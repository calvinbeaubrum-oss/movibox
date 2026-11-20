package com.bytedance.sdk.component.pFF.sc.sc.sc;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc extends com.bytedance.sdk.component.pFF.sc.We {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static volatile Ol f26962sc;
    private ExecutorService We;
    private List<com.bytedance.sdk.component.pFF.sc.pFF> pFF = new CopyOnWriteArrayList();
    private List<com.bytedance.sdk.component.pFF.sc.pFF> zY = new CopyOnWriteArrayList();

    public sc(ExecutorService executorService) {
        this.We = executorService;
    }

    public static void sc(Ol ol2) {
        f26962sc = ol2;
    }

    public boolean ExN() {
        return (f26962sc == null || f26962sc.sc() == null) ? false : true;
    }

    @Override // com.bytedance.sdk.component.pFF.sc.We
    public List<com.bytedance.sdk.component.pFF.sc.pFF> We() {
        return this.zY;
    }

    @Override // com.bytedance.sdk.component.pFF.sc.We
    public ExecutorService pFF() {
        ExecutorService executorServiceSc = f26962sc != null ? f26962sc.sc() : null;
        return executorServiceSc != null ? executorServiceSc : this.We;
    }

    @Override // com.bytedance.sdk.component.pFF.sc.We
    public int sc() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.pFF.sc.We
    public void sc(int i11) {
    }

    @Override // com.bytedance.sdk.component.pFF.sc.We
    public List<com.bytedance.sdk.component.pFF.sc.pFF> zY() {
        return this.pFF;
    }
}
