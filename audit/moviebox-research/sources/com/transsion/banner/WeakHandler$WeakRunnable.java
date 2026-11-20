package com.transsion.banner;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
class WeakHandler$WeakRunnable implements Runnable {
    private final WeakReference<Runnable> mDelegate;
    private final WeakReference<b> mReference;

    public WeakHandler$WeakRunnable(WeakReference<Runnable> weakReference, WeakReference<b> weakReference2) {
        this.mDelegate = weakReference;
        this.mReference = weakReference2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.mDelegate.get();
        b bVar = this.mReference.get();
        if (bVar != null) {
            bVar.a();
        }
        if (runnable != null) {
            runnable.run();
        }
    }
}
