package com.bytedance.sdk.openadsdk.core.zY;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.Qj.Qj;
import com.bytedance.sdk.openadsdk.core.Qj.Sfl;
import com.bytedance.sdk.openadsdk.core.Qj.Xc;
import com.bytedance.sdk.openadsdk.core.Qj.wjp;
import com.bytedance.sdk.openadsdk.core.model.BT;
import com.bytedance.sdk.openadsdk.core.model.SR;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.Ql;
import com.bytedance.sdk.openadsdk.core.widget.Tf;
import com.bytedance.sdk.openadsdk.core.widget.dE;
import com.bytedance.sdk.openadsdk.utils.Ol;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.google.android.material.card.MaterialCardView;
import com.google.logging.type.LogSeverity;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc extends com.bytedance.sdk.openadsdk.core.Qj.sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static Xc[] f28590sc = {new Xc(1, 6.4f, 320, 50), new Xc(4, 1.2f, LogSeverity.NOTICE_VALUE, 250)};
    private String BT;
    private C0309sc Ql;
    private Sfl SR;
    private PAGBannerAdWrapperListener dE;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.zY.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0309sc {
        FrameLayout ExN;
        private Tf Qj;
        View TRI;
        dE We;
        public TextView pFF;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        TextView f28596qr;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public Ql f28597sc;
        ImageView zY;

        public C0309sc(View view, Ql ql2) {
            this.TRI = view;
            this.f28597sc = ql2;
        }

        public C0309sc(ImageView imageView, View view, TextView textView, TextView textView2, Ql ql2, dE dEVar, FrameLayout frameLayout) {
            this.zY = imageView;
            this.TRI = view;
            this.f28596qr = textView;
            this.pFF = textView2;
            this.f28597sc = ql2;
            this.We = dEVar;
            this.ExN = frameLayout;
        }

        public C0309sc(ImageView imageView, View view, TextView textView, TextView textView2, Tf tf2, dE dEVar, FrameLayout frameLayout) {
            this.zY = imageView;
            this.TRI = view;
            this.f28596qr = textView;
            this.pFF = textView2;
            this.Qj = tf2;
            this.We = dEVar;
            this.ExN = frameLayout;
        }

        public C0309sc(ImageView imageView, TextView textView, dE dEVar, View view, TextView textView2) {
            this.zY = imageView;
            this.pFF = textView;
            this.We = dEVar;
            this.TRI = view;
            this.f28596qr = textView2;
        }
    }

    public sc(@NonNull Context context) {
        super(context);
        this.pFF = context;
    }

    private void ExN() {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.zY;
        if (sfl != null) {
            int iDix = sfl.dix();
            float fZY = (this.Qj * 1.0f) / kX.zY(this.pFF, 250.0f);
            if (this.zY.GI() == null) {
                C0309sc c0309scQj = Qj();
                this.Ql = c0309scQj;
                Ql ql2 = c0309scQj.f28597sc;
                ImageView imageView = c0309scQj.zY;
                TextView textView = c0309scQj.pFF;
                TextView textView2 = c0309scQj.f28596qr;
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = (int) (kX.zY(this.pFF, 45.0f) * fZY);
                    layoutParams.height = (int) (kX.zY(this.pFF, 45.0f) * fZY);
                }
                textView.setTextSize(2, kX.pFF(this.pFF, textView.getTextSize()) * fZY);
                textView2.setTextSize(2, kX.pFF(this.pFF, textView2.getTextSize()) * fZY);
                View view = this.Ql.TRI;
                if (view != null) {
                    view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.zY.sc.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            TTWebsiteActivity.sc(((com.bytedance.sdk.openadsdk.core.Qj.sc) sc.this).pFF, ((com.bytedance.sdk.openadsdk.core.Qj.sc) sc.this).zY, ((com.bytedance.sdk.openadsdk.core.Qj.sc) sc.this).TRI);
                        }
                    });
                }
                if (iDix == 33) {
                    ql2.setRatio(1.0f);
                } else {
                    ql2.setRatio(1.91f);
                }
                List<BT> listHt = this.zY.ht();
                if (listHt != null && !listHt.isEmpty()) {
                    com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(listHt.get(0), ql2, this.zY);
                    com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(listHt.get(0).sc(), this.Ql.ExN);
                }
                if (this.zY.qfG() != null && !TextUtils.isEmpty(this.zY.qfG().sc())) {
                    com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(this.zY.qfG().sc(), this.zY.qfG().pFF(), this.zY.qfG().zY(), imageView, this.zY);
                }
                textView.setText(this.zY.YdT());
                if (TextUtils.isEmpty(this.zY.NQ())) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(this.zY.NQ());
                }
                kX.sc((TextView) null, this.Ql.We, this.zY);
                sc((View) ql2, true);
                ql2.setTag(520093762, Boolean.TRUE);
                sc((View) this, true);
                sc((View) textView2, true);
                return;
            }
            C0309sc c0309scOl = Ol();
            this.Ql = c0309scOl;
            TextView textView3 = c0309scOl.pFF;
            TextView textView4 = c0309scOl.f28596qr;
            Tf tf2 = c0309scOl.Qj;
            textView3.setTextSize(2, kX.pFF(this.pFF, textView3.getTextSize()) * fZY);
            textView4.setTextSize(2, kX.pFF(this.pFF, textView4.getTextSize()) * fZY);
            com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(this.zY.GI().r(), this.Ql.ExN);
            View view2 = this.Ql.TRI;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.zY.sc.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        TTWebsiteActivity.sc(((com.bytedance.sdk.openadsdk.core.Qj.sc) sc.this).pFF, ((com.bytedance.sdk.openadsdk.core.Qj.sc) sc.this).zY, ((com.bytedance.sdk.openadsdk.core.Qj.sc) sc.this).TRI);
                    }
                });
            }
            if (iDix == 15) {
                tf2.setRatio(0.5625f);
            } else if (iDix == 5) {
                tf2.setRatio(1.7777778f);
            } else {
                tf2.setRatio(1.0f);
            }
            tf2.removeAllViews();
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI videoView = getVideoView();
            if (videoView != null) {
                Sfl sfl2 = this.SR;
                if (sfl2 instanceof wjp) {
                    videoView.setVideoAdInteractionListener((wjp) sfl2);
                }
                tf2.addView(videoView, layoutParams2);
                videoView.setAdCreativeClickListener(new com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI.sc() { // from class: com.bytedance.sdk.openadsdk.core.zY.sc.5
                    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI.sc
                    public void sc(View view3, int i11) {
                        if (sc.this.dE != null) {
                            sc.this.dE.onAdClicked();
                        }
                    }
                });
                Qj clickCreativeListener = this.SR.getClickCreativeListener();
                if (clickCreativeListener != null) {
                    clickCreativeListener.sc(videoView.getNativeVideoController());
                }
            }
            if (this.zY.qfG() != null && !TextUtils.isEmpty(this.zY.qfG().sc())) {
                com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(this.zY.qfG().sc(), this.zY.qfG().pFF(), this.zY.qfG().zY(), this.Ql.zY, this.zY);
            }
            textView3.setText(this.zY.YdT());
            kX.sc((TextView) null, this.Ql.We, this.zY);
            if (TextUtils.isEmpty(this.zY.NQ())) {
                textView4.setVisibility(8);
            } else {
                textView4.setText(this.zY.NQ());
            }
            sc((View) videoView, true);
            if (videoView != null) {
                videoView.setTag(520093762, Boolean.TRUE);
            }
            sc((View) this, true);
            sc((View) textView4, true);
            sc(tf2);
        }
    }

    private C0309sc Ol() {
        int iZY = kX.zY(this.pFF, 8.0f);
        int iZY2 = kX.zY(this.pFF, 21.0f);
        RelativeLayout relativeLayout = new RelativeLayout(this.pFF);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        relativeLayout.setPadding(iZY, iZY, iZY, iZY2);
        relativeLayout.setLayoutParams(layoutParams);
        addView(relativeLayout);
        LinearLayout linearLayout = new LinearLayout(this.pFF);
        linearLayout.setId(520093737);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(layoutParams2);
        relativeLayout.addView(linearLayout);
        com.bytedance.sdk.openadsdk.core.widget.Xc xc2 = new com.bytedance.sdk.openadsdk.core.widget.Xc(this.pFF);
        xc2.setId(520093738);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(kX.zY(this.pFF, 52.0f), kX.zY(this.pFF, 52.0f));
        xc2.setScaleType(ImageView.ScaleType.FIT_XY);
        xc2.setLayoutParams(layoutParams3);
        linearLayout.addView(xc2);
        LinearLayout linearLayout2 = new LinearLayout(this.pFF);
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2);
        layoutParams4.weight = 1.0f;
        layoutParams4.leftMargin = iZY;
        layoutParams4.rightMargin = iZY;
        layoutParams4.setMarginStart(iZY);
        layoutParams4.setMarginEnd(iZY);
        linearLayout.addView(linearLayout2, layoutParams4);
        TextView textView = new TextView(this.pFF);
        textView.setId(520093730);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        textView.setMaxLines(1);
        textView.setTextColor(Color.parseColor("#FF3E3E3E"));
        textView.setTextSize(12.0f);
        textView.setLayoutParams(layoutParams5);
        linearLayout2.addView(textView);
        dE dEVar = new dE(this.pFF);
        dEVar.setId(520093735);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.topMargin = kX.zY(this.pFF, 4.0f);
        linearLayout2.addView(dEVar, layoutParams6);
        TextView textView2 = new TextView(this.pFF);
        textView2.setId(520093703);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(kX.zY(this.pFF, 76.0f), kX.zY(this.pFF, 36.0f));
        textView2.setBackground(Ol.sc(this.pFF, 18));
        textView2.setEllipsize(truncateAt);
        textView2.setMaxLines(1);
        textView2.setGravity(17);
        textView2.setText(com.bytedance.sdk.component.utils.Sfl.sc(this.pFF, "tt_video_download_apk"));
        textView2.setTextColor(-1);
        textView2.setTextSize(14.0f);
        textView2.setLayoutParams(layoutParams7);
        linearLayout.addView(textView2);
        FrameLayout frameLayout = new FrameLayout(this.pFF);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams8.addRule(2, linearLayout.getId());
        layoutParams8.bottomMargin = iZY2;
        frameLayout.setLayoutParams(layoutParams8);
        relativeLayout.addView(frameLayout);
        Tf tf2 = new Tf(this.pFF);
        tf2.setId(520093736);
        FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams9.gravity = 17;
        tf2.setLayoutParams(layoutParams9);
        frameLayout.addView(tf2);
        View pAGLogoView = new PAGLogoView(this.pFF);
        pAGLogoView.setId(520093739);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.addRule(10);
        layoutParams10.addRule(9);
        layoutParams10.setMargins(iZY, iZY, 0, 0);
        pAGLogoView.setLayoutParams(layoutParams10);
        relativeLayout.addView(pAGLogoView);
        return new C0309sc(xc2, pAGLogoView, textView2, textView, tf2, dEVar, frameLayout);
    }

    private C0309sc Qj() {
        int iZY = kX.zY(this.pFF, 8.0f);
        int iZY2 = kX.zY(this.pFF, 21.0f);
        RelativeLayout relativeLayout = new RelativeLayout(this.pFF);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        relativeLayout.setPadding(iZY, iZY, iZY, iZY2);
        relativeLayout.setLayoutParams(layoutParams);
        addView(relativeLayout);
        LinearLayout linearLayout = new LinearLayout(this.pFF);
        linearLayout.setId(520093737);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(layoutParams2);
        relativeLayout.addView(linearLayout);
        com.bytedance.sdk.openadsdk.core.widget.Xc xc2 = new com.bytedance.sdk.openadsdk.core.widget.Xc(this.pFF);
        xc2.setId(520093738);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(kX.zY(this.pFF, 52.0f), kX.zY(this.pFF, 52.0f));
        xc2.setScaleType(ImageView.ScaleType.FIT_XY);
        xc2.setLayoutParams(layoutParams3);
        linearLayout.addView(xc2);
        LinearLayout linearLayout2 = new LinearLayout(this.pFF);
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2);
        layoutParams4.weight = 1.0f;
        layoutParams4.leftMargin = iZY;
        layoutParams4.rightMargin = iZY;
        layoutParams4.setMarginStart(iZY);
        layoutParams4.setMarginEnd(iZY);
        linearLayout.addView(linearLayout2, layoutParams4);
        TextView textView = new TextView(this.pFF);
        textView.setId(520093730);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        textView.setMaxLines(1);
        textView.setTextColor(Color.parseColor("#FF3E3E3E"));
        textView.setTextSize(12.0f);
        textView.setLayoutParams(layoutParams5);
        linearLayout2.addView(textView);
        dE dEVar = new dE(this.pFF);
        dEVar.setId(520093735);
        linearLayout2.addView(dEVar, new LinearLayout.LayoutParams(-2, -2));
        TextView textView2 = new TextView(this.pFF);
        textView2.setId(520093703);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(kX.zY(this.pFF, 76.0f), kX.zY(this.pFF, 36.0f));
        textView2.setBackground(Ol.sc(this.pFF, 18));
        textView2.setEllipsize(truncateAt);
        textView2.setMaxLines(1);
        textView2.setGravity(17);
        textView2.setText(com.bytedance.sdk.component.utils.Sfl.sc(this.pFF, "tt_video_download_apk"));
        textView2.setTextColor(-1);
        textView2.setTextSize(14.0f);
        textView2.setLayoutParams(layoutParams6);
        linearLayout.addView(textView2);
        FrameLayout frameLayout = new FrameLayout(this.pFF);
        frameLayout.setLayoutDirection(3);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams7.addRule(2, linearLayout.getId());
        layoutParams7.bottomMargin = iZY2;
        frameLayout.setLayoutParams(layoutParams7);
        relativeLayout.addView(frameLayout);
        Ql ql2 = new Ql(this.pFF);
        ql2.setId(520093736);
        ql2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams8.gravity = 17;
        frameLayout.addView(ql2, layoutParams8);
        View pAGLogoView = new PAGLogoView(this.pFF);
        pAGLogoView.setId(520093739);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams9.addRule(10);
        layoutParams9.addRule(9);
        layoutParams9.setMargins(iZY, iZY, 0, 0);
        pAGLogoView.setLayoutParams(layoutParams9);
        relativeLayout.addView(pAGLogoView);
        return new C0309sc(xc2, pAGLogoView, textView2, textView, ql2, dEVar, frameLayout);
    }

    private C0309sc TRI() {
        int iZY = kX.zY(this.pFF, 8.0f);
        Ql ql2 = new Ql(this.pFF);
        ql2.setId(520093736);
        ql2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(ql2, layoutParams);
        View pAGLogoView = new PAGLogoView(this.pFF);
        pAGLogoView.setId(520093739);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(iZY, iZY, 0, 0);
        layoutParams2.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
        pAGLogoView.setLayoutParams(layoutParams2);
        addView(pAGLogoView);
        return new C0309sc(pAGLogoView, ql2);
    }

    private void We() {
        C0309sc c0309scTRI = TRI();
        this.Ql = c0309scTRI;
        View view = c0309scTRI.TRI;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.zY.sc.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TTWebsiteActivity.sc(((com.bytedance.sdk.openadsdk.core.Qj.sc) sc.this).pFF, ((com.bytedance.sdk.openadsdk.core.Qj.sc) sc.this).zY, ((com.bytedance.sdk.openadsdk.core.Qj.sc) sc.this).TRI);
                }
            });
        }
        Ql ql2 = this.Ql.f28597sc;
        if (ql2 != null) {
            List<BT> listHt = this.zY.ht();
            if (listHt != null && !listHt.isEmpty()) {
                com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(listHt.get(0), ql2, this.zY);
            }
            sc((View) ql2, true);
            ql2.setTag(520093762, Boolean.TRUE);
        }
    }

    private void pFF() {
        Xc xcSc = sc(this.SR.getExpectExpressWidth(), this.SR.getExpectExpressHeight());
        if (this.SR.getExpectExpressWidth() <= 0 || this.SR.getExpectExpressHeight() <= 0) {
            int iZY = kX.zY(this.pFF);
            this.f28092qr = iZY;
            this.Qj = Float.valueOf(iZY / xcSc.pFF).intValue();
        } else {
            this.f28092qr = kX.zY(this.pFF, this.SR.getExpectExpressWidth());
            this.Qj = kX.zY(this.pFF, this.SR.getExpectExpressHeight());
        }
        int i11 = this.f28092qr;
        if (i11 > 0 && i11 > kX.zY(this.pFF)) {
            float fZY = kX.zY(this.pFF) / this.f28092qr;
            this.f28092qr = kX.zY(this.pFF);
            this.Qj = Float.valueOf(this.Qj * fZY).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f28092qr, this.Qj);
        }
        layoutParams.width = this.f28092qr;
        layoutParams.height = this.Qj;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.zY;
        if (sfl != null) {
            int iDix = sfl.dix();
            if (iDix == 1010 || iDix == 1011 || iDix == 1012) {
                We();
            } else {
                sc(xcSc);
            }
        }
    }

    private C0309sc qr() {
        int iZY = kX.zY(this.pFF, 38.0f);
        int iZY2 = (int) (((double) kX.zY(this.pFF, 25.0f)) / 5.0d);
        int iZY3 = kX.zY(this.pFF, 10.0f);
        int iZY4 = kX.zY(this.pFF, 2.0f);
        int iZY5 = kX.zY(this.pFF, 6.0f);
        int iZY6 = kX.zY(this.pFF, 8.0f);
        RelativeLayout relativeLayout = new RelativeLayout(this.pFF);
        addView(relativeLayout, -1, -1);
        com.bytedance.sdk.openadsdk.core.widget.Xc xc2 = new com.bytedance.sdk.openadsdk.core.widget.Xc(this.pFF);
        xc2.setId(520093738);
        TextView textView = new TextView(this.pFF);
        textView.setId(520093730);
        dE dEVar = new dE(this.pFF);
        dEVar.setId(520093735);
        View pAGLogoView = new PAGLogoView(this.pFF);
        pAGLogoView.setId(520093739);
        TextView textView2 = new TextView(this.pFF);
        textView2.setId(520093703);
        C0309sc c0309sc = new C0309sc(xc2, textView, dEVar, pAGLogoView, textView2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iZY, iZY);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        layoutParams.addRule(20);
        layoutParams.setMarginStart(iZY5);
        layoutParams.setMargins(iZY5, 0, 0, 0);
        xc2.setLayoutParams(layoutParams);
        xc2.setBackgroundColor(-1);
        xc2.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout.addView(xc2);
        LinearLayout linearLayout = new LinearLayout(this.pFF);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(16, textView2.getId());
        layoutParams2.addRule(17, xc2.getId());
        layoutParams2.setMarginStart(iZY6);
        layoutParams2.setMarginEnd(iZY6);
        layoutParams2.addRule(0, textView2.getId());
        layoutParams2.addRule(1, xc2.getId());
        layoutParams2.setMargins(iZY6, 0, iZY6, 0);
        relativeLayout.addView(linearLayout, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        textView.setTextDirection(5);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        textView.setGravity(80);
        textView.setMaxLines(1);
        textView.setTextColor(Color.parseColor("#FF333333"));
        textView.setTextSize(12.0f);
        textView.setLayoutParams(layoutParams3);
        linearLayout.addView(textView);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = iZY4;
        dEVar.setLayoutParams(layoutParams4);
        linearLayout.addView(dEVar);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(20);
        layoutParams5.addRule(9);
        layoutParams5.addRule(12);
        pAGLogoView.setLayoutParams(layoutParams5);
        relativeLayout.addView(pAGLogoView);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(11);
        layoutParams6.addRule(15);
        layoutParams6.setMarginEnd(iZY5);
        layoutParams6.addRule(21);
        layoutParams6.rightMargin = iZY5;
        textView2.setBackground(Ol.sc(this.pFF, 12));
        textView2.setEllipsize(truncateAt);
        textView2.setGravity(17);
        textView2.setMaxLines(1);
        textView2.setPadding(iZY3, iZY2, iZY3, iZY2);
        textView2.setText(com.bytedance.sdk.component.utils.Sfl.sc(this.pFF, "tt_video_download_apk"));
        textView2.setTextColor(Color.parseColor("#f0f0f0"));
        textView2.setTextSize(10.0f);
        textView2.setLayoutParams(layoutParams6);
        relativeLayout.addView(textView2);
        return c0309sc;
    }

    public static Xc sc(int i11, int i12) {
        try {
            return ((double) i12) >= Math.floor((((double) i11) * 450.0d) / 600.0d) ? f28590sc[1] : f28590sc[0];
        } catch (Throwable unused) {
            return f28590sc[0];
        }
    }

    private void sc(Xc xc2) {
        if (xc2.f28083sc == 1) {
            zY();
        } else {
            ExN();
        }
    }

    private void zY() {
        float fZY = (this.Qj * 1.0f) / kX.zY(this.pFF, 50.0f);
        float f11 = this.Qj * 1.0f;
        int i11 = this.f28092qr;
        if (f11 / i11 > 0.21875f) {
            fZY = (i11 * 1.0f) / kX.zY(this.pFF, 320.0f);
        }
        C0309sc c0309scQr = qr();
        this.Ql = c0309scQr;
        ImageView imageView = c0309scQr.zY;
        TextView textView = c0309scQr.pFF;
        dE dEVar = c0309scQr.We;
        TextView textView2 = c0309scQr.f28596qr;
        textView.setTextSize(2, kX.pFF(this.pFF, textView.getTextSize()) * fZY);
        textView2.setTextSize(2, kX.pFF(this.pFF, textView2.getTextSize()) * fZY);
        View view = this.Ql.TRI;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.zY.sc.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TTWebsiteActivity.sc(((com.bytedance.sdk.openadsdk.core.Qj.sc) sc.this).pFF, ((com.bytedance.sdk.openadsdk.core.Qj.sc) sc.this).zY, ((com.bytedance.sdk.openadsdk.core.Qj.sc) sc.this).TRI);
                }
            });
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) (kX.zY(this.pFF, 38.0f) * fZY);
            layoutParams.height = (int) (kX.zY(this.pFF, 38.0f) * fZY);
        }
        if (this.zY.qfG() != null && !TextUtils.isEmpty(this.zY.qfG().sc())) {
            com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(this.zY.qfG().sc(), this.zY.qfG().pFF(), this.zY.qfG().zY(), imageView, this.zY);
        }
        textView.setText(this.zY.YdT());
        if (TextUtils.isEmpty(this.zY.NQ())) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(this.zY.NQ());
        }
        kX.sc((TextView) null, dEVar, this.zY);
        sc((View) imageView, true);
        imageView.setTag(520093762, Boolean.TRUE);
        sc((View) this, true);
        sc((View) textView2, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.sc
    public void sc() {
        TTDislikeDialogAbstract tTDislikeDialogAbstract = this.ExN;
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.show();
            return;
        }
        com.bytedance.sdk.openadsdk.zY.zY zYVar = this.We;
        if (zYVar != null) {
            zYVar.sc();
        } else {
            TTDelegateActivity.sc(this.zY, this.BT);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.sc
    public void sc(View view, int i11, SR sr2) {
        Sfl sfl = this.SR;
        if (sfl != null) {
            sfl.sc(view, i11, sr2);
        }
    }

    public void sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl, Sfl sfl2, com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI tri) {
        setBackgroundColor(-1);
        this.zY = sfl;
        this.SR = sfl2;
        this.TRI = "banner_ad";
        sfl2.addView(this, new ViewGroup.LayoutParams(-2, -2));
        pFF();
    }

    public void setAdInteractionListener(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        this.dE = pAGBannerAdWrapperListener;
    }

    public void setClosedListenerKey(String str) {
        this.BT = str;
    }
}
