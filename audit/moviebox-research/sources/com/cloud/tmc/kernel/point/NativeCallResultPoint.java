package com.cloud.tmc.kernel.point;

import com.cloud.tmc.kernel.bridge.NativeCallContext;
import com.cloud.tmc.kernel.extension.c;
import com.google.gson.JsonObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface NativeCallResultPoint extends c {
    @Override // com.cloud.tmc.kernel.extension.c
    /* synthetic */ void onFinalized();

    @Override // com.cloud.tmc.kernel.extension.c
    /* synthetic */ void onInitialized();

    void onSendBack(NativeCallContext nativeCallContext, JsonObject jsonObject);
}
