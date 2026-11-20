package com.alibaba.sdk.android.oss.model;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class GetBucketInfoRequest extends OSSRequest {
    private String bucketName;

    public GetBucketInfoRequest(String str) {
        this.bucketName = str;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }
}
