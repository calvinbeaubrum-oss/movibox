package com.cloud.tmc.integration.invoke.extension;

import com.cloud.tmc.integration.permission.AppPermissionManager;
import com.cloud.tmc.integration.permission.PermissionManager;
import com.cloud.tmc.integration.permission.model.TmcGroupInit;
import com.cloud.tmc.integration.permission.proxy.AuthenticationProxy;
import com.cloud.tmc.integration.permission.whitelist.BridgeWhiteList;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.bridge.NativeCallContext;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.c;
import com.cloud.tmc.kernel.point.BridgeAccessPoint;
import dd.d;
import dd.e;
import dd.f;
import java.lang.ref.WeakReference;
import java.util.List;
import mc.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class BridgeAccessExtension implements BridgeAccessPoint, c<Page> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PermissionManager f30808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<Page> f30809b;

    public BridgeAccessExtension() {
        TmcGroupInit.init();
    }

    @Override // com.cloud.tmc.kernel.point.BridgeAccessPoint
    public boolean asyncCheckPermission(f fVar, dd.c cVar, NativeCallContext nativeCallContext, a aVar) {
        boolean zAsyncCheckPermission = this.f30808a.asyncCheckPermission(fVar, cVar, nativeCallContext, aVar);
        TmcLogger.c(":Permission", nativeCallContext.getId() + "|" + fVar.authority() + "|accessor" + cVar.hashCode() + "#async check permission result=" + zAsyncCheckPermission);
        return zAsyncCheckPermission;
    }

    @Override // com.cloud.tmc.kernel.point.BridgeAccessPoint
    public boolean bizCheckPermission(f fVar, dd.c cVar, NativeCallContext nativeCallContext, a aVar) {
        boolean zBizCheckPermission = this.f30808a.bizCheckPermission(fVar, cVar, nativeCallContext, aVar);
        TmcLogger.c(":Permission", nativeCallContext.getId() + "____" + fVar.authority() + "____accessor" + cVar.hashCode() + "#biz check permission result=" + zBizCheckPermission);
        return zBizCheckPermission;
    }

    @Override // com.cloud.tmc.kernel.point.BridgeAccessPoint
    public boolean checkPermission(f fVar, dd.c cVar, NativeCallContext nativeCallContext, a aVar) {
        boolean zCheckPermission = this.f30808a.checkPermission(fVar, cVar, nativeCallContext, aVar);
        TmcLogger.c(":Permission", nativeCallContext.getId() + "____" + fVar.authority() + "____accessor" + cVar.hashCode() + "____check permission result=" + zCheckPermission);
        return zCheckPermission;
    }

    @Override // com.cloud.tmc.kernel.node.c
    public Class getNodeType() {
        return Page.class;
    }

    @Override // com.cloud.tmc.kernel.point.BridgeAccessPoint
    public d manageAccessorGroup(dd.c cVar) {
        TmcGroupInit.init();
        d dVarManageAccessorGroup = this.f30808a.manageAccessorGroup(cVar);
        TmcLogger.c(":Permission", "accessor" + cVar.hashCode() + " group=" + dVarManageAccessorGroup.groupName());
        return dVarManageAccessorGroup;
    }

    @Override // com.cloud.tmc.kernel.point.BridgeAccessPoint
    public List<f> manageAccessorPermissions(dd.c cVar) {
        List<f> listManageAccessorPermissions = this.f30808a.manageAccessorPermissions(cVar);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("accessor");
        sb2.append(cVar.hashCode());
        sb2.append(" permission list size=");
        sb2.append(listManageAccessorPermissions == null ? "0" : Integer.valueOf(listManageAccessorPermissions.size()));
        TmcLogger.c(":Permission", sb2.toString());
        return listManageAccessorPermissions;
    }

    @Override // com.cloud.tmc.kernel.point.BridgeAccessPoint
    public boolean needPermissionCheck(dd.c cVar, List<? extends e> list) {
        if (this.f30808a == null) {
            AppPermissionManager appPermissionManager = new AppPermissionManager(null);
            this.f30808a = appPermissionManager;
            appPermissionManager.init(cVar);
        }
        if (list != null && list.size() > 0) {
            for (e eVar : list) {
                if (eVar.permit() != null && BridgeWhiteList.isInWhiteList(eVar.permit().authority())) {
                    return false;
                }
            }
        }
        WeakReference<Page> weakReference = this.f30809b;
        if (weakReference == null || weakReference.get() == null || this.f30809b.get().getApp() == null || ((AuthenticationProxy) tc.a.a(AuthenticationProxy.class)).hasPermissionModel(this.f30809b.get().getApp().getAppId(), this.f30809b.get())) {
            return true;
        }
        TmcLogger.c(":Permission", "accessor" + cVar.hashCode() + " dont have permission model");
        return false;
    }

    @Override // com.cloud.tmc.kernel.point.BridgeAccessPoint, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.point.BridgeAccessPoint, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.kernel.node.c
    public void setNode(WeakReference<Page> weakReference) {
        this.f30809b = weakReference;
    }
}
