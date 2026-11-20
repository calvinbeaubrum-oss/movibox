package com.bytedance.sdk.component.ExN.sc;

import com.cloud.tmc.integration.core.TmcEngineFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final TimeUnit f26500sc = TimeUnit.SECONDS;

    public static ExecutorService sc() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 30L, f26500sc, new LinkedBlockingQueue(), new sc(TmcEngineFactory.ENGINE_TYPE_DEFAULT));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
