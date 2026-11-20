package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazonaws.services.s3.internal.S3VersionResult;
import com.amazonaws.services.s3.internal.SSEResultBase;
import java.util.Date;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class PutObjectResult extends SSEResultBase implements ObjectExpirationResult, S3RequesterChargedResult, S3VersionResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Date f16072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f16073d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f16074f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ObjectMetadata f16075g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f16076h;

    public void a(String str) {
        this.f16074f = str;
    }

    public void b(ObjectMetadata objectMetadata) {
        this.f16075g = objectMetadata;
    }

    public void setETag(String str) {
        this.f16071b = str;
    }

    @Override // com.amazonaws.services.s3.internal.ObjectExpirationResult
    public void setExpirationTime(Date date) {
        this.f16072c = date;
    }

    @Override // com.amazonaws.services.s3.internal.ObjectExpirationResult
    public void setExpirationTimeRuleId(String str) {
        this.f16073d = str;
    }

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public void setRequesterCharged(boolean z11) {
        this.f16076h = z11;
    }

    @Override // com.amazonaws.services.s3.internal.S3VersionResult
    public void setVersionId(String str) {
        this.f16070a = str;
    }
}
