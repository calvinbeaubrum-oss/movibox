package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.DisplayMetrics;
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
public final class q0 {
    public static final g4 a(int i11, int i12, int i13, boolean z11, androidx.compose.ui.graphics.colorspace.c cVar) {
        Bitmap bitmapCreateBitmap;
        Bitmap.Config configD = d(i13);
        if (Build.VERSION.SDK_INT >= 26) {
            bitmapCreateBitmap = c1.b(i11, i12, i13, z11, cVar);
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap((DisplayMetrics) null, i11, i12, configD);
            bitmapCreateBitmap.setHasAlpha(z11);
        }
        return new n0(bitmapCreateBitmap);
    }

    public static final Bitmap b(g4 g4Var) {
        if (g4Var instanceof n0) {
            return ((n0) g4Var).c();
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Bitmap");
    }

    public static final g4 c(Bitmap bitmap) {
        return new n0(bitmap);
    }

    public static final Bitmap.Config d(int i11) {
        h4.a aVar = h4.f4148b;
        if (h4.i(i11, aVar.b())) {
            return Bitmap.Config.ARGB_8888;
        }
        if (h4.i(i11, aVar.a())) {
            return Bitmap.Config.ALPHA_8;
        }
        if (h4.i(i11, aVar.e())) {
            return Bitmap.Config.RGB_565;
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 < 26 || !h4.i(i11, aVar.c())) {
            return (i12 < 26 || !h4.i(i11, aVar.d())) ? Bitmap.Config.ARGB_8888 : Bitmap.Config.HARDWARE;
        }
        return Bitmap.Config.RGBA_F16;
    }

    public static final int e(Bitmap.Config config) {
        if (config == Bitmap.Config.ALPHA_8) {
            return h4.f4148b.a();
        }
        if (config == Bitmap.Config.RGB_565) {
            return h4.f4148b.e();
        }
        if (config == Bitmap.Config.ARGB_4444) {
            return h4.f4148b.b();
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 26 || config != Bitmap.Config.RGBA_F16) {
            return (i11 < 26 || config != Bitmap.Config.HARDWARE) ? h4.f4148b.b() : h4.f4148b.d();
        }
        return h4.f4148b.c();
    }
}
