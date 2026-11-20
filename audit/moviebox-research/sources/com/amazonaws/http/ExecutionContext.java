package com.amazonaws.http;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.Signer;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AWSRequestMetricsFullSupport;
import java.net.URI;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExecutionContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AWSRequestMetrics f15720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<RequestHandler2> f15721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f15722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AmazonWebServiceClient f15723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AWSCredentials f15724e;

    public ExecutionContext(List<RequestHandler2> list, boolean z11, AmazonWebServiceClient amazonWebServiceClient) {
        this.f15721b = list;
        this.f15720a = z11 ? new AWSRequestMetricsFullSupport() : new AWSRequestMetrics();
        this.f15723d = amazonWebServiceClient;
    }

    @Deprecated
    public AWSRequestMetrics a() {
        return this.f15720a;
    }

    public String b() {
        return this.f15722c;
    }

    public AWSCredentials c() {
        return this.f15724e;
    }

    public List<RequestHandler2> d() {
        return this.f15721b;
    }

    public Signer e(URI uri) {
        throw null;
    }

    public void f(AWSCredentials aWSCredentials) {
        this.f15724e = aWSCredentials;
    }

    public void g(Signer signer) {
        throw null;
    }
}
