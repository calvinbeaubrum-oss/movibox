package com.google.android.datatransport.runtime;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k implements gg.b<Executor> {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f32647a = new k();
    }

    public static k a() {
        return a.f32647a;
    }

    public static Executor b() {
        return (Executor) gg.d.d(j.a());
    }

    @Override // u10.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Executor get() {
        return b();
    }
}
