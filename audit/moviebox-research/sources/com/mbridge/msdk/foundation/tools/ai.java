package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.MBDownloadConfig;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper;
import com.mbridge.msdk.foundation.download.resource.ResourceConfig;
import com.mbridge.msdk.foundation.download.utils.ILogger;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class ai extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f44991a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f44992b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f44993c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f44994d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f44995e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f44996f = 7;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f44997g = 14;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f44998h = 19;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int f44999i = 16;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f45000j = 26;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static char[] f45001k = {'.', 'X'};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static char[] f45002l = {'A', 'p', 'p', 'l', 'i', 'c', 'a', 't', 'i', 'o', 'n', 'I', 'n', 'f', 'o'};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static int f45003m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static boolean f45004n = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static volatile Boolean f45005o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static String f45006p = "[一-龥]";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static Pattern f45007q = Pattern.compile("[一-龥]");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static Map<String, String> f45008r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static Map<String, String> f45009s;

    public static double a(Double d11) {
        try {
            String str = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.US)).format(d11);
            if (an.b(str)) {
                return Double.parseDouble(str);
            }
            return 0.0d;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0.0d;
        }
    }

    public static final int a() {
        if (f45005o == null) {
            try {
                f45005o = MIMManager.a.f44952a.d();
            } catch (Exception e11) {
                ad.b("SameTools", e11.getMessage());
            }
        }
        if (f45005o != null) {
            return f45005o.booleanValue() ? 1 : 0;
        }
        return -1;
    }

    public static int a(int i11) {
        if ((i11 > 100 && i11 < 199) || i11 == 2) {
            return 1;
        }
        if ((i11 <= 200 || i11 >= 299) && i11 != 4) {
            return (i11 <= 500 || i11 >= 599) ? -1 : 5;
        }
        return 2;
    }

    public static int a(Context context, float f11) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return (int) ((f11 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        try {
            if (obj instanceof String) {
                return Integer.parseInt((String) obj);
            }
            return 0;
        } catch (Throwable th2) {
            ad.a("SameTools", th2.getMessage(), th2);
            return 0;
        }
    }

    public static int a(String str, String str2, int i11) {
        if (TextUtils.isEmpty(str)) {
            return i11;
        }
        try {
            Uri uri = Uri.parse(str);
            if (uri != null) {
                String queryParameter = uri.getQueryParameter(str2);
                return TextUtils.isEmpty(queryParameter) ? i11 : (int) Math.round(Double.valueOf(String.valueOf(queryParameter)).doubleValue());
            }
        } catch (Exception e11) {
            ad.b("SameTools", e11.getMessage());
        }
        return i11;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0024 A[EXC_TOP_SPLITTER, PHI: r0 r2
  0x0024: PHI (r0v1 long) = (r0v0 long), (r0v3 long) binds: [B:21:0x002e, B:15:0x0022] A[DONT_GENERATE, DONT_INLINE]
  0x0024: PHI (r2v3 java.io.FileInputStream) = (r2v2 java.io.FileInputStream), (r2v4 java.io.FileInputStream) binds: [B:21:0x002e, B:15:0x0022] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public static long a(File file) throws Exception {
        long jAvailable = 0;
        FileInputStream fileInputStream = null;
        try {
            if (file.exists()) {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    jAvailable = fileInputStream2.available();
                    fileInputStream = fileInputStream2;
                } catch (Exception unused) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } else {
                file.createNewFile();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (Exception unused4) {
        } catch (Throwable th3) {
            th = th3;
        }
        return jAvailable;
    }

    public static ImageView a(ImageView imageView, BitmapDrawable bitmapDrawable, DisplayMetrics displayMetrics) {
        try {
            bitmapDrawable.setTargetDensity(displayMetrics);
            imageView.setBackground(bitmapDrawable);
            imageView.setClickable(false);
            imageView.setFocusable(false);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return imageView;
    }

    public static String a(Context context, String str) {
        String strA = "";
        try {
            JSONArray jSONArrayB = b(context, str);
            strA = jSONArrayB.length() > 0 ? a(jSONArrayB) : "";
            ad.c("SameTools", "get excludes:" + strA);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return strA;
    }

    public static synchronized String a(Context context, String str, String str2) {
        StringBuilder sb2;
        sb2 = new StringBuilder(str2);
        try {
            sb2.append(a(str2, context, str));
        } catch (Exception unused) {
        }
        return sb2.toString();
    }

    public static String a(CampaignEx campaignEx) {
        com.mbridge.msdk.c.g gVarB;
        CampaignEx.a adchoice;
        String privacyUrl = "";
        if (campaignEx != null) {
            try {
                privacyUrl = campaignEx.getPrivacyUrl();
            } catch (Exception e11) {
                ad.b("SameTools", e11.getMessage());
                return "";
            }
        }
        if (TextUtils.isEmpty(privacyUrl) && campaignEx != null && (adchoice = campaignEx.getAdchoice()) != null) {
            privacyUrl = adchoice.c();
        }
        if (TextUtils.isEmpty(privacyUrl) && (gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k())) != null) {
            privacyUrl = gVarB.g();
        }
        return TextUtils.isEmpty(privacyUrl) ? com.mbridge.msdk.foundation.same.net.g.d.f().f44629f : privacyUrl;
    }

    public static String a(String str) {
        try {
            return an.b(str) ? URLEncoder.encode(str, "utf-8") : "";
        } catch (Throwable th2) {
            ad.a("SameTools", th2.getMessage(), th2);
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object] */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:13:0x0025
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private static synchronized java.lang.String a(java.lang.String r2, android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.Class<com.mbridge.msdk.foundation.tools.ai> r0 = com.mbridge.msdk.foundation.tools.ai.class
            monitor-enter(r0)
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L25
            java.util.Set r2 = r2.getQueryParameterNames()     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L25
            if (r2 == 0) goto L1d
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L25
            if (r2 <= 0) goto L1d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L25
            java.lang.String r1 = "&rtins_type="
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L25
            goto L2c
        L1b:
            r2 = move-exception
            goto L46
        L1d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L25
            java.lang.String r1 = "?rtins_type="
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L25
            goto L2c
        L25:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1b
            java.lang.String r1 = "&rtins_type="
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L1b
        L2c:
            java.lang.Object r3 = b(r4, r3)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L3c
            if (r3 == 0) goto L37
            r3 = 1
            r2.append(r3)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L3c
            goto L40
        L37:
            r3 = 2
            r2.append(r3)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L3c
            goto L40
        L3c:
            r3 = 0
            r2.append(r3)     // Catch: java.lang.Throwable -> L1b
        L40:
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L1b
            monitor-exit(r0)
            return r2
        L46:
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ai.a(java.lang.String, android.content.Context, java.lang.String):java.lang.String");
    }

    public static String a(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                HashMap map = new HashMap();
                map.put(str2, str3);
                return a(str, map);
            }
            return str;
        } catch (Exception e11) {
            ad.b("SameTools", e11.getMessage());
            return str;
        }
    }

    private static String a(String str, Map<String, String> map) {
        try {
            if (!TextUtils.isEmpty(str) && map != null) {
                StringBuilder sb2 = new StringBuilder(str);
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry != null && !TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                        String value = entry.getValue();
                        if (str.contains(entry.getKey())) {
                            sb2 = value.equals("0") ? new StringBuilder(str.replaceAll("(" + entry.getKey() + "[^&]*)", "")) : new StringBuilder(str.replaceAll("(" + entry.getKey() + "[^&]*)", entry.getKey() + entry.getValue()));
                        } else if (!value.equals("0")) {
                            sb2.append(entry.getKey() + entry.getValue());
                        }
                    }
                }
                return sb2.toString();
            }
            return str;
        } catch (Exception e11) {
            ad.b("SameTools", e11.getMessage());
            return str;
        }
    }

    public static String a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return "";
        }
        com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
        if (gVarB == null) {
            com.mbridge.msdk.c.h.a();
            gVarB = com.mbridge.msdk.c.i.a();
        }
        int iY = gVarB.Y();
        if (jSONArray.length() <= iY) {
            return jSONArray.toString();
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i11 = 0; i11 < iY; i11++) {
            try {
                jSONArray2.put(jSONArray.get(i11));
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }
        return jSONArray2.toString();
    }

    private static List<String> a(StackTraceElement[] stackTraceElementArr) {
        ArrayList arrayList = new ArrayList();
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                arrayList.add(stackTraceElement.getClassName());
            }
        }
        return arrayList;
    }

    public static final void a(final int i11, final ImageView imageView, final CampaignEx campaignEx, Context context, boolean z11, final com.mbridge.msdk.foundation.d.a aVar) {
        if (imageView == null || campaignEx == null) {
            return;
        }
        ad.a("configPrivacyButton", "configPrivacyButton");
        boolean z12 = campaignEx.getPrivacyButtonTemplateVisibility() == 0;
        ad.a("configPrivacyButton", "privacyButtonVisibilityGone: " + z12 + " isIgnoreCampaignPrivacyConfig: " + z11);
        if (!z11 && z12) {
            try {
                imageView.setVisibility(8);
                return;
            } catch (Exception e11) {
                ad.b("SameTools", e11.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(a(campaignEx))) {
            try {
                imageView.setVisibility(8);
                return;
            } catch (Exception e12) {
                ad.b("SameTools", e12.getMessage());
                return;
            }
        }
        try {
            imageView.setVisibility(0);
        } catch (Exception e13) {
            ad.b("SameTools", e13.getMessage());
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.foundation.tools.ai.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    ai.a(campaignEx, aVar, i11, (String) imageView.getTag());
                } catch (Exception e14) {
                    ad.b("SameTools", e14.getMessage());
                }
            }
        });
    }

    public static void a(View view) {
        if (view == null) {
            return;
        }
        try {
            view.setSystemUiVisibility(4102);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        try {
            imageView.setImageResource(0);
            imageView.setImageDrawable(null);
            imageView.setImageURI(null);
            imageView.setImageBitmap(null);
        } catch (Throwable th2) {
            if (MBridgeConstans.DEBUG) {
                th2.printStackTrace();
            }
        }
    }

    public static void a(CampaignEx campaignEx, com.mbridge.msdk.foundation.d.a aVar, int i11, String str) {
        if (campaignEx == null) {
            return;
        }
        try {
            String str2 = campaignEx.getCampaignUnitId() + "_" + i11;
            com.mbridge.msdk.foundation.d.b.a().c(str2);
            com.mbridge.msdk.foundation.d.b.a().a(str2, campaignEx);
            com.mbridge.msdk.foundation.d.b.a().a(str2, aVar);
            com.mbridge.msdk.foundation.d.b.a().a(str2, i11);
            com.mbridge.msdk.foundation.d.b.a().a(str2, str);
            com.mbridge.msdk.foundation.d.b.a().a(str2).e();
        } catch (Throwable th2) {
            ad.a("SameTools", "feedback error", th2);
        }
    }

    public static void a(String str, CampaignEx campaignEx, int i11) {
        if (TextUtils.isEmpty(str) || campaignEx == null || com.mbridge.msdk.foundation.controller.c.m().c() == null) {
            return;
        }
        com.mbridge.msdk.foundation.db.j jVarA = com.mbridge.msdk.foundation.db.j.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
        com.mbridge.msdk.foundation.entity.f fVar = new com.mbridge.msdk.foundation.entity.f();
        fVar.a(System.currentTimeMillis());
        fVar.b(str);
        fVar.a(campaignEx.getId());
        fVar.a(i11);
        jVarA.a(fVar);
    }

    public static boolean a(String str, Context context) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            try {
                try {
                    Uri uri = Uri.parse(str2);
                    return (uri == null || TextUtils.isEmpty(uri.getQueryParameter(str))) ? false : true;
                } catch (Exception e11) {
                    ad.b("SameTools", e11.getMessage());
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.length() == 0 || jSONObject.optInt("v", -1) != -1) ? false : true;
    }

    public static int b() {
        int i11 = f45003m;
        f45003m = i11 + 1;
        return i11;
    }

    public static int b(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            PackageInfo currentWebViewPackage = Build.VERSION.SDK_INT >= 26 ? WebView.getCurrentWebViewPackage() : context.getPackageManager().getPackageInfo("com.google.android.webview", 1);
            com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (gVarB == null) {
                com.mbridge.msdk.c.h.a();
                gVarB = com.mbridge.msdk.c.i.a();
            }
            if (currentWebViewPackage == null || TextUtils.isEmpty(currentWebViewPackage.versionName) || !currentWebViewPackage.versionName.equals("77.0.3865.92")) {
                return gVarB.aB();
            }
            return 5;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int b(Context context, float f11) {
        float f12 = 2.5f;
        if (context != null) {
            try {
                float f13 = context.getResources().getDisplayMetrics().density;
                if (f13 != 0.0f) {
                    f12 = f13;
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return (int) ((f11 / f12) + 0.5f);
    }

    public static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            Uri uri = Uri.parse(str);
            if (uri == null) {
                return -1;
            }
            String queryParameter = uri.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW);
            if (TextUtils.isEmpty(queryParameter)) {
                queryParameter = uri.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            }
            if (TextUtils.isEmpty(queryParameter)) {
                return -1;
            }
            try {
                return Integer.parseInt(queryParameter);
            } catch (Exception unused) {
                return -1;
            }
        } catch (Exception e11) {
            ad.b("SameTools", e11.getMessage());
            return -1;
        }
    }

    private static Object b(String str, Context context) {
        try {
            return Class.forName(String.valueOf(c(f44991a))).getMethod(String.valueOf(c(f44993c)), String.class, Integer.TYPE).invoke(Class.forName(String.valueOf(c(f44992b))).getMethod(String.valueOf(c(f44994d)), new Class[0]).invoke(context, new Object[0]), str, 8192);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(int i11) {
        long[] jArrB;
        try {
            com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (gVarB == null) {
                com.mbridge.msdk.c.h.a();
                gVarB = com.mbridge.msdk.c.i.a();
            }
            JSONArray jSONArray = new JSONArray();
            if (gVarB != null && gVarB.q() == 1 && (jArrB = com.mbridge.msdk.foundation.db.k.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.c.m().c())).b()) != null) {
                int length = jArrB.length;
                for (int i12 = (length <= i11 || i11 == 0) ? 0 : length - i11; i12 < length; i12++) {
                    jSONArray.put(jArrB[i12]);
                }
            }
            return jSONArray.length() > 0 ? a(jSONArray) : "";
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static String b(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = jSONObject.getJSONObject("device");
                if (jSONObject2 == null) {
                    return str;
                }
                if (jSONObject2.has(str2)) {
                    if (str3.equals("0")) {
                        jSONObject2.remove(str2);
                    } else {
                        jSONObject2.put(str2, str3);
                    }
                } else {
                    if (str3.equals("0")) {
                        return str;
                    }
                    jSONObject2.put(str2, str3);
                }
                return jSONObject.toString();
            } catch (Exception e11) {
                ad.b("SameTools", e11.getMessage());
            }
        }
        return str;
    }

    public static List<String> b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                String strOptString = jSONArray.optString(i11);
                if (an.b(strOptString)) {
                    arrayList.add(strOptString);
                }
            }
            return arrayList;
        } catch (Throwable th2) {
            ad.a("SameTools", th2.getMessage(), th2);
            return null;
        }
    }

    public static JSONArray b(Context context, String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (gVarB == null) {
                com.mbridge.msdk.c.h.a();
                gVarB = com.mbridge.msdk.c.i.a();
            }
            if (gVarB != null && gVarB.q() == 1) {
                ad.c("SameTools", "fqci cfc:" + gVarB.q());
                long[] jArrB = com.mbridge.msdk.foundation.db.k.a(com.mbridge.msdk.foundation.db.h.a(context)).b();
                if (jArrB != null) {
                    for (long j11 : jArrB) {
                        ad.c("SameTools", "cfc campaignIds:" + jArrB);
                        jSONArray.put(j11);
                    }
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return jSONArray;
    }

    public static synchronized void b(String str, String str2) {
        try {
            if (f45009s == null) {
                f45009s = new HashMap();
            }
            f45009s.put(com.mbridge.msdk.foundation.controller.c.m().k() + "_" + str, str2);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static boolean b(CampaignEx campaignEx) {
        if (campaignEx != null) {
            return !TextUtils.isEmpty(campaignEx.getDeepLinkURL());
        }
        return false;
    }

    public static int c(Context context) {
        if (context != null) {
            return 0;
        }
        try {
            if (context.getResources().getIdentifier("config_showNavigationBar", "bool", "android") != 0) {
                return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", "android"));
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return 0;
    }

    public static int c(String str, String str2) {
        return a(str, str2, 0);
    }

    public static final String c() {
        return MIMManager.a.f44952a.c();
    }

    public static String c(String str) {
        ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c> concurrentHashMapA;
        List<String> listC;
        if (TextUtils.isEmpty(str) || (concurrentHashMapA = com.mbridge.msdk.foundation.same.a.d.a(str)) == null || concurrentHashMapA.size() <= 0) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (com.mbridge.msdk.foundation.entity.c cVar : concurrentHashMapA.values()) {
            if (cVar != null) {
                long jE = cVar.e();
                long jF = cVar.f();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jE <= 0) {
                    com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
                    if (gVarB == null) {
                        com.mbridge.msdk.c.h.a();
                        gVarB = com.mbridge.msdk.c.i.a();
                    }
                    if (jF + (gVarB.ac() * 1000) >= jCurrentTimeMillis) {
                        listC = cVar.c();
                        if (listC == null) {
                        }
                    }
                } else if (jF + (jE * 1000) >= jCurrentTimeMillis) {
                    listC = cVar.c();
                    if (listC == null && listC.size() > 0) {
                        arrayList.addAll(listC);
                    }
                }
            }
        }
        if (arrayList.size() <= 0) {
            return "";
        }
        HashSet hashSet = new HashSet(arrayList);
        arrayList.clear();
        arrayList.addAll(hashSet);
        return arrayList.toString();
    }

    public static synchronized boolean c(Context context, String str) {
        boolean z11;
        z11 = false;
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    if (b(str, context) != null) {
                        z11 = true;
                    }
                } catch (Exception unused) {
                }
            }
        }
        return z11;
    }

    public static boolean c(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                return campaignEx.getRetarget_offer() == 1;
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return false;
    }

    private static final char[] c(int i11) {
        StringBuilder sb2;
        if (i11 == 0) {
            sb2 = new StringBuilder();
            sb2.append(String.valueOf(Arrays.copyOf(ah.f44988a, f44996f)));
            sb2.append(f45001k[f44995e]);
            sb2.append(String.valueOf(Arrays.copyOfRange(ah.f44988a, f44996f, f44997g)));
            sb2.append(f45001k[f44995e]);
            sb2.append(String.valueOf(Arrays.copyOfRange(ah.f44988a, f44997g, f44999i)));
            sb2.append(f45001k[f44995e]);
            sb2.append(String.valueOf(ag.f44980a));
        } else if (i11 == 1) {
            sb2 = new StringBuilder();
            sb2.append(String.valueOf(Arrays.copyOf(ah.f44988a, f44996f)));
            sb2.append(f45001k[f44995e]);
            sb2.append(String.valueOf(Arrays.copyOfRange(ah.f44988a, f44996f, f44997g)));
            sb2.append(f45001k[f44995e]);
            sb2.append(String.valueOf(Arrays.copyOfRange(ah.f44988a, f44998h, f45000j)));
        } else if (i11 == 2) {
            sb2 = new StringBuilder();
            sb2.append(String.valueOf(Arrays.copyOfRange(ah.f44988a, f44999i, f44998h)));
            sb2.append(String.valueOf(f45002l));
        } else if (i11 != 3) {
            sb2 = null;
        } else {
            sb2 = new StringBuilder();
            sb2.append(String.valueOf(Arrays.copyOfRange(ah.f44988a, f44999i, f44998h)));
            sb2.append(String.valueOf(ag.f44980a));
        }
        return sb2.toString().toCharArray();
    }

    public static float d(Context context) {
        if (context == null) {
            return 2.5f;
        }
        try {
            float f11 = context.getResources().getDisplayMetrics().density;
            if (f11 == 0.0f) {
                return 2.5f;
            }
            return f11;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 2.5f;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0019 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:15:0x001b  */
    /* JADX WARN: Code duplicated, block: B:16:0x001d A[Catch: all -> 0x0015, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:7:0x000b, B:16:0x001d), top: B:24:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0023  */
    /* JADX WARN: Code duplicated, block: B:19:0x0025  */
    public static synchronized int d(Context context, String str) {
        int i11;
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    i11 = b(str, context) != null ? 1 : 0;
                } catch (Exception unused) {
                    i11 = 3;
                }
            } else if (context == null) {
                i11 = 5;
            } else if (TextUtils.isEmpty(str)) {
                i11 = 2;
            } else {
                i11 = 4;
            }
        } else if (context == null) {
            i11 = 5;
        } else if (TextUtils.isEmpty(str)) {
            i11 = 2;
        } else {
            i11 = 4;
        }
        throw th;
        return i11;
    }

    public static String d() {
        String str;
        try {
            str = UUID.randomUUID().toString() + System.currentTimeMillis();
        } catch (Throwable th2) {
            th2.printStackTrace();
            str = "";
        }
        if (!an.a(str)) {
            return str;
        }
        return System.currentTimeMillis() + "";
    }

    public static synchronized String d(String str) {
        String str2 = com.mbridge.msdk.foundation.controller.c.m().k() + "_" + str;
        Map<String, String> map = f45009s;
        if (map == null || !map.containsKey(str2)) {
            return null;
        }
        return f45009s.get(str2);
    }

    public static int e() {
        try {
            return ((Integer) Class.forName("com.tencent.mm.opensdk.constants.Build").getField("SDK_INT").get(null)).intValue();
        } catch (Throwable th2) {
            ad.b("SameTools", th2.getMessage());
            return 0;
        }
    }

    public static int e(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return n(context).heightPixels;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static final synchronized String e(String str) {
        boolean zAC;
        int iMax;
        boolean zAH;
        JSONObject jSONObject;
        Map<String, String> map;
        try {
            try {
                String str2 = com.mbridge.msdk.foundation.controller.c.m().k() + "_" + str;
                com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
                if (gVarB != null) {
                    zAC = gVarB.aC();
                    zAH = gVarB.aH();
                    iMax = Math.max(0, gVarB.ad());
                } else {
                    zAC = true;
                    iMax = 3;
                    zAH = false;
                }
                if (zAH && iMax != 0) {
                    if (zAC && (map = f45008r) != null && map.containsKey(str2)) {
                        return f45008r.get(str2);
                    }
                    StringBuilder sb2 = new StringBuilder("");
                    StackTraceElement[] stackTrace = new Exception().getStackTrace();
                    if (stackTrace != null && stackTrace.length > 0) {
                        List<String> listA = a(stackTrace);
                        Collections.reverse(listA);
                        ArrayList arrayList = new ArrayList();
                        for (String str3 : listA) {
                            if (!str3.startsWith(MBridgeConstans.APPLICATION_STACK_COM_ANDROID) && !str3.startsWith(MBridgeConstans.APPLICATION_STACK_ANDROID_OS) && !str3.startsWith(MBridgeConstans.APPLICATION_STACK_ANDROID_APP) && !str3.startsWith(MBridgeConstans.APPLICATION_STACK_REFLECT_METHOD) && !str3.startsWith(MBridgeConstans.APPLICATION_STACK_ANDROID_VIEW) && !arrayList.contains(str3)) {
                                arrayList.add(str3);
                            }
                        }
                        int iMin = Math.min(arrayList.size(), iMax);
                        if (iMin > 0) {
                            for (int i11 = 0; i11 < iMin; i11++) {
                                sb2.append((String) arrayList.get(i11));
                                if (i11 < iMin - 1) {
                                    sb2.append("|");
                                }
                            }
                        }
                        if (TextUtils.isEmpty(sb2.toString())) {
                            jSONObject = null;
                        } else {
                            jSONObject = new JSONObject();
                            jSONObject.put("1", sb2.toString());
                        }
                        if (jSONObject == null || jSONObject.length() <= 0) {
                            return "";
                        }
                        String strA = a.a(jSONObject.toString());
                        if (zAC && !TextUtils.isEmpty(strA)) {
                            if (f45008r == null) {
                                f45008r = new HashMap();
                            }
                            f45008r.put(str2, strA);
                        }
                        return strA;
                    }
                    return "";
                }
                return "";
            } catch (Exception e11) {
                ad.b("SameTools", e11.getMessage());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static int f(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return n(context).widthPixels;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static int f(String str) {
        try {
            return ((Integer) Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI").getMethod("getWXAppSupportAPI", new Class[0]).invoke(z.b(str), new Object[0])).intValue();
        } catch (Throwable th2) {
            ad.b("SameTools", th2.getMessage());
            return 0;
        }
    }

    public static boolean f() {
        if (TextUtils.isEmpty(com.mbridge.msdk.foundation.controller.c.m().h())) {
            return false;
        }
        try {
            Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory");
            Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram");
            return true;
        } catch (ClassNotFoundException e11) {
            ad.b("SameTools", e11.getMessage());
            return false;
        }
    }

    public static int g(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().heightPixels;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static Object g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory").getMethod("createWXAPI", Context.class, String.class).invoke(null, com.mbridge.msdk.foundation.controller.c.m().c(), str);
        } catch (ClassNotFoundException e11) {
            ad.b("SameTools", e11.getMessage());
            return null;
        } catch (IllegalAccessException e12) {
            ad.b("SameTools", e12.getMessage());
            return null;
        } catch (NoSuchMethodException e13) {
            ad.b("SameTools", e13.getMessage());
            return null;
        } catch (InvocationTargetException e14) {
            ad.b("SameTools", e14.getMessage());
            return null;
        }
    }

    public static boolean g() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static int h(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().widthPixels;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static boolean h() {
        NetworkInfo networkInfo;
        try {
            ConnectivityManager connectivityManagerA = u.a();
            if (connectivityManagerA != null && (networkInfo = connectivityManagerA.getNetworkInfo(17)) != null) {
                return networkInfo.isConnected();
            }
            return false;
        } catch (Exception e11) {
            ad.b("SameTools", e11.getMessage());
            return false;
        }
    }

    public static boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            if (uri == null) {
                return false;
            }
            String queryParameter = uri.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_CAN_ANIM);
            if (TextUtils.isEmpty(queryParameter)) {
                return false;
            }
            return queryParameter.equals("1");
        } catch (Exception e11) {
            ad.b("SameTools", e11.getMessage());
            return false;
        }
    }

    public static float i(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static boolean i() {
        try {
            if (com.mbridge.msdk.foundation.controller.c.m().c() == null) {
                return false;
            }
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 == null) {
                property2 = "-1";
            }
            int i11 = Integer.parseInt(property2);
            ad.a("address = ", property + "~");
            ad.a("port = ", i11 + "~");
            return (TextUtils.isEmpty(property) || i11 == -1) ? false : true;
        } catch (Throwable th2) {
            ad.b("SameTools", th2.getMessage());
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0037  */
    public static boolean i(String str) {
        boolean z11;
        int i11;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            try {
                Uri uri = Uri.parse(str);
                if (uri == null) {
                    return false;
                }
                String queryParameter = uri.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW);
                if (TextUtils.isEmpty(queryParameter)) {
                    queryParameter = uri.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
                }
                if (TextUtils.isEmpty(queryParameter)) {
                    z11 = false;
                } else {
                    try {
                        i11 = Integer.parseInt(queryParameter);
                    } catch (Exception unused) {
                        i11 = -1;
                    }
                    if (i11 % 2 == 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                }
                try {
                    try {
                        if (TextUtils.isEmpty(uri.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_KEY_NATMP))) {
                            return z11;
                        }
                        return true;
                    } catch (Exception e11) {
                        e = e11;
                        ad.b("SameTools", e.getMessage());
                        return false;
                    }
                } catch (Throwable unused2) {
                    return z11;
                }
            } catch (Throwable unused3) {
                return false;
            }
        } catch (Exception e12) {
            e = e12;
            z11 = false;
        }
    }

    public static int j(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static void j() {
        HandlerThread handlerThread = new HandlerThread("mb_db_thread");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        MBDownloadConfig.Builder builder = new MBDownloadConfig.Builder();
        builder.setDatabaseHandler(handler);
        builder.setDatabaseOpenHelper(new IDatabaseOpenHelper() { // from class: com.mbridge.msdk.foundation.tools.ai.2
            @Override // com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper
            public final SQLiteDatabase getReadableDatabase() {
                return com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.c.m().c()).c();
            }

            @Override // com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper
            public final SQLiteDatabase getWritableDatabase() {
                return com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.c.m().c()).d();
            }
        });
        builder.setLogger(new ILogger() { // from class: com.mbridge.msdk.foundation.tools.ai.3
            @Override // com.mbridge.msdk.foundation.download.utils.ILogger
            public final void log(String str, Exception exc) {
                ad.a(str, exc.getMessage());
            }

            @Override // com.mbridge.msdk.foundation.download.utils.ILogger
            public final void log(String str, String str2) {
                ad.a(str, str2);
            }
        });
        MBDownloadManager.getInstance().initialize(com.mbridge.msdk.foundation.controller.c.m().c(), builder.build(), new ResourceConfig.Builder().setMaxStorageSpace(100L).setMaxStorageTime(259200000L).build());
    }

    public static <T extends String> boolean j(T t11) {
        return t11 != null && t11.length() > 0;
    }

    public static boolean k(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static <T extends String> boolean k(T t11) {
        return t11 == null || t11.length() == 0;
    }

    public static boolean l(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.a("SameTools", "isNetworkAvailable", e11);
            }
            return false;
        }
    }

    public static boolean l(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            if (uri == null) {
                return false;
            }
            String queryParameter = uri.getQueryParameter(MBridgeConstans.ENDCARD_URL_IS_PLAYABLE);
            if (TextUtils.isEmpty(queryParameter)) {
                return false;
            }
            return queryParameter.equals("0");
        } catch (Exception e11) {
            ad.b("SameTools", e11.getMessage());
            return false;
        }
    }

    public static double m(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0.0d;
            }
            return Double.parseDouble(str);
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0.0d;
        }
    }

    public static boolean m(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && "wifi".equals(activeNetworkInfo.getTypeName().toLowerCase(Locale.US));
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static BitmapDrawable n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
            if (bitmapDecodeByteArray != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapDecodeByteArray);
                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                bitmapDrawable.setTileModeXY(tileMode, tileMode);
                return bitmapDrawable;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return null;
    }

    private static DisplayMetrics n(Context context) {
        if (context == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return context.getResources().getDisplayMetrics();
        }
    }
}
