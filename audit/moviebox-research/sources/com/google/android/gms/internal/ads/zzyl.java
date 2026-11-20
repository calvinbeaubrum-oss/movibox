package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzyl extends zzyo {

    @Nullable
    private zzyk zza;

    public abstract Pair zzc(zzyk zzykVar, int[][][] iArr, int[] iArr2, zzur zzurVar, zzcx zzcxVar) throws zziz;

    @Override // com.google.android.gms.internal.ads.zzyo
    public final zzyp zzp(zzmh[] zzmhVarArr, zzws zzwsVar, zzur zzurVar, zzcx zzcxVar) throws zziz {
        boolean z11;
        int[] iArr;
        int[] iArr2 = new int[3];
        zzcz[][] zzczVarArr = new zzcz[3][];
        int[][][] iArr3 = new int[3][][];
        for (int i11 = 0; i11 < 3; i11++) {
            int i12 = zzwsVar.zzc;
            zzczVarArr[i11] = new zzcz[i12];
            iArr3[i11] = new int[i12][];
        }
        int i13 = 2;
        int[] iArr4 = new int[2];
        for (int i14 = 0; i14 < 2; i14++) {
            iArr4[i14] = zzmhVarArr[i14].zze();
        }
        int i15 = 0;
        while (i15 < zzwsVar.zzc) {
            zzcz zzczVarZzb = zzwsVar.zzb(i15);
            int i16 = zzczVarZzb.zzd;
            int i17 = 0;
            int i18 = 2;
            int i19 = 0;
            boolean z12 = true;
            while (i17 < i13) {
                zzmh zzmhVar = zzmhVarArr[i17];
                int iMax = 0;
                for (int i21 = 0; i21 <= 0; i21++) {
                    iMax = Math.max(iMax, zzmhVar.zzX(zzczVarZzb.zzb(i21)) & 7);
                }
                boolean z13 = iArr2[i17] == 0;
                if (iMax > i19) {
                    z12 = z13;
                    i18 = i17;
                    i19 = iMax;
                } else if (iMax == i19 && i16 == 5 && !z12 && z13) {
                    i18 = i17;
                    i19 = iMax;
                    z12 = true;
                }
                i17++;
                i13 = 2;
            }
            if (i18 == i13) {
                iArr = new int[1];
            } else {
                zzmh zzmhVar2 = zzmhVarArr[i18];
                int[] iArr5 = new int[1];
                for (int i22 = 0; i22 <= 0; i22++) {
                    iArr5[i22] = zzmhVar2.zzX(zzczVarZzb.zzb(i22));
                }
                iArr = iArr5;
            }
            int i23 = iArr2[i18];
            zzczVarArr[i18][i23] = zzczVarZzb;
            iArr3[i18][i23] = iArr;
            iArr2[i18] = i23 + 1;
            i15++;
            i13 = 2;
        }
        zzws[] zzwsVarArr = new zzws[i13];
        String[] strArr = new String[i13];
        int[] iArr6 = new int[i13];
        int i24 = 0;
        while (i24 < i13) {
            int i25 = iArr2[i24];
            zzwsVarArr[i24] = new zzws((zzcz[]) zzfy.zzL(zzczVarArr[i24], i25));
            iArr3[i24] = (int[][]) zzfy.zzL(iArr3[i24], i25);
            strArr[i24] = zzmhVarArr[i24].zzT();
            iArr6[i24] = zzmhVarArr[i24].zzbj();
            i24++;
            i13 = 2;
        }
        zzyk zzykVar = new zzyk(strArr, iArr6, zzwsVarArr, iArr4, iArr3, new zzws((zzcz[]) zzfy.zzL(zzczVarArr[2], iArr2[2])));
        Pair pairZzc = zzc(zzykVar, iArr3, iArr4, zzurVar, zzcxVar);
        zzym[] zzymVarArr = (zzym[]) pairZzc.second;
        List[] listArr = new List[zzymVarArr.length];
        for (int i26 = 0; i26 < zzymVarArr.length; i26++) {
            zzym zzymVar = zzymVarArr[i26];
            listArr[i26] = zzymVar != null ? zzgaa.zzm(zzymVar) : zzgaa.zzl();
        }
        zzfzx zzfzxVar = new zzfzx();
        int i27 = 0;
        for (int i28 = 2; i27 < i28; i28 = 2) {
            zzws zzwsVarZzd = zzykVar.zzd(i27);
            List list = listArr[i27];
            for (int i29 = 0; i29 < zzwsVarZzd.zzc; i29++) {
                zzcz zzczVarZzb2 = zzwsVarZzd.zzb(i29);
                boolean z14 = zzykVar.zza(i27, i29, false) != 0;
                int i31 = zzczVarZzb2.zzb;
                int[] iArr7 = new int[1];
                boolean[] zArr = new boolean[1];
                for (int i32 = 0; i32 <= 0; i32++) {
                    iArr7[i32] = zzykVar.zzb(i27, i29, i32) & 7;
                    int i33 = 0;
                    while (true) {
                        if (i33 >= list.size()) {
                            z11 = false;
                            break;
                        }
                        zzym zzymVar2 = (zzym) list.get(i33);
                        if (zzymVar2.zze().equals(zzczVarZzb2) && zzymVar2.zzb(i32) != -1) {
                            z11 = true;
                            break;
                        }
                        i33++;
                    }
                    zArr[i32] = z11;
                }
                zzfzxVar.zzf(new zzdj(zzczVarZzb2, z14, iArr7, zArr));
            }
            i27++;
        }
        zzws zzwsVarZze = zzykVar.zze();
        for (int i34 = 0; i34 < zzwsVarZze.zzc; i34++) {
            zzcz zzczVarZzb3 = zzwsVarZze.zzb(i34);
            int i35 = zzczVarZzb3.zzb;
            int[] iArr8 = new int[1];
            Arrays.fill(iArr8, 0);
            zzfzxVar.zzf(new zzdj(zzczVarZzb3, false, iArr8, new boolean[1]));
        }
        return new zzyp((zzmi[]) pairZzc.first, (zzyi[]) pairZzc.second, new zzdk(zzfzxVar.zzi()), zzykVar);
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final void zzq(@Nullable Object obj) {
        this.zza = (zzyk) obj;
    }
}
