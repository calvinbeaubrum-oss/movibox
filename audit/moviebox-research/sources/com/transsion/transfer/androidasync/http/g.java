package com.transsion.transfer.androidasync.http;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface g {

    /* JADX INFO: compiled from: source.java */
    public static class a extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public fy.b f58660c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public com.transsion.transfer.androidasync.future.a f58661d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f58662e;
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public com.transsion.transfer.androidasync.r f58663j;
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public com.transsion.transfer.androidasync.l f58664f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public i f58665g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public fy.a f58666h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public fy.a f58667i;
    }

    /* JADX INFO: compiled from: source.java */
    public static class d extends f {
    }

    /* JADX INFO: compiled from: source.java */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.transsion.transfer.androidasync.util.f f58668a = new com.transsion.transfer.androidasync.util.f();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public j f58669b;
    }

    /* JADX INFO: compiled from: source.java */
    public static class f extends c {
    }

    /* JADX INFO: renamed from: com.transsion.transfer.androidasync.http.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0599g extends h {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Exception f58670k;
    }

    /* JADX INFO: compiled from: source.java */
    public static class h extends b {
    }

    /* JADX INFO: compiled from: source.java */
    public interface i {
        com.transsion.transfer.androidasync.u F();

        int b();

        i d(int i11);

        Headers g();

        i h(com.transsion.transfer.androidasync.u uVar);

        i l(String str);

        i n(com.transsion.transfer.androidasync.r rVar);

        String protocol();

        i r(String str);

        com.transsion.transfer.androidasync.l socket();

        i v(Headers headers);
    }

    void a(e eVar);

    void b(C0599g c0599g);

    void c(f fVar);

    void d(b bVar);

    com.transsion.transfer.androidasync.future.a e(a aVar);

    boolean f(c cVar);

    void g(d dVar);

    j h(h hVar);
}
