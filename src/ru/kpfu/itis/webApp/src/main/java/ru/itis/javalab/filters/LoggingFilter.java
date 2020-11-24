package ru.itis.javalab.filters;


import javafx.scene.shape.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoggingFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(LoggingFilter.class);
    private static final String FILENAME = "D:\\Repository\\JavaLab\\JavaLabShandrenkoRepository\\src\\ru\\kpfu\\itis\\webApp\\src\\main\\java\\ru\\itis\\javalab\\filters\\log.txt";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        logger.info(String.valueOf(request.getRequestURL()));
        logger.debug("Message for debug level.");
        try {
            Files.readAllBytes(Paths.get(FILENAME));
        } catch (IOException e) {
            logger.error("Failed to read file {}.", FILENAME, e);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
