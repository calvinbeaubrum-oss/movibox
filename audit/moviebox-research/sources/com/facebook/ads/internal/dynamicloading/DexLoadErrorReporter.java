package com.facebook.ads.internal.dynamicloading;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class DexLoadErrorReporter {
    public static final double SAMPLING = 0.1d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f32403a = new AtomicBoolean();

    public static void b(Context context, JSONObject jSONObject, String str) throws JSONException, PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        jSONObject.put("APPBUILD", context.getPackageManager().getPackageInfo(packageName, 0).versionCode);
        jSONObject.put("APPNAME", context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(packageName, 0)));
        jSONObject.put("APPVERS", context.getPackageManager().getPackageInfo(packageName, 0).versionName);
        jSONObject.put("OSVERS", Build.VERSION.RELEASE);
        jSONObject.put("SDK", "android");
        jSONObject.put("SESSION_ID", str);
        jSONObject.put("MODEL", Build.MODEL);
        jSONObject.put("BUNDLE", packageName);
        jSONObject.put("SDK_VERSION", BuildConfigApi.getVersionName(context));
        jSONObject.put("OS", "Android");
    }

    @SuppressLint({"CatchGeneralException"})
    public static void reportDexLoadingIssue(final Context context, final String str, double d11) {
        AtomicBoolean atomicBoolean = f32403a;
        if (atomicBoolean.get() || Math.random() >= d11) {
            return;
        }
        atomicBoolean.set(true);
        new Thread() { // from class: com.facebook.ads.internal.dynamicloading.DexLoadErrorReporter.1
            /* JADX WARN: Code duplicated, block: B:69:0x0173 A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:79:0x017e A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:86:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                DataOutputStream dataOutputStream;
                InputStream inputStream;
                HttpURLConnection httpURLConnection;
                super.run();
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL("https://www.facebook.com/adnw_logging/").openConnection()));
                    try {
                        httpURLConnection2.setRequestMethod("POST");
                        httpURLConnection2.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=UTF-8");
                        httpURLConnection2.setRequestProperty("Accept", "application/json");
                        httpURLConnection2.setRequestProperty("Accept-Charset", "UTF-8");
                        httpURLConnection2.setRequestProperty("user-agent", "[FBAN/AudienceNetworkForAndroid;FBSN/Android]");
                        httpURLConnection2.setDoOutput(true);
                        httpURLConnection2.setDoInput(true);
                        httpURLConnection2.connect();
                        String string = UUID.randomUUID().toString();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("attempt", "0");
                        DexLoadErrorReporter.b(context, jSONObject, string);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("subtype", "generic");
                        jSONObject2.put("subtype_code", "1320");
                        jSONObject2.put("caught_exception", "1");
                        jSONObject2.put("stacktrace", str);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("id", UUID.randomUUID().toString());
                        jSONObject3.put("type", "debug");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("");
                        httpURLConnection = httpURLConnection2;
                        try {
                            sb2.append(System.currentTimeMillis() / 1000);
                            jSONObject3.put("session_time", sb2.toString());
                            jSONObject3.put("time", "" + (System.currentTimeMillis() / 1000));
                            jSONObject3.put("session_id", string);
                            jSONObject3.put("data", jSONObject2);
                            jSONObject3.put("attempt", "0");
                            DexLoadErrorReporter.b(context, jSONObject2, string);
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(jSONObject3);
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("data", jSONObject);
                            jSONObject4.put("events", jSONArray);
                            String string2 = jSONObject4.toString();
                            DataOutputStream dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                            try {
                                dataOutputStream2.writeBytes("payload=" + URLEncoder.encode(string2, "UTF-8"));
                                dataOutputStream2.flush();
                                byte[] bArr = new byte[16384];
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                InputStream inputStream2 = httpURLConnection.getInputStream();
                                while (true) {
                                    try {
                                        int i11 = inputStream2.read(bArr);
                                        if (i11 == -1) {
                                            break;
                                        } else {
                                            byteArrayOutputStream.write(bArr, 0, i11);
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        inputStream = inputStream2;
                                        dataOutputStream = dataOutputStream2;
                                        try {
                                            Log.e(AudienceNetworkAds.TAG, "Can't send error.", th);
                                        } finally {
                                            if (dataOutputStream != null) {
                                                try {
                                                    dataOutputStream.close();
                                                } catch (Exception e11) {
                                                    Log.e(AudienceNetworkAds.TAG, "Can't close connection.", e11);
                                                }
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Exception e12) {
                                                    Log.e(AudienceNetworkAds.TAG, "Can't close connection.", e12);
                                                }
                                            }
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                        }
                                    }
                                }
                                byteArrayOutputStream.flush();
                                try {
                                    dataOutputStream2.close();
                                } catch (Exception e13) {
                                    Log.e(AudienceNetworkAds.TAG, "Can't close connection.", e13);
                                }
                                try {
                                    inputStream2.close();
                                } catch (Exception e14) {
                                    Log.e(AudienceNetworkAds.TAG, "Can't close connection.", e14);
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                dataOutputStream = dataOutputStream2;
                                inputStream = null;
                                Log.e(AudienceNetworkAds.TAG, "Can't send error.", th);
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            dataOutputStream = null;
                            inputStream = null;
                            Log.e(AudienceNetworkAds.TAG, "Can't send error.", th);
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        httpURLConnection = httpURLConnection2;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    dataOutputStream = null;
                    inputStream = null;
                    httpURLConnection = null;
                }
            }
        }.start();
    }
}
