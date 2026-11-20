package com.cloud.tmc.integration.permission.proxy;

import androidx.annotation.Nullable;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.permission.ApiPermissionCheckResult;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.bridge.NativeCallContext;
import com.cloud.tmc.kernel.model.permission.PermissionModel;
import dd.f;
import java.util.List;
import java.util.Map;
import mc.a;
import zb.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@c("")
public interface AuthenticationProxy {
    boolean checkEventPermission(String str, String str2, Page page);

    ApiPermissionCheckResult checkJSApi(f fVar, NativeCallContext nativeCallContext, a aVar, App app);

    boolean checkSPJSApi(f fVar, NativeCallContext nativeCallContext, a aVar, App app);

    boolean checkShowPermissionDialog(f fVar, NativeCallContext nativeCallContext, a aVar, Page page);

    void clearPermissionModel(String str);

    Map<String, Boolean> getAllPermissions(String str, String str2, @Nullable AppModel appModel);

    PermissionModel getPermissionModel(String str);

    List<f> getPermissions(String str);

    boolean hasPermission(String str, String str2, String str3, Page page);

    boolean hasPermissionModel(String str, Page page);

    void setPermissionModel(String str, PermissionModel permissionModel);

    void setPermissionState(String str, String str2, String str3, boolean z11);
}
