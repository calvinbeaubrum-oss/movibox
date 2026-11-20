package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class GetBucketMetricsConfigurationRequest extends AmazonWebServiceRequest implements Serializable {
    private String bucketName;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f16012id;

    public GetBucketMetricsConfigurationRequest() {
    }

    public GetBucketMetricsConfigurationRequest(String str, String str2) {
        this.bucketName = str;
        this.f16012id = str2;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getId() {
        return this.f16012id;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setId(String str) {
        this.f16012id = str;
    }

    public GetBucketMetricsConfigurationRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public GetBucketMetricsConfigurationRequest withId(String str) {
        setId(str);
        return this;
    }
}
