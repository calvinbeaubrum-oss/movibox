package fo;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoBuilder;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements io.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f65150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f65151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f65152c;

    /* JADX INFO: renamed from: fo.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @AutoBuilder
    public interface InterfaceC0676a {
        InterfaceC0676a a(String str);

        InterfaceC0676a b(long j11);

        a build();

        InterfaceC0676a c(int i11);
    }

    public a(long j11, String str, int i11) {
        this.f65150a = j11;
        this.f65151b = str;
        this.f65152c = i11;
    }

    public static InterfaceC0676a f() {
        i iVar = (i) new i().b(0L);
        iVar.f65183b = "";
        return iVar.c(-1);
    }

    @Override // io.l
    public void a(io.r rVar) {
        rVar.n(1, this.f65150a).u(2, this.f65151b).o(500, this.f65152c);
    }

    public int c() {
        return this.f65152c;
    }

    public String d() {
        return this.f65151b;
    }

    @Override // io.l
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public a b(io.o oVar) {
        InterfaceC0676a interfaceC0676aH = h();
        while (oVar.b()) {
            int iN = oVar.n();
            if (iN == 1) {
                interfaceC0676aH.b(oVar.j());
            } else if (iN == 2) {
                interfaceC0676aH.a(oVar.q());
            } else if (iN != 500) {
                oVar.c();
            } else {
                interfaceC0676aH.c(oVar.k());
            }
        }
        return interfaceC0676aH.build();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f65150a == aVar.f65150a && Objects.equals(this.f65151b, aVar.f65151b) && this.f65152c == aVar.f65152c;
    }

    public long g() {
        return this.f65150a;
    }

    public InterfaceC0676a h() {
        return new i(this);
    }

    public int hashCode() {
        return l.p.a(this.f65150a);
    }

    public String toString() {
        return super.toString();
    }
}
