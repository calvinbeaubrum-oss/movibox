package com.transsion.http.impl;

import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnsupportedEncodingException f52860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ l f52861b;

    public k(l lVar, UnsupportedEncodingException unsupportedEncodingException) {
        this.f52861b = lVar;
        this.f52860a = unsupportedEncodingException;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar = this.f52861b;
        lVar.f52864c.D(lVar.f52863b, null, this.f52860a.getCause());
    }
}
