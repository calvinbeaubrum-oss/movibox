package com.amazonaws.services.s3.model;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MultipartUploadListing {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f16041d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f16042e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f16043f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f16044g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f16045h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f16046i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f16047j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<MultipartUpload> f16048k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<String> f16049l = new ArrayList();

    public List<String> a() {
        return this.f16049l;
    }

    public List<MultipartUpload> b() {
        if (this.f16048k == null) {
            this.f16048k = new ArrayList();
        }
        return this.f16048k;
    }

    public void c(String str) {
        this.f16038a = str;
    }

    public void d(String str) {
        this.f16040c = str;
    }

    public void e(String str) {
        this.f16044g = str;
    }

    public void f(String str) {
        this.f16039b = str;
    }

    public void g(int i11) {
        this.f16043f = i11;
    }

    public void h(String str) {
        this.f16046i = str;
    }

    public void i(String str) {
        this.f16047j = str;
    }

    public void j(String str) {
        this.f16041d = str;
    }

    public void k(boolean z11) {
        this.f16045h = z11;
    }

    public void l(String str) {
        this.f16042e = str;
    }
}
