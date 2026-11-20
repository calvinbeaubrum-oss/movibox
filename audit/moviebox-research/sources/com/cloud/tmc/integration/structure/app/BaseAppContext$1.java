package com.cloud.tmc.integration.structure.app;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class BaseAppContext$1 implements Runnable {
    final /* synthetic */ a this$0;

    public BaseAppContext$1(a aVar) {
        this.this$0 = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.l().setVisibility(0);
    }
}
