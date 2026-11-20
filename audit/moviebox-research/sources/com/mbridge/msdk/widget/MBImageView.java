package com.mbridge.msdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.tools.ad;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bitmap f48608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f48609b;

    public MBImageView(Context context) {
        super(context);
        this.f48608a = null;
    }

    public MBImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f48608a = null;
    }

    public MBImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f48608a = null;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap = this.f48608a;
        if (bitmap == null || !bitmap.isRecycled()) {
            super.onDraw(canvas);
            return;
        }
        ad.b("mb-widget-imageview", "onDraw bitmap recycled");
        if (getContext() != null) {
            b.a(getContext()).a(this.f48609b, new c() { // from class: com.mbridge.msdk.widget.MBImageView.1
                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onFailedLoad(String str, String str2) {
                    ad.b("mb-widget-imageview", str2 + " load failed:" + str);
                }

                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onSuccessLoad(Bitmap bitmap2, String str) {
                    MBImageView.this.setImageBitmap(bitmap2);
                }
            });
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.f48608a = bitmap;
        if (bitmap == null || !bitmap.isRecycled()) {
            super.setImageBitmap(bitmap);
            return;
        }
        this.f48608a = null;
        super.setImageBitmap(null);
        ad.b("mb-widget-imageview", "setImageBitmap recycled");
    }

    public void setImageUrl(String str) {
        this.f48609b = str;
    }
}
