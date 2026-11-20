package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.services.s3.internal.ServerSideEncryptionResult;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ServerSideEncryptionHeaderHandler<T extends ServerSideEncryptionResult> implements HeaderHandler<T> {
    @Override // com.amazonaws.services.s3.internal.HeaderHandler
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(T t11, HttpResponse httpResponse) {
        t11.setSSEAlgorithm(httpResponse.c().get("x-amz-server-side-encryption"));
        t11.setSSECustomerAlgorithm(httpResponse.c().get("x-amz-server-side-encryption-customer-algorithm"));
        t11.setSSECustomerKeyMd5(httpResponse.c().get("x-amz-server-side-encryption-customer-key-MD5"));
    }
}
