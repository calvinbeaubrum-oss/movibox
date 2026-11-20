package com.transsion.http.impl;

import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f52862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f52863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StringCallback f52864c;

    public l(StringCallback stringCallback, byte[] bArr, int i11) {
        this.f52864c = stringCallback;
        this.f52862a = bArr;
        this.f52863b = i11;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f52864c.j(new j(this, StringCallback.C(this.f52862a, "UTF-8")));
        } catch (UnsupportedEncodingException e11) {
            this.f52864c.j(new k(this, e11));
        }
    }
}
