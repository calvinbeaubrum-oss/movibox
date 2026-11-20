package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.applovin.sdk.AppLovinMediationProvider;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class cJ {
    private static String BT;
    private static final byte[] Ql;
    private static String SR;
    private static final byte[] Tf;
    private static final HashSet<String> UFX;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static Integer f28766sc;
    private static final ExecutorService pFF = Executors.newSingleThreadExecutor();
    private static volatile boolean zY = false;
    private static final AtomicInteger We = new AtomicInteger(0);
    private static volatile String ExN = "";
    private static final ReentrantLock TRI = new ReentrantLock();

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private static String f28765qr = null;
    private static String Qj = null;
    private static String Ol = null;
    private static final HashSet<String> WH = new HashSet<>(Arrays.asList("Asia/Shanghai", "Asia/Urumqi", "Asia/Chongqing", "Asia/Harbin", "Asia/Kashgar"));

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.utils.cJ$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (TextUtils.isEmpty(cJ.ExN)) {
                    com.bytedance.sdk.component.Ol.We we2 = new com.bytedance.sdk.component.Ol.We(com.bytedance.sdk.openadsdk.core.Xc.sc());
                    we2.setWebViewClient(new com.bytedance.sdk.component.Ol.We.sc());
                    String unused = cJ.ExN = we2.getUserAgentString();
                }
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.Tf.sc("TTAD.ToolUtils", "", e11);
            } catch (NoClassDefFoundError e12) {
                com.bytedance.sdk.component.utils.Tf.sc("TTAD.ToolUtils", "", e12);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class pFF {
        public final int pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public final ComponentName f28768sc;

        public pFF(ComponentName componentName, int i11) {
            this.f28768sc = componentName;
            this.pFF = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class sc implements Callable<String> {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final int f28769sc;

        public sc(int i11) {
            this.f28769sc = i11;
        }

        private String pFF() {
            String property;
            Throwable th2;
            try {
                property = System.getProperty("http.agent");
                if (property != null) {
                    try {
                        if (!"unKnow".equals(property)) {
                            if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                                com.bytedance.sdk.openadsdk.multipro.We.sc.sc("sp_multi_ua_data", "android_system_ua", property);
                            } else {
                                com.bytedance.sdk.openadsdk.core.zY.sc(com.bytedance.sdk.openadsdk.core.Xc.sc()).sc("android_system_ua", property);
                            }
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        com.bytedance.sdk.component.utils.Tf.sc("getUA", "e:" + th2.getMessage());
                    }
                }
            } catch (Throwable th4) {
                property = "unKnow";
                th2 = th4;
            }
            return property;
        }

        private synchronized String zY() {
            final String[] strArr;
            strArr = new String[]{"unKnow"};
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.cJ.sc.1
                @Override // java.lang.Runnable
                public void run() {
                    strArr[0] = cJ.WP();
                    String str = strArr[0];
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await(2L, TimeUnit.SECONDS);
            } catch (InterruptedException e11) {
                com.bytedance.sdk.component.utils.Tf.sc("TTAD.ToolUtils", e11.getMessage());
            }
            return strArr[0];
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public synchronized String call() throws Exception {
            String strPFF;
            try {
                strPFF = "unKnow";
                int i11 = this.f28769sc;
                if (i11 == 1) {
                    strPFF = zY();
                } else if (i11 == 2) {
                    strPFF = pFF();
                }
            } catch (Throwable th2) {
                throw th2;
            }
            return strPFF;
        }
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        UFX = hashSet;
        hashSet.addAll(Arrays.asList("America/Eirunepe", "America/Rio_Branco", "America/Boa_Vista", "America/Campo_Grande", "America/Cuiaba", "America/Manaus", "America/Porto_Velho", "America/Araguaina", "America/Bahia", "America/Belem", "America/Fortaleza", "America/Maceio", "America/Recife", "America/Santarem", "America/Sao_Paulo", "America/Noronha"));
        f28766sc = null;
        Tf = new byte[]{108, 111, 97, 100, 105, 110, 103};
        Ql = new byte[]{97, 114, 98, 105, 116, 114, 97, 103, 101};
    }

    public static String BT() {
        try {
            return TimeZone.getDefault().getID();
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.ToolUtils", e11.toString());
            return "";
        }
    }

    public static String Dl() {
        String str = BT;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = new String(Ql);
        BT = str2;
        return str2;
    }

    public static long ExN(Context context) {
        return com.bytedance.sdk.openadsdk.core.zY.sc(context).pFF("total_sdcard_storage", 0L).longValue();
    }

    public static synchronized String ExN() {
        Context contextSc;
        try {
            if (TextUtils.isEmpty(f28765qr) && (contextSc = com.bytedance.sdk.openadsdk.core.Xc.sc()) != null) {
                try {
                    f28765qr = contextSc.getPackageName();
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.Tf.sc("TTAD.ToolUtils", "ToolUtils getPackageName throws exception :", th2);
                }
            }
        } catch (Throwable th3) {
            throw th3;
        }
        return f28765qr;
    }

    public static String ExN(String str) {
        if (TextUtils.isEmpty(str)) {
            str = com.bytedance.sdk.openadsdk.core.Xc.We().Cb();
        }
        if (TextUtils.isEmpty(str)) {
            return dE() == 2 ? "https://log.sgsnssdk.com/service/2/app_log/" : "https://log-mva.isnssdk.com/service/2/app_log/";
        }
        return !str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) ? AgentPageJsBridge.HTTPS.concat(str) : str;
    }

    public static boolean ExN(int i11) {
        return i11 == 5;
    }

    public static String Ol() {
        return zY("MemTotal");
    }

    public static boolean Ol(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
        }
    }

    public static boolean Ol(String str) {
        if (com.bytedance.sdk.openadsdk.core.SR.ExN()) {
            return true;
        }
        com.bytedance.sdk.component.utils.Tf.pFF("You must use method '" + str + "' after initialization, please check.");
        return false;
    }

    public static String Qj() {
        try {
            ActivityManager activityManager = (ActivityManager) com.bytedance.sdk.openadsdk.core.Xc.sc().getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            long j11 = memoryInfo.totalMem;
            if (j11 > 0) {
                return String.valueOf(j11 / 1024);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void Qj(final String str) {
        com.bytedance.sdk.openadsdk.SR.zY.sc();
        com.bytedance.sdk.openadsdk.SR.zY.sc("reportMultiLog", false, new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.utils.cJ.2
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                if (cJ.zY || !com.bytedance.sdk.openadsdk.core.Xc.We().qfG()) {
                    return null;
                }
                boolean unused = cJ.zY = true;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("error", str);
                return com.bytedance.sdk.openadsdk.SR.sc.We.pFF().sc("reportMultiLog").pFF(jSONObject.toString());
            }
        });
    }

    public static boolean Qj(int i11) {
        if (i11 <= 0) {
            return false;
        }
        return i11 >= 100 || new Random(System.currentTimeMillis()).nextInt(100) + 1 <= i11;
    }

    public static boolean Qj(Context context) {
        if (context != null) {
            return !(context.getApplicationInfo().targetSdkVersion >= 30 && Build.VERSION.SDK_INT >= 30);
        }
        throw new IllegalArgumentException("params context is null");
    }

    public static String Ql() {
        return String.format("https://%s", "log.byteoversea.com/service/2/app_log_test/");
    }

    public static void Ql(Context context) {
        try {
            AtomicInteger atomicInteger = We;
            if (atomicInteger.get() != 0) {
                return;
            }
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            boolean zIsEnabled = accessibilityManager.isEnabled();
            boolean zIsTouchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
            if (!zIsEnabled || !zIsTouchExplorationEnabled) {
                atomicInteger.set(2);
            } else {
                atomicInteger.set(1);
                com.bytedance.sdk.openadsdk.SR.zY.sc().zY();
            }
        } catch (Exception unused) {
            We.set(2);
        }
    }

    public static int SR(Context context) {
        List<ResolveInfo> listQueryIntentActivities;
        Integer num = f28766sc;
        if (num != null) {
            return num.intValue();
        }
        if (context == null || (listQueryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("https://www.example.com")), 0)) == null) {
            return 0;
        }
        Integer numValueOf = Integer.valueOf(listQueryIntentActivities.size());
        f28766sc = numValueOf;
        return numValueOf.intValue();
    }

    public static String SR() {
        int iDE = dE();
        return (iDE == 1 || iDE == 2) ? "https://sf16-static.i18n-pglstatp.com/obj/ad-pattern-sg/renderer/package_sg.json" : "https://sf16-static.i18n-pglstatp.com/obj/ad-pattern-va/renderer/package_va.json";
    }

    public static boolean Sfl() {
        return We.get() == 1;
    }

    public static int TRI(Context context) {
        return com.bytedance.sdk.openadsdk.core.zY.sc(context).pFF("is_root", -1);
    }

    public static synchronized String TRI() {
        try {
            if (TextUtils.isEmpty(Qj) && com.bytedance.sdk.openadsdk.core.Xc.sc() != null) {
                try {
                    PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.Xc.sc().getPackageManager().getPackageInfo(ExN(), 0);
                    Qj = String.valueOf(packageInfo.versionCode);
                    Ol = packageInfo.versionName;
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.Tf.sc("TTAD.ToolUtils", "ToolUtils getVersionCode throws exception :", th2);
                }
            }
        } catch (Throwable th3) {
            throw th3;
        }
        return Qj;
    }

    public static boolean TRI(int i11) {
        return i11 == 6;
    }

    public static boolean TRI(String str) {
        try {
            return Pattern.compile("[一-龥]").matcher(str).find();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int Tf(Context context) {
        return qr(com.bytedance.sdk.component.utils.uEA.sc(context, 0L));
    }

    private static String Tf(String str) {
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("aid", "1371").appendQueryParameter("device_platform", "android").appendQueryParameter("version_code", TRI()).toString();
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.ToolUtils", e11.getMessage());
            return str;
        }
    }

    public static boolean Tf() {
        try {
            return new File("/system/bin/su").exists() || new File("/system/xbin/su").exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static long UFX() {
        try {
            if (!cvk()) {
                return 0L;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.ToolUtils", th2.getMessage());
            return 0L;
        }
    }

    public static long UFX(Context context) {
        int i11 = -1;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                i11 = context.getApplicationInfo().minSdkVersion;
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.ToolUtils", th2.getMessage());
        }
        return i11;
    }

    public static int WH(Context context) {
        try {
            return context.getApplicationInfo().targetSdkVersion;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.ToolUtils", th2.getMessage());
            return -1;
        }
    }

    public static long WH() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static void WH(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return;
        }
        com.bytedance.sdk.component.utils.Tf.pFF("You should use method '" + str + "' on the asynchronous thread,it may cause anr, please check.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String WP() {
        try {
            WebView webView = new WebView(com.bytedance.sdk.openadsdk.core.Xc.sc());
            webView.setWebViewClient(new com.bytedance.sdk.component.Ol.We.sc());
            String userAgentString = webView.getSettings().getUserAgentString();
            if (userAgentString != null && !"unKnow".equals(userAgentString)) {
                if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                    com.bytedance.sdk.openadsdk.multipro.We.sc.sc("sp_multi_ua_data", "webview_ua", userAgentString);
                } else {
                    com.bytedance.sdk.openadsdk.core.zY.sc(com.bytedance.sdk.openadsdk.core.Xc.sc()).sc("webview_ua", userAgentString);
                }
            }
            return userAgentString;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("getUA", "e:" + th2.getMessage());
            return "unKnow";
        }
    }

    public static long We(Context context) {
        return com.bytedance.sdk.openadsdk.core.zY.sc(context).pFF("free_internal_storage", 0L).longValue();
    }

    public static String We() {
        return JPJ.sc();
    }

    public static String We(String str) {
        return sc(str, false);
    }

    public static boolean We(int i11) {
        return i11 == 4;
    }

    public static boolean We(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        return sfl != null && sfl.QLv() == 3 && sfl.yL() && (sfl.Yhz() == 4 || sfl.Yhz() == 5);
    }

    public static int Xc() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    public static String YIK() {
        String str = SR;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = new String(Tf);
        SR = str2;
        return str2;
    }

    private static boolean cvk() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int dE() {
        try {
            String id2 = TimeZone.getDefault().getID();
            if (WH.contains(id2)) {
                return 2;
            }
            if (id2 != null && id2.startsWith("Asia/")) {
                return 2;
            }
            if (id2 == null || !id2.startsWith("Europe/")) {
                return (id2 == null || !id2.startsWith("America/") || UFX.contains(id2)) ? 3 : 5;
            }
            return 4;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.ToolUtils", th2.toString());
            return 0;
        }
    }

    public static int pFF(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        if (sfl == null) {
            return -1;
        }
        int iQY = sfl.qY();
        int i11 = 1;
        if (iQY == 1) {
            return 2;
        }
        if (iQY == 3) {
            return 4;
        }
        if (iQY != 5) {
            i11 = 7;
            if (iQY != 7) {
                return iQY != 8 ? -1 : 5;
            }
        }
        return i11;
    }

    public static long pFF(String str) {
        try {
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    @NonNull
    public static pFF pFF(Context context, Intent intent) {
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        if (listQueryIntentActivities == null || listQueryIntentActivities.isEmpty()) {
            return new pFF(null, 0);
        }
        ActivityInfo activityInfo = listQueryIntentActivities.get(0).activityInfo;
        return (activityInfo == null || TextUtils.isEmpty(activityInfo.packageName) || TextUtils.isEmpty(activityInfo.name)) ? new pFF(null, listQueryIntentActivities.size()) : new pFF(new ComponentName(activityInfo.packageName, activityInfo.name), listQueryIntentActivities.size());
    }

    public static String pFF() {
        String str = "unKnow";
        com.bytedance.sdk.openadsdk.multipro.zY.sc(com.bytedance.sdk.openadsdk.core.Xc.sc());
        try {
            String strPFF = com.bytedance.sdk.openadsdk.multipro.pFF.zY() ? com.bytedance.sdk.openadsdk.multipro.We.sc.pFF("sp_multi_ua_data", "android_system_ua", "unKnow") : com.bytedance.sdk.openadsdk.core.zY.sc(com.bytedance.sdk.openadsdk.core.Xc.sc()).pFF("android_system_ua", "unKnow");
            if (strPFF != null && !"unKnow".equals(strPFF)) {
                return strPFF;
            }
            FutureTask futureTask = new FutureTask(new sc(2));
            pFF.execute(futureTask);
            str = (String) futureTask.get(500L, TimeUnit.MILLISECONDS);
        } catch (Exception unused) {
        }
        com.bytedance.sdk.component.utils.Tf.sc("getUA", " getAndroidSystemUA userAgent".concat(String.valueOf(str)));
        return str;
    }

    public static String pFF(int i11) {
        if (i11 == 1) {
            return "embeded_ad_landingpage";
        }
        if (i11 == 2) {
            return "banner_ad_landingpage";
        }
        if (i11 == 3) {
            return "interaction_landingpage";
        }
        if (i11 == 4) {
            return "splash_ad_landingpage";
        }
        if (i11 != 5) {
            return i11 != 7 ? "unknow" : "rewarded_video_landingpage";
        }
        return "fullscreen_interstitial_ad";
    }

    public static String pFF(Context context) {
        return com.bytedance.sdk.openadsdk.core.zY.sc(context).pFF("total_memory", "0");
    }

    public static boolean pFF(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int qr(int i11) {
        if (i11 == 1) {
            return 0;
        }
        if (i11 == 4) {
            return 1;
        }
        if (i11 == 5) {
            return 4;
        }
        if (i11 != 6) {
            return i11;
        }
        return 5;
    }

    public static synchronized String qr() {
        try {
            if (TextUtils.isEmpty(Ol) && com.bytedance.sdk.openadsdk.core.Xc.sc() != null) {
                try {
                    PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.Xc.sc().getPackageManager().getPackageInfo(ExN(), 0);
                    Qj = String.valueOf(packageInfo.versionCode);
                    Ol = packageInfo.versionName;
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.Tf.sc("TTAD.ToolUtils", "ToolUtils getVersionName throws exception :", th2);
                }
            }
        } catch (Throwable th3) {
            throw th3;
        }
        return Ol;
    }

    public static String qr(@NonNull Context context) {
        try {
            return (Build.VERSION.SDK_INT >= 24 ? context.getResources().getConfiguration().getLocales().get(0) : Locale.getDefault()).getLanguage();
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.ToolUtils", e11.toString());
            return "";
        }
    }

    public static String qr(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", "OPPO");
        }
        return str.contains("kllk") ? str.replace("kllk", "oppo") : "";
    }

    public static int sc(WebView webView) {
        if (webView == null) {
            return -1;
        }
        try {
            WebBackForwardList webBackForwardListCopyBackForwardList = webView.copyBackForwardList();
            int size = webBackForwardListCopyBackForwardList.getSize();
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < size; i11++) {
                WebHistoryItem itemAtIndex = webBackForwardListCopyBackForwardList.getItemAtIndex(i11);
                if (itemAtIndex != null) {
                    String url = itemAtIndex.getUrl();
                    if (!arrayList.contains(url)) {
                        arrayList.add(url);
                    }
                }
            }
            return arrayList.indexOf(webView.getUrl()) + 1;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.ToolUtils", th2.toString());
            return -1;
        }
    }

    public static int sc(String str) {
        str.hashCode();
        switch (str) {
            case "banner_ad":
                return 2;
            case "rewarded_video":
                return 7;
            case "open_ad":
            case "cache_splash_ad":
                return 4;
            case "fullscreen_interstitial_ad":
                return 5;
            case "interaction":
                return 3;
            default:
                return 1;
        }
    }

    public static Intent sc(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(ASTNode.DEOP);
        return launchIntentForPackage;
    }

    public static com.bytedance.sdk.openadsdk.common.We sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl, com.bytedance.sdk.component.Ol.We we2, Context context, String str) {
        int iYhz = sfl.Yhz();
        if (!sfl.yL() || (iYhz != 1 && iYhz != 3)) {
            return null;
        }
        we2.sc(true, (View) new com.bytedance.sdk.openadsdk.common.zY(context));
        return new com.bytedance.sdk.openadsdk.common.We(sfl, we2, str, false);
    }

    public static String sc(int i11) {
        if (i11 == 1) {
            return "embeded_ad";
        }
        if (i11 == 2) {
            return "banner_ad";
        }
        if (i11 == 3) {
            return "interaction";
        }
        if (i11 == 4) {
            return "open_ad";
        }
        if (i11 == 5) {
            return "fullscreen_interstitial_ad";
        }
        if (i11 != 7) {
            return null;
        }
        return "rewarded_video";
    }

    public static String sc(Context context) {
        String strPFF = com.bytedance.sdk.openadsdk.core.zY.sc(context).pFF("total_memory", (String) null);
        if (strPFF == null || pFF(strPFF) <= 0) {
            strPFF = zY("MemTotal");
            if (pFF(strPFF) <= 0) {
                strPFF = Qj();
            }
            com.bytedance.sdk.openadsdk.core.zY.sc(context).sc("total_memory", strPFF);
        }
        return strPFF;
    }

    public static String sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        if (sfl == null) {
            return null;
        }
        try {
            return zY(sfl.qY());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String sc(@NonNull String str, boolean z11) {
        String str2;
        String strCD = com.bytedance.sdk.openadsdk.core.Xc.We().cD();
        if (!TextUtils.isEmpty(strCD)) {
            String strSc = AgentPageJsBridge.HTTPS + strCD + str;
            if (cD.sc() && !z11) {
                strSc = cD.sc(strSc);
            }
            return z11 ? Tf(strSc) : strSc;
        }
        int iDE = dE();
        if (iDE == 1) {
            str2 = AgentPageJsBridge.HTTPS + "pangolin16.sgsnssdk.com" + str;
        } else if (iDE == 2) {
            str2 = AgentPageJsBridge.HTTPS + "pangolin16.sgsnssdk.com" + str;
        } else {
            str2 = AgentPageJsBridge.HTTPS + "pangolin16.isnssdk.com" + str;
        }
        return !z11 ? cD.sc(str2) : Tf(str2);
    }

    public static JSONObject sc(AdSlot adSlot) {
        JSONObject jSONObject = new JSONObject();
        if (adSlot != null) {
            try {
                jSONObject.put("is_sb", !TextUtils.isEmpty(adSlot.getBidAdm()));
            } catch (Throwable unused) {
            }
        }
        return jSONObject;
    }

    public static JSONObject sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl, long j11, q8.b bVar) {
        if (sfl == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CampaignEx.JSON_KEY_CREATIVE_ID, sfl.kDg());
            jSONObject.put("buffers_time", j11);
            x8.a aVarGI = sfl.GI();
            if (aVarGI != null) {
                jSONObject.put(CampaignEx.JSON_KEY_VIDEO_SIZE, aVarGI.c());
                jSONObject.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, aVarGI.f());
            }
            sc(jSONObject, bVar);
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.ToolUtils", "getVideoAction json error", e11);
        }
        return jSONObject;
    }

    public static JSONObject sc(boolean z11, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, long j11, long j12, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CampaignEx.JSON_KEY_CREATIVE_ID, sfl.kDg());
            jSONObject.put("load_time", j11);
            x8.a aVarGI = sfl.GI();
            if (aVarGI != null) {
                jSONObject.put(CampaignEx.JSON_KEY_VIDEO_SIZE, aVarGI.c());
                jSONObject.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, aVarGI.f());
            }
            if (!z11) {
                jSONObject.put(TrackingKey.ERROR_CODE, j12);
                if (TextUtils.isEmpty(str)) {
                    str = AppLovinMediationProvider.UNKNOWN;
                }
                jSONObject.put(TrackingKey.ERROR_MESSAGE, str);
            }
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.ToolUtils", "getVideoDownload json error", e11);
        }
        return jSONObject;
    }

    public static void sc(@NonNull com.bytedance.sdk.openadsdk.core.model.Sfl sfl, @NonNull View view) {
    }

    public static void sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl, com.bytedance.sdk.component.Ol.We we2) {
        sc(sfl, we2, false);
    }

    public static void sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl, com.bytedance.sdk.component.Ol.We we2, boolean z11) {
        com.bytedance.sdk.openadsdk.core.model.ExN exNUFX;
        List<Integer> list;
        if (sfl == null || we2 == null) {
            return;
        }
        int iYhz = sfl.Yhz();
        if (sfl.yL()) {
            if ((iYhz == 2 || iYhz == 3 || iYhz == 5) && (exNUFX = sfl.UFX()) != null) {
                List<Integer> listTRI = exNUFX.TRI();
                ArrayList arrayList = new ArrayList();
                if (z11) {
                    for (int i11 = 0; i11 < listTRI.size(); i11++) {
                        arrayList.add(Integer.valueOf(listTRI.get(i11).intValue() - 1));
                    }
                    list = arrayList;
                } else {
                    list = listTRI;
                }
                we2.sc(true, exNUFX.We(), exNUFX.ExN(), list, exNUFX.qr(), exNUFX.zY());
            }
        }
    }

    public static void sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl, String str) {
        if (sfl != null) {
            try {
                String strKo = sfl.ko();
                if (TextUtils.isEmpty(strKo) && sfl.otH() != null && sfl.otH().zY() == 1 && !TextUtils.isEmpty(sfl.otH().pFF())) {
                    strKo = sfl.otH().pFF();
                }
                String str2 = strKo;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.cD.sc(com.bytedance.sdk.openadsdk.core.Xc.sc(), str2, sfl, sc(str), str, false);
            } catch (Throwable unused) {
            }
        }
    }

    public static void sc(String str, String str2, Context context) {
        if (TextUtils.isEmpty(str2) || !Ol(context)) {
            return;
        }
        int length = str2.length();
        int i11 = 1;
        int i12 = length % 3572 == 0 ? length / 3572 : (length / 3572) + 1;
        int i13 = 3572;
        int i14 = 0;
        while (i11 <= i12) {
            if (i13 >= length) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i12);
                sb2.append("-");
                sb2.append(i11);
                sb2.append(":");
                sb2.append(str2.substring(i14));
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(i12);
            sb3.append("-");
            sb3.append(i11);
            sb3.append(":");
            sb3.append(str2.substring(i14, i13));
            i11++;
            i14 = i13;
            i13 += 3572;
        }
    }

    public static void sc(StringBuilder sb2, String str, String str2) {
        int iIndexOf;
        if (sb2 == null || TextUtils.isEmpty(str) || (iIndexOf = sb2.indexOf(str)) <= 0) {
            return;
        }
        sb2.replace(iIndexOf, str.length() + iIndexOf, str2);
    }

    public static void sc(JSONObject jSONObject) {
        int iIntValue;
        try {
            Pair<String, Long> pairWe = com.bytedance.sdk.openadsdk.core.Ol.We("oem_store");
            int i11 = -1;
            if (pairWe != null && ((iIntValue = Integer.valueOf((String) pairWe.first).intValue()) != -2 || System.currentTimeMillis() - ((Long) pairWe.second).longValue() < com.bytedance.sdk.openadsdk.YIK.sc.sc("oem_store_state_time", 259200000))) {
                i11 = iIntValue;
            }
            jSONObject.put("oem_store", i11);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.ToolUtils", th2.getMessage());
        }
    }

    private static void sc(JSONObject jSONObject, q8.b bVar) {
        if (jSONObject.has(CampaignEx.JSON_KEY_VIDEO_RESOLUTION) || bVar == null) {
            return;
        }
        try {
            jSONObject.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, String.format(Locale.getDefault(), "%d×%d", Integer.valueOf(bVar.We()), Integer.valueOf(bVar.ExN())));
        } catch (Throwable unused) {
        }
    }

    public static boolean sc() {
        return (com.bytedance.sdk.openadsdk.core.BT.sc() == null || com.bytedance.sdk.openadsdk.core.BT.sc().We()) ? false : true;
    }

    public static boolean sc(Context context, Intent intent) {
        return zY(context, intent) > 0;
    }

    public static String wjp() {
        int i11 = -Xc();
        return i11 >= 0 ? "Etc/GMT+".concat(String.valueOf(i11)) : "Etc/GMT".concat(String.valueOf(i11));
    }

    public static int zY(Context context, Intent intent) {
        if (intent == null) {
            return 0;
        }
        try {
            return context.getPackageManager().queryIntentActivities(intent, 65536).size();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static long zY(Context context) {
        return com.bytedance.sdk.openadsdk.core.zY.sc(context).pFF("total_internal_storage", 0L).longValue();
    }

    public static String zY() {
        if (!TextUtils.isEmpty(ExN)) {
            return ExN;
        }
        com.bytedance.sdk.openadsdk.multipro.zY.sc(com.bytedance.sdk.openadsdk.core.Xc.sc());
        String strSc = com.bytedance.sdk.openadsdk.core.Ol.sc("sdk_local_web_ua", ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED);
        ExN = strSc;
        if (TextUtils.isEmpty(strSc)) {
            ReentrantLock reentrantLock = TRI;
            try {
                if (reentrantLock.tryLock()) {
                    try {
                        if (TextUtils.isEmpty(ExN)) {
                            ExN = WebSettings.getDefaultUserAgent(com.bytedance.sdk.openadsdk.core.Xc.sc());
                        }
                        com.bytedance.sdk.openadsdk.core.Ol.sc("sdk_local_web_ua", ExN);
                        reentrantLock.unlock();
                    } catch (Exception e11) {
                        com.bytedance.sdk.component.utils.Tf.sc("TTAD.ToolUtils", "", e11);
                        TRI.unlock();
                    } catch (NoClassDefFoundError e12) {
                        com.bytedance.sdk.component.utils.Tf.sc("TTAD.ToolUtils", "", e12);
                        TRI.unlock();
                    }
                }
            } catch (Throwable th2) {
                TRI.unlock();
                throw th2;
            }
        }
        return ExN;
    }

    public static String zY(int i11) {
        if (i11 == 1) {
            return "banner_ad";
        }
        if (i11 == 2) {
            return "interaction";
        }
        if (i11 == 3 || i11 == 4) {
            return "open_ad";
        }
        if (i11 != 7) {
            return i11 != 8 ? "embeded_ad" : "fullscreen_interstitial_ad";
        }
        return "rewarded_video";
    }

    public static String zY(String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String line;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 4096);
                do {
                    try {
                        line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            com.bytedance.sdk.component.utils.Tf.sc("TTAD.ToolUtils", th.getMessage());
                            return null;
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception unused2) {
                                }
                            }
                        }
                    }
                } while (!line.contains(str));
                if (line == null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                    try {
                        fileReader.close();
                    } catch (Exception unused4) {
                    }
                    return null;
                }
                String str2 = line.split("\\s+")[1];
                try {
                    bufferedReader.close();
                } catch (Exception unused5) {
                }
                try {
                    fileReader.close();
                } catch (Exception unused6) {
                }
                return str2;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
            bufferedReader = null;
        }
    }

    public static boolean zY(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + Uri.encode(str)));
                if (!(context instanceof Activity)) {
                    intent.setFlags(ASTNode.DEOP);
                }
                com.bytedance.sdk.component.utils.pFF.sc(context, intent, null);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean zY(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        if (sfl == null) {
            return true;
        }
        int iPFF = com.bytedance.sdk.openadsdk.core.Xc.We().pFF(sfl.QT());
        int iZY = com.bytedance.sdk.component.utils.BT.zY(com.bytedance.sdk.openadsdk.core.Xc.sc());
        if (iPFF == 1) {
            return We(iZY);
        }
        if (iPFF == 2) {
            return ExN(iZY) || We(iZY) || TRI(iZY);
        }
        if (iPFF != 3) {
            return iPFF != 5 || We(iZY) || TRI(iZY);
        }
        return false;
    }
}
