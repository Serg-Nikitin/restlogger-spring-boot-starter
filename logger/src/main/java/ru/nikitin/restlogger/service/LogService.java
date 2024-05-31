package ru.nikitin.restlogger.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import ru.nikitin.restlogger.api.Helper;

import java.util.Collection;
import java.util.Collections;
import java.util.function.Function;

@Slf4j
@Service
public class LogService implements Helper {

    public void toServ(ContentCachingResponseWrapper responseCache) {
        log.trace("service responseCache = {}", responseCache);
        StringBuilder builder = new StringBuilder();
        this.prepareHeaders(builder, responseCache.getHeaderNames(), responseCache::getHeader);
        String responseBody = new String(responseCache.getContentAsByteArray());
        builder.append(responseBody);

        log.info("\n Response: status = {},\n  body = {}"
                , responseCache.getStatus(), responseBody);
        log.debug("\n Response = {}", builder);
    }

    public void toServ(ContentCachingRequestWrapper requestCache) {
        log.trace("service requestCache = {}", requestCache);
        StringBuilder builder = new StringBuilder();
        this.prepareHeaders(builder, Collections.list(requestCache.getHeaderNames()), requestCache::getHeader);
        String requestBody = new String(requestCache.getContentAsByteArray());
        builder.append(requestBody);

        log.info("\n Request: url = {},\n method = {},\n  body = {}"
                , requestCache.getRequestURL(), requestCache.getMethod(), requestBody);
        log.debug("\n Request = {}", builder);
    }

    private String prepareHeaders(StringBuilder builder, Collection<String> headerNames, Function<String, String> headerValueResolver) {
        for (String headerName : headerNames) {
            String header = headerValueResolver.apply(headerName);
            builder.append("%s=%s".formatted(headerName, header)).append("\n");
        }
        return builder.toString();
    }
}
