package l7;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.Feature;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import okhttp3.internal.http2.Settings;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f70115u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f70116v;

    public e(String str) {
        this(str, com.alibaba.fastjson.a.DEFAULT_PARSER_FEATURE);
    }

    public e(String str, int i11) {
        super(i11);
        this.f70115u = str;
        this.f70116v = str.length();
        this.f70099f = -1;
        next();
        if (this.f70098d == 65279) {
            next();
        }
    }

    public e(char[] cArr, int i11, int i12) {
        this(new String(cArr, 0, i11), i12);
    }

    public static boolean m1(String str, int i11, char[] cArr) {
        int length = cArr.length;
        if (length + i11 > str.length()) {
            return false;
        }
        for (int i12 = 0; i12 < length; i12++) {
            if (cArr[i12] != str.charAt(i11 + i12)) {
                return false;
            }
        }
        return true;
    }

    public static boolean n1(char c11, char c12, char c13, char c14, char c15, char c16, int i11, int i12) {
        if (c11 >= '0' && c11 <= '9' && c12 >= '0' && c12 <= '9' && c13 >= '0' && c13 <= '9' && c14 >= '0' && c14 <= '9') {
            if (c15 == '0') {
                if (c16 < '1' || c16 > '9') {
                    return false;
                }
            } else if (c15 != '1' || (c16 != '0' && c16 != '1' && c16 != '2')) {
                return false;
            }
            if (i11 == 48) {
                return i12 >= 49 && i12 <= 57;
            }
            if (i11 != 49 && i11 != 50) {
                return i11 == 51 && (i12 == 48 || i12 == 49);
            }
            if (i12 >= 48 && i12 <= 57) {
                return true;
            }
        }
        return false;
    }

    @Override // l7.c
    public final void A0(int i11, int i12, char[] cArr) {
        this.f70115u.getChars(i11, i12 + i11, cArr, 0);
    }

    @Override // l7.c
    public final int D0(char c11, int i11) {
        return this.f70115u.indexOf(c11, i11);
    }

    @Override // l7.c
    public boolean E0() {
        int i11 = this.f70099f;
        int i12 = this.f70116v;
        if (i11 != i12) {
            return this.f70098d == 26 && i11 + 1 >= i12;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0165  */
    /* JADX WARN: Code duplicated, block: B:103:0x016b A[LOOP:0: B:78:0x00ed->B:103:0x016b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:108:0x0108 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x0176 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:112:0x0162 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:0x0125 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:0x0137 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:0x014b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x0104  */
    /* JADX WARN: Code duplicated, block: B:86:0x0121  */
    /* JADX WARN: Code duplicated, block: B:89:0x0135 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x0147  */
    /* JADX WARN: Code duplicated, block: B:96:0x0152  */
    /* JADX WARN: Code duplicated, block: B:98:0x0158 A[LOOP:1: B:84:0x0111->B:98:0x0158, LOOP_END] */
    @Override // l7.c
    public boolean P0(char[] cArr) {
        char cZ0;
        boolean z11;
        char cZ1;
        this.f70108o = 0;
        if (!m1(this.f70115u, this.f70099f, cArr)) {
            this.f70108o = -2;
            return false;
        }
        int i11 = this.f70099f;
        int length = cArr.length + i11;
        int i12 = length + 1;
        char cZ2 = z0(length);
        boolean z12 = cZ2 == '\"';
        if (z12) {
            cZ2 = z0(i12);
            i12 = length + 2;
        }
        if (cZ2 != 't') {
            if (cZ2 == 'f') {
                int i13 = i12 + 1;
                if (z0(i12) != 'a') {
                    this.f70108o = -1;
                    return false;
                }
                int i14 = i12 + 2;
                if (z0(i13) != 'l') {
                    this.f70108o = -1;
                    return false;
                }
                int i15 = i12 + 3;
                if (z0(i14) != 's') {
                    this.f70108o = -1;
                    return false;
                }
                int i16 = i12 + 4;
                if (z0(i15) != 'e') {
                    this.f70108o = -1;
                    return false;
                }
                if (z12) {
                    int i17 = i12 + 5;
                    if (z0(i16) != '\"') {
                        this.f70108o = -1;
                        return false;
                    }
                    i16 = i17;
                }
                this.f70099f = i16;
                cZ0 = z0(i16);
            } else if (cZ2 == '1') {
                if (z12) {
                    int i18 = i12 + 1;
                    if (z0(i12) != '\"') {
                        this.f70108o = -1;
                        return false;
                    }
                    i12 = i18;
                }
                this.f70099f = i12;
                cZ0 = z0(i12);
            } else {
                if (cZ2 != '0') {
                    this.f70108o = -1;
                    return false;
                }
                if (z12) {
                    int i19 = i12 + 1;
                    if (z0(i12) != '\"') {
                        this.f70108o = -1;
                        return false;
                    }
                    i12 = i19;
                }
                this.f70099f = i12;
                cZ0 = z0(i12);
            }
            z11 = false;
            while (cZ0 != ',') {
                if (cZ0 == '}') {
                    int i21 = this.f70099f + 1;
                    this.f70099f = i21;
                    cZ1 = z0(i21);
                    while (cZ1 != ',') {
                        if (cZ1 == ']') {
                            this.f70095a = 15;
                            int i22 = this.f70099f + 1;
                            this.f70099f = i22;
                            this.f70098d = z0(i22);
                        } else if (cZ1 == '}') {
                            this.f70095a = 13;
                            int i23 = this.f70099f + 1;
                            this.f70099f = i23;
                            this.f70098d = z0(i23);
                        } else if (cZ1 == 26) {
                            this.f70095a = 20;
                        } else {
                            if (c.F0(cZ1)) {
                                this.f70108o = -1;
                                return false;
                            }
                            int i24 = this.f70099f + 1;
                            this.f70099f = i24;
                            cZ1 = z0(i24);
                        }
                        this.f70108o = 4;
                        return z11;
                    }
                    this.f70095a = 16;
                    int i25 = this.f70099f + 1;
                    this.f70099f = i25;
                    this.f70098d = z0(i25);
                    this.f70108o = 4;
                    return z11;
                }
                if (c.F0(cZ0)) {
                    this.f70099f = i11;
                    z0(i11);
                    this.f70108o = -1;
                    return false;
                }
                int i26 = this.f70099f + 1;
                this.f70099f = i26;
                cZ0 = z0(i26);
            }
            int i27 = this.f70099f + 1;
            this.f70099f = i27;
            this.f70098d = z0(i27);
            this.f70108o = 3;
            this.f70095a = 16;
            return z11;
        }
        int i28 = i12 + 1;
        if (z0(i12) != 'r') {
            this.f70108o = -1;
            return false;
        }
        int i29 = i12 + 2;
        if (z0(i28) != 'u') {
            this.f70108o = -1;
            return false;
        }
        int i31 = i12 + 3;
        if (z0(i29) != 'e') {
            this.f70108o = -1;
            return false;
        }
        if (z12) {
            int i32 = i12 + 4;
            if (z0(i31) != '\"') {
                this.f70108o = -1;
                return false;
            }
            i31 = i32;
        }
        this.f70099f = i31;
        cZ0 = z0(i31);
        z11 = true;
        while (cZ0 != ',') {
            if (cZ0 == '}') {
                int i210 = this.f70099f + 1;
                this.f70099f = i210;
                cZ1 = z0(i210);
                while (cZ1 != ',') {
                    if (cZ1 == ']') {
                        this.f70095a = 15;
                        int i211 = this.f70099f + 1;
                        this.f70099f = i211;
                        this.f70098d = z0(i211);
                    } else if (cZ1 == '}') {
                        this.f70095a = 13;
                        int i212 = this.f70099f + 1;
                        this.f70099f = i212;
                        this.f70098d = z0(i212);
                    } else if (cZ1 == 26) {
                        this.f70095a = 20;
                    } else {
                        if (c.F0(cZ1)) {
                            this.f70108o = -1;
                            return false;
                        }
                        int i213 = this.f70099f + 1;
                        this.f70099f = i213;
                        cZ1 = z0(i213);
                    }
                    this.f70108o = 4;
                    return z11;
                }
                this.f70095a = 16;
                int i214 = this.f70099f + 1;
                this.f70099f = i214;
                this.f70098d = z0(i214);
                this.f70108o = 4;
                return z11;
            }
            if (c.F0(cZ0)) {
                this.f70099f = i11;
                z0(i11);
                this.f70108o = -1;
                return false;
            }
            int i215 = this.f70099f + 1;
            this.f70099f = i215;
            cZ0 = z0(i215);
        }
        int i216 = this.f70099f + 1;
        this.f70099f = i216;
        this.f70098d = z0(i216);
        this.f70108o = 3;
        this.f70095a = 16;
        return z11;
    }

    @Override // l7.c
    public Date Q0(char[] cArr) {
        long j11;
        Date date;
        char cZ0;
        char cZ1;
        boolean z11 = false;
        this.f70108o = 0;
        int i11 = this.f70099f;
        char c11 = this.f70098d;
        if (!m1(this.f70115u, i11, cArr)) {
            this.f70108o = -2;
            return null;
        }
        int length = this.f70099f + cArr.length;
        int i12 = length + 1;
        char cZ2 = z0(length);
        if (cZ2 == '\"') {
            int iD0 = D0('\"', i12);
            if (iD0 == -1) {
                throw new JSONException("unclosed str");
            }
            this.f70099f = i12;
            if (!r1(false, iD0 - i12)) {
                this.f70099f = i11;
                this.f70108o = -1;
                return null;
            }
            date = this.f70105l.getTime();
            cZ0 = z0(iD0 + 1);
            this.f70099f = i11;
            while (cZ0 != ',' && cZ0 != '}') {
                if (!c.F0(cZ0)) {
                    this.f70108o = -1;
                    return null;
                }
                int i13 = iD0 + 1;
                char cZ3 = z0(iD0 + 2);
                iD0 = i13;
                cZ0 = cZ3;
            }
            this.f70099f = iD0 + 1;
            this.f70098d = cZ0;
        } else {
            char c12 = '9';
            char c13 = '0';
            if (cZ2 != '-' && (cZ2 < '0' || cZ2 > '9')) {
                this.f70108o = -1;
                return null;
            }
            if (cZ2 == '-') {
                cZ2 = z0(i12);
                i12 = length + 2;
                z11 = true;
            }
            if (cZ2 < '0' || cZ2 > '9') {
                j11 = 0;
            } else {
                long j12 = cZ2 - '0';
                while (true) {
                    int i14 = i12 + 1;
                    cZ1 = z0(i12);
                    if (cZ1 < c13 || cZ1 > c12) {
                        break;
                    }
                    j12 = (j12 * 10) + ((long) (cZ1 - '0'));
                    i12 = i14;
                    c12 = '9';
                    c13 = '0';
                }
                if (cZ1 == ',' || cZ1 == '}') {
                    this.f70099f = i12;
                }
                long j13 = j12;
                cZ2 = cZ1;
                j11 = j13;
            }
            if (j11 < 0) {
                this.f70108o = -1;
                return null;
            }
            if (z11) {
                j11 = -j11;
            }
            date = new Date(j11);
            cZ0 = cZ2;
        }
        if (cZ0 == ',') {
            int i15 = this.f70099f + 1;
            this.f70099f = i15;
            this.f70098d = z0(i15);
            this.f70108o = 3;
            this.f70095a = 16;
            return date;
        }
        int i16 = this.f70099f + 1;
        this.f70099f = i16;
        char cZ4 = z0(i16);
        if (cZ4 == ',') {
            this.f70095a = 16;
            int i17 = this.f70099f + 1;
            this.f70099f = i17;
            this.f70098d = z0(i17);
        } else if (cZ4 == ']') {
            this.f70095a = 15;
            int i18 = this.f70099f + 1;
            this.f70099f = i18;
            this.f70098d = z0(i18);
        } else if (cZ4 == '}') {
            this.f70095a = 13;
            int i19 = this.f70099f + 1;
            this.f70099f = i19;
            this.f70098d = z0(i19);
        } else {
            if (cZ4 != 26) {
                this.f70099f = i11;
                this.f70098d = c11;
                this.f70108o = -1;
                return null;
            }
            this.f70095a = 20;
        }
        this.f70108o = 4;
        return date;
    }

    @Override // l7.c
    public int W0(char[] cArr) {
        int i11;
        char cZ0;
        this.f70108o = 0;
        int i12 = this.f70099f;
        char c11 = this.f70098d;
        if (!m1(this.f70115u, i12, cArr)) {
            this.f70108o = -2;
            return 0;
        }
        int length = this.f70099f + cArr.length;
        int i13 = length + 1;
        char cZ1 = z0(length);
        boolean z11 = cZ1 == '\"';
        if (z11) {
            cZ1 = z0(i13);
            i13 = length + 2;
        }
        boolean z12 = cZ1 == '-';
        if (z12) {
            cZ1 = z0(i13);
            i13++;
        }
        if (cZ1 < '0' || cZ1 > '9') {
            this.f70108o = -1;
            return 0;
        }
        int i14 = cZ1 - '0';
        while (true) {
            i11 = i13 + 1;
            cZ0 = z0(i13);
            if (cZ0 < '0' || cZ0 > '9') {
                break;
            }
            int i15 = i14 * 10;
            if (i15 < i14) {
                this.f70108o = -1;
                return 0;
            }
            i14 = i15 + (cZ0 - '0');
            i13 = i11;
        }
        if (cZ0 == '.') {
            this.f70108o = -1;
            return 0;
        }
        if (i14 < 0) {
            this.f70108o = -1;
            return 0;
        }
        if (z11) {
            if (cZ0 != '\"') {
                this.f70108o = -1;
                return 0;
            }
            int i16 = i13 + 2;
            cZ0 = z0(i11);
            i11 = i16;
        }
        while (cZ0 != ',' && cZ0 != '}') {
            if (!c.F0(cZ0)) {
                this.f70108o = -1;
                return 0;
            }
            int i17 = i11 + 1;
            cZ0 = z0(i11);
            i11 = i17;
        }
        this.f70099f = i11 - 1;
        if (cZ0 == ',') {
            this.f70099f = i11;
            this.f70098d = z0(i11);
            this.f70108o = 3;
            this.f70095a = 16;
            return z12 ? -i14 : i14;
        }
        if (cZ0 == '}') {
            this.f70099f = i11;
            char cZ2 = z0(i11);
            while (true) {
                if (cZ2 == ',') {
                    this.f70095a = 16;
                    int i18 = this.f70099f + 1;
                    this.f70099f = i18;
                    this.f70098d = z0(i18);
                    break;
                }
                if (cZ2 == ']') {
                    this.f70095a = 15;
                    int i19 = this.f70099f + 1;
                    this.f70099f = i19;
                    this.f70098d = z0(i19);
                    break;
                }
                if (cZ2 == '}') {
                    this.f70095a = 13;
                    int i21 = this.f70099f + 1;
                    this.f70099f = i21;
                    this.f70098d = z0(i21);
                    break;
                }
                if (cZ2 == 26) {
                    this.f70095a = 20;
                    break;
                }
                if (!c.F0(cZ2)) {
                    this.f70099f = i12;
                    this.f70098d = c11;
                    this.f70108o = -1;
                    return 0;
                }
                int i22 = this.f70099f + 1;
                this.f70099f = i22;
                cZ2 = z0(i22);
            }
            this.f70108o = 4;
        }
        return z12 ? -i14 : i14;
    }

    @Override // l7.c
    public long Y0(char[] cArr) {
        int i11;
        char cZ0;
        boolean z11 = false;
        this.f70108o = 0;
        int i12 = this.f70099f;
        char c11 = this.f70098d;
        if (!m1(this.f70115u, i12, cArr)) {
            this.f70108o = -2;
            return 0L;
        }
        int length = this.f70099f + cArr.length;
        int i13 = length + 1;
        char cZ1 = z0(length);
        boolean z12 = cZ1 == '\"';
        if (z12) {
            cZ1 = z0(i13);
            i13 = length + 2;
        }
        if (cZ1 == '-') {
            cZ1 = z0(i13);
            i13++;
            z11 = true;
        }
        if (cZ1 < '0' || cZ1 > '9') {
            this.f70099f = i12;
            this.f70098d = c11;
            this.f70108o = -1;
            return 0L;
        }
        long j11 = cZ1 - '0';
        while (true) {
            i11 = i13 + 1;
            cZ0 = z0(i13);
            if (cZ0 < '0' || cZ0 > '9') {
                break;
            }
            j11 = (j11 * 10) + ((long) (cZ0 - '0'));
            i13 = i11;
        }
        if (cZ0 == '.') {
            this.f70108o = -1;
            return 0L;
        }
        if (z12) {
            if (cZ0 != '\"') {
                this.f70108o = -1;
                return 0L;
            }
            cZ0 = z0(i11);
            i11 = i13 + 2;
        }
        if (cZ0 == ',' || cZ0 == '}') {
            this.f70099f = i11 - 1;
        }
        if (j11 < 0 && (j11 != Long.MIN_VALUE || !z11)) {
            this.f70099f = i12;
            this.f70098d = c11;
            this.f70108o = -1;
            return 0L;
        }
        while (cZ0 != ',') {
            if (cZ0 == '}') {
                int i14 = 1;
                int i15 = this.f70099f + 1;
                this.f70099f = i15;
                char cZ2 = z0(i15);
                while (true) {
                    if (cZ2 == ',') {
                        this.f70095a = 16;
                        int i16 = this.f70099f + i14;
                        this.f70099f = i16;
                        this.f70098d = z0(i16);
                        break;
                    }
                    if (cZ2 == ']') {
                        this.f70095a = 15;
                        int i17 = this.f70099f + i14;
                        this.f70099f = i17;
                        this.f70098d = z0(i17);
                        break;
                    }
                    if (cZ2 == '}') {
                        this.f70095a = 13;
                        int i18 = this.f70099f + i14;
                        this.f70099f = i18;
                        this.f70098d = z0(i18);
                        break;
                    }
                    if (cZ2 == 26) {
                        this.f70095a = 20;
                        break;
                    }
                    if (!c.F0(cZ2)) {
                        this.f70099f = i12;
                        this.f70098d = c11;
                        this.f70108o = -1;
                        return 0L;
                    }
                    int i19 = this.f70099f + 1;
                    this.f70099f = i19;
                    cZ2 = z0(i19);
                    i14 = 1;
                }
                this.f70108o = 4;
                return z11 ? -j11 : j11;
            }
            if (!c.F0(cZ0)) {
                this.f70108o = -1;
                return 0L;
            }
            this.f70099f = i11;
            cZ0 = z0(i11);
            i11++;
        }
        int i21 = this.f70099f + 1;
        this.f70099f = i21;
        this.f70098d = z0(i21);
        this.f70108o = 3;
        this.f70095a = 16;
        return z11 ? -j11 : j11;
    }

    @Override // l7.c, l7.b
    public final BigDecimal Z() {
        char cZ0 = z0((this.f70103j + this.f70102i) - 1);
        int i11 = this.f70102i;
        if (cZ0 == 'L' || cZ0 == 'S' || cZ0 == 'B' || cZ0 == 'F' || cZ0 == 'D') {
            i11--;
        }
        if (i11 > 65535) {
            throw new JSONException("decimal overflow");
        }
        int i12 = this.f70103j;
        char[] cArr = this.f70101h;
        if (i11 < cArr.length) {
            this.f70115u.getChars(i12, i12 + i11, cArr, 0);
            return new BigDecimal(this.f70101h, 0, i11, MathContext.UNLIMITED);
        }
        char[] cArr2 = new char[i11];
        this.f70115u.getChars(i12, i12 + i11, cArr2, 0);
        return new BigDecimal(cArr2, 0, i11, MathContext.UNLIMITED);
    }

    @Override // l7.c
    public String Z0(char[] cArr) {
        this.f70108o = 0;
        int i11 = this.f70099f;
        char c11 = this.f70098d;
        while (!m1(this.f70115u, this.f70099f, cArr)) {
            if (!c.F0(this.f70098d)) {
                this.f70108o = -2;
                return j1();
            }
            next();
            while (c.F0(this.f70098d)) {
                next();
            }
        }
        int length = this.f70099f + cArr.length;
        int i12 = length + 1;
        char cZ0 = z0(length);
        int i13 = 0;
        if (cZ0 != '\"') {
            while (c.F0(cZ0)) {
                i13++;
                int i14 = i12 + 1;
                char cZ1 = z0(i12);
                i12 = i14;
                cZ0 = cZ1;
            }
            if (cZ0 != '\"') {
                this.f70108o = -1;
                return j1();
            }
        }
        int iD0 = D0('\"', i12);
        if (iD0 == -1) {
            throw new JSONException("unclosed str");
        }
        String strK1 = k1(i12, iD0 - i12);
        if (strK1.indexOf(92) != -1) {
            while (true) {
                int i15 = 0;
                for (int i16 = iD0 - 1; i16 >= 0 && z0(i16) == '\\'; i16--) {
                    i15++;
                }
                if (i15 % 2 == 0) {
                    break;
                }
                iD0 = D0('\"', iD0 + 1);
            }
            int i17 = this.f70099f;
            int length2 = iD0 - (((cArr.length + i17) + 1) + i13);
            strK1 = c.L0(l1(i17 + cArr.length + 1 + i13, length2), length2);
        }
        if ((this.f70097c & Feature.TrimStringFieldValue.mask) != 0) {
            strK1 = strK1.trim();
        }
        char cZ2 = z0(iD0 + 1);
        while (cZ2 != ',' && cZ2 != '}') {
            if (!c.F0(cZ2)) {
                this.f70108o = -1;
                return j1();
            }
            char cZ3 = z0(iD0 + 2);
            iD0++;
            cZ2 = cZ3;
        }
        this.f70099f = iD0 + 1;
        this.f70098d = cZ2;
        if (cZ2 == ',') {
            int i18 = iD0 + 2;
            this.f70099f = i18;
            this.f70098d = z0(i18);
            this.f70108o = 3;
            return strK1;
        }
        int i19 = iD0 + 2;
        this.f70099f = i19;
        char cZ4 = z0(i19);
        if (cZ4 == ',') {
            this.f70095a = 16;
            int i21 = this.f70099f + 1;
            this.f70099f = i21;
            this.f70098d = z0(i21);
        } else if (cZ4 == ']') {
            this.f70095a = 15;
            int i22 = this.f70099f + 1;
            this.f70099f = i22;
            this.f70098d = z0(i22);
        } else if (cZ4 == '}') {
            this.f70095a = 13;
            int i23 = this.f70099f + 1;
            this.f70099f = i23;
            this.f70098d = z0(i23);
        } else {
            if (cZ4 != 26) {
                this.f70099f = i11;
                this.f70098d = c11;
                this.f70108o = -1;
                return j1();
            }
            this.f70095a = 20;
        }
        this.f70108o = 4;
        return strK1;
    }

    @Override // l7.c, l7.b
    public final int b0(char c11) {
        int i11;
        char cZ0;
        this.f70108o = 0;
        int i12 = this.f70099f;
        int i13 = i12 + 1;
        char cZ1 = z0(i12);
        while (c.F0(cZ1)) {
            cZ1 = z0(i13);
            i13++;
        }
        boolean z11 = cZ1 == '\"';
        if (z11) {
            cZ1 = z0(i13);
            i13++;
        }
        boolean z12 = cZ1 == '-';
        if (z12) {
            cZ1 = z0(i13);
            i13++;
        }
        if (cZ1 < '0' || cZ1 > '9') {
            if (cZ1 == 'n') {
                int i14 = i13 + 1;
                if (z0(i13) == 'u') {
                    int i15 = i13 + 2;
                    if (z0(i14) == 'l') {
                        int i16 = i13 + 3;
                        if (z0(i15) == 'l') {
                            this.f70108o = 5;
                            int i17 = i13 + 4;
                            char cZ2 = z0(i16);
                            if (z11 && cZ2 == '\"') {
                                cZ2 = z0(i17);
                                i17 = i13 + 5;
                            }
                            while (cZ2 != ',') {
                                if (cZ2 == ']') {
                                    this.f70099f = i17;
                                    this.f70098d = z0(i17);
                                    this.f70108o = 5;
                                    this.f70095a = 15;
                                    return 0;
                                }
                                if (!c.F0(cZ2)) {
                                    this.f70108o = -1;
                                    return 0;
                                }
                                char cZ3 = z0(i17);
                                i17++;
                                cZ2 = cZ3;
                            }
                            this.f70099f = i17;
                            this.f70098d = z0(i17);
                            this.f70108o = 5;
                            this.f70095a = 16;
                            return 0;
                        }
                    }
                }
            }
            this.f70108o = -1;
            return 0;
        }
        int i18 = cZ1 - '0';
        while (true) {
            i11 = i13 + 1;
            cZ0 = z0(i13);
            if (cZ0 < '0' || cZ0 > '9') {
                break;
            }
            int i19 = i18 * 10;
            if (i19 < i18) {
                throw new JSONException("parseInt error : " + k1(i12, i13));
            }
            i18 = i19 + (cZ0 - '0');
            i13 = i11;
        }
        if (cZ0 == '.') {
            this.f70108o = -1;
            return 0;
        }
        if (z11) {
            if (cZ0 != '\"') {
                this.f70108o = -1;
                return 0;
            }
            cZ0 = z0(i11);
            i11 = i13 + 2;
        }
        if (i18 < 0) {
            this.f70108o = -1;
            return 0;
        }
        while (cZ0 != c11) {
            if (!c.F0(cZ0)) {
                this.f70108o = -1;
                return z12 ? -i18 : i18;
            }
            cZ0 = z0(i11);
            i11++;
        }
        this.f70099f = i11;
        this.f70098d = z0(i11);
        this.f70108o = 3;
        this.f70095a = 16;
        return z12 ? -i18 : i18;
    }

    @Override // l7.c, l7.b
    public String c() {
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        int i12 = 1;
        int i13 = 1;
        while (i11 < this.f70099f) {
            if (this.f70115u.charAt(i11) == '\n') {
                i12++;
                i13 = 1;
            }
            i11++;
            i13++;
        }
        sb2.append("pos ");
        sb2.append(this.f70099f);
        sb2.append(", line ");
        sb2.append(i12);
        sb2.append(", column ");
        sb2.append(i13);
        if (this.f70115u.length() < 65535) {
            sb2.append(this.f70115u);
        } else {
            sb2.append(this.f70115u.substring(0, Settings.DEFAULT_INITIAL_WINDOW_SIZE));
        }
        return sb2.toString();
    }

    @Override // l7.b
    public byte[] d0() {
        if (this.f70095a != 26) {
            return !this.f70104k ? com.alibaba.fastjson.util.f.d(this.f70115u, this.f70103j + 1, this.f70102i) : com.alibaba.fastjson.util.f.c(new String(this.f70101h, 0, this.f70102i));
        }
        int i11 = this.f70103j + 1;
        int i12 = this.f70102i;
        if (i12 % 2 != 0) {
            throw new JSONException("illegal state. " + i12);
        }
        int i13 = i12 / 2;
        byte[] bArr = new byte[i13];
        for (int i14 = 0; i14 < i13; i14++) {
            int i15 = (i14 * 2) + i11;
            char cCharAt = this.f70115u.charAt(i15);
            char cCharAt2 = this.f70115u.charAt(i15 + 1);
            char c11 = '7';
            int i16 = cCharAt - (cCharAt <= '9' ? '0' : '7');
            if (cCharAt2 <= '9') {
                c11 = '0';
            }
            bArr[i14] = (byte) ((i16 << 4) | (cCharAt2 - c11));
        }
        return bArr;
    }

    @Override // l7.c, l7.b
    public final String g0() {
        return !this.f70104k ? k1(this.f70103j + 1, this.f70102i) : new String(this.f70101h, 0, this.f70102i);
    }

    @Override // l7.c, l7.b
    public String k(i iVar) {
        int iIndexOf;
        if (!this.f70115u.startsWith("\"@type\":\"", this.f70099f) || (iIndexOf = this.f70115u.indexOf(34, this.f70099f + 9)) == -1) {
            return null;
        }
        int i11 = this.f70099f + 9;
        this.f70099f = i11;
        int iCharAt = 0;
        while (i11 < iIndexOf) {
            iCharAt = (iCharAt * 31) + this.f70115u.charAt(i11);
            i11++;
        }
        int i12 = this.f70099f;
        String strW0 = w0(i12, iIndexOf - i12, iCharAt, iVar);
        char cCharAt = this.f70115u.charAt(iIndexOf + 1);
        if (cCharAt != ',' && cCharAt != ']') {
            return null;
        }
        int i13 = iIndexOf + 2;
        this.f70099f = i13;
        this.f70098d = this.f70115u.charAt(i13);
        return strW0;
    }

    @Override // l7.c
    public final String k1(int i11, int i12) {
        if (!com.alibaba.fastjson.util.b.f15531b) {
            return this.f70115u.substring(i11, i12 + i11);
        }
        char[] cArr = this.f70101h;
        if (i12 < cArr.length) {
            this.f70115u.getChars(i11, i11 + i12, cArr, 0);
            return new String(this.f70101h, 0, i12);
        }
        char[] cArr2 = new char[i12];
        this.f70115u.getChars(i11, i12 + i11, cArr2, 0);
        return new String(cArr2);
    }

    @Override // l7.c
    public final char[] l1(int i11, int i12) {
        if (com.alibaba.fastjson.util.b.f15531b) {
            char[] cArr = this.f70101h;
            if (i12 < cArr.length) {
                this.f70115u.getChars(i11, i12 + i11, cArr, 0);
                return this.f70101h;
            }
        }
        char[] cArr2 = new char[i12];
        this.f70115u.getChars(i11, i12 + i11, cArr2, 0);
        return cArr2;
    }

    @Override // l7.c, l7.b
    public double n(char c11) {
        int i11;
        char cZ0;
        long j11;
        int i12;
        int i13;
        double d11;
        char cZ1;
        this.f70108o = 0;
        int i14 = this.f70099f;
        int i15 = i14 + 1;
        char cZ2 = z0(i14);
        boolean z11 = cZ2 == '\"';
        if (z11) {
            cZ2 = z0(i15);
            i15 = i14 + 2;
        }
        boolean z12 = cZ2 == '-';
        if (z12) {
            cZ2 = z0(i15);
            i15++;
        }
        if (cZ2 >= '0') {
            char c12 = '9';
            if (cZ2 <= '9') {
                long j12 = cZ2 - '0';
                while (true) {
                    i11 = i15 + 1;
                    cZ0 = z0(i15);
                    if (cZ0 < '0' || cZ0 > '9') {
                        break;
                    }
                    j12 = (j12 * 10) + ((long) (cZ0 - '0'));
                    i15 = i11;
                }
                if (cZ0 == '.') {
                    int i16 = i15 + 2;
                    char cZ3 = z0(i11);
                    if (cZ3 < '0' || cZ3 > '9') {
                        this.f70108o = -1;
                        return 0.0d;
                    }
                    j12 = (j12 * 10) + ((long) (cZ3 - '0'));
                    long j13 = 10;
                    while (true) {
                        i11 = i16 + 1;
                        cZ1 = z0(i16);
                        if (cZ1 < '0' || cZ1 > c12) {
                            break;
                        }
                        j12 = (j12 * 10) + ((long) (cZ1 - '0'));
                        j13 *= 10;
                        i16 = i11;
                        c12 = '9';
                    }
                    long j14 = j13;
                    cZ0 = cZ1;
                    j11 = j14;
                } else {
                    j11 = 1;
                }
                boolean z13 = cZ0 == 'e' || cZ0 == 'E';
                if (z13) {
                    int i17 = i11 + 1;
                    char cZ4 = z0(i11);
                    if (cZ4 == '+' || cZ4 == '-') {
                        i11 += 2;
                        cZ0 = z0(i17);
                    } else {
                        i11 = i17;
                        cZ0 = cZ4;
                    }
                    while (cZ0 >= '0' && cZ0 <= '9') {
                        int i18 = i11 + 1;
                        char cZ5 = z0(i11);
                        i11 = i18;
                        cZ0 = cZ5;
                    }
                }
                if (!z11) {
                    i12 = this.f70099f;
                    i13 = (i11 - i12) - 1;
                } else {
                    if (cZ0 != '\"') {
                        this.f70108o = -1;
                        return 0.0d;
                    }
                    int i19 = i11 + 1;
                    char cZ6 = z0(i11);
                    i12 = this.f70099f + 1;
                    i13 = (i19 - i12) - 2;
                    i11 = i19;
                    cZ0 = cZ6;
                }
                if (z13 || i13 >= 18) {
                    d11 = Double.parseDouble(k1(i12, i13));
                } else {
                    d11 = j12 / j11;
                    if (z12) {
                        d11 = -d11;
                    }
                }
                if (cZ0 != c11) {
                    this.f70108o = -1;
                    return d11;
                }
                this.f70099f = i11;
                this.f70098d = z0(i11);
                this.f70108o = 3;
                this.f70095a = 16;
                return d11;
            }
        }
        if (cZ2 == 'n') {
            int i21 = i15 + 1;
            if (z0(i15) == 'u') {
                int i22 = i15 + 2;
                if (z0(i21) == 'l') {
                    int i23 = i15 + 3;
                    if (z0(i22) == 'l') {
                        this.f70108o = 5;
                        int i24 = i15 + 4;
                        char cZ7 = z0(i23);
                        if (z11 && cZ7 == '\"') {
                            cZ7 = z0(i24);
                            i24 = i15 + 5;
                        }
                        while (cZ7 != ',') {
                            if (cZ7 == ']') {
                                this.f70099f = i24;
                                this.f70098d = z0(i24);
                                this.f70108o = 5;
                                this.f70095a = 15;
                                return 0.0d;
                            }
                            if (!c.F0(cZ7)) {
                                this.f70108o = -1;
                                return 0.0d;
                            }
                            char cZ8 = z0(i24);
                            i24++;
                            cZ7 = cZ8;
                        }
                        this.f70099f = i24;
                        this.f70098d = z0(i24);
                        this.f70108o = 5;
                        this.f70095a = 16;
                        return 0.0d;
                    }
                }
            }
        }
        this.f70108o = -1;
        return 0.0d;
    }

    @Override // l7.c, l7.b
    public final char next() {
        int i11 = this.f70099f + 1;
        this.f70099f = i11;
        char cCharAt = i11 >= this.f70116v ? (char) 26 : this.f70115u.charAt(i11);
        this.f70098d = cCharAt;
        return cCharAt;
    }

    public final boolean o1(char c11, char c12, char c13, char c14, char c15, char c16) {
        if (c11 == '0') {
            if (c12 < '0' || c12 > '9') {
                return false;
            }
        } else {
            if (c11 != '1') {
                if (c11 == '2' && c12 >= '0' && c12 <= '4') {
                }
                return false;
            }
            if (c12 < '0' || c12 > '9') {
                return false;
            }
        }
        if (c13 < '0' || c13 > '5') {
            if (c13 != '6' || c14 != '0') {
                return false;
            }
        } else if (c14 < '0' || c14 > '9') {
            return false;
        }
        if (c15 < '0' || c15 > '5') {
            return c15 == '6' && c16 == '0';
        }
        return c16 >= '0' && c16 <= '9';
    }

    public boolean p1() {
        return q1(true);
    }

    public boolean q1(boolean z11) {
        return r1(z11, this.f70116v - this.f70099f);
    }

    public final boolean r1(boolean z11, int i11) {
        char cZ0;
        char c11;
        char c12;
        char c13;
        int i12;
        int i13;
        int i14;
        int i15;
        char c14;
        char c15;
        char cZ1;
        char c16;
        char c17;
        char c18;
        int i16;
        char c19;
        int i17;
        int i18;
        int i19;
        char cZ2;
        char cZ3;
        char cZ4;
        char cZ5;
        char cZ6;
        char cZ7;
        if (i11 < 8) {
            return false;
        }
        char cZ8 = z0(this.f70099f);
        char cZ9 = z0(this.f70099f + 1);
        char cZ10 = z0(this.f70099f + 2);
        int i21 = 3;
        char cZ11 = z0(this.f70099f + 3);
        char cZ12 = z0(this.f70099f + 4);
        char cZ13 = z0(this.f70099f + 5);
        char cZ14 = z0(this.f70099f + 6);
        char cZ15 = z0(this.f70099f + 7);
        if (!z11) {
            if (i11 > 13) {
                char cZ16 = z0((this.f70099f + i11) - 1);
                char cZ17 = z0((this.f70099f + i11) - 2);
                if (cZ8 == '/' && cZ9 == 'D' && cZ10 == 'a' && cZ11 == 't' && cZ12 == 'e' && cZ13 == '(' && cZ16 == '/' && cZ17 == ')') {
                    int i22 = -1;
                    for (int i23 = 6; i23 < i11; i23++) {
                        char cZ18 = z0(this.f70099f + i23);
                        if (cZ18 != '+') {
                            if (cZ18 < '0' || cZ18 > '9') {
                                break;
                            }
                        } else {
                            i22 = i23;
                        }
                    }
                    if (i22 == -1) {
                        return false;
                    }
                    int i24 = this.f70099f;
                    int i25 = i24 + 6;
                    long j11 = Long.parseLong(k1(i25, (i24 + i22) - i25));
                    Calendar calendar = Calendar.getInstance(this.f70106m, this.f70107n);
                    this.f70105l = calendar;
                    calendar.setTimeInMillis(j11);
                    this.f70095a = 5;
                    return true;
                }
            }
        }
        if (i11 == 8 || i11 == 14 || ((i11 == 16 && ((cZ7 = z0(this.f70099f + 10)) == 'T' || cZ7 == ' ')) || (i11 == 17 && z0(this.f70099f + 6) != '-'))) {
            if (z11) {
                return false;
            }
            char cZ19 = z0(this.f70099f + 8);
            boolean z12 = cZ12 == '-' && cZ15 == '-';
            boolean z13 = z12 && i11 == 16;
            boolean z14 = z12 && i11 == 17;
            if (z14 || z13) {
                cZ0 = z0(this.f70099f + 9);
                c11 = cZ13;
                c12 = cZ14;
                c13 = cZ19;
            } else if (cZ12 == '-' && cZ14 == '-') {
                c12 = cZ13;
                cZ0 = cZ15;
                c11 = '0';
                c13 = '0';
            } else {
                c11 = cZ12;
                c12 = cZ13;
                c13 = cZ14;
                cZ0 = cZ15;
            }
            if (!n1(cZ8, cZ9, cZ10, cZ11, c11, c12, c13, cZ0)) {
                return false;
            }
            s1(cZ8, cZ9, cZ10, cZ11, c11, c12, c13, cZ0);
            if (i11 != 8) {
                char cZ20 = z0(this.f70099f + 9);
                char cZ21 = z0(this.f70099f + 10);
                char cZ22 = z0(this.f70099f + 11);
                char cZ23 = z0(this.f70099f + 12);
                char cZ24 = z0(this.f70099f + 13);
                if ((z14 && cZ21 == 'T' && cZ24 == ':' && z0(this.f70099f + 16) == 'Z') || (z13 && ((cZ21 == ' ' || cZ21 == 'T') && cZ24 == ':'))) {
                    char cZ25 = z0(this.f70099f + 14);
                    cZ1 = z0(this.f70099f + 15);
                    c15 = cZ25;
                    c17 = cZ22;
                    c14 = cZ23;
                    c18 = '0';
                    c16 = '0';
                } else {
                    c14 = cZ20;
                    c15 = cZ21;
                    cZ1 = cZ22;
                    c16 = cZ24;
                    c17 = cZ19;
                    c18 = cZ23;
                }
                if (!o1(c17, c14, c15, cZ1, c18, c16)) {
                    return false;
                }
                if (i11 != 17 || z14) {
                    i16 = 0;
                } else {
                    char cZ26 = z0(this.f70099f + 14);
                    char cZ27 = z0(this.f70099f + 15);
                    char cZ28 = z0(this.f70099f + 16);
                    if (cZ26 < '0' || cZ26 > '9' || cZ27 < '0' || cZ27 > '9' || cZ28 < '0' || cZ28 > '9') {
                        return false;
                    }
                    i16 = ((cZ26 - '0') * 100) + ((cZ27 - '0') * 10) + (cZ28 - '0');
                }
                i13 = ((c18 - '0') * 10) + (c16 - '0');
                i15 = ((c17 - '0') * 10) + (c14 - '0');
                i14 = i16;
                i12 = ((c15 - '0') * 10) + (cZ1 - '0');
            } else {
                i12 = 0;
                i13 = 0;
                i14 = 0;
                i15 = 0;
            }
            this.f70105l.set(11, i15);
            this.f70105l.set(12, i12);
            this.f70105l.set(13, i13);
            this.f70105l.set(14, i14);
            this.f70095a = 5;
            return true;
        }
        if (i11 < 9) {
            return false;
        }
        char cZ29 = z0(this.f70099f + 8);
        char cZ30 = z0(this.f70099f + 9);
        if ((cZ12 == '-' && cZ15 == '-') || (cZ12 == '/' && cZ15 == '/')) {
            if (cZ30 == ' ') {
                c19 = '0';
                i17 = 9;
                cZ9 = cZ29;
                cZ13 = cZ14;
                cZ10 = cZ10;
            } else {
                i17 = 10;
                c19 = cZ29;
                cZ13 = cZ14;
                cZ10 = cZ10;
                cZ13 = cZ13;
                cZ9 = cZ9;
                cZ9 = cZ30;
            }
        } else if (cZ12 == '-' && cZ14 == '-') {
            if (cZ29 == ' ') {
                cZ13 = '0';
                i17 = 8;
                cZ9 = cZ15;
                cZ11 = cZ11;
                c19 = '0';
            } else {
                cZ13 = '0';
                i17 = 9;
                cZ13 = cZ13;
                cZ9 = cZ9;
                cZ9 = cZ29;
                c19 = cZ15;
                cZ11 = cZ11;
            }
        } else if ((cZ10 == '.' && cZ13 == '.') || (cZ10 == '-' && cZ13 == '-')) {
            cZ9 = cZ15;
            cZ11 = cZ30;
            cZ13 = cZ11;
            c19 = cZ8;
            i17 = 10;
            cZ13 = cZ12;
            cZ8 = cZ14;
            cZ10 = cZ29;
        } else {
            if (cZ29 == 'T') {
                cZ13 = cZ12;
                cZ13 = cZ13;
                cZ8 = cZ8;
                cZ9 = cZ9;
                i17 = 8;
                cZ9 = cZ15;
                cZ11 = cZ11;
                c19 = cZ14;
            } else {
                if (cZ12 != 24180 && cZ12 != 45380) {
                    return false;
                }
                if (cZ15 != 26376 && cZ15 != 50900) {
                    if (cZ14 != 26376 && cZ14 != 50900) {
                        return false;
                    }
                    if (cZ29 == 26085 || cZ29 == 51068) {
                        cZ13 = '0';
                        i17 = 10;
                        cZ9 = cZ15;
                        cZ11 = cZ11;
                        c19 = '0';
                    } else {
                        if (cZ30 != 26085 && cZ30 != 51068) {
                            return false;
                        }
                        cZ13 = '0';
                        i17 = 10;
                        cZ13 = cZ13;
                        cZ9 = cZ9;
                        cZ9 = cZ29;
                        c19 = cZ15;
                        cZ11 = cZ11;
                    }
                } else if (cZ30 == 26085 || cZ30 == 51068) {
                    c19 = '0';
                    i17 = 10;
                    cZ9 = cZ29;
                    cZ13 = cZ14;
                } else {
                    if (z0(this.f70099f + 10) != 26085 && z0(this.f70099f + 10) != 51068) {
                        return false;
                    }
                    i17 = 11;
                    c19 = cZ29;
                    cZ13 = cZ14;
                    cZ10 = cZ10;
                    cZ13 = cZ13;
                    cZ9 = cZ9;
                    cZ9 = cZ30;
                }
            }
            cZ10 = cZ10;
        }
        if (!n1(cZ8, cZ9, cZ10, cZ11, cZ13, cZ13, c19, cZ9)) {
            return false;
        }
        s1(cZ8, cZ9, cZ10, cZ11, cZ13, cZ13, c19, cZ9);
        char cZ31 = z0(this.f70099f + i17);
        char c21 = 'T';
        if (cZ31 == 'T') {
            if (i11 == 16 && i17 == 8 && z0(this.f70099f + 15) == 'Z') {
                char cZ32 = z0(this.f70099f + i17 + 1);
                char cZ33 = z0(this.f70099f + i17 + 2);
                char cZ34 = z0(this.f70099f + i17 + 3);
                char cZ35 = z0(this.f70099f + i17 + 4);
                char cZ36 = z0(this.f70099f + i17 + 5);
                char cZ37 = z0(this.f70099f + i17 + 6);
                if (!o1(cZ32, cZ33, cZ34, cZ35, cZ36, cZ37)) {
                    return false;
                }
                t1(cZ32, cZ33, cZ34, cZ35, cZ36, cZ37);
                this.f70105l.set(14, 0);
                if (this.f70105l.getTimeZone().getRawOffset() != 0) {
                    String[] availableIDs = TimeZone.getAvailableIDs(0);
                    if (availableIDs.length > 0) {
                        this.f70105l.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                    }
                }
                this.f70095a = 5;
                return true;
            }
            c21 = 'T';
        }
        if (cZ31 != c21 && (cZ31 != ' ' || z11)) {
            if (cZ31 == '\"' || cZ31 == 26 || cZ31 == 26085 || cZ31 == 51068) {
                this.f70105l.set(11, 0);
                this.f70105l.set(12, 0);
                this.f70105l.set(13, 0);
                this.f70105l.set(14, 0);
                int i26 = this.f70099f + i17;
                this.f70099f = i26;
                this.f70098d = z0(i26);
                this.f70095a = 5;
                return true;
            }
            if ((cZ31 != '+' && cZ31 != '-') || this.f70116v != i17 + 6 || z0(this.f70099f + i17 + 3) != ':' || z0(this.f70099f + i17 + 4) != '0' || z0(this.f70099f + i17 + 5) != '0') {
                return false;
            }
            t1('0', '0', '0', '0', '0', '0');
            this.f70105l.set(14, 0);
            u1(cZ31, z0(this.f70099f + i17 + 1), z0(this.f70099f + i17 + 2));
            return true;
        }
        if (i11 < i17 + 9 || z0(this.f70099f + i17 + 3) != ':' || z0(this.f70099f + i17 + 6) != ':') {
            return false;
        }
        char cZ38 = z0(this.f70099f + i17 + 1);
        char cZ39 = z0(this.f70099f + i17 + 2);
        char cZ40 = z0(this.f70099f + i17 + 4);
        char cZ41 = z0(this.f70099f + i17 + 5);
        char cZ42 = z0(this.f70099f + i17 + 7);
        char cZ43 = z0(this.f70099f + i17 + 8);
        if (!o1(cZ38, cZ39, cZ40, cZ41, cZ42, cZ43)) {
            return false;
        }
        t1(cZ38, cZ39, cZ40, cZ41, cZ42, cZ43);
        if (z0(this.f70099f + i17 + 9) == '.') {
            int i27 = i17 + 11;
            if (i11 < i27 || (cZ4 = z0(this.f70099f + i17 + 10)) < '0' || cZ4 > '9') {
                return false;
            }
            int i28 = cZ4 - '0';
            if (i11 <= i27 || (cZ6 = z0(this.f70099f + i17 + 11)) < '0' || cZ6 > '9') {
                i18 = 1;
            } else {
                i28 = (i28 * 10) + (cZ6 - '0');
                i18 = 2;
            }
            if (i18 != 2 || (cZ5 = z0(this.f70099f + i17 + 12)) < '0' || cZ5 > '9') {
                i19 = i28;
            } else {
                i19 = (cZ5 - '0') + (i28 * 10);
                i18 = 3;
            }
        } else {
            i18 = -1;
            i19 = 0;
        }
        this.f70105l.set(14, i19);
        char cZ44 = z0(this.f70099f + i17 + 10 + i18);
        if (cZ44 == ' ') {
            i18++;
            cZ44 = z0(this.f70099f + i17 + 10 + i18);
        }
        char c22 = cZ44;
        if (c22 == '+' || c22 == '-') {
            char cZ45 = z0(this.f70099f + i17 + 10 + i18 + 1);
            if (cZ45 < '0' || cZ45 > '1' || (cZ2 = z0(this.f70099f + i17 + 10 + i18 + 2)) < '0' || cZ2 > '9') {
                return false;
            }
            char cZ46 = z0(this.f70099f + i17 + 10 + i18 + 3);
            char c23 = '3';
            if (cZ46 == ':') {
                char cZ47 = z0(this.f70099f + i17 + 10 + i18 + 4);
                cZ3 = z0(this.f70099f + i17 + 10 + i18 + 5);
                if (cZ47 == '4' && cZ3 == '5') {
                    if (cZ45 != '1' || (cZ2 != '2' && cZ2 != '3')) {
                        if (cZ45 != '0') {
                            return false;
                        }
                        if (cZ2 != '5' && cZ2 != '8') {
                            return false;
                        }
                    }
                } else if ((cZ47 != '0' && cZ47 != '3') || cZ3 != '0') {
                    return false;
                }
                c23 = cZ47;
                i21 = 6;
            } else {
                if (cZ46 == '0') {
                    char cZ48 = z0(this.f70099f + i17 + 10 + i18 + 4);
                    if (cZ48 != '0' && cZ48 != '3') {
                        return false;
                    }
                    c23 = cZ48;
                } else {
                    if (cZ46 != '3' || z0(this.f70099f + i17 + 10 + i18 + 4) != '0') {
                        if (cZ46 == '4' && z0(this.f70099f + i17 + 10 + i18 + 4) == '5') {
                            c23 = '4';
                            cZ3 = '5';
                        } else {
                            c23 = '0';
                            cZ3 = '0';
                        }
                    }
                    i21 = 5;
                }
                cZ3 = '0';
                i21 = 5;
            }
            v1(c22, cZ45, cZ2, c23, cZ3);
        } else if (c22 == 'Z') {
            if (this.f70105l.getTimeZone().getRawOffset() != 0) {
                String[] availableIDs2 = TimeZone.getAvailableIDs(0);
                if (availableIDs2.length > 0) {
                    this.f70105l.setTimeZone(TimeZone.getTimeZone(availableIDs2[0]));
                }
            }
            i21 = 1;
        } else {
            i21 = 0;
        }
        int i29 = i17 + 10 + i18 + i21;
        char cZ49 = z0(this.f70099f + i29);
        if (cZ49 != 26 && cZ49 != '\"') {
            return false;
        }
        int i31 = this.f70099f + i29;
        this.f70099f = i31;
        this.f70098d = z0(i31);
        this.f70095a = 5;
        return true;
    }

    @Override // l7.c, l7.b
    public long s0(char c11) {
        int i11;
        char cZ0;
        this.f70108o = 0;
        int i12 = this.f70099f;
        int i13 = i12 + 1;
        char cZ1 = z0(i12);
        boolean z11 = cZ1 == '\"';
        if (z11) {
            cZ1 = z0(i13);
            i13 = i12 + 2;
        }
        boolean z12 = cZ1 == '-';
        if (z12) {
            cZ1 = z0(i13);
            i13++;
        }
        if (cZ1 >= '0' && cZ1 <= '9') {
            long j11 = cZ1 - '0';
            while (true) {
                i11 = i13 + 1;
                cZ0 = z0(i13);
                if (cZ0 < '0' || cZ0 > '9') {
                    break;
                }
                j11 = (j11 * 10) + ((long) (cZ0 - '0'));
                i13 = i11;
            }
            if (cZ0 == '.') {
                this.f70108o = -1;
                return 0L;
            }
            if (z11) {
                if (cZ0 != '\"') {
                    this.f70108o = -1;
                    return 0L;
                }
                cZ0 = z0(i11);
                i11 = i13 + 2;
            }
            if (j11 < 0 && (j11 != Long.MIN_VALUE || !z12)) {
                this.f70108o = -1;
                return 0L;
            }
            while (cZ0 != c11) {
                if (!c.F0(cZ0)) {
                    this.f70108o = -1;
                    return j11;
                }
                cZ0 = z0(i11);
                i11++;
            }
            this.f70099f = i11;
            this.f70098d = z0(i11);
            this.f70108o = 3;
            this.f70095a = 16;
            return z12 ? -j11 : j11;
        }
        if (cZ1 == 'n') {
            int i14 = i13 + 1;
            if (z0(i13) == 'u') {
                int i15 = i13 + 2;
                if (z0(i14) == 'l') {
                    int i16 = i13 + 3;
                    if (z0(i15) == 'l') {
                        this.f70108o = 5;
                        int i17 = i13 + 4;
                        char cZ2 = z0(i16);
                        if (z11 && cZ2 == '\"') {
                            cZ2 = z0(i17);
                            i17 = i13 + 5;
                        }
                        while (cZ2 != ',') {
                            if (cZ2 == ']') {
                                this.f70099f = i17;
                                this.f70098d = z0(i17);
                                this.f70108o = 5;
                                this.f70095a = 15;
                                return 0L;
                            }
                            if (!c.F0(cZ2)) {
                                this.f70108o = -1;
                                return 0L;
                            }
                            char cZ3 = z0(i17);
                            i17++;
                            cZ2 = cZ3;
                        }
                        this.f70099f = i17;
                        this.f70098d = z0(i17);
                        this.f70108o = 5;
                        this.f70095a = 16;
                        return 0L;
                    }
                }
            }
        }
        this.f70108o = -1;
        return 0L;
    }

    public final void s1(char c11, char c12, char c13, char c14, char c15, char c16, char c17, char c18) {
        Calendar calendar = Calendar.getInstance(this.f70106m, this.f70107n);
        this.f70105l = calendar;
        calendar.set(1, ((c11 - '0') * 1000) + ((c12 - '0') * 100) + ((c13 - '0') * 10) + (c14 - '0'));
        this.f70105l.set(2, (((c15 - '0') * 10) + (c16 - '0')) - 1);
        this.f70105l.set(5, ((c17 - '0') * 10) + (c18 - '0'));
    }

    public void t1(char c11, char c12, char c13, char c14, char c15, char c16) {
        this.f70105l.set(11, ((c11 - '0') * 10) + (c12 - '0'));
        this.f70105l.set(12, ((c13 - '0') * 10) + (c14 - '0'));
        this.f70105l.set(13, ((c15 - '0') * 10) + (c16 - '0'));
    }

    public void u1(char c11, char c12, char c13) {
        v1(c11, c12, c13, '0', '0');
    }

    @Override // l7.c, l7.b
    public final String v0() {
        char cZ0 = z0((this.f70103j + this.f70102i) - 1);
        int i11 = this.f70102i;
        if (cZ0 == 'L' || cZ0 == 'S' || cZ0 == 'B' || cZ0 == 'F' || cZ0 == 'D') {
            i11--;
        }
        return k1(this.f70103j, i11);
    }

    public void v1(char c11, char c12, char c13, char c14, char c15) {
        int i11 = ((((c12 - '0') * 10) + (c13 - '0')) * 3600000) + ((((c14 - '0') * 10) + (c15 - '0')) * 60000);
        if (c11 == '-') {
            i11 = -i11;
        }
        if (this.f70105l.getTimeZone().getRawOffset() != i11) {
            this.f70105l.setTimeZone(new SimpleTimeZone(i11, Integer.toString(i11)));
        }
    }

    @Override // l7.c
    public final String w0(int i11, int i12, int i13, i iVar) {
        return iVar.a(this.f70115u, i11, i12, i13);
    }

    public final void w1(boolean z11) {
        int i11 = this.f70099f;
        boolean z12 = false;
        int i12 = 0;
        while (i11 < this.f70115u.length()) {
            char cCharAt = this.f70115u.charAt(i11);
            if (cCharAt == '\\') {
                if (i11 >= this.f70116v - 1) {
                    this.f70098d = cCharAt;
                    this.f70099f = i11;
                    throw new JSONException("illegal str, " + c());
                }
                i11++;
            } else if (cCharAt == '\"') {
                z12 = !z12;
            } else if (cCharAt != '[') {
                if (cCharAt == '{' && z11) {
                    int i13 = this.f70099f + 1;
                    this.f70099f = i13;
                    this.f70098d = i13 < this.f70115u.length() ? this.f70115u.charAt(i13) : (char) 26;
                    x1(z11);
                } else if (cCharAt == ']' && !z12 && (i12 = i12 - 1) == -1) {
                    int i14 = i11 + 1;
                    this.f70099f = i14;
                    if (i14 == this.f70115u.length()) {
                        this.f70098d = (char) 26;
                        this.f70095a = 20;
                        return;
                    } else {
                        this.f70098d = this.f70115u.charAt(this.f70099f);
                        W(16);
                        return;
                    }
                }
            } else if (!z12) {
                i12++;
            }
            i11++;
        }
        if (i11 != this.f70115u.length()) {
            return;
        }
        throw new JSONException("illegal str, " + c());
    }

    @Override // l7.c
    public final void x0(int i11, char[] cArr, int i12, int i13) {
        this.f70115u.getChars(i11, i13 + i11, cArr, i12);
    }

    public final void x1(boolean z11) {
        int i11 = this.f70099f;
        boolean z12 = false;
        int i12 = 0;
        while (i11 < this.f70115u.length()) {
            char cCharAt = this.f70115u.charAt(i11);
            if (cCharAt == '\\') {
                if (i11 >= this.f70116v - 1) {
                    this.f70098d = cCharAt;
                    this.f70099f = i11;
                    throw new JSONException("illegal str, " + c());
                }
                i11++;
            } else if (cCharAt == '\"') {
                z12 = !z12;
            } else if (cCharAt != '{') {
                if (cCharAt == '}' && !z12 && (i12 = i12 - 1) == -1) {
                    int i13 = i11 + 1;
                    this.f70099f = i13;
                    if (i13 == this.f70115u.length()) {
                        this.f70098d = (char) 26;
                        this.f70095a = 20;
                        return;
                    }
                    char cCharAt2 = this.f70115u.charAt(this.f70099f);
                    this.f70098d = cCharAt2;
                    if (cCharAt2 == ',') {
                        this.f70095a = 16;
                        int i14 = this.f70099f + 1;
                        this.f70099f = i14;
                        this.f70098d = i14 < this.f70115u.length() ? this.f70115u.charAt(i14) : (char) 26;
                        return;
                    }
                    if (cCharAt2 == '}') {
                        this.f70095a = 13;
                        next();
                        return;
                    } else if (cCharAt2 != ']') {
                        W(16);
                        return;
                    } else {
                        this.f70095a = 15;
                        next();
                        return;
                    }
                }
            } else if (!z12) {
                i12++;
            }
            i11++;
        }
        for (int i15 = 0; i15 < this.f70099f; i15++) {
            if (i15 < this.f70115u.length() && this.f70115u.charAt(i15) == ' ') {
                i11++;
            }
        }
        if (i11 != this.f70115u.length()) {
            return;
        }
        throw new JSONException("illegal str, " + c());
    }

    @Override // l7.c
    public final boolean y0(char[] cArr) {
        return m1(this.f70115u, this.f70099f, cArr);
    }

    @Override // l7.c
    public final char z0(int i11) {
        if (i11 >= this.f70116v) {
            return (char) 26;
        }
        return this.f70115u.charAt(i11);
    }
}
