package androidx.compose.foundation.gestures;

import kotlin.Metadata;

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
public interface d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2358a = a.f2359a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f2359a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final androidx.compose.animation.core.g<Float> f2360b = androidx.compose.animation.core.h.d(0.0f, 0.0f, null, 7, null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f2361c = new C0041a();

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0041a implements d {
            @Override // androidx.compose.foundation.gestures.d
            public /* synthetic */ float a(float f11, float f12, float f13) {
                return c.a(this, f11, f12, f13);
            }

            @Override // androidx.compose.foundation.gestures.d
            public /* synthetic */ androidx.compose.animation.core.g b() {
                return c.b(this);
            }
        }

        public final float a(float f11, float f12, float f13) {
            float f14 = f12 + f11;
            if ((f11 >= 0.0f && f14 <= f13) || (f11 < 0.0f && f14 > f13)) {
                return 0.0f;
            }
            float f15 = f14 - f13;
            return Math.abs(f11) < Math.abs(f15) ? f11 : f15;
        }

        public final d b() {
            return f2361c;
        }

        public final androidx.compose.animation.core.g<Float> c() {
            return f2360b;
        }
    }

    float a(float f11, float f12, float f13);

    androidx.compose.animation.core.g<Float> b();
}
