package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class AWSCredentialsProviderChain implements AWSCredentialsProvider {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Log f15665d = LogFactory.b(AWSCredentialsProviderChain.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<AWSCredentialsProvider> f15666a = new LinkedList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15667b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AWSCredentialsProvider f15668c;

    public AWSCredentialsProviderChain(AWSCredentialsProvider... aWSCredentialsProviderArr) {
        if (aWSCredentialsProviderArr == null || aWSCredentialsProviderArr.length == 0) {
            throw new IllegalArgumentException("No credential providers specified");
        }
        for (AWSCredentialsProvider aWSCredentialsProvider : aWSCredentialsProviderArr) {
            this.f15666a.add(aWSCredentialsProvider);
        }
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public AWSCredentials getCredentials() {
        AWSCredentialsProvider aWSCredentialsProvider;
        if (this.f15667b && (aWSCredentialsProvider = this.f15668c) != null) {
            return aWSCredentialsProvider.getCredentials();
        }
        for (AWSCredentialsProvider aWSCredentialsProvider2 : this.f15666a) {
            try {
                AWSCredentials credentials = aWSCredentialsProvider2.getCredentials();
                if (credentials.a() != null && credentials.b() != null) {
                    f15665d.a("Loading credentials from " + aWSCredentialsProvider2.toString());
                    this.f15668c = aWSCredentialsProvider2;
                    return credentials;
                }
            } catch (Exception e11) {
                f15665d.a("Unable to load credentials from " + aWSCredentialsProvider2.toString() + ": " + e11.getMessage());
            }
        }
        throw new AmazonClientException("Unable to load AWS credentials from any provider in the chain");
    }
}
