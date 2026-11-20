package org.jsoup.parser;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f73196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f73197b = 0;

    public g(String str) {
        d30.d.j(str);
        this.f73196a = str;
    }

    public static String s(String str) {
        StringBuilder sbO = d30.c.o();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i11 = 0;
        char c11 = 0;
        while (i11 < length) {
            char c12 = charArray[i11];
            if (c12 != '\\') {
                sbO.append(c12);
            } else if (c11 != 0 && c11 == '\\') {
                sbO.append(c12);
            }
            i11++;
            c11 = c12;
        }
        return sbO.toString();
    }

    public String a(char c11, char c12) {
        char cCharValue = 0;
        boolean z11 = false;
        boolean z12 = false;
        int i11 = 0;
        int i12 = -1;
        int i13 = -1;
        while (!j()) {
            Character chValueOf = Character.valueOf(c());
            if (cCharValue == 0 || cCharValue != '\\') {
                if (chValueOf.equals('\'') && chValueOf.charValue() != c11 && !z11) {
                    z12 = !z12;
                } else if (chValueOf.equals('\"') && chValueOf.charValue() != c11 && !z12) {
                    z11 = !z11;
                }
                if (!z12 && !z11) {
                    if (chValueOf.equals(Character.valueOf(c11))) {
                        i11++;
                        if (i12 == -1) {
                            i12 = this.f73197b;
                        }
                    } else if (chValueOf.equals(Character.valueOf(c12))) {
                        i11--;
                    }
                    if (i11 > 0 && cCharValue != 0) {
                        i13 = this.f73197b;
                    }
                    cCharValue = chValueOf.charValue();
                }
            } else {
                if (i11 > 0) {
                    i13 = this.f73197b;
                }
                cCharValue = chValueOf.charValue();
            }
            if (i11 <= 0) {
                break;
            }
        }
        String strSubstring = i13 >= 0 ? this.f73196a.substring(i12, i13) : "";
        if (i11 > 0) {
            d30.d.a("Did not find balanced marker at '" + strSubstring + "'");
        }
        return strSubstring;
    }

    public String b(String str) {
        String strG = g(str);
        k(str);
        return strG;
    }

    public char c() {
        String str = this.f73196a;
        int i11 = this.f73197b;
        this.f73197b = i11 + 1;
        return str.charAt(i11);
    }

    public void d(String str) {
        if (!l(str)) {
            throw new IllegalStateException("Queue did not match expected sequence");
        }
        int length = str.length();
        if (length > r()) {
            throw new IllegalStateException("Queue not long enough to consume sequence");
        }
        this.f73197b += length;
    }

    public String e() {
        int i11 = this.f73197b;
        while (!j() && (p() || m('-', '_'))) {
            this.f73197b++;
        }
        return this.f73196a.substring(i11, this.f73197b);
    }

    public String f() {
        int i11 = this.f73197b;
        while (!j() && (p() || n("*|", "|", "_", "-"))) {
            this.f73197b++;
        }
        return this.f73196a.substring(i11, this.f73197b);
    }

    public String g(String str) {
        int iIndexOf = this.f73196a.indexOf(str, this.f73197b);
        if (iIndexOf == -1) {
            return q();
        }
        String strSubstring = this.f73196a.substring(this.f73197b, iIndexOf);
        this.f73197b += strSubstring.length();
        return strSubstring;
    }

    public String h(String... strArr) {
        int i11 = this.f73197b;
        while (!j() && !n(strArr)) {
            this.f73197b++;
        }
        return this.f73196a.substring(i11, this.f73197b);
    }

    public boolean i() {
        boolean z11 = false;
        while (o()) {
            this.f73197b++;
            z11 = true;
        }
        return z11;
    }

    public boolean j() {
        return r() == 0;
    }

    public boolean k(String str) {
        if (!l(str)) {
            return false;
        }
        this.f73197b += str.length();
        return true;
    }

    public boolean l(String str) {
        return this.f73196a.regionMatches(true, this.f73197b, str, 0, str.length());
    }

    public boolean m(char... cArr) {
        if (j()) {
            return false;
        }
        for (char c11 : cArr) {
            if (this.f73196a.charAt(this.f73197b) == c11) {
                return true;
            }
        }
        return false;
    }

    public boolean n(String... strArr) {
        for (String str : strArr) {
            if (l(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean o() {
        return !j() && d30.c.h(this.f73196a.charAt(this.f73197b));
    }

    public boolean p() {
        return !j() && Character.isLetterOrDigit(this.f73196a.charAt(this.f73197b));
    }

    public String q() {
        String str = this.f73196a;
        String strSubstring = str.substring(this.f73197b, str.length());
        this.f73197b = this.f73196a.length();
        return strSubstring;
    }

    public final int r() {
        return this.f73196a.length() - this.f73197b;
    }

    public String toString() {
        return this.f73196a.substring(this.f73197b);
    }
}
