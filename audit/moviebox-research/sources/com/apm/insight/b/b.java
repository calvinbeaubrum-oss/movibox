package com.apm.insight.b;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.Npth;
import com.apm.insight.entity.Header;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.m;
import com.apm.insight.runtime.o;
import com.apm.insight.runtime.p;
import com.applovin.sdk.AppLovinMediationProvider;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static volatile boolean f16604z = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f16605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f16606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f16607c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private JSONObject f16611g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private JSONObject f16612h;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private JSONArray f16617m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private JSONObject f16618n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private JSONArray f16621q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private JSONArray f16622r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private JSONObject f16623s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f16624t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private volatile boolean f16626v;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f16608d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private File f16609e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f16610f = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f16613i = AppLovinMediationProvider.UNKNOWN;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f16614j = AppLovinMediationProvider.UNKNOWN;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f16615k = AppLovinMediationProvider.UNKNOWN;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f16616l = "npth_inner_default";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f16619o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f16620p = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Object f16625u = new Object();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f16627w = -1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f16628x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Runnable f16629y = new Runnable() { // from class: com.apm.insight.b.b.1
        @Override // java.lang.Runnable
        public final void run() {
            try {
                b.this.g();
            } catch (Throwable th2) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.k.a(th2, "NPTH_CATCH");
            }
        }
    };
    private int A = 0;
    private List<Pattern> B = null;
    private Pattern C = null;
    private File D = null;

    public b(Context context) {
        this.f16606b = context;
    }

    private static String a(float f11) {
        if (f11 <= 0.0f) {
            return "0%";
        }
        if (f11 <= 0.1f) {
            return "0% - 10%";
        }
        if (f11 <= 0.3f) {
            return "10% - 30%";
        }
        if (f11 <= 0.6f) {
            return "30% - 60%";
        }
        return f11 <= 0.9f ? "60% - 90%" : "90% - 100%";
    }

    private static String a(float f11, float f12) {
        if (f12 > 0.0f) {
            return a(f11 / f12);
        }
        return f11 > 0.0f ? "100%" : "0%";
    }

    private JSONObject a(String str, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArrayB = com.apm.insight.a.b(jSONArray);
        if (jSONArrayB.length() != jSONArray.length()) {
            this.f16619o++;
        }
        try {
            jSONObject.put("thread_name", str);
            jSONObject.put("thread_stack", jSONArrayB);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:102:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:104:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:106:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:108:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:110:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:113:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:114:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:115:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:116:0x0202  */
    /* JADX WARN: Code duplicated, block: B:117:0x0205  */
    /* JADX WARN: Code duplicated, block: B:119:0x0211  */
    /* JADX WARN: Code duplicated, block: B:122:0x021e  */
    /* JADX WARN: Code duplicated, block: B:123:0x0221 A[PHI: r28
  0x0221: PHI (r28v2 char) = (r8v14 char), (r28v16 char) binds: [B:121:0x021c, B:115:0x01ff] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:125:0x022b  */
    /* JADX WARN: Code duplicated, block: B:126:0x022e A[PHI: r28
  0x022e: PHI (r28v3 char) = (r28v2 char), (r28v17 char) binds: [B:124:0x0229, B:114:0x01fc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:128:0x0238  */
    /* JADX WARN: Code duplicated, block: B:129:0x023b A[PHI: r28
  0x023b: PHI (r28v4 char) = (r28v3 char), (r28v18 char) binds: [B:127:0x0236, B:113:0x01f9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:131:0x0243  */
    /* JADX WARN: Code duplicated, block: B:132:0x0245 A[PHI: r28
  0x0245: PHI (r28v14 char) = (r28v4 char), (r28v19 char) binds: [B:130:0x0241, B:111:0x01f5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:134:0x024d  */
    /* JADX WARN: Code duplicated, block: B:135:0x024f A[PHI: r28
  0x024f: PHI (r28v5 char) = (r28v14 char), (r28v19 char) binds: [B:133:0x024b, B:111:0x01f5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:137:0x0254  */
    /* JADX WARN: Code duplicated, block: B:142:0x0277  */
    /* JADX WARN: Code duplicated, block: B:143:0x027a  */
    /* JADX WARN: Code duplicated, block: B:151:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:153:0x02b6 A[LOOP:2: B:98:0x01df->B:153:0x02b6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:181:0x0353  */
    /* JADX WARN: Code duplicated, block: B:182:0x0357 A[PHI: r3 r15 r16 r22 r25 r26
  0x0357: PHI (r3v8 java.lang.String) = (r3v7 java.lang.String), (r3v5 java.lang.String) binds: [B:180:0x0351, B:156:0x02cc] A[DONT_GENERATE, DONT_INLINE]
  0x0357: PHI (r15v11 java.lang.String) = (r15v10 java.lang.String), (r15v1 java.lang.String) binds: [B:180:0x0351, B:156:0x02cc] A[DONT_GENERATE, DONT_INLINE]
  0x0357: PHI (r16v12 java.lang.String) = (r16v10 java.lang.String), (r16v1 java.lang.String) binds: [B:180:0x0351, B:156:0x02cc] A[DONT_GENERATE, DONT_INLINE]
  0x0357: PHI (r22v4 char) = (r22v3 char), (r22v6 char) binds: [B:180:0x0351, B:156:0x02cc] A[DONT_GENERATE, DONT_INLINE]
  0x0357: PHI (r25v9 java.util.HashMap) = (r25v8 java.util.HashMap), (r25v11 java.util.HashMap) binds: [B:180:0x0351, B:156:0x02cc] A[DONT_GENERATE, DONT_INLINE]
  0x0357: PHI (r26v9 java.util.HashMap) = (r26v8 java.util.HashMap), (r26v11 java.util.HashMap) binds: [B:180:0x0351, B:156:0x02cc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:184:0x0363  */
    /* JADX WARN: Code duplicated, block: B:186:0x0375  */
    /* JADX WARN: Code duplicated, block: B:189:0x0379 A[LOOP:4: B:187:0x0376->B:189:0x0379, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:191:0x038b A[EDGE_INSN: B:241:0x038b->B:191:0x038b BREAK  A[LOOP:2: B:98:0x01df->B:153:0x02b6], PHI: r15 r16 r22 r25 r26
  0x038b: PHI (r15v12 java.lang.String) = 
  (r15v11 java.lang.String)
  (r15v1 java.lang.String)
  (r15v1 java.lang.String)
  (r15v1 java.lang.String)
  (r15v1 java.lang.String)
 binds: [B:183:0x0361, B:155:0x02c4, B:154:0x02be, B:242:0x038b, B:241:0x038b] A[DONT_GENERATE, DONT_INLINE]
  0x038b: PHI (r16v13 java.lang.String) = 
  (r16v12 java.lang.String)
  (r16v1 java.lang.String)
  (r16v1 java.lang.String)
  (r16v1 java.lang.String)
  (r16v1 java.lang.String)
 binds: [B:183:0x0361, B:155:0x02c4, B:154:0x02be, B:242:0x038b, B:241:0x038b] A[DONT_GENERATE, DONT_INLINE]
  0x038b: PHI (r22v5 char) = (r22v4 char), (r22v7 char), (r22v7 char), (r22v7 char), (r22v7 char) binds: [B:183:0x0361, B:155:0x02c4, B:154:0x02be, B:242:0x038b, B:241:0x038b] A[DONT_GENERATE, DONT_INLINE]
  0x038b: PHI (r25v10 java.util.HashMap) = 
  (r25v9 java.util.HashMap)
  (r25v12 java.util.HashMap)
  (r25v13 java.util.HashMap)
  (r25v17 java.util.HashMap)
  (r25v17 java.util.HashMap)
 binds: [B:183:0x0361, B:155:0x02c4, B:154:0x02be, B:242:0x038b, B:241:0x038b] A[DONT_GENERATE, DONT_INLINE]
  0x038b: PHI (r26v10 java.util.HashMap) = 
  (r26v9 java.util.HashMap)
  (r26v12 java.util.HashMap)
  (r26v13 java.util.HashMap)
  (r26v16 java.util.HashMap)
  (r26v16 java.util.HashMap)
 binds: [B:183:0x0361, B:155:0x02c4, B:154:0x02be, B:242:0x038b, B:241:0x038b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:192:0x038c A[PHI: r15 r16 r20 r22 r25 r26
  0x038c: PHI (r15v7 java.lang.String) = (r15v1 java.lang.String), (r15v1 java.lang.String), (r15v12 java.lang.String), (r15v1 java.lang.String) binds: [B:198:0x03b3, B:195:0x0397, B:191:0x038b, B:14:0x0057] A[DONT_GENERATE, DONT_INLINE]
  0x038c: PHI (r16v6 java.lang.String) = (r16v1 java.lang.String), (r16v1 java.lang.String), (r16v13 java.lang.String), (r16v1 java.lang.String) binds: [B:198:0x03b3, B:195:0x0397, B:191:0x038b, B:14:0x0057] A[DONT_GENERATE, DONT_INLINE]
  0x038c: PHI (r20v5 java.lang.String) = (r20v2 java.lang.String), (r20v6 java.lang.String), (r20v6 java.lang.String), (r20v6 java.lang.String) binds: [B:198:0x03b3, B:195:0x0397, B:191:0x038b, B:14:0x0057] A[DONT_GENERATE, DONT_INLINE]
  0x038c: PHI (r22v2 char) = (r22v1 char), (r22v3 char), (r22v5 char), (r22v8 char) binds: [B:198:0x03b3, B:195:0x0397, B:191:0x038b, B:14:0x0057] A[DONT_GENERATE, DONT_INLINE]
  0x038c: PHI (r25v7 java.util.HashMap) = (r25v4 java.util.HashMap), (r25v8 java.util.HashMap), (r25v10 java.util.HashMap), (r25v21 java.util.HashMap) binds: [B:198:0x03b3, B:195:0x0397, B:191:0x038b, B:14:0x0057] A[DONT_GENERATE, DONT_INLINE]
  0x038c: PHI (r26v7 java.util.HashMap) = (r26v4 java.util.HashMap), (r26v8 java.util.HashMap), (r26v10 java.util.HashMap), (r26v22 java.util.HashMap) binds: [B:198:0x03b3, B:195:0x0397, B:191:0x038b, B:14:0x0057] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:208:0x0413  */
    /* JADX WARN: Code duplicated, block: B:209:0x0419  */
    /* JADX WARN: Code duplicated, block: B:212:0x0430  */
    /* JADX WARN: Code duplicated, block: B:213:0x0436  */
    /* JADX WARN: Code duplicated, block: B:216:0x044d  */
    /* JADX WARN: Code duplicated, block: B:218:0x0453  */
    /* JADX WARN: Code duplicated, block: B:237:0x03c4 A[EDGE_INSN: B:237:0x03c4->B:202:0x03c4 BREAK  A[LOOP:0: B:3:0x0038->B:204:0x03d6], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:239:0x03d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:241:0x038b A[EDGE_INSN: B:241:0x038b->B:191:0x038b BREAK  A[LOOP:2: B:98:0x01df->B:153:0x02b6], SYNTHETIC] */
    private void a(String str, JSONObject jSONObject) throws JSONException {
        HashMap map;
        String str2;
        char c11;
        char c12;
        boolean z11;
        String str3;
        String strTrim;
        String[] strArrSplit;
        int i11;
        String string;
        HashMap map2;
        String str4;
        int i12;
        char c13;
        String str5;
        String[] strArr;
        char c14;
        float fFloatValue;
        SystemClock.uptimeMillis();
        String[] strArrSplit2 = str.split("\n");
        float[] fArr = {-1.0f, -1.0f, -1.0f};
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        HashMap map5 = new HashMap();
        HashMap map6 = new HashMap();
        HashMap map7 = new HashMap();
        int length = strArrSplit2.length;
        String str6 = AppLovinMediationProvider.UNKNOWN;
        String strTrim2 = AppLovinMediationProvider.UNKNOWN;
        String str7 = strTrim2;
        int i13 = 0;
        char c15 = 0;
        boolean z12 = false;
        while (true) {
            if (i13 >= length) {
                map = map6;
                map7 = map7;
                break;
            }
            String strTrim3 = strArrSplit2[i13];
            if (!TextUtils.isEmpty(strTrim3)) {
                if (c15 != 0) {
                    str2 = str6;
                    if (c15 == 1) {
                        map = map6;
                        map7 = map7;
                        c11 = c15;
                        strTrim3 = strTrim3.trim();
                        String lowerCase = strTrim3.toLowerCase();
                        if (lowerCase.startsWith("shortmsg")) {
                            strTrim3.substring(strTrim3.indexOf(58));
                            z11 = false;
                        } else {
                            if (lowerCase.startsWith("reason:")) {
                                strTrim3.substring(strTrim3.indexOf(58));
                                z11 = true;
                            } else if (lowerCase.contains("appfreeze")) {
                                str7 = "AppFreeze";
                                c15 = '\n';
                            } else {
                                c15 = c11;
                            }
                            c12 = 4;
                        }
                        if (lowerCase.contains("input dispatch")) {
                            str3 = "Input dispatching timed out";
                        } else if (lowerCase.contains("broadcast of intent")) {
                            str3 = "Broadcast of Intent";
                        } else {
                            if (lowerCase.contains("executing service")) {
                                if ("null".equalsIgnoreCase(strTrim2)) {
                                    strTrim2 = strTrim3.substring(strTrim3.indexOf("service ") + 8).trim();
                                }
                                str7 = "executing service";
                            } else if (lowerCase.contains("service.startforeground")) {
                                str3 = "not call Service.startForeground";
                            } else {
                                str7 = str2;
                            }
                            if (z11) {
                                c12 = 4;
                                c15 = 2;
                            } else {
                                strTrim = strTrim3.trim();
                                if (strTrim.startsWith("Load:")) {
                                    strArrSplit = strTrim.replace("Load:", "").trim().split("/");
                                    if (3 == strArrSplit.length) {
                                        for (i11 = 0; i11 < strArrSplit.length; i11++) {
                                            fArr[i11] = Float.valueOf(strArrSplit[i11]).floatValue();
                                        }
                                    }
                                    c12 = 4;
                                    c15 = 3;
                                } else {
                                    c15 = c11;
                                    c12 = 4;
                                }
                            }
                        }
                        str7 = str3;
                        if (z11) {
                            c12 = 4;
                            c15 = 2;
                        } else {
                            strTrim = strTrim3.trim();
                            if (strTrim.startsWith("Load:")) {
                                strArrSplit = strTrim.replace("Load:", "").trim().split("/");
                                if (3 == strArrSplit.length) {
                                    while (i11 < strArrSplit.length) {
                                        fArr[i11] = Float.valueOf(strArrSplit[i11]).floatValue();
                                    }
                                }
                                c12 = 4;
                                c15 = 3;
                            } else {
                                c15 = c11;
                                c12 = 4;
                            }
                        }
                    } else if (c15 == 2) {
                        map = map6;
                        map7 = map7;
                        c11 = c15;
                        strTrim = strTrim3.trim();
                        if (strTrim.startsWith("Load:")) {
                            strArrSplit = strTrim.replace("Load:", "").trim().split("/");
                            if (3 == strArrSplit.length) {
                                while (i11 < strArrSplit.length) {
                                    fArr[i11] = Float.valueOf(strArrSplit[i11]).floatValue();
                                }
                            }
                            c12 = 4;
                            c15 = 3;
                        } else {
                            c15 = c11;
                            c12 = 4;
                        }
                    } else if (c15 != 3) {
                        map = map6;
                        map7 = map7;
                        c11 = c15;
                        c15 = c11;
                        c12 = 4;
                    } else {
                        String[] strArrSplit3 = strTrim3.split("\\s");
                        c11 = c15;
                        if (strArrSplit3.length >= 2) {
                            if ("CPU".equalsIgnoreCase(strArrSplit3[0]) && "usage".equalsIgnoreCase(strArrSplit3[1])) {
                                if (strTrim3.contains("ago")) {
                                    z12 = true;
                                }
                                if (map3.isEmpty() && map4.isEmpty() && map5.isEmpty() && map7.isEmpty() && map6.isEmpty()) {
                                    map = map6;
                                    map7 = map7;
                                    c15 = c11;
                                    c12 = 4;
                                }
                            } else if (map3.isEmpty() || map4.isEmpty() || map5.isEmpty() || map7.isEmpty() || map6.isEmpty()) {
                                if (map3.isEmpty() && strArrSplit3[1].equalsIgnoreCase("TOTAL:")) {
                                    string = "";
                                    map2 = map3;
                                } else if (strTrim3.contains(this.f16606b.getPackageName())) {
                                    string = "";
                                    int i14 = 0;
                                    while (i14 < strArrSplit3.length) {
                                        if (strArrSplit3[i14].contains(this.f16606b.getPackageName())) {
                                            StringBuilder sb2 = new StringBuilder();
                                            String str8 = strArrSplit3[i14];
                                            sb2.append(str8.substring(str8.indexOf(47) + 1, strArrSplit3[i14].length() - 1));
                                            sb2.append('_');
                                            string = sb2.toString();
                                        }
                                        i14++;
                                        this = this;
                                    }
                                    map2 = map5;
                                } else if (map4.isEmpty() && strTrim3.contains("system_server:")) {
                                    string = "";
                                    map2 = map4;
                                } else if (map7.isEmpty() && strTrim3.contains("kswapd")) {
                                    string = "";
                                    map2 = map7;
                                } else if (map6.isEmpty() && strTrim3.contains("dex2oat")) {
                                    string = "";
                                    map2 = map6;
                                } else {
                                    string = "";
                                    map2 = null;
                                }
                                if (map2 != null) {
                                    int i15 = 0;
                                    do {
                                        str4 = "%";
                                        if (strArrSplit3[i15].contains("%")) {
                                            break;
                                        } else {
                                            i15++;
                                        }
                                    } while (i15 < strArrSplit3.length);
                                    try {
                                        float fFloatValue2 = Float.valueOf(strArrSplit3[i15].replace("%", "")).floatValue();
                                        map = map6;
                                        try {
                                            String str9 = string + "total";
                                            if (map2 != map3) {
                                                fFloatValue2 /= com.apm.insight.l.d.d();
                                            }
                                            try {
                                                map2.put(str9, Float.valueOf(fFloatValue2));
                                            } catch (Throwable unused) {
                                                map2.put(string + "total", Float.valueOf(-1.0f));
                                            }
                                        } catch (Throwable unused2) {
                                            map7 = map7;
                                            map2.put(string + "total", Float.valueOf(-1.0f));
                                            i12 = i15 + 3;
                                            c13 = 0;
                                            while (i12 < strArrSplit3.length) {
                                                str5 = "softirq";
                                                if (c13 != 0) {
                                                    if ("user".equalsIgnoreCase(strArrSplit3[i12])) {
                                                        str5 = "user";
                                                        c13 = 1;
                                                    }
                                                    if (str5 != null) {
                                                        fFloatValue = Float.valueOf(strArrSplit3[i12 - 1].replace(str4, "")).floatValue();
                                                        strArr = strArrSplit3;
                                                        String str10 = string + str5;
                                                        if (map2 == map3) {
                                                            fFloatValue /= com.apm.insight.l.d.d();
                                                        }
                                                        map2.put(str10, Float.valueOf(fFloatValue));
                                                        c14 = 6;
                                                        if (c13 < c14) {
                                                            break;
                                                            break;
                                                        } else {
                                                            i12 += 3;
                                                            strArrSplit3 = strArr;
                                                            str4 = str4;
                                                        }
                                                    } else {
                                                        strArr = strArrSplit3;
                                                        str4 = str4;
                                                    }
                                                    c14 = 6;
                                                    if (c13 < c14) {
                                                        break;
                                                        break;
                                                    } else {
                                                        i12 += 3;
                                                        strArrSplit3 = strArr;
                                                        str4 = str4;
                                                    }
                                                } else {
                                                    if (c13 != 1) {
                                                        if (c13 != 2) {
                                                            c13 = c13;
                                                            if ("iowait".equalsIgnoreCase(strArrSplit3[i12])) {
                                                                str5 = "iowait";
                                                                c13 = 3;
                                                            } else if ("irq".equalsIgnoreCase(strArrSplit3[i12])) {
                                                                str5 = "irq";
                                                                c13 = 4;
                                                            } else if ("softirq".equalsIgnoreCase(strArrSplit3[i12])) {
                                                                c13 = 5;
                                                            } else if ("softirq".equalsIgnoreCase(strArrSplit3[i12])) {
                                                                c13 = 6;
                                                            }
                                                            if (str5 != null) {
                                                                fFloatValue = Float.valueOf(strArrSplit3[i12 - 1].replace(str4, "")).floatValue();
                                                                strArr = strArrSplit3;
                                                                String str11 = string + str5;
                                                                if (map2 == map3) {
                                                                    fFloatValue /= com.apm.insight.l.d.d();
                                                                }
                                                                map2.put(str11, Float.valueOf(fFloatValue));
                                                                c14 = 6;
                                                                if (c13 < c14) {
                                                                    break;
                                                                    break;
                                                                } else {
                                                                    i12 += 3;
                                                                    strArrSplit3 = strArr;
                                                                    str4 = str4;
                                                                }
                                                            } else {
                                                                strArr = strArrSplit3;
                                                                str4 = str4;
                                                            }
                                                            c14 = 6;
                                                            if (c13 < c14) {
                                                                break;
                                                                break;
                                                            } else {
                                                                i12 += 3;
                                                                strArrSplit3 = strArr;
                                                                str4 = str4;
                                                            }
                                                        } else if (c13 != 3) {
                                                            c13 = c13;
                                                            if ("irq".equalsIgnoreCase(strArrSplit3[i12])) {
                                                                str5 = "irq";
                                                                c13 = 4;
                                                            } else if ("softirq".equalsIgnoreCase(strArrSplit3[i12])) {
                                                                c13 = 5;
                                                            } else if ("softirq".equalsIgnoreCase(strArrSplit3[i12])) {
                                                                c13 = 6;
                                                            }
                                                            if (str5 != null) {
                                                                fFloatValue = Float.valueOf(strArrSplit3[i12 - 1].replace(str4, "")).floatValue();
                                                                strArr = strArrSplit3;
                                                                String str12 = string + str5;
                                                                if (map2 == map3) {
                                                                    fFloatValue /= com.apm.insight.l.d.d();
                                                                }
                                                                map2.put(str12, Float.valueOf(fFloatValue));
                                                                c14 = 6;
                                                                if (c13 < c14) {
                                                                    break;
                                                                    break;
                                                                } else {
                                                                    i12 += 3;
                                                                    strArrSplit3 = strArr;
                                                                    str4 = str4;
                                                                }
                                                            } else {
                                                                strArr = strArrSplit3;
                                                                str4 = str4;
                                                            }
                                                            c14 = 6;
                                                            if (c13 < c14) {
                                                                break;
                                                                break;
                                                            } else {
                                                                i12 += 3;
                                                                strArrSplit3 = strArr;
                                                                str4 = str4;
                                                            }
                                                        } else if (c13 != 4) {
                                                            c13 = c13;
                                                            if ("softirq".equalsIgnoreCase(strArrSplit3[i12])) {
                                                                c13 = 5;
                                                            } else if ("softirq".equalsIgnoreCase(strArrSplit3[i12])) {
                                                                c13 = 6;
                                                            }
                                                            if (str5 != null) {
                                                                fFloatValue = Float.valueOf(strArrSplit3[i12 - 1].replace(str4, "")).floatValue();
                                                                strArr = strArrSplit3;
                                                                String str13 = string + str5;
                                                                if (map2 == map3) {
                                                                    fFloatValue /= com.apm.insight.l.d.d();
                                                                }
                                                                map2.put(str13, Float.valueOf(fFloatValue));
                                                                c14 = 6;
                                                                if (c13 < c14) {
                                                                    break;
                                                                    break;
                                                                } else {
                                                                    i12 += 3;
                                                                    strArrSplit3 = strArr;
                                                                    str4 = str4;
                                                                }
                                                            } else {
                                                                strArr = strArrSplit3;
                                                                str4 = str4;
                                                            }
                                                            c14 = 6;
                                                            if (c13 < c14) {
                                                                break;
                                                                break;
                                                            } else {
                                                                i12 += 3;
                                                                strArrSplit3 = strArr;
                                                                str4 = str4;
                                                            }
                                                        } else {
                                                            c13 = c13;
                                                            if (c13 != 5) {
                                                                if ("softirq".equalsIgnoreCase(strArrSplit3[i12])) {
                                                                    c13 = 6;
                                                                }
                                                            }
                                                            if (str5 != null) {
                                                                try {
                                                                    fFloatValue = Float.valueOf(strArrSplit3[i12 - 1].replace(str4, "")).floatValue();
                                                                    strArr = strArrSplit3;
                                                                    try {
                                                                        String str14 = string + str5;
                                                                        if (map2 == map3) {
                                                                            fFloatValue /= com.apm.insight.l.d.d();
                                                                        }
                                                                        try {
                                                                            map2.put(str14, Float.valueOf(fFloatValue));
                                                                            c14 = 6;
                                                                        } catch (Throwable unused3) {
                                                                            map2.put(string + str5, Float.valueOf(-1.0f));
                                                                            c14 = 6;
                                                                        }
                                                                    } catch (Throwable unused4) {
                                                                        str4 = str4;
                                                                        map2.put(string + str5, Float.valueOf(-1.0f));
                                                                        c14 = 6;
                                                                        if (c13 < c14) {
                                                                            i12 += 3;
                                                                            strArrSplit3 = strArr;
                                                                            str4 = str4;
                                                                        } else {
                                                                            break;
                                                                            c15 = c11;
                                                                            c12 = 4;
                                                                            if (c15 >= c12) {
                                                                                break;
                                                                                String str15 = str7;
                                                                                jSONObject.put("anr_tag", strTrim2);
                                                                                jSONObject.put("anr_has_ago", String.valueOf(z12));
                                                                                jSONObject.put("anr_reason", str15);
                                                                                a(map5, jSONObject, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
                                                                                a(map3, jSONObject, "total");
                                                                                if (map4.isEmpty()) {
                                                                                    jSONObject.put("npth_anr_systemserver_total", "not found");
                                                                                } else {
                                                                                    jSONObject.put("npth_anr_systemserver_total", b(com.apm.insight.l.c.AnonymousClass1.a(map4).floatValue()));
                                                                                }
                                                                                if (map7.isEmpty()) {
                                                                                    jSONObject.put("npth_anr_kswapd_total", "not found");
                                                                                } else {
                                                                                    jSONObject.put("npth_anr_kswapd_total", b(com.apm.insight.l.c.AnonymousClass1.a(map7).floatValue()));
                                                                                }
                                                                                if (map.isEmpty()) {
                                                                                    jSONObject.put("npth_anr_dex2oat_total", "not found");
                                                                                } else {
                                                                                    jSONObject.put("npth_anr_dex2oat_total", b(com.apm.insight.l.c.AnonymousClass1.a(map).floatValue()));
                                                                                }
                                                                            }
                                                                            i13++;
                                                                            strArrSplit2 = strArrSplit2;
                                                                            length = length;
                                                                            str6 = str2;
                                                                            map6 = map;
                                                                            map7 = map7;
                                                                        }
                                                                    }
                                                                } catch (Throwable unused5) {
                                                                    strArr = strArrSplit3;
                                                                }
                                                                if (c13 < c14) {
                                                                    break;
                                                                }
                                                                i12 += 3;
                                                                strArrSplit3 = strArr;
                                                                str4 = str4;
                                                            } else {
                                                                strArr = strArrSplit3;
                                                                str4 = str4;
                                                            }
                                                            c14 = 6;
                                                            if (c13 < c14) {
                                                                break;
                                                                break;
                                                            } else {
                                                                i12 += 3;
                                                                strArrSplit3 = strArr;
                                                                str4 = str4;
                                                            }
                                                        }
                                                    }
                                                    c13 = c13;
                                                    str5 = null;
                                                    if (str5 != null) {
                                                        fFloatValue = Float.valueOf(strArrSplit3[i12 - 1].replace(str4, "")).floatValue();
                                                        strArr = strArrSplit3;
                                                        String str16 = string + str5;
                                                        if (map2 == map3) {
                                                            fFloatValue /= com.apm.insight.l.d.d();
                                                        }
                                                        map2.put(str16, Float.valueOf(fFloatValue));
                                                        c14 = 6;
                                                        if (c13 < c14) {
                                                            break;
                                                            break;
                                                        } else {
                                                            i12 += 3;
                                                            strArrSplit3 = strArr;
                                                            str4 = str4;
                                                        }
                                                    } else {
                                                        strArr = strArrSplit3;
                                                        str4 = str4;
                                                    }
                                                    c14 = 6;
                                                    if (c13 < c14) {
                                                        break;
                                                        break;
                                                    } else {
                                                        i12 += 3;
                                                        strArrSplit3 = strArr;
                                                        str4 = str4;
                                                    }
                                                }
                                                if ("kernel".equalsIgnoreCase(strArrSplit3[i12])) {
                                                    str5 = "kernel";
                                                    c13 = 2;
                                                } else if ("iowait".equalsIgnoreCase(strArrSplit3[i12])) {
                                                    str5 = "iowait";
                                                    c13 = 3;
                                                } else if ("irq".equalsIgnoreCase(strArrSplit3[i12])) {
                                                    str5 = "irq";
                                                    c13 = 4;
                                                } else if ("softirq".equalsIgnoreCase(strArrSplit3[i12])) {
                                                    c13 = 5;
                                                } else if ("softirq".equalsIgnoreCase(strArrSplit3[i12])) {
                                                    c13 = 6;
                                                } else {
                                                    c13 = c13;
                                                    str5 = null;
                                                }
                                                if (str5 != null) {
                                                    fFloatValue = Float.valueOf(strArrSplit3[i12 - 1].replace(str4, "")).floatValue();
                                                    strArr = strArrSplit3;
                                                    String str17 = string + str5;
                                                    if (map2 == map3) {
                                                        fFloatValue /= com.apm.insight.l.d.d();
                                                    }
                                                    map2.put(str17, Float.valueOf(fFloatValue));
                                                    c14 = 6;
                                                    if (c13 < c14) {
                                                        break;
                                                        break;
                                                    } else {
                                                        i12 += 3;
                                                        strArrSplit3 = strArr;
                                                        str4 = str4;
                                                    }
                                                } else {
                                                    strArr = strArrSplit3;
                                                    str4 = str4;
                                                }
                                                c14 = 6;
                                                if (c13 < c14) {
                                                    break;
                                                    break;
                                                } else {
                                                    i12 += 3;
                                                    strArrSplit3 = strArr;
                                                    str4 = str4;
                                                }
                                            }
                                            c15 = c11;
                                            c12 = 4;
                                            if (c15 >= c12) {
                                                break;
                                                String str18 = str7;
                                                jSONObject.put("anr_tag", strTrim2);
                                                jSONObject.put("anr_has_ago", String.valueOf(z12));
                                                jSONObject.put("anr_reason", str18);
                                                a(map5, jSONObject, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
                                                a(map3, jSONObject, "total");
                                                if (map4.isEmpty()) {
                                                    jSONObject.put("npth_anr_systemserver_total", "not found");
                                                } else {
                                                    jSONObject.put("npth_anr_systemserver_total", b(com.apm.insight.l.c.AnonymousClass1.a(map4).floatValue()));
                                                }
                                                if (map7.isEmpty()) {
                                                    jSONObject.put("npth_anr_kswapd_total", "not found");
                                                } else {
                                                    jSONObject.put("npth_anr_kswapd_total", b(com.apm.insight.l.c.AnonymousClass1.a(map7).floatValue()));
                                                }
                                                if (map.isEmpty()) {
                                                    jSONObject.put("npth_anr_dex2oat_total", "not found");
                                                } else {
                                                    jSONObject.put("npth_anr_dex2oat_total", b(com.apm.insight.l.c.AnonymousClass1.a(map).floatValue()));
                                                }
                                            }
                                            i13++;
                                            strArrSplit2 = strArrSplit2;
                                            length = length;
                                            str6 = str2;
                                            map6 = map;
                                            map7 = map7;
                                        }
                                    } catch (Throwable unused6) {
                                        map = map6;
                                    }
                                    i12 = i15 + 3;
                                    c13 = 0;
                                    while (i12 < strArrSplit3.length) {
                                        str5 = "softirq";
                                        if (c13 != 0) {
                                            if ("user".equalsIgnoreCase(strArrSplit3[i12])) {
                                                str5 = "user";
                                                c13 = 1;
                                            }
                                            if (str5 != null) {
                                                fFloatValue = Float.valueOf(strArrSplit3[i12 - 1].replace(str4, "")).floatValue();
                                                strArr = strArrSplit3;
                                                String str19 = string + str5;
                                                if (map2 == map3) {
                                                    fFloatValue /= com.apm.insight.l.d.d();
                                                }
                                                map2.put(str19, Float.valueOf(fFloatValue));
                                                c14 = 6;
                                                if (c13 < c14) {
                                                    break;
                                                    break;
                                                } else {
                                                    i12 += 3;
                                                    strArrSplit3 = strArr;
                                                    str4 = str4;
                                                }
                                            } else {
                                                strArr = strArrSplit3;
                                                str4 = str4;
                                            }
                                            c14 = 6;
                                            if (c13 < c14) {
                                                break;
                                                break;
                                            } else {
                                                i12 += 3;
                                                strArrSplit3 = strArr;
                                                str4 = str4;
                                            }
                                        } else {
                                            if (c13 != 1) {
                                                if (c13 != 2) {
                                                    c13 = c13;
                                                    if ("iowait".equalsIgnoreCase(strArrSplit3[i12])) {
                                                        str5 = "iowait";
                                                        c13 = 3;
                                                    } else if ("irq".equalsIgnoreCase(strArrSplit3[i12])) {
                                                        str5 = "irq";
                                                        c13 = 4;
                                                    } else if ("softirq".equalsIgnoreCase(strArrSplit3[i12])) {
                                                        c13 = 5;
                                                    } else if ("softirq".equalsIgnoreCase(strArrSplit3[i12])) {
                                                        c13 = 6;
                                                    }
                                                    if (str5 != null) {
                                                        fFloatValue = Float.valueOf(strArrSplit3[i12 - 1].replace(str4, "")).floatValue();
                                                        strArr = strArrSplit3;
                                                        String str110 = string + str5;
                                                        if (map2 == map3) {
                                                            fFloatValue /= com.apm.insight.l.d.d();
                                                        }
                                                        map2.put(str110, Float.valueOf(fFloatValue));
                                                        c14 = 6;
                                                        if (c13 < c14) {
                                                            break;
                                                            break;
                                                        } else {
                                                            i12 += 3;
                                                            strArrSplit3 = strArr;
                                                            str4 = str4;
                                                        }
                                                    } else {
                                                        strArr = strArrSplit3;
                                                        str4 = str4;
                                                    }
                                                    c14 = 6;
                                                    if (c13 < c14) {
                                                        break;
                                                        break;
                                                    } else {
                                                        i12 += 3;
                                                        strArrSplit3 = strArr;
                                                        str4 = str4;
                                                    }
                                                } else if (c13 != 3) {
                                                    c13 = c13;
                                                    if ("irq".equalsIgnoreCase(strArrSplit3[i12])) {
                                                        str5 = "irq";
                                                        c13 = 4;
                                                    } else if ("softirq".equalsIgnoreCase(strArrSplit3[i12])) {
                                                        c13 = 5;
                                                    } else if ("softirq".equalsIgnoreCase(strArrSplit3[i12])) {
                                                        c13 = 6;
                                                    }
                                                    if (str5 != null) {
                                                        fFloatValue = Float.valueOf(strArrSplit3[i12 - 1].replace(str4, "")).floatValue();
                                                        strArr = strArrSplit3;
                                                        String str111 = string + str5;
                                                        if (map2 == map3) {
                                                            fFloatValue /= com.apm.insight.l.d.d();
                                                        }
                                                        map2.put(str111, Float.valueOf(fFloatValue));
                                                        c14 = 6;
                                                        if (c13 < c14) {
                                                            break;
                                                            break;
                                                        } else {
                                                            i12 += 3;
                                                            strArrSplit3 = strArr;
                                                            str4 = str4;
                                                        }
                                                    } else {
                                                        strArr = strArrSplit3;
                                                        str4 = str4;
                                                    }
                                                    c14 = 6;
                                                    if (c13 < c14) {
                                                        break;
                                                        break;
                                                    } else {
                                                        i12 += 3;
                                                        strArrSplit3 = strArr;
                                                        str4 = str4;
                                                    }
                                                } else if (c13 != 4) {
                                                    c13 = c13;
                                                    if ("softirq".equalsIgnoreCase(strArrSplit3[i12])) {
                                                        c13 = 5;
                                                    } else if ("softirq".equalsIgnoreCase(strArrSplit3[i12])) {
                                                        c13 = 6;
                                                    }
                                                    if (str5 != null) {
                                                        fFloatValue = Float.valueOf(strArrSplit3[i12 - 1].replace(str4, "")).floatValue();
                                                        strArr = strArrSplit3;
                                                        String str112 = string + str5;
                                                        if (map2 == map3) {
                                                            fFloatValue /= com.apm.insight.l.d.d();
                                                        }
                                                        map2.put(str112, Float.valueOf(fFloatValue));
                                                        c14 = 6;
                                                        if (c13 < c14) {
                                                            break;
                                                            break;
                                                        } else {
                                                            i12 += 3;
                                                            strArrSplit3 = strArr;
                                                            str4 = str4;
                                                        }
                                                    } else {
                                                        strArr = strArrSplit3;
                                                        str4 = str4;
                                                    }
                                                    c14 = 6;
                                                    if (c13 < c14) {
                                                        break;
                                                        break;
                                                    } else {
                                                        i12 += 3;
                                                        strArrSplit3 = strArr;
                                                        str4 = str4;
                                                    }
                                                } else {
                                                    c13 = c13;
                                                    if (c13 != 5) {
                                                        if ("softirq".equalsIgnoreCase(strArrSplit3[i12])) {
                                                            c13 = 6;
                                                        }
                                                    }
                                                    if (str5 != null) {
                                                        fFloatValue = Float.valueOf(strArrSplit3[i12 - 1].replace(str4, "")).floatValue();
                                                        strArr = strArrSplit3;
                                                        String str113 = string + str5;
                                                        if (map2 == map3) {
                                                            fFloatValue /= com.apm.insight.l.d.d();
                                                        }
                                                        map2.put(str113, Float.valueOf(fFloatValue));
                                                        c14 = 6;
                                                        if (c13 < c14) {
                                                            break;
                                                            break;
                                                        } else {
                                                            i12 += 3;
                                                            strArrSplit3 = strArr;
                                                            str4 = str4;
                                                        }
                                                    } else {
                                                        strArr = strArrSplit3;
                                                        str4 = str4;
                                                    }
                                                    c14 = 6;
                                                    if (c13 < c14) {
                                                        break;
                                                        break;
                                                    } else {
                                                        i12 += 3;
                                                        strArrSplit3 = strArr;
                                                        str4 = str4;
                                                    }
                                                }
                                            }
                                            c13 = c13;
                                            str5 = null;
                                            if (str5 != null) {
                                                fFloatValue = Float.valueOf(strArrSplit3[i12 - 1].replace(str4, "")).floatValue();
                                                strArr = strArrSplit3;
                                                String str114 = string + str5;
                                                if (map2 == map3) {
                                                    fFloatValue /= com.apm.insight.l.d.d();
                                                }
                                                map2.put(str114, Float.valueOf(fFloatValue));
                                                c14 = 6;
                                                if (c13 < c14) {
                                                    break;
                                                    break;
                                                } else {
                                                    i12 += 3;
                                                    strArrSplit3 = strArr;
                                                    str4 = str4;
                                                }
                                            } else {
                                                strArr = strArrSplit3;
                                                str4 = str4;
                                            }
                                            c14 = 6;
                                            if (c13 < c14) {
                                                break;
                                                break;
                                            } else {
                                                i12 += 3;
                                                strArrSplit3 = strArr;
                                                str4 = str4;
                                            }
                                        }
                                        if ("kernel".equalsIgnoreCase(strArrSplit3[i12])) {
                                            str5 = "kernel";
                                            c13 = 2;
                                        } else if ("iowait".equalsIgnoreCase(strArrSplit3[i12])) {
                                            str5 = "iowait";
                                            c13 = 3;
                                        } else if ("irq".equalsIgnoreCase(strArrSplit3[i12])) {
                                            str5 = "irq";
                                            c13 = 4;
                                        } else if ("softirq".equalsIgnoreCase(strArrSplit3[i12])) {
                                            c13 = 5;
                                        } else if ("softirq".equalsIgnoreCase(strArrSplit3[i12])) {
                                            c13 = 6;
                                        } else {
                                            c13 = c13;
                                            str5 = null;
                                        }
                                        if (str5 != null) {
                                            fFloatValue = Float.valueOf(strArrSplit3[i12 - 1].replace(str4, "")).floatValue();
                                            strArr = strArrSplit3;
                                            String str115 = string + str5;
                                            if (map2 == map3) {
                                                fFloatValue /= com.apm.insight.l.d.d();
                                            }
                                            map2.put(str115, Float.valueOf(fFloatValue));
                                            c14 = 6;
                                            if (c13 < c14) {
                                                break;
                                                break;
                                            } else {
                                                i12 += 3;
                                                strArrSplit3 = strArr;
                                                str4 = str4;
                                            }
                                        } else {
                                            strArr = strArrSplit3;
                                            str4 = str4;
                                        }
                                        c14 = 6;
                                        if (c13 < c14) {
                                            break;
                                            break;
                                        } else {
                                            i12 += 3;
                                            strArrSplit3 = strArr;
                                            str4 = str4;
                                        }
                                    }
                                } else {
                                    map = map6;
                                    map7 = map7;
                                }
                            }
                            map = map6;
                            map7 = map7;
                            c12 = 4;
                            c15 = 4;
                        } else {
                            map = map6;
                            map7 = map7;
                        }
                        c15 = c11;
                        c12 = 4;
                    }
                } else {
                    map = map6;
                    map7 = map7;
                    str2 = str6;
                    c11 = c15;
                    String strTrim4 = strTrim3.trim();
                    if (strTrim4.startsWith("tag:")) {
                        strTrim2 = strTrim4.replace("tag:", "").trim();
                        c12 = 4;
                        c15 = 1;
                    } else {
                        c15 = c11;
                        c12 = 4;
                    }
                }
                if (c15 >= c12) {
                    break;
                }
            } else {
                map = map6;
                map7 = map7;
                str2 = str6;
            }
            i13++;
            strArrSplit2 = strArrSplit2;
            length = length;
            str6 = str2;
            map6 = map;
            map7 = map7;
        }
        String str116 = str7;
        jSONObject.put("anr_tag", strTrim2);
        jSONObject.put("anr_has_ago", String.valueOf(z12));
        jSONObject.put("anr_reason", str116);
        a(map5, jSONObject, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        a(map3, jSONObject, "total");
        if (map4.isEmpty()) {
            jSONObject.put("npth_anr_systemserver_total", "not found");
        } else {
            jSONObject.put("npth_anr_systemserver_total", b(com.apm.insight.l.c.AnonymousClass1.a(map4).floatValue()));
        }
        if (map7.isEmpty()) {
            jSONObject.put("npth_anr_kswapd_total", "not found");
        } else {
            jSONObject.put("npth_anr_kswapd_total", b(com.apm.insight.l.c.AnonymousClass1.a(map7).floatValue()));
        }
        if (map.isEmpty()) {
            jSONObject.put("npth_anr_dex2oat_total", "not found");
        } else {
            jSONObject.put("npth_anr_dex2oat_total", b(com.apm.insight.l.c.AnonymousClass1.a(map).floatValue()));
        }
    }

    private static void a(HashMap<String, Float> map, JSONObject jSONObject, String str) throws JSONException {
        String strConcat = "npth_anr_".concat(String.valueOf(str));
        if (map.isEmpty()) {
            jSONObject.put(strConcat + "_total", "not found");
            return;
        }
        float fFloatValue = 0.0f;
        float fFloatValue2 = 0.0f;
        float fFloatValue3 = 0.0f;
        float fFloatValue4 = 0.0f;
        float fFloatValue5 = 0.0f;
        for (Map.Entry<String, Float> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.endsWith("user")) {
                fFloatValue += entry.getValue().floatValue();
            } else if (key.endsWith("kernel")) {
                fFloatValue2 += entry.getValue().floatValue();
            } else if (key.endsWith("iowait")) {
                fFloatValue3 += entry.getValue().floatValue();
            } else if (key.endsWith("irq")) {
                fFloatValue4 += entry.getValue().floatValue();
            } else if (key.endsWith("softirq")) {
                fFloatValue5 += entry.getValue().floatValue();
            }
        }
        float f11 = fFloatValue + fFloatValue2 + fFloatValue3 + fFloatValue4 + fFloatValue5;
        jSONObject.put(strConcat + "_total", b(f11));
        jSONObject.put(strConcat + "_kernel_user_ratio", a(fFloatValue2, f11));
        jSONObject.put(strConcat + "_iowait_user_ratio", a(fFloatValue3, f11));
    }

    private void a(JSONArray jSONArray) {
        int[] iArrB;
        int[] iArrB2;
        if (jSONArray == null) {
            return;
        }
        this.f16611g = null;
        this.f16618n = null;
        this.f16619o = 0;
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray3 = new JSONArray();
        JSONArray jSONArray4 = new JSONArray();
        this.f16613i = AppLovinMediationProvider.UNKNOWN;
        this.f16614j = AppLovinMediationProvider.UNKNOWN;
        this.f16615k = AppLovinMediationProvider.UNKNOWN;
        int[] iArr = {0, 0, 0};
        JSONArray jSONArray5 = jSONArray4;
        String strTrim = null;
        boolean z11 = false;
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            String strOptString = jSONArray.optString(i11);
            if (TextUtils.isEmpty(strOptString)) {
                if (jSONArray5.length() > 0 && !TextUtils.isEmpty(strTrim)) {
                    if (this.f16611g == null && "main".equals(strTrim)) {
                        this.f16611g = c(jSONArray5);
                    } else {
                        jSONArray2.put(a(strTrim, jSONArray5));
                    }
                    try {
                        if (!"main".equals(strTrim)) {
                            strTrim = strTrim.substring(0, strTrim.indexOf(40)).trim();
                        }
                    } catch (Throwable unused) {
                    }
                    String str = strTrim;
                    if (!a(str)) {
                        try {
                            iArrB2 = b(jSONArray5);
                        } catch (IllegalArgumentException e11) {
                            com.apm.insight.c.a();
                            com.apm.insight.runtime.k.a(e11, "NPTH_CATCH");
                            iArrB2 = null;
                        } catch (Throwable unused2) {
                            iArrB2 = null;
                        }
                        if (iArrB2 != null) {
                            int i12 = iArrB2[0];
                            if (i12 > iArr[0]) {
                                iArr[0] = i12;
                                this.f16613i = str;
                            }
                            int i13 = iArrB2[1];
                            if (i13 > iArr[1]) {
                                iArr[1] = i13;
                                this.f16614j = str;
                            }
                            int i14 = iArrB2[2];
                            if (i14 > iArr[2]) {
                                iArr[2] = i14;
                                this.f16615k = str;
                            }
                        }
                    }
                }
                if (jSONArray5.length() > 0) {
                    jSONArray5 = new JSONArray();
                }
                strTrim = null;
            } else if (!z11) {
                if (strOptString.startsWith("DALVIK THREADS") || strOptString.startsWith("suspend") || strOptString.startsWith("\"")) {
                    z11 = true;
                }
                jSONArray3.put(strOptString);
            } else if (z11) {
                if (strOptString.contains(" prio=")) {
                    if (jSONArray5.length() > 0 && !TextUtils.isEmpty(strTrim)) {
                        if (this.f16611g == null && "main".equals(strTrim)) {
                            this.f16611g = c(jSONArray5);
                        } else {
                            jSONArray2.put(a(strTrim, jSONArray5));
                        }
                        try {
                            if (!"main".equals(strTrim)) {
                                strTrim = strTrim.substring(0, strTrim.indexOf(40)).trim();
                            }
                        } catch (Throwable unused3) {
                        }
                        String str2 = strTrim;
                        if (!a(str2)) {
                            try {
                                iArrB = b(jSONArray5);
                            } catch (IllegalArgumentException e12) {
                                com.apm.insight.c.a();
                                com.apm.insight.runtime.k.a(e12, "NPTH_CATCH");
                                iArrB = null;
                            } catch (Throwable unused4) {
                                iArrB = null;
                            }
                            if (iArrB != null) {
                                int i15 = iArrB[0];
                                if (i15 > iArr[0]) {
                                    iArr[0] = i15;
                                    this.f16613i = str2;
                                }
                                int i16 = iArrB[1];
                                if (i16 > iArr[1]) {
                                    iArr[1] = i16;
                                    this.f16614j = str2;
                                }
                                int i17 = iArrB[2];
                                if (i17 > iArr[2]) {
                                    iArr[2] = i17;
                                    this.f16615k = str2;
                                }
                            }
                        }
                    }
                    String strSubstring = strOptString.substring(1, strOptString.indexOf(34, 1));
                    strTrim = "main".equals(strSubstring) ? strSubstring : strSubstring + "  (" + strOptString.substring(strOptString.indexOf(34, 2) + 1) + " )";
                    if (jSONArray5.length() > 0) {
                        jSONArray5 = new JSONArray();
                    }
                    jSONArray5.put(strOptString);
                } else if (TextUtils.isEmpty(strTrim)) {
                    jSONArray3.put(strOptString);
                } else {
                    jSONArray5.put(strOptString);
                }
            }
        }
        if (jSONArray2.length() > 0) {
            this.f16617m = jSONArray3;
            try {
                JSONObject jSONObject = new JSONObject();
                this.f16618n = jSONObject;
                jSONObject.put("thread_all_count", jSONArray2.length());
                this.f16618n.put("thread_stacks", jSONArray2);
            } catch (JSONException e13) {
                e13.printStackTrace();
            }
        }
    }

    private boolean a(long j11) {
        if (this.f16626v) {
            this.f16626v = false;
            b(j11);
        }
        return false;
    }

    private boolean a(String str) {
        if (this.B == null) {
            JSONArray jSONArrayB = com.apm.insight.runtime.a.b();
            if (jSONArrayB != null) {
                this.B = new LinkedList();
                this.f16616l = jSONArrayB.optString(0);
                for (int i11 = 1; i11 < jSONArrayB.length(); i11++) {
                    try {
                        this.B.add(Pattern.compile(jSONArrayB.optString(i11)));
                    } catch (Throwable unused) {
                    }
                }
            }
            if (this.B == null) {
                LinkedList linkedList = new LinkedList();
                this.B = linkedList;
                linkedList.add(Pattern.compile("^main$"));
                this.B.add(Pattern.compile("^default_npth_thread$"));
                this.B.add(Pattern.compile("^RenderThread$"));
                this.B.add(Pattern.compile("^Jit thread pool worker thread.*$"));
            }
        }
        Iterator<Pattern> it = this.B.iterator();
        while (it.hasNext()) {
            if (it.next().matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    private static String b(float f11) {
        return a(f11 / 100.0f);
    }

    private void b(long j11) {
        if (this.f16628x != this.f16627w) {
            try {
                this.f16620p = System.currentTimeMillis();
                this.f16622r = f.b().b();
                this.f16621q = j.a(j11);
                this.f16612h = f.b().a(j11).a();
                JSONObject jSONObject = new JSONObject();
                this.f16623s = jSONObject;
                com.apm.insight.l.a.a(this.f16606b, jSONObject);
                this.f16624t = h();
                this.f16610f = !Npth.hasCrash();
            } catch (Throwable unused) {
            }
            try {
                this.f16608d = this.f16620p;
                String strB = com.apm.insight.l.j.b();
                File file = new File(new File(com.apm.insight.l.j.f(this.f16606b), strB), "trace_" + com.apm.insight.l.a.d(this.f16606b).replace(':', '_') + ".txt");
                file.getParentFile().mkdirs();
                com.apm.insight.l.f.a(file, com.apm.insight.l.b.a().format(new Date(System.currentTimeMillis())) + "\n", false);
                p.a("anr_trace", strB);
                NativeImpl.i(file.getAbsolutePath());
                try {
                    JSONArray jSONArrayA = com.apm.insight.l.f.a(file.getAbsolutePath());
                    this.f16617m = jSONArrayA;
                    a(jSONArrayA);
                } catch (IOException unused2) {
                } catch (Throwable th2) {
                    com.apm.insight.c.a();
                    com.apm.insight.runtime.k.a(th2, "NPTH_CATCH");
                }
                if (this.f16611g == null) {
                    this.f16611g = d.a();
                }
            } catch (Throwable th3) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.k.a(th3, "NPTH_CATCH");
            }
            com.apm.insight.a.d();
        } else {
            try {
                this.f16608d = this.f16620p;
                String strB2 = com.apm.insight.l.j.b();
                File file2 = new File(new File(com.apm.insight.l.j.f(this.f16606b), strB2), "trace" + com.apm.insight.l.a.d(this.f16606b).replace(':', '_') + ".txt");
                file2.getParentFile().mkdirs();
                com.apm.insight.l.f.a(file2, com.apm.insight.l.b.a().format(new Date(System.currentTimeMillis())) + "\n", false);
                p.a("anr_trace", strB2);
                NativeImpl.i(file2.getAbsolutePath());
                try {
                    JSONArray jSONArrayA2 = com.apm.insight.l.f.a(file2.getAbsolutePath());
                    this.f16617m = jSONArrayA2;
                    a(jSONArrayA2);
                } catch (IOException unused3) {
                } catch (Throwable th4) {
                    com.apm.insight.c.a();
                    com.apm.insight.runtime.k.a(th4, "NPTH_CATCH");
                }
                if (this.f16611g == null) {
                    this.f16611g = d.a();
                }
            } catch (Throwable th5) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.k.a(th5, "NPTH_CATCH");
            }
        }
        long j12 = this.f16627w;
        this.f16628x = j12;
        this.f16627w = -1L;
        if (j12 == -1) {
            this.f16628x = (-1) - 1;
        }
    }

    private static void b(String str, JSONArray jSONArray) {
        for (ICrashCallback iCrashCallback : m.a().e()) {
            try {
                if (iCrashCallback instanceof com.apm.insight.b) {
                    ((com.apm.insight.b) iCrashCallback).a(CrashType.ANR, str, (Thread) null, jSONArray);
                } else {
                    iCrashCallback.onCrash(CrashType.ANR, str, null);
                }
            } catch (Throwable th2) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.k.a(th2, "NPTH_CATCH");
            }
        }
    }

    @Nullable
    private int[] b(@NonNull JSONArray jSONArray) throws IllegalArgumentException {
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            String strOptString = jSONArray.optString(i11);
            int iIndexOf = (strOptString == null || strOptString.isEmpty()) ? -1 : strOptString.indexOf("utm=");
            if (iIndexOf > 0) {
                if (this.C == null) {
                    this.C = Pattern.compile("[^0-9]+");
                }
                String[] strArrSplit = this.C.split(strOptString.substring(iIndexOf));
                if (strArrSplit == null || strArrSplit.length < 2) {
                    return null;
                }
                try {
                    int iIntValue = Integer.decode(strArrSplit[1]).intValue();
                    int iIntValue2 = Integer.decode(strArrSplit[2]).intValue();
                    return new int[]{iIntValue, iIntValue2, iIntValue + iIntValue2};
                } catch (Throwable unused) {
                    throw new IllegalArgumentException("Err stack line: ".concat(strOptString));
                }
            }
        }
        return null;
    }

    private JSONObject c(@NonNull JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArrayB = com.apm.insight.a.b(jSONArray);
        if (jSONArrayB.length() != jSONArray.length()) {
            this.f16619o++;
        }
        try {
            jSONObject.put("thread_number", 1);
            StringBuilder sb2 = new StringBuilder();
            for (int i11 = 0; i11 < jSONArrayB.length(); i11++) {
                sb2.append(jSONArrayB.getString(i11));
                sb2.append('\n');
            }
            jSONObject.put("mainStackFromTrace", sb2.toString());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private boolean h() {
        boolean z11 = !com.apm.insight.l.a.a(this.f16606b);
        if (!z11 || com.apm.insight.runtime.a.b.d().e() > AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
            return z11;
        }
        return false;
    }

    private File i() {
        if (this.D == null) {
            this.D = new File(this.f16606b.getFilesDir(), "has_anr_signal_" + com.apm.insight.l.a.d(this.f16606b).replaceAll(":", "_"));
        }
        return this.D;
    }

    public final void a() {
        if (this.f16607c) {
            return;
        }
        this.f16605a = new c(this);
        this.f16608d = com.apm.insight.e.j();
        this.f16607c = true;
    }

    public final void b() {
        if (this.f16607c) {
            this.f16607c = false;
            c cVar = this.f16605a;
            if (cVar != null) {
                cVar.b();
            }
            this.f16605a = null;
        }
    }

    public final void c() {
        c cVar = this.f16605a;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void d() {
        synchronized (this.f16625u) {
        }
        this.f16629y.run();
    }

    public final void e() {
        if (NativeImpl.h()) {
            try {
                com.apm.insight.l.f.a(i(), String.valueOf(this.A + 1), false);
            } catch (Throwable th2) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.k.a(th2, "NPTH_CATCH");
            }
        }
        this.f16627w = SystemClock.uptimeMillis();
        this.f16626v = true;
    }

    public final void f() {
        File fileI = i();
        try {
            int iIntValue = Integer.decode(com.apm.insight.l.f.a(fileI.getAbsolutePath(), "\n")).intValue();
            this.A = iIntValue;
            if (iIntValue >= 2) {
                NativeImpl.a(false);
            } else {
                NativeImpl.a(true);
            }
        } catch (IOException unused) {
            NativeImpl.a(true);
        } catch (Throwable unused2) {
            com.apm.insight.l.f.a(fileI);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0359  */
    /* JADX WARN: Code duplicated, block: B:101:0x035c  */
    /* JADX WARN: Code duplicated, block: B:104:0x037f  */
    /* JADX WARN: Code duplicated, block: B:105:0x0382  */
    /* JADX WARN: Code duplicated, block: B:108:0x03b3 A[Catch: all -> 0x0241, TRY_LEAVE, TryCatch #2 {all -> 0x0241, blocks: (B:73:0x023b, B:76:0x0245, B:98:0x02b1, B:102:0x035e, B:106:0x0384, B:108:0x03b3, B:113:0x03c2, B:109:0x03bc), top: B:135:0x023b, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x03e2 A[Catch: all -> 0x03e9, TRY_LEAVE, TryCatch #4 {all -> 0x03e9, blocks: (B:117:0x03d4, B:119:0x03e2), top: B:139:0x03d4 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x0410 A[Catch: all -> 0x041b, TRY_LEAVE, TryCatch #6 {all -> 0x041b, blocks: (B:120:0x03e9, B:122:0x0410), top: B:143:0x03e9 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x0236 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0143  */
    /* JADX WARN: Code duplicated, block: B:60:0x01c4 A[Catch: all -> 0x01ca, TryCatch #5 {all -> 0x01ca, blocks: (B:58:0x0149, B:60:0x01c4, B:63:0x01cd, B:65:0x01d3, B:68:0x01db, B:70:0x01e2, B:116:0x03cc, B:123:0x041b, B:69:0x01de), top: B:141:0x0149 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x01d3 A[Catch: all -> 0x01ca, TryCatch #5 {all -> 0x01ca, blocks: (B:58:0x0149, B:60:0x01c4, B:63:0x01cd, B:65:0x01d3, B:68:0x01db, B:70:0x01e2, B:116:0x03cc, B:123:0x041b, B:69:0x01de), top: B:141:0x0149 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:75:0x0244  */
    /* JADX WARN: Code duplicated, block: B:78:0x0270  */
    /* JADX WARN: Code duplicated, block: B:79:0x0273  */
    /* JADX WARN: Code duplicated, block: B:81:0x027a  */
    /* JADX WARN: Code duplicated, block: B:82:0x027d  */
    /* JADX WARN: Code duplicated, block: B:84:0x0284  */
    /* JADX WARN: Code duplicated, block: B:85:0x0287  */
    /* JADX WARN: Code duplicated, block: B:87:0x028e  */
    /* JADX WARN: Code duplicated, block: B:88:0x0291  */
    /* JADX WARN: Code duplicated, block: B:90:0x0298  */
    /* JADX WARN: Code duplicated, block: B:91:0x029b  */
    /* JADX WARN: Code duplicated, block: B:93:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:94:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:96:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:97:0x02af  */
    public final boolean g() {
        String str;
        String str2;
        JSONArray jSONArrayB;
        JSONArray jSONArrayA;
        JSONObject jSONObject;
        boolean z11;
        JSONObject jSONObjectA;
        boolean z12;
        String str3;
        String str4;
        JSONArray jSONArray;
        final long j11;
        JSONObject jSONObjectA2;
        JSONObject jSONObject2;
        com.apm.insight.entity.a aVar;
        JSONObject jSONObject3;
        JSONObject jSONObjectB;
        com.apm.insight.entity.a aVarA;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject4;
        JSONArray jSONArrayA2;
        long j12;
        String str5;
        String str6;
        String str7;
        int i11;
        JSONObject jSONObject5;
        boolean zB = com.apm.insight.runtime.j.a().b();
        long jUptimeMillis = SystemClock.uptimeMillis();
        a(jUptimeMillis);
        String strA = d.a(this.f16606b);
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str8 = "normal";
        TextUtils.isEmpty(strA);
        if (TextUtils.isEmpty(strA)) {
            str = AppLovinMediationProvider.UNKNOWN;
            str2 = AppLovinMediationProvider.UNKNOWN;
            jSONArrayB = null;
            jSONArrayA = null;
            jSONObject = null;
            z11 = false;
            jSONObjectA = null;
            z12 = false;
            str3 = "normal";
            str4 = AppLovinMediationProvider.UNKNOWN;
            jSONArray = null;
            j11 = jCurrentTimeMillis;
            jSONObjectA2 = null;
        } else {
            synchronized (this.f16625u) {
            }
            if (this.f16611g == null || System.currentTimeMillis() - this.f16608d > DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT) {
                if (this.f16626v) {
                    this.f16626v = false;
                    str8 = "trace_after";
                }
                b(jUptimeMillis);
            } else {
                str8 = "trace_last";
            }
            JSONObject jSONObject6 = this.f16611g;
            String str9 = this.f16613i;
            String str10 = this.f16614j;
            String str11 = this.f16615k;
            JSONArray jSONArray2 = this.f16617m;
            JSONArray jSONArray3 = this.f16622r;
            JSONArray jSONArray4 = this.f16621q;
            JSONObject jSONObject7 = this.f16623s;
            JSONObject jSONObject8 = this.f16612h;
            z12 = this.f16624t;
            long j13 = this.f16620p;
            this.f16611g = null;
            this.f16617m = null;
            this.f16621q = null;
            this.f16612h = null;
            this.f16622r = null;
            this.f16613i = AppLovinMediationProvider.UNKNOWN;
            this.f16614j = AppLovinMediationProvider.UNKNOWN;
            this.f16615k = AppLovinMediationProvider.UNKNOWN;
            this.f16619o = 0;
            jSONArrayA = jSONArray4;
            str2 = str11;
            str4 = str9;
            jSONArray = jSONArray2;
            jSONObjectA = jSONObject8;
            jSONObject = jSONObject7;
            jSONArrayB = jSONArray3;
            str = str10;
            str3 = str8;
            j11 = j13;
            jSONObjectA2 = jSONObject6;
            z11 = true;
        }
        if (TextUtils.isEmpty(strA)) {
            if (this.f16611g == null || System.currentTimeMillis() - this.f16608d <= DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT) {
                if (this.f16611g == null || System.currentTimeMillis() - this.f16608d <= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS || !NativeImpl.h()) {
                    return false;
                }
                com.apm.insight.l.f.a(i());
                return false;
            }
            this.f16611g = null;
            this.f16617m = null;
            this.f16621q = null;
            this.f16612h = null;
            this.f16622r = null;
            this.f16613i = AppLovinMediationProvider.UNKNOWN;
            this.f16614j = AppLovinMediationProvider.UNKNOWN;
            this.f16615k = AppLovinMediationProvider.UNKNOWN;
            this.f16619o = 0;
            this.f16609e = null;
            return false;
        }
        if (jSONObjectA2 == null) {
            if (jSONArrayA == null) {
                try {
                    jSONArrayB = f.b().b();
                    jSONArrayA = j.a(jUptimeMillis);
                    jSONObject5 = jSONObjectA2;
                    try {
                        jSONObjectA = f.b().a(jUptimeMillis).a();
                        JSONObject jSONObject9 = new JSONObject();
                        try {
                            com.apm.insight.l.a.a(this.f16606b, jSONObject9);
                            jSONObject = jSONObject9;
                        } catch (Throwable unused) {
                            jSONObject = jSONObject9;
                            jSONObjectA2 = jSONObject5;
                        }
                    } catch (Throwable unused2) {
                        jSONObjectA2 = jSONObject5;
                        jSONObject2 = jSONObjectA;
                        if (jSONObjectA2 != null) {
                            try {
                                jSONObjectA2.put("pid", Process.myPid());
                                jSONObjectA2.put("package", this.f16606b.getPackageName());
                                jSONObjectA2.put("is_remote_process", 0);
                                jSONObjectA2.put("is_new_stack", 10);
                                aVar = new com.apm.insight.entity.a(new JSONObject());
                                String str12 = str2;
                                aVar.a("data", (Object) jSONObjectA2.toString());
                                JSONObject jSONObject10 = jSONObjectA2;
                                aVar.a("is_anr", (Object) 1);
                                aVar.a("anrType", (Object) str3);
                                aVar.a("history_message", (Object) jSONArrayB);
                                aVar.a("current_message", jSONObject2);
                                aVar.a("pending_messages", (Object) jSONArrayA);
                                aVar.a("anr_time", Long.valueOf(System.currentTimeMillis()));
                                aVar.a("crash_time", Long.valueOf(j11));
                                com.apm.insight.c.a.b();
                                aVar.c(jSONObject);
                                aVar.a("anr_info", (Object) strA);
                                if (jSONArray != null) {
                                    aVar.a("dump_trace", (Object) jSONArray);
                                }
                                jSONObject3 = this.f16618n;
                                jSONObjectB = jSONObject3 == null ? com.apm.insight.l.m.b((String) null) : com.apm.insight.l.m.b((String) null);
                                aVar.a("all_thread_stacks", jSONObjectB);
                                com.apm.insight.runtime.a.f fVarA = com.apm.insight.runtime.a.f.a();
                                CrashType crashType = CrashType.ANR;
                                aVarA = fVarA.a(crashType, aVar);
                                aVarA.a("is_background", Boolean.valueOf(z12));
                                aVarA.a("logcat", (Object) com.apm.insight.runtime.i.a(com.apm.insight.e.f()));
                                aVarA.a("has_dump", (Object) "true");
                                aVarA.a("crash_uuid", (Object) com.apm.insight.e.a(j11, crashType, false, false));
                                aVarA.a("jiffy", Long.valueOf(o.a.a()));
                                jSONObjectOptJSONObject = aVarA.c().optJSONObject("filters");
                                com.apm.insight.entity.d.b(aVarA.c());
                                if (jSONObjectOptJSONObject == null) {
                                    try {
                                        jSONObject4 = new JSONObject();
                                        try {
                                            aVarA.a("filters", jSONObject4);
                                        } catch (Throwable unused3) {
                                            jSONObjectOptJSONObject = jSONObject4;
                                            jSONObject4 = jSONObjectOptJSONObject;
                                        }
                                    } catch (Throwable unused4) {
                                        jSONObject4 = jSONObjectOptJSONObject;
                                    }
                                } else {
                                    jSONObject4 = jSONObjectOptJSONObject;
                                }
                                jSONObject4.put("anrType", str3);
                                jSONObject4.put("max_utm_thread", str4);
                                jSONObject4.put("max_stm_thread", str);
                                jSONObject4.put("max_utm_stm_thread", str12);
                                jSONObject4.put("max_utm_thread_version", this.f16616l);
                                j12 = j11 - com.apm.insight.e.j();
                                if (j12 < 30000) {
                                    str5 = "0 - 30s";
                                } else if (j12 < ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) {
                                    str5 = "30s - 1min";
                                } else if (j12 < 120000) {
                                    str5 = "1min - 2min";
                                } else if (j12 < 300000) {
                                    str5 = "2min - 5min";
                                } else if (j12 < TTAdConstant.AD_MAX_EVENT_TIME) {
                                    str5 = "5min - 10min";
                                } else if (j12 < 1800000) {
                                    str5 = "10min - 30min";
                                } else if (j12 < 3600000) {
                                    str5 = "30min - 1h";
                                } else {
                                    str5 = "1h - ";
                                }
                                jSONObject4.put("crash_length", str5);
                                jSONObject4.put("disable_looper_monitor", String.valueOf(com.apm.insight.runtime.a.c()));
                                jSONObject4.put("npth_force_apm_crash", String.valueOf(com.apm.insight.c.a.b()));
                                jSONObject4.put("sdk_version", "1.3.8.nourl-rc.1");
                                jSONObject4.put("has_logcat", String.valueOf(aVarA.a()));
                                jSONObject4.put("memory_leak", String.valueOf(com.apm.insight.entity.a.a(com.apm.insight.e.f())));
                                jSONObject4.put("fd_leak", String.valueOf(com.apm.insight.entity.a.b(com.apm.insight.e.f())));
                                jSONObject4.put("threads_leak", String.valueOf(com.apm.insight.entity.a.c(com.apm.insight.e.f())));
                                jSONObject4.put("is_64_devices", String.valueOf(Header.a()));
                                jSONObject4.put("is_64_runtime", String.valueOf(NativeImpl.f()));
                                jSONObject4.put("is_x86_devices", String.valueOf(Header.b()));
                                jSONObject4.put("has_meminfo_file", String.valueOf(com.apm.insight.l.j.d(com.apm.insight.e.f()).exists()));
                                if (com.apm.insight.nativecrash.a.k()) {
                                    str6 = "true";
                                } else {
                                    str6 = "false";
                                }
                                jSONObject4.put("is_root", str6);
                                jSONObject4.put("anr_normal_trace", String.valueOf(!this.f16626v));
                                jSONObject4.put("anr_no_run", String.valueOf(zB));
                                if (Npth.hasCrash()) {
                                    str7 = "true";
                                } else {
                                    str7 = "false";
                                }
                                jSONObject4.put("crash_after_crash", str7);
                                jSONObject4.put("from_file", String.valueOf(d.b()));
                                jSONObject4.put("has_dump", "true");
                                jSONObject4.put("from_kill", "false");
                                jSONObject4.put("last_resume_activity", com.apm.insight.runtime.a.b.d().h());
                                i11 = this.f16619o;
                                if (i11 > 0) {
                                    jSONObject4.put("may_have_stack_overflow", String.valueOf(i11));
                                }
                                try {
                                    a(strA, jSONObject4);
                                } catch (Throwable th2) {
                                    com.apm.insight.c.a();
                                    com.apm.insight.runtime.k.a(th2, "NPTH_CATCH");
                                }
                                com.apm.insight.a.a.a();
                                CrashType crashType2 = CrashType.LAUNCH;
                                com.apm.insight.e.e();
                                try {
                                    if (com.apm.insight.a.e().length() > 1024) {
                                        aVarA.a("has_system_traces", "true");
                                    }
                                } catch (Throwable unused5) {
                                }
                                try {
                                    jSONArrayA2 = com.apm.insight.nativecrash.b.a(com.apm.insight.l.j.e(com.apm.insight.e.f()), com.apm.insight.l.j.f(com.apm.insight.e.f()));
                                    jSONObject4.put("leak_threads_count", String.valueOf(jSONArrayA2.length()));
                                    if (jSONArrayA2.length() > 0) {
                                        com.apm.insight.l.f.a(com.apm.insight.l.j.g(com.apm.insight.e.f()), jSONArrayA2);
                                    }
                                } catch (Throwable unused6) {
                                }
                                String strOptString = jSONObject10.optString("mainStackFromTrace");
                                JSONArray jSONArrayA3 = com.apm.insight.entity.b.a(strOptString);
                                com.apm.insight.entity.b.a(aVarA.c(), jSONArrayA3, new com.apm.insight.entity.b.a() { // from class: com.apm.insight.b.b.2
                                    @Override // com.apm.insight.entity.b.a
                                    public final void a(JSONObject jSONObject11) {
                                        com.apm.insight.k.d.a().a(jSONObject11, j11, b.this.f16610f);
                                    }
                                });
                                b(strOptString, jSONArrayA3);
                            } catch (Throwable th3) {
                                com.apm.insight.c.a();
                                com.apm.insight.runtime.k.a(th3, "NPTH_CATCH");
                            }
                        }
                        return z11;
                    }
                } catch (Throwable unused7) {
                    jSONObject5 = jSONObjectA2;
                    jSONObjectA2 = jSONObject5;
                    jSONObject2 = jSONObjectA;
                    if (jSONObjectA2 != null) {
                        jSONObjectA2.put("pid", Process.myPid());
                        jSONObjectA2.put("package", this.f16606b.getPackageName());
                        jSONObjectA2.put("is_remote_process", 0);
                        jSONObjectA2.put("is_new_stack", 10);
                        aVar = new com.apm.insight.entity.a(new JSONObject());
                        String str13 = str2;
                        aVar.a("data", (Object) jSONObjectA2.toString());
                        JSONObject jSONObject11 = jSONObjectA2;
                        aVar.a("is_anr", (Object) 1);
                        aVar.a("anrType", (Object) str3);
                        aVar.a("history_message", (Object) jSONArrayB);
                        aVar.a("current_message", jSONObject2);
                        aVar.a("pending_messages", (Object) jSONArrayA);
                        aVar.a("anr_time", Long.valueOf(System.currentTimeMillis()));
                        aVar.a("crash_time", Long.valueOf(j11));
                        com.apm.insight.c.a.b();
                        aVar.c(jSONObject);
                        aVar.a("anr_info", (Object) strA);
                        if (jSONArray != null) {
                            aVar.a("dump_trace", (Object) jSONArray);
                        }
                        jSONObject3 = this.f16618n;
                        if (jSONObject3 == null) {
                        }
                        aVar.a("all_thread_stacks", jSONObjectB);
                        com.apm.insight.runtime.a.f fVarA2 = com.apm.insight.runtime.a.f.a();
                        CrashType crashType3 = CrashType.ANR;
                        aVarA = fVarA2.a(crashType3, aVar);
                        aVarA.a("is_background", Boolean.valueOf(z12));
                        aVarA.a("logcat", (Object) com.apm.insight.runtime.i.a(com.apm.insight.e.f()));
                        aVarA.a("has_dump", (Object) "true");
                        aVarA.a("crash_uuid", (Object) com.apm.insight.e.a(j11, crashType3, false, false));
                        aVarA.a("jiffy", Long.valueOf(o.a.a()));
                        jSONObjectOptJSONObject = aVarA.c().optJSONObject("filters");
                        com.apm.insight.entity.d.b(aVarA.c());
                        if (jSONObjectOptJSONObject == null) {
                            jSONObject4 = new JSONObject();
                            aVarA.a("filters", jSONObject4);
                        } else {
                            jSONObject4 = jSONObjectOptJSONObject;
                        }
                        jSONObject4.put("anrType", str3);
                        jSONObject4.put("max_utm_thread", str4);
                        jSONObject4.put("max_stm_thread", str);
                        jSONObject4.put("max_utm_stm_thread", str13);
                        jSONObject4.put("max_utm_thread_version", this.f16616l);
                        j12 = j11 - com.apm.insight.e.j();
                        if (j12 < 30000) {
                            str5 = "0 - 30s";
                        } else if (j12 < ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) {
                            str5 = "30s - 1min";
                        } else if (j12 < 120000) {
                            str5 = "1min - 2min";
                        } else if (j12 < 300000) {
                            str5 = "2min - 5min";
                        } else if (j12 < TTAdConstant.AD_MAX_EVENT_TIME) {
                            str5 = "5min - 10min";
                        } else if (j12 < 1800000) {
                            str5 = "10min - 30min";
                        } else if (j12 < 3600000) {
                            str5 = "30min - 1h";
                        } else {
                            str5 = "1h - ";
                        }
                        jSONObject4.put("crash_length", str5);
                        jSONObject4.put("disable_looper_monitor", String.valueOf(com.apm.insight.runtime.a.c()));
                        jSONObject4.put("npth_force_apm_crash", String.valueOf(com.apm.insight.c.a.b()));
                        jSONObject4.put("sdk_version", "1.3.8.nourl-rc.1");
                        jSONObject4.put("has_logcat", String.valueOf(aVarA.a()));
                        jSONObject4.put("memory_leak", String.valueOf(com.apm.insight.entity.a.a(com.apm.insight.e.f())));
                        jSONObject4.put("fd_leak", String.valueOf(com.apm.insight.entity.a.b(com.apm.insight.e.f())));
                        jSONObject4.put("threads_leak", String.valueOf(com.apm.insight.entity.a.c(com.apm.insight.e.f())));
                        jSONObject4.put("is_64_devices", String.valueOf(Header.a()));
                        jSONObject4.put("is_64_runtime", String.valueOf(NativeImpl.f()));
                        jSONObject4.put("is_x86_devices", String.valueOf(Header.b()));
                        jSONObject4.put("has_meminfo_file", String.valueOf(com.apm.insight.l.j.d(com.apm.insight.e.f()).exists()));
                        if (com.apm.insight.nativecrash.a.k()) {
                            str6 = "true";
                        } else {
                            str6 = "false";
                        }
                        jSONObject4.put("is_root", str6);
                        jSONObject4.put("anr_normal_trace", String.valueOf(!this.f16626v));
                        jSONObject4.put("anr_no_run", String.valueOf(zB));
                        if (Npth.hasCrash()) {
                            str7 = "true";
                        } else {
                            str7 = "false";
                        }
                        jSONObject4.put("crash_after_crash", str7);
                        jSONObject4.put("from_file", String.valueOf(d.b()));
                        jSONObject4.put("has_dump", "true");
                        jSONObject4.put("from_kill", "false");
                        jSONObject4.put("last_resume_activity", com.apm.insight.runtime.a.b.d().h());
                        i11 = this.f16619o;
                        if (i11 > 0) {
                            jSONObject4.put("may_have_stack_overflow", String.valueOf(i11));
                        }
                        a(strA, jSONObject4);
                        com.apm.insight.a.a.a();
                        CrashType crashType4 = CrashType.LAUNCH;
                        com.apm.insight.e.e();
                        if (com.apm.insight.a.e().length() > 1024) {
                            aVarA.a("has_system_traces", "true");
                        }
                        jSONArrayA2 = com.apm.insight.nativecrash.b.a(com.apm.insight.l.j.e(com.apm.insight.e.f()), com.apm.insight.l.j.f(com.apm.insight.e.f()));
                        jSONObject4.put("leak_threads_count", String.valueOf(jSONArrayA2.length()));
                        if (jSONArrayA2.length() > 0) {
                            com.apm.insight.l.f.a(com.apm.insight.l.j.g(com.apm.insight.e.f()), jSONArrayA2);
                        }
                        String strOptString2 = jSONObject11.optString("mainStackFromTrace");
                        JSONArray jSONArrayA4 = com.apm.insight.entity.b.a(strOptString2);
                        com.apm.insight.entity.b.a(aVarA.c(), jSONArrayA4, new com.apm.insight.entity.b.a() { // from class: com.apm.insight.b.b.2
                            @Override // com.apm.insight.entity.b.a
                            public final void a(JSONObject jSONObject12) {
                                com.apm.insight.k.d.a().a(jSONObject12, j11, b.this.f16610f);
                            }
                        });
                        b(strOptString2, jSONArrayA4);
                    }
                    return z11;
                }
            } else {
                jSONObject5 = jSONObjectA2;
            }
            jSONObjectA2 = d.a();
        }
        jSONObject2 = jSONObjectA;
        if (jSONObjectA2 != null && jSONObjectA2.length() > 0) {
            jSONObjectA2.put("pid", Process.myPid());
            jSONObjectA2.put("package", this.f16606b.getPackageName());
            jSONObjectA2.put("is_remote_process", 0);
            jSONObjectA2.put("is_new_stack", 10);
            aVar = new com.apm.insight.entity.a(new JSONObject());
            String str14 = str2;
            aVar.a("data", (Object) jSONObjectA2.toString());
            JSONObject jSONObject12 = jSONObjectA2;
            aVar.a("is_anr", (Object) 1);
            aVar.a("anrType", (Object) str3);
            aVar.a("history_message", (Object) jSONArrayB);
            aVar.a("current_message", jSONObject2);
            aVar.a("pending_messages", (Object) jSONArrayA);
            aVar.a("anr_time", Long.valueOf(System.currentTimeMillis()));
            aVar.a("crash_time", Long.valueOf(j11));
            com.apm.insight.c.a.b();
            aVar.c(jSONObject);
            aVar.a("anr_info", (Object) strA);
            if (jSONArray != null) {
                aVar.a("dump_trace", (Object) jSONArray);
            }
            jSONObject3 = this.f16618n;
            if (jSONObject3 == null && jSONObject3.length() != 0) {
                jSONObjectB = this.f16618n;
            }
            aVar.a("all_thread_stacks", jSONObjectB);
            com.apm.insight.runtime.a.f fVarA3 = com.apm.insight.runtime.a.f.a();
            CrashType crashType5 = CrashType.ANR;
            aVarA = fVarA3.a(crashType5, aVar);
            aVarA.a("is_background", Boolean.valueOf(z12));
            aVarA.a("logcat", (Object) com.apm.insight.runtime.i.a(com.apm.insight.e.f()));
            aVarA.a("has_dump", (Object) "true");
            aVarA.a("crash_uuid", (Object) com.apm.insight.e.a(j11, crashType5, false, false));
            aVarA.a("jiffy", Long.valueOf(o.a.a()));
            jSONObjectOptJSONObject = aVarA.c().optJSONObject("filters");
            com.apm.insight.entity.d.b(aVarA.c());
            if (jSONObjectOptJSONObject == null) {
                jSONObject4 = new JSONObject();
                aVarA.a("filters", jSONObject4);
            } else {
                jSONObject4 = jSONObjectOptJSONObject;
            }
            jSONObject4.put("anrType", str3);
            jSONObject4.put("max_utm_thread", str4);
            jSONObject4.put("max_stm_thread", str);
            jSONObject4.put("max_utm_stm_thread", str14);
            jSONObject4.put("max_utm_thread_version", this.f16616l);
            j12 = j11 - com.apm.insight.e.j();
            if (j12 < 30000) {
                str5 = "0 - 30s";
            } else if (j12 < ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) {
                str5 = "30s - 1min";
            } else if (j12 < 120000) {
                str5 = "1min - 2min";
            } else if (j12 < 300000) {
                str5 = "2min - 5min";
            } else if (j12 < TTAdConstant.AD_MAX_EVENT_TIME) {
                str5 = "5min - 10min";
            } else if (j12 < 1800000) {
                str5 = "10min - 30min";
            } else if (j12 < 3600000) {
                str5 = "30min - 1h";
            } else {
                str5 = "1h - ";
            }
            jSONObject4.put("crash_length", str5);
            jSONObject4.put("disable_looper_monitor", String.valueOf(com.apm.insight.runtime.a.c()));
            jSONObject4.put("npth_force_apm_crash", String.valueOf(com.apm.insight.c.a.b()));
            jSONObject4.put("sdk_version", "1.3.8.nourl-rc.1");
            jSONObject4.put("has_logcat", String.valueOf(aVarA.a()));
            jSONObject4.put("memory_leak", String.valueOf(com.apm.insight.entity.a.a(com.apm.insight.e.f())));
            jSONObject4.put("fd_leak", String.valueOf(com.apm.insight.entity.a.b(com.apm.insight.e.f())));
            jSONObject4.put("threads_leak", String.valueOf(com.apm.insight.entity.a.c(com.apm.insight.e.f())));
            jSONObject4.put("is_64_devices", String.valueOf(Header.a()));
            jSONObject4.put("is_64_runtime", String.valueOf(NativeImpl.f()));
            jSONObject4.put("is_x86_devices", String.valueOf(Header.b()));
            jSONObject4.put("has_meminfo_file", String.valueOf(com.apm.insight.l.j.d(com.apm.insight.e.f()).exists()));
            if (com.apm.insight.nativecrash.a.k()) {
                str6 = "true";
            } else {
                str6 = "false";
            }
            jSONObject4.put("is_root", str6);
            jSONObject4.put("anr_normal_trace", String.valueOf(!this.f16626v));
            jSONObject4.put("anr_no_run", String.valueOf(zB));
            if (Npth.hasCrash()) {
                str7 = "true";
            } else {
                str7 = "false";
            }
            jSONObject4.put("crash_after_crash", str7);
            jSONObject4.put("from_file", String.valueOf(d.b()));
            jSONObject4.put("has_dump", "true");
            jSONObject4.put("from_kill", "false");
            jSONObject4.put("last_resume_activity", com.apm.insight.runtime.a.b.d().h());
            i11 = this.f16619o;
            if (i11 > 0) {
                jSONObject4.put("may_have_stack_overflow", String.valueOf(i11));
            }
            a(strA, jSONObject4);
            com.apm.insight.a.a.a();
            CrashType crashType6 = CrashType.LAUNCH;
            com.apm.insight.e.e();
            if (com.apm.insight.a.e().length() > 1024) {
                aVarA.a("has_system_traces", "true");
            }
            jSONArrayA2 = com.apm.insight.nativecrash.b.a(com.apm.insight.l.j.e(com.apm.insight.e.f()), com.apm.insight.l.j.f(com.apm.insight.e.f()));
            jSONObject4.put("leak_threads_count", String.valueOf(jSONArrayA2.length()));
            if (jSONArrayA2.length() > 0) {
                com.apm.insight.l.f.a(com.apm.insight.l.j.g(com.apm.insight.e.f()), jSONArrayA2);
            }
            String strOptString3 = jSONObject12.optString("mainStackFromTrace");
            JSONArray jSONArrayA5 = com.apm.insight.entity.b.a(strOptString3);
            com.apm.insight.entity.b.a(aVarA.c(), jSONArrayA5, new com.apm.insight.entity.b.a() { // from class: com.apm.insight.b.b.2
                @Override // com.apm.insight.entity.b.a
                public final void a(JSONObject jSONObject13) {
                    com.apm.insight.k.d.a().a(jSONObject13, j11, b.this.f16610f);
                }
            });
            b(strOptString3, jSONArrayA5);
        }
        return z11;
    }
}
