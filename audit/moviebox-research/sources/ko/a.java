package ko;

import androidx.core.view.MotionEventCompat;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f68668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f68669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f68670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f68671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f68672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f68673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public char[] f68674g;

    public a(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f68668a = name;
        this.f68669b = name.length();
    }

    public final String a() {
        int i11;
        int i12;
        char c11;
        int i13 = this.f68670c;
        this.f68671d = i13;
        this.f68672e = i13;
        while (true) {
            int i14 = this.f68670c;
            if (i14 >= this.f68669b) {
                char[] cArr = this.f68674g;
                int i15 = this.f68671d;
                return new String(cArr, i15, this.f68672e - i15);
            }
            char[] cArr2 = this.f68674g;
            char c12 = cArr2[i14];
            if (c12 != ' ') {
                if (c12 != ';') {
                    if (c12 == '\\') {
                        int i16 = this.f68672e;
                        this.f68672e = i16 + 1;
                        cArr2[i16] = d();
                        this.f68670c++;
                    } else if (c12 != '+' && c12 != ',') {
                        int i17 = this.f68672e;
                        this.f68672e = i17 + 1;
                        cArr2[i17] = c12;
                        this.f68670c = i14 + 1;
                    }
                }
                int i18 = this.f68671d;
                return new String(cArr2, i18, this.f68672e - i18);
            }
            int i19 = this.f68672e;
            this.f68673f = i19;
            this.f68670c = i14 + 1;
            this.f68672e = i19 + 1;
            cArr2[i19] = ' ';
            while (true) {
                i11 = this.f68670c;
                i12 = this.f68669b;
                if (i11 >= i12) {
                    break;
                }
                char[] cArr3 = this.f68674g;
                if (cArr3[i11] != ' ') {
                    break;
                }
                int i21 = this.f68672e;
                this.f68672e = i21 + 1;
                cArr3[i21] = ' ';
                this.f68670c = i11 + 1;
            }
            if (i11 == i12 || (c11 = this.f68674g[i11]) == ',' || c11 == '+' || c11 == ';') {
                char[] cArr4 = this.f68674g;
                int i22 = this.f68671d;
                return new String(cArr4, i22, this.f68673f - i22);
            }
        }
    }

    public String b(String str) {
        String strH;
        this.f68670c = 0;
        this.f68671d = 0;
        this.f68672e = 0;
        this.f68673f = 0;
        this.f68674g = this.f68668a.toCharArray();
        String strG = g();
        if (strG == null) {
            return null;
        }
        do {
            int i11 = this.f68670c;
            if (i11 == this.f68669b) {
                return null;
            }
            char c11 = this.f68674g[i11];
            if (c11 == '\"') {
                strH = h();
            } else if (c11 != '#') {
                strH = (c11 == '+' || c11 == ',' || c11 == ';') ? "" : a();
            } else {
                strH = f();
            }
            if (str.equalsIgnoreCase(strG)) {
                return strH;
            }
            int i12 = this.f68670c;
            if (i12 >= this.f68669b) {
                return null;
            }
            char c12 = this.f68674g[i12];
            if (c12 != ',' && c12 != ';' && c12 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f68668a);
            }
            this.f68670c = i12 + 1;
            strG = g();
        } while (strG != null);
        throw new IllegalStateException("Malformed DN: " + this.f68668a);
    }

    public final int c(int i11) {
        int i12;
        int i13;
        int i14 = i11 + 1;
        if (i14 >= this.f68669b) {
            throw new IllegalStateException("Malformed DN: " + this.f68668a);
        }
        char[] cArr = this.f68674g;
        char c11 = cArr[i11];
        if (c11 >= '0' && c11 <= '9') {
            i12 = c11 - '0';
        } else if (c11 >= 'a' && c11 <= 'f') {
            i12 = c11 - 'W';
        } else {
            if (c11 < 'A' || c11 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f68668a);
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
                throw new IllegalStateException("Malformed DN: " + this.f68668a);
            }
            i13 = c12 - '7';
        }
        return (i12 << 4) + i13;
    }

    public final char d() {
        int i11 = this.f68670c + 1;
        this.f68670c = i11;
        if (i11 == this.f68669b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f68668a);
        }
        char c11 = this.f68674g[i11];
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
                        return e();
                }
        }
    }

    public final char e() {
        int i11;
        int i12;
        int iC = c(this.f68670c);
        this.f68670c++;
        if (iC < 128) {
            return (char) iC;
        }
        if (iC < 192 || iC > 247) {
            return '?';
        }
        if (iC <= 223) {
            i11 = iC & 31;
            i12 = 1;
        } else if (iC <= 239) {
            i11 = iC & 15;
            i12 = 2;
        } else {
            i11 = iC & 7;
            i12 = 3;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = this.f68670c;
            int i15 = i14 + 1;
            this.f68670c = i15;
            if (i15 == this.f68669b || this.f68674g[i15] != '\\') {
                return '?';
            }
            int i16 = i14 + 2;
            this.f68670c = i16;
            int iC2 = c(i16);
            this.f68670c++;
            if ((iC2 & PsExtractor.AUDIO_STREAM) != 128) {
                return '?';
            }
            i11 = (i11 << 6) + (iC2 & 63);
        }
        return (char) i11;
    }

    public final String f() {
        char[] cArr;
        char c11;
        int i11 = this.f68670c;
        if (i11 + 4 >= this.f68669b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f68668a);
        }
        this.f68671d = i11;
        this.f68670c = i11 + 1;
        while (true) {
            int i12 = this.f68670c;
            if (i12 == this.f68669b || (c11 = (cArr = this.f68674g)[i12]) == '+' || c11 == ',' || c11 == ';') {
                this.f68672e = i12;
                break;
            }
            if (c11 == ' ') {
                this.f68672e = i12;
                this.f68670c = i12 + 1;
                while (true) {
                    int i13 = this.f68670c;
                    if (i13 >= this.f68669b || this.f68674g[i13] != ' ') {
                        break;
                    }
                    this.f68670c = i13 + 1;
                }
            } else {
                if (c11 >= 'A' && c11 <= 'F') {
                    cArr[i12] = (char) (c11 + ' ');
                }
                this.f68670c = i12 + 1;
            }
        }
        int i14 = this.f68672e;
        int i15 = this.f68671d;
        int i16 = i14 - i15;
        if (i16 < 5 || (i16 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f68668a);
        }
        int i17 = i16 / 2;
        byte[] bArr = new byte[i17];
        int i18 = i15 + 1;
        for (int i19 = 0; i19 < i17; i19++) {
            bArr[i19] = (byte) c(i18);
            i18 += 2;
        }
        return new String(this.f68674g, this.f68671d, i16);
    }

    public final String g() {
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
            i11 = this.f68670c;
            i12 = this.f68669b;
            if (i11 >= i12 || this.f68674g[i11] != ' ') {
                break;
            }
            this.f68670c = i11 + 1;
        }
        if (i11 == i12) {
            return null;
        }
        this.f68671d = i11;
        this.f68670c = i11 + 1;
        while (true) {
            i13 = this.f68670c;
            i14 = this.f68669b;
            if (i13 >= i14 || (c13 = this.f68674g[i13]) == '=' || c13 == ' ') {
                break;
            }
            this.f68670c = i13 + 1;
        }
        if (i13 >= i14) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f68668a);
        }
        this.f68672e = i13;
        if (this.f68674g[i13] == ' ') {
            while (true) {
                i15 = this.f68670c;
                i16 = this.f68669b;
                if (i15 >= i16 || (c12 = this.f68674g[i15]) == '=' || c12 != ' ') {
                    break;
                }
                this.f68670c = i15 + 1;
            }
            if (this.f68674g[i15] != '=' || i15 == i16) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f68668a);
            }
        }
        this.f68670c++;
        while (true) {
            int i17 = this.f68670c;
            if (i17 >= this.f68669b || this.f68674g[i17] != ' ') {
                break;
            }
            this.f68670c = i17 + 1;
        }
        int i18 = this.f68672e;
        int i19 = this.f68671d;
        if (i18 - i19 > 4) {
            char[] cArr = this.f68674g;
            if (cArr[i19 + 3] == '.' && (((c11 = cArr[i19]) == 'O' || c11 == 'o') && ((cArr[i19 + 1] == 'I' || cArr[i19 + 1] == 'i') && (cArr[i19 + 2] == 'D' || cArr[i19 + 2] == 'd')))) {
                this.f68671d = i19 + 4;
            }
        }
        char[] cArr2 = this.f68674g;
        int i21 = this.f68671d;
        return new String(cArr2, i21, i18 - i21);
    }

    public final String h() {
        int i11 = this.f68670c + 1;
        this.f68670c = i11;
        this.f68671d = i11;
        this.f68672e = i11;
        while (true) {
            int i12 = this.f68670c;
            if (i12 == this.f68669b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f68668a);
            }
            char[] cArr = this.f68674g;
            char c11 = cArr[i12];
            if (c11 == '\"') {
                this.f68670c = i12 + 1;
                while (true) {
                    int i13 = this.f68670c;
                    if (i13 >= this.f68669b || this.f68674g[i13] != ' ') {
                        break;
                    }
                    this.f68670c = i13 + 1;
                }
                char[] cArr2 = this.f68674g;
                int i14 = this.f68671d;
                return new String(cArr2, i14, this.f68672e - i14);
            }
            if (c11 == '\\') {
                cArr[this.f68672e] = d();
            } else {
                cArr[this.f68672e] = c11;
            }
            this.f68670c++;
            this.f68672e++;
        }
    }
}
