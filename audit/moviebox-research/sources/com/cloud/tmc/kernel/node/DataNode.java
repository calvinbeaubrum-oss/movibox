package com.cloud.tmc.kernel.node;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface DataNode extends Node {
    @Nullable
    <T> T getData(Class<T> cls);

    <T> T getData(Class<T> cls, boolean z11);

    @Override // com.cloud.tmc.kernel.node.Node
    /* synthetic */ dd.d getGroup();

    @Override // com.cloud.tmc.kernel.node.Node
    /* synthetic */ void inquiry(List list, dd.c.a aVar);

    <T> void setData(Class<T> cls, T t11);

    @Override // com.cloud.tmc.kernel.node.Node
    /* synthetic */ List usePermissions();
}
