package com.work.base.ext

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Ting on 2018/1/23.
 */

fun <T> Observable<T>.execute(observer: Observer<T>) {
    this.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(observer)
}