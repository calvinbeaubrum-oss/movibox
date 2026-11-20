package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
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
public final class g {
    @JvmName
    public static final int a(i iVar, int i11) {
        if (k.J()) {
            k.S(524444915, i11, -1, "androidx.compose.runtime.<get-currentCompositeKeyHash> (Composables.kt:228)");
        }
        int iM = iVar.M();
        if (k.J()) {
            k.R();
        }
        return iM;
    }

    @PublishedApi
    public static final void b() {
        throw new IllegalStateException("Invalid applier".toString());
    }

    public static final m c(i iVar, int i11) {
        if (k.J()) {
            k.S(-1165786124, i11, -1, "androidx.compose.runtime.rememberCompositionContext (Composables.kt:484)");
        }
        m mVarN = iVar.N();
        if (k.J()) {
            k.R();
        }
        return mVarN;
    }
}
