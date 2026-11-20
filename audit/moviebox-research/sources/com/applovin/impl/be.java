package com.applovin.impl;

import android.os.Handler;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface be {

    /* JADX INFO: compiled from: source.java */
    public static final class a extends yd {
        public a(yd ydVar) {
            super(ydVar);
        }

        public a(Object obj) {
            super(obj);
        }

        public a(Object obj, int i11, int i12, long j11) {
            super(obj, i11, i12, j11);
        }

        public a(Object obj, long j11, int i11) {
            super(obj, j11, i11);
        }

        public a b(Object obj) {
            return new a(super.a(obj));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(be beVar, fo foVar);
    }

    td a();

    wd a(a aVar, n0 n0Var, long j11);

    void a(Handler handler, a7 a7Var);

    void a(Handler handler, ce ceVar);

    void a(a7 a7Var);

    void a(b bVar);

    void a(b bVar, xo xoVar);

    void a(ce ceVar);

    void a(wd wdVar);

    void b();

    void b(b bVar);

    void c(b bVar);

    boolean c();

    fo d();
}
