package com.polygamma.ogm;

import com.google.common.util.concurrent.Futures;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.common.util.concurrent.s f48885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.c f48886b;

    public s(com.google.common.util.concurrent.s sVar, io.c cVar) {
        Objects.requireNonNull(sVar);
        this.f48885a = sVar;
        Objects.requireNonNull(cVar);
        this.f48886b = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f48886b.accept(Futures.d(this.f48885a), null);
        } catch (Throwable th2) {
            th = th2;
            io.c cVar = this.f48886b;
            if (th instanceof ExecutionException) {
                th = th.getCause();
            }
            cVar.accept(null, th);
        }
    }
}
