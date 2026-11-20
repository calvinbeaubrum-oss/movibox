package androidx.compose.ui.text;

import java.util.List;
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
public final class q {
    public static final l a(String str, e0 e0Var, long j11, q2.e eVar, androidx.compose.ui.text.font.i.b bVar, List<AnnotatedString.b<y>> list, List<AnnotatedString.b<t>> list2, int i11, boolean z11) {
        return androidx.compose.ui.text.platform.e.b(str, e0Var, list, list2, i11, z11, j11, eVar, bVar);
    }

    public static final l c(o oVar, long j11, int i11, boolean z11) {
        return androidx.compose.ui.text.platform.e.a(oVar, i11, z11, j11);
    }

    public static final int d(float f11) {
        return (int) Math.ceil(f11);
    }
}
