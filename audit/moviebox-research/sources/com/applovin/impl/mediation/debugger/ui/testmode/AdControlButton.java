package com.applovin.impl.mediation.debugger.ui.testmode;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.applovin.impl.o;
import com.applovin.impl.t3;
import com.applovin.mediation.MaxAdFormat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class AdControlButton extends RelativeLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GradientDrawable f20919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Button f20920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final o f20921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f20922d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MaxAdFormat f20923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f20924g;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void onClick(AdControlButton adControlButton);
    }

    /* JADX INFO: compiled from: source.java */
    public enum b {
        LOAD,
        LOADING,
        SHOW
    }

    public AdControlButton(Context context) {
        this(context, null, 0);
    }

    public AdControlButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdControlButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f20919a = gradientDrawable;
        Button button = new Button(getContext());
        this.f20920b = button;
        o oVar = new o(getContext(), 20, R.attr.progressBarStyleSmall);
        this.f20921c = oVar;
        b bVar = b.LOAD;
        this.f20922d = bVar;
        setBackgroundColor(0);
        FrameLayout frameLayout = new FrameLayout(context);
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1, 17));
        button.setOnClickListener(this);
        frameLayout.addView(button, new FrameLayout.LayoutParams(-1, -1, 17));
        gradientDrawable.setCornerRadius(20.0f);
        button.setBackground(gradientDrawable);
        a();
        oVar.setColor(-1);
        addView(oVar, new FrameLayout.LayoutParams(-1, -1, 17));
        c(bVar);
    }

    private int a(b bVar) {
        if (b.LOAD != bVar && b.LOADING != bVar) {
            return t3.a(com.applovin.sdk.R.color.applovin_sdk_adControlbutton_brightBlueColor, getContext());
        }
        return t3.a(com.applovin.sdk.R.color.applovin_sdk_brand_color, getContext());
    }

    private void a() {
        this.f20920b.setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{t3.a(com.applovin.sdk.R.color.applovin_sdk_highlightTextColor, getContext()), -1}));
    }

    private String b(b bVar) {
        if (b.LOAD == bVar) {
            return "Load";
        }
        return b.LOADING == bVar ? "" : "Show";
    }

    private void c(b bVar) {
        if (b.LOADING == bVar) {
            setEnabled(false);
            this.f20921c.a();
        } else {
            setEnabled(true);
            this.f20921c.b();
        }
        this.f20920b.setText(b(bVar));
        this.f20919a.setColor(a(bVar));
    }

    public b getControlState() {
        return this.f20922d;
    }

    public MaxAdFormat getFormat() {
        return this.f20923f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar = this.f20924g;
        if (aVar != null) {
            aVar.onClick(this);
        }
    }

    public void setControlState(b bVar) {
        if (this.f20922d != bVar) {
            c(bVar);
        }
        this.f20922d = bVar;
    }

    public void setFormat(MaxAdFormat maxAdFormat) {
        this.f20923f = maxAdFormat;
    }

    public void setOnClickListener(a aVar) {
        this.f20924g = aVar;
    }
}
