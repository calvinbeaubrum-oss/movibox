package l7;

import androidx.core.view.MotionEventCompat;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.Feature;
import com.google.android.gms.ads.AdError;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.transsion.gslb.Worker;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import okio.internal.BufferKt;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c implements b, Closeable {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ThreadLocal<char[]> f70092r = new ThreadLocal<>();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final char[] f70093s = ("\"" + com.alibaba.fastjson.a.DEFAULT_TYPE_KEY + "\":\"").toCharArray();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int[] f70094t = new int[Worker.WHAT_SYNC_DATA];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f70095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f70096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f70097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public char f70098d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f70099f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f70100g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public char[] f70101h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f70102i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f70103j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f70104k;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f70109p;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Calendar f70105l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TimeZone f70106m = com.alibaba.fastjson.a.defaultTimeZone;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Locale f70107n = com.alibaba.fastjson.a.defaultLocale;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f70108o = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f70110q = 0;

    static {
        for (int i11 = 48; i11 <= 57; i11++) {
            f70094t[i11] = i11 - 48;
        }
        for (int i12 = 97; i12 <= 102; i12++) {
            f70094t[i12] = i12 - 87;
        }
        for (int i13 = 65; i13 <= 70; i13++) {
            f70094t[i13] = i13 - 55;
        }
    }

    public c(int i11) {
        this.f70109p = null;
        this.f70097c = i11;
        if ((i11 & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.f70109p = "";
        }
        char[] cArr = f70092r.get();
        this.f70101h = cArr;
        if (cArr == null) {
            this.f70101h = new char[512];
        }
    }

    public static boolean F0(char c11) {
        return c11 <= ' ' && (c11 == ' ' || c11 == '\n' || c11 == '\r' || c11 == '\t' || c11 == '\f' || c11 == '\b');
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00f1  */
    public static String L0(char[] cArr, int i11) {
        int i12;
        int i13;
        char[] cArr2 = new char[i11];
        int i14 = 0;
        int i15 = 0;
        while (i14 < i11) {
            char c11 = cArr[i14];
            if (c11 != '\\') {
                cArr2[i15] = c11;
                i15++;
            } else {
                int i16 = i14 + 1;
                char c12 = cArr[i16];
                if (c12 == '\"') {
                    i12 = i15 + 1;
                    cArr2[i15] = '\"';
                } else if (c12 == '\'') {
                    i12 = i15 + 1;
                    cArr2[i15] = '\'';
                } else if (c12 == 'F') {
                    i12 = i15 + 1;
                    cArr2[i15] = '\f';
                } else if (c12 == '\\') {
                    i12 = i15 + 1;
                    cArr2[i15] = '\\';
                } else if (c12 == 'b') {
                    i12 = i15 + 1;
                    cArr2[i15] = '\b';
                } else if (c12 == 'f') {
                    i12 = i15 + 1;
                    cArr2[i15] = '\f';
                } else if (c12 == 'n') {
                    i12 = i15 + 1;
                    cArr2[i15] = '\n';
                } else if (c12 != 'r') {
                    if (c12 != 'x') {
                        switch (c12) {
                            case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                i12 = i15 + 1;
                                cArr2[i15] = '/';
                                break;
                            case '0':
                                i12 = i15 + 1;
                                cArr2[i15] = 0;
                                break;
                            case '1':
                                i12 = i15 + 1;
                                cArr2[i15] = 1;
                                break;
                            case '2':
                                i12 = i15 + 1;
                                cArr2[i15] = 2;
                                break;
                            case '3':
                                i12 = i15 + 1;
                                cArr2[i15] = 3;
                                break;
                            case '4':
                                i12 = i15 + 1;
                                cArr2[i15] = 4;
                                break;
                            case '5':
                                i12 = i15 + 1;
                                cArr2[i15] = 5;
                                break;
                            case '6':
                                i12 = i15 + 1;
                                cArr2[i15] = 6;
                                break;
                            case '7':
                                i12 = i15 + 1;
                                cArr2[i15] = 7;
                                break;
                            default:
                                switch (c12) {
                                    case 't':
                                        i12 = i15 + 1;
                                        cArr2[i15] = '\t';
                                        break;
                                    case 'u':
                                        i13 = i15 + 1;
                                        i14 += 5;
                                        cArr2[i15] = (char) Integer.parseInt(new String(new char[]{cArr[i14 + 2], cArr[i14 + 3], cArr[i14 + 4], cArr[i14]}), 16);
                                        break;
                                    case 'v':
                                        i12 = i15 + 1;
                                        cArr2[i15] = 11;
                                        break;
                                    default:
                                        throw new JSONException("unclosed.str.lit");
                                }
                                break;
                        }
                    } else {
                        i13 = i15 + 1;
                        int[] iArr = f70094t;
                        int i17 = iArr[cArr[i14 + 2]] * 16;
                        i14 += 3;
                        cArr2[i15] = (char) (i17 + iArr[cArr[i14]]);
                    }
                    i15 = i13;
                } else {
                    i12 = i15 + 1;
                    cArr2[i15] = '\r';
                }
                i15 = i12;
                i14 = i16;
            }
            i14++;
        }
        return new String(cArr2, 0, i15);
    }

    public abstract void A0(int i11, int i12, char[] cArr);

    public double B0() {
        return Double.parseDouble(v0());
    }

    public Calendar C0() {
        return this.f70105l;
    }

    public abstract int D0(char c11, int i11);

    public abstract boolean E0();

    public void G0(String str, Object... objArr) {
        this.f70095a = 1;
    }

    public final boolean H0(char[] cArr) {
        while (!y0(cArr)) {
            if (!F0(this.f70098d)) {
                return false;
            }
            next();
        }
        int length = this.f70099f + cArr.length;
        this.f70099f = length;
        char cZ0 = z0(length);
        this.f70098d = cZ0;
        if (cZ0 == '{') {
            next();
            this.f70095a = 12;
        } else if (cZ0 == '[') {
            next();
            this.f70095a = 14;
        } else if (cZ0 == 'S' && z0(this.f70099f + 1) == 'e' && z0(this.f70099f + 2) == 't' && z0(this.f70099f + 3) == '[') {
            int i11 = this.f70099f + 3;
            this.f70099f = i11;
            this.f70098d = z0(i11);
            this.f70095a = 21;
        } else {
            w();
        }
        return true;
    }

    public final void I0() {
        while (F0(this.f70098d)) {
            next();
        }
        char c11 = this.f70098d;
        if (c11 == '_' || c11 == '$' || Character.isLetter(c11)) {
            b1();
        } else {
            w();
        }
    }

    public final void J0(char c11) {
        this.f70102i = 0;
        while (true) {
            char c12 = this.f70098d;
            if (c12 == c11) {
                next();
                w();
                return;
            }
            if (c12 != ' ' && c12 != '\n' && c12 != '\r' && c12 != '\t' && c12 != '\f' && c12 != '\b') {
                throw new JSONException("not match " + c11 + " - " + this.f70098d + ", info : " + c());
            }
            next();
        }
    }

    public final void K0(char c11) {
        int i11 = this.f70102i;
        char[] cArr = this.f70101h;
        if (i11 >= cArr.length) {
            int length = cArr.length * 2;
            if (length < i11) {
                length = i11 + 1;
            }
            char[] cArr2 = new char[length];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            this.f70101h = cArr2;
        }
        char[] cArr3 = this.f70101h;
        int i12 = this.f70102i;
        this.f70102i = i12 + 1;
        cArr3[i12] = c11;
    }

    public long M0(char[] cArr) {
        this.f70108o = 0;
        if (!y0(cArr)) {
            this.f70108o = -2;
            return 0L;
        }
        int length = cArr.length;
        int i11 = length + 1;
        if (z0(this.f70099f + length) != '\"') {
            this.f70108o = -1;
            return 0L;
        }
        long j11 = -3750763034362895579L;
        while (true) {
            int i12 = i11 + 1;
            char cZ0 = z0(this.f70099f + i11);
            if (cZ0 == '\"') {
                int i13 = i11 + 2;
                char cZ1 = z0(this.f70099f + i12);
                if (cZ1 == ',') {
                    int i14 = this.f70099f + i13;
                    this.f70099f = i14;
                    this.f70098d = z0(i14);
                    this.f70108o = 3;
                    return j11;
                }
                if (cZ1 != '}') {
                    this.f70108o = -1;
                    return 0L;
                }
                int i15 = i11 + 3;
                char cZ2 = z0(this.f70099f + i13);
                if (cZ2 == ',') {
                    this.f70095a = 16;
                    int i16 = this.f70099f + i15;
                    this.f70099f = i16;
                    this.f70098d = z0(i16);
                } else if (cZ2 == ']') {
                    this.f70095a = 15;
                    int i17 = this.f70099f + i15;
                    this.f70099f = i17;
                    this.f70098d = z0(i17);
                } else if (cZ2 == '}') {
                    this.f70095a = 13;
                    int i18 = this.f70099f + i15;
                    this.f70099f = i18;
                    this.f70098d = z0(i18);
                } else {
                    if (cZ2 != 26) {
                        this.f70108o = -1;
                        return 0L;
                    }
                    this.f70095a = 20;
                    this.f70099f += i11 + 2;
                    this.f70098d = (char) 26;
                }
                this.f70108o = 4;
                return j11;
            }
            j11 = (j11 ^ ((long) ((cZ0 < 'A' || cZ0 > 'Z') ? cZ0 : cZ0 + ' '))) * 1099511628211L;
            if (cZ0 == '\\') {
                this.f70108o = -1;
                return 0L;
            }
            i11 = i12;
        }
    }

    public final void N0() {
        if (this.f70098d != 'f') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.f70098d != 'a') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.f70098d != 'l') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.f70098d != 's') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.f70098d != 'e') {
            throw new JSONException("error parse false");
        }
        next();
        char c11 = this.f70098d;
        if (c11 != ' ' && c11 != ',' && c11 != '}' && c11 != ']' && c11 != '\n' && c11 != '\r' && c11 != '\t' && c11 != 26 && c11 != '\f' && c11 != '\b' && c11 != ':' && c11 != '/') {
            throw new JSONException("scan false error");
        }
        this.f70095a = 7;
    }

    public BigInteger O0(char[] cArr) {
        int i11;
        char cZ0;
        boolean z11;
        int length;
        int i12;
        BigInteger bigInteger;
        this.f70108o = 0;
        if (!y0(cArr)) {
            this.f70108o = -2;
            return null;
        }
        int length2 = cArr.length;
        int i13 = length2 + 1;
        char cZ1 = z0(this.f70099f + length2);
        boolean z12 = cZ1 == '\"';
        if (z12) {
            cZ1 = z0(this.f70099f + i13);
            i13 = length2 + 2;
        }
        boolean z13 = cZ1 == '-';
        if (z13) {
            cZ1 = z0(this.f70099f + i13);
            i13++;
        }
        if (cZ1 >= '0') {
            char c11 = '9';
            if (cZ1 <= '9') {
                long j11 = cZ1 - '0';
                while (true) {
                    i11 = i13 + 1;
                    cZ0 = z0(this.f70099f + i13);
                    if (cZ0 < '0' || cZ0 > c11) {
                        z11 = false;
                        break;
                    }
                    long j12 = (10 * j11) + ((long) (cZ0 - '0'));
                    if (j12 < j11) {
                        z11 = true;
                        break;
                    }
                    j11 = j12;
                    i13 = i11;
                    c11 = '9';
                }
                if (!z12) {
                    int i14 = this.f70099f;
                    length = cArr.length + i14;
                    i12 = ((i14 + i11) - length) - 1;
                } else {
                    if (cZ0 != '\"') {
                        this.f70108o = -1;
                        return null;
                    }
                    int i15 = i13 + 2;
                    cZ0 = z0(this.f70099f + i11);
                    int i16 = this.f70099f;
                    length = cArr.length + i16 + 1;
                    i12 = ((i16 + i15) - length) - 2;
                    i11 = i15;
                }
                if (!z11 && (i12 < 20 || (z13 && i12 < 21))) {
                    if (z13) {
                        j11 = -j11;
                    }
                    bigInteger = BigInteger.valueOf(j11);
                } else {
                    if (i12 > 65535) {
                        throw new JSONException("scanInteger overflow");
                    }
                    bigInteger = new BigInteger(k1(length, i12), 10);
                }
                if (cZ0 == ',') {
                    int i17 = this.f70099f + i11;
                    this.f70099f = i17;
                    this.f70098d = z0(i17);
                    this.f70108o = 3;
                    this.f70095a = 16;
                    return bigInteger;
                }
                if (cZ0 != '}') {
                    this.f70108o = -1;
                    return null;
                }
                int i18 = i11 + 1;
                char cZ2 = z0(this.f70099f + i11);
                if (cZ2 == ',') {
                    this.f70095a = 16;
                    int i19 = this.f70099f + i18;
                    this.f70099f = i19;
                    this.f70098d = z0(i19);
                } else if (cZ2 == ']') {
                    this.f70095a = 15;
                    int i21 = this.f70099f + i18;
                    this.f70099f = i21;
                    this.f70098d = z0(i21);
                } else if (cZ2 == '}') {
                    this.f70095a = 13;
                    int i22 = this.f70099f + i18;
                    this.f70099f = i22;
                    this.f70098d = z0(i22);
                } else {
                    if (cZ2 != 26) {
                        this.f70108o = -1;
                        return null;
                    }
                    this.f70095a = 20;
                    this.f70099f += i11;
                    this.f70098d = (char) 26;
                }
                this.f70108o = 4;
                return bigInteger;
            }
        }
        if (cZ1 != 'n' || z0(this.f70099f + i13) != 'u' || z0(this.f70099f + i13 + 1) != 'l' || z0(this.f70099f + i13 + 2) != 'l') {
            this.f70108o = -1;
            return null;
        }
        this.f70108o = 5;
        int i23 = i13 + 4;
        char cZ3 = z0(this.f70099f + i13 + 3);
        if (z12 && cZ3 == '\"') {
            cZ3 = z0(this.f70099f + i23);
            i23 = i13 + 5;
        }
        while (cZ3 != ',') {
            if (cZ3 == '}') {
                int i24 = this.f70099f + i23;
                this.f70099f = i24;
                this.f70098d = z0(i24);
                this.f70108o = 5;
                this.f70095a = 13;
                return null;
            }
            if (!F0(cZ3)) {
                this.f70108o = -1;
                return null;
            }
            cZ3 = z0(this.f70099f + i23);
            i23++;
        }
        int i25 = this.f70099f + i23;
        this.f70099f = i25;
        this.f70098d = z0(i25);
        this.f70108o = 5;
        this.f70095a = 16;
        return null;
    }

    public boolean P0(char[] cArr) {
        int i11;
        boolean z11;
        this.f70108o = 0;
        if (!y0(cArr)) {
            this.f70108o = -2;
            return false;
        }
        int length = cArr.length;
        int i12 = length + 1;
        char cZ0 = z0(this.f70099f + length);
        if (cZ0 == 't') {
            int i13 = length + 2;
            if (z0(this.f70099f + i12) != 'r') {
                this.f70108o = -1;
                return false;
            }
            int i14 = length + 3;
            if (z0(this.f70099f + i13) != 'u') {
                this.f70108o = -1;
                return false;
            }
            i11 = length + 4;
            if (z0(this.f70099f + i14) != 'e') {
                this.f70108o = -1;
                return false;
            }
            z11 = true;
        } else {
            if (cZ0 != 'f') {
                this.f70108o = -1;
                return false;
            }
            int i15 = length + 2;
            if (z0(this.f70099f + i12) != 'a') {
                this.f70108o = -1;
                return false;
            }
            int i16 = length + 3;
            if (z0(this.f70099f + i15) != 'l') {
                this.f70108o = -1;
                return false;
            }
            int i17 = length + 4;
            if (z0(this.f70099f + i16) != 's') {
                this.f70108o = -1;
                return false;
            }
            i11 = length + 5;
            if (z0(this.f70099f + i17) != 'e') {
                this.f70108o = -1;
                return false;
            }
            z11 = false;
        }
        int i18 = i11 + 1;
        char cZ1 = z0(this.f70099f + i11);
        if (cZ1 == ',') {
            int i19 = this.f70099f + i18;
            this.f70099f = i19;
            this.f70098d = z0(i19);
            this.f70108o = 3;
            this.f70095a = 16;
            return z11;
        }
        if (cZ1 != '}') {
            this.f70108o = -1;
            return false;
        }
        int i21 = i11 + 2;
        char cZ2 = z0(this.f70099f + i18);
        if (cZ2 == ',') {
            this.f70095a = 16;
            int i22 = this.f70099f + i21;
            this.f70099f = i22;
            this.f70098d = z0(i22);
        } else if (cZ2 == ']') {
            this.f70095a = 15;
            int i23 = this.f70099f + i21;
            this.f70099f = i23;
            this.f70098d = z0(i23);
        } else if (cZ2 == '}') {
            this.f70095a = 13;
            int i24 = this.f70099f + i21;
            this.f70099f = i24;
            this.f70098d = z0(i24);
        } else {
            if (cZ2 != 26) {
                this.f70108o = -1;
                return false;
            }
            this.f70095a = 20;
            this.f70099f += i11 + 1;
            this.f70098d = (char) 26;
        }
        this.f70108o = 4;
        return z11;
    }

    public Date Q0(char[] cArr) {
        char cZ0;
        int i11;
        long j11;
        Date date;
        int i12;
        char cZ1;
        boolean z11 = false;
        this.f70108o = 0;
        if (!y0(cArr)) {
            this.f70108o = -2;
            return null;
        }
        int length = cArr.length;
        int i13 = length + 1;
        char cZ2 = z0(this.f70099f + length);
        if (cZ2 == '\"') {
            int iD0 = D0('\"', this.f70099f + cArr.length + 1);
            if (iD0 == -1) {
                throw new JSONException("unclosed str");
            }
            int length2 = this.f70099f + cArr.length + 1;
            String strK1 = k1(length2, iD0 - length2);
            if (strK1.indexOf(92) != -1) {
                while (true) {
                    int i14 = 0;
                    for (int i15 = iD0 - 1; i15 >= 0 && z0(i15) == '\\'; i15--) {
                        i14++;
                    }
                    if (i14 % 2 == 0) {
                        break;
                    }
                    iD0 = D0('\"', iD0 + 1);
                }
                int i16 = this.f70099f;
                int length3 = iD0 - ((cArr.length + i16) + 1);
                strK1 = L0(l1(i16 + cArr.length + 1, length3), length3);
            }
            int i17 = this.f70099f;
            int length4 = i13 + (iD0 - ((cArr.length + i17) + 1)) + 1;
            i11 = length4 + 1;
            cZ0 = z0(i17 + length4);
            e eVar = new e(strK1);
            try {
                if (!eVar.q1(false)) {
                    this.f70108o = -1;
                    eVar.close();
                    return null;
                }
                date = eVar.C0().getTime();
                eVar.close();
            } catch (Throwable th2) {
                eVar.close();
                throw th2;
            }
        } else {
            if (cZ2 != '-' && (cZ2 < '0' || cZ2 > '9')) {
                this.f70108o = -1;
                return null;
            }
            if (cZ2 == '-') {
                cZ2 = z0(this.f70099f + i13);
                i13 = length + 2;
                z11 = true;
            }
            if (cZ2 < '0' || cZ2 > '9') {
                cZ0 = cZ2;
                i11 = i13;
                j11 = 0;
            } else {
                j11 = cZ2 - '0';
                while (true) {
                    i12 = i13 + 1;
                    cZ1 = z0(this.f70099f + i13);
                    if (cZ1 < '0' || cZ1 > '9') {
                        break;
                    }
                    j11 = (j11 * 10) + ((long) (cZ1 - '0'));
                    i13 = i12;
                }
                cZ0 = cZ1;
                i11 = i12;
            }
            if (j11 < 0) {
                this.f70108o = -1;
                return null;
            }
            if (z11) {
                j11 = -j11;
            }
            date = new Date(j11);
        }
        if (cZ0 == ',') {
            int i18 = this.f70099f + i11;
            this.f70099f = i18;
            this.f70098d = z0(i18);
            this.f70108o = 3;
            return date;
        }
        if (cZ0 != '}') {
            this.f70108o = -1;
            return null;
        }
        int i19 = i11 + 1;
        char cZ3 = z0(this.f70099f + i11);
        if (cZ3 == ',') {
            this.f70095a = 16;
            int i21 = this.f70099f + i19;
            this.f70099f = i21;
            this.f70098d = z0(i21);
        } else if (cZ3 == ']') {
            this.f70095a = 15;
            int i22 = this.f70099f + i19;
            this.f70099f = i22;
            this.f70098d = z0(i22);
        } else if (cZ3 == '}') {
            this.f70095a = 13;
            int i23 = this.f70099f + i19;
            this.f70099f = i23;
            this.f70098d = z0(i23);
        } else {
            if (cZ3 != 26) {
                this.f70108o = -1;
                return null;
            }
            this.f70095a = 20;
            this.f70099f += i11;
            this.f70098d = (char) 26;
        }
        this.f70108o = 4;
        return date;
    }

    public BigDecimal R0(char[] cArr) {
        int i11;
        char cZ0;
        int length;
        int i12;
        this.f70108o = 0;
        if (!y0(cArr)) {
            this.f70108o = -2;
            return null;
        }
        int length2 = cArr.length;
        int i13 = length2 + 1;
        char cZ1 = z0(this.f70099f + length2);
        boolean z11 = cZ1 == '\"';
        if (z11) {
            cZ1 = z0(this.f70099f + i13);
            i13 = length2 + 2;
        }
        if (cZ1 == '-') {
            cZ1 = z0(this.f70099f + i13);
            i13++;
        }
        if (cZ1 < '0' || cZ1 > '9') {
            if (cZ1 != 'n' || z0(this.f70099f + i13) != 'u' || z0(this.f70099f + i13 + 1) != 'l' || z0(this.f70099f + i13 + 2) != 'l') {
                this.f70108o = -1;
                return null;
            }
            this.f70108o = 5;
            int i14 = i13 + 4;
            char cZ2 = z0(this.f70099f + i13 + 3);
            if (z11 && cZ2 == '\"') {
                cZ2 = z0(this.f70099f + i14);
                i14 = i13 + 5;
            }
            while (cZ2 != ',') {
                if (cZ2 == '}') {
                    int i15 = this.f70099f + i14;
                    this.f70099f = i15;
                    this.f70098d = z0(i15);
                    this.f70108o = 5;
                    this.f70095a = 13;
                    return null;
                }
                if (!F0(cZ2)) {
                    this.f70108o = -1;
                    return null;
                }
                cZ2 = z0(this.f70099f + i14);
                i14++;
            }
            int i16 = this.f70099f + i14;
            this.f70099f = i16;
            this.f70098d = z0(i16);
            this.f70108o = 5;
            this.f70095a = 16;
            return null;
        }
        while (true) {
            i11 = i13 + 1;
            cZ0 = z0(this.f70099f + i13);
            if (cZ0 < '0' || cZ0 > '9') {
                break;
            }
            i13 = i11;
        }
        if (cZ0 == '.') {
            int i17 = i13 + 2;
            char cZ3 = z0(this.f70099f + i11);
            if (cZ3 < '0' || cZ3 > '9') {
                this.f70108o = -1;
                return null;
            }
            while (true) {
                i11 = i17 + 1;
                cZ0 = z0(this.f70099f + i17);
                if (cZ0 < '0' || cZ0 > '9') {
                    break;
                }
                i17 = i11;
            }
        }
        if (cZ0 == 'e' || cZ0 == 'E') {
            int i18 = i11 + 1;
            cZ0 = z0(this.f70099f + i11);
            if (cZ0 == '+' || cZ0 == '-') {
                i11 += 2;
                cZ0 = z0(this.f70099f + i18);
            } else {
                i11 = i18;
            }
            while (cZ0 >= '0' && cZ0 <= '9') {
                char cZ4 = z0(this.f70099f + i11);
                i11++;
                cZ0 = cZ4;
            }
        }
        if (!z11) {
            int i19 = this.f70099f;
            length = cArr.length + i19;
            i12 = ((i19 + i11) - length) - 1;
        } else {
            if (cZ0 != '\"') {
                this.f70108o = -1;
                return null;
            }
            int i21 = i11 + 1;
            char cZ5 = z0(this.f70099f + i11);
            int i22 = this.f70099f;
            length = cArr.length + i22 + 1;
            i12 = ((i22 + i21) - length) - 2;
            i11 = i21;
            cZ0 = cZ5;
        }
        if (i12 > 65535) {
            throw new JSONException("scan decimal overflow");
        }
        char[] cArrL1 = l1(length, i12);
        BigDecimal bigDecimal = new BigDecimal(cArrL1, 0, cArrL1.length, MathContext.UNLIMITED);
        if (cZ0 == ',') {
            int i23 = this.f70099f + i11;
            this.f70099f = i23;
            this.f70098d = z0(i23);
            this.f70108o = 3;
            this.f70095a = 16;
            return bigDecimal;
        }
        if (cZ0 != '}') {
            this.f70108o = -1;
            return null;
        }
        int i24 = i11 + 1;
        char cZ6 = z0(this.f70099f + i11);
        if (cZ6 == ',') {
            this.f70095a = 16;
            int i25 = this.f70099f + i24;
            this.f70099f = i25;
            this.f70098d = z0(i25);
        } else if (cZ6 == ']') {
            this.f70095a = 15;
            int i26 = this.f70099f + i24;
            this.f70099f = i26;
            this.f70098d = z0(i26);
        } else if (cZ6 == '}') {
            this.f70095a = 13;
            int i27 = this.f70099f + i24;
            this.f70099f = i27;
            this.f70098d = z0(i27);
        } else {
            if (cZ6 != 26) {
                this.f70108o = -1;
                return null;
            }
            this.f70095a = 20;
            this.f70099f += i11;
            this.f70098d = (char) 26;
        }
        this.f70108o = 4;
        return bigDecimal;
    }

    public final double S0(char[] cArr) {
        int i11;
        char cZ0;
        long j11;
        int length;
        int i12;
        double d11;
        this.f70108o = 0;
        if (!y0(cArr)) {
            this.f70108o = -2;
            return 0.0d;
        }
        int length2 = cArr.length;
        int i13 = length2 + 1;
        char cZ1 = z0(this.f70099f + length2);
        boolean z11 = cZ1 == '\"';
        if (z11) {
            cZ1 = z0(this.f70099f + i13);
            i13 = length2 + 2;
        }
        boolean z12 = cZ1 == '-';
        if (z12) {
            cZ1 = z0(this.f70099f + i13);
            i13++;
        }
        if (cZ1 < '0' || cZ1 > '9') {
            if (cZ1 != 'n' || z0(this.f70099f + i13) != 'u' || z0(this.f70099f + i13 + 1) != 'l' || z0(this.f70099f + i13 + 2) != 'l') {
                this.f70108o = -1;
                return 0.0d;
            }
            this.f70108o = 5;
            int i14 = i13 + 4;
            char cZ2 = z0(this.f70099f + i13 + 3);
            if (z11 && cZ2 == '\"') {
                cZ2 = z0(this.f70099f + i14);
                i14 = i13 + 5;
            }
            while (cZ2 != ',') {
                if (cZ2 == '}') {
                    int i15 = this.f70099f + i14;
                    this.f70099f = i15;
                    this.f70098d = z0(i15);
                    this.f70108o = 5;
                    this.f70095a = 13;
                    return 0.0d;
                }
                if (!F0(cZ2)) {
                    this.f70108o = -1;
                    return 0.0d;
                }
                cZ2 = z0(this.f70099f + i14);
                i14++;
            }
            int i16 = this.f70099f + i14;
            this.f70099f = i16;
            this.f70098d = z0(i16);
            this.f70108o = 5;
            this.f70095a = 16;
            return 0.0d;
        }
        long j12 = cZ1 - '0';
        while (true) {
            i11 = i13 + 1;
            cZ0 = z0(this.f70099f + i13);
            if (cZ0 < '0' || cZ0 > '9') {
                break;
            }
            j12 = (j12 * 10) + ((long) (cZ0 - '0'));
            i13 = i11;
        }
        if (cZ0 == '.') {
            int i17 = i13 + 2;
            char cZ3 = z0(this.f70099f + i11);
            if (cZ3 < '0' || cZ3 > '9') {
                this.f70108o = -1;
                return 0.0d;
            }
            j12 = (j12 * 10) + ((long) (cZ3 - '0'));
            j11 = 10;
            while (true) {
                i11 = i17 + 1;
                cZ0 = z0(this.f70099f + i17);
                if (cZ0 < '0' || cZ0 > '9') {
                    break;
                }
                j12 = (j12 * 10) + ((long) (cZ0 - '0'));
                j11 *= 10;
                i17 = i11;
            }
        } else {
            j11 = 1;
        }
        boolean z13 = cZ0 == 'e' || cZ0 == 'E';
        if (z13) {
            int i18 = i11 + 1;
            cZ0 = z0(this.f70099f + i11);
            if (cZ0 == '+' || cZ0 == '-') {
                i11 += 2;
                cZ0 = z0(this.f70099f + i18);
            } else {
                i11 = i18;
            }
            while (cZ0 >= '0' && cZ0 <= '9') {
                cZ0 = z0(this.f70099f + i11);
                i11++;
            }
        }
        if (!z11) {
            int i19 = this.f70099f;
            length = cArr.length + i19;
            i12 = ((i19 + i11) - length) - 1;
        } else {
            if (cZ0 != '\"') {
                this.f70108o = -1;
                return 0.0d;
            }
            int i21 = i11 + 1;
            cZ0 = z0(this.f70099f + i11);
            int i22 = this.f70099f;
            length = cArr.length + i22 + 1;
            i12 = ((i22 + i21) - length) - 2;
            i11 = i21;
        }
        if (z13 || i12 >= 17) {
            d11 = Double.parseDouble(k1(length, i12));
        } else {
            d11 = j12 / j11;
            if (z12) {
                d11 = -d11;
            }
        }
        if (cZ0 == ',') {
            int i23 = this.f70099f + i11;
            this.f70099f = i23;
            this.f70098d = z0(i23);
            this.f70108o = 3;
            this.f70095a = 16;
            return d11;
        }
        if (cZ0 != '}') {
            this.f70108o = -1;
            return 0.0d;
        }
        int i24 = i11 + 1;
        char cZ4 = z0(this.f70099f + i11);
        if (cZ4 == ',') {
            this.f70095a = 16;
            int i25 = this.f70099f + i24;
            this.f70099f = i25;
            this.f70098d = z0(i25);
        } else if (cZ4 == ']') {
            this.f70095a = 15;
            int i26 = this.f70099f + i24;
            this.f70099f = i26;
            this.f70098d = z0(i26);
        } else if (cZ4 == '}') {
            this.f70095a = 13;
            int i27 = this.f70099f + i24;
            this.f70099f = i27;
            this.f70098d = z0(i27);
        } else {
            if (cZ4 != 26) {
                this.f70108o = -1;
                return 0.0d;
            }
            this.f70095a = 20;
            this.f70099f += i11;
            this.f70098d = (char) 26;
        }
        this.f70108o = 4;
        return d11;
    }

    public final float T0(char[] cArr) {
        int i11;
        char cZ0;
        long j11;
        int length;
        int i12;
        float f11;
        this.f70108o = 0;
        if (!y0(cArr)) {
            this.f70108o = -2;
            return 0.0f;
        }
        int length2 = cArr.length;
        int i13 = length2 + 1;
        char cZ1 = z0(this.f70099f + length2);
        boolean z11 = cZ1 == '\"';
        if (z11) {
            cZ1 = z0(this.f70099f + i13);
            i13 = length2 + 2;
        }
        boolean z12 = cZ1 == '-';
        if (z12) {
            cZ1 = z0(this.f70099f + i13);
            i13++;
        }
        if (cZ1 < '0' || cZ1 > '9') {
            if (cZ1 != 'n' || z0(this.f70099f + i13) != 'u' || z0(this.f70099f + i13 + 1) != 'l' || z0(this.f70099f + i13 + 2) != 'l') {
                this.f70108o = -1;
                return 0.0f;
            }
            this.f70108o = 5;
            int i14 = i13 + 4;
            char cZ2 = z0(this.f70099f + i13 + 3);
            if (z11 && cZ2 == '\"') {
                cZ2 = z0(this.f70099f + i14);
                i14 = i13 + 5;
            }
            while (cZ2 != ',') {
                if (cZ2 == '}') {
                    int i15 = this.f70099f + i14;
                    this.f70099f = i15;
                    this.f70098d = z0(i15);
                    this.f70108o = 5;
                    this.f70095a = 13;
                    return 0.0f;
                }
                if (!F0(cZ2)) {
                    this.f70108o = -1;
                    return 0.0f;
                }
                cZ2 = z0(this.f70099f + i14);
                i14++;
            }
            int i16 = this.f70099f + i14;
            this.f70099f = i16;
            this.f70098d = z0(i16);
            this.f70108o = 5;
            this.f70095a = 16;
            return 0.0f;
        }
        long j12 = cZ1 - '0';
        while (true) {
            i11 = i13 + 1;
            cZ0 = z0(this.f70099f + i13);
            if (cZ0 < '0' || cZ0 > '9') {
                break;
            }
            j12 = (j12 * 10) + ((long) (cZ0 - '0'));
            i13 = i11;
        }
        if (cZ0 == '.') {
            int i17 = i13 + 2;
            char cZ3 = z0(this.f70099f + i11);
            if (cZ3 < '0' || cZ3 > '9') {
                this.f70108o = -1;
                return 0.0f;
            }
            j12 = (j12 * 10) + ((long) (cZ3 - '0'));
            j11 = 10;
            while (true) {
                i11 = i17 + 1;
                cZ0 = z0(this.f70099f + i17);
                if (cZ0 < '0' || cZ0 > '9') {
                    break;
                }
                j12 = (j12 * 10) + ((long) (cZ0 - '0'));
                j11 *= 10;
                i17 = i11;
            }
        } else {
            j11 = 1;
        }
        boolean z13 = cZ0 == 'e' || cZ0 == 'E';
        if (z13) {
            int i18 = i11 + 1;
            cZ0 = z0(this.f70099f + i11);
            if (cZ0 == '+' || cZ0 == '-') {
                i11 += 2;
                cZ0 = z0(this.f70099f + i18);
            } else {
                i11 = i18;
            }
            while (cZ0 >= '0' && cZ0 <= '9') {
                char cZ4 = z0(this.f70099f + i11);
                i11++;
                cZ0 = cZ4;
            }
        }
        if (!z11) {
            int i19 = this.f70099f;
            length = cArr.length + i19;
            i12 = ((i19 + i11) - length) - 1;
        } else {
            if (cZ0 != '\"') {
                this.f70108o = -1;
                return 0.0f;
            }
            int i21 = i11 + 1;
            cZ0 = z0(this.f70099f + i11);
            int i22 = this.f70099f;
            length = cArr.length + i22 + 1;
            i12 = ((i22 + i21) - length) - 2;
            i11 = i21;
        }
        if (z13 || i12 >= 17) {
            f11 = Float.parseFloat(k1(length, i12));
        } else {
            f11 = (float) (j12 / j11);
            if (z12) {
                f11 = -f11;
            }
        }
        if (cZ0 == ',') {
            int i23 = this.f70099f + i11;
            this.f70099f = i23;
            this.f70098d = z0(i23);
            this.f70108o = 3;
            this.f70095a = 16;
            return f11;
        }
        if (cZ0 != '}') {
            this.f70108o = -1;
            return 0.0f;
        }
        int i24 = i11 + 1;
        char cZ5 = z0(this.f70099f + i11);
        if (cZ5 == ',') {
            this.f70095a = 16;
            int i25 = this.f70099f + i24;
            this.f70099f = i25;
            this.f70098d = z0(i25);
        } else if (cZ5 == ']') {
            this.f70095a = 15;
            int i26 = this.f70099f + i24;
            this.f70099f = i26;
            this.f70098d = z0(i26);
        } else if (cZ5 == '}') {
            this.f70095a = 13;
            int i27 = this.f70099f + i24;
            this.f70099f = i27;
            this.f70098d = z0(i27);
        } else {
            if (cZ5 != 26) {
                this.f70108o = -1;
                return 0.0f;
            }
            this.f70099f += i11;
            this.f70095a = 20;
            this.f70098d = (char) 26;
        }
        this.f70108o = 4;
        return f11;
    }

    @Override // l7.b
    public Enum<?> U(Class<?> cls, i iVar, char c11) {
        String strF1 = f1(iVar, c11);
        if (strF1 == null) {
            return null;
        }
        return Enum.valueOf(cls, strF1);
    }

    public final float[] U0(char[] cArr) {
        int i11;
        char cZ0;
        int i12;
        float f11;
        float[] fArr;
        this.f70108o = 0;
        float[] fArr2 = null;
        if (!y0(cArr)) {
            this.f70108o = -2;
            return null;
        }
        int length = cArr.length;
        int i13 = length + 1;
        if (z0(this.f70099f + length) != '[') {
            this.f70108o = -2;
            return null;
        }
        int i14 = length + 2;
        char cZ1 = z0(this.f70099f + i13);
        float[] fArr3 = new float[16];
        int i15 = 0;
        while (true) {
            int i16 = this.f70099f;
            int i17 = (i16 + i14) - 1;
            boolean z11 = cZ1 == '-';
            if (z11) {
                cZ1 = z0(i16 + i14);
                i14++;
            }
            if (cZ1 < '0' || cZ1 > '9') {
                break;
            }
            int i18 = cZ1 - '0';
            while (true) {
                i11 = i14 + 1;
                cZ0 = z0(this.f70099f + i14);
                if (cZ0 < '0' || cZ0 > '9') {
                    break;
                }
                i18 = (i18 * 10) + (cZ0 - '0');
                i14 = i11;
            }
            if (cZ0 == '.') {
                int i19 = i14 + 2;
                char cZ2 = z0(this.f70099f + i11);
                if (cZ2 < '0' || cZ2 > '9') {
                    this.f70108o = -1;
                    return fArr2;
                }
                i18 = (i18 * 10) + (cZ2 - '0');
                i12 = 10;
                while (true) {
                    i11 = i19 + 1;
                    cZ0 = z0(this.f70099f + i19);
                    if (cZ0 < '0' || cZ0 > '9') {
                        break;
                    }
                    i18 = (i18 * 10) + (cZ0 - '0');
                    i12 *= 10;
                    i19 = i11;
                }
            } else {
                i12 = 1;
            }
            boolean z12 = cZ0 == 'e' || cZ0 == 'E';
            if (z12) {
                int i21 = i11 + 1;
                cZ0 = z0(this.f70099f + i11);
                if (cZ0 == '+' || cZ0 == '-') {
                    i11 += 2;
                    cZ0 = z0(this.f70099f + i21);
                } else {
                    i11 = i21;
                }
                while (cZ0 >= '0' && cZ0 <= '9') {
                    cZ0 = z0(this.f70099f + i11);
                    i11++;
                }
            }
            int i22 = ((this.f70099f + i11) - i17) - 1;
            if (z12 || i22 >= 10) {
                f11 = Float.parseFloat(k1(i17, i22));
            } else {
                f11 = i18 / i12;
                if (z11) {
                    f11 = -f11;
                }
            }
            if (i15 >= fArr3.length) {
                float[] fArr4 = new float[(fArr3.length * 3) / 2];
                System.arraycopy(fArr3, 0, fArr4, 0, i15);
                fArr3 = fArr4;
            }
            int i23 = i15 + 1;
            fArr3[i15] = f11;
            if (cZ0 == ',') {
                i14 = i11 + 1;
                cZ0 = z0(this.f70099f + i11);
                fArr = null;
            } else {
                if (cZ0 == ']') {
                    int i24 = i11 + 1;
                    char cZ3 = z0(this.f70099f + i11);
                    if (i23 != fArr3.length) {
                        float[] fArr5 = new float[i23];
                        System.arraycopy(fArr3, 0, fArr5, 0, i23);
                        fArr3 = fArr5;
                    }
                    if (cZ3 == ',') {
                        this.f70099f += i11;
                        next();
                        this.f70108o = 3;
                        this.f70095a = 16;
                        return fArr3;
                    }
                    if (cZ3 != '}') {
                        this.f70108o = -1;
                        return null;
                    }
                    char cZ4 = z0(this.f70099f + i24);
                    if (cZ4 == ',') {
                        this.f70095a = 16;
                        this.f70099f += i11 + 1;
                        next();
                    } else if (cZ4 == ']') {
                        this.f70095a = 15;
                        this.f70099f += i11 + 1;
                        next();
                    } else if (cZ4 == '}') {
                        this.f70095a = 13;
                        this.f70099f += i11 + 1;
                        next();
                    } else {
                        if (cZ4 != 26) {
                            this.f70108o = -1;
                            return null;
                        }
                        this.f70099f += i11 + 1;
                        this.f70095a = 20;
                        this.f70098d = (char) 26;
                    }
                    this.f70108o = 4;
                    return fArr3;
                }
                fArr = null;
                i14 = i11;
            }
            i15 = i23;
            cZ1 = cZ0;
            fArr2 = fArr;
        }
        float[] fArr6 = fArr2;
        this.f70108o = -1;
        return fArr6;
    }

    public final float[][] V0(char[] cArr) {
        int i11;
        char cZ0;
        int i12;
        int i13;
        float f11;
        int i14;
        int i15;
        char cZ1;
        this.f70108o = 0;
        float[][] fArr = null;
        if (!y0(cArr)) {
            this.f70108o = -2;
            return null;
        }
        int length = cArr.length;
        int i16 = length + 1;
        if (z0(this.f70099f + length) != '[') {
            this.f70108o = -2;
            return null;
        }
        int i17 = length + 2;
        char cZ2 = z0(this.f70099f + i16);
        int i18 = 16;
        float[][] fArr2 = new float[16][];
        int i19 = 0;
        for (char c11 = '['; cZ2 == c11; c11 = '[') {
            int i21 = i17 + 1;
            char cZ3 = z0(this.f70099f + i17);
            float[] fArr3 = new float[i18];
            int i22 = 0;
            while (true) {
                int i23 = this.f70099f;
                int i24 = (i23 + i21) - 1;
                boolean z11 = cZ3 == '-';
                if (z11) {
                    char cZ4 = z0(i23 + i21);
                    i21++;
                    cZ3 = cZ4;
                }
                if (cZ3 < '0' || cZ3 > '9') {
                    this.f70108o = -1;
                    return null;
                }
                int i25 = cZ3 - '0';
                while (true) {
                    i11 = i21 + 1;
                    cZ0 = z0(this.f70099f + i21);
                    if (cZ0 < '0' || cZ0 > '9') {
                        break;
                    }
                    i25 = (i25 * 10) + (cZ0 - '0');
                    i21 = i11;
                }
                if (cZ0 == '.') {
                    int i26 = i21 + 2;
                    char cZ5 = z0(this.f70099f + i11);
                    if (cZ5 < '0' || cZ5 > '9') {
                        this.f70108o = -1;
                        return fArr;
                    }
                    int i27 = (i25 * 10) + (cZ5 - '0');
                    int i28 = 10;
                    while (true) {
                        i11 = i26 + 1;
                        cZ1 = z0(this.f70099f + i26);
                        if (cZ1 < '0' || cZ1 > '9') {
                            break;
                        }
                        i27 = (i27 * 10) + (cZ1 - '0');
                        i28 *= 10;
                        i26 = i11;
                    }
                    int i29 = i27;
                    i13 = i28;
                    cZ0 = cZ1;
                    i12 = i29;
                } else {
                    i12 = i25;
                    i13 = 1;
                }
                boolean z12 = cZ0 == 'e' || cZ0 == 'E';
                if (z12) {
                    int i31 = i11 + 1;
                    cZ0 = z0(this.f70099f + i11);
                    if (cZ0 == '+' || cZ0 == '-') {
                        i11 += 2;
                        cZ0 = z0(this.f70099f + i31);
                    } else {
                        i11 = i31;
                    }
                    while (cZ0 >= '0' && cZ0 <= '9') {
                        cZ0 = z0(this.f70099f + i11);
                        i11++;
                    }
                }
                int i32 = ((this.f70099f + i11) - i24) - 1;
                if (z12 || i32 >= 10) {
                    f11 = Float.parseFloat(k1(i24, i32));
                } else {
                    f11 = i12 / i13;
                    if (z11) {
                        f11 = -f11;
                    }
                }
                if (i22 >= fArr3.length) {
                    float[] fArr4 = new float[(fArr3.length * 3) / 2];
                    System.arraycopy(fArr3, 0, fArr4, 0, i22);
                    fArr3 = fArr4;
                }
                i14 = i22 + 1;
                fArr3[i22] = f11;
                if (cZ0 == ',') {
                    cZ0 = z0(this.f70099f + i11);
                    i21 = i11 + 1;
                } else {
                    if (cZ0 == ']') {
                        break;
                    }
                    i21 = i11;
                }
                i22 = i14;
                fArr = null;
                cZ3 = cZ0;
            }
            int i33 = i11 + 1;
            char cZ6 = z0(this.f70099f + i11);
            if (i14 != fArr3.length) {
                float[] fArr5 = new float[i14];
                i15 = 0;
                System.arraycopy(fArr3, 0, fArr5, 0, i14);
                fArr3 = fArr5;
            } else {
                i15 = 0;
            }
            if (i19 >= fArr2.length) {
                float[][] fArr6 = new float[(fArr2.length * 3) / 2][];
                System.arraycopy(fArr3, i15, fArr6, i15, i14);
                fArr2 = fArr6;
            }
            int i34 = i19 + 1;
            fArr2[i19] = fArr3;
            if (cZ6 == ',') {
                cZ2 = z0(this.f70099f + i33);
                i17 = i11 + 2;
            } else {
                if (cZ6 == ']') {
                    i17 = i11 + 2;
                    cZ2 = z0(this.f70099f + i33);
                    i19 = i34;
                    break;
                }
                cZ2 = cZ6;
                i17 = i33;
            }
            i19 = i34;
            fArr = null;
            i18 = 16;
        }
        if (i19 != fArr2.length) {
            float[][] fArr7 = new float[i19][];
            System.arraycopy(fArr2, 0, fArr7, 0, i19);
            fArr2 = fArr7;
        }
        if (cZ2 == ',') {
            this.f70099f += i17 - 1;
            next();
            this.f70108o = 3;
            this.f70095a = 16;
            return fArr2;
        }
        if (cZ2 != '}') {
            this.f70108o = -1;
            return null;
        }
        char cZ7 = z0(this.f70099f + i17);
        if (cZ7 == ',') {
            this.f70095a = 16;
            this.f70099f += i17;
            next();
        } else if (cZ7 == ']') {
            this.f70095a = 15;
            this.f70099f += i17;
            next();
        } else if (cZ7 == '}') {
            this.f70095a = 13;
            this.f70099f += i17;
            next();
        } else {
            if (cZ7 != 26) {
                this.f70108o = -1;
                return null;
            }
            this.f70099f += i17;
            this.f70095a = 20;
            this.f70098d = (char) 26;
        }
        this.f70108o = 4;
        return fArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:108:0x007b A[SYNTHETIC] */
    @Override // l7.b
    public final void W(int i11) {
        this.f70102i = 0;
        while (true) {
            if (i11 == 2) {
                char c11 = this.f70098d;
                if (c11 >= '0' && c11 <= '9') {
                    this.f70096b = this.f70099f;
                    i();
                    return;
                }
                if (c11 == '\"') {
                    this.f70096b = this.f70099f;
                    x();
                    return;
                } else if (c11 == '[') {
                    this.f70095a = 14;
                    next();
                    return;
                } else if (c11 == '{') {
                    this.f70095a = 12;
                    next();
                    return;
                }
            } else if (i11 == 4) {
                char c12 = this.f70098d;
                if (c12 == '\"') {
                    this.f70096b = this.f70099f;
                    x();
                    return;
                }
                if (c12 >= '0' && c12 <= '9') {
                    this.f70096b = this.f70099f;
                    i();
                    return;
                } else if (c12 == '[') {
                    this.f70095a = 14;
                    next();
                    return;
                } else if (c12 == '{') {
                    this.f70095a = 12;
                    next();
                    return;
                }
            } else if (i11 == 12) {
                char c13 = this.f70098d;
                if (c13 == '{') {
                    this.f70095a = 12;
                    next();
                    return;
                } else if (c13 == '[') {
                    this.f70095a = 14;
                    next();
                    return;
                }
            } else {
                if (i11 == 18) {
                    I0();
                    return;
                }
                if (i11 != 20) {
                    switch (i11) {
                        case 14:
                            char c14 = this.f70098d;
                            if (c14 == '[') {
                                this.f70095a = 14;
                                next();
                            } else if (c14 == '{') {
                                this.f70095a = 12;
                                next();
                            }
                            break;
                        case 15:
                            if (this.f70098d == ']') {
                                this.f70095a = 15;
                                next();
                            }
                            if (this.f70098d == 26) {
                                this.f70095a = 20;
                            }
                            break;
                        case 16:
                            char c15 = this.f70098d;
                            if (c15 == ',') {
                                this.f70095a = 16;
                                next();
                            } else if (c15 == '}') {
                                this.f70095a = 13;
                                next();
                            } else if (c15 == ']') {
                                this.f70095a = 15;
                                next();
                            } else if (c15 == 26) {
                                this.f70095a = 20;
                            } else if (c15 == 'n') {
                                d1(false);
                            }
                            break;
                    }
                    return;
                }
                if (this.f70098d == 26) {
                    this.f70095a = 20;
                    return;
                }
            }
            char c16 = this.f70098d;
            if (c16 != ' ' && c16 != '\n' && c16 != '\r' && c16 != '\t' && c16 != '\f' && c16 != '\b') {
                w();
                return;
            }
            next();
        }
    }

    public int W0(char[] cArr) {
        int i11;
        char cZ0;
        this.f70108o = 0;
        if (!y0(cArr)) {
            this.f70108o = -2;
            return 0;
        }
        int length = cArr.length;
        int i12 = length + 1;
        char cZ1 = z0(this.f70099f + length);
        boolean z11 = cZ1 == '-';
        if (z11) {
            cZ1 = z0(this.f70099f + i12);
            i12 = length + 2;
        }
        if (cZ1 < '0' || cZ1 > '9') {
            this.f70108o = -1;
            return 0;
        }
        int i13 = cZ1 - '0';
        while (true) {
            i11 = i12 + 1;
            cZ0 = z0(this.f70099f + i12);
            if (cZ0 < '0' || cZ0 > '9') {
                break;
            }
            i13 = (i13 * 10) + (cZ0 - '0');
            i12 = i11;
        }
        if (cZ0 == '.') {
            this.f70108o = -1;
            return 0;
        }
        if ((i13 < 0 || i11 > cArr.length + 14) && !(i13 == Integer.MIN_VALUE && i11 == 17 && z11)) {
            this.f70108o = -1;
            return 0;
        }
        if (cZ0 == ',') {
            int i14 = this.f70099f + i11;
            this.f70099f = i14;
            this.f70098d = z0(i14);
            this.f70108o = 3;
            this.f70095a = 16;
            return z11 ? -i13 : i13;
        }
        if (cZ0 != '}') {
            this.f70108o = -1;
            return 0;
        }
        int i15 = i12 + 2;
        char cZ2 = z0(this.f70099f + i11);
        if (cZ2 == ',') {
            this.f70095a = 16;
            int i16 = this.f70099f + i15;
            this.f70099f = i16;
            this.f70098d = z0(i16);
        } else if (cZ2 == ']') {
            this.f70095a = 15;
            int i17 = this.f70099f + i15;
            this.f70099f = i17;
            this.f70098d = z0(i17);
        } else if (cZ2 == '}') {
            this.f70095a = 13;
            int i18 = this.f70099f + i15;
            this.f70099f = i18;
            this.f70098d = z0(i18);
        } else {
            if (cZ2 != 26) {
                this.f70108o = -1;
                return 0;
            }
            this.f70095a = 20;
            this.f70099f += i12 + 1;
            this.f70098d = (char) 26;
        }
        this.f70108o = 4;
        return z11 ? -i13 : i13;
    }

    public final int[] X0(char[] cArr) {
        boolean z11;
        int i11;
        char cZ0;
        int i12;
        char cZ1;
        int i13;
        int[] iArr;
        this.f70108o = 0;
        int[] iArr2 = null;
        if (!y0(cArr)) {
            this.f70108o = -2;
            return null;
        }
        int length = cArr.length;
        int i14 = length + 1;
        if (z0(this.f70099f + length) != '[') {
            this.f70108o = -2;
            return null;
        }
        int i15 = length + 2;
        char cZ2 = z0(this.f70099f + i14);
        int[] iArr3 = new int[16];
        if (cZ2 == ']') {
            i13 = length + 3;
            cZ1 = z0(this.f70099f + i15);
            i12 = 0;
        } else {
            int i16 = 0;
            while (true) {
                if (cZ2 == '-') {
                    cZ2 = z0(this.f70099f + i15);
                    i15++;
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (cZ2 < '0' || cZ2 > '9') {
                    int[] iArr4 = iArr2;
                    this.f70108o = -1;
                    return iArr4;
                }
                int i17 = cZ2 - '0';
                while (true) {
                    i11 = i15 + 1;
                    cZ0 = z0(this.f70099f + i15);
                    if (cZ0 < '0' || cZ0 > '9') {
                        break;
                    }
                    i17 = (i17 * 10) + (cZ0 - '0');
                    i15 = i11;
                }
                if (i16 >= iArr3.length) {
                    int[] iArr5 = new int[(iArr3.length * 3) / 2];
                    System.arraycopy(iArr3, 0, iArr5, 0, i16);
                    iArr3 = iArr5;
                }
                i12 = i16 + 1;
                if (z11) {
                    i17 = -i17;
                }
                iArr3[i16] = i17;
                if (cZ0 == ',') {
                    i15 += 2;
                    cZ2 = z0(this.f70099f + i11);
                    iArr = null;
                } else {
                    if (cZ0 == ']') {
                        cZ1 = z0(this.f70099f + i11);
                        i13 = i15 + 2;
                        break;
                    }
                    iArr = null;
                    cZ2 = cZ0;
                    i15 = i11;
                }
                iArr2 = iArr;
                i16 = i12;
            }
        }
        if (i12 != iArr3.length) {
            int[] iArr6 = new int[i12];
            System.arraycopy(iArr3, 0, iArr6, 0, i12);
            iArr3 = iArr6;
        }
        if (cZ1 == ',') {
            this.f70099f += i13 - 1;
            next();
            this.f70108o = 3;
            this.f70095a = 16;
            return iArr3;
        }
        if (cZ1 != '}') {
            this.f70108o = -1;
            return null;
        }
        char cZ3 = z0(this.f70099f + i13);
        if (cZ3 == ',') {
            this.f70095a = 16;
            this.f70099f += i13;
            next();
        } else if (cZ3 == ']') {
            this.f70095a = 15;
            this.f70099f += i13;
            next();
        } else if (cZ3 == '}') {
            this.f70095a = 13;
            this.f70099f += i13;
            next();
        } else {
            if (cZ3 != 26) {
                this.f70108o = -1;
                return null;
            }
            this.f70099f += i13;
            this.f70095a = 20;
            this.f70098d = (char) 26;
        }
        this.f70108o = 4;
        return iArr3;
    }

    public long Y0(char[] cArr) {
        int i11;
        char cZ0;
        boolean z11 = false;
        this.f70108o = 0;
        if (!y0(cArr)) {
            this.f70108o = -2;
            return 0L;
        }
        int length = cArr.length;
        int i12 = length + 1;
        char cZ1 = z0(this.f70099f + length);
        if (cZ1 == '-') {
            cZ1 = z0(this.f70099f + i12);
            i12 = length + 2;
            z11 = true;
        }
        if (cZ1 < '0' || cZ1 > '9') {
            this.f70108o = -1;
            return 0L;
        }
        long j11 = cZ1 - '0';
        while (true) {
            i11 = i12 + 1;
            cZ0 = z0(this.f70099f + i12);
            if (cZ0 < '0' || cZ0 > '9') {
                break;
            }
            j11 = (j11 * 10) + ((long) (cZ0 - '0'));
            i12 = i11;
        }
        if (cZ0 == '.') {
            this.f70108o = -1;
            return 0L;
        }
        if (i11 - cArr.length >= 21 || (j11 < 0 && !(j11 == Long.MIN_VALUE && z11))) {
            this.f70108o = -1;
            return 0L;
        }
        if (cZ0 == ',') {
            int i13 = this.f70099f + i11;
            this.f70099f = i13;
            this.f70098d = z0(i13);
            this.f70108o = 3;
            this.f70095a = 16;
            return z11 ? -j11 : j11;
        }
        if (cZ0 != '}') {
            this.f70108o = -1;
            return 0L;
        }
        int i14 = i12 + 2;
        char cZ2 = z0(this.f70099f + i11);
        if (cZ2 == ',') {
            this.f70095a = 16;
            int i15 = this.f70099f + i14;
            this.f70099f = i15;
            this.f70098d = z0(i15);
        } else if (cZ2 == ']') {
            this.f70095a = 15;
            int i16 = this.f70099f + i14;
            this.f70099f = i16;
            this.f70098d = z0(i16);
        } else if (cZ2 == '}') {
            this.f70095a = 13;
            int i17 = this.f70099f + i14;
            this.f70099f = i17;
            this.f70098d = z0(i17);
        } else {
            if (cZ2 != 26) {
                this.f70108o = -1;
                return 0L;
            }
            this.f70095a = 20;
            this.f70099f += i12 + 1;
            this.f70098d = (char) 26;
        }
        this.f70108o = 4;
        return z11 ? -j11 : j11;
    }

    @Override // l7.b
    public abstract BigDecimal Z();

    public String Z0(char[] cArr) {
        this.f70108o = 0;
        if (!y0(cArr)) {
            this.f70108o = -2;
            return j1();
        }
        int length = cArr.length;
        int i11 = length + 1;
        if (z0(this.f70099f + length) != '\"') {
            this.f70108o = -1;
            return j1();
        }
        int iD0 = D0('\"', this.f70099f + cArr.length + 1);
        if (iD0 == -1) {
            throw new JSONException("unclosed str");
        }
        int length2 = this.f70099f + cArr.length + 1;
        String strK1 = k1(length2, iD0 - length2);
        if (strK1.indexOf(92) != -1) {
            while (true) {
                int i12 = 0;
                for (int i13 = iD0 - 1; i13 >= 0 && z0(i13) == '\\'; i13--) {
                    i12++;
                }
                if (i12 % 2 == 0) {
                    break;
                }
                iD0 = D0('\"', iD0 + 1);
            }
            int i14 = this.f70099f;
            int length3 = iD0 - ((cArr.length + i14) + 1);
            strK1 = L0(l1(i14 + cArr.length + 1, length3), length3);
        }
        int i15 = this.f70099f;
        int length4 = i11 + (iD0 - ((cArr.length + i15) + 1)) + 1;
        int i16 = length4 + 1;
        char cZ0 = z0(i15 + length4);
        if (cZ0 == ',') {
            int i17 = this.f70099f + i16;
            this.f70099f = i17;
            this.f70098d = z0(i17);
            this.f70108o = 3;
            return strK1;
        }
        if (cZ0 != '}') {
            this.f70108o = -1;
            return j1();
        }
        int i18 = length4 + 2;
        char cZ1 = z0(this.f70099f + i16);
        if (cZ1 == ',') {
            this.f70095a = 16;
            int i19 = this.f70099f + i18;
            this.f70099f = i19;
            this.f70098d = z0(i19);
        } else if (cZ1 == ']') {
            this.f70095a = 15;
            int i21 = this.f70099f + i18;
            this.f70099f = i21;
            this.f70098d = z0(i21);
        } else if (cZ1 == '}') {
            this.f70095a = 13;
            int i22 = this.f70099f + i18;
            this.f70099f = i22;
            this.f70098d = z0(i22);
        } else {
            if (cZ1 != 26) {
                this.f70108o = -1;
                return j1();
            }
            this.f70095a = 20;
            this.f70099f += length4 + 1;
            this.f70098d = (char) 26;
        }
        this.f70108o = 4;
        return strK1;
    }

    @Override // l7.b
    public final char a() {
        return this.f70098d;
    }

    public final void a1() {
        char next;
        if (this.f70098d != 'x') {
            throw new JSONException("illegal state. " + this.f70098d);
        }
        next();
        if (this.f70098d != '\'') {
            throw new JSONException("illegal state. " + this.f70098d);
        }
        this.f70103j = this.f70099f;
        next();
        if (this.f70098d == '\'') {
            next();
            this.f70095a = 26;
            return;
        }
        while (true) {
            next = next();
            if ((next < '0' || next > '9') && (next < 'A' || next > 'F')) {
                break;
            } else {
                this.f70102i++;
            }
        }
        if (next == '\'') {
            this.f70102i++;
            next();
            this.f70095a = 26;
        } else {
            throw new JSONException("illegal state. " + next);
        }
    }

    @Override // l7.b
    public final int b() {
        return this.f70096b;
    }

    @Override // l7.b
    public int b0(char c11) {
        int i11;
        int i12;
        char cZ0;
        this.f70108o = 0;
        char cZ1 = z0(this.f70099f);
        boolean z11 = cZ1 == '\"';
        if (z11) {
            cZ1 = z0(this.f70099f + 1);
            i11 = 2;
        } else {
            i11 = 1;
        }
        boolean z12 = cZ1 == '-';
        if (z12) {
            cZ1 = z0(this.f70099f + i11);
            i11++;
        }
        if (cZ1 >= '0' && cZ1 <= '9') {
            int i13 = cZ1 - '0';
            while (true) {
                i12 = i11 + 1;
                cZ0 = z0(this.f70099f + i11);
                if (cZ0 < '0' || cZ0 > '9') {
                    break;
                }
                i13 = (i13 * 10) + (cZ0 - '0');
                i11 = i12;
            }
            if (cZ0 == '.') {
                this.f70108o = -1;
                return 0;
            }
            if (i13 < 0) {
                this.f70108o = -1;
                return 0;
            }
            while (cZ0 != c11) {
                if (!F0(cZ0)) {
                    this.f70108o = -1;
                    return z12 ? -i13 : i13;
                }
                char cZ2 = z0(this.f70099f + i12);
                i12++;
                cZ0 = cZ2;
            }
            int i14 = this.f70099f + i12;
            this.f70099f = i14;
            this.f70098d = z0(i14);
            this.f70108o = 3;
            this.f70095a = 16;
            return z12 ? -i13 : i13;
        }
        if (cZ1 != 'n' || z0(this.f70099f + i11) != 'u' || z0(this.f70099f + i11 + 1) != 'l' || z0(this.f70099f + i11 + 2) != 'l') {
            this.f70108o = -1;
            return 0;
        }
        this.f70108o = 5;
        int i15 = i11 + 4;
        char cZ3 = z0(this.f70099f + i11 + 3);
        if (z11 && cZ3 == '\"') {
            cZ3 = z0(this.f70099f + i15);
            i15 = i11 + 5;
        }
        while (cZ3 != ',') {
            if (cZ3 == ']') {
                int i16 = this.f70099f + i15;
                this.f70099f = i16;
                this.f70098d = z0(i16);
                this.f70108o = 5;
                this.f70095a = 15;
                return 0;
            }
            if (!F0(cZ3)) {
                this.f70108o = -1;
                return 0;
            }
            cZ3 = z0(this.f70099f + i15);
            i15++;
        }
        int i17 = this.f70099f + i15;
        this.f70099f = i17;
        this.f70098d = z0(i17);
        this.f70108o = 5;
        this.f70095a = 16;
        return 0;
    }

    public final void b1() {
        this.f70103j = this.f70099f - 1;
        this.f70104k = false;
        do {
            this.f70102i++;
            next();
        } while (Character.isLetterOrDigit(this.f70098d));
        String strG0 = g0();
        if ("null".equalsIgnoreCase(strG0)) {
            this.f70095a = 8;
            return;
        }
        if ("new".equals(strG0)) {
            this.f70095a = 9;
            return;
        }
        if ("true".equals(strG0)) {
            this.f70095a = 6;
            return;
        }
        if ("false".equals(strG0)) {
            this.f70095a = 7;
            return;
        }
        if (AdError.UNDEFINED_DOMAIN.equals(strG0)) {
            this.f70095a = 23;
            return;
        }
        if ("Set".equals(strG0)) {
            this.f70095a = 21;
        } else if ("TreeSet".equals(strG0)) {
            this.f70095a = 22;
        } else {
            this.f70095a = 18;
        }
    }

    @Override // l7.b
    public String c() {
        return "";
    }

    public final void c1() {
        d1(true);
    }

    @Override // l7.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        char[] cArr = this.f70101h;
        if (cArr.length <= 8192) {
            f70092r.set(cArr);
        }
        this.f70101h = null;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0034  */
    /* JADX WARN: Code duplicated, block: B:32:0x0076  */
    /* JADX WARN: Code duplicated, block: B:34:0x007b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x007c  */
    /* JADX WARN: Code duplicated, block: B:37:0x0086  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x005d -> B:11:0x002e). Please report as a decompilation issue!!! */
    @Override // l7.b
    public final long d() throws NumberFormatException {
        long j11;
        long j12;
        int i11;
        char cZ0;
        boolean z11 = false;
        if (this.f70103j == -1) {
            this.f70103j = 0;
        }
        int i12 = this.f70103j;
        int i13 = this.f70102i + i12;
        if (z0(i12) == '-') {
            i12++;
            j11 = Long.MIN_VALUE;
            z11 = true;
        } else {
            j11 = C.TIME_UNSET;
        }
        if (i12 >= i13) {
            j12 = 0;
            if (i12 < i13) {
                i11 = i12 + 1;
                cZ0 = z0(i12);
                if (cZ0 != 'L' || cZ0 == 'S' || cZ0 == 'B') {
                    i12 = i11;
                } else {
                    int i14 = cZ0 - '0';
                    if (j12 < BufferKt.OVERFLOW_ZONE) {
                        throw new NumberFormatException(v0());
                    }
                    long j13 = j12 * 10;
                    long j14 = i14;
                    if (j13 < j11 + j14) {
                        throw new NumberFormatException(v0());
                    }
                    j12 = j13 - j14;
                }
            }
            if (z11) {
                return -j12;
            }
            if (i12 > this.f70103j + 1) {
                return j12;
            }
            throw new NumberFormatException(v0());
        }
        i11 = i12 + 1;
        j12 = -(z0(i12) - '0');
        i12 = i11;
        if (i12 < i13) {
            i11 = i12 + 1;
            cZ0 = z0(i12);
            if (cZ0 != 'L') {
            }
            i12 = i11;
        }
        if (z11) {
            return -j12;
        }
        if (i12 > this.f70103j + 1) {
            return j12;
        }
        throw new NumberFormatException(v0());
    }

    public final void d1(boolean z11) {
        if (this.f70098d != 'n') {
            throw new JSONException("error parse null or new");
        }
        next();
        char c11 = this.f70098d;
        if (c11 != 'u') {
            if (c11 != 'e') {
                throw new JSONException("error parse new");
            }
            next();
            if (this.f70098d != 'w') {
                throw new JSONException("error parse new");
            }
            next();
            char c12 = this.f70098d;
            if (c12 != ' ' && c12 != ',' && c12 != '}' && c12 != ']' && c12 != '\n' && c12 != '\r' && c12 != '\t' && c12 != 26 && c12 != '\f' && c12 != '\b') {
                throw new JSONException("scan new error");
            }
            this.f70095a = 9;
            return;
        }
        next();
        if (this.f70098d != 'l') {
            throw new JSONException("error parse null");
        }
        next();
        if (this.f70098d != 'l') {
            throw new JSONException("error parse null");
        }
        next();
        char c13 = this.f70098d;
        if (c13 != ' ' && c13 != ',' && c13 != '}' && c13 != ']' && c13 != '\n' && c13 != '\r' && c13 != '\t' && c13 != 26 && ((c13 != ':' || !z11) && c13 != '\f' && c13 != '\b')) {
            throw new JSONException("scan null error");
        }
        this.f70095a = 8;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00c5 -> B:51:0x00b4). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // l7.b
    public final float e(char r21) {
        /*
            Method dump skipped, instruction units count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l7.c.e(char):float");
    }

    @Override // l7.b
    public final String e0(i iVar) {
        p0();
        char c11 = this.f70098d;
        if (c11 == '\"') {
            return l(iVar, '\"');
        }
        if (c11 == '\'') {
            if (g(Feature.AllowSingleQuotes)) {
                return l(iVar, '\'');
            }
            throw new JSONException("syntax error");
        }
        if (c11 == '}') {
            next();
            this.f70095a = 13;
            return null;
        }
        if (c11 == ',') {
            next();
            this.f70095a = 16;
            return null;
        }
        if (c11 == 26) {
            this.f70095a = 20;
            return null;
        }
        if (g(Feature.AllowUnQuotedFieldNames)) {
            return y(iVar);
        }
        throw new JSONException("syntax error");
    }

    public final void e1() {
        this.f70103j = this.f70099f;
        this.f70104k = false;
        while (true) {
            char next = next();
            if (next == '\'') {
                this.f70095a = 4;
                next();
                return;
            }
            if (next != 26) {
                boolean z11 = true;
                if (next == '\\') {
                    if (!this.f70104k) {
                        this.f70104k = true;
                        int i11 = this.f70102i;
                        char[] cArr = this.f70101h;
                        if (i11 > cArr.length) {
                            char[] cArr2 = new char[i11 * 2];
                            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                            this.f70101h = cArr2;
                        }
                        A0(this.f70103j + 1, this.f70102i, this.f70101h);
                    }
                    char next2 = next();
                    if (next2 == '\"') {
                        K0('\"');
                    } else if (next2 != '\'') {
                        if (next2 != 'F') {
                            if (next2 == '\\') {
                                K0('\\');
                            } else if (next2 == 'b') {
                                K0('\b');
                            } else if (next2 != 'f') {
                                if (next2 == 'n') {
                                    K0('\n');
                                } else if (next2 == 'r') {
                                    K0('\r');
                                } else if (next2 != 'x') {
                                    switch (next2) {
                                        case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                            K0('/');
                                            break;
                                        case '0':
                                            K0((char) 0);
                                            break;
                                        case '1':
                                            K0((char) 1);
                                            break;
                                        case '2':
                                            K0((char) 2);
                                            break;
                                        case '3':
                                            K0((char) 3);
                                            break;
                                        case '4':
                                            K0((char) 4);
                                            break;
                                        case '5':
                                            K0((char) 5);
                                            break;
                                        case '6':
                                            K0((char) 6);
                                            break;
                                        case '7':
                                            K0((char) 7);
                                            break;
                                        default:
                                            switch (next2) {
                                                case 't':
                                                    K0('\t');
                                                    break;
                                                case 'u':
                                                    K0((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                    break;
                                                case 'v':
                                                    K0((char) 11);
                                                    break;
                                                default:
                                                    this.f70098d = next2;
                                                    throw new JSONException("unclosed single-quote string");
                                            }
                                            break;
                                    }
                                } else {
                                    char next3 = next();
                                    char next4 = next();
                                    boolean z12 = (next3 >= '0' && next3 <= '9') || (next3 >= 'a' && next3 <= 'f') || (next3 >= 'A' && next3 <= 'F');
                                    if ((next4 < '0' || next4 > '9') && ((next4 < 'a' || next4 > 'f') && (next4 < 'A' || next4 > 'F'))) {
                                        z11 = false;
                                    }
                                    if (!z12 || !z11) {
                                        throw new JSONException("invalid escape character \\x" + next3 + next4);
                                    }
                                    int[] iArr = f70094t;
                                    K0((char) ((iArr[next3] * 16) + iArr[next4]));
                                }
                            }
                        }
                        K0('\f');
                    } else {
                        K0('\'');
                    }
                } else if (this.f70104k) {
                    int i12 = this.f70102i;
                    char[] cArr3 = this.f70101h;
                    if (i12 == cArr3.length) {
                        K0(next);
                    } else {
                        this.f70102i = i12 + 1;
                        cArr3[i12] = next;
                    }
                } else {
                    this.f70102i++;
                }
            } else {
                if (E0()) {
                    throw new JSONException("unclosed single-quote string");
                }
                K0((char) 26);
            }
        }
    }

    public String f1(i iVar, char c11) {
        int i11 = 0;
        this.f70108o = 0;
        char cZ0 = z0(this.f70099f);
        if (cZ0 == 'n') {
            if (z0(this.f70099f + 1) != 'u' || z0(this.f70099f + 2) != 'l' || z0(this.f70099f + 3) != 'l') {
                this.f70108o = -1;
                return null;
            }
            if (z0(this.f70099f + 4) != c11) {
                this.f70108o = -1;
                return null;
            }
            int i12 = this.f70099f + 5;
            this.f70099f = i12;
            this.f70098d = z0(i12);
            this.f70108o = 3;
            return null;
        }
        if (cZ0 != '\"') {
            this.f70108o = -1;
            return null;
        }
        int i13 = 1;
        while (true) {
            int i14 = i13 + 1;
            char cZ1 = z0(this.f70099f + i13);
            if (cZ1 == '\"') {
                int i15 = this.f70099f;
                int i16 = i15 + 1;
                String strW0 = w0(i16, ((i15 + i14) - i16) - 1, i11, iVar);
                int i17 = i13 + 2;
                char cZ2 = z0(this.f70099f + i14);
                while (cZ2 != c11) {
                    if (!F0(cZ2)) {
                        this.f70108o = -1;
                        return strW0;
                    }
                    cZ2 = z0(this.f70099f + i17);
                    i17++;
                }
                int i18 = this.f70099f + i17;
                this.f70099f = i18;
                this.f70098d = z0(i18);
                this.f70108o = 3;
                return strW0;
            }
            i11 = (i11 * 31) + cZ1;
            if (cZ1 == '\\') {
                this.f70108o = -1;
                return null;
            }
            i13 = i14;
        }
    }

    @Override // l7.b
    public final boolean g(Feature feature) {
        return isEnabled(feature.mask);
    }

    @Override // l7.b
    public abstract String g0();

    public final void g1() {
        if (this.f70098d != 't') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.f70098d != 'r') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.f70098d != 'u') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.f70098d != 'e') {
            throw new JSONException("error parse true");
        }
        next();
        char c11 = this.f70098d;
        if (c11 != ' ' && c11 != ',' && c11 != '}' && c11 != ']' && c11 != '\n' && c11 != '\r' && c11 != '\t' && c11 != 26 && c11 != '\f' && c11 != '\b' && c11 != ':' && c11 != '/') {
            throw new JSONException("scan true error");
        }
        this.f70095a = 6;
    }

    @Override // l7.b
    public final int h() {
        int i11;
        boolean z11;
        int i12 = 0;
        if (this.f70103j == -1) {
            this.f70103j = 0;
        }
        int i13 = this.f70103j;
        int i14 = this.f70102i + i13;
        if (z0(i13) == '-') {
            i13++;
            i11 = Integer.MIN_VALUE;
            z11 = true;
        } else {
            i11 = -2147483647;
            z11 = false;
        }
        if (i13 < i14) {
            i12 = -(z0(i13) - '0');
            i13++;
        }
        while (i13 < i14) {
            int i15 = i13 + 1;
            char cZ0 = z0(i13);
            if (cZ0 == 'L' || cZ0 == 'S' || cZ0 == 'B') {
                i13 = i15;
                break;
            }
            int i16 = cZ0 - '0';
            if (i12 < -214748364) {
                throw new NumberFormatException(v0());
            }
            int i17 = i12 * 10;
            if (i17 < i11 + i16) {
                throw new NumberFormatException(v0());
            }
            i12 = i17 - i16;
            i13 = i15;
        }
        if (!z11) {
            return -i12;
        }
        if (i13 > this.f70103j + 1) {
            return i12;
        }
        throw new NumberFormatException(v0());
    }

    @Override // l7.b
    public TimeZone h0() {
        return this.f70106m;
    }

    public void h1(TimeZone timeZone) {
        this.f70106m = timeZone;
    }

    @Override // l7.b
    public final void i() {
        char c11;
        boolean z11;
        char c12;
        this.f70103j = this.f70099f;
        if (this.f70098d == '-') {
            this.f70102i++;
            next();
        }
        while (true) {
            c11 = this.f70098d;
            if (c11 < '0' || c11 > '9') {
                break;
            }
            this.f70102i++;
            next();
        }
        if (c11 == '.') {
            this.f70102i++;
            next();
            while (true) {
                char c13 = this.f70098d;
                if (c13 < '0' || c13 > '9') {
                    break;
                }
                this.f70102i++;
                next();
            }
            z11 = true;
        } else {
            z11 = false;
        }
        int i11 = this.f70102i;
        if (i11 > 65535) {
            throw new JSONException("scanNumber overflow");
        }
        char c14 = this.f70098d;
        if (c14 != 'L' && c14 != 'S' && c14 != 'B') {
            if (c14 == 'F' || c14 == 'D') {
                this.f70102i = i11 + 1;
                next();
            } else if (c14 == 'e' || c14 == 'E') {
                this.f70102i = i11 + 1;
                next();
                char c15 = this.f70098d;
                if (c15 == '+' || c15 == '-') {
                    this.f70102i++;
                    next();
                }
                while (true) {
                    c12 = this.f70098d;
                    if (c12 < '0' || c12 > '9') {
                        break;
                    }
                    this.f70102i++;
                    next();
                }
                if (c12 == 'D' || c12 == 'F') {
                    this.f70102i++;
                    next();
                }
            }
            this.f70095a = 3;
        }
        this.f70102i = i11 + 1;
        next();
        if (!z11) {
            this.f70095a = 2;
            return;
        }
        this.f70095a = 3;
    }

    @Override // l7.b
    public final Number i0() throws NumberFormatException {
        char c11;
        long j11;
        long j12;
        boolean z11 = false;
        if (this.f70103j == -1) {
            this.f70103j = 0;
        }
        int i11 = this.f70103j;
        int i12 = this.f70102i + i11;
        char cZ0 = z0(i12 - 1);
        if (cZ0 == 'B') {
            i12--;
            c11 = 'B';
        } else if (cZ0 == 'L') {
            i12--;
            c11 = 'L';
        } else if (cZ0 != 'S') {
            c11 = ' ';
        } else {
            i12--;
            c11 = 'S';
        }
        if (z0(this.f70103j) == '-') {
            i11++;
            j11 = Long.MIN_VALUE;
            z11 = true;
        } else {
            j11 = C.TIME_UNSET;
        }
        if (i11 < i12) {
            j12 = -(z0(i11) - '0');
            i11++;
        } else {
            j12 = 0;
        }
        while (i11 < i12) {
            int i13 = i11 + 1;
            int iZ0 = z0(i11) - '0';
            if (j12 < BufferKt.OVERFLOW_ZONE) {
                return new BigInteger(v0(), 10);
            }
            long j13 = j12 * 10;
            long j14 = iZ0;
            if (j13 < j11 + j14) {
                return new BigInteger(v0(), 10);
            }
            j12 = j13 - j14;
            i11 = i13;
        }
        if (!z11) {
            long j15 = -j12;
            if (j15 > 2147483647L || c11 == 'L') {
                return Long.valueOf(j15);
            }
            if (c11 == 'S') {
                return Short.valueOf((short) j15);
            }
            return c11 == 'B' ? Byte.valueOf((byte) j15) : Integer.valueOf((int) j15);
        }
        if (i11 <= this.f70103j + 1) {
            throw new JSONException("illegal number format : " + v0());
        }
        if (j12 < -2147483648L || c11 == 'L') {
            return Long.valueOf(j12);
        }
        if (c11 == 'S') {
            return Short.valueOf((short) j12);
        }
        return c11 == 'B' ? Byte.valueOf((byte) j12) : Integer.valueOf((int) j12);
    }

    public void i1() {
        char c11;
        next();
        char c12 = this.f70098d;
        if (c12 == '/') {
            do {
                next();
                c11 = this.f70098d;
                if (c11 == '\n') {
                    next();
                    return;
                }
            } while (c11 != 26);
            return;
        }
        if (c12 != '*') {
            throw new JSONException("invalid comment");
        }
        next();
        while (true) {
            char c13 = this.f70098d;
            if (c13 == 26) {
                return;
            }
            if (c13 == '*') {
                next();
                if (this.f70098d == '/') {
                    next();
                    return;
                }
            } else {
                next();
            }
        }
    }

    @Override // l7.b
    public final boolean isEnabled(int i11) {
        return (i11 & this.f70097c) != 0;
    }

    @Override // l7.b
    public final void j(int i11) {
        J0(':');
    }

    @Override // l7.b
    public float j0() {
        char cCharAt;
        String strV0 = v0();
        float f11 = Float.parseFloat(strV0);
        if ((f11 != 0.0f && f11 != Float.POSITIVE_INFINITY) || (cCharAt = strV0.charAt(0)) <= '0' || cCharAt > '9') {
            return f11;
        }
        throw new JSONException("float overflow : " + strV0);
    }

    public final String j1() {
        return this.f70109p;
    }

    @Override // l7.b
    public String k(i iVar) {
        return null;
    }

    @Override // l7.b
    public final int k0() {
        return this.f70095a;
    }

    public abstract String k1(int i11, int i12);

    @Override // l7.b
    public final String l(i iVar, char c11) {
        String strC;
        this.f70103j = this.f70099f;
        this.f70102i = 0;
        boolean z11 = false;
        int i11 = 0;
        while (true) {
            char next = next();
            if (next == c11) {
                this.f70095a = 4;
                if (z11) {
                    strC = iVar.c(this.f70101h, 0, this.f70102i, i11);
                } else {
                    int i12 = this.f70103j;
                    strC = w0(i12 == -1 ? 0 : i12 + 1, this.f70102i, i11, iVar);
                }
                this.f70102i = 0;
                next();
                return strC;
            }
            if (next == 26) {
                throw new JSONException("unclosed.str");
            }
            if (next == '\\') {
                if (!z11) {
                    int i13 = this.f70102i;
                    char[] cArr = this.f70101h;
                    if (i13 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i13 <= length) {
                            i13 = length;
                        }
                        char[] cArr2 = new char[i13];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.f70101h = cArr2;
                    }
                    x0(this.f70103j + 1, this.f70101h, 0, this.f70102i);
                    z11 = true;
                }
                char next2 = next();
                if (next2 == '\"') {
                    i11 = (i11 * 31) + 34;
                    K0('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            i11 = (i11 * 31) + 92;
                            K0('\\');
                        } else if (next2 == 'b') {
                            i11 = (i11 * 31) + 8;
                            K0('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                i11 = (i11 * 31) + 10;
                                K0('\n');
                            } else if (next2 == 'r') {
                                i11 = (i11 * 31) + 13;
                                K0('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                        i11 = (i11 * 31) + 47;
                                        K0('/');
                                        break;
                                    case '0':
                                        i11 = (i11 * 31) + next2;
                                        K0((char) 0);
                                        break;
                                    case '1':
                                        i11 = (i11 * 31) + next2;
                                        K0((char) 1);
                                        break;
                                    case '2':
                                        i11 = (i11 * 31) + next2;
                                        K0((char) 2);
                                        break;
                                    case '3':
                                        i11 = (i11 * 31) + next2;
                                        K0((char) 3);
                                        break;
                                    case '4':
                                        i11 = (i11 * 31) + next2;
                                        K0((char) 4);
                                        break;
                                    case '5':
                                        i11 = (i11 * 31) + next2;
                                        K0((char) 5);
                                        break;
                                    case '6':
                                        i11 = (i11 * 31) + next2;
                                        K0((char) 6);
                                        break;
                                    case '7':
                                        i11 = (i11 * 31) + next2;
                                        K0((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                i11 = (i11 * 31) + 9;
                                                K0('\t');
                                                break;
                                            case 'u':
                                                int i14 = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                                                i11 = (i11 * 31) + i14;
                                                K0((char) i14);
                                                break;
                                            case 'v':
                                                i11 = (i11 * 31) + 11;
                                                K0((char) 11);
                                                break;
                                            default:
                                                this.f70098d = next2;
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                        break;
                                }
                            } else {
                                char next3 = next();
                                this.f70098d = next3;
                                char next4 = next();
                                this.f70098d = next4;
                                int[] iArr = f70094t;
                                char c12 = (char) ((iArr[next3] * 16) + iArr[next4]);
                                i11 = (i11 * 31) + c12;
                                K0(c12);
                            }
                        }
                    }
                    i11 = (i11 * 31) + 12;
                    K0('\f');
                } else {
                    i11 = (i11 * 31) + 39;
                    K0('\'');
                }
            } else {
                i11 = (i11 * 31) + next;
                if (z11) {
                    int i15 = this.f70102i;
                    char[] cArr3 = this.f70101h;
                    if (i15 == cArr3.length) {
                        K0(next);
                    } else {
                        this.f70102i = i15 + 1;
                        cArr3[i15] = next;
                    }
                } else {
                    this.f70102i++;
                }
            }
        }
    }

    @Override // l7.b
    public String l0(char c11) {
        this.f70108o = 0;
        char cZ0 = z0(this.f70099f);
        if (cZ0 == 'n') {
            if (z0(this.f70099f + 1) != 'u' || z0(this.f70099f + 2) != 'l' || z0(this.f70099f + 3) != 'l') {
                this.f70108o = -1;
                return null;
            }
            if (z0(this.f70099f + 4) != c11) {
                this.f70108o = -1;
                return null;
            }
            int i11 = this.f70099f + 5;
            this.f70099f = i11;
            this.f70098d = z0(i11);
            this.f70108o = 3;
            return null;
        }
        int i12 = 1;
        while (cZ0 != '\"') {
            if (!F0(cZ0)) {
                this.f70108o = -1;
                return j1();
            }
            cZ0 = z0(this.f70099f + i12);
            i12++;
        }
        int i13 = this.f70099f + i12;
        int iD0 = D0('\"', i13);
        if (iD0 == -1) {
            throw new JSONException("unclosed str");
        }
        String strK1 = k1(this.f70099f + i12, iD0 - i13);
        if (strK1.indexOf(92) != -1) {
            while (true) {
                int i14 = 0;
                for (int i15 = iD0 - 1; i15 >= 0 && z0(i15) == '\\'; i15--) {
                    i14++;
                }
                if (i14 % 2 == 0) {
                    break;
                }
                iD0 = D0('\"', iD0 + 1);
            }
            int i16 = iD0 - i13;
            strK1 = L0(l1(this.f70099f + 1, i16), i16);
        }
        int i17 = i12 + (iD0 - i13) + 1;
        int i18 = i17 + 1;
        char cZ1 = z0(this.f70099f + i17);
        while (cZ1 != c11) {
            if (!F0(cZ1)) {
                if (cZ1 == ']') {
                    int i19 = this.f70099f + i18;
                    this.f70099f = i19;
                    this.f70098d = z0(i19);
                    this.f70108o = -1;
                }
                return strK1;
            }
            cZ1 = z0(this.f70099f + i18);
            i18++;
        }
        int i21 = this.f70099f + i18;
        this.f70099f = i21;
        this.f70098d = z0(i21);
        this.f70108o = 3;
        this.f70095a = 16;
        return strK1;
    }

    public abstract char[] l1(int i11, int i12);

    @Override // l7.b
    public int m() {
        return this.f70097c;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00c2 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00c4 -> B:51:0x00b3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // l7.b
    public double n(char r21) {
        /*
            Method dump skipped, instruction units count: 430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l7.c.n(char):double");
    }

    @Override // l7.b
    public abstract char next();

    /* JADX WARN: Code duplicated, block: B:43:0x0097 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0099 -> B:40:0x0089). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // l7.b
    public java.math.BigDecimal o(char r18) {
        /*
            Method dump skipped, instruction units count: 465
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l7.c.o(char):java.math.BigDecimal");
    }

    @Override // l7.b
    public final void p() {
        J0(':');
    }

    @Override // l7.b
    public final void p0() {
        while (true) {
            char c11 = this.f70098d;
            if (c11 > '/') {
                return;
            }
            if (c11 == ' ' || c11 == '\r' || c11 == '\n' || c11 == '\t' || c11 == '\f' || c11 == '\b') {
                next();
            } else if (c11 != '/') {
                return;
            } else {
                i1();
            }
        }
    }

    @Override // l7.b
    public final String q() {
        return f.a(this.f70095a);
    }

    @Override // l7.b
    public final void q0() {
        this.f70102i = 0;
    }

    @Override // l7.b
    public final boolean r() {
        return this.f70102i == 4 && z0(this.f70103j + 1) == '$' && z0(this.f70103j + 2) == 'r' && z0(this.f70103j + 3) == 'e' && z0(this.f70103j + 4) == 'f';
    }

    @Override // l7.b
    public long s0(char c11) {
        int i11;
        int i12;
        char cZ0;
        this.f70108o = 0;
        char cZ1 = z0(this.f70099f);
        boolean z11 = cZ1 == '\"';
        if (z11) {
            cZ1 = z0(this.f70099f + 1);
            i11 = 2;
        } else {
            i11 = 1;
        }
        boolean z12 = cZ1 == '-';
        if (z12) {
            cZ1 = z0(this.f70099f + i11);
            i11++;
        }
        if (cZ1 >= '0') {
            char c12 = '9';
            if (cZ1 <= '9') {
                long j11 = cZ1 - '0';
                while (true) {
                    i12 = i11 + 1;
                    cZ0 = z0(this.f70099f + i11);
                    if (cZ0 < '0' || cZ0 > c12) {
                        break;
                    }
                    j11 = (j11 * 10) + ((long) (cZ0 - '0'));
                    i11 = i12;
                    c12 = '9';
                }
                if (cZ0 == '.') {
                    this.f70108o = -1;
                    return 0L;
                }
                if (j11 < 0 && (j11 != Long.MIN_VALUE || !z12)) {
                    throw new NumberFormatException(k1(this.f70099f, i11));
                }
                if (z11) {
                    if (cZ0 != '\"') {
                        this.f70108o = -1;
                        return 0L;
                    }
                    cZ0 = z0(this.f70099f + i12);
                    i12 = i11 + 2;
                }
                while (cZ0 != c11) {
                    if (!F0(cZ0)) {
                        this.f70108o = -1;
                        return j11;
                    }
                    cZ0 = z0(this.f70099f + i12);
                    i12++;
                }
                int i13 = this.f70099f + i12;
                this.f70099f = i13;
                this.f70098d = z0(i13);
                this.f70108o = 3;
                this.f70095a = 16;
                return z12 ? -j11 : j11;
            }
        }
        if (cZ1 != 'n' || z0(this.f70099f + i11) != 'u' || z0(this.f70099f + i11 + 1) != 'l' || z0(this.f70099f + i11 + 2) != 'l') {
            this.f70108o = -1;
            return 0L;
        }
        this.f70108o = 5;
        int i14 = i11 + 4;
        char cZ2 = z0(this.f70099f + i11 + 3);
        if (z11 && cZ2 == '\"') {
            cZ2 = z0(this.f70099f + i14);
            i14 = i11 + 5;
        }
        while (cZ2 != ',') {
            if (cZ2 == ']') {
                int i15 = this.f70099f + i14;
                this.f70099f = i15;
                this.f70098d = z0(i15);
                this.f70108o = 5;
                this.f70095a = 15;
                return 0L;
            }
            if (!F0(cZ2)) {
                this.f70108o = -1;
                return 0L;
            }
            cZ2 = z0(this.f70099f + i14);
            i14++;
        }
        int i16 = this.f70099f + i14;
        this.f70099f = i16;
        this.f70098d = z0(i16);
        this.f70108o = 5;
        this.f70095a = 16;
        return 0L;
    }

    @Override // l7.b
    public boolean t() {
        int i11 = 0;
        while (true) {
            char cZ0 = z0(i11);
            if (cZ0 == 26) {
                this.f70095a = 20;
                return true;
            }
            if (!F0(cZ0)) {
                return false;
            }
            i11++;
        }
    }

    @Override // l7.b
    public final Number t0(boolean z11) {
        char cZ0 = z0((this.f70103j + this.f70102i) - 1);
        try {
            if (cZ0 == 'F') {
                return Float.valueOf(Float.parseFloat(v0()));
            }
            if (cZ0 == 'D') {
                return Double.valueOf(Double.parseDouble(v0()));
            }
            return z11 ? Z() : Double.valueOf(B0());
        } catch (NumberFormatException e11) {
            throw new JSONException(e11.getMessage() + ", " + c());
        }
    }

    @Override // l7.b
    public boolean u(char c11) {
        boolean z11 = false;
        this.f70108o = 0;
        char cZ0 = z0(this.f70099f);
        int i11 = 5;
        if (cZ0 == 't') {
            if (z0(this.f70099f + 1) != 'r' || z0(this.f70099f + 2) != 'u' || z0(this.f70099f + 3) != 'e') {
                this.f70108o = -1;
                return false;
            }
            cZ0 = z0(this.f70099f + 4);
            z11 = true;
        } else if (cZ0 != 'f') {
            if (cZ0 == '1') {
                cZ0 = z0(this.f70099f + 1);
                z11 = true;
            } else if (cZ0 == '0') {
                cZ0 = z0(this.f70099f + 1);
            } else {
                i11 = 1;
            }
            i11 = 2;
        } else {
            if (z0(this.f70099f + 1) != 'a' || z0(this.f70099f + 2) != 'l' || z0(this.f70099f + 3) != 's' || z0(this.f70099f + 4) != 'e') {
                this.f70108o = -1;
                return false;
            }
            cZ0 = z0(this.f70099f + 5);
            i11 = 6;
        }
        while (cZ0 != c11) {
            if (!F0(cZ0)) {
                this.f70108o = -1;
                return z11;
            }
            cZ0 = z0(this.f70099f + i11);
            i11++;
        }
        int i12 = this.f70099f + i11;
        this.f70099f = i12;
        this.f70098d = z0(i12);
        this.f70108o = 3;
        return z11;
    }

    @Override // l7.b
    public Locale u0() {
        return this.f70107n;
    }

    @Override // l7.b
    public abstract String v0();

    @Override // l7.b
    public final void w() {
        this.f70102i = 0;
        while (true) {
            this.f70096b = this.f70099f;
            char c11 = this.f70098d;
            if (c11 == '/') {
                i1();
            } else {
                if (c11 == '\"') {
                    x();
                    return;
                }
                if (c11 == ',') {
                    next();
                    this.f70095a = 16;
                    return;
                }
                if (c11 >= '0' && c11 <= '9') {
                    i();
                    return;
                }
                if (c11 == '-') {
                    i();
                    return;
                }
                switch (c11) {
                    case '\b':
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                        next();
                        break;
                    case '\'':
                        if (!g(Feature.AllowSingleQuotes)) {
                            throw new JSONException("Feature.AllowSingleQuotes is false");
                        }
                        e1();
                        return;
                    case '(':
                        next();
                        this.f70095a = 10;
                        return;
                    case ')':
                        next();
                        this.f70095a = 11;
                        return;
                    case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                        next();
                        i();
                        return;
                    case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                        next();
                        this.f70095a = 25;
                        return;
                    case ':':
                        next();
                        this.f70095a = 17;
                        return;
                    case ';':
                        next();
                        this.f70095a = 24;
                        return;
                    case 'N':
                    case 'S':
                    case 'T':
                    case 'u':
                        b1();
                        return;
                    case '[':
                        next();
                        this.f70095a = 14;
                        return;
                    case ']':
                        next();
                        this.f70095a = 15;
                        return;
                    case 'f':
                        N0();
                        return;
                    case Worker.WHAT_QUIT /* 110 */:
                        c1();
                        return;
                    case 't':
                        g1();
                        return;
                    case 'x':
                        a1();
                        return;
                    case '{':
                        next();
                        this.f70095a = 12;
                        return;
                    case '}':
                        next();
                        this.f70095a = 13;
                        return;
                    default:
                        if (E0()) {
                            if (this.f70095a == 20) {
                                throw new JSONException("EOF error");
                            }
                            this.f70095a = 20;
                            int i11 = this.f70099f;
                            this.f70096b = i11;
                            this.f70100g = i11;
                            return;
                        }
                        char c12 = this.f70098d;
                        if (c12 > 31 && c12 != 127) {
                            G0("illegal.char", String.valueOf((int) c12));
                            next();
                            return;
                        }
                        next();
                        break;
                        break;
                }
            }
        }
    }

    public abstract String w0(int i11, int i12, int i13, i iVar);

    @Override // l7.b
    public final void x() {
        this.f70103j = this.f70099f;
        this.f70104k = false;
        while (true) {
            char next = next();
            if (next == '\"') {
                this.f70095a = 4;
                this.f70098d = next();
                return;
            }
            if (next != 26) {
                boolean z11 = true;
                if (next == '\\') {
                    if (!this.f70104k) {
                        this.f70104k = true;
                        int i11 = this.f70102i;
                        char[] cArr = this.f70101h;
                        if (i11 >= cArr.length) {
                            int length = cArr.length * 2;
                            if (i11 <= length) {
                                i11 = length;
                            }
                            char[] cArr2 = new char[i11];
                            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                            this.f70101h = cArr2;
                        }
                        A0(this.f70103j + 1, this.f70102i, this.f70101h);
                    }
                    char next2 = next();
                    if (next2 == '\"') {
                        K0('\"');
                    } else if (next2 != '\'') {
                        if (next2 != 'F') {
                            if (next2 == '\\') {
                                K0('\\');
                            } else if (next2 == 'b') {
                                K0('\b');
                            } else if (next2 != 'f') {
                                if (next2 == 'n') {
                                    K0('\n');
                                } else if (next2 == 'r') {
                                    K0('\r');
                                } else if (next2 != 'x') {
                                    switch (next2) {
                                        case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                            K0('/');
                                            break;
                                        case '0':
                                            K0((char) 0);
                                            break;
                                        case '1':
                                            K0((char) 1);
                                            break;
                                        case '2':
                                            K0((char) 2);
                                            break;
                                        case '3':
                                            K0((char) 3);
                                            break;
                                        case '4':
                                            K0((char) 4);
                                            break;
                                        case '5':
                                            K0((char) 5);
                                            break;
                                        case '6':
                                            K0((char) 6);
                                            break;
                                        case '7':
                                            K0((char) 7);
                                            break;
                                        default:
                                            switch (next2) {
                                                case 't':
                                                    K0('\t');
                                                    break;
                                                case 'u':
                                                    K0((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                    break;
                                                case 'v':
                                                    K0((char) 11);
                                                    break;
                                                default:
                                                    this.f70098d = next2;
                                                    throw new JSONException("unclosed string : " + next2);
                                            }
                                            break;
                                    }
                                } else {
                                    char next3 = next();
                                    char next4 = next();
                                    boolean z12 = (next3 >= '0' && next3 <= '9') || (next3 >= 'a' && next3 <= 'f') || (next3 >= 'A' && next3 <= 'F');
                                    if ((next4 < '0' || next4 > '9') && ((next4 < 'a' || next4 > 'f') && (next4 < 'A' || next4 > 'F'))) {
                                        z11 = false;
                                    }
                                    if (!z12 || !z11) {
                                        throw new JSONException("invalid escape character \\x" + next3 + next4);
                                    }
                                    int[] iArr = f70094t;
                                    K0((char) ((iArr[next3] * 16) + iArr[next4]));
                                }
                            }
                        }
                        K0('\f');
                    } else {
                        K0('\'');
                    }
                } else if (this.f70104k) {
                    int i12 = this.f70102i;
                    char[] cArr3 = this.f70101h;
                    if (i12 == cArr3.length) {
                        K0(next);
                    } else {
                        this.f70102i = i12 + 1;
                        cArr3[i12] = next;
                    }
                } else {
                    this.f70102i++;
                }
            } else {
                if (E0()) {
                    throw new JSONException("unclosed string : " + next);
                }
                K0((char) 26);
            }
        }
    }

    public abstract void x0(int i11, char[] cArr, int i12, int i13);

    @Override // l7.b
    public final String y(i iVar) {
        if (this.f70095a == 1 && this.f70096b == 0 && this.f70099f == 1) {
            this.f70099f = 0;
        }
        boolean[] zArr = com.alibaba.fastjson.util.f.f15557d;
        int i11 = this.f70098d;
        if (i11 < zArr.length && !zArr[i11]) {
            throw new JSONException("illegal identifier : " + this.f70098d + c());
        }
        boolean[] zArr2 = com.alibaba.fastjson.util.f.f15558e;
        this.f70103j = this.f70099f;
        this.f70102i = 1;
        while (true) {
            char next = next();
            if (next < zArr2.length && !zArr2[next]) {
                break;
            }
            i11 = (i11 * 31) + next;
            this.f70102i++;
        }
        this.f70098d = z0(this.f70099f);
        this.f70095a = 18;
        if (this.f70102i == 4 && i11 == 3392903 && z0(this.f70103j) == 'n' && z0(this.f70103j + 1) == 'u' && z0(this.f70103j + 2) == 'l' && z0(this.f70103j + 3) == 'l') {
            return null;
        }
        return iVar == null ? k1(this.f70103j, this.f70102i) : w0(this.f70103j, this.f70102i, i11, iVar);
    }

    public abstract boolean y0(char[] cArr);

    public abstract char z0(int i11);
}
