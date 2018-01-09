package com.work.ddnet.rx


import java.io.File
import java.util.WeakHashMap

import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody

/**
 * @author Ting
 * @date 2017/11/15
 */

class RxRestClient(private val URL: String,
                   params: WeakHashMap<String, Any>,
                   private val BODY: RequestBody?,
                   private val FILE: File?) {
    private val SERVICE = RestCreator.getRxService()

    init {
        PARAMS.putAll(params)
    }


    fun get(): Observable<String> {
        return if (PARAMS.size == 0) {
            SERVICE.get(URL)
        } else {
            SERVICE.get(URL, PARAMS)
        }
    }

    fun post(): Observable<String> {
        return if (BODY == null) {
            SERVICE.post(URL, PARAMS)
        } else {
            if (!PARAMS.isEmpty()) {
                throw RuntimeException("params must be null!")
            } else {
                SERVICE.putRaw(URL, BODY)
            }
        }
    }

    fun put(): Observable<String> {
        return if (BODY == null) {
            SERVICE.put(URL, PARAMS)
        } else {
            if (!PARAMS.isEmpty()) {
                throw RuntimeException("params must be null!")
            } else {
                SERVICE.putRaw(URL, BODY)
            }
        }
    }

    fun delete(): Observable<String> {
        return SERVICE.delete(URL, PARAMS)
    }

    fun upload(): Observable<String> {

        val requestBody = RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()), FILE)
        val body = MultipartBody.Part.createFormData("file", FILE?.name, requestBody)
        return SERVICE.upload(URL, body)
    }

    fun download(): Observable<ResponseBody> {
        return RestCreator.getRxService().download(URL, PARAMS)
    }

    companion object {
        private val PARAMS = RestCreator.getParam()

        fun builder(): RxRestClientBuilder {
            return RxRestClientBuilder()
        }
    }
}
