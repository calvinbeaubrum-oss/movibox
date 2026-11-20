package com.cloud.tmc.miniapp.defaultimpl;

import OooO0Oo.OooO0OO;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.extension.IgnorePermissionPoint;
import com.cloud.tmc.integration.model.AppInfoScene;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.ScopeModel;
import com.cloud.tmc.integration.permission.ApiPermissionCheckResult;
import com.cloud.tmc.integration.permission.AppPermissionUtils;
import com.cloud.tmc.integration.permission.PermissionConstant;
import com.cloud.tmc.integration.permission.model.ApiPermissionInfo;
import com.cloud.tmc.integration.permission.proxy.AuthenticationProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.bridge.NativeCallContext;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.model.permission.PermissionModel;
import com.cloud.tmc.kernel.model.permission.ScopesV2Bean;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.security.DefaultPermission;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.kernel.utils.g;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.utils.ScopeUtils;
import com.google.gson.JsonObject;
import com.hisavana.common.constant.ComConstants;
import dd.f;
import h.a;
import h.b;
import hd.j;
import hd.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultAuthenticationProxyImpl implements AuthenticationProxy {

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public static String f31507OooO0o = a.a("Tmcintegration:", "DefaultAuthenticationProxyImpl");
    public Context OooO00o;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public b f31509OooO0o0;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public String f31508OooO0Oo = "";
    public Map<String, ApiPermissionInfo> OooO0O0 = new ConcurrentHashMap();
    public Map<String, PermissionModel> OooO0OO = new ConcurrentHashMap();

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add("tel");
        arrayList.add("mailto");
        arrayList.add("sms");
        arrayList.add("geo");
    }

    public DefaultAuthenticationProxyImpl(Context context) {
        this.OooO00o = context;
        this.f31509OooO0o0 = new b(context);
    }

    public final boolean OooO00o(ApiPermissionInfo apiPermissionInfo, String str, String str2) {
        if (!TextUtils.equals(str2, PermissionConstant.VALID_SUB_RES_MIME_LIST) && !str2.startsWith(PermissionConstant.JS_API_SP_CONFIG) && !TextUtils.equals(str2, PermissionConstant.EVENT_LIST) && !TextUtils.equals(str2, PermissionConstant.HTTP_LINK_SUB_RES_MIME_LIST) && !str2.startsWith(PermissionConstant.WEB_VIEW_CONFIG) && !TextUtils.equals(str2, PermissionConstant.VALID_DOMAIN)) {
            return apiPermissionInfo.getApiLevelList(str2).contains(str);
        }
        List<String> apiLevelList = apiPermissionInfo.getApiLevelList(str2);
        if (apiLevelList == null || apiLevelList.isEmpty()) {
            return false;
        }
        Iterator<String> it = apiLevelList.iterator();
        while (it.hasNext()) {
            try {
                if (Pattern.compile(it.next()).matcher(str).find()) {
                    return true;
                }
            } catch (Exception e11) {
                TmcLogger.g(f31507OooO0o, "hasPermission Regex Exception", e11);
            }
        }
        return false;
    }

    @Override // com.cloud.tmc.integration.permission.proxy.AuthenticationProxy
    public boolean checkEventPermission(String str, String str2, Page page) {
        if (this.OooO0O0.containsKey(str)) {
            return hasPermission(str, str2, PermissionConstant.EVENT_LIST, page);
        }
        return true;
    }

    @Override // com.cloud.tmc.integration.permission.proxy.AuthenticationProxy
    public ApiPermissionCheckResult checkJSApi(f permission, NativeCallContext nativeCallContext, mc.a aVar, App app) {
        String str = f31507OooO0o;
        StringBuilder sbA = j.a("checkJSApi,page i新日志##########");
        sbA.append(nativeCallContext.getSource());
        TmcLogger.c(str, sbA.toString());
        if (app == null) {
            TmcLogger.c(f31507OooO0o, "checkJSApi,page is null");
            return ApiPermissionCheckResult.DENY;
        }
        IgnorePermissionPoint ignorePermissionPoint = (IgnorePermissionPoint) ib.a.b(IgnorePermissionPoint.class).g(app).d();
        if (ignorePermissionPoint != null && ignorePermissionPoint.ignoreAppPermission(app.getAppId())) {
            TmcLogger.c(f31507OooO0o, "checkJSApi,IgnorePermissionPoint ignoreAppPermission");
            return ApiPermissionCheckResult.IGNORE;
        }
        AppModel appModel = app.getAppModel();
        if (appModel != null) {
            boolean zIsDevSource = AppInfoScene.isDevSource(app.getStartParams());
            String strD = g.d(appModel.getExtendInfos(), "checkPermission", "YES");
            if (zIsDevSource && "NO".equalsIgnoreCase(strD)) {
                TmcLogger.c(f31507OooO0o, "checkJSApi, KEY_CHECK_PERMISSION ignoreAppPermission");
                return ApiPermissionCheckResult.IGNORE;
            }
        }
        String appId = app.getAppId();
        PermissionModel permissionModel = this.OooO0OO.get(appId);
        if (permission == null || permission == DefaultPermission.ALL || permissionModel == null) {
            TmcLogger.c(f31507OooO0o, String.format("%s not have permission file", appId));
            return ApiPermissionCheckResult.IGNORE;
        }
        permissionModel.getJsapiList();
        ScopeUtils scopeUtils = ScopeUtils.f31808a;
        Intrinsics.g(permission, "permission");
        ConcurrentHashMap<String, String> concurrentHashMap = b.f65650c;
        if (!concurrentHashMap.containsKey(permission.authority())) {
            StringBuilder sbA2 = j.a(" checkJSAPI deny \t");
            sbA2.append(permission.authority());
            TmcLogger.c("ScopeUtils", sbA2.toString());
            return ApiPermissionCheckResult.DENY;
        }
        String str2 = concurrentHashMap.get(permission.authority());
        ConcurrentHashMap<String, ScopeModel> SHOW_SCOPE_MAP = b.f65651d;
        Intrinsics.f(SHOW_SCOPE_MAP, "SHOW_SCOPE_MAP");
        if (SHOW_SCOPE_MAP.get(str2) != null) {
            return ApiPermissionCheckResult.ALLOW;
        }
        StringBuilder sbA3 = j.a(" checkJSAPI deny \t");
        sbA3.append(permission.authority());
        TmcLogger.c("ScopeUtils", sbA3.toString());
        return ApiPermissionCheckResult.DENY;
    }

    @Override // com.cloud.tmc.integration.permission.proxy.AuthenticationProxy
    public boolean checkSPJSApi(f fVar, NativeCallContext nativeCallContext, mc.a aVar, App app) {
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:40:0x0104  */
    /* JADX WARN: Code duplicated, block: B:42:0x0116  */
    @Override // com.cloud.tmc.integration.permission.proxy.AuthenticationProxy
    public boolean checkShowPermissionDialog(f fVar, NativeCallContext nativeCallContext, mc.a aVar, Page page) {
        Pair<Boolean, Long> pairD;
        Long second;
        PermissionModel permissionModel = this.OooO0OO.get(page.getApp().getAppId());
        if (fVar == null || fVar == DefaultPermission.ALL || permissionModel == null) {
            TmcLogger.c(f31507OooO0o, "checkShowPermissionDialog permsionModel is null");
            return false;
        }
        b bVar = this.f31509OooO0o0;
        bVar.getClass();
        if (page.getApp() != null) {
            AppModel appModel = page.getApp().getAppModel();
            PermissionModel permissions = appModel.getPermissions();
            String appId = page.getApp().getAppId();
            String strAuthority = fVar.authority();
            if (!"0".equals(((ConfigService) tc.a.a(ConfigService.class)).getConfig("ta_permissionDialogSwitch", "1"))) {
                String scopeName = bVar.b(strAuthority);
                ScopeModel scopeModel = b.f65651d.get(scopeName);
                if (scopeModel != null) {
                    ScopeUtils scopeUtils = ScopeUtils.f31808a;
                    ArrayList<ScopesV2Bean> arrayListC = scopeUtils.c(page);
                    long validityTime = scopeModel.getValidityTime();
                    boolean userAuthorization = scopeModel.getUserAuthorization();
                    if (arrayListC != null) {
                        ScopesV2Bean scopesV2BeanA = scopeUtils.a(scopeName, arrayListC);
                        if (scopesV2BeanA == null) {
                            bVar.d(nativeCallContext, aVar, strAuthority, scopeName);
                            e.a(ExecutorType.NORMAL, new OooO0OO(bVar, scopeName, appId, appModel));
                        } else {
                            userAuthorization = scopesV2BeanA.getUserAuthorization();
                            long validityTime2 = scopesV2BeanA.getValidityTime();
                            scopeModel.setUserAuthorization(userAuthorization);
                            scopeModel.setValidityTime(validityTime2);
                            validityTime = validityTime2;
                        }
                        return true;
                    }
                    if (userAuthorization && !scopeUtils.h(bVar.f65653a, scopeName, validityTime, appId)) {
                        Context context = bVar.f65653a;
                        Intrinsics.g(context, "context");
                        Intrinsics.g(scopeName, "scopeName");
                        Intrinsics.g(appId, "appId");
                        if (Intrinsics.b(scopeName, "userLogin") || scopeUtils.j(context, scopeName, appId) < 3) {
                            if ("notifyMessage".equals(scopeName)) {
                                pairD = scopeUtils.d(bVar.f65653a, appId);
                                if (Boolean.TRUE.equals(pairD.getFirst())) {
                                    second = pairD.getSecond();
                                    if (System.currentTimeMillis() - second.longValue() < 604800000) {
                                        TmcLogger.c("Tmcintegration:LocalAuthPermissionManager", "notifyMsg scope not show again" + second);
                                        bVar.d(nativeCallContext, aVar, strAuthority, scopeName);
                                    }
                                }
                            }
                            return bVar.f(page, appId, strAuthority, nativeCallContext, aVar, permissions, false);
                        }
                        if (System.currentTimeMillis() - scopeUtils.m(context, scopeName, appId) > ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) {
                            if ("notifyMessage".equals(scopeName)) {
                                pairD = scopeUtils.d(bVar.f65653a, appId);
                                if (Boolean.TRUE.equals(pairD.getFirst())) {
                                    second = pairD.getSecond();
                                    if (System.currentTimeMillis() - second.longValue() < 604800000 && second.longValue() != 0) {
                                        TmcLogger.c("Tmcintegration:LocalAuthPermissionManager", "notifyMsg scope not show again" + second);
                                        bVar.d(nativeCallContext, aVar, strAuthority, scopeName);
                                    }
                                }
                            }
                            return bVar.f(page, appId, strAuthority, nativeCallContext, aVar, permissions, false);
                        }
                        bVar.d(nativeCallContext, aVar, strAuthority, scopeName);
                        return true;
                    }
                }
            } else {
                TmcLogger.c("Tmcintegration:LocalAuthPermissionManager", "checkShowPermissionDialog...dialogSwitch closed");
            }
        }
        return false;
    }

    @Override // com.cloud.tmc.integration.permission.proxy.AuthenticationProxy
    public void clearPermissionModel(String str) {
        if (this.OooO0O0.get(str) != null) {
            this.OooO0O0.get(str).clear();
            this.OooO0O0.remove(str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0103  */
    @Override // com.cloud.tmc.integration.permission.proxy.AuthenticationProxy
    public Map<String, Boolean> getAllPermissions(String str, String str2, @Nullable AppModel appModel) {
        if (this.f31509OooO0o0 == null) {
            this.f31509OooO0o0 = new b(this.OooO00o);
        }
        b bVar = this.f31509OooO0o0;
        bVar.getClass();
        TmcAppInfoManager tmcAppInfoManager = (TmcAppInfoManager) tc.a.a(TmcAppInfoManager.class);
        if (appModel == null) {
            appModel = tmcAppInfoManager.getAppModel(bVar.f65653a, lb.a.b(str2));
        }
        HashMap map = new HashMap();
        if (appModel != null && appModel.getPermissions() != null && appModel.getPermissions().getNativeApiScopeConfig() != null) {
            JsonObject nativeApiScopeConfig = appModel.getPermissions().getNativeApiScopeConfig();
            String aggregationMainAppId = AppPermissionUtils.getAggregationMainAppId(appModel);
            for (String str3 : nativeApiScopeConfig.keySet()) {
                String strC = bVar.c(str2, str3);
                String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(bVar.f65653a, str2, strC);
                TmcLogger.c("Tmcintegration:LocalAuthPermissionManager", "isThePermissionApplied,key: " + strC + ",value: " + string);
                if (TextUtils.isEmpty(string) && !TextUtils.isEmpty(aggregationMainAppId)) {
                    string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(bVar.f65653a, str2, bVar.c(aggregationMainAppId, str3));
                }
                boolean z11 = true;
                if (!TextUtils.isEmpty(string)) {
                    String strC2 = bVar.c(str2, str3);
                    String string2 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(bVar.f65653a, str2, strC2);
                    TmcLogger.c("Tmcintegration:LocalAuthPermissionManager", "getPermissionByKey,key: " + strC2 + ",value: " + string2);
                    if (!TextUtils.equals(string2, "1")) {
                        if (TextUtils.isEmpty(aggregationMainAppId)) {
                            z11 = false;
                        } else {
                            if (!TextUtils.equals(((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(bVar.f65653a, str2, bVar.c(aggregationMainAppId, str3)), "1")) {
                                z11 = false;
                            }
                        }
                    }
                    map.put(str3, Boolean.valueOf(z11));
                }
            }
        }
        return map;
    }

    @Override // com.cloud.tmc.integration.permission.proxy.AuthenticationProxy
    public PermissionModel getPermissionModel(String str) {
        return this.OooO0OO.get(str);
    }

    @Override // com.cloud.tmc.integration.permission.proxy.AuthenticationProxy
    public List<f> getPermissions(String str) {
        List<String> jsapiList;
        PermissionModel permissionModel = this.OooO0OO.get(str);
        if (permissionModel == null || (jsapiList = permissionModel.getJsapiList()) == null || jsapiList.size() <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(jsapiList.size());
        for (String str2 : jsapiList) {
            arrayList.add(new kc.b(str2, str2));
        }
        return arrayList;
    }

    @Override // com.cloud.tmc.integration.permission.proxy.AuthenticationProxy
    public boolean hasPermission(String str, String str2, String str3, Page page) {
        Map<String, ApiPermissionInfo> map;
        TmcLogger.c(f31507OooO0o, "hasPermission " + str + " " + str2 + " " + str3);
        IgnorePermissionPoint ignorePermissionPoint = (IgnorePermissionPoint) ib.a.b(IgnorePermissionPoint.class).g(page.getApp()).d();
        if (ignorePermissionPoint != null && ignorePermissionPoint.ignoreAppPermission(str)) {
            k.a("ignore hasPermission appid\t ", str, f31507OooO0o);
            return true;
        }
        try {
            ApiPermissionInfo apiPermissionInfo = null;
            if (!TextUtils.isEmpty(this.f31508OooO0Oo)) {
                JsonObject jsonObjectE = g.e(this.f31508OooO0Oo);
                JsonObject jsonObjectB = g.b(jsonObjectE, str, null);
                if (jsonObjectB == null || jsonObjectB.size() == 0) {
                    if ("yes".equalsIgnoreCase(g.c(jsonObjectE, str3))) {
                        return true;
                    }
                } else if ("yes".equalsIgnoreCase(g.c(jsonObjectB, str3))) {
                    return true;
                }
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && (map = this.OooO0O0) != null && map.get(str) != null && this.OooO0O0.get(str).getApiLevelList(str3) != null && !this.OooO0O0.get(str).getApiLevelList(str3).isEmpty()) {
                apiPermissionInfo = this.OooO0O0.get(str);
            }
            return apiPermissionInfo == null ? str3.startsWith(PermissionConstant.JS_API_SP_CONFIG) : OooO00o(apiPermissionInfo, str2, str3);
        } catch (Exception e11) {
            TmcLogger.g(f31507OooO0o, "hasPermission Exception!", e11);
            return true;
        }
    }

    @Override // com.cloud.tmc.integration.permission.proxy.AuthenticationProxy
    public boolean hasPermissionModel(String str, Page page) {
        if (TextUtils.isEmpty(str)) {
            str = page.getApp().getAppId();
        }
        return this.OooO0OO.containsKey(str);
    }

    @Override // com.cloud.tmc.integration.permission.proxy.AuthenticationProxy
    public void setPermissionModel(String str, PermissionModel permissionModel) {
        this.OooO0OO.put(str, permissionModel);
        this.OooO0O0.put(str, AppPermissionUtils.convert2ApiPermissionInfo(permissionModel));
    }

    @Override // com.cloud.tmc.integration.permission.proxy.AuthenticationProxy
    public void setPermissionState(String str, String str2, String str3, boolean z11) {
        if (this.f31509OooO0o0 == null) {
            this.f31509OooO0o0 = new b(this.OooO00o);
        }
        AppModel appModel = ((TmcAppInfoManager) tc.a.a(TmcAppInfoManager.class)).getAppModel(this.OooO00o, lb.a.b(str2));
        b bVar = this.f31509OooO0o0;
        String aggregationMainAppId = AppPermissionUtils.getAggregationMainAppId(appModel);
        bVar.getClass();
        if ("userLogin".equals(str3)) {
            return;
        }
        String strC = TextUtils.isEmpty(aggregationMainAppId) ? bVar.c(str2, str3) : bVar.c(aggregationMainAppId, str3);
        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(bVar.f65653a, str2, strC, z11 ? "1" : "0");
        TmcLogger.c("Tmcintegration:LocalAuthPermissionManager", "changePermissionState,key: " + strC + ",opened: " + z11);
    }
}
