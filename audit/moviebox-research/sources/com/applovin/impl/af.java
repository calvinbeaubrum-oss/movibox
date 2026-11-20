package com.applovin.impl;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.mediation.MaxMediatedNetworkInfoImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.ads.AdSize;
import com.hisavana.common.tracking.TrackingKey;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TreeMap f17650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List f17651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static JSONArray f17652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map f17653d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f17654e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Map f17655f = Collections.synchronizedMap(new HashMap(1));

    static {
        TreeMap treeMap = new TreeMap();
        f17650a = treeMap;
        treeMap.put("com.applovin.mediation.adapters.AmazonAdMarketplaceMediationAdapter", "Amazon Publisher Services");
        treeMap.put("com.applovin.mediation.adapters.AppLovinMediationAdapter", "AppLovin");
        treeMap.put("com.applovin.mediation.adapters.BidMachineMediationAdapter", "BidMachine");
        treeMap.put("com.applovin.mediation.adapters.BigoAdsMediationAdapter", "Bigo Ads");
        treeMap.put("com.applovin.mediation.adapters.ByteDanceMediationAdapter", "Pangle");
        treeMap.put("com.applovin.mediation.adapters.ChartboostMediationAdapter", "Chartboost");
        treeMap.put("com.applovin.mediation.adapters.CSJMediationAdapter", "CSJ");
        treeMap.put("com.applovin.mediation.adapters.DataseatMediationAdapter", "Dataseat");
        treeMap.put("com.applovin.mediation.adapters.FacebookMediationAdapter", "Facebook");
        treeMap.put("com.applovin.mediation.adapters.GoogleMediationAdapter", "AdMob");
        treeMap.put("com.applovin.mediation.adapters.GoogleAdManagerMediationAdapter", "Google Ad Manager");
        treeMap.put("com.applovin.mediation.adapters.HyprMXMediationAdapter", "HyprMX");
        treeMap.put("com.applovin.mediation.adapters.InMobiMediationAdapter", "InMobi");
        treeMap.put("com.applovin.mediation.adapters.InneractiveMediationAdapter", "Fyber");
        treeMap.put("com.applovin.mediation.adapters.IronSourceMediationAdapter", "ironSource");
        treeMap.put("com.applovin.mediation.adapters.LineMediationAdapter", "LINE");
        treeMap.put("com.applovin.mediation.adapters.MaioMediationAdapter", "Maio");
        treeMap.put("com.applovin.mediation.adapters.MintegralMediationAdapter", "Mintegral");
        treeMap.put("com.applovin.mediation.adapters.MobileFuseMediationAdapter", "MobileFuse");
        treeMap.put("com.applovin.mediation.adapters.MolocoMediationAdapter", "Moloco");
        treeMap.put("com.applovin.mediation.adapters.MyTargetMediationAdapter", "myTarget");
        treeMap.put("com.applovin.mediation.adapters.OguryMediationAdapter", "Ogury");
        treeMap.put("com.applovin.mediation.adapters.OguryPresageMediationAdapter", "Ogury Presage");
        treeMap.put("com.applovin.mediation.adapters.PangleMediationAdapter", "Pangle");
        treeMap.put("com.applovin.mediation.adapters.PubMaticMediationAdapter", "PubMatic");
        treeMap.put("com.applovin.mediation.adapters.SayGamesMediationAdapter", "SayGames");
        treeMap.put("com.applovin.mediation.adapters.SmaatoMediationAdapter", "Smaato");
        treeMap.put("com.applovin.mediation.adapters.TencentMediationAdapter", "Tencent");
        treeMap.put("com.applovin.mediation.adapters.UnityAdsMediationAdapter", "Unity Ads");
        treeMap.put("com.applovin.mediation.adapters.VerveMediationAdapter", "Verve");
        treeMap.put("com.applovin.mediation.adapters.VungleMediationAdapter", "Vungle");
        treeMap.put("com.applovin.mediation.adapters.YandexMediationAdapter", "Yandex");
        treeMap.put("com.applovin.mediation.adapters.AdColonyMediationAdapter", "AdColony");
        treeMap.put("com.applovin.mediation.adapters.AmazonMediationAdapter", "Amazon");
        treeMap.put("com.applovin.mediation.adapters.AmazonPublisherServicesMediationAdapter", "Amazon Publisher Services");
        treeMap.put("com.applovin.mediation.adapters.CriteoMediationAdapter", "Criteo");
        treeMap.put("com.applovin.mediation.adapters.NendMediationAdapter", "Nend");
        treeMap.put("com.applovin.mediation.adapters.SnapMediationAdapter", "Snap");
        treeMap.put("com.applovin.mediation.adapters.TapjoyMediationAdapter", "Tapjoy");
        treeMap.put("com.applovin.mediation.adapters.VerizonAdsMediationAdapter", "Verizon");
        treeMap.put("com.applovin.mediation.adapters.YahooMediationAdapter", "Yahoo");
        treeMap.put("com.applovin.mediation.ALYsoNetworkMediationAdapter", "YSO Network");
        treeMap.put("com.applovin.mediation.adapters.YsoNetworkMediationAdapter", "YSO Network");
        f17651b = new ArrayList(treeMap.keySet());
    }

    public static MaxMediatedNetworkInfo a(String str) {
        MaxMediatedNetworkInfo maxMediatedNetworkInfo = (MaxMediatedNetworkInfo) f17653d.get(str);
        if (maxMediatedNetworkInfo != null) {
            return maxMediatedNetworkInfo;
        }
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "class", str);
        return new MaxMediatedNetworkInfoImpl(jSONObject);
    }

    public static MaxAdapter a(String str, com.applovin.impl.sdk.j jVar) {
        if (TextUtils.isEmpty(str)) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().b("AppLovinSdk", "Failed to create adapter instance. No class name provided");
            }
            return null;
        }
        try {
            Class<?> cls = Class.forName(str);
            if (MaxAdapter.class.isAssignableFrom(cls)) {
                return (MaxAdapter) cls.getConstructor(AppLovinSdk.class).newInstance(jVar.s0());
            }
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().b("AppLovinSdk", str + " error: not an instance of '" + MaxAdapter.class.getName() + "'.");
            }
            return null;
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th2) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().a("AppLovinSdk", "Failed to load: " + str, th2);
            }
        }
    }

    public static AppLovinSdkUtils.Size a(int i11, MaxAdFormat maxAdFormat, Context context) {
        if (i11 < 0) {
            try {
                i11 = AppLovinSdkUtils.pxToDp(context, z3.a(context).x);
            } catch (Throwable unused) {
                return maxAdFormat.getSize();
            }
        }
        Map map = f17655f;
        AppLovinSdkUtils.Size size = (AppLovinSdkUtils.Size) map.get(Integer.valueOf(i11));
        if (size != null) {
            return size;
        }
        int i12 = AdSize.FULL_WIDTH;
        Method method = AdSize.class.getMethod("getCurrentOrientationAnchoredAdaptiveBannerAdSize", Context.class, Integer.TYPE);
        Method method2 = AdSize.class.getMethod("getWidth", new Class[0]);
        Method method3 = AdSize.class.getMethod("getHeight", new Class[0]);
        Object objInvoke = method.invoke(null, context, Integer.valueOf(i11));
        AppLovinSdkUtils.Size size2 = new AppLovinSdkUtils.Size(((Integer) method2.invoke(objInvoke, new Object[0])).intValue(), ((Integer) method3.invoke(objInvoke, new Object[0])).intValue());
        map.put(Integer.valueOf(i11), size2);
        return size2;
    }

    public static String a(MaxAdapter maxAdapter) {
        try {
            return StringUtils.emptyIfNull(maxAdapter.getSdkVersion());
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("MediationUtils", "Failed to retrieve SDK version for adapter: " + maxAdapter, th2);
            return "";
        }
    }

    public static JSONArray a(com.applovin.impl.sdk.j jVar) {
        if (f17652c != null) {
            b(jVar);
            return f17652c;
        }
        f17652c = new JSONArray();
        for (String str : f17651b) {
            MaxAdapter maxAdapterA = a(str, jVar);
            if (maxAdapterA != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", f17650a.get(str));
                    jSONObject.put("class", str);
                    jSONObject.put("sdk_version", a(maxAdapterA));
                    jSONObject.put("version", maxAdapterA.getAdapterVersion());
                } catch (Throwable unused) {
                }
                synchronized (f17654e) {
                    f17652c.put(jSONObject);
                    f17653d.put(str, new MaxMediatedNetworkInfoImpl(jSONObject));
                }
            }
        }
        return f17652c;
    }

    public static boolean a(Object obj) {
        return (obj instanceof com.applovin.impl.sdk.ad.b) && StringUtils.isValidString(((com.applovin.impl.sdk.ad.b) obj).H());
    }

    public static boolean a(JSONObject jSONObject, String str, com.applovin.impl.sdk.j jVar) {
        if (!JsonUtils.containsJSONObjectContainingInt(jSONObject.optJSONArray("no_fill_reason"), 1035, TrackingKey.CODE)) {
            return false;
        }
        jVar.E().a(la.L, "invalid_or_disabled_ad_unit_id", CollectionUtils.hashMap("ad_unit_id", str), "invalid_or_disabled_ad_unit_id" + str);
        return true;
    }

    private static void b(com.applovin.impl.sdk.j jVar) {
        MaxAdapter maxAdapterA;
        for (int i11 = 0; i11 < f17652c.length(); i11++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(f17652c, i11, (JSONObject) null);
            String string = JsonUtils.getString(jSONObject, "class", "");
            if (!StringUtils.isValidString(JsonUtils.getString(jSONObject, "sdk_version", "")) && (maxAdapterA = a(string, jVar)) != null) {
                String strA = a(maxAdapterA);
                if (StringUtils.isValidString(strA)) {
                    synchronized (f17654e) {
                        JsonUtils.putString(jSONObject, "sdk_version", strA);
                        f17653d.put(string, new MaxMediatedNetworkInfoImpl(jSONObject));
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public static boolean b(Object obj) {
        return (obj instanceof ge) && "APPLOVIN".equals(((ge) obj).k());
    }
}
