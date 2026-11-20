package androidx.compose.ui.input.pointer;

import kotlin.Deprecated;
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
@Deprecated
@Metadata
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4694b;

    public f(boolean z11, boolean z12) {
        this.f4693a = z11;
        this.f4694b = z12;
    }

    public final boolean a() {
        return this.f4694b;
    }

    public final boolean b() {
        return this.f4693a;
    }

    public final void c(boolean z11) {
        this.f4694b = z11;
    }

    public final void d(boolean z11) {
        this.f4693a = z11;
    }
}
