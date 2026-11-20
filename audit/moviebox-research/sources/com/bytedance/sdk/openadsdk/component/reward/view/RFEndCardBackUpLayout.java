package com.bytedance.sdk.openadsdk.component.reward.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.Sfl;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.model.YIK;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.Xc;
import com.bytedance.sdk.openadsdk.core.widget.dE;
import com.bytedance.sdk.openadsdk.utils.SR;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.google.android.material.card.MaterialCardView;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class RFEndCardBackUpLayout extends com.bytedance.sdk.openadsdk.core.ExN.zY {
    private static final String TAG = "TTAD.RFEndCardBackUpL";
    private com.bytedance.sdk.openadsdk.component.reward.sc.sc adContext;
    private PAGLogoView adLogo;
    private Xc ivIcon;
    private boolean mInit;
    private dE rbScore;
    private int shownAdCount;
    private com.bytedance.sdk.openadsdk.core.ExN.Qj tvDesc;
    private com.bytedance.sdk.openadsdk.core.ExN.Qj tvDownload;
    private TextView tvTitle;

    /* JADX INFO: compiled from: source.java */
    public static final class sc extends Drawable {
        private final Drawable pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        Path f27956sc = new Path();
        private final int zY;

        public sc(Context context) {
            this.pFF = Sfl.zY(context, "tt_ad_bg_header_gradient");
            this.zY = kX.zY(context, 8.0f);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            canvas.clipPath(this.f27956sc);
            canvas.drawColor(-1);
            this.pFF.draw(canvas);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i11) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setBounds(int i11, int i12, int i13, int i14) {
            super.setBounds(i11, i12, i13, i14);
            float f11 = i13;
            this.pFF.setBounds(i11, i12, i13, (int) (((1.0f * f11) / this.pFF.getIntrinsicWidth()) * this.pFF.getIntrinsicHeight()));
            this.f27956sc.reset();
            Path path = this.f27956sc;
            RectF rectF = new RectF(0.0f, 0.0f, f11, i14);
            int i15 = this.zY;
            path.addRoundRect(rectF, i15, i15, Path.Direction.CCW);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
        }
    }

    public RFEndCardBackUpLayout(Context context) {
        super(context);
        setVisibility(8);
        setId(SR.f28748gx);
    }

    private void bindDescData(com.bytedance.sdk.openadsdk.core.ExN.Qj qj2, com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        if (qj2 == null) {
            return;
        }
        String strBSP = sfl.bSP();
        if (TextUtils.isEmpty(strBSP)) {
            return;
        }
        qj2.setText(strBSP);
    }

    private void bindIconData(com.bytedance.sdk.openadsdk.core.ExN.We we2, com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        if (we2 == null || sfl.qfG() == null || TextUtils.isEmpty(sfl.qfG().sc())) {
            return;
        }
        com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(sfl.qfG(), we2, sfl);
    }

    private void bindTitleData(TextView textView, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, String str) {
        if (textView != null) {
            if (sfl.NP() == null || TextUtils.isEmpty(sfl.NP().pFF())) {
                textView.setText(str);
            } else {
                textView.setText(sfl.NP().pFF());
            }
        }
    }

    private void initData(com.bytedance.sdk.openadsdk.core.model.Sfl sfl, com.bytedance.sdk.openadsdk.core.ExN.Qj qj2) {
        setDownloadButtonData(qj2, sfl, -1);
        bindIconData(this.ivIcon, sfl);
        Xc xc2 = this.ivIcon;
        if (xc2 != null) {
            xc2.setOnClickListener(this.adContext.McK.ExN());
        }
        dE dEVar = this.rbScore;
        if (dEVar != null) {
            kX.sc((TextView) null, dEVar, sfl);
            if (sfl.NP() != null) {
                this.rbScore.setVisibility(0);
            }
            this.rbScore.setOnClickListener(this.adContext.McK.ExN());
        }
        if (this.tvTitle != null) {
            if (sfl.NP() != null && !TextUtils.isEmpty(sfl.NP().pFF())) {
                this.tvTitle.setText(sfl.NP().pFF());
            } else if (TextUtils.isEmpty(sfl.MxZ())) {
                this.tvTitle.setVisibility(8);
            } else {
                this.tvTitle.setText(sfl.MxZ());
            }
            this.tvTitle.setOnClickListener(this.adContext.McK.ExN());
        }
        if (this.tvDesc != null) {
            String strYdT = sfl.YdT();
            if (TextUtils.isEmpty(strYdT)) {
                this.tvDesc.setVisibility(8);
            } else {
                this.tvDesc.setText(strYdT);
            }
            this.tvDesc.setOnClickListener(this.adContext.McK.ExN());
        }
        this.adLogo.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RFEndCardBackUpLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    TTWebsiteActivity.sc(RFEndCardBackUpLayout.this.adContext.CYO, RFEndCardBackUpLayout.this.adContext.pFF, RFEndCardBackUpLayout.this.adContext.ExN);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void initOneSlotMultipleAdsLayout() {
        Context context = getContext();
        setBackgroundColor(Color.parseColor("#C2FFFFFF"));
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN.setOrientation(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(kX.zY(context, 16.0f), 0, kX.zY(context, 16.0f), 0);
        layoutParams.gravity = 17;
        addView(exN, layoutParams);
        if (this.adContext.OKY == 2) {
            com.bytedance.sdk.openadsdk.core.ExN.ExN exN2 = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
            exN2.setOrientation(0);
            exN.addView(exN2, new FrameLayout.LayoutParams(-1, -2));
            initOneSlotMultipleAdsLayoutLandscape(exN2, this.shownAdCount);
        } else if (this.shownAdCount == 2) {
            initOneSlotMultipleAdsLayoutForTwoAdVertical(exN);
        } else {
            initOneSlotMultipleAdsLayoutForThreeAdVertical(exN);
        }
        View pAGLogoView = new PAGLogoView(this.adContext.CYO);
        pAGLogoView.setId(520093757);
        exN.addView(pAGLogoView);
        pAGLogoView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RFEndCardBackUpLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TTWebsiteActivity.sc(RFEndCardBackUpLayout.this.adContext.CYO, RFEndCardBackUpLayout.this.adContext.pFF, RFEndCardBackUpLayout.this.adContext.ExN);
            }
        });
    }

    private void initOneSlotMultipleAdsLayoutForThreeAdVertical(com.bytedance.sdk.openadsdk.core.ExN.ExN exN) {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.adContext.pFF;
        if (sfl instanceof YIK) {
            List<com.bytedance.sdk.openadsdk.core.model.Sfl> listWe = ((YIK) sfl).vBa().We();
            for (int i11 = 0; i11 < listWe.size() && i11 < 3; i11++) {
                initSingleCardInThreeCardStyle(exN, listWe.get(i11), i11);
            }
        }
    }

    private void initOneSlotMultipleAdsLayoutForTwoAdVertical(com.bytedance.sdk.openadsdk.core.ExN.ExN exN) {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.adContext.pFF;
        if (sfl instanceof YIK) {
            List<com.bytedance.sdk.openadsdk.core.model.Sfl> listWe = ((YIK) sfl).vBa().We();
            for (int i11 = 0; i11 < listWe.size() && i11 < 2; i11++) {
                initSingleCardInTwoCardStyle(exN, listWe.get(i11), i11);
            }
        }
    }

    private void initOneSlotMultipleAdsLayoutLandscape(com.bytedance.sdk.openadsdk.core.ExN.ExN exN, int i11) {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.adContext.pFF;
        if (sfl instanceof YIK) {
            List<com.bytedance.sdk.openadsdk.core.model.Sfl> listWe = ((YIK) sfl).vBa().We();
            for (int i12 = 0; i12 < listWe.size() && i12 < i11 && i12 < 3; i12++) {
                initSingleCardInTwoCardStyleLandscape(exN, listWe.get(i12), i12, i11);
            }
        }
    }

    private void initSingleCardInThreeCardStyle(com.bytedance.sdk.openadsdk.core.ExN.ExN exN, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, int i11) {
        Context context = getContext();
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN2 = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN2.setOrientation(1);
        exN2.setGravity(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, i11 > 0 ? kX.zY(context, 12.0f) : 0, 0, 0);
        exN2.setBackground(new sc(context));
        exN.addView(exN2, layoutParams);
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN3 = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN3.setOrientation(0);
        exN3.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = kX.zY(context, 20.0f);
        layoutParams2.leftMargin = kX.zY(context, 17.0f);
        layoutParams2.rightMargin = kX.zY(context, 30.0f);
        exN2.addView(exN3, layoutParams2);
        Xc xc2 = new Xc(context);
        exN3.addView(xc2, new FrameLayout.LayoutParams(kX.zY(context, 70.0f), kX.zY(context, 63.0f)));
        bindIconData(xc2, sfl);
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN4 = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN4.setOrientation(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = kX.zY(context, 7.0f);
        exN3.addView(exN4, layoutParams3);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        qj2.setSingleLine(true);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        qj2.setEllipsize(truncateAt);
        qj2.setTextSize(18.0f);
        qj2.setTextColor(Color.parseColor("#161823"));
        qj2.setGravity(GravityCompat.START);
        qj2.setTypeface(null, 1);
        exN4.addView(qj2, new FrameLayout.LayoutParams(-1, -2));
        bindTitleData(qj2, sfl, sfl.MxZ());
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj3 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        qj3.setSingleLine(true);
        qj3.setEllipsize(truncateAt);
        qj3.setTextSize(16.0f);
        qj3.setTextColor(Color.parseColor("#80161823"));
        exN4.addView(qj3, new FrameLayout.LayoutParams(-1, -2));
        bindDescData(qj3, sfl);
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN5 = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN5.setOrientation(0);
        exN5.setGravity(16);
        exN4.addView(exN5, new FrameLayout.LayoutParams(-2, -2));
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj4 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        qj4.setTextSize(16.0f);
        qj4.setTextColor(Color.parseColor("#80161823"));
        exN5.addView(qj4, new ViewGroup.LayoutParams(-2, -2));
        dE dEVar = new dE(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.leftMargin = kX.zY(context, 8.0f);
        exN5.addView(dEVar, layoutParams4);
        kX.sc(qj4, dEVar, sfl, 18);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj5 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        qj5.setGravity(17);
        qj5.setId(520093707);
        qj5.setText(Sfl.sc(context, "tt_video_download_apk"));
        qj5.setTextColor(-1);
        qj5.setTextSize(2, 16.0f);
        qj5.setBackground(com.bytedance.sdk.openadsdk.utils.Ol.sc(context, "tt_reward_full_video_backup_btn_bg"));
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, kX.zY(context, 36.0f));
        layoutParams5.setMargins(kX.zY(context, 20.0f), kX.zY(context, 22.0f), kX.zY(context, 20.0f), kX.zY(context, 20.0f));
        exN2.addView(qj5, layoutParams5);
        setDownloadButtonData(qj5, sfl, i11);
    }

    private void initSingleCardInTwoCardStyle(com.bytedance.sdk.openadsdk.core.ExN.ExN exN, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, int i11) {
        Context context = getContext();
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN2 = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN2.setOrientation(1);
        exN2.setGravity(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, i11 > 0 ? kX.zY(context, 12.0f) : 0, 0, 0);
        exN2.setBackground(new sc(context));
        exN.addView(exN2, layoutParams);
        Xc xc2 = new Xc(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(kX.zY(context, 70.0f), kX.zY(context, 63.0f));
        layoutParams2.setMargins(0, kX.zY(context, 24.0f), 0, kX.zY(context, 12.0f));
        exN2.addView(xc2, layoutParams2);
        bindIconData(xc2, sfl);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        qj2.setSingleLine(true);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        qj2.setEllipsize(truncateAt);
        qj2.setTextSize(18.0f);
        qj2.setTextColor(Color.parseColor("#161823"));
        qj2.setGravity(17);
        qj2.setTypeface(null, 1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(kX.zY(context, 56.0f), 0, kX.zY(context, 56.0f), 0);
        exN2.addView(qj2, layoutParams3);
        bindTitleData(qj2, sfl, sfl.MxZ());
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj3 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        qj3.setSingleLine(true);
        qj3.setEllipsize(truncateAt);
        qj3.setTextSize(16.0f);
        qj3.setTextColor(Color.parseColor("#80161823"));
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams4.setMargins(kX.zY(context, 56.0f), kX.zY(context, 4.0f), kX.zY(context, 56.0f), 0);
        exN2.addView(qj3, layoutParams4);
        bindDescData(qj3, sfl);
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN3 = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN3.setOrientation(0);
        exN3.setGravity(16);
        exN2.addView(exN3, new FrameLayout.LayoutParams(-2, -2));
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj4 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        qj4.setTextSize(16.0f);
        qj4.setTextColor(Color.parseColor("#80161823"));
        exN3.addView(qj4, new ViewGroup.LayoutParams(-2, -2));
        dE dEVar = new dE(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = kX.zY(context, 8.0f);
        exN3.addView(dEVar, layoutParams5);
        kX.sc(qj4, dEVar, sfl, 18);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj5 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        qj5.setGravity(17);
        qj5.setId(520093707);
        qj5.setText(Sfl.sc(context, "tt_video_download_apk"));
        qj5.setTextColor(-1);
        qj5.setTextSize(2, 16.0f);
        qj5.setBackground(com.bytedance.sdk.openadsdk.utils.Ol.sc(context, "tt_reward_full_video_backup_btn_bg"));
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, kX.zY(context, 36.0f));
        layoutParams6.setMargins(kX.zY(context, 20.0f), kX.zY(context, 36.0f), kX.zY(context, 20.0f), kX.zY(context, 20.0f));
        exN2.addView(qj5, layoutParams6);
        setDownloadButtonData(qj5, sfl, i11);
    }

    private void initSingleCardInTwoCardStyleLandscape(com.bytedance.sdk.openadsdk.core.ExN.ExN exN, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, int i11, int i12) {
        Context context = getContext();
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN2 = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN2.setOrientation(1);
        exN2.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        if (i11 > 0) {
            layoutParams.setMargins(kX.zY(context, 12.0f), 0, 0, 0);
        }
        exN2.setBackground(new sc(context));
        exN.addView(exN2, layoutParams);
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN3 = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN3.setOrientation(0);
        exN3.setGravity(48);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = kX.zY(context, 20.0f);
        layoutParams2.leftMargin = kX.zY(context, 17.0f);
        layoutParams2.rightMargin = kX.zY(context, 30.0f);
        exN2.addView(exN3, layoutParams2);
        Xc xc2 = new Xc(context);
        exN3.addView(xc2, new FrameLayout.LayoutParams(kX.zY(context, 44.0f), kX.zY(context, 44.0f)));
        bindIconData(xc2, sfl);
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN4 = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN4.setOrientation(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = kX.zY(context, 7.0f);
        exN3.addView(exN4, layoutParams3);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        qj2.setSingleLine(true);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        qj2.setEllipsize(truncateAt);
        qj2.setTextSize(18.0f);
        qj2.setTextColor(Color.parseColor("#161823"));
        qj2.setGravity(GravityCompat.START);
        qj2.setTypeface(null, 1);
        exN4.addView(qj2, new FrameLayout.LayoutParams(-1, -2));
        bindTitleData(qj2, sfl, sfl.MxZ());
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN5 = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN5.setOrientation(0);
        exN5.setGravity(16);
        exN4.addView(exN5, new FrameLayout.LayoutParams(-2, -2));
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj3 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        qj3.setTextSize(16.0f);
        qj3.setTextColor(Color.parseColor("#80161823"));
        exN5.addView(qj3, new ViewGroup.LayoutParams(-2, -2));
        dE dEVar = new dE(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.leftMargin = kX.zY(context, 8.0f);
        exN5.addView(dEVar, layoutParams4);
        kX.sc(qj3, dEVar, sfl, 18);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj4 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        if (i12 == 2) {
            qj4.setSingleLine(true);
        } else {
            qj4.setLines(2);
        }
        qj4.setEllipsize(truncateAt);
        qj4.setTextSize(16.0f);
        qj4.setTextColor(Color.parseColor("#80161823"));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        int i13 = layoutParams2.leftMargin;
        layoutParams5.rightMargin = i13;
        layoutParams5.leftMargin = i13;
        layoutParams5.topMargin = kX.zY(context, 12.0f);
        exN2.addView(qj4, layoutParams5);
        bindDescData(qj4, sfl);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj5 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        qj5.setGravity(17);
        qj5.setId(520093707);
        qj5.setText(Sfl.sc(context, "tt_video_download_apk"));
        qj5.setTextColor(-1);
        qj5.setTextSize(2, 16.0f);
        qj5.setBackground(com.bytedance.sdk.openadsdk.utils.Ol.sc(context, "tt_reward_full_video_backup_btn_bg"));
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, kX.zY(context, 36.0f));
        layoutParams6.setMargins(kX.zY(context, 20.0f), kX.zY(context, 22.0f), kX.zY(context, 20.0f), kX.zY(context, 20.0f));
        exN2.addView(qj5, layoutParams6);
        setDownloadButtonData(qj5, sfl, i11);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void initViews() {
        if (this.mInit) {
            return;
        }
        this.mInit = true;
        if (this.adContext.pFF.hP() && this.shownAdCount > 1) {
            initOneSlotMultipleAdsLayout();
            return;
        }
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.adContext.pFF;
        if (sfl.ymG()) {
            initViewsForVast();
        } else {
            initViewsDefault();
            initData(sfl, this.tvDownload);
        }
    }

    private void initViewsDefault() {
        Context context = getContext();
        boolean z11 = this.adContext.pFF.gx() == 1;
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN.setGravity(1);
        exN.setOrientation(1);
        FrameLayout.LayoutParams layoutParams = z11 ? new FrameLayout.LayoutParams(-1, -2) : new FrameLayout.LayoutParams(kX.zY(context, 327.0f), -2);
        layoutParams.gravity = 17;
        int iZY = kX.zY(context, 24.0f);
        layoutParams.rightMargin = iZY;
        layoutParams.leftMargin = iZY;
        addView(exN, layoutParams);
        Xc xc2 = new Xc(context);
        this.ivIcon = xc2;
        xc2.setBackgroundColor(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(kX.zY(context, 80.0f), kX.zY(context, 80.0f));
        layoutParams2.bottomMargin = kX.zY(context, 12.0f);
        exN.addView(this.ivIcon, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        this.tvTitle = qj2;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        qj2.setEllipsize(truncateAt);
        this.tvTitle.setGravity(17);
        this.tvTitle.setMaxLines(2);
        this.tvTitle.setMaxWidth(kX.zY(context, 180.0f));
        this.tvTitle.setTextColor(-1);
        this.tvTitle.setTextSize(2, 24.0f);
        exN.addView(this.tvTitle, new LinearLayout.LayoutParams(-1, -2));
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj3 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        this.tvDesc = qj3;
        qj3.setEllipsize(truncateAt);
        this.tvDesc.setGravity(17);
        this.tvDesc.setMaxLines(2);
        this.tvDesc.setTextColor(Color.parseColor("#BFFFFFFF"));
        this.tvDesc.setTextSize(2, 16.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = kX.zY(context, 8.0f);
        exN.addView(this.tvDesc, layoutParams3);
        this.rbScore = new dE(context, true);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, kX.zY(context, 16.0f));
        layoutParams4.topMargin = kX.zY(context, 12.0f);
        this.rbScore.setVisibility(8);
        exN.addView(this.rbScore, layoutParams4);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj4 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        this.tvDownload = qj4;
        qj4.setId(520093707);
        this.tvDownload.setGravity(17);
        this.tvDownload.setText(Sfl.sc(context, "tt_video_download_apk"));
        this.tvDownload.setTextColor(-1);
        this.tvDownload.setTextSize(2, 16.0f);
        this.tvDownload.setBackground(com.bytedance.sdk.openadsdk.utils.Ol.sc(context, "tt_reward_full_video_backup_btn_bg"));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, kX.zY(context, 44.0f));
        layoutParams5.topMargin = kX.zY(context, 54.0f);
        exN.addView(this.tvDownload, layoutParams5);
        this.adLogo = new PAGLogoView(context);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, kX.zY(context, 14.0f));
        layoutParams6.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START;
        layoutParams6.leftMargin = kX.zY(context, 18.0f);
        if (z11) {
            layoutParams6.bottomMargin = kX.zY(context, 61.0f);
        } else {
            layoutParams6.bottomMargin = kX.zY(context, 24.0f);
        }
        addView(this.adLogo, layoutParams6);
    }

    private void initViewsForVast() {
        Context context = getContext();
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        we2.setId(SR.Qj);
        we2.setVisibility(8);
        addView(we2, new FrameLayout.LayoutParams(-1, -1));
        View we3 = new com.bytedance.sdk.component.Ol.We(context, true);
        we3.setVisibility(8);
        we3.setId(SR.Ol);
        addView(we3, new FrameLayout.LayoutParams(-1, -1));
    }

    private void setDownloadButtonData(com.bytedance.sdk.openadsdk.core.ExN.Qj qj2, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, int i11) {
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.adContext;
        com.bytedance.sdk.openadsdk.core.pFF.ExN exNSc = scVar.McK.sc(scVar, sfl);
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.adContext;
        exNSc.sc(com.bytedance.sdk.openadsdk.wjp.sc.sc.qr.sc(scVar2.CYO, sfl, scVar2.ExN));
        if (i11 != -1) {
            HashMap map = new HashMap();
            map.put("ad_show_order", Integer.valueOf(i11 + 1));
            exNSc.sc(map);
        }
        qj2.setOnClickListener(exNSc);
        qj2.setOnTouchListener(exNSc);
        CharSequence charSequenceNQ = sfl.NQ();
        if (TextUtils.isEmpty(charSequenceNQ)) {
            return;
        }
        qj2.setText(charSequenceNQ);
    }

    public void init(com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar) {
        this.adContext = scVar;
        if (scVar.pFF.ymG()) {
            initViews();
        }
    }

    public void setShownAdCount(int i11) {
        this.shownAdCount = i11;
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
        super.setVisibility(i11);
        if (i11 == 0) {
            initViews();
        }
    }
}
