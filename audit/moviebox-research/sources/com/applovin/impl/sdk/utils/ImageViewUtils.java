package com.applovin.impl.sdk.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.StrictMode;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sj;
import com.applovin.impl.yp;
import com.applovin.impl.z3;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ImageViewUtils {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Uri uri, final ImageView imageView) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i11 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(uri.getPath(), options);
        int height = imageView.getHeight();
        int width = imageView.getWidth();
        if (height <= 0 || width <= 0) {
            Point pointB = z3.b(imageView.getContext());
            height = Math.min(pointB.x, pointB.y);
            width = height;
        }
        int i12 = options.outHeight;
        int i13 = options.outWidth;
        if (i12 > height || i13 > width) {
            while (true) {
                int i14 = i11 * 2;
                if (i12 / i14 < height && i13 / i14 < width) {
                    break;
                } else {
                    i11 = i14;
                }
            }
        }
        options.inSampleSize = i11;
        options.inJustDecodeBounds = false;
        j.f22563v0.J();
        if (n.a()) {
            j.f22563v0.J().a("ImageViewUtils", "Loading image: " + uri.getLastPathSegment() + "...");
        }
        final Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(uri.getPath(), options);
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.e
            @Override // java.lang.Runnable
            public final void run() {
                imageView.setImageBitmap(bitmapDecodeFile);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(j jVar, Bitmap bitmap, ImageView imageView) {
        jVar.J();
        if (n.a()) {
            jVar.J().a("ImageViewUtils", "Image fetched");
        }
        imageView.setImageDrawable(new BitmapDrawable(j.l().getResources(), bitmap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(final j jVar, String str, final ImageView imageView, Uri uri) {
        if (!((Boolean) jVar.a(sj.F)).booleanValue()) {
            InputStream inputStreamOpenStream = null;
            try {
                inputStreamOpenStream = FirebasePerfUrlConnection.openStream(new URL(str));
                final Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenStream);
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageViewUtils.b(jVar, bitmapDecodeStream, imageView);
                    }
                });
                yp.a(inputStreamOpenStream, jVar);
                return;
            } catch (Throwable th2) {
                try {
                    jVar.J();
                    if (n.a()) {
                        jVar.J().a("ImageViewUtils", "Failed to fetch image: " + uri, th2);
                    }
                    return;
                } finally {
                    yp.a(inputStreamOpenStream, jVar);
                }
            }
        }
        try {
            InputStream inputStreamOpenStream2 = FirebasePerfUrlConnection.openStream(new URL(str));
            try {
                final Bitmap bitmapDecodeStream2 = BitmapFactory.decodeStream(inputStreamOpenStream2);
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageViewUtils.a(jVar, bitmapDecodeStream2, imageView);
                    }
                });
                if (inputStreamOpenStream2 != null) {
                    inputStreamOpenStream2.close();
                }
            } catch (Throwable th3) {
                if (inputStreamOpenStream2 != null) {
                    try {
                        inputStreamOpenStream2.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (Throwable th5) {
            jVar.J();
            if (n.a()) {
                jVar.J().a("ImageViewUtils", "Failed to fetch image: " + uri, th5);
            }
            jVar.J().a("ImageViewUtils", th5);
            jVar.E().a("ImageViewUtils", "setImageUri", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(ImageView imageView, Uri uri) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        imageView.setImageURI(uri);
        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(j jVar, Bitmap bitmap, ImageView imageView) {
        jVar.J();
        if (n.a()) {
            jVar.J().a("ImageViewUtils", "Image fetched");
        }
        imageView.setImageDrawable(new BitmapDrawable(j.l().getResources(), bitmap));
    }

    public static void setAndDownscaleBitmap(final ImageView imageView, final Uri uri) {
        if (uri == null || imageView == null) {
            return;
        }
        j jVar = j.f22563v0;
        if (jVar == null) {
            n.h("ImageViewUtils", "SDK has not been initialized");
        } else {
            jVar.j0().b().execute(new Runnable() { // from class: com.applovin.impl.sdk.utils.c
                @Override // java.lang.Runnable
                public final void run() {
                    ImageViewUtils.a(uri, imageView);
                }
            });
        }
    }

    public static void setAndDownscaleImageUri(final ImageView imageView, final Uri uri) {
        if (uri == null || imageView == null) {
            return;
        }
        if (imageView.getHeight() <= 0 || imageView.getWidth() <= 0) {
            imageView.post(new Runnable() { // from class: com.applovin.impl.sdk.utils.d
                @Override // java.lang.Runnable
                public final void run() {
                    ImageViewUtils.setAndDownscaleBitmap(imageView, uri);
                }
            });
        } else {
            setAndDownscaleBitmap(imageView, uri);
        }
    }

    public static void setImageUri(final ImageView imageView, final Uri uri, final j jVar) {
        if (imageView == null || uri == null) {
            return;
        }
        final String string = uri.toString();
        if (URLUtil.isFileUrl(string) || URLUtil.isContentUrl(string)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.g
                @Override // java.lang.Runnable
                public final void run() {
                    ImageViewUtils.b(imageView, uri);
                }
            });
            return;
        }
        if (jVar == null) {
            return;
        }
        jVar.J();
        if (n.a()) {
            jVar.J().a("ImageViewUtils", "Fetching image: " + uri);
        }
        jVar.j0().b().execute(new Runnable() { // from class: com.applovin.impl.sdk.utils.f
            @Override // java.lang.Runnable
            public final void run() {
                ImageViewUtils.a(jVar, string, imageView, uri);
            }
        });
    }
}
