package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzagq {
    public static final zzago zza = new zzago() { // from class: com.google.android.gms.internal.ads.zzagn
    };

    /* JADX WARN: Code duplicated, block: B:30:0x0090  */
    /* JADX WARN: Code duplicated, block: B:34:0x00af A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:40:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:43:0x00db  */
    /* JADX WARN: Code duplicated, block: B:52:0x0108  */
    /* JADX WARN: Code duplicated, block: B:58:0x0112 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x0102 A[SYNTHETIC] */
    @Nullable
    public static final zzby zza(byte[] bArr, int i11, zzago zzagoVar, zzafr zzafrVar) {
        boolean z11;
        zzagp zzagpVar;
        int i12;
        int iZze;
        zzagr zzagrVarZzf;
        ArrayList arrayList = new ArrayList();
        zzfp zzfpVar = new zzfp(bArr, i11);
        boolean z12 = false;
        if (zzfpVar.zzb() < 10) {
            zzff.zzf("Id3Decoder", "Data too short to be an ID3 tag");
        } else {
            int iZzo = zzfpVar.zzo();
            if (iZzo == 4801587) {
                int iZzm = zzfpVar.zzm();
                zzfpVar.zzL(1);
                int iZzm2 = zzfpVar.zzm();
                int iZzl = zzfpVar.zzl();
                if (iZzm != 2) {
                    if (iZzm == 3) {
                        if ((iZzm2 & 64) != 0) {
                            int iZzg = zzfpVar.zzg();
                            zzfpVar.zzL(iZzg);
                            iZzl -= iZzg + 4;
                        }
                    } else if (iZzm == 4) {
                        if ((iZzm2 & 64) != 0) {
                            int iZzl2 = zzfpVar.zzl();
                            zzfpVar.zzL(iZzl2 - 4);
                            iZzl -= iZzl2;
                        }
                        if ((iZzm2 & 16) != 0) {
                            iZzl -= 10;
                        }
                    } else {
                        zzff.zzf("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + iZzm);
                    }
                    if (iZzm < 4) {
                        z11 = false;
                    } else {
                        z11 = false;
                    }
                    zzagpVar = new zzagp(iZzm, z11, iZzl);
                } else if ((iZzm2 & 64) != 0) {
                    zzff.zzf("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                } else {
                    if (iZzm < 4 || (iZzm2 & 128) == 0) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    zzagpVar = new zzagp(iZzm, z11, iZzl);
                }
                if (zzagpVar == null) {
                    return null;
                }
                int iZzd = zzfpVar.zzd();
                i12 = zzagpVar.zza == 2 ? 6 : 10;
                iZze = zzagpVar.zzc;
                if (zzagpVar.zzb) {
                    iZze = zze(zzfpVar, zzagpVar.zzc);
                }
                zzfpVar.zzJ(iZzd + iZze);
                if (!zzk(zzfpVar, zzagpVar.zza, i12, false)) {
                    if (zzagpVar.zza == 4 || !zzk(zzfpVar, 4, i12, true)) {
                        zzff.zzf("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + zzagpVar.zza);
                        return null;
                    }
                    z12 = true;
                }
                while (zzfpVar.zzb() >= i12) {
                    zzagrVarZzf = zzf(zzagpVar.zza, zzfpVar, z12, i12, zzagoVar);
                    if (zzagrVarZzf != null) {
                        arrayList.add(zzagrVarZzf);
                    }
                }
                return new zzby(arrayList);
            }
            zzff.zzf("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x".concat(String.valueOf(String.format("%06X", Integer.valueOf(iZzo)))));
        }
        zzagpVar = null;
        if (zzagpVar == null) {
            return null;
        }
        int iZzd2 = zzfpVar.zzd();
        if (zzagpVar.zza == 2) {
        }
        iZze = zzagpVar.zzc;
        if (zzagpVar.zzb) {
            iZze = zze(zzfpVar, zzagpVar.zzc);
        }
        zzfpVar.zzJ(iZzd2 + iZze);
        if (!zzk(zzfpVar, zzagpVar.zza, i12, false)) {
            if (zzagpVar.zza == 4) {
            }
            zzff.zzf("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + zzagpVar.zza);
            return null;
        }
        while (zzfpVar.zzb() >= i12) {
            zzagrVarZzf = zzf(zzagpVar.zza, zzfpVar, z12, i12, zzagoVar);
            if (zzagrVarZzf != null) {
                arrayList.add(zzagrVarZzf);
            }
        }
        return new zzby(arrayList);
    }

    private static int zzb(int i11) {
        return (i11 == 0 || i11 == 3) ? 1 : 2;
    }

    private static int zzc(byte[] bArr, int i11, int i12) {
        int iZzd = zzd(bArr, i11);
        if (i12 == 0 || i12 == 3) {
            return iZzd;
        }
        while (true) {
            int length = bArr.length;
            if (iZzd >= length - 1) {
                return length;
            }
            int i13 = iZzd + 1;
            if ((iZzd - i11) % 2 == 0 && bArr[i13] == 0) {
                return iZzd;
            }
            iZzd = zzd(bArr, i13);
        }
    }

    private static int zzd(byte[] bArr, int i11) {
        while (true) {
            int length = bArr.length;
            if (i11 >= length) {
                return length;
            }
            if (bArr[i11] == 0) {
                return i11;
            }
            i11++;
        }
    }

    private static int zze(zzfp zzfpVar, int i11) {
        byte[] bArrZzM = zzfpVar.zzM();
        int iZzd = zzfpVar.zzd();
        int i12 = iZzd;
        while (true) {
            int i13 = i12 + 1;
            if (i13 >= iZzd + i11) {
                return i11;
            }
            if ((bArrZzM[i12] & 255) == 255 && bArrZzM[i13] == 0) {
                System.arraycopy(bArrZzM, i12 + 2, bArrZzM, i13, (i11 - (i12 - iZzd)) - 2);
                i11--;
            }
            i12 = i13;
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 15321. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    @androidx.annotation.Nullable
    private static com.google.android.gms.internal.ads.zzagr zzf(int r35, com.google.android.gms.internal.ads.zzfp r36, boolean r37, int r38, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzago r39) {
        /*
            Method dump skipped, instruction units count: 1532
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagq.zzf(int, com.google.android.gms.internal.ads.zzfp, boolean, int, com.google.android.gms.internal.ads.zzago):com.google.android.gms.internal.ads.zzagr");
    }

    private static zzgaa zzg(byte[] bArr, int i11, int i12) {
        if (i12 >= bArr.length) {
            return zzgaa.zzm("");
        }
        zzfzx zzfzxVar = new zzfzx();
        int iZzc = zzc(bArr, i12, i11);
        while (i12 < iZzc) {
            zzfzxVar.zzf(new String(bArr, i12, iZzc - i12, zzj(i11)));
            i12 = zzb(i11) + iZzc;
            iZzc = zzc(bArr, i12, i11);
        }
        zzgaa zzgaaVarZzi = zzfzxVar.zzi();
        return zzgaaVarZzi.isEmpty() ? zzgaa.zzm("") : zzgaaVarZzi;
    }

    private static String zzh(byte[] bArr, int i11, int i12, Charset charset) {
        return (i12 <= i11 || i12 > bArr.length) ? "" : new String(bArr, i11, i12 - i11, charset);
    }

    private static String zzi(int i11, int i12, int i13, int i14, int i15) {
        return i11 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15));
    }

    private static Charset zzj(int i11) {
        if (i11 == 1) {
            return zzfwq.zzf;
        }
        if (i11 != 2) {
            return i11 != 3 ? zzfwq.zzb : zzfwq.zzc;
        }
        return zzfwq.zzd;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006c A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:3:0x0008, B:7:0x0015, B:20:0x0040, B:23:0x004a, B:25:0x006c, B:29:0x0072, B:41:0x008e, B:42:0x0090, B:45:0x0096, B:48:0x00a0, B:31:0x007c, B:35:0x0083, B:10:0x0025), top: B:54:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0070  */
    /* JADX WARN: Code duplicated, block: B:28:0x0071  */
    /* JADX WARN: Code duplicated, block: B:30:0x007a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x007c A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:3:0x0008, B:7:0x0015, B:20:0x0040, B:23:0x004a, B:25:0x006c, B:29:0x0072, B:41:0x008e, B:42:0x0090, B:45:0x0096, B:48:0x00a0, B:31:0x007c, B:35:0x0083, B:10:0x0025), top: B:54:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0080  */
    /* JADX WARN: Code duplicated, block: B:34:0x0082  */
    /* JADX WARN: Code duplicated, block: B:37:0x0087  */
    /* JADX WARN: Code duplicated, block: B:39:0x008a  */
    /* JADX WARN: Code duplicated, block: B:41:0x008e A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:3:0x0008, B:7:0x0015, B:20:0x0040, B:23:0x004a, B:25:0x006c, B:29:0x0072, B:41:0x008e, B:42:0x0090, B:45:0x0096, B:48:0x00a0, B:31:0x007c, B:35:0x0083, B:10:0x0025), top: B:54:0x0008 }] */
    private static boolean zzk(zzfp zzfpVar, int i11, int i12, boolean z11) {
        boolean z12;
        int iZzo;
        long jZzo;
        int iZzq;
        int i13;
        int iZzd = zzfpVar.zzd();
        while (true) {
            try {
                z12 = true;
                z12 = true;
                int i14 = 1;
                int i15 = 1;
                if (zzfpVar.zzb() >= i12) {
                    if (i11 >= 3) {
                        iZzo = zzfpVar.zzg();
                        jZzo = zzfpVar.zzu();
                        iZzq = zzfpVar.zzq();
                    } else {
                        iZzo = zzfpVar.zzo();
                        jZzo = zzfpVar.zzo();
                        iZzq = 0;
                    }
                    if (iZzo != 0 || jZzo != 0 || iZzq != 0) {
                        if (i11 != 4 || z11) {
                            if (i11 == 4) {
                                if ((iZzq & 64) != 0) {
                                    i14 = 0;
                                }
                                int i16 = i14;
                                i15 = iZzq & 1;
                                i13 = i16;
                            } else {
                                if (i11 == 3) {
                                    if ((iZzq & 32) != 0) {
                                        i13 = 1;
                                    } else {
                                        i13 = 0;
                                    }
                                    if ((iZzq & 128) != 0) {
                                    }
                                } else {
                                    i13 = 0;
                                }
                                i15 = 0;
                            }
                            if (i15 != 0) {
                                i13 += 4;
                            }
                            if (jZzo >= i13 && zzfpVar.zzb() >= jZzo) {
                                zzfpVar.zzL((int) jZzo);
                            }
                        } else if ((8421504 & jZzo) == 0) {
                            long j11 = ((jZzo >> 16) & 255) << 14;
                            jZzo = ((jZzo >> 24) << 21) | j11 | (jZzo & 255) | (((jZzo >> 8) & 255) << 7);
                            if (i11 == 4) {
                                if ((iZzq & 64) != 0) {
                                    i14 = 0;
                                }
                                int i17 = i14;
                                i15 = iZzq & 1;
                                i13 = i17;
                            } else {
                                if (i11 == 3) {
                                    if ((iZzq & 32) != 0) {
                                        i13 = 1;
                                    } else {
                                        i13 = 0;
                                    }
                                    if ((iZzq & 128) != 0) {
                                    }
                                } else {
                                    i13 = 0;
                                }
                                i15 = 0;
                            }
                            if (i15 != 0) {
                                i13 += 4;
                            }
                            if (jZzo >= i13) {
                                zzfpVar.zzL((int) jZzo);
                            }
                        }
                        z12 = false;
                        break;
                    }
                    break;
                }
                break;
            } catch (Throwable th2) {
                zzfpVar.zzK(iZzd);
                throw th2;
            }
        }
        zzfpVar.zzK(iZzd);
        return z12;
    }

    private static byte[] zzl(byte[] bArr, int i11, int i12) {
        return i12 <= i11 ? zzfy.zzf : Arrays.copyOfRange(bArr, i11, i12);
    }
}
