package com.applovin.impl;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface z6 {

    /* JADX INFO: compiled from: source.java */
    public static class a extends IOException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f24814a;

        public a(Throwable th2, int i11) {
            super(th2);
            this.f24814a = i11;
        }
    }

    void a(a7.a aVar);

    boolean a(String str);

    int b();

    void b(a7.a aVar);

    boolean c();

    Map d();

    UUID e();

    z4 f();

    a getError();
}
