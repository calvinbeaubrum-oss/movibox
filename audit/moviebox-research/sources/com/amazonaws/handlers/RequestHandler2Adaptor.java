package com.amazonaws.handlers;

import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.util.AWSRequestMetrics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class RequestHandler2Adaptor extends RequestHandler2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RequestHandler f15713a;

    public RequestHandler2Adaptor(RequestHandler requestHandler) {
        if (requestHandler == null) {
            throw new IllegalArgumentException();
        }
        this.f15713a = requestHandler;
    }

    @Override // com.amazonaws.handlers.RequestHandler2
    public void b(Request<?> request, Response<?> response, Exception exc) {
        this.f15713a.b(request, exc);
    }

    @Override // com.amazonaws.handlers.RequestHandler2
    public void c(Request<?> request, Response<?> response) {
        AWSRequestMetrics aWSRequestMetricsB = request == null ? null : request.b();
        this.f15713a.c(request, response == null ? null : response.a(), aWSRequestMetricsB != null ? aWSRequestMetricsB.c() : null);
    }

    @Override // com.amazonaws.handlers.RequestHandler2
    public void d(Request<?> request) {
        this.f15713a.a(request);
    }

    public boolean equals(Object obj) {
        if (obj instanceof RequestHandler2Adaptor) {
            return this.f15713a.equals(((RequestHandler2Adaptor) obj).f15713a);
        }
        return false;
    }

    public int hashCode() {
        return this.f15713a.hashCode();
    }
}
