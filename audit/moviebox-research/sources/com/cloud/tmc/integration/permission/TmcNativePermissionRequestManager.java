package com.cloud.tmc.integration.permission;

import androidx.collection.w0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TmcNativePermissionRequestManager implements TmcNativePermissionRequestProxy {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w0<IPermissionRequestCallback> f30893b = new w0<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f30892a = 0;

    @Override // com.cloud.tmc.integration.permission.TmcNativePermissionRequestProxy
    public void addPermRequestCallback(int i11, IPermissionRequestCallback iPermissionRequestCallback) {
        w0<IPermissionRequestCallback> w0Var = this.f30893b;
        if (w0Var != null) {
            w0Var.m(i11, iPermissionRequestCallback);
        }
    }

    @Override // com.cloud.tmc.integration.permission.TmcNativePermissionRequestProxy
    public int getRequestCode() {
        Integer numValueOf;
        synchronized (this) {
            numValueOf = Integer.valueOf(this.f30892a.intValue() + 1);
            this.f30892a = numValueOf;
        }
        return numValueOf.intValue();
    }

    @Override // com.cloud.tmc.integration.permission.TmcNativePermissionRequestProxy
    public void onRequestPermissionResult(int i11, String[] strArr, int[] iArr) {
        IPermissionRequestCallback iPermissionRequestCallbackG;
        w0<IPermissionRequestCallback> w0Var = this.f30893b;
        if (w0Var == null || (iPermissionRequestCallbackG = w0Var.g(i11)) == null) {
            return;
        }
        iPermissionRequestCallbackG.onRequestPermissionResult(i11, strArr, iArr);
        this.f30893b.n(i11);
    }
}
