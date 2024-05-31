package ru.nikitin.restlogger.api;

import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

public interface Helper {

    void toServ(ContentCachingRequestWrapper requestCache);

    void toServ(ContentCachingResponseWrapper responseCache);
}
