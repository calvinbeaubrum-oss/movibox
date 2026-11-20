package com.google.android.gms.internal.ads;

import com.google.logging.type.LogSeverity;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzdv {
    private final int zza;
    private final int zzb;
    private final float zzc;
    private final float zzd;
    private final float zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final short[] zzi;
    private short[] zzj;
    private int zzk;
    private short[] zzl;
    private int zzm;
    private short[] zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private int zzv;

    public zzdv(int i11, int i12, float f11, float f12, int i13) {
        this.zza = i11;
        this.zzb = i12;
        this.zzc = f11;
        this.zzd = f12;
        this.zze = i11 / i13;
        this.zzf = i11 / LogSeverity.WARNING_VALUE;
        int i14 = i11 / 65;
        this.zzg = i14;
        int i15 = i14 + i14;
        this.zzh = i15;
        this.zzi = new short[i15];
        int i16 = i15 * i12;
        this.zzj = new short[i16];
        this.zzl = new short[i16];
        this.zzn = new short[i16];
    }

    private final int zzg(short[] sArr, int i11, int i12, int i13) {
        int i14 = 1;
        int i15 = 255;
        int i16 = 0;
        int i17 = 0;
        while (i12 <= i13) {
            int iAbs = 0;
            for (int i18 = 0; i18 < i12; i18++) {
                int i19 = this.zzb * i11;
                iAbs += Math.abs(sArr[i19 + i18] - sArr[(i19 + i12) + i18]);
            }
            int i21 = iAbs * i16;
            int i22 = i14 * i12;
            if (i21 < i22) {
                i14 = iAbs;
            }
            if (i21 < i22) {
                i16 = i12;
            }
            int i23 = iAbs * i15;
            int i24 = i17 * i12;
            if (i23 > i24) {
                i17 = iAbs;
            }
            if (i23 > i24) {
                i15 = i12;
            }
            i12++;
        }
        this.zzu = i14 / i16;
        this.zzv = i17 / i15;
        return i16;
    }

    private final void zzh(short[] sArr, int i11, int i12) {
        short[] sArrZzl = zzl(this.zzl, this.zzm, i12);
        this.zzl = sArrZzl;
        int i13 = this.zzm;
        int i14 = this.zzb;
        System.arraycopy(sArr, i11 * i14, sArrZzl, i13 * i14, i12 * i14);
        this.zzm += i12;
    }

    private final void zzi(short[] sArr, int i11, int i12) {
        int i13;
        for (int i14 = 0; i14 < this.zzh / i12; i14++) {
            int i15 = 0;
            int i16 = 0;
            while (true) {
                int i17 = this.zzb;
                i13 = i17 * i12;
                if (i15 < i13) {
                    i16 += sArr[(i17 * i11) + (i13 * i14) + i15];
                    i15++;
                }
            }
            this.zzi[i14] = (short) (i16 / i13);
        }
    }

    private static void zzj(int i11, int i12, short[] sArr, int i13, short[] sArr2, int i14, short[] sArr3, int i15) {
        for (int i16 = 0; i16 < i12; i16++) {
            int i17 = (i14 * i12) + i16;
            int i18 = (i15 * i12) + i16;
            int i19 = (i13 * i12) + i16;
            for (int i21 = 0; i21 < i11; i21++) {
                sArr[i19] = (short) (((sArr2[i17] * (i11 - i21)) + (sArr3[i18] * i21)) / i11);
                i19 += i12;
                i17 += i12;
                i18 += i12;
            }
        }
    }

    private final void zzk() {
        int iZzg;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        float f11 = this.zzc / this.zzd;
        double d11 = f11;
        int i18 = this.zzm;
        if (d11 > 1.00001d || d11 < 0.99999d) {
            int i19 = this.zzk;
            if (i19 >= this.zzh) {
                int i21 = 0;
                do {
                    int i22 = this.zzr;
                    if (i22 > 0) {
                        int iMin = Math.min(this.zzh, i22);
                        zzh(this.zzj, i21, iMin);
                        this.zzr -= iMin;
                        i21 += iMin;
                    } else {
                        short[] sArr = this.zzj;
                        int i23 = this.zza;
                        int i24 = i23 > 4000 ? i23 / 4000 : 1;
                        if (this.zzb == 1 && i24 == 1) {
                            iZzg = zzg(sArr, i21, this.zzf, this.zzg);
                        } else {
                            zzi(sArr, i21, i24);
                            int iZzg2 = zzg(this.zzi, 0, this.zzf / i24, this.zzg / i24);
                            if (i24 != 1) {
                                int i25 = iZzg2 * i24;
                                int i26 = i24 * 4;
                                int i27 = this.zzf;
                                int i28 = i25 - i26;
                                if (i28 >= i27) {
                                    i27 = i28;
                                }
                                int i29 = i25 + i26;
                                int i31 = this.zzg;
                                if (i29 > i31) {
                                    i29 = i31;
                                }
                                if (this.zzb == 1) {
                                    iZzg = zzg(sArr, i21, i27, i29);
                                } else {
                                    zzi(sArr, i21, 1);
                                    iZzg = zzg(this.zzi, 0, i27, i29);
                                }
                            } else {
                                iZzg = iZzg2;
                            }
                        }
                        int i32 = this.zzu;
                        int i33 = (i32 == 0 || (i13 = this.zzs) == 0 || this.zzv > i32 * 3 || i32 + i32 <= this.zzt * 3) ? iZzg : i13;
                        int i34 = i21 + i33;
                        this.zzt = i32;
                        this.zzs = iZzg;
                        float f12 = i33;
                        if (d11 > 1.0d) {
                            short[] sArr2 = this.zzj;
                            float f13 = (-1.0f) + f11;
                            if (f11 >= 2.0f) {
                                i12 = (int) (f12 / f13);
                            } else {
                                this.zzr = (int) ((f12 * (2.0f - f11)) / f13);
                                i12 = i33;
                            }
                            short[] sArrZzl = zzl(this.zzl, this.zzm, i12);
                            this.zzl = sArrZzl;
                            int i35 = i12;
                            zzj(i12, this.zzb, sArrZzl, this.zzm, sArr2, i21, sArr2, i34);
                            this.zzm += i35;
                            i21 += i33 + i35;
                        } else {
                            int i36 = i33;
                            short[] sArr3 = this.zzj;
                            float f14 = 1.0f - f11;
                            if (f11 < 0.5f) {
                                i11 = (int) ((f12 * f11) / f14);
                            } else {
                                this.zzr = (int) ((f12 * ((f11 + f11) - 1.0f)) / f14);
                                i11 = i36;
                            }
                            int i37 = i36 + i11;
                            short[] sArrZzl2 = zzl(this.zzl, this.zzm, i37);
                            this.zzl = sArrZzl2;
                            int i38 = this.zzb;
                            System.arraycopy(sArr3, i21 * i38, sArrZzl2, this.zzm * i38, i38 * i36);
                            zzj(i11, this.zzb, this.zzl, this.zzm + i36, sArr3, i34, sArr3, i21);
                            this.zzm += i37;
                            i21 += i11;
                        }
                    }
                } while (this.zzh + i21 <= i19);
                int i39 = this.zzk - i21;
                short[] sArr4 = this.zzj;
                int i40 = this.zzb;
                System.arraycopy(sArr4, i21 * i40, sArr4, 0, i40 * i39);
                this.zzk = i39;
            }
        } else {
            zzh(this.zzj, 0, this.zzk);
            this.zzk = 0;
        }
        float f15 = this.zze * this.zzd;
        if (f15 == 1.0f || this.zzm == i18) {
            return;
        }
        int i41 = this.zza;
        int i42 = (int) (i41 / f15);
        while (true) {
            if (i42 <= 16384 && i41 <= 16384) {
                break;
            }
            i42 /= 2;
            i41 /= 2;
        }
        int i43 = this.zzm - i18;
        short[] sArrZzl3 = zzl(this.zzn, this.zzo, i43);
        this.zzn = sArrZzl3;
        short[] sArr5 = this.zzl;
        int i44 = this.zzb;
        System.arraycopy(sArr5, i18 * i44, sArrZzl3, this.zzo * i44, i44 * i43);
        this.zzm = i18;
        this.zzo += i43;
        int i45 = 0;
        while (true) {
            i14 = this.zzo;
            i15 = i14 - 1;
            if (i45 >= i15) {
                break;
            }
            while (true) {
                i16 = this.zzp + 1;
                int i46 = i16 * i42;
                i17 = this.zzq;
                if (i46 <= i17 * i41) {
                    break;
                }
                this.zzl = zzl(this.zzl, this.zzm, 1);
                int i47 = 0;
                while (true) {
                    int i48 = this.zzb;
                    if (i47 < i48) {
                        short[] sArr6 = this.zzl;
                        int i49 = this.zzm * i48;
                        short[] sArr7 = this.zzn;
                        int i50 = (i45 * i48) + i47;
                        short s11 = sArr7[i50];
                        short s12 = sArr7[i50 + i48];
                        int i51 = this.zzq * i41;
                        int i52 = this.zzp;
                        int i53 = i52 * i42;
                        int i54 = (i52 + 1) * i42;
                        int i55 = i54 - i51;
                        int i56 = i54 - i53;
                        sArr6[i49 + i47] = (short) (((s11 * i55) + ((i56 - i55) * s12)) / i56);
                        i47++;
                    }
                }
                this.zzq++;
                this.zzm++;
            }
            this.zzp = i16;
            if (i16 == i41) {
                this.zzp = 0;
                zzek.zzf(i17 == i42);
                this.zzq = 0;
            }
            i45++;
        }
        if (i15 != 0) {
            short[] sArr8 = this.zzn;
            int i57 = this.zzb;
            System.arraycopy(sArr8, i15 * i57, sArr8, 0, (i14 - i15) * i57);
            this.zzo -= i15;
        }
    }

    private final short[] zzl(short[] sArr, int i11, int i12) {
        int length = sArr.length;
        int i13 = this.zzb;
        int i14 = length / i13;
        return i11 + i12 <= i14 ? sArr : Arrays.copyOf(sArr, (((i14 * 3) / 2) + i12) * i13);
    }

    public final int zza() {
        int i11 = this.zzm * this.zzb;
        return i11 + i11;
    }

    public final int zzb() {
        int i11 = this.zzk * this.zzb;
        return i11 + i11;
    }

    public final void zzc() {
        this.zzk = 0;
        this.zzm = 0;
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        this.zzt = 0;
        this.zzu = 0;
        this.zzv = 0;
    }

    public final void zzd(ShortBuffer shortBuffer) {
        int iMin = Math.min(shortBuffer.remaining() / this.zzb, this.zzm);
        shortBuffer.put(this.zzl, 0, this.zzb * iMin);
        int i11 = this.zzm - iMin;
        this.zzm = i11;
        int i12 = this.zzb;
        short[] sArr = this.zzl;
        System.arraycopy(sArr, iMin * i12, sArr, 0, i11 * i12);
    }

    public final void zze() {
        int i11;
        int i12 = this.zzk;
        int i13 = this.zzm;
        float f11 = this.zzo;
        float f12 = this.zzc;
        float f13 = this.zze;
        float f14 = this.zzd;
        int i14 = i13 + ((int) ((((i12 / (f12 / f14)) + f11) / (f13 * f14)) + 0.5f));
        int i15 = this.zzh;
        this.zzj = zzl(this.zzj, i12, i15 + i15 + i12);
        int i16 = 0;
        while (true) {
            int i17 = this.zzh;
            int i18 = this.zzb;
            i11 = i17 + i17;
            if (i16 >= i11 * i18) {
                break;
            }
            this.zzj[(i18 * i12) + i16] = 0;
            i16++;
        }
        this.zzk += i11;
        zzk();
        if (this.zzm > i14) {
            this.zzm = i14;
        }
        this.zzk = 0;
        this.zzr = 0;
        this.zzo = 0;
    }

    public final void zzf(ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining();
        int i11 = this.zzb;
        int i12 = iRemaining / i11;
        int i13 = i11 * i12;
        short[] sArrZzl = zzl(this.zzj, this.zzk, i12);
        this.zzj = sArrZzl;
        shortBuffer.get(sArrZzl, this.zzk * this.zzb, (i13 + i13) / 2);
        this.zzk += i12;
        zzk();
    }
}
