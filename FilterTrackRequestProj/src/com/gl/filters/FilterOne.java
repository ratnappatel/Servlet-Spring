package com.gl.filters;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class FilterOne
 */
@WebFilter("/FilterOne")
public class FilterOne implements Filter {

    /**
     * Default constructor. 
     */
	FileOutputStream fis;
    public FilterOne() {
        try {
			fis=new FileOutputStream("d:\\ServerLog.txt");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String localIP=request.getLocalAddr();
		String server=request.getServerName();
		Date date=new Date();
		String log=localIP+" has sent request on "+server+" at : "+date;
		fis.write(log.getBytes());
		System.out.println("A Filter has retrieved a metadat of request as below:\n"+log);
		chain.doFilter(request, response);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
