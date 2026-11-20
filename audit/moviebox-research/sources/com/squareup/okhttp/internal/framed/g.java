package com.squareup.okhttp.internal.framed;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CountDownLatch f49198a = new CountDownLatch(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f49199b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f49200c = -1;

    public void a() {
        if (this.f49200c == -1) {
            long j11 = this.f49199b;
            if (j11 != -1) {
                this.f49200c = j11 - 1;
                this.f49198a.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }

    public void b() {
        if (this.f49200c != -1 || this.f49199b == -1) {
            throw new IllegalStateException();
        }
        this.f49200c = System.nanoTime();
        this.f49198a.countDown();
    }

    public void c() {
        if (this.f49199b != -1) {
            throw new IllegalStateException();
        }
        this.f49199b = System.nanoTime();
    }
}
