package n7;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.applovin.exoplayer2.common.base.Ascii;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j1 extends Writer {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ThreadLocal<char[]> f71666t = new ThreadLocal<>();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ThreadLocal<byte[]> f71667u = new ThreadLocal<>();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final char[] f71668v = ":true".toCharArray();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final char[] f71669w = ":false".toCharArray();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static int f71670x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f71671y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f71672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f71673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f71674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Writer f71675d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f71676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f71677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f71678h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f71679i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f71680j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f71681k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f71682l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f71683m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f71684n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f71685o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public char f71686p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f71687q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f71688r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f71689s;

    static {
        int i11;
        f71670x = 131072;
        try {
            String strK = com.alibaba.fastjson.util.f.k("fastjson.serializer_buffer_threshold");
            if (strK != null && strK.length() > 0 && (i11 = Integer.parseInt(strK)) >= 64 && i11 <= 65536) {
                f71670x = i11 * 1024;
            }
        } catch (Throwable unused) {
        }
        f71671y = SerializerFeature.UseSingleQuotes.mask | SerializerFeature.BrowserCompatible.mask | SerializerFeature.PrettyFormat.mask | SerializerFeature.WriteEnumUsingToString.mask | SerializerFeature.WriteNonStringValueAsString.mask | SerializerFeature.WriteSlashAsSpecial.mask | SerializerFeature.IgnoreErrorGetter.mask | SerializerFeature.WriteClassName.mask | SerializerFeature.NotWriteDefaultValue.mask;
    }

    public j1() {
        this(null);
    }

    public j1(Writer writer) {
        this(writer, com.alibaba.fastjson.a.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
    }

    public j1(Writer writer, int i11, SerializerFeature... serializerFeatureArr) {
        this.f71687q = -1;
        this.f71675d = writer;
        ThreadLocal<char[]> threadLocal = f71666t;
        char[] cArr = threadLocal.get();
        this.f71672a = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        } else {
            this.f71672a = new char[2048];
        }
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            i11 |= serializerFeature.getMask();
        }
        this.f71674c = i11;
        d();
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00d2  */
    public void U(char c11, String str, String str2) {
        int length;
        int i11;
        int length2 = str.length();
        int i12 = this.f71673b;
        if (str2 == null) {
            i11 = i12 + length2 + 8;
            length = 4;
        } else {
            length = str2.length();
            i11 = i12 + length2 + length + 6;
        }
        int i13 = 0;
        if (i11 > this.f71672a.length) {
            if (this.f71675d != null) {
                write(c11);
                l0(str, ':');
                l0(str2, (char) 0);
                return;
            }
            i(i11);
        }
        char[] cArr = this.f71672a;
        int i14 = this.f71673b;
        cArr[i14] = c11;
        int i15 = i14 + 2;
        int i16 = i15 + length2;
        cArr[i14 + 1] = '\"';
        str.getChars(0, length2, cArr, i15);
        this.f71673b = i11;
        char[] cArr2 = this.f71672a;
        cArr2[i16] = '\"';
        int i17 = i16 + 2;
        cArr2[i16 + 1] = ':';
        if (str2 == null) {
            cArr2[i17] = 'n';
            cArr2[i16 + 3] = 'u';
            cArr2[i16 + 4] = 'l';
            cArr2[i16 + 5] = 'l';
            return;
        }
        int i18 = i16 + 3;
        cArr2[i17] = '\"';
        int i19 = i18 + length;
        str2.getChars(0, length, cArr2, i18);
        int i21 = -1;
        char c12 = 0;
        int i22 = -1;
        int i23 = -1;
        for (int i24 = i18; i24 < i19; i24++) {
            char c13 = this.f71672a[i24];
            if (c13 >= ']') {
                if (c13 >= 127 && (c13 == 8232 || c13 == 8233 || c13 < 160)) {
                    if (i22 == i21) {
                        i22 = i24;
                    }
                    i13++;
                    i11 += 4;
                    c12 = c13;
                    i23 = i24;
                }
            } else if ((c13 >= '@' || (this.f71689s & (1 << c13)) == 0) && c13 != '\\') {
                i21 = -1;
            } else {
                i13++;
                if (c13 == '(' || c13 == ')' || c13 == '<' || c13 == '>') {
                    i11 += 4;
                } else {
                    byte[] bArr = com.alibaba.fastjson.util.f.f15559f;
                    if (c13 < bArr.length && bArr[c13] == 4) {
                        i11 += 4;
                    }
                }
                i21 = -1;
                c12 = c13;
                if (i22 == -1) {
                    i22 = i24;
                    i23 = i22;
                } else {
                    i23 = i24;
                }
            }
        }
        if (i13 > 0) {
            int i25 = i11 + i13;
            if (i25 > this.f71672a.length) {
                i(i25);
            }
            this.f71673b = i25;
            if (i13 == 1) {
                if (c12 == 8232) {
                    int i26 = i23 + 1;
                    char[] cArr3 = this.f71672a;
                    System.arraycopy(cArr3, i26, cArr3, i23 + 6, (i19 - i23) - 1);
                    char[] cArr4 = this.f71672a;
                    cArr4[i23] = '\\';
                    cArr4[i26] = 'u';
                    cArr4[i23 + 2] = '2';
                    cArr4[i23 + 3] = '0';
                    cArr4[i23 + 4] = '2';
                    cArr4[i23 + 5] = '8';
                } else if (c12 == 8233) {
                    int i27 = i23 + 1;
                    char[] cArr5 = this.f71672a;
                    System.arraycopy(cArr5, i27, cArr5, i23 + 6, (i19 - i23) - 1);
                    char[] cArr6 = this.f71672a;
                    cArr6[i23] = '\\';
                    cArr6[i27] = 'u';
                    cArr6[i23 + 2] = '2';
                    cArr6[i23 + 3] = '0';
                    cArr6[i23 + 4] = '2';
                    cArr6[i23 + 5] = '9';
                } else if (c12 == '(' || c12 == ')' || c12 == '<' || c12 == '>') {
                    int i28 = i23 + 1;
                    char[] cArr7 = this.f71672a;
                    System.arraycopy(cArr7, i28, cArr7, i23 + 6, (i19 - i23) - 1);
                    char[] cArr8 = this.f71672a;
                    cArr8[i23] = '\\';
                    cArr8[i28] = 'u';
                    char[] cArr9 = com.alibaba.fastjson.util.f.f15556c;
                    cArr8[i23 + 2] = cArr9[(c12 >>> '\f') & 15];
                    cArr8[i23 + 3] = cArr9[(c12 >>> '\b') & 15];
                    cArr8[i23 + 4] = cArr9[(c12 >>> 4) & 15];
                    cArr8[i23 + 5] = cArr9[c12 & 15];
                } else {
                    byte[] bArr2 = com.alibaba.fastjson.util.f.f15559f;
                    if (c12 >= bArr2.length || bArr2[c12] != 4) {
                        int i29 = i23 + 1;
                        char[] cArr10 = this.f71672a;
                        System.arraycopy(cArr10, i29, cArr10, i23 + 2, (i19 - i23) - 1);
                        char[] cArr11 = this.f71672a;
                        cArr11[i23] = '\\';
                        cArr11[i29] = com.alibaba.fastjson.util.f.f15563j[c12];
                    } else {
                        int i31 = i23 + 1;
                        char[] cArr12 = this.f71672a;
                        System.arraycopy(cArr12, i31, cArr12, i23 + 6, (i19 - i23) - 1);
                        char[] cArr13 = this.f71672a;
                        cArr13[i23] = '\\';
                        cArr13[i31] = 'u';
                        char[] cArr14 = com.alibaba.fastjson.util.f.f15556c;
                        cArr13[i23 + 2] = cArr14[(c12 >>> '\f') & 15];
                        cArr13[i23 + 3] = cArr14[(c12 >>> '\b') & 15];
                        cArr13[i23 + 4] = cArr14[(c12 >>> 4) & 15];
                        cArr13[i23 + 5] = cArr14[c12 & 15];
                    }
                }
            } else if (i13 > 1) {
                for (int i32 = i22 - i18; i32 < str2.length(); i32++) {
                    char cCharAt = str2.charAt(i32);
                    if (this.f71688r) {
                        if (cCharAt != '(' && cCharAt != ')') {
                            if (cCharAt == '<' || cCharAt == '>') {
                            }
                        }
                        char[] cArr15 = this.f71672a;
                        cArr15[i22] = '\\';
                        cArr15[i22 + 1] = 'u';
                        char[] cArr16 = com.alibaba.fastjson.util.f.f15556c;
                        cArr15[i22 + 2] = cArr16[(cCharAt >>> '\f') & 15];
                        cArr15[i22 + 3] = cArr16[(cCharAt >>> '\b') & 15];
                        int i33 = i22 + 5;
                        cArr15[i22 + 4] = cArr16[(cCharAt >>> 4) & 15];
                        i22 += 6;
                        cArr15[i33] = cArr16[cCharAt & 15];
                    }
                    byte[] bArr3 = com.alibaba.fastjson.util.f.f15559f;
                    if ((cCharAt >= bArr3.length || bArr3[cCharAt] == 0) && !(cCharAt == '/' && k(SerializerFeature.WriteSlashAsSpecial))) {
                        if (cCharAt == 8232 || cCharAt == 8233) {
                            char[] cArr17 = this.f71672a;
                            cArr17[i22] = '\\';
                            cArr17[i22 + 1] = 'u';
                            char[] cArr18 = com.alibaba.fastjson.util.f.f15556c;
                            cArr17[i22 + 2] = cArr18[(cCharAt >>> '\f') & 15];
                            cArr17[i22 + 3] = cArr18[(cCharAt >>> '\b') & 15];
                            int i34 = i22 + 5;
                            cArr17[i22 + 4] = cArr18[(cCharAt >>> 4) & 15];
                            i22 += 6;
                            cArr17[i34] = cArr18[cCharAt & 15];
                        } else {
                            this.f71672a[i22] = cCharAt;
                            i22++;
                        }
                    } else {
                        char[] cArr19 = this.f71672a;
                        int i35 = i22 + 1;
                        cArr19[i22] = '\\';
                        if (bArr3[cCharAt] == 4) {
                            cArr19[i35] = 'u';
                            char[] cArr20 = com.alibaba.fastjson.util.f.f15556c;
                            cArr19[i22 + 2] = cArr20[(cCharAt >>> '\f') & 15];
                            cArr19[i22 + 3] = cArr20[(cCharAt >>> '\b') & 15];
                            int i36 = i22 + 5;
                            cArr19[i22 + 4] = cArr20[(cCharAt >>> 4) & 15];
                            i22 += 6;
                            cArr19[i36] = cArr20[cCharAt & 15];
                        } else {
                            i22 += 2;
                            cArr19[i35] = com.alibaba.fastjson.util.f.f15563j[cCharAt];
                        }
                    }
                }
            }
        }
        this.f71672a[this.f71673b - 1] = '\"';
    }

    public void W(float f11, boolean z11) {
        if (f11 != f11 || f11 == Float.POSITIVE_INFINITY || f11 == Float.NEGATIVE_INFINITY) {
            g0();
            return;
        }
        int i11 = this.f71673b + 15;
        if (i11 > this.f71672a.length) {
            if (this.f71675d != null) {
                String strB = com.alibaba.fastjson.util.k.b(f11);
                write(strB, 0, strB.length());
                if (z11 && k(SerializerFeature.WriteClassName)) {
                    write(70);
                    return;
                }
                return;
            }
            i(i11);
        }
        this.f71673b += com.alibaba.fastjson.util.k.a(f11, this.f71672a, this.f71673b);
        if (z11 && k(SerializerFeature.WriteClassName)) {
            write(70);
        }
    }

    public void Z(byte[] bArr) {
        int length = this.f71673b + (bArr.length * 2) + 3;
        if (length > this.f71672a.length) {
            i(length);
        }
        char[] cArr = this.f71672a;
        int i11 = this.f71673b;
        cArr[i11] = 'x';
        this.f71673b = i11 + 2;
        cArr[i11 + 1] = '\'';
        for (byte b11 : bArr) {
            int i12 = (b11 & 255) >> 4;
            int i13 = b11 & Ascii.SI;
            char[] cArr2 = this.f71672a;
            int i14 = this.f71673b;
            int i15 = i14 + 1;
            this.f71673b = i15;
            int i16 = 55;
            cArr2[i14] = (char) (i12 + (i12 < 10 ? 48 : 55));
            this.f71673b = i14 + 2;
            if (i13 < 10) {
                i16 = 48;
            }
            cArr2[i15] = (char) (i13 + i16);
        }
        char[] cArr3 = this.f71672a;
        int i17 = this.f71673b;
        this.f71673b = i17 + 1;
        cArr3[i17] = '\'';
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public j1 append(char c11) {
        write(c11);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public j1 append(CharSequence charSequence) {
        String string = charSequence == null ? "null" : charSequence.toString();
        write(string, 0, string.length());
        return this;
    }

    public void b0(int i11) {
        if (i11 == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int iO = i11 < 0 ? com.alibaba.fastjson.util.f.o(-i11) + 1 : com.alibaba.fastjson.util.f.o(i11);
        int i12 = this.f71673b + iO;
        if (i12 > this.f71672a.length) {
            if (this.f71675d != null) {
                char[] cArr = new char[iO];
                com.alibaba.fastjson.util.f.i(i11, iO, cArr);
                write(cArr, 0, iO);
                return;
            }
            i(i12);
        }
        com.alibaba.fastjson.util.f.i(i11, i12, this.f71672a);
        this.f71673b = i12;
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public j1 append(CharSequence charSequence, int i11, int i12) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String string = charSequence.subSequence(i11, i12).toString();
        write(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f71675d != null && this.f71673b > 0) {
            flush();
        }
        char[] cArr = this.f71672a;
        if (cArr.length <= f71670x) {
            f71666t.set(cArr);
        }
        this.f71672a = null;
    }

    public void d() {
        long j11;
        int i11 = this.f71674c;
        boolean z11 = (SerializerFeature.QuoteFieldNames.mask & i11) != 0;
        this.f71677g = z11;
        boolean z12 = (SerializerFeature.UseSingleQuotes.mask & i11) != 0;
        this.f71676f = z12;
        this.f71678h = (SerializerFeature.SortField.mask & i11) != 0;
        this.f71679i = (SerializerFeature.DisableCircularReferenceDetect.mask & i11) != 0;
        boolean z13 = (SerializerFeature.BeanToArray.mask & i11) != 0;
        this.f71680j = z13;
        this.f71681k = (SerializerFeature.WriteNonStringValueAsString.mask & i11) != 0;
        this.f71682l = (SerializerFeature.NotWriteDefaultValue.mask & i11) != 0;
        boolean z14 = (SerializerFeature.WriteEnumUsingName.mask & i11) != 0;
        this.f71683m = z14;
        this.f71684n = (SerializerFeature.WriteEnumUsingToString.mask & i11) != 0;
        this.f71685o = z11 && (f71671y & i11) == 0 && (z13 || z14);
        this.f71686p = z12 ? '\'' : '\"';
        boolean z15 = (SerializerFeature.BrowserSecure.mask & i11) != 0;
        this.f71688r = z15;
        if (z15) {
            j11 = 5764610843043954687L;
        } else {
            j11 = (i11 & SerializerFeature.WriteSlashAsSpecial.mask) != 0 ? 140758963191807L : 21474836479L;
        }
        this.f71689s = j11;
    }

    public final void d0(String str) {
        byte[] bArr = com.alibaba.fastjson.util.f.f15560g;
        int length = str.length();
        boolean z11 = true;
        int i11 = this.f71673b + length + 1;
        int i12 = 0;
        if (i11 > this.f71672a.length) {
            if (this.f71675d != null) {
                if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                }
                int i13 = 0;
                while (true) {
                    if (i13 < length) {
                        char cCharAt = str.charAt(i13);
                        if (cCharAt < bArr.length && bArr[cCharAt] != 0) {
                            break;
                        } else {
                            i13++;
                        }
                    } else {
                        z11 = false;
                        break;
                    }
                }
                if (z11) {
                    write(39);
                }
                while (i12 < length) {
                    char cCharAt2 = str.charAt(i12);
                    if (cCharAt2 >= bArr.length || bArr[cCharAt2] == 0) {
                        write(cCharAt2);
                    } else {
                        write(92);
                        write(com.alibaba.fastjson.util.f.f15563j[cCharAt2]);
                    }
                    i12++;
                }
                if (z11) {
                    write(39);
                }
                write(58);
                return;
            }
            i(i11);
        }
        if (length == 0) {
            int i14 = this.f71673b;
            if (i14 + 3 > this.f71672a.length) {
                i(i14 + 3);
            }
            char[] cArr = this.f71672a;
            int i15 = this.f71673b;
            cArr[i15] = '\'';
            cArr[i15 + 1] = '\'';
            this.f71673b = i15 + 3;
            cArr[i15 + 2] = ':';
            return;
        }
        int i16 = this.f71673b;
        int i17 = i16 + length;
        str.getChars(0, length, this.f71672a, i16);
        this.f71673b = i11;
        int i18 = i16;
        boolean z12 = false;
        while (i18 < i17) {
            char[] cArr2 = this.f71672a;
            char c11 = cArr2[i18];
            if (c11 < bArr.length && bArr[c11] != 0) {
                if (z12) {
                    i11++;
                    if (i11 > cArr2.length) {
                        i(i11);
                    }
                    this.f71673b = i11;
                    char[] cArr3 = this.f71672a;
                    int i19 = i18 + 1;
                    System.arraycopy(cArr3, i19, cArr3, i18 + 2, i17 - i18);
                    char[] cArr4 = this.f71672a;
                    cArr4[i18] = '\\';
                    cArr4[i19] = com.alibaba.fastjson.util.f.f15563j[c11];
                    i17++;
                    i18 = i19;
                } else {
                    i11 += 3;
                    if (i11 > cArr2.length) {
                        i(i11);
                    }
                    this.f71673b = i11;
                    char[] cArr5 = this.f71672a;
                    int i21 = i18 + 1;
                    System.arraycopy(cArr5, i21, cArr5, i18 + 3, (i17 - i18) - 1);
                    char[] cArr6 = this.f71672a;
                    System.arraycopy(cArr6, i12, cArr6, 1, i18);
                    char[] cArr7 = this.f71672a;
                    cArr7[i16] = '\'';
                    cArr7[i21] = '\\';
                    i18 += 2;
                    cArr7[i18] = com.alibaba.fastjson.util.f.f15563j[c11];
                    i17 += 2;
                    cArr7[this.f71673b - 2] = '\'';
                    z12 = true;
                }
            }
            i18++;
            i12 = 0;
        }
        this.f71672a[i11 - 1] = ':';
    }

    public void e(SerializerFeature serializerFeature, boolean z11) {
        if (z11) {
            int mask = this.f71674c | serializerFeature.getMask();
            this.f71674c = mask;
            SerializerFeature serializerFeature2 = SerializerFeature.WriteEnumUsingToString;
            if (serializerFeature == serializerFeature2) {
                this.f71674c = (~SerializerFeature.WriteEnumUsingName.getMask()) & mask;
            } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                this.f71674c = (~serializerFeature2.getMask()) & mask;
            }
        } else {
            this.f71674c = (~serializerFeature.getMask()) & this.f71674c;
        }
        d();
    }

    public void e0(long j11) {
        boolean z11 = k(SerializerFeature.BrowserCompatible) && !k(SerializerFeature.WriteClassName) && (j11 > 9007199254740991L || j11 < -9007199254740991L);
        if (j11 == Long.MIN_VALUE) {
            if (z11) {
                write("\"-9223372036854775808\"");
                return;
            } else {
                write("-9223372036854775808");
                return;
            }
        }
        int iP = j11 < 0 ? com.alibaba.fastjson.util.f.p(-j11) + 1 : com.alibaba.fastjson.util.f.p(j11);
        int i11 = this.f71673b + iP;
        if (z11) {
            i11 += 2;
        }
        if (i11 > this.f71672a.length) {
            if (this.f71675d != null) {
                char[] cArr = new char[iP];
                com.alibaba.fastjson.util.f.j(j11, iP, cArr);
                if (!z11) {
                    write(cArr, 0, iP);
                    return;
                }
                write(34);
                write(cArr, 0, iP);
                write(34);
                return;
            }
            i(i11);
        }
        if (z11) {
            char[] cArr2 = this.f71672a;
            cArr2[this.f71673b] = '\"';
            int i12 = i11 - 1;
            com.alibaba.fastjson.util.f.j(j11, i12, cArr2);
            this.f71672a[i12] = '\"';
        } else {
            com.alibaba.fastjson.util.f.j(j11, i11, this.f71672a);
        }
        this.f71673b = i11;
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        Writer writer = this.f71675d;
        if (writer == null) {
            return;
        }
        try {
            writer.write(this.f71672a, 0, this.f71673b);
            this.f71675d.flush();
            this.f71673b = 0;
        } catch (IOException e11) {
            throw new JSONException(e11.getMessage(), e11);
        }
    }

    public final int g(OutputStream outputStream) throws IOException {
        int i11 = (int) (((double) this.f71673b) * 3.0d);
        ThreadLocal<byte[]> threadLocal = f71667u;
        byte[] bArr = threadLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            threadLocal.set(bArr);
        }
        byte[] bArr2 = bArr.length < i11 ? new byte[i11] : bArr;
        int iG = com.alibaba.fastjson.util.f.g(this.f71672a, 0, this.f71673b, bArr2);
        outputStream.write(bArr2, 0, iG);
        if (bArr2 != bArr && bArr2.length <= f71670x) {
            threadLocal.set(bArr2);
        }
        return iG;
    }

    public void g0() {
        write("null");
    }

    public final byte[] h() {
        int i11 = (int) (((double) this.f71673b) * 3.0d);
        ThreadLocal<byte[]> threadLocal = f71667u;
        byte[] bArr = threadLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            threadLocal.set(bArr);
        }
        byte[] bArr2 = bArr.length < i11 ? new byte[i11] : bArr;
        int iG = com.alibaba.fastjson.util.f.g(this.f71672a, 0, this.f71673b, bArr2);
        byte[] bArr3 = new byte[iG];
        System.arraycopy(bArr2, 0, bArr3, 0, iG);
        if (bArr2 != bArr && bArr2.length <= f71670x) {
            threadLocal.set(bArr2);
        }
        return bArr3;
    }

    public void h0(int i11, int i12) {
        if ((i11 & i12) == 0 && (this.f71674c & i12) == 0) {
            g0();
            return;
        }
        int i13 = SerializerFeature.WriteMapNullValue.mask;
        if ((i11 & i13) != 0 && (i11 & (~i13) & SerializerFeature.WRITE_MAP_NULL_FEATURES) == 0) {
            g0();
            return;
        }
        if (i12 == SerializerFeature.WriteNullListAsEmpty.mask) {
            write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        if (i12 == SerializerFeature.WriteNullStringAsEmpty.mask) {
            j0("");
            return;
        }
        if (i12 == SerializerFeature.WriteNullBooleanAsFalse.mask) {
            write("false");
        } else if (i12 == SerializerFeature.WriteNullNumberAsZero.mask) {
            write(48);
        } else {
            g0();
        }
    }

    public void i(int i11) {
        ThreadLocal<char[]> threadLocal;
        char[] cArr;
        int i12 = this.f71687q;
        if (i12 != -1 && i11 >= i12) {
            throw new JSONException("serialize exceeded MAX_OUTPUT_LENGTH=" + this.f71687q + ", minimumCapacity=" + i11);
        }
        char[] cArr2 = this.f71672a;
        int length = cArr2.length + (cArr2.length >> 1) + 1;
        if (length >= i11) {
            i11 = length;
        }
        char[] cArr3 = new char[i11];
        System.arraycopy(cArr2, 0, cArr3, 0, this.f71673b);
        if (this.f71672a.length < f71670x && ((cArr = (threadLocal = f71666t).get()) == null || cArr.length < this.f71672a.length)) {
            threadLocal.set(this.f71672a);
        }
        this.f71672a = cArr3;
    }

    public void i0(SerializerFeature serializerFeature) {
        h0(0, serializerFeature.mask);
    }

    public boolean j(int i11) {
        return (i11 & this.f71674c) != 0;
    }

    public void j0(String str) {
        if (this.f71676f) {
            p0(str);
        } else {
            l0(str, (char) 0);
        }
    }

    public boolean k(SerializerFeature serializerFeature) {
        return (serializerFeature.mask & this.f71674c) != 0;
    }

    public void k0(char[] cArr) {
        if (this.f71676f) {
            q0(cArr);
        } else {
            l0(new String(cArr), (char) 0);
        }
    }

    public byte[] l(Charset charset) {
        if (this.f71675d == null) {
            return charset == com.alibaba.fastjson.util.f.f15555b ? h() : new String(this.f71672a, 0, this.f71673b).getBytes(charset);
        }
        throw new UnsupportedOperationException("writer not null");
    }

    /* JADX WARN: Code duplicated, block: B:165:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:59:0x014f  */
    public void l0(String str, char c11) {
        if (str == null) {
            g0();
            if (c11 != 0) {
                write(c11);
                return;
            }
            return;
        }
        int length = str.length();
        int i11 = this.f71673b + length;
        int i12 = i11 + 2;
        if (c11 != 0) {
            i12 = i11 + 3;
        }
        char c12 = '>';
        if (i12 > this.f71672a.length) {
            if (this.f71675d != null) {
                write(34);
                int i13 = 0;
                while (i13 < str.length()) {
                    char cCharAt = str.charAt(i13);
                    if (k(SerializerFeature.BrowserSecure) && (cCharAt == '(' || cCharAt == ')' || cCharAt == '<' || cCharAt == c12)) {
                        write(92);
                        write(117);
                        char[] cArr = com.alibaba.fastjson.util.f.f15556c;
                        write(cArr[(cCharAt >>> '\f') & 15]);
                        write(cArr[(cCharAt >>> '\b') & 15]);
                        write(cArr[(cCharAt >>> 4) & 15]);
                        write(cArr[cCharAt & 15]);
                    } else if (!k(SerializerFeature.BrowserCompatible)) {
                        byte[] bArr = com.alibaba.fastjson.util.f.f15559f;
                        if ((cCharAt >= bArr.length || bArr[cCharAt] == 0) && !(cCharAt == '/' && k(SerializerFeature.WriteSlashAsSpecial))) {
                            write(cCharAt);
                        } else {
                            write(92);
                            if (bArr[cCharAt] == 4) {
                                write(117);
                                char[] cArr2 = com.alibaba.fastjson.util.f.f15556c;
                                write(cArr2[(cCharAt >>> '\f') & 15]);
                                write(cArr2[(cCharAt >>> '\b') & 15]);
                                write(cArr2[(cCharAt >>> 4) & 15]);
                                write(cArr2[cCharAt & 15]);
                            } else {
                                write(com.alibaba.fastjson.util.f.f15563j[cCharAt]);
                            }
                        }
                    } else if (cCharAt == '\b' || cCharAt == '\f' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t' || cCharAt == '\"' || cCharAt == '/' || cCharAt == '\\') {
                        write(92);
                        write(com.alibaba.fastjson.util.f.f15563j[cCharAt]);
                    } else if (cCharAt < ' ') {
                        write(92);
                        write(117);
                        write(48);
                        write(48);
                        char[] cArr3 = com.alibaba.fastjson.util.f.f15564k;
                        int i14 = cCharAt * 2;
                        write(cArr3[i14]);
                        write(cArr3[i14 + 1]);
                    } else if (cCharAt >= 127) {
                        write(92);
                        write(117);
                        char[] cArr4 = com.alibaba.fastjson.util.f.f15556c;
                        write(cArr4[(cCharAt >>> '\f') & 15]);
                        write(cArr4[(cCharAt >>> '\b') & 15]);
                        write(cArr4[(cCharAt >>> 4) & 15]);
                        write(cArr4[cCharAt & 15]);
                    } else {
                        write(cCharAt);
                    }
                    i13++;
                    c12 = '>';
                }
                write(34);
                if (c11 != 0) {
                    write(c11);
                    return;
                }
                return;
            }
            i(i12);
        }
        int i15 = this.f71673b;
        int i16 = i15 + 1;
        int i17 = i16 + length;
        char[] cArr5 = this.f71672a;
        cArr5[i15] = '\"';
        char c13 = 0;
        str.getChars(0, length, cArr5, i16);
        this.f71673b = i12;
        int i18 = -1;
        if (k(SerializerFeature.BrowserCompatible)) {
            for (int i19 = i16; i19 < i17; i19++) {
                char c14 = this.f71672a[i19];
                if (c14 == '\"' || c14 == '/' || c14 == '\\' || c14 == '\b' || c14 == '\f' || c14 == '\n' || c14 == '\r' || c14 == '\t') {
                    i12++;
                } else {
                    if (c14 < ' ' || c14 >= 127) {
                        i12 += 5;
                    }
                }
                i18 = i19;
            }
            if (i12 > this.f71672a.length) {
                i(i12);
            }
            this.f71673b = i12;
            while (i18 >= i16) {
                char[] cArr6 = this.f71672a;
                char c15 = cArr6[i18];
                if (c15 == '\b' || c15 == '\f' || c15 == '\n' || c15 == '\r' || c15 == '\t') {
                    int i21 = i18 + 1;
                    System.arraycopy(cArr6, i21, cArr6, i18 + 2, (i17 - i18) - 1);
                    char[] cArr7 = this.f71672a;
                    cArr7[i18] = '\\';
                    cArr7[i21] = com.alibaba.fastjson.util.f.f15563j[c15];
                } else {
                    if (c15 == '\"' || c15 == '/' || c15 == '\\') {
                        int i22 = i18 + 1;
                        System.arraycopy(cArr6, i22, cArr6, i18 + 2, (i17 - i18) - 1);
                        char[] cArr8 = this.f71672a;
                        cArr8[i18] = '\\';
                        cArr8[i22] = c15;
                    } else {
                        if (c15 < ' ') {
                            int i23 = i18 + 1;
                            System.arraycopy(cArr6, i23, cArr6, i18 + 6, (i17 - i18) - 1);
                            char[] cArr9 = this.f71672a;
                            cArr9[i18] = '\\';
                            cArr9[i23] = 'u';
                            cArr9[i18 + 2] = '0';
                            cArr9[i18 + 3] = '0';
                            char[] cArr10 = com.alibaba.fastjson.util.f.f15564k;
                            int i24 = c15 * 2;
                            cArr9[i18 + 4] = cArr10[i24];
                            cArr9[i18 + 5] = cArr10[i24 + 1];
                        } else if (c15 >= 127) {
                            int i25 = i18 + 1;
                            System.arraycopy(cArr6, i25, cArr6, i18 + 6, (i17 - i18) - 1);
                            char[] cArr11 = this.f71672a;
                            cArr11[i18] = '\\';
                            cArr11[i25] = 'u';
                            char[] cArr12 = com.alibaba.fastjson.util.f.f15556c;
                            cArr11[i18 + 2] = cArr12[(c15 >>> '\f') & 15];
                            cArr11[i18 + 3] = cArr12[(c15 >>> '\b') & 15];
                            cArr11[i18 + 4] = cArr12[(c15 >>> 4) & 15];
                            cArr11[i18 + 5] = cArr12[c15 & 15];
                        }
                        i17 += 5;
                    }
                    i18--;
                }
                i17++;
                i18--;
            }
            if (c11 == 0) {
                this.f71672a[this.f71673b - 1] = '\"';
                return;
            }
            char[] cArr13 = this.f71672a;
            int i26 = this.f71673b;
            cArr13[i26 - 2] = '\"';
            cArr13[i26 - 1] = c11;
            return;
        }
        int i27 = 0;
        int i28 = -1;
        int i29 = -1;
        for (int i31 = i16; i31 < i17; i31++) {
            char c16 = this.f71672a[i31];
            if (c16 >= ']') {
                if (c16 >= 127 && (c16 == 8232 || c16 == 8233 || c16 < 160)) {
                    if (i28 == i18) {
                        i28 = i31;
                    }
                    i27++;
                    i12 += 4;
                    i29 = i31;
                    c13 = c16;
                }
            } else if ((c16 >= '@' || (this.f71689s & (1 << c16)) == 0) && c16 != '\\') {
                i18 = -1;
            } else {
                i27++;
                if (c16 == '(' || c16 == ')' || c16 == '<' || c16 == '>') {
                    i12 += 4;
                } else {
                    byte[] bArr2 = com.alibaba.fastjson.util.f.f15559f;
                    if (c16 < bArr2.length && bArr2[c16] == 4) {
                        i12 += 4;
                    }
                }
                i18 = -1;
                if (i28 == -1) {
                    i28 = i31;
                    i29 = i28;
                } else {
                    i29 = i31;
                }
                c13 = c16;
            }
        }
        if (i27 > 0) {
            int i32 = i12 + i27;
            if (i32 > this.f71672a.length) {
                i(i32);
            }
            this.f71673b = i32;
            if (i27 == 1) {
                if (c13 == 8232) {
                    int i33 = i29 + 1;
                    char[] cArr14 = this.f71672a;
                    System.arraycopy(cArr14, i33, cArr14, i29 + 6, (i17 - i29) - 1);
                    char[] cArr15 = this.f71672a;
                    cArr15[i29] = '\\';
                    cArr15[i33] = 'u';
                    cArr15[i29 + 2] = '2';
                    cArr15[i29 + 3] = '0';
                    cArr15[i29 + 4] = '2';
                    cArr15[i29 + 5] = '8';
                } else if (c13 == 8233) {
                    int i34 = i29 + 1;
                    char[] cArr16 = this.f71672a;
                    System.arraycopy(cArr16, i34, cArr16, i29 + 6, (i17 - i29) - 1);
                    char[] cArr17 = this.f71672a;
                    cArr17[i29] = '\\';
                    cArr17[i34] = 'u';
                    cArr17[i29 + 2] = '2';
                    cArr17[i29 + 3] = '0';
                    cArr17[i29 + 4] = '2';
                    cArr17[i29 + 5] = '9';
                } else if (c13 == '(' || c13 == ')' || c13 == '<' || c13 == '>') {
                    int i35 = i29 + 1;
                    char[] cArr18 = this.f71672a;
                    System.arraycopy(cArr18, i35, cArr18, i29 + 6, (i17 - i29) - 1);
                    char[] cArr19 = this.f71672a;
                    cArr19[i29] = '\\';
                    cArr19[i35] = 'u';
                    char[] cArr20 = com.alibaba.fastjson.util.f.f15556c;
                    cArr19[i29 + 2] = cArr20[(c13 >>> '\f') & 15];
                    cArr19[i29 + 3] = cArr20[(c13 >>> '\b') & 15];
                    cArr19[i29 + 4] = cArr20[(c13 >>> 4) & 15];
                    cArr19[i29 + 5] = cArr20[c13 & 15];
                } else {
                    byte[] bArr3 = com.alibaba.fastjson.util.f.f15559f;
                    if (c13 >= bArr3.length || bArr3[c13] != 4) {
                        int i36 = i29 + 1;
                        char[] cArr21 = this.f71672a;
                        System.arraycopy(cArr21, i36, cArr21, i29 + 2, (i17 - i29) - 1);
                        char[] cArr22 = this.f71672a;
                        cArr22[i29] = '\\';
                        cArr22[i36] = com.alibaba.fastjson.util.f.f15563j[c13];
                    } else {
                        int i37 = i29 + 1;
                        char[] cArr23 = this.f71672a;
                        System.arraycopy(cArr23, i37, cArr23, i29 + 6, (i17 - i29) - 1);
                        char[] cArr24 = this.f71672a;
                        cArr24[i29] = '\\';
                        cArr24[i37] = 'u';
                        char[] cArr25 = com.alibaba.fastjson.util.f.f15556c;
                        cArr24[i29 + 2] = cArr25[(c13 >>> '\f') & 15];
                        cArr24[i29 + 3] = cArr25[(c13 >>> '\b') & 15];
                        cArr24[i29 + 4] = cArr25[(c13 >>> 4) & 15];
                        cArr24[i29 + 5] = cArr25[c13 & 15];
                    }
                }
            } else if (i27 > 1) {
                for (int i38 = i28 - i16; i38 < str.length(); i38++) {
                    char cCharAt2 = str.charAt(i38);
                    if (this.f71688r) {
                        if (cCharAt2 != '(' && cCharAt2 != ')') {
                            if (cCharAt2 == '<' || cCharAt2 == '>') {
                            }
                        }
                        char[] cArr26 = this.f71672a;
                        cArr26[i28] = '\\';
                        cArr26[i28 + 1] = 'u';
                        char[] cArr27 = com.alibaba.fastjson.util.f.f15556c;
                        cArr26[i28 + 2] = cArr27[(cCharAt2 >>> '\f') & 15];
                        cArr26[i28 + 3] = cArr27[(cCharAt2 >>> '\b') & 15];
                        int i39 = i28 + 5;
                        cArr26[i28 + 4] = cArr27[(cCharAt2 >>> 4) & 15];
                        i28 += 6;
                        cArr26[i39] = cArr27[cCharAt2 & 15];
                    }
                    byte[] bArr4 = com.alibaba.fastjson.util.f.f15559f;
                    if ((cCharAt2 >= bArr4.length || bArr4[cCharAt2] == 0) && !(cCharAt2 == '/' && k(SerializerFeature.WriteSlashAsSpecial))) {
                        if (cCharAt2 == 8232 || cCharAt2 == 8233) {
                            char[] cArr28 = this.f71672a;
                            cArr28[i28] = '\\';
                            cArr28[i28 + 1] = 'u';
                            char[] cArr29 = com.alibaba.fastjson.util.f.f15556c;
                            cArr28[i28 + 2] = cArr29[(cCharAt2 >>> '\f') & 15];
                            cArr28[i28 + 3] = cArr29[(cCharAt2 >>> '\b') & 15];
                            int i40 = i28 + 5;
                            cArr28[i28 + 4] = cArr29[(cCharAt2 >>> 4) & 15];
                            i28 += 6;
                            cArr28[i40] = cArr29[cCharAt2 & 15];
                        } else {
                            this.f71672a[i28] = cCharAt2;
                            i28++;
                        }
                    } else {
                        char[] cArr30 = this.f71672a;
                        int i41 = i28 + 1;
                        cArr30[i28] = '\\';
                        if (bArr4[cCharAt2] == 4) {
                            cArr30[i41] = 'u';
                            char[] cArr31 = com.alibaba.fastjson.util.f.f15556c;
                            cArr30[i28 + 2] = cArr31[(cCharAt2 >>> '\f') & 15];
                            cArr30[i28 + 3] = cArr31[(cCharAt2 >>> '\b') & 15];
                            int i42 = i28 + 5;
                            cArr30[i28 + 4] = cArr31[(cCharAt2 >>> 4) & 15];
                            i28 += 6;
                            cArr30[i42] = cArr31[cCharAt2 & 15];
                        } else {
                            i28 += 2;
                            cArr30[i41] = com.alibaba.fastjson.util.f.f15563j[cCharAt2];
                        }
                    }
                }
            }
        }
        if (c11 == 0) {
            this.f71672a[this.f71673b - 1] = '\"';
            return;
        }
        char[] cArr32 = this.f71672a;
        int i43 = this.f71673b;
        cArr32[i43 - 2] = '\"';
        cArr32[i43 - 1] = c11;
    }

    public void m(boolean z11) {
        if (z11) {
            write("true");
        } else {
            write("false");
        }
    }

    public void n(byte[] bArr) {
        if (j(SerializerFeature.WriteClassName.mask)) {
            Z(bArr);
            return;
        }
        int length = bArr.length;
        boolean z11 = this.f71676f;
        char c11 = z11 ? '\'' : '\"';
        if (length == 0) {
            write(z11 ? "''" : "\"\"");
            return;
        }
        char[] cArr = com.alibaba.fastjson.util.f.f15569p;
        int i11 = (length / 3) * 3;
        int i12 = length - 1;
        int i13 = this.f71673b;
        int i14 = (((i12 / 3) + 1) << 2) + i13;
        int i15 = i14 + 2;
        if (i15 > this.f71672a.length) {
            if (this.f71675d != null) {
                write(c11);
                int i16 = 0;
                while (i16 < i11) {
                    int i17 = i16 + 2;
                    int i18 = ((bArr[i16 + 1] & 255) << 8) | ((bArr[i16] & 255) << 16);
                    i16 += 3;
                    int i19 = i18 | (bArr[i17] & 255);
                    write(cArr[(i19 >>> 18) & 63]);
                    write(cArr[(i19 >>> 12) & 63]);
                    write(cArr[(i19 >>> 6) & 63]);
                    write(cArr[i19 & 63]);
                }
                int i21 = length - i11;
                if (i21 > 0) {
                    int i22 = ((bArr[i11] & 255) << 10) | (i21 == 2 ? (bArr[i12] & 255) << 2 : 0);
                    write(cArr[i22 >> 12]);
                    write(cArr[(i22 >>> 6) & 63]);
                    write(i21 == 2 ? cArr[i22 & 63] : '=');
                    write(61);
                }
                write(c11);
                return;
            }
            i(i15);
        }
        this.f71673b = i15;
        int i23 = i13 + 1;
        this.f71672a[i13] = c11;
        int i24 = 0;
        while (i24 < i11) {
            int i25 = i24 + 2;
            int i26 = ((bArr[i24 + 1] & 255) << 8) | ((bArr[i24] & 255) << 16);
            i24 += 3;
            int i27 = i26 | (bArr[i25] & 255);
            char[] cArr2 = this.f71672a;
            cArr2[i23] = cArr[(i27 >>> 18) & 63];
            cArr2[i23 + 1] = cArr[(i27 >>> 12) & 63];
            int i28 = i23 + 3;
            cArr2[i23 + 2] = cArr[(i27 >>> 6) & 63];
            i23 += 4;
            cArr2[i28] = cArr[i27 & 63];
        }
        int i29 = length - i11;
        if (i29 > 0) {
            int i31 = ((bArr[i11] & 255) << 10) | (i29 == 2 ? (bArr[i12] & 255) << 2 : 0);
            char[] cArr3 = this.f71672a;
            cArr3[i14 - 3] = cArr[i31 >> 12];
            cArr3[i14 - 2] = cArr[(i31 >>> 6) & 63];
            cArr3[i14 - 1] = i29 == 2 ? cArr[i31 & 63] : '=';
            cArr3[i14] = '=';
        }
        this.f71672a[i14 + 1] = c11;
    }

    public void o(double d11, boolean z11) {
        if (Double.isNaN(d11) || Double.isInfinite(d11)) {
            g0();
            return;
        }
        int i11 = this.f71673b + 24;
        if (i11 > this.f71672a.length) {
            if (this.f71675d != null) {
                String strB = com.alibaba.fastjson.util.j.b(d11);
                write(strB, 0, strB.length());
                if (z11 && k(SerializerFeature.WriteClassName)) {
                    write(68);
                    return;
                }
                return;
            }
            i(i11);
        }
        this.f71673b += com.alibaba.fastjson.util.j.a(d11, this.f71672a, this.f71673b);
        if (z11 && k(SerializerFeature.WriteClassName)) {
            write(68);
        }
    }

    public void p(Enum<?> r11) {
        String string;
        if (r11 == null) {
            g0();
            return;
        }
        if (!this.f71683m || this.f71684n) {
            string = this.f71684n ? r11.toString() : null;
        } else {
            string = r11.name();
        }
        if (string == null) {
            b0(r11.ordinal());
            return;
        }
        int i11 = k(SerializerFeature.UseSingleQuotes) ? 39 : 34;
        write(i11);
        write(string);
        write(i11);
    }

    public void p0(String str) {
        int i11 = 0;
        if (str == null) {
            int i12 = this.f71673b + 4;
            if (i12 > this.f71672a.length) {
                i(i12);
            }
            "null".getChars(0, 4, this.f71672a, this.f71673b);
            this.f71673b = i12;
            return;
        }
        int length = str.length();
        int i13 = this.f71673b + length + 2;
        if (i13 > this.f71672a.length) {
            if (this.f71675d != null) {
                write(39);
                while (i11 < str.length()) {
                    char cCharAt = str.charAt(i11);
                    if (cCharAt <= '\r' || cCharAt == '\\' || cCharAt == '\'' || (cCharAt == '/' && k(SerializerFeature.WriteSlashAsSpecial))) {
                        write(92);
                        write(com.alibaba.fastjson.util.f.f15563j[cCharAt]);
                    } else {
                        write(cCharAt);
                    }
                    i11++;
                }
                write(39);
                return;
            }
            i(i13);
        }
        int i14 = this.f71673b;
        int i15 = i14 + 1;
        int i16 = i15 + length;
        char[] cArr = this.f71672a;
        cArr[i14] = '\'';
        str.getChars(0, length, cArr, i15);
        this.f71673b = i13;
        char c11 = 0;
        int i17 = -1;
        for (int i18 = i15; i18 < i16; i18++) {
            char c12 = this.f71672a[i18];
            if (c12 <= '\r' || c12 == '\\' || c12 == '\'' || (c12 == '/' && k(SerializerFeature.WriteSlashAsSpecial))) {
                i11++;
                i17 = i18;
                c11 = c12;
            }
        }
        int i19 = i13 + i11;
        if (i19 > this.f71672a.length) {
            i(i19);
        }
        this.f71673b = i19;
        if (i11 == 1) {
            char[] cArr2 = this.f71672a;
            int i21 = i17 + 1;
            System.arraycopy(cArr2, i21, cArr2, i17 + 2, (i16 - i17) - 1);
            char[] cArr3 = this.f71672a;
            cArr3[i17] = '\\';
            cArr3[i21] = com.alibaba.fastjson.util.f.f15563j[c11];
        } else if (i11 > 1) {
            char[] cArr4 = this.f71672a;
            int i22 = i17 + 1;
            System.arraycopy(cArr4, i22, cArr4, i17 + 2, (i16 - i17) - 1);
            char[] cArr5 = this.f71672a;
            cArr5[i17] = '\\';
            cArr5[i22] = com.alibaba.fastjson.util.f.f15563j[c11];
            int i23 = i16 + 1;
            for (int i24 = i17 - 1; i24 >= i15; i24--) {
                char c13 = this.f71672a[i24];
                if (c13 <= '\r' || c13 == '\\' || c13 == '\'' || (c13 == '/' && k(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr6 = this.f71672a;
                    int i25 = i24 + 1;
                    System.arraycopy(cArr6, i25, cArr6, i24 + 2, (i23 - i24) - 1);
                    char[] cArr7 = this.f71672a;
                    cArr7[i24] = '\\';
                    cArr7[i25] = com.alibaba.fastjson.util.f.f15563j[c13];
                    i23++;
                }
            }
        }
        this.f71672a[this.f71673b - 1] = '\'';
    }

    public void q(String str) {
        r(str, false);
    }

    public void q0(char[] cArr) {
        int i11 = 0;
        if (cArr == null) {
            int i12 = this.f71673b + 4;
            if (i12 > this.f71672a.length) {
                i(i12);
            }
            "null".getChars(0, 4, this.f71672a, this.f71673b);
            this.f71673b = i12;
            return;
        }
        int length = cArr.length;
        int i13 = this.f71673b + length + 2;
        if (i13 > this.f71672a.length) {
            if (this.f71675d != null) {
                write(39);
                while (i11 < cArr.length) {
                    char c11 = cArr[i11];
                    if (c11 <= '\r' || c11 == '\\' || c11 == '\'' || (c11 == '/' && k(SerializerFeature.WriteSlashAsSpecial))) {
                        write(92);
                        write(com.alibaba.fastjson.util.f.f15563j[c11]);
                    } else {
                        write(c11);
                    }
                    i11++;
                }
                write(39);
                return;
            }
            i(i13);
        }
        int i14 = this.f71673b;
        int i15 = i14 + 1;
        int i16 = length + i15;
        char[] cArr2 = this.f71672a;
        cArr2[i14] = '\'';
        System.arraycopy(cArr, 0, cArr2, i15, cArr.length);
        this.f71673b = i13;
        char c12 = 0;
        int i17 = -1;
        for (int i18 = i15; i18 < i16; i18++) {
            char c13 = this.f71672a[i18];
            if (c13 <= '\r' || c13 == '\\' || c13 == '\'' || (c13 == '/' && k(SerializerFeature.WriteSlashAsSpecial))) {
                i11++;
                i17 = i18;
                c12 = c13;
            }
        }
        int i19 = i13 + i11;
        if (i19 > this.f71672a.length) {
            i(i19);
        }
        this.f71673b = i19;
        if (i11 == 1) {
            char[] cArr3 = this.f71672a;
            int i21 = i17 + 1;
            System.arraycopy(cArr3, i21, cArr3, i17 + 2, (i16 - i17) - 1);
            char[] cArr4 = this.f71672a;
            cArr4[i17] = '\\';
            cArr4[i21] = com.alibaba.fastjson.util.f.f15563j[c12];
        } else if (i11 > 1) {
            char[] cArr5 = this.f71672a;
            int i22 = i17 + 1;
            System.arraycopy(cArr5, i22, cArr5, i17 + 2, (i16 - i17) - 1);
            char[] cArr6 = this.f71672a;
            cArr6[i17] = '\\';
            cArr6[i22] = com.alibaba.fastjson.util.f.f15563j[c12];
            int i23 = i16 + 1;
            for (int i24 = i17 - 1; i24 >= i15; i24--) {
                char c14 = this.f71672a[i24];
                if (c14 <= '\r' || c14 == '\\' || c14 == '\'' || (c14 == '/' && k(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr7 = this.f71672a;
                    int i25 = i24 + 1;
                    System.arraycopy(cArr7, i25, cArr7, i24 + 2, (i23 - i24) - 1);
                    char[] cArr8 = this.f71672a;
                    cArr8[i24] = '\\';
                    cArr8[i25] = com.alibaba.fastjson.util.f.f15563j[c14];
                    i23++;
                }
            }
        }
        this.f71672a[this.f71673b - 1] = '\'';
    }

    public void r(String str, boolean z11) {
        if (str == null) {
            write("null:");
            return;
        }
        if (this.f71676f) {
            if (!this.f71677g) {
                d0(str);
                return;
            } else {
                p0(str);
                write(58);
                return;
            }
        }
        if (this.f71677g) {
            l0(str, ':');
            return;
        }
        boolean z12 = str.length() == 0;
        for (int i11 = 0; i11 < str.length(); i11++) {
            char cCharAt = str.charAt(i11);
            if ((cCharAt < '@' && (this.f71689s & (1 << cCharAt)) != 0) || cCharAt == '\\') {
                l0(str, ':');
            }
        }
        if (!z12) {
            write(str);
            write(58);
            return;
        }
        l0(str, ':');
    }

    public int s0(OutputStream outputStream, Charset charset) throws IOException {
        if (this.f71675d != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        if (charset == com.alibaba.fastjson.util.f.f15555b) {
            return g(outputStream);
        }
        byte[] bytes = new String(this.f71672a, 0, this.f71673b).getBytes(charset);
        outputStream.write(bytes);
        return bytes.length;
    }

    public void t(char c11, String str, double d11) {
        write(c11);
        q(str);
        o(d11, false);
    }

    public String toString() {
        return new String(this.f71672a, 0, this.f71673b);
    }

    public void u(char c11, String str, int i11) {
        if (i11 == Integer.MIN_VALUE || !this.f71677g) {
            write(c11);
            q(str);
            b0(i11);
            return;
        }
        int iO = i11 < 0 ? com.alibaba.fastjson.util.f.o(-i11) + 1 : com.alibaba.fastjson.util.f.o(i11);
        int length = str.length();
        int i12 = this.f71673b + length + 4 + iO;
        if (i12 > this.f71672a.length) {
            if (this.f71675d != null) {
                write(c11);
                q(str);
                b0(i11);
                return;
            }
            i(i12);
        }
        int i13 = this.f71673b;
        this.f71673b = i12;
        char[] cArr = this.f71672a;
        cArr[i13] = c11;
        int i14 = i13 + length;
        cArr[i13 + 1] = this.f71686p;
        str.getChars(0, length, cArr, i13 + 2);
        char[] cArr2 = this.f71672a;
        cArr2[i14 + 2] = this.f71686p;
        cArr2[i14 + 3] = ':';
        com.alibaba.fastjson.util.f.i(i11, this.f71673b, cArr2);
    }

    public void w(char c11, String str, long j11) {
        if (j11 == Long.MIN_VALUE || !this.f71677g || j(SerializerFeature.BrowserCompatible.mask)) {
            write(c11);
            q(str);
            e0(j11);
            return;
        }
        int iP = j11 < 0 ? com.alibaba.fastjson.util.f.p(-j11) + 1 : com.alibaba.fastjson.util.f.p(j11);
        int length = str.length();
        int i11 = this.f71673b + length + 4 + iP;
        if (i11 > this.f71672a.length) {
            if (this.f71675d != null) {
                write(c11);
                q(str);
                e0(j11);
                return;
            }
            i(i11);
        }
        int i12 = this.f71673b;
        this.f71673b = i11;
        char[] cArr = this.f71672a;
        cArr[i12] = c11;
        int i13 = i12 + length;
        cArr[i12 + 1] = this.f71686p;
        str.getChars(0, length, cArr, i12 + 2);
        char[] cArr2 = this.f71672a;
        cArr2[i13 + 2] = this.f71686p;
        cArr2[i13 + 3] = ':';
        com.alibaba.fastjson.util.f.j(j11, this.f71673b, cArr2);
    }

    @Override // java.io.Writer
    public void write(int i11) {
        int i12 = 1;
        int i13 = this.f71673b + 1;
        if (i13 <= this.f71672a.length) {
            i12 = i13;
        } else if (this.f71675d == null) {
            i(i13);
            i12 = i13;
        } else {
            flush();
        }
        this.f71672a[this.f71673b] = (char) i11;
        this.f71673b = i12;
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str == null) {
            g0();
        } else {
            write(str, 0, str.length());
        }
    }

    @Override // java.io.Writer
    public void write(String str, int i11, int i12) {
        int i13;
        int i14 = this.f71673b + i12;
        if (i14 > this.f71672a.length) {
            if (this.f71675d == null) {
                i(i14);
            } else {
                while (true) {
                    char[] cArr = this.f71672a;
                    int length = cArr.length;
                    int i15 = this.f71673b;
                    int i16 = length - i15;
                    i13 = i11 + i16;
                    str.getChars(i11, i13, cArr, i15);
                    this.f71673b = this.f71672a.length;
                    flush();
                    i12 -= i16;
                    if (i12 <= this.f71672a.length) {
                        break;
                    } else {
                        i11 = i13;
                    }
                }
                i14 = i12;
                i11 = i13;
            }
        }
        str.getChars(i11, i12 + i11, this.f71672a, this.f71673b);
        this.f71673b = i14;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i11, int i12) {
        int i13;
        if (i11 < 0 || i11 > cArr.length || i12 < 0 || (i13 = i11 + i12) > cArr.length || i13 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i12 == 0) {
            return;
        }
        int i14 = this.f71673b + i12;
        if (i14 > this.f71672a.length) {
            if (this.f71675d == null) {
                i(i14);
            } else {
                do {
                    char[] cArr2 = this.f71672a;
                    int length = cArr2.length;
                    int i15 = this.f71673b;
                    int i16 = length - i15;
                    System.arraycopy(cArr, i11, cArr2, i15, i16);
                    this.f71673b = this.f71672a.length;
                    flush();
                    i12 -= i16;
                    i11 += i16;
                } while (i12 > this.f71672a.length);
                i14 = i12;
            }
        }
        System.arraycopy(cArr, i11, this.f71672a, this.f71673b, i12);
        this.f71673b = i14;
    }

    public void x(char c11, String str, String str2) {
        if (!this.f71677g) {
            write(c11);
            q(str);
            if (str2 == null) {
                g0();
                return;
            } else {
                j0(str2);
                return;
            }
        }
        if (this.f71676f) {
            write(c11);
            q(str);
            if (str2 == null) {
                g0();
                return;
            } else {
                j0(str2);
                return;
            }
        }
        if (!k(SerializerFeature.BrowserCompatible)) {
            U(c11, str, str2);
            return;
        }
        write(c11);
        l0(str, ':');
        l0(str2, (char) 0);
    }

    public void y(char c11, String str, BigDecimal bigDecimal) {
        write(c11);
        q(str);
        if (bigDecimal == null) {
            g0();
        } else {
            int iScale = bigDecimal.scale();
            write((!k(SerializerFeature.WriteBigDecimalAsPlain) || iScale < -100 || iScale >= 100) ? bigDecimal.toString() : bigDecimal.toPlainString());
        }
    }
}
