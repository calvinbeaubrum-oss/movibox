package com.amazonaws;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class AmazonWebServiceResponse<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f15615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ResponseMetadata f15616b;

    public String a() {
        ResponseMetadata responseMetadata = this.f15616b;
        if (responseMetadata == null) {
            return null;
        }
        return responseMetadata.a();
    }

    public T b() {
        return this.f15615a;
    }

    public void c(ResponseMetadata responseMetadata) {
        this.f15616b = responseMetadata;
    }

    public void d(T t11) {
        this.f15615a = t11;
    }
}
