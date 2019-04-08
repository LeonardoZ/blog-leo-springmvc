package com.leonardoz.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.leonardoz.blog.binders.CategoriaToString;
import com.leonardoz.blog.binders.StringToCategoria;
import com.leonardoz.blog.binders.formatters.DateFormat;
import com.leonardoz.blog.security.LoginHandler;

// eq to mvc-config.xml
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.leonardoz.blog", "com.leonardoz.blog.controller" })
public class WebConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private StringToCategoria stringToCategoria;
	
	@Autowired
	private CategoriaToString categoriaToString;
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		 registry
		 .addResourceHandler("/resources/**")
         .addResourceLocations("/resources/"); 
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(stringToCategoria);
		registry.addConverter(categoriaToString);
		registry.addFormatter(new DateFormat());
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/tiles/tiles-config.xml" });
		tilesConfigurer.setCheckRefresh(true);

		return tilesConfigurer;
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		TilesViewResolver viewResolver = new TilesViewResolver();
		registry.viewResolver(viewResolver);
	}


	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginHandler()).addPathPatterns("/cp/**");
	}

}
