package com.apm.insight.entity;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.apm.insight.e;
import com.apm.insight.l.k;
import com.apm.insight.l.l;
import com.apm.insight.runtime.q;
import com.applovin.sdk.AppLovinMediationProvider;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Header {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f16757a = {"version_code", "manifest_version_code", "aid", "update_version_code"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f16758d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f16759e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f16760f = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f16761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f16762c = new JSONObject();

    public Header(Context context) {
        this.f16761b = context;
    }

    public static Header a(long j11) {
        Header headerA;
        q qVarA = q.a();
        if (j11 == 0) {
            j11 = System.currentTimeMillis();
        }
        JSONObject jSONObjectA = qVarA.a(j11);
        if (jSONObjectA == null || jSONObjectA.length() == 0) {
            headerA = a(e.g());
            headerA.c();
            try {
                headerA.f16762c.put("errHeader", 1);
            } catch (Throwable unused) {
            }
        } else {
            headerA = new Header(e.g());
        }
        b(headerA);
        headerA.a(jSONObjectA);
        return headerA;
    }

    public static Header a(Context context) {
        Header header = new Header(context);
        JSONObject jSONObject = header.f16762c;
        try {
            jSONObject.put("sdk_version", 1030851);
            jSONObject.put("sdk_version_name", "1.3.8.nourl-rc.1");
        } catch (Exception unused) {
        }
        return header;
    }

    public static Header a(Header header) {
        addRuntimeHeader(header.f16762c);
        return header;
    }

    public static boolean a() {
        if (f16759e == -1) {
            f16759e = g().contains("64") ? 1 : 0;
        }
        return f16759e == 1;
    }

    @Keep
    public static void addOtherHeader(JSONObject jSONObject) {
        Object obj;
        if (jSONObject == null) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        try {
            if (com.apm.insight.l.d.b()) {
                sb2.append("MIUI-");
            } else if (com.apm.insight.l.d.c()) {
                sb2.append("FLYME-");
            } else {
                String strA = com.apm.insight.l.d.a();
                if (com.apm.insight.l.d.a(strA)) {
                    sb2.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strA)) {
                    sb2.append(strA);
                    sb2.append("-");
                }
            }
            sb2.append(Build.VERSION.INCREMENTAL);
            if (sb2.length() > 0) {
                jSONObject.put("rom", sb2.toString());
            }
            jSONObject.put("rom_version", l.a());
        } catch (Throwable unused) {
        }
        try {
            DisplayMetrics displayMetrics = e.g().getResources().getDisplayMetrics();
            int i11 = displayMetrics.densityDpi;
            if (i11 == 120) {
                obj = "ldpi";
            } else if (i11 != 240) {
                obj = i11 != 320 ? "mdpi" : "xhdpi";
            } else {
                obj = "hdpi";
            }
            jSONObject.put("density_dpi", i11);
            jSONObject.put("display_density", obj);
            jSONObject.put("resolution", displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        } catch (Exception unused2) {
        }
        try {
            String language = e.g().getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put("language", language);
            }
            int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
            if (rawOffset < -12) {
                rawOffset = -12;
            }
            if (rawOffset > 12) {
                rawOffset = 12;
            }
            jSONObject.put("timezone", rawOffset);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("os", "Android");
            jSONObject.put("device_id", e.c().a());
            String str = Build.VERSION.RELEASE;
            if (!str.contains(InstructionFileId.DOT)) {
                str = str + ".0";
            }
            jSONObject.put("os_version", str);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            String str2 = Build.MODEL;
            String str3 = Build.BRAND;
            if (str2 == null) {
                str2 = str3;
            } else if (str3 != null && !str2.contains(str3)) {
                str2 = str3 + ' ' + str2;
            }
            jSONObject.put("device_model", str2);
            jSONObject.put("device_brand", str3);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put("cpu_abi", g());
            Context contextG = e.g();
            String packageName = contextG.getPackageName();
            jSONObject.put("package", packageName);
            PackageInfo packageInfo = contextG.getPackageManager().getPackageInfo(packageName, 0);
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo != null) {
                int i12 = applicationInfo.labelRes;
                if (i12 > 0) {
                    jSONObject.put("display_name", contextG.getString(i12));
                } else {
                    jSONObject.put("display_name", contextG.getPackageManager().getApplicationLabel(packageInfo.applicationInfo));
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        d.a(jSONObject);
    }

    public static void addRuntimeHeader(JSONObject jSONObject) {
        try {
            jSONObject.put("access", k.a(e.g()));
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) e.g().getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    jSONObject.put("carrier", networkOperatorName);
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                if (TextUtils.isEmpty(networkOperator)) {
                    return;
                }
                jSONObject.put("mcc_mnc", networkOperator);
            }
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    public static Header b(Context context) {
        Header headerA = a(context);
        a(headerA);
        b(headerA);
        headerA.c();
        headerA.d();
        headerA.e();
        return headerA;
    }

    public static void b(Header header) {
        if (header == null) {
            return;
        }
        addOtherHeader(header.f16762c);
    }

    public static boolean b() {
        if (f16760f == -1) {
            f16760f = g().contains("86") ? 1 : 0;
        }
        return f16760f == 1;
    }

    public static boolean b(JSONObject jSONObject) {
        return jSONObject.optInt("unauthentic_version", 0) == 1;
    }

    public static boolean c(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return true;
        }
        return (jSONObject.opt("app_version") == null && jSONObject.opt("version_name") == null) || jSONObject.opt("version_code") == null || jSONObject.opt("update_version_code") == null;
    }

    public static boolean d(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            String strOptString = jSONObject.optString("aid");
            if (TextUtils.isEmpty(strOptString)) {
                return true;
            }
            try {
                return Integer.parseInt(strOptString) <= 0;
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    private static String g() {
        if (f16758d == null) {
            try {
                StringBuilder sb2 = new StringBuilder();
                if (Build.SUPPORTED_ABIS.length > 0) {
                    int i11 = 0;
                    while (true) {
                        String[] strArr = Build.SUPPORTED_ABIS;
                        if (i11 >= strArr.length) {
                            break;
                        }
                        sb2.append(strArr[i11]);
                        if (i11 != strArr.length - 1) {
                            sb2.append(", ");
                        }
                        i11++;
                    }
                } else {
                    sb2 = new StringBuilder(Build.CPU_ABI);
                }
                if (TextUtils.isEmpty(sb2.toString())) {
                    f16758d = AppLovinMediationProvider.UNKNOWN;
                }
                f16758d = sb2.toString();
            } catch (Exception e11) {
                com.apm.insight.a.b((Throwable) e11);
                f16758d = AppLovinMediationProvider.UNKNOWN;
            }
        }
        return f16758d;
    }

    public final JSONObject a(@Nullable Map<String, Object> map) {
        try {
            if (map == null) {
                return this.f16762c;
            }
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!this.f16762c.has(entry.getKey())) {
                    this.f16762c.put(entry.getKey(), entry.getValue());
                }
            }
            String[] strArr = f16757a;
            for (int i11 = 0; i11 < 4; i11++) {
                String str = strArr[i11];
                if (map.containsKey(str)) {
                    try {
                        this.f16762c.put(str, Integer.parseInt(String.valueOf(map.get(str))));
                    } catch (Throwable unused) {
                        this.f16762c.put(str, map.get(str));
                    }
                }
            }
            if (map.containsKey("version_code") && !map.containsKey("manifest_version_code")) {
                try {
                    this.f16762c.put("manifest_version_code", Integer.parseInt(String.valueOf(map.get("version_code"))));
                } catch (Throwable unused2) {
                }
            }
            if (map.containsKey("iid")) {
                this.f16762c.put("udid", map.get("iid"));
                this.f16762c.remove("iid");
            }
            if (map.containsKey("version_name")) {
                this.f16762c.put("app_version", map.get("version_name"));
                this.f16762c.remove("version_name");
            }
        } catch (Throwable unused3) {
        }
        return this.f16762c;
    }

    public final JSONObject a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return this.f16762c;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                this.f16762c.put(next, jSONObject.opt(next));
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }
        return this.f16762c;
    }

    public final JSONObject c() {
        return a(e.a().a());
    }

    public final JSONObject d() {
        try {
            this.f16762c.put("device_id", e.c().a());
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return this.f16762c;
    }

    public final JSONObject e() {
        try {
            long jF = e.a().f();
            if (jF > 0) {
                this.f16762c.put("user_id", jF);
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return this.f16762c;
    }

    public final JSONObject f() {
        return this.f16762c;
    }
}
