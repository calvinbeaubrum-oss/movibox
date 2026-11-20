package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.resource.drawable.b;
import com.bumptech.glide.load.resource.drawable.c;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class UFX extends TRI {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f26812sc;

    /* JADX INFO: compiled from: source.java */
    public static class pFF implements com.bytedance.sdk.component.ExN.dE<Bitmap> {
        private Resources pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private WeakReference<View> f26814sc;

        public pFF(View view, Resources resources) {
            this.f26814sc = new WeakReference<>(view);
            this.pFF = resources;
        }

        @Override // com.bytedance.sdk.component.ExN.dE
        public void sc(int i11, String str, @Nullable Throwable th2) {
        }

        @Override // com.bytedance.sdk.component.ExN.dE
        public void sc(com.bytedance.sdk.component.ExN.UFX<Bitmap> ufx) {
            Bitmap bitmapPFF;
            View view = this.f26814sc.get();
            if (view == null || (bitmapPFF = ufx.pFF()) == null || ufx.zY() == null) {
                return;
            }
            view.setBackground(new BitmapDrawable(this.pFF, bitmapPFF));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class sc implements com.bytedance.sdk.component.ExN.Qj {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final WeakReference<Context> f26815sc;

        public sc(Context context) {
            this.f26815sc = new WeakReference<>(context);
        }

        @Override // com.bytedance.sdk.component.ExN.Qj
        public Bitmap sc(Bitmap bitmap) {
            Context context = this.f26815sc.get();
            if (context != null) {
                return com.bytedance.sdk.component.adexpress.We.sc.sc(context, bitmap, 25);
            }
            return null;
        }
    }

    public UFX(Context context, @NonNull DynamicRootView dynamicRootView, @NonNull com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        super(context, dynamicRootView, qj2);
        if (!TextUtils.isEmpty(this.Tf.NP()) && qj2.Sfl()) {
            com.bytedance.sdk.component.adexpress.TRI.WH wh2 = new com.bytedance.sdk.component.adexpress.TRI.WH(context);
            wh2.setAnimationsLoop(this.Tf.otH());
            wh2.setImageLottieTosPath(this.Tf.NP());
            wh2.setLottieAppNameMaxLength(this.Tf.IEI());
            wh2.setLottieAdTitleMaxLength(this.Tf.dix());
            wh2.setLottieAdDescMaxLength(this.Tf.mD());
            wh2.setData(qj2.YIK());
            this.BT = wh2;
        } else if (this.Tf.BT() > 0.0f) {
            com.bytedance.sdk.component.adexpress.TRI.WP wp2 = new com.bytedance.sdk.component.adexpress.TRI.WP(context);
            this.BT = wp2;
            wp2.setXRound((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(context, this.Tf.BT()));
            ((com.bytedance.sdk.component.adexpress.TRI.WP) this.BT).setYRound((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(context, this.Tf.BT()));
        } else if (!Qj() && "arrowButton".equals(qj2.WH().pFF())) {
            com.bytedance.sdk.component.adexpress.dynamic.animation.view.pFF pff = new com.bytedance.sdk.component.adexpress.dynamic.animation.view.pFF(context);
            pff.setBrickNativeValue(this.Tf);
            this.BT = pff;
        } else if (com.bytedance.sdk.component.adexpress.We.WH.pFF(this.Tf.UFX())) {
            this.BT = new com.bytedance.sdk.component.adexpress.TRI.Ql(context);
        } else {
            this.BT = new ImageView(context);
        }
        this.f26812sc = getImageKey();
        this.BT.setTag(Integer.valueOf(getClickArea()));
        if ("arrowButton".equals(qj2.WH().pFF())) {
            if (this.Tf.pFF() > 0 || this.Tf.sc() > 0) {
                int iMin = Math.min(this.f26791qr, this.Qj);
                this.f26791qr = iMin;
                this.Qj = Math.min(iMin, this.Qj);
                this.Ol = (int) (this.Ol + com.bytedance.sdk.component.adexpress.We.Qj.sc(context, this.Tf.pFF() + (this.Tf.sc() / 2) + 0.5f));
            } else {
                int iMax = Math.max(this.f26791qr, this.Qj);
                this.f26791qr = iMax;
                this.Qj = Math.max(iMax, this.Qj);
            }
            this.Tf.sc(this.f26791qr / 2);
        }
        addView(this.BT, new FrameLayout.LayoutParams(this.f26791qr, this.Qj));
    }

    private String getImageKey() {
        Map<String, String> mapUFX = this.SR.getRenderRequest().UFX();
        if (mapUFX == null || mapUFX.size() <= 0) {
            return null;
        }
        return mapUFX.get(this.Tf.UFX());
    }

    private void sc(com.bytedance.sdk.component.ExN.WH wh2) {
        wh2.zY(3).sc(new com.bytedance.sdk.component.ExN.dE() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.UFX.1
            @Override // com.bytedance.sdk.component.ExN.dE
            public void sc(int i11, String str, Throwable th2) {
            }

            @Override // com.bytedance.sdk.component.ExN.dE
            public void sc(com.bytedance.sdk.component.ExN.UFX ufx) {
                Object objPFF = ufx.pFF();
                if (objPFF instanceof byte[]) {
                    UFX ufx2 = UFX.this;
                    View view = ufx2.BT;
                    if (view instanceof ImageView) {
                        com.bytedance.sdk.component.adexpress.We.TRI.pFF((ImageView) view, (byte[]) objPFF, ufx2.f26791qr, ufx2.Qj);
                    }
                }
            }
        });
    }

    private boolean sc() {
        String strTf = this.Tf.Tf();
        if (this.Tf.YIK()) {
            return true;
        }
        if (TextUtils.isEmpty(strTf)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(strTf);
            return Math.abs((((float) this.f26791qr) / (((float) this.Qj) * 1.0f)) - (((float) jSONObject.optInt("width")) / (((float) jSONObject.optInt("height")) * 1.0f))) > 0.01f;
        } catch (JSONException unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.OXF
    public boolean Ol() {
        int iDE;
        super.Ol();
        if (!TextUtils.isEmpty(this.Tf.NP())) {
            ((ImageView) this.BT).setScaleType(ImageView.ScaleType.CENTER_CROP);
            return true;
        }
        int iBT = 0;
        if ("arrowButton".equals(this.Ql.WH().pFF())) {
            ((ImageView) this.BT).setImageResource(com.bytedance.sdk.component.utils.Sfl.We(this.UFX, "tt_white_righterbackicon_titlebar"));
            if (((ImageView) this.BT).getDrawable() != null) {
                ((ImageView) this.BT).getDrawable().setAutoMirrored(true);
            }
            this.BT.setPadding(0, 0, 0, 0);
            ((ImageView) this.BT).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        this.BT.setBackgroundColor(this.Tf.McK());
        String strZY = this.Ql.WH().zY();
        if ("user".equals(strZY)) {
            ((ImageView) this.BT).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((ImageView) this.BT).setColorFilter(this.Tf.qr());
            ((ImageView) this.BT).setImageDrawable(com.bytedance.sdk.component.utils.Sfl.zY(getContext(), "tt_user"));
            ImageView imageView = (ImageView) this.BT;
            int i11 = this.f26791qr;
            imageView.setPadding(i11 / 10, this.Qj / 5, i11 / 10, 0);
        } else if (strZY != null && strZY.startsWith("@")) {
            try {
                ((ImageView) this.BT).setImageResource(Integer.parseInt(strZY.substring(1)));
            } catch (Exception unused) {
            }
        }
        com.bytedance.sdk.component.ExN.BT btExN = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().ExN();
        String strUFX = this.Tf.UFX();
        if (!TextUtils.isEmpty(strUFX) && !strUFX.startsWith("http:") && !strUFX.startsWith("https:")) {
            DynamicRootView dynamicRootView = this.SR;
            strUFX = com.bytedance.sdk.component.adexpress.dynamic.ExN.Ol.pFF(strUFX, (dynamicRootView == null || dynamicRootView.getRenderRequest() == null) ? null : this.SR.getRenderRequest().FI());
        }
        com.bytedance.sdk.component.adexpress.sc.sc.zY zYVarZY = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY();
        if (zYVarZY != null) {
            iBT = zYVarZY.BT();
            iDE = zYVarZY.dE();
        } else {
            iDE = 0;
        }
        com.bytedance.sdk.component.ExN.WH whExN = btExN.sc(strUFX).sc(this.f26812sc).sc(this.f26791qr).pFF(this.Qj).We(iBT).ExN(iDE);
        String strSR = this.SR.getRenderRequest().SR();
        if (!TextUtils.isEmpty(strSR)) {
            whExN.pFF(strSR);
        }
        if (sc()) {
            ((ImageView) this.BT).setScaleType(ImageView.ScaleType.FIT_CENTER);
            whExN.sc(Bitmap.Config.ARGB_4444).zY(2).sc(new sc(this.UFX)).sc(new pFF(this.BT, getResources()));
        } else {
            if (com.bytedance.sdk.component.adexpress.We.pFF()) {
                whExN.sc((ImageView) this.BT);
            }
            ((ImageView) this.BT).setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if ((this.BT instanceof ImageView) && "cover".equals(getImageObjectFit())) {
            ((ImageView) this.BT).setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (!com.bytedance.sdk.component.adexpress.We.pFF()) {
            sc(whExN);
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = ((ImageView) this.BT).getDrawable();
        if (Build.VERSION.SDK_INT < 28 || !b.a(drawable)) {
            return;
        }
        c.a(drawable).start();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = ((ImageView) this.BT).getDrawable();
        if (Build.VERSION.SDK_INT < 28 || !b.a(drawable)) {
            return;
        }
        c.a(drawable).stop();
    }
}
