package com.amazonaws.services.s3.model.metrics;

import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MetricsFilter implements Serializable {
    private MetricsFilterPredicate predicate;

    public MetricsFilter() {
    }

    public MetricsFilter(MetricsFilterPredicate metricsFilterPredicate) {
        this.predicate = metricsFilterPredicate;
    }

    public MetricsFilterPredicate getPredicate() {
        return this.predicate;
    }

    public void setPredicate(MetricsFilterPredicate metricsFilterPredicate) {
        this.predicate = metricsFilterPredicate;
    }

    public MetricsFilter withPredicate(MetricsFilterPredicate metricsFilterPredicate) {
        setPredicate(metricsFilterPredicate);
        return this;
    }
}
