package com.bytedance.sdk.openadsdk.multipro.aidl.sc;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class qr extends sc {
    private static volatile qr pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final Map<String, RemoteCallbackList<IRewardAdInteractionListener>> f28647sc = Collections.synchronizedMap(new HashMap());

    public static qr sc() {
        if (pFF == null) {
            synchronized (qr.class) {
                try {
                    if (pFF == null) {
                        pFF = new qr();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return pFF;
    }

    private synchronized void sc(String str, String str2, boolean z11, int i11, String str3, int i12, String str4) {
        try {
            Map<String, RemoteCallbackList<IRewardAdInteractionListener>> map = f28647sc;
            if (map != null) {
                RemoteCallbackList<IRewardAdInteractionListener> remoteCallbackListRemove = "recycleRes".equals(str2) ? map.remove(str) : map.get(str);
                if (remoteCallbackListRemove != null) {
                    int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
                    for (int i13 = 0; i13 < iBeginBroadcast; i13++) {
                        try {
                            IRewardAdInteractionListener iRewardAdInteractionListener = (IRewardAdInteractionListener) remoteCallbackListRemove.getBroadcastItem(i13);
                            if (iRewardAdInteractionListener != null) {
                                if ("onAdShow".equals(str2)) {
                                    iRewardAdInteractionListener.onAdShow();
                                } else if ("onAdClose".equals(str2)) {
                                    iRewardAdInteractionListener.onAdClose();
                                } else if ("onAdVideoBarClick".equals(str2)) {
                                    iRewardAdInteractionListener.onAdVideoBarClick();
                                } else if ("onRewardVerify".equals(str2)) {
                                    iRewardAdInteractionListener.onRewardVerify(z11, i11, str3, i12, str4);
                                } else if ("recycleRes".equals(str2)) {
                                    iRewardAdInteractionListener.onDestroy();
                                }
                            }
                        } catch (Throwable th2) {
                            Tf.sc("MultiProcess", "reward1 '" + str2 + "'  throws Exception :", th2);
                        }
                    }
                    remoteCallbackListRemove.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackListRemove.kill();
                    }
                }
            }
        } catch (Throwable th3) {
            Tf.sc("MultiProcess", "reward2 '" + str2 + "'  throws Exception :", th3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.sc.sc, com.bytedance.sdk.openadsdk.IListenerManager
    public void executeRewardVideoCallback(String str, String str2, boolean z11, int i11, String str3, int i12, String str4) throws RemoteException {
        sc(str, str2, z11, i11, str3, i12, str4);
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.sc.sc, com.bytedance.sdk.openadsdk.IListenerManager
    public synchronized void registerRewardVideoListener(String str, IRewardAdInteractionListener iRewardAdInteractionListener) throws RemoteException {
        RemoteCallbackList<IRewardAdInteractionListener> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(iRewardAdInteractionListener);
        f28647sc.put(str, remoteCallbackList);
    }
}
