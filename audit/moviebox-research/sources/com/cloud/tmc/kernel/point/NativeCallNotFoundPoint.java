package com.cloud.tmc.kernel.point;

import com.cloud.tmc.kernel.bridge.NativeCallContext;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.c;
import mc.a;
import zb.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface NativeCallNotFoundPoint extends c {
    @e(ExecutorType.SYNC)
    boolean handleNotFound(NativeCallContext nativeCallContext, a aVar);

    @Override // com.cloud.tmc.kernel.extension.c
    /* synthetic */ void onFinalized();

    @Override // com.cloud.tmc.kernel.extension.c
    /* synthetic */ void onInitialized();
}
