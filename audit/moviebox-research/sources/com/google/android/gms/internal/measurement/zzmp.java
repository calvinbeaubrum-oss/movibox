package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzmp {
    private static final zzmp zza = new zzmp(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzmp() {
        this(0, new int[8], new Object[8], true);
    }

    private zzmp(int i11, int[] iArr, Object[] objArr, boolean z11) {
        this.zze = -1;
        this.zzb = i11;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z11;
    }

    public static zzmp zzc() {
        return zza;
    }

    public static zzmp zze(zzmp zzmpVar, zzmp zzmpVar2) {
        int i11 = zzmpVar.zzb + zzmpVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzmpVar.zzc, i11);
        System.arraycopy(zzmpVar2.zzc, 0, iArrCopyOf, zzmpVar.zzb, zzmpVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzmpVar.zzd, i11);
        System.arraycopy(zzmpVar2.zzd, 0, objArrCopyOf, zzmpVar.zzb, zzmpVar2.zzb);
        return new zzmp(i11, iArrCopyOf, objArrCopyOf, true);
    }

    public static zzmp zzf() {
        return new zzmp(0, new int[8], new Object[8], true);
    }

    private final void zzl(int i11) {
        int[] iArr = this.zzc;
        if (i11 > iArr.length) {
            int i12 = this.zzb;
            int i13 = i12 + (i12 / 2);
            if (i13 >= i11) {
                i11 = i13;
            }
            if (i11 < 8) {
                i11 = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i11);
            this.zzd = Arrays.copyOf(this.zzd, i11);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzmp)) {
            return false;
        }
        zzmp zzmpVar = (zzmp) obj;
        int i11 = this.zzb;
        if (i11 == zzmpVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzmpVar.zzc;
            for (int i12 = 0; i12 < i11; i12++) {
                if (iArr[i12] == iArr2[i12]) {
                }
            }
            Object[] objArr = this.zzd;
            Object[] objArr2 = zzmpVar.zzd;
            int i13 = this.zzb;
            for (int i14 = 0; i14 < i13; i14++) {
                if (objArr[i14].equals(objArr2[i14])) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i11 = this.zzb;
        int i12 = (i11 + 527) * 31;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i13 = 17;
        for (int i14 = 0; i14 < i11; i14++) {
            i13 = (i13 * 31) + iArr[i14];
        }
        int i15 = (i12 + i13) * 31;
        Object[] objArr = this.zzd;
        int i16 = this.zzb;
        for (int i17 = 0; i17 < i16; i17++) {
            iHashCode = (iHashCode * 31) + objArr[i17].hashCode();
        }
        return i15 + iHashCode;
    }

    public final int zza() {
        int iZzA;
        int iZzB;
        int iZzA2;
        int i11 = this.zze;
        if (i11 != -1) {
            return i11;
        }
        int iZzA3 = 0;
        for (int i12 = 0; i12 < this.zzb; i12++) {
            int i13 = this.zzc[i12];
            int i14 = i13 >>> 3;
            int i15 = i13 & 7;
            if (i15 != 0) {
                if (i15 != 1) {
                    if (i15 == 2) {
                        zzje zzjeVar = (zzje) this.zzd[i12];
                        int iZzA4 = zzjm.zzA(i14 << 3);
                        int iZzd = zzjeVar.zzd();
                        iZzA3 += iZzA4 + zzjm.zzA(iZzd) + iZzd;
                    } else if (i15 == 3) {
                        int iZzz = zzjm.zzz(i14);
                        iZzA = iZzz + iZzz;
                        iZzB = ((zzmp) this.zzd[i12]).zza();
                    } else {
                        if (i15 != 5) {
                            throw new IllegalStateException(zzkp.zza());
                        }
                        ((Integer) this.zzd[i12]).intValue();
                        iZzA2 = zzjm.zzA(i14 << 3) + 4;
                    }
                } else {
                    ((Long) this.zzd[i12]).longValue();
                    iZzA2 = zzjm.zzA(i14 << 3) + 8;
                }
                iZzA3 += iZzA2;
            } else {
                long jLongValue = ((Long) this.zzd[i12]).longValue();
                iZzA = zzjm.zzA(i14 << 3);
                iZzB = zzjm.zzB(jLongValue);
            }
            iZzA2 = iZzA + iZzB;
            iZzA3 += iZzA2;
        }
        this.zze = iZzA3;
        return iZzA3;
    }

    public final int zzb() {
        int i11 = this.zze;
        if (i11 != -1) {
            return i11;
        }
        int iZzA = 0;
        for (int i12 = 0; i12 < this.zzb; i12++) {
            int i13 = this.zzc[i12];
            zzje zzjeVar = (zzje) this.zzd[i12];
            int iZzA2 = zzjm.zzA(8);
            int iZzd = zzjeVar.zzd();
            iZzA += iZzA2 + iZzA2 + zzjm.zzA(16) + zzjm.zzA(i13 >>> 3) + zzjm.zzA(24) + zzjm.zzA(iZzd) + iZzd;
        }
        this.zze = iZzA;
        return iZzA;
    }

    public final zzmp zzd(zzmp zzmpVar) {
        if (zzmpVar.equals(zza)) {
            return this;
        }
        zzg();
        int i11 = this.zzb + zzmpVar.zzb;
        zzl(i11);
        System.arraycopy(zzmpVar.zzc, 0, this.zzc, this.zzb, zzmpVar.zzb);
        System.arraycopy(zzmpVar.zzd, 0, this.zzd, this.zzb, zzmpVar.zzb);
        this.zzb = i11;
        return this;
    }

    public final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        this.zzf = false;
    }

    public final void zzi(StringBuilder sb2, int i11) {
        for (int i12 = 0; i12 < this.zzb; i12++) {
            zzlo.zzb(sb2, i11, String.valueOf(this.zzc[i12] >>> 3), this.zzd[i12]);
        }
    }

    public final void zzj(int i11, Object obj) {
        zzg();
        zzl(this.zzb + 1);
        int[] iArr = this.zzc;
        int i12 = this.zzb;
        iArr[i12] = i11;
        this.zzd[i12] = obj;
        this.zzb = i12 + 1;
    }

    public final void zzk(zzng zzngVar) throws IOException {
        if (this.zzb != 0) {
            for (int i11 = 0; i11 < this.zzb; i11++) {
                int i12 = this.zzc[i11];
                Object obj = this.zzd[i11];
                int i13 = i12 >>> 3;
                int i14 = i12 & 7;
                if (i14 == 0) {
                    zzngVar.zzt(i13, ((Long) obj).longValue());
                } else if (i14 == 1) {
                    zzngVar.zzm(i13, ((Long) obj).longValue());
                } else if (i14 == 2) {
                    zzngVar.zzd(i13, (zzje) obj);
                } else if (i14 == 3) {
                    zzngVar.zzE(i13);
                    ((zzmp) obj).zzk(zzngVar);
                    zzngVar.zzh(i13);
                } else {
                    if (i14 != 5) {
                        throw new RuntimeException(zzkp.zza());
                    }
                    zzngVar.zzk(i13, ((Integer) obj).intValue());
                }
            }
        }
    }
}
