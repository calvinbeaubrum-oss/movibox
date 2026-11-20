package com.vungle.warren;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.provider.Settings;
import android.security.NetworkSecurityPolicy;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.webkit.URLUtil;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.applovin.sdk.AppLovinMediationProvider;
import com.cloud.tmc.integration.permission.PermissionConstant;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.network.VungleApi;
import com.vungle.warren.omsdk.OMInjector;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.session.SessionAttribute;
import com.vungle.warren.session.SessionEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class VungleApiClient {
    public static final String A = "com.vungle.warren.VungleApiClient";
    public static String B;
    public static String C;
    public static Set<Interceptor> D;
    public static Set<Interceptor> E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.vungle.warren.utility.platform.a f61820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f61821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VungleApi f61822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f61823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f61824e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f61825f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f61826g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f61827h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f61828i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f61829j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f61830k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public JsonObject f61831l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public JsonObject f61832m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f61833n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f61834o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public OkHttpClient f61835p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public VungleApi f61836q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public VungleApi f61837r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f61838s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public com.vungle.warren.persistence.a f61839t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Boolean f61840u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public com.vungle.warren.utility.u f61841v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Repository f61843x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final OMInjector f61845z;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Map<String, Long> f61842w = new ConcurrentHashMap();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f61844y = System.getProperty("http.agent");

    /* JADX INFO: compiled from: source.java */
    public static class ClearTextTrafficException extends IOException {
        public ClearTextTrafficException(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Keep
    public enum WrapperFramework {
        admob,
        air,
        cocos2dx,
        corona,
        dfp,
        heyzap,
        marmalade,
        mopub,
        unity,
        fyber,
        ironsource,
        upsight,
        appodeal,
        aerserv,
        adtoapp,
        tapdaq,
        vunglehbs,
        max,
        none
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements Interceptor {
        public a() {
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            int iCode;
            Request request = chain.request();
            String strEncodedPath = request.url().encodedPath();
            Long l11 = (Long) VungleApiClient.this.f61842w.get(strEncodedPath);
            if (l11 != null) {
                long seconds = TimeUnit.MILLISECONDS.toSeconds(l11.longValue() - System.currentTimeMillis());
                if (seconds > 0) {
                    return new Response.Builder().request(request).addHeader("Retry-After", String.valueOf(seconds)).code(500).protocol(Protocol.HTTP_1_1).message("Server is busy").body(ResponseBody.create(MediaType.parse("application/json; charset=utf-8"), "{\"Error\":\"Retry-After\"}")).build();
                }
                VungleApiClient.this.f61842w.remove(strEncodedPath);
            }
            Response responseProceed = chain.proceed(request);
            if (responseProceed != null && ((iCode = responseProceed.code()) == 429 || iCode == 500 || iCode == 502 || iCode == 503)) {
                String str = responseProceed.headers().get("Retry-After");
                if (!TextUtils.isEmpty(str)) {
                    try {
                        long j11 = Long.parseLong(str);
                        if (j11 > 0) {
                            VungleApiClient.this.f61842w.put(strEncodedPath, Long.valueOf((j11 * 1000) + System.currentTimeMillis()));
                        }
                    } catch (NumberFormatException unused) {
                        String unused2 = VungleApiClient.A;
                    }
                }
            }
            return responseProceed;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements androidx.core.util.a<String> {
        public b() {
        }

        @Override // androidx.core.util.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) {
            if (str == null) {
                Log.e(VungleApiClient.A, "Cannot Get UserAgent. Setting Default Device UserAgent");
            } else {
                VungleApiClient.this.f61844y = str;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements Interceptor {

        /* JADX INFO: compiled from: source.java */
        public class a extends RequestBody {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RequestBody f61848a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Buffer f61849b;

            public a(RequestBody requestBody, Buffer buffer) {
                this.f61848a = requestBody;
                this.f61849b = buffer;
            }

            @Override // okhttp3.RequestBody
            public long contentLength() {
                return this.f61849b.size();
            }

            @Override // okhttp3.RequestBody
            public MediaType contentType() {
                return this.f61848a.contentType();
            }

            @Override // okhttp3.RequestBody
            public void writeTo(@NonNull BufferedSink bufferedSink) throws IOException {
                bufferedSink.write(this.f61849b.snapshot());
            }
        }

        public final RequestBody a(RequestBody requestBody) throws IOException {
            Buffer buffer = new Buffer();
            BufferedSink bufferedSinkBuffer = Okio.buffer(new GzipSink(buffer));
            requestBody.writeTo(bufferedSinkBuffer);
            bufferedSinkBuffer.close();
            return new a(requestBody, buffer);
        }

        @Override // okhttp3.Interceptor
        @NonNull
        public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            return (request.body() == null || request.header(HttpHeaders.CONTENT_ENCODING) != null) ? chain.proceed(request) : chain.proceed(request.newBuilder().header(HttpHeaders.CONTENT_ENCODING, "gzip").method(request.method(), a(request.body())).build());
        }
    }

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Amazon".equals(Build.MANUFACTURER) ? "VungleAmazon/" : "VungleDroid/");
        sb2.append("6.12.1");
        B = sb2.toString();
        C = "https://config.ads.vungle.com/api/v5/";
        D = new HashSet();
        E = new HashSet();
    }

    public VungleApiClient(@NonNull Context context, @NonNull com.vungle.warren.persistence.a aVar, @NonNull Repository repository, @NonNull OMInjector oMInjector, @NonNull com.vungle.warren.utility.platform.a aVar2) {
        this.f61839t = aVar;
        this.f61821b = context.getApplicationContext();
        this.f61843x = repository;
        this.f61845z = oMInjector;
        this.f61820a = aVar2;
        OkHttpClient.Builder builderAddInterceptor = new OkHttpClient.Builder().addInterceptor(new a());
        this.f61835p = builderAddInterceptor.build();
        OkHttpClient okHttpClientBuild = builderAddInterceptor.addInterceptor(new c()).build();
        v00.a aVar3 = new v00.a(this.f61835p, C);
        Vungle vungle = Vungle._instance;
        this.f61822c = aVar3.a(vungle.appID);
        this.f61837r = new v00.a(okHttpClientBuild, C).a(vungle.appID);
        this.f61841v = (com.vungle.warren.utility.u) t.f(context).h(com.vungle.warren.utility.u.class);
    }

    public static String l() {
        return B;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public v00.b<JsonObject> A(Collection<com.vungle.warren.model.h> collection) {
        if (this.f61830k == null) {
            throw new IllegalStateException("API Client not configured yet! Must call /config first.");
        }
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException("Cannot send analytics when bust and session data is empty");
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("device", i());
        jsonObject.add(MBridgeConstans.DYNAMIC_VIEW_WX_APP, this.f61832m);
        JsonObject jsonObject2 = new JsonObject();
        JsonArray jsonArray = new JsonArray(collection.size());
        for (com.vungle.warren.model.h hVar : collection) {
            for (int i11 = 0; i11 < hVar.b().length; i11++) {
                JsonObject jsonObject3 = new JsonObject();
                jsonObject3.addProperty("target", hVar.d() == 1 ? "campaign" : "creative");
                jsonObject3.addProperty("id", hVar.c());
                jsonObject3.addProperty("event_id", hVar.b()[i11]);
                jsonArray.add(jsonObject3);
            }
        }
        if (jsonArray.size() > 0) {
            jsonObject2.add("cache_bust", jsonArray);
        }
        jsonObject.add(PermissionConstant.ACTION_REQUEST, jsonObject2);
        return this.f61837r.sendBiAnalytics(l(), this.f61830k, jsonObject);
    }

    public v00.b<JsonObject> B(JsonObject jsonObject) {
        if (this.f61828i != null) {
            return this.f61837r.sendLog(l(), this.f61828i, jsonObject);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    public v00.b<JsonObject> C(@NonNull JsonArray jsonArray) {
        if (this.f61830k == null) {
            throw new IllegalStateException("API Client not configured yet! Must call /config first.");
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("device", i());
        jsonObject.add(MBridgeConstans.DYNAMIC_VIEW_WX_APP, this.f61832m);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.add("session_events", jsonArray);
        jsonObject.add(PermissionConstant.ACTION_REQUEST, jsonObject2);
        return this.f61837r.sendBiAnalytics(l(), this.f61830k, jsonObject);
    }

    public void D(String str) {
        E(str, this.f61832m);
    }

    public final void E(String str, JsonObject jsonObject) {
        jsonObject.addProperty("id", str);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public v00.b<JsonObject> F(String str, boolean z11, String str2) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("device", i());
        jsonObject.add(MBridgeConstans.DYNAMIC_VIEW_WX_APP, this.f61832m);
        jsonObject.add("user", q());
        JsonObject jsonObject2 = new JsonObject();
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty("reference_id", str);
        jsonObject3.addProperty("is_auto_cached", Boolean.valueOf(z11));
        jsonObject2.add("placement", jsonObject3);
        jsonObject2.addProperty("ad_token", str2);
        jsonObject.add(PermissionConstant.ACTION_REQUEST, jsonObject2);
        return this.f61836q.willPlayAd(l(), this.f61826g, jsonObject);
    }

    public void d(boolean z11) throws DatabaseHelper.DBException {
        com.vungle.warren.model.j jVar = new com.vungle.warren.model.j("isPlaySvcAvailable");
        jVar.e("isPlaySvcAvailable", Boolean.valueOf(z11));
        this.f61843x.h0(jVar);
    }

    public v00.b<JsonObject> e(long j11) {
        if (this.f61829j == null) {
            throw new IllegalStateException("API Client not configured yet! Must call /config first.");
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("device", i());
        jsonObject.add(MBridgeConstans.DYNAMIC_VIEW_WX_APP, this.f61832m);
        jsonObject.add("user", q());
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("last_cache_bust", Long.valueOf(j11));
        jsonObject.add(PermissionConstant.ACTION_REQUEST, jsonObject2);
        return this.f61837r.cacheBust(l(), this.f61829j, jsonObject);
    }

    public boolean f() {
        return this.f61833n && !TextUtils.isEmpty(this.f61826g);
    }

    public v00.e g() throws IOException, VungleException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("device", j(true));
        jsonObject.add(MBridgeConstans.DYNAMIC_VIEW_WX_APP, this.f61832m);
        jsonObject.add("user", q());
        JsonObject jsonObjectK = k();
        if (jsonObjectK != null) {
            jsonObject.add("ext", jsonObjectK);
        }
        v00.e<JsonObject> eVarExecute = this.f61822c.config(l(), jsonObject).execute();
        if (!eVarExecute.e()) {
            return eVarExecute;
        }
        JsonObject jsonObjectA = eVarExecute.a();
        String str = A;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Config Response: ");
        sb2.append(jsonObjectA);
        if (com.vungle.warren.model.l.e(jsonObjectA, "sleep")) {
            Log.e(str, "Error Initializing Vungle. Please try again. " + (com.vungle.warren.model.l.e(jsonObjectA, "info") ? jsonObjectA.get("info").getAsString() : ""));
            throw new VungleException(3);
        }
        if (!com.vungle.warren.model.l.e(jsonObjectA, "endpoints")) {
            Log.e(str, "Error Initializing Vungle. Please try again. ");
            throw new VungleException(3);
        }
        JsonObject asJsonObject = jsonObjectA.getAsJsonObject("endpoints");
        HttpUrl httpUrl = HttpUrl.parse(asJsonObject.get("new").getAsString());
        HttpUrl httpUrl2 = HttpUrl.parse(asJsonObject.get(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS).getAsString());
        HttpUrl httpUrl3 = HttpUrl.parse(asJsonObject.get("will_play_ad").getAsString());
        HttpUrl httpUrl4 = HttpUrl.parse(asJsonObject.get("report_ad").getAsString());
        HttpUrl httpUrl5 = HttpUrl.parse(asJsonObject.get("ri").getAsString());
        HttpUrl httpUrl6 = HttpUrl.parse(asJsonObject.get("log").getAsString());
        HttpUrl httpUrl7 = HttpUrl.parse(asJsonObject.get("cache_bust").getAsString());
        HttpUrl httpUrl8 = HttpUrl.parse(asJsonObject.get("sdk_bi").getAsString());
        if (httpUrl == null || httpUrl2 == null || httpUrl3 == null || httpUrl4 == null || httpUrl5 == null || httpUrl6 == null || httpUrl7 == null || httpUrl8 == null) {
            Log.e(str, "Error Initializing Vungle. Please try again. ");
            throw new VungleException(3);
        }
        this.f61823d = httpUrl.toString();
        this.f61824e = httpUrl2.toString();
        this.f61826g = httpUrl3.toString();
        this.f61825f = httpUrl4.toString();
        this.f61827h = httpUrl5.toString();
        this.f61828i = httpUrl6.toString();
        this.f61829j = httpUrl7.toString();
        this.f61830k = httpUrl8.toString();
        JsonObject asJsonObject2 = jsonObjectA.getAsJsonObject("will_play_ad");
        this.f61834o = asJsonObject2.get("request_timeout").getAsInt();
        this.f61833n = asJsonObject2.get("enabled").getAsBoolean();
        this.f61838s = com.vungle.warren.model.l.a(jsonObjectA.getAsJsonObject("viewability"), "om", false);
        if (this.f61833n) {
            Log.v(str, "willPlayAd is enabled, generating a timeout client.");
            this.f61836q = new v00.a(this.f61835p.newBuilder().readTimeout(this.f61834o, TimeUnit.MILLISECONDS).build(), "https://api.vungle.com/").a(Vungle._instance.appID);
        }
        if (m()) {
            this.f61845z.c();
        } else {
            SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.OM_SDK).b(SessionAttribute.ENABLED, false).c());
        }
        return eVarExecute;
    }

    public final String h(int i11) {
        switch (i11) {
            case 1:
                return "gprs";
            case 2:
                return "edge";
            case 3:
            case 10:
            case 11:
            default:
                return AppLovinMediationProvider.UNKNOWN;
            case 4:
                return "wcdma";
            case 5:
                return "cdma_evdo_0";
            case 6:
                return "cdma_evdo_a";
            case 7:
                return "cdma_1xrtt";
            case 8:
                return "hsdpa";
            case 9:
                return "hsupa";
            case 12:
                return "cdma_evdo_b";
            case 13:
                return "LTE";
            case 14:
                return "hrpd";
        }
    }

    @SuppressLint({"HardwareIds", "NewApi"})
    public final JsonObject i() throws IllegalStateException {
        return j(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:155:0x0307, code lost:
    
        r12 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.gson.JsonObject] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    @SuppressLint({"HardwareIds", "NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized JsonObject j(boolean z11) throws IllegalStateException {
        ?? DeepCopy;
        String str;
        boolean zHasSystemFeature;
        boolean zCanRequestPackageInstalls;
        String str2;
        NetworkInfo activeNetworkInfo;
        try {
            DeepCopy = this.f61831l.deepCopy();
            JsonObject jsonObject = new JsonObject();
            com.vungle.warren.model.d dVarB = this.f61820a.b();
            boolean z12 = dVarB.f62163b;
            String str3 = dVarB.f62162a;
            if (PrivacyManager.d().f()) {
                if (str3 != null) {
                    jsonObject.addProperty("Amazon".equals(Build.MANUFACTURER) ? "amazon_advertising_id" : "gaid", str3);
                    DeepCopy.addProperty("ifa", str3);
                } else {
                    String strH = this.f61820a.h();
                    DeepCopy.addProperty("ifa", !TextUtils.isEmpty(strH) ? strH : "");
                    if (!TextUtils.isEmpty(strH)) {
                        jsonObject.addProperty("android_id", strH);
                    }
                }
            }
            if (!PrivacyManager.d().f() || z11) {
                DeepCopy.remove("ifa");
                jsonObject.remove("android_id");
                jsonObject.remove("gaid");
                jsonObject.remove("amazon_advertising_id");
            }
            ?? Equals = 0;
            DeepCopy.addProperty("lmt", Integer.valueOf(z12 ? 1 : 0));
            jsonObject.addProperty("is_google_play_services_available", Boolean.valueOf(Boolean.TRUE.equals(u())));
            String strD = this.f61820a.d();
            if (!TextUtils.isEmpty(strD)) {
                jsonObject.addProperty("app_set_id", strD);
            }
            Context context = this.f61821b;
            Intent intentRegisterReceiver = context != null ? context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")) : null;
            if (intentRegisterReceiver != null) {
                int intExtra = intentRegisterReceiver.getIntExtra("level", -1);
                int intExtra2 = intentRegisterReceiver.getIntExtra("scale", -1);
                if (intExtra > 0 && intExtra2 > 0) {
                    jsonObject.addProperty("battery_level", Float.valueOf(intExtra / intExtra2));
                }
                int intExtra3 = intentRegisterReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
                if (intExtra3 == -1) {
                    str = "UNKNOWN";
                } else if (intExtra3 == 2 || intExtra3 == 5) {
                    int intExtra4 = intentRegisterReceiver.getIntExtra("plugged", -1);
                    if (intExtra4 == 1) {
                        str = "BATTERY_PLUGGED_AC";
                    } else if (intExtra4 != 2) {
                        str = intExtra4 != 4 ? "BATTERY_PLUGGED_OTHERS" : "BATTERY_PLUGGED_WIRELESS";
                    } else {
                        str = "BATTERY_PLUGGED_USB";
                    }
                } else {
                    str = "NOT_CHARGING";
                }
            } else {
                str = "UNKNOWN";
            }
            jsonObject.addProperty("battery_state", str);
            PowerManager powerManager = (PowerManager) this.f61821b.getSystemService("power");
            jsonObject.addProperty("battery_saver_enabled", Integer.valueOf((powerManager == null || !powerManager.isPowerSaveMode()) ? 0 : 1));
            if (z2.f.a(this.f61821b, "android.permission.ACCESS_NETWORK_STATE") == 0) {
                String str4 = "NONE";
                String strH2 = AppLovinMediationProvider.UNKNOWN;
                ConnectivityManager connectivityManager = (ConnectivityManager) this.f61821b.getSystemService("connectivity");
                if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                    int type = activeNetworkInfo.getType();
                    if (type == 0) {
                        str4 = "MOBILE";
                        strH2 = h(activeNetworkInfo.getSubtype());
                    } else if (type == 1 || type == 6) {
                        str4 = "WIFI";
                    } else if (type != 7) {
                        str4 = type != 9 ? "UNKNOWN" : "ETHERNET";
                    } else {
                        str4 = "BLUETOOTH";
                    }
                }
                jsonObject.addProperty("connection_type", str4);
                jsonObject.addProperty("connection_type_detail", strH2);
                if (Build.VERSION.SDK_INT >= 24) {
                    if (connectivityManager.isActiveNetworkMetered()) {
                        int restrictBackgroundStatus = connectivityManager.getRestrictBackgroundStatus();
                        if (restrictBackgroundStatus == 1) {
                            str2 = "DISABLED";
                        } else if (restrictBackgroundStatus != 2) {
                            str2 = restrictBackgroundStatus != 3 ? "UNKNOWN" : "ENABLED";
                        } else {
                            str2 = "WHITELISTED";
                        }
                        jsonObject.addProperty("data_saver_status", str2);
                        jsonObject.addProperty("network_metered", (Number) 1);
                    } else {
                        jsonObject.addProperty("data_saver_status", "NOT_APPLICABLE");
                        jsonObject.addProperty("network_metered", (Number) 0);
                    }
                }
            }
            jsonObject.addProperty("locale", Locale.getDefault().toString());
            jsonObject.addProperty("language", Locale.getDefault().getLanguage());
            jsonObject.addProperty("time_zone", TimeZone.getDefault().getID());
            AudioManager audioManager = (AudioManager) this.f61821b.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            if (audioManager != null) {
                int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                int streamVolume = audioManager.getStreamVolume(3);
                jsonObject.addProperty("volume_level", Float.valueOf(streamVolume / streamMaxVolume));
                jsonObject.addProperty("sound_enabled", Integer.valueOf(streamVolume > 0 ? 1 : 0));
            }
            File fileG = this.f61839t.g();
            fileG.getPath();
            if (fileG.exists() && fileG.isDirectory()) {
                jsonObject.addProperty("storage_bytes_available", Long.valueOf(this.f61839t.e()));
            }
            if ("Amazon".equals(Build.MANUFACTURER)) {
                zHasSystemFeature = this.f61821b.getApplicationContext().getPackageManager().hasSystemFeature("amazon.hardware.fire_tv");
            } else {
                zHasSystemFeature = Build.VERSION.SDK_INT < 23 ? this.f61821b.getApplicationContext().getPackageManager().hasSystemFeature("com.google.android.tv") || !this.f61821b.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.touchscreen") : ((UiModeManager) this.f61821b.getSystemService("uimode")).getCurrentModeType() == 4;
            }
            jsonObject.addProperty("is_tv", Boolean.valueOf(zHasSystemFeature));
            int i11 = Build.VERSION.SDK_INT;
            jsonObject.addProperty("os_api_level", Integer.valueOf(i11));
            jsonObject.addProperty("app_target_sdk_version", Integer.valueOf(this.f61821b.getApplicationInfo().targetSdkVersion));
            if (i11 >= 24) {
                jsonObject.addProperty("app_min_sdk_version", Integer.valueOf(this.f61821b.getApplicationInfo().minSdkVersion));
            }
            try {
                if (i11 >= 26) {
                    zCanRequestPackageInstalls = this.f61821b.checkCallingOrSelfPermission("android.permission.REQUEST_INSTALL_PACKAGES") == 0 ? this.f61821b.getApplicationContext().getPackageManager().canRequestPackageInstalls() : false;
                } else {
                    zCanRequestPackageInstalls = Settings.Secure.getInt(this.f61821b.getContentResolver(), "install_non_market_apps") == 1;
                }
            } catch (Settings.SettingNotFoundException e11) {
                Log.e(A, "isInstallNonMarketAppsEnabled Settings not found", e11);
            }
            jsonObject.addProperty("is_sideload_enabled", Boolean.valueOf(zCanRequestPackageInstalls));
            try {
                Equals = Environment.getExternalStorageState().equals("mounted");
            } catch (Exception unused) {
                Log.e(A, "External storage state failed");
            }
            jsonObject.addProperty("sd_card_available", Integer.valueOf((int) Equals));
            jsonObject.addProperty("os_name", Build.FINGERPRINT);
            jsonObject.addProperty("vduid", "");
            DeepCopy.addProperty("ua", this.f61844y);
            JsonObject jsonObject2 = new JsonObject();
            JsonObject jsonObject3 = new JsonObject();
            jsonObject2.add("vungle", jsonObject3);
            DeepCopy.add("ext", jsonObject2);
            jsonObject3.add("Amazon".equals(Build.MANUFACTURER) ? "amazon" : "android", jsonObject);
        } catch (Throwable th2) {
            throw th2;
        }
        return DeepCopy;
    }

    public final JsonObject k() {
        com.vungle.warren.model.j jVar = (com.vungle.warren.model.j) this.f61843x.T("config_extension", com.vungle.warren.model.j.class).get(this.f61841v.a(), TimeUnit.MILLISECONDS);
        String strD = jVar != null ? jVar.d("config_extension") : "";
        if (TextUtils.isEmpty(strD)) {
            return null;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("config_extension", strD);
        return jsonObject;
    }

    public boolean m() {
        return this.f61838s;
    }

    public Boolean n() {
        Boolean boolValueOf = null;
        try {
            GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.getInstance();
            if (googleApiAvailabilityLight == null) {
                return null;
            }
            boolValueOf = Boolean.valueOf(googleApiAvailabilityLight.isGooglePlayServicesAvailable(this.f61821b) == 0);
            d(boolValueOf.booleanValue());
            return boolValueOf;
        } catch (Exception unused) {
            Log.w(A, "Unexpected exception from Play services lib.");
            return boolValueOf;
        } catch (NoClassDefFoundError unused2) {
            Log.w(A, "Play services Not available");
            Boolean bool = Boolean.FALSE;
            try {
                d(false);
                return bool;
            } catch (DatabaseHelper.DBException unused3) {
                Log.w(A, "Failure to write GPS availability to DB");
                return bool;
            }
        }
    }

    public Boolean o() {
        com.vungle.warren.model.j jVar = (com.vungle.warren.model.j) this.f61843x.T("isPlaySvcAvailable", com.vungle.warren.model.j.class).get(this.f61841v.a(), TimeUnit.MILLISECONDS);
        if (jVar != null) {
            return jVar.a("isPlaySvcAvailable");
        }
        return null;
    }

    public long p(v00.e eVar) {
        try {
            return Long.parseLong(eVar.d().get("Retry-After")) * 1000;
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    public final JsonObject q() {
        String strD;
        String strD2;
        long jLongValue;
        String strD3;
        JsonObject jsonObject = new JsonObject();
        com.vungle.warren.model.j jVar = (com.vungle.warren.model.j) this.f61843x.T("consentIsImportantToVungle", com.vungle.warren.model.j.class).get(this.f61841v.a(), TimeUnit.MILLISECONDS);
        if (jVar != null) {
            strD = jVar.d("consent_status");
            strD2 = jVar.d("consent_source");
            jLongValue = jVar.c(CampaignEx.JSON_KEY_TIMESTAMP).longValue();
            strD3 = jVar.d("consent_message_version");
        } else {
            strD = AppLovinMediationProvider.UNKNOWN;
            strD2 = "no_interaction";
            jLongValue = 0;
            strD3 = "";
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("consent_status", strD);
        jsonObject2.addProperty("consent_source", strD2);
        jsonObject2.addProperty("consent_timestamp", Long.valueOf(jLongValue));
        jsonObject2.addProperty("consent_message_version", TextUtils.isEmpty(strD3) ? "" : strD3);
        jsonObject.add("gdpr", jsonObject2);
        com.vungle.warren.model.j jVar2 = (com.vungle.warren.model.j) this.f61843x.T("ccpaIsImportantToVungle", com.vungle.warren.model.j.class).get();
        String strD4 = jVar2 != null ? jVar2.d("ccpa_status") : "opted_in";
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty(NotificationCompat.CATEGORY_STATUS, strD4);
        jsonObject.add("ccpa", jsonObject3);
        if (PrivacyManager.d().c() != PrivacyManager.COPPA.COPPA_NOTSET) {
            JsonObject jsonObject4 = new JsonObject();
            jsonObject4.addProperty("is_coppa", Boolean.valueOf(PrivacyManager.d().c().getValue()));
            jsonObject.add("coppa", jsonObject4);
        }
        return jsonObject;
    }

    public void r() {
        s(this.f61821b);
    }

    public synchronized void s(Context context) {
        String str;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("bundle", context.getPackageName());
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str = null;
        }
        if (str == null) {
            str = "1.0";
        }
        jsonObject.addProperty("ver", str);
        JsonObject jsonObject2 = new JsonObject();
        String str2 = Build.MANUFACTURER;
        jsonObject2.addProperty("make", str2);
        jsonObject2.addProperty("model", Build.MODEL);
        jsonObject2.addProperty("osv", Build.VERSION.RELEASE);
        jsonObject2.addProperty("carrier", ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName());
        jsonObject2.addProperty("os", "Amazon".equals(str2) ? "amazon" : "android");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        jsonObject2.addProperty("w", Integer.valueOf(displayMetrics.widthPixels));
        jsonObject2.addProperty("h", Integer.valueOf(displayMetrics.heightPixels));
        try {
            String strA = this.f61820a.a();
            this.f61844y = strA;
            jsonObject2.addProperty("ua", strA);
            t();
        } catch (Exception e11) {
            Log.e(A, "Cannot Get UserAgent. Setting Default Device UserAgent." + e11.getLocalizedMessage());
        }
        this.f61831l = jsonObject2;
        this.f61832m = jsonObject;
        this.f61840u = n();
    }

    public final void t() {
        this.f61820a.j(new b());
    }

    public Boolean u() {
        if (this.f61840u == null) {
            this.f61840u = o();
        }
        if (this.f61840u == null) {
            this.f61840u = n();
        }
        return this.f61840u;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x007c A[Catch: IOException -> 0x00a7, TryCatch #0 {IOException -> 0x00a7, blocks: (B:19:0x006e, B:21:0x007c, B:24:0x00a9, B:26:0x00af), top: B:35:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:24:0x00a9 A[Catch: IOException -> 0x00a7, TryCatch #0 {IOException -> 0x00a7, blocks: (B:19:0x006e, B:21:0x007c, B:24:0x00a9, B:26:0x00af), top: B:35:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:26:0x00af A[Catch: IOException -> 0x00a7, TRY_LEAVE, TryCatch #0 {IOException -> 0x00a7, blocks: (B:19:0x006e, B:21:0x007c, B:24:0x00a9, B:26:0x00af), top: B:35:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:26:0x00af, please report this as an issue */
    public boolean v(String str) throws MalformedURLException, ClearTextTrafficException {
        boolean zIsCleartextTrafficPermitted;
        v00.e<Void> eVarExecute;
        if (TextUtils.isEmpty(str) || HttpUrl.parse(str) == null) {
            SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.TPAT).b(SessionAttribute.SUCCESS, false).a(SessionAttribute.REASON, "Invalid URL").a(SessionAttribute.URL, str).c());
            throw new MalformedURLException("Invalid URL : " + str);
        }
        try {
            String host = new URL(str).getHost();
            int i11 = Build.VERSION.SDK_INT;
            try {
                if (i11 < 24) {
                    if (i11 >= 23) {
                        zIsCleartextTrafficPermitted = NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
                    }
                    eVarExecute = this.f61822c.pingTPAT(this.f61844y, str).execute();
                    if (eVarExecute == null) {
                        SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.TPAT).b(SessionAttribute.SUCCESS, false).a(SessionAttribute.REASON, "Error on pinging TPAT").a(SessionAttribute.URL, str).c());
                        return true;
                    }
                    if (!eVarExecute.e()) {
                        return true;
                    }
                    SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.TPAT).b(SessionAttribute.SUCCESS, false).a(SessionAttribute.REASON, eVarExecute.b() + ": " + eVarExecute.f()).a(SessionAttribute.URL, str).c());
                    return true;
                }
                zIsCleartextTrafficPermitted = NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(host);
                eVarExecute = this.f61822c.pingTPAT(this.f61844y, str).execute();
                if (eVarExecute == null) {
                    SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.TPAT).b(SessionAttribute.SUCCESS, false).a(SessionAttribute.REASON, "Error on pinging TPAT").a(SessionAttribute.URL, str).c());
                    return true;
                }
                if (!eVarExecute.e()) {
                    return true;
                }
                SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.TPAT).b(SessionAttribute.SUCCESS, false).a(SessionAttribute.REASON, eVarExecute.b() + ": " + eVarExecute.f()).a(SessionAttribute.URL, str).c());
                return true;
            } catch (IOException e11) {
                SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.TPAT).b(SessionAttribute.SUCCESS, false).a(SessionAttribute.REASON, e11.getMessage()).a(SessionAttribute.URL, str).c());
                return false;
            }
            if (!zIsCleartextTrafficPermitted && URLUtil.isHttpUrl(str)) {
                SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.TPAT).b(SessionAttribute.SUCCESS, false).a(SessionAttribute.REASON, "Clear Text Traffic is blocked").a(SessionAttribute.URL, str).c());
                throw new ClearTextTrafficException("Clear Text Traffic is blocked");
            }
        } catch (MalformedURLException unused) {
            SessionTracker.l().w(new com.vungle.warren.model.p.b().d(SessionEvent.TPAT).b(SessionAttribute.SUCCESS, false).a(SessionAttribute.REASON, "Invalid URL").a(SessionAttribute.URL, str).c());
            throw new MalformedURLException("Invalid URL : " + str);
        }
    }

    public v00.b<JsonObject> w(JsonObject jsonObject) {
        if (this.f61825f == null) {
            throw new IllegalStateException("API Client not configured yet! Must call /config first.");
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.add("device", i());
        jsonObject2.add(MBridgeConstans.DYNAMIC_VIEW_WX_APP, this.f61832m);
        jsonObject2.add(PermissionConstant.ACTION_REQUEST, jsonObject);
        jsonObject2.add("user", q());
        JsonObject jsonObjectK = k();
        if (jsonObjectK != null) {
            jsonObject2.add("ext", jsonObjectK);
        }
        return this.f61837r.reportAd(l(), this.f61825f, jsonObject2);
    }

    public v00.b<JsonObject> x() throws IllegalStateException {
        if (this.f61823d == null) {
            throw new IllegalStateException("API Client not configured yet! Must call /config first.");
        }
        HashMap map = new HashMap(2);
        JsonElement jsonElement = this.f61832m.get("id");
        map.put("app_id", jsonElement != null ? jsonElement.getAsString() : "");
        JsonObject jsonObjectI = i();
        if (PrivacyManager.d().f()) {
            JsonElement jsonElement2 = jsonObjectI.get("ifa");
            map.put("ifa", jsonElement2 != null ? jsonElement2.getAsString() : "");
        }
        return this.f61822c.reportNew(l(), this.f61823d, map);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public v00.b<JsonObject> y(String str, String str2, boolean z11, @Nullable JsonObject jsonObject) throws IllegalStateException {
        if (this.f61824e == null) {
            throw new IllegalStateException("API Client not configured yet! Must call /config first.");
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.add("device", i());
        jsonObject2.add(MBridgeConstans.DYNAMIC_VIEW_WX_APP, this.f61832m);
        JsonObject jsonObjectQ = q();
        if (jsonObject != null) {
            jsonObjectQ.add("vision", jsonObject);
        }
        jsonObject2.add("user", jsonObjectQ);
        JsonObject jsonObjectK = k();
        if (jsonObjectK != null) {
            jsonObject2.add("ext", jsonObjectK);
        }
        JsonObject jsonObject3 = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(str);
        jsonObject3.add("placements", jsonArray);
        jsonObject3.addProperty("header_bidding", Boolean.valueOf(z11));
        if (!TextUtils.isEmpty(str2)) {
            jsonObject3.addProperty("ad_size", str2);
        }
        jsonObject2.add(PermissionConstant.ACTION_REQUEST, jsonObject3);
        return this.f61837r.ads(l(), this.f61824e, jsonObject2);
    }

    public v00.b<JsonObject> z(JsonObject jsonObject) {
        if (this.f61827h == null) {
            throw new IllegalStateException("API Client not configured yet! Must call /config first.");
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.add("device", i());
        jsonObject2.add(MBridgeConstans.DYNAMIC_VIEW_WX_APP, this.f61832m);
        jsonObject2.add(PermissionConstant.ACTION_REQUEST, jsonObject);
        jsonObject2.add("user", q());
        JsonObject jsonObjectK = k();
        if (jsonObjectK != null) {
            jsonObject2.add("ext", jsonObjectK);
        }
        return this.f61822c.ri(l(), this.f61827h, jsonObject2);
    }
}
