package com.work.ddnet

/**
 * @author Ting
 * @date 2017/11/10
 */

interface I {
    interface Configkey {
        companion object {
            val CONFIG_READY = "CONFIG_READY"
            val APPLICATION_CONTEXT = "APPLICATION_CONTEXT"
            val API_HOST = "API_HOST"
            val LOADER_DELAYED = "LOADER_DELAYED"
            val HANDLER = "HANDLER"
            val INTERCEPTOR = "INTERCEPTOR"
        }
    }

    interface HttpMethod {
        companion object {
            val GET = "GET"
            val POST = "POST"
            val POST_RAW = "POST_RAW"
            val PUT = "PUT"
            val PUT_RAW = "PUT_RAW"
            val DELETE = "DELETE"
            val UPLOAD = "UPLOAD"
        }
    }

    interface BaseUrl {
        companion object {
            val URL = "http://news.baidu.com/"
        }
    }
}
