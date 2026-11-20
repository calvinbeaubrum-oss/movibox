package com.cloud.tmc.kernel.proxy.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import vc.a;
import vc.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface ImageLoaderProxy {
    void loadImg(@NonNull Context context, int i11, int i12, @NonNull ImageView imageView);

    void loadImg(@NonNull Context context, int i11, int i12, @NonNull ImageView imageView, a<Drawable> aVar);

    void loadImg(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView);

    void loadImg(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView, @Nullable Drawable drawable);

    void loadImg(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView, @Nullable Drawable drawable, @Nullable Drawable drawable2);

    @Nullable
    Bitmap loadImgBitmap(@NonNull Context context, @NonNull String str);

    void loadImgBitmapNoRound(@NonNull Context context, @NonNull String str, b bVar);

    @Nullable
    Bitmap loadImgBitmapSize(@NonNull Context context, @NonNull String str, int i11, int i12, int i13);

    File loadImgFile(@NonNull Context context, @NonNull String str);

    void loadImgGifPlay(@NonNull Context context, int i11, int i12, @NonNull ImageView imageView);

    void loadImgGifPlay(@NonNull Context context, @Nullable File file, @Nullable Drawable drawable, @NonNull ImageView imageView);

    void loadImgGifPlay(@NonNull Context context, @Nullable File file, @Nullable Drawable drawable, @NonNull ImageView imageView, b bVar);

    void loadImgGifPlayOnce(@NonNull Context context, int i11, int i12, @NonNull ImageView imageView, @Nullable Function1<Drawable, Unit> function1);

    void loadImgGifPlayOnce(@NonNull Context context, @Nullable File file, int i11, @NonNull ImageView imageView, @Nullable Function1<Drawable, Unit> function1);

    void loadImgRoundCorners(@NonNull Context context, @NonNull File file, @NonNull ImageView imageView, int i11, int i12);

    void loadImgRoundCorners(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView, int i11);

    void loadImgRoundCorners(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView, int i11, int i12);

    void loadImgRoundCorners(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView, int i11, int i12, int i13);

    void loadImgRoundCornersCenterCrop(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView, int i11);

    void loadImgRoundCornersCenterCrop(@NonNull Context context, @NonNull String str, @NonNull ImageView imageView, int i11, int i12, int i13);

    boolean queryImgIsExist(@NonNull Context context, String str);
}
