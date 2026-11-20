package k2;

import androidx.annotation.StringRes;
import androidx.compose.runtime.k;
import java.util.Arrays;
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
public final class i {
    public static final String a(@StringRes int i11, androidx.compose.runtime.i iVar, int i12) {
        if (k.J()) {
            k.S(1223887937, i12, -1, "androidx.compose.ui.res.stringResource (StringResources.android.kt:32)");
        }
        String string = h.a(iVar, 0).getString(i11);
        if (k.J()) {
            k.R();
        }
        return string;
    }

    public static final String b(@StringRes int i11, Object[] objArr, androidx.compose.runtime.i iVar, int i12) {
        if (k.J()) {
            k.S(2071230100, i12, -1, "androidx.compose.ui.res.stringResource (StringResources.android.kt:46)");
        }
        String string = h.a(iVar, 0).getString(i11, Arrays.copyOf(objArr, objArr.length));
        if (k.J()) {
            k.R();
        }
        return string;
    }
}
