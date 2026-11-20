package com.bytedance.sdk.component.pFF.sc.sc.sc;

import com.google.android.gms.common.api.Api;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN extends com.bytedance.sdk.component.pFF.sc.We {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private ExecutorService f26954sc;
    private List<com.bytedance.sdk.component.pFF.sc.pFF> pFF = new CopyOnWriteArrayList();
    private List<com.bytedance.sdk.component.pFF.sc.pFF> zY = new CopyOnWriteArrayList();
    private AtomicInteger We = new AtomicInteger(64);

    public ExN() {
        if (this.f26954sc == null) {
            this.f26954sc = new ThreadPoolExecutor(0, Api.BaseClientBuilder.API_PRIORITY_OTHER, 20L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.bytedance.sdk.component.pFF.sc.sc.sc.ExN.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable, "systemHttp Dispatcher");
                    thread.setDaemon(false);
                    thread.setPriority(10);
                    return thread;
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.pFF.sc.We
    public List<com.bytedance.sdk.component.pFF.sc.pFF> We() {
        return this.zY;
    }

    @Override // com.bytedance.sdk.component.pFF.sc.We
    public ExecutorService pFF() {
        return this.f26954sc;
    }

    @Override // com.bytedance.sdk.component.pFF.sc.We
    public int sc() {
        return this.We.get();
    }

    @Override // com.bytedance.sdk.component.pFF.sc.We
    public void sc(int i11) {
        this.We.set(i11);
    }

    @Override // com.bytedance.sdk.component.pFF.sc.We
    public List<com.bytedance.sdk.component.pFF.sc.pFF> zY() {
        return this.pFF;
    }
}
