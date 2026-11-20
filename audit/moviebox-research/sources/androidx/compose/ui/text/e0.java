package androidx.compose.ui.text;

import androidx.compose.ui.graphics.b5;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.w1;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class e0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f5774d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e0 f5775e = new e0(0, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777215, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f5776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f5777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f5778c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e0 a() {
            return e0.f5775e;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e0(long j11, long j12, androidx.compose.ui.text.font.u uVar, androidx.compose.ui.text.font.q qVar, androidx.compose.ui.text.font.r rVar, androidx.compose.ui.text.font.i iVar, String str, long j13, androidx.compose.ui.text.style.a aVar, androidx.compose.ui.text.style.m mVar, p2.i iVar2, long j14, androidx.compose.ui.text.style.i iVar3, b5 b5Var, androidx.compose.ui.text.style.h hVar, androidx.compose.ui.text.style.j jVar, long j15, androidx.compose.ui.text.style.n nVar, x xVar, androidx.compose.ui.text.style.g gVar, androidx.compose.ui.text.style.e eVar, androidx.compose.ui.text.style.d dVar) {
        this(new y(j11, j12, uVar, qVar, rVar, iVar, str, j13, aVar, mVar, iVar2, j14, iVar3, b5Var, null, null, 32768, null), new r(hVar != null ? hVar.n() : androidx.compose.ui.text.style.h.f6101b.g(), jVar != null ? jVar.m() : androidx.compose.ui.text.style.j.f6115b.f(), j15, nVar, xVar != null ? xVar.a() : null, gVar, eVar != null ? eVar.l() : androidx.compose.ui.text.style.e.f6066b.b(), dVar != null ? dVar.j() : androidx.compose.ui.text.style.d.f6061b.c(), null, 256, null), xVar);
        if (xVar != null) {
            xVar.b();
        }
    }

    public /* synthetic */ e0(long j11, long j12, androidx.compose.ui.text.font.u uVar, androidx.compose.ui.text.font.q qVar, androidx.compose.ui.text.font.r rVar, androidx.compose.ui.text.font.i iVar, String str, long j13, androidx.compose.ui.text.style.a aVar, androidx.compose.ui.text.style.m mVar, p2.i iVar2, long j14, androidx.compose.ui.text.style.i iVar3, b5 b5Var, androidx.compose.ui.text.style.h hVar, androidx.compose.ui.text.style.j jVar, long j15, androidx.compose.ui.text.style.n nVar, x xVar, androidx.compose.ui.text.style.g gVar, androidx.compose.ui.text.style.e eVar, androidx.compose.ui.text.style.d dVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? w1.f4564b.e() : j11, (i11 & 2) != 0 ? q2.w.f74257b.a() : j12, (i11 & 4) != 0 ? null : uVar, (i11 & 8) != 0 ? null : qVar, (i11 & 16) != 0 ? null : rVar, (i11 & 32) != 0 ? null : iVar, (i11 & 64) != 0 ? null : str, (i11 & 128) != 0 ? q2.w.f74257b.a() : j13, (i11 & 256) != 0 ? null : aVar, (i11 & 512) != 0 ? null : mVar, (i11 & 1024) != 0 ? null : iVar2, (i11 & 2048) != 0 ? w1.f4564b.e() : j14, (i11 & 4096) != 0 ? null : iVar3, (i11 & 8192) != 0 ? null : b5Var, (i11 & 16384) != 0 ? null : hVar, (i11 & 32768) != 0 ? null : jVar, (i11 & 65536) != 0 ? q2.w.f74257b.a() : j15, (i11 & 131072) != 0 ? null : nVar, (i11 & 262144) != 0 ? null : xVar, (i11 & 524288) != 0 ? null : gVar, (i11 & 1048576) != 0 ? null : eVar, (i11 & 2097152) != 0 ? null : dVar, null);
    }

    @Deprecated
    public /* synthetic */ e0(long j11, long j12, androidx.compose.ui.text.font.u uVar, androidx.compose.ui.text.font.q qVar, androidx.compose.ui.text.font.r rVar, androidx.compose.ui.text.font.i iVar, String str, long j13, androidx.compose.ui.text.style.a aVar, androidx.compose.ui.text.style.m mVar, p2.i iVar2, long j14, androidx.compose.ui.text.style.i iVar3, b5 b5Var, androidx.compose.ui.text.style.h hVar, androidx.compose.ui.text.style.j jVar, long j15, androidx.compose.ui.text.style.n nVar, x xVar, androidx.compose.ui.text.style.g gVar, androidx.compose.ui.text.style.e eVar, androidx.compose.ui.text.style.d dVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, uVar, qVar, rVar, iVar, str, j13, aVar, mVar, iVar2, j14, iVar3, b5Var, hVar, jVar, j15, nVar, xVar, gVar, eVar, dVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e0(long j11, long j12, androidx.compose.ui.text.font.u uVar, androidx.compose.ui.text.font.q qVar, androidx.compose.ui.text.font.r rVar, androidx.compose.ui.text.font.i iVar, String str, long j13, androidx.compose.ui.text.style.a aVar, androidx.compose.ui.text.style.m mVar, p2.i iVar2, long j14, androidx.compose.ui.text.style.i iVar3, b5 b5Var, z1.h hVar, int i11, int i12, long j15, androidx.compose.ui.text.style.n nVar, x xVar, androidx.compose.ui.text.style.g gVar, int i13, int i14, androidx.compose.ui.text.style.o oVar) {
        this(new y(j11, j12, uVar, qVar, rVar, iVar, str, j13, aVar, mVar, iVar2, j14, iVar3, b5Var, (w) null, hVar, (DefaultConstructorMarker) null), new r(i11, i12, j15, nVar, xVar != null ? xVar.a() : null, gVar, i13, i14, oVar, null), xVar);
        if (xVar != null) {
            xVar.b();
        }
    }

    public /* synthetic */ e0(long j11, long j12, androidx.compose.ui.text.font.u uVar, androidx.compose.ui.text.font.q qVar, androidx.compose.ui.text.font.r rVar, androidx.compose.ui.text.font.i iVar, String str, long j13, androidx.compose.ui.text.style.a aVar, androidx.compose.ui.text.style.m mVar, p2.i iVar2, long j14, androidx.compose.ui.text.style.i iVar3, b5 b5Var, z1.h hVar, int i11, int i12, long j15, androidx.compose.ui.text.style.n nVar, x xVar, androidx.compose.ui.text.style.g gVar, int i13, int i14, androidx.compose.ui.text.style.o oVar, int i15, DefaultConstructorMarker defaultConstructorMarker) {
        this((i15 & 1) != 0 ? w1.f4564b.e() : j11, (i15 & 2) != 0 ? q2.w.f74257b.a() : j12, (i15 & 4) != 0 ? null : uVar, (i15 & 8) != 0 ? null : qVar, (i15 & 16) != 0 ? null : rVar, (i15 & 32) != 0 ? null : iVar, (i15 & 64) != 0 ? null : str, (i15 & 128) != 0 ? q2.w.f74257b.a() : j13, (i15 & 256) != 0 ? null : aVar, (i15 & 512) != 0 ? null : mVar, (i15 & 1024) != 0 ? null : iVar2, (i15 & 2048) != 0 ? w1.f4564b.e() : j14, (i15 & 4096) != 0 ? null : iVar3, (i15 & 8192) != 0 ? null : b5Var, (i15 & 16384) != 0 ? null : hVar, (i15 & 32768) != 0 ? androidx.compose.ui.text.style.h.f6101b.g() : i11, (i15 & 65536) != 0 ? androidx.compose.ui.text.style.j.f6115b.f() : i12, (i15 & 131072) != 0 ? q2.w.f74257b.a() : j15, (i15 & 262144) != 0 ? null : nVar, (i15 & 524288) != 0 ? null : xVar, (i15 & 1048576) != 0 ? null : gVar, (i15 & 2097152) != 0 ? androidx.compose.ui.text.style.e.f6066b.b() : i13, (i15 & 4194304) != 0 ? androidx.compose.ui.text.style.d.f6061b.c() : i14, (i15 & 8388608) != 0 ? null : oVar, null);
    }

    public /* synthetic */ e0(long j11, long j12, androidx.compose.ui.text.font.u uVar, androidx.compose.ui.text.font.q qVar, androidx.compose.ui.text.font.r rVar, androidx.compose.ui.text.font.i iVar, String str, long j13, androidx.compose.ui.text.style.a aVar, androidx.compose.ui.text.style.m mVar, p2.i iVar2, long j14, androidx.compose.ui.text.style.i iVar3, b5 b5Var, z1.h hVar, int i11, int i12, long j15, androidx.compose.ui.text.style.n nVar, x xVar, androidx.compose.ui.text.style.g gVar, int i13, int i14, androidx.compose.ui.text.style.o oVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, uVar, qVar, rVar, iVar, str, j13, aVar, mVar, iVar2, j14, iVar3, b5Var, hVar, i11, i12, j15, nVar, xVar, gVar, i13, i14, oVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e0(y yVar, r rVar) {
        this(yVar, rVar, f0.b(null, rVar.g()));
        yVar.q();
    }

    public e0(y yVar, r rVar, x xVar) {
        this.f5776a = yVar;
        this.f5777b = rVar;
        this.f5778c = xVar;
    }

    public final androidx.compose.ui.text.style.i A() {
        return this.f5776a.s();
    }

    public final int B() {
        return this.f5777b.i();
    }

    public final androidx.compose.ui.text.style.m C() {
        return this.f5776a.u();
    }

    public final androidx.compose.ui.text.style.n D() {
        return this.f5777b.j();
    }

    public final androidx.compose.ui.text.style.o E() {
        return this.f5777b.k();
    }

    public final boolean F(e0 e0Var) {
        return this == e0Var || this.f5776a.w(e0Var.f5776a);
    }

    public final boolean G(e0 e0Var) {
        return this == e0Var || (Intrinsics.b(this.f5777b, e0Var.f5777b) && this.f5776a.v(e0Var.f5776a));
    }

    public final e0 H(r rVar) {
        return new e0(M(), L().l(rVar));
    }

    public final e0 I(e0 e0Var) {
        return (e0Var == null || Intrinsics.b(e0Var, f5775e)) ? this : new e0(M().x(e0Var.M()), L().l(e0Var.L()));
    }

    public final e0 J(long j11, long j12, androidx.compose.ui.text.font.u uVar, androidx.compose.ui.text.font.q qVar, androidx.compose.ui.text.font.r rVar, androidx.compose.ui.text.font.i iVar, String str, long j13, androidx.compose.ui.text.style.a aVar, androidx.compose.ui.text.style.m mVar, p2.i iVar2, long j14, androidx.compose.ui.text.style.i iVar3, b5 b5Var, z1.h hVar, int i11, int i12, long j15, androidx.compose.ui.text.style.n nVar, androidx.compose.ui.text.style.g gVar, int i13, int i14, x xVar, androidx.compose.ui.text.style.o oVar) {
        y yVar = this.f5776a;
        if (xVar != null) {
            xVar.b();
        }
        y yVarB = SpanStyleKt.b(yVar, j11, null, Float.NaN, j12, uVar, qVar, rVar, iVar, str, j13, aVar, mVar, iVar2, j14, iVar3, b5Var, null, hVar);
        r rVarA = s.a(this.f5777b, i11, i12, j15, nVar, xVar != null ? xVar.a() : null, gVar, i13, i14, oVar);
        return (this.f5776a == yVarB && this.f5777b == rVarA) ? this : new e0(yVarB, rVarA);
    }

    public final r L() {
        return this.f5777b;
    }

    public final y M() {
        return this.f5776a;
    }

    @Deprecated
    public final /* synthetic */ e0 b(long j11, long j12, androidx.compose.ui.text.font.u uVar, androidx.compose.ui.text.font.q qVar, androidx.compose.ui.text.font.r rVar, androidx.compose.ui.text.font.i iVar, String str, long j13, androidx.compose.ui.text.style.a aVar, androidx.compose.ui.text.style.m mVar, p2.i iVar2, long j14, androidx.compose.ui.text.style.i iVar3, b5 b5Var, androidx.compose.ui.text.style.h hVar, androidx.compose.ui.text.style.j jVar, long j15, androidx.compose.ui.text.style.n nVar, x xVar, androidx.compose.ui.text.style.g gVar, androidx.compose.ui.text.style.e eVar, androidx.compose.ui.text.style.d dVar) {
        androidx.compose.ui.text.style.l lVarT = w1.m(j11, this.f5776a.g()) ? this.f5776a.t() : androidx.compose.ui.text.style.l.f6123a.b(j11);
        if (xVar != null) {
            xVar.b();
        }
        return new e0(new y(lVarT, j12, uVar, qVar, rVar, iVar, str, j13, aVar, mVar, iVar2, j14, iVar3, b5Var, (w) null, i(), (DefaultConstructorMarker) null), new r(hVar != null ? hVar.n() : androidx.compose.ui.text.style.h.f6101b.g(), jVar != null ? jVar.m() : androidx.compose.ui.text.style.j.f6115b.f(), j15, nVar, xVar != null ? xVar.a() : null, gVar, eVar != null ? eVar.l() : androidx.compose.ui.text.style.e.f6066b.b(), dVar != null ? dVar.j() : androidx.compose.ui.text.style.d.f6061b.c(), E(), null), xVar);
    }

    public final float d() {
        return this.f5776a.c();
    }

    public final long e() {
        return this.f5776a.d();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return Intrinsics.b(this.f5776a, e0Var.f5776a) && Intrinsics.b(this.f5777b, e0Var.f5777b) && Intrinsics.b(this.f5778c, e0Var.f5778c);
    }

    public final androidx.compose.ui.text.style.a f() {
        return this.f5776a.e();
    }

    public final l1 g() {
        return this.f5776a.f();
    }

    public final long h() {
        return this.f5776a.g();
    }

    public int hashCode() {
        int iHashCode = ((this.f5776a.hashCode() * 31) + this.f5777b.hashCode()) * 31;
        x xVar = this.f5778c;
        return iHashCode + (xVar != null ? xVar.hashCode() : 0);
    }

    public final z1.h i() {
        return this.f5776a.h();
    }

    public final androidx.compose.ui.text.font.i j() {
        return this.f5776a.i();
    }

    public final String k() {
        return this.f5776a.j();
    }

    public final long l() {
        return this.f5776a.k();
    }

    public final androidx.compose.ui.text.font.q m() {
        return this.f5776a.l();
    }

    public final androidx.compose.ui.text.font.r n() {
        return this.f5776a.m();
    }

    public final androidx.compose.ui.text.font.u o() {
        return this.f5776a.n();
    }

    public final int p() {
        return this.f5777b.c();
    }

    public final long q() {
        return this.f5776a.o();
    }

    public final int r() {
        return this.f5777b.d();
    }

    public final long s() {
        return this.f5777b.e();
    }

    public final androidx.compose.ui.text.style.g t() {
        return this.f5777b.f();
    }

    public String toString() {
        return "TextStyle(color=" + ((Object) w1.t(h())) + ", brush=" + g() + ", alpha=" + d() + ", fontSize=" + ((Object) q2.w.j(l())) + ", fontWeight=" + o() + ", fontStyle=" + m() + ", fontSynthesis=" + n() + ", fontFamily=" + j() + ", fontFeatureSettings=" + k() + ", letterSpacing=" + ((Object) q2.w.j(q())) + ", baselineShift=" + f() + ", textGeometricTransform=" + C() + ", localeList=" + u() + ", background=" + ((Object) w1.t(e())) + ", textDecoration=" + A() + ", shadow=" + x() + ", drawStyle=" + i() + ", textAlign=" + ((Object) androidx.compose.ui.text.style.h.m(z())) + ", textDirection=" + ((Object) androidx.compose.ui.text.style.j.l(B())) + ", lineHeight=" + ((Object) q2.w.j(s())) + ", textIndent=" + D() + ", platformStyle=" + this.f5778c + ", lineHeightStyle=" + t() + ", lineBreak=" + ((Object) androidx.compose.ui.text.style.e.k(r())) + ", hyphens=" + ((Object) androidx.compose.ui.text.style.d.i(p())) + ", textMotion=" + E() + ')';
    }

    public final p2.i u() {
        return this.f5776a.p();
    }

    public final r v() {
        return this.f5777b;
    }

    public final x w() {
        return this.f5778c;
    }

    public final b5 x() {
        return this.f5776a.r();
    }

    public final y y() {
        return this.f5776a;
    }

    public final int z() {
        return this.f5777b.h();
    }
}
