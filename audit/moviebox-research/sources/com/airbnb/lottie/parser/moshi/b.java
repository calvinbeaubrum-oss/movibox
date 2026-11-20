package com.airbnb.lottie.parser.moshi;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.internal.BufferKt;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends JsonReader {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ByteString f15302o = ByteString.encodeUtf8("'\\");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ByteString f15303p = ByteString.encodeUtf8("\"\\");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ByteString f15304q = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ByteString f15305r = ByteString.encodeUtf8("\n\r");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ByteString f15306s = ByteString.encodeUtf8("*/");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BufferedSource f15307i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Buffer f15308j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f15309k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f15310l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f15311m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public String f15312n;

    public b(BufferedSource bufferedSource) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        this.f15307i = bufferedSource;
        this.f15308j = bufferedSource.buffer();
        o(6);
    }

    public final boolean U(int i11) throws IOException {
        if (i11 == 9 || i11 == 10 || i11 == 12 || i11 == 13 || i11 == 32) {
            return false;
        }
        if (i11 != 35) {
            if (i11 == 44) {
                return false;
            }
            if (i11 != 47 && i11 != 61) {
                if (i11 == 123 || i11 == 125 || i11 == 58) {
                    return false;
                }
                if (i11 != 59) {
                    switch (i11) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        w();
        return false;
    }

    public final int W(boolean z11) throws IOException {
        int i11;
        byte b11;
        while (true) {
            while (true) {
                int i12 = i11 + 1;
                if (!this.f15307i.request(i12)) {
                    if (z11) {
                        throw new EOFException("End of input");
                    }
                    return -1;
                }
                b11 = this.f15308j.getByte(i11);
                i11 = (b11 == 10 || b11 == 32 || b11 == 13 || b11 == 9) ? i12 : 0;
            }
            this.f15308j.skip(i11);
            if (b11 == 47) {
                if (!this.f15307i.request(2L)) {
                    return b11;
                }
                w();
                byte b12 = this.f15308j.getByte(1L);
                if (b12 == 42) {
                    this.f15308j.readByte();
                    this.f15308j.readByte();
                    if (!i0()) {
                        throw u("Unterminated comment");
                    }
                } else {
                    if (b12 != 47) {
                        return b11;
                    }
                    this.f15308j.readByte();
                    this.f15308j.readByte();
                    j0();
                }
            } else {
                if (b11 != 35) {
                    return b11;
                }
                w();
                j0();
            }
        }
    }

    public final String Z(ByteString byteString) throws IOException {
        StringBuilder sb2 = null;
        while (true) {
            long jIndexOfElement = this.f15307i.indexOfElement(byteString);
            if (jIndexOfElement == -1) {
                throw u("Unterminated string");
            }
            if (this.f15308j.getByte(jIndexOfElement) != 92) {
                if (sb2 == null) {
                    String utf8 = this.f15308j.readUtf8(jIndexOfElement);
                    this.f15308j.readByte();
                    return utf8;
                }
                sb2.append(this.f15308j.readUtf8(jIndexOfElement));
                this.f15308j.readByte();
                return sb2.toString();
            }
            if (sb2 == null) {
                sb2 = new StringBuilder();
            }
            sb2.append(this.f15308j.readUtf8(jIndexOfElement));
            this.f15308j.readByte();
            sb2.append(g0());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void b() throws IOException {
        int iX = this.f15309k;
        if (iX == 0) {
            iX = x();
        }
        if (iX == 3) {
            o(1);
            this.f15297d[this.f15294a - 1] = 0;
            this.f15309k = 0;
        } else {
            throw new JsonDataException("Expected BEGIN_ARRAY but was " + n() + " at path " + getPath());
        }
    }

    public final String b0() throws IOException {
        long jIndexOfElement = this.f15307i.indexOfElement(f15304q);
        return jIndexOfElement != -1 ? this.f15308j.readUtf8(jIndexOfElement) : this.f15308j.readUtf8();
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void c() throws IOException {
        int iX = this.f15309k;
        if (iX == 0) {
            iX = x();
        }
        if (iX == 1) {
            o(3);
            this.f15309k = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + n() + " at path " + getPath());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f15309k = 0;
        this.f15295b[0] = 8;
        this.f15294a = 1;
        this.f15308j.clear();
        this.f15307i.close();
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void d() throws IOException {
        int iX = this.f15309k;
        if (iX == 0) {
            iX = x();
        }
        if (iX != 4) {
            throw new JsonDataException("Expected END_ARRAY but was " + n() + " at path " + getPath());
        }
        int i11 = this.f15294a;
        this.f15294a = i11 - 1;
        int[] iArr = this.f15297d;
        int i12 = i11 - 2;
        iArr[i12] = iArr[i12] + 1;
        this.f15309k = 0;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final int d0() throws IOException {
        String str;
        String str2;
        int i11;
        byte b11 = this.f15308j.getByte(0L);
        if (b11 == 116 || b11 == 84) {
            str = "true";
            str2 = "TRUE";
            i11 = 5;
        } else if (b11 == 102 || b11 == 70) {
            str = "false";
            str2 = "FALSE";
            i11 = 6;
        } else {
            if (b11 != 110 && b11 != 78) {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i11 = 7;
        }
        int length = str.length();
        int i12 = 1;
        while (i12 < length) {
            int i13 = i12 + 1;
            if (!this.f15307i.request(i13)) {
                return 0;
            }
            byte b12 = this.f15308j.getByte(i12);
            if (b12 != str.charAt(i12) && b12 != str2.charAt(i12)) {
                return 0;
            }
            i12 = i13;
        }
        if (this.f15307i.request(length + 1) && U(this.f15308j.getByte(length))) {
            return 0;
        }
        this.f15308j.skip(length);
        this.f15309k = i11;
        return i11;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void e() throws IOException {
        int iX = this.f15309k;
        if (iX == 0) {
            iX = x();
        }
        if (iX != 2) {
            throw new JsonDataException("Expected END_OBJECT but was " + n() + " at path " + getPath());
        }
        int i11 = this.f15294a;
        int i12 = i11 - 1;
        this.f15294a = i12;
        this.f15296c[i12] = null;
        int[] iArr = this.f15297d;
        int i13 = i11 - 2;
        iArr[i13] = iArr[i13] + 1;
        this.f15309k = 0;
    }

    public final int e0() throws IOException {
        boolean z11 = true;
        long j11 = 0;
        int i11 = 0;
        char c11 = 0;
        boolean z12 = true;
        boolean z13 = false;
        while (true) {
            int i12 = i11 + 1;
            if (!this.f15307i.request(i12)) {
                break;
            }
            byte b11 = this.f15308j.getByte(i11);
            if (b11 != 43) {
                if (b11 == 69 || b11 == 101) {
                    if (c11 != 2 && c11 != 4) {
                        return 0;
                    }
                    c11 = 5;
                } else if (b11 != 45) {
                    if (b11 != 46) {
                        if (b11 < 48 || b11 > 57) {
                            if (!U(b11)) {
                                break;
                            }
                            return 0;
                        }
                        if (c11 == z11 || c11 == 0) {
                            j11 = -(b11 - 48);
                            c11 = 2;
                        } else if (c11 == 2) {
                            if (j11 == 0) {
                                return 0;
                            }
                            long j12 = (10 * j11) - ((long) (b11 - 48));
                            z12 &= j11 > BufferKt.OVERFLOW_ZONE || (j11 == BufferKt.OVERFLOW_ZONE && j12 < j11);
                            j11 = j12;
                        } else if (c11 == 3) {
                            c11 = 4;
                        } else if (c11 == 5 || c11 == 6) {
                            c11 = 7;
                        }
                    } else {
                        if (c11 != 2) {
                            return 0;
                        }
                        c11 = 3;
                    }
                } else if (c11 == 0) {
                    c11 = 1;
                    z13 = true;
                } else if (c11 != 5) {
                    return 0;
                }
                i11 = i12;
                z11 = true;
            } else if (c11 != 5) {
                return 0;
            }
            c11 = 6;
            i11 = i12;
            z11 = true;
        }
        if (c11 == 2 && z12 && ((j11 != Long.MIN_VALUE || z13) && (j11 != 0 || !z13))) {
            if (!z13) {
                j11 = -j11;
            }
            this.f15310l = j11;
            this.f15308j.skip(i11);
            this.f15309k = 16;
            return 16;
        }
        if (c11 != 2 && c11 != 4 && c11 != 7) {
            return 0;
        }
        this.f15311m = i11;
        this.f15309k = 17;
        return 17;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean g() throws IOException {
        int iX = this.f15309k;
        if (iX == 0) {
            iX = x();
        }
        return (iX == 2 || iX == 4 || iX == 18) ? false : true;
    }

    public final char g0() throws IOException {
        int i11;
        if (!this.f15307i.request(1L)) {
            throw u("Unterminated escape sequence");
        }
        byte b11 = this.f15308j.readByte();
        if (b11 == 10 || b11 == 34 || b11 == 39 || b11 == 47 || b11 == 92) {
            return (char) b11;
        }
        if (b11 == 98) {
            return '\b';
        }
        if (b11 == 102) {
            return '\f';
        }
        if (b11 == 110) {
            return '\n';
        }
        if (b11 == 114) {
            return '\r';
        }
        if (b11 == 116) {
            return '\t';
        }
        if (b11 != 117) {
            if (this.f15298f) {
                return (char) b11;
            }
            throw u("Invalid escape sequence: \\" + ((char) b11));
        }
        if (!this.f15307i.request(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + getPath());
        }
        char c11 = 0;
        for (int i12 = 0; i12 < 4; i12++) {
            byte b12 = this.f15308j.getByte(i12);
            char c12 = (char) (c11 << 4);
            if (b12 >= 48 && b12 <= 57) {
                i11 = b12 - 48;
            } else if (b12 >= 97 && b12 <= 102) {
                i11 = b12 - 87;
            } else {
                if (b12 < 65 || b12 > 70) {
                    throw u("\\u" + this.f15308j.readUtf8(4L));
                }
                i11 = b12 - 55;
            }
            c11 = (char) (c12 + i11);
        }
        this.f15308j.skip(4L);
        return c11;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean h() throws IOException {
        int iX = this.f15309k;
        if (iX == 0) {
            iX = x();
        }
        if (iX == 5) {
            this.f15309k = 0;
            int[] iArr = this.f15297d;
            int i11 = this.f15294a - 1;
            iArr[i11] = iArr[i11] + 1;
            return true;
        }
        if (iX == 6) {
            this.f15309k = 0;
            int[] iArr2 = this.f15297d;
            int i12 = this.f15294a - 1;
            iArr2[i12] = iArr2[i12] + 1;
            return false;
        }
        throw new JsonDataException("Expected a boolean but was " + n() + " at path " + getPath());
    }

    public final void h0(ByteString byteString) throws IOException {
        while (true) {
            long jIndexOfElement = this.f15307i.indexOfElement(byteString);
            if (jIndexOfElement == -1) {
                throw u("Unterminated string");
            }
            if (this.f15308j.getByte(jIndexOfElement) != 92) {
                this.f15308j.skip(jIndexOfElement + 1);
                return;
            } else {
                this.f15308j.skip(jIndexOfElement + 1);
                g0();
            }
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public double i() throws IOException {
        int iX = this.f15309k;
        if (iX == 0) {
            iX = x();
        }
        if (iX == 16) {
            this.f15309k = 0;
            int[] iArr = this.f15297d;
            int i11 = this.f15294a - 1;
            iArr[i11] = iArr[i11] + 1;
            return this.f15310l;
        }
        if (iX == 17) {
            this.f15312n = this.f15308j.readUtf8(this.f15311m);
        } else if (iX == 9) {
            this.f15312n = Z(f15303p);
        } else if (iX == 8) {
            this.f15312n = Z(f15302o);
        } else if (iX == 10) {
            this.f15312n = b0();
        } else if (iX != 11) {
            throw new JsonDataException("Expected a double but was " + n() + " at path " + getPath());
        }
        this.f15309k = 11;
        try {
            double d11 = Double.parseDouble(this.f15312n);
            if (this.f15298f || !(Double.isNaN(d11) || Double.isInfinite(d11))) {
                this.f15312n = null;
                this.f15309k = 0;
                int[] iArr2 = this.f15297d;
                int i12 = this.f15294a - 1;
                iArr2[i12] = iArr2[i12] + 1;
                return d11;
            }
            throw new JsonEncodingException("JSON forbids NaN and infinities: " + d11 + " at path " + getPath());
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.f15312n + " at path " + getPath());
        }
    }

    public final boolean i0() throws IOException {
        BufferedSource bufferedSource = this.f15307i;
        ByteString byteString = f15306s;
        long jIndexOf = bufferedSource.indexOf(byteString);
        boolean z11 = jIndexOf != -1;
        Buffer buffer = this.f15308j;
        buffer.skip(z11 ? jIndexOf + ((long) byteString.size()) : buffer.size());
        return z11;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int j() throws IOException {
        int iX = this.f15309k;
        if (iX == 0) {
            iX = x();
        }
        if (iX == 16) {
            long j11 = this.f15310l;
            int i11 = (int) j11;
            if (j11 == i11) {
                this.f15309k = 0;
                int[] iArr = this.f15297d;
                int i12 = this.f15294a - 1;
                iArr[i12] = iArr[i12] + 1;
                return i11;
            }
            throw new JsonDataException("Expected an int but was " + this.f15310l + " at path " + getPath());
        }
        if (iX == 17) {
            this.f15312n = this.f15308j.readUtf8(this.f15311m);
        } else if (iX == 9 || iX == 8) {
            String strZ = iX == 9 ? Z(f15303p) : Z(f15302o);
            this.f15312n = strZ;
            try {
                int i13 = Integer.parseInt(strZ);
                this.f15309k = 0;
                int[] iArr2 = this.f15297d;
                int i14 = this.f15294a - 1;
                iArr2[i14] = iArr2[i14] + 1;
                return i13;
            } catch (NumberFormatException unused) {
            }
        } else if (iX != 11) {
            throw new JsonDataException("Expected an int but was " + n() + " at path " + getPath());
        }
        this.f15309k = 11;
        try {
            double d11 = Double.parseDouble(this.f15312n);
            int i15 = (int) d11;
            if (i15 == d11) {
                this.f15312n = null;
                this.f15309k = 0;
                int[] iArr3 = this.f15297d;
                int i16 = this.f15294a - 1;
                iArr3[i16] = iArr3[i16] + 1;
                return i15;
            }
            throw new JsonDataException("Expected an int but was " + this.f15312n + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.f15312n + " at path " + getPath());
        }
    }

    public final void j0() throws IOException {
        long jIndexOfElement = this.f15307i.indexOfElement(f15305r);
        Buffer buffer = this.f15308j;
        buffer.skip(jIndexOfElement != -1 ? jIndexOfElement + 1 : buffer.size());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String k() throws IOException {
        String strZ;
        int iX = this.f15309k;
        if (iX == 0) {
            iX = x();
        }
        if (iX == 14) {
            strZ = b0();
        } else if (iX == 13) {
            strZ = Z(f15303p);
        } else if (iX == 12) {
            strZ = Z(f15302o);
        } else {
            if (iX != 15) {
                throw new JsonDataException("Expected a name but was " + n() + " at path " + getPath());
            }
            strZ = this.f15312n;
        }
        this.f15309k = 0;
        this.f15296c[this.f15294a - 1] = strZ;
        return strZ;
    }

    public final void k0() throws IOException {
        long jIndexOfElement = this.f15307i.indexOfElement(f15304q);
        Buffer buffer = this.f15308j;
        if (jIndexOfElement == -1) {
            jIndexOfElement = buffer.size();
        }
        buffer.skip(jIndexOfElement);
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String l() throws IOException {
        String utf8;
        int iX = this.f15309k;
        if (iX == 0) {
            iX = x();
        }
        if (iX == 10) {
            utf8 = b0();
        } else if (iX == 9) {
            utf8 = Z(f15303p);
        } else if (iX == 8) {
            utf8 = Z(f15302o);
        } else if (iX == 11) {
            utf8 = this.f15312n;
            this.f15312n = null;
        } else if (iX == 16) {
            utf8 = Long.toString(this.f15310l);
        } else {
            if (iX != 17) {
                throw new JsonDataException("Expected a string but was " + n() + " at path " + getPath());
            }
            utf8 = this.f15308j.readUtf8(this.f15311m);
        }
        this.f15309k = 0;
        int[] iArr = this.f15297d;
        int i11 = this.f15294a - 1;
        iArr[i11] = iArr[i11] + 1;
        return utf8;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public JsonReader.Token n() throws IOException {
        int iX = this.f15309k;
        if (iX == 0) {
            iX = x();
        }
        switch (iX) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int p(JsonReader.a aVar) throws IOException {
        int iX = this.f15309k;
        if (iX == 0) {
            iX = x();
        }
        if (iX < 12 || iX > 15) {
            return -1;
        }
        if (iX == 15) {
            return y(this.f15312n, aVar);
        }
        int iSelect = this.f15307i.select(aVar.f15301b);
        if (iSelect != -1) {
            this.f15309k = 0;
            this.f15296c[this.f15294a - 1] = aVar.f15300a[iSelect];
            return iSelect;
        }
        String str = this.f15296c[this.f15294a - 1];
        String strK = k();
        int iY = y(strK, aVar);
        if (iY == -1) {
            this.f15309k = 15;
            this.f15312n = strK;
            this.f15296c[this.f15294a - 1] = str;
        }
        return iY;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void q() throws IOException {
        if (this.f15299g) {
            throw new JsonDataException("Cannot skip unexpected " + n() + " at " + getPath());
        }
        int iX = this.f15309k;
        if (iX == 0) {
            iX = x();
        }
        if (iX == 14) {
            k0();
        } else if (iX == 13) {
            h0(f15303p);
        } else if (iX == 12) {
            h0(f15302o);
        } else if (iX != 15) {
            throw new JsonDataException("Expected a name but was " + n() + " at path " + getPath());
        }
        this.f15309k = 0;
        this.f15296c[this.f15294a - 1] = "null";
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void r() throws IOException {
        if (this.f15299g) {
            throw new JsonDataException("Cannot skip unexpected " + n() + " at " + getPath());
        }
        int i11 = 0;
        do {
            int iX = this.f15309k;
            if (iX == 0) {
                iX = x();
            }
            if (iX == 3) {
                o(1);
            } else {
                if (iX == 1) {
                    o(3);
                } else if (iX == 4) {
                    i11--;
                    if (i11 < 0) {
                        throw new JsonDataException("Expected a value but was " + n() + " at path " + getPath());
                    }
                    this.f15294a--;
                } else if (iX == 2) {
                    i11--;
                    if (i11 < 0) {
                        throw new JsonDataException("Expected a value but was " + n() + " at path " + getPath());
                    }
                    this.f15294a--;
                } else if (iX == 14 || iX == 10) {
                    k0();
                } else if (iX == 9 || iX == 13) {
                    h0(f15303p);
                } else if (iX == 8 || iX == 12) {
                    h0(f15302o);
                } else if (iX == 17) {
                    this.f15308j.skip(this.f15311m);
                } else if (iX == 18) {
                    throw new JsonDataException("Expected a value but was " + n() + " at path " + getPath());
                }
                this.f15309k = 0;
            }
            i11++;
            this.f15309k = 0;
        } while (i11 != 0);
        int[] iArr = this.f15297d;
        int i12 = this.f15294a;
        int i13 = i12 - 1;
        iArr[i13] = iArr[i13] + 1;
        this.f15296c[i12 - 1] = "null";
    }

    public String toString() {
        return "JsonReader(" + this.f15307i + ")";
    }

    public final void w() throws IOException {
        if (!this.f15298f) {
            throw u("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    public final int x() throws IOException {
        int[] iArr = this.f15295b;
        int i11 = this.f15294a;
        int i12 = iArr[i11 - 1];
        if (i12 == 1) {
            iArr[i11 - 1] = 2;
        } else if (i12 == 2) {
            int iW = W(true);
            this.f15308j.readByte();
            if (iW != 44) {
                if (iW != 59) {
                    if (iW != 93) {
                        throw u("Unterminated array");
                    }
                    this.f15309k = 4;
                    return 4;
                }
                w();
            }
        } else {
            if (i12 == 3 || i12 == 5) {
                iArr[i11 - 1] = 4;
                if (i12 == 5) {
                    int iW2 = W(true);
                    this.f15308j.readByte();
                    if (iW2 != 44) {
                        if (iW2 != 59) {
                            if (iW2 != 125) {
                                throw u("Unterminated object");
                            }
                            this.f15309k = 2;
                            return 2;
                        }
                        w();
                    }
                }
                int iW3 = W(true);
                if (iW3 == 34) {
                    this.f15308j.readByte();
                    this.f15309k = 13;
                    return 13;
                }
                if (iW3 == 39) {
                    this.f15308j.readByte();
                    w();
                    this.f15309k = 12;
                    return 12;
                }
                if (iW3 != 125) {
                    w();
                    if (!U((char) iW3)) {
                        throw u("Expected name");
                    }
                    this.f15309k = 14;
                    return 14;
                }
                if (i12 == 5) {
                    throw u("Expected name");
                }
                this.f15308j.readByte();
                this.f15309k = 2;
                return 2;
            }
            if (i12 == 4) {
                iArr[i11 - 1] = 5;
                int iW4 = W(true);
                this.f15308j.readByte();
                if (iW4 != 58) {
                    if (iW4 != 61) {
                        throw u("Expected ':'");
                    }
                    w();
                    if (this.f15307i.request(1L) && this.f15308j.getByte(0L) == 62) {
                        this.f15308j.readByte();
                    }
                }
            } else if (i12 == 6) {
                iArr[i11 - 1] = 7;
            } else if (i12 == 7) {
                if (W(false) == -1) {
                    this.f15309k = 18;
                    return 18;
                }
                w();
            } else if (i12 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iW5 = W(true);
        if (iW5 == 34) {
            this.f15308j.readByte();
            this.f15309k = 9;
            return 9;
        }
        if (iW5 == 39) {
            w();
            this.f15308j.readByte();
            this.f15309k = 8;
            return 8;
        }
        if (iW5 != 44 && iW5 != 59) {
            if (iW5 == 91) {
                this.f15308j.readByte();
                this.f15309k = 3;
                return 3;
            }
            if (iW5 != 93) {
                if (iW5 == 123) {
                    this.f15308j.readByte();
                    this.f15309k = 1;
                    return 1;
                }
                int iD0 = d0();
                if (iD0 != 0) {
                    return iD0;
                }
                int iE0 = e0();
                if (iE0 != 0) {
                    return iE0;
                }
                if (!U(this.f15308j.getByte(0L))) {
                    throw u("Expected value");
                }
                w();
                this.f15309k = 10;
                return 10;
            }
            if (i12 == 1) {
                this.f15308j.readByte();
                this.f15309k = 4;
                return 4;
            }
        }
        if (i12 != 1 && i12 != 2) {
            throw u("Unexpected value");
        }
        w();
        this.f15309k = 7;
        return 7;
    }

    public final int y(String str, JsonReader.a aVar) {
        int length = aVar.f15300a.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (str.equals(aVar.f15300a[i11])) {
                this.f15309k = 0;
                this.f15296c[this.f15294a - 1] = str;
                return i11;
            }
        }
        return -1;
    }
}
