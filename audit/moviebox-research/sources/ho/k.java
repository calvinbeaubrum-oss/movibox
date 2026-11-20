package ho;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoBuilder;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class k implements io.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f66704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f66705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f66706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f66707d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f66708e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f66709f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f66710g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f66711h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f66712i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f66713j;

    /* JADX INFO: compiled from: source.java */
    @AutoBuilder
    public interface a {
        a a(String str);

        a b(String str);

        k build();

        a c(String str);

        a d(int i11);

        a e(int i11);

        a f(String str);

        a g(int i11);

        a h(String str);

        a i(String str);

        a j(String str);
    }

    public k(int i11, int i12, int i13, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f66704a = i11;
        this.f66705b = i12;
        this.f66706c = i13;
        this.f66707d = str;
        this.f66708e = str2;
        this.f66709f = str3;
        this.f66710g = str4;
        this.f66711h = str5;
        this.f66712i = str6;
        this.f66713j = str7;
    }

    public static a l() {
        return ((n) ((n) new n().d(-1)).g(0)).e(-1).h("").b("").j("").a("").i("").f("").c("");
    }

    @Override // io.l
    public void a(io.r rVar) {
        rVar.o(1, this.f66704a).s(2, this.f66705b).o(500, this.f66706c).u(3, this.f66707d).u(4, this.f66708e).u(5, this.f66709f).u(6, this.f66710g).u(7, this.f66711h).u(8, this.f66712i).u(9, this.f66713j);
    }

    public int c() {
        return this.f66706c;
    }

    public String d() {
        return this.f66707d;
    }

    public int e() {
        return this.f66705b;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f66704a == kVar.f66704a && this.f66705b == kVar.f66705b && this.f66706c == kVar.f66706c && Objects.equals(this.f66707d, kVar.f66707d) && Objects.equals(this.f66708e, kVar.f66708e) && Objects.equals(this.f66709f, kVar.f66709f) && Objects.equals(this.f66710g, kVar.f66710g) && Objects.equals(this.f66711h, kVar.f66711h) && Objects.equals(this.f66712i, kVar.f66712i) && Objects.equals(this.f66713j, kVar.f66713j);
    }

    public String f() {
        return this.f66710g;
    }

    public int g() {
        return this.f66704a;
    }

    @Override // io.l
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public k b(io.o oVar) {
        a aVarO = o();
        while (oVar.b()) {
            int iN = oVar.n();
            if (iN != 500) {
                switch (iN) {
                    case 1:
                        aVarO.d(oVar.k());
                        break;
                    case 2:
                        aVarO.g(oVar.o());
                        break;
                    case 3:
                        aVarO.h(oVar.q());
                        break;
                    case 4:
                        aVarO.b(oVar.q());
                        break;
                    case 5:
                        aVarO.j(oVar.q());
                        break;
                    case 6:
                        aVarO.a(oVar.q());
                        break;
                    case 7:
                        aVarO.i(oVar.q());
                        break;
                    case 8:
                        aVarO.f(oVar.q());
                        break;
                    case 9:
                        aVarO.c(oVar.q());
                        break;
                    default:
                        oVar.c();
                        break;
                }
            } else {
                aVarO.e(oVar.k());
            }
        }
        return aVarO.build();
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f66704a), Integer.valueOf(this.f66705b), Integer.valueOf(this.f66706c), this.f66707d, this.f66708e, this.f66709f, this.f66710g, this.f66711h, this.f66712i, this.f66713j);
    }

    public String i() {
        return this.f66713j;
    }

    public String j() {
        return this.f66711h;
    }

    public String k() {
        return this.f66712i;
    }

    public String m() {
        return this.f66708e;
    }

    public String n() {
        return this.f66709f;
    }

    public a o() {
        return new n(this);
    }

    public String toString() {
        return super.toString();
    }
}
