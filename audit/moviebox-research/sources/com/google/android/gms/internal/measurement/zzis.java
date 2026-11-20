package com.google.android.gms.internal.measurement;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzis {
    public static int zza(byte[] bArr, int i11, zzir zzirVar) throws zzkp {
        int iZzj = zzj(bArr, i11, zzirVar);
        int i12 = zzirVar.zza;
        if (i12 < 0) {
            throw zzkp.zzd();
        }
        if (i12 > bArr.length - iZzj) {
            throw zzkp.zzf();
        }
        if (i12 == 0) {
            zzirVar.zzc = zzje.zzb;
            return iZzj;
        }
        zzirVar.zzc = zzje.zzl(bArr, iZzj, i12);
        return iZzj + i12;
    }

    public static int zzb(byte[] bArr, int i11) {
        return ((bArr[i11 + 3] & 255) << 24) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16);
    }

    public static int zzc(zzlx zzlxVar, byte[] bArr, int i11, int i12, int i13, zzir zzirVar) throws IOException {
        Object objZze = zzlxVar.zze();
        int iZzn = zzn(objZze, zzlxVar, bArr, i11, i12, i13, zzirVar);
        zzlxVar.zzf(objZze);
        zzirVar.zzc = objZze;
        return iZzn;
    }

    public static int zzd(zzlx zzlxVar, byte[] bArr, int i11, int i12, zzir zzirVar) throws IOException {
        Object objZze = zzlxVar.zze();
        int iZzo = zzo(objZze, zzlxVar, bArr, i11, i12, zzirVar);
        zzlxVar.zzf(objZze);
        zzirVar.zzc = objZze;
        return iZzo;
    }

    public static int zze(zzlx zzlxVar, int i11, byte[] bArr, int i12, int i13, zzkm zzkmVar, zzir zzirVar) throws IOException {
        int iZzd = zzd(zzlxVar, bArr, i12, i13, zzirVar);
        zzkmVar.add(zzirVar.zzc);
        while (iZzd < i13) {
            int iZzj = zzj(bArr, iZzd, zzirVar);
            if (i11 != zzirVar.zza) {
                break;
            }
            iZzd = zzd(zzlxVar, bArr, iZzj, i13, zzirVar);
            zzkmVar.add(zzirVar.zzc);
        }
        return iZzd;
    }

    public static int zzf(byte[] bArr, int i11, zzkm zzkmVar, zzir zzirVar) throws IOException {
        zzkg zzkgVar = (zzkg) zzkmVar;
        int iZzj = zzj(bArr, i11, zzirVar);
        int i12 = zzirVar.zza + iZzj;
        while (iZzj < i12) {
            iZzj = zzj(bArr, iZzj, zzirVar);
            zzkgVar.zzh(zzirVar.zza);
        }
        if (iZzj == i12) {
            return iZzj;
        }
        throw zzkp.zzf();
    }

    public static int zzg(byte[] bArr, int i11, zzir zzirVar) throws zzkp {
        int iZzj = zzj(bArr, i11, zzirVar);
        int i12 = zzirVar.zza;
        if (i12 < 0) {
            throw zzkp.zzd();
        }
        if (i12 == 0) {
            zzirVar.zzc = "";
            return iZzj;
        }
        zzirVar.zzc = new String(bArr, iZzj, i12, zzkn.zzb);
        return iZzj + i12;
    }

    public static int zzh(byte[] bArr, int i11, zzir zzirVar) throws zzkp {
        int iZzj = zzj(bArr, i11, zzirVar);
        int i12 = zzirVar.zza;
        if (i12 < 0) {
            throw zzkp.zzd();
        }
        if (i12 == 0) {
            zzirVar.zzc = "";
            return iZzj;
        }
        zzirVar.zzc = zznd.zzd(bArr, iZzj, i12);
        return iZzj + i12;
    }

    public static int zzi(int i11, byte[] bArr, int i12, int i13, zzmp zzmpVar, zzir zzirVar) throws zzkp {
        if ((i11 >>> 3) == 0) {
            throw zzkp.zzb();
        }
        int i14 = i11 & 7;
        if (i14 == 0) {
            int iZzm = zzm(bArr, i12, zzirVar);
            zzmpVar.zzj(i11, Long.valueOf(zzirVar.zzb));
            return iZzm;
        }
        if (i14 == 1) {
            zzmpVar.zzj(i11, Long.valueOf(zzp(bArr, i12)));
            return i12 + 8;
        }
        if (i14 == 2) {
            int iZzj = zzj(bArr, i12, zzirVar);
            int i15 = zzirVar.zza;
            if (i15 < 0) {
                throw zzkp.zzd();
            }
            if (i15 > bArr.length - iZzj) {
                throw zzkp.zzf();
            }
            if (i15 == 0) {
                zzmpVar.zzj(i11, zzje.zzb);
            } else {
                zzmpVar.zzj(i11, zzje.zzl(bArr, iZzj, i15));
            }
            return iZzj + i15;
        }
        if (i14 != 3) {
            if (i14 != 5) {
                throw zzkp.zzb();
            }
            zzmpVar.zzj(i11, Integer.valueOf(zzb(bArr, i12)));
            return i12 + 4;
        }
        int i16 = (i11 & (-8)) | 4;
        zzmp zzmpVarZzf = zzmp.zzf();
        int i17 = 0;
        while (i12 < i13) {
            int iZzj2 = zzj(bArr, i12, zzirVar);
            int i18 = zzirVar.zza;
            if (i18 == i16) {
                i17 = i18;
                i12 = iZzj2;
                break;
            }
            i17 = i18;
            i12 = zzi(i18, bArr, iZzj2, i13, zzmpVarZzf, zzirVar);
        }
        if (i12 > i13 || i17 != i16) {
            throw zzkp.zze();
        }
        zzmpVar.zzj(i11, zzmpVarZzf);
        return i12;
    }

    public static int zzj(byte[] bArr, int i11, zzir zzirVar) {
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        if (b11 < 0) {
            return zzk(b11, bArr, i12, zzirVar);
        }
        zzirVar.zza = b11;
        return i12;
    }

    public static int zzk(int i11, byte[] bArr, int i12, zzir zzirVar) {
        int i13 = i11 & 127;
        int i14 = i12 + 1;
        byte b11 = bArr[i12];
        if (b11 >= 0) {
            zzirVar.zza = i13 | (b11 << 7);
            return i14;
        }
        int i15 = i13 | ((b11 & Ascii.DEL) << 7);
        int i16 = i12 + 2;
        byte b12 = bArr[i14];
        if (b12 >= 0) {
            zzirVar.zza = i15 | (b12 << Ascii.SO);
            return i16;
        }
        int i17 = i15 | ((b12 & Ascii.DEL) << 14);
        int i18 = i12 + 3;
        byte b13 = bArr[i16];
        if (b13 >= 0) {
            zzirVar.zza = i17 | (b13 << Ascii.NAK);
            return i18;
        }
        int i19 = i17 | ((b13 & Ascii.DEL) << 21);
        int i21 = i12 + 4;
        byte b14 = bArr[i18];
        if (b14 >= 0) {
            zzirVar.zza = i19 | (b14 << Ascii.FS);
            return i21;
        }
        int i22 = i19 | ((b14 & Ascii.DEL) << 28);
        while (true) {
            int i23 = i21 + 1;
            if (bArr[i21] >= 0) {
                zzirVar.zza = i22;
                return i23;
            }
            i21 = i23;
        }
    }

    public static int zzl(int i11, byte[] bArr, int i12, int i13, zzkm zzkmVar, zzir zzirVar) {
        zzkg zzkgVar = (zzkg) zzkmVar;
        int iZzj = zzj(bArr, i12, zzirVar);
        zzkgVar.zzh(zzirVar.zza);
        while (iZzj < i13) {
            int iZzj2 = zzj(bArr, iZzj, zzirVar);
            if (i11 != zzirVar.zza) {
                break;
            }
            iZzj = zzj(bArr, iZzj2, zzirVar);
            zzkgVar.zzh(zzirVar.zza);
        }
        return iZzj;
    }

    public static int zzm(byte[] bArr, int i11, zzir zzirVar) {
        int i12 = i11 + 1;
        long j11 = bArr[i11];
        if (j11 >= 0) {
            zzirVar.zzb = j11;
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
        zzirVar.zzb = j12;
        return i13;
    }

    public static int zzn(Object obj, zzlx zzlxVar, byte[] bArr, int i11, int i12, int i13, zzir zzirVar) throws IOException {
        int iZzc = ((zzlp) zzlxVar).zzc(obj, bArr, i11, i12, i13, zzirVar);
        zzirVar.zzc = obj;
        return iZzc;
    }

    public static int zzo(Object obj, zzlx zzlxVar, byte[] bArr, int i11, int i12, zzir zzirVar) throws IOException {
        int iZzk = i11 + 1;
        int i13 = bArr[i11];
        if (i13 < 0) {
            iZzk = zzk(i13, bArr, iZzk, zzirVar);
            i13 = zzirVar.zza;
        }
        int i14 = iZzk;
        if (i13 < 0 || i13 > i12 - i14) {
            throw zzkp.zzf();
        }
        int i15 = i13 + i14;
        zzlxVar.zzh(obj, bArr, i14, i15, zzirVar);
        zzirVar.zzc = obj;
        return i15;
    }

    public static long zzp(byte[] bArr, int i11) {
        return ((((long) bArr[i11 + 7]) & 255) << 56) | (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48);
    }
}
