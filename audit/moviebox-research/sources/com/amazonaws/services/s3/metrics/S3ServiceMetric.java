package com.amazonaws.services.s3.metrics;

import com.amazonaws.metrics.ServiceMetricType;
import com.amazonaws.metrics.SimpleMetricType;
import com.amazonaws.metrics.ThroughputMetricType;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class S3ServiceMetric extends SimpleMetricType implements ServiceMetricType {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final S3ThroughputMetric f15989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final S3ServiceMetric f15990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final S3ThroughputMetric f15991d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final S3ServiceMetric f15992f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final S3ServiceMetric[] f15993g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15994a;

    /* JADX INFO: compiled from: source.java */
    public static abstract class S3ThroughputMetric extends S3ServiceMetric implements ThroughputMetricType {
        public S3ThroughputMetric(String str) {
            super(str);
        }
    }

    static {
        S3ThroughputMetric s3ThroughputMetric = new S3ThroughputMetric(a("DownloadThroughput")) { // from class: com.amazonaws.services.s3.metrics.S3ServiceMetric.1
        };
        f15989b = s3ThroughputMetric;
        S3ServiceMetric s3ServiceMetric = new S3ServiceMetric(a("DownloadByteCount"));
        f15990c = s3ServiceMetric;
        S3ThroughputMetric s3ThroughputMetric2 = new S3ThroughputMetric(a("UploadThroughput")) { // from class: com.amazonaws.services.s3.metrics.S3ServiceMetric.2
        };
        f15991d = s3ThroughputMetric2;
        S3ServiceMetric s3ServiceMetric2 = new S3ServiceMetric(a("UploadByteCount"));
        f15992f = s3ServiceMetric2;
        f15993g = new S3ServiceMetric[]{s3ThroughputMetric, s3ServiceMetric, s3ThroughputMetric2, s3ServiceMetric2};
    }

    public S3ServiceMetric(String str) {
        this.f15994a = str;
    }

    public static final String a(String str) {
        return "S3" + str;
    }

    public static S3ServiceMetric[] b() {
        return (S3ServiceMetric[]) f15993g.clone();
    }

    @Override // com.amazonaws.metrics.SimpleMetricType, com.amazonaws.metrics.MetricType
    public String name() {
        return this.f15994a;
    }
}
