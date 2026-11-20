package com.cloud.tmc.miniapp.utils;

import android.app.Application;
import android.content.Context;
import com.cloud.config.utils.CommonUtils;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.net.BaseResponse;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.o;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniutils.util.k;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import i0.c;
import i0.h;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mb.d;
import tb.b;
import tc.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class MessageBubbleUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MessageBubbleUtils f31780a = new MessageBubbleUtils();

    public final void a(App app, c cVar) {
        Application application$com_cloud_tmc_miniapp_sdk;
        b appContext;
        try {
            TmcLogger.c("MessageBubbleUtils", "requestMsgBubbleStatus");
            Context context = (app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
            if (context == null) {
                return;
            }
            h hVar = h.f66817a;
            String strG = hVar.g(context);
            if (strG.length() == 0) {
                TmcLogger.c("MessageBubbleUtils", "latestUnreadMsg is null or empty");
                return;
            }
            JsonObject jsonObject = (JsonObject) k.d(strG, JsonObject.class);
            JsonElement jsonElement = jsonObject.get("miniappId");
            String asString = jsonElement != null ? jsonElement.getAsString() : null;
            String str = "";
            if (asString == null) {
                asString = "";
            }
            JsonElement jsonElement2 = jsonObject.get("miniappName");
            String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
            if (asString2 == null) {
                asString2 = "";
            }
            if (Intrinsics.b(app.getAppId(), asString)) {
                return;
            }
            if (!hVar.d(context, asString)) {
                TmcLogger.c("MessageBubbleUtils", "requestMsgBubbleStatus msg switch is closed -> " + asString);
                return;
            }
            TmcLogger.c("MessageBubbleUtils", "checkAndShowMessageBubble appId " + asString);
            String appId = app.getAppId();
            if (appId != null) {
                str = appId;
            }
            if (str.length() == 0 || (application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk()) == null) {
                return;
            }
            if (System.currentTimeMillis() - ((KVStorageProxy) a.a(KVStorageProxy.class)).getLong(application$com_cloud_tmc_miniapp_sdk, str, "MessageBubbleLatestTime") < 43200000) {
                return;
            }
            TmcLogger.c("MessageBubbleUtils", "show msg bubble");
            if (cVar != null) {
                cVar.d(str, asString2);
            }
        } catch (Throwable th2) {
            TmcLogger.g("MessageBubbleUtils", "requestMsgBubbleStatus", th2);
        }
    }

    public final boolean b() {
        try {
            if (e()) {
                return MiniAppConfigHelper.f30370a.b("msgBottomItemEnable", false);
            }
            return false;
        } catch (Throwable th2) {
            TmcLogger.h("MessageBubbleUtils", th2);
            return false;
        }
    }

    public final boolean c(String str) {
        try {
            Object objD = k.d(MiniAppConfigHelper.f30370a.e("miniPopwindowMsgBubbleForbidId", "[\"1000391591855976448\",\"1000886706715795456\"]"), List.class);
            List arrayList = objD instanceof List ? (List) objD : null;
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            return arrayList.contains(str);
        } catch (Throwable th2) {
            TmcLogger.h("MessageBubbleUtils", th2);
            return false;
        }
    }

    public final void d(final App app, final c cVar) {
        String asString;
        String asString2;
        String string;
        b appContext;
        final Context context = (app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
        if (context == null) {
            return;
        }
        if (((KVStorageProxy) a.a(KVStorageProxy.class)).getBoolean(context, "100000", "isNewUser", true)) {
            TmcLogger.c("MessageBubbleUtils", "updateDateMsgStatus isFirst = true");
            return;
        }
        Intrinsics.g(context, "context");
        try {
            String string2 = ((KVStorageProxy) a.a(KVStorageProxy.class)).getString(context, "miniMsgProvider", "mainMsgSwitch");
            if (string2 == null || string2.length() <= 0) {
                asString = "";
                asString2 = asString;
            } else {
                JsonObject jsonObject = (JsonObject) k.d(string2, JsonObject.class);
                JsonElement jsonElement = jsonObject.get("mainSwitchStatus");
                asString2 = jsonElement != null ? jsonElement.getAsString() : null;
                if (asString2 == null) {
                    asString2 = "";
                }
                JsonElement jsonElement2 = jsonObject.get("mainSwitchTimestamp");
                asString = jsonElement2 != null ? jsonElement2.getAsString() : null;
                if (asString == null) {
                    asString = "";
                }
            }
        } catch (Throwable unused) {
        }
        if (!Intrinsics.b(TuplesKt.a(asString2, asString).getFirst(), "1")) {
            TmcLogger.c("MessageBubbleUtils", "main msg switch is closed,return");
            return;
        }
        mb.c<LauncherMiniAppMsgModel> cVar2 = new mb.c<LauncherMiniAppMsgModel>() { // from class: com.cloud.tmc.miniapp.utils.MessageBubbleUtils$requestMsgInfo$1
            @Override // mb.c
            public Type d() {
                Type type = new TypeToken<BaseResponse<? extends LauncherMiniAppMsgModel>>() { // from class: com.cloud.tmc.miniapp.utils.MessageBubbleUtils$requestMsgInfo$1$getType$1
                }.getType();
                Intrinsics.f(type, "object :\n               …iAppMsgModel?>>() {}.type");
                return type;
            }

            @Override // mb.c
            public void e(BaseResponse<? extends Object> fail, Map<String, String> map) {
                Intrinsics.g(fail, "fail");
                TmcLogger.f("MessageBubbleUtils", "updateDateMsgStatus ErrCode:" + fail.getCode() + ",errMsg:" + fail.getMessage());
            }

            @Override // mb.c
            public void g(BaseResponse<? extends LauncherMiniAppMsgModel> bean, Map<String, String> map) {
                String msgDataStr;
                Unit unit;
                Intrinsics.g(bean, "bean");
                try {
                    LauncherMiniAppMsgModel data = bean.getData();
                    if (data == null || (msgDataStr = o.a(data)) == null) {
                        msgDataStr = "";
                    }
                    if (data != null) {
                        TmcLogger.c("MessageBubbleUtils", "updateDateMsgStatus dataObj = " + msgDataStr);
                        Boolean successUpdateSwitchStatus = data.getSuccessUpdateSwitchStatus();
                        boolean zBooleanValue = successUpdateSwitchStatus != null ? successUpdateSwitchStatus.booleanValue() : true;
                        Long webQueryTimestamp = data.getWebQueryTimestamp();
                        long jLongValue = webQueryTimestamp != null ? webQueryTimestamp.longValue() : System.currentTimeMillis();
                        if (zBooleanValue) {
                            h.f66817a.b(context, jLongValue);
                        }
                        ArrayList<LauncherMiniAppMsgInfoBean> miniappMessageInfos = data.getMiniappMessageInfos();
                        if (miniappMessageInfos != null && miniappMessageInfos.size() > 0) {
                            TmcLogger.c("MessageBubbleUtils", "updateDateMsgStatus msgInfo = $" + miniappMessageInfos.size());
                            Context context2 = context;
                            Intrinsics.g(context2, "context");
                            Intrinsics.g(msgDataStr, "msgDataStr");
                            try {
                                ((KVStorageProxy) a.a(KVStorageProxy.class)).putString(context2, "miniMsgCacheData", String.valueOf(System.currentTimeMillis()), msgDataStr);
                            } catch (Throwable th2) {
                                TmcLogger.h("MiniappMsgDataProvider", th2);
                            }
                        }
                        LauncherLastlyMessageInfo lastlyMessageInfo = data.getLastlyMessageInfo();
                        if (lastlyMessageInfo != null) {
                            Context context3 = context;
                            JsonObject jsonObject2 = new JsonObject();
                            String miniappId = lastlyMessageInfo.getMiniappId();
                            if (miniappId == null) {
                                miniappId = "";
                            }
                            String miniappName = lastlyMessageInfo.getMiniappName();
                            if (miniappName == null) {
                                miniappName = "";
                            }
                            if (miniappId.length() <= 0 || miniappName.length() <= 0) {
                                TmcLogger.c("MessageBubbleUtils", "miniappId or miniappName is null ");
                            } else {
                                h hVar = h.f66817a;
                                if (hVar.d(context3, miniappId)) {
                                    jsonObject2.addProperty("miniappId", miniappId);
                                    jsonObject2.addProperty("miniappName", miniappName);
                                    TmcLogger.c("MessageBubbleUtils", "updateLatestUnreadMsg miniappId " + miniappId);
                                    hVar.h(context3, o.a(jsonObject2));
                                } else {
                                    TmcLogger.c("MessageBubbleUtils", "miniappId ->" + miniappId + " msg switch is closed");
                                }
                            }
                            unit = Unit.f68710a;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            TmcLogger.c("MessageBubbleUtils", "latestMsgInfo is null");
                        }
                    } else {
                        TmcLogger.c("MessageBubbleUtils", "updateDateMsgStatus no new msg ");
                    }
                    ((KVStorageProxy) a.a(KVStorageProxy.class)).putLong(context, "miniMsgKvId", "miniLatestUpdate", System.currentTimeMillis());
                    MessageBubbleUtils.f31780a.a(app, cVar);
                } catch (Throwable th3) {
                    TmcLogger.g("MessageBubbleUtils", "", th3);
                }
            }
        };
        try {
            String strF = d.f();
            TmcLogger.c("MessageBubbleUtils", "requestUrl -> " + strF);
            try {
                string = ((KVStorageProxy) a.a(KVStorageProxy.class)).getString(context, "minisdk_storage", "device_util_ga_id");
                if (string == null) {
                    string = "";
                }
                TmcLogger.c("MessageBubbleUtils", "requestQueryMsgStatus mGAId:" + string);
            } catch (Throwable unused2) {
                string = "";
            }
            if (string.length() == 0) {
                cVar2.b("-1", "gaid is null", "");
                TmcLogger.c("MessageBubbleUtils", "mGAId is null ");
                return;
            }
            h hVar = h.f66817a;
            Pair<String, String> pairI = hVar.i(context);
            HashMap map = new HashMap();
            map.put("originType", "3");
            map.put(CommonUtils.PARAM_UID, string);
            map.put("webQueryTimestamp", Long.valueOf(System.currentTimeMillis()));
            String first = pairI.getFirst();
            String second = pairI.getSecond();
            if (first.length() > 0) {
                map.put("mainSwitchStatus", first);
            }
            if (second.length() > 0) {
                map.put("mainSwitchTimestamp", second);
            }
            JsonArray jsonArrayE = hVar.e(context);
            if (!jsonArrayE.isEmpty()) {
                map.put("miniAppSwitchOnOffs", jsonArrayE);
                TmcLogger.c("MessageBubbleUtils", "miniAppSwitchOnOffs:" + o.a(map));
            }
            ((INetWorkProxy) a.a(INetWorkProxy.class)).postJson(strF, new LinkedHashMap(), new LinkedHashMap(), map, Boolean.TRUE, cVar2);
        } catch (Throwable th2) {
            TmcLogger.h("MessageBubbleUtils", th2);
        }
    }

    public final boolean e() {
        try {
            return MiniAppConfigHelper.f30370a.b("msgTotalEnable", false);
        } catch (Throwable th2) {
            TmcLogger.h("MessageBubbleUtils", th2);
            return false;
        }
    }
}
