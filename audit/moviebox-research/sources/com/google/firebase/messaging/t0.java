package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f40925a;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final long f40926d = TimeUnit.DAYS.toMillis(7);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f40927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f40928b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f40929c;

        public a(String str, String str2, long j11) {
            this.f40927a = str;
            this.f40928b = str2;
            this.f40929c = j11;
        }

        public static String a(String str, String str2, long j11) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", str);
                jSONObject.put("appVersion", str2);
                jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, j11);
                return jSONObject.toString();
            } catch (JSONException e11) {
                Log.w("FirebaseMessaging", "Failed to encode token: " + e11);
                return null;
            }
        }

        public static a c(String str) {
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
                Log.w("FirebaseMessaging", "Failed to parse token: " + e11);
                return null;
            }
        }

        public boolean b(String str) {
            return System.currentTimeMillis() > this.f40929c + f40926d || !str.equals(this.f40928b);
        }
    }

    public t0(Context context) {
        this.f40925a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        a(context, "com.google.android.gms.appid-no-backup");
    }

    public final void a(Context context, String str) {
        File file = new File(z2.a.getNoBackupFilesDir(context), str);
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || e()) {
                return;
            }
            c();
        } catch (IOException e11) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error creating file in no backup dir: ");
                sb2.append(e11.getMessage());
            }
        }
    }

    public final String b(String str, String str2) {
        return str + "|T|" + str2 + "|*";
    }

    public synchronized void c() {
        this.f40925a.edit().clear().commit();
    }

    public synchronized a d(String str, String str2) {
        return a.c(this.f40925a.getString(b(str, str2), null));
    }

    public synchronized boolean e() {
        return this.f40925a.getAll().isEmpty();
    }

    public synchronized void f(String str, String str2, String str3, String str4) {
        String strA = a.a(str3, str4, System.currentTimeMillis());
        if (strA == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.f40925a.edit();
        editorEdit.putString(b(str, str2), strA);
        editorEdit.commit();
    }
}
