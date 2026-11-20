package com.transsion.http.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f52858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ l f52859b;

    public j(l lVar, String str) {
        this.f52859b = lVar;
        this.f52858a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar = this.f52859b;
        lVar.f52864c.E(lVar.f52863b, this.f52858a);
    }
}
