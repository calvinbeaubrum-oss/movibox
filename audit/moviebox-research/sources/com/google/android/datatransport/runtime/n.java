package com.google.android.datatransport.runtime;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class n {

    /* JADX INFO: compiled from: source.java */
    public static abstract class a {
        public abstract n a();

        public abstract a b(cg.c cVar);

        public abstract a c(cg.d<?> dVar);

        public abstract a d(cg.f<?, byte[]> fVar);

        public abstract a e(o oVar);

        public abstract a f(String str);
    }

    public static a a() {
        return new c.b();
    }

    public abstract cg.c b();

    public abstract cg.d<?> c();

    public byte[] d() {
        return e().apply(c().b());
    }

    public abstract cg.f<?, byte[]> e();

    public abstract o f();

    public abstract String g();
}
