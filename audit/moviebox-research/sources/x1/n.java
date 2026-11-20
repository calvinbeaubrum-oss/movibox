package x1;

import android.view.ViewStructure;
import androidx.annotation.RequiresApi;
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
@RequiresApi(23)
@Metadata
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f79831a = new n();

    @RequiresApi(23)
    public final int a(ViewStructure viewStructure, int i11) {
        return viewStructure.addChildCount(i11);
    }

    @RequiresApi(23)
    public final ViewStructure b(ViewStructure viewStructure, int i11) {
        return viewStructure.newChild(i11);
    }

    @RequiresApi(23)
    public final void c(ViewStructure viewStructure, int i11, int i12, int i13, int i14, int i15, int i16) {
        viewStructure.setDimens(i11, i12, i13, i14, i15, i16);
    }

    @RequiresApi(23)
    public final void d(ViewStructure viewStructure, int i11, String str, String str2, String str3) {
        viewStructure.setId(i11, str, str2, str3);
    }
}
