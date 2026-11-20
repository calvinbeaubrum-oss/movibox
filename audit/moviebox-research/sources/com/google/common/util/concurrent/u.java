package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface u extends ExecutorService {
    s<?> submit(Runnable runnable);

    <T> s<T> submit(Callable<T> callable);
}
