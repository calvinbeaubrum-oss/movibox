package androidx.compose.material;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.ui.R$string;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
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
    public static final String a(int i11, androidx.compose.runtime.i iVar, int i12) {
        String string;
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(-726638443, i12, -1, "androidx.compose.material.getString (Strings.android.kt:24)");
        }
        iVar.l(AndroidCompositionLocals_androidKt.f());
        Resources resources = ((Context) iVar.l(AndroidCompositionLocals_androidKt.g())).getResources();
        l.a aVar = l.f3097a;
        if (l.i(i11, aVar.e())) {
            string = resources.getString(R$string.navigation_menu);
        } else if (l.i(i11, aVar.a())) {
            string = resources.getString(R$string.close_drawer);
        } else if (l.i(i11, aVar.b())) {
            string = resources.getString(R$string.close_sheet);
        } else if (l.i(i11, aVar.c())) {
            string = resources.getString(R$string.default_error_message);
        } else if (l.i(i11, aVar.d())) {
            string = resources.getString(R$string.dropdown_menu);
        } else if (l.i(i11, aVar.g())) {
            string = resources.getString(R$string.range_start);
        } else {
            string = l.i(i11, aVar.f()) ? resources.getString(R$string.range_end) : "";
        }
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        return string;
    }
}
