package com.cloud.tmc.integration.proxy;

import com.cloud.tmc.integration.structure.node.AppNode;
import zb.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@c("com.cloud.tmc.integration.defaultImpl.DefaultAppFactoryImpl")
public interface AppFactory {
    AppNode createApp();

    AppNode createVirtualApp();
}
