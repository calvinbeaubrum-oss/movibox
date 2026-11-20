package com.aliyun.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ThreadManager {
    public static ExecutorService threadPool = Executors.newCachedThreadPool();
}
