package n2;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
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
public final class l extends CharacterStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f71484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f71485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f71486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f71487d;

    public l(int i11, float f11, float f12, float f13) {
        this.f71484a = i11;
        this.f71485b = f11;
        this.f71486c = f12;
        this.f71487d = f13;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setShadowLayer(this.f71487d, this.f71485b, this.f71486c, this.f71484a);
    }
}
