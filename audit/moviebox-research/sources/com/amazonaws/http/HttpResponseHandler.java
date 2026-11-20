package com.amazonaws.http;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface HttpResponseHandler<T> {
    T a(HttpResponse httpResponse) throws Exception;

    boolean b();
}
