package fo;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoBuilder;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements io.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f65153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f65154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f65155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f65156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f65157e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f65158f;

    /* JADX INFO: compiled from: source.java */
    @AutoBuilder
    public interface a {
        a a(String str);

        a b(int i11);

        b build();

        a c(String str);

        a d(String str);

        a e(String str);

        a f(long j11);
    }

    public b(String str, String str2, String str3, String str4, int i11, long j11) {
        this.f65153a = str;
        this.f65154b = str2;
        this.f65155c = str3;
        this.f65156d = str4;
        this.f65157e = i11;
        this.f65158f = j11;
    }

    public static a g() {
        j jVar = new j();
        jVar.f65186a = "";
        jVar.f65187b = "";
        jVar.f65188c = "";
        jVar.f65189d = "";
        return ((j) jVar.b(0)).f(0L);
    }

    @Override // io.l
    public void a(io.r rVar) {
        rVar.u(1, this.f65153a).u(2, this.f65154b).u(3, "Android").u(4, this.f65155c).s(5, this.f65157e).n(6, this.f65158f).u(500, this.f65156d);
    }

    public int c() {
        return this.f65157e;
    }

    public String d() {
        return this.f65153a;
    }

    @Override // io.l
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public b b(io.o oVar) {
        a aVarJ = j();
        while (oVar.b()) {
            int iN = oVar.n();
            if (iN == 1) {
                aVarJ.e(oVar.q());
            } else if (iN == 2) {
                aVarJ.d(oVar.q());
            } else if (iN == 500) {
                aVarJ.c(oVar.q());
            } else if (iN == 4) {
                aVarJ.a(oVar.q());
            } else if (iN == 5) {
                aVarJ.b(oVar.o());
            } else if (iN != 6) {
                oVar.c();
            } else {
                aVarJ.f(oVar.j());
            }
        }
        return aVarJ.build();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Objects.equals(this.f65153a, bVar.f65153a) && Objects.equals(this.f65154b, bVar.f65154b) && Objects.equals(this.f65155c, bVar.f65155c) && Objects.equals(this.f65156d, bVar.f65156d) && this.f65157e == bVar.f65157e && this.f65158f == bVar.f65158f;
    }

    public String f() {
        return this.f65154b;
    }

    public String h() {
        return this.f65155c;
    }

    public int hashCode() {
        return Objects.hash(this.f65153a, this.f65154b, this.f65155c);
    }

    public String i() {
        return this.f65156d;
    }

    public a j() {
        return new j(this);
    }

    public long k() {
        return this.f65158f;
    }

    public String toString() {
        return super.toString();
    }
}
