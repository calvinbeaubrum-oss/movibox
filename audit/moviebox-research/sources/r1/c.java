package r1;

import androidx.compose.runtime.a2;
import androidx.compose.runtime.k;
import androidx.compose.runtime.m2;
import androidx.compose.runtime.o1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class c extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f75036a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f75037b = new g();

    public final void a() {
        this.f75037b.m();
        this.f75036a.m();
    }

    public final void b(Function0<? extends Object> function0, int i11, androidx.compose.runtime.c cVar) {
        g gVar = this.f75036a;
        d.n nVar = d.n.f75062c;
        gVar.y(nVar);
        g gVarA = g.c.a(gVar);
        g.c.d(gVarA, d.t.a(0), function0);
        g.c.c(gVarA, d.q.a(0), i11);
        int i12 = 1;
        g.c.d(gVarA, d.t.a(1), cVar);
        if (!(gVar.f75083g == gVar.n(nVar.b()) && gVar.f75084h == gVar.n(nVar.d()))) {
            StringBuilder sb2 = new StringBuilder();
            int iB = nVar.b();
            int i13 = 0;
            int i14 = 0;
            while (i14 < iB) {
                if (((i12 << i14) & gVar.f75083g) != 0) {
                    if (i13 > 0) {
                        sb2.append(", ");
                    }
                    sb2.append(nVar.e(d.q.a(i14)));
                    i13++;
                }
                i14++;
                i12 = 1;
            }
            String string = sb2.toString();
            Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int iD = nVar.d();
            int i15 = 0;
            int i16 = 0;
            while (i16 < iD) {
                if (((1 << i16) & gVar.f75084h) != 0) {
                    if (i13 > 0) {
                        sb3.append(", ");
                    }
                    sb3.append(nVar.f(d.t.a(i16)));
                    i15++;
                }
                i16++;
                gVar = gVar;
            }
            String string2 = sb3.toString();
            Intrinsics.f(string2, "StringBuilder().apply(builderAction).toString()");
            o1.b("Error while pushing " + nVar + ". Not all arguments were provided. Missing " + i13 + " int arguments (" + string + ") and " + i15 + " object arguments (" + string2 + ").");
        }
        g gVar2 = this.f75037b;
        d.u uVar = d.u.f75067c;
        gVar2.y(uVar);
        g gVarA2 = g.c.a(gVar2);
        g.c.c(gVarA2, d.q.a(0), i11);
        g.c.d(gVarA2, d.t.a(0), cVar);
        if (gVar2.f75083g == gVar2.n(uVar.b()) && gVar2.f75084h == gVar2.n(uVar.d())) {
            return;
        }
        StringBuilder sb4 = new StringBuilder();
        int iB2 = uVar.b();
        int i17 = 0;
        for (int i18 = 0; i18 < iB2; i18++) {
            if (((1 << i18) & gVar2.f75083g) != 0) {
                if (i17 > 0) {
                    sb4.append(", ");
                }
                sb4.append(uVar.e(d.q.a(i18)));
                i17++;
            }
        }
        String string3 = sb4.toString();
        Intrinsics.f(string3, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb5 = new StringBuilder();
        int iD2 = uVar.d();
        int i19 = 0;
        int i21 = 0;
        while (i21 < iD2) {
            if (((1 << i21) & gVar2.f75084h) != 0) {
                if (i17 > 0) {
                    sb5.append(", ");
                }
                sb5.append(uVar.f(d.t.a(i21)));
                i19++;
            }
            i21++;
            gVar2 = gVar2;
        }
        String string4 = sb5.toString();
        Intrinsics.f(string4, "StringBuilder().apply(builderAction).toString()");
        o1.b("Error while pushing " + uVar + ". Not all arguments were provided. Missing " + i17 + " int arguments (" + string3 + ") and " + i19 + " object arguments (" + string4 + ").");
    }

    public final void c() {
        if (!this.f75037b.u()) {
            k.s("Cannot end node insertion, there are no pending operations that can be realized.");
        }
        this.f75037b.w(this.f75036a);
    }

    public final void d(androidx.compose.runtime.f<?> fVar, m2 m2Var, a2 a2Var) {
        if (!this.f75037b.t()) {
            k.s("FixupList has pending fixup operations that were not realized. Were there mismatched insertNode() and endNodeInsert() calls?");
        }
        this.f75036a.r(fVar, m2Var, a2Var);
    }

    public final boolean e() {
        return this.f75036a.t();
    }

    public final <V, T> void f(V v11, Function2<? super T, ? super V, Unit> function2) {
        g gVar = this.f75036a;
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
}
