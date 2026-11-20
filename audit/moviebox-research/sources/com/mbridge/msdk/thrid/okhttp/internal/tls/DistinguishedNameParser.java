package com.mbridge.msdk.thrid.okhttp.internal.tls;

import androidx.core.view.MotionEventCompat;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
final class DistinguishedNameParser {
    private int beg;
    private char[] chars;
    private int cur;

    /* JADX INFO: renamed from: dn, reason: collision with root package name */
    private final String f47331dn;
    private int end;
    private final int length;
    private int pos;

    public DistinguishedNameParser(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f47331dn = name;
        this.length = name.length();
    }

    private String escapedAV() {
        int i11;
        int i12;
        char c11;
        int i13 = this.pos;
        this.beg = i13;
        this.end = i13;
        while (true) {
            int i14 = this.pos;
            if (i14 >= this.length) {
                char[] cArr = this.chars;
                int i15 = this.beg;
                return new String(cArr, i15, this.end - i15);
            }
            char[] cArr2 = this.chars;
            char c12 = cArr2[i14];
            if (c12 != ' ') {
                if (c12 != ';') {
                    if (c12 == '\\') {
                        int i16 = this.end;
                        this.end = i16 + 1;
                        cArr2[i16] = getEscaped();
                        this.pos++;
                    } else if (c12 != '+' && c12 != ',') {
                        int i17 = this.end;
                        this.end = i17 + 1;
                        cArr2[i17] = c12;
                        this.pos = i14 + 1;
                    }
                }
                int i18 = this.beg;
                return new String(cArr2, i18, this.end - i18);
            }
            int i19 = this.end;
            this.cur = i19;
            this.pos = i14 + 1;
            this.end = i19 + 1;
            cArr2[i19] = ' ';
            while (true) {
                i11 = this.pos;
                i12 = this.length;
                if (i11 >= i12) {
                    break;
                }
                char[] cArr3 = this.chars;
                if (cArr3[i11] != ' ') {
                    break;
                }
                int i21 = this.end;
                this.end = i21 + 1;
                cArr3[i21] = ' ';
                this.pos = i11 + 1;
            }
            if (i11 == i12 || (c11 = this.chars[i11]) == ',' || c11 == '+' || c11 == ';') {
                char[] cArr4 = this.chars;
                int i22 = this.beg;
                return new String(cArr4, i22, this.cur - i22);
            }
        }
    }

    private int getByte(int i11) {
        int i12;
        int i13;
        int i14 = i11 + 1;
        if (i14 >= this.length) {
            throw new IllegalStateException("Malformed DN: " + this.f47331dn);
        }
        char[] cArr = this.chars;
        char c11 = cArr[i11];
        if (c11 >= '0' && c11 <= '9') {
            i12 = c11 - '0';
        } else if (c11 >= 'a' && c11 <= 'f') {
            i12 = c11 - 'W';
        } else {
            if (c11 < 'A' || c11 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f47331dn);
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
                throw new IllegalStateException("Malformed DN: " + this.f47331dn);
            }
            i13 = c12 - '7';
        }
        return (i12 << 4) + i13;
    }

    private char getEscaped() {
        int i11 = this.pos + 1;
        this.pos = i11;
        if (i11 == this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f47331dn);
        }
        char c11 = this.chars[i11];
        if (c11 == ' ' || c11 == '%' || c11 == '\\' || c11 == '_' || c11 == '\"' || c11 == '#') {
            return c11;
        }
        switch (c11) {
            case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
            case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
            case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                return c11;
            default:
                switch (c11) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        return c11;
                    default:
                        return getUTF8();
                }
        }
    }

    private char getUTF8() {
        int i11;
        int i12;
        int i13 = getByte(this.pos);
        this.pos++;
        if (i13 < 128) {
            return (char) i13;
        }
        if (i13 < 192 || i13 > 247) {
            return '?';
        }
        if (i13 <= 223) {
            i11 = i13 & 31;
            i12 = 1;
        } else if (i13 <= 239) {
            i11 = i13 & 15;
            i12 = 2;
        } else {
            i11 = i13 & 7;
            i12 = 3;
        }
        for (int i14 = 0; i14 < i12; i14++) {
            int i15 = this.pos;
            int i16 = i15 + 1;
            this.pos = i16;
            if (i16 == this.length || this.chars[i16] != '\\') {
                return '?';
            }
            int i17 = i15 + 2;
            this.pos = i17;
            int i18 = getByte(i17);
            this.pos++;
            if ((i18 & PsExtractor.AUDIO_STREAM) != 128) {
                return '?';
            }
            i11 = (i11 << 6) + (i18 & 63);
        }
        return (char) i11;
    }

    private String hexAV() {
        char[] cArr;
        char c11;
        int i11 = this.pos;
        if (i11 + 4 >= this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f47331dn);
        }
        this.beg = i11;
        this.pos = i11 + 1;
        while (true) {
            int i12 = this.pos;
            if (i12 == this.length || (c11 = (cArr = this.chars)[i12]) == '+' || c11 == ',' || c11 == ';') {
                this.end = i12;
                break;
            }
            if (c11 == ' ') {
                this.end = i12;
                this.pos = i12 + 1;
                while (true) {
                    int i13 = this.pos;
                    if (i13 >= this.length || this.chars[i13] != ' ') {
                        break;
                    }
                    this.pos = i13 + 1;
                }
            } else {
                if (c11 >= 'A' && c11 <= 'F') {
                    cArr[i12] = (char) (c11 + ' ');
                }
                this.pos = i12 + 1;
            }
        }
        int i14 = this.end;
        int i15 = this.beg;
        int i16 = i14 - i15;
        if (i16 < 5 || (i16 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f47331dn);
        }
        int i17 = i16 / 2;
        byte[] bArr = new byte[i17];
        int i18 = i15 + 1;
        for (int i19 = 0; i19 < i17; i19++) {
            bArr[i19] = (byte) getByte(i18);
            i18 += 2;
        }
        return new String(this.chars, this.beg, i16);
    }

    private String nextAT() {
        int i11;
        int i12;
        int i13;
        int i14;
        char c11;
        int i15;
        int i16;
        char c12;
        char c13;
        while (true) {
            i11 = this.pos;
            i12 = this.length;
            if (i11 >= i12 || this.chars[i11] != ' ') {
                break;
            }
            this.pos = i11 + 1;
        }
        if (i11 == i12) {
            return null;
        }
        this.beg = i11;
        this.pos = i11 + 1;
        while (true) {
            i13 = this.pos;
            i14 = this.length;
            if (i13 >= i14 || (c13 = this.chars[i13]) == '=' || c13 == ' ') {
                break;
            }
            this.pos = i13 + 1;
        }
        if (i13 >= i14) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f47331dn);
        }
        this.end = i13;
        if (this.chars[i13] == ' ') {
            while (true) {
                i15 = this.pos;
                i16 = this.length;
                if (i15 >= i16 || (c12 = this.chars[i15]) == '=' || c12 != ' ') {
                    break;
                }
                this.pos = i15 + 1;
            }
            if (this.chars[i15] != '=' || i15 == i16) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f47331dn);
            }
        }
        this.pos++;
        while (true) {
            int i17 = this.pos;
            if (i17 >= this.length || this.chars[i17] != ' ') {
                break;
            }
            this.pos = i17 + 1;
        }
        int i18 = this.end;
        int i19 = this.beg;
        if (i18 - i19 > 4) {
            char[] cArr = this.chars;
            if (cArr[i19 + 3] == '.' && (((c11 = cArr[i19]) == 'O' || c11 == 'o') && ((cArr[i19 + 1] == 'I' || cArr[i19 + 1] == 'i') && (cArr[i19 + 2] == 'D' || cArr[i19 + 2] == 'd')))) {
                this.beg = i19 + 4;
            }
        }
        char[] cArr2 = this.chars;
        int i21 = this.beg;
        return new String(cArr2, i21, i18 - i21);
    }

    private String quotedAV() {
        int i11 = this.pos + 1;
        this.pos = i11;
        this.beg = i11;
        this.end = i11;
        while (true) {
            int i12 = this.pos;
            if (i12 == this.length) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f47331dn);
            }
            char[] cArr = this.chars;
            char c11 = cArr[i12];
            if (c11 == '\"') {
                this.pos = i12 + 1;
                while (true) {
                    int i13 = this.pos;
                    if (i13 >= this.length || this.chars[i13] != ' ') {
                        break;
                    }
                    this.pos = i13 + 1;
                }
                char[] cArr2 = this.chars;
                int i14 = this.beg;
                return new String(cArr2, i14, this.end - i14);
            }
            if (c11 == '\\') {
                cArr[this.end] = getEscaped();
            } else {
                cArr[this.end] = c11;
            }
            this.pos++;
            this.end++;
        }
    }

    public String findMostSpecific(String str) {
        String strQuotedAV;
        this.pos = 0;
        this.beg = 0;
        this.end = 0;
        this.cur = 0;
        this.chars = this.f47331dn.toCharArray();
        String strNextAT = nextAT();
        if (strNextAT == null) {
            return null;
        }
        do {
            int i11 = this.pos;
            if (i11 == this.length) {
                return null;
            }
            char c11 = this.chars[i11];
            if (c11 == '\"') {
                strQuotedAV = quotedAV();
            } else if (c11 != '#') {
                strQuotedAV = (c11 == '+' || c11 == ',' || c11 == ';') ? "" : escapedAV();
            } else {
                strQuotedAV = hexAV();
            }
            if (str.equalsIgnoreCase(strNextAT)) {
                return strQuotedAV;
            }
            int i12 = this.pos;
            if (i12 >= this.length) {
                return null;
            }
            char c12 = this.chars[i12];
            if (c12 != ',' && c12 != ';' && c12 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f47331dn);
            }
            this.pos = i12 + 1;
            strNextAT = nextAT();
        } while (strNextAT != null);
        throw new IllegalStateException("Malformed DN: " + this.f47331dn);
    }
}
