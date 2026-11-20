package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzhde {
    private static final zzhdb zza;

    static {
        if (zzhcz.zzA() && zzhcz.zzB()) {
            int i11 = zzgxw.zza;
        }
        zza = new zzhdc();
    }

    public static /* bridge */ /* synthetic */ int zzc(byte[] bArr, int i11, int i12) {
        int i13 = i12 - i11;
        byte b11 = bArr[i11 - 1];
        if (i13 == 0) {
            if (b11 > -12) {
                return -1;
            }
            return b11;
        }
        if (i13 == 1) {
            return zzk(b11, bArr[i11]);
        }
        if (i13 == 2) {
            return zzl(b11, bArr[i11], bArr[i11 + 1]);
        }
        throw new AssertionError();
    }

    public static int zzd(String str, byte[] bArr, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        char cCharAt;
        int length = str.length();
        int i16 = 0;
        while (true) {
            i13 = i11 + i12;
            if (i16 >= length || (i15 = i16 + i11) >= i13 || (cCharAt = str.charAt(i16)) >= 128) {
                break;
            }
            bArr[i15] = (byte) cCharAt;
            i16++;
        }
        if (i16 == length) {
            return i11 + length;
        }
        int i17 = i11 + i16;
        while (i16 < length) {
            char cCharAt2 = str.charAt(i16);
            if (cCharAt2 < 128 && i17 < i13) {
                bArr[i17] = (byte) cCharAt2;
                i17++;
            } else if (cCharAt2 < 2048 && i17 <= i13 - 2) {
                bArr[i17] = (byte) ((cCharAt2 >>> 6) | 960);
                bArr[i17 + 1] = (byte) ((cCharAt2 & '?') | 128);
                i17 += 2;
            } else {
                if ((cCharAt2 >= 55296 && cCharAt2 <= 57343) || i17 > i13 - 3) {
                    if (i17 > i13 - 4) {
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343 && ((i14 = i16 + 1) == str.length() || !Character.isSurrogatePair(cCharAt2, str.charAt(i14)))) {
                            throw new zzhdd(i16, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i17);
                    }
                    int i18 = i16 + 1;
                    if (i18 != str.length()) {
                        char cCharAt3 = str.charAt(i18);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int i19 = i17 + 3;
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            bArr[i17] = (byte) ((codePoint >>> 18) | 240);
                            bArr[i17 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                            bArr[i17 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i17 += 4;
                            bArr[i19] = (byte) ((codePoint & 63) | 128);
                            i16 = i18;
                        } else {
                            i16 = i18;
                        }
                    }
                    throw new zzhdd(i16 - 1, length);
                }
                bArr[i17] = (byte) ((cCharAt2 >>> '\f') | 480);
                bArr[i17 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                bArr[i17 + 2] = (byte) ((cCharAt2 & '?') | 128);
                i17 += 3;
            }
            i16++;
        }
        return i17;
    }

    public static int zze(String str) {
        int length = str.length();
        int i11 = 0;
        int i12 = 0;
        while (i12 < length && str.charAt(i12) < 128) {
            i12++;
        }
        int i13 = length;
        while (i12 < length) {
            char cCharAt = str.charAt(i12);
            if (cCharAt >= 2048) {
                int length2 = str.length();
                while (i12 < length2) {
                    char cCharAt2 = str.charAt(i12);
                    if (cCharAt2 < 2048) {
                        i11 += (127 - cCharAt2) >>> 31;
                    } else {
                        i11 += 2;
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(str, i12) < 65536) {
                                throw new zzhdd(i12, length2);
                            }
                            i12++;
                        }
                    }
                    i12++;
                }
                i13 += i11;
                break;
            }
            i13 += (127 - cCharAt) >>> 31;
            i12++;
        }
        if (i13 >= length) {
            return i13;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i13) + 4294967296L));
    }

    public static int zzf(int i11, byte[] bArr, int i12, int i13) {
        return zza.zza(i11, bArr, i12, i13);
    }

    public static String zzg(ByteBuffer byteBuffer, int i11, int i12) throws zzhag {
        zzhdb zzhdbVar = zza;
        if (byteBuffer.hasArray()) {
            return zzhdbVar.zzb(byteBuffer.array(), byteBuffer.arrayOffset() + i11, i12);
        }
        return byteBuffer.isDirect() ? zzhdb.zzd(byteBuffer, i11, i12) : zzhdb.zzd(byteBuffer, i11, i12);
    }

    public static String zzh(byte[] bArr, int i11, int i12) throws zzhag {
        return zza.zzb(bArr, i11, i12);
    }

    public static boolean zzi(byte[] bArr) {
        return zza.zzc(bArr, 0, bArr.length);
    }

    public static boolean zzj(byte[] bArr, int i11, int i12) {
        return zza.zzc(bArr, i11, i12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzk(int i11, int i12) {
        if (i11 > -12 || i12 > -65) {
            return -1;
        }
        return i11 ^ (i12 << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzl(int i11, int i12, int i13) {
        if (i11 > -12 || i12 > -65 || i13 > -65) {
            return -1;
        }
        return (i11 ^ (i12 << 8)) ^ (i13 << 16);
    }
}
