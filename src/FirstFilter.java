import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("First Filter: Init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("First Filter: doFilter");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String name = httpServletRequest.getParameter("name");
        httpServletRequest.setAttribute("test", "123");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("First Filter: destroy");
    }
}
