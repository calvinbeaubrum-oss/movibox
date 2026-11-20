package com.cloud.tmc.miniapp.debug;

import com.cloud.tmc.kernel.debug.IDebugManager;
import com.cloud.tmc.miniapp.widget.s;
import hc.a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class DebugManager implements IDebugManager {
    public final Map<Object, a> OooO00o = new LinkedHashMap();

    @Override // com.cloud.tmc.kernel.debug.IDebugManager
    public void addObserver(Object tag, a target) {
        Intrinsics.g(tag, "tag");
        Intrinsics.g(target, "target");
        this.OooO00o.put(tag, target);
    }

    @Override // com.cloud.tmc.kernel.debug.IDebugManager
    public void notifyObserver() {
        if (this.OooO00o.size() != 1) {
            s.a("当前非主页，不支chrome/inspect 刷新");
            return;
        }
        Iterator<T> it = this.OooO00o.values().iterator();
        while (it.hasNext()) {
            ((a) it.next()).f();
        }
    }

    @Override // com.cloud.tmc.kernel.debug.IDebugManager
    public void removeObserver(Object tag) {
        Intrinsics.g(tag, "tag");
        this.OooO00o.remove(tag);
    }
}
