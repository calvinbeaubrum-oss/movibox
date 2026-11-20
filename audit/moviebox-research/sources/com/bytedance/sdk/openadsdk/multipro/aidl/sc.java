package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.IBinderPool;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.multipro.aidl.sc.ExN;
import com.bytedance.sdk.openadsdk.multipro.aidl.sc.TRI;
import com.bytedance.sdk.openadsdk.multipro.aidl.sc.We;
import com.bytedance.sdk.openadsdk.multipro.aidl.sc.qr;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.cJ;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    private static final sc pFF = new sc();

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private IBinderPool f28637sc;
    private pFF zY;
    private long We = 0;
    private final ServiceConnection ExN = new ServiceConnection() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.sc.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            Cb.sc(new Qj("onServiceConnected") { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.sc.2.1
                @Override // java.lang.Runnable
                public void run() {
                    sc.this.f28637sc = IBinderPool.Stub.asInterface(iBinder);
                    try {
                        sc.this.f28637sc.asBinder().linkToDeath(sc.this.TRI, 0);
                    } catch (RemoteException e11) {
                        Tf.sc("TTAD.BinderPool", "onServiceConnected throws :", e11);
                    }
                    System.currentTimeMillis();
                    long unused = sc.this.We;
                    if (sc.this.zY != null) {
                        sc.this.zY.onServiceConnected();
                    }
                }
            }, 5);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private final IBinder.DeathRecipient TRI = new IBinder.DeathRecipient() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.sc.3
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Cb.sc(new Qj("binderDied") { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.sc.3.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (sc.this.f28637sc.asBinder().isBinderAlive()) {
                            sc.this.f28637sc.asBinder().unlinkToDeath(sc.this.TRI, 0);
                        }
                    } catch (Exception e11) {
                        Tf.sc("TTAD.BinderPool", e11.getMessage());
                    }
                    sc.this.f28637sc = null;
                    sc.this.We();
                }
            }, 5);
        }
    };

    private sc() {
        We();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void We() {
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            zY();
        }
    }

    public static sc sc() {
        return pFF;
    }

    public void pFF() {
        try {
            Context contextSc = Xc.sc();
            contextSc.startService(new Intent(contextSc, (Class<?>) BinderPoolService.class));
        } catch (Exception unused) {
        }
    }

    public IBinder sc(int i11) {
        try {
            if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                try {
                    IBinderPool iBinderPool = this.f28637sc;
                    if (iBinderPool != null) {
                        return iBinderPool.queryBinder(i11);
                    }
                    return null;
                } catch (RemoteException e11) {
                    Tf.sc("TTAD.BinderPool", e11.getMessage());
                    cJ.Qj("queryBinder error");
                    return null;
                }
            }
            if (i11 == 0) {
                return qr.sc();
            }
            if (i11 == 1) {
                return ExN.sc();
            }
            if (i11 == 5) {
                return TRI.pFF();
            }
            if (i11 == 6) {
                return We.sc();
            }
            if (i11 != 7) {
                return null;
            }
            return com.bytedance.sdk.openadsdk.multipro.aidl.sc.pFF.sc();
        } catch (Throwable unused) {
            return null;
        }
    }

    public void sc(pFF pff) {
        this.zY = pff;
        if (this.f28637sc != null) {
            Cb.sc(new Qj("onServiceConnected2") { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.sc.1
                @Override // java.lang.Runnable
                public void run() {
                    if (sc.this.zY != null) {
                        sc.this.zY.onServiceConnected();
                    }
                }
            }, 5);
        }
    }

    public void zY() {
        try {
            Context contextSc = Xc.sc();
            contextSc.bindService(new Intent(contextSc, (Class<?>) BinderPoolService.class), this.ExN, 1);
            this.We = System.currentTimeMillis();
        } catch (Throwable unused) {
        }
    }
}
