package com.cloud.tmc.kernel.extension;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface BridgeExtension extends c, dd.e {
    void callbackFail(bc.a aVar, String str, Boolean bool);

    @Override // com.cloud.tmc.kernel.extension.c
    /* synthetic */ void onFinalized();

    @Override // com.cloud.tmc.kernel.extension.c
    /* synthetic */ void onInitialized();

    /* synthetic */ dd.f permit();
}
