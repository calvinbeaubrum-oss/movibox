package androidx.compose.foundation.gestures;

import android.content.Context;
import androidx.compose.animation.core.u;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.r;
import androidx.compose.runtime.s1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
public final class BringIntoViewSpec_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s1<d> f2273a = CompositionLocalKt.e(new Function1<r, d>() { // from class: androidx.compose.foundation.gestures.BringIntoViewSpec_androidKt$LocalBringIntoViewSpec$1
        @Override // kotlin.jvm.functions.Function1
        public final d invoke(r rVar) {
            return !((Context) rVar.c(AndroidCompositionLocals_androidKt.g())).getPackageManager().hasSystemFeature("android.software.leanback") ? d.f2358a.b() : BringIntoViewSpec_androidKt.b();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f2274b = new a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f2276c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f2275b = 0.3f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final androidx.compose.animation.core.g<Float> f2277d = androidx.compose.animation.core.h.f(125, 0, new u(0.25f, 0.1f, 0.25f, 1.0f), 2, null);

        @Override // androidx.compose.foundation.gestures.d
        public float a(float f11, float f12, float f13) {
            float fAbs = Math.abs((f12 + f11) - f11);
            boolean z11 = fAbs <= f13;
            float f14 = (this.f2275b * f13) - (this.f2276c * fAbs);
            float f15 = f13 - f14;
            if (z11 && f15 < fAbs) {
                f14 = f13 - fAbs;
            }
            return f11 - f14;
        }

        @Override // androidx.compose.foundation.gestures.d
        public androidx.compose.animation.core.g<Float> b() {
            return this.f2277d;
        }
    }

    public static final s1<d> a() {
        return f2273a;
    }

    public static final d b() {
        return f2274b;
    }
}
