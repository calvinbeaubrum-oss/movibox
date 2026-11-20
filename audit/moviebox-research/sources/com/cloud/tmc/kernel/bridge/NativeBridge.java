package com.cloud.tmc.kernel.bridge;

import ac.c;
import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.engine.EngineRouter;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface NativeBridge {
    void bindEngineRouter(EngineRouter engineRouter);

    void release();

    boolean sendToNative(NativeCallContext nativeCallContext, @Nullable c cVar);

    boolean sendToNative(NativeCallContext nativeCallContext, @Nullable c cVar, boolean z11);
}
