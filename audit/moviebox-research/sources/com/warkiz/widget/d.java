package com.warkiz.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrowView f62755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f62756d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PopupWindow f62757e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f62758f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f62759g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f62760h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Context f62761i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f62762j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IndicatorSeekBar f62763k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f62764l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f62765m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f62766n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f62767o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f62768p;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f62754b = new int[2];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f62753a = e();

    public d(Context context, IndicatorSeekBar indicatorSeekBar, int i11, int i12, int i13, int i14, View view, View view2) {
        this.f62761i = context;
        this.f62763k = indicatorSeekBar;
        this.f62760h = i11;
        this.f62762j = i12;
        this.f62765m = view;
        this.f62766n = view2;
        this.f62767o = i13;
        this.f62768p = i14;
        this.f62759g = g.a(this.f62761i, 2.0f);
        h();
    }

    public final void a(float f11) {
        int i11 = this.f62762j;
        if (i11 == 4 || i11 == 1) {
            return;
        }
        int iC = c();
        if (iC + f11 < this.f62757e.getContentView().getMeasuredWidth() / 2) {
            k(this.f62755c, -((int) (((this.f62757e.getContentView().getMeasuredWidth() / 2) - iC) - f11)), -1, -1, -1);
        } else if ((this.f62753a - iC) - f11 < this.f62757e.getContentView().getMeasuredWidth() / 2) {
            k(this.f62755c, (int) ((this.f62757e.getContentView().getMeasuredWidth() / 2) - ((this.f62753a - iC) - f11)), -1, -1, -1);
        } else {
            k(this.f62755c, 0, 0, 0, 0);
        }
    }

    @NonNull
    public final GradientDrawable b() {
        GradientDrawable gradientDrawable = this.f62762j == 2 ? (GradientDrawable) this.f62761i.getResources().getDrawable(R$drawable.isb_indicator_rounded_corners) : (GradientDrawable) this.f62761i.getResources().getDrawable(R$drawable.isb_indicator_square_corners);
        gradientDrawable.setColor(this.f62760h);
        return gradientDrawable;
    }

    public final int c() {
        this.f62763k.getLocationOnScreen(this.f62754b);
        return this.f62754b[0];
    }

    public View d() {
        return this.f62764l;
    }

    public final int e() {
        WindowManager windowManager = (WindowManager) this.f62761i.getSystemService("window");
        if (windowManager != null) {
            return windowManager.getDefaultDisplay().getWidth();
        }
        return 0;
    }

    public void f() {
        PopupWindow popupWindow = this.f62757e;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    public void g() {
        View view;
        if (this.f62757e != null || this.f62762j == 0 || (view = this.f62764l) == null) {
            return;
        }
        view.measure(0, 0);
        this.f62757e = new PopupWindow(this.f62764l, -2, -2, false);
    }

    public final void h() {
        View viewFindViewById;
        int i11 = this.f62762j;
        if (i11 == 4) {
            View view = this.f62765m;
            if (view == null) {
                throw new IllegalArgumentException("the attr：indicator_custom_layout must be set while you set the indicator type to CUSTOM.");
            }
            this.f62764l = view;
            int identifier = this.f62761i.getResources().getIdentifier("isb_progress", "id", this.f62761i.getApplicationContext().getPackageName());
            if (identifier <= 0 || (viewFindViewById = this.f62764l.findViewById(identifier)) == null) {
                return;
            }
            if (!(viewFindViewById instanceof TextView)) {
                throw new ClassCastException("the view identified by isb_progress in indicator custom layout can not be cast to TextView");
            }
            TextView textView = (TextView) viewFindViewById;
            this.f62756d = textView;
            textView.setText(this.f62763k.getIndicatorTextString());
            this.f62756d.setTextSize(g.b(this.f62761i, this.f62767o));
            this.f62756d.setTextColor(this.f62768p);
            return;
        }
        if (i11 == 1) {
            CircleBubbleView circleBubbleView = new CircleBubbleView(this.f62761i, this.f62767o, this.f62768p, this.f62760h, "1000");
            this.f62764l = circleBubbleView;
            circleBubbleView.setProgress(this.f62763k.getIndicatorTextString());
            return;
        }
        View viewInflate = View.inflate(this.f62761i, R$layout.isb_indicator, null);
        this.f62764l = viewInflate;
        this.f62758f = (LinearLayout) viewInflate.findViewById(R$id.indicator_container);
        ArrowView arrowView = (ArrowView) this.f62764l.findViewById(R$id.indicator_arrow);
        this.f62755c = arrowView;
        arrowView.setColor(this.f62760h);
        TextView textView2 = (TextView) this.f62764l.findViewById(R$id.isb_progress);
        this.f62756d = textView2;
        textView2.setText(this.f62763k.getIndicatorTextString());
        this.f62756d.setTextSize(g.b(this.f62761i, this.f62767o));
        this.f62756d.setTextColor(this.f62768p);
        this.f62758f.setBackground(b());
        if (this.f62766n != null) {
            int identifier2 = this.f62761i.getResources().getIdentifier("isb_progress", "id", this.f62761i.getApplicationContext().getPackageName());
            View view2 = this.f62766n;
            if (identifier2 <= 0) {
                m(view2);
                return;
            }
            View viewFindViewById2 = view2.findViewById(identifier2);
            if (viewFindViewById2 == null || !(viewFindViewById2 instanceof TextView)) {
                m(view2);
            } else {
                n(view2, (TextView) viewFindViewById2);
            }
        }
    }

    public boolean i() {
        PopupWindow popupWindow = this.f62757e;
        return popupWindow != null && popupWindow.isShowing();
    }

    public void j() {
        String indicatorTextString = this.f62763k.getIndicatorTextString();
        View view = this.f62764l;
        if (view instanceof CircleBubbleView) {
            ((CircleBubbleView) view).setProgress(indicatorTextString);
            return;
        }
        TextView textView = this.f62756d;
        if (textView != null) {
            textView.setText(indicatorTextString);
        }
    }

    public final void k(View view, int i11, int i12, int i13, int i14) {
        if (view != null && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (i11 == -1) {
                i11 = marginLayoutParams.leftMargin;
            }
            if (i12 == -1) {
                i12 = marginLayoutParams.topMargin;
            }
            if (i13 == -1) {
                i13 = marginLayoutParams.rightMargin;
            }
            if (i14 == -1) {
                i14 = marginLayoutParams.bottomMargin;
            }
            marginLayoutParams.setMargins(i11, i12, i13, i14);
            view.requestLayout();
        }
    }

    public void l(String str) {
        View view = this.f62764l;
        if (view instanceof CircleBubbleView) {
            ((CircleBubbleView) view).setProgress(str);
            return;
        }
        TextView textView = this.f62756d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void m(@NonNull View view) {
        n(view, null);
    }

    public void n(@NonNull View view, @Nullable TextView textView) {
        this.f62756d = textView;
        this.f62758f.removeAllViews();
        view.setBackground(b());
        this.f62758f.addView(view);
    }

    public void o(float f11) {
        if (this.f62763k.isEnabled() && this.f62763k.getVisibility() == 0) {
            j();
            PopupWindow popupWindow = this.f62757e;
            if (popupWindow != null) {
                popupWindow.getContentView().measure(0, 0);
                PopupWindow popupWindow2 = this.f62757e;
                popupWindow2.showAsDropDown(this.f62763k, (int) (f11 - (popupWindow2.getContentView().getMeasuredWidth() / 2.0f)), -(((this.f62763k.getMeasuredHeight() + this.f62757e.getContentView().getMeasuredHeight()) - this.f62763k.getPaddingTop()) + this.f62759g));
                a(f11);
            }
        }
    }

    public void p(float f11) {
        if (this.f62763k.isEnabled() && this.f62763k.getVisibility() == 0) {
            j();
            PopupWindow popupWindow = this.f62757e;
            if (popupWindow != null) {
                popupWindow.getContentView().measure(0, 0);
                PopupWindow popupWindow2 = this.f62757e;
                popupWindow2.update(this.f62763k, (int) (f11 - (popupWindow2.getContentView().getMeasuredWidth() / 2)), -(((this.f62763k.getMeasuredHeight() + this.f62757e.getContentView().getMeasuredHeight()) - this.f62763k.getPaddingTop()) + this.f62759g), -1, -1);
                a(f11);
            }
        }
    }

    public void q(int i11) {
        k(this.f62755c, i11, -1, -1, -1);
    }

    public void r(int i11) {
        k(this.f62764l, i11, -1, -1, -1);
    }
}
