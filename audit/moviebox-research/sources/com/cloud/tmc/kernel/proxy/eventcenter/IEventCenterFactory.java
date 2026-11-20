package com.cloud.tmc.kernel.proxy.eventcenter;

import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.node.Node;
import uc.a;
import uc.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface IEventCenterFactory {
    void clearEventCenterInstance(Node node);

    a createEvent(String str);

    @Nullable
    b getEventCenterInstance(Node node);
}
