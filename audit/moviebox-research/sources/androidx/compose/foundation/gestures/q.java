package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.z;
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
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Orientation f2371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2372b;

    /* JADX WARN: Multi-variable type inference failed */
    public q() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public q(Orientation orientation) {
        this.f2371a = orientation;
        this.f2372b = y1.g.f81070b.c();
    }

    public /* synthetic */ q(Orientation orientation, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : orientation);
    }

    public final y1.g a(z zVar, float f11) {
        long jR = y1.g.r(this.f2372b, y1.g.q(zVar.h(), zVar.k()));
        this.f2372b = jR;
        if ((this.f2371a == null ? y1.g.k(jR) : Math.abs(d(jR))) >= f11) {
            return y1.g.d(b(f11));
        }
        return null;
    }

    public final long b(float f11) {
        if (this.f2371a == null) {
            long j11 = this.f2372b;
            return y1.g.q(this.f2372b, y1.g.s(y1.g.h(j11, y1.g.k(j11)), f11));
        }
        float fD = d(this.f2372b) - (Math.signum(d(this.f2372b)) * f11);
        float fC = c(this.f2372b);
        return this.f2371a == Orientation.Horizontal ? y1.h.a(fD, fC) : y1.h.a(fC, fD);
    }

    public final float c(long j11) {
        return this.f2371a == Orientation.Horizontal ? y1.g.n(j11) : y1.g.m(j11);
    }

    public final float d(long j11) {
        return this.f2371a == Orientation.Horizontal ? y1.g.m(j11) : y1.g.n(j11);
    }

    public final void e() {
        this.f2372b = y1.g.f81070b.c();
    }
}
