package tb;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.JvmField;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public boolean f76932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public boolean f76933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public String f76934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public Bundle f76935d;

    public String toString() {
        return "AppRestartResult{canRestart=" + this.f76932a + ", closeAllWindow=" + this.f76933b + ", startUrl=" + this.f76934c + '}';
    }
}
