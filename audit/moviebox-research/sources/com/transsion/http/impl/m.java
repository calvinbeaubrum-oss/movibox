package com.transsion.http.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f52865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ o f52866b;

    public m(o oVar, String str) {
        this.f52866b = oVar;
        this.f52865a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        o oVar = this.f52866b;
        oVar.f52872d.D(oVar.f52870b, this.f52865a, oVar.f52871c);
    }
}
