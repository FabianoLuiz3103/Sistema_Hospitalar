package br.com.fiap.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/*")
public class FiltroPaginas extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;


    public FiltroPaginas() {
        super();
      
    }

	public void destroy() {

	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		    String url = httpServletRequest.getRequestURI();
		    HttpSession session = httpServletRequest.getSession();
		    
		    if (url.endsWith("favicon.ico")) {
		        chain.doFilter(request, response);
		        return;
		    }
		    
		    if (url.endsWith("favicon.ico")) {
		        chain.doFilter(request, response);
		        return;
		    }

		    if (session.getAttribute("pacienteAutenticado") != null && url.startsWith("/Sistema_Hospitalar_GS/paciente") ||
		    		url.endsWith("login-paciente.jsp") ||
		    		url.endsWith("home.jsp") ||
		    	    url.endsWith("paciente") || 
		    	    url.endsWith("login") || 
		    	    url.endsWith(".css") ||  
		    	    url.endsWith(".js") ||
		    	    url.endsWith(".png") ||
		    	    url.endsWith(".jpg") ||
		    	    url.endsWith("graficos")||
		    	    url.endsWith("GraficosPac.jsp")
		    	   ) {
		        
		        chain.doFilter(request, response);
		    } else if (session.getAttribute("medicoAutenticado") != null && url.startsWith("/Sistema_Hospitalar_GS/medico")||
		    		url.endsWith("login-medico.jsp") ||
		    		url.endsWith("home.jsp") ||
		    	    url.endsWith("paciente") || 
		    	    url.endsWith("login") || 
		    	    url.endsWith(".css") ||  
		    	    url.endsWith(".js") ||
		    	    url.endsWith(".png") ||
		    	    url.endsWith(".jpg") ||
		    	    url.endsWith("graficos")||
		    	    url.endsWith("GraficosMed.jsp")
		    	   ) {
		        chain.doFilter(request, response);
		    } else {
		        ((HttpServletResponse) response).sendRedirect("/Sistema_Hospitalar_GS/home.jsp");
		    }

		    

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
