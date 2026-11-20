package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzajl {
    private static final int[] zza = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean zza(zzacv zzacvVar) throws IOException {
        return zzc(zzacvVar, true, false);
    }

    public static boolean zzb(zzacv zzacvVar, boolean z11) throws IOException {
        return zzc(zzacvVar, false, z11);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x00fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00f9 A[LOOP:2: B:65:0x00f0->B:70:0x00f9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:97:0x00e0 A[SYNTHETIC] */
    private static boolean zzc(zzacv zzacvVar, boolean z11, boolean z12) throws IOException {
        boolean z13;
        long jZzt;
        int i11;
        boolean z14;
        int[] iArr;
        int i12;
        long jZzd = zzacvVar.zzd();
        long j11 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        long j12 = -1;
        if (jZzd != -1 && jZzd <= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            j11 = jZzd;
        }
        zzfp zzfpVar = new zzfp(64);
        int i13 = (int) j11;
        int i14 = 0;
        boolean z15 = false;
        while (true) {
            if (i14 < i13) {
                zzfpVar.zzH(8);
                if (zzacvVar.zzm(zzfpVar.zzM(), 0, 8, true)) {
                    long jZzu = zzfpVar.zzu();
                    int iZzg = zzfpVar.zzg();
                    if (jZzu == 1) {
                        zzacvVar.zzh(zzfpVar.zzM(), 8, 8);
                        i11 = 16;
                        zzfpVar.zzJ(16);
                        jZzt = zzfpVar.zzt();
                    } else {
                        if (jZzu == 0) {
                            long jZzd2 = zzacvVar.zzd();
                            if (jZzd2 != j12) {
                                jZzu = (jZzd2 - zzacvVar.zze()) + 8;
                            }
                        }
                        jZzt = jZzu;
                        i11 = 8;
                    }
                    long j13 = i11;
                    if (jZzt < j13) {
                        return false;
                    }
                    i14 += i11;
                    if (iZzg == 1836019574) {
                        i13 += (int) jZzt;
                        if (jZzd != -1 && i13 > jZzd) {
                            i13 = (int) jZzd;
                        }
                    } else {
                        if (iZzg == 1836019558 || iZzg == 1836475768) {
                            z13 = true;
                            return !z15 && z11 == z13;
                        }
                        z15 = (!(iZzg != 1835295092)) | z15;
                        long j14 = jZzd;
                        if ((((long) i14) + jZzt) - j13 < i13) {
                            int i15 = (int) (jZzt - j13);
                            i14 += i15;
                            if (iZzg == 1718909296) {
                                if (i15 < 8) {
                                    return false;
                                }
                                zzfpVar.zzH(i15);
                                zzacvVar.zzh(zzfpVar.zzM(), 0, i15);
                                int i16 = i15 >> 2;
                                int i17 = 0;
                                while (true) {
                                    if (i17 >= i16) {
                                        z14 = z15;
                                        break;
                                    }
                                    if (i17 != 1) {
                                        int iZzg2 = zzfpVar.zzg();
                                        if ((iZzg2 >>> 8) != 3368816) {
                                            if (iZzg2 != 1751476579) {
                                                iArr = zza;
                                                i12 = 0;
                                                while (true) {
                                                    if (i12 < 29) {
                                                        continue;
                                                    } else if (iArr[i12] == iZzg2) {
                                                        i12++;
                                                    }
                                                }
                                            } else if (!z12) {
                                                iZzg2 = 1751476579;
                                                iArr = zza;
                                                i12 = 0;
                                                while (true) {
                                                    if (i12 < 29) {
                                                        continue;
                                                    } else if (iArr[i12] == iZzg2) {
                                                        i12++;
                                                    }
                                                }
                                            }
                                        }
                                        z14 = true;
                                        break;
                                    }
                                    zzfpVar.zzL(4);
                                    i17++;
                                }
                                if (!z14) {
                                    return false;
                                }
                                z15 = z14;
                            } else if (i15 != 0) {
                                zzacvVar.zzg(i15);
                            }
                            jZzd = j14;
                        }
                    }
                    j12 = -1;
                }
            }
            z13 = false;
            if (z15) {
            }
        }
    }
}
