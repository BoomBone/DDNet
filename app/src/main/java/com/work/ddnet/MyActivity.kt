package com.work.ddnet

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast

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
        RxRestClient.builder()
                .url("http://news.baidu.com/")
                .build()
                .get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<String> {
                    override fun onSubscribe(@NonNull d: Disposable) {

                    }

                    override fun onNext(@NonNull s: String) {
                        Toast.makeText(this@MyActivity, s, Toast.LENGTH_SHORT).show()
                    }

                    override fun onError(@NonNull e: Throwable) {

                    }

                    override fun onComplete() {

                    }
                })
    }
}
