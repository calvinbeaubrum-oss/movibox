package com.alibaba.sdk.android.oss.model;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class RestoreObjectRequest extends OSSRequest {
    private String bucketName;
    private String objectKey;

    public String getBucketName() {
        return this.bucketName;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setObjectKey(String str) {
        this.objectKey = str;
    }
}
