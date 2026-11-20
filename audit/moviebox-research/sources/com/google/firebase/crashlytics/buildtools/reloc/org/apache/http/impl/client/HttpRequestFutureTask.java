package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client;

import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class HttpRequestFutureTask<V> extends FutureTask<V> {
    private final a<V> callable;
    private final yj.a request;

    public HttpRequestFutureTask(yj.a aVar, a<V> aVar2) {
        super(aVar2);
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    public boolean cancel(boolean z11) {
        throw null;
    }

    public long endedTime() {
        if (isDone()) {
            throw null;
        }
        throw new IllegalStateException("Task is not done yet");
    }

    public long requestDuration() {
        if (isDone()) {
            return endedTime() - startedTime();
        }
        throw new IllegalStateException("Task is not done yet");
    }

    public long scheduledTime() {
        throw null;
    }

    public long startedTime() {
        throw null;
    }

    public long taskDuration() {
        if (isDone()) {
            return endedTime() - scheduledTime();
        }
        throw new IllegalStateException("Task is not done yet");
    }

    @Override // java.util.concurrent.FutureTask
    public String toString() {
        throw null;
    }
}
