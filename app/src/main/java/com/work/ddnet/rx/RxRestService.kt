package com.work.ddnet.rx

import java.util.WeakHashMap

import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.QueryMap
import retrofit2.http.Streaming
import retrofit2.http.Url

/**
 * @author Ting
 * @date 2017/11/15
 */

interface RxRestService {
    @GET
    operator fun get(@Url url: String, @QueryMap params: Map<String, Any>): Observable<String>

    @GET
    operator fun get(@Url url: String): Observable<String>

    @FormUrlEncoded
    @POST
    fun post(@Url url: String, @FieldMap params: WeakHashMap<String, Any>): Observable<String>

    @POST
    fun postRaw(@Url url: String, @Body body: RequestBody): Observable<String>

    @FormUrlEncoded
    @PUT
    fun put(@Url url: String, @FieldMap params: WeakHashMap<String, Any>): Observable<String>

    @PUT
    fun putRaw(@Url url: String, @Body body: RequestBody): Observable<String>

    @DELETE
    fun delete(@Url url: String, @QueryMap params: WeakHashMap<String, Any>): Observable<String>

    @Streaming
    @GET
    fun download(@Url url: String, @QueryMap params: WeakHashMap<String, Any>): Observable<ResponseBody>

    @Multipart
    @POST
    fun upload(@Url url: String, @Part file: MultipartBody.Part): Observable<String>
}
