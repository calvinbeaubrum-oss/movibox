package com.cloud.tmc.kernel.node;

import com.cloud.tmc.kernel.node.Node;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface c<T extends Node> {
    Class<T> getNodeType();

    void setNode(WeakReference<T> weakReference);
}
