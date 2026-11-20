package com.alibaba.sdk.android.oss.common.auth;

import com.alibaba.sdk.android.oss.ClientException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface OSSCredentialProvider {
    OSSFederationToken getFederationToken() throws ClientException;
}
