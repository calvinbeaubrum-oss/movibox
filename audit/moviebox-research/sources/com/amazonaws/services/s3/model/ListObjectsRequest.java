package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ListObjectsRequest extends AmazonWebServiceRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f16025d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f16026f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f16027g;

    public ListObjectsRequest(String str, String str2, String str3, String str4, Integer num) {
        setBucketName(str);
        d(str2);
        setMarker(str3);
        a(str4);
        c(num);
    }

    public void a(String str) {
        this.f16025d = str;
    }

    public void b(String str) {
        this.f16027g = str;
    }

    public void c(Integer num) {
        this.f16026f = num;
    }

    public void d(String str) {
        this.f16023b = str;
    }

    public ListObjectsRequest f(String str) {
        b(str);
        return this;
    }

    public void setBucketName(String str) {
        this.f16022a = str;
    }

    public void setMarker(String str) {
        this.f16024c = str;
    }
}
