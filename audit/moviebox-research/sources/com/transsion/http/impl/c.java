package com.transsion.http.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f52837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Throwable f52838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BitmapCallback f52839c;

    public c(BitmapCallback bitmapCallback, int i11, Throwable th2) {
        this.f52839c = bitmapCallback;
        this.f52837a = i11;
        this.f52838b = th2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f52839c.E(this.f52837a, null, this.f52838b);
    }
}
