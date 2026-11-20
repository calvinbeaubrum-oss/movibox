package com.amazonaws.auth;

import com.amazonaws.Request;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface Signer {
    void b(Request<?> request, AWSCredentials aWSCredentials);
}
