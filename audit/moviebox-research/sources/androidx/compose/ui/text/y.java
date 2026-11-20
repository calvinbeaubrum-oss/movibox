package androidx.compose.ui.text;

import androidx.compose.ui.graphics.b5;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.w1;
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
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.compose.ui.text.style.l f6163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.compose.ui.text.font.u f6165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.compose.ui.text.font.q f6166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.compose.ui.text.font.r f6167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.compose.ui.text.font.i f6168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f6169g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f6170h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.compose.ui.text.style.a f6171i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.compose.ui.text.style.m f6172j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final p2.i f6173k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f6174l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final androidx.compose.ui.text.style.i f6175m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b5 f6176n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final z1.h f6177o;

    public y(long j11, long j12, androidx.compose.ui.text.font.u uVar, androidx.compose.ui.text.font.q qVar, androidx.compose.ui.text.font.r rVar, androidx.compose.ui.text.font.i iVar, String str, long j13, androidx.compose.ui.text.style.a aVar, androidx.compose.ui.text.style.m mVar, p2.i iVar2, long j14, androidx.compose.ui.text.style.i iVar3, b5 b5Var, w wVar, z1.h hVar) {
        this(androidx.compose.ui.text.style.l.f6123a.b(j11), j12, uVar, qVar, rVar, iVar, str, j13, aVar, mVar, iVar2, j14, iVar3, b5Var, wVar, hVar, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ y(long j11, long j12, androidx.compose.ui.text.font.u uVar, androidx.compose.ui.text.font.q qVar, androidx.compose.ui.text.font.r rVar, androidx.compose.ui.text.font.i iVar, String str, long j13, androidx.compose.ui.text.style.a aVar, androidx.compose.ui.text.style.m mVar, p2.i iVar2, long j14, androidx.compose.ui.text.style.i iVar3, b5 b5Var, w wVar, z1.h hVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? w1.f4564b.e() : j11, (i11 & 2) != 0 ? q2.w.f74257b.a() : j12, (i11 & 4) != 0 ? null : uVar, (i11 & 8) != 0 ? null : qVar, (i11 & 16) != 0 ? null : rVar, (i11 & 32) != 0 ? null : iVar, (i11 & 64) != 0 ? null : str, (i11 & 128) != 0 ? q2.w.f74257b.a() : j13, (i11 & 256) != 0 ? null : aVar, (i11 & 512) != 0 ? null : mVar, (i11 & 1024) != 0 ? null : iVar2, (i11 & 2048) != 0 ? w1.f4564b.e() : j14, (i11 & 4096) != 0 ? null : iVar3, (i11 & 8192) != 0 ? null : b5Var, (i11 & 16384) != 0 ? null : wVar, (i11 & 32768) != 0 ? null : hVar, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ y(long j11, long j12, androidx.compose.ui.text.font.u uVar, androidx.compose.ui.text.font.q qVar, androidx.compose.ui.text.font.r rVar, androidx.compose.ui.text.font.i iVar, String str, long j13, androidx.compose.ui.text.style.a aVar, androidx.compose.ui.text.style.m mVar, p2.i iVar2, long j14, androidx.compose.ui.text.style.i iVar3, b5 b5Var, w wVar, z1.h hVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, uVar, qVar, rVar, iVar, str, j13, aVar, mVar, iVar2, j14, iVar3, b5Var, wVar, hVar);
    }

    public y(androidx.compose.ui.text.style.l lVar, long j11, androidx.compose.ui.text.font.u uVar, androidx.compose.ui.text.font.q qVar, androidx.compose.ui.text.font.r rVar, androidx.compose.ui.text.font.i iVar, String str, long j12, androidx.compose.ui.text.style.a aVar, androidx.compose.ui.text.style.m mVar, p2.i iVar2, long j13, androidx.compose.ui.text.style.i iVar3, b5 b5Var, w wVar, z1.h hVar) {
        this.f6163a = lVar;
        this.f6164b = j11;
        this.f6165c = uVar;
        this.f6166d = qVar;
        this.f6167e = rVar;
        this.f6168f = iVar;
        this.f6169g = str;
        this.f6170h = j12;
        this.f6171i = aVar;
        this.f6172j = mVar;
        this.f6173k = iVar2;
        this.f6174l = j13;
        this.f6175m = iVar3;
        this.f6176n = b5Var;
        this.f6177o = hVar;
    }

    public /* synthetic */ y(androidx.compose.ui.text.style.l lVar, long j11, androidx.compose.ui.text.font.u uVar, androidx.compose.ui.text.font.q qVar, androidx.compose.ui.text.font.r rVar, androidx.compose.ui.text.font.i iVar, String str, long j12, androidx.compose.ui.text.style.a aVar, androidx.compose.ui.text.style.m mVar, p2.i iVar2, long j13, androidx.compose.ui.text.style.i iVar3, b5 b5Var, w wVar, z1.h hVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(lVar, j11, uVar, qVar, rVar, iVar, str, j12, aVar, mVar, iVar2, j13, iVar3, b5Var, wVar, hVar);
    }

    public static /* synthetic */ y b(y yVar, long j11, long j12, androidx.compose.ui.text.font.u uVar, androidx.compose.ui.text.font.q qVar, androidx.compose.ui.text.font.r rVar, androidx.compose.ui.text.font.i iVar, String str, long j13, androidx.compose.ui.text.style.a aVar, androidx.compose.ui.text.style.m mVar, p2.i iVar2, long j14, androidx.compose.ui.text.style.i iVar3, b5 b5Var, w wVar, z1.h hVar, int i11, Object obj) {
        w wVar2;
        long jG = (i11 & 1) != 0 ? yVar.g() : j11;
        long j15 = (i11 & 2) != 0 ? yVar.f6164b : j12;
        androidx.compose.ui.text.font.u uVar2 = (i11 & 4) != 0 ? yVar.f6165c : uVar;
        androidx.compose.ui.text.font.q qVar2 = (i11 & 8) != 0 ? yVar.f6166d : qVar;
        androidx.compose.ui.text.font.r rVar2 = (i11 & 16) != 0 ? yVar.f6167e : rVar;
        androidx.compose.ui.text.font.i iVar4 = (i11 & 32) != 0 ? yVar.f6168f : iVar;
        String str2 = (i11 & 64) != 0 ? yVar.f6169g : str;
        long j16 = (i11 & 128) != 0 ? yVar.f6170h : j13;
        androidx.compose.ui.text.style.a aVar2 = (i11 & 256) != 0 ? yVar.f6171i : aVar;
        androidx.compose.ui.text.style.m mVar2 = (i11 & 512) != 0 ? yVar.f6172j : mVar;
        p2.i iVar5 = (i11 & 1024) != 0 ? yVar.f6173k : iVar2;
        androidx.compose.ui.text.style.m mVar3 = mVar2;
        long j17 = (i11 & 2048) != 0 ? yVar.f6174l : j14;
        androidx.compose.ui.text.style.i iVar6 = (i11 & 4096) != 0 ? yVar.f6175m : iVar3;
        b5 b5Var2 = (i11 & 8192) != 0 ? yVar.f6176n : b5Var;
        if ((i11 & 16384) != 0) {
            yVar.getClass();
            wVar2 = null;
        } else {
            wVar2 = wVar;
        }
        return yVar.a(jG, j15, uVar2, qVar2, rVar2, iVar4, str2, j16, aVar2, mVar3, iVar5, j17, iVar6, b5Var2, wVar2, (i11 & 32768) != 0 ? yVar.f6177o : hVar);
    }

    public final y a(long j11, long j12, androidx.compose.ui.text.font.u uVar, androidx.compose.ui.text.font.q qVar, androidx.compose.ui.text.font.r rVar, androidx.compose.ui.text.font.i iVar, String str, long j13, androidx.compose.ui.text.style.a aVar, androidx.compose.ui.text.style.m mVar, p2.i iVar2, long j14, androidx.compose.ui.text.style.i iVar3, b5 b5Var, w wVar, z1.h hVar) {
        return new y(w1.m(j11, g()) ? this.f6163a : androidx.compose.ui.text.style.l.f6123a.b(j11), j12, uVar, qVar, rVar, iVar, str, j13, aVar, mVar, iVar2, j14, iVar3, b5Var, wVar, hVar, (DefaultConstructorMarker) null);
    }

    public final float c() {
        return this.f6163a.getAlpha();
    }

    public final long d() {
        return this.f6174l;
    }

    public final androidx.compose.ui.text.style.a e() {
        return this.f6171i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return v(yVar) && w(yVar);
    }

    public final l1 f() {
        return this.f6163a.d();
    }

    public final long g() {
        return this.f6163a.a();
    }

    public final z1.h h() {
        return this.f6177o;
    }

    public int hashCode() {
        int iS = w1.s(g()) * 31;
        l1 l1VarF = f();
        int iHashCode = (((((iS + (l1VarF != null ? l1VarF.hashCode() : 0)) * 31) + Float.floatToIntBits(c())) * 31) + q2.w.i(this.f6164b)) * 31;
        androidx.compose.ui.text.font.u uVar = this.f6165c;
        int iHashCode2 = (iHashCode + (uVar != null ? uVar.hashCode() : 0)) * 31;
        androidx.compose.ui.text.font.q qVar = this.f6166d;
        int iG = (iHashCode2 + (qVar != null ? androidx.compose.ui.text.font.q.g(qVar.i()) : 0)) * 31;
        androidx.compose.ui.text.font.r rVar = this.f6167e;
        int iF = (iG + (rVar != null ? androidx.compose.ui.text.font.r.f(rVar.j()) : 0)) * 31;
        androidx.compose.ui.text.font.i iVar = this.f6168f;
        int iHashCode3 = (iF + (iVar != null ? iVar.hashCode() : 0)) * 31;
        String str = this.f6169g;
        int iHashCode4 = (((iHashCode3 + (str != null ? str.hashCode() : 0)) * 31) + q2.w.i(this.f6170h)) * 31;
        androidx.compose.ui.text.style.a aVar = this.f6171i;
        int iF2 = (iHashCode4 + (aVar != null ? androidx.compose.ui.text.style.a.f(aVar.h()) : 0)) * 31;
        androidx.compose.ui.text.style.m mVar = this.f6172j;
        int iHashCode5 = (iF2 + (mVar != null ? mVar.hashCode() : 0)) * 31;
        p2.i iVar2 = this.f6173k;
        int iHashCode6 = (((iHashCode5 + (iVar2 != null ? iVar2.hashCode() : 0)) * 31) + w1.s(this.f6174l)) * 31;
        androidx.compose.ui.text.style.i iVar3 = this.f6175m;
        int iHashCode7 = (iHashCode6 + (iVar3 != null ? iVar3.hashCode() : 0)) * 31;
        b5 b5Var = this.f6176n;
        int iHashCode8 = (iHashCode7 + (b5Var != null ? b5Var.hashCode() : 0)) * 961;
        z1.h hVar = this.f6177o;
        return iHashCode8 + (hVar != null ? hVar.hashCode() : 0);
    }

    public final androidx.compose.ui.text.font.i i() {
        return this.f6168f;
    }

    public final String j() {
        return this.f6169g;
    }

    public final long k() {
        return this.f6164b;
    }

    public final androidx.compose.ui.text.font.q l() {
        return this.f6166d;
    }

    public final androidx.compose.ui.text.font.r m() {
        return this.f6167e;
    }

    public final androidx.compose.ui.text.font.u n() {
        return this.f6165c;
    }

    public final long o() {
        return this.f6170h;
    }

    public final p2.i p() {
        return this.f6173k;
    }

    public final w q() {
        return null;
    }

    public final b5 r() {
        return this.f6176n;
    }

    public final androidx.compose.ui.text.style.i s() {
        return this.f6175m;
    }

    public final androidx.compose.ui.text.style.l t() {
        return this.f6163a;
    }

    public String toString() {
        return "SpanStyle(color=" + ((Object) w1.t(g())) + ", brush=" + f() + ", alpha=" + c() + ", fontSize=" + ((Object) q2.w.j(this.f6164b)) + ", fontWeight=" + this.f6165c + ", fontStyle=" + this.f6166d + ", fontSynthesis=" + this.f6167e + ", fontFamily=" + this.f6168f + ", fontFeatureSettings=" + this.f6169g + ", letterSpacing=" + ((Object) q2.w.j(this.f6170h)) + ", baselineShift=" + this.f6171i + ", textGeometricTransform=" + this.f6172j + ", localeList=" + this.f6173k + ", background=" + ((Object) w1.t(this.f6174l)) + ", textDecoration=" + this.f6175m + ", shadow=" + this.f6176n + ", platformStyle=" + ((Object) null) + ", drawStyle=" + this.f6177o + ')';
    }

    public final androidx.compose.ui.text.style.m u() {
        return this.f6172j;
    }

    public final boolean v(y yVar) {
        if (this == yVar) {
            return true;
        }
        return q2.w.e(this.f6164b, yVar.f6164b) && Intrinsics.b(this.f6165c, yVar.f6165c) && Intrinsics.b(this.f6166d, yVar.f6166d) && Intrinsics.b(this.f6167e, yVar.f6167e) && Intrinsics.b(this.f6168f, yVar.f6168f) && Intrinsics.b(this.f6169g, yVar.f6169g) && q2.w.e(this.f6170h, yVar.f6170h) && Intrinsics.b(this.f6171i, yVar.f6171i) && Intrinsics.b(this.f6172j, yVar.f6172j) && Intrinsics.b(this.f6173k, yVar.f6173k) && w1.m(this.f6174l, yVar.f6174l) && Intrinsics.b(null, null);
    }

    public final boolean w(y yVar) {
        return Intrinsics.b(this.f6163a, yVar.f6163a) && Intrinsics.b(this.f6175m, yVar.f6175m) && Intrinsics.b(this.f6176n, yVar.f6176n) && Intrinsics.b(this.f6177o, yVar.f6177o);
    }

    public final y x(y yVar) {
        return yVar == null ? this : SpanStyleKt.b(this, yVar.f6163a.a(), yVar.f6163a.d(), yVar.f6163a.getAlpha(), yVar.f6164b, yVar.f6165c, yVar.f6166d, yVar.f6167e, yVar.f6168f, yVar.f6169g, yVar.f6170h, yVar.f6171i, yVar.f6172j, yVar.f6173k, yVar.f6174l, yVar.f6175m, yVar.f6176n, null, yVar.f6177o);
    }
}
