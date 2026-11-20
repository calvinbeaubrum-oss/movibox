package com.mbridge.msdk.e.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class r<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f43843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.mbridge.msdk.e.a.b.a f43844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f43845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f43846d;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(z zVar);
    }

    /* JADX INFO: compiled from: source.java */
    public interface b<T> {
        void a(T t11);
    }

    private r(z zVar) {
        this.f43846d = false;
        this.f43843a = null;
        this.f43844b = null;
        this.f43845c = zVar;
    }

    private r(T t11, com.mbridge.msdk.e.a.b.a aVar) {
        this.f43846d = false;
        this.f43843a = t11;
        this.f43844b = aVar;
        this.f43845c = null;
    }

    public static <T> r<T> a(z zVar) {
        return new r<>(zVar);
    }

    public static <T> r<T> a(T t11, com.mbridge.msdk.e.a.b.a aVar) {
        return new r<>(t11, aVar);
    }

    public final boolean a() {
        return this.f43845c == null;
    }
}
