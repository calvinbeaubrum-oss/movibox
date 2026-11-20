package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazonaws.services.s3.internal.SSEResultBase;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class UploadPartResult extends SSEResultBase implements S3RequesterChargedResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f16115c;

    public String getETag() {
        return this.f16114b;
    }

    public int getPartNumber() {
        return this.f16113a;
    }

    public void setETag(String str) {
        this.f16114b = str;
    }

    public void setPartNumber(int i11) {
        this.f16113a = i11;
    }

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public void setRequesterCharged(boolean z11) {
        this.f16115c = z11;
    }
}
