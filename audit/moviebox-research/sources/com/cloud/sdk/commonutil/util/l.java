package com.cloud.sdk.commonutil.util;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f30299a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f30300b = true;

    public static void a(ImageView imageView) {
        Bitmap bitmap;
        if (imageView != null) {
            try {
                if (imageView.getDrawable() != null && !b()) {
                    if (imageView.getDrawable() instanceof BitmapDrawable) {
                        BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
                        if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null && !bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                    } else {
                        imageView.setImageDrawable(null);
                    }
                }
            } catch (Throwable th2) {
                c.Log().w("HisavanaImageLoader", Log.getStackTraceString(th2));
            }
        }
    }

    public static boolean b() {
        return f30299a;
    }

    public static void c() {
        try {
            f30299a = true;
        } catch (Throwable unused) {
            c.Log().e("ssp", "init glide error, com.bumptech.glide.Glide not found!");
        }
    }

    public static boolean d(String str, ImageView imageView, boolean z11) {
        try {
            if (!TextUtils.isEmpty(str) && imageView != null && b() && f30300b) {
                RequestOptions requestOptionsDiskCacheStrategy = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE);
                if (z11) {
                    requestOptionsDiskCacheStrategy = requestOptionsDiskCacheStrategy.useUnlimitedSourceGeneratorsPool(true).priority(Priority.IMMEDIATE);
                }
                Glide.with(f.a()).load2(str).apply((BaseRequestOptions<?>) requestOptionsDiskCacheStrategy).into(imageView);
                return true;
            }
            return false;
        } catch (Throwable th2) {
            c.Log().w("HisavanaImageLoader", "Glide：" + th2.getMessage());
            return false;
        }
    }
}
