package com.bytedance.adsdk.ugeno.Ol.We;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.drawable.b;
import com.bumptech.glide.load.resource.drawable.c;
import com.bytedance.adsdk.ugeno.We;
import com.bytedance.adsdk.ugeno.qr.Qj;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY extends com.bytedance.adsdk.ugeno.pFF.zY<sc> {
    private float HC;
    private int We;
    private float jcs;
    protected ImageView.ScaleType pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected String f26337sc;
    protected boolean zY;

    public zY(Context context) {
        super(context);
        this.pFF = ImageView.ScaleType.FIT_XY;
        this.We = -1;
        this.jcs = -1.0f;
        this.HC = -1.0f;
    }

    private void eo() {
        if (this.jcs > 0.0f) {
            We.sc().pFF().sc(this.Tf, this.f26337sc, new com.bytedance.adsdk.ugeno.sc.InterfaceC0235sc() { // from class: com.bytedance.adsdk.ugeno.Ol.We.zY.1
                @Override // com.bytedance.adsdk.ugeno.sc.InterfaceC0235sc
                public void sc(Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    final Bitmap bitmapSc = Qj.sc(((com.bytedance.adsdk.ugeno.pFF.zY) zY.this).ExN, bitmap, (int) zY.this.jcs);
                    if (bitmapSc != null) {
                        Qj.sc(new Runnable() { // from class: com.bytedance.adsdk.ugeno.Ol.We.zY.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((sc) ((com.bytedance.adsdk.ugeno.pFF.zY) zY.this).Qj).setImageBitmap(bitmapSc);
                            }
                        });
                    }
                    zY zYVar = zY.this;
                    if (zYVar.zY || zYVar.HC > 0.0f) {
                        Bitmap bitmapSc2 = Qj.sc(((com.bytedance.adsdk.ugeno.pFF.zY) zY.this).ExN, bitmap, zY.this.HC > 0.0f ? (int) zY.this.HC : 10);
                        if (bitmapSc2 != null) {
                            final BitmapDrawable bitmapDrawable = new BitmapDrawable(((com.bytedance.adsdk.ugeno.pFF.zY) zY.this).ExN.getResources(), bitmapSc2);
                            Qj.sc(new Runnable() { // from class: com.bytedance.adsdk.ugeno.Ol.We.zY.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((sc) ((com.bytedance.adsdk.ugeno.pFF.zY) zY.this).Qj).setBackground(bitmapDrawable);
                                }
                            });
                        }
                    }
                }
            });
            return;
        }
        com.bytedance.adsdk.ugeno.sc scVarPFF = We.sc().pFF();
        com.bytedance.adsdk.ugeno.core.Qj qj2 = this.Tf;
        String str = this.f26337sc;
        T t11 = this.Qj;
        scVarPFF.sc(qj2, str, (ImageView) t11, ((sc) t11).getWidth(), ((sc) this.Qj).getHeight());
        if (this.zY || this.HC > 0.0f) {
            We.sc().pFF().sc(this.Tf, this.f26337sc, new com.bytedance.adsdk.ugeno.sc.InterfaceC0235sc() { // from class: com.bytedance.adsdk.ugeno.Ol.We.zY.2
                @Override // com.bytedance.adsdk.ugeno.sc.InterfaceC0235sc
                public void sc(Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    final Bitmap bitmapSc = Qj.sc(((com.bytedance.adsdk.ugeno.pFF.zY) zY.this).ExN, bitmap, zY.this.HC > 0.0f ? (int) zY.this.HC : 10);
                    Qj.sc(new Runnable() { // from class: com.bytedance.adsdk.ugeno.Ol.We.zY.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (bitmapSc != null) {
                                ((sc) ((com.bytedance.adsdk.ugeno.pFF.zY) zY.this).Qj).setBackground(new BitmapDrawable(((com.bytedance.adsdk.ugeno.pFF.zY) zY.this).ExN.getResources(), bitmapSc));
                            }
                        }
                    });
                }
            });
        }
    }

    private ImageView.ScaleType qr(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        switch (str) {
            case "center":
                return ImageView.ScaleType.CENTER;
            case "fitEnd":
                return ImageView.ScaleType.FIT_END;
            case "fitStart":
                return ImageView.ScaleType.FIT_START;
            case "centerInside":
                return ImageView.ScaleType.CENTER_INSIDE;
            case "fit":
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            case "fill":
            case "fitXY":
            default:
                return scaleType;
        }
    }

    private void zY() {
        if (TextUtils.isEmpty(this.f26337sc)) {
            return;
        }
        ((sc) this.Qj).setImageDrawable(null);
        if (this.f26337sc.startsWith("local://")) {
            try {
                ((sc) this.Qj).setImageResource(com.bytedance.adsdk.ugeno.qr.We.sc(this.ExN, this.f26337sc.replace("local://", "")));
            } catch (Throwable unused) {
            }
        } else {
            if (!this.f26337sc.startsWith("@")) {
                eo();
                return;
            }
            try {
                ((sc) this.Qj).setImageResource(Integer.parseInt(this.f26337sc.substring(1)));
            } catch (Exception unused2) {
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY, com.bytedance.adsdk.ugeno.zY
    public void Qj() {
        super.Qj();
        Drawable drawable = ((sc) this.Qj).getDrawable();
        if (Build.VERSION.SDK_INT < 28 || !b.a(drawable)) {
            return;
        }
        c.a(drawable).stop();
    }

    public void Qj(String str) {
        this.f26337sc = str;
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    public void pFF() {
        super.pFF();
        zY();
        ((sc) this.Qj).setScaleType(this.pFF);
        ((sc) this.Qj).setBorderColor(this.YdT);
        ((sc) this.Qj).setCornerRadius(this.yL);
        ((sc) this.Qj).setBorderWidth(this.Bs);
        int i11 = this.We;
        if (i11 != -1) {
            ((sc) this.Qj).setColorFilter(i11);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY, com.bytedance.adsdk.ugeno.zY
    public void qr() {
        super.qr();
        ((sc) this.Qj).post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.Ol.We.zY.3
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawable = ((sc) ((com.bytedance.adsdk.ugeno.pFF.zY) zY.this).Qj).getDrawable();
                if (Build.VERSION.SDK_INT < 28 || !b.a(drawable)) {
                    return;
                }
                c.a(drawable).start();
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public sc We() {
        sc scVar = new sc(this.ExN);
        scVar.sc(this);
        return scVar;
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    public void sc(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.sc(str, str2);
        str.hashCode();
        switch (str) {
            case "scaleMode":
            case "scaleType":
                this.pFF = qr(str2);
                break;
            case "imageBlur":
                this.jcs = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, -1.0f);
                break;
            case "isBgGaussianBlur":
                this.zY = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, false);
                break;
            case "src":
                this.f26337sc = str2;
                break;
            case "tintColor":
                this.We = com.bytedance.adsdk.ugeno.qr.sc.sc(str2);
                break;
            case "imageBgBlur":
                this.HC = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, -1.0f);
                break;
        }
    }
}
