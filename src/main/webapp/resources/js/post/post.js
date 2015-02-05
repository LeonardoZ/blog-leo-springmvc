/**
 * Funções que cuidam das funcionalidades dos POSTs;
 */
$(function() {

	function Categoria(id, text) {
		this.id = id;
		this.descricao = text;
		this.label = text;
	}

	function getCategorias() {
		var cs = [];
		$.ajax({
			async : false,
			url : "/blog-leo/cp/categoria/listar.do",
			success : function(data) {
				cs = jsonListToCategoria(data);
			}
		});
		return cs;
	}

	function getCategoriasPorDescricao() {
		var descricao = $("#categoria-input").val();
		var categorias = [];

		$.ajax({
			async : false,
			url : "/blog-leo/cp/categoria/listar/contendo?desc=" + descricao,
			success : function(data) {
				categorias = jsonListToCategoria(data);
			}
		});

		return categorias;
	}

	function jsonListToCategoria(jsonList) {
		var categorias = [];
		for (var i = 0; i < jsonList.length; i++) {
			var json = jsonList[i];
			var categoria = new Categoria(json.id, json.descricao);
			categorias.push(categoria);
		}
		return categorias;
	}

	function categoriaInputSelected(event, ui) {

		criarLabelCategoria(new Categoria(ui.item.id, ui.item.descricao));

		return false;
	}

	function criarLabelCategoria(categoria) {
		var $divFinal;
		var $categoriasSelecionadas = $("#categorias-selecionadas");
		var $containerHtml = $("<div />").addClass("categorias-container");

		var $itemHtml = $("<span />").addClass("label label-default categoria")
				.text(categoria.descricao).append(
						$("<label />").addClass("glyphicon glyphicon-remove")
								.addClass("categoria-remove"));

		$("#categoria-input").val("");

		var $checkboxHtml = $("<input />").attr("type", "checkbox").attr("id",
				"categorias" + categoria.id).attr("checked", "checked").attr(
				"name", "categorias").addClass("invisivel").val(categoria.id);

		var containerSize = $("#categorias-selecionadas div").size();
		if (naoContemCheckbox($checkboxHtml)) {

			if (containerSize === 0) {
				$categoriasSelecionadas.append($containerHtml);
				$("#nenhuma-categoria").remove();
				$divFinal = $containerHtml;
			} else {
				var $lastDiv = $("#categorias-selecionadas div").last();
				var divSize = $lastDiv.children().size();
				if (divSize === 9) {
					$categoriasSelecionadas.append($containerHtml);
					$divFinal = $("#categorias-selecionadas div").last();
				} else {
					$divFinal = $("#categorias-selecionadas div").last();
				}
			}
			$divFinal.append($itemHtml);
			$("#categorias-hidden").append($checkboxHtml);
		}

	}

	function configurarEfeitosDasCategorias() {
		$(".categoria").mouseover(function() {
			$(this).toggleClass("label-default", false);
			$(this).toggleClass("label-danger", true);
		});
		$(".categoria").mouseout(function() {
			$(this).toggleClass("label-danger", false);
			$(this).toggleClass("label-default", true);
		});

		$(".categoria label").click(function() {
			var index = $(this).parent().index();
			$("#categorias-hidden").children()[index].remove();
			$(this).parent().remove();
		});
	}

	function naoContemCheckbox($checkboxHtml) {
		return !$("#categorias-hidden").has("#" + $checkboxHtml.attr("id")).length;
	}

	function carregarCategoriasDoPost() {
		var postId = $("#id").val();
		if (postId) {
			var cats = [];
			$.getJSON("categorias?id=" + postId).done(function(data) {
				cats = jsonListToCategoria(data);
				adicionarCategorias(cats);
			});
		}
	}

	function adicionarCategorias(categorias) {
		$.each(categorias, function(i, categoria) {
			criarLabelCategoria(categoria);
		});
	}

	function configurarAutocomplete() {
		$("#categoria-input").autocomplete({
			minLength : 3,
			source : getCategoriasPorDescricao(),
			select : categoriaInputSelected
		});
	}

	function criarLabelCategoriaNaoEncontrada() {
		$("#btn-categoria").click(function() {
			var input = $("#categoria-input").val();
			if (input) {
				criarLabelCategoriaAjax(input);
			}
		});
	}

	function criarLabelCategoriaAjax(descricao) {
		$.post("/blog-leo/cp/categoria/criar.do", {
			"descricao" : descricao
		}).done(function(data) {
			var categoria = new Categoria(data.id, data.descricao);
			criarLabelCategoria(categoria);
		});
	}

	carregarCategoriasDoPost();
	configurarAutocomplete();
	configurarEfeitosDasCategorias();
	criarLabelCategoriaNaoEncontrada();
	$('#conteudo').editable({
		inlineMode : false
	});
});