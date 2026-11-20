package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.g4;
import androidx.compose.ui.graphics.h4;
import androidx.compose.ui.graphics.i4;
import androidx.compose.ui.graphics.o1;
import androidx.compose.ui.graphics.q1;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.x1;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import q2.t;
import q2.u;

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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g4 f4427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o1 f4428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q2.e f4429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LayoutDirection f4430d = LayoutDirection.Ltr;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f4431e = t.f74253b.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4432f = h4.f4148b.b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final z1.a f4433g = new z1.a();

    public final void a(z1.g gVar) {
        z1.f.j(gVar, w1.f4564b.a(), 0L, 0L, 0.0f, null, null, e1.f4102a.a(), 62, null);
    }

    public final void b(int i11, long j11, q2.e eVar, LayoutDirection layoutDirection, Function1<? super z1.g, Unit> function1) {
        this.f4429c = eVar;
        this.f4430d = layoutDirection;
        g4 g4VarB = this.f4427a;
        o1 o1VarA = this.f4428b;
        if (g4VarB == null || o1VarA == null || t.g(j11) > g4VarB.getWidth() || t.f(j11) > g4VarB.getHeight() || !h4.i(this.f4432f, i11)) {
            g4VarB = i4.b(t.g(j11), t.f(j11), i11, false, null, 24, null);
            o1VarA = q1.a(g4VarB);
            this.f4427a = g4VarB;
            this.f4428b = o1VarA;
            this.f4432f = i11;
        }
        this.f4431e = j11;
        z1.a aVar = this.f4433g;
        long jD = u.d(j11);
        z1.a.C0925a c0925aD = aVar.D();
        q2.e eVarA = c0925aD.a();
        LayoutDirection layoutDirectionB = c0925aD.b();
        o1 o1VarC = c0925aD.c();
        long jD2 = c0925aD.d();
        z1.a.C0925a c0925aD2 = aVar.D();
        c0925aD2.j(eVar);
        c0925aD2.k(layoutDirection);
        c0925aD2.i(o1VarA);
        c0925aD2.l(jD);
        o1VarA.d();
        a(aVar);
        function1.invoke(aVar);
        o1VarA.k();
        z1.a.C0925a c0925aD3 = aVar.D();
        c0925aD3.j(eVarA);
        c0925aD3.k(layoutDirectionB);
        c0925aD3.i(o1VarC);
        c0925aD3.l(jD2);
        g4VarB.a();
    }

    public final void c(z1.g gVar, float f11, x1 x1Var) {
        g4 g4Var = this.f4427a;
        if (!(g4Var != null)) {
            h2.a.b("drawCachedImage must be invoked first before attempting to draw the result into another destination");
        }
        z1.f.e(gVar, g4Var, 0L, this.f4431e, 0L, 0L, f11, null, x1Var, 0, 0, 858, null);
    }

    public final g4 d() {
        return this.f4427a;
    }
}
