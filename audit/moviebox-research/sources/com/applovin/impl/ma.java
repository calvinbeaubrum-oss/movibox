package com.applovin.impl;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ma {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f20638g = (int) TimeUnit.SECONDS.toMillis(30);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f20639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExecutorService f20640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f20641c = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f20642d = Collections.synchronizedSet(new HashSet());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f20643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final com.applovin.impl.sdk.n f20644f;

    /* JADX INFO: compiled from: source.java */
    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.j f20645a;

        /* JADX INFO: renamed from: com.applovin.impl.ma$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0186a implements Thread.UncaughtExceptionHandler {
            public C0186a() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th2) {
                a.this.f20645a.J();
                if (com.applovin.impl.sdk.n.a()) {
                    a.this.f20645a.J().a("HealthEventsReporter", "Caught unhandled exception", th2);
                }
            }
        }

        public a(com.applovin.impl.sdk.j jVar) {
            this.f20645a = jVar;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "AppLovinSdk:health_events_reporter");
            thread.setDaemon(true);
            thread.setPriority(((Integer) this.f20645a.a(sj.Y)).intValue());
            thread.setUncaughtExceptionHandler(new C0186a());
            return thread;
        }
    }

    public ma(com.applovin.impl.sdk.j jVar) {
        this.f20643e = jVar;
        this.f20644f = jVar.J();
        this.f20640b = Executors.newFixedThreadPool(1, new a(jVar));
    }

    private AppLovinAdSize a(h0 h0Var, com.applovin.impl.sdk.ad.b bVar) {
        AppLovinAdSize appLovinAdSizeF = h0Var != null ? h0Var.f() : null;
        if (appLovinAdSizeF != null) {
            return appLovinAdSizeF;
        }
        if (bVar != null) {
            return bVar.getSize();
        }
        return null;
    }

    private URL a(la laVar, Object obj, Map map) throws UnsupportedEncodingException {
        StringBuilder sb2 = new StringBuilder("https://ms.applovin.com/1.0/sdk/error");
        sb2.append("?");
        Iterator it = b(laVar, obj, map).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String strEncode = URLEncoder.encode((String) entry.getKey(), "UTF-8");
            String strEncode2 = URLEncoder.encode((String) entry.getValue(), "UTF-8");
            sb2.append(strEncode);
            sb2.append("=");
            sb2.append(strEncode2);
            if (it.hasNext()) {
                sb2.append("&");
            }
        }
        return new URL(sb2.toString());
    }

    private List a(String str) {
        List<Integer> integerList = JsonUtils.getIntegerList(this.f20639a, StringUtils.getHost(str), null);
        return integerList == null ? JsonUtils.getIntegerList(this.f20639a, TmcEngineFactory.ENGINE_TYPE_DEFAULT, null) : integerList;
    }

    public static Map a(ge geVar) {
        Map mapA = a((pe) geVar);
        CollectionUtils.putStringIfValid("bcode", geVar.C(), mapA);
        CollectionUtils.putStringIfValid(CampaignEx.JSON_KEY_CREATIVE_ID, geVar.getCreativeId(), mapA);
        CollectionUtils.putStringIfValid("ad_unit_id", geVar.getAdUnitId(), mapA);
        CollectionUtils.putStringIfValid("ad_format", geVar.getFormat().getLabel(), mapA);
        return mapA;
    }

    public static Map a(pe peVar) {
        HashMap map = new HashMap(3);
        CollectionUtils.putStringIfValid("network_name", peVar.c(), map);
        String strB = peVar.b();
        CollectionUtils.putStringIfValid("adapter_class", peVar.b(), map);
        CollectionUtils.putStringIfValid("adapter_version", af.a(strB).getAdapterVersion(), map);
        return map;
    }

    public static Map a(com.applovin.impl.sdk.ad.b bVar) {
        HashMap map = new HashMap(8);
        if (bVar != null) {
            CollectionUtils.putStringIfValid("ad_domain", bVar.getAdDomain(), map);
            CollectionUtils.putStringIfValid("ad_id", String.valueOf(bVar.getAdIdNumber()), map);
            MaxAdFormat maxAdFormatD = bVar.getAdZone().d();
            CollectionUtils.putStringIfValid("ad_format", maxAdFormatD != null ? maxAdFormatD.getLabel() : null, map);
            CollectionUtils.putStringIfValid("ad_zone_id", bVar.getAdZone().e(), map);
            CollectionUtils.putStringIfValid("clcode", bVar.getClCode(), map);
            CollectionUtils.putStringIfValid("dsp_id", bVar.getDspId(), map);
            CollectionUtils.putStringIfValid("dsp_name", bVar.getDspName(), map);
            CollectionUtils.putStringIfValid("ad_size", bVar.getSize().getLabel(), map);
        }
        return map;
    }

    public static Map a(MaxError maxError) {
        HashMap map = new HashMap(4);
        CollectionUtils.putStringIfValid(TrackingKey.ERROR_MESSAGE, maxError.getMessage(), map);
        CollectionUtils.putStringIfValid(TrackingKey.ERROR_CODE, String.valueOf(maxError.getCode()), map);
        CollectionUtils.putStringIfValid("mediated_network_error_message", maxError.getMediatedNetworkErrorMessage(), map);
        CollectionUtils.putStringIfValid("mediated_network_error_code", String.valueOf(maxError.getMediatedNetworkErrorCode()), map);
        return map;
    }

    private JSONObject a(la laVar, double d11, Object obj, List list) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putLong(jSONObject, "ts_ms", System.currentTimeMillis());
        if (laVar == la.F || laVar == la.T || laVar == la.R) {
            if (((Boolean) this.f20643e.a(sj.f23097x4)).booleanValue()) {
                JsonUtils.putStringIfValid(jSONObject, "wvvc", String.valueOf(sr.d()));
                JsonUtils.putStringIfValid(jSONObject, "wvv", sr.c());
                JsonUtils.putStringIfValid(jSONObject, "wvpn", sr.b());
            }
            JsonUtils.putStringIfValid(jSONObject, "oglv", this.f20643e.y().D());
        }
        JSONObject jSONObject2 = new JSONObject();
        Map mapG = this.f20643e.y().G();
        JsonUtils.putObject(jSONObject2, TrackingKey.PLATFORM, mapG.get(TrackingKey.PLATFORM));
        JsonUtils.putObject(jSONObject2, "os", mapG.get("os"));
        JsonUtils.putObject(jSONObject2, "brand", mapG.get("brand"));
        JsonUtils.putObject(jSONObject2, "model", mapG.get("model"));
        JsonUtils.putObject(jSONObject2, "revision", mapG.get("revision"));
        JsonUtils.putObject(jSONObject2, "country_code", mapG.get("country_code"));
        JsonUtils.putObject(jSONObject2, "cc", this.f20643e.r().getCountryCode());
        JsonUtils.putObject(jSONObject2, "applovin_random_token", this.f20643e.a0());
        JsonUtils.putObject(jSONObject2, "ad_review_sdk_version", StringUtils.emptyIfNull(v.b()));
        Map mapA = this.f20643e.y().A();
        JsonUtils.putObject(jSONObject2, "sdk_version", mapA.get("sdk_version"));
        JsonUtils.putObject(jSONObject2, "app_version", mapA.get("app_version"));
        JsonUtils.putObject(jSONObject2, "package_name", mapA.get("package_name"));
        JsonUtils.putObject(jSONObject2, "first_install", Boolean.toString(Boolean.TRUE.equals((Boolean) mapA.get("first_install_v2"))));
        JsonUtils.putObject(jSONObject2, "md", this.f20643e.a(sj.f23076v));
        JsonUtils.putObject(jSONObject2, "mediation_provider", this.f20643e.O());
        JsonUtils.putObject(jSONObject, "shared_fields", jSONObject2);
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            JSONObject jSONObject3 = new JSONObject();
            JsonUtils.putDouble(jSONObject3, "ts_ms", System.currentTimeMillis());
            JsonUtils.putString(jSONObject3, "type", laVar.b());
            JsonUtils.putDouble(jSONObject3, "weight", d11);
            JsonUtils.putString(jSONObject3, "level", "DEBUG");
            a(obj, map);
            JsonUtils.putAll(jSONObject3, (Map<String, ?>) map);
            jSONArray.put(jSONObject3);
        }
        JsonUtils.putObject(jSONObject, "events", jSONArray);
        return jSONObject;
    }

    private void a(la laVar, h0 h0Var, com.applovin.impl.sdk.ad.b bVar, AppLovinError appLovinError) {
        if (((Boolean) this.f20643e.a(sj.R)).booleanValue() && this.f20643e.A0()) {
            return;
        }
        HashMap map = new HashMap();
        if (bVar != null) {
            map.putAll(a(bVar));
        }
        if (h0Var != null) {
            CollectionUtils.putStringIfValid("ad_zone_id", h0Var.e(), map);
            MaxAdFormat maxAdFormatD = h0Var.d();
            if (maxAdFormatD != null) {
                CollectionUtils.putStringIfValid("ad_format", maxAdFormatD.getLabel(), map);
            }
        }
        AppLovinAdSize appLovinAdSizeA = a(h0Var, bVar);
        if (appLovinAdSizeA != null) {
            CollectionUtils.putStringIfValid("ad_size", appLovinAdSizeA.getLabel(), map);
        }
        if (appLovinError != null) {
            CollectionUtils.putStringIfValid(TrackingKey.ERROR_MESSAGE, appLovinError.getMessage(), map);
            CollectionUtils.putStringIfValid(TrackingKey.ERROR_CODE, String.valueOf(appLovinError.getCode()), map);
        }
        a(laVar, (Map) map);
    }

    private void a(la laVar, MaxAdFormat maxAdFormat, String str, ge geVar, MaxError maxError) {
        HashMap map = new HashMap();
        if (geVar != null) {
            map.putAll(a(geVar));
        } else {
            CollectionUtils.putStringIfValid("ad_unit_id", str, map);
            CollectionUtils.putStringIfValid("ad_format", maxAdFormat.getLabel(), map);
        }
        if (maxError != null) {
            CollectionUtils.putStringIfValid(TrackingKey.ERROR_MESSAGE, maxError.getMessage(), map);
            CollectionUtils.putStringIfValid(TrackingKey.ERROR_CODE, String.valueOf(maxError.getCode()), map);
            CollectionUtils.putStringIfValid("mediated_network_error_message", maxError.getMediatedNetworkErrorMessage(), map);
            CollectionUtils.putStringIfValid("mediated_network_error_code", String.valueOf(maxError.getMediatedNetworkErrorCode()), map);
        }
        a(laVar, (Map) map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(la laVar, Object obj, List list) {
        if (AppLovinSdkUtils.isEmulator()) {
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f20644f.a("HealthEventsReporter", "Reporting " + laVar.b() + " with extra parameters collection " + list);
        }
        c(laVar, obj, list);
        d(laVar, obj, list);
    }

    private void a(Object obj, Map map) {
        if (map == null) {
            return;
        }
        if (obj == null) {
            obj = this.f20643e.C().a();
        }
        if (obj instanceof com.applovin.impl.sdk.ad.b) {
            map.put("fs_ad_network", "AppLovin");
            map.put("fs_ad_creative_id", Long.toString(((com.applovin.impl.sdk.ad.b) obj).getAdIdNumber()));
        } else if (!(obj instanceof ge)) {
            map.put("fs_ad_network", "None");
            map.put("fs_ad_creative_id", "None");
        } else {
            ge geVar = (ge) obj;
            map.put("fs_ad_network", geVar.getNetworkName());
            map.put("fs_ad_creative_id", geVar.getCreativeId());
        }
    }

    private void a(Map map) {
        String packageName;
        PackageInfo packageInfo;
        try {
            PackageManager packageManager = com.applovin.impl.sdk.j.l().getPackageManager();
            packageName = com.applovin.impl.sdk.j.l().getPackageName();
            try {
                packageInfo = packageManager.getPackageInfo(packageName, 0);
            } catch (Throwable unused) {
                packageInfo = null;
            }
        } catch (Throwable unused2) {
            packageName = "";
        }
        map.put("package_name", packageName);
        map.put("app_version", packageInfo != null ? packageInfo.versionName : "");
        map.put("app_version_code", String.valueOf(packageInfo != null ? packageInfo.versionCode : 0));
    }

    private boolean a(la laVar, long j11) {
        Long l11 = (Long) this.f20641c.get(laVar);
        return System.currentTimeMillis() - (l11 != null ? l11.longValue() : -1L) < j11;
    }

    private Map b(la laVar, Object obj, Map map) {
        HashMap map2 = new HashMap();
        map2.put("type", laVar.b());
        if (laVar == la.F || laVar == la.T || laVar == la.R) {
            if (((Boolean) this.f20643e.a(sj.f23097x4)).booleanValue()) {
                CollectionUtils.putStringIfValid("wvvc", String.valueOf(sr.d()), map2);
                CollectionUtils.putStringIfValid("wvv", sr.c(), map2);
                CollectionUtils.putStringIfValid("wvpn", sr.b(), map2);
            }
            CollectionUtils.putStringIfValid("oglv", this.f20643e.y().D(), map2);
        }
        Map mapG = this.f20643e.y().G();
        map2.put(TrackingKey.PLATFORM, String.valueOf(mapG.get(TrackingKey.PLATFORM)));
        map2.put("country_code", String.valueOf(mapG.get("country_code")));
        map2.put("cc", this.f20643e.r().getCountryCode());
        map2.put("applovin_random_token", this.f20643e.a0());
        map2.put("compass_random_token", this.f20643e.q());
        map2.put("model", Build.MODEL);
        map2.put("brand", Build.MANUFACTURER);
        map2.put("brand_name", Build.BRAND);
        map2.put("hardware", Build.HARDWARE);
        map2.put("revision", Build.DEVICE);
        map2.put("os", Build.VERSION.RELEASE);
        map2.put("api_level", String.valueOf(Build.VERSION.SDK_INT));
        map2.put("sdk_version", String.valueOf(AppLovinSdk.VERSION));
        CollectionUtils.putStringIfValid("ad_review_sdk_version", v.b(), map2);
        map2.put("md", (String) this.f20643e.a(sj.f23076v));
        a(map2);
        a(obj, map2);
        if (map != null) {
            map2.putAll(map);
        }
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(String str, la laVar, Object obj, JSONObject jSONObject) {
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(str);
            byte[] bytes = jSONObject.toString().getBytes("UTF-8");
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
            try {
                int i11 = f20638g;
                httpURLConnection2.setConnectTimeout(i11);
                httpURLConnection2.setReadTimeout(i11);
                httpURLConnection2.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
                httpURLConnection2.setDefaultUseCaches(false);
                httpURLConnection2.setAllowUserInteraction(false);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setInstanceFollowRedirects(true);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setFixedLengthStreamingMode(bytes.length);
                httpURLConnection2.setRequestMethod("POST");
                OutputStream outputStream = httpURLConnection2.getOutputStream();
                outputStream.write(bytes);
                outputStream.close();
                int responseCode = httpURLConnection2.getResponseCode();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f20644f.a("HealthEventsReporter", laVar.b() + " reported with code " + responseCode);
                }
                this.f20641c.put(laVar, Long.valueOf(System.currentTimeMillis()));
                yp.a(httpURLConnection2, this.f20643e);
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpURLConnection2;
                try {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f20644f.d("HealthEventsReporter", "Failed to report " + laVar.b(), th);
                    }
                } finally {
                    yp.a(httpURLConnection, this.f20643e);
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private void c(la laVar, Object obj, List list) {
        HttpURLConnection httpURLConnection;
        Throwable th2;
        if (laVar.a() == la.b.AD || laVar.a() == la.b.USER_SESSION || !yp.a(((Integer) this.f20643e.a(sj.J)).intValue())) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            try {
                httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(a(laVar, obj, map).openConnection()));
                try {
                    int i11 = f20638g;
                    httpURLConnection.setConnectTimeout(i11);
                    httpURLConnection.setReadTimeout(i11);
                    httpURLConnection.setDefaultUseCaches(false);
                    httpURLConnection.setAllowUserInteraction(false);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setDoOutput(false);
                    httpURLConnection.setRequestMethod("POST");
                    int responseCode = httpURLConnection.getResponseCode();
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f20644f.a("HealthEventsReporter", laVar.b() + " reported with code " + responseCode + " and extra parameters " + map);
                    }
                    this.f20641c.put(laVar, Long.valueOf(System.currentTimeMillis()));
                    yp.a(httpURLConnection, this.f20643e);
                } catch (Throwable th3) {
                    th2 = th3;
                    try {
                        if (com.applovin.impl.sdk.n.a()) {
                            this.f20644f.d("HealthEventsReporter", "Failed to report " + laVar.b() + " with extra parameters " + map, th2);
                        }
                        yp.a(httpURLConnection, this.f20643e);
                    } catch (Throwable th4) {
                        yp.a(httpURLConnection, this.f20643e);
                        throw th4;
                    }
                }
            } catch (Throwable th5) {
                httpURLConnection = null;
                th2 = th5;
            }
        }
    }

    private void d(final la laVar, final Object obj, List list) {
        final String str = (String) this.f20643e.a(sj.K);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        double dA = laVar.a(this.f20643e);
        if (yp.a(dA)) {
            if (((Boolean) this.f20643e.a(sj.Q)).booleanValue()) {
                a(str, laVar, obj, a(laVar, dA, obj, list));
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final JSONObject jSONObjectA = a(laVar, dA, obj, Collections.singletonList((Map) it.next()));
                this.f20640b.execute(new Runnable() { // from class: com.applovin.impl.uz
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f23710a.a(str, laVar, obj, jSONObjectA);
                    }
                });
            }
        }
    }

    public void a() {
        this.f20639a = JsonUtils.deserialize((String) this.f20643e.a(sj.S));
    }

    public void a(la laVar, ge geVar) {
        a(laVar, geVar.getFormat(), geVar.getAdUnitId(), geVar, null);
    }

    public void a(la laVar, ge geVar, MaxError maxError) {
        a(laVar, geVar.getFormat(), geVar.getAdUnitId(), geVar, maxError);
    }

    public void a(la laVar, h0 h0Var, AppLovinError appLovinError) {
        a(laVar, h0Var, (com.applovin.impl.sdk.ad.b) null, appLovinError);
    }

    public void a(la laVar, com.applovin.impl.sdk.ad.b bVar) {
        a(laVar, bVar != null ? bVar.getAdZone() : null, bVar, (AppLovinError) null);
    }

    public void a(la laVar, MaxAdFormat maxAdFormat, String str, MaxError maxError) {
        a(laVar, maxAdFormat, str, null, maxError);
    }

    public void a(final la laVar, final Object obj, final List list, long j11) {
        if (a(laVar, j11)) {
            return;
        }
        try {
            if (yp.h()) {
                this.f20640b.execute(new Runnable() { // from class: com.applovin.impl.vz
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f23990a.b(laVar, obj, list);
                    }
                });
            } else {
                b(laVar, obj, list);
            }
        } catch (Throwable th2) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f20644f.d("HealthEventsReporter", "Failed to report " + laVar.b() + " with extra parameters collection " + list, th2);
            }
        }
    }

    public void a(la laVar, Object obj, Map map, long j11) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(map);
        a(laVar, obj, arrayList, j11);
    }

    public void a(la laVar, String str) {
        a(laVar, str, (Map) new HashMap());
    }

    public void a(la laVar, String str, Map map) {
        map.put("source", str);
        a(laVar, map);
    }

    public void a(la laVar, String str, Map map, String str2) {
        if (!StringUtils.isValidString(str2) || this.f20642d.add(str2)) {
            map.put("source", str);
            a(laVar, str, map);
        }
    }

    public void a(la laVar, Map map) {
        a(laVar, (Object) null, map, 0L);
    }

    public void a(la laVar, Map map, long j11) {
        a(laVar, (Object) null, map, j11);
    }

    public void a(String str, String str2, int i11) {
        a(str, str2, i11, new HashMap());
    }

    public void a(String str, String str2, int i11, HashMap map) {
        List listA = a(str2);
        boolean z11 = listA != null;
        if (z11 && listA.contains(Integer.valueOf(i11))) {
            return;
        }
        if (z11 || i11 >= 400) {
            map.put("source", str);
            map.put("url", StringUtils.emptyIfNull(str2));
            map.put(TrackingKey.CODE, String.valueOf(i11));
            a(la.O, (Map) map);
        }
    }

    public void a(String str, String str2, com.applovin.impl.sdk.ad.b bVar) {
        HashMap map = new HashMap();
        map.put("source", str);
        map.put(TrackingKey.ERROR_MESSAGE, str2);
        if (bVar != null) {
            map.putAll(a(bVar));
            boolean zH0 = bVar.H0();
            map.put("is_video_stream", String.valueOf(zH0));
            if (zH0 && (bVar instanceof com.applovin.impl.sdk.ad.a)) {
                CollectionUtils.putStringIfValid(CampaignEx.JSON_KEY_VIDEO_URL, ((com.applovin.impl.sdk.ad.a) bVar).k1(), map);
            } else {
                CollectionUtils.putStringIfValid(CampaignEx.JSON_KEY_VIDEO_URL, bVar.P(), map);
            }
        }
        a(la.M, (Map) map);
    }

    public void a(String str, String str2, Throwable th2) {
        a(str, str2, th2, new HashMap());
    }

    public void a(String str, String str2, Throwable th2, Map map) {
        a(str + ":" + str2, th2, map);
    }

    public void a(String str, Throwable th2) {
        a(str, th2, new HashMap());
    }

    public void a(String str, Throwable th2, Map map) {
        map.put("source", str);
        map.put("top_main_method", th2.toString());
        ArrayList arrayList = new ArrayList();
        arrayList.add(map);
        for (Throwable th3 : th2.getSuppressed()) {
            HashMap map2 = new HashMap();
            CollectionUtils.putStringIfValid("source", str, map2);
            CollectionUtils.putStringIfValid("top_main_method", th2.toString(), map2);
            CollectionUtils.putStringIfValid("suppressed_throwable", th3.toString(), map2);
            arrayList.add(map2);
        }
        a(la.H, (Object) null, arrayList, 0L);
    }
}
