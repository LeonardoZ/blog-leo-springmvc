package com.leonardoz.blog.test;

import org.junit.Assert;
import org.junit.Test;

import com.leonardoz.blog.dao.Paginacao;


public class PaginacaoTest {

	Paginacao paginacao = new Paginacao();
	
	@Test
	public void paginarTest() {
		int res = paginacao.paginar(5, 5, 1);
		Assert.assertEquals(4, res);
	}
	
}
