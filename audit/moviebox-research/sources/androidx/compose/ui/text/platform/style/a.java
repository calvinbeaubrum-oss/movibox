package androidx.compose.ui.text.platform.style;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.ui.graphics.e5;
import androidx.compose.ui.graphics.f5;
import androidx.compose.ui.graphics.r4;
import androidx.compose.ui.graphics.w0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import z1.h;
import z1.l;
import z1.m;

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
public final class a extends CharacterStyle implements UpdateAppearance {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f6042a;

    public a(h hVar) {
        this.f6042a = hVar;
    }

    public final Paint.Cap a(int i11) {
        e5.a aVar = e5.f4128a;
        if (e5.e(i11, aVar.a())) {
            return Paint.Cap.BUTT;
        }
        if (e5.e(i11, aVar.b())) {
            return Paint.Cap.ROUND;
        }
        return e5.e(i11, aVar.c()) ? Paint.Cap.SQUARE : Paint.Cap.BUTT;
    }

    public final Paint.Join b(int i11) {
        f5.a aVar = f5.f4136a;
        if (f5.e(i11, aVar.b())) {
            return Paint.Join.MITER;
        }
        if (f5.e(i11, aVar.c())) {
            return Paint.Join.ROUND;
        }
        return f5.e(i11, aVar.a()) ? Paint.Join.BEVEL : Paint.Join.MITER;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (textPaint != null) {
            h hVar = this.f6042a;
            if (Intrinsics.b(hVar, l.f81716a)) {
                textPaint.setStyle(Paint.Style.FILL);
                return;
            }
            if (hVar instanceof m) {
                textPaint.setStyle(Paint.Style.STROKE);
                textPaint.setStrokeWidth(((m) this.f6042a).f());
                textPaint.setStrokeMiter(((m) this.f6042a).d());
                textPaint.setStrokeJoin(b(((m) this.f6042a).c()));
                textPaint.setStrokeCap(a(((m) this.f6042a).b()));
                r4 r4VarE = ((m) this.f6042a).e();
                textPaint.setPathEffect(r4VarE != null ? w0.a(r4VarE) : null);
            }
        }
    }
}
