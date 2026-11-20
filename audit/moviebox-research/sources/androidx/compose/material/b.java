package androidx.compose.material;

import androidx.compose.runtime.i1;
import androidx.compose.runtime.r2;
import androidx.compose.ui.graphics.w1;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i1 f3062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i1 f3063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i1 f3064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i1 f3065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i1 f3066e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i1 f3067f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i1 f3068g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i1 f3069h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i1 f3070i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i1 f3071j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i1 f3072k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final i1 f3073l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final i1 f3074m;

    public b(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, boolean z11) {
        this.f3062a = r2.e(w1.g(j11), r2.j());
        this.f3063b = r2.e(w1.g(j12), r2.j());
        this.f3064c = r2.e(w1.g(j13), r2.j());
        this.f3065d = r2.e(w1.g(j14), r2.j());
        this.f3066e = r2.e(w1.g(j15), r2.j());
        this.f3067f = r2.e(w1.g(j16), r2.j());
        this.f3068g = r2.e(w1.g(j17), r2.j());
        this.f3069h = r2.e(w1.g(j18), r2.j());
        this.f3070i = r2.e(w1.g(j19), r2.j());
        this.f3071j = r2.e(w1.g(j21), r2.j());
        this.f3072k = r2.e(w1.g(j22), r2.j());
        this.f3073l = r2.e(w1.g(j23), r2.j());
        this.f3074m = r2.e(Boolean.valueOf(z11), r2.j());
    }

    public /* synthetic */ b(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, boolean z11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, j14, j15, j16, j17, j18, j19, j21, j22, j23, z11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long a() {
        return ((w1) this.f3066e.getValue()).u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long b() {
        return ((w1) this.f3068g.getValue()).u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long c() {
        return ((w1) this.f3071j.getValue()).u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long d() {
        return ((w1) this.f3073l.getValue()).u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long e() {
        return ((w1) this.f3069h.getValue()).u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long f() {
        return ((w1) this.f3070i.getValue()).u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long g() {
        return ((w1) this.f3072k.getValue()).u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long h() {
        return ((w1) this.f3062a.getValue()).u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long i() {
        return ((w1) this.f3063b.getValue()).u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long j() {
        return ((w1) this.f3064c.getValue()).u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long k() {
        return ((w1) this.f3065d.getValue()).u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long l() {
        return ((w1) this.f3067f.getValue()).u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean m() {
        return ((Boolean) this.f3074m.getValue()).booleanValue();
    }

    public String toString() {
        return "Colors(primary=" + ((Object) w1.t(h())) + ", primaryVariant=" + ((Object) w1.t(i())) + ", secondary=" + ((Object) w1.t(j())) + ", secondaryVariant=" + ((Object) w1.t(k())) + ", background=" + ((Object) w1.t(a())) + ", surface=" + ((Object) w1.t(l())) + ", error=" + ((Object) w1.t(b())) + ", onPrimary=" + ((Object) w1.t(e())) + ", onSecondary=" + ((Object) w1.t(f())) + ", onBackground=" + ((Object) w1.t(c())) + ", onSurface=" + ((Object) w1.t(g())) + ", onError=" + ((Object) w1.t(d())) + ", isLight=" + m() + ')';
    }
}
