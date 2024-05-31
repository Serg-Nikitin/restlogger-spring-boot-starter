package ru.nikitin.restlogger.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import ru.nikitin.restlogger.api.Helper;

import java.io.IOException;

public abstract class CommonHttpFilter extends OncePerRequestFilter {

    private Helper helper;

    public CommonHttpFilter(Helper helper) {
        this.helper = helper;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var requestWrapper = requestWrapper(request);
        var responseWrapper = responseWrapper(response);
        before(requestWrapper, responseWrapper);
        super.doFilter(requestWrapper, responseWrapper, filterChain);
        after(requestWrapper, responseWrapper);
        responseWrapper.copyBodyToResponse();
    }

    protected abstract void before(ContentCachingRequestWrapper requestWrapper, ContentCachingResponseWrapper responseWrapper);

    protected abstract void after(ContentCachingRequestWrapper requestWrapper, ContentCachingResponseWrapper responseWrapper);

    private ContentCachingRequestWrapper requestWrapper(HttpServletRequest request) {
        if (request instanceof ContentCachingRequestWrapper requestWrapper) {
            return requestWrapper;
        }
        return new ContentCachingRequestWrapper(request);
    }

    private ContentCachingResponseWrapper responseWrapper(HttpServletResponse response) {
        if (response instanceof ContentCachingResponseWrapper responseWrapper) {
            return responseWrapper;
        }
        return new ContentCachingResponseWrapper(response);
    }
}
