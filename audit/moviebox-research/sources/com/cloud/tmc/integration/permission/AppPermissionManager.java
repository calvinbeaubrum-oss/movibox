package com.cloud.tmc.integration.permission;

import com.cloud.tmc.integration.permission.api.TmcGroup;
import com.cloud.tmc.integration.permission.proxy.AuthenticationProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.bridge.NativeCallContext;
import com.cloud.tmc.kernel.log.TmcLogger;
import dd.c;
import dd.d;
import dd.f;
import java.util.ArrayList;
import java.util.List;
import mc.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class AppPermissionManager implements PermissionManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f30882d = "Tmcintegration:" + AppPermissionManager.class.getSimpleName();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static List<String> f30883e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AuthenticationProxy f30884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BizPermissionManager f30885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f30886c;

    static {
        ArrayList arrayList = new ArrayList();
        f30883e = arrayList;
        arrayList.add("registerWorker");
        f30883e.add("getPackageFile");
    }

    public AppPermissionManager(BizPermissionManager bizPermissionManager) {
        this.f30885b = bizPermissionManager;
    }

    @Override // com.cloud.tmc.integration.permission.PermissionManager
    public boolean asyncCheckPermission(f fVar, c cVar, NativeCallContext nativeCallContext, a aVar) {
        if (!(cVar instanceof Page)) {
            return false;
        }
        return this.f30884a.checkShowPermissionDialog(fVar, nativeCallContext, aVar, (Page) cVar);
    }

    @Override // com.cloud.tmc.integration.permission.PermissionManager
    public boolean bizCheckPermission(f fVar, c cVar, NativeCallContext nativeCallContext, a aVar) {
        BizPermissionManager bizPermissionManager = this.f30885b;
        if (bizPermissionManager != null && !bizPermissionManager.checkBizParamPermission(fVar.authority(), this.f30886c, nativeCallContext.getParams())) {
            TmcLogger.c(f30882d, fVar.authority() + " is not supported by param!");
            if (aVar != null) {
                aVar.l(2, fVar.authority() + " is not supported by param!");
            }
        }
        return false;
    }

    @Override // com.cloud.tmc.integration.permission.PermissionManager
    public boolean checkPermission(f fVar, c cVar, NativeCallContext nativeCallContext, a aVar) {
        if (f30883e.contains(nativeCallContext.getName())) {
            TmcLogger.c(f30882d, "checkPermission skip white list! " + nativeCallContext.getName());
            return true;
        }
        boolean z11 = cVar instanceof Page;
        if (!z11 && !(cVar instanceof App)) {
            return false;
        }
        App app = cVar instanceof App ? (App) cVar : null;
        if (z11) {
            app = ((Page) cVar).getApp();
        }
        ApiPermissionCheckResult apiPermissionCheckResultCheckJSApi = this.f30884a.checkJSApi(fVar, nativeCallContext, aVar, app);
        if (ApiPermissionCheckResult.ALLOW == apiPermissionCheckResultCheckJSApi) {
            TmcLogger.c(f30882d, "checkPermission allowed:\t " + nativeCallContext.getName());
            return this.f30884a.checkSPJSApi(fVar, nativeCallContext, aVar, app);
        }
        if (ApiPermissionCheckResult.IGNORE != apiPermissionCheckResultCheckJSApi) {
            return false;
        }
        TmcLogger.c(f30882d, "checkPermission ignored:\t " + nativeCallContext.getName());
        return true;
    }

    @Override // com.cloud.tmc.integration.permission.PermissionManager
    public void init(c cVar) {
        this.f30886c = AppPermissionUtils.getPermissionAppId(cVar);
        this.f30884a = (AuthenticationProxy) tc.a.a(AuthenticationProxy.class);
    }

    @Override // com.cloud.tmc.integration.permission.PermissionManager
    public d manageAccessorGroup(c cVar) {
        return TmcGroup.LEVEL_APP_DEFAULT;
    }

    @Override // com.cloud.tmc.integration.permission.PermissionManager
    public List<f> manageAccessorPermissions(c cVar) {
        return this.f30884a.getPermissions(this.f30886c);
    }
}
