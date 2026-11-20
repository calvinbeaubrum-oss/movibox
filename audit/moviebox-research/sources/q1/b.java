package q1;

import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import q2.i;

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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f74147a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ColorSchemeKeyTokens f74148b = ColorSchemeKeyTokens.OutlineVariant;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f74149c = i.h((float) 1.0d);

    public final ColorSchemeKeyTokens a() {
        return f74148b;
    }

    public final float b() {
        return f74149c;
    }
}
