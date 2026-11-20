package androidx.compose.foundation.lazy;

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
public final class f {
    public static final androidx.compose.foundation.lazy.layout.h a(LazyListState lazyListState, int i11, androidx.compose.runtime.i iVar, int i12) {
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(-1877443446, i12, -1, "androidx.compose.foundation.lazy.rememberLazyListBeyondBoundsState (LazyListBeyondBoundsModifier.kt:26)");
        }
        boolean z11 = ((((i12 & 14) ^ 6) > 4 && iVar.Q(lazyListState)) || (i12 & 6) == 4) | ((((i12 & 112) ^ 48) > 32 && iVar.c(i11)) || (i12 & 48) == 32);
        Object objY = iVar.y();
        if (z11 || objY == androidx.compose.runtime.i.f3413a.a()) {
            objY = new g(lazyListState, i11);
            iVar.p(objY);
        }
        g gVar = (g) objY;
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        return gVar;
    }
}
