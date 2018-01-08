package com.work.ddnet;

/**
 * @author Ting
 * @date 2017/11/10
 */

public interface I {
    interface Configkey {
        String CONFIG_READY = "CONFIG_READY";
        String APPLICATION_CONTEXT = "APPLICATION_CONTEXT";
        String API_HOST = "API_HOST";
        String LOADER_DELAYED = "LOADER_DELAYED";
        String HANDLER = "HANDLER";
        String INTERCEPTOR = "INTERCEPTOR";
    }

    interface HttpMethod {
        String GET = "GET";
        String POST = "POST";
        String POST_RAW = "POST_RAW";
        String PUT = "PUT";
        String PUT_RAW = "PUT_RAW";
        String DELETE = "DELETE";
        String UPLOAD = "UPLOAD";
    }

    interface BaseUrl {
        String URL = "http://news.baidu.com/";
    }
}
