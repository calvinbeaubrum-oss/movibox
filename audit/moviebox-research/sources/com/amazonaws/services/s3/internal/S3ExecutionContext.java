package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.auth.Signer;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.http.ExecutionContext;
import java.net.URI;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class S3ExecutionContext extends ExecutionContext {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Signer f15972f;

    public S3ExecutionContext(List<RequestHandler2> list, boolean z11, AmazonWebServiceClient amazonWebServiceClient) {
        super(list, z11, amazonWebServiceClient);
    }

    @Override // com.amazonaws.http.ExecutionContext
    public Signer e(URI uri) {
        return this.f15972f;
    }

    @Override // com.amazonaws.http.ExecutionContext
    public void g(Signer signer) {
        this.f15972f = signer;
    }
}
