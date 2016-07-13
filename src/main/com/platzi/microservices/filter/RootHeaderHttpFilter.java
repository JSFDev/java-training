package main.com.platzi.microservices.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(
        urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "state-root-webfilter", value = "filtered")
        }
)
public class RootHeaderHttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setAttribute("state-root-dofilter", "filtered");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
