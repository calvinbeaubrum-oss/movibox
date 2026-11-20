package com.bytedance.sdk.openadsdk.zY;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.Sfl;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.settings.dE;
import com.bytedance.sdk.openadsdk.utils.SR;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.google.android.material.card.MaterialCardView;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Ol extends com.bytedance.sdk.openadsdk.core.ExN.zY implements WH.We, WH.pFF, WH.sc, WH.zY {
    private com.bytedance.sdk.openadsdk.core.ExN.Qj ExN;
    private View Ol;
    private View Qj;
    private int Ql;
    private FilterWord SR;
    private TextView TRI;
    private int Tf;
    private com.bytedance.sdk.openadsdk.core.ExN.Qj UFX;
    private com.bytedance.sdk.openadsdk.core.ExN.We WH;
    private final WH We;
    private int pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private UFX f28798qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    TRI f28799sc;
    private int zY;

    public Ol(Context context, WH wh2) {
        this(context, wh2, null);
    }

    public Ol(Context context, WH wh2, List<FilterWord> list) {
        super(context);
        this.We = wh2;
        wh2.sc((WH.zY) this);
        wh2.sc((WH.pFF) this);
        wh2.sc((WH.We) this);
        wh2.sc((WH.sc) this);
        zY();
        sc(context);
        if (list == null || list.isEmpty()) {
            return;
        }
        pFF(list);
    }

    private View We(Context context) {
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN.setOrientation(1);
        exN.setLayoutParams(new LinearLayout.LayoutParams(-1, !We() ? kX.zY(context, 200.0f) : kX.zY(context, 358.0f)));
        TextView textView = new TextView(context);
        textView.setText(Sfl.sc(context, "tt_select_reason"));
        textView.setTextSize(We() ? 23 : 16);
        textView.setGravity(1);
        textView.setTextColor(Color.parseColor("#161823"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = kX.zY(context, We() ? 24.0f : 4.0f);
        exN.addView(textView, layoutParams);
        TRI tri = new TRI(context, this.We);
        this.f28799sc = tri;
        exN.addView(tri);
        if (dE.ef().eo()) {
            com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
            this.UFX = qj2;
            qj2.setId(SR.OvL);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = We() ? this.pFF : kX.zY(context, 6.0f);
            layoutParams2.gravity = 17;
            this.UFX.setLayoutParams(layoutParams2);
            this.UFX.setFocusable(false);
            this.UFX.setHint(Sfl.sc(context, "tt_add_bad_reason"));
            this.UFX.setHintTextColor(Color.parseColor("#57000000"));
            this.UFX.setTextColor(Color.rgb(22, 24, 35));
            this.UFX.setTextSize(15.0f);
            this.UFX.setGravity(GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK);
            this.UFX.setVisibility(0);
            this.UFX.setPadding(0, kX.zY(context, 15.0f), 0, kX.zY(context, 14.0f));
            this.UFX.setEllipsize(TextUtils.TruncateAt.END);
            this.UFX.setSingleLine();
            this.UFX.setMaxLines(1);
            this.UFX.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.zY.Ol.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Ol.this.We.TRI();
                }
            });
            exN.addView(this.UFX, layoutParams2);
            exN.addView(new UFX(context, Color.argb(128, 0, 0, 0)));
        }
        exN.setVisibility(8);
        return exN;
    }

    private boolean We() {
        if (this.Tf == 0) {
            zY();
        }
        return this.Tf < this.Ql;
    }

    private com.bytedance.sdk.openadsdk.core.ExN.Qj pFF(Context context) {
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = We() ? this.pFF : kX.zY(context, 12.0f);
        layoutParams.gravity = 80;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.zY);
        int iRgb = Color.rgb(254, 44, 85);
        gradientDrawable.setColor(iRgb);
        gradientDrawable.setAlpha(102);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(this.zY);
        gradientDrawable2.setColor(iRgb);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_enabled}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        int i11 = this.zY;
        qj2.setPadding(0, i11, 0, i11);
        qj2.setGravity(17);
        qj2.setBackground(stateListDrawable);
        qj2.setTextColor(-1);
        qj2.setTextSize(16.0f);
        qj2.setText(Sfl.sc(context, "tt_suggestion_commit"));
        qj2.setEnabled(false);
        qj2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.zY.Ol.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ol.this.We.We();
            }
        });
        qj2.setLayoutParams(layoutParams);
        return qj2;
    }

    private void pFF(List<FilterWord> list) {
        this.f28799sc.sc(list);
    }

    private void sc(Context context) {
        this.zY = kX.zY(context, 8.0f);
        this.pFF = kX.zY(context, 20.0f);
        int iZY = kX.zY(context, 56.0f);
        int iZY2 = kX.zY(context, 30.0f);
        int iZY3 = kX.zY(context, 12.0f);
        if (We()) {
            iZY3 = this.pFF;
        }
        if (!We()) {
            iZY = iZY2;
        }
        View view = new View(getContext());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, kX.zY(getContext(), 98.0f));
        view.setBackground(Sfl.zY(context, "tt_ad_bg_header_gradient"));
        addView(view, layoutParams);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.zY);
        gradientDrawable.setColor(-1);
        setBackground(gradientDrawable);
        setLayoutParams(layoutParams2);
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        int iZY4 = kX.zY(context, 24.0f);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(iZY4, iZY4);
        layoutParams3.setMargins(0, iZY3, iZY3, 0);
        layoutParams3.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END;
        we2.setImageDrawable(com.bytedance.sdk.openadsdk.utils.Ol.sc(context, "tt_titlebar_close_seletor"));
        addView(we2, layoutParams3);
        we2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.zY.Ol.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Ol.this.We.ExN();
            }
        });
        com.bytedance.sdk.openadsdk.core.ExN.We we3 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        this.WH = we3;
        we3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.zY.Ol.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Ol.this.pFF();
            }
        });
        this.WH.setVisibility(8);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(iZY4, iZY4);
        layoutParams4.setMargins(iZY3, iZY3, 0, 0);
        layoutParams4.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
        Drawable drawableSc = com.bytedance.sdk.openadsdk.utils.Ol.sc(context, "tt_leftbackicon_selector");
        drawableSc.setAutoMirrored(true);
        this.WH.setImageDrawable(drawableSc);
        addView(this.WH, layoutParams4);
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams5.setMargins(iZY3, iZY, iZY3, iZY3);
        exN.setOrientation(1);
        addView(exN, layoutParams5);
        View viewZY = zY(context);
        this.Qj = viewZY;
        exN.addView(viewZY);
        View viewWe = We(context);
        this.Ol = viewWe;
        exN.addView(viewWe);
        com.bytedance.sdk.openadsdk.core.ExN.Qj qjPFF = pFF(context);
        this.ExN = qjPFF;
        exN.addView(qjPFF);
    }

    private View zY(Context context) {
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        exN.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setText(Sfl.sc(context, "tt_like_this_ad"));
        textView.setTextSize(We() ? 23 : 16);
        textView.setGravity(1);
        textView.setTextColor(Color.parseColor("#161823"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        exN.addView(textView, layoutParams);
        TextView textView2 = new TextView(context);
        textView2.setText(Sfl.sc(context, "tt_feel_hint"));
        textView2.setTextSize(We() ? 14 : 10);
        textView2.setAlpha(0.5f);
        textView2.setTextColor(Color.parseColor("#161823"));
        textView2.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        if (We()) {
            layoutParams2.topMargin = kX.zY(context, 4.0f);
        }
        exN.addView(textView2, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN2 = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN2.setOrientation(0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        int iZY = kX.zY(context, 16.0f);
        int iZY2 = kX.zY(context, 12.0f);
        int iZY3 = kX.zY(context, 8.0f);
        if (We()) {
            layoutParams3.topMargin = iZY;
            layoutParams3.bottomMargin = iZY;
        } else {
            layoutParams3.topMargin = iZY2;
            layoutParams3.bottomMargin = iZY3;
        }
        exN.addView(exN2, layoutParams3);
        exN2.addView(new ExN(context, 1, this.We));
        ExN exN3 = new ExN(context, 2, this.We);
        ViewGroup.LayoutParams layoutParams4 = exN3.getLayoutParams();
        boolean z11 = layoutParams4 instanceof LinearLayout.LayoutParams;
        ViewGroup.LayoutParams layoutParams5 = layoutParams4;
        if (!z11) {
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -2);
            layoutParams6.weight = 1.0f;
            layoutParams5 = layoutParams6;
        }
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) layoutParams5;
        layoutParams7.leftMargin = iZY;
        layoutParams7.rightMargin = iZY;
        exN2.addView(exN3, layoutParams5);
        exN2.addView(new ExN(context, 3, this.We));
        UFX ufx = new UFX(context);
        this.f28798qr = ufx;
        exN.addView(ufx);
        this.TRI = new TextView(context);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2);
        if (!We()) {
            iZY = iZY3;
        }
        layoutParams8.topMargin = iZY;
        this.TRI.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.TRI.setPadding(iZY2, iZY3, iZY2, iZY3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(iZY3);
        gradientDrawable.setColor(Color.parseColor("#F8F8F8"));
        this.TRI.setBackground(gradientDrawable);
        this.TRI.setText(Sfl.sc(context, "tt_report_this_ad"));
        this.TRI.setTextSize(We() ? 14 : 12);
        Drawable drawableZY = Sfl.zY(context, "tt_report_ad_arrow");
        drawableZY.setBounds(0, 0, iZY2, iZY2);
        this.TRI.setCompoundDrawables(null, null, drawableZY, null);
        this.TRI.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.zY.Ol.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Ol.this.sc();
            }
        });
        exN.addView(this.TRI, layoutParams8);
        return exN;
    }

    private void zY() {
        if (this.Tf > 0) {
            return;
        }
        this.Tf = kX.zY(getContext());
        int iWe = kX.We(getContext());
        this.Ql = iWe;
        this.We.sc(this.Tf, iWe);
    }

    public void pFF() {
        View view = this.Ol;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.Qj;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = this.WH;
        if (we2 != null) {
            we2.setVisibility(8);
        }
        WH wh2 = this.We;
        if (wh2 != null) {
            FilterWord filterWord = this.SR;
            if (filterWord != null) {
                wh2.sc(filterWord);
            } else {
                wh2.sc(WH.f28815sc);
            }
            this.We.zY(null);
        }
    }

    public void sc() {
        View view = this.Ol;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.Qj;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = this.WH;
        if (we2 != null) {
            we2.setVisibility(0);
        }
        WH wh2 = this.We;
        if (wh2 == null || !wh2.zY()) {
            return;
        }
        this.SR = this.We.pFF();
    }

    @Override // com.bytedance.sdk.openadsdk.zY.WH.pFF
    public void sc(int i11) {
        if (WH.zY == i11) {
            this.SR = null;
            pFF();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zY.WH.zY
    public void sc(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        if (this.ExN != null && TextUtils.isEmpty(this.We.qr())) {
            this.ExN.setEnabled(!WH.f28815sc.equals(filterWord));
        }
        if (ExN.f28796sc.equals(filterWord) || ExN.pFF.equals(filterWord)) {
            this.TRI.setVisibility(8);
            this.f28798qr.setVisibility(8);
        }
        if (ExN.zY.equals(filterWord) || WH.f28815sc.equals(filterWord)) {
            this.TRI.setVisibility(0);
            this.f28798qr.setVisibility(0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zY.WH.We
    public void sc(String str) {
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2;
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj3 = this.UFX;
        if (qj3 != null) {
            qj3.setText(str);
        }
        if (!TextUtils.isEmpty(str)) {
            com.bytedance.sdk.openadsdk.core.ExN.Qj qj4 = this.ExN;
            if (qj4 != null) {
                qj4.setEnabled(true);
                return;
            }
            return;
        }
        WH wh2 = this.We;
        if (wh2 == null || (qj2 = this.ExN) == null) {
            return;
        }
        qj2.setEnabled(wh2.zY());
    }

    @Override // com.bytedance.sdk.openadsdk.zY.WH.sc
    public void sc(List<FilterWord> list) {
        pFF(list);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ExN.zY, android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (layoutParams != null) {
            if (this.Tf == 0) {
                zY();
            }
            layoutParams.width = Math.min(this.Tf, this.Ql) - (kX.zY(getContext(), 16.0f) * 2);
        }
    }
}
