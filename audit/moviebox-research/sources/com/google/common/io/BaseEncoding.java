package com.google.common.io;

import com.google.common.base.m;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseEncoding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BaseEncoding f38750a = new c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BaseEncoding f38751b = new c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BaseEncoding f38752c = new d("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final BaseEncoding f38753d = new d("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final BaseEncoding f38754e = new b("base16()", "0123456789ABCDEF");

    /* JADX INFO: compiled from: source.java */
    public static final class DecodingException extends IOException {
        public DecodingException(String str) {
            super(str);
        }

        public DecodingException(Throwable th2) {
            super(th2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f38755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final char[] f38756b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f38757c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f38758d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f38759e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f38760f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final byte[] f38761g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean[] f38762h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f38763i;

        public a(String str, char[] cArr) {
            this(str, cArr, b(cArr), false);
        }

        public a(String str, char[] cArr, byte[] bArr, boolean z11) {
            this.f38755a = (String) m.p(str);
            this.f38756b = (char[]) m.p(cArr);
            try {
                int iF = com.google.common.math.d.f(cArr.length, RoundingMode.UNNECESSARY);
                this.f38758d = iF;
                int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(iF);
                int i11 = 1 << (3 - iNumberOfTrailingZeros);
                this.f38759e = i11;
                this.f38760f = iF >> iNumberOfTrailingZeros;
                this.f38757c = cArr.length - 1;
                this.f38761g = bArr;
                boolean[] zArr = new boolean[i11];
                for (int i12 = 0; i12 < this.f38760f; i12++) {
                    zArr[com.google.common.math.d.c(i12 * 8, this.f38758d, RoundingMode.CEILING)] = true;
                }
                this.f38762h = zArr;
                this.f38763i = z11;
            } catch (ArithmeticException e11) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e11);
            }
        }

        public static byte[] b(char[] cArr) {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i11 = 0; i11 < cArr.length; i11++) {
                char c11 = cArr[i11];
                boolean z11 = true;
                m.f(c11 < 128, "Non-ASCII character: %s", c11);
                if (bArr[c11] != -1) {
                    z11 = false;
                }
                m.f(z11, "Duplicate character: %s", c11);
                bArr[c11] = (byte) i11;
            }
            return bArr;
        }

        public int c(char c11) throws DecodingException {
            if (c11 > 127) {
                throw new DecodingException("Unrecognized character: 0x" + Integer.toHexString(c11));
            }
            byte b11 = this.f38761g[c11];
            if (b11 != -1) {
                return b11;
            }
            if (c11 <= ' ' || c11 == 127) {
                throw new DecodingException("Unrecognized character: 0x" + Integer.toHexString(c11));
            }
            throw new DecodingException("Unrecognized character: " + c11);
        }

        public char d(int i11) {
            return this.f38756b[i11];
        }

        public boolean e(int i11) {
            return this.f38762h[i11 % this.f38759e];
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f38763i == aVar.f38763i && Arrays.equals(this.f38756b, aVar.f38756b);
        }

        public boolean f(char c11) {
            byte[] bArr = this.f38761g;
            return c11 < bArr.length && bArr[c11] != -1;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f38756b) + (this.f38763i ? 1231 : 1237);
        }

        public String toString() {
            return this.f38755a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends d {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final char[] f38764h;

        public b(a aVar) {
            super(aVar, null);
            this.f38764h = new char[512];
            m.d(aVar.f38756b.length == 16);
            for (int i11 = 0; i11 < 256; i11++) {
                this.f38764h[i11] = aVar.d(i11 >>> 4);
                this.f38764h[i11 | 256] = aVar.d(i11 & 15);
            }
        }

        public b(String str, String str2) {
            this(new a(str, str2.toCharArray()));
        }

        @Override // com.google.common.io.BaseEncoding.d, com.google.common.io.BaseEncoding
        public int e(byte[] bArr, CharSequence charSequence) throws DecodingException {
            m.p(bArr);
            if (charSequence.length() % 2 == 1) {
                throw new DecodingException("Invalid input length " + charSequence.length());
            }
            int i11 = 0;
            int i12 = 0;
            while (i11 < charSequence.length()) {
                bArr[i12] = (byte) ((this.f38765f.c(charSequence.charAt(i11)) << 4) | this.f38765f.c(charSequence.charAt(i11 + 1)));
                i11 += 2;
                i12++;
            }
            return i12;
        }

        @Override // com.google.common.io.BaseEncoding.d, com.google.common.io.BaseEncoding
        public void h(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException {
            m.p(appendable);
            m.u(i11, i11 + i12, bArr.length);
            for (int i13 = 0; i13 < i12; i13++) {
                int i14 = bArr[i11 + i13] & 255;
                appendable.append(this.f38764h[i14]);
                appendable.append(this.f38764h[i14 | 256]);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends d {
        public c(a aVar, Character ch2) {
            super(aVar, ch2);
            m.d(aVar.f38756b.length == 64);
        }

        public c(String str, String str2, Character ch2) {
            this(new a(str, str2.toCharArray()), ch2);
        }

        @Override // com.google.common.io.BaseEncoding.d, com.google.common.io.BaseEncoding
        public int e(byte[] bArr, CharSequence charSequence) throws DecodingException {
            m.p(bArr);
            CharSequence charSequenceL = l(charSequence);
            if (!this.f38765f.e(charSequenceL.length())) {
                throw new DecodingException("Invalid input length " + charSequenceL.length());
            }
            int i11 = 0;
            int i12 = 0;
            while (i11 < charSequenceL.length()) {
                int i13 = i11 + 2;
                int iC = (this.f38765f.c(charSequenceL.charAt(i11)) << 18) | (this.f38765f.c(charSequenceL.charAt(i11 + 1)) << 12);
                int i14 = i12 + 1;
                bArr[i12] = (byte) (iC >>> 16);
                if (i13 < charSequenceL.length()) {
                    int i15 = i11 + 3;
                    int iC2 = iC | (this.f38765f.c(charSequenceL.charAt(i13)) << 6);
                    int i16 = i12 + 2;
                    bArr[i14] = (byte) ((iC2 >>> 8) & 255);
                    if (i15 < charSequenceL.length()) {
                        i11 += 4;
                        i12 += 3;
                        bArr[i16] = (byte) ((iC2 | this.f38765f.c(charSequenceL.charAt(i15))) & 255);
                    } else {
                        i12 = i16;
                        i11 = i15;
                    }
                } else {
                    i12 = i14;
                    i11 = i13;
                }
            }
            return i12;
        }

        @Override // com.google.common.io.BaseEncoding.d, com.google.common.io.BaseEncoding
        public void h(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException {
            m.p(appendable);
            int i13 = i11 + i12;
            m.u(i11, i13, bArr.length);
            while (i12 >= 3) {
                int i14 = i11 + 2;
                int i15 = ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11] & 255) << 16);
                i11 += 3;
                int i16 = i15 | (bArr[i14] & 255);
                appendable.append(this.f38765f.d(i16 >>> 18));
                appendable.append(this.f38765f.d((i16 >>> 12) & 63));
                appendable.append(this.f38765f.d((i16 >>> 6) & 63));
                appendable.append(this.f38765f.d(i16 & 63));
                i12 -= 3;
            }
            if (i11 < i13) {
                m(appendable, bArr, i11, i13 - i11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d extends BaseEncoding {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final a f38765f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Character f38766g;

        public d(a aVar, Character ch2) {
            this.f38765f = (a) m.p(aVar);
            m.k(ch2 == null || !aVar.f(ch2.charValue()), "Padding character %s was already in alphabet", ch2);
            this.f38766g = ch2;
        }

        public d(String str, String str2, Character ch2) {
            this(new a(str, str2.toCharArray()), ch2);
        }

        @Override // com.google.common.io.BaseEncoding
        public int e(byte[] bArr, CharSequence charSequence) throws DecodingException {
            a aVar;
            m.p(bArr);
            CharSequence charSequenceL = l(charSequence);
            if (!this.f38765f.e(charSequenceL.length())) {
                throw new DecodingException("Invalid input length " + charSequenceL.length());
            }
            int i11 = 0;
            int i12 = 0;
            while (i11 < charSequenceL.length()) {
                long jC = 0;
                int i13 = 0;
                int i14 = 0;
                while (true) {
                    aVar = this.f38765f;
                    if (i13 >= aVar.f38759e) {
                        break;
                    }
                    jC <<= aVar.f38758d;
                    if (i11 + i13 < charSequenceL.length()) {
                        jC |= (long) this.f38765f.c(charSequenceL.charAt(i14 + i11));
                        i14++;
                    }
                    i13++;
                }
                int i15 = aVar.f38760f;
                int i16 = (i15 * 8) - (i14 * aVar.f38758d);
                int i17 = (i15 - 1) * 8;
                while (i17 >= i16) {
                    bArr[i12] = (byte) ((jC >>> i17) & 255);
                    i17 -= 8;
                    i12++;
                }
                i11 += this.f38765f.f38759e;
            }
            return i12;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f38765f.equals(dVar.f38765f) && Objects.equals(this.f38766g, dVar.f38766g);
        }

        @Override // com.google.common.io.BaseEncoding
        public void h(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException {
            m.p(appendable);
            m.u(i11, i11 + i12, bArr.length);
            int i13 = 0;
            while (i13 < i12) {
                m(appendable, bArr, i11 + i13, Math.min(this.f38765f.f38760f, i12 - i13));
                i13 += this.f38765f.f38760f;
            }
        }

        public int hashCode() {
            return this.f38765f.hashCode() ^ Objects.hashCode(this.f38766g);
        }

        @Override // com.google.common.io.BaseEncoding
        public int j(int i11) {
            return (int) (((((long) this.f38765f.f38758d) * ((long) i11)) + 7) / 8);
        }

        @Override // com.google.common.io.BaseEncoding
        public int k(int i11) {
            a aVar = this.f38765f;
            return aVar.f38759e * com.google.common.math.d.c(i11, aVar.f38760f, RoundingMode.CEILING);
        }

        @Override // com.google.common.io.BaseEncoding
        public CharSequence l(CharSequence charSequence) {
            m.p(charSequence);
            Character ch2 = this.f38766g;
            if (ch2 == null) {
                return charSequence;
            }
            char cCharValue = ch2.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == cCharValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }

        public void m(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException {
            m.p(appendable);
            m.u(i11, i11 + i12, bArr.length);
            int i13 = 0;
            m.d(i12 <= this.f38765f.f38760f);
            long j11 = 0;
            for (int i14 = 0; i14 < i12; i14++) {
                j11 = (j11 | ((long) (bArr[i11 + i14] & 255))) << 8;
            }
            int i15 = ((i12 + 1) * 8) - this.f38765f.f38758d;
            while (i13 < i12 * 8) {
                a aVar = this.f38765f;
                appendable.append(aVar.d(((int) (j11 >>> (i15 - i13))) & aVar.f38757c));
                i13 += this.f38765f.f38758d;
            }
            if (this.f38766g != null) {
                while (i13 < this.f38765f.f38760f * 8) {
                    appendable.append(this.f38766g.charValue());
                    i13 += this.f38765f.f38758d;
                }
            }
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("BaseEncoding.");
            sb2.append(this.f38765f);
            if (8 % this.f38765f.f38758d != 0) {
                if (this.f38766g == null) {
                    sb2.append(".omitPadding()");
                } else {
                    sb2.append(".withPadChar('");
                    sb2.append(this.f38766g);
                    sb2.append("')");
                }
            }
            return sb2.toString();
        }
    }

    public static BaseEncoding a() {
        return f38750a;
    }

    public static BaseEncoding b() {
        return f38751b;
    }

    public static byte[] i(byte[] bArr, int i11) {
        if (i11 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, 0, bArr2, 0, i11);
        return bArr2;
    }

    public final byte[] c(CharSequence charSequence) {
        try {
            return d(charSequence);
        } catch (DecodingException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public final byte[] d(CharSequence charSequence) throws DecodingException {
        CharSequence charSequenceL = l(charSequence);
        byte[] bArr = new byte[j(charSequenceL.length())];
        return i(bArr, e(bArr, charSequenceL));
    }

    public abstract int e(byte[] bArr, CharSequence charSequence) throws DecodingException;

    public String f(byte[] bArr) {
        return g(bArr, 0, bArr.length);
    }

    public final String g(byte[] bArr, int i11, int i12) {
        m.u(i11, i11 + i12, bArr.length);
        StringBuilder sb2 = new StringBuilder(k(i12));
        try {
            h(sb2, bArr, i11, i12);
            return sb2.toString();
        } catch (IOException e11) {
            throw new AssertionError(e11);
        }
    }

    public abstract void h(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException;

    public abstract int j(int i11);

    public abstract int k(int i11);

    public abstract CharSequence l(CharSequence charSequence);
}
