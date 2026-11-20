// =============================================================================
// GateWaySdk (original : com.transsion.api.gateway.GateWaySdk) — MovieBox 3.0.05
// Singleton du module « gateway » : routage des requêtes via la passerelle
// apigateway.tmctool.com, secret HMAC récupéré du manifeste
// (meta-data gateway_secret_online / gateway_secret_test — 2 clés base64),
// injection de GatewayInterceptor dans OkHttp, config des chemins signés
// (/gateway/metric/add, /gateway/sdk/v1/config) via setActivateSignConfig.
// WorkMode : MODE_TEST/MODE_ONLINE (sélection du secret et de l'hôte).
// =============================================================================
package com.transsion.api.gateway;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import com.transsion.api.gateway.config.WorkMode;
import com.transsion.api.gateway.interceptor.GatewayInterceptor;
import com.transsion.api.gateway.utils.ContextUtils;
import com.transsion.api.gateway.utils.GatewayUtils;
import com.transsion.api.gateway.utils.SafeStringUtils;
import com.transsion.api.gateway.utils.ThreadManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class GateWaySdk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f50682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static OkHttpClient f50683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f50684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static CopyOnWriteArrayList<String> f50685d = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static CopyOnWriteArrayList<String> f50686e = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static WorkMode f50687f = WorkMode.MODE_ONLINE;

    /* JADX INFO: compiled from: source.java */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f50688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f50689b;

        public a(Context context, String str) {
            this.f50688a = context;
            this.f50689b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SafeStringUtils.getInstance(this.f50688a).saveString(SafeStringUtils.SP_APPID, this.f50689b);
        }
    }

    public static void a(Context context) {
        if (!f50684c && isOkhttpIntegrated()) {
            f50684c = true;
            try {
                context.registerReceiver(new com.transsion.api.gateway.receiver.a(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } catch (Exception e11) {
                GatewayUtils.L.e("registerReceiver fail, e:" + e11.getMessage());
            }
        }
    }

    public static List<String> getActivateSigHosts() {
        return f50685d;
    }

    public static List<String> getActivateSigPaths() {
        return f50686e;
    }

    public static String getHost() {
        int iOrdinal = f50687f.ordinal();
        return (iOrdinal == 0 || iOrdinal == 1) ? "apigateway.tmctool.com" : "";
    }

    public static boolean getIsInited() {
        return f50682a;
    }

    public static OkHttpClient getOkHttpClient() {
        if (f50683b == null) {
            f50683b = new OkHttpClient().newBuilder().addInterceptor(new GatewayInterceptor()).build();
        }
        return f50683b;
    }

    public static String getSecret() {
        try {
            if (ContextUtils.getContext() == null) {
                return "";
            }
            ApplicationInfo applicationInfo = ContextUtils.getContext().getPackageManager().getApplicationInfo(ContextUtils.getContext().getPackageName(), 128);
            int iOrdinal = f50687f.ordinal();
            if (iOrdinal != 0) {
                return iOrdinal != 1 ? "" : applicationInfo.metaData.getString("gateway_secret_online");
            }
            return applicationInfo.metaData.getString("gateway_secret_test");
        } catch (Exception e11) {
            GatewayUtils.L.e(e11);
            return "";
        }
    }

    public static WorkMode getWorkMode() {
        return f50687f;
    }

    public static void init(Context context, String str) {
        ContextUtils.init(context);
        a(context);
        f50687f = WorkMode.MODE_ONLINE;
        f50682a = true;
    }

    public static void init(Context context, String str, WorkMode workMode) {
        ContextUtils.init(context);
        a(context);
        f50687f = workMode;
        ThreadManager.executeInBackground(new a(context, str));
        ArrayList arrayList = new ArrayList();
        arrayList.add("/gateway/metric/add");
        arrayList.add("/gateway/sdk/v1/config");
        setActivateSignConfig(null, arrayList);
        f50682a = true;
    }

    public static boolean isOkhttpIntegrated() {
        try {
            OkHttpClient.Companion companion = OkHttpClient.Companion;
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static void setActivateSignConfig(List<String> list, List<String> list2) {
        if (list != null && list.size() > 0) {
            f50685d.addAllAbsent(list);
        }
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        f50686e.addAllAbsent(list2);
    }

    public static void setOkHttpClient(OkHttpClient okHttpClient) {
        if (okHttpClient != null) {
            f50683b = okHttpClient;
        }
    }
}
