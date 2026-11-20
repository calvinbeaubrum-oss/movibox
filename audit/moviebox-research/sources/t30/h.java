package t30;

import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.ast.EndOfStatement;
import org.mvel2.ast.Function;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f76807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f76808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f76809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f76810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public char[] f76811e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ParserContext f76812f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g f76813g;

    public h(String str, int i11, int i12, char[] cArr, int i13, ParserContext parserContext, g gVar) {
        this.f76807a = str;
        this.f76808b = i11;
        this.f76809c = i12;
        this.f76811e = cArr;
        this.f76810d = i13;
        this.f76812f = parserContext;
        this.f76813g = gVar;
    }

    public int a() {
        return this.f76808b;
    }

    public String b() {
        return this.f76807a;
    }

    public Function c() {
        int i11;
        int i12;
        int iE;
        int i13 = this.f76808b;
        int i14 = this.f76809c + i13;
        int iJ = m.j(this.f76811e, i13, i14, this.f76812f);
        this.f76808b = iJ;
        char[] cArr = this.f76811e;
        int iS0 = m.s0(cArr, iJ);
        this.f76808b = iS0;
        if (cArr[iS0] == '(') {
            iE = m.e(this.f76811e, iS0, i14, '(', this.f76812f);
            int i15 = iS0 + 1;
            int i16 = iE + 1;
            this.f76808b = i16;
            int iE0 = m.E0(this.f76811e, i16);
            this.f76808b = iE0;
            if (iE0 >= i14) {
                throw new CompileException("incomplete statement", this.f76811e, this.f76808b);
            }
            char[] cArr2 = this.f76811e;
            if (cArr2[iE0] == '{') {
                i12 = m.e(cArr2, iE0, i14, '{', this.f76812f);
                this.f76808b = i12;
                i11 = i15;
                iS0 = iE0;
            } else {
                i12 = m.i(cArr2, iE0, i14, this.f76812f);
                this.f76808b = i12;
                i11 = i15;
                iS0 = iE0 - 1;
            }
        } else {
            char[] cArr3 = this.f76811e;
            i11 = 0;
            if (cArr3[iS0] == '{') {
                i12 = m.e(cArr3, iS0, i14, '{', this.f76812f);
                this.f76808b = i12;
            } else {
                i12 = m.i(cArr3, iS0, i14, this.f76812f);
                this.f76808b = i12;
                iS0--;
            }
            iE = 0;
        }
        int iN0 = m.N0(this.f76811e, iS0 + 1);
        int iM0 = m.M0(this.f76811e, i13, i12);
        int i17 = this.f76808b + 1;
        this.f76808b = i17;
        if (this.f76813g != null && m.p0(this.f76811e, i17)) {
            this.f76813g.a(new EndOfStatement(this.f76812f));
        }
        return new Function(this.f76807a, this.f76811e, i11, iE - i11, iN0, iM0 - iN0, this.f76810d, this.f76812f);
    }
}
