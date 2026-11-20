package com.cloud.tmc.integration.defaultImpl;

import androidx.annotation.Keep;
import com.cloud.tmc.integration.proxy.AppFactory;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.integration.structure.VirtualAppManager;
import com.cloud.tmc.integration.structure.node.AppNode;
import tc.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public class DefaultAppFactoryImpl implements AppFactory {
    @Override // com.cloud.tmc.integration.proxy.AppFactory
    public AppNode createApp() {
        return new AppNode((AppManager) a.a(AppManager.class));
    }

    @Override // com.cloud.tmc.integration.proxy.AppFactory
    public AppNode createVirtualApp() {
        return new AppNode((AppManager) a.a(VirtualAppManager.class));
    }
}
