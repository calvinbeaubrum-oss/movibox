package androidx.compose.ui.graphics;

import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;

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
public final class d4 {
    public static final androidx.compose.ui.f a(androidx.compose.ui.f fVar, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f21, long j11, c5 c5Var, boolean z11, y4 y4Var, long j12, long j13, int i11) {
        return fVar.f(new GraphicsLayerElement(f11, f12, f13, f14, f15, f16, f17, f18, f19, f21, j11, c5Var, z11, y4Var, j12, j13, i11, null));
    }

    public static /* synthetic */ androidx.compose.ui.f b(androidx.compose.ui.f fVar, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f21, long j11, c5 c5Var, boolean z11, y4 y4Var, long j12, long j13, int i11, int i12, Object obj) {
        return a(fVar, (i12 & 1) != 0 ? 1.0f : f11, (i12 & 2) != 0 ? 1.0f : f12, (i12 & 4) == 0 ? f13 : 1.0f, (i12 & 8) != 0 ? 0.0f : f14, (i12 & 16) != 0 ? 0.0f : f15, (i12 & 32) != 0 ? 0.0f : f16, (i12 & 64) != 0 ? 0.0f : f17, (i12 & 128) != 0 ? 0.0f : f18, (i12 & 256) == 0 ? f19 : 0.0f, (i12 & 512) != 0 ? 8.0f : f21, (i12 & 1024) != 0 ? g5.f4145a.a() : j11, (i12 & 2048) != 0 ? x4.a() : c5Var, (i12 & 4096) != 0 ? false : z11, (i12 & 8192) != 0 ? null : y4Var, (i12 & 16384) != 0 ? f4.a() : j12, (i12 & 32768) != 0 ? f4.a() : j13, (i12 & 65536) != 0 ? y3.f4585a.a() : i11);
    }

    public static final androidx.compose.ui.f c(androidx.compose.ui.f fVar) {
        return InspectableValueKt.b() ? fVar.f(b(androidx.compose.ui.f.f3863a, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null)) : fVar;
    }
}
