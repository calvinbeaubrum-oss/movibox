package androidx.compose.ui.text.platform.style;

import android.graphics.Shader;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.runtime.a3;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.r2;
import androidx.compose.runtime.u2;
import androidx.compose.ui.graphics.a5;
import androidx.compose.ui.text.platform.f;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import y1.m;

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
public final class ShaderBrushSpan extends CharacterStyle implements UpdateAppearance {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a5 f6038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f6039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i1 f6040c = u2.c(m.c(m.f81091b.a()), null, 2, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a3<Shader> f6041d = r2.c(new Function0<Shader>() { // from class: androidx.compose.ui.text.platform.style.ShaderBrushSpan$shaderState$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Shader invoke() {
            if (this.this$0.b() == 9205357640488583168L || m.k(this.this$0.b())) {
                return null;
            }
            return this.this$0.a().b(this.this$0.b());
        }
    });

    public ShaderBrushSpan(a5 a5Var, float f11) {
        this.f6038a = a5Var;
        this.f6039b = f11;
    }

    public final a5 a() {
        return this.f6038a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long b() {
        return ((m) this.f6040c.getValue()).m();
    }

    public final void c(long j11) {
        this.f6040c.setValue(m.c(j11));
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        f.a(textPaint, this.f6039b);
        textPaint.setShader(this.f6041d.getValue());
    }
}
