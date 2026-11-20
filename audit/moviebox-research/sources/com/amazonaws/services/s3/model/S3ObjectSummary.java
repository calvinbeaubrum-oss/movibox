package com.amazonaws.services.s3.model;

import java.util.Date;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class S3ObjectSummary {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f16095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Date f16096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f16097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Owner f16098g;

    public String a() {
        return this.f16093b;
    }

    public void b(String str) {
        this.f16092a = str;
    }

    public void c(String str) {
        this.f16094c = str;
    }

    public void d(String str) {
        this.f16093b = str;
    }

    public void e(Date date) {
        this.f16096e = date;
    }

    public void f(Owner owner) {
        this.f16098g = owner;
    }

    public void g(long j11) {
        this.f16095d = j11;
    }

    public void h(String str) {
        this.f16097f = str;
    }

    public String toString() {
        return "S3ObjectSummary{bucketName='" + this.f16092a + "', key='" + this.f16093b + "', eTag='" + this.f16094c + "', size=" + this.f16095d + ", lastModified=" + this.f16096e + ", storageClass='" + this.f16097f + "', owner=" + this.f16098g + '}';
    }
}
