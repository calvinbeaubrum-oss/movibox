package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.SSEResultBase;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class InitiateMultipartUploadResult extends SSEResultBase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16021c;

    public String a() {
        return this.f16021c;
    }

    public void b(String str) {
        this.f16021c = str;
    }

    public void setBucketName(String str) {
        this.f16019a = str;
    }

    public void setKey(String str) {
        this.f16020b = str;
    }
}
