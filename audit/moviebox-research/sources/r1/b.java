package r1;

import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.b2;
import androidx.compose.runtime.i2;
import androidx.compose.runtime.j2;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.m;
import androidx.compose.runtime.m0;
import androidx.compose.runtime.x0;
import androidx.compose.runtime.y;
import androidx.compose.runtime.y0;
import androidx.compose.runtime.z2;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f75022m = new a(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f75023n = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ComposerImpl f75024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r1.a f75025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f75026c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f75029f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f75030g;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f75035l;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m0 f75027d = new m0();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f75028e = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public z2<Object> f75031h = new z2<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f75032i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f75033j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f75034k = -1;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(ComposerImpl composerImpl, r1.a aVar) {
        this.f75024a = composerImpl;
        this.f75025b = aVar;
    }

    public static /* synthetic */ void F(b bVar, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        bVar.E(z11);
    }

    public static /* synthetic */ void J(b bVar, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        bVar.I(z11);
    }

    public final void A() {
        H();
        if (this.f75031h.d()) {
            this.f75031h.g();
        } else {
            this.f75030g++;
        }
    }

    public final void B() {
        C();
    }

    public final void C() {
        int i11 = this.f75030g;
        if (i11 > 0) {
            this.f75025b.H(i11);
            this.f75030g = 0;
        }
        if (this.f75031h.d()) {
            this.f75025b.k(this.f75031h.i());
            this.f75031h.a();
        }
    }

    public final void D() {
        J(this, false, 1, null);
        L();
    }

    public final void E(boolean z11) {
        I(z11);
    }

    public final void G(int i11, int i12, int i13) {
        B();
        this.f75025b.u(i11, i12, i13);
    }

    public final void H() {
        int i11 = this.f75035l;
        if (i11 > 0) {
            int i12 = this.f75032i;
            if (i12 >= 0) {
                K(i12, i11);
                this.f75032i = -1;
            } else {
                G(this.f75034k, this.f75033j, i11);
                this.f75033j = -1;
                this.f75034k = -1;
            }
            this.f75035l = 0;
        }
    }

    public final void I(boolean z11) {
        int iU = z11 ? r().u() : r().k();
        int i11 = iU - this.f75029f;
        if (!(i11 >= 0)) {
            k.s("Tried to seek backward");
        }
        if (i11 > 0) {
            this.f75025b.e(i11);
            this.f75029f = iU;
        }
    }

    public final void K(int i11, int i12) {
        B();
        this.f75025b.y(i11, i12);
    }

    public final void L() {
        i2 i2VarR;
        int iU;
        if (r().x() <= 0 || this.f75027d.h(-2) == (iU = (i2VarR = r()).u())) {
            return;
        }
        m();
        if (iU > 0) {
            androidx.compose.runtime.c cVarA = i2VarR.a(iU);
            this.f75027d.j(iU);
            l(cVarA);
        }
    }

    public final void M() {
        C();
        if (this.f75026c) {
            W();
            k();
        }
    }

    public final void N(y yVar, m mVar, y0 y0Var) {
        this.f75025b.v(yVar, mVar, y0Var);
    }

    public final void O(b2 b2Var) {
        this.f75025b.w(b2Var);
    }

    public final void P() {
        D();
        this.f75025b.x();
        this.f75029f += r().p();
    }

    public final void Q(int i11, int i12) {
        if (i12 > 0) {
            if (!(i11 >= 0)) {
                k.s("Invalid remove index " + i11);
            }
            if (this.f75032i == i11) {
                this.f75035l += i12;
                return;
            }
            H();
            this.f75032i = i11;
            this.f75035l = i12;
        }
    }

    public final void R() {
        this.f75025b.z();
    }

    public final void S() {
        this.f75026c = false;
        this.f75027d.a();
        this.f75029f = 0;
    }

    public final void T(r1.a aVar) {
        this.f75025b = aVar;
    }

    public final void U(boolean z11) {
        this.f75028e = z11;
    }

    public final void V(Function0<Unit> function0) {
        this.f75025b.A(function0);
    }

    public final void W() {
        this.f75025b.B();
    }

    public final void X(int i11) {
        if (i11 > 0) {
            D();
            this.f75025b.C(i11);
        }
    }

    public final void Y(Object obj, androidx.compose.runtime.c cVar, int i11) {
        this.f75025b.D(obj, cVar, i11);
    }

    public final void Z(Object obj) {
        F(this, false, 1, null);
        this.f75025b.E(obj);
    }

    public final void a(androidx.compose.runtime.c cVar, Object obj) {
        this.f75025b.f(cVar, obj);
    }

    public final <T, V> void a0(V v11, Function2<? super T, ? super V, Unit> function2) {
        B();
        this.f75025b.F(v11, function2);
    }

    public final void b(List<? extends Object> list, androidx.compose.runtime.internal.d dVar) {
        this.f75025b.g(list, dVar);
    }

    public final void b0(Object obj, int i11) {
        E(true);
        this.f75025b.G(obj, i11);
    }

    public final void c(x0 x0Var, m mVar, y0 y0Var, y0 y0Var2) {
        this.f75025b.h(x0Var, mVar, y0Var, y0Var2);
    }

    public final void c0(Object obj) {
        B();
        this.f75025b.I(obj);
    }

    public final void d() {
        F(this, false, 1, null);
        this.f75025b.i();
    }

    public final void e(androidx.compose.runtime.internal.d dVar, androidx.compose.runtime.c cVar) {
        C();
        this.f75025b.j(dVar, cVar);
    }

    public final void f(Function1<? super l, Unit> function1, l lVar) {
        this.f75025b.l(function1, lVar);
    }

    public final void g() {
        int iU = r().u();
        if (!(this.f75027d.h(-1) <= iU)) {
            k.s("Missed recording an endGroup");
        }
        if (this.f75027d.h(-1) == iU) {
            F(this, false, 1, null);
            this.f75027d.i();
            this.f75025b.m();
        }
    }

    public final void h() {
        this.f75025b.n();
        this.f75029f = 0;
    }

    public final void i() {
        H();
    }

    public final void j(int i11, int i12) {
        i();
        C();
        int iN = r().J(i12) ? 1 : r().N(i12);
        if (iN > 0) {
            Q(i11, iN);
        }
    }

    public final void k() {
        if (this.f75026c) {
            F(this, false, 1, null);
            F(this, false, 1, null);
            this.f75025b.m();
            this.f75026c = false;
        }
    }

    public final void l(androidx.compose.runtime.c cVar) {
        F(this, false, 1, null);
        this.f75025b.o(cVar);
        this.f75026c = true;
    }

    public final void m() {
        if (this.f75026c || !this.f75028e) {
            return;
        }
        F(this, false, 1, null);
        this.f75025b.p();
        this.f75026c = true;
    }

    public final void n() {
        C();
        if (this.f75027d.d()) {
            return;
        }
        k.s("Missed recording an endGroup()");
    }

    public final r1.a o() {
        return this.f75025b;
    }

    public final boolean p() {
        return this.f75028e;
    }

    public final boolean q() {
        return r().u() - this.f75029f < 0;
    }

    public final i2 r() {
        return this.f75024a.F0();
    }

    public final void s(r1.a aVar, androidx.compose.runtime.internal.d dVar) {
        this.f75025b.q(aVar, dVar);
    }

    public final void t(androidx.compose.runtime.c cVar, j2 j2Var) {
        C();
        D();
        H();
        this.f75025b.r(cVar, j2Var);
    }

    public final void u(androidx.compose.runtime.c cVar, j2 j2Var, c cVar2) {
        C();
        D();
        H();
        this.f75025b.s(cVar, j2Var, cVar2);
    }

    public final void v(int i11) {
        D();
        this.f75025b.t(i11);
    }

    public final void w(Object obj) {
        H();
        this.f75031h.h(obj);
    }

    public final void x(int i11, int i12, int i13) {
        if (i13 > 0) {
            int i14 = this.f75035l;
            if (i14 > 0 && this.f75033j == i11 - i14 && this.f75034k == i12 - i14) {
                this.f75035l = i14 + i13;
                return;
            }
            H();
            this.f75033j = i11;
            this.f75034k = i12;
            this.f75035l = i13;
        }
    }

    public final void y(int i11) {
        this.f75029f += i11 - r().k();
    }

    public final void z(int i11) {
        this.f75029f = i11;
    }
}
