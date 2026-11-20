package m2;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.RequiresApi;
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
@RequiresApi(23)
@Metadata
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f70615a = new i();

    public final void a(Canvas canvas, CharSequence charSequence, int i11, int i12, int i13, int i14, float f11, float f12, boolean z11, Paint paint) {
        canvas.drawTextRun(charSequence, i11, i12, i13, i14, f11, f12, z11, paint);
    }

    public final void b(Canvas canvas, char[] cArr, int i11, int i12, int i13, int i14, float f11, float f12, boolean z11, Paint paint) {
        canvas.drawTextRun(cArr, i11, i12, i13, i14, f11, f12, z11, paint);
    }
}
