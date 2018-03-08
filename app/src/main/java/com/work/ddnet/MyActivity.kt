package com.work.ddnet

import android.os.Bundle
import android.os.PersistableBundle
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.work.base.ext.execute

import com.work.ddnet.rx.RxRestClient

import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Ting on 2018/1/5.
 */

class MyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        val time0 = SystemClock.currentThreadTimeMillis()
        Log.e("time", time0.toString())
        RxRestClient.builder()
                .url("http://news.baidu.com/")
                .build()
                .get()
                .execute(object : Observer<String> {
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onError(e: Throwable) {
                    }

                    override fun onComplete() {
                    }

                    override fun onNext(t: String) {
                        Log.e("main","网络请求成功")
                    }
                })
    }
}
