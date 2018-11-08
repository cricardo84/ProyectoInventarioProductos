package com.pe.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class MiFiltro
 */
@WebFilter("/MiFiltro")
public class MiFiltro implements Filter {

    public MiFiltro() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpSession sesion = ((HttpServletRequest)request).getSession();
			
		if(sesion.getAttribute("usuario")!=null && sesion.getAttribute("contraseña")!=null) {
			chain.doFilter(request, response);
		}else {
			((HttpServletResponse)response).sendRedirect("/ServletExample/validarUsuario.jsp");
		}
		
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
