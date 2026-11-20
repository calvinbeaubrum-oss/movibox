package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzalg {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;

    private zzalg(int i11, int i12, int i13, int i14, int i15) {
        this.zza = i11;
        this.zzb = i12;
        this.zzc = i13;
        this.zzd = i14;
        this.zze = i15;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x005b  */
    @Nullable
    public static zzalg zza(String str) {
        byte b11;
        zzek.zzd(str.startsWith("Format:"));
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i11 = 0;
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        int i15 = -1;
        while (true) {
            int length = strArrSplit.length;
            if (i11 >= length) {
                if (i12 == -1 || i13 == -1 || i15 == -1) {
                    return null;
                }
                return new zzalg(i12, i13, i14, i15, length);
            }
            switch (zzfwk.zza(strArrSplit[i11].trim())) {
                case "end":
                    b11 = 1;
                    break;
                case "text":
                    b11 = 3;
                    break;
                case "start":
                    b11 = 0;
                    break;
                case "style":
                    b11 = 2;
                    break;
                default:
                    b11 = -1;
                    break;
            }
            if (b11 == 0) {
                i12 = i11;
            } else if (b11 == 1) {
                i13 = i11;
            } else if (b11 == 2) {
                i14 = i11;
            } else if (b11 == 3) {
                i15 = i11;
            }
            i11++;
        }
    }
}
