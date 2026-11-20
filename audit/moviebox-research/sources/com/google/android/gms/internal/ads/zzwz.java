package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzwz extends zzxb {
    private final zzyw zzd;
    private final zzgaa zze;
    private final zzel zzf;

    public zzwz(zzcz zzczVar, int[] iArr, int i11, zzyw zzywVar, long j11, long j12, long j13, int i12, int i13, float f11, float f12, List list, zzel zzelVar) {
        super(zzczVar, iArr, 0);
        this.zzd = zzywVar;
        this.zze = zzgaa.zzj(list);
        this.zzf = zzelVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* bridge */ /* synthetic */ zzgaa zzf(zzyh[] zzyhVarArr) {
        int i11;
        int i12;
        ArrayList arrayList = new ArrayList();
        char c11 = 0;
        int i13 = 0;
        while (true) {
            i11 = 2;
            i12 = 1;
            if (i13 >= 2) {
                break;
            }
            zzyh zzyhVar = zzyhVarArr[i13];
            if (zzyhVar == null || zzyhVar.zzb.length <= 1) {
                arrayList.add(null);
            } else {
                zzfzx zzfzxVar = new zzfzx();
                zzfzxVar.zzf(new zzwx(0L, 0L));
                arrayList.add(zzfzxVar);
            }
            i13++;
        }
        long[][] jArr = new long[2][];
        for (int i14 = 0; i14 < 2; i14++) {
            zzyh zzyhVar2 = zzyhVarArr[i14];
            if (zzyhVar2 == null) {
                jArr[i14] = new long[0];
            } else {
                jArr[i14] = new long[zzyhVar2.zzb.length];
                int i15 = 0;
                while (true) {
                    int[] iArr = zzyhVar2.zzb;
                    if (i15 >= iArr.length) {
                        break;
                    }
                    long j11 = zzyhVar2.zza.zzb(iArr[i15]).zzi;
                    long[] jArr2 = jArr[i14];
                    if (j11 == -1) {
                        j11 = 0;
                    }
                    jArr2[i15] = j11;
                    i15++;
                }
                Arrays.sort(jArr[i14]);
            }
        }
        int[] iArr2 = new int[2];
        long[] jArr3 = new long[2];
        for (int i16 = 0; i16 < 2; i16++) {
            long[] jArr4 = jArr[i16];
            jArr3[i16] = jArr4.length == 0 ? 0L : jArr4[0];
        }
        zzg(arrayList, jArr3);
        zzgal zzgalVarZza = zzgbe.zzc(zzgbj.zzc()).zzb(2).zza();
        int i17 = 0;
        while (i17 < i11) {
            int length = jArr[i17].length;
            if (length > i12) {
                double[] dArr = new double[length];
                int i18 = 0;
                while (true) {
                    long[] jArr5 = jArr[i17];
                    double dLog = 0.0d;
                    if (i18 >= jArr5.length) {
                        break;
                    }
                    long j12 = jArr5[i18];
                    if (j12 != -1) {
                        dLog = Math.log(j12);
                    }
                    dArr[i18] = dLog;
                    i18++;
                }
                int i19 = length - 1;
                double d11 = dArr[i19] - dArr[c11];
                int i21 = 0;
                while (i21 < i19) {
                    double d12 = dArr[i21];
                    i21++;
                    zzgalVarZza.zzq(Double.valueOf(d11 == 0.0d ? 1.0d : (((d12 + dArr[i21]) * 0.5d) - dArr[c11]) / d11), Integer.valueOf(i17));
                    c11 = 0;
                }
            }
            i17++;
            c11 = 0;
            i11 = 2;
            i12 = 1;
        }
        zzgaa zzgaaVarZzj = zzgaa.zzj(zzgalVarZza.zzr());
        for (int i22 = 0; i22 < zzgaaVarZzj.size(); i22++) {
            int iIntValue = ((Integer) zzgaaVarZzj.get(i22)).intValue();
            int i23 = iArr2[iIntValue] + 1;
            iArr2[iIntValue] = i23;
            jArr3[iIntValue] = jArr[iIntValue][i23];
            zzg(arrayList, jArr3);
        }
        for (int i24 = 0; i24 < 2; i24++) {
            if (arrayList.get(i24) != null) {
                long j13 = jArr3[i24];
                jArr3[i24] = j13 + j13;
            }
        }
        zzg(arrayList, jArr3);
        zzfzx zzfzxVar2 = new zzfzx();
        for (int i25 = 0; i25 < arrayList.size(); i25++) {
            zzfzx zzfzxVar3 = (zzfzx) arrayList.get(i25);
            zzfzxVar2.zzf(zzfzxVar3 == null ? zzgaa.zzl() : zzfzxVar3.zzi());
        }
        return zzfzxVar2.zzi();
    }

    private static void zzg(List list, long[] jArr) {
        long j11 = 0;
        for (int i11 = 0; i11 < 2; i11++) {
            j11 += jArr[i11];
        }
        for (int i12 = 0; i12 < list.size(); i12++) {
            zzfzx zzfzxVar = (zzfzx) list.get(i12);
            if (zzfzxVar != null) {
                zzfzxVar.zzf(new zzwx(j11, jArr[i12]));
            }
        }
    }
}
