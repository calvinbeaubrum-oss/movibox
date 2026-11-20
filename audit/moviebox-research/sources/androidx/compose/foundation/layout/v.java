package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.k0;
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
public final class v {
    public static final m a(z zVar) {
        if (zVar != null) {
            return zVar.a();
        }
        return null;
    }

    public static final boolean b(z zVar) {
        if (zVar != null) {
            return zVar.b();
        }
        return true;
    }

    public static final z c(androidx.compose.ui.layout.j jVar) {
        Object objF = jVar.F();
        if (objF instanceof z) {
            return (z) objF;
        }
        return null;
    }

    public static final z d(k0 k0Var) {
        Object objF = k0Var.F();
        if (objF instanceof z) {
            return (z) objF;
        }
        return null;
    }

    public static final float e(z zVar) {
        if (zVar != null) {
            return zVar.d();
        }
        return 0.0f;
    }

    public static final boolean f(z zVar) {
        m mVarA = a(zVar);
        if (mVarA != null) {
            return mVarA.c();
        }
        return false;
    }
}
