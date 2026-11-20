package com.transsion.http.impl;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bitmap f52832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ b f52833b;

    public a(b bVar, Bitmap bitmap) {
        this.f52833b = bVar;
        this.f52832a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVar = this.f52833b;
        bVar.f52836c.F(bVar.f52835b, this.f52832a);
    }
}
