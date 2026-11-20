package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
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
public final class c0 {
    public static final AnnotatedString a(TextFieldValue textFieldValue) {
        return textFieldValue.a().o(textFieldValue.c());
    }

    public static final AnnotatedString b(TextFieldValue textFieldValue, int i11) {
        return textFieldValue.a().subSequence(androidx.compose.ui.text.c0.i(textFieldValue.c()), Math.min(androidx.compose.ui.text.c0.i(textFieldValue.c()) + i11, textFieldValue.d().length()));
    }

    public static final AnnotatedString c(TextFieldValue textFieldValue, int i11) {
        return textFieldValue.a().subSequence(Math.max(0, androidx.compose.ui.text.c0.j(textFieldValue.c()) - i11), androidx.compose.ui.text.c0.j(textFieldValue.c()));
    }
}
