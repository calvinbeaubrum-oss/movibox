package com.cloud.tmc.miniapp.utils;

import android.content.Context;
import android.os.Bundle;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.PermissionAppInfoModel;
import com.cloud.tmc.integration.model.PermissionInfoModel;
import com.cloud.tmc.integration.model.ScopeModel;
import com.cloud.tmc.integration.permission.config.ScopePermissionHelper;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.model.permission.PermissionModel;
import com.cloud.tmc.kernel.model.permission.ScopesV2Bean;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniutils.util.k;
import com.cloud.tmc.miniutils.util.y;
import com.google.gson.reflect.TypeToken;
import h.b;
import i0.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.g;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import tc.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class ScopeUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ScopeUtils f31808a = new ScopeUtils();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f31809b = g.o("readPhotosAlbum", "userLocation", "phoneCall", "sms", "navigateTo", "bluetooth", "notifyMessage", "scanCode", "wifi", "uploadFile", "camera", "downloadFile", "openExternalApp", "navigateToOutsideBrowser", "recorder", "clipboard", "screenshot", "athena");

    public final ScopesV2Bean a(String str, ArrayList<ScopesV2Bean> arrayList) {
        Object obj = null;
        if (arrayList == null) {
            return null;
        }
        for (Object obj2 : arrayList) {
            if (Intrinsics.b(((ScopesV2Bean) obj2).getScopeName(), str)) {
                obj = obj2;
                break;
            }
        }
        return (ScopesV2Bean) obj;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final String b(String str, String str2) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1600397930:
                    if (str.equals("clipboard")) {
                        String strC = y.c(R$string.mini_permission_clipboard_content);
                        Intrinsics.f(strC, "getString(R.string.mini_…ission_clipboard_content)");
                        return strC;
                    }
                    break;
                case -1407612381:
                    if (str.equals("athena")) {
                        String strC2 = y.c(R$string.mini_permission_athena_content);
                        Intrinsics.f(strC2, "getString(R.string.mini_permission_athena_content)");
                        return strC2;
                    }
                    break;
                case -1367751899:
                    if (str.equals("camera")) {
                        String strC3 = y.c(R$string.mini_permission_camera_content);
                        Intrinsics.f(strC3, "getString(R.string.mini_permission_camera_content)");
                        return strC3;
                    }
                    break;
                case -1029520148:
                    if (str.equals("phoneCall")) {
                        String strC4 = y.c(R$string.mini_permission_phone_content);
                        Intrinsics.f(strC4, "getString(R.string.mini_permission_phone_content)");
                        return strC4;
                    }
                    break;
                case -891002358:
                    if (str.equals("scanCode")) {
                        String strC5 = y.c(R$string.mini_permission_scan_content);
                        Intrinsics.f(strC5, "getString(R.string.mini_permission_scan_content)");
                        return strC5;
                    }
                    break;
                case -799233858:
                    if (str.equals("recorder")) {
                        String strC6 = y.c(R$string.mini_permission_record_content);
                        Intrinsics.f(strC6, "getString(R.string.mini_permission_record_content)");
                        return strC6;
                    }
                    break;
                case -416447130:
                    if (str.equals("screenshot")) {
                        String strC7 = y.c(R$string.mini_permission_screenshot_content);
                        Intrinsics.f(strC7, "getString(R.string.mini_…ssion_screenshot_content)");
                        return strC7;
                    }
                    break;
                case -243495139:
                    if (str.equals("uploadFile")) {
                        String strC8 = y.c(R$string.mini_permission_upload_content);
                        Intrinsics.f(strC8, "getString(R.string.mini_permission_upload_content)");
                        return strC8;
                    }
                    break;
                case 114009:
                    if (str.equals("sms")) {
                        String strC9 = y.c(R$string.mini_permission_sms_content);
                        Intrinsics.f(strC9, "getString(R.string.mini_permission_sms_content)");
                        return strC9;
                    }
                    break;
                case 3649301:
                    if (str.equals("wifi")) {
                        String strC10 = y.c(R$string.mini_permission_wifi_content);
                        Intrinsics.f(strC10, "getString(R.string.mini_permission_wifi_content)");
                        return strC10;
                    }
                    break;
                case 706349231:
                    if (str.equals("navigateToOutsideBrowser")) {
                        String strC11 = y.c(R$string.mini_permission_open_outside_browser_content);
                        Intrinsics.f(strC11, "getString(R.string.mini_…_outside_browser_content)");
                        return strC11;
                    }
                    break;
                case 1108651556:
                    if (str.equals("downloadFile")) {
                        String strC12 = y.c(R$string.mini_permission_file_download_content);
                        Intrinsics.f(strC12, "getString(R.string.mini_…on_file_download_content)");
                        return strC12;
                    }
                    break;
                case 1133114528:
                    if (str.equals("userLocation")) {
                        String strC13 = y.c(R$string.mini_permission_location_content);
                        Intrinsics.f(strC13, "getString(R.string.mini_…mission_location_content)");
                        return strC13;
                    }
                    break;
                case 1156181118:
                    if (str.equals("notifyMessage")) {
                        String strC14 = y.c(R$string.mini_permission_notifications_permission);
                        Intrinsics.f(strC14, "getString(R.string.mini_…notifications_permission)");
                        return strC14;
                    }
                    break;
                case 1306564012:
                    if (str.equals("openExternalApp")) {
                        String strC15 = y.c(R$string.mini_permission_open_external_app_content);
                        Intrinsics.f(strC15, "getString(R.string.mini_…pen_external_app_content)");
                        return strC15;
                    }
                    break;
                case 1511637752:
                    if (str.equals("readPhotosAlbum")) {
                        String strC16 = y.c(R$string.mini_permission_media_content);
                        Intrinsics.f(strC16, "getString(R.string.mini_permission_media_content)");
                        return strC16;
                    }
                    break;
                case 1862662092:
                    if (str.equals("navigateTo")) {
                        String strC17 = y.c(R$string.mini_permission_navigate_content);
                        Intrinsics.f(strC17, "getString(R.string.mini_…mission_navigate_content)");
                        return strC17;
                    }
                    break;
                case 1968882350:
                    if (str.equals("bluetooth")) {
                        String strC18 = y.c(R$string.mini_permission_bluetooth_content);
                        Intrinsics.f(strC18, "getString(R.string.mini_…ission_bluetooth_content)");
                        return strC18;
                    }
                    break;
            }
        }
        return str2 == null ? "" : str2;
    }

    public final ArrayList<ScopesV2Bean> c(Page page) {
        App app;
        AppModel appModel;
        PermissionModel permissions;
        if (page == null || (app = page.getApp()) == null || (appModel = app.getAppModel()) == null || (permissions = appModel.getPermissions()) == null) {
            return null;
        }
        return permissions.getScopesV2();
    }

    public final Pair<Boolean, Long> d(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        try {
            return new Pair<>(Boolean.valueOf(((KVStorageProxy) a.a(KVStorageProxy.class)).getBoolean(context, "scope_storageV2", "notifyMessage" + appId, false)), Long.valueOf(((KVStorageProxy) a.a(KVStorageProxy.class)).getLong(context, "scope_storageV2", "notifyMessage" + appId + "_time")));
        } catch (Throwable th2) {
            TmcLogger.h("ScopeUtils", th2);
            return new Pair<>(Boolean.FALSE, 0L);
        }
    }

    public final void e(Context context, String str, String str2, boolean z11) {
        int iJ;
        long jM = m(context, str, str2);
        if (z11) {
            iJ = 0;
        } else {
            iJ = 1;
            if (System.currentTimeMillis() - jM <= 1800000) {
                iJ = 1 + j(context, str, str2);
            }
        }
        ((KVStorageProxy) a.a(KVStorageProxy.class)).putInt(context, "scope_storageV2", str + '_' + str2 + "_timeStamp_failed_count", iJ);
    }

    @JvmOverloads
    public final void f(Context context, String scopeName, String appId, boolean z11, String str, String str2, boolean z12, boolean z13) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Object next;
        ArrayList arrayList3;
        String str3;
        Intrinsics.g(context, "context");
        Intrinsics.g(scopeName, "scopeName");
        Intrinsics.g(appId, "appId");
        ((KVStorageProxy) a.a(KVStorageProxy.class)).putBoolean(context, "scope_storageV2", scopeName + '_' + appId, z11);
        if (z11) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            ((KVStorageProxy) a.a(KVStorageProxy.class)).putLong(context, "scope_storageV2", scopeName + '_' + appId + "_timeStamp_success", jCurrentTimeMillis);
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) a.a(PerformanceAnalyseProxy.class);
            Bundle bundle = new Bundle();
            bundle.putString("allowScopeName", scopeName);
            bundle.putLong("allowTimeStamp", jCurrentTimeMillis);
            bundle.putString("authAppId", appId);
            Unit unit = Unit.f68710a;
            performanceAnalyseProxy.recordForCommon(appId, "miniapp_permission", bundle);
            e(context, scopeName, appId, true);
        } else if (z12) {
            e(context, scopeName, appId, false);
            ((KVStorageProxy) a.a(KVStorageProxy.class)).putLong(context, "scope_storageV2", scopeName + '_' + appId + "_timeStamp_failed", System.currentTimeMillis());
        }
        Object obj = null;
        if (Intrinsics.b(scopeName, "notifyMessage")) {
            h.f66817a.c(context, appId, z11 ? "1" : "0");
        } else {
            String string = ((KVStorageProxy) a.a(KVStorageProxy.class)).getString(context, "scope_storageV2", "key_allow_scope_list_" + appId);
            if (string == null || string.length() == 0) {
                arrayList2 = new ArrayList();
            } else {
                try {
                    Object objE = k.e(string, new TypeToken<ArrayList<PermissionInfoModel>>() { // from class: com.cloud.tmc.miniapp.utils.ScopeUtils$updatePermissionMiniappScopeData$authList$1
                    }.getType());
                    Intrinsics.f(objE, "{\n                GsonUt…          )\n            }");
                    arrayList2 = (ArrayList) objE;
                } catch (Throwable unused) {
                    arrayList2 = new ArrayList();
                }
            }
            ArrayList arrayList4 = arrayList2;
            Iterator it = arrayList4.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.b(((PermissionInfoModel) next).getScopeName(), scopeName));
            PermissionInfoModel permissionInfoModel = (PermissionInfoModel) next;
            if (permissionInfoModel == null) {
                ConcurrentHashMap<String, ScopeModel> concurrentHashMap = b.f65651d;
                ScopeModel scopeModel = concurrentHashMap.get(scopeName);
                if (scopeModel == null || scopeModel.getValidityTime() != 0) {
                    Long lValueOf = Long.valueOf(System.currentTimeMillis());
                    Boolean boolValueOf = Boolean.valueOf(z11);
                    ScopeModel scopeModel2 = concurrentHashMap.get(scopeName);
                    arrayList3 = arrayList4;
                    str3 = "key_allow_scope_list_";
                    arrayList3.add(new PermissionInfoModel(scopeName, "", lValueOf, boolValueOf, scopeModel2 != null ? Long.valueOf(scopeModel2.getValidityTime()) : null));
                }
            } else {
                arrayList3 = arrayList4;
                str3 = "key_allow_scope_list_";
                ConcurrentHashMap<String, ScopeModel> concurrentHashMap2 = b.f65651d;
                ScopeModel scopeModel3 = concurrentHashMap2.get(scopeName);
                if (scopeModel3 == null || scopeModel3.getValidityTime() != 0) {
                    permissionInfoModel.setAuthStatus(Boolean.valueOf(z11));
                    permissionInfoModel.setAuthTimeStamp(Long.valueOf(System.currentTimeMillis()));
                    ScopeModel scopeModel4 = concurrentHashMap2.get(scopeName);
                    permissionInfoModel.setValidityTime(scopeModel4 != null ? Long.valueOf(scopeModel4.getValidityTime()) : null);
                } else {
                    arrayList3.remove(permissionInfoModel);
                }
            }
            ((KVStorageProxy) a.a(KVStorageProxy.class)).putString(context, "scope_storageV2", h.a.a(str3, appId), k.k(arrayList3, new TypeToken<ArrayList<PermissionInfoModel>>() { // from class: com.cloud.tmc.miniapp.utils.ScopeUtils$updatePermissionMiniappScopeData$updateAllowStr$1
            }.getType()));
        }
        ScopeModel scopeModel5 = b.f65651d.get(scopeName);
        if (scopeModel5 == null || scopeModel5.getValidityTime() != 0 || z13) {
            String string2 = ((KVStorageProxy) a.a(KVStorageProxy.class)).getString(context, "scope_storageV2", scopeName + "_key_appId_list");
            if (string2 == null || string2.length() == 0) {
                arrayList = new ArrayList();
            } else {
                try {
                    Object objE2 = k.e(string2, new TypeToken<ArrayList<PermissionAppInfoModel>>() { // from class: com.cloud.tmc.miniapp.utils.ScopeUtils$updatePermissionScopeAppIdList$appIdList$1
                    }.getType());
                    Intrinsics.f(objE2, "{\n                GsonUt…          )\n            }");
                    arrayList = (ArrayList) objE2;
                } catch (Throwable unused2) {
                    arrayList = new ArrayList();
                }
            }
            for (Object obj2 : arrayList) {
                if (Intrinsics.b(((PermissionAppInfoModel) obj2).getAppId(), appId)) {
                    obj = obj2;
                    break;
                }
            }
            PermissionAppInfoModel permissionAppInfoModel = (PermissionAppInfoModel) obj;
            if (z11) {
                if (permissionAppInfoModel == null) {
                    arrayList.add(new PermissionAppInfoModel(appId, scopeName, str, str2, Long.valueOf(System.currentTimeMillis()), Boolean.TRUE));
                    ((KVStorageProxy) a.a(KVStorageProxy.class)).putString(context, "scope_storageV2", h.a.a(scopeName, "_key_appId_list"), k.k(arrayList, new TypeToken<ArrayList<PermissionAppInfoModel>>() { // from class: com.cloud.tmc.miniapp.utils.ScopeUtils$updatePermissionScopeAppIdList$updateAllowStr$1
                    }.getType()));
                    return;
                } else {
                    permissionAppInfoModel.setAuthStatus(Boolean.TRUE);
                    ((KVStorageProxy) a.a(KVStorageProxy.class)).putString(context, "scope_storageV2", h.a.a(scopeName, "_key_appId_list"), k.k(arrayList, new TypeToken<ArrayList<PermissionAppInfoModel>>() { // from class: com.cloud.tmc.miniapp.utils.ScopeUtils$updatePermissionScopeAppIdList$updateAllowStr$2
                    }.getType()));
                    return;
                }
            }
            if (permissionAppInfoModel != null) {
                if (Intrinsics.b(scopeName, "notifyMessage")) {
                    permissionAppInfoModel.setAuthStatus(Boolean.FALSE);
                } else {
                    arrayList.remove(permissionAppInfoModel);
                }
                ((KVStorageProxy) a.a(KVStorageProxy.class)).putString(context, "scope_storageV2", h.a.a(scopeName, "_key_appId_list"), k.k(arrayList, new TypeToken<ArrayList<PermissionAppInfoModel>>() { // from class: com.cloud.tmc.miniapp.utils.ScopeUtils$updatePermissionScopeAppIdList$updateAllowStr$3
                }.getType()));
            }
        }
    }

    public final void g(ConcurrentHashMap<String, ScopeModel> SHOW_SCOPE_MAP, ConcurrentHashMap<String, String> SHOW_PERMISSION_DIALOG_API_MAP) {
        Intrinsics.g(SHOW_SCOPE_MAP, "SHOW_SCOPE_MAP");
        Intrinsics.g(SHOW_PERMISSION_DIALOG_API_MAP, "SHOW_PERMISSION_DIALOG_API_MAP");
        Object objE = k.e(ScopePermissionHelper.INSTANCE.getPresetScopeStr(), new TypeToken<ArrayList<ScopeModel>>() { // from class: com.cloud.tmc.miniapp.utils.ScopeUtils$initScopeData$defaultScopeList$1
        }.getType());
        Intrinsics.f(objE, "fromJson(\n            pr…del>>() {}.type\n        )");
        for (ScopeModel scopeModel : (ArrayList) objE) {
            String scopeName = scopeModel.getScopeName();
            if (scopeName == null) {
                scopeName = "";
            }
            SHOW_SCOPE_MAP.put(scopeName, scopeModel);
            List<String> apis = scopeModel.getApis();
            if (apis != null) {
                for (String str : apis) {
                    try {
                        String scopeName2 = scopeModel.getScopeName();
                        if (scopeName2 == null) {
                            scopeName2 = "";
                        }
                        SHOW_PERMISSION_DIALOG_API_MAP.put(str, scopeName2);
                    } catch (Throwable unused) {
                        TmcLogger.f("ScopeUtils", str + ',' + scopeModel.getScopeName());
                    }
                }
            }
        }
    }

    public final boolean h(Context context, String scopeName, long j11, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(scopeName, "scopeName");
        Intrinsics.g(appId, "appId");
        if (j11 == 0) {
            return false;
        }
        if (!((KVStorageProxy) a.a(KVStorageProxy.class)).getBoolean(context, "scope_storageV2", scopeName + '_' + appId, false)) {
            return false;
        }
        if (j11 == -1) {
            return true;
        }
        Intrinsics.g(context, "context");
        Intrinsics.g(scopeName, "scopeName");
        Intrinsics.g(appId, "appId");
        KVStorageProxy kVStorageProxy = (KVStorageProxy) a.a(KVStorageProxy.class);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(scopeName);
        sb2.append('_');
        sb2.append(appId);
        sb2.append("_timeStamp_success");
        return System.currentTimeMillis() - kVStorageProxy.getLong(context, "scope_storageV2", sb2.toString()) <= j11;
    }

    public final boolean i(Context context, String scopeName, String appId) {
        ArrayList arrayList;
        Object next;
        Intrinsics.g(context, "context");
        Intrinsics.g(scopeName, "scopeName");
        Intrinsics.g(appId, "appId");
        String string = ((KVStorageProxy) a.a(KVStorageProxy.class)).getString(context, "scope_storageV2", scopeName + "_key_appId_list");
        if (string == null || string.length() == 0) {
            arrayList = new ArrayList();
        } else {
            try {
                Object objE = k.e(string, new TypeToken<ArrayList<PermissionAppInfoModel>>() { // from class: com.cloud.tmc.miniapp.utils.ScopeUtils$checkPermissionScopeInAppList$appIdList$1
                }.getType());
                Intrinsics.f(objE, "{\n                GsonUt…          )\n            }");
                arrayList = (ArrayList) objE;
            } catch (Throwable unused) {
                arrayList = new ArrayList();
            }
        }
        Iterator it = arrayList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.b(((PermissionAppInfoModel) next).getAppId(), appId));
        return ((PermissionAppInfoModel) next) != null;
    }

    public final int j(Context context, String str, String str2) {
        return ((KVStorageProxy) a.a(KVStorageProxy.class)).getInt(context, "scope_storageV2", str + '_' + str2 + "_timeStamp_failed_count");
    }

    public final String k(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        try {
            String string = ((KVStorageProxy) a.a(KVStorageProxy.class)).getString(context, "scope_storageV2", "key_allow_scope_list_" + appId);
            return string == null ? "" : string;
        } catch (Throwable th2) {
            TmcLogger.h("ScopeUtils", th2);
            return "";
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final String l(String str, String str2) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1600397930:
                    if (str.equals("clipboard")) {
                        String strC = y.c(R$string.mini_permission_clipboard);
                        Intrinsics.f(strC, "getString(R.string.mini_permission_clipboard)");
                        return strC;
                    }
                    break;
                case -1407612381:
                    if (str.equals("athena")) {
                        String strC2 = y.c(R$string.mini_permission_athena);
                        Intrinsics.f(strC2, "getString(R.string.mini_permission_athena)");
                        return strC2;
                    }
                    break;
                case -1367751899:
                    if (str.equals("camera")) {
                        String strC3 = y.c(R$string.mini_permission_camera);
                        Intrinsics.f(strC3, "getString(R.string.mini_permission_camera)");
                        return strC3;
                    }
                    break;
                case -1029520148:
                    if (str.equals("phoneCall")) {
                        String strC4 = y.c(R$string.mini_permission_phone_desc);
                        Intrinsics.f(strC4, "getString(R.string.mini_permission_phone_desc)");
                        return strC4;
                    }
                    break;
                case -891002358:
                    if (str.equals("scanCode")) {
                        String strC5 = y.c(R$string.mini_permission_scanner);
                        Intrinsics.f(strC5, "getString(R.string.mini_permission_scanner)");
                        return strC5;
                    }
                    break;
                case -799233858:
                    if (str.equals("recorder")) {
                        String strC6 = y.c(R$string.mini_permission_record);
                        Intrinsics.f(strC6, "getString(R.string.mini_permission_record)");
                        return strC6;
                    }
                    break;
                case -416447130:
                    if (str.equals("screenshot")) {
                        String strC7 = y.c(R$string.mini_permission_screenshot);
                        Intrinsics.f(strC7, "getString(R.string.mini_permission_screenshot)");
                        return strC7;
                    }
                    break;
                case -243495139:
                    if (str.equals("uploadFile")) {
                        String strC8 = y.c(R$string.mini_permission_file_uploads);
                        Intrinsics.f(strC8, "getString(R.string.mini_permission_file_uploads)");
                        return strC8;
                    }
                    break;
                case 114009:
                    if (str.equals("sms")) {
                        String strC9 = y.c(R$string.mini_permission_sms_desc);
                        Intrinsics.f(strC9, "getString(R.string.mini_permission_sms_desc)");
                        return strC9;
                    }
                    break;
                case 3649301:
                    if (str.equals("wifi")) {
                        String strC10 = y.c(R$string.mini_permission_wifi);
                        Intrinsics.f(strC10, "getString(R.string.mini_permission_wifi)");
                        return strC10;
                    }
                    break;
                case 706349231:
                    if (str.equals("navigateToOutsideBrowser")) {
                        String strC11 = y.c(R$string.mini_permission_open_outside_browser);
                        Intrinsics.f(strC11, "getString(R.string.mini_…ion_open_outside_browser)");
                        return strC11;
                    }
                    break;
                case 1108651556:
                    if (str.equals("downloadFile")) {
                        String strC12 = y.c(R$string.mini_permission_file_download);
                        Intrinsics.f(strC12, "getString(R.string.mini_permission_file_download)");
                        return strC12;
                    }
                    break;
                case 1133114528:
                    if (str.equals("userLocation")) {
                        String strC13 = y.c(R$string.mini_permission_location_desc);
                        Intrinsics.f(strC13, "getString(R.string.mini_permission_location_desc)");
                        return strC13;
                    }
                    break;
                case 1156181118:
                    if (str.equals("notifyMessage")) {
                        String strC14 = y.c(R$string.mini_permission_notifications_content);
                        Intrinsics.f(strC14, "getString(R.string.mini_…on_notifications_content)");
                        return strC14;
                    }
                    break;
                case 1306564012:
                    if (str.equals("openExternalApp")) {
                        String strC15 = y.c(R$string.mini_permission_open_external_app);
                        Intrinsics.f(strC15, "getString(R.string.mini_…ission_open_external_app)");
                        return strC15;
                    }
                    break;
                case 1511637752:
                    if (str.equals("readPhotosAlbum")) {
                        String strC16 = y.c(R$string.mini_permission_media_desc);
                        Intrinsics.f(strC16, "getString(R.string.mini_permission_media_desc)");
                        return strC16;
                    }
                    break;
                case 1862662092:
                    if (str.equals("navigateTo")) {
                        String strC17 = y.c(R$string.mini_permission_navigate_content);
                        Intrinsics.f(strC17, "getString(R.string.mini_…mission_navigate_content)");
                        return strC17;
                    }
                    break;
                case 1968882350:
                    if (str.equals("bluetooth")) {
                        String strC18 = y.c(R$string.mini_permission_bluetooth);
                        Intrinsics.f(strC18, "getString(R.string.mini_permission_bluetooth)");
                        return strC18;
                    }
                    break;
            }
        }
        return str2 == null ? "" : str2;
    }

    public final long m(Context context, String str, String str2) {
        return ((KVStorageProxy) a.a(KVStorageProxy.class)).getLong(context, "scope_storageV2", str + '_' + str2 + "_timeStamp_failed");
    }

    public final void n(Context context, String miniappId) {
        ArrayList<PermissionInfoModel> arrayList;
        ArrayList arrayList2;
        Object next;
        Intrinsics.g(context, "context");
        Intrinsics.g(miniappId, "miniappId");
        ((KVStorageProxy) a.a(KVStorageProxy.class)).remove(context, "miniMsgProvider", "msg_switch_" + miniappId);
        ((KVStorageProxy) a.a(KVStorageProxy.class)).remove(context, "scope_storageV2", "notifyMessage_" + miniappId);
        ((KVStorageProxy) a.a(KVStorageProxy.class)).remove(context, "scope_storageV2", "notifyMessage_" + miniappId + "_timeStamp_success");
        ((KVStorageProxy) a.a(KVStorageProxy.class)).remove(context, "scope_storageV2", "notifyMessage_" + miniappId + "_timeStamp_failed");
        ((KVStorageProxy) a.a(KVStorageProxy.class)).remove(context, "scope_storageV2", "notifyMessage_" + miniappId + "_timeStamp_failed_count");
        String strK = k(context, miniappId);
        if (strK.length() == 0) {
            TmcLogger.c("ScopeUtils", "permission Data is null");
            return;
        }
        try {
            Object objE = k.e(strK, new TypeToken<ArrayList<PermissionInfoModel>>() { // from class: com.cloud.tmc.miniapp.utils.ScopeUtils$removePermissionData$authList$1
            }.getType());
            Intrinsics.f(objE, "{\n            GsonUtils.…e\n            )\n        }");
            arrayList = (ArrayList) objE;
        } catch (Throwable unused) {
            arrayList = new ArrayList();
        }
        for (PermissionInfoModel permissionInfoModel : arrayList) {
            ((KVStorageProxy) a.a(KVStorageProxy.class)).remove(context, "scope_storageV2", permissionInfoModel.getScopeName() + '_' + miniappId + "_timeStamp_success");
            ((KVStorageProxy) a.a(KVStorageProxy.class)).remove(context, "scope_storageV2", permissionInfoModel.getScopeName() + '_' + miniappId);
            ((KVStorageProxy) a.a(KVStorageProxy.class)).remove(context, "scope_storageV2", permissionInfoModel.getScopeName() + '_' + miniappId + "_timeStamp_failed");
            ((KVStorageProxy) a.a(KVStorageProxy.class)).remove(context, "scope_storageV2", permissionInfoModel.getScopeName() + '_' + miniappId + "_timeStamp_failed_count");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("remove scope permission ->");
            sb2.append(permissionInfoModel.getScopeName());
            TmcLogger.c("ScopeUtils", sb2.toString());
            String string = ((KVStorageProxy) a.a(KVStorageProxy.class)).getString(context, "scope_storageV2", permissionInfoModel.getScopeName() + "_key_appId_list");
            if (string == null || string.length() == 0) {
                arrayList2 = new ArrayList();
            } else {
                try {
                    Object objE2 = k.e(string, new TypeToken<ArrayList<PermissionAppInfoModel>>() { // from class: com.cloud.tmc.miniapp.utils.ScopeUtils$removePermissionData$1$appIdList$1
                    }.getType());
                    Intrinsics.f(objE2, "{\n                    Gs…      )\n                }");
                    arrayList2 = (ArrayList) objE2;
                } catch (Throwable unused2) {
                    arrayList2 = new ArrayList();
                }
            }
            Iterator it = arrayList2.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.b(((PermissionAppInfoModel) next).getAppId(), miniappId));
            PermissionAppInfoModel permissionAppInfoModel = (PermissionAppInfoModel) next;
            if (permissionAppInfoModel != null) {
                arrayList2.remove(permissionAppInfoModel);
                TmcLogger.c("ScopeUtils", "find and remove scope " + permissionInfoModel.getScopeName());
                String strK2 = k.k(arrayList2, new TypeToken<ArrayList<PermissionAppInfoModel>>() { // from class: com.cloud.tmc.miniapp.utils.ScopeUtils$removePermissionData$1$updateAllowStr$1
                }.getType());
                ((KVStorageProxy) a.a(KVStorageProxy.class)).putString(context, "scope_storageV2", permissionInfoModel.getScopeName() + "_key_appId_list", strK2);
            } else {
                TmcLogger.c("ScopeUtils", miniappId + " is not allow " + permissionInfoModel.getScopeName() + " scope ");
            }
        }
        ((KVStorageProxy) a.a(KVStorageProxy.class)).remove(context, "scope_storageV2", "key_allow_scope_list_" + miniappId);
    }
}
