package com.google.android.gms.internal.ads;

import com.applovin.exoplayer2.common.base.Ascii;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzhdc extends zzhdb {
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        if (r13[r14] <= (-65)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0047, code lost:
    
        if (r13[r14] <= (-65)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0080, code lost:
    
        if (r13[r14] <= (-65)) goto L11;
     */
    @Override // com.google.android.gms.internal.ads.zzhdb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zza(int i11, byte[] bArr, int i12, int i13) {
        int i14;
        int i15;
        if (i11 != 0) {
            if (i12 >= i13) {
                return i11;
            }
            byte b11 = (byte) i11;
            if (b11 < -32) {
                if (b11 >= -62) {
                    i15 = i12 + 1;
                }
                return -1;
            }
            int i16 = ~(i11 >> 8);
            if (b11 < -16) {
                byte b12 = (byte) i16;
                if (b12 == 0) {
                    int i17 = i12 + 1;
                    byte b13 = bArr[i12];
                    if (i17 >= i13) {
                        return zzhde.zzk(b11, b13);
                    }
                    i12 = i17;
                    b12 = b13;
                }
                if (b12 <= -65 && ((b11 != -32 || b12 >= -96) && (b11 != -19 || b12 < -96))) {
                    i15 = i12 + 1;
                }
                return -1;
            }
            byte b14 = (byte) i16;
            if (b14 == 0) {
                int i18 = i12 + 1;
                b14 = bArr[i12];
                if (i18 >= i13) {
                    return zzhde.zzk(b11, b14);
                }
                i12 = i18;
                i14 = 0;
            } else {
                i14 = i11 >> 16;
            }
            if (i14 == 0) {
                int i19 = i12 + 1;
                byte b15 = bArr[i12];
                if (i19 >= i13) {
                    return zzhde.zzl(b11, b14, b15);
                }
                i12 = i19;
                i14 = b15;
            }
            if (b14 <= -65 && (((b11 << Ascii.FS) + (b14 + 112)) >> 30) == 0 && i14 <= -65) {
                i15 = i12 + 1;
            }
            return -1;
            i12 = i15;
        }
        while (i12 < i13 && bArr[i12] >= 0) {
            i12++;
        }
        if (i12 >= i13) {
            return 0;
        }
        while (i12 < i13) {
            int i21 = i12 + 1;
            byte b16 = bArr[i12];
            if (b16 < 0) {
                if (b16 < -32) {
                    if (i21 >= i13) {
                        return b16;
                    }
                    if (b16 >= -62) {
                        i12 += 2;
                        if (bArr[i21] > -65) {
                        }
                    }
                    return -1;
                }
                if (b16 >= -16) {
                    if (i21 >= i13 - 2) {
                        return zzhde.zzc(bArr, i21, i13);
                    }
                    int i22 = i12 + 2;
                    byte b17 = bArr[i21];
                    if (b17 <= -65 && (((b16 << Ascii.FS) + (b17 + 112)) >> 30) == 0) {
                        int i23 = i12 + 3;
                        if (bArr[i22] <= -65) {
                            i12 += 4;
                            if (bArr[i23] > -65) {
                            }
                        }
                    }
                    return -1;
                }
                if (i21 >= i13 - 1) {
                    return zzhde.zzc(bArr, i21, i13);
                }
                int i24 = i12 + 2;
                byte b18 = bArr[i21];
                if (b18 <= -65 && ((b16 != -32 || b18 >= -96) && (b16 != -19 || b18 < -96))) {
                    i12 += 3;
                    if (bArr[i24] > -65) {
                    }
                }
                return -1;
            }
            i12 = i21;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhdb
    public final String zzb(byte[] bArr, int i11, int i12) throws zzhag {
        int i13;
        int length = bArr.length;
        if ((((length - i11) - i12) | i11 | i12) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i11), Integer.valueOf(i12)));
        }
        int i14 = i11 + i12;
        char[] cArr = new char[i12];
        int i15 = 0;
        while (i11 < i14) {
            byte b11 = bArr[i11];
            if (!zzhda.zzd(b11)) {
                break;
            }
            i11++;
            cArr[i15] = (char) b11;
            i15++;
        }
        while (i11 < i14) {
            int i16 = i11 + 1;
            byte b12 = bArr[i11];
            if (zzhda.zzd(b12)) {
                cArr[i15] = (char) b12;
                i15++;
                i11 = i16;
                while (i11 < i14) {
                    byte b13 = bArr[i11];
                    if (!zzhda.zzd(b13)) {
                        break;
                    }
                    i11++;
                    cArr[i15] = (char) b13;
                    i15++;
                }
            } else {
                if (zzhda.zzf(b12)) {
                    if (i16 >= i14) {
                        throw zzhag.zzd();
                    }
                    i13 = i15 + 1;
                    i11 += 2;
                    zzhda.zzc(b12, bArr[i16], cArr, i15);
                } else if (zzhda.zze(b12)) {
                    if (i16 >= i14 - 1) {
                        throw zzhag.zzd();
                    }
                    i13 = i15 + 1;
                    int i17 = i11 + 2;
                    i11 += 3;
                    zzhda.zzb(b12, bArr[i16], bArr[i17], cArr, i15);
                } else {
                    if (i16 >= i14 - 2) {
                        throw zzhag.zzd();
                    }
                    byte b14 = bArr[i16];
                    int i18 = i11 + 3;
                    byte b15 = bArr[i11 + 2];
                    i11 += 4;
                    zzhda.zza(b12, b14, b15, bArr[i18], cArr, i15);
                    i15 += 2;
                }
                i15 = i13;
            }
        }
        return new String(cArr, 0, i15);
    }
}
