package com.cloud.tmc.kernel.proxy.core;

import com.cloud.tmc.kernel.engine.IEngine;
import com.cloud.tmc.kernel.node.Node;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface IEngineFactory {
    IEngine createEngine(String str, Node node, String str2);

    String getEngineType(String str);
}
