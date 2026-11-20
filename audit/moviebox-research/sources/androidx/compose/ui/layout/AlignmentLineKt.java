package androidx.compose.ui.layout;

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
public final class AlignmentLineKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f4786a = new i(AlignmentLineKt$FirstBaseline$1.INSTANCE);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f4787b = new i(AlignmentLineKt$LastBaseline$1.INSTANCE);

    public static final i a() {
        return f4786a;
    }

    public static final i b() {
        return f4787b;
    }

    public static final int c(a aVar, int i11, int i12) {
        return aVar.a().invoke(Integer.valueOf(i11), Integer.valueOf(i12)).intValue();
    }
}
