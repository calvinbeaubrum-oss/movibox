package com.amazonaws.services.s3.model;

import java.util.Date;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MultipartUpload {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Owner f16034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Owner f16035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f16036e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Date f16037f;

    public void a(Date date) {
        this.f16037f = date;
    }

    public void b(Owner owner) {
        this.f16035d = owner;
    }

    public void c(String str) {
        this.f16032a = str;
    }

    public void d(Owner owner) {
        this.f16034c = owner;
    }

    public void e(String str) {
        this.f16036e = str;
    }

    public void f(String str) {
        this.f16033b = str;
    }
}
