package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base;

import java.util.Arrays;
import java.util.function.Predicate;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class b implements com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n<Character> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final b f39042a = w();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final b f39043b = e();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public static final b f39044c = d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public static final b f39045d = f();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public static final b f39046f = l();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Deprecated
    public static final b f39047g = n();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Deprecated
    public static final b f39048h = o();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Deprecated
    public static final b f39049i = q();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Deprecated
    public static final b f39050j = p();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Deprecated
    public static final b f39051k = m();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Deprecated
    public static final b f39052l = i();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Deprecated
    public static final b f39053m = v();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Deprecated
    public static final b f39054n = b();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Deprecated
    public static final b f39055o = t();

    /* JADX INFO: compiled from: source.java */
    public static final class a extends p {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final a f39056q = new a();

        public a() {
            super("CharMatcher.any()");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public int h(CharSequence charSequence, int i11) {
            int length = charSequence.length();
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.q(i11, length);
            if (i11 == length) {
                return -1;
            }
            return i11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public boolean r(char c11) {
            return true;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b.e, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b, java.util.function.Predicate
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public b negate() {
            return b.t();
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0407b extends p {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final C0407b f39057q = new C0407b();

        public C0407b() {
            super("CharMatcher.ascii()");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public boolean r(char c11) {
            return c11 <= 127;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends b {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final b f39058p = new c();

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return super.negate();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public boolean r(char c11) {
            if (c11 != ' ' && c11 != 133 && c11 != 5760) {
                if (c11 == 8199) {
                    return false;
                }
                if (c11 != 8287 && c11 != 12288 && c11 != 8232 && c11 != 8233) {
                    switch (c11) {
                        case '\t':
                        case '\n':
                        case 11:
                        case '\f':
                        case '\r':
                            break;
                        default:
                            return c11 >= 8192 && c11 <= 8202;
                    }
                }
            }
            return true;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public String toString() {
            return "CharMatcher.breakingWhitespace()";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d extends t {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final d f39059s = new d();

        public d() {
            super("CharMatcher.digit()", y(), x());
        }

        public static char[] x() {
            char[] cArr = new char[37];
            for (int i11 = 0; i11 < 37; i11++) {
                cArr[i11] = (char) ("0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".charAt(i11) + '\t');
            }
            return cArr;
        }

        public static char[] y() {
            return "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".toCharArray();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class e extends b {
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b, java.util.function.Predicate
        /* JADX INFO: renamed from: s */
        public b negate() {
            return new r(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f extends e {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final char f39060p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final char f39061q;

        public f(char c11, char c12) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(c12 >= c11);
            this.f39060p = c11;
            this.f39061q = c12;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public boolean r(char c11) {
            return this.f39060p <= c11 && c11 <= this.f39061q;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public String toString() {
            return "CharMatcher.inRange('" + b.u(this.f39060p) + "', '" + b.u(this.f39061q) + "')";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g extends t {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final g f39062s = new g();

        public g() {
            super("CharMatcher.invisible()", "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f\u08e2\u1680\u180e\u2000\u2028\u205f\u2066\u3000\ud800\ufeff\ufff9".toCharArray(), "  \u00ad\u0605\u061c\u06dd\u070f\u08e2\u1680\u180e\u200f \u2064\u206f\u3000\uf8ff\ufeff\ufffb".toCharArray());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h extends e {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final char f39063p;

        public h(char c11) {
            this.f39063p = c11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public boolean r(char c11) {
            return c11 == this.f39063p;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b.e, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b, java.util.function.Predicate
        /* JADX INFO: renamed from: s */
        public b negate() {
            return b.k(this.f39063p);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public String toString() {
            return "CharMatcher.is('" + b.u(this.f39063p) + "')";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class i extends e {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final char f39064p;

        public i(char c11) {
            this.f39064p = c11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public boolean r(char c11) {
            return c11 != this.f39064p;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b.e, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b, java.util.function.Predicate
        /* JADX INFO: renamed from: s */
        public b negate() {
            return b.j(this.f39064p);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public String toString() {
            return "CharMatcher.isNot('" + b.u(this.f39064p) + "')";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class j extends b {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final j f39065p = new j();

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return super.negate();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public boolean r(char c11) {
            return Character.isDigit(c11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public String toString() {
            return "CharMatcher.javaDigit()";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class k extends p {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final k f39066q = new k();

        public k() {
            super("CharMatcher.javaIsoControl()");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public boolean r(char c11) {
            return c11 <= 31 || (c11 >= 127 && c11 <= 159);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class l extends b {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final l f39067p = new l();

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return super.negate();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public boolean r(char c11) {
            return Character.isLetter(c11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public String toString() {
            return "CharMatcher.javaLetter()";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class m extends b {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final m f39068p = new m();

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return super.negate();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public boolean r(char c11) {
            return Character.isLetterOrDigit(c11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class n extends b {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final n f39069p = new n();

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return super.negate();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public boolean r(char c11) {
            return Character.isLowerCase(c11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public String toString() {
            return "CharMatcher.javaLowerCase()";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o extends b {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final o f39070p = new o();

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return super.negate();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public boolean r(char c11) {
            return Character.isUpperCase(c11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public String toString() {
            return "CharMatcher.javaUpperCase()";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class p extends e {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final String f39071p;

        public p(String str) {
            this.f39071p = (String) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(str);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public final String toString() {
            return this.f39071p;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class q extends b {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final b f39072p;

        public q(b bVar) {
            this.f39072p = (b) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(bVar);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public boolean r(char c11) {
            return !this.f39072p.r(c11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b, java.util.function.Predicate
        /* JADX INFO: renamed from: s */
        public b negate() {
            return this.f39072p;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public String toString() {
            return this.f39072p + ".negate()";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class r extends q {
        public r(b bVar) {
            super(bVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class s extends p {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final s f39073q = new s();

        public s() {
            super("CharMatcher.none()");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public int h(CharSequence charSequence, int i11) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.q(i11, charSequence.length());
            return -1;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public boolean r(char c11) {
            return false;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b.e, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b, java.util.function.Predicate
        /* JADX INFO: renamed from: s */
        public b negate() {
            return b.b();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class t extends b {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final String f39074p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final char[] f39075q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final char[] f39076r;

        public t(String str, char[] cArr, char[] cArr2) {
            this.f39074p = str;
            this.f39075q = cArr;
            this.f39076r = cArr2;
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(cArr.length == cArr2.length);
            int i11 = 0;
            while (i11 < cArr.length) {
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(cArr[i11] <= cArr2[i11]);
                int i12 = i11 + 1;
                if (i12 < cArr.length) {
                    com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(cArr2[i11] < cArr[i12]);
                }
                i11 = i12;
            }
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return super.negate();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public boolean r(char c11) {
            int iBinarySearch = Arrays.binarySearch(this.f39075q, c11);
            if (iBinarySearch >= 0) {
                return true;
            }
            int i11 = (~iBinarySearch) - 1;
            return i11 >= 0 && c11 <= this.f39076r[i11];
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public String toString() {
            return this.f39074p;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class u extends t {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final u f39077s = new u();

        public u() {
            super("CharMatcher.singleWidth()", "\u0000־א׳\u0600ݐ\u0e00Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ\u0e7f₯℺﷿\ufeffￜ".toCharArray());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class v extends p {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final int f39078q = Integer.numberOfLeadingZeros(31);

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final v f39079r = new v();

        public v() {
            super("CharMatcher.whitespace()");
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.b
        public boolean r(char c11) {
            return "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt((48906 * c11) >>> f39078q) == c11;
        }
    }

    public static b b() {
        return a.f39056q;
    }

    public static b d() {
        return C0407b.f39057q;
    }

    public static b e() {
        return c.f39058p;
    }

    @Deprecated
    public static b f() {
        return d.f39059s;
    }

    public static b g(char c11, char c12) {
        return new f(c11, c12);
    }

    @Deprecated
    public static b i() {
        return g.f39062s;
    }

    public static b j(char c11) {
        return new h(c11);
    }

    public static b k(char c11) {
        return new i(c11);
    }

    @Deprecated
    public static b l() {
        return j.f39065p;
    }

    public static b m() {
        return k.f39066q;
    }

    @Deprecated
    public static b n() {
        return l.f39067p;
    }

    @Deprecated
    public static b o() {
        return m.f39068p;
    }

    @Deprecated
    public static b p() {
        return n.f39069p;
    }

    @Deprecated
    public static b q() {
        return o.f39070p;
    }

    public static b t() {
        return s.f39073q;
    }

    public static String u(char c11) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i11 = 0; i11 < 4; i11++) {
            cArr[5 - i11] = "0123456789ABCDEF".charAt(c11 & 15);
            c11 = (char) (c11 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    @Deprecated
    public static b v() {
        return u.f39077s;
    }

    public static b w() {
        return v.f39079r;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n
    @Deprecated
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean apply(Character ch2) {
        return r(ch2.charValue());
    }

    public int h(CharSequence charSequence, int i11) {
        int length = charSequence.length();
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.q(i11, length);
        while (i11 < length) {
            if (r(charSequence.charAt(i11))) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public abstract boolean r(char c11);

    @Override // java.util.function.Predicate
    /* JADX INFO: renamed from: s */
    public b negate() {
        return new q(this);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n, java.util.function.Predicate
    public /* synthetic */ boolean test(Object obj) {
        return com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.m.a(this, obj);
    }

    public String toString() {
        return super.toString();
    }
}
