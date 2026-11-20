package com.google.android.libraries.places.internal;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbug {
    String zza;
    String zzb;
    int zzc = -1;

    /* JADX WARN: Code duplicated, block: B:34:0x0060  */
    /* JADX WARN: Code duplicated, block: B:44:0x0079 A[LOOP:3: B:33:0x005e->B:44:0x0079, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:47:0x0081 A[LOOP:2: B:25:0x004b->B:47:0x0081, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:54:0x0096  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a1 A[LOOP:1: B:53:0x0094->B:57:0x00a1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:83:0x00a7 A[EDGE_INSN: B:83:0x00a7->B:58:0x00a7 BREAK  A[LOOP:1: B:53:0x0094->B:57:0x00a1], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x0091 A[SYNTHETIC] */
    private static InetAddress zzf(String str, int i11, int i12) {
        int i13;
        int i14;
        char cCharAt;
        int i15;
        int i16;
        int iZza;
        byte[] bArr = new byte[16];
        int i17 = 0;
        int i18 = 1;
        int i19 = 0;
        int i21 = -1;
        int i22 = -1;
        while (i18 < i12) {
            if (i19 == 16) {
                return null;
            }
            int i23 = i18 + 2;
            if (i23 <= i12 && str.regionMatches(i18, "::", i17, 2)) {
                if (i21 != -1) {
                    return null;
                }
                i19 += 2;
                if (i23 == i12) {
                    i21 = i19;
                    break;
                }
                i21 = i19;
                i22 = i23;
                i18 = i22;
                i15 = 0;
                while (i18 < i12) {
                    iZza = zzbui.zza(str.charAt(i18));
                    if (iZza == -1) {
                        break;
                        break;
                    }
                    i18++;
                    i15 = (i15 << 4) + iZza;
                }
                i16 = i18 - i22;
                if (i16 != 0) {
                }
                return null;
            }
            if (i19 != 0) {
                if (!str.regionMatches(i18, ":", i17, 1)) {
                    if (str.regionMatches(i18, InstructionFileId.DOT, i17, 1)) {
                        int i24 = i19 - 2;
                        int i25 = i24;
                        while (i22 < i12) {
                            if (i25 != 16) {
                                if (i25 == i24) {
                                    i13 = i22;
                                    i14 = 0;
                                    while (i13 < i12) {
                                        cCharAt = str.charAt(i13);
                                        if (cCharAt < '0' || cCharAt > '9') {
                                            break;
                                        }
                                        if (i14 != 0) {
                                            i14 = ((i14 * 10) + cCharAt) - 48;
                                            if (i14 <= 255) {
                                                i13++;
                                            }
                                        } else if (i22 == i13) {
                                            i14 = 0;
                                            i14 = ((i14 * 10) + cCharAt) - 48;
                                            if (i14 <= 255) {
                                                i13++;
                                            }
                                        }
                                    }
                                    if (i13 - i22 != 0) {
                                        bArr[i25] = (byte) i14;
                                        i25++;
                                        i22 = i13;
                                    }
                                } else if (str.charAt(i22) == '.') {
                                    i22++;
                                    i13 = i22;
                                    i14 = 0;
                                    while (i13 < i12) {
                                        cCharAt = str.charAt(i13);
                                        if (cCharAt < '0') {
                                            break;
                                        }
                                        break;
                                        break;
                                    }
                                    if (i13 - i22 != 0) {
                                        bArr[i25] = (byte) i14;
                                        i25++;
                                        i22 = i13;
                                    }
                                }
                            }
                        }
                        if (i25 == i19 + 2) {
                            i19 += 2;
                            break;
                        }
                    }
                    return null;
                }
                i18++;
            }
            i22 = i18;
            i18 = i22;
            i15 = 0;
            while (i18 < i12) {
                iZza = zzbui.zza(str.charAt(i18));
                if (iZza == -1) {
                    break;
                }
                i18++;
                i15 = (i15 << 4) + iZza;
            }
            i16 = i18 - i22;
            if (i16 != 0 || i16 > 4) {
                return null;
            }
            int i26 = i19 + 1;
            bArr[i19] = (byte) ((i15 >>> 8) & 255);
            i19 += 2;
            bArr[i26] = (byte) (i15 & 255);
            i17 = 0;
        }
        if (i19 != 16) {
            if (i21 == -1) {
                return null;
            }
            int i27 = i19 - i21;
            System.arraycopy(bArr, i21, bArr, 16 - i27, i27);
            Arrays.fill(bArr, i21, (16 - i19) + i21, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.zza);
        sb2.append("://");
        if (this.zzb.indexOf(58) != -1) {
            sb2.append('[');
            sb2.append(this.zzb);
            sb2.append(']');
        } else {
            sb2.append(this.zzb);
        }
        int iZza = zza();
        if (iZza != zzbui.zzb(this.zza)) {
            sb2.append(':');
            sb2.append(iZza);
        }
        return sb2.toString();
    }

    public final int zza() {
        int i11 = this.zzc;
        return i11 != -1 ? i11 : zzbui.zzb(this.zza);
    }

    public final zzbug zzb(String str) {
        int i11;
        String strSubstring;
        if (str == null) {
            throw new IllegalArgumentException("host == null");
        }
        int i12 = 0;
        int iCharCount = 0;
        while (true) {
            int length = str.length();
            i11 = -1;
            if (iCharCount >= length) {
                strSubstring = str.substring(0, length);
                break;
            }
            if (str.charAt(iCharCount) == '%') {
                zzbwb zzbwbVar = new zzbwb();
                zzbwbVar.zzt(str, 0, iCharCount);
                while (iCharCount < length) {
                    int iCodePointAt = str.codePointAt(iCharCount);
                    if (iCodePointAt != 37) {
                        zzbwbVar.zzu(iCodePointAt);
                    } else {
                        int i13 = iCharCount + 2;
                        if (i13 < length) {
                            int iZza = zzbui.zza(str.charAt(iCharCount + 1));
                            int iZza2 = zzbui.zza(str.charAt(i13));
                            if (iZza != -1 && iZza2 != -1) {
                                zzbwbVar.zzm((iZza << 4) + iZza2);
                                iCharCount = i13;
                                iCodePointAt = 37;
                            }
                        }
                        iCodePointAt = 37;
                        zzbwbVar.zzu(iCodePointAt);
                    }
                    iCharCount += Character.charCount(iCodePointAt);
                }
                strSubstring = zzbwbVar.zzi();
                break;
            }
            iCharCount++;
        }
        String strZzi = null;
        if (strSubstring.startsWith("[") && strSubstring.endsWith("]")) {
            InetAddress inetAddressZzf = zzf(strSubstring, 1, strSubstring.length() - 1);
            if (inetAddressZzf != null) {
                byte[] address = inetAddressZzf.getAddress();
                if (address.length != 16) {
                    throw new AssertionError();
                }
                int i14 = 0;
                int i15 = 0;
                while (i14 < address.length) {
                    int i16 = i14;
                    while (i16 < 16 && address[i16] == 0 && address[i16 + 1] == 0) {
                        i16 += 2;
                    }
                    int i17 = i16 - i14;
                    int i18 = i17 > i15 ? i17 : i15;
                    if (i17 > i15) {
                        i11 = i14;
                    }
                    i14 = i16 + 2;
                    i15 = i18;
                }
                zzbwb zzbwbVar2 = new zzbwb();
                while (i12 < address.length) {
                    if (i12 == i11) {
                        zzbwbVar2.zzm(58);
                        i12 += i15;
                        if (i12 == 16) {
                            zzbwbVar2.zzm(58);
                        }
                    } else {
                        if (i12 > 0) {
                            zzbwbVar2.zzm(58);
                        }
                        zzbwbVar2.zzo(((address[i12] & 255) << 8) | (address[i12 + 1] & 255));
                        i12 += 2;
                    }
                }
                strZzi = zzbwbVar2.zzi();
            }
        } else {
            try {
                String lowerCase = IDN.toASCII(strSubstring).toLowerCase(Locale.US);
                if (!lowerCase.isEmpty()) {
                    while (true) {
                        if (i12 >= lowerCase.length()) {
                            strZzi = lowerCase;
                            break;
                        }
                        char cCharAt = lowerCase.charAt(i12);
                        if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                            break;
                            break;
                            break;
                        }
                        i12++;
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        if (strZzi == null) {
            throw new IllegalArgumentException("unexpected host: ".concat(str));
        }
        this.zzb = strZzi;
        return this;
    }

    public final zzbug zzc(int i11) {
        if (i11 > 0 && i11 <= 65535) {
            this.zzc = i11;
            return this;
        }
        throw new IllegalArgumentException("unexpected port: " + i11);
    }

    public final zzbug zzd(String str) {
        this.zza = "https";
        return this;
    }

    public final zzbui zze() {
        if (this.zza == null) {
            throw new IllegalStateException("scheme == null");
        }
        if (this.zzb != null) {
            return new zzbui(this, null);
        }
        throw new IllegalStateException("host == null");
    }
}
