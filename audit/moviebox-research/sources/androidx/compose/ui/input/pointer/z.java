package androidx.compose.ui.input.pointer;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f4773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f4774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f4775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f4776g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f4777h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f4778i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f4779j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<g> f4780k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f4781l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public f f4782m;

    public z(long j11, long j12, long j13, boolean z11, float f11, long j14, long j15, boolean z12, boolean z13, int i11, long j16) {
        this.f4770a = j11;
        this.f4771b = j12;
        this.f4772c = j13;
        this.f4773d = z11;
        this.f4774e = f11;
        this.f4775f = j14;
        this.f4776g = j15;
        this.f4777h = z12;
        this.f4778i = i11;
        this.f4779j = j16;
        this.f4781l = y1.g.f81070b.c();
        this.f4782m = new f(z13, z13);
    }

    public /* synthetic */ z(long j11, long j12, long j13, boolean z11, float f11, long j14, long j15, boolean z12, boolean z13, int i11, long j16, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, z11, f11, j14, j15, z12, z13, (i12 & 512) != 0 ? k0.f4712a.d() : i11, (i12 & 1024) != 0 ? y1.g.f81070b.c() : j16, null);
    }

    public /* synthetic */ z(long j11, long j12, long j13, boolean z11, float f11, long j14, long j15, boolean z12, boolean z13, int i11, long j16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, z11, f11, j14, j15, z12, z13, i11, j16);
    }

    public z(long j11, long j12, long j13, boolean z11, float f11, long j14, long j15, boolean z12, boolean z13, int i11, List<g> list, long j16, long j17) {
        this(j11, j12, j13, z11, f11, j14, j15, z12, z13, i11, j16, null);
        this.f4780k = list;
        this.f4781l = j17;
    }

    public /* synthetic */ z(long j11, long j12, long j13, boolean z11, float f11, long j14, long j15, boolean z12, boolean z13, int i11, List list, long j16, long j17, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, z11, f11, j14, j15, z12, z13, i11, (List<g>) list, j16, j17);
    }

    public final void a() {
        this.f4782m.c(true);
        this.f4782m.d(true);
    }

    public final z b(long j11, long j12, long j13, boolean z11, long j14, long j15, boolean z12, int i11, List<g> list, long j16) {
        return d(j11, j12, j13, z11, this.f4774e, j14, j15, z12, i11, list, j16);
    }

    public final z d(long j11, long j12, long j13, boolean z11, float f11, long j14, long j15, boolean z12, int i11, List<g> list, long j16) {
        z zVar = new z(j11, j12, j13, z11, f11, j14, j15, z12, false, i11, list, j16, this.f4781l, null);
        zVar.f4782m = this.f4782m;
        return zVar;
    }

    public final List<g> e() {
        List<g> list = this.f4780k;
        return list == null ? kotlin.collections.g.l() : list;
    }

    public final long f() {
        return this.f4770a;
    }

    public final long g() {
        return this.f4781l;
    }

    public final long h() {
        return this.f4772c;
    }

    public final boolean i() {
        return this.f4773d;
    }

    public final float j() {
        return this.f4774e;
    }

    public final long k() {
        return this.f4776g;
    }

    public final boolean l() {
        return this.f4777h;
    }

    public final long m() {
        return this.f4779j;
    }

    public final int n() {
        return this.f4778i;
    }

    public final long o() {
        return this.f4771b;
    }

    public final boolean p() {
        return this.f4782m.a() || this.f4782m.b();
    }

    public String toString() {
        return "PointerInputChange(id=" + ((Object) y.f(this.f4770a)) + ", uptimeMillis=" + this.f4771b + ", position=" + ((Object) y1.g.t(this.f4772c)) + ", pressed=" + this.f4773d + ", pressure=" + this.f4774e + ", previousUptimeMillis=" + this.f4775f + ", previousPosition=" + ((Object) y1.g.t(this.f4776g)) + ", previousPressed=" + this.f4777h + ", isConsumed=" + p() + ", type=" + ((Object) k0.i(this.f4778i)) + ", historical=" + e() + ",scrollDelta=" + ((Object) y1.g.t(this.f4779j)) + ')';
    }
}
