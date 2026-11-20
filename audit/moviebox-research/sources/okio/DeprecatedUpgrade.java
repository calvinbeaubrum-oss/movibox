package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

/* JADX INFO: renamed from: okio.-DeprecatedUpgrade, reason: invalid class name */
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@JvmName
public final class DeprecatedUpgrade {
    private static final DeprecatedOkio Okio = DeprecatedOkio.INSTANCE;
    private static final DeprecatedUtf8 Utf8 = DeprecatedUtf8.INSTANCE;

    public static final DeprecatedOkio getOkio() {
        return Okio;
    }

    public static final DeprecatedUtf8 getUtf8() {
        return Utf8;
    }
}
