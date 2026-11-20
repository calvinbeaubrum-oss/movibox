package com.mbridge.msdk.foundation.same.net;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class k<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.mbridge.msdk.foundation.same.net.b.a f44689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.mbridge.msdk.foundation.same.net.f.c f44690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f44691c;

    private k(com.mbridge.msdk.foundation.same.net.b.a aVar) {
        this.f44690b = null;
        this.f44691c = null;
        this.f44689a = aVar;
    }

    private k(T t11, com.mbridge.msdk.foundation.same.net.f.c cVar) {
        this.f44689a = null;
        this.f44691c = t11;
        this.f44690b = cVar;
    }

    public static <T> k<T> a(com.mbridge.msdk.foundation.same.net.b.a aVar) {
        return new k<>(aVar);
    }

    public static <T> k<T> a(T t11, com.mbridge.msdk.foundation.same.net.f.c cVar) {
        return new k<>(t11, cVar);
    }
}
