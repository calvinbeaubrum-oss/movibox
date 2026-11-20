package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
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
public final class i0 {
    public static final androidx.compose.ui.f a(androidx.compose.ui.f fVar, androidx.compose.foundation.gestures.o oVar, Orientation orientation, boolean z11, boolean z12, androidx.compose.foundation.gestures.g gVar, o1.i iVar, androidx.compose.foundation.gestures.d dVar, androidx.compose.runtime.i iVar2, int i11, int i12) {
        androidx.compose.foundation.gestures.d dVar2 = (i12 & 64) != 0 ? null : dVar;
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(-1677817431, i11, -1, "androidx.compose.foundation.scrollingContainer (ScrollingContainer.kt:40)");
        }
        androidx.compose.foundation.gestures.m mVar = androidx.compose.foundation.gestures.m.f2370a;
        f0 f0VarB = mVar.b(iVar2, 6);
        androidx.compose.ui.f fVarF = ScrollableKt.f(g0.a(g.a(fVar, orientation), f0VarB), oVar, orientation, f0VarB, z11, mVar.c((LayoutDirection) iVar2.l(CompositionLocalsKt.g()), orientation, z12), gVar, iVar, dVar2);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        return fVarF;
    }
}
