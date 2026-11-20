package com.cloud.tmc.kernel.coreimpl.eventcenter;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.coreimpl.eventcenter.DefaultEventCenterFactory;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import java.util.HashMap;
import java.util.Map;
import uc.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultEventCenterFactory implements IEventCenterFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, a> f31184a = new HashMap(16);

    @Nullable
    public static a b(final String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (f31184a.get(str) == null) {
            synchronized (a.class) {
                try {
                    if (f31184a.get(str) == null) {
                        f31184a.put(str, new a(new a.InterfaceC0341a() { // from class: fc.b
                            @Override // com.cloud.tmc.kernel.coreimpl.eventcenter.a.InterfaceC0341a
                            public final void onDestroy() {
                                DefaultEventCenterFactory.c(str);
                            }
                        }));
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f31184a.get(str);
    }

    public static /* synthetic */ void c(String str) {
        f31184a.remove(str);
    }

    @Override // com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory
    public void clearEventCenterInstance(Node node) {
        if (node == null) {
            return;
        }
        synchronized (a.class) {
            try {
                a aVarRemove = f31184a.remove(node.getNodeId() + "");
                if (aVarRemove != null) {
                    aVarRemove.destroy();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory
    public uc.a createEvent(String str) {
        return new fc.a(str);
    }

    @Override // com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory
    @Nullable
    public b getEventCenterInstance(Node node) {
        if (node == null) {
            return null;
        }
        return b(node.getNodeId() + "");
    }
}
