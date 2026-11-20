package com.cloud.tmc.kernel.ipc;

import androidx.annotation.Nullable;
import zb.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@c("")
public interface RemoteCallerProxy {
    @Nullable
    <T> T getRemoteCaller(Class<T> cls);

    <T> void registerServiceBean(Class<T> cls, T t11);
}
