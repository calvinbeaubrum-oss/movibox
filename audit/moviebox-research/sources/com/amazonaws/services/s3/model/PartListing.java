package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class PartListing implements S3RequesterChargedResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f16056d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f16057f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f16058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Owner f16059h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Owner f16060i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f16061j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f16062k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f16063l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<PartSummary> f16064m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f16065n;

    public List<PartSummary> a() {
        if (this.f16064m == null) {
            this.f16064m = new ArrayList();
        }
        return this.f16064m;
    }

    public void b(String str) {
        this.f16053a = str;
    }

    public void c(String str) {
        this.f16058g = str;
    }

    public void d(Owner owner) {
        this.f16060i = owner;
    }

    public void e(String str) {
        this.f16054b = str;
    }

    public void f(int i11) {
        this.f16056d = Integer.valueOf(i11);
    }

    public void g(int i11) {
        this.f16063l = Integer.valueOf(i11);
    }

    public void h(Owner owner) {
        this.f16059h = owner;
    }

    public void i(int i11) {
        this.f16057f = Integer.valueOf(i11);
    }

    public void j(String str) {
        this.f16061j = str;
    }

    public void k(boolean z11) {
        this.f16062k = z11;
    }

    public void l(String str) {
        this.f16055c = str;
    }

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public void setRequesterCharged(boolean z11) {
        this.f16065n = z11;
    }
}
