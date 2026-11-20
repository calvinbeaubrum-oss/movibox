package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.e0;
import androidx.compose.ui.text.t;
import androidx.compose.ui.text.y;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

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
@JvmName
public final class e {
    public static final androidx.compose.ui.text.l a(androidx.compose.ui.text.o oVar, int i11, boolean z11, long j11) {
        Intrinsics.e(oVar, "null cannot be cast to non-null type androidx.compose.ui.text.platform.AndroidParagraphIntrinsics");
        return new androidx.compose.ui.text.a((AndroidParagraphIntrinsics) oVar, i11, z11, j11, null);
    }

    public static final androidx.compose.ui.text.l b(String str, e0 e0Var, List<AnnotatedString.b<y>> list, List<AnnotatedString.b<t>> list2, int i11, boolean z11, long j11, q2.e eVar, androidx.compose.ui.text.font.i.b bVar) {
        return new androidx.compose.ui.text.a(new AndroidParagraphIntrinsics(str, e0Var, list, list2, bVar, eVar), i11, z11, j11, null);
    }
}
