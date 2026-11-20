package com.bytedance.sdk.openadsdk.Ol;

import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.ExN.UFX;
import com.bytedance.sdk.component.ExN.dE;
import com.bytedance.sdk.openadsdk.core.SR;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.Cb;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY implements dE<Bitmap> {
    private final String pFF = "ImageLoaderToViewWrapper";

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final WeakReference<ImageView> f27108sc;

    private zY(ImageView imageView) {
        this.f27108sc = new WeakReference<>(imageView);
    }

    public static dE sc(Sfl sfl, String str, ImageView imageView) {
        return new pFF(sfl, str, new zY(imageView));
    }

    @Override // com.bytedance.sdk.component.ExN.dE
    public void sc(int i11, String str, @Nullable Throwable th2) {
    }

    @Override // com.bytedance.sdk.component.ExN.dE
    public void sc(UFX<Bitmap> ufx) {
        final ImageView imageView = this.f27108sc.get();
        if (imageView == null || !(ufx.pFF() instanceof Bitmap)) {
            return;
        }
        final Bitmap bitmapPFF = ufx.pFF();
        if (Cb.ExN()) {
            imageView.setImageBitmap(bitmapPFF);
        } else {
            SR.zY().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.Ol.zY.1
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageBitmap(bitmapPFF);
                }
            });
        }
    }
}
