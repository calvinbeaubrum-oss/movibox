package com.amazonaws.util;

import com.amazonaws.metrics.MetricType;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class AWSRequestMetrics {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TimingInfo f16246a;

    /* JADX INFO: compiled from: source.java */
    public enum Field implements MetricType {
        AWSErrorCode,
        AWSRequestID,
        BytesProcessed,
        ClientExecuteTime,
        CredentialsRequestTime,
        Exception,
        HttpRequestTime,
        RedirectLocation,
        RequestMarshallTime,
        RequestSigningTime,
        ResponseProcessingTime,
        RequestCount,
        RetryCount,
        HttpClientRetryCount,
        HttpClientSendRequestTime,
        HttpClientReceiveResponseTime,
        RetryPauseTime,
        ServiceEndpoint,
        ServiceName,
        StatusCode
    }

    public AWSRequestMetrics() {
        this.f16246a = TimingInfo.m();
    }

    public AWSRequestMetrics(TimingInfo timingInfo) {
        this.f16246a = timingInfo;
    }

    public void a(MetricType metricType, Object obj) {
    }

    public void b(MetricType metricType) {
    }

    public final TimingInfo c() {
        return this.f16246a;
    }

    public void d(MetricType metricType) {
    }

    public void e() {
    }

    public void f(MetricType metricType, long j11) {
    }

    public void g(MetricType metricType) {
    }
}
