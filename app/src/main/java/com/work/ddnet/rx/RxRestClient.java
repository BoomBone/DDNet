package com.work.ddnet.rx;

import android.content.Context;


import com.work.ddnet.I;

import java.io.File;
import java.util.WeakHashMap;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * @author Ting
 * @date 2017/11/15
 */

public class RxRestClient {
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final String URL;
    private final RequestBody BODY;
    private final File FILE;
    private final RxRestService SERVICE = RestCreator.getRxRestService();

    public RxRestClient(String url,
                        WeakHashMap<String, Object> params,
                        RequestBody body,
                        File file) {
        PARAMS.putAll(params);
        this.URL = url;
        this.BODY = body;
        this.FILE = file;
    }

    public static RxRestClientBuilder builder() {
        return new RxRestClientBuilder();
    }


    public final Observable<String> get() {
        if (PARAMS.size()==0){
            Observable<String> observable = SERVICE.get(URL);
            return observable;
        }else{
            Observable<String> observable = SERVICE.get(URL, PARAMS);
            return observable;
        }
    }

    public final Observable<String> post() {
        if (BODY == null) {
            Observable<String> observable = SERVICE.post(URL, PARAMS);
            return observable;
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null!");
            }else{
                Observable<String> observable = SERVICE.putRaw(URL, BODY);
                return observable;
            }
        }
    }

    public final Observable<String> put() {
        if (BODY == null) {
            Observable<String> observable = SERVICE.put(URL, PARAMS);;
            return observable;
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null!");
            }else{
                Observable<String> observable = SERVICE.putRaw(URL, BODY);
                return observable;
            }
        }
    }

    public final Observable<String> delete() {
        Observable<String> observable = SERVICE.delete(URL, PARAMS);
        return observable;
    }

    public final Observable<String> upload() {
        final RequestBody requestBody =
                RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()), FILE);
        final MultipartBody.Part body =
                MultipartBody.Part.createFormData("file", FILE.getName(), requestBody);
        Observable<String> observable = SERVICE.upload(URL, body);
        return observable;
    }

    public final Observable<ResponseBody> download() {
        final Observable<ResponseBody> observable = RestCreator.getRxRestService().download(URL, PARAMS);
        return observable;
    }
}
