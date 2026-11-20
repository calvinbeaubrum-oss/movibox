package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzyk {
    private final String[] zza;
    private final int[] zzb;
    private final zzws[] zzc;
    private final int[] zzd;
    private final int[][][] zze;
    private final zzws zzf;

    public zzyk(String[] strArr, int[] iArr, zzws[] zzwsVarArr, int[] iArr2, int[][][] iArr3, zzws zzwsVar) {
        this.zza = strArr;
        this.zzb = iArr;
        this.zzc = zzwsVarArr;
        this.zze = iArr3;
        this.zzd = iArr2;
        this.zzf = zzwsVar;
    }

    public final int zza(int i11, int i12, boolean z11) {
        int i13 = this.zzc[i11].zzb(i12).zzb;
        int[] iArr = new int[1];
        int i14 = 0;
        int i15 = 0;
        for (char c11 = 0; c11 <= 0; c11 = 1) {
            if ((this.zze[i11][i12][0] & 7) == 4) {
                iArr[i15] = 0;
                i15++;
            }
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, i15);
        String str = null;
        boolean z12 = false;
        int i16 = 0;
        int iMin = 16;
        while (i14 < iArrCopyOf.length) {
            String str2 = this.zzc[i11].zzb(i12).zzb(iArrCopyOf[i14]).zzm;
            int i17 = i16 + 1;
            if (i16 == 0) {
                str = str2;
            } else {
                z12 |= !zzfy.zzF(str, str2);
            }
            iMin = Math.min(iMin, this.zze[i11][i12][i14] & 24);
            i14++;
            i16 = i17;
        }
        return z12 ? Math.min(iMin, this.zzd[i11]) : iMin;
    }

    public final int zzb(int i11, int i12, int i13) {
        return this.zze[i11][i12][i13];
    }

    public final int zzc(int i11) {
        return this.zzb[i11];
    }

    public final zzws zzd(int i11) {
        return this.zzc[i11];
    }

    public final zzws zze() {
        return this.zzf;
    }
}
