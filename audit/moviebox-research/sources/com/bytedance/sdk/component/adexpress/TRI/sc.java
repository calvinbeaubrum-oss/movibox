package com.bytedance.sdk.component.adexpress.TRI;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc extends TextSwitcher implements ViewSwitcher.ViewFactory, com.bytedance.sdk.component.utils.FI.sc {
    private Context ExN;
    private float Ol;
    private int Qj;
    private int Ql;
    private Handler SR;
    private TextView TRI;
    private int Tf;
    private int UFX;
    private int WH;
    private final int We;
    private List<String> pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f26718qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    Animation.AnimationListener f26719sc;
    private int zY;

    public sc(Context context, int i11, float f11, int i12, int i13) {
        super(context);
        this.pFF = new ArrayList();
        this.zY = 0;
        this.We = 1;
        this.SR = new com.bytedance.sdk.component.utils.FI(Looper.getMainLooper(), this);
        this.f26719sc = new Animation.AnimationListener() { // from class: com.bytedance.sdk.component.adexpress.TRI.sc.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (sc.this.TRI != null) {
                    sc.this.TRI.setText("");
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        };
        this.ExN = context;
        this.Qj = i11;
        this.Ol = f11;
        this.WH = i12;
        this.Ql = i13;
        zY();
    }

    private void zY() {
        setFactory(this);
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        TextView textView = new TextView(getContext());
        this.TRI = textView;
        textView.setTextColor(this.Qj);
        this.TRI.setTextSize(this.Ol);
        this.TRI.setMaxLines(this.WH);
        this.TRI.setTextAlignment(this.Ql);
        return this.TRI;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.SR.sendEmptyMessageDelayed(1, this.f26718qr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.SR.removeMessages(1);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        try {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(com.bytedance.sdk.component.adexpress.dynamic.ExN.UFX.pFF(this.pFF.get(this.UFX), this.Ol, false)[0], 1073741824), i11);
        } catch (Exception unused) {
            super.onMeasure(i11, i12);
        }
    }

    public void pFF() {
        List<String> list = this.pFF;
        if (list == null || list.size() <= 0) {
            return;
        }
        int i11 = this.zY;
        this.zY = i11 + 1;
        this.UFX = i11;
        setText(this.pFF.get(i11));
        if (this.zY > this.pFF.size() - 1) {
            this.zY = 0;
        }
    }

    public void sc() {
        int i11 = this.Tf;
        if (i11 == 1) {
            setInAnimation(getContext(), com.bytedance.sdk.component.utils.Sfl.Ol(this.ExN, "tt_text_animation_y_in"));
            setOutAnimation(getContext(), com.bytedance.sdk.component.utils.Sfl.Ol(this.ExN, "tt_text_animation_y_out"));
        } else if (i11 == 0) {
            setInAnimation(getContext(), com.bytedance.sdk.component.utils.Sfl.Ol(this.ExN, "tt_text_animation_x_in"));
            setOutAnimation(getContext(), com.bytedance.sdk.component.utils.Sfl.Ol(this.ExN, "tt_text_animation_x_in"));
            getInAnimation().setInterpolator(new LinearInterpolator());
            getOutAnimation().setInterpolator(new LinearInterpolator());
            getInAnimation().setAnimationListener(this.f26719sc);
            getOutAnimation().setAnimationListener(this.f26719sc);
        }
        this.SR.sendEmptyMessage(1);
    }

    @Override // com.bytedance.sdk.component.utils.FI.sc
    public void sc(Message message) {
        if (message.what != 1) {
            return;
        }
        pFF();
        this.SR.sendEmptyMessageDelayed(1, this.f26718qr);
    }

    public void setAnimationDuration(int i11) {
        this.f26718qr = i11;
    }

    public void setAnimationText(List<String> list) {
        this.pFF = list;
    }

    public void setAnimationType(int i11) {
        this.Tf = i11;
    }

    public void setMaxLines(int i11) {
        this.WH = i11;
    }

    public void setTextColor(int i11) {
        this.Qj = i11;
    }

    public void setTextSize(float f11) {
        this.Ol = f11;
    }
}
