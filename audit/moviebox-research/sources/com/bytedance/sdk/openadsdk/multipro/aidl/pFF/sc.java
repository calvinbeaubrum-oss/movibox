package com.bytedance.sdk.openadsdk.multipro.aidl.pFF;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.Cb;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc extends IAppOpenAdInteractionListener.Stub {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.sc.We.pFF f28628sc;

    public sc(com.bytedance.sdk.openadsdk.sc.We.pFF pff) {
        this.f28628sc = pff;
    }

    private void sc() {
        this.f28628sc = null;
    }

    @Override // com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener
    public void onAdClicked() throws RemoteException {
        if (this.f28628sc == null) {
            return;
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.pFF.sc.2
            @Override // java.lang.Runnable
            public void run() {
                if (sc.this.f28628sc != null) {
                    sc.this.f28628sc.onAdClicked();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener
    public void onAdShow() throws RemoteException {
        if (this.f28628sc == null) {
            return;
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.pFF.sc.1
            @Override // java.lang.Runnable
            public void run() {
                if (sc.this.f28628sc != null) {
                    sc.this.f28628sc.sc();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener
    public void onAdSkip() throws RemoteException {
        if (this.f28628sc == null) {
            return;
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.pFF.sc.3
            @Override // java.lang.Runnable
            public void run() {
                if (sc.this.f28628sc != null) {
                    sc.this.f28628sc.pFF();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener
    public void onAdTimeOver() throws RemoteException {
        if (this.f28628sc == null) {
            return;
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.pFF.sc.4
            @Override // java.lang.Runnable
            public void run() {
                if (sc.this.f28628sc != null) {
                    sc.this.f28628sc.zY();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener
    public void onDestroy() throws RemoteException {
        sc();
    }
}
