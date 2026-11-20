package com.applovin.impl;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.icu.util.VersionInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Toast;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxNetworkResponseInfo;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.NetworkInterface;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class yp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f24701a = {60, 60, 24, 7, 4, 12};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f24702b = {" second", " minute", " hour", " day", " week", " month"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f24703c = {"s", "m", "h", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "w", "mth"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final DecimalFormat f24704d = new DecimalFormat();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Random f24705e = new Random();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Boolean f24706f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Boolean f24707g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f24708h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Boolean f24709i;

    /* JADX INFO: compiled from: source.java */
    public class a implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareToIgnoreCase(str2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void onCachedResourcesChecked(boolean z11);
    }

    public static double a(long j11) {
        return j11 / 1024.0d;
    }

    public static double a(String str, double d11) {
        try {
            return Double.parseDouble(str);
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("Utils", "Failed to parse double from String: " + str, th2);
            return d11;
        }
    }

    public static int a(int i11) {
        return a(i11, 95);
    }

    public static int a(int i11, int i12) {
        return (i11 < 0 || i11 > 100) ? i12 : i11;
    }

    public static int a(Context context) {
        z3.d();
        return Settings.System.getInt(context.getContentResolver(), "always_finish_activities", 0);
    }

    public static int a(String str, String str2) {
        String digitsOnlyVersionString = StringUtils.toDigitsOnlyVersionString(str);
        String digitsOnlyVersionString2 = StringUtils.toDigitsOnlyVersionString(str2);
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                int iCompareTo = VersionInfo.getInstance(digitsOnlyVersionString).compareTo(VersionInfo.getInstance(digitsOnlyVersionString2));
                if (iCompareTo == 0) {
                    return iCompareTo;
                }
                return iCompareTo > 0 ? 1 : -1;
            }
            String[] strArrSplit = digitsOnlyVersionString.split("\\.");
            String[] strArrSplit2 = digitsOnlyVersionString2.split("\\.");
            int iMax = Math.max(strArrSplit.length, strArrSplit2.length);
            int i11 = 0;
            while (i11 < iMax) {
                String str3 = StringUtils.isValidString(strArrSplit[i11]) ? strArrSplit[i11] : "0";
                String str4 = StringUtils.isValidString(strArrSplit2[i11]) ? strArrSplit2[i11] : "0";
                int i12 = i11 < strArrSplit.length ? Integer.parseInt(str3) : 0;
                int i13 = i11 < strArrSplit2.length ? Integer.parseInt(str4) : 0;
                if (i12 < i13) {
                    return -1;
                }
                if (i12 > i13) {
                    return 1;
                }
                i11++;
            }
            return 0;
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("Utils", "Failed to process version string.", th2);
            return 0;
        }
    }

    private static long a(float f11) {
        return Math.round(f11);
    }

    public static long a(com.applovin.impl.sdk.j jVar) {
        long jLongValue = ((Long) jVar.a(sj.C5)).longValue();
        long jLongValue2 = ((Long) jVar.a(sj.D5)).longValue();
        long jCurrentTimeMillis = System.currentTimeMillis();
        return (jLongValue <= 0 || jLongValue2 <= 0) ? jCurrentTimeMillis : jCurrentTimeMillis + (jLongValue - jLongValue2);
    }

    public static long a(byte[] bArr, int i11) {
        int i12 = i11 + 8;
        if (bArr.length < i12) {
            throw new IllegalArgumentException("byte array must be at least 8 bytes long");
        }
        long j11 = 0;
        while (i11 < i12) {
            j11 |= (((long) bArr[i11]) & 255) << (i11 * 8);
            i11++;
        }
        return j11;
    }

    public static ActivityManager.MemoryInfo a(ActivityManager activityManager) {
        if (activityManager == null) {
            return null;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        try {
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo;
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.b("Utils", "Unable to collect memory info.", th2);
            return null;
        }
    }

    public static WebView a(Context context, String str, boolean z11) {
        try {
            WebView webView = new WebView(context);
            if (z11) {
                webView.setWebViewClient(new pi());
            }
            return webView;
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("Utils", "Failed to initialize WebView for " + str + InstructionFileId.DOT, th2);
            return null;
        }
    }

    public static h0 a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        return h0.a(AppLovinAdSize.fromString(JsonUtils.getString(jSONObject, "ad_size", null)), AppLovinAdType.fromString(JsonUtils.getString(jSONObject, "ad_type", null)), JsonUtils.getString(jSONObject, "zone_id", null), true, JsonUtils.getBoolean(jSONObject, "is_direct_sold", Boolean.FALSE).booleanValue());
    }

    public static AppLovinAd a(AppLovinAd appLovinAd, com.applovin.impl.sdk.j jVar) {
        if (!(appLovinAd instanceof com.applovin.impl.sdk.ad.c)) {
            return appLovinAd;
        }
        com.applovin.impl.sdk.ad.c cVar = (com.applovin.impl.sdk.ad.c) appLovinAd;
        AppLovinAd appLovinAdDequeueAd = jVar.i().dequeueAd(cVar.getAdZone());
        jVar.J();
        if (com.applovin.impl.sdk.n.a()) {
            jVar.J().a("Utils", "Dequeued ad for dummy ad: " + appLovinAdDequeueAd);
        }
        if (appLovinAdDequeueAd == null) {
            return cVar.e();
        }
        cVar.a(appLovinAdDequeueAd);
        ((AppLovinAdImpl) appLovinAdDequeueAd).setDummyAd(cVar);
        return appLovinAdDequeueAd;
    }

    public static String a(int i11, Context context, com.applovin.impl.sdk.j jVar) {
        if (i11 == 0) {
            return "";
        }
        try {
            InputStream inputStreamOpenRawResource = context.getResources().openRawResource(i11);
            try {
                byte[] bArr = new byte[inputStreamOpenRawResource.available()];
                inputStreamOpenRawResource.read(bArr);
                return new String(bArr);
            } catch (IOException e11) {
                if (jVar != null) {
                    jVar.J();
                    if (com.applovin.impl.sdk.n.a()) {
                        jVar.J().a("Utils", "Opening raw resource file threw exception", e11);
                    }
                }
                return "";
            } finally {
                a(inputStreamOpenRawResource, jVar);
            }
        } catch (Throwable th2) {
            if (jVar != null) {
                jVar.J();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.J().a("Utils", "Failed to retrieve resource " + i11, th2);
                }
            }
            return "";
        }
    }

    public static String a(long j11, boolean z11) {
        String[] strArr = z11 ? f24702b : f24703c;
        long jCurrentTimeMillis = (System.currentTimeMillis() - j11) / 1000;
        for (int i11 = 0; i11 < strArr.length; i11++) {
            long j12 = f24701a[i11];
            if (jCurrentTimeMillis < j12) {
                if (jCurrentTimeMillis <= 0) {
                    return z11 ? "just now" : "now";
                }
                return String.format("%d%s%s%s", Long.valueOf(jCurrentTimeMillis), strArr[i11], (!z11 || jCurrentTimeMillis <= 1) ? "" : "s", z11 ? " ago" : "");
            }
            jCurrentTimeMillis /= j12;
        }
        return z11 ? "just now" : "now";
    }

    public static String a(Uri uri, String str, com.applovin.impl.sdk.j jVar) {
        List listC = jVar.c(sj.f22919b1);
        String lastPathSegment = uri.getLastPathSegment();
        if (listC.contains(lastPathSegment)) {
            return lastPathSegment;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = uri.getQueryParameterNames().iterator();
        while (it.hasNext()) {
            String queryParameter = uri.getQueryParameter(it.next());
            if (StringUtils.isValidString(queryParameter)) {
                arrayList.add(queryParameter);
            }
        }
        arrayList.addAll(uri.getPathSegments());
        String strEncodeUriString = StringUtils.encodeUriString(TextUtils.join("_", arrayList));
        Integer num = (Integer) jVar.a(sj.f22927c1);
        int length = StringUtils.emptyIfNull(strEncodeUriString).length() + StringUtils.emptyIfNull(str).length();
        if (length > num.intValue() && StringUtils.isValidString(strEncodeUriString)) {
            strEncodeUriString = strEncodeUriString.substring(length - num.intValue());
        }
        if (!StringUtils.isValidString(strEncodeUriString) || !StringUtils.isValidString(str)) {
            return strEncodeUriString;
        }
        return str + strEncodeUriString;
    }

    public static String a(nh nhVar) {
        if (nhVar == null) {
            return "Unknown error";
        }
        Throwable cause = nhVar.getCause();
        String message = cause != null ? cause.getMessage() : "Unknown";
        return "Code: " + nhVar.f21333a + ", Name: " + nhVar.a() + ", Message: " + nhVar.getMessage() + ", Cause Class: " + (cause != null ? cause.getClass().getName() : "") + ", Cause Message: " + message;
    }

    public static String a(AppLovinSdkSettings appLovinSdkSettings) {
        String strEmptyIfNull = StringUtils.emptyIfNull(appLovinSdkSettings.getExtraParameters().get("applovin_unity_metadata"));
        if (TextUtils.isEmpty(strEmptyIfNull)) {
            return null;
        }
        Map<String, String> mapTryToStringMap = JsonUtils.tryToStringMap(JsonUtils.jsonObjectFromJsonString(strEmptyIfNull, new JSONObject()));
        if (CollectionUtils.isEmpty(mapTryToStringMap)) {
            return null;
        }
        return mapTryToStringMap.get("UnityVersion");
    }

    public static String a(Object obj) {
        if (obj instanceof ge) {
            return ((ge) obj).T();
        }
        if (af.a(obj)) {
            return ((com.applovin.impl.sdk.ad.b) obj).H();
        }
        return null;
    }

    public static String a(Map map, boolean z11) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        if (z11) {
            TreeMap treeMap = new TreeMap(new a());
            treeMap.putAll(map);
            map = treeMap;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (sb2.length() > 0) {
                sb2.append("&");
            }
            Object value = entry.getValue();
            if (value instanceof String) {
                String str = (String) value;
                if (str.contains("&")) {
                    value = str.replace("&", "%26");
                }
            }
            sb2.append(entry.getKey());
            sb2.append('=');
            sb2.append(value);
        }
        return sb2.toString();
    }

    public static Field a(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Class superclass = cls.getSuperclass();
            if (superclass == null) {
                return null;
            }
            return a(superclass, str);
        }
    }

    public static List a(JSONObject jSONObject, String str, String str2, com.applovin.impl.sdk.j jVar) {
        return a(jSONObject, str, null, str2, null, false, jVar);
    }

    public static List a(JSONObject jSONObject, String str, Map map, String str2, Map map2, boolean z11, com.applovin.impl.sdk.j jVar) {
        if (map == null) {
            map = new HashMap(1);
        }
        Map map3 = map;
        map3.put("{CLCODE}", str);
        return a(jSONObject, map3, str2, map2, z11, jVar);
    }

    public static List a(JSONObject jSONObject, Map map, String str, Map map2, boolean z11, com.applovin.impl.sdk.j jVar) {
        ArrayList arrayList = new ArrayList(jSONObject.length() + 1);
        if (StringUtils.isValidString(str)) {
            arrayList.add(new s(str, null, map2, z11));
        }
        if (jSONObject.length() <= 0) {
            return arrayList;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            try {
                String next = itKeys.next();
                if (!TextUtils.isEmpty(next)) {
                    String strOptString = jSONObject.optString(next);
                    String strReplace = StringUtils.replace(next, map);
                    if (AppLovinSdkUtils.isValidString(strOptString)) {
                        strOptString = StringUtils.replace(strOptString, map);
                    }
                    arrayList.add(new s(strReplace, strOptString, map2, z11));
                }
            } catch (Throwable th2) {
                jVar.J();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.J().a("Utils", "Failed to create and add postback url.", th2);
                }
            }
        }
        return arrayList;
    }

    public static List a(boolean z11, com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.j jVar, Context context) {
        Uri uriS0;
        if (bVar instanceof aq) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Uri uri : new ArrayList(bVar.i())) {
            if (!jVar.B().b(uri.getLastPathSegment(), context)) {
                jVar.J();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.J().b("Utils", "Cached HTML asset missing: " + uri);
                }
                arrayList.add(uri);
            }
        }
        if (z11 && (uriS0 = bVar.s0()) != null && !jVar.B().b(uriS0.getLastPathSegment(), context)) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().b("Utils", "Cached video missing: " + uriS0);
            }
            arrayList.add(uriS0);
        }
        return arrayList;
    }

    public static Map a(Map map) {
        HashMap map2 = new HashMap();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry entry : map.entrySet()) {
                map2.put((String) entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return map2;
    }

    public static Map a(Map map, com.applovin.impl.sdk.j jVar) {
        Map map2 = CollectionUtils.map(map);
        for (String str : map2.keySet()) {
            String str2 = (String) map2.get(str);
            if (str2 != null) {
                map2.put(str, StringUtils.encodeUriString(str2));
            }
        }
        return map2;
    }

    public static void a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Context context, String str) {
        Toast toastMakeText = Toast.makeText(context, str, 0);
        toastMakeText.setMargin(0.0f, 0.1f);
        toastMakeText.show();
    }

    public static void a(Uri uri, Activity activity, com.applovin.impl.sdk.j jVar) {
        if (activity == null) {
            activity = jVar.n0();
        }
        Intent intent = new Intent(activity, (Class<?>) AppLovinWebViewActivity.class);
        intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, jVar.b0());
        intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_LOAD_URL, uri.toString());
        activity.startActivity(intent);
    }

    public static void a(com.applovin.impl.sdk.j jVar, String str) {
        String strB0 = jVar.b0();
        if (!((Boolean) jVar.a(sj.I)).booleanValue() || strB0 == null || strB0.length() == 86) {
            return;
        }
        a(TextUtils.isEmpty(strB0) ? "Empty SDK key" : "Invalid SDK key length", str, jVar);
    }

    public static void a(MaxError maxError, String str, Context context) {
        StringBuilder sb2 = new StringBuilder();
        if (maxError.getCode() == -5001) {
            for (MaxNetworkResponseInfo maxNetworkResponseInfo : maxError.getWaterfall().getNetworkResponses()) {
                MaxError error = maxNetworkResponseInfo.getError();
                String name = maxNetworkResponseInfo.getMediatedNetwork().getName();
                sb2.append("\nFailed to load " + str + " from " + name + ":\n");
                sb2.append("\nMAX Error " + error.getCode() + ": " + error.getMessage() + "\n");
                sb2.append("\n" + name + " Error " + error.getMediatedNetworkErrorCode() + ": " + error.getMediatedNetworkErrorMessage() + "\n\n");
            }
        } else {
            sb2.append("Failed to load " + str + " with error " + maxError.getCode() + ": " + maxError.getMessage());
        }
        a("", sb2.toString(), context);
    }

    public static void a(Closeable closeable, com.applovin.impl.sdk.j jVar) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            if (jVar != null) {
                jVar.J();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.J().a("Utils", "Unable to close stream: " + closeable, th2);
                }
            }
        }
    }

    public static void a(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(1);
        thread.start();
    }

    public static void a(final String str, final Context context) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.ha0
            @Override // java.lang.Runnable
            public final void run() {
                yp.a(context, str);
            }
        });
    }

    private static void a(String str, AppLovinAdBase appLovinAdBase, String str2, com.applovin.impl.sdk.j jVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("sdkKey=");
        sb2.append(jVar.b0());
        if (appLovinAdBase != null) {
            sb2.append(",adSdkKey=");
            sb2.append(appLovinAdBase.getSdk().b0());
        }
        HashMap map = new HashMap();
        CollectionUtils.putStringIfValid("details", sb2.toString(), map);
        CollectionUtils.putStringIfValid(TrackingKey.ERROR_MESSAGE, str, map);
        jVar.E().a(la.L, str2, (Map) map);
    }

    public static void a(String str, MaxAd maxAd, Context context) {
        Toast.makeText(context, maxAd.getFormat().getLabel() + ": " + str, 1).show();
    }

    public static void a(String str, MaxAdFormat maxAdFormat, JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject.has("no_fill_reason")) {
            Object object = JsonUtils.getObject(jSONObject, "no_fill_reason", new Object());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\n**************************************************\nNO FILL received:\n..ID: \"");
            sb2.append(str);
            sb2.append("\"\n..FORMAT: \"");
            sb2.append(maxAdFormat != null ? maxAdFormat.getLabel() : "None");
            sb2.append("\"\n..SDK KEY: \"");
            sb2.append(jVar.b0());
            sb2.append("\"\n..PACKAGE NAME: \"");
            sb2.append(com.applovin.impl.sdk.j.l().getPackageName());
            sb2.append("\"\n..Reason: ");
            sb2.append(object);
            sb2.append("\n**************************************************\n");
            String string = sb2.toString();
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().b("AppLovinSdk", string);
            }
        }
    }

    public static void a(String str, String str2, Context context) {
        new AlertDialog.Builder(context).setTitle(str).setMessage(str2).setNegativeButton(R.string.ok, (DialogInterface.OnClickListener) null).create().show();
    }

    private static void a(String str, String str2, com.applovin.impl.sdk.j jVar) {
        a(str, (AppLovinAdBase) null, str2, jVar);
    }

    public static void a(String str, String str2, Map map) {
        if (map.containsKey(str)) {
            map.put(str2, map.get(str));
            map.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(WeakReference weakReference, com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.j jVar, Context context, boolean z11) {
        final b bVar2 = (b) weakReference.get();
        if (bVar2 == null) {
            return;
        }
        if (bVar instanceof aq) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.ca0
                @Override // java.lang.Runnable
                public final void run() {
                    bVar2.onCachedResourcesChecked(true);
                }
            });
            return;
        }
        for (Uri uri : new ArrayList(bVar.i())) {
            if (!jVar.B().c(uri.getLastPathSegment(), context)) {
                jVar.J();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.J().b("Utils", "Cached HTML asset unavailable: " + uri);
                }
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.da0
                    @Override // java.lang.Runnable
                    public final void run() {
                        bVar2.onCachedResourcesChecked(false);
                    }
                });
                return;
            }
        }
        if (z11) {
            Uri uriS0 = bVar.s0();
            if (!jVar.B().c(uriS0.getLastPathSegment(), context)) {
                jVar.J();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.J().b("Utils", "Cached video unavailable: " + uriS0);
                }
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.ea0
                    @Override // java.lang.Runnable
                    public final void run() {
                        bVar2.onCachedResourcesChecked(false);
                    }
                });
                return;
            }
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.fa0
            @Override // java.lang.Runnable
            public final void run() {
                bVar2.onCachedResourcesChecked(true);
            }
        });
    }

    public static void a(HttpURLConnection httpURLConnection, com.applovin.impl.sdk.j jVar) {
        if (httpURLConnection == null) {
            return;
        }
        try {
            httpURLConnection.disconnect();
        } catch (Throwable th2) {
            if (jVar != null) {
                jVar.J();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.J().a("Utils", "Unable to disconnect connection: " + httpURLConnection, th2);
                }
            }
        }
    }

    public static void a(final boolean z11, final com.applovin.impl.sdk.ad.b bVar, final com.applovin.impl.sdk.j jVar, final Context context, b bVar2) {
        final WeakReference weakReference = new WeakReference(bVar2);
        jVar.j0().a(new jn(jVar, "checkIfAdContainsUnavailableCachedResources", new Runnable() { // from class: com.applovin.impl.ga0
            @Override // java.lang.Runnable
            public final void run() {
                yp.a(weakReference, bVar, jVar, context, z11);
            }
        }));
    }

    public static boolean a(double d11) {
        if (d11 >= 100.0d) {
            return true;
        }
        return d11 > 0.0d && ((double) f24705e.nextFloat()) < d11 / 100.0d;
    }

    public static boolean a(long j11, long j12) {
        return (j11 & j12) != 0;
    }

    public static boolean a(sj sjVar, com.applovin.impl.sdk.j jVar) {
        String str = jVar.g0().getExtraParameters().get("enable_black_screen_fixes");
        return StringUtils.isValidString(str) ? Boolean.parseBoolean(str) : ((Boolean) jVar.a(sjVar)).booleanValue();
    }

    public static boolean a(MaxAdFormat maxAdFormat, MaxAdFormat maxAdFormat2) {
        return (maxAdFormat == null || maxAdFormat2 == null || (maxAdFormat != maxAdFormat2 && ((!maxAdFormat.isAdViewAd() || !maxAdFormat2.isAdViewAd()) && (!maxAdFormat.isFullscreenAd() || !maxAdFormat2.isFullscreenAd())))) ? false : true;
    }

    public static boolean a(AppLovinAdSize appLovinAdSize) {
        return appLovinAdSize == AppLovinAdSize.BANNER || appLovinAdSize == AppLovinAdSize.MREC || appLovinAdSize == AppLovinAdSize.LEADER;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(String str, List list) {
        return StringUtils.startsWithAtLeastOnePrefix(str, list);
    }

    public static boolean a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (a((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static byte[] a(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static float b(float f11) {
        return f11 * 1000.0f;
    }

    public static int b(int i11) {
        return i11 * 1024;
    }

    public static long b(long j11) {
        return j11 * 8;
    }

    public static WebView b(Context context, String str) {
        return a(context, str, false);
    }

    public static String b(Context context) {
        if (context == null) {
            return null;
        }
        if (StringUtils.isValidString(f24708h)) {
            return f24708h;
        }
        try {
            int iMyPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                com.applovin.impl.sdk.n.c("Utils", "No running app processes. Unable to determine process name");
                return null;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (iMyPid == runningAppProcessInfo.pid) {
                    String str = runningAppProcessInfo.processName;
                    f24708h = str;
                    return str;
                }
            }
            return null;
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.b("Utils", "Unable to determine process name", th2);
        }
    }

    public static String b(Class cls, String str) {
        try {
            Field fieldA = a(cls, str);
            fieldA.setAccessible(true);
            return (String) fieldA.get(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(String str) {
        return str.replace("ALPlayableAnalytics.trackEvent = ", "ALPlayableAnalytics.trackEvent = function (eventName) {const SDK_URL = 'applovin://com.applovin.sdk/playable_event';if (!Object.values(ALPlayableEvent).includes(eventName)) {var aTag = document.createElement('a');aTag.setAttribute('href', SDK_URL + '?success=0&type=' + encodeURIComponent(eventName));aTag.innerHTML = 'empty';aTag.click();return;}var aTag = document.createElement('a');aTag.setAttribute('href', SDK_URL + '?success=1&type=' + encodeURIComponent(eventName));aTag.innerHTML = 'empty';aTag.click();}; ALPlayableAnalytics.trackEvent_ignore = ");
    }

    public static void b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(AppLovinAd appLovinAd, com.applovin.impl.sdk.j jVar) {
        if (appLovinAd instanceof AppLovinAdBase) {
            AppLovinAdBase appLovinAdBase = (AppLovinAdBase) appLovinAd;
            String strB0 = jVar.b0();
            String strB1 = appLovinAdBase.getSdk().b0();
            if (strB0.equals(strB1)) {
                return;
            }
            String str = "Ad was loaded from sdk with key: " + strB1 + ", but is being rendered from sdk with key: " + strB0;
            com.applovin.impl.sdk.n.h("AppLovinAd", str);
            jVar.D().c(ca.f18160q);
            a(str, appLovinAdBase, "AppLovinAd", jVar);
        }
    }

    public static void b(String str, String str2) {
        if (str == null || str.length() <= b(8)) {
            return;
        }
        com.applovin.impl.sdk.n.j(str2, "Provided custom data parameter longer than supported (" + str.length() + " bytes, " + b(8) + " maximum)");
    }

    public static boolean b(com.applovin.impl.sdk.j jVar) {
        if (!z3.e()) {
            return true;
        }
        try {
            JSONObject.wrap(JSONObject.NULL);
            return true;
        } catch (Throwable th2) {
            jVar.J();
            if (!com.applovin.impl.sdk.n.a()) {
                return false;
            }
            jVar.J().d("Utils", "Failed to wrap JSONObject with exception", th2);
            return false;
        }
    }

    public static boolean b(List list) {
        Context contextL = com.applovin.impl.sdk.j.l();
        if (contextL != null) {
            return list.contains(contextL.getPackageName());
        }
        com.applovin.impl.sdk.n.h("Utils", "Failed to check whether or not app is member of package names");
        return false;
    }

    public static boolean b(byte[] bArr) {
        return bArr.length >= 2 && bArr[0] == 31 && bArr[1] == -117;
    }

    public static double c(long j11) {
        return a(b(j11));
    }

    public static int c(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return 0;
        }
        return windowManager.getDefaultDisplay().getRotation();
    }

    public static long c(float f11) {
        return a(b(f11));
    }

    public static long c(byte[] bArr) {
        return a(bArr, 0);
    }

    public static void c() {
    }

    public static boolean c(com.applovin.impl.sdk.j jVar) {
        String str = jVar.g0().getExtraParameters().get("run_in_release_mode");
        return ((StringUtils.isValidString(str) && Boolean.parseBoolean(str)) || (com.applovin.impl.sdk.j.l().getApplicationInfo().flags & 2) == 0) ? false : true;
    }

    public static boolean c(String str) {
        return str != null && (str.contains("applovin.com") || str.contains("applvn.com"));
    }

    public static double d(long j11) {
        return j11 / 1000.0d;
    }

    public static long d(String str) {
        if (!StringUtils.isValidString(str)) {
            return Long.MAX_VALUE;
        }
        try {
            return Color.parseColor(str);
        } catch (Throwable unused) {
            return Long.MAX_VALUE;
        }
    }

    public static Context d(Context context) {
        return j(context) ? context : com.applovin.impl.sdk.j.l();
    }

    public static String d() {
        try {
            return Build.VERSION.RELEASE + " (" + e() + " - API " + Build.VERSION.SDK_INT + ")";
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("Utils", "Unable to get Android OS info", th2);
            return "";
        }
    }

    public static boolean d(com.applovin.impl.sdk.j jVar) {
        String str = jVar.g0().getExtraParameters().get("user_agent_collection_enabled");
        if (StringUtils.isValidString(str)) {
            return Boolean.parseBoolean(str);
        }
        return true;
    }

    public static byte[] d(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0 || !b(bArr)) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
        byte[] bArr2 = new byte[1024];
        while (true) {
            int i11 = gZIPInputStream.read(bArr2);
            if (i11 <= 0) {
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr2, 0, i11);
        }
    }

    public static String e() {
        try {
            for (Field field : Build.VERSION_CODES.class.getFields()) {
                if (field.getInt(null) == Build.VERSION.SDK_INT) {
                    return field.getName();
                }
            }
            return "";
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("Utils", "Unable to get Android SDK codename", th2);
            return "";
        }
    }

    public static String e(String str) {
        return (str == null || str.length() <= 4) ? "NOKEY" : str.substring(str.length() - 4);
    }

    public static boolean e(Context context) {
        return t0.a(context).a("applovin.sdk.is_test_environment");
    }

    public static boolean e(com.applovin.impl.sdk.j jVar) {
        return ((Boolean) jVar.a(sj.f23111z2)).booleanValue() ? jVar.g0().isMuted() : ((Boolean) jVar.a(sj.f23095x2)).booleanValue();
    }

    public static int f() {
        return 2015001;
    }

    public static int f(String str) {
        int i11 = 0;
        for (String str2 : str.replaceAll("-beta", InstructionFileId.DOT).split("\\.")) {
            if (str2.length() > 2) {
                com.applovin.impl.sdk.n.h("Utils", "Version number components cannot be longer than two digits -> " + str);
                return i11;
            }
            i11 = (i11 * 100) + Integer.parseInt(str2);
        }
        return !str.contains("-beta") ? (i11 * 100) + 99 : i11;
    }

    public static boolean f(Context context) {
        if (f24706f == null) {
            f24706f = Boolean.valueOf("com.applovin.apps.dspdemo".equals(context.getPackageName()));
        }
        return f24706f.booleanValue();
    }

    public static Boolean g(Context context) {
        if (context == null) {
            return null;
        }
        Boolean bool = f24709i;
        if (bool != null) {
            return bool;
        }
        try {
            String strA = t0.a(context).a();
            String strB = b(context);
            if (strB == null) {
                return null;
            }
            if (strB.equals(strA)) {
                Boolean bool2 = Boolean.TRUE;
                f24709i = bool2;
                return bool2;
            }
            if (TextUtils.isEmpty(strA) && strB.equals(context.getPackageName())) {
                Boolean bool3 = Boolean.TRUE;
                f24709i = bool3;
                return bool3;
            }
            Boolean bool4 = Boolean.FALSE;
            f24709i = bool4;
            return bool4;
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.b("Utils", "Unable to determine if the current process is the main process", th2);
            return null;
        }
    }

    public static boolean g() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        try {
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("Utils", "Exception thrown while getting memory state.", th2);
        }
        int i11 = runningAppProcessInfo.importance;
        return i11 == 100 || i11 == 200;
    }

    public static boolean h() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean h(Context context) {
        if (f24707g == null) {
            f24707g = Boolean.valueOf("com.applovin.apps.playables".equals(context.getPackageName()));
        }
        return f24707g.booleanValue();
    }

    public static boolean i() {
        return !a("com.applovin.sdk.AppLovinSdk");
    }

    public static boolean i(Context context) {
        String packageName = context.getPackageName();
        return "com.revolverolver.fliptrickster".equals(packageName) || "com.mindstormstudios.idlemakeover".equals(packageName);
    }

    public static boolean j() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                String displayName = networkInterfaces.nextElement().getDisplayName();
                if (displayName.contains("tun") || displayName.contains("ppp") || displayName.contains("ipsec")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("Utils", "Unable to check Network Interfaces", th2);
            return false;
        }
    }

    public static boolean j(Context context) {
        if (context == null) {
            return false;
        }
        try {
            context.getResources();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean k() {
        Context contextL = com.applovin.impl.sdk.j.l();
        if (contextL != null) {
            return t0.a(contextL).a("applovin.sdk.verbose_logging");
        }
        return false;
    }

    public static boolean k(Context context) {
        if (context == null) {
            context = com.applovin.impl.sdk.j.l();
        }
        if (context != null) {
            return t0.a(context).a("applovin.sdk.verbose_logging", false);
        }
        return false;
    }

    public static String l(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (listQueryIntentActivities.isEmpty()) {
            return null;
        }
        return listQueryIntentActivities.get(0).activityInfo.name;
    }
}
