package androidx.compose.material;

import androidx.compose.runtime.a3;
import androidx.compose.runtime.r2;
import androidx.compose.ui.graphics.w1;
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
public final class d implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f3079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f3080e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f3081f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f3082g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f3083h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f3084i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f3085j;

    public d(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21) {
        this.f3076a = j11;
        this.f3077b = j12;
        this.f3078c = j13;
        this.f3079d = j14;
        this.f3080e = j15;
        this.f3081f = j16;
        this.f3082g = j17;
        this.f3083h = j18;
        this.f3084i = j19;
        this.f3085j = j21;
    }

    public /* synthetic */ d(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, j14, j15, j16, j17, j18, j19, j21);
    }

    @Override // androidx.compose.material.j
    public a3<w1> a(boolean z11, boolean z12, androidx.compose.runtime.i iVar, int i11) {
        long j11;
        iVar.R(-1491563694);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(-1491563694, i11, -1, "androidx.compose.material.DefaultSliderColors.tickColor (Slider.kt:1111)");
        }
        if (z11) {
            j11 = z12 ? this.f3082g : this.f3083h;
        } else {
            j11 = z12 ? this.f3084i : this.f3085j;
        }
        a3<w1> a3VarI = r2.i(w1.g(j11), iVar, 0);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        iVar.L();
        return a3VarI;
    }

    @Override // androidx.compose.material.j
    public a3<w1> b(boolean z11, boolean z12, androidx.compose.runtime.i iVar, int i11) {
        long j11;
        iVar.R(1575395620);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(1575395620, i11, -1, "androidx.compose.material.DefaultSliderColors.trackColor (Slider.kt:1100)");
        }
        if (z11) {
            j11 = z12 ? this.f3078c : this.f3079d;
        } else {
            j11 = z12 ? this.f3080e : this.f3081f;
        }
        a3<w1> a3VarI = r2.i(w1.g(j11), iVar, 0);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        iVar.L();
        return a3VarI;
    }

    @Override // androidx.compose.material.j
    public a3<w1> c(boolean z11, androidx.compose.runtime.i iVar, int i11) {
        iVar.R(-1733795637);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(-1733795637, i11, -1, "androidx.compose.material.DefaultSliderColors.thumbColor (Slider.kt:1095)");
        }
        a3<w1> a3VarI = r2.i(w1.g(z11 ? this.f3076a : this.f3077b), iVar, 0);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        iVar.L();
        return a3VarI;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return w1.m(this.f3076a, dVar.f3076a) && w1.m(this.f3077b, dVar.f3077b) && w1.m(this.f3078c, dVar.f3078c) && w1.m(this.f3079d, dVar.f3079d) && w1.m(this.f3080e, dVar.f3080e) && w1.m(this.f3081f, dVar.f3081f) && w1.m(this.f3082g, dVar.f3082g) && w1.m(this.f3083h, dVar.f3083h) && w1.m(this.f3084i, dVar.f3084i) && w1.m(this.f3085j, dVar.f3085j);
    }

    public int hashCode() {
        return (((((((((((((((((w1.s(this.f3076a) * 31) + w1.s(this.f3077b)) * 31) + w1.s(this.f3078c)) * 31) + w1.s(this.f3079d)) * 31) + w1.s(this.f3080e)) * 31) + w1.s(this.f3081f)) * 31) + w1.s(this.f3082g)) * 31) + w1.s(this.f3083h)) * 31) + w1.s(this.f3084i)) * 31) + w1.s(this.f3085j);
    }
}
