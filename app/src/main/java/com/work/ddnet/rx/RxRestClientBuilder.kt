package com.work.ddnet.rx


import java.io.File
import java.util.WeakHashMap

import okhttp3.MediaType
import okhttp3.RequestBody

/**
 * @author Ting
 * @date 2017/11/17
 */

class RxRestClientBuilder {
    private var mUrl: String = ""
    private var mBody: RequestBody? = null
    private var mFile: File? = null


    fun url(url: String): RxRestClientBuilder {
        this.mUrl = url
        return this
    }

    fun params(params: WeakHashMap<String, Any>): RxRestClientBuilder {
        PARAMS.putAll(params)
        return this
    }

    fun params(key: String, value: Any): RxRestClientBuilder {
        PARAMS.put(key, value)
        return this
    }

    fun raw(raw: String): RxRestClientBuilder {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw)
        return this
    }

    fun file(file: File): RxRestClientBuilder {
        this.mFile = file
        return this
    }

    fun file(file: String): RxRestClientBuilder {
        this.mFile = File(file)
        return this
    }

    fun build(): RxRestClient {
        return RxRestClient(mUrl, PARAMS, mBody, mFile)
    }

    companion object {
        private val PARAMS = RestCreator.getParam()
    }
}
