package br;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import androidx.annotation.NonNull;
import athena.a0;
import athena.m0;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import javax.crypto.KeyGenerator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class g {
    public static String A = "";
    public static boolean B = false;
    public static boolean C = false;
    public static boolean D = false;
    public static boolean E = true;
    public static boolean F = true;
    public static boolean G = true;
    public static boolean H = false;
    public static JSONObject I = new JSONObject();
    public static JSONObject J = new JSONObject();
    public static JSONObject K = new JSONObject();
    public static JSONObject L = new JSONObject();
    public static JSONObject M = new JSONObject();
    public static final ArrayMap<Integer, String> N = new ArrayMap<>();
    public static boolean O = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f14348a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f14349b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f14350c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f14351d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f14352e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f14353f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f14354g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f14355h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f14356i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f14357j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f14358k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f14359l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static byte[] f14360m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static byte[] f14361n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static byte[] f14362o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f14363p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static String f14364q = "online";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static long f14365r = 30000;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static String f14366s = "";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static String f14367t = "";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f14368u = true;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f14369v = true;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static boolean f14370w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static int f14371x = 10485760;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static int f14372y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static short f14373z;

    public static long A() {
        return f14365r;
    }

    public static String B() {
        return c(true) + f14356i;
    }

    public static boolean C() {
        return f14369v;
    }

    public static boolean D() {
        return f14363p;
    }

    public static boolean E() {
        return f14368u;
    }

    public static boolean F() {
        return TextUtils.equals(f14364q, androidx.browser.customtabs.c.ONLINE_EXTRAS_KEY);
    }

    public static boolean G() {
        return f14370w;
    }

    public static boolean H() {
        return TextUtils.equals(f14364q, "test");
    }

    public static String a(int i11) {
        ArrayMap<Integer, String> arrayMap = N;
        return arrayMap.containsKey(Integer.valueOf(i11)) ? arrayMap.get(Integer.valueOf(i11)) : "";
    }

    public static String b(String str) {
        return str + f14356i;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0036  */
    @NonNull
    public static String c(boolean z11) {
        byte b11;
        String str;
        String str2 = f14364q;
        int iHashCode = str2.hashCode();
        if (iHashCode != -1012222381) {
            if (iHashCode != 99349) {
                if (iHashCode == 3556498 && str2.equals("test")) {
                    b11 = 1;
                } else {
                    b11 = -1;
                }
            } else if (str2.equals("dev")) {
                b11 = 0;
            } else {
                b11 = -1;
            }
        } else if (str2.equals(androidx.browser.customtabs.c.ONLINE_EXTRAS_KEY)) {
            b11 = 2;
        } else {
            b11 = -1;
        }
        if (b11 == 0) {
            str = f14348a;
        } else if (b11 != 1) {
            str = z11 ? f14351d : f14352e;
        } else {
            str = z11 ? f14349b : f14350c;
        }
        try {
            if (d.b(ws.a.a(), "debug.athena.test_mode", false).booleanValue()) {
                str = z11 ? f14349b : f14350c;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return AgentPageJsBridge.HTTPS + str;
    }

    public static void d(long j11) {
        if (j11 < 30000) {
            j11 = 30000;
        }
        f14365r = j11;
    }

    public static void e(String str, boolean z11) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(f14366s) || z11) {
            f14366s = str;
        }
    }

    public static void f(short s11, String str) {
        f14373z = s11;
        A = str;
    }

    public static boolean g(Object obj) {
        int length = obj.toString().getBytes(StandardCharsets.UTF_8).length;
        if (length <= 2000) {
            return true;
        }
        a0.c(String.format(Locale.getDefault(), "custom param is too long,limit is 2000 bytes(now is %d bytes)", Integer.valueOf(length)));
        return false;
    }

    public static String h() {
        return A;
    }

    public static void i(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        f14348a = jSONObject.getString(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D);
        f14349b = jSONObject.getString("tu");
        f14350c = jSONObject.getString("tc");
        f14351d = jSONObject.getString("ou");
        f14352e = jSONObject.getString("oc");
        f14353f = jSONObject.getString("c");
        f14354g = jSONObject.getString("g") + "v2";
        String string = jSONObject.getString("u");
        f14355h = string;
        f14356i = string.replace("v2", "v3");
        f14357j = jSONObject.getString("fc");
        f14358k = jSONObject.getString("fd");
        f14359l = jSONObject.getString("fe");
        f14361n = jSONObject.getString("w").getBytes();
        f14362o = jSONObject.getString("iv").getBytes();
        m0 m0VarA = m0.a(ws.a.a());
        try {
            if (m0VarA.e("athena_def") != 0) {
                f14360m = f14361n;
                return;
            }
            String strH = m0VarA.h("athena_ea");
            if (TextUtils.isEmpty(strH)) {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                keyGenerator.init(128);
                strH = d.e(keyGenerator.generateKey().getEncoded());
                m0VarA.c("athena_ea", strH);
            }
            f14360m = d.j(strH);
        } catch (Exception unused) {
            m0VarA.b("athena_def", 1);
            f14360m = f14361n;
        }
    }

    public static short j() {
        return f14373z;
    }

    public static void k(String str) {
        f14367t = str;
    }

    public static void l(boolean z11) {
        f14363p = z11;
    }

    public static JSONObject m() {
        return J;
    }

    public static void n(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (g(obj)) {
                I.put(str, obj);
            }
        } catch (JSONException e11) {
            a0.c(Log.getStackTraceString(e11));
        }
    }

    public static void o(boolean z11) {
        a0.e("setEnable isEnable = " + z11);
        f14368u = z11;
    }

    public static String p() {
        return c(false) + f14353f;
    }

    public static void q(boolean z11) {
        f14364q = z11 ? "test" : androidx.browser.customtabs.c.ONLINE_EXTRAS_KEY;
    }

    public static JSONObject r() {
        return M;
    }

    public static JSONObject s() {
        return L;
    }

    public static String t() {
        return f14366s;
    }

    public static JSONObject u() {
        return I;
    }

    public static String v() {
        return c(false) + f14354g;
    }

    public static int w() {
        return f14372y;
    }

    public static int x() {
        return f14371x;
    }

    public static JSONObject y() {
        return K;
    }

    public static String z() {
        return f14367t;
    }
}
