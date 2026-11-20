package io.reactivex.rxjava3.internal.schedulers;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class b implements Future<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h10.b f67513a;

    public b(h10.b bVar) {
        this.f67513a = bVar;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z11) {
        this.f67513a.dispose();
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return null;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j11, TimeUnit timeUnit) {
        return null;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return false;
    }
}
