package com.amazonaws;

import com.amazonaws.http.HttpResponse;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Response<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f15652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HttpResponse f15653b;

    public Response(T t11, HttpResponse httpResponse) {
        this.f15652a = t11;
        this.f15653b = httpResponse;
    }

    public T a() {
        return this.f15652a;
    }
}
