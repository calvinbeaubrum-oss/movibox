package androidx.compose.ui.text;

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
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f6045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.compose.ui.text.style.n f6046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final v f6047e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.compose.ui.text.style.g f6048f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f6049g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f6050h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.compose.ui.text.style.o f6051i;

    public r(int i11, int i12, long j11, androidx.compose.ui.text.style.n nVar, v vVar, androidx.compose.ui.text.style.g gVar, int i13, int i14, androidx.compose.ui.text.style.o oVar) {
        this.f6043a = i11;
        this.f6044b = i12;
        this.f6045c = j11;
        this.f6046d = nVar;
        this.f6047e = vVar;
        this.f6048f = gVar;
        this.f6049g = i13;
        this.f6050h = i14;
        this.f6051i = oVar;
        if (q2.w.e(j11, q2.w.f74257b.a()) || q2.w.h(j11) >= 0.0f) {
            return;
        }
        throw new IllegalStateException(("lineHeight can't be negative (" + q2.w.h(j11) + ')').toString());
    }

    public /* synthetic */ r(int i11, int i12, long j11, androidx.compose.ui.text.style.n nVar, v vVar, androidx.compose.ui.text.style.g gVar, int i13, int i14, androidx.compose.ui.text.style.o oVar, int i15, DefaultConstructorMarker defaultConstructorMarker) {
        this((i15 & 1) != 0 ? androidx.compose.ui.text.style.h.f6101b.g() : i11, (i15 & 2) != 0 ? androidx.compose.ui.text.style.j.f6115b.f() : i12, (i15 & 4) != 0 ? q2.w.f74257b.a() : j11, (i15 & 8) != 0 ? null : nVar, (i15 & 16) != 0 ? null : vVar, (i15 & 32) != 0 ? null : gVar, (i15 & 64) != 0 ? androidx.compose.ui.text.style.e.f6066b.b() : i13, (i15 & 128) != 0 ? androidx.compose.ui.text.style.d.f6061b.c() : i14, (i15 & 256) == 0 ? oVar : null, null);
    }

    public /* synthetic */ r(int i11, int i12, long j11, androidx.compose.ui.text.style.n nVar, v vVar, androidx.compose.ui.text.style.g gVar, int i13, int i14, androidx.compose.ui.text.style.o oVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, i12, j11, nVar, vVar, gVar, i13, i14, oVar);
    }

    public final r a(int i11, int i12, long j11, androidx.compose.ui.text.style.n nVar, v vVar, androidx.compose.ui.text.style.g gVar, int i13, int i14, androidx.compose.ui.text.style.o oVar) {
        return new r(i11, i12, j11, nVar, vVar, gVar, i13, i14, oVar, null);
    }

    public final int c() {
        return this.f6050h;
    }

    public final int d() {
        return this.f6049g;
    }

    public final long e() {
        return this.f6045c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return androidx.compose.ui.text.style.h.k(this.f6043a, rVar.f6043a) && androidx.compose.ui.text.style.j.j(this.f6044b, rVar.f6044b) && q2.w.e(this.f6045c, rVar.f6045c) && Intrinsics.b(this.f6046d, rVar.f6046d) && Intrinsics.b(this.f6047e, rVar.f6047e) && Intrinsics.b(this.f6048f, rVar.f6048f) && androidx.compose.ui.text.style.e.f(this.f6049g, rVar.f6049g) && androidx.compose.ui.text.style.d.g(this.f6050h, rVar.f6050h) && Intrinsics.b(this.f6051i, rVar.f6051i);
    }

    public final androidx.compose.ui.text.style.g f() {
        return this.f6048f;
    }

    public final v g() {
        return this.f6047e;
    }

    public final int h() {
        return this.f6043a;
    }

    public int hashCode() {
        int iL = ((((androidx.compose.ui.text.style.h.l(this.f6043a) * 31) + androidx.compose.ui.text.style.j.k(this.f6044b)) * 31) + q2.w.i(this.f6045c)) * 31;
        androidx.compose.ui.text.style.n nVar = this.f6046d;
        int iHashCode = (iL + (nVar != null ? nVar.hashCode() : 0)) * 31;
        v vVar = this.f6047e;
        int iHashCode2 = (iHashCode + (vVar != null ? vVar.hashCode() : 0)) * 31;
        androidx.compose.ui.text.style.g gVar = this.f6048f;
        int iHashCode3 = (((((iHashCode2 + (gVar != null ? gVar.hashCode() : 0)) * 31) + androidx.compose.ui.text.style.e.j(this.f6049g)) * 31) + androidx.compose.ui.text.style.d.h(this.f6050h)) * 31;
        androidx.compose.ui.text.style.o oVar = this.f6051i;
        return iHashCode3 + (oVar != null ? oVar.hashCode() : 0);
    }

    public final int i() {
        return this.f6044b;
    }

    public final androidx.compose.ui.text.style.n j() {
        return this.f6046d;
    }

    public final androidx.compose.ui.text.style.o k() {
        return this.f6051i;
    }

    public final r l(r rVar) {
        return rVar == null ? this : s.a(this, rVar.f6043a, rVar.f6044b, rVar.f6045c, rVar.f6046d, rVar.f6047e, rVar.f6048f, rVar.f6049g, rVar.f6050h, rVar.f6051i);
    }

    public String toString() {
        return "ParagraphStyle(textAlign=" + ((Object) androidx.compose.ui.text.style.h.m(this.f6043a)) + ", textDirection=" + ((Object) androidx.compose.ui.text.style.j.l(this.f6044b)) + ", lineHeight=" + ((Object) q2.w.j(this.f6045c)) + ", textIndent=" + this.f6046d + ", platformStyle=" + this.f6047e + ", lineHeightStyle=" + this.f6048f + ", lineBreak=" + ((Object) androidx.compose.ui.text.style.e.k(this.f6049g)) + ", hyphens=" + ((Object) androidx.compose.ui.text.style.d.i(this.f6050h)) + ", textMotion=" + this.f6051i + ')';
    }
}
