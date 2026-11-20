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
public final class p {
    public static final o a(String str, e0 e0Var, List<AnnotatedString.b<y>> list, List<AnnotatedString.b<t>> list2, q2.e eVar, androidx.compose.ui.text.font.i.b bVar) {
        return androidx.compose.ui.text.platform.d.a(str, e0Var, list, list2, eVar, bVar);
    }

    public static /* synthetic */ o b(String str, e0 e0Var, List list, List list2, q2.e eVar, androidx.compose.ui.text.font.i.b bVar, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            list = kotlin.collections.g.l();
        }
        List list3 = list;
        if ((i11 & 8) != 0) {
            list2 = kotlin.collections.g.l();
        }
        return a(str, e0Var, list3, list2, eVar, bVar);
    }
}
