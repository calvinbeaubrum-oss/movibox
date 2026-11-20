package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.integration.activity.LoadStepAction;
import com.cloud.tmc.integration.proxy.IUpdateLoadingStepProxy;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import rb.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class UpdateLoadingStepProxyImpl implements IUpdateLoadingStepProxy {
    public final ConcurrentHashMap<String, b> OooO00o = new ConcurrentHashMap<>();

    @Override // com.cloud.tmc.integration.proxy.IUpdateLoadingStepProxy
    public void addUpdateLoadingListener(String appId, b listener) {
        Intrinsics.g(appId, "appId");
        Intrinsics.g(listener, "listener");
        if (appId.length() == 0) {
            return;
        }
        this.OooO00o.put(appId, listener);
    }

    public final ConcurrentHashMap<String, b> getMap() {
        return this.OooO00o;
    }

    @Override // com.cloud.tmc.integration.proxy.IUpdateLoadingStepProxy
    public void notifyUpdateLoadingStep(String appId, LoadStepAction step) {
        b bVar;
        Intrinsics.g(appId, "appId");
        Intrinsics.g(step, "step");
        if (appId.length() == 0 || (bVar = this.OooO00o.get(appId)) == null) {
            return;
        }
        bVar.D(step);
    }

    @Override // com.cloud.tmc.integration.proxy.IUpdateLoadingStepProxy
    public void removeUpdateLoadingListener(String appId) {
        Intrinsics.g(appId, "appId");
        if (appId.length() == 0) {
            return;
        }
        this.OooO00o.remove(appId);
    }
}
