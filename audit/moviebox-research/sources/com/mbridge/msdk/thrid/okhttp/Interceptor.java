package com.mbridge.msdk.thrid.okhttp;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface Interceptor {

    /* JADX INFO: compiled from: source.java */
    public interface Chain {
        Call call();

        int connectTimeoutMillis();

        Connection connection();

        Response proceed(Request request) throws IOException;

        int readTimeoutMillis();

        Request request();

        Chain withConnectTimeout(int i11, TimeUnit timeUnit);

        Chain withReadTimeout(int i11, TimeUnit timeUnit);

        Chain withWriteTimeout(int i11, TimeUnit timeUnit);

        int writeTimeoutMillis();
    }

    Response intercept(Chain chain) throws IOException;
}
