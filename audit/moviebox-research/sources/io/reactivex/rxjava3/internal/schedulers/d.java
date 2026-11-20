package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class d extends Scheduler {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final RxThreadFactory f67520d = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx3.newthread-priority", 5).intValue())));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThreadFactory f67521c;

    public d() {
        this(f67520d);
    }

    public d(ThreadFactory threadFactory) {
        this.f67521c = threadFactory;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker c() {
        return new e(this.f67521c);
    }
}
