package com.applovin.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinMediationProvider;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f18554a = {7, 4, 2, 1, 11};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f18555b = {5, 6, 12, 10, 3, 9, 8, 14};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f18556c = {15, 13};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f18557d = {20};

    public static String a(com.applovin.impl.sdk.j jVar) {
        return a((String) jVar.a(sj.O0), ((Boolean) jVar.a(sj.f23056s3)).booleanValue() ? "5.0/ad" : "4.0/ad", jVar);
    }

    public static String a(String str, com.applovin.impl.sdk.j jVar) {
        return a((String) jVar.a(sj.Q0), str, jVar);
    }

    public static String a(String str, String str2, com.applovin.impl.sdk.j jVar) {
        if (str == null || str.length() < 4) {
            throw new IllegalArgumentException("Invalid domain specified");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("No endpoint specified");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        return str + str2;
    }

    public static void a(int i11, com.applovin.impl.sdk.j jVar) {
        if (i11 == 401) {
            com.applovin.impl.sdk.n.h("AppLovinSdk", "SDK key \"" + jVar.b0() + "\" is rejected by AppLovin. Please make sure the SDK key is correct.");
            return;
        }
        if (i11 == 418) {
            jVar.h0().a(sj.f22948f, Boolean.TRUE);
            jVar.h0().e();
        } else if (i11 >= 400 && i11 < 500) {
            if (((Boolean) jVar.a(sj.f22964h)).booleanValue()) {
                jVar.R0();
            }
        } else if (i11 == -1 && ((Boolean) jVar.a(sj.f22964h)).booleanValue()) {
            jVar.R0();
        }
    }

    public static void a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "filesystem_values", (JSONObject) null);
        if (jSONObject2 != null) {
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(com.applovin.impl.sdk.j.l()).edit();
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object object = JsonUtils.getObject(jSONObject2, next, null);
                if (object != null) {
                    vj.a(next, object, (SharedPreferences) null, editorEdit);
                }
            }
            editorEdit.apply();
        }
    }

    public static void a(JSONObject jSONObject, boolean z11, com.applovin.impl.sdk.j jVar) {
        jVar.p().a(jSONObject, z11);
    }

    private static boolean a(int i11, int[] iArr) {
        for (int i12 : iArr) {
            if (i12 == i11) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(Context context) {
        if (context.getSystemService("connectivity") == null) {
            return true;
        }
        NetworkInfo networkInfoB = b(context);
        if (networkInfoB != null) {
            return networkInfoB.isConnected();
        }
        return false;
    }

    public static byte[] a(InputStream inputStream, com.applovin.impl.sdk.j jVar) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[((Integer) jVar.a(sj.f23000l3)).intValue()];
        while (true) {
            int i11 = inputStream.read(bArr);
            if (i11 <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i11);
        }
    }

    private static NetworkInfo b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public static String b(com.applovin.impl.sdk.j jVar) {
        return a((String) jVar.a(sj.N0), ((Boolean) jVar.a(sj.f23056s3)).booleanValue() ? "5.0/ad" : "4.0/ad", jVar);
    }

    public static String b(String str, com.applovin.impl.sdk.j jVar) {
        return a((String) jVar.a(sj.P0), str, jVar);
    }

    public static void b(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        String string = JsonUtils.getString(jSONObject, "persisted_data", null);
        if (StringUtils.isValidString(string)) {
            jVar.b(uj.G, string);
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().d("ConnectionUtils", "Updated persisted data");
            }
        }
    }

    public static Map c(com.applovin.impl.sdk.j jVar) {
        HashMap map = new HashMap();
        String str = (String) jVar.a(sj.f22988k);
        if (StringUtils.isValidString(str)) {
            map.put("device_token", str);
        } else if (!((Boolean) jVar.a(sj.f22970h5)).booleanValue()) {
            map.put("api_key", jVar.b0());
        }
        map.putAll(yp.a(jVar.y().e()));
        return map;
    }

    public static void c(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        try {
            if (jSONObject.has("settings")) {
                tj tjVarH0 = jVar.h0();
                if (jSONObject.isNull("settings")) {
                    return;
                }
                tjVarH0.a(jSONObject.getJSONObject("settings"));
                tjVarH0.e();
            }
        } catch (JSONException e11) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().a("ConnectionUtils", "Unable to parse settings out of API response", e11);
            }
        }
    }

    public static String d(com.applovin.impl.sdk.j jVar) {
        return a((String) jVar.a(sj.O0), "4.0/ad", jVar);
    }

    public static String e(com.applovin.impl.sdk.j jVar) {
        return a((String) jVar.a(sj.N0), "4.0/ad", jVar);
    }

    public static Long f(com.applovin.impl.sdk.j jVar) {
        d4.d dVarA = jVar.s().a();
        if (dVarA == null) {
            return null;
        }
        double dC = yp.c(dVarA.b());
        double d11 = yp.d(dVarA.a());
        if (d11 == 0.0d) {
            return null;
        }
        return Long.valueOf((long) (dC / d11));
    }

    public static String g(com.applovin.impl.sdk.j jVar) {
        NetworkInfo networkInfoB = b(com.applovin.impl.sdk.j.l());
        if (networkInfoB == null) {
            return AppLovinMediationProvider.UNKNOWN;
        }
        int type = networkInfoB.getType();
        int subtype = networkInfoB.getSubtype();
        if (type == 1) {
            return "wifi";
        }
        if (type != 0) {
            return AppLovinMediationProvider.UNKNOWN;
        }
        if (a(subtype, f18554a)) {
            return "2g";
        }
        if (a(subtype, f18555b)) {
            return "3g";
        }
        if (a(subtype, f18556c)) {
            return "4g";
        }
        return a(subtype, f18557d) ? "5g" : "mobile";
    }
}
