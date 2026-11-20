package com.mbridge.msdk.mbbid.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ag;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.e;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbbid.out.BidConstants;
import com.mbridge.msdk.out.MBConfiguration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, String> f45433a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static JSONArray f45434b;

    public static String a(Context context, String str) {
        HashMap map = new HashMap();
        map.put(BidConstants.BID_FILTER_KEY_UNIT_ID, str);
        return a(context, map);
    }

    private static String a(Context context, String str, String str2) {
        long jA;
        StringBuffer stringBuffer = new StringBuffer();
        if (context != null) {
            try {
                if (com.mbridge.msdk.foundation.controller.c.m().c() == null) {
                    com.mbridge.msdk.foundation.controller.c.m().b(context);
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.b("BidCommon", e11.getMessage());
                }
            }
        }
        g gVarB = h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
        if (gVarB == null) {
            h.a();
            gVarB = i.a();
        }
        stringBuffer.append(e.c());
        stringBuffer.append("|");
        stringBuffer.append("");
        stringBuffer.append("|");
        stringBuffer.append("");
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append(z.w());
        stringBuffer.append("|");
        stringBuffer.append(z.m());
        stringBuffer.append("|");
        stringBuffer.append(z.l(context));
        stringBuffer.append("|");
        stringBuffer.append(MBConfiguration.SDK_VERSION);
        stringBuffer.append("|");
        stringBuffer.append(z.i(context));
        stringBuffer.append("x");
        stringBuffer.append(z.g(context));
        stringBuffer.append("|");
        stringBuffer.append(z.g());
        stringBuffer.append("|");
        stringBuffer.append("");
        stringBuffer.append("|");
        stringBuffer.append(ai.b(20));
        stringBuffer.append("|");
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append("|");
        stringBuffer.append(com.mbridge.msdk.foundation.same.a.f44368d);
        stringBuffer.append("|");
        stringBuffer.append(z.o());
        stringBuffer.append("|");
        stringBuffer.append(z.f());
        stringBuffer.append("|");
        stringBuffer.append("");
        stringBuffer.append("|");
        stringBuffer.append("");
        stringBuffer.append("|");
        stringBuffer.append("");
        stringBuffer.append("|");
        stringBuffer.append(ag.b());
        stringBuffer.append("|");
        stringBuffer.append(ag.a());
        stringBuffer.append("|");
        try {
            jA = y.a();
        } catch (Exception unused) {
            jA = 0;
        }
        if (jA > 0) {
            stringBuffer.append(jA);
            stringBuffer.append("|");
        } else {
            stringBuffer.append("");
            stringBuffer.append("|");
        }
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append(com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B));
        stringBuffer.append("|");
        stringBuffer.append(com.mbridge.msdk.foundation.a.a.a.a().a("c"));
        stringBuffer.append("|");
        stringBuffer.append(z.i());
        String strA = gVarB != null ? gVarB.a() : "";
        stringBuffer.append("|");
        stringBuffer.append(strA);
        stringBuffer.append("|");
        stringBuffer.append(ai.a());
        stringBuffer.append("|");
        String strC = ai.c();
        if (TextUtils.isEmpty(strC)) {
            strC = "";
        }
        stringBuffer.append(strC);
        stringBuffer.append("|");
        stringBuffer.append(ai.c(str));
        stringBuffer.append("|");
        if (gVarB != null && gVarB.au() == 1 && com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            stringBuffer.append("");
        }
        stringBuffer.append("|");
        stringBuffer.append(z.y());
        stringBuffer.append("|");
        stringBuffer.append(z.u(context));
        stringBuffer.append("|");
        stringBuffer.append(z.t() + "");
        stringBuffer.append("|");
        stringBuffer.append(z.c(com.mbridge.msdk.foundation.controller.c.m().h()) + "");
        stringBuffer.append("|");
        stringBuffer.append(z.u());
        stringBuffer.append("|");
        stringBuffer.append(com.mbridge.msdk.foundation.controller.authoritycontroller.b.a() ? "1" : "2");
        stringBuffer.append("|");
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            stringBuffer.append("");
        }
        stringBuffer.append("|");
        stringBuffer.append("");
        stringBuffer.append("|");
        stringBuffer.append("");
        stringBuffer.append("|");
        stringBuffer.append("");
        stringBuffer.append("|");
        stringBuffer.append("1");
        stringBuffer.append("|");
        stringBuffer.append(com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().f());
        stringBuffer.append("|");
        if (z.q() != 0) {
            stringBuffer.append(z.q() + "");
        }
        if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
            stringBuffer.append("|");
            stringBuffer.append(1);
        } else {
            stringBuffer.append("|");
            stringBuffer.append("");
        }
        stringBuffer.append("|");
        stringBuffer.append("");
        stringBuffer.append("|");
        stringBuffer.append(str2);
        stringBuffer.append("|");
        stringBuffer.append(z.k(context));
        stringBuffer.append("|");
        stringBuffer.append(z.j(context));
        stringBuffer.append("|");
        stringBuffer.append(e.d());
        stringBuffer.append("|");
        stringBuffer.append(e.a());
        stringBuffer.append("|");
        stringBuffer.append(com.mbridge.msdk.f.c.f43981a);
        stringBuffer.append("|");
        stringBuffer.append("");
        return x.b(stringBuffer.toString());
    }

    public static String a(Context context, Map<String, String> map) {
        String md5;
        f45433a = map;
        try {
            if (com.mbridge.msdk.foundation.controller.c.m().c() == null) {
                com.mbridge.msdk.foundation.controller.c.m().b(context);
            }
            if (f45434b == null) {
                f45434b = h.a().a(com.mbridge.msdk.foundation.controller.c.m().k()).ak();
            }
            md5 = SameMD5.getMD5(ai.d());
            try {
                if (b(context, md5)) {
                    return "";
                }
                Map<String, String> map2 = f45433a;
                return a(context, (map2 == null || !map2.containsKey(BidConstants.BID_FILTER_KEY_UNIT_ID)) ? "" : f45433a.get(BidConstants.BID_FILTER_KEY_UNIT_ID), md5);
            } catch (Exception unused) {
                return a(context, "", md5);
            }
        } catch (Exception unused2) {
            md5 = "";
        }
    }

    private static void a(Context context, String str, long j11) {
        ak.a(context, str, Long.valueOf(j11));
    }

    private static void a(String str, int i11) {
        d dVar = new d();
        dVar.a("filter", Integer.valueOf(i11));
        dVar.a("lrid", str);
        com.mbridge.msdk.foundation.same.report.d.c.a().b("2000124", dVar);
    }

    private static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str.equals(str2)) {
            return true;
        }
        for (String str3 : str.split("-")) {
            if (!TextUtils.isEmpty(str3) && str3.length() > 2 && str3.startsWith("{") && str3.endsWith("}")) {
                String strSubstring = str3.substring(1, str3.length() - 1);
                Map<String, String> map = f45433a;
                if (map != null && map.containsKey(strSubstring)) {
                    String strValueOf = String.valueOf(f45433a.get(strSubstring));
                    if (!TextUtils.isEmpty(strValueOf)) {
                        str = str.replace(str3, strValueOf + "");
                    }
                } else if (BidConstants.BID_FILTER_KEY_NETWORK.equals(str3)) {
                    str = str.replace(str3, z.l(com.mbridge.msdk.foundation.controller.c.m().c()) + "");
                }
            }
        }
        return str.equals(str2);
    }

    /* JADX WARN: Code duplicated, block: B:69:0x0142  */
    /* JADX WARN: Code duplicated, block: B:73:0x0155 A[Catch: all -> 0x01c5, TryCatch #1 {all -> 0x01c5, blocks: (B:71:0x014b, B:73:0x0155, B:75:0x01a9, B:78:0x01c8, B:80:0x01e3, B:82:0x01eb, B:83:0x020e, B:85:0x0218, B:86:0x023b, B:88:0x0245, B:89:0x0268, B:91:0x0277, B:92:0x0283), top: B:104:0x014b }] */
    /* JADX WARN: Code duplicated, block: B:75:0x01a9 A[Catch: all -> 0x01c5, TryCatch #1 {all -> 0x01c5, blocks: (B:71:0x014b, B:73:0x0155, B:75:0x01a9, B:78:0x01c8, B:80:0x01e3, B:82:0x01eb, B:83:0x020e, B:85:0x0218, B:86:0x023b, B:88:0x0245, B:89:0x0268, B:91:0x0277, B:92:0x0283), top: B:104:0x014b }] */
    /* JADX WARN: Code duplicated, block: B:80:0x01e3 A[Catch: all -> 0x01c5, TryCatch #1 {all -> 0x01c5, blocks: (B:71:0x014b, B:73:0x0155, B:75:0x01a9, B:78:0x01c8, B:80:0x01e3, B:82:0x01eb, B:83:0x020e, B:85:0x0218, B:86:0x023b, B:88:0x0245, B:89:0x0268, B:91:0x0277, B:92:0x0283), top: B:104:0x014b }] */
    /* JADX WARN: Code duplicated, block: B:82:0x01eb A[Catch: all -> 0x01c5, TryCatch #1 {all -> 0x01c5, blocks: (B:71:0x014b, B:73:0x0155, B:75:0x01a9, B:78:0x01c8, B:80:0x01e3, B:82:0x01eb, B:83:0x020e, B:85:0x0218, B:86:0x023b, B:88:0x0245, B:89:0x0268, B:91:0x0277, B:92:0x0283), top: B:104:0x014b }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0218 A[Catch: all -> 0x01c5, TryCatch #1 {all -> 0x01c5, blocks: (B:71:0x014b, B:73:0x0155, B:75:0x01a9, B:78:0x01c8, B:80:0x01e3, B:82:0x01eb, B:83:0x020e, B:85:0x0218, B:86:0x023b, B:88:0x0245, B:89:0x0268, B:91:0x0277, B:92:0x0283), top: B:104:0x014b }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0245 A[Catch: all -> 0x01c5, TryCatch #1 {all -> 0x01c5, blocks: (B:71:0x014b, B:73:0x0155, B:75:0x01a9, B:78:0x01c8, B:80:0x01e3, B:82:0x01eb, B:83:0x020e, B:85:0x0218, B:86:0x023b, B:88:0x0245, B:89:0x0268, B:91:0x0277, B:92:0x0283), top: B:104:0x014b }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0277 A[Catch: all -> 0x01c5, TryCatch #1 {all -> 0x01c5, blocks: (B:71:0x014b, B:73:0x0155, B:75:0x01a9, B:78:0x01c8, B:80:0x01e3, B:82:0x01eb, B:83:0x020e, B:85:0x0218, B:86:0x023b, B:88:0x0245, B:89:0x0268, B:91:0x0277, B:92:0x0283), top: B:104:0x014b }] */
    /* JADX WARN: Code duplicated, block: B:92:0x0283 A[Catch: all -> 0x01c5, TRY_LEAVE, TryCatch #1 {all -> 0x01c5, blocks: (B:71:0x014b, B:73:0x0155, B:75:0x01a9, B:78:0x01c8, B:80:0x01e3, B:82:0x01eb, B:83:0x020e, B:85:0x0218, B:86:0x023b, B:88:0x0245, B:89:0x0268, B:91:0x0277, B:92:0x0283), top: B:104:0x014b }] */
    /* JADX WARN: Code duplicated, block: B:97:0x0297 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x0299 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Instruction removed from duplicated block: B:73:0x0155, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:75:0x01a9, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:82:0x01eb, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:85:0x0218, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:88:0x0245, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    private static boolean b(Context context, String str) {
        int i11;
        int i12;
        Context contextC;
        StringBuffer stringBuffer;
        Map<String, String> map;
        int i13;
        Object objValueOf;
        int i14;
        int i15;
        JSONArray jSONArray = f45434b;
        int i16 = 0;
        if (jSONArray == null || jSONArray.length() == 0) {
            a(str, 2);
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        int i17 = 0;
        while (true) {
            try {
                if (i17 >= f45434b.length()) {
                    i11 = 0;
                    i12 = 2;
                    i13 = 0;
                    break;
                }
                JSONObject jSONObjectOptJSONObject = f45434b.optJSONObject(i17);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("key_tpl");
                    String strOptString2 = jSONObjectOptJSONObject.optString("key_value");
                    Long l11 = 0L;
                    if (context == null) {
                        objValueOf = l11;
                    } else {
                        String simpleName = "";
                        if (l11 != 0) {
                            try {
                                simpleName = l11.getClass().getSimpleName();
                            } catch (Exception e11) {
                                e = e11;
                                if (MBridgeConstans.DEBUG) {
                                    ad.b("BidCommon", e.getMessage());
                                }
                                i11 = 0;
                                i12 = 2;
                                contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                                if (contextC != null) {
                                    stringBuffer = new StringBuffer();
                                    stringBuffer.append("filter=" + i12 + "&");
                                    stringBuffer.append("network_type=" + z.l(contextC) + "&");
                                    stringBuffer.append("timeout=" + i16 + "&");
                                    if (jSONObject.length() > 0) {
                                        stringBuffer.append("hitNode=" + jSONObject.toString() + "&");
                                    }
                                    stringBuffer.append("hitRate=" + i11 + "&");
                                    map = f45433a;
                                    if (map != null) {
                                        if (map.containsKey(BidConstants.BID_FILTER_KEY_UNIT_ID)) {
                                            stringBuffer.append("unit_id=" + String.valueOf(f45433a.get(BidConstants.BID_FILTER_KEY_UNIT_ID)) + "&");
                                        }
                                        if (f45433a.containsKey(BidConstants.BID_FILTER_KEY_PLACEMENT_ID)) {
                                            stringBuffer.append("placementId=" + String.valueOf(f45433a.get(BidConstants.BID_FILTER_KEY_PLACEMENT_ID)) + "&");
                                        }
                                        if (f45433a.containsKey(BidConstants.BID_FILTER_KEY_AD_TYPE)) {
                                            stringBuffer.append("adType=" + String.valueOf(f45433a.get(BidConstants.BID_FILTER_KEY_AD_TYPE)) + "&");
                                        }
                                    }
                                    stringBuffer.append("key=2000122");
                                    if (j.a().b()) {
                                        j.a().a(stringBuffer.toString());
                                    } else {
                                        q.b(contextC, stringBuffer.toString());
                                    }
                                }
                                a(str, i12);
                                if (i12 == 1) {
                                    return true;
                                }
                                return false;
                            }
                        }
                        SharedPreferences sharedPreferences = context.getSharedPreferences("share_date_setting_filter", i16);
                        if ("String".equals(simpleName)) {
                            objValueOf = sharedPreferences.getString(strOptString2, (String) l11);
                        } else if ("Integer".equals(simpleName)) {
                            objValueOf = Integer.valueOf(sharedPreferences.getInt(strOptString2, ((Integer) l11).intValue()));
                        } else if ("Boolean".equals(simpleName)) {
                            objValueOf = Boolean.valueOf(sharedPreferences.getBoolean(strOptString2, ((Boolean) l11).booleanValue()));
                        } else if ("Float".equals(simpleName)) {
                            objValueOf = Float.valueOf(sharedPreferences.getFloat(strOptString2, ((Float) l11).floatValue()));
                        } else if ("Long".equals(simpleName)) {
                            objValueOf = l11;
                            objValueOf = Long.valueOf(sharedPreferences.getLong(strOptString2, l11.longValue()));
                        }
                    }
                    objValueOf = l11;
                    long jLongValue = ((Long) objValueOf).longValue();
                    if (a(strOptString, strOptString2)) {
                        try {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            try {
                                if (jLongValue <= 0) {
                                    a(context, strOptString2, jCurrentTimeMillis);
                                    jSONObject = jSONObjectOptJSONObject;
                                    i11 = 0;
                                    i12 = 2;
                                    i13 = 1;
                                    break;
                                }
                                if (jCurrentTimeMillis - jLongValue < ((long) jSONObjectOptJSONObject.optInt("ttl")) * 1000) {
                                    try {
                                        double dOptDouble = jSONObjectOptJSONObject.optDouble("rate");
                                        int iNextInt = new Random().nextInt(100);
                                        if (dOptDouble == 0.0d || dOptDouble * 100.0d < iNextInt) {
                                            i14 = 2;
                                            i15 = 2;
                                        } else {
                                            i14 = 1;
                                            i15 = 1;
                                        }
                                        i12 = i14;
                                        i13 = 2;
                                    } catch (Exception e12) {
                                        e = e12;
                                        jSONObject = jSONObjectOptJSONObject;
                                        i16 = 2;
                                        if (MBridgeConstans.DEBUG) {
                                            ad.b("BidCommon", e.getMessage());
                                        }
                                        i11 = 0;
                                        i12 = 2;
                                    }
                                } else {
                                    a(context, strOptString2, jCurrentTimeMillis);
                                    i15 = 0;
                                    i12 = 2;
                                    i13 = 1;
                                }
                                i11 = i15;
                                jSONObject = jSONObjectOptJSONObject;
                                break;
                            } catch (Exception e13) {
                                e = e13;
                                jSONObject = jSONObjectOptJSONObject;
                                i16 = 1;
                            }
                        } catch (Exception e14) {
                            e = e14;
                            jSONObject = jSONObjectOptJSONObject;
                            i16 = 0;
                            if (MBridgeConstans.DEBUG) {
                                ad.b("BidCommon", e.getMessage());
                            }
                            i11 = 0;
                            i12 = 2;
                            contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                            if (contextC != null) {
                                stringBuffer = new StringBuffer();
                                stringBuffer.append("filter=" + i12 + "&");
                                stringBuffer.append("network_type=" + z.l(contextC) + "&");
                                stringBuffer.append("timeout=" + i16 + "&");
                                if (jSONObject.length() > 0) {
                                    stringBuffer.append("hitNode=" + jSONObject.toString() + "&");
                                }
                                stringBuffer.append("hitRate=" + i11 + "&");
                                map = f45433a;
                                if (map != null) {
                                    if (map.containsKey(BidConstants.BID_FILTER_KEY_UNIT_ID)) {
                                        stringBuffer.append("unit_id=" + String.valueOf(f45433a.get(BidConstants.BID_FILTER_KEY_UNIT_ID)) + "&");
                                    }
                                    if (f45433a.containsKey(BidConstants.BID_FILTER_KEY_PLACEMENT_ID)) {
                                        stringBuffer.append("placementId=" + String.valueOf(f45433a.get(BidConstants.BID_FILTER_KEY_PLACEMENT_ID)) + "&");
                                    }
                                    if (f45433a.containsKey(BidConstants.BID_FILTER_KEY_AD_TYPE)) {
                                        stringBuffer.append("adType=" + String.valueOf(f45433a.get(BidConstants.BID_FILTER_KEY_AD_TYPE)) + "&");
                                    }
                                }
                                stringBuffer.append("key=2000122");
                                if (j.a().b()) {
                                    j.a().a(stringBuffer.toString());
                                } else {
                                    q.b(contextC, stringBuffer.toString());
                                }
                            }
                            a(str, i12);
                            if (i12 == 1) {
                                return true;
                            }
                            return false;
                        }
                    }
                }
                i17++;
                i16 = 0;
            } catch (Exception e15) {
                e = e15;
            }
        }
        i16 = i13;
        try {
            contextC = com.mbridge.msdk.foundation.controller.c.m().c();
            if (contextC != null) {
                stringBuffer = new StringBuffer();
                stringBuffer.append("filter=" + i12 + "&");
                stringBuffer.append("network_type=" + z.l(contextC) + "&");
                stringBuffer.append("timeout=" + i16 + "&");
                if (jSONObject.length() > 0) {
                    stringBuffer.append("hitNode=" + jSONObject.toString() + "&");
                }
                stringBuffer.append("hitRate=" + i11 + "&");
                map = f45433a;
                if (map != null) {
                    if (map.containsKey(BidConstants.BID_FILTER_KEY_UNIT_ID)) {
                        stringBuffer.append("unit_id=" + String.valueOf(f45433a.get(BidConstants.BID_FILTER_KEY_UNIT_ID)) + "&");
                    }
                    if (f45433a.containsKey(BidConstants.BID_FILTER_KEY_PLACEMENT_ID)) {
                        stringBuffer.append("placementId=" + String.valueOf(f45433a.get(BidConstants.BID_FILTER_KEY_PLACEMENT_ID)) + "&");
                    }
                    if (f45433a.containsKey(BidConstants.BID_FILTER_KEY_AD_TYPE)) {
                        stringBuffer.append("adType=" + String.valueOf(f45433a.get(BidConstants.BID_FILTER_KEY_AD_TYPE)) + "&");
                    }
                }
                stringBuffer.append("key=2000122");
                if (j.a().b()) {
                    j.a().a(stringBuffer.toString());
                } else {
                    q.b(contextC, stringBuffer.toString());
                }
            }
        } catch (Throwable th2) {
            ad.b("BidCommon", th2.getMessage());
        }
        a(str, i12);
        if (i12 == 1) {
            return true;
        }
        return false;
    }
}
