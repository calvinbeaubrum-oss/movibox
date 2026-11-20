package com.transsion.http.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f52834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f52835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BitmapCallback f52836c;

    public b(BitmapCallback bitmapCallback, byte[] bArr, int i11) {
        this.f52836c = bitmapCallback;
        this.f52834a = bArr;
        this.f52835b = i11;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f52836c.j(new a(this, this.f52836c.D(this.f52834a)));
    }
}
