package ho;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoBuilder;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements io.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f66651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f66652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f66653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f66654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f66655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f66656f;

    /* JADX INFO: renamed from: ho.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @AutoBuilder
    public static abstract class AbstractC0700a {
        public abstract int a();

        public abstract AbstractC0700a b(int i11);

        public abstract AbstractC0700a c(int i11);

        public abstract int d();

        public a e() {
            int iA = a();
            int iD = d();
            com.google.common.base.m.v((iA == -1 || (iA >= 0 && iA < g().size())) && (iD == -1 || (iD >= 0 && iD < h().size())));
            return f();
        }

        public abstract a f();

        public abstract List g();

        public abstract List h();

        public abstract AbstractC0700a i(String str);

        public abstract AbstractC0700a j(List<e> list);

        public abstract AbstractC0700a k(List<k> list);

        public abstract AbstractC0700a l(long j11);
    }

    public a(long j11, List list, int i11, List list2, int i12, String str) {
        this.f66651a = j11;
        this.f66652b = list;
        this.f66653c = i11;
        this.f66654d = list2;
        this.f66655e = i12;
        this.f66656f = str;
    }

    public static AbstractC0700a i() {
        return new l().l(0L).j(Collections.emptyList()).b(-1).k(Collections.emptyList()).c(-1).i("");
    }

    @Override // io.l
    public void a(io.r rVar) {
        rVar.n(1, this.f66651a).r(2, this.f66652b).o(3, this.f66653c).r(4, this.f66654d).o(5, this.f66655e).u(6, this.f66656f);
    }

    public int c() {
        return this.f66653c;
    }

    @Nullable
    public k d() {
        int i11 = this.f66655e;
        if (i11 == -1) {
            return null;
        }
        return (k) this.f66654d.get(i11);
    }

    public int e() {
        return this.f66655e;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f66651a == aVar.f66651a && Objects.equals(this.f66652b, aVar.f66652b) && this.f66653c == aVar.f66653c && Objects.equals(this.f66654d, aVar.f66654d) && this.f66655e == aVar.f66655e && Objects.equals(this.f66656f, aVar.f66656f);
    }

    @Override // io.l
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public a b(io.o oVar) {
        AbstractC0700a abstractC0700aL = l();
        while (oVar.b()) {
            switch (oVar.n()) {
                case 1:
                    abstractC0700aL.l(oVar.j());
                    break;
                case 2:
                    abstractC0700aL.j(oVar.m(abstractC0700aL.g(), this.f66652b, e.l().f()));
                    break;
                case 3:
                    abstractC0700aL.b(oVar.k());
                    break;
                case 4:
                    abstractC0700aL.k(oVar.m(abstractC0700aL.h(), this.f66654d, k.l().build()));
                    break;
                case 5:
                    abstractC0700aL.c(oVar.k());
                    break;
                case 6:
                    abstractC0700aL.i(oVar.q());
                    break;
                default:
                    oVar.c();
                    break;
            }
        }
        return abstractC0700aL.e();
    }

    public String g() {
        return this.f66656f;
    }

    public List<e> h() {
        return this.f66652b;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.f66651a), this.f66652b, Integer.valueOf(this.f66653c), this.f66654d, Integer.valueOf(this.f66655e), this.f66656f);
    }

    public List<k> j() {
        return this.f66654d;
    }

    public long k() {
        return this.f66651a;
    }

    public AbstractC0700a l() {
        return new l(this);
    }

    public String toString() {
        return super.toString();
    }
}
