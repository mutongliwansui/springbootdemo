package com.open.micro.service.config;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.LocaleResolver;

import com.google.common.base.Strings;

public class RequestLocaleResolver implements LocaleResolver {

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String lang = request.getParameter("lang");
		if ( Strings.isNullOrEmpty(lang) ) {
			return Locale.SIMPLIFIED_CHINESE;
		}
		
		return new Locale(lang);
	}
	
	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
//		throw new IllegalStateException("not implemented");
	}

}
