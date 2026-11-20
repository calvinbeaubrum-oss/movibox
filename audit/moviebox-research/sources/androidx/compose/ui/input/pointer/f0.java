package androidx.compose.ui.input.pointer;

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
public abstract class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public androidx.compose.ui.layout.m f4695a;

    public boolean a() {
        return false;
    }

    public final androidx.compose.ui.layout.m b() {
        return this.f4695a;
    }

    public abstract boolean c();

    public abstract void d();

    public abstract void e(q qVar, PointerEventPass pointerEventPass, long j11);

    public final void f(androidx.compose.ui.layout.m mVar) {
        this.f4695a = mVar;
    }
}
