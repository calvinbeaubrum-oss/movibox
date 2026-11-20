package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class o implements p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f40229g = Pattern.compile("[^\\p{Alnum}]");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f40230h = Pattern.quote("/");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f40231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f40232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f40233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final cl.g f40234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f40235e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f40236f;

    public o(Context context, String str, cl.g gVar, m mVar) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        this.f40232b = context;
        this.f40233c = str;
        this.f40234d = gVar;
        this.f40235e = mVar;
        this.f40231a = new q();
    }

    public static String c() {
        return "SYN_" + UUID.randomUUID().toString();
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        return f40229g.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    public static boolean k(String str) {
        return str != null && str.startsWith("SYN_");
    }

    @Override // com.google.firebase.crashlytics.internal.common.p
    @NonNull
    public synchronized String a() {
        try {
            String str = this.f40236f;
            if (str != null) {
                return str;
            }
            gk.f.f().i("Determining Crashlytics installation ID...");
            SharedPreferences sharedPreferencesR = CommonUtils.r(this.f40232b);
            String string = sharedPreferencesR.getString("firebase.installation.id", null);
            gk.f.f().i("Cached Firebase Installation ID: " + string);
            if (this.f40235e.d()) {
                String strD = d();
                gk.f.f().i("Fetched Firebase Installation ID: " + strD);
                if (strD == null) {
                    strD = string == null ? c() : string;
                }
                if (strD.equals(string)) {
                    this.f40236f = l(sharedPreferencesR);
                } else {
                    this.f40236f = b(strD, sharedPreferencesR);
                }
            } else if (k(string)) {
                this.f40236f = l(sharedPreferencesR);
            } else {
                this.f40236f = b(c(), sharedPreferencesR);
            }
            if (this.f40236f == null) {
                gk.f.f().k("Unable to determine Crashlytics Install Id, creating a new one.");
                this.f40236f = b(c(), sharedPreferencesR);
            }
            gk.f.f().i("Crashlytics installation ID: " + this.f40236f);
            return this.f40236f;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @NonNull
    public final synchronized String b(String str, SharedPreferences sharedPreferences) {
        String strE;
        strE = e(UUID.randomUUID().toString());
        gk.f.f().i("Created new Crashlytics installation ID: " + strE + " for FID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", strE).putString("firebase.installation.id", str).apply();
        return strE;
    }

    @Nullable
    public final String d() {
        try {
            return (String) Utils.d(this.f40234d.getId());
        } catch (Exception e11) {
            gk.f.f().l("Failed to retrieve Firebase Installations ID.", e11);
            return null;
        }
    }

    public String f() {
        return this.f40233c;
    }

    public String g() {
        return this.f40231a.a(this.f40232b);
    }

    public String h() {
        return String.format(Locale.US, "%s/%s", m(Build.MANUFACTURER), m(Build.MODEL));
    }

    public String i() {
        return m(Build.VERSION.INCREMENTAL);
    }

    public String j() {
        return m(Build.VERSION.RELEASE);
    }

    public final String l(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("crashlytics.installation.id", null);
    }

    public final String m(String str) {
        return str.replaceAll(f40230h, "");
    }
}
