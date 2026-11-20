package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f40668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f40669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Long> f40670c = new androidx.collection.a();

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final long f40671d = TimeUnit.DAYS.toMillis(7);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f40672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f40673b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f40674c;

        public a(String str, String str2, long j11) {
            this.f40672a = str;
            this.f40673b = str2;
            this.f40674c = j11;
        }

        public static String a(String str, String str2, long j11) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", str);
                jSONObject.put("appVersion", str2);
                jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, j11);
                return jSONObject.toString();
            } catch (JSONException e11) {
                String strValueOf = String.valueOf(e11);
                StringBuilder sb2 = new StringBuilder(strValueOf.length() + 24);
                sb2.append("Failed to encode token: ");
                sb2.append(strValueOf);
                Log.w("FirebaseInstanceId", sb2.toString());
                return null;
            }
        }

        public static String b(@Nullable a aVar) {
            if (aVar == null) {
                return null;
            }
            return aVar.f40672a;
        }

        public static a d(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("{")) {
                return new a(str, null, 0L);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new a(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong(CampaignEx.JSON_KEY_TIMESTAMP));
            } catch (JSONException e11) {
                String strValueOf = String.valueOf(e11);
                StringBuilder sb2 = new StringBuilder(strValueOf.length() + 23);
                sb2.append("Failed to parse token: ");
                sb2.append(strValueOf);
                Log.w("FirebaseInstanceId", sb2.toString());
                return null;
            }
        }

        public boolean c(String str) {
            return System.currentTimeMillis() > this.f40674c + f40671d || !str.equals(this.f40673b);
        }
    }

    public u(Context context) {
        this.f40669b = context;
        this.f40668a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        a("com.google.android.gms.appid-no-backup");
    }

    public static String b(String str, String str2) {
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 6);
        sb2.append(str);
        sb2.append("|S|cre");
        return sb2.toString();
    }

    public final void a(String str) {
        File file = new File(z2.a.getNoBackupFilesDir(this.f40669b), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || g()) {
                return;
            }
            d();
        } catch (IOException e11) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String strValueOf = String.valueOf(e11.getMessage());
                if (strValueOf.length() != 0) {
                    "Error creating file in no backup dir: ".concat(strValueOf);
                }
            }
        }
    }

    public final String c(String str, String str2, String str3) {
        int length = String.valueOf(str).length();
        StringBuilder sb2 = new StringBuilder(length + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb2.append(str);
        sb2.append("|T|");
        sb2.append(str2);
        sb2.append("|");
        sb2.append(str3);
        return sb2.toString();
    }

    public synchronized void d() {
        this.f40670c.clear();
        this.f40668a.edit().clear().commit();
    }

    public final long e(String str) {
        String string = this.f40668a.getString(b(str, "cre"), null);
        if (string == null) {
            return 0L;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    public synchronized a f(String str, String str2, String str3) {
        return a.d(this.f40668a.getString(c(str, str2, str3), null));
    }

    public synchronized boolean g() {
        return this.f40668a.getAll().isEmpty();
    }

    public synchronized void h(String str, String str2, String str3, String str4, String str5) {
        String strA = a.a(str4, str5, System.currentTimeMillis());
        if (strA == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.f40668a.edit();
        editorEdit.putString(c(str, str2, str3), strA);
        editorEdit.commit();
    }

    public synchronized long i(String str) {
        long j11;
        j11 = j(str);
        this.f40670c.put(str, Long.valueOf(j11));
        return j11;
    }

    public final long j(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.f40668a.contains(b(str, "cre"))) {
            return e(str);
        }
        SharedPreferences.Editor editorEdit = this.f40668a.edit();
        editorEdit.putString(b(str, "cre"), String.valueOf(jCurrentTimeMillis));
        editorEdit.commit();
        return jCurrentTimeMillis;
    }
}
