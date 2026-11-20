package com.amazonaws.services.s3.model.metrics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface MetricsPredicateVisitor {
    void a(MetricsAndOperator metricsAndOperator);

    void b(MetricsTagPredicate metricsTagPredicate);

    void c(MetricsPrefixPredicate metricsPrefixPredicate);
}
