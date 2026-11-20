package com.alibaba.sdk.android.oss.model;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class GetBucketLifecycleRequest extends OSSRequest {
    private String mBucketName;

    public String getBucketName() {
        return this.mBucketName;
    }

    public void setBucketName(String str) {
        this.mBucketName = str;
    }
}
