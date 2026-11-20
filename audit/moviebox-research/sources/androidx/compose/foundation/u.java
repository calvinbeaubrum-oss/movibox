package androidx.compose.foundation;

import android.content.Context;
import android.widget.EdgeEffect;
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
public final class u extends EdgeEffect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f3022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f3023b;

    public u(Context context) {
        super(context);
        this.f3022a = q2.a.a(context).N0(q2.i.h(1));
    }

    public final void a(float f11) {
        float f12 = this.f3023b + f11;
        this.f3023b = f12;
        if (Math.abs(f12) > this.f3022a) {
            onRelease();
        }
    }

    @Override // android.widget.EdgeEffect
    public void onAbsorb(int i11) {
        this.f3023b = 0.0f;
        super.onAbsorb(i11);
    }

    @Override // android.widget.EdgeEffect
    public void onPull(float f11) {
        this.f3023b = 0.0f;
        super.onPull(f11);
    }

    @Override // android.widget.EdgeEffect
    public void onPull(float f11, float f12) {
        this.f3023b = 0.0f;
        super.onPull(f11, f12);
    }

    @Override // android.widget.EdgeEffect
    public void onRelease() {
        this.f3023b = 0.0f;
        super.onRelease();
    }
}
