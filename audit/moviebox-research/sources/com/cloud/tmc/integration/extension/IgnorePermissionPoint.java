package com.cloud.tmc.integration.extension;

import com.cloud.tmc.kernel.extension.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface IgnorePermissionPoint extends c {
    boolean ignoreAppPermission(String str);

    @Override // com.cloud.tmc.kernel.extension.c
    /* synthetic */ void onFinalized();

    @Override // com.cloud.tmc.kernel.extension.c
    /* synthetic */ void onInitialized();
}
