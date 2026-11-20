package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhu {
    private static final Pattern zza = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");
    private static final Pattern zzb = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");

    public static long zza(@Nullable String str, @Nullable String str2) {
        long j11 = -1;
        if (!TextUtils.isEmpty(str)) {
            try {
                j11 = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                zzff.zzc("HttpUtil", "Unexpected Content-Length [" + str + "]");
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return j11;
        }
        Matcher matcher = zza.matcher(str2);
        if (!matcher.matches()) {
            return j11;
        }
        try {
            String strGroup = matcher.group(2);
            strGroup.getClass();
            long j12 = Long.parseLong(strGroup);
            String strGroup2 = matcher.group(1);
            strGroup2.getClass();
            long j13 = (j12 - Long.parseLong(strGroup2)) + 1;
            if (j11 < 0) {
                return j13;
            }
            if (j11 == j13) {
                return j11;
            }
            zzff.zzf("HttpUtil", "Inconsistent headers [" + str + "] [" + str2 + "]");
            return Math.max(j11, j13);
        } catch (NumberFormatException unused2) {
            zzff.zzc("HttpUtil", "Unexpected Content-Range [" + str2 + "]");
            return j11;
        }
    }

    public static long zzb(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        Matcher matcher = zzb.matcher(str);
        if (!matcher.matches()) {
            return -1L;
        }
        String strGroup = matcher.group(1);
        strGroup.getClass();
        return Long.parseLong(strGroup);
    }
}
