package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
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
public final class n0 implements g4 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap f4315b;

    public n0(Bitmap bitmap) {
        this.f4315b = bitmap;
    }

    @Override // androidx.compose.ui.graphics.g4
    public void a() {
        this.f4315b.prepareToDraw();
    }

    @Override // androidx.compose.ui.graphics.g4
    public int b() {
        return q0.e(this.f4315b.getConfig());
    }

    public final Bitmap c() {
        return this.f4315b;
    }

    @Override // androidx.compose.ui.graphics.g4
    public int getHeight() {
        return this.f4315b.getHeight();
    }

    @Override // androidx.compose.ui.graphics.g4
    public int getWidth() {
        return this.f4315b.getWidth();
    }
}
