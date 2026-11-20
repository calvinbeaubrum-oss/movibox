package com.bytedance.sdk.openadsdk.multipro.aidl.pFF;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.Cb;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We extends IRewardAdInteractionListener.Stub {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.sc.ExN.sc f28621sc;

    public We(com.bytedance.sdk.openadsdk.sc.ExN.sc scVar) {
        this.f28621sc = scVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc() {
        this.f28621sc = null;
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdClose() throws RemoteException {
        if (this.f28621sc == null) {
            return;
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.pFF.We.3
            @Override // java.lang.Runnable
            public void run() {
                if (We.this.f28621sc != null) {
                    We.this.f28621sc.pFF();
                }
                We.this.sc();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdShow() throws RemoteException {
        if (this.f28621sc == null) {
            return;
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.pFF.We.1
            @Override // java.lang.Runnable
            public void run() {
                if (We.this.f28621sc != null) {
                    We.this.f28621sc.sc();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdVideoBarClick() throws RemoteException {
        if (this.f28621sc == null) {
            return;
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.pFF.We.2
            @Override // java.lang.Runnable
            public void run() {
                if (We.this.f28621sc != null) {
                    We.this.f28621sc.onAdClicked();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onDestroy() throws RemoteException {
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onRewardVerify(final boolean z11, final int i11, final String str, final int i12, final String str2) throws RemoteException {
        if (this.f28621sc == null) {
            return;
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.pFF.We.4
            @Override // java.lang.Runnable
            public void run() {
                if (We.this.f28621sc != null) {
                    We.this.f28621sc.sc(z11, i11, str, i12, str2);
                }
            }
        });
    }
}
