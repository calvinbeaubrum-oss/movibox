package com.cloud.tmc.miniapp.prepare.steps;

import androidx.annotation.CallSuper;
import com.cloud.tmc.integration.proxy.FileProxy;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.miniapp.prepare.controller.PrepareController;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.prepare.manager.TmcResourceManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f31599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TmcAppInfoManager f31600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TmcResourceManager f31601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PathProxy f31602d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FileProxy f31603e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f31604f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f31605g = false;

    @Override // com.cloud.tmc.miniapp.prepare.steps.w
    public boolean OooO00o() {
        return this.f31605g;
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.w
    @CallSuper
    public void a(PrepareController prepareController, lb.g gVar, c0 c0Var) throws PrepareException {
        this.f31600b = (TmcAppInfoManager) tc.a.a(TmcAppInfoManager.class);
        this.f31601c = (TmcResourceManager) tc.a.a(TmcResourceManager.class);
        this.f31602d = (PathProxy) tc.a.a(PathProxy.class);
        this.f31603e = (FileProxy) tc.a.a(FileProxy.class);
        if (this.f31600b == null) {
            throw new PrepareException("0", "ERROR_UNKNOWN with appInfoManager == null");
        }
        if (gVar == null) {
            throw new PrepareException("0", "ERROR_UNKNOWN with context == null");
        }
        if (this.f31604f) {
            return;
        }
        this.f31604f = true;
        StringBuilder sbA = hd.j.a("Tmcresource:PrepareStep_");
        sbA.append(gVar.c());
        sbA.append("_");
        sbA.append(b());
        this.f31599a = sbA.toString();
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.w
    public void c(PrepareController prepareController, lb.g gVar, c0 c0Var) {
    }

    @Override // com.cloud.tmc.miniapp.prepare.steps.w
    public void finish() {
        this.f31605g = true;
    }
}
