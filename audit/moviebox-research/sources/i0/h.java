package i0;

import android.content.Context;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f66817a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ConcurrentHashMap<String, JsonObject> f66818b;

    public final ConcurrentHashMap<String, JsonObject> a(Context context) {
        if (f66818b == null) {
            f66818b = new ConcurrentHashMap<>();
            String[] mMKVFileAllKeys = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getMMKVFileAllKeys(context, "miniMsgChangedProvider");
            Intrinsics.f(mMKVFileAllKeys, "get(KVStorageProxy::clas…KEY_CHANGED_MSG_PROVIDER)");
            for (String it : mMKVFileAllKeys) {
                Intrinsics.f(it, "it");
                if (kotlin.text.l.L(it, "change_msg_switch_", false, 2, null)) {
                    String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, "miniMsgChangedProvider", it);
                    if (string == null) {
                        string = "";
                    }
                    Intrinsics.f(string, "TmcProxy.get(KVStoragePr…D_MSG_PROVIDER, it) ?: \"\"");
                    ConcurrentHashMap<String, JsonObject> concurrentHashMap = f66818b;
                    if (concurrentHashMap != null) {
                        concurrentHashMap.put(it, (JsonObject) com.cloud.tmc.miniutils.util.k.d(string, JsonObject.class));
                    }
                }
            }
        }
        return f66818b;
    }

    public final void b(Context context, long j11) {
        Set<Map.Entry<String, JsonObject>> setEntrySet;
        long jCurrentTimeMillis;
        JsonElement jsonElement;
        String asString;
        Intrinsics.g(context, "context");
        try {
            ConcurrentHashMap<String, JsonObject> concurrentHashMapA = a(context);
            if (concurrentHashMapA == null || (setEntrySet = concurrentHashMapA.entrySet()) == null) {
                return;
            }
            Iterator<T> it = setEntrySet.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                JsonObject jsonObject = (JsonObject) entry.getValue();
                if (jsonObject == null || (jsonElement = jsonObject.get("appSwitchTimestamp")) == null || (asString = jsonElement.getAsString()) == null) {
                    jCurrentTimeMillis = System.currentTimeMillis();
                } else {
                    Intrinsics.f(asString, "asString");
                    jCurrentTimeMillis = Long.parseLong(asString);
                }
                TmcLogger.c("MiniappMsgDataProvider", "clearChangedMsgSwitchList timestamp->" + j11 + ",appSwitchTimestamp=" + jCurrentTimeMillis);
                if (j11 >= jCurrentTimeMillis) {
                    TmcLogger.c("MiniappMsgDataProvider", "clearChangedMsgSwitchList remove key->" + ((String) entry.getKey()));
                    concurrentHashMapA.remove(entry.getKey());
                    ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).remove(context, "miniMsgChangedProvider", "change_msg_switch_" + ((String) entry.getKey()));
                }
            }
        } catch (Throwable th2) {
            TmcLogger.g("MiniappMsgDataProvider", "clearChangedMsgSwitchList", th2);
        }
    }

    public final void c(Context context, String appId, String status) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(status, "status");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("miniappId", appId);
        jsonObject.addProperty("appSwitchStatus", status);
        jsonObject.addProperty("appSwitchTimestamp", String.valueOf(System.currentTimeMillis()));
        String string = jsonObject.toString();
        Intrinsics.f(string, "msgObj.toString()");
        TmcLogger.c("MiniappMsgDataProvider", "changeMsgSwitchStatus msgStr = " + string);
        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(context, "miniMsgProvider", h.a.a("msg_switch_", appId), string);
        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(context, "miniMsgChangedProvider", h.a.a("change_msg_switch_", appId), string);
        ConcurrentHashMap<String, JsonObject> concurrentHashMapA = a(context);
        if (concurrentHashMapA != null) {
            concurrentHashMapA.put("change_msg_switch_" + appId, jsonObject);
        }
    }

    public final boolean d(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        if (!Intrinsics.b(i(context).getFirst(), "1")) {
            TmcLogger.c("MiniappMsgDataProvider", "main switch is closed");
            return false;
        }
        String strF = f(context, appId);
        if (strF.length() <= 0) {
            TmcLogger.c("MiniappMsgDataProvider", "msgSwitch " + appId + " empty,status is closed");
            return false;
        }
        JsonElement jsonElement = ((JsonObject) com.cloud.tmc.miniutils.util.k.d(strF, JsonObject.class)).get("appSwitchStatus");
        String asString = jsonElement != null ? jsonElement.getAsString() : null;
        if (asString == null) {
            asString = "";
        }
        if (Intrinsics.b(asString, "1")) {
            return true;
        }
        TmcLogger.c("MiniappMsgDataProvider", "msgSwitch " + appId + " status is closed");
        return false;
    }

    public final JsonArray e(Context context) {
        Set<Map.Entry<String, JsonObject>> setEntrySet;
        Intrinsics.g(context, "context");
        JsonArray jsonArray = new JsonArray();
        ConcurrentHashMap<String, JsonObject> concurrentHashMapA = a(context);
        if (concurrentHashMapA != null && (setEntrySet = concurrentHashMapA.entrySet()) != null) {
            Iterator<T> it = setEntrySet.iterator();
            while (it.hasNext()) {
                jsonArray.add((JsonElement) ((Map.Entry) it.next()).getValue());
            }
        }
        TmcLogger.c("MiniappMsgDataProvider", "getChangedMsgSwitchList-> " + jsonArray);
        return jsonArray;
    }

    public final String f(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, "miniMsgProvider", "msg_switch_" + appId);
        return string == null ? "" : string;
    }

    public final String g(Context context) {
        Intrinsics.g(context, "context");
        try {
            String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, "miniMsgProvider", "miniLatestUnreadMsg");
            if (string != null) {
                return string;
            }
            TmcLogger.c("MiniappMsgDataProvider", "getLatestUnreadMsg -> ");
            return "";
        } catch (Throwable th2) {
            TmcLogger.h("MiniappMsgDataProvider", th2);
            return "";
        }
    }

    public final void h(Context context, String msgStr) {
        Intrinsics.g(context, "context");
        Intrinsics.g(msgStr, "msgStr");
        try {
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(context, "miniMsgProvider", "miniLatestUnreadMsg", msgStr);
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putBoolean(context, "miniMsgKvId", "miniNewMsgStatus", !Intrinsics.b(msgStr, ""));
        } catch (Throwable th2) {
            TmcLogger.h("MiniappMsgDataProvider", th2);
        }
    }

    public final Pair<String, String> i(Context context) {
        String str;
        Intrinsics.g(context, "context");
        String str2 = "";
        try {
            String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, "miniMsgProvider", "mainMsgSwitch");
            if (string == null || string.length() <= 0) {
                str = "";
            } else {
                JsonObject jsonObject = (JsonObject) com.cloud.tmc.miniutils.util.k.d(string, JsonObject.class);
                JsonElement jsonElement = jsonObject.get("mainSwitchStatus");
                String asString = jsonElement != null ? jsonElement.getAsString() : null;
                if (asString == null) {
                    asString = "";
                }
                JsonElement jsonElement2 = jsonObject.get("mainSwitchTimestamp");
                String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                str = asString2 != null ? asString2 : "";
                str2 = asString;
            }
        } catch (Throwable unused) {
        }
        return TuplesKt.a(str2, str);
    }
}
