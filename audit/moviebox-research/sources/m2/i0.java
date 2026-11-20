package m2;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextPaint;
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
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f70616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextPaint f70617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f70618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f70619d = Float.NaN;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f70620e = Float.NaN;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BoringLayout.Metrics f70621f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f70622g;

    public i0(CharSequence charSequence, TextPaint textPaint, int i11) {
        this.f70616a = charSequence;
        this.f70617b = textPaint;
        this.f70618c = i11;
    }

    public final BoringLayout.Metrics a() {
        if (!this.f70622g) {
            this.f70621f = e.f70596a.c(this.f70616a, this.f70617b, t1.k(this.f70618c));
            this.f70622g = true;
        }
        return this.f70621f;
    }

    public final float b() {
        if (!Float.isNaN(this.f70619d)) {
            return this.f70619d;
        }
        BoringLayout.Metrics metricsA = a();
        float fCeil = metricsA != null ? metricsA.width : -1;
        if (fCeil < 0.0f) {
            CharSequence charSequence = this.f70616a;
            fCeil = (float) Math.ceil(Layout.getDesiredWidth(charSequence, 0, charSequence.length(), this.f70617b));
        }
        if (k0.e(fCeil, this.f70616a, this.f70617b)) {
            fCeil += 0.5f;
        }
        this.f70619d = fCeil;
        return fCeil;
    }

    public final float c() {
        if (!Float.isNaN(this.f70620e)) {
            return this.f70620e;
        }
        float fC = k0.c(this.f70616a, this.f70617b);
        this.f70620e = fC;
        return fC;
    }
}
