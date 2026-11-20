package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.IBinderPool;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.settings.dE;
import com.bytedance.sdk.openadsdk.multipro.aidl.sc.ExN;
import com.bytedance.sdk.openadsdk.multipro.aidl.sc.TRI;
import com.bytedance.sdk.openadsdk.multipro.aidl.sc.We;
import com.bytedance.sdk.openadsdk.multipro.aidl.sc.qr;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class BinderPoolService extends Service {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static volatile boolean f28619sc;
    private static boolean zY;
    private final Binder pFF = new sc();

    /* JADX INFO: compiled from: source.java */
    public static class sc extends IBinderPool.Stub {
        @Override // com.bytedance.sdk.openadsdk.IBinderPool
        public IBinder queryBinder(int i11) throws RemoteException {
            if (i11 == 0) {
                return qr.sc();
            }
            if (i11 == 1) {
                return ExN.sc();
            }
            if (i11 == 4) {
                return com.bytedance.sdk.openadsdk.multipro.aidl.sc.zY.sc();
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
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return this.pFF;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Xc.pFF(getApplicationContext());
        f28619sc = true;
        if (!zY) {
            com.bytedance.sdk.component.utils.qr.pFF().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.BinderPoolService.1
                @Override // java.lang.Runnable
                public void run() {
                    dE.ef().sc(BinderPoolService.this.getApplicationContext());
                }
            });
        }
        zY = true;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }
}
