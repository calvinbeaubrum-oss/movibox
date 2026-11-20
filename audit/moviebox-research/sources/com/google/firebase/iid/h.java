package com.google.firebase.iid;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class h implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Executor f40641a = new h();

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
