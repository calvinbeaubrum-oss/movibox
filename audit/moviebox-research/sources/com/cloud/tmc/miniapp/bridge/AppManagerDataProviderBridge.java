package com.cloud.tmc.miniapp.bridge;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import bc.a;
import cc.c;
import cc.f;
import cc.g;
import com.cloud.tmc.integration.model.AppStoreInfo;
import com.cloud.tmc.integration.model.PermissionInfoModel;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.integration.utils.LatestUseUtils;
import com.cloud.tmc.integration.utils.a0;
import com.cloud.tmc.integration.utils.z;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.o;
import com.cloud.tmc.miniapp.ui.AppBrandProfileActivity;
import com.cloud.tmc.miniapp.utils.ScopeUtils;
import com.cloud.tmc.miniutils.util.k;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import i0.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.d;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import tb.b;
import zb.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class AppManagerDataProviderBridge implements BridgeExtension {
    public final String OooO00o = "AppManagerDataProviderBridge";
    public final String OooO0O0 = "appList";

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void changeAutoUpdateStatus(@f(App.class) App app, @g({NotificationCompat.CATEGORY_STATUS}) boolean z11, @c a aVar) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                b appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putBoolean(context, "miniLauncherGlobal", "miniAutoUpdateStatus", z11);
                    if (aVar != null) {
                        aVar.g();
                        unit = Unit.f68710a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.h(this.OooO00o, th2);
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
        }
        if (aVar != null) {
            aVar.b();
            Unit unit2 = Unit.f68710a;
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void changeMiniappPermission(@f(App.class) App app, @g({"miniappId"}) String miniappId, @g({"scopeName"}) String scopeName, @g({NotificationCompat.CATEGORY_STATUS}) boolean z11, @c a aVar) {
        Context context;
        Unit unit;
        Intrinsics.g(miniappId, "miniappId");
        Intrinsics.g(scopeName, "scopeName");
        if (app != null) {
            try {
                b appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    ScopeUtils.f31808a.f(context, scopeName, miniappId, z11, "", "", false, true);
                    if (aVar != null) {
                        aVar.g();
                        unit = Unit.f68710a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.h(this.OooO00o, th2);
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
        }
        if (aVar != null) {
            aVar.b();
            Unit unit2 = Unit.f68710a;
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void changeMsgSwitchStatus(@f(App.class) App app, @g({"miniappId"}) String miniappId, @g({"appSwitchStatus"}) String appSwitchStatus, @c a aVar) {
        b appContext;
        Context context;
        Unit unit;
        Intrinsics.g(miniappId, "miniappId");
        Intrinsics.g(appSwitchStatus, "appSwitchStatus");
        if (app != null && (appContext = app.getAppContext()) != null && (context = appContext.getContext()) != null) {
            h.f66817a.c(context, miniappId, appSwitchStatus);
            if (aVar != null) {
                aVar.g();
                unit = Unit.f68710a;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        if (aVar != null) {
            aVar.b();
            Unit unit2 = Unit.f68710a;
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void changePrefetchState(@f(App.class) App app, @g({NotificationCompat.CATEGORY_STATUS}) int i11, @c a aVar) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                b appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putInt(context, "miniLauncherGlobal", "miniPrefetchStatus", i11);
                    ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putLong(context, "miniLauncherGlobal", "miniPrefetchTimestamp", System.currentTimeMillis());
                    if (aVar != null) {
                        aVar.g();
                        unit = Unit.f68710a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.h(this.OooO00o, th2);
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
        }
        if (aVar != null) {
            aVar.b();
            Unit unit2 = Unit.f68710a;
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void changeTotalMsgStatus(@f(App.class) App app, @g({"mainSwitchStatus"}) String status, @c a callback) {
        Unit unit;
        Context context;
        Intrinsics.g(app, "app");
        Intrinsics.g(status, "status");
        Intrinsics.g(callback, "callback");
        b appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("mainSwitchStatus", status);
            jsonObject.addProperty("mainSwitchTimestamp", String.valueOf(System.currentTimeMillis()));
            TmcLogger.c(this.OooO00o, "changeTotalMsgStatus: " + jsonObject);
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(context, "miniMsgProvider", "mainMsgSwitch", jsonObject.toString());
            callback.g();
            unit = Unit.f68710a;
        }
        if (unit == null) {
            callback.b();
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void clearAllMiniAppCacheData(@f(App.class) App app, @c a callback) {
        Unit unit;
        Context context;
        Intrinsics.g(app, "app");
        Intrinsics.g(callback, "callback");
        b appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            FileUtil.f31012a.o(context);
            callback.d(new JsonObject());
            unit = Unit.f68710a;
        }
        if (unit == null) {
            callback.b();
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void clearAllMiniAppData(@f(App.class) App app, @c a callback) {
        Unit unit;
        Context context;
        Intrinsics.g(app, "app");
        Intrinsics.g(callback, "callback");
        b appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            FileUtil.f31012a.p(context);
            callback.d(new JsonObject());
            unit = Unit.f68710a;
        }
        if (unit == null) {
            callback.b();
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void clearCacheMsgData(@f(App.class) App app, @c a aVar) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                b appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    TmcLogger.c(this.OooO00o, "clearCacheMsgData");
                    ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).clear(context, "miniMsgCacheData");
                    if (aVar != null) {
                        aVar.g();
                        unit = Unit.f68710a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.h(this.OooO00o, th2);
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
        }
        if (aVar != null) {
            aVar.b();
            Unit unit2 = Unit.f68710a;
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void clearChangedMsgSwitchList(@f(App.class) App app, @g({CampaignEx.JSON_KEY_TIMESTAMP}) long j11, @c a aVar) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                b appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    h.f66817a.b(context, j11);
                    if (aVar != null) {
                        aVar.g();
                        unit = Unit.f68710a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.h(this.OooO00o, th2);
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
        }
        if (aVar != null) {
            aVar.b();
            Unit unit2 = Unit.f68710a;
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void getAutoUpdateStatus(@f(App.class) App app, @c a aVar) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                b appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    boolean z11 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getBoolean(context, "miniLauncherGlobal", "miniAutoUpdateStatus", false);
                    if (aVar != null) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty(NotificationCompat.CATEGORY_STATUS, Boolean.valueOf(z11));
                        aVar.d(jsonObject);
                        unit = Unit.f68710a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.h(this.OooO00o, th2);
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
        }
        if (aVar != null) {
            aVar.b();
            Unit unit2 = Unit.f68710a;
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void getCacheMsgData(@f(App.class) App app, @c a aVar) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                b appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    JsonArray jsonArray = new JsonArray();
                    KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
                    String[] mMKVFileAllKeys = kVStorageProxy.getMMKVFileAllKeys(context, "miniMsgCacheData");
                    Intrinsics.f(mMKVFileAllKeys, "storageProxy.getMMKVFile…vider.KEY_MSG_CACHE_DATA)");
                    Iterator it = d.u0(mMKVFileAllKeys).iterator();
                    while (it.hasNext()) {
                        jsonArray.add((JsonObject) a0.f31025a.a(kVStorageProxy.getString(context, "miniMsgCacheData", (String) it.next()), JsonObject.class));
                    }
                    String string = jsonArray.toString();
                    Intrinsics.f(string, "msgDataArray.toString()");
                    TmcLogger.c(this.OooO00o, "getCacheMsgData msgCacheObj = " + string);
                    if (aVar != null) {
                        aVar.d(z.a().d("msgData", string).e());
                        unit = Unit.f68710a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.h(this.OooO00o, th2);
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
        }
        if (aVar != null) {
            aVar.b();
            Unit unit2 = Unit.f68710a;
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void getChangedMsgSwitchList(@f(App.class) App app, @c a aVar) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                b appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    JsonArray jsonArrayE = h.f66817a.e(context);
                    if (aVar != null) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.add(this.OooO0O0, jsonArrayE);
                        aVar.d(jsonObject);
                        unit = Unit.f68710a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.h(this.OooO00o, th2);
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
        }
        if (aVar != null) {
            aVar.b();
            Unit unit2 = Unit.f68710a;
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void getLatestAppListMsgSwitch(@f(App.class) App app, @c a aVar) {
        b appContext;
        Context context;
        if (app != null && (appContext = app.getAppContext()) != null && (context = appContext.getContext()) != null) {
            JsonArray jsonArray = new JsonArray();
            List<AppStoreInfo> listD = LatestUseUtils.d();
            Unit unit = null;
            if (listD != null) {
                Intrinsics.f(listD, "getLatestUseApps()");
                for (AppStoreInfo appStoreInfo : listD) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("miniappId", appStoreInfo.getAppId());
                    jsonObject.addProperty("miniappName", appStoreInfo.getName());
                    jsonObject.addProperty("miniappLogo", appStoreInfo.getLogo());
                    String appId = appStoreInfo.getAppId();
                    if (appId == null) {
                        appId = "";
                    }
                    Intrinsics.g(context, "context");
                    Intrinsics.g(appId, "appId");
                    String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, "miniMsgProvider", "msg_switch_" + appId);
                    if (string == null) {
                        string = "";
                    }
                    if (string.length() > 0) {
                        JsonObject jsonObject2 = (JsonObject) k.d(string, JsonObject.class);
                        JsonElement jsonElement = jsonObject2.get("appSwitchStatus");
                        String asString = jsonElement != null ? jsonElement.getAsString() : null;
                        if (asString == null) {
                            asString = "";
                        }
                        jsonObject.addProperty("appSwitchStatus", asString);
                        JsonElement jsonElement2 = jsonObject2.get("appSwitchTimestamp");
                        String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                        jsonObject.addProperty("appSwitchTimestamp", asString2 != null ? asString2 : "");
                    }
                    jsonArray.add(jsonObject);
                }
            }
            TmcLogger.c(this.OooO00o, jsonArray.toString());
            if (aVar != null) {
                JsonObject jsonObject3 = new JsonObject();
                jsonObject3.add(this.OooO0O0, jsonArray);
                aVar.d(jsonObject3);
                unit = Unit.f68710a;
            }
            if (unit != null) {
                return;
            }
        }
        if (aVar != null) {
            aVar.b();
            Unit unit2 = Unit.f68710a;
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void getMiniAppCacheSize(@f(App.class) App app, @g({"miniappId"}) String appId, @c a callback) {
        Unit unit;
        Context context;
        Intrinsics.g(app, "app");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(callback, "callback");
        b appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            long jL = FileUtil.L(context, appId);
            TmcLogger.c(this.OooO00o, "getMiniAppCacheSize: " + jL);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("cacheSize", Long.valueOf(jL));
            callback.d(jsonObject);
            unit = Unit.f68710a;
        }
        if (unit == null) {
            callback.b();
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void getMiniAppFileSize(@f(App.class) App app, @g({"miniappId"}) String appId, @c a callback) {
        Unit unit;
        Context context;
        Intrinsics.g(app, "app");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(callback, "callback");
        b appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            long jM = FileUtil.M(context, appId);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("totalSize", Long.valueOf(jM));
            callback.d(jsonObject);
            TmcLogger.c(this.OooO00o, "getMiniAppFileSize: " + jM);
            unit = Unit.f68710a;
        }
        if (unit == null) {
            callback.b();
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void getMiniAppTotalCacheSize(@f(App.class) App app, @g({"miniappId"}) String appId, @c a callback) {
        Unit unit;
        Context context;
        Intrinsics.g(app, "app");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(callback, "callback");
        b appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            long jA = FileUtil.A(context);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("totalCacheSize", Long.valueOf(jA));
            callback.d(jsonObject);
            TmcLogger.c(this.OooO00o, "getAllMiniAppCacheSize: " + jA);
            unit = Unit.f68710a;
        }
        if (unit == null) {
            callback.b();
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void getMiniAppTotalSize(@f(App.class) App app, @c a callback) {
        Unit unit;
        Context context;
        Intrinsics.g(app, "app");
        Intrinsics.g(callback, "callback");
        b appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            long jB = FileUtil.B(context);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("totalSize", Long.valueOf(jB));
            callback.d(jsonObject);
            TmcLogger.c(this.OooO00o, "getMiniAppTotalSize: " + jB);
            unit = Unit.f68710a;
        }
        if (unit == null) {
            callback.b();
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:40:? A[RETURN, SYNTHETIC] */
    @zb.a("")
    @e(ExecutorType.IO)
    public final void getMiniappPermissionList(@f(App.class) App app, @g({"miniappId"}) String miniappId, @c a aVar) {
        Context context;
        ArrayList<PermissionInfoModel> arrayList;
        Unit unit;
        Intrinsics.g(miniappId, "miniappId");
        if (app != null) {
            try {
                b appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    String strK = ScopeUtils.f31808a.k(context, miniappId);
                    TmcLogger.c(this.OooO00o, "permissionMiniappScopeData: " + strK);
                    if (strK.length() == 0) {
                        if (aVar != null) {
                            aVar.d(z.a().b("isAuthorized", Boolean.FALSE).e());
                            unit = Unit.f68710a;
                        } else {
                            unit = null;
                        }
                        if (unit != null) {
                            return;
                        }
                    } else {
                        try {
                            Object objE = k.e(strK, new TypeToken<ArrayList<PermissionInfoModel>>() { // from class: com.cloud.tmc.miniapp.bridge.AppManagerDataProviderBridge$getMiniappPermissionList$1$authList$1
                            }.getType());
                            Intrinsics.f(objE, "{\n                      …  )\n                    }");
                            arrayList = (ArrayList) objE;
                        } catch (Throwable unused) {
                            arrayList = new ArrayList();
                        }
                        for (PermissionInfoModel permissionInfoModel : arrayList) {
                            permissionInfoModel.setScopeDescription(ScopeUtils.f31808a.l(permissionInfoModel.getScopeName(), permissionInfoModel.getScopeName()));
                        }
                        String strA = o.a(arrayList);
                        TmcLogger.c(this.OooO00o, "miniScopeData:-> " + strA);
                        if (aVar != null) {
                            aVar.d(z.a().b("isAuthorized", Boolean.TRUE).d("permissionList", strA).e());
                            unit = Unit.f68710a;
                        } else {
                            unit = null;
                        }
                        if (unit != null) {
                            return;
                        }
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.h(this.OooO00o, th2);
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
        }
        if (aVar != null) {
            aVar.b();
            Unit unit2 = Unit.f68710a;
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void getMsgListInfo(@f(App.class) App app, @c a callback) {
        Unit unit;
        Context context;
        Intrinsics.g(app, "app");
        Intrinsics.g(callback, "callback");
        b appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, "miniMsgProvider", "MsgListData");
            TmcLogger.c(this.OooO00o, "getMsgListInfo: " + string);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("msgList", string);
            callback.d(jsonObject);
            unit = Unit.f68710a;
        }
        if (unit == null) {
            callback.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @zb.a("")
    @e(ExecutorType.IO)
    public final void getMsgSwitchStatus(@f(App.class) App app, @g({"miniappId"}) String appId, @c a callback) {
        Context context;
        Intrinsics.g(app, "app");
        Intrinsics.g(appId, "miniappId");
        Intrinsics.g(callback, "callback");
        b appContext = app.getAppContext();
        Object asString = null;
        if (appContext != null && (context = appContext.getContext()) != null) {
            JsonObject jsonObject = new JsonObject();
            Intrinsics.g(context, "context");
            Intrinsics.g(appId, "appId");
            String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, "miniMsgProvider", "msg_switch_" + appId);
            String str = "";
            if (string == null) {
                string = "";
            }
            if (string.length() > 0) {
                JsonObject jsonObject2 = (JsonObject) k.d(string, JsonObject.class);
                JsonElement jsonElement = jsonObject2.get("appSwitchStatus");
                String asString2 = jsonElement != null ? jsonElement.getAsString() : null;
                if (asString2 == null) {
                    asString2 = "";
                } else {
                    Intrinsics.f(asString2, "msgProvider[MiniappMsgDa…H_STATUS]?.asString ?: \"\"");
                }
                jsonObject.addProperty("appSwitchStatus", asString2);
                JsonElement jsonElement2 = jsonObject2.get("appSwitchTimestamp");
                asString = jsonElement2 != null ? jsonElement2.getAsString() : null;
                if (asString != null) {
                    Intrinsics.f(asString, "msgProvider[MiniappMsgDa…IMESTAMP]?.asString ?: \"\"");
                    str = asString;
                }
                jsonObject.addProperty("appSwitchTimestamp", str);
            }
            callback.d(jsonObject);
            asString = Unit.f68710a;
        }
        if (asString == null) {
            callback.b();
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void getMsgWithReadStatusListInfo(@f(App.class) App app, @c a callback) {
        Unit unit;
        Context context;
        Intrinsics.g(app, "app");
        Intrinsics.g(callback, "callback");
        b appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, "miniMsgProvider", "MsgListWithReadStatusData");
            TmcLogger.c(this.OooO00o, "getMsgWithReadStatusListInfo: " + string);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("msgList", string);
            callback.d(jsonObject);
            unit = Unit.f68710a;
        }
        if (unit == null) {
            callback.b();
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:? A[RETURN, SYNTHETIC] */
    @zb.a("")
    @e(ExecutorType.IO)
    public final void getPermissionStatus(@f(App.class) App app, @g({"miniappId"}) String miniappId, @g({"scopeName"}) String scopeName, @c a aVar) {
        Context context;
        ArrayList arrayList;
        Object next;
        Unit unit;
        Intrinsics.g(miniappId, "miniappId");
        Intrinsics.g(scopeName, "scopeName");
        if (app != null) {
            try {
                b appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    ScopeUtils scopeUtils = ScopeUtils.f31808a;
                    String strK = scopeUtils.k(context, miniappId);
                    Unit unit2 = null;
                    if (strK.length() == 0) {
                        if (aVar != null) {
                            aVar.d(z.a().b("isAuthorized", Boolean.FALSE).d("scopeName", scopeName).d("scopeDescription", scopeUtils.l(scopeName, scopeName)).e());
                            unit = Unit.f68710a;
                            unit2 = unit;
                        }
                        if (unit2 != null) {
                            return;
                        }
                    } else {
                        try {
                            Object objE = k.e(strK, new TypeToken<ArrayList<PermissionInfoModel>>() { // from class: com.cloud.tmc.miniapp.bridge.AppManagerDataProviderBridge$getPermissionStatus$1$authList$1
                            }.getType());
                            Intrinsics.f(objE, "{\n                      …  )\n                    }");
                            arrayList = (ArrayList) objE;
                        } catch (Throwable unused) {
                            arrayList = new ArrayList();
                        }
                        Iterator it = arrayList.iterator();
                        do {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                        } while (!Intrinsics.b(((PermissionInfoModel) next).getScopeName(), scopeName));
                        PermissionInfoModel permissionInfoModel = (PermissionInfoModel) next;
                        if (permissionInfoModel == null) {
                            if (aVar != null) {
                                aVar.d(z.a().b("isAuthorized", Boolean.FALSE).d("scopeName", scopeName).d("scopeDescription", ScopeUtils.f31808a.l(scopeName, scopeName)).e());
                                unit = Unit.f68710a;
                                unit2 = unit;
                            }
                        } else if (aVar != null) {
                            aVar.d(z.a().b("isAuthorized", Boolean.TRUE).d("scopeName", scopeName).d("scopeDescription", ScopeUtils.f31808a.l(scopeName, scopeName)).b("authStatus", permissionInfoModel.getAuthStatus()).c("authTimeStamp", permissionInfoModel.getAuthTimeStamp()).c("validityTime", permissionInfoModel.getValidityTime()).e());
                            unit = Unit.f68710a;
                            unit2 = unit;
                        }
                        if (unit2 != null) {
                            return;
                        }
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.h(this.OooO00o, th2);
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
        }
        if (aVar != null) {
            aVar.b();
            Unit unit3 = Unit.f68710a;
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void getPrefetchState(@f(App.class) App app, @c a aVar) {
        Context context;
        Unit unit;
        if (app != null) {
            try {
                b appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    int i11 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getInt(context, "miniLauncherGlobal", "miniPrefetchStatus");
                    long j11 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getLong(context, "miniLauncherGlobal", "miniPrefetchTimestamp");
                    if (aVar != null) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(i11));
                        jsonObject.addProperty(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(j11));
                        aVar.d(jsonObject);
                        unit = Unit.f68710a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.h(this.OooO00o, th2);
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
        }
        if (aVar != null) {
            aVar.b();
            Unit unit2 = Unit.f68710a;
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void getTotalMsgStatus(@f(App.class) App app, @c a callback) {
        Context context;
        Object obj;
        Object obj2 = "";
        Intrinsics.g(app, "app");
        Intrinsics.g(callback, "callback");
        b appContext = app.getAppContext();
        Object asString = null;
        if (appContext != null && (context = appContext.getContext()) != null) {
            try {
                Intrinsics.g(context, "context");
                try {
                    String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, "miniMsgProvider", "mainMsgSwitch");
                    if (string == null || string.length() <= 0) {
                        obj = "";
                    } else {
                        JsonObject jsonObject = (JsonObject) k.d(string, JsonObject.class);
                        JsonElement jsonElement = jsonObject.get("mainSwitchStatus");
                        String asString2 = jsonElement != null ? jsonElement.getAsString() : null;
                        if (asString2 == null) {
                            asString2 = "";
                        }
                        JsonElement jsonElement2 = jsonObject.get("mainSwitchTimestamp");
                        asString = jsonElement2 != null ? jsonElement2.getAsString() : null;
                        obj = asString != null ? asString : "";
                        obj2 = asString2;
                    }
                } catch (Throwable unused) {
                }
                Pair pairA = TuplesKt.a(obj2, obj);
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("mainSwitchStatus", (String) pairA.getFirst());
                jsonObject2.addProperty("mainSwitchTimestamp", (String) pairA.getSecond());
                callback.d(jsonObject2);
            } catch (Throwable th2) {
                TmcLogger.h(this.OooO00o, th2);
            }
            asString = Unit.f68710a;
        }
        if (asString == null) {
            callback.b();
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void getUnreadMsgNum(@f(App.class) App app, @g(stringDefault = "", value = {"miniappId"}) String str, @c a aVar) {
        Context context;
        JsonObject jsonObject;
        Unit unit;
        if (app != null) {
            try {
                b appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    Intrinsics.g(context, "context");
                    try {
                        String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, "miniMsgProvider", "miniMsgUnreadData");
                        TmcLogger.c("MiniappMsgDataProvider", "getMsgUnreadNumber-> " + string);
                        jsonObject = (string == null || string.length() <= 0) ? new JsonObject() : (JsonObject) k.d(string, JsonObject.class);
                        Intrinsics.f(jsonObject, "{\n            val unread…)\n            }\n        }");
                    } catch (Throwable th2) {
                        TmcLogger.h("MiniappMsgDataProvider", th2);
                        jsonObject = new JsonObject();
                    }
                    if (str != null && str.length() > 0) {
                        JsonElement jsonElement = jsonObject.get(str);
                        int asInt = jsonElement != null ? jsonElement.getAsInt() : 0;
                        JsonObject jsonObject2 = new JsonObject();
                        jsonObject2.addProperty(str, Integer.valueOf(asInt));
                        jsonObject = jsonObject2;
                    }
                    if (aVar != null) {
                        aVar.d(z.a().d("unreadMsgData", jsonObject.toString()).e());
                        unit = Unit.f68710a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th3) {
                TmcLogger.h(this.OooO00o, th3);
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
        }
        if (aVar != null) {
            aVar.b();
            Unit unit2 = Unit.f68710a;
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void launcherMiniappBrandPage(@f(App.class) App app, @g({"miniappId"}) String miniappId, @c a aVar) {
        Context context;
        Intrinsics.g(miniappId, "miniappId");
        if (app != null) {
            try {
                b appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    Unit unit = null;
                    AppBrandProfileActivity.f31662t.a(context, miniappId, null);
                    if (aVar != null) {
                        aVar.g();
                        unit = Unit.f68710a;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.h(this.OooO00o, th2);
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
        }
        if (aVar != null) {
            aVar.b();
            Unit unit2 = Unit.f68710a;
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void removeMiniAppFile(@f(App.class) App app, @g({"miniappId"}) String appId, @c a callback) {
        Unit unit;
        Context context;
        Intrinsics.g(app, "app");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(callback, "callback");
        b appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            TmcLogger.c(this.OooO00o, "removeMiniAppFile: ");
            FileUtil.e0(context, appId);
            callback.d(new JsonObject());
            unit = Unit.f68710a;
        }
        if (unit == null) {
            callback.b();
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void removeMiniAppFileCache(@f(App.class) App app, @g({"miniappId"}) String appId, @c a callback) {
        Unit unit;
        Context context;
        Intrinsics.g(app, "app");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(callback, "callback");
        b appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            TmcLogger.c(this.OooO00o, "removeMiniAppFileCache: ");
            FileUtil.g0(context, appId);
            callback.d(new JsonObject());
            unit = Unit.f68710a;
        }
        if (unit == null) {
            callback.b();
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void requestSendMsgPermission(@f(App.class) App app, @g({"miniappId"}) String miniappId, @c a aVar) {
        Unit unit;
        Intrinsics.g(miniappId, "miniappId");
        if (app != null) {
            try {
                b appContext = app.getAppContext();
                if (appContext != null && appContext.getContext() != null) {
                    if (aVar != null) {
                        aVar.g();
                        unit = Unit.f68710a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.h(this.OooO00o, th2);
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
        }
        if (aVar != null) {
            aVar.b();
            Unit unit2 = Unit.f68710a;
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void saveMsgListInfo(@f(App.class) App app, @g({"msgList"}) String msgList, @c a callback) {
        Unit unit;
        Context context;
        Intrinsics.g(app, "app");
        Intrinsics.g(msgList, "msgList");
        Intrinsics.g(callback, "callback");
        b appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            TmcLogger.c(this.OooO00o, "saveMsgListInfo: " + msgList);
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(context, "miniMsgProvider", "MsgListData", msgList);
            callback.g();
            unit = Unit.f68710a;
        }
        if (unit == null) {
            callback.b();
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void saveMsgWithReadStatusListInfo(@f(App.class) App app, @g({"msgList"}) String msgList, @c a callback) {
        Unit unit;
        Context context;
        Intrinsics.g(app, "app");
        Intrinsics.g(msgList, "msgList");
        Intrinsics.g(callback, "callback");
        b appContext = app.getAppContext();
        if (appContext == null || (context = appContext.getContext()) == null) {
            unit = null;
        } else {
            TmcLogger.c(this.OooO00o, "saveMsgWithReadStatusListInfo: " + msgList);
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(context, "miniMsgProvider", "MsgListWithReadStatusData", msgList);
            callback.g();
            unit = Unit.f68710a;
        }
        if (unit == null) {
            callback.b();
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void updateUnreadMsgNum(@f(App.class) App app, @g({"unreadMsgData"}) JsonObject unreadMsgData, @c a aVar) {
        Context context;
        JsonObject jsonObject;
        Unit unit;
        Intrinsics.g(unreadMsgData, "unreadMsgData");
        if (app != null) {
            try {
                b appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    Intrinsics.g(context, "context");
                    try {
                        String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, "miniMsgProvider", "miniMsgUnreadData");
                        TmcLogger.c("MiniappMsgDataProvider", "getMsgUnreadNumber-> " + string);
                        jsonObject = (string == null || string.length() <= 0) ? new JsonObject() : (JsonObject) k.d(string, JsonObject.class);
                        Intrinsics.f(jsonObject, "{\n            val unread…)\n            }\n        }");
                    } catch (Throwable th2) {
                        TmcLogger.h("MiniappMsgDataProvider", th2);
                        jsonObject = new JsonObject();
                    }
                    Set<String> setKeySet = unreadMsgData.keySet();
                    Intrinsics.f(setKeySet, "unreadMsgData.keySet()");
                    for (String str : setKeySet) {
                        jsonObject.addProperty(str, Integer.valueOf(unreadMsgData.get(str).getAsInt()));
                    }
                    String unreadMsgData2 = jsonObject.toString();
                    Intrinsics.f(unreadMsgData2, "msgUnreadNumberData.toString()");
                    Intrinsics.g(context, "context");
                    Intrinsics.g(unreadMsgData2, "unreadMsgData");
                    try {
                        TmcLogger.c("MiniappMsgDataProvider", "updateMsgUnreadNumber unreadMsgData:" + unreadMsgData2);
                        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, "miniMsgProvider", "miniMsgUnreadData");
                    } catch (Throwable th3) {
                        TmcLogger.h("MiniappMsgDataProvider", th3);
                    }
                    if (aVar != null) {
                        aVar.g();
                        unit = Unit.f68710a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        return;
                    }
                }
            } catch (Throwable th4) {
                TmcLogger.h(this.OooO00o, th4);
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
        }
        if (aVar != null) {
            aVar.b();
            Unit unit2 = Unit.f68710a;
        }
    }
}
