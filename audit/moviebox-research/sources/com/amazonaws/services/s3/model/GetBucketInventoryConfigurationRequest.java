package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class GetBucketInventoryConfigurationRequest extends AmazonWebServiceRequest implements Serializable {
    private String bucketName;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f16011id;

    public GetBucketInventoryConfigurationRequest() {
    }

    public GetBucketInventoryConfigurationRequest(String str, String str2) {
        this.bucketName = str;
        this.f16011id = str2;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getId() {
        return this.f16011id;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setId(String str) {
        this.f16011id = str;
    }

    public GetBucketInventoryConfigurationRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public GetBucketInventoryConfigurationRequest withId(String str) {
        setId(str);
        return this;
    }
}
