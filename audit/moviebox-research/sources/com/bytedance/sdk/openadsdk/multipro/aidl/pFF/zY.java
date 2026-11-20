package com.bytedance.sdk.openadsdk.multipro.aidl.pFF;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.Cb;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY extends IFullScreenVideoAdInteractionListener.Stub {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.sc.zY.pFF f28633sc;

    public zY(com.bytedance.sdk.openadsdk.sc.zY.pFF pff) {
        this.f28633sc = pff;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc() {
        this.f28633sc = null;
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdClose() throws RemoteException {
        if (this.f28633sc == null) {
            return;
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.pFF.zY.3
            @Override // java.lang.Runnable
            public void run() {
                if (zY.this.f28633sc != null) {
                    zY.this.f28633sc.pFF();
                }
                zY.this.sc();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdShow() throws RemoteException {
        if (this.f28633sc == null) {
            return;
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.pFF.zY.1
            @Override // java.lang.Runnable
            public void run() {
                if (zY.this.f28633sc != null) {
                    zY.this.f28633sc.sc();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdVideoBarClick() throws RemoteException {
        if (this.f28633sc == null) {
            return;
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.pFF.zY.2
            @Override // java.lang.Runnable
            public void run() {
                if (zY.this.f28633sc != null) {
                    zY.this.f28633sc.onAdClicked();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onDestroy() throws RemoteException {
    }
}
