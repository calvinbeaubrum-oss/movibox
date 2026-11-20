package tm;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.oned.rss.expanded.decoders.CurrentParsingState;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hm.a f77251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CurrentParsingState f77252b = new CurrentParsingState();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StringBuilder f77253c = new StringBuilder();

    public r(hm.a aVar) {
        this.f77251a = aVar;
    }

    public static int g(hm.a aVar, int i11, int i12) {
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            if (aVar.h(i11 + i14)) {
                i13 |= 1 << ((i12 - i14) - 1);
            }
        }
        return i13;
    }

    public String a(StringBuilder sb2, int i11) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            n nVarC = c(i11, str);
            String strA = q.a(nVarC.b());
            if (strA != null) {
                sb2.append(strA);
            }
            String strValueOf = nVarC.d() ? String.valueOf(nVarC.c()) : null;
            if (i11 == nVarC.a()) {
                return sb2.toString();
            }
            i11 = nVarC.a();
            str = strValueOf;
        }
    }

    public final m b(int i11) {
        char c11;
        int iF = f(i11, 5);
        if (iF == 15) {
            return new m(i11 + 5, '$');
        }
        if (iF >= 5 && iF < 15) {
            return new m(i11 + 5, (char) (iF + 43));
        }
        int iF2 = f(i11, 6);
        if (iF2 >= 32 && iF2 < 58) {
            return new m(i11 + 6, (char) (iF2 + 33));
        }
        switch (iF2) {
            case 58:
                c11 = '*';
                break;
            case 59:
                c11 = ',';
                break;
            case 60:
                c11 = '-';
                break;
            case 61:
                c11 = '.';
                break;
            case 62:
                c11 = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: " + iF2);
        }
        return new m(i11 + 6, c11);
    }

    public n c(int i11, String str) throws FormatException {
        this.f77253c.setLength(0);
        if (str != null) {
            this.f77253c.append(str);
        }
        this.f77252b.h(i11);
        n nVarO = o();
        return (nVarO == null || !nVarO.d()) ? new n(this.f77252b.a(), this.f77253c.toString()) : new n(this.f77252b.a(), this.f77253c.toString(), nVarO.c());
    }

    public final m d(int i11) throws FormatException {
        int iF = f(i11, 5);
        if (iF == 15) {
            return new m(i11 + 5, '$');
        }
        char c11 = '+';
        if (iF >= 5 && iF < 15) {
            return new m(i11 + 5, (char) (iF + 43));
        }
        int iF2 = f(i11, 7);
        if (iF2 >= 64 && iF2 < 90) {
            return new m(i11 + 7, (char) (iF2 + 1));
        }
        if (iF2 >= 90 && iF2 < 116) {
            return new m(i11 + 7, (char) (iF2 + 7));
        }
        switch (f(i11, 8)) {
            case 232:
                c11 = '!';
                break;
            case 233:
                c11 = '\"';
                break;
            case 234:
                c11 = '%';
                break;
            case 235:
                c11 = '&';
                break;
            case 236:
                c11 = '\'';
                break;
            case 237:
                c11 = '(';
                break;
            case 238:
                c11 = ')';
                break;
            case 239:
                c11 = '*';
                break;
            case 240:
                break;
            case 241:
                c11 = ',';
                break;
            case 242:
                c11 = '-';
                break;
            case 243:
                c11 = '.';
                break;
            case 244:
                c11 = '/';
                break;
            case 245:
                c11 = ':';
                break;
            case 246:
                c11 = ';';
                break;
            case 247:
                c11 = '<';
                break;
            case 248:
                c11 = '=';
                break;
            case 249:
                c11 = '>';
                break;
            case 250:
                c11 = '?';
                break;
            case 251:
                c11 = '_';
                break;
            case 252:
                c11 = ' ';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        return new m(i11 + 8, c11);
    }

    public final o e(int i11) throws FormatException {
        int i12 = i11 + 7;
        if (i12 > this.f77251a.m()) {
            int iF = f(i11, 4);
            return iF == 0 ? new o(this.f77251a.m(), 10, 10) : new o(this.f77251a.m(), iF - 1, 10);
        }
        int iF2 = f(i11, 7) - 8;
        return new o(i12, iF2 / 11, iF2 % 11);
    }

    public int f(int i11, int i12) {
        return g(this.f77251a, i11, i12);
    }

    public final boolean h(int i11) {
        int i12 = i11 + 3;
        if (i12 > this.f77251a.m()) {
            return false;
        }
        while (i11 < i12) {
            if (this.f77251a.h(i11)) {
                return false;
            }
            i11++;
        }
        return true;
    }

    public final boolean i(int i11) {
        int i12;
        if (i11 + 1 > this.f77251a.m()) {
            return false;
        }
        for (int i13 = 0; i13 < 5 && (i12 = i13 + i11) < this.f77251a.m(); i13++) {
            if (i13 == 2) {
                if (!this.f77251a.h(i11 + 2)) {
                    return false;
                }
            } else if (this.f77251a.h(i12)) {
                return false;
            }
        }
        return true;
    }

    public final boolean j(int i11) {
        int i12;
        if (i11 + 1 > this.f77251a.m()) {
            return false;
        }
        for (int i13 = 0; i13 < 4 && (i12 = i13 + i11) < this.f77251a.m(); i13++) {
            if (this.f77251a.h(i12)) {
                return false;
            }
        }
        return true;
    }

    public final boolean k(int i11) {
        int iF;
        if (i11 + 5 > this.f77251a.m()) {
            return false;
        }
        int iF2 = f(i11, 5);
        if (iF2 < 5 || iF2 >= 16) {
            return i11 + 6 <= this.f77251a.m() && (iF = f(i11, 6)) >= 16 && iF < 63;
        }
        return true;
    }

    public final boolean l(int i11) {
        int iF;
        if (i11 + 5 > this.f77251a.m()) {
            return false;
        }
        int iF2 = f(i11, 5);
        if (iF2 >= 5 && iF2 < 16) {
            return true;
        }
        if (i11 + 7 > this.f77251a.m()) {
            return false;
        }
        int iF3 = f(i11, 7);
        if (iF3 < 64 || iF3 >= 116) {
            return i11 + 8 <= this.f77251a.m() && (iF = f(i11, 8)) >= 232 && iF < 253;
        }
        return true;
    }

    public final boolean m(int i11) {
        if (i11 + 7 > this.f77251a.m()) {
            return i11 + 4 <= this.f77251a.m();
        }
        int i12 = i11;
        while (true) {
            int i13 = i11 + 3;
            if (i12 >= i13) {
                return this.f77251a.h(i13);
            }
            if (this.f77251a.h(i12)) {
                return true;
            }
            i12++;
        }
    }

    public final l n() {
        while (k(this.f77252b.a())) {
            m mVarB = b(this.f77252b.a());
            this.f77252b.h(mVarB.a());
            if (mVarB.c()) {
                return new l(new n(this.f77252b.a(), this.f77253c.toString()), true);
            }
            this.f77253c.append(mVarB.b());
        }
        if (h(this.f77252b.a())) {
            this.f77252b.b(3);
            this.f77252b.g();
        } else if (i(this.f77252b.a())) {
            if (this.f77252b.a() + 5 < this.f77251a.m()) {
                this.f77252b.b(5);
            } else {
                this.f77252b.h(this.f77251a.m());
            }
            this.f77252b.f();
        }
        return new l();
    }

    public final n o() throws FormatException {
        l lVarQ;
        boolean zB;
        do {
            int iA = this.f77252b.a();
            if (this.f77252b.c()) {
                lVarQ = n();
                zB = lVarQ.b();
            } else if (this.f77252b.d()) {
                lVarQ = p();
                zB = lVarQ.b();
            } else {
                lVarQ = q();
                zB = lVarQ.b();
            }
            if (iA == this.f77252b.a() && !zB) {
                break;
            }
        } while (!zB);
        return lVarQ.a();
    }

    public final l p() throws FormatException {
        while (l(this.f77252b.a())) {
            m mVarD = d(this.f77252b.a());
            this.f77252b.h(mVarD.a());
            if (mVarD.c()) {
                return new l(new n(this.f77252b.a(), this.f77253c.toString()), true);
            }
            this.f77253c.append(mVarD.b());
        }
        if (h(this.f77252b.a())) {
            this.f77252b.b(3);
            this.f77252b.g();
        } else if (i(this.f77252b.a())) {
            if (this.f77252b.a() + 5 < this.f77251a.m()) {
                this.f77252b.b(5);
            } else {
                this.f77252b.h(this.f77251a.m());
            }
            this.f77252b.e();
        }
        return new l();
    }

    public final l q() throws FormatException {
        while (m(this.f77252b.a())) {
            o oVarE = e(this.f77252b.a());
            this.f77252b.h(oVarE.a());
            if (oVarE.d()) {
                return new l(oVarE.e() ? new n(this.f77252b.a(), this.f77253c.toString()) : new n(this.f77252b.a(), this.f77253c.toString(), oVarE.c()), true);
            }
            this.f77253c.append(oVarE.b());
            if (oVarE.e()) {
                return new l(new n(this.f77252b.a(), this.f77253c.toString()), true);
            }
            this.f77253c.append(oVarE.c());
        }
        if (j(this.f77252b.a())) {
            this.f77252b.e();
            this.f77252b.b(4);
        }
        return new l();
    }
}
