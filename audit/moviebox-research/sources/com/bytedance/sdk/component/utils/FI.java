package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class FI extends Handler {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected WeakReference<sc> f27023sc;

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void sc(Message message);
    }

    public FI(Looper looper, sc scVar) {
        super(looper);
        if (scVar != null) {
            this.f27023sc = new WeakReference<>(scVar);
        }
    }

    public FI(sc scVar) {
        if (scVar != null) {
            this.f27023sc = new WeakReference<>(scVar);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        sc scVar;
        WeakReference<sc> weakReference = this.f27023sc;
        if (weakReference == null || (scVar = weakReference.get()) == null || message == null) {
            return;
        }
        scVar.sc(message);
    }
}
