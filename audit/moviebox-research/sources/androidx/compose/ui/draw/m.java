package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.c5;
import androidx.compose.ui.graphics.f4;
import androidx.compose.ui.graphics.x4;
import kotlin.Metadata;
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
public final class m {
    public static final androidx.compose.ui.f a(androidx.compose.ui.f fVar, float f11, c5 c5Var, boolean z11, long j11, long j12) {
        return (q2.i.e(f11, q2.i.h((float) 0)) > 0 || z11) ? fVar.f(new ShadowGraphicsLayerElement(f11, c5Var, z11, j11, j12, null)) : fVar;
    }

    public static /* synthetic */ androidx.compose.ui.f b(androidx.compose.ui.f fVar, float f11, c5 c5Var, boolean z11, long j11, long j12, int i11, Object obj) {
        boolean z12;
        c5 c5VarA = (i11 & 2) != 0 ? x4.a() : c5Var;
        if ((i11 & 4) != 0) {
            z12 = false;
            if (q2.i.e(f11, q2.i.h(0)) > 0) {
                z12 = true;
            }
        } else {
            z12 = z11;
        }
        return a(fVar, f11, c5VarA, z12, (i11 & 8) != 0 ? f4.a() : j11, (i11 & 16) != 0 ? f4.a() : j12);
    }
}
