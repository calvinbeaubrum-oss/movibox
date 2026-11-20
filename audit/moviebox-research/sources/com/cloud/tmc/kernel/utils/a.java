package com.cloud.tmc.kernel.utils;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.log.TmcLogger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    public static Bundle a(Bundle bundle) {
        return bundle == null ? new Bundle() : (Bundle) bundle.clone();
    }

    public static boolean b(Bundle bundle, String str, boolean z11) {
        return ((Boolean) g(bundle, str, Boolean.valueOf(z11))).booleanValue();
    }

    public static long c(Bundle bundle, String str, long j11) {
        Long l11;
        if (bundle != null) {
            try {
                return (TextUtils.isEmpty(str) || !bundle.containsKey(str) || (l11 = (Long) bundle.get(str)) == null) ? j11 : l11.longValue();
            } catch (Exception e11) {
                TmcLogger.h("get json value exception", e11);
            }
        }
        return j11;
    }

    public static <T extends Parcelable> T d(Bundle bundle, @Nullable String str) {
        if (bundle != null && !TextUtils.isEmpty(str)) {
            try {
                return (T) bundle.getParcelable(str);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String e(Bundle bundle, String str) {
        return f(bundle, str, "");
    }

    public static String f(Bundle bundle, String str, String str2) {
        String str3;
        if (str2 == null) {
            str2 = "";
        }
        if (bundle != null) {
            try {
                if (!TextUtils.isEmpty(str) && bundle.containsKey(str) && (str3 = (String) bundle.get(str)) != null) {
                    return str3;
                }
            } catch (Exception e11) {
                TmcLogger.h("get json value exception", e11);
            }
        }
        return str2;
    }

    public static <T> T g(Bundle bundle, String str, T t11) {
        T t12;
        if (bundle != null) {
            try {
                return (TextUtils.isEmpty(str) || t11 == null || !bundle.containsKey(str) || (t12 = (T) bundle.get(str)) == null || !t11.getClass().isAssignableFrom(t12.getClass())) ? t11 : t12;
            } catch (Exception e11) {
                TmcLogger.h("get json value exception", e11);
            }
        }
        return t11;
    }
}
