package com.transsion.http.impl;

import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnsupportedEncodingException f52867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ o f52868b;

    public n(o oVar, UnsupportedEncodingException unsupportedEncodingException) {
        this.f52868b = oVar;
        this.f52867a = unsupportedEncodingException;
    }

    @Override // java.lang.Runnable
    public void run() {
        o oVar = this.f52868b;
        oVar.f52872d.D(oVar.f52870b, null, this.f52867a.getCause());
    }
}
