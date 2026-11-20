package com.cloud.tmc.kernel.utils;

import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class k {
    public static void a(Node node, com.cloud.tmc.kernel.extension.c cVar) {
        com.cloud.tmc.kernel.node.c cVar2;
        Class nodeType;
        if (!(cVar instanceof com.cloud.tmc.kernel.node.c) || (nodeType = (cVar2 = (com.cloud.tmc.kernel.node.c) cVar).getNodeType()) == null) {
            return;
        }
        for (Node parentNode = node; parentNode != null; parentNode = parentNode.getParentNode()) {
            if (nodeType.isAssignableFrom(parentNode.getClass())) {
                cVar2.setNode(new WeakReference(parentNode));
                return;
            }
        }
        TmcLogger.o("TmcKernel:ExtensionInvoker:Aware", "cannot find Wanted node type: " + nodeType + " with target node: " + node + " in extension " + cVar);
    }
}
