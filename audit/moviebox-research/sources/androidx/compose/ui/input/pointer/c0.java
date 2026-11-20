package androidx.compose.ui.input.pointer;

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
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f4680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f4681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f4682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f4683g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f4684h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<g> f4685i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f4686j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f4687k;

    public c0(long j11, long j12, long j13, long j14, boolean z11, float f11, int i11, boolean z12, List<g> list, long j15, long j16) {
        this.f4677a = j11;
        this.f4678b = j12;
        this.f4679c = j13;
        this.f4680d = j14;
        this.f4681e = z11;
        this.f4682f = f11;
        this.f4683g = i11;
        this.f4684h = z12;
        this.f4685i = list;
        this.f4686j = j15;
        this.f4687k = j16;
    }

    public /* synthetic */ c0(long j11, long j12, long j13, long j14, boolean z11, float f11, int i11, boolean z12, List list, long j15, long j16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, j14, z11, f11, i11, z12, list, j15, j16);
    }

    public final boolean a() {
        return this.f4684h;
    }

    public final boolean b() {
        return this.f4681e;
    }

    public final List<g> c() {
        return this.f4685i;
    }

    public final long d() {
        return this.f4677a;
    }

    public final long e() {
        return this.f4687k;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return y.d(this.f4677a, c0Var.f4677a) && this.f4678b == c0Var.f4678b && y1.g.j(this.f4679c, c0Var.f4679c) && y1.g.j(this.f4680d, c0Var.f4680d) && this.f4681e == c0Var.f4681e && Float.compare(this.f4682f, c0Var.f4682f) == 0 && k0.g(this.f4683g, c0Var.f4683g) && this.f4684h == c0Var.f4684h && Intrinsics.b(this.f4685i, c0Var.f4685i) && y1.g.j(this.f4686j, c0Var.f4686j) && y1.g.j(this.f4687k, c0Var.f4687k);
    }

    public final long f() {
        return this.f4680d;
    }

    public final long g() {
        return this.f4679c;
    }

    public final float h() {
        return this.f4682f;
    }

    public int hashCode() {
        return (((((((((((((((((((y.e(this.f4677a) * 31) + l.p.a(this.f4678b)) * 31) + y1.g.o(this.f4679c)) * 31) + y1.g.o(this.f4680d)) * 31) + androidx.compose.foundation.e.a(this.f4681e)) * 31) + Float.floatToIntBits(this.f4682f)) * 31) + k0.h(this.f4683g)) * 31) + androidx.compose.foundation.e.a(this.f4684h)) * 31) + this.f4685i.hashCode()) * 31) + y1.g.o(this.f4686j)) * 31) + y1.g.o(this.f4687k);
    }

    public final long i() {
        return this.f4686j;
    }

    public final int j() {
        return this.f4683g;
    }

    public final long k() {
        return this.f4678b;
    }

    public String toString() {
        return "PointerInputEventData(id=" + ((Object) y.f(this.f4677a)) + ", uptime=" + this.f4678b + ", positionOnScreen=" + ((Object) y1.g.t(this.f4679c)) + ", position=" + ((Object) y1.g.t(this.f4680d)) + ", down=" + this.f4681e + ", pressure=" + this.f4682f + ", type=" + ((Object) k0.i(this.f4683g)) + ", activeHover=" + this.f4684h + ", historical=" + this.f4685i + ", scrollDelta=" + ((Object) y1.g.t(this.f4686j)) + ", originalEventPosition=" + ((Object) y1.g.t(this.f4687k)) + ')';
    }
}
