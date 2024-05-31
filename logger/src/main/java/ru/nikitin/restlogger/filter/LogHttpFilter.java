package ru.nikitin.restlogger.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import ru.nikitin.restlogger.service.LogService;

@Slf4j
@Order(1)
@Component
public class LogHttpFilter extends CommonHttpFilter {

    @Autowired
    LogService logger;

    public LogHttpFilter(LogService logger) {
        super(logger);
    }

    @Override
    protected void before(ContentCachingRequestWrapper requestWrapper, ContentCachingResponseWrapper responseWrapper) {

    }

    @Override
    protected void after(ContentCachingRequestWrapper requestWrapper, ContentCachingResponseWrapper responseWrapper) {
        logger.toServ(requestWrapper);
        logger.toServ(responseWrapper);
    }
}