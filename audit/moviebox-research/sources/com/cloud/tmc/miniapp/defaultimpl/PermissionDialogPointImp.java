package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.integration.point.PermissionDialogPoint;
import kotlin.jvm.internal.Intrinsics;
import ua.p;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class PermissionDialogPointImp implements PermissionDialogPoint {
    public p OooO00o;

    @Override // com.cloud.tmc.integration.point.PermissionDialogPoint, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.integration.point.PermissionDialogPoint, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.integration.point.PermissionDialogPoint
    public void privacyDialogDismiss(String appId, long j11) {
        Intrinsics.g(appId, "appId");
        p pVar = this.OooO00o;
        if (pVar != null) {
            pVar.a(appId, j11);
        }
    }

    @Override // com.cloud.tmc.integration.point.PermissionDialogPoint
    public void registerCallback(p privacyCallback) {
        Intrinsics.g(privacyCallback, "privacyCallback");
        this.OooO00o = privacyCallback;
    }
}
