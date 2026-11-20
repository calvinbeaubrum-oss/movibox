package com.amazonaws.auth;

import com.amazonaws.Request;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class NoOpSigner implements Signer {
    @Override // com.amazonaws.auth.Signer
    public void b(Request<?> request, AWSCredentials aWSCredentials) {
    }
}
