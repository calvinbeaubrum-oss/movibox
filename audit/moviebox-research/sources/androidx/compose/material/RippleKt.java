package androidx.compose.material;

import androidx.compose.foundation.b0;
import androidx.compose.foundation.x;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.s1;
import androidx.compose.ui.graphics.w1;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class RippleKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s1<Boolean> f3045a = CompositionLocalKt.f(new Function0<Boolean>() { // from class: androidx.compose.material.RippleKt$LocalUseFallbackRippleImplementation$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s1<g> f3046b = CompositionLocalKt.d(null, new Function0<g>() { // from class: androidx.compose.material.RippleKt$LocalRippleConfiguration$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final g invoke() {
            return new g(0L, null, 3, null);
        }
    }, 1, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f3047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i f3048d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final androidx.compose.material.ripple.c f3049e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final androidx.compose.material.ripple.c f3050f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final androidx.compose.material.ripple.c f3051g;

    static {
        q2.i.a aVar = q2.i.f74232b;
        float fB = aVar.b();
        w1.a aVar2 = w1.f4564b;
        f3047c = new i(true, fB, aVar2.e(), (DefaultConstructorMarker) null);
        f3048d = new i(false, aVar.b(), aVar2.e(), (DefaultConstructorMarker) null);
        f3049e = new androidx.compose.material.ripple.c(0.16f, 0.24f, 0.08f, 0.24f);
        f3050f = new androidx.compose.material.ripple.c(0.08f, 0.12f, 0.04f, 0.12f);
        f3051g = new androidx.compose.material.ripple.c(0.08f, 0.12f, 0.04f, 0.1f);
    }

    public static final s1<g> d() {
        return f3046b;
    }

    public static final b0 e(boolean z11, float f11, long j11) {
        if (q2.i.j(f11, q2.i.f74232b.b()) && w1.m(j11, w1.f4564b.e())) {
            return z11 ? f3047c : f3048d;
        }
        return new i(z11, f11, j11, (DefaultConstructorMarker) null);
    }

    public static final x f(boolean z11, float f11, long j11, androidx.compose.runtime.i iVar, int i11, int i12) {
        x xVarE;
        boolean z12 = (i12 & 1) != 0 ? true : z11;
        if ((i12 & 2) != 0) {
            f11 = q2.i.f74232b.b();
        }
        float f12 = f11;
        if ((i12 & 4) != 0) {
            j11 = w1.f4564b.e();
        }
        long j12 = j11;
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(-58830494, i11, -1, "androidx.compose.material.rippleOrFallbackImplementation (Ripple.kt:264)");
        }
        if (((Boolean) iVar.l(f3045a)).booleanValue()) {
            iVar.R(96412190);
            xVarE = androidx.compose.material.ripple.h.f(z12, f12, j12, iVar, (i11 & 14) | (i11 & 112) | (i11 & 896), 0);
            iVar.L();
        } else {
            iVar.R(96503175);
            iVar.L();
            xVarE = e(z12, f12, j12);
        }
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        return xVarE;
    }
}
