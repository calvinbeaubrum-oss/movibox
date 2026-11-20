package com.cloud.tmc.kernel.node;

import android.os.Parcelable;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface Node extends dd.c, Parcelable {
    void addFixedView(View view);

    @Nullable
    <T extends Node> T bubbleFindNode(Class<T> cls);

    Node getChild(long j11);

    Node getChildAt(int i11);

    int getChildCount();

    /* synthetic */ dd.d getGroup();

    int getIndexOfChild(Node node);

    long getNodeId();

    Node getParentNode();

    /* synthetic */ void inquiry(List list, dd.c.a aVar);

    boolean isChildless();

    void onFinalized();

    void onInitialized();

    Node peekChild();

    Node popChild();

    void pushChild(Node node);

    boolean removeChild(Node node);

    void setParentNode(Node node);

    /* synthetic */ List usePermissions();
}
