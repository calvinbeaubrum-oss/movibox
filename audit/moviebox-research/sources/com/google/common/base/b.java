package com.google.common.base;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements n<Character> {

    /* JADX INFO: compiled from: source.java */
    public static final class a extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f38155b = new a();

        public a() {
            super("CharMatcher.ascii()");
        }

        @Override // com.google.common.base.b
        public boolean g(char c11) {
            return c11 <= 127;
        }
    }

    /* JADX INFO: renamed from: com.google.common.base.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static abstract class AbstractC0389b extends b {
        @Override // com.google.common.base.n
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.b(ch2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends AbstractC0389b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final char f38156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final char f38157b;

        public c(char c11, char c12) {
            m.d(c12 >= c11);
            this.f38156a = c11;
            this.f38157b = c12;
        }

        @Override // com.google.common.base.b
        public boolean g(char c11) {
            return this.f38156a <= c11 && c11 <= this.f38157b;
        }

        public String toString() {
            return "CharMatcher.inRange('" + b.j(this.f38156a) + "', '" + b.j(this.f38157b) + "')";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d extends AbstractC0389b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final char f38158a;

        public d(char c11) {
            this.f38158a = c11;
        }

        @Override // com.google.common.base.b
        public boolean g(char c11) {
            return c11 == this.f38158a;
        }

        public String toString() {
            return "CharMatcher.is('" + b.j(this.f38158a) + "')";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class e extends AbstractC0389b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f38159a;

        public e(String str) {
            this.f38159a = (String) m.p(str);
        }

        public final String toString() {
            return this.f38159a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f38160b = new f();

        public f() {
            super("CharMatcher.none()");
        }

        @Override // com.google.common.base.b
        public int e(CharSequence charSequence, int i11) {
            m.s(i11, charSequence.length());
            return -1;
        }

        @Override // com.google.common.base.b
        public boolean g(char c11) {
            return false;
        }

        @Override // com.google.common.base.b
        public boolean h(CharSequence charSequence) {
            return charSequence.length() == 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f38161b = Integer.numberOfLeadingZeros(31);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g f38162c = new g();

        public g() {
            super("CharMatcher.whitespace()");
        }

        @Override // com.google.common.base.b
        public boolean g(char c11) {
            return "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt((48906 * c11) >>> f38161b) == c11;
        }
    }

    public static b c() {
        return a.f38155b;
    }

    public static b d(char c11, char c12) {
        return new c(c11, c12);
    }

    public static b f(char c11) {
        return new d(c11);
    }

    public static b i() {
        return f.f38160b;
    }

    public static String j(char c11) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i11 = 0; i11 < 4; i11++) {
            cArr[5 - i11] = "0123456789ABCDEF".charAt(c11 & 15);
            c11 = (char) (c11 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public static b k() {
        return g.f38162c;
    }

    @Deprecated
    public boolean b(Character ch2) {
        return g(ch2.charValue());
    }

    public int e(CharSequence charSequence, int i11) {
        int length = charSequence.length();
        m.s(i11, length);
        while (i11 < length) {
            if (g(charSequence.charAt(i11))) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public abstract boolean g(char c11);

    public boolean h(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!g(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }
}
