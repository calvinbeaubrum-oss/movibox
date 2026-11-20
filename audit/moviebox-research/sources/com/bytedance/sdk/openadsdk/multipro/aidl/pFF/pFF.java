package com.bytedance.sdk.openadsdk.multipro.aidl.pFF;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IDislikeClosedListener;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.zY.WH;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF extends IDislikeClosedListener.Stub {
    private final String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.zY.We.sc f28626sc;

    public pFF(String str, com.bytedance.sdk.openadsdk.core.zY.We.sc scVar) {
        this.pFF = str;
        this.f28626sc = scVar;
    }

    @Override // com.bytedance.sdk.openadsdk.IDislikeClosedListener
    public void onItemClickClosed() throws RemoteException {
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.pFF.pFF.1
            @Override // java.lang.Runnable
            public void run() {
                if (pFF.this.f28626sc != null) {
                    pFF.this.f28626sc.sc();
                    WH.sc(6, pFF.this.pFF);
                }
            }
        });
    }
}
