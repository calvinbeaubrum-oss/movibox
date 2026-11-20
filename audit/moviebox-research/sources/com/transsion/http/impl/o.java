package com.transsion.http.impl;

import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f52869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f52870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Throwable f52871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ StringCallback f52872d;

    public o(StringCallback stringCallback, byte[] bArr, int i11, Throwable th2) {
        this.f52872d = stringCallback;
        this.f52869a = bArr;
        this.f52870b = i11;
        this.f52871c = th2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f52872d.j(new m(this, StringCallback.C(this.f52869a, "UTF-8")));
        } catch (UnsupportedEncodingException e11) {
            this.f52872d.j(new n(this, e11));
        }
    }
}
