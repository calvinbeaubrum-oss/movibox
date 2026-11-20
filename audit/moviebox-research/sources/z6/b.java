package z6;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.l0;
import g7.f;
import g7.l;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f81882d = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Context f81883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f81884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, l0> f81885c;

    public b(Drawable.Callback callback, String str, com.airbnb.lottie.b bVar, Map<String, l0> map) {
        if (TextUtils.isEmpty(str) || str.charAt(str.length() - 1) == '/') {
            this.f81884b = str;
        } else {
            this.f81884b = str + '/';
        }
        this.f81885c = map;
        d(bVar);
        if (callback instanceof View) {
            this.f81883a = ((View) callback).getContext().getApplicationContext();
        } else {
            this.f81883a = null;
        }
    }

    @Nullable
    public Bitmap a(String str) {
        l0 l0Var = this.f81885c.get(str);
        if (l0Var == null) {
            return null;
        }
        Bitmap bitmapB = l0Var.b();
        if (bitmapB != null) {
            return bitmapB;
        }
        Context context = this.f81883a;
        if (context == null) {
            return null;
        }
        String strC = l0Var.c();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strC.startsWith("data:") && strC.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strC.substring(strC.indexOf(44) + 1), 0);
                return c(str, l.m(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options), l0Var.f(), l0Var.d()));
            } catch (IllegalArgumentException e11) {
                f.d("data URL did not have correct base64 format.", e11);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.f81884b)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(context.getAssets().open(this.f81884b + strC), null, options);
                if (bitmapDecodeStream != null) {
                    return c(str, l.m(bitmapDecodeStream, l0Var.f(), l0Var.d()));
                }
                f.c("Decoded image `" + str + "` is null.");
                return null;
            } catch (IllegalArgumentException e12) {
                f.d("Unable to decode image `" + str + "`.", e12);
                return null;
            }
        } catch (IOException e13) {
            f.d("Unable to open asset.", e13);
            return null;
        }
    }

    public boolean b(Context context) {
        if (this.f81883a instanceof Application) {
            context = context.getApplicationContext();
        }
        return context == this.f81883a;
    }

    public final Bitmap c(String str, @Nullable Bitmap bitmap) {
        synchronized (f81882d) {
            this.f81885c.get(str).g(bitmap);
        }
        return bitmap;
    }

    public void d(@Nullable com.airbnb.lottie.b bVar) {
    }

    @Nullable
    public Bitmap e(String str, @Nullable Bitmap bitmap) {
        if (bitmap != null) {
            Bitmap bitmapB = this.f81885c.get(str).b();
            c(str, bitmap);
            return bitmapB;
        }
        l0 l0Var = this.f81885c.get(str);
        Bitmap bitmapB2 = l0Var.b();
        l0Var.g(null);
        return bitmapB2;
    }
}
