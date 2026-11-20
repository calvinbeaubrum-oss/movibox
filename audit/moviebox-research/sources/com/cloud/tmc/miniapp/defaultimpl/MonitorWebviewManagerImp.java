package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.render.IMonitorWebviewManagerProxy;
import ee.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class MonitorWebviewManagerImp implements IMonitorWebviewManagerProxy {
    public final List<i> OooO00o = new ArrayList();

    @Override // com.cloud.tmc.render.IMonitorWebviewManagerProxy
    public void registerMonitorListener(i listener) {
        Intrinsics.g(listener, "listener");
        if (this.OooO00o.contains(listener)) {
            return;
        }
        this.OooO00o.add(listener);
    }

    @Override // com.cloud.tmc.render.IMonitorWebviewManagerProxy
    public void reportDomLoadTime(int i11, String uniqueId) {
        Intrinsics.g(uniqueId, "uniqueId");
        try {
            for (i iVar : this.OooO00o) {
                if (Intrinsics.b(String.valueOf(iVar.hashCode()), uniqueId)) {
                    iVar.reportDomLoadTime(i11, uniqueId);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.cloud.tmc.render.IMonitorWebviewManagerProxy
    public void unRegisterMonitorListener(i listener) {
        Intrinsics.g(listener, "listener");
        if (this.OooO00o.contains(listener)) {
            this.OooO00o.remove(listener);
        }
    }
}
