package com.google.android.libraries.places.internal;

import androidx.core.view.MotionEventCompat;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbta {
    private final String zza;
    private final int zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private char[] zzg;

    public zzbta(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.zza = name;
        this.zzb = name.length();
    }

    private final char zzb() {
        int i11;
        int i12;
        int i13 = this.zzc + 1;
        this.zzc = i13;
        if (i13 == this.zzb) {
            throw new IllegalStateException("Unexpected end of DN: ".concat(String.valueOf(this.zza)));
        }
        char c11 = this.zzg[i13];
        if (c11 != ' ' && c11 != '%' && c11 != '\\' && c11 != '_' && c11 != '\"' && c11 != '#') {
            switch (c11) {
                default:
                    switch (c11) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            break;
                        default:
                            int iZzc = zzc(i13);
                            this.zzc++;
                            if (iZzc >= 128) {
                                if (iZzc < 192 || iZzc > 247) {
                                    iZzc = 63;
                                } else {
                                    if (iZzc <= 223) {
                                        i11 = iZzc & 31;
                                        i12 = 1;
                                    } else if (iZzc <= 239) {
                                        i11 = iZzc & 15;
                                        i12 = 2;
                                    } else {
                                        i11 = iZzc & 7;
                                        i12 = 3;
                                    }
                                    int i14 = 0;
                                    while (true) {
                                        if (i14 < i12) {
                                            int i15 = this.zzc;
                                            int i16 = i15 + 1;
                                            this.zzc = i16;
                                            if (i16 != this.zzb && this.zzg[i16] == '\\') {
                                                int i17 = i15 + 2;
                                                this.zzc = i17;
                                                int iZzc2 = zzc(i17);
                                                this.zzc++;
                                                if ((iZzc2 & PsExtractor.AUDIO_STREAM) == 128) {
                                                    i11 = (i11 << 6) + (iZzc2 & 63);
                                                    i14++;
                                                }
                                            }
                                            iZzc = 63;
                                        } else {
                                            iZzc = (char) i11;
                                        }
                                    }
                                }
                            }
                            return (char) iZzc;
                    }
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    return c11;
            }
        }
        return c11;
    }

    private final int zzc(int i11) {
        int i12;
        int i13;
        int i14 = i11 + 1;
        if (i14 >= this.zzb) {
            throw new IllegalStateException("Malformed DN: ".concat(String.valueOf(this.zza)));
        }
        char[] cArr = this.zzg;
        char c11 = cArr[i11];
        if (c11 >= '0' && c11 <= '9') {
            i12 = c11 - '0';
        } else if (c11 >= 'a' && c11 <= 'f') {
            i12 = c11 - 'W';
        } else {
            if (c11 < 'A' || c11 > 'F') {
                throw new IllegalStateException("Malformed DN: ".concat(String.valueOf(this.zza)));
            }
            i12 = c11 - '7';
        }
        char c12 = cArr[i14];
        if (c12 >= '0' && c12 <= '9') {
            i13 = c12 - '0';
        } else if (c12 >= 'a' && c12 <= 'f') {
            i13 = c12 - 'W';
        } else {
            if (c12 < 'A' || c12 > 'F') {
                throw new IllegalStateException("Malformed DN: ".concat(String.valueOf(this.zza)));
            }
            i13 = c12 - '7';
        }
        return (i12 << 4) + i13;
    }

    private final String zzd() {
        int i11;
        int i12;
        int i13;
        int i14;
        char c11;
        char c12;
        char c13;
        int i15;
        char c14;
        char c15;
        while (true) {
            i11 = this.zzc;
            i12 = this.zzb;
            if (i11 >= i12 || this.zzg[i11] != ' ') {
                break;
            }
            this.zzc = i11 + 1;
        }
        if (i11 == i12) {
            return null;
        }
        this.zzd = i11;
        this.zzc = i11 + 1;
        while (true) {
            i13 = this.zzc;
            i14 = this.zzb;
            if (i13 >= i14 || (c15 = this.zzg[i13]) == '=' || c15 == ' ') {
                break;
            }
            this.zzc = i13 + 1;
        }
        if (i13 >= i14) {
            throw new IllegalStateException("Unexpected end of DN: ".concat(String.valueOf(this.zza)));
        }
        this.zze = i13;
        if (this.zzg[i13] == ' ') {
            while (true) {
                i13 = this.zzc;
                i15 = this.zzb;
                if (i13 >= i15 || (c14 = this.zzg[i13]) == '=' || c14 != ' ') {
                    break;
                }
                this.zzc = i13 + 1;
            }
            if (this.zzg[i13] != '=' || i13 == i15) {
                throw new IllegalStateException("Unexpected end of DN: ".concat(String.valueOf(this.zza)));
            }
        }
        this.zzc = i13 + 1;
        while (true) {
            int i16 = this.zzc;
            if (i16 >= this.zzb || this.zzg[i16] != ' ') {
                break;
            }
            this.zzc = i16 + 1;
        }
        int i17 = this.zze;
        int i18 = this.zzd;
        if (i17 - i18 > 4) {
            char[] cArr = this.zzg;
            if (cArr[i18 + 3] == '.' && (((c11 = cArr[i18]) == 'O' || c11 == 'o') && (((c12 = cArr[i18 + 1]) == 'I' || c12 == 'i') && ((c13 = cArr[i18 + 2]) == 'D' || c13 == 'd')))) {
                i18 += 4;
                this.zzd = i18;
            }
        }
        return new String(this.zzg, i18, i17 - i18);
    }

    public final String zza(String str) {
        String str2;
        char[] cArr;
        char c11;
        int i11;
        int i12;
        char c12;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = 0;
        this.zzf = 0;
        this.zzg = this.zza.toCharArray();
        String strZzd = zzd();
        if (strZzd == null) {
            return null;
        }
        do {
            int i13 = this.zzc;
            int i14 = this.zzb;
            if (i13 == i14) {
                return null;
            }
            char c13 = this.zzg[i13];
            if (c13 == '\"') {
                int i15 = i13 + 1;
                this.zzc = i15;
                this.zzd = i15;
                this.zze = i15;
                while (true) {
                    int i16 = this.zzc;
                    if (i16 == this.zzb) {
                        throw new IllegalStateException("Unexpected end of DN: ".concat(String.valueOf(this.zza)));
                    }
                    char[] cArr2 = this.zzg;
                    char c14 = cArr2[i16];
                    if (c14 == '\"') {
                        this.zzc = i16 + 1;
                        while (true) {
                            int i17 = this.zzc;
                            if (i17 >= this.zzb || this.zzg[i17] != ' ') {
                                break;
                            }
                            this.zzc = i17 + 1;
                        }
                        char[] cArr3 = this.zzg;
                        int i18 = this.zzd;
                        str2 = new String(cArr3, i18, this.zze - i18);
                        break;
                    }
                    if (c14 == '\\') {
                        cArr2[this.zze] = zzb();
                    } else {
                        cArr2[this.zze] = c14;
                    }
                    this.zzc++;
                    this.zze++;
                }
            } else if (c13 != '#') {
                if (c13 == '+' || c13 == ',' || c13 == ';') {
                    str2 = "";
                } else {
                    this.zzd = i13;
                    this.zze = i13;
                    while (true) {
                        int i19 = this.zzc;
                        if (i19 >= this.zzb) {
                            char[] cArr4 = this.zzg;
                            int i21 = this.zzd;
                            str2 = new String(cArr4, i21, this.zze - i21);
                            break;
                        }
                        char[] cArr5 = this.zzg;
                        char c15 = cArr5[i19];
                        if (c15 != ' ') {
                            if (c15 != ';') {
                                if (c15 == '\\') {
                                    int i22 = this.zze;
                                    this.zze = i22 + 1;
                                    cArr5[i22] = zzb();
                                    this.zzc++;
                                } else if (c15 != '+' && c15 != ',') {
                                    int i23 = this.zze;
                                    this.zze = i23 + 1;
                                    cArr5[i23] = c15;
                                    this.zzc = i19 + 1;
                                }
                            }
                            int i24 = this.zzd;
                            str2 = new String(cArr5, i24, this.zze - i24);
                            break;
                        }
                        int i25 = this.zze;
                        this.zzf = i25;
                        this.zzc = i19 + 1;
                        this.zze = i25 + 1;
                        cArr5[i25] = ' ';
                        while (true) {
                            i11 = this.zzc;
                            i12 = this.zzb;
                            if (i11 >= i12) {
                                break;
                            }
                            char[] cArr6 = this.zzg;
                            if (cArr6[i11] != ' ') {
                                break;
                            }
                            int i26 = this.zze;
                            this.zze = i26 + 1;
                            cArr6[i26] = ' ';
                            this.zzc = i11 + 1;
                        }
                        if (i11 == i12 || (c12 = this.zzg[i11]) == ',' || c12 == '+' || c12 == ';') {
                            char[] cArr7 = this.zzg;
                            int i27 = this.zzd;
                            str2 = new String(cArr7, i27, this.zzf - i27);
                            break;
                        }
                    }
                }
            } else {
                if (i13 + 4 >= i14) {
                    throw new IllegalStateException("Unexpected end of DN: ".concat(String.valueOf(this.zza)));
                }
                this.zzd = i13;
                this.zzc = i13 + 1;
                while (true) {
                    int i28 = this.zzc;
                    if (i28 == this.zzb || (c11 = (cArr = this.zzg)[i28]) == '+' || c11 == ',' || c11 == ';') {
                        this.zze = i28;
                        break;
                    }
                    int i29 = i28 + 1;
                    if (c11 == ' ') {
                        this.zze = i28;
                        this.zzc = i29;
                        while (true) {
                            int i31 = this.zzc;
                            if (i31 >= this.zzb || this.zzg[i31] != ' ') {
                                break;
                            }
                            this.zzc = i31 + 1;
                        }
                    } else {
                        if (c11 >= 'A' && c11 <= 'F') {
                            cArr[i28] = (char) (c11 + ' ');
                        }
                        this.zzc = i29;
                    }
                }
                int i32 = this.zze;
                int i33 = this.zzd;
                int i34 = i32 - i33;
                if (i34 < 5 || (i34 & 1) == 0) {
                    throw new IllegalStateException("Unexpected end of DN: ".concat(String.valueOf(this.zza)));
                }
                int i35 = i34 >> 1;
                byte[] bArr = new byte[i35];
                int i36 = i33 + 1;
                int i37 = 0;
                while (i37 < i35) {
                    bArr[i37] = (byte) zzc(i36);
                    i37++;
                    i36 += 2;
                }
                str2 = new String(this.zzg, this.zzd, i34);
            }
            if ("cn".equalsIgnoreCase(strZzd)) {
                return str2;
            }
            int i38 = this.zzc;
            if (i38 >= this.zzb) {
                return null;
            }
            char c16 = this.zzg[i38];
            if (c16 != ',' && c16 != ';' && c16 != '+') {
                throw new IllegalStateException("Malformed DN: ".concat(String.valueOf(this.zza)));
            }
            this.zzc = i38 + 1;
            strZzd = zzd();
        } while (strZzd != null);
        throw new IllegalStateException("Malformed DN: ".concat(String.valueOf(this.zza)));
    }
}
