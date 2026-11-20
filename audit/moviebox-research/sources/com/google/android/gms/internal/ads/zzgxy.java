package com.google.android.gms.internal.ads;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgxy {
    public static int zza(byte[] bArr, int i11, zzgxx zzgxxVar) throws zzhag {
        int iZzh = zzh(bArr, i11, zzgxxVar);
        int i12 = zzgxxVar.zza;
        if (i12 < 0) {
            throw zzhag.zzf();
        }
        if (i12 > bArr.length - iZzh) {
            throw zzhag.zzj();
        }
        if (i12 == 0) {
            zzgxxVar.zzc = zzgyl.zzb;
            return iZzh;
        }
        zzgxxVar.zzc = zzgyl.zzv(bArr, iZzh, i12);
        return iZzh + i12;
    }

    public static int zzb(byte[] bArr, int i11) {
        int i12 = bArr[i11] & 255;
        int i13 = bArr[i11 + 1] & 255;
        int i14 = bArr[i11 + 2] & 255;
        return ((bArr[i11 + 3] & 255) << 24) | (i13 << 8) | i12 | (i14 << 16);
    }

    public static int zzc(zzhby zzhbyVar, byte[] bArr, int i11, int i12, int i13, zzgxx zzgxxVar) throws IOException {
        Object objZze = zzhbyVar.zze();
        int iZzl = zzl(objZze, zzhbyVar, bArr, i11, i12, i13, zzgxxVar);
        zzhbyVar.zzf(objZze);
        zzgxxVar.zzc = objZze;
        return iZzl;
    }

    public static int zzd(zzhby zzhbyVar, byte[] bArr, int i11, int i12, zzgxx zzgxxVar) throws IOException {
        Object objZze = zzhbyVar.zze();
        int iZzm = zzm(objZze, zzhbyVar, bArr, i11, i12, zzgxxVar);
        zzhbyVar.zzf(objZze);
        zzgxxVar.zzc = objZze;
        return iZzm;
    }

    public static int zze(zzhby zzhbyVar, int i11, byte[] bArr, int i12, int i13, zzhad zzhadVar, zzgxx zzgxxVar) throws IOException {
        int iZzd = zzd(zzhbyVar, bArr, i12, i13, zzgxxVar);
        zzhadVar.add(zzgxxVar.zzc);
        while (iZzd < i13) {
            int iZzh = zzh(bArr, iZzd, zzgxxVar);
            if (i11 != zzgxxVar.zza) {
                break;
            }
            iZzd = zzd(zzhbyVar, bArr, iZzh, i13, zzgxxVar);
            zzhadVar.add(zzgxxVar.zzc);
        }
        return iZzd;
    }

    public static int zzf(byte[] bArr, int i11, zzhad zzhadVar, zzgxx zzgxxVar) throws IOException {
        zzgzv zzgzvVar = (zzgzv) zzhadVar;
        int iZzh = zzh(bArr, i11, zzgxxVar);
        int i12 = zzgxxVar.zza + iZzh;
        while (iZzh < i12) {
            iZzh = zzh(bArr, iZzh, zzgxxVar);
            zzgzvVar.zzh(zzgxxVar.zza);
        }
        if (iZzh == i12) {
            return iZzh;
        }
        throw zzhag.zzj();
    }

    public static int zzg(int i11, byte[] bArr, int i12, int i13, zzhcq zzhcqVar, zzgxx zzgxxVar) throws zzhag {
        if ((i11 >>> 3) == 0) {
            throw zzhag.zzc();
        }
        int i14 = i11 & 7;
        if (i14 == 0) {
            int iZzk = zzk(bArr, i12, zzgxxVar);
            zzhcqVar.zzj(i11, Long.valueOf(zzgxxVar.zzb));
            return iZzk;
        }
        if (i14 == 1) {
            zzhcqVar.zzj(i11, Long.valueOf(zzn(bArr, i12)));
            return i12 + 8;
        }
        if (i14 == 2) {
            int iZzh = zzh(bArr, i12, zzgxxVar);
            int i15 = zzgxxVar.zza;
            if (i15 < 0) {
                throw zzhag.zzf();
            }
            if (i15 > bArr.length - iZzh) {
                throw zzhag.zzj();
            }
            if (i15 == 0) {
                zzhcqVar.zzj(i11, zzgyl.zzb);
            } else {
                zzhcqVar.zzj(i11, zzgyl.zzv(bArr, iZzh, i15));
            }
            return iZzh + i15;
        }
        if (i14 != 3) {
            if (i14 != 5) {
                throw zzhag.zzc();
            }
            zzhcqVar.zzj(i11, Integer.valueOf(zzb(bArr, i12)));
            return i12 + 4;
        }
        int i16 = (i11 & (-8)) | 4;
        zzhcq zzhcqVarZzf = zzhcq.zzf();
        int i17 = 0;
        while (i12 < i13) {
            int iZzh2 = zzh(bArr, i12, zzgxxVar);
            int i18 = zzgxxVar.zza;
            i17 = i18;
            if (i18 == i16) {
                i12 = iZzh2;
                break;
            }
            int iZzg = zzg(i17, bArr, iZzh2, i13, zzhcqVarZzf, zzgxxVar);
            i17 = i18;
            i12 = iZzg;
        }
        if (i12 > i13 || i17 != i16) {
            throw zzhag.zzg();
        }
        zzhcqVar.zzj(i11, zzhcqVarZzf);
        return i12;
    }

    public static int zzh(byte[] bArr, int i11, zzgxx zzgxxVar) {
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        if (b11 < 0) {
            return zzi(b11, bArr, i12, zzgxxVar);
        }
        zzgxxVar.zza = b11;
        return i12;
    }

    public static int zzi(int i11, byte[] bArr, int i12, zzgxx zzgxxVar) {
        byte b11 = bArr[i12];
        int i13 = i12 + 1;
        int i14 = i11 & 127;
        if (b11 >= 0) {
            zzgxxVar.zza = i14 | (b11 << 7);
            return i13;
        }
        int i15 = i14 | ((b11 & Ascii.DEL) << 7);
        int i16 = i12 + 2;
        byte b12 = bArr[i13];
        if (b12 >= 0) {
            zzgxxVar.zza = i15 | (b12 << Ascii.SO);
            return i16;
        }
        int i17 = i15 | ((b12 & Ascii.DEL) << 14);
        int i18 = i12 + 3;
        byte b13 = bArr[i16];
        if (b13 >= 0) {
            zzgxxVar.zza = i17 | (b13 << Ascii.NAK);
            return i18;
        }
        int i19 = i17 | ((b13 & Ascii.DEL) << 21);
        int i21 = i12 + 4;
        byte b14 = bArr[i18];
        if (b14 >= 0) {
            zzgxxVar.zza = i19 | (b14 << Ascii.FS);
            return i21;
        }
        int i22 = i19 | ((b14 & Ascii.DEL) << 28);
        while (true) {
            int i23 = i21 + 1;
            if (bArr[i21] >= 0) {
                zzgxxVar.zza = i22;
                return i23;
            }
            i21 = i23;
        }
    }

    public static int zzj(int i11, byte[] bArr, int i12, int i13, zzhad zzhadVar, zzgxx zzgxxVar) {
        zzgzv zzgzvVar = (zzgzv) zzhadVar;
        int iZzh = zzh(bArr, i12, zzgxxVar);
        zzgzvVar.zzh(zzgxxVar.zza);
        while (iZzh < i13) {
            int iZzh2 = zzh(bArr, iZzh, zzgxxVar);
            if (i11 != zzgxxVar.zza) {
                break;
            }
            iZzh = zzh(bArr, iZzh2, zzgxxVar);
            zzgzvVar.zzh(zzgxxVar.zza);
        }
        return iZzh;
    }

    public static int zzk(byte[] bArr, int i11, zzgxx zzgxxVar) {
        long j11 = bArr[i11];
        int i12 = i11 + 1;
        if (j11 >= 0) {
            zzgxxVar.zzb = j11;
            return i12;
        }
        int i13 = i11 + 2;
        byte b11 = bArr[i12];
        long j12 = (j11 & 127) | (((long) (b11 & Ascii.DEL)) << 7);
        int i14 = 7;
        while (b11 < 0) {
            int i15 = i13 + 1;
            byte b12 = bArr[i13];
            i14 += 7;
            j12 |= ((long) (b12 & Ascii.DEL)) << i14;
            b11 = b12;
            i13 = i15;
        }
        zzgxxVar.zzb = j12;
        return i13;
    }

    public static int zzl(Object obj, zzhby zzhbyVar, byte[] bArr, int i11, int i12, int i13, zzgxx zzgxxVar) throws IOException {
        int iZzc = ((zzhbh) zzhbyVar).zzc(obj, bArr, i11, i12, i13, zzgxxVar);
        zzgxxVar.zzc = obj;
        return iZzc;
    }

    public static int zzm(Object obj, zzhby zzhbyVar, byte[] bArr, int i11, int i12, zzgxx zzgxxVar) throws IOException {
        int iZzi = i11 + 1;
        int i13 = bArr[i11];
        if (i13 < 0) {
            iZzi = zzi(i13, bArr, iZzi, zzgxxVar);
            i13 = zzgxxVar.zza;
        }
        int i14 = iZzi;
        if (i13 < 0 || i13 > i12 - i14) {
            throw zzhag.zzj();
        }
        int i15 = i13 + i14;
        zzhbyVar.zzi(obj, bArr, i14, i15, zzgxxVar);
        zzgxxVar.zzc = obj;
        return i15;
    }

    public static long zzn(byte[] bArr, int i11) {
        return (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48) | ((((long) bArr[i11 + 7]) & 255) << 56);
    }
}
