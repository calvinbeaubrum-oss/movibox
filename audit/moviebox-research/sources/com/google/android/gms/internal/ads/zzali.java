package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzali {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final int zzk;

    private zzali(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21, int i22) {
        this.zza = i11;
        this.zzb = i12;
        this.zzc = i13;
        this.zzd = i14;
        this.zze = i15;
        this.zzf = i16;
        this.zzg = i17;
        this.zzh = i18;
        this.zzi = i19;
        this.zzj = i21;
        this.zzk = i22;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:38:0x0096  */
    @Nullable
    public static zzali zza(String str) {
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i11 = 0;
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        int i15 = -1;
        int i16 = -1;
        int i17 = -1;
        int i18 = -1;
        int i19 = -1;
        int i21 = -1;
        int i22 = -1;
        while (true) {
            int length = strArrSplit.length;
            if (i11 >= length) {
                if (i12 != -1) {
                    return new zzali(i12, i13, i14, i15, i16, i17, i18, i19, i21, i22, length);
                }
                return null;
            }
            switch (zzfwk.zza(strArrSplit[i11].trim())) {
                case "name":
                    i12 = i11;
                    break;
                case "alignment":
                    i13 = i11;
                    break;
                case "primarycolour":
                    i14 = i11;
                    break;
                case "outlinecolour":
                    i15 = i11;
                    break;
                case "fontsize":
                    i16 = i11;
                    break;
                case "bold":
                    i17 = i11;
                    break;
                case "italic":
                    i18 = i11;
                    break;
                case "underline":
                    i19 = i11;
                    break;
                case "strikeout":
                    i21 = i11;
                    break;
                case "borderstyle":
                    i22 = i11;
                    break;
            }
            i11++;
        }
    }
}
