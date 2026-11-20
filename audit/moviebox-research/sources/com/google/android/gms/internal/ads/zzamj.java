package com.google.android.gms.internal.ads;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzamj {
    private static final Pattern zza = Pattern.compile("^NOTE([ \t].*)?$");

    public static float zza(String str) throws NumberFormatException {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long zzb(String str) throws NumberFormatException {
        int i11 = zzfy.zza;
        String[] strArrSplit = str.split("\\.", 2);
        long j11 = 0;
        for (String str2 : strArrSplit[0].split(":", -1)) {
            j11 = (j11 * 60) + Long.parseLong(str2);
        }
        long j12 = j11 * 1000;
        if (strArrSplit.length == 2) {
            j12 += Long.parseLong(strArrSplit[1]);
        }
        return j12 * 1000;
    }
}
