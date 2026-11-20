package com.bytedance.sdk.openadsdk.multipro.aidl.sc;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.IDislikeClosedListener;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We extends sc {
    private static volatile We pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static ConcurrentHashMap<String, RemoteCallbackList<IDislikeClosedListener>> f28645sc = new ConcurrentHashMap<>();

    public static We sc() {
        if (pFF == null) {
            synchronized (We.class) {
                try {
                    if (pFF == null) {
                        pFF = new We();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return pFF;
    }

    private synchronized void sc(String str, String str2) {
        RemoteCallbackList<IDislikeClosedListener> remoteCallbackList;
        try {
            ConcurrentHashMap<String, RemoteCallbackList<IDislikeClosedListener>> concurrentHashMap = f28645sc;
            if (concurrentHashMap != null && (remoteCallbackList = concurrentHashMap.get(str)) != null) {
                int iBeginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i11 = 0; i11 < iBeginBroadcast; i11++) {
                    try {
                        IDislikeClosedListener iDislikeClosedListener = (IDislikeClosedListener) remoteCallbackList.getBroadcastItem(i11);
                        if (iDislikeClosedListener != null && "onItemClickClosed".equals(str2)) {
                            iDislikeClosedListener.onItemClickClosed();
                        }
                    } catch (Throwable th2) {
                        Tf.sc("MultiProcess", "dislike '" + str2 + "'  throws Exception :", th2);
                    }
                }
                remoteCallbackList.finishBroadcast();
            }
        } catch (Throwable th3) {
            Tf.sc("MultiProcess", "dislike '" + str2 + "'  throws Exception :", th3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.sc.sc, com.bytedance.sdk.openadsdk.IListenerManager
    public void executeDisLikeClosedCallback(String str, String str2) throws RemoteException {
        sc(str, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.sc.sc, com.bytedance.sdk.openadsdk.IListenerManager
    public synchronized void registerDisLikeClosedListener(String str, IDislikeClosedListener iDislikeClosedListener) throws RemoteException {
        RemoteCallbackList<IDislikeClosedListener> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(iDislikeClosedListener);
        f28645sc.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.sc.sc, com.bytedance.sdk.openadsdk.IListenerManager
    public void unregisterDisLikeClosedListener(String str) throws RemoteException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f28645sc.remove(str);
    }
}
