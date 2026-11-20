package r1;

import androidx.compose.runtime.a2;
import androidx.compose.runtime.b2;
import androidx.compose.runtime.j2;
import androidx.compose.runtime.l;
import androidx.compose.runtime.m;
import androidx.compose.runtime.m2;
import androidx.compose.runtime.o1;
import androidx.compose.runtime.x0;
import androidx.compose.runtime.y;
import androidx.compose.runtime.y0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class a extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f75021a = new g();

    public final void A(Function0<Unit> function0) {
        g gVar = this.f75021a;
        d.a0 a0Var = d.a0.f75041c;
        gVar.y(a0Var);
        g.c.d(g.c.a(gVar), d.t.a(0), function0);
        if (gVar.f75083g == gVar.n(a0Var.b()) && gVar.f75084h == gVar.n(a0Var.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int iB = a0Var.b();
        int i11 = 0;
        for (int i12 = 0; i12 < iB; i12++) {
            if (((1 << i12) & gVar.f75083g) != 0) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(a0Var.e(d.q.a(i12)));
                i11++;
            }
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int iD = a0Var.d();
        int i13 = 0;
        for (int i14 = 0; i14 < iD; i14++) {
            if (((1 << i14) & gVar.f75084h) != 0) {
                if (i11 > 0) {
                    sb3.append(", ");
                }
                sb3.append(a0Var.f(d.t.a(i14)));
                i13++;
            }
        }
        String string2 = sb3.toString();
        Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + a0Var + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + string + ") and " + i13 + " object arguments (" + string2 + ").");
    }

    public final void B() {
        this.f75021a.x(d.b0.f75043c);
    }

    public final void C(int i11) {
        g gVar = this.f75021a;
        d.c0 c0Var = d.c0.f75045c;
        gVar.y(c0Var);
        g.c.c(g.c.a(gVar), d.q.a(0), i11);
        if (gVar.f75083g == gVar.n(c0Var.b()) && gVar.f75084h == gVar.n(c0Var.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int iB = c0Var.b();
        int i12 = 0;
        for (int i13 = 0; i13 < iB; i13++) {
            if (((1 << i13) & gVar.f75083g) != 0) {
                if (i12 > 0) {
                    sb2.append(", ");
                }
                sb2.append(c0Var.e(d.q.a(i13)));
                i12++;
            }
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int iD = c0Var.d();
        int i14 = 0;
        for (int i15 = 0; i15 < iD; i15++) {
            if (((1 << i15) & gVar.f75084h) != 0) {
                if (i12 > 0) {
                    sb3.append(", ");
                }
                sb3.append(c0Var.f(d.t.a(i15)));
                i14++;
            }
        }
        String string2 = sb3.toString();
        Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + c0Var + ". Not all arguments were provided. Missing " + i12 + " int arguments (" + string + ") and " + i14 + " object arguments (" + string2 + ").");
    }

    public final void D(Object obj, androidx.compose.runtime.c cVar, int i11) {
        g gVar = this.f75021a;
        d.d0 d0Var = d.d0.f75047c;
        gVar.y(d0Var);
        g gVarA = g.c.a(gVar);
        g.c.d(gVarA, d.t.a(0), obj);
        g.c.d(gVarA, d.t.a(1), cVar);
        g.c.c(gVarA, d.q.a(0), i11);
        if (gVar.f75083g == gVar.n(d0Var.b()) && gVar.f75084h == gVar.n(d0Var.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int iB = d0Var.b();
        int i12 = 0;
        for (int i13 = 0; i13 < iB; i13++) {
            if (((1 << i13) & gVar.f75083g) != 0) {
                if (i12 > 0) {
                    sb2.append(", ");
                }
                sb2.append(d0Var.e(d.q.a(i13)));
                i12++;
            }
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int iD = d0Var.d();
        int i14 = 0;
        for (int i15 = 0; i15 < iD; i15++) {
            if (((1 << i15) & gVar.f75084h) != 0) {
                if (i12 > 0) {
                    sb3.append(", ");
                }
                sb3.append(d0Var.f(d.t.a(i15)));
                i14++;
            }
        }
        String string2 = sb3.toString();
        Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + d0Var + ". Not all arguments were provided. Missing " + i12 + " int arguments (" + string + ") and " + i14 + " object arguments (" + string2 + ").");
    }

    public final void E(Object obj) {
        g gVar = this.f75021a;
        d.e0 e0Var = d.e0.f75049c;
        gVar.y(e0Var);
        g.c.d(g.c.a(gVar), d.t.a(0), obj);
        if (gVar.f75083g == gVar.n(e0Var.b()) && gVar.f75084h == gVar.n(e0Var.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int iB = e0Var.b();
        int i11 = 0;
        for (int i12 = 0; i12 < iB; i12++) {
            if (((1 << i12) & gVar.f75083g) != 0) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(e0Var.e(d.q.a(i12)));
                i11++;
            }
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int iD = e0Var.d();
        int i13 = 0;
        for (int i14 = 0; i14 < iD; i14++) {
            if (((1 << i14) & gVar.f75084h) != 0) {
                if (i11 > 0) {
                    sb3.append(", ");
                }
                sb3.append(e0Var.f(d.t.a(i14)));
                i13++;
            }
        }
        String string2 = sb3.toString();
        Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + e0Var + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + string + ") and " + i13 + " object arguments (" + string2 + ").");
    }

    public final <T, V> void F(V v11, Function2<? super T, ? super V, Unit> function2) {
        g gVar = this.f75021a;
        d.f0 f0Var = d.f0.f75051c;
        gVar.y(f0Var);
        g gVarA = g.c.a(gVar);
        g.c.d(gVarA, d.t.a(0), v11);
        int iA = d.t.a(1);
        Intrinsics.e(function2, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Unit>");
        g.c.d(gVarA, iA, (Function2) TypeIntrinsics.e(function2, 2));
        if (gVar.f75083g == gVar.n(f0Var.b()) && gVar.f75084h == gVar.n(f0Var.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int iB = f0Var.b();
        int i11 = 0;
        for (int i12 = 0; i12 < iB; i12++) {
            if (((1 << i12) & gVar.f75083g) != 0) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(f0Var.e(d.q.a(i12)));
                i11++;
            }
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int iD = f0Var.d();
        int i13 = 0;
        for (int i14 = 0; i14 < iD; i14++) {
            if (((1 << i14) & gVar.f75084h) != 0) {
                if (i11 > 0) {
                    sb3.append(", ");
                }
                sb3.append(f0Var.f(d.t.a(i14)));
                i13++;
            }
        }
        String string2 = sb3.toString();
        Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + f0Var + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + string + ") and " + i13 + " object arguments (" + string2 + ").");
    }

    public final void G(Object obj, int i11) {
        g gVar = this.f75021a;
        d.g0 g0Var = d.g0.f75053c;
        gVar.y(g0Var);
        g gVarA = g.c.a(gVar);
        g.c.d(gVarA, d.t.a(0), obj);
        g.c.c(gVarA, d.q.a(0), i11);
        if (gVar.f75083g == gVar.n(g0Var.b()) && gVar.f75084h == gVar.n(g0Var.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int iB = g0Var.b();
        int i12 = 0;
        for (int i13 = 0; i13 < iB; i13++) {
            if (((1 << i13) & gVar.f75083g) != 0) {
                if (i12 > 0) {
                    sb2.append(", ");
                }
                sb2.append(g0Var.e(d.q.a(i13)));
                i12++;
            }
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int iD = g0Var.d();
        int i14 = 0;
        for (int i15 = 0; i15 < iD; i15++) {
            if (((1 << i15) & gVar.f75084h) != 0) {
                if (i12 > 0) {
                    sb3.append(", ");
                }
                sb3.append(g0Var.f(d.t.a(i15)));
                i14++;
            }
        }
        String string2 = sb3.toString();
        Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + g0Var + ". Not all arguments were provided. Missing " + i12 + " int arguments (" + string + ") and " + i14 + " object arguments (" + string2 + ").");
    }

    public final void H(int i11) {
        g gVar = this.f75021a;
        d.h0 h0Var = d.h0.f75055c;
        gVar.y(h0Var);
        g.c.c(g.c.a(gVar), d.q.a(0), i11);
        if (gVar.f75083g == gVar.n(h0Var.b()) && gVar.f75084h == gVar.n(h0Var.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int iB = h0Var.b();
        int i12 = 0;
        for (int i13 = 0; i13 < iB; i13++) {
            if (((1 << i13) & gVar.f75083g) != 0) {
                if (i12 > 0) {
                    sb2.append(", ");
                }
                sb2.append(h0Var.e(d.q.a(i13)));
                i12++;
            }
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int iD = h0Var.d();
        int i14 = 0;
        for (int i15 = 0; i15 < iD; i15++) {
            if (((1 << i15) & gVar.f75084h) != 0) {
                if (i12 > 0) {
                    sb3.append(", ");
                }
                sb3.append(h0Var.f(d.t.a(i15)));
                i14++;
            }
        }
        String string2 = sb3.toString();
        Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + h0Var + ". Not all arguments were provided. Missing " + i12 + " int arguments (" + string + ") and " + i14 + " object arguments (" + string2 + ").");
    }

    public final void I(Object obj) {
        if (obj instanceof androidx.compose.runtime.h) {
            this.f75021a.x(d.i0.f75057c);
        }
    }

    public final void a() {
        this.f75021a.m();
    }

    public final void b(androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
        this.f75021a.r(fVar, m2Var, a2Var);
    }

    public final boolean c() {
        return this.f75021a.t();
    }

    public final boolean d() {
        return this.f75021a.u();
    }

    public final void e(int i11) {
        g gVar = this.f75021a;
        d.a aVar = d.a.f75040c;
        gVar.y(aVar);
        g.c.c(g.c.a(gVar), d.q.a(0), i11);
        if (gVar.f75083g == gVar.n(aVar.b()) && gVar.f75084h == gVar.n(aVar.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int iB = aVar.b();
        int i12 = 0;
        for (int i13 = 0; i13 < iB; i13++) {
            if (((1 << i13) & gVar.f75083g) != 0) {
                if (i12 > 0) {
                    sb2.append(", ");
                }
                sb2.append(aVar.e(d.q.a(i13)));
                i12++;
            }
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int iD = aVar.d();
        int i14 = 0;
        for (int i15 = 0; i15 < iD; i15++) {
            if (((1 << i15) & gVar.f75084h) != 0) {
                if (i12 > 0) {
                    sb3.append(", ");
                }
                sb3.append(aVar.f(d.t.a(i15)));
                i14++;
            }
        }
        String string2 = sb3.toString();
        Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + aVar + ". Not all arguments were provided. Missing " + i12 + " int arguments (" + string + ") and " + i14 + " object arguments (" + string2 + ").");
    }

    public final void f(androidx.compose.runtime.c cVar, Object obj) {
        g gVar = this.f75021a;
        d.b bVar = d.b.f75042c;
        gVar.y(bVar);
        g gVarA = g.c.a(gVar);
        g.c.d(gVarA, d.t.a(0), cVar);
        g.c.d(gVarA, d.t.a(1), obj);
        if (gVar.f75083g == gVar.n(bVar.b()) && gVar.f75084h == gVar.n(bVar.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int iB = bVar.b();
        int i11 = 0;
        for (int i12 = 0; i12 < iB; i12++) {
            if (((1 << i12) & gVar.f75083g) != 0) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(bVar.e(d.q.a(i12)));
                i11++;
            }
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int iD = bVar.d();
        int i13 = 0;
        for (int i14 = 0; i14 < iD; i14++) {
            if (((1 << i14) & gVar.f75084h) != 0) {
                if (i11 > 0) {
                    sb3.append(", ");
                }
                sb3.append(bVar.f(d.t.a(i14)));
                i13++;
            }
        }
        String string2 = sb3.toString();
        Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + bVar + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + string + ") and " + i13 + " object arguments (" + string2 + ").");
    }

    public final void g(List<? extends Object> list, androidx.compose.runtime.internal.d dVar) {
        if (!list.isEmpty()) {
            g gVar = this.f75021a;
            d.C0823d c0823d = d.C0823d.f75046c;
            gVar.y(c0823d);
            g gVarA = g.c.a(gVar);
            g.c.d(gVarA, d.t.a(1), list);
            g.c.d(gVarA, d.t.a(0), dVar);
            if (gVar.f75083g == gVar.n(c0823d.b()) && gVar.f75084h == gVar.n(c0823d.d())) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            int iB = c0823d.b();
            int i11 = 0;
            for (int i12 = 0; i12 < iB; i12++) {
                if (((1 << i12) & gVar.f75083g) != 0) {
                    if (i11 > 0) {
                        sb2.append(", ");
                    }
                    sb2.append(c0823d.e(d.q.a(i12)));
                    i11++;
                }
            }
            String string = sb2.toString();
            Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int iD = c0823d.d();
            int i13 = 0;
            for (int i14 = 0; i14 < iD; i14++) {
                if (((1 << i14) & gVar.f75084h) != 0) {
                    if (i11 > 0) {
                        sb3.append(", ");
                    }
                    sb3.append(c0823d.f(d.t.a(i14)));
                    i13++;
                }
            }
            String string2 = sb3.toString();
            Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
            o1.b("Error while pushing " + c0823d + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + string + ") and " + i13 + " object arguments (" + string2 + ").");
        }
    }

    public final void h(x0 x0Var, m mVar, y0 y0Var, y0 y0Var2) {
        g gVar = this.f75021a;
        d.e eVar = d.e.f75048c;
        gVar.y(eVar);
        g gVarA = g.c.a(gVar);
        g.c.d(gVarA, d.t.a(0), x0Var);
        g.c.d(gVarA, d.t.a(1), mVar);
        g.c.d(gVarA, d.t.a(3), y0Var2);
        g.c.d(gVarA, d.t.a(2), y0Var);
        if (gVar.f75083g == gVar.n(eVar.b()) && gVar.f75084h == gVar.n(eVar.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int iB = eVar.b();
        int i11 = 0;
        for (int i12 = 0; i12 < iB; i12++) {
            if (((1 << i12) & gVar.f75083g) != 0) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(eVar.e(d.q.a(i12)));
                i11++;
            }
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int iD = eVar.d();
        int i13 = 0;
        for (int i14 = 0; i14 < iD; i14++) {
            if (((1 << i14) & gVar.f75084h) != 0) {
                if (i11 > 0) {
                    sb3.append(", ");
                }
                sb3.append(eVar.f(d.t.a(i14)));
                i13++;
            }
        }
        String string2 = sb3.toString();
        Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + eVar + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + string + ") and " + i13 + " object arguments (" + string2 + ").");
    }

    public final void i() {
        this.f75021a.x(d.f.f75050c);
    }

    public final void j(androidx.compose.runtime.internal.d dVar, androidx.compose.runtime.c cVar) {
        g gVar = this.f75021a;
        d.g gVar2 = d.g.f75052c;
        gVar.y(gVar2);
        g gVarA = g.c.a(gVar);
        g.c.d(gVarA, d.t.a(0), dVar);
        g.c.d(gVarA, d.t.a(1), cVar);
        if (gVar.f75083g == gVar.n(gVar2.b()) && gVar.f75084h == gVar.n(gVar2.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int iB = gVar2.b();
        int i11 = 0;
        for (int i12 = 0; i12 < iB; i12++) {
            if (((1 << i12) & gVar.f75083g) != 0) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(gVar2.e(d.q.a(i12)));
                i11++;
            }
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int iD = gVar2.d();
        int i13 = 0;
        for (int i14 = 0; i14 < iD; i14++) {
            if (((1 << i14) & gVar.f75084h) != 0) {
                if (i11 > 0) {
                    sb3.append(", ");
                }
                sb3.append(gVar2.f(d.t.a(i14)));
                i13++;
            }
        }
        String string2 = sb3.toString();
        Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + gVar2 + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + string + ") and " + i13 + " object arguments (" + string2 + ").");
    }

    public final void k(Object[] objArr) {
        if (!(objArr.length == 0)) {
            g gVar = this.f75021a;
            d.h hVar = d.h.f75054c;
            gVar.y(hVar);
            g.c.d(g.c.a(gVar), d.t.a(0), objArr);
            if (gVar.f75083g == gVar.n(hVar.b()) && gVar.f75084h == gVar.n(hVar.d())) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            int iB = hVar.b();
            int i11 = 0;
            for (int i12 = 0; i12 < iB; i12++) {
                if (((1 << i12) & gVar.f75083g) != 0) {
                    if (i11 > 0) {
                        sb2.append(", ");
                    }
                    sb2.append(hVar.e(d.q.a(i12)));
                    i11++;
                }
            }
            String string = sb2.toString();
            Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int iD = hVar.d();
            int i13 = 0;
            for (int i14 = 0; i14 < iD; i14++) {
                if (((1 << i14) & gVar.f75084h) != 0) {
                    if (i11 > 0) {
                        sb3.append(", ");
                    }
                    sb3.append(hVar.f(d.t.a(i14)));
                    i13++;
                }
            }
            String string2 = sb3.toString();
            Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
            o1.b("Error while pushing " + hVar + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + string + ") and " + i13 + " object arguments (" + string2 + ").");
        }
    }

    public final void l(Function1<? super l, Unit> function1, l lVar) {
        g gVar = this.f75021a;
        d.i iVar = d.i.f75056c;
        gVar.y(iVar);
        g gVarA = g.c.a(gVar);
        g.c.d(gVarA, d.t.a(0), function1);
        g.c.d(gVarA, d.t.a(1), lVar);
        if (gVar.f75083g == gVar.n(iVar.b()) && gVar.f75084h == gVar.n(iVar.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int iB = iVar.b();
        int i11 = 0;
        for (int i12 = 0; i12 < iB; i12++) {
            if (((1 << i12) & gVar.f75083g) != 0) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(iVar.e(d.q.a(i12)));
                i11++;
            }
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int iD = iVar.d();
        int i13 = 0;
        for (int i14 = 0; i14 < iD; i14++) {
            if (((1 << i14) & gVar.f75084h) != 0) {
                if (i11 > 0) {
                    sb3.append(", ");
                }
                sb3.append(iVar.f(d.t.a(i14)));
                i13++;
            }
        }
        String string2 = sb3.toString();
        Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + iVar + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + string + ") and " + i13 + " object arguments (" + string2 + ").");
    }

    public final void m() {
        this.f75021a.x(d.j.f75058c);
    }

    public final void n() {
        this.f75021a.x(d.k.f75059c);
    }

    public final void o(androidx.compose.runtime.c cVar) {
        g gVar = this.f75021a;
        d.l lVar = d.l.f75060c;
        gVar.y(lVar);
        g.c.d(g.c.a(gVar), d.t.a(0), cVar);
        if (gVar.f75083g == gVar.n(lVar.b()) && gVar.f75084h == gVar.n(lVar.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int iB = lVar.b();
        int i11 = 0;
        for (int i12 = 0; i12 < iB; i12++) {
            if (((1 << i12) & gVar.f75083g) != 0) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(lVar.e(d.q.a(i12)));
                i11++;
            }
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int iD = lVar.d();
        int i13 = 0;
        for (int i14 = 0; i14 < iD; i14++) {
            if (((1 << i14) & gVar.f75084h) != 0) {
                if (i11 > 0) {
                    sb3.append(", ");
                }
                sb3.append(lVar.f(d.t.a(i14)));
                i13++;
            }
        }
        String string2 = sb3.toString();
        Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + lVar + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + string + ") and " + i13 + " object arguments (" + string2 + ").");
    }

    public final void p() {
        this.f75021a.x(d.m.f75061c);
    }

    public final void q(a aVar, androidx.compose.runtime.internal.d dVar) {
        if (aVar.d()) {
            g gVar = this.f75021a;
            d.c cVar = d.c.f75044c;
            gVar.y(cVar);
            g gVarA = g.c.a(gVar);
            g.c.d(gVarA, d.t.a(0), aVar);
            g.c.d(gVarA, d.t.a(1), dVar);
            if (gVar.f75083g == gVar.n(cVar.b()) && gVar.f75084h == gVar.n(cVar.d())) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            int iB = cVar.b();
            int i11 = 0;
            for (int i12 = 0; i12 < iB; i12++) {
                if (((1 << i12) & gVar.f75083g) != 0) {
                    if (i11 > 0) {
                        sb2.append(", ");
                    }
                    sb2.append(cVar.e(d.q.a(i12)));
                    i11++;
                }
            }
            String string = sb2.toString();
            Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int iD = cVar.d();
            int i13 = 0;
            for (int i14 = 0; i14 < iD; i14++) {
                if (((1 << i14) & gVar.f75084h) != 0) {
                    if (i11 > 0) {
                        sb3.append(", ");
                    }
                    sb3.append(cVar.f(d.t.a(i14)));
                    i13++;
                }
            }
            String string2 = sb3.toString();
            Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
            o1.b("Error while pushing " + cVar + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + string + ") and " + i13 + " object arguments (" + string2 + ").");
        }
    }

    public final void r(androidx.compose.runtime.c cVar, j2 j2Var) {
        g gVar = this.f75021a;
        d.o oVar = d.o.f75063c;
        gVar.y(oVar);
        g gVarA = g.c.a(gVar);
        g.c.d(gVarA, d.t.a(0), cVar);
        g.c.d(gVarA, d.t.a(1), j2Var);
        if (gVar.f75083g == gVar.n(oVar.b()) && gVar.f75084h == gVar.n(oVar.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int iB = oVar.b();
        int i11 = 0;
        for (int i12 = 0; i12 < iB; i12++) {
            if (((1 << i12) & gVar.f75083g) != 0) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(oVar.e(d.q.a(i12)));
                i11++;
            }
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int iD = oVar.d();
        int i13 = 0;
        for (int i14 = 0; i14 < iD; i14++) {
            if (((1 << i14) & gVar.f75084h) != 0) {
                if (i11 > 0) {
                    sb3.append(", ");
                }
                sb3.append(oVar.f(d.t.a(i14)));
                i13++;
            }
        }
        String string2 = sb3.toString();
        Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + oVar + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + string + ") and " + i13 + " object arguments (" + string2 + ").");
    }

    public final void s(androidx.compose.runtime.c cVar, j2 j2Var, c cVar2) {
        g gVar = this.f75021a;
        d.p pVar = d.p.f75064c;
        gVar.y(pVar);
        g gVarA = g.c.a(gVar);
        g.c.d(gVarA, d.t.a(0), cVar);
        g.c.d(gVarA, d.t.a(1), j2Var);
        g.c.d(gVarA, d.t.a(2), cVar2);
        if (gVar.f75083g == gVar.n(pVar.b()) && gVar.f75084h == gVar.n(pVar.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int iB = pVar.b();
        int i11 = 0;
        for (int i12 = 0; i12 < iB; i12++) {
            if (((1 << i12) & gVar.f75083g) != 0) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(pVar.e(d.q.a(i12)));
                i11++;
            }
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int iD = pVar.d();
        int i13 = 0;
        for (int i14 = 0; i14 < iD; i14++) {
            if (((1 << i14) & gVar.f75084h) != 0) {
                if (i11 > 0) {
                    sb3.append(", ");
                }
                sb3.append(pVar.f(d.t.a(i14)));
                i13++;
            }
        }
        String string2 = sb3.toString();
        Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + pVar + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + string + ") and " + i13 + " object arguments (" + string2 + ").");
    }

    public final void t(int i11) {
        g gVar = this.f75021a;
        d.r rVar = d.r.f75065c;
        gVar.y(rVar);
        g.c.c(g.c.a(gVar), d.q.a(0), i11);
        if (gVar.f75083g == gVar.n(rVar.b()) && gVar.f75084h == gVar.n(rVar.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int iB = rVar.b();
        int i12 = 0;
        for (int i13 = 0; i13 < iB; i13++) {
            if (((1 << i13) & gVar.f75083g) != 0) {
                if (i12 > 0) {
                    sb2.append(", ");
                }
                sb2.append(rVar.e(d.q.a(i13)));
                i12++;
            }
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int iD = rVar.d();
        int i14 = 0;
        for (int i15 = 0; i15 < iD; i15++) {
            if (((1 << i15) & gVar.f75084h) != 0) {
                if (i12 > 0) {
                    sb3.append(", ");
                }
                sb3.append(rVar.f(d.t.a(i15)));
                i14++;
            }
        }
        String string2 = sb3.toString();
        Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + rVar + ". Not all arguments were provided. Missing " + i12 + " int arguments (" + string + ") and " + i14 + " object arguments (" + string2 + ").");
    }

    public final void u(int i11, int i12, int i13) {
        g gVar = this.f75021a;
        d.s sVar = d.s.f75066c;
        gVar.y(sVar);
        g gVarA = g.c.a(gVar);
        g.c.c(gVarA, d.q.a(1), i11);
        g.c.c(gVarA, d.q.a(0), i12);
        g.c.c(gVarA, d.q.a(2), i13);
        if (gVar.f75083g == gVar.n(sVar.b()) && gVar.f75084h == gVar.n(sVar.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int iB = sVar.b();
        int i14 = 0;
        for (int i15 = 0; i15 < iB; i15++) {
            if (((1 << i15) & gVar.f75083g) != 0) {
                if (i14 > 0) {
                    sb2.append(", ");
                }
                sb2.append(sVar.e(d.q.a(i15)));
                i14++;
            }
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int iD = sVar.d();
        int i16 = 0;
        for (int i17 = 0; i17 < iD; i17++) {
            if (((1 << i17) & gVar.f75084h) != 0) {
                if (i14 > 0) {
                    sb3.append(", ");
                }
                sb3.append(sVar.f(d.t.a(i17)));
                i16++;
            }
        }
        String string2 = sb3.toString();
        Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + sVar + ". Not all arguments were provided. Missing " + i14 + " int arguments (" + string + ") and " + i16 + " object arguments (" + string2 + ").");
    }

    public final void v(y yVar, m mVar, y0 y0Var) {
        g gVar = this.f75021a;
        d.v vVar = d.v.f75068c;
        gVar.y(vVar);
        g gVarA = g.c.a(gVar);
        g.c.d(gVarA, d.t.a(0), yVar);
        g.c.d(gVarA, d.t.a(1), mVar);
        g.c.d(gVarA, d.t.a(2), y0Var);
        if (gVar.f75083g == gVar.n(vVar.b()) && gVar.f75084h == gVar.n(vVar.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int iB = vVar.b();
        int i11 = 0;
        for (int i12 = 0; i12 < iB; i12++) {
            if (((1 << i12) & gVar.f75083g) != 0) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(vVar.e(d.q.a(i12)));
                i11++;
            }
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int iD = vVar.d();
        int i13 = 0;
        for (int i14 = 0; i14 < iD; i14++) {
            if (((1 << i14) & gVar.f75084h) != 0) {
                if (i11 > 0) {
                    sb3.append(", ");
                }
                sb3.append(vVar.f(d.t.a(i14)));
                i13++;
            }
        }
        String string2 = sb3.toString();
        Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + vVar + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + string + ") and " + i13 + " object arguments (" + string2 + ").");
    }

    public final void w(b2 b2Var) {
        g gVar = this.f75021a;
        d.w wVar = d.w.f75069c;
        gVar.y(wVar);
        g.c.d(g.c.a(gVar), d.t.a(0), b2Var);
        if (gVar.f75083g == gVar.n(wVar.b()) && gVar.f75084h == gVar.n(wVar.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int iB = wVar.b();
        int i11 = 0;
        for (int i12 = 0; i12 < iB; i12++) {
            if (((1 << i12) & gVar.f75083g) != 0) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(wVar.e(d.q.a(i12)));
                i11++;
            }
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int iD = wVar.d();
        int i13 = 0;
        for (int i14 = 0; i14 < iD; i14++) {
            if (((1 << i14) & gVar.f75084h) != 0) {
                if (i11 > 0) {
                    sb3.append(", ");
                }
                sb3.append(wVar.f(d.t.a(i14)));
                i13++;
            }
        }
        String string2 = sb3.toString();
        Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + wVar + ". Not all arguments were provided. Missing " + i11 + " int arguments (" + string + ") and " + i13 + " object arguments (" + string2 + ").");
    }

    public final void x() {
        this.f75021a.x(d.x.f75070c);
    }

    public final void y(int i11, int i12) {
        g gVar = this.f75021a;
        d.y yVar = d.y.f75071c;
        gVar.y(yVar);
        g gVarA = g.c.a(gVar);
        g.c.c(gVarA, d.q.a(0), i11);
        g.c.c(gVarA, d.q.a(1), i12);
        if (gVar.f75083g == gVar.n(yVar.b()) && gVar.f75084h == gVar.n(yVar.d())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        int iB = yVar.b();
        int i13 = 0;
        for (int i14 = 0; i14 < iB; i14++) {
            if (((1 << i14) & gVar.f75083g) != 0) {
                if (i13 > 0) {
                    sb2.append(", ");
                }
                sb2.append(yVar.e(d.q.a(i14)));
                i13++;
            }
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int iD = yVar.d();
        int i15 = 0;
        for (int i16 = 0; i16 < iD; i16++) {
            if (((1 << i16) & gVar.f75084h) != 0) {
                if (i13 > 0) {
                    sb3.append(", ");
                }
                sb3.append(yVar.f(d.t.a(i16)));
                i15++;
            }
        }
        String string2 = sb3.toString();
        Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + yVar + ". Not all arguments were provided. Missing " + i13 + " int arguments (" + string + ") and " + i15 + " object arguments (" + string2 + ").");
    }

    public final void z() {
        this.f75021a.x(d.z.f75072c);
    }
}
