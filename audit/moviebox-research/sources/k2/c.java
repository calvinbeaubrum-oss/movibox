package k2;

import android.content.Context;
import android.os.Build;
import androidx.compose.runtime.k;
import androidx.compose.ui.graphics.y1;
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
public final class c {
    public static final long a(int i11, androidx.compose.runtime.i iVar, int i12) {
        if (k.J()) {
            k.S(-1777644873, i12, -1, "androidx.compose.ui.res.colorResource (ColorResources.android.kt:36)");
        }
        Context context = (Context) iVar.l(AndroidCompositionLocals_androidKt.g());
        long jA = Build.VERSION.SDK_INT >= 23 ? b.f68203a.a(context, i11) : y1.b(context.getResources().getColor(i11));
        if (k.J()) {
            k.R();
        }
        return jA;
    }
}
