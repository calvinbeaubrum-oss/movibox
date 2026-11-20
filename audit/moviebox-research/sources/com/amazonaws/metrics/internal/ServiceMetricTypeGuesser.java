package com.amazonaws.metrics.internal;

import com.amazonaws.Request;
import com.amazonaws.metrics.AwsSdkMetrics;
import com.amazonaws.metrics.SimpleThroughputMetricType;
import com.amazonaws.metrics.ThroughputMetricType;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public enum ServiceMetricTypeGuesser {
    ;

    public static ThroughputMetricType guessThroughputMetricType(Request<?> request, String str, String str2) {
        if (!AwsSdkMetrics.isMetricsEnabled() || !request.m().getClass().getName().startsWith("com.amazonaws.services.s3")) {
            return null;
        }
        return new SimpleThroughputMetricType("S3" + str, request.d(), "S3" + str2);
    }
}
