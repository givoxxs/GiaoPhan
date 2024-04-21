package hitoan.me.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

//@WebFilter(urlPatterns = {"/*"}, initParams = {
//		@WebInitParam(name = "count", value = "100")})
public class CounterFilter implements Filter{
	// counter
	private int count;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		count++;
		// handle request
		System.out.println("Counter: " + count);
		// pass the request
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		// get init parameter
		String counter = filterConfig.getInitParameter("count");
		// convert to integer
		count = Integer.valueOf(counter);
	}
}
