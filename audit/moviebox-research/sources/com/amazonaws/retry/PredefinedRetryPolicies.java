package com.amazonaws.retry;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Random;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class PredefinedRetryPolicies {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RetryPolicy f15904a = new RetryPolicy(RetryPolicy.RetryCondition.f15917a, RetryPolicy.BackoffStrategy.f15916a, 0, false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final RetryPolicy.RetryCondition f15907d = new SDKDefaultRetryCondition();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final RetryPolicy.BackoffStrategy f15908e = new SDKDefaultBackoffStrategy(100, 20000);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final RetryPolicy f15905b = a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RetryPolicy f15906c = b();

    /* JADX INFO: compiled from: source.java */
    public static final class SDKDefaultBackoffStrategy implements RetryPolicy.BackoffStrategy {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Random f15909b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f15910c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f15911d;

        public SDKDefaultBackoffStrategy(int i11, int i12) {
            this.f15909b = new Random();
            this.f15910c = i11;
            this.f15911d = i12;
        }

        @Override // com.amazonaws.retry.RetryPolicy.BackoffStrategy
        public final long a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i11) {
            if (i11 <= 0) {
                return 0L;
            }
            return this.f15909b.nextInt(Math.min(this.f15911d, (1 << i11) * this.f15910c));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class SDKDefaultRetryCondition implements RetryPolicy.RetryCondition {
        @Override // com.amazonaws.retry.RetryPolicy.RetryCondition
        public boolean a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i11) {
            if ((amazonClientException.getCause() instanceof IOException) && !(amazonClientException.getCause() instanceof InterruptedIOException)) {
                return true;
            }
            if (!(amazonClientException instanceof AmazonServiceException)) {
                return false;
            }
            AmazonServiceException amazonServiceException = (AmazonServiceException) amazonClientException;
            int statusCode = amazonServiceException.getStatusCode();
            return statusCode == 500 || statusCode == 503 || statusCode == 502 || statusCode == 504 || RetryUtils.c(amazonServiceException) || RetryUtils.a(amazonServiceException);
        }
    }

    public static RetryPolicy a() {
        return new RetryPolicy(f15907d, f15908e, 3, true);
    }

    public static RetryPolicy b() {
        return new RetryPolicy(f15907d, f15908e, 10, true);
    }
}
