package com.amazonaws.retry;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceRequest;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class RetryPolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RetryCondition f15912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BackoffStrategy f15913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f15915d;

    /* JADX INFO: compiled from: source.java */
    public interface BackoffStrategy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BackoffStrategy f15916a = new BackoffStrategy() { // from class: com.amazonaws.retry.RetryPolicy.BackoffStrategy.1
            @Override // com.amazonaws.retry.RetryPolicy.BackoffStrategy
            public long a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i11) {
                return 0L;
            }
        };

        long a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface RetryCondition {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final RetryCondition f15917a = new RetryCondition() { // from class: com.amazonaws.retry.RetryPolicy.RetryCondition.1
            @Override // com.amazonaws.retry.RetryPolicy.RetryCondition
            public boolean a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i11) {
                return false;
            }
        };

        boolean a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i11);
    }

    public RetryPolicy(RetryCondition retryCondition, BackoffStrategy backoffStrategy, int i11, boolean z11) {
        retryCondition = retryCondition == null ? PredefinedRetryPolicies.f15907d : retryCondition;
        backoffStrategy = backoffStrategy == null ? PredefinedRetryPolicies.f15908e : backoffStrategy;
        if (i11 < 0) {
            throw new IllegalArgumentException("Please provide a non-negative value for maxErrorRetry.");
        }
        this.f15912a = retryCondition;
        this.f15913b = backoffStrategy;
        this.f15914c = i11;
        this.f15915d = z11;
    }

    public BackoffStrategy a() {
        return this.f15913b;
    }

    public int b() {
        return this.f15914c;
    }

    public RetryCondition c() {
        return this.f15912a;
    }

    public boolean d() {
        return this.f15915d;
    }
}
