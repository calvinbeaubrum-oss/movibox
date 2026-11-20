package androidx.compose.foundation;

import android.content.Context;
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
public final class a {
    public static final f0 a(androidx.compose.runtime.i iVar, int i11) {
        f0 f0Var;
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(-1476348564, i11, -1, "androidx.compose.foundation.rememberOverscrollEffect (AndroidOverscroll.android.kt:63)");
        }
        Context context = (Context) iVar.l(AndroidCompositionLocals_androidKt.g());
        e0 e0Var = (e0) iVar.l(OverscrollConfiguration_androidKt.a());
        if (e0Var != null) {
            iVar.R(1586021609);
            boolean zQ = iVar.Q(context) | iVar.Q(e0Var);
            Object objY = iVar.y();
            if (zQ || objY == androidx.compose.runtime.i.f3413a.a()) {
                objY = new AndroidEdgeEffectOverscrollEffect(context, e0Var);
                iVar.p(objY);
            }
            f0Var = (AndroidEdgeEffectOverscrollEffect) objY;
            iVar.L();
        } else {
            iVar.R(1586120933);
            iVar.L();
            f0Var = d0.f2264a;
        }
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        return f0Var;
    }
}
