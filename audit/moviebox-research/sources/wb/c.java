package wb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f79411a = new c();

    @JvmStatic
    public static final File b(File imageFile, int i11, int i12, int i13, String str) {
        Bitmap.CompressFormat compressFormat;
        Intrinsics.g(imageFile, "imageFile");
        String strT = FilesKt__UtilsKt.t(imageFile);
        if (Intrinsics.b(strT, "png")) {
            compressFormat = Bitmap.CompressFormat.PNG;
        } else if (!Intrinsics.b(strT, "webp")) {
            compressFormat = Bitmap.CompressFormat.JPEG;
        } else if (Build.VERSION.SDK_INT >= 30) {
            compressFormat = i11 == 100 ? Bitmap.CompressFormat.WEBP_LOSSLESS : Bitmap.CompressFormat.WEBP_LOSSY;
        } else {
            compressFormat = Bitmap.CompressFormat.WEBP;
        }
        byte[] bArrC = c(FilesKt__FileReadWriteKt.d(imageFile), i11, i12, i13, compressFormat);
        if (str == null || str.length() == 0) {
            str = imageFile.getParent();
        }
        File file = new File(str, "compressed_" + imageFile.getName());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArrC);
            fileOutputStream.flush();
            Unit unit = Unit.f68710a;
            CloseableKt.a(fileOutputStream, null);
            return file;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.a(fileOutputStream, th2);
                throw th3;
            }
        }
    }

    @JvmStatic
    public static final byte[] c(byte[] imageData, int i11, int i12, int i13, Bitmap.CompressFormat format) {
        int iC;
        Bitmap bitmapCreateScaledBitmap;
        Intrinsics.g(imageData, "imageData");
        Intrinsics.g(format, "format");
        if (format == Bitmap.CompressFormat.PNG) {
            return imageData;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(imageData, 0, imageData.length, options);
        int i14 = options.outWidth;
        int i15 = options.outHeight;
        if (i12 > 0 && i13 > 0) {
            iC = kotlin.ranges.a.g(a20.b.c(i15 / i13), a20.b.c(i14 / i12));
        } else if (i12 > 0) {
            iC = a20.b.c(i14 / i12);
        } else {
            iC = i13 > 0 ? a20.b.c(i15 / i13) : 1;
        }
        options.inSampleSize = f79411a.a(options, iC);
        options.inJustDecodeBounds = false;
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(imageData, 0, imageData.length, options);
        int width = bitmapDecodeByteArray.getWidth();
        int height = bitmapDecodeByteArray.getHeight();
        if (i12 > 0 && i13 > 0) {
            bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, i12, i13, true);
        } else if (i12 > 0) {
            bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, i12, (int) (height * (i12 / width)), true);
        } else {
            bitmapCreateScaledBitmap = i13 > 0 ? Bitmap.createScaledBitmap(bitmapDecodeByteArray, (int) (width * (i13 / height)), i13, true) : bitmapDecodeByteArray;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapCreateScaledBitmap.compress(format, i11, byteArrayOutputStream);
        bitmapCreateScaledBitmap.recycle();
        bitmapDecodeByteArray.recycle();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.f(byteArray, "outputStream.toByteArray()");
        return byteArray;
    }

    public final int a(BitmapFactory.Options options, int i11) {
        int i12 = options.outWidth;
        int i13 = options.outHeight;
        int i14 = 1;
        int i15 = i13;
        int i16 = i12;
        while (true) {
            if (i15 <= i13 / i11 && i16 <= i12 / i11) {
                return i14;
            }
            i15 >>= 1;
            i16 >>= 1;
            i14 <<= 1;
        }
    }
}
