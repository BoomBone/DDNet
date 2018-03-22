# kotlin网络请求
简单使用方法示例
```
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
                        toast("网络请求成功")
                    }
                })
```