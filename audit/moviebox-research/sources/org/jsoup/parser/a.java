package org.jsoup.parser;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Locale;
import org.jsoup.UncheckedIOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char[] f73145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Reader f73146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f73147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f73148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f73149e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f73150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f73151g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String[] f73152h;

    public a(Reader reader) {
        this(reader, 32768);
    }

    public a(Reader reader, int i11) {
        this.f73152h = new String[512];
        d30.d.j(reader);
        d30.d.d(reader.markSupported());
        this.f73146b = reader;
        this.f73145a = new char[i11 > 32768 ? 32768 : i11];
        b();
    }

    public a(String str) {
        this(new StringReader(str), str.length());
    }

    public static boolean G(char[] cArr, int i11, int i12, String str) {
        if (i12 != str.length()) {
            return false;
        }
        int i13 = 0;
        while (true) {
            int i14 = i12 - 1;
            if (i12 == 0) {
                return true;
            }
            int i15 = i11 + 1;
            int i16 = i13 + 1;
            if (cArr[i11] != str.charAt(i13)) {
                return false;
            }
            i11 = i15;
            i12 = i14;
            i13 = i16;
        }
    }

    public static String c(char[] cArr, String[] strArr, int i11, int i12) {
        if (i12 > 12) {
            return new String(cArr, i11, i12);
        }
        if (i12 < 1) {
            return "";
        }
        int i13 = 0;
        int i14 = i11;
        int i15 = 0;
        while (i13 < i12) {
            i15 = (i15 * 31) + cArr[i14];
            i13++;
            i14++;
        }
        int length = i15 & (strArr.length - 1);
        String str = strArr[length];
        if (str == null) {
            String str2 = new String(cArr, i11, i12);
            strArr[length] = str2;
            return str2;
        }
        if (G(cArr, i11, i12, str)) {
            return str;
        }
        String str3 = new String(cArr, i11, i12);
        strArr[length] = str3;
        return str3;
    }

    public boolean A() {
        char c11;
        return !r() && (c11 = this.f73145a[this.f73149e]) >= '0' && c11 <= '9';
    }

    public boolean B(String str) {
        b();
        int length = str.length();
        if (length > this.f73147c - this.f73149e) {
            return false;
        }
        for (int i11 = 0; i11 < length; i11++) {
            if (Character.toUpperCase(str.charAt(i11)) != Character.toUpperCase(this.f73145a[this.f73149e + i11])) {
                return false;
            }
        }
        return true;
    }

    public boolean C() {
        if (r()) {
            return false;
        }
        char c11 = this.f73145a[this.f73149e];
        return (c11 >= 'A' && c11 <= 'Z') || (c11 >= 'a' && c11 <= 'z') || Character.isLetter(c11);
    }

    public int D(char c11) {
        b();
        for (int i11 = this.f73149e; i11 < this.f73147c; i11++) {
            if (c11 == this.f73145a[i11]) {
                return i11 - this.f73149e;
            }
        }
        return -1;
    }

    public int E(CharSequence charSequence) {
        b();
        char cCharAt = charSequence.charAt(0);
        int i11 = this.f73149e;
        while (i11 < this.f73147c) {
            if (cCharAt != this.f73145a[i11]) {
                do {
                    i11++;
                    if (i11 >= this.f73147c) {
                        break;
                    }
                } while (cCharAt != this.f73145a[i11]);
            }
            int i12 = i11 + 1;
            int length = (charSequence.length() + i12) - 1;
            int i13 = this.f73147c;
            if (i11 < i13 && length <= i13) {
                int i14 = i12;
                for (int i15 = 1; i14 < length && charSequence.charAt(i15) == this.f73145a[i14]; i15++) {
                    i14++;
                }
                if (i14 == length) {
                    return i11 - this.f73149e;
                }
            }
            i11 = i12;
        }
        return -1;
    }

    public int F() {
        return this.f73150f + this.f73149e;
    }

    public void H() {
        this.f73149e = this.f73151g;
    }

    public void I() {
        this.f73149e--;
    }

    public void a() {
        this.f73149e++;
    }

    public final void b() {
        int i11 = this.f73149e;
        if (i11 < this.f73148d) {
            return;
        }
        try {
            this.f73146b.skip(i11);
            this.f73146b.mark(32768);
            int i12 = this.f73146b.read(this.f73145a);
            this.f73146b.reset();
            if (i12 != -1) {
                this.f73147c = i12;
                this.f73150f += this.f73149e;
                this.f73149e = 0;
                this.f73151g = 0;
                if (i12 > 24576) {
                    i12 = 24576;
                }
                this.f73148d = i12;
            }
        } catch (IOException e11) {
            throw new UncheckedIOException(e11);
        }
    }

    public char d() {
        b();
        char c11 = s() ? (char) 65535 : this.f73145a[this.f73149e];
        this.f73149e++;
        return c11;
    }

    public String e() {
        int i11;
        char c11;
        b();
        int i12 = this.f73149e;
        int i13 = this.f73147c;
        char[] cArr = this.f73145a;
        while (true) {
            i11 = this.f73149e;
            if (i11 >= i13 || (c11 = cArr[i11]) == '&' || c11 == '<' || c11 == 0) {
                break;
            }
            this.f73149e = i11 + 1;
        }
        return i11 > i12 ? c(this.f73145a, this.f73152h, i12, i11 - i12) : "";
    }

    public String f() {
        int i11;
        char c11;
        b();
        int i12 = this.f73149e;
        while (true) {
            i11 = this.f73149e;
            if (i11 >= this.f73147c || (c11 = this.f73145a[i11]) < '0' || c11 > '9') {
                break;
            }
            this.f73149e = i11 + 1;
        }
        return c(this.f73145a, this.f73152h, i12, i11 - i12);
    }

    public String g() {
        int i11;
        char c11;
        b();
        int i12 = this.f73149e;
        while (true) {
            i11 = this.f73149e;
            if (i11 >= this.f73147c || (((c11 = this.f73145a[i11]) < '0' || c11 > '9') && ((c11 < 'A' || c11 > 'F') && (c11 < 'a' || c11 > 'f')))) {
                break;
            }
            this.f73149e = i11 + 1;
        }
        return c(this.f73145a, this.f73152h, i12, i11 - i12);
    }

    public String h() {
        char c11;
        b();
        int i11 = this.f73149e;
        while (true) {
            int i12 = this.f73149e;
            if (i12 >= this.f73147c || (((c11 = this.f73145a[i12]) < 'A' || c11 > 'Z') && ((c11 < 'a' || c11 > 'z') && !Character.isLetter(c11)))) {
                break;
            }
            this.f73149e++;
        }
        return c(this.f73145a, this.f73152h, i11, this.f73149e - i11);
    }

    public String i() {
        char c11;
        b();
        int i11 = this.f73149e;
        while (true) {
            int i12 = this.f73149e;
            if (i12 >= this.f73147c || (((c11 = this.f73145a[i12]) < 'A' || c11 > 'Z') && ((c11 < 'a' || c11 > 'z') && !Character.isLetter(c11)))) {
                break;
            }
            this.f73149e++;
        }
        while (!s()) {
            char[] cArr = this.f73145a;
            int i13 = this.f73149e;
            char c12 = cArr[i13];
            if (c12 < '0' || c12 > '9') {
                break;
            }
            this.f73149e = i13 + 1;
        }
        return c(this.f73145a, this.f73152h, i11, this.f73149e - i11);
    }

    public String j() {
        int i11;
        char c11;
        b();
        int i12 = this.f73149e;
        int i13 = this.f73147c;
        char[] cArr = this.f73145a;
        while (true) {
            i11 = this.f73149e;
            if (i11 >= i13 || (c11 = cArr[i11]) == '\t' || c11 == '\n' || c11 == '\r' || c11 == '\f' || c11 == ' ' || c11 == '/' || c11 == '>' || c11 == 0) {
                break;
            }
            this.f73149e = i11 + 1;
        }
        return i11 > i12 ? c(this.f73145a, this.f73152h, i12, i11 - i12) : "";
    }

    public String k(char c11) {
        int iD = D(c11);
        if (iD == -1) {
            return o();
        }
        String strC = c(this.f73145a, this.f73152h, this.f73149e, iD);
        this.f73149e += iD;
        return strC;
    }

    public String l(String str) {
        int iE = E(str);
        if (iE == -1) {
            return o();
        }
        String strC = c(this.f73145a, this.f73152h, this.f73149e, iE);
        this.f73149e += iE;
        return strC;
    }

    public String m(char... cArr) {
        b();
        int i11 = this.f73149e;
        int i12 = this.f73147c;
        char[] cArr2 = this.f73145a;
        loop0: while (this.f73149e < i12) {
            for (char c11 : cArr) {
                if (cArr2[this.f73149e] == c11) {
                    break loop0;
                }
            }
            this.f73149e++;
        }
        int i13 = this.f73149e;
        return i13 > i11 ? c(this.f73145a, this.f73152h, i11, i13 - i11) : "";
    }

    public String n(char... cArr) {
        b();
        int i11 = this.f73149e;
        int i12 = this.f73147c;
        char[] cArr2 = this.f73145a;
        while (true) {
            int i13 = this.f73149e;
            if (i13 >= i12 || Arrays.binarySearch(cArr, cArr2[i13]) >= 0) {
                break;
            }
            this.f73149e++;
        }
        int i14 = this.f73149e;
        return i14 > i11 ? c(this.f73145a, this.f73152h, i11, i14 - i11) : "";
    }

    public String o() {
        b();
        char[] cArr = this.f73145a;
        String[] strArr = this.f73152h;
        int i11 = this.f73149e;
        String strC = c(cArr, strArr, i11, this.f73147c - i11);
        this.f73149e = this.f73147c;
        return strC;
    }

    public boolean p(String str) {
        Locale locale = Locale.ENGLISH;
        return E(str.toLowerCase(locale)) > -1 || E(str.toUpperCase(locale)) > -1;
    }

    public char q() {
        b();
        if (s()) {
            return (char) 65535;
        }
        return this.f73145a[this.f73149e];
    }

    public boolean r() {
        b();
        return this.f73149e >= this.f73147c;
    }

    public final boolean s() {
        return this.f73149e >= this.f73147c;
    }

    public void t() {
        this.f73151g = this.f73149e;
    }

    public String toString() {
        char[] cArr = this.f73145a;
        int i11 = this.f73149e;
        return new String(cArr, i11, this.f73147c - i11);
    }

    public boolean u(String str) {
        b();
        if (!x(str)) {
            return false;
        }
        this.f73149e += str.length();
        return true;
    }

    public boolean v(String str) {
        if (!B(str)) {
            return false;
        }
        this.f73149e += str.length();
        return true;
    }

    public boolean w(char c11) {
        return !r() && this.f73145a[this.f73149e] == c11;
    }

    public boolean x(String str) {
        b();
        int length = str.length();
        if (length > this.f73147c - this.f73149e) {
            return false;
        }
        for (int i11 = 0; i11 < length; i11++) {
            if (str.charAt(i11) != this.f73145a[this.f73149e + i11]) {
                return false;
            }
        }
        return true;
    }

    public boolean y(char... cArr) {
        if (r()) {
            return false;
        }
        b();
        char c11 = this.f73145a[this.f73149e];
        for (char c12 : cArr) {
            if (c12 == c11) {
                return true;
            }
        }
        return false;
    }

    public boolean z(char[] cArr) {
        b();
        return !r() && Arrays.binarySearch(cArr, this.f73145a[this.f73149e]) >= 0;
    }
}
