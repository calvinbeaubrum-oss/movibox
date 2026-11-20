package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgm {
    public static final byte[] zza = {0, 0, 0, 1};
    public static final float[] zzb = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object zzc = new Object();
    private static int[] zzd = new int[10];

    public static int zza(byte[] bArr, int i11, int i12, boolean[] zArr) {
        int i13 = i12 - i11;
        zzek.zzf(i13 >= 0);
        if (i13 == 0) {
            return i12;
        }
        if (zArr[0]) {
            zzf(zArr);
            return i11 - 3;
        }
        if (i13 > 1 && zArr[1] && bArr[i11] == 1) {
            zzf(zArr);
            return i11 - 2;
        }
        if (i13 > 2 && zArr[2] && bArr[i11] == 0 && bArr[i11 + 1] == 1) {
            zzf(zArr);
            return i11 - 1;
        }
        int i14 = i12 - 1;
        int i15 = i11 + 2;
        while (i15 < i14) {
            byte b11 = bArr[i15];
            if ((b11 & 254) == 0) {
                int i16 = i15 - 2;
                if (bArr[i16] == 0 && bArr[i15 - 1] == 0 && b11 == 1) {
                    zzf(zArr);
                    return i16;
                }
                i15 = i16;
            }
            i15 += 3;
        }
        zArr[0] = i13 <= 2 ? !(i13 != 2 ? !(zArr[1] && bArr[i14] == 1) : !(zArr[2] && bArr[i12 + (-2)] == 0 && bArr[i14] == 1)) : bArr[i12 + (-3)] == 0 && bArr[i12 + (-2)] == 0 && bArr[i14] == 1;
        zArr[1] = i13 <= 1 ? zArr[2] && bArr[i14] == 0 : bArr[i12 + (-2)] == 0 && bArr[i14] == 0;
        zArr[2] = bArr[i14] == 0;
        return i12;
    }

    public static int zzb(byte[] bArr, int i11) {
        int i12;
        synchronized (zzc) {
            int i13 = 0;
            int i14 = 0;
            while (i13 < i11) {
                while (true) {
                    try {
                        if (i13 >= i11 - 2) {
                            i13 = i11;
                            break;
                        }
                        int i15 = i13 + 1;
                        if (bArr[i13] == 0 && bArr[i15] == 0 && bArr[i13 + 2] == 3) {
                            break;
                        }
                        i13 = i15;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (i13 < i11) {
                    int[] iArr = zzd;
                    int length = iArr.length;
                    if (length <= i14) {
                        zzd = Arrays.copyOf(iArr, length + length);
                    }
                    zzd[i14] = i13;
                    i13 += 3;
                    i14++;
                }
            }
            i12 = i11 - i14;
            int i16 = 0;
            int i17 = 0;
            for (int i18 = 0; i18 < i14; i18++) {
                int i19 = zzd[i18] - i16;
                System.arraycopy(bArr, i16, bArr, i17, i19);
                int i21 = i17 + i19;
                int i22 = i21 + 1;
                bArr[i21] = 0;
                i17 = i21 + 2;
                bArr[i22] = 0;
                i16 += i19 + 3;
            }
            System.arraycopy(bArr, i16, bArr, i17, i12 - i17);
        }
        return i12;
    }

    public static zzgj zzc(byte[] bArr, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int iZzb;
        int i16;
        int i17;
        zzgn zzgnVar = new zzgn(bArr, i11, i12);
        int i18 = 4;
        zzgnVar.zze(4);
        int iZza = zzgnVar.zza(3);
        zzgnVar.zzd();
        int iZza2 = zzgnVar.zza(2);
        boolean zZzf = zzgnVar.zzf();
        int iZza3 = zzgnVar.zza(5);
        int i19 = 0;
        for (int i21 = 0; i21 < 32; i21++) {
            if (zzgnVar.zzf()) {
                i19 |= 1 << i21;
            }
        }
        int i22 = 6;
        int[] iArr = new int[6];
        for (int i23 = 0; i23 < 6; i23++) {
            iArr[i23] = zzgnVar.zza(8);
        }
        int iZza4 = zzgnVar.zza(8);
        int i24 = 0;
        for (int i25 = 0; i25 < iZza; i25++) {
            if (zzgnVar.zzf()) {
                i24 += 89;
            }
            if (zzgnVar.zzf()) {
                i24 += 8;
            }
        }
        zzgnVar.zze(i24);
        if (iZza > 0) {
            int i26 = 8 - iZza;
            zzgnVar.zze(i26 + i26);
        }
        int iZzc = zzgnVar.zzc();
        int iZzc2 = zzgnVar.zzc();
        if (iZzc2 == 3) {
            zzgnVar.zzd();
            iZzc2 = 3;
        }
        int iZzc3 = zzgnVar.zzc();
        int iZzc4 = zzgnVar.zzc();
        if (zzgnVar.zzf()) {
            int iZzc5 = zzgnVar.zzc();
            int iZzc6 = zzgnVar.zzc();
            int iZzc7 = zzgnVar.zzc();
            int iZzc8 = zzgnVar.zzc();
            if (iZzc2 == 1) {
                i17 = 2;
            } else if (iZzc2 == 2) {
                iZzc2 = 2;
                i17 = 2;
            } else {
                i17 = 1;
            }
            iZzc3 -= i17 * (iZzc5 + iZzc6);
            iZzc4 -= (iZzc2 == 1 ? 2 : 1) * (iZzc7 + iZzc8);
        }
        int i27 = iZzc3;
        int i28 = iZzc2;
        int i29 = iZzc4;
        int iZzc9 = zzgnVar.zzc();
        int iZzc10 = zzgnVar.zzc();
        int iZzc11 = zzgnVar.zzc();
        for (int i31 = true != zzgnVar.zzf() ? iZza : 0; i31 <= iZza; i31++) {
            zzgnVar.zzc();
            zzgnVar.zzc();
            zzgnVar.zzc();
        }
        zzgnVar.zzc();
        zzgnVar.zzc();
        zzgnVar.zzc();
        zzgnVar.zzc();
        zzgnVar.zzc();
        zzgnVar.zzc();
        if (zzgnVar.zzf() && zzgnVar.zzf()) {
            int i32 = 0;
            while (i32 < i18) {
                int i33 = 0;
                while (i33 < i22) {
                    if (zzgnVar.zzf()) {
                        int iMin = Math.min(64, 1 << ((i32 + i32) + 4));
                        if (i32 > 1) {
                            zzgnVar.zzb();
                        }
                        for (int i34 = 0; i34 < iMin; i34++) {
                            zzgnVar.zzb();
                        }
                    } else {
                        zzgnVar.zzc();
                    }
                    i33 += i32 == 3 ? 3 : 1;
                    i22 = 6;
                }
                i32++;
                i18 = 4;
                i22 = 6;
            }
        }
        zzgnVar.zze(2);
        if (zzgnVar.zzf()) {
            zzgnVar.zze(8);
            zzgnVar.zzc();
            zzgnVar.zzc();
            zzgnVar.zzd();
        }
        int iZzc12 = zzgnVar.zzc();
        int i35 = 0;
        int[] iArr2 = new int[0];
        int[] iArrCopyOf = new int[0];
        int i36 = -1;
        int i37 = -1;
        int i38 = -1;
        while (i35 < iZzc12) {
            if (i35 == 0 || !zzgnVar.zzf()) {
                int iZzc13 = zzgnVar.zzc();
                int iZzc14 = zzgnVar.zzc();
                int[] iArr3 = new int[iZzc13];
                int i39 = 0;
                while (i39 < iZzc13) {
                    iArr3[i39] = (i39 > 0 ? iArr3[i39 - 1] : 0) - (zzgnVar.zzc() + 1);
                    zzgnVar.zzd();
                    i39++;
                }
                int[] iArr4 = new int[iZzc14];
                int i40 = 0;
                while (i40 < iZzc14) {
                    iArr4[i40] = (i40 > 0 ? iArr4[i40 - 1] : 0) + zzgnVar.zzc() + 1;
                    zzgnVar.zzd();
                    i40++;
                }
                i38 = iZzc14;
                iArrCopyOf = iArr4;
                i37 = iZzc13;
                iArr2 = iArr3;
            } else {
                int i41 = i37 + i38;
                boolean zZzf2 = zzgnVar.zzf();
                int iZzc15 = zzgnVar.zzc() + 1;
                int i42 = 1 - ((zZzf2 ? 1 : 0) + (zZzf2 ? 1 : 0));
                int i43 = i41 + 1;
                boolean[] zArr = new boolean[i43];
                for (int i44 = 0; i44 <= i41; i44++) {
                    if (zzgnVar.zzf()) {
                        zArr[i44] = true;
                    } else {
                        zArr[i44] = zzgnVar.zzf();
                    }
                }
                int i45 = i38 - 1;
                int[] iArr5 = new int[i43];
                int[] iArr6 = new int[i43];
                int i46 = 0;
                while (true) {
                    i16 = i42 * iZzc15;
                    if (i45 < 0) {
                        break;
                    }
                    int i47 = iArrCopyOf[i45] + i16;
                    if (i47 < 0 && zArr[i37 + i45]) {
                        iArr5[i46] = i47;
                        i46++;
                    }
                    i45--;
                }
                if (i16 < 0 && zArr[i41]) {
                    iArr5[i46] = i16;
                    i46++;
                }
                int i48 = i46;
                for (int i49 = 0; i49 < i37; i49++) {
                    int i50 = iArr2[i49] + i16;
                    if (i50 < 0 && zArr[i49]) {
                        iArr5[i48] = i50;
                        i48++;
                    }
                }
                int[] iArrCopyOf2 = Arrays.copyOf(iArr5, i48);
                int i51 = 0;
                for (int i52 = i37 - 1; i52 >= 0; i52--) {
                    int i53 = iArr2[i52] + i16;
                    if (i53 > 0 && zArr[i52]) {
                        iArr6[i51] = i53;
                        i51++;
                    }
                }
                if (i16 > 0 && zArr[i41]) {
                    iArr6[i51] = i16;
                    i51++;
                }
                int i54 = i51;
                for (int i55 = 0; i55 < i38; i55++) {
                    int i56 = iArrCopyOf[i55] + i16;
                    if (i56 > 0 && zArr[i37 + i55]) {
                        iArr6[i54] = i56;
                        i54++;
                    }
                }
                iArrCopyOf = Arrays.copyOf(iArr6, i54);
                i38 = i54;
                iArr2 = iArrCopyOf2;
                i37 = i48;
            }
            i35++;
            i28 = i28;
            i19 = i19;
            iZzc12 = iZzc12;
            iArr = iArr;
        }
        int i57 = i19;
        int i58 = i28;
        int[] iArr7 = iArr;
        if (zzgnVar.zzf()) {
            int iZzc16 = zzgnVar.zzc();
            for (int i59 = 0; i59 < iZzc16; i59++) {
                zzgnVar.zze(iZzc11 + 5);
            }
        }
        zzgnVar.zze(2);
        float f11 = 1.0f;
        if (zzgnVar.zzf()) {
            if (zzgnVar.zzf()) {
                int iZza5 = zzgnVar.zza(8);
                if (iZza5 == 255) {
                    int iZza6 = zzgnVar.zza(16);
                    int iZza7 = zzgnVar.zza(16);
                    if (iZza6 != 0 && iZza7 != 0) {
                        f11 = iZza6 / iZza7;
                    }
                } else if (iZza5 < 17) {
                    f11 = zzb[iZza5];
                } else {
                    zzff.zzf("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iZza5);
                }
            }
            if (zzgnVar.zzf()) {
                zzgnVar.zzd();
            }
            if (zzgnVar.zzf()) {
                zzgnVar.zze(3);
                int i60 = true != zzgnVar.zzf() ? 2 : 1;
                if (zzgnVar.zzf()) {
                    int iZza8 = zzgnVar.zza(8);
                    int iZza9 = zzgnVar.zza(8);
                    zzgnVar.zze(8);
                    int iZza10 = zzt.zza(iZza8);
                    iZzb = zzt.zzb(iZza9);
                    i14 = iZza10;
                    i36 = i60;
                } else {
                    i36 = i60;
                    i14 = -1;
                    iZzb = -1;
                }
            } else {
                i14 = -1;
                iZzb = -1;
            }
            if (zzgnVar.zzf()) {
                zzgnVar.zzc();
                zzgnVar.zzc();
            }
            zzgnVar.zzd();
            if (zzgnVar.zzf()) {
                i29 += i29;
            }
            i15 = iZzb;
            i13 = i29;
        } else {
            i13 = i29;
            i14 = -1;
            i15 = -1;
        }
        return new zzgj(iZza2, zZzf, iZza3, i57, i58, iZzc9, iZzc10, iArr7, iZza4, iZzc, i27, i13, f11, i14, i36, i15);
    }

    public static zzgk zzd(byte[] bArr, int i11, int i12) {
        zzgn zzgnVar = new zzgn(bArr, 4, i12);
        int iZzc = zzgnVar.zzc();
        int iZzc2 = zzgnVar.zzc();
        zzgnVar.zzd();
        return new zzgk(iZzc, iZzc2, zzgnVar.zzf());
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:104:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:105:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:107:0x01db  */
    /* JADX WARN: Code duplicated, block: B:109:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:114:0x00a3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x009f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0055  */
    /* JADX WARN: Code duplicated, block: B:27:0x005b  */
    /* JADX WARN: Code duplicated, block: B:30:0x006e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x0070  */
    /* JADX WARN: Code duplicated, block: B:32:0x0073  */
    /* JADX WARN: Code duplicated, block: B:35:0x0078  */
    /* JADX WARN: Code duplicated, block: B:37:0x007e  */
    /* JADX WARN: Code duplicated, block: B:39:0x0081  */
    /* JADX WARN: Code duplicated, block: B:40:0x0084  */
    /* JADX WARN: Code duplicated, block: B:43:0x008d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x008f  */
    /* JADX WARN: Code duplicated, block: B:46:0x009d  */
    /* JADX WARN: Code duplicated, block: B:63:0x0105  */
    /* JADX WARN: Code duplicated, block: B:66:0x011b  */
    /* JADX WARN: Code duplicated, block: B:69:0x012e  */
    /* JADX WARN: Code duplicated, block: B:71:0x0131  */
    /* JADX WARN: Code duplicated, block: B:72:0x0135  */
    /* JADX WARN: Code duplicated, block: B:74:0x013a  */
    /* JADX WARN: Code duplicated, block: B:75:0x013c  */
    /* JADX WARN: Code duplicated, block: B:80:0x0155  */
    /* JADX WARN: Code duplicated, block: B:82:0x015b  */
    /* JADX WARN: Code duplicated, block: B:84:0x0165  */
    /* JADX WARN: Code duplicated, block: B:88:0x0177  */
    /* JADX WARN: Code duplicated, block: B:89:0x017a  */
    /* JADX WARN: Code duplicated, block: B:91:0x017e  */
    /* JADX WARN: Code duplicated, block: B:92:0x0183  */
    /* JADX WARN: Code duplicated, block: B:95:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:98:0x01a9  */
    /* JADX WARN: Instruction removed from duplicated block: B:92:0x0183, please report this as an issue */
    public static zzgl zze(byte[] bArr, int i11, int i12) {
        int iZzc;
        int i13;
        boolean zZzf;
        int i14;
        int i15;
        boolean z11;
        int i16;
        int i17;
        int i18;
        int i19;
        int iZzb;
        int i21;
        int iZzc2;
        boolean z12;
        boolean zZzf2;
        int i22;
        int i23;
        int i24;
        int iZza;
        float f11;
        int i25;
        int iZzb2;
        float f12;
        int iZza2;
        int iZza3;
        int i26;
        int i27;
        int i28;
        zzgn zzgnVar = new zzgn(bArr, i11, i12);
        int iZza4 = zzgnVar.zza(8);
        int iZza5 = zzgnVar.zza(8);
        int iZza6 = zzgnVar.zza(8);
        int iZzc3 = zzgnVar.zzc();
        int i29 = 1;
        if (iZza4 == 100 || iZza4 == 110 || iZza4 == 122 || iZza4 == 244 || iZza4 == 44 || iZza4 == 83 || iZza4 == 86 || iZza4 == 118 || iZza4 == 128) {
            iZzc = zzgnVar.zzc();
            if (iZzc == 3) {
                zZzf = zzgnVar.zzf();
                i13 = 3;
            } else {
                i13 = iZzc;
                zZzf = false;
            }
            int iZzc4 = zzgnVar.zzc();
            int iZzc5 = zzgnVar.zzc();
            zzgnVar.zzd();
            if (zzgnVar.zzf()) {
                if (i13 != 3) {
                    i16 = 8;
                } else {
                    i16 = 12;
                }
                for (i17 = 0; i17 < i16; i17++) {
                    if (!zzgnVar.zzf()) {
                        if (i17 < 6) {
                            i18 = 16;
                        } else {
                            i18 = 64;
                        }
                        iZzb = 8;
                        i21 = 8;
                        for (i19 = 0; i19 < i18; i19++) {
                            if (iZzb != 0) {
                                iZzb = ((i21 + zzgnVar.zzb()) + 256) % 256;
                            }
                            if (iZzb != 0) {
                                i21 = iZzb;
                            }
                        }
                    }
                }
            }
            i14 = iZzc4;
            i15 = iZzc5;
            z11 = zZzf;
        } else if (iZza4 == 138) {
            iZza4 = TsExtractor.TS_STREAM_TYPE_DTS;
            iZzc = zzgnVar.zzc();
            if (iZzc == 3) {
                zZzf = zzgnVar.zzf();
                i13 = 3;
            } else {
                i13 = iZzc;
                zZzf = false;
            }
            int iZzc6 = zzgnVar.zzc();
            int iZzc7 = zzgnVar.zzc();
            zzgnVar.zzd();
            if (zzgnVar.zzf()) {
                if (i13 != 3) {
                    i16 = 8;
                } else {
                    i16 = 12;
                }
                while (i17 < i16) {
                    if (!zzgnVar.zzf()) {
                        if (i17 < 6) {
                            i18 = 16;
                        } else {
                            i18 = 64;
                        }
                        iZzb = 8;
                        i21 = 8;
                        while (i19 < i18) {
                            if (iZzb != 0) {
                                iZzb = ((i21 + zzgnVar.zzb()) + 256) % 256;
                            }
                            if (iZzb != 0) {
                                i21 = iZzb;
                            }
                        }
                    }
                }
            }
            i14 = iZzc6;
            i15 = iZzc7;
            z11 = zZzf;
        } else {
            iZzc = 1;
            i14 = 0;
            i15 = 0;
            z11 = false;
        }
        int iZzc8 = zzgnVar.zzc() + 4;
        int iZzc9 = zzgnVar.zzc();
        if (iZzc9 != 0) {
            if (iZzc9 == 1) {
                boolean zZzf3 = zzgnVar.zzf();
                zzgnVar.zzb();
                zzgnVar.zzb();
                long jZzc = zzgnVar.zzc();
                iZza5 = iZza5;
                for (int i31 = 0; i31 < jZzc; i31++) {
                    zzgnVar.zzc();
                }
                z12 = zZzf3;
                iZzc9 = 1;
                iZzc2 = 0;
            } else {
                iZzc2 = 0;
            }
            int iZzc10 = zzgnVar.zzc();
            zzgnVar.zzd();
            int iZzc11 = zzgnVar.zzc() + 1;
            int iZzc12 = zzgnVar.zzc() + 1;
            zZzf2 = zzgnVar.zzf();
            i22 = 2 - (zZzf2 ? 1 : 0);
            if (!zZzf2) {
                zzgnVar.zzd();
            }
            zzgnVar.zzd();
            i23 = iZzc11 * 16;
            i24 = iZzc12 * i22 * 16;
            if (zzgnVar.zzf()) {
                int iZzc13 = zzgnVar.zzc();
                int iZzc14 = zzgnVar.zzc();
                int iZzc15 = zzgnVar.zzc();
                int iZzc16 = zzgnVar.zzc();
                if (iZzc != 0) {
                    if (iZzc == 3) {
                        i26 = 1;
                        i27 = 1;
                    } else {
                        i26 = 1;
                        i27 = 2;
                    }
                    if (iZzc == i26) {
                        i28 = 2;
                    } else {
                        i28 = 1;
                    }
                    i22 *= i28;
                    i29 = i27;
                }
                i23 -= (iZzc13 + iZzc14) * i29;
                i24 -= (iZzc15 + iZzc16) * i22;
            }
            int i32 = i23;
            int i33 = i24;
            if (zzgnVar.zzf()) {
                if (zzgnVar.zzf()) {
                    iZza2 = zzgnVar.zza(8);
                    if (iZza2 == 255) {
                        iZza3 = zzgnVar.zza(16);
                        int iZza7 = zzgnVar.zza(16);
                        if (iZza3 != 0 || iZza7 == 0) {
                            f12 = 1.0f;
                        } else {
                            f12 = iZza3 / iZza7;
                        }
                    } else if (iZza2 < 17) {
                        f12 = zzb[iZza2];
                    } else {
                        zzff.zzf("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iZza2);
                        f12 = 1.0f;
                    }
                } else {
                    f12 = 1.0f;
                }
                if (zzgnVar.zzf()) {
                    zzgnVar.zzd();
                }
                if (zzgnVar.zzf()) {
                    zzgnVar.zze(3);
                    i25 = true == zzgnVar.zzf() ? 1 : 2;
                    if (zzgnVar.zzf()) {
                        int iZza8 = zzgnVar.zza(8);
                        int iZza9 = zzgnVar.zza(8);
                        zzgnVar.zze(8);
                        iZza = zzt.zza(iZza8);
                        iZzb2 = zzt.zzb(iZza9);
                        f11 = f12;
                    } else {
                        f11 = f12;
                        iZza = -1;
                        iZzb2 = -1;
                    }
                } else {
                    f11 = f12;
                    iZza = -1;
                }
                return new zzgl(iZza4, iZza5, iZza6, iZzc3, iZzc10, i32, i33, f11, i14, i15, z11, zZzf2, iZzc8, iZzc9, iZzc2, z12, iZza, i25, iZzb2);
            }
            iZza = -1;
            f11 = 1.0f;
            i25 = -1;
            iZzb2 = -1;
            return new zzgl(iZza4, iZza5, iZza6, iZzc3, iZzc10, i32, i33, f11, i14, i15, z11, zZzf2, iZzc8, iZzc9, iZzc2, z12, iZza, i25, iZzb2);
        }
        iZzc2 = zzgnVar.zzc() + 4;
        z12 = false;
        int iZzc17 = zzgnVar.zzc();
        zzgnVar.zzd();
        int iZzc18 = zzgnVar.zzc() + 1;
        int iZzc19 = zzgnVar.zzc() + 1;
        zZzf2 = zzgnVar.zzf();
        i22 = 2 - (zZzf2 ? 1 : 0);
        if (!zZzf2) {
            zzgnVar.zzd();
        }
        zzgnVar.zzd();
        i23 = iZzc18 * 16;
        i24 = iZzc19 * i22 * 16;
        if (zzgnVar.zzf()) {
            int iZzc110 = zzgnVar.zzc();
            int iZzc111 = zzgnVar.zzc();
            int iZzc112 = zzgnVar.zzc();
            int iZzc113 = zzgnVar.zzc();
            if (iZzc != 0) {
                if (iZzc == 3) {
                    i26 = 1;
                    i27 = 1;
                } else {
                    i26 = 1;
                    i27 = 2;
                }
                if (iZzc == i26) {
                    i28 = 2;
                } else {
                    i28 = 1;
                }
                i22 *= i28;
                i29 = i27;
            }
            i23 -= (iZzc110 + iZzc111) * i29;
            i24 -= (iZzc112 + iZzc113) * i22;
        }
        int i34 = i23;
        int i35 = i24;
        if (zzgnVar.zzf()) {
            if (zzgnVar.zzf()) {
                f12 = 1.0f;
            } else {
                iZza2 = zzgnVar.zza(8);
                if (iZza2 == 255) {
                    iZza3 = zzgnVar.zza(16);
                    int iZza10 = zzgnVar.zza(16);
                    if (iZza3 != 0) {
                        f12 = 1.0f;
                    } else {
                        f12 = 1.0f;
                    }
                } else if (iZza2 < 17) {
                    f12 = zzb[iZza2];
                } else {
                    zzff.zzf("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iZza2);
                    f12 = 1.0f;
                }
            }
            if (zzgnVar.zzf()) {
                zzgnVar.zzd();
            }
            if (zzgnVar.zzf()) {
                zzgnVar.zze(3);
                if (true == zzgnVar.zzf()) {
                }
                if (zzgnVar.zzf()) {
                    int iZza11 = zzgnVar.zza(8);
                    int iZza12 = zzgnVar.zza(8);
                    zzgnVar.zze(8);
                    iZza = zzt.zza(iZza11);
                    iZzb2 = zzt.zzb(iZza12);
                    f11 = f12;
                } else {
                    f11 = f12;
                    iZza = -1;
                    iZzb2 = -1;
                }
            } else {
                f11 = f12;
                iZza = -1;
            }
            return new zzgl(iZza4, iZza5, iZza6, iZzc3, iZzc17, i34, i35, f11, i14, i15, z11, zZzf2, iZzc8, iZzc9, iZzc2, z12, iZza, i25, iZzb2);
        }
        iZza = -1;
        f11 = 1.0f;
        i25 = -1;
        iZzb2 = -1;
        return new zzgl(iZza4, iZza5, iZza6, iZzc3, iZzc17, i34, i35, f11, i14, i15, z11, zZzf2, iZzc8, iZzc9, iZzc2, z12, iZza, i25, iZzb2);
    }

    public static void zzf(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }
}
