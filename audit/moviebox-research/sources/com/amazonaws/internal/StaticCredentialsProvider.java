package com.amazonaws.internal;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class StaticCredentialsProvider implements AWSCredentialsProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AWSCredentials f15748a;

    public StaticCredentialsProvider(AWSCredentials aWSCredentials) {
        this.f15748a = aWSCredentials;
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public AWSCredentials getCredentials() {
        return this.f15748a;
    }
}
