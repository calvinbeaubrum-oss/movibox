package com.google.android.gms.internal.ads;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzalk {
    public final String zza;
    public final int zzb;

    @Nullable
    public final Integer zzc;

    @Nullable
    public final Integer zzd;
    public final float zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final int zzj;

    private zzalk(String str, int i11, @Nullable Integer num, @Nullable Integer num2, float f11, boolean z11, boolean z12, boolean z13, boolean z14, int i12) {
        this.zza = str;
        this.zzb = i11;
        this.zzc = num;
        this.zzd = num2;
        this.zze = f11;
        this.zzf = z11;
        this.zzg = z12;
        this.zzh = z13;
        this.zzi = z14;
        this.zzj = i12;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0113, code lost:
    
        if (r4 != 3) goto L59;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzalk zzb(String str, zzali zzaliVar) {
        int i11;
        String strTrim;
        zzek.zzd(str.startsWith("Style:"));
        String[] strArrSplit = TextUtils.split(str.substring(6), ",");
        int length = strArrSplit.length;
        int i12 = zzaliVar.zzk;
        if (length != i12) {
            zzff.zzf("SsaStyle", String.format(Locale.US, "Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(i12), Integer.valueOf(length), str));
            return null;
        }
        try {
            String strTrim2 = strArrSplit[zzaliVar.zza].trim();
            int i13 = zzaliVar.zzb;
            int iZzd = i13 != -1 ? zzd(strArrSplit[i13].trim()) : -1;
            int i14 = zzaliVar.zzc;
            Integer numZzc = i14 != -1 ? zzc(strArrSplit[i14].trim()) : null;
            int i15 = zzaliVar.zzd;
            Integer numZzc2 = i15 != -1 ? zzc(strArrSplit[i15].trim()) : null;
            int i16 = zzaliVar.zze;
            float f11 = -3.4028235E38f;
            if (i16 != -1) {
                String strTrim3 = strArrSplit[i16].trim();
                try {
                    f11 = Float.parseFloat(strTrim3);
                } catch (NumberFormatException e11) {
                    zzff.zzg("SsaStyle", "Failed to parse font size: '" + strTrim3 + "'", e11);
                }
            }
            int i17 = zzaliVar.zzf;
            boolean z11 = i17 != -1 && zze(strArrSplit[i17].trim());
            int i18 = zzaliVar.zzg;
            boolean z12 = i18 != -1 && zze(strArrSplit[i18].trim());
            int i19 = zzaliVar.zzh;
            boolean z13 = i19 != -1 && zze(strArrSplit[i19].trim());
            int i21 = zzaliVar.zzi;
            boolean z14 = i21 != -1 && zze(strArrSplit[i21].trim());
            int i22 = zzaliVar.zzj;
            if (i22 != -1) {
                strTrim = strArrSplit[i22].trim();
                try {
                    i11 = Integer.parseInt(strTrim.trim());
                    if (i11 != 1) {
                    }
                } catch (NumberFormatException unused) {
                }
            } else {
                i11 = -1;
            }
            return new zzalk(strTrim2, iZzd, numZzc, numZzc2, f11, z11, z12, z13, z14, i11);
        } catch (RuntimeException e12) {
            zzff.zzg("SsaStyle", "Skipping malformed 'Style:' line: '" + str + "'", e12);
            return null;
        }
        zzff.zzf("SsaStyle", "Ignoring unknown BorderStyle: ".concat(String.valueOf(strTrim)));
        i11 = -1;
        return new zzalk(strTrim2, iZzd, numZzc, numZzc2, f11, z11, z12, z13, z14, i11);
    }

    @Nullable
    public static Integer zzc(String str) {
        try {
            long j11 = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            zzek.zzd(j11 <= 4294967295L);
            return Integer.valueOf(Color.argb(zzgcu.zza(((j11 >> 24) & 255) ^ 255), zzgcu.zza(j11 & 255), zzgcu.zza((j11 >> 8) & 255), zzgcu.zza((j11 >> 16) & 255)));
        } catch (IllegalArgumentException e11) {
            zzff.zzg("SsaStyle", "Failed to parse color expression: '" + str + "'", e11);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzd(String str) {
        try {
            int i11 = Integer.parseInt(str.trim());
            switch (i11) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    return i11;
                default:
                    zzff.zzf("SsaStyle", "Ignoring unknown alignment: ".concat(String.valueOf(str)));
                    return -1;
            }
        } catch (NumberFormatException unused) {
        }
    }

    private static boolean zze(String str) {
        try {
            int i11 = Integer.parseInt(str);
            return i11 == 1 || i11 == -1;
        } catch (NumberFormatException e11) {
            zzff.zzg("SsaStyle", "Failed to parse boolean value: '" + str + "'", e11);
            return false;
        }
    }
}
