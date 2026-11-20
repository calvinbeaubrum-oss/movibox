package com.bytedance.sdk.openadsdk.component.Ol;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.Sfl;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.Xc;
import com.bytedance.sdk.openadsdk.core.widget.dE;
import com.bytedance.sdk.openadsdk.utils.Ol;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We extends zY {
    private final com.bytedance.sdk.openadsdk.core.ExN.Qj BT;
    private final com.bytedance.sdk.openadsdk.core.ExN.zY Ql;
    private final dE SR;
    private final com.bytedance.sdk.openadsdk.core.ExN.ExN Xc;
    private final com.bytedance.sdk.openadsdk.core.ExN.We dE;

    /* JADX INFO: compiled from: source.java */
    public static final class sc extends Drawable {
        private static final int ExN = Color.parseColor("#b0000000");
        private static final int TRI = Color.parseColor("#40000000");
        private final boolean We;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final RectF f27741sc = new RectF();
        private final Paint pFF = new Paint();
        private final Path zY = new Path();

        public sc(Context context) {
            this.We = com.bytedance.sdk.component.adexpress.We.pFF.sc(context);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            canvas.drawPath(this.zY, this.pFF);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void onBoundsChange(@NonNull Rect rect) {
            float[] fArr;
            super.onBoundsChange(rect);
            this.f27741sc.set(rect);
            this.zY.reset();
            int iHeight = rect.height() / 2;
            Path path = this.zY;
            RectF rectF = this.f27741sc;
            if (this.We) {
                float f11 = iHeight;
                fArr = new float[]{f11, f11, 0.0f, 0.0f, 0.0f, 0.0f, f11, f11};
            } else {
                float f12 = iHeight;
                fArr = new float[]{0.0f, 0.0f, f12, f12, f12, f12, 0.0f, 0.0f};
            }
            path.addRoundRect(rectF, fArr, Path.Direction.CW);
            float f13 = rect.right;
            int[] iArr = new int[2];
            boolean z11 = this.We;
            iArr[0] = z11 ? TRI : ExN;
            iArr[1] = z11 ? ExN : TRI;
            this.pFF.setShader(new LinearGradient(0.0f, 0.0f, f13, 0.0f, iArr, (float[]) null, Shader.TileMode.CLAMP));
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i11) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
        }
    }

    public We(Context context) {
        super(context);
        setId(520093753);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setBackgroundColor(0);
        int iZY = kX.zY(context, 8.0f);
        int iZY2 = kX.zY(context, 9.0f);
        int iZY3 = kX.zY(context, 10.0f);
        int iZY4 = kX.zY(context, 40.0f);
        com.bytedance.sdk.openadsdk.core.widget.zY zYVar = new com.bytedance.sdk.openadsdk.core.widget.zY(context);
        this.Tf = zYVar;
        zYVar.setPadding(iZY2, 0, iZY2, 0);
        this.Tf.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(kX.zY(context, 32.0f), kX.zY(context, 14.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, iZY3, iZY3);
        this.Tf.setLayoutParams(layoutParams);
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar2 = new com.bytedance.sdk.openadsdk.core.ExN.zY(context);
        this.Ql = zYVar2;
        zYVar2.setBackgroundColor(-1);
        zYVar2.setId(520093758);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, kX.zY(context, 107.0f));
        layoutParams2.addRule(12);
        zYVar2.setLayoutParams(layoutParams2);
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN.setOrientation(0);
        exN.setGravity(16);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        exN.setLayoutParams(layoutParams3);
        zYVar2.addView(exN);
        Xc xc2 = new Xc(context);
        this.TRI = xc2;
        xc2.setId(520093759);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(iZY4, iZY4);
        layoutParams4.rightMargin = iZY;
        layoutParams4.setMarginEnd(iZY);
        this.TRI.setLayoutParams(layoutParams4);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        this.f27747qr = qj2;
        qj2.setId(520093761);
        this.f27747qr.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj3 = this.f27747qr;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        qj3.setEllipsize(truncateAt);
        this.f27747qr.setMaxLines(2);
        this.f27747qr.setTextColor(Color.parseColor("#161823"));
        this.f27747qr.setTextSize(30.0f);
        exN.addView(this.TRI);
        exN.addView(this.f27747qr);
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar3 = new com.bytedance.sdk.openadsdk.core.ExN.zY(context);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams5.addRule(2, zYVar2.getId());
        layoutParams5.addRule(10);
        zYVar3.setLayoutParams(layoutParams5);
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        this.f27748sc = we2;
        we2.setId(520093754);
        this.f27748sc.setScaleType(ImageView.ScaleType.CENTER_CROP);
        zYVar3.addView(this.f27748sc, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar4 = new com.bytedance.sdk.openadsdk.core.ExN.zY(context);
        this.pFF = zYVar4;
        zYVar4.setId(520093755);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams6.gravity = 17;
        zYVar3.addView(this.pFF, layoutParams6);
        com.bytedance.sdk.openadsdk.core.ExN.We we3 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        this.zY = we3;
        we3.setId(520093756);
        zYVar3.addView(this.zY, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj4 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        this.ExN = qj4;
        qj4.setId(520093717);
        this.ExN.setBackground(Ol.sc(context, Color.parseColor("#b3000000"), 24));
        this.ExN.setEllipsize(truncateAt);
        this.ExN.setGravity(17);
        this.ExN.setSingleLine(true);
        this.ExN.setText(Sfl.sc(context, "tt_video_download_apk"));
        this.ExN.setTextColor(-1);
        this.ExN.setTextSize(1, 16.0f);
        this.ExN.setTag("open_ad_click_button_tag");
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(kX.zY(context, 236.0f), kX.zY(context, 48.0f));
        layoutParams7.gravity = 81;
        layoutParams7.bottomMargin = kX.zY(context, 32.0f);
        zYVar3.addView(this.ExN, layoutParams7);
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN2 = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        this.Xc = exN2;
        exN2.setOrientation(0);
        exN2.setGravity(16);
        exN2.setBackground(new sc(context));
        exN2.setPadding(kX.zY(context, 16.0f), kX.zY(context, 8.0f), kX.zY(context, 16.0f), kX.zY(context, 8.0f));
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(10);
        layoutParams8.topMargin = kX.zY(context, 90.0f);
        exN2.setLayoutParams(layoutParams8);
        Xc xc3 = new Xc(context);
        this.dE = xc3;
        exN2.addView(xc3, new LinearLayout.LayoutParams(kX.zY(context, 36.0f), kX.zY(context, 36.0f)));
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN3 = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN3.setOrientation(1);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams9.leftMargin = kX.zY(context, 8.0f);
        exN2.addView(exN3, layoutParams9);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj5 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        this.BT = qj5;
        qj5.setTextColor(-1);
        exN3.addView(qj5, new LinearLayout.LayoutParams(-2, -2));
        dE dEVar = new dE(context, true);
        this.SR = dEVar;
        exN3.addView(dEVar, new LinearLayout.LayoutParams(-2, -2));
        PAGLogoView pAGLogoView = new PAGLogoView(context);
        this.We = pAGLogoView;
        pAGLogoView.setId(520093757);
        FrameLayout.LayoutParams layoutParams10 = new FrameLayout.LayoutParams(-2, kX.zY(context, 14.0f));
        layoutParams10.gravity = 83;
        zYVar3.addView(this.We, layoutParams10);
        addView(zYVar3);
        addView(this.Tf);
        addView(zYVar2);
        addView(this.Qj);
        addView(exN2);
    }

    @Override // com.bytedance.sdk.openadsdk.component.Ol.zY
    public com.bytedance.sdk.openadsdk.core.ExN.We getAdIconView() {
        return this.dE;
    }

    @Override // com.bytedance.sdk.openadsdk.component.Ol.zY
    public com.bytedance.sdk.openadsdk.core.ExN.Qj getAdTitleTextView() {
        return this.BT;
    }

    @Override // com.bytedance.sdk.openadsdk.component.Ol.zY
    public com.bytedance.sdk.openadsdk.core.ExN.ExN getOverlayLayout() {
        return this.Xc;
    }

    @Override // com.bytedance.sdk.openadsdk.component.Ol.zY
    public dE getScoreBar() {
        return this.SR;
    }

    @Override // com.bytedance.sdk.openadsdk.component.Ol.zY
    public View getUserInfo() {
        return this.Ql;
    }
}
