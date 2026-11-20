package androidx.compose.ui.text;

import androidx.compose.ui.text.style.ResolvedTextDirection;
import java.util.List;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f5755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MultiParagraph f5756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f5757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f5758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f5759e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<y1.i> f5760f;

    public a0(z zVar, MultiParagraph multiParagraph, long j11) {
        this.f5755a = zVar;
        this.f5756b = multiParagraph;
        this.f5757c = j11;
        this.f5758d = multiParagraph.g();
        this.f5759e = multiParagraph.j();
        this.f5760f = multiParagraph.v();
    }

    public /* synthetic */ a0(z zVar, MultiParagraph multiParagraph, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(zVar, multiParagraph, j11);
    }

    public static /* synthetic */ a0 b(a0 a0Var, z zVar, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            zVar = a0Var.f5755a;
        }
        if ((i11 & 2) != 0) {
            j11 = a0Var.f5757c;
        }
        return a0Var.a(zVar, j11);
    }

    public static /* synthetic */ int o(a0 a0Var, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        return a0Var.n(i11, z11);
    }

    public final a0 a(z zVar, long j11) {
        return new a0(zVar, this.f5756b, j11, null);
    }

    public final ResolvedTextDirection c(int i11) {
        return this.f5756b.c(i11);
    }

    public final y1.i d(int i11) {
        return this.f5756b.d(i11);
    }

    public final y1.i e(int i11) {
        return this.f5756b.e(i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return Intrinsics.b(this.f5755a, a0Var.f5755a) && Intrinsics.b(this.f5756b, a0Var.f5756b) && q2.t.e(this.f5757c, a0Var.f5757c) && this.f5758d == a0Var.f5758d && this.f5759e == a0Var.f5759e && Intrinsics.b(this.f5760f, a0Var.f5760f);
    }

    public final boolean f() {
        return this.f5756b.f() || ((float) q2.t.f(this.f5757c)) < this.f5756b.h();
    }

    public final boolean g() {
        return ((float) q2.t.g(this.f5757c)) < this.f5756b.w();
    }

    public final float h() {
        return this.f5758d;
    }

    public int hashCode() {
        return (((((((((this.f5755a.hashCode() * 31) + this.f5756b.hashCode()) * 31) + q2.t.h(this.f5757c)) * 31) + Float.floatToIntBits(this.f5758d)) * 31) + Float.floatToIntBits(this.f5759e)) * 31) + this.f5760f.hashCode();
    }

    public final boolean i() {
        return g() || f();
    }

    public final float j() {
        return this.f5759e;
    }

    public final z k() {
        return this.f5755a;
    }

    public final float l(int i11) {
        return this.f5756b.k(i11);
    }

    public final int m() {
        return this.f5756b.l();
    }

    public final int n(int i11, boolean z11) {
        return this.f5756b.m(i11, z11);
    }

    public final int p(int i11) {
        return this.f5756b.n(i11);
    }

    public final int q(float f11) {
        return this.f5756b.o(f11);
    }

    public final float r(int i11) {
        return this.f5756b.p(i11);
    }

    public final float s(int i11) {
        return this.f5756b.q(i11);
    }

    public final int t(int i11) {
        return this.f5756b.r(i11);
    }

    public String toString() {
        return "TextLayoutResult(layoutInput=" + this.f5755a + ", multiParagraph=" + this.f5756b + ", size=" + ((Object) q2.t.i(this.f5757c)) + ", firstBaseline=" + this.f5758d + ", lastBaseline=" + this.f5759e + ", placeholderRects=" + this.f5760f + ')';
    }

    public final float u(int i11) {
        return this.f5756b.s(i11);
    }

    public final MultiParagraph v() {
        return this.f5756b;
    }

    public final ResolvedTextDirection w(int i11) {
        return this.f5756b.t(i11);
    }

    public final List<y1.i> x() {
        return this.f5760f;
    }

    public final long y() {
        return this.f5757c;
    }
}
