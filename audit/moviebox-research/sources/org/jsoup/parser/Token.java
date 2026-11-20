package org.jsoup.parser;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class Token {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TokenType f73127a;

    /* JADX INFO: compiled from: source.java */
    public enum TokenType {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        EOF
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends c {
        public b(String str) {
            p(str);
        }

        @Override // org.jsoup.parser.Token.c
        public String toString() {
            return "<![CDATA[" + q() + "]]>";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends Token {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f73128b;

        public c() {
            super();
            this.f73127a = TokenType.Character;
        }

        @Override // org.jsoup.parser.Token
        public Token m() {
            this.f73128b = null;
            return this;
        }

        public c p(String str) {
            this.f73128b = str;
            return this;
        }

        public String q() {
            return this.f73128b;
        }

        public String toString() {
            return q();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d extends Token {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final StringBuilder f73129b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f73130c;

        public d() {
            super();
            this.f73129b = new StringBuilder();
            this.f73130c = false;
            this.f73127a = TokenType.Comment;
        }

        @Override // org.jsoup.parser.Token
        public Token m() {
            Token.n(this.f73129b);
            this.f73130c = false;
            return this;
        }

        public String p() {
            return this.f73129b.toString();
        }

        public String toString() {
            return "<!--" + p() + "-->";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e extends Token {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final StringBuilder f73131b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f73132c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final StringBuilder f73133d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final StringBuilder f73134e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f73135f;

        public e() {
            super();
            this.f73131b = new StringBuilder();
            this.f73132c = null;
            this.f73133d = new StringBuilder();
            this.f73134e = new StringBuilder();
            this.f73135f = false;
            this.f73127a = TokenType.Doctype;
        }

        @Override // org.jsoup.parser.Token
        public Token m() {
            Token.n(this.f73131b);
            this.f73132c = null;
            Token.n(this.f73133d);
            Token.n(this.f73134e);
            this.f73135f = false;
            return this;
        }

        public String p() {
            return this.f73131b.toString();
        }

        public String q() {
            return this.f73132c;
        }

        public String r() {
            return this.f73133d.toString();
        }

        public String s() {
            return this.f73134e.toString();
        }

        public boolean t() {
            return this.f73135f;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f extends Token {
        public f() {
            super();
            this.f73127a = TokenType.EOF;
        }

        @Override // org.jsoup.parser.Token
        public Token m() {
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g extends i {
        public g() {
            this.f73127a = TokenType.EndTag;
        }

        public String toString() {
            return "</" + A() + ">";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h extends i {
        public h() {
            this.f73144j = new org.jsoup.nodes.b();
            this.f73127a = TokenType.StartTag;
        }

        @Override // org.jsoup.parser.Token.i, org.jsoup.parser.Token
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public i m() {
            super.m();
            this.f73144j = new org.jsoup.nodes.b();
            return this;
        }

        public h G(String str, org.jsoup.nodes.b bVar) {
            this.f73136b = str;
            this.f73144j = bVar;
            this.f73137c = e30.b.a(str);
            return this;
        }

        public String toString() {
            org.jsoup.nodes.b bVar = this.f73144j;
            if (bVar == null || bVar.size() <= 0) {
                return "<" + A() + ">";
            }
            return "<" + A() + " " + this.f73144j.toString() + ">";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class i extends Token {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f73136b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f73137c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f73138d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public StringBuilder f73139e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f73140f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f73141g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f73142h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f73143i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public org.jsoup.nodes.b f73144j;

        public i() {
            super();
            this.f73139e = new StringBuilder();
            this.f73141g = false;
            this.f73142h = false;
            this.f73143i = false;
        }

        public final String A() {
            String str = this.f73136b;
            d30.d.b(str == null || str.length() == 0);
            return this.f73136b;
        }

        public final i B(String str) {
            this.f73136b = str;
            this.f73137c = e30.b.a(str);
            return this;
        }

        public final void C() {
            String string;
            if (this.f73144j == null) {
                this.f73144j = new org.jsoup.nodes.b();
            }
            String str = this.f73138d;
            if (str != null) {
                String strTrim = str.trim();
                this.f73138d = strTrim;
                if (strTrim.length() > 0) {
                    if (this.f73142h) {
                        string = this.f73139e.length() > 0 ? this.f73139e.toString() : this.f73140f;
                    } else {
                        string = this.f73141g ? "" : null;
                    }
                    this.f73144j.G(this.f73138d, string);
                }
            }
            this.f73138d = null;
            this.f73141g = false;
            this.f73142h = false;
            Token.n(this.f73139e);
            this.f73140f = null;
        }

        public final String D() {
            return this.f73137c;
        }

        @Override // org.jsoup.parser.Token
        /* JADX INFO: renamed from: E */
        public i m() {
            this.f73136b = null;
            this.f73137c = null;
            this.f73138d = null;
            Token.n(this.f73139e);
            this.f73140f = null;
            this.f73141g = false;
            this.f73142h = false;
            this.f73143i = false;
            this.f73144j = null;
            return this;
        }

        public final void F() {
            this.f73141g = true;
        }

        public final void p(char c11) {
            q(String.valueOf(c11));
        }

        public final void q(String str) {
            String str2 = this.f73138d;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.f73138d = str;
        }

        public final void r(char c11) {
            w();
            this.f73139e.append(c11);
        }

        public final void s(String str) {
            w();
            if (this.f73139e.length() == 0) {
                this.f73140f = str;
            } else {
                this.f73139e.append(str);
            }
        }

        public final void t(int[] iArr) {
            w();
            for (int i11 : iArr) {
                this.f73139e.appendCodePoint(i11);
            }
        }

        public final void u(char c11) {
            v(String.valueOf(c11));
        }

        public final void v(String str) {
            String str2 = this.f73136b;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.f73136b = str;
            this.f73137c = e30.b.a(str);
        }

        public final void w() {
            this.f73142h = true;
            String str = this.f73140f;
            if (str != null) {
                this.f73139e.append(str);
                this.f73140f = null;
            }
        }

        public final void x() {
            if (this.f73138d != null) {
                C();
            }
        }

        public final org.jsoup.nodes.b y() {
            return this.f73144j;
        }

        public final boolean z() {
            return this.f73143i;
        }
    }

    public Token() {
    }

    public static void n(StringBuilder sb2) {
        if (sb2 != null) {
            sb2.delete(0, sb2.length());
        }
    }

    public final c a() {
        return (c) this;
    }

    public final d b() {
        return (d) this;
    }

    public final e c() {
        return (e) this;
    }

    public final g d() {
        return (g) this;
    }

    public final h e() {
        return (h) this;
    }

    public final boolean f() {
        return this instanceof b;
    }

    public final boolean g() {
        return this.f73127a == TokenType.Character;
    }

    public final boolean h() {
        return this.f73127a == TokenType.Comment;
    }

    public final boolean i() {
        return this.f73127a == TokenType.Doctype;
    }

    public final boolean j() {
        return this.f73127a == TokenType.EOF;
    }

    public final boolean k() {
        return this.f73127a == TokenType.EndTag;
    }

    public final boolean l() {
        return this.f73127a == TokenType.StartTag;
    }

    public abstract Token m();

    public String o() {
        return getClass().getSimpleName();
    }
}
