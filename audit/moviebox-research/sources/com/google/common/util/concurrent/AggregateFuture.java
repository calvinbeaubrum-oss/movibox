package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.g1;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AggregateFuture<InputT, OutputT> extends d<OutputT> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f38877d = Logger.getLogger(AggregateFuture.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImmutableCollection<? extends s<? extends InputT>> f38878c;

    /* JADX INFO: compiled from: source.java */
    public enum ReleaseResourcesReason {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        super.afterDone();
        ImmutableCollection<? extends s<? extends InputT>> immutableCollection = this.f38878c;
        b(ReleaseResourcesReason.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (immutableCollection != null)) {
            boolean zWasInterrupted = wasInterrupted();
            g1<? extends s<? extends InputT>> it = immutableCollection.iterator();
            while (it.hasNext()) {
                it.next().cancel(zWasInterrupted);
            }
        }
    }

    public void b(ReleaseResourcesReason releaseResourcesReason) {
        com.google.common.base.m.p(releaseResourcesReason);
        this.f38878c = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final String pendingToString() {
        ImmutableCollection<? extends s<? extends InputT>> immutableCollection = this.f38878c;
        if (immutableCollection == null) {
            return super.pendingToString();
        }
        return "futures=" + immutableCollection;
    }
}
