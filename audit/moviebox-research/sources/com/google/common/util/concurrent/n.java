package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class n<V> extends m<V> implements s<V> {

    /* JADX INFO: compiled from: source.java */
    public static abstract class a<V> extends n<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s<V> f38948a;

        public a(s<V> sVar) {
            this.f38948a = (s) com.google.common.base.m.p(sVar);
        }

        @Override // com.google.common.util.concurrent.m
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public final s<V> u() {
            return this.f38948a;
        }
    }

    @Override // com.google.common.util.concurrent.s
    public void addListener(Runnable runnable, Executor executor) {
        delegate().addListener(runnable, executor);
    }

    /* JADX INFO: renamed from: v */
    public abstract s<? extends V> delegate();
}
