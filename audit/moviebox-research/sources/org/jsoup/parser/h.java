package org.jsoup.parser;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.transsion.gslb.Utils;
import java.util.Arrays;
import org.jsoup.nodes.Entities;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class h {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final char[] f73198r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int[] f73199s = {8364, TsExtractor.TS_STREAM_TYPE_AC3, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 141, 381, 143, 144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 157, 382, 376};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f73200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ParseErrorList f73201b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Token f73203d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Token.i f73208i;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f73214o;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TokeniserState f73202c = TokeniserState.Data;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f73204e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f73205f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public StringBuilder f73206g = new StringBuilder(1024);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public StringBuilder f73207h = new StringBuilder(1024);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Token.h f73209j = new Token.h();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Token.g f73210k = new Token.g();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Token.c f73211l = new Token.c();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Token.e f73212m = new Token.e();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Token.d f73213n = new Token.d();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int[] f73215p = new int[1];

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int[] f73216q = new int[2];

    static {
        char[] cArr = {'\t', '\n', '\r', '\f', ' ', '<', '&'};
        f73198r = cArr;
        Arrays.sort(cArr);
    }

    public h(a aVar, ParseErrorList parseErrorList) {
        this.f73200a = aVar;
        this.f73201b = parseErrorList;
    }

    public void a(TokeniserState tokeniserState) {
        this.f73200a.a();
        this.f73202c = tokeniserState;
    }

    public String b() {
        return this.f73214o;
    }

    public final void c(String str) {
        if (this.f73201b.canAddError()) {
            this.f73201b.add(new c(this.f73200a.F(), "Invalid character reference: %s", str));
        }
    }

    public int[] d(Character ch2, boolean z11) {
        int iIntValue;
        if (this.f73200a.r()) {
            return null;
        }
        if ((ch2 != null && ch2.charValue() == this.f73200a.q()) || this.f73200a.z(f73198r)) {
            return null;
        }
        int[] iArr = this.f73215p;
        this.f73200a.t();
        if (this.f73200a.u(Utils.SEPARATOR)) {
            boolean zV = this.f73200a.v("X");
            a aVar = this.f73200a;
            String strG = zV ? aVar.g() : aVar.f();
            if (strG.length() == 0) {
                c("numeric reference with no numerals");
                this.f73200a.H();
                return null;
            }
            if (!this.f73200a.u(";")) {
                c("missing semicolon");
            }
            try {
                iIntValue = Integer.valueOf(strG, zV ? 16 : 10).intValue();
            } catch (NumberFormatException unused) {
                iIntValue = -1;
            }
            if (iIntValue == -1 || ((iIntValue >= 55296 && iIntValue <= 57343) || iIntValue > 1114111)) {
                c("character outside of valid range");
                iArr[0] = 65533;
                return iArr;
            }
            if (iIntValue >= 128) {
                int[] iArr2 = f73199s;
                if (iIntValue < iArr2.length + 128) {
                    c("character is not a valid unicode code point");
                    iIntValue = iArr2[iIntValue - 128];
                }
            }
            iArr[0] = iIntValue;
            return iArr;
        }
        String strI = this.f73200a.i();
        boolean zW = this.f73200a.w(';');
        if (!Entities.f(strI) && (!Entities.g(strI) || !zW)) {
            this.f73200a.H();
            if (zW) {
                c(String.format("invalid named referenece '%s'", strI));
            }
            return null;
        }
        if (z11 && (this.f73200a.C() || this.f73200a.A() || this.f73200a.y('=', '-', '_'))) {
            this.f73200a.H();
            return null;
        }
        if (!this.f73200a.u(";")) {
            c("missing semicolon");
        }
        int iD = Entities.d(strI, this.f73216q);
        if (iD == 1) {
            iArr[0] = this.f73216q[0];
            return iArr;
        }
        if (iD == 2) {
            return this.f73216q;
        }
        d30.d.a("Unexpected characters returned for " + strI);
        return this.f73216q;
    }

    public void e() {
        this.f73213n.m();
    }

    public void f() {
        this.f73212m.m();
    }

    public Token.i g(boolean z11) {
        Token.i iVarM = z11 ? this.f73209j.m() : this.f73210k.m();
        this.f73208i = iVarM;
        return iVarM;
    }

    public void h() {
        Token.n(this.f73207h);
    }

    public void i(char c11) {
        j(String.valueOf(c11));
    }

    public void j(String str) {
        if (this.f73205f == null) {
            this.f73205f = str;
            return;
        }
        if (this.f73206g.length() == 0) {
            this.f73206g.append(this.f73205f);
        }
        this.f73206g.append(str);
    }

    public void k(Token token) {
        d30.d.c(this.f73204e, "There is an unread token pending!");
        this.f73203d = token;
        this.f73204e = true;
        Token.TokenType tokenType = token.f73127a;
        if (tokenType == Token.TokenType.StartTag) {
            this.f73214o = ((Token.h) token).f73136b;
        } else {
            if (tokenType != Token.TokenType.EndTag || ((Token.g) token).f73144j == null) {
                return;
            }
            q("Attributes incorrectly present on end tag");
        }
    }

    public void l(int[] iArr) {
        j(new String(iArr, 0, iArr.length));
    }

    public void m() {
        k(this.f73213n);
    }

    public void n() {
        k(this.f73212m);
    }

    public void o() {
        this.f73208i.x();
        k(this.f73208i);
    }

    public void p(TokeniserState tokeniserState) {
        if (this.f73201b.canAddError()) {
            this.f73201b.add(new c(this.f73200a.F(), "Unexpectedly reached end of file (EOF) in input state [%s]", tokeniserState));
        }
    }

    public void q(String str) {
        if (this.f73201b.canAddError()) {
            this.f73201b.add(new c(this.f73200a.F(), str));
        }
    }

    public void r(TokeniserState tokeniserState) {
        if (this.f73201b.canAddError()) {
            this.f73201b.add(new c(this.f73200a.F(), "Unexpected character '%s' in input state [%s]", Character.valueOf(this.f73200a.q()), tokeniserState));
        }
    }

    public boolean s() {
        return this.f73214o != null && this.f73208i.A().equalsIgnoreCase(this.f73214o);
    }

    public Token t() {
        while (!this.f73204e) {
            this.f73202c.read(this, this.f73200a);
        }
        if (this.f73206g.length() > 0) {
            String string = this.f73206g.toString();
            StringBuilder sb2 = this.f73206g;
            sb2.delete(0, sb2.length());
            this.f73205f = null;
            return this.f73211l.p(string);
        }
        String str = this.f73205f;
        if (str == null) {
            this.f73204e = false;
            return this.f73203d;
        }
        Token.c cVarP = this.f73211l.p(str);
        this.f73205f = null;
        return cVarP;
    }

    public void u(TokeniserState tokeniserState) {
        this.f73202c = tokeniserState;
    }
}
