package p007do;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoBuilder;
import io.l;
import io.o;
import io.r;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f63439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f63440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f63441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f63442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f63443e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f63444f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f63445g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f63446h;

    /* JADX INFO: compiled from: source.java */
    @AutoBuilder
    public interface a {
        a a(String str);

        a b(String str);

        d build();

        a c(String str);

        a d(int i11);

        a e(String str);

        a f(String str);

        a g(int i11);

        a h(String str);
    }

    public d(String str, String str2, String str3, String str4, String str5, String str6, int i11, int i12) {
        this.f63439a = str;
        this.f63440b = str2;
        this.f63441c = str3;
        this.f63442d = str4;
        this.f63443e = str5;
        this.f63444f = str6;
        this.f63445g = i11;
        this.f63446h = i12;
    }

    public static a g() {
        q qVar = new q();
        qVar.f63496a = "";
        qVar.f63497b = "";
        qVar.f63498c = "";
        qVar.f63499d = "";
        qVar.f63501f = "";
        return ((q) qVar.g(0)).d(0).a("");
    }

    @Override // io.l
    public void a(r rVar) {
        rVar.u(1, this.f63439a).u(2, this.f63440b).u(3, this.f63441c).u(4, this.f63442d).u(500, this.f63444f).o(501, this.f63445g).o(502, this.f63446h).u(503, this.f63443e);
    }

    public String c() {
        return this.f63440b;
    }

    public String d() {
        return this.f63443e;
    }

    @Override // io.l
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public d b(o oVar) {
        a aVarK = k();
        while (oVar.b()) {
            int iN = oVar.n();
            if (iN == 1) {
                aVarK.h(oVar.q());
            } else if (iN == 2) {
                aVarK.f(oVar.q());
            } else if (iN == 3) {
                aVarK.e(oVar.q());
            } else if (iN != 4) {
                switch (iN) {
                    case 500:
                        aVarK.c(oVar.q());
                        break;
                    case 501:
                        aVarK.g(oVar.k());
                        break;
                    case 502:
                        aVarK.d(oVar.k());
                        break;
                    case 503:
                        aVarK.a(oVar.q());
                        break;
                    default:
                        oVar.c();
                        break;
                }
            } else {
                aVarK.b(oVar.q());
            }
        }
        return aVarK.build();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Objects.equals(this.f63439a, dVar.f63439a) && Objects.equals(this.f63440b, dVar.f63440b) && Objects.equals(this.f63441c, dVar.f63441c) && Objects.equals(this.f63442d, dVar.f63442d) && Objects.equals(this.f63443e, dVar.f63443e) && Objects.equals(this.f63444f, dVar.f63444f) && this.f63445g == dVar.f63445g && this.f63446h == dVar.f63446h;
    }

    public String f() {
        return this.f63442d;
    }

    public int h() {
        return this.f63445g;
    }

    public int hashCode() {
        return Objects.hash(this.f63439a, this.f63440b, this.f63441c, this.f63442d, this.f63444f, Integer.valueOf(this.f63445g), Integer.valueOf(this.f63446h), this.f63443e);
    }

    public String i() {
        return this.f63444f;
    }

    public String j() {
        return this.f63439a;
    }

    public a k() {
        return new q(this);
    }

    public int l() {
        return this.f63446h;
    }

    public String m() {
        return this.f63441c;
    }

    public String toString() {
        return super.toString();
    }
}
