package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import androidx.annotation.Keep;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.transsion.push.PushConstants;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ConfigFetchHttpClient {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Pattern f41061h = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f41062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f41063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f41064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f41065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f41066e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f41067f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f41068g;

    public ConfigFetchHttpClient(Context context, String str, String str2, String str3, long j11, long j12) {
        this.f41062a = context;
        this.f41063b = str;
        this.f41064c = str2;
        this.f41065d = f(str);
        this.f41066e = str3;
        this.f41067f = j11;
        this.f41068g = j12;
    }

    public static a e(JSONObject jSONObject, Date date) throws FirebaseRemoteConfigClientException {
        JSONObject jSONObject2;
        JSONArray jSONArray;
        try {
            a.b bVarD = a.g().d(date);
            JSONObject jSONObject3 = null;
            try {
                jSONObject2 = jSONObject.getJSONObject("entries");
            } catch (JSONException unused) {
                jSONObject2 = null;
            }
            if (jSONObject2 != null) {
                bVarD = bVarD.b(jSONObject2);
            }
            try {
                jSONArray = jSONObject.getJSONArray("experimentDescriptions");
            } catch (JSONException unused2) {
                jSONArray = null;
            }
            if (jSONArray != null) {
                bVarD = bVarD.c(jSONArray);
            }
            try {
                jSONObject3 = jSONObject.getJSONObject("personalizationMetadata");
            } catch (JSONException unused3) {
            }
            if (jSONObject3 != null) {
                bVarD = bVarD.e(jSONObject3);
            }
            return bVarD.a();
        } catch (JSONException e11) {
            throw new FirebaseRemoteConfigClientException("Fetch failed: fetch response could not be parsed.", e11);
        }
    }

    public static String f(String str) {
        Matcher matcher = f41061h.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    public final boolean a(JSONObject jSONObject) {
        try {
            return !jSONObject.get("state").equals("NO_CHANGE");
        } catch (JSONException unused) {
            return true;
        }
    }

    public final String b(long j11) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(Long.valueOf(j11));
    }

    public final JSONObject c(String str, String str2, Map<String, String> map, Long l11) throws FirebaseRemoteConfigClientException {
        HashMap map2 = new HashMap();
        if (str == null) {
            throw new FirebaseRemoteConfigClientException("Fetch failed: Firebase installation id is null.");
        }
        map2.put("appInstanceId", str);
        map2.put("appInstanceIdToken", str2);
        map2.put(PushConstants.PROVIDER_FIELD_APP_ID, this.f41063b);
        Locale locale = this.f41062a.getResources().getConfiguration().locale;
        map2.put("countryCode", locale.getCountry());
        int i11 = Build.VERSION.SDK_INT;
        map2.put("languageCode", locale.toLanguageTag());
        map2.put("platformVersion", Integer.toString(i11));
        map2.put("timeZone", TimeZone.getDefault().getID());
        try {
            PackageInfo packageInfo = this.f41062a.getPackageManager().getPackageInfo(this.f41062a.getPackageName(), 0);
            if (packageInfo != null) {
                map2.put("appVersion", packageInfo.versionName);
                map2.put("appBuild", Long.toString(a3.a.a(packageInfo)));
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        map2.put("packageName", this.f41062a.getPackageName());
        map2.put(PushConstants.PROVIDER_FIELD_SDK_VERSION, "21.2.1");
        map2.put("analyticsUserProperties", new JSONObject(map));
        if (l11 != null) {
            map2.put("firstOpenTime", b(l11.longValue()));
        }
        return new JSONObject(map2);
    }

    public HttpURLConnection d() throws FirebaseRemoteConfigException {
        try {
            return (HttpURLConnection) new URL(h(this.f41065d, this.f41066e)).openConnection();
        } catch (IOException e11) {
            throw new FirebaseRemoteConfigException(e11.getMessage());
        }
    }

    @Keep
    public b.a fetch(HttpURLConnection httpURLConnection, String str, String str2, Map<String, String> map, String str3, Map<String, String> map2, Long l11, Date date) throws FirebaseRemoteConfigException {
        m(httpURLConnection, str3, str2, map2);
        try {
            try {
                l(httpURLConnection, c(str, str2, map, l11).toString().getBytes("utf-8"));
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    throw new FirebaseRemoteConfigServerException(responseCode, httpURLConnection.getResponseMessage());
                }
                String headerField = httpURLConnection.getHeaderField("ETag");
                JSONObject jSONObjectG = g(httpURLConnection);
                httpURLConnection.disconnect();
                try {
                    httpURLConnection.getInputStream().close();
                } catch (IOException unused) {
                }
                return !a(jSONObjectG) ? b.a.a(date) : b.a.b(e(jSONObjectG, date), headerField);
            } catch (Throwable th2) {
                httpURLConnection.disconnect();
                try {
                    httpURLConnection.getInputStream().close();
                } catch (IOException unused2) {
                }
                throw th2;
            }
        } catch (IOException | JSONException e11) {
            throw new FirebaseRemoteConfigClientException("The client had an error while calling the backend!", e11);
        }
    }

    public final JSONObject g(URLConnection uRLConnection) throws JSONException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uRLConnection.getInputStream(), "utf-8"));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            int i11 = bufferedReader.read();
            if (i11 == -1) {
                return new JSONObject(sb2.toString());
            }
            sb2.append((char) i11);
        }
    }

    public final String h(String str, String str2) {
        return String.format("https://firebaseremoteconfig.googleapis.com/v1/projects/%s/namespaces/%s:fetch", str, str2);
    }

    public final String i() {
        try {
            Context context = this.f41062a;
            byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context, context.getPackageName());
            if (packageCertificateHashBytes != null) {
                return Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
            }
            Log.e("FirebaseRemoteConfig", "Could not get fingerprint hash for package: " + this.f41062a.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException e11) {
            Log.e("FirebaseRemoteConfig", "No such package: " + this.f41062a.getPackageName(), e11);
            return null;
        }
    }

    public final void j(HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setRequestProperty("X-Goog-Api-Key", this.f41064c);
        httpURLConnection.setRequestProperty("X-Android-Package", this.f41062a.getPackageName());
        httpURLConnection.setRequestProperty("X-Android-Cert", i());
        httpURLConnection.setRequestProperty("X-Google-GFE-Can-Retry", "yes");
        httpURLConnection.setRequestProperty("X-Goog-Firebase-Installations-Auth", str);
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
        httpURLConnection.setRequestProperty("Accept", "application/json");
    }

    public final void k(HttpURLConnection httpURLConnection, Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public final void l(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
        bufferedOutputStream.write(bArr);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    public final void m(HttpURLConnection httpURLConnection, String str, String str2, Map<String, String> map) {
        httpURLConnection.setDoOutput(true);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        httpURLConnection.setConnectTimeout((int) timeUnit.toMillis(this.f41067f));
        httpURLConnection.setReadTimeout((int) timeUnit.toMillis(this.f41068g));
        httpURLConnection.setRequestProperty("If-None-Match", str);
        j(httpURLConnection, str2);
        k(httpURLConnection, map);
    }
}
