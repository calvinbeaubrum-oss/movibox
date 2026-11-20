package com.google.firebase.perf.util;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f41036a;

    public static void a(boolean z11, String str) {
        if (!z11) {
            throw new IllegalArgumentException(str);
        }
    }

    public static boolean b(@NonNull Context context) {
        Boolean bool = f41036a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean boolValueOf = Boolean.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("firebase_performance_logcat_enabled", false));
            f41036a = boolValueOf;
            return boolValueOf.booleanValue();
        } catch (PackageManager.NameNotFoundException | NullPointerException e11) {
            ql.a.e().a("No perf logcat meta data found " + e11.getMessage());
            return false;
        }
    }

    public static int c(long j11) {
        if (j11 > 2147483647L) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if (j11 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j11;
    }

    public static String d(@NonNull String str) {
        HttpUrl httpUrl = HttpUrl.parse(str);
        return httpUrl != null ? httpUrl.newBuilder().username("").password("").query(null).fragment(null).toString() : str;
    }

    public static String e(String str, int i11) {
        HttpUrl httpUrl;
        int iLastIndexOf;
        if (str.length() <= i11) {
            return str;
        }
        if (str.charAt(i11) != '/' && (httpUrl = HttpUrl.parse(str)) != null) {
            return (httpUrl.encodedPath().lastIndexOf(47) < 0 || (iLastIndexOf = str.lastIndexOf(47, i11 + (-1))) < 0) ? str.substring(0, i11) : str.substring(0, iLastIndexOf);
        }
        return str.substring(0, i11);
    }
}
