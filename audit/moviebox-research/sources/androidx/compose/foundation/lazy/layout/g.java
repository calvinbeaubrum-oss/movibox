package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.unit.LayoutDirection;
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
public final class g {
    public static final androidx.compose.ui.f b(androidx.compose.ui.f fVar, h hVar, e eVar, boolean z11, LayoutDirection layoutDirection, Orientation orientation, boolean z12, androidx.compose.runtime.i iVar, int i11) {
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(1331498025, i11, -1, "androidx.compose.foundation.lazy.layout.lazyLayoutBeyondBoundsModifier (LazyLayoutBeyondBoundsModifierLocal.kt:51)");
        }
        if (z12) {
            iVar.R(-1890632411);
            boolean z13 = ((((i11 & 112) ^ 48) > 32 && iVar.Q(hVar)) || (i11 & 48) == 32) | ((((i11 & 896) ^ 384) > 256 && iVar.Q(eVar)) || (i11 & 384) == 256) | ((((i11 & 7168) ^ 3072) > 2048 && iVar.a(z11)) || (i11 & 3072) == 2048) | ((((57344 & i11) ^ 24576) > 16384 && iVar.Q(layoutDirection)) || (i11 & 24576) == 16384) | ((((458752 & i11) ^ 196608) > 131072 && iVar.Q(orientation)) || (i11 & 196608) == 131072);
            Object objY = iVar.y();
            if (z13 || objY == androidx.compose.runtime.i.f3413a.a()) {
                objY = new f(hVar, eVar, z11, layoutDirection, orientation);
                iVar.p(objY);
            }
            fVar = fVar.f((f) objY);
            iVar.L();
        } else {
            iVar.R(-1890658823);
            iVar.L();
        }
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        return fVar;
    }

    public static final Void c() {
        throw new IllegalStateException("Lazy list does not support beyond bounds layout for the specified direction".toString());
    }
}
