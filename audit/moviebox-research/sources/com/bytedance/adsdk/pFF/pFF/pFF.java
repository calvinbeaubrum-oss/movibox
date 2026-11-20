package com.bytedance.adsdk.pFF.pFF;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.bytedance.adsdk.pFF.TRI.TRI;
import com.bytedance.adsdk.pFF.WH;
import com.bytedance.adsdk.pFF.We;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final Object f26170sc = new Object();
    private final Map<String, WH> ExN;
    private We We;
    private final Context pFF;
    private final String zY;

    public pFF(Drawable.Callback callback, String str, We we2, Map<String, WH> map) {
        if (TextUtils.isEmpty(str) || str.charAt(str.length() - 1) == '/') {
            this.zY = str;
        } else {
            this.zY = str + '/';
        }
        this.ExN = map;
        sc(we2);
        if (callback instanceof View) {
            this.pFF = ((View) callback).getContext().getApplicationContext();
        } else {
            this.pFF = null;
        }
    }

    private Bitmap pFF(String str, Bitmap bitmap) {
        synchronized (f26170sc) {
        }
        return bitmap;
    }

    public Bitmap sc(String str) {
        WH wh2 = this.ExN.get(str);
        if (wh2 == null) {
            return null;
        }
        Bitmap bitmapUFX = wh2.UFX();
        if (bitmapUFX != null) {
            return bitmapUFX;
        }
        We we2 = this.We;
        if (we2 != null) {
            return we2.sc(wh2);
        }
        Context context = this.pFF;
        if (context == null) {
            return null;
        }
        String strOl = wh2.Ol();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strOl.startsWith("data:") && strOl.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strOl.substring(strOl.indexOf(44) + 1), 0);
                return pFF(str, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.zY)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(context.getAssets().open(this.zY + strOl), null, options);
                if (bitmapDecodeStream == null) {
                    return null;
                }
                return pFF(str, TRI.sc(bitmapDecodeStream, wh2.sc(), wh2.pFF()));
            } catch (IllegalArgumentException unused2) {
                return null;
            }
        } catch (IOException unused3) {
            return null;
        }
    }

    public Bitmap sc(String str, Bitmap bitmap) {
        if (bitmap != null) {
            return this.ExN.get(str).UFX();
        }
        WH wh2 = this.ExN.get(str);
        Bitmap bitmapUFX = wh2.UFX();
        wh2.sc(null);
        return bitmapUFX;
    }

    public void sc(We we2) {
        this.We = we2;
    }

    public boolean sc(Context context) {
        return (context == null && this.pFF == null) || this.pFF.equals(context);
    }
}
