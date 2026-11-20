package com.bytedance.adsdk.ugeno.qr;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ol extends Handler {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final WeakReference<sc> f26441sc;

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void sc(Message message);
    }

    public Ol(Looper looper, sc scVar) {
        super(looper);
        this.f26441sc = new WeakReference<>(scVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        sc scVar = this.f26441sc.get();
        if (scVar == null || message == null) {
            return;
        }
        scVar.sc(message);
    }
}
