package com.bytedance.adsdk.zY;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.pFF.TRI;
import com.bytedance.adsdk.pFF.WH;
import com.bytedance.adsdk.pFF.We;
import com.bytedance.adsdk.ugeno.pFF.zY;
import com.bytedance.adsdk.ugeno.qr.Qj;
import com.bytedance.adsdk.ugeno.zY.pFF;
import com.google.android.gms.common.internal.ImagesContract;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc extends zY<TRI> {
    private int GOt;
    private boolean HC;
    private boolean Pu;
    private float VZ;
    protected ImageView.ScaleType We;

    /* JADX INFO: renamed from: ef, reason: collision with root package name */
    private float f26485ef;
    private String jcs;
    protected HashMap<String, Bitmap> pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected String f26486sc;

    @Deprecated
    private boolean ymG;
    protected ImageView.ScaleType zY;

    /* JADX INFO: renamed from: com.bytedance.adsdk.zY.sc$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass1 implements We {
        public AnonymousClass1() {
        }

        @Override // com.bytedance.adsdk.pFF.We
        public Bitmap sc(final WH wh2) {
            final String strSc;
            if (wh2 == null) {
                return null;
            }
            String strWH = wh2.WH();
            String strOl = wh2.Ol();
            if (!TextUtils.isEmpty(strWH) && TextUtils.isEmpty(strOl)) {
                strSc = pFF.sc(strWH, ((zY) sc.this).f26430qr);
            } else if (!TextUtils.isEmpty(strOl) && TextUtils.isEmpty(strWH)) {
                strSc = pFF.sc(strOl, ((zY) sc.this).f26430qr);
            } else if (TextUtils.isEmpty(strOl) || TextUtils.isEmpty(strWH)) {
                strSc = null;
            } else {
                strSc = pFF.sc(strWH, ((zY) sc.this).f26430qr) + pFF.sc(strOl, ((zY) sc.this).f26430qr);
            }
            if (TextUtils.isEmpty(strSc)) {
                return null;
            }
            Bitmap bitmap = sc.this.pFF.get(strSc);
            if (bitmap != null) {
                return bitmap;
            }
            com.bytedance.adsdk.ugeno.We.sc().pFF().sc(((zY) sc.this).Tf, strSc, new com.bytedance.adsdk.ugeno.sc.InterfaceC0235sc() { // from class: com.bytedance.adsdk.zY.sc.1.1
                @Override // com.bytedance.adsdk.ugeno.sc.InterfaceC0235sc
                public void sc(Bitmap bitmap2) {
                    if (bitmap2 != null) {
                        final Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, wh2.sc(), wh2.pFF(), false);
                        sc.this.pFF.put(strSc, bitmapCreateScaledBitmap);
                        Qj.sc(new Runnable() { // from class: com.bytedance.adsdk.zY.sc.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((TRI) ((zY) sc.this).Qj).sc(wh2.Qj(), bitmapCreateScaledBitmap);
                            }
                        });
                    }
                }
            });
            return sc.this.pFF.get(strSc);
        }
    }

    public sc(Context context) {
        super(context);
        this.jcs = "images";
        this.f26485ef = 1.0f;
        this.zY = ImageView.ScaleType.FIT_CENTER;
        this.We = ImageView.ScaleType.FIT_XY;
        this.pFF = new HashMap<>();
    }

    private ImageView.ScaleType Ol(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        switch (str) {
            case "center":
            case "none":
                return ImageView.ScaleType.CENTER;
            case "fit":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
                return ImageView.ScaleType.CENTER_CROP;
            case "fill":
            default:
                return scaleType;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private ImageView.ScaleType Qj(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        byte b11 = -1;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(TtmlNode.CENTER)) {
                    b11 = 0;
                }
                break;
            case -1274298614:
                if (str.equals("fitEnd")) {
                    b11 = 1;
                }
                break;
            case -522179887:
                if (str.equals("fitStart")) {
                    b11 = 2;
                }
                break;
            case -340708175:
                if (str.equals("centerInside")) {
                    b11 = 3;
                }
                break;
            case 97441490:
                if (str.equals("fitXY")) {
                    b11 = 4;
                }
                break;
            case 520762310:
                if (str.equals("fitCenter")) {
                    b11 = 5;
                }
                break;
            case 1161480325:
                if (str.equals("centerCrop")) {
                    b11 = 6;
                }
                break;
        }
        switch (b11) {
            case 0:
                return ImageView.ScaleType.CENTER;
            case 1:
                return ImageView.ScaleType.FIT_END;
            case 2:
                return ImageView.ScaleType.FIT_START;
            case 3:
                return ImageView.ScaleType.CENTER_INSIDE;
            case 4:
            default:
                return scaleType;
            case 5:
                return ImageView.ScaleType.FIT_CENTER;
            case 6:
                return ImageView.ScaleType.CENTER_CROP;
        }
    }

    private String qr(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(ImagesContract.LOCAL)) {
            return "";
        }
        if (str.contains("shake_phone")) {
            return "lottie_json/shake_phone.json";
        }
        return str.contains("swipe_right") ? "lottie_json/swipe_right.json" : "";
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    public void pFF() {
        super.pFF();
        ((TRI) this.Qj).setProgress(this.VZ);
        if (this.f26485ef <= 0.0f) {
            this.f26485ef = 1.0f;
        }
        ((TRI) this.Qj).setSpeed(this.f26485ef);
        if (this.f26486sc.startsWith(ImagesContract.LOCAL)) {
            ((TRI) this.Qj).setAnimation(qr(this.f26486sc));
            ((TRI) this.Qj).setImageAssetsFolder(this.jcs);
        } else {
            ((TRI) this.Qj).setAnimationFromUrl(this.f26486sc);
        }
        ((TRI) this.Qj).setImageAssetDelegate(new AnonymousClass1());
        if (McK()) {
            ((TRI) this.Qj).setScaleType(this.We);
        } else {
            ((TRI) this.Qj).setScaleType(this.zY);
        }
        if (McK()) {
            ((TRI) this.Qj).setRepeatCount(this.GOt);
        } else {
            ((TRI) this.Qj).sc(this.ymG);
        }
        zY();
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public TRI We() {
        TRI tri = new TRI(this.ExN);
        tri.sc(this);
        return tri;
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    public void sc(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.sc(str, str2);
        str.hashCode();
        switch (str) {
            case "scaleMode":
                this.We = Ol(str2);
                break;
            case "scaleType":
                this.zY = Qj(str2);
                break;
            case "progress":
                this.VZ = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0.0f);
                break;
            case "imagePath":
                this.jcs = str2;
                break;
            case "autoReverse":
                this.HC = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, false);
                break;
            case "src":
                this.f26486sc = str2;
                break;
            case "loop":
                if (!McK()) {
                    this.ymG = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, false);
                    break;
                } else {
                    this.GOt = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0);
                    break;
                }
                break;
            case "speed":
                this.f26485ef = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 1.0f);
                break;
            case "autoPlay":
                this.Pu = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, false);
                break;
            case "autoplay":
                this.Pu = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, true);
                break;
        }
    }

    public void zY() {
        ((TRI) this.Qj).sc();
    }
}
