package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.integration.proxy.ITaskQueueProxy;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.defaultimpl.TaskQueueProxyImpl;
import d0.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import p011Oooo00o.o000oOoO;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class TaskQueueProxyImpl implements ITaskQueueProxy {
    public static final void OooO00o(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.cloud.tmc.integration.proxy.ITaskQueueProxy
    public void addAppTask(String uniqueId, final Function0<Unit> function0) {
        Intrinsics.g(uniqueId, "uniqueId");
        o000oOoO o000oooo = o000oOoO.f221a;
        b task = new b(uniqueId, new Runnable() { // from class: md.j
            @Override // java.lang.Runnable
            public final void run() {
                TaskQueueProxyImpl.OooO00o(function0);
            }
        });
        Intrinsics.g(task, "task");
        try {
            o000oooo.a().b(task);
        } catch (Throwable th2) {
            TmcLogger.g("NormalTaskQueueUtils", "", th2);
        }
    }
}
