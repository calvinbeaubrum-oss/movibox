package com.mbridge.msdk.video.module.a.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ac;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class j extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f48023a;

    public j(ImageView imageView, int i11) {
        super(imageView);
        this.f48023a = i11;
    }

    @Override // com.mbridge.msdk.video.module.a.a.e, com.mbridge.msdk.foundation.same.c.c
    public final void onSuccessLoad(Bitmap bitmap, String str) {
        Bitmap bitmapA;
        if (bitmap == null) {
            return;
        }
        try {
            if (this.f48017b == null || bitmap.isRecycled() || (bitmapA = ac.a(bitmap, 1, this.f48023a)) == null) {
                return;
            }
            this.f48017b.setImageBitmap(bitmapA);
        } catch (Throwable th2) {
            if (MBridgeConstans.DEBUG) {
                th2.printStackTrace();
            }
        }
    }
}
