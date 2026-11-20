package com.bytedance.sdk.openadsdk.utils;

import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class cvk implements com.bytedance.sdk.component.ExN.dE<Bitmap> {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final WeakReference<ImageView> f28771sc;

    public cvk(ImageView imageView) {
        this.f28771sc = new WeakReference<>(imageView);
    }

    @Override // com.bytedance.sdk.component.ExN.dE
    public void sc(int i11, String str, @Nullable Throwable th2) {
        ImageView imageView = this.f28771sc.get();
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.ExN.dE
    public void sc(com.bytedance.sdk.component.ExN.UFX<Bitmap> ufx) {
        ImageView imageView = this.f28771sc.get();
        if (imageView == null) {
            return;
        }
        if (ufx != null) {
            try {
                if (ufx.pFF() != null) {
                    imageView.setImageBitmap(ufx.pFF());
                    return;
                }
            } catch (Throwable unused) {
                imageView.setVisibility(8);
                return;
            }
        }
        imageView.setVisibility(8);
    }
}
