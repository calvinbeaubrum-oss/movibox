package com.cloud.tmc.miniutils.util;

import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.applovin.sdk.AppLovinMediationProvider;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ImageUtils {

    /* JADX INFO: compiled from: source.java */
    public enum ImageType {
        TYPE_JPG("jpg"),
        TYPE_PNG("png"),
        TYPE_GIF("gif"),
        TYPE_TIFF("tiff"),
        TYPE_BMP("bmp"),
        TYPE_WEBP("webp"),
        TYPE_ICO("ico"),
        TYPE_UNKNOWN(AppLovinMediationProvider.UNKNOWN);

        String value;

        ImageType(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    public static Bitmap a(File file) {
        if (file == null) {
            return null;
        }
        return BitmapFactory.decodeFile(file.getAbsolutePath());
    }

    public static Bitmap b(String str) {
        if (h0.u(str)) {
            return null;
        }
        return BitmapFactory.decodeFile(str);
    }

    public static boolean c(Bitmap bitmap) {
        return bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0;
    }

    public static boolean d(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, int i11, boolean z11) throws Throwable {
        boolean zCompress = false;
        if (c(bitmap)) {
            Log.e("ImageUtils", "bitmap is empty.");
            return false;
        }
        if (bitmap.isRecycled()) {
            Log.e("ImageUtils", "bitmap is recycled.");
            return false;
        }
        if (!h0.c(file)) {
            Log.e("ImageUtils", "create or delete file <" + file + "> failed.");
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        zCompress = bitmap.compress(compressFormat, i11, bufferedOutputStream2);
                        if (z11 && !bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                        bufferedOutputStream2.close();
                    } catch (IOException e11) {
                        e = e11;
                        bufferedOutputStream = bufferedOutputStream2;
                        e.printStackTrace();
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        return zCompress;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e12) {
                                e12.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e13) {
                    e = e13;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e14) {
            e14.printStackTrace();
        }
        return zCompress;
    }

    /* JADX WARN: Code duplicated, block: B:62:0x012e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    public static File e(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i11, boolean z11) throws Throwable {
        OutputStream outputStreamOpenOutputStream;
        if (TextUtils.isEmpty(str)) {
            str = e0.a().getPackageName();
        }
        String str2 = System.currentTimeMillis() + "_" + i11 + InstructionFileId.DOT + (Bitmap.CompressFormat.JPEG.equals(compressFormat) ? "JPG" : compressFormat.name());
        OutputStream outputStream = null;
        if (Build.VERSION.SDK_INT < 29) {
            if (!h0.r("android.permission.WRITE_EXTERNAL_STORAGE")) {
                Log.e("ImageUtils", "save to album need storage permission");
                return null;
            }
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), str + "/" + str2);
            if (!d(bitmap, file, compressFormat, i11, z11)) {
                return null;
            }
            h0.w(file);
            return file;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str2);
        contentValues.put("mime_type", "image/*");
        Uri uri = Environment.getExternalStorageState().equals("mounted") ? MediaStore.Images.Media.EXTERNAL_CONTENT_URI : MediaStore.Images.Media.INTERNAL_CONTENT_URI;
        contentValues.put("relative_path", Environment.DIRECTORY_DCIM + "/" + str);
        contentValues.put("is_pending", (Integer) 1);
        Uri uriInsert = e0.a().getContentResolver().insert(uri, contentValues);
        if (uriInsert == null) {
            return null;
        }
        try {
            outputStreamOpenOutputStream = e0.a().getContentResolver().openOutputStream(uriInsert);
            try {
                try {
                    bitmap.compress(compressFormat, i11, outputStreamOpenOutputStream);
                    contentValues.clear();
                    contentValues.put("is_pending", (Integer) 0);
                    e0.a().getContentResolver().update(uriInsert, contentValues, null, null);
                    File fileA = h0.A(uriInsert);
                    if (outputStreamOpenOutputStream != null) {
                        try {
                            outputStreamOpenOutputStream.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                    return fileA;
                } catch (Exception e12) {
                    e = e12;
                    e0.a().getContentResolver().delete(uriInsert, null, null);
                    e.printStackTrace();
                    if (outputStreamOpenOutputStream != null) {
                        try {
                            outputStreamOpenOutputStream.close();
                        } catch (IOException e13) {
                            e13.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = outputStreamOpenOutputStream;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e14) {
                        e14.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e15) {
            e = e15;
            outputStreamOpenOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            if (outputStream != null) {
                outputStream.close();
            }
            throw th;
        }
    }

    @Nullable
    public static File f(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, boolean z11) {
        return e(bitmap, str, compressFormat, 100, z11);
    }
}
