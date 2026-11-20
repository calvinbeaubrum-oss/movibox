package com.google.firebase.crashlytics.internal.common;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f40238a = new AtomicInteger();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f40239b = new AtomicInteger();

    public void a() {
        this.f40239b.getAndIncrement();
    }

    public void b() {
        this.f40238a.getAndIncrement();
    }

    public void c() {
        this.f40239b.set(0);
    }
}
