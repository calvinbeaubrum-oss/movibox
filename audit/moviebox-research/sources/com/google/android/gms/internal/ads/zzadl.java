package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzadl {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final float zzh;

    @Nullable
    public final String zzi;

    private zzadl(List list, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, float f11, @Nullable String str) {
        this.zza = list;
        this.zzb = i11;
        this.zzc = i14;
        this.zzd = i15;
        this.zze = i16;
        this.zzf = i17;
        this.zzg = i18;
        this.zzh = f11;
        this.zzi = str;
    }

    public static zzadl zza(zzfp zzfpVar) throws zzcc {
        try {
            zzfpVar.zzL(21);
            int iZzm = zzfpVar.zzm() & 3;
            int iZzm2 = zzfpVar.zzm();
            int iZzd = zzfpVar.zzd();
            int i11 = 0;
            int i12 = 0;
            for (int i13 = 0; i13 < iZzm2; i13++) {
                zzfpVar.zzL(1);
                int iZzq = zzfpVar.zzq();
                for (int i14 = 0; i14 < iZzq; i14++) {
                    int iZzq2 = zzfpVar.zzq();
                    i12 += iZzq2 + 4;
                    zzfpVar.zzL(iZzq2);
                }
            }
            zzfpVar.zzK(iZzd);
            byte[] bArr = new byte[i12];
            String strZzb = null;
            int i15 = 0;
            int i16 = 0;
            int i17 = -1;
            int i18 = -1;
            int i19 = -1;
            int i21 = -1;
            int i22 = -1;
            int i23 = -1;
            int i24 = -1;
            float f11 = 1.0f;
            while (i15 < iZzm2) {
                int iZzm3 = zzfpVar.zzm() & 63;
                int iZzq3 = zzfpVar.zzq();
                int i25 = 0;
                while (i25 < iZzq3) {
                    int iZzq4 = zzfpVar.zzq();
                    int i26 = iZzm2;
                    System.arraycopy(zzgm.zza, i11, bArr, i16, 4);
                    int i27 = i16 + 4;
                    System.arraycopy(zzfpVar.zzM(), zzfpVar.zzd(), bArr, i27, iZzq4);
                    int i28 = i27 + iZzq4;
                    if (iZzm3 == 33 && i25 == 0) {
                        zzgj zzgjVarZzc = zzgm.zzc(bArr, i16 + 6, i28);
                        i17 = zzgjVarZzc.zzi;
                        i18 = zzgjVarZzc.zzj;
                        i19 = zzgjVarZzc.zze + 8;
                        i21 = zzgjVarZzc.zzf + 8;
                        int i29 = zzgjVarZzc.zzl;
                        int i31 = zzgjVarZzc.zzm;
                        int i32 = zzgjVarZzc.zzn;
                        float f12 = zzgjVarZzc.zzk;
                        strZzb = zzem.zzb(zzgjVarZzc.zza, zzgjVarZzc.zzb, zzgjVarZzc.zzc, zzgjVarZzc.zzd, zzgjVarZzc.zzg, zzgjVarZzc.zzh);
                        f11 = f12;
                        i22 = i29;
                        i23 = i31;
                        i24 = i32;
                        i25 = 0;
                    }
                    zzfpVar.zzL(iZzq4);
                    i25++;
                    iZzm2 = i26;
                    i16 = i28;
                    iZzm3 = iZzm3;
                    iZzq3 = iZzq3;
                    i11 = 0;
                }
                i15++;
                i11 = 0;
            }
            return new zzadl(i12 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), iZzm + 1, i17, i18, i19, i21, i22, i23, i24, f11, strZzb);
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw zzcc.zza("Error parsing HEVC config", e11);
        }
    }
}
