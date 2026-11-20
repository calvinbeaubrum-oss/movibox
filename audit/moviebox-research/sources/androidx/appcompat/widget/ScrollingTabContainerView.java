package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Interpolator f1482m = new DecelerateInterpolator();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Runnable f1483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f1484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayoutCompat f1485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Spinner f1486d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1487f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1488g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1489h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1490i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1491j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewPropertyAnimator f1492k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final d f1493l;

    /* JADX INFO: compiled from: source.java */
    public class a extends BaseAdapter {
        public a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ScrollingTabContainerView.this.f1485c.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i11) {
            return ((c) ScrollingTabContainerView.this.f1485c.getChildAt(i11)).b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i11) {
            return i11;
        }

        @Override // android.widget.Adapter
        public View getView(int i11, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.c((androidx.appcompat.app.a.c) getItem(i11), true);
            }
            ((c) view).a((androidx.appcompat.app.a.c) getItem(i11));
            return view;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((c) view).b().e();
            int childCount = ScrollingTabContainerView.this.f1485c.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = ScrollingTabContainerView.this.f1485c.getChildAt(i11);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f1496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public androidx.appcompat.app.a.c f1497b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TextView f1498c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ImageView f1499d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View f1500f;

        public c(Context context, androidx.appcompat.app.a.c cVar, boolean z11) {
            super(context, null, R$attr.actionBarTabStyle);
            int[] iArr = {R.attr.background};
            this.f1496a = iArr;
            this.f1497b = cVar;
            n0 n0VarV = n0.v(context, null, iArr, R$attr.actionBarTabStyle, 0);
            if (n0VarV.s(0)) {
                setBackgroundDrawable(n0VarV.g(0));
            }
            n0VarV.x();
            if (z11) {
                setGravity(8388627);
            }
            c();
        }

        public void a(androidx.appcompat.app.a.c cVar) {
            this.f1497b = cVar;
            c();
        }

        public androidx.appcompat.app.a.c b() {
            return this.f1497b;
        }

        public void c() {
            androidx.appcompat.app.a.c cVar = this.f1497b;
            View viewB = cVar.b();
            if (viewB != null) {
                ViewParent parent = viewB.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewB);
                    }
                    addView(viewB);
                }
                this.f1500f = viewB;
                TextView textView = this.f1498c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f1499d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f1499d.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f1500f;
            if (view != null) {
                removeView(view);
                this.f1500f = null;
            }
            Drawable drawableC = cVar.c();
            CharSequence charSequenceD = cVar.d();
            if (drawableC != null) {
                if (this.f1499d == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f1499d = appCompatImageView;
                }
                this.f1499d.setImageDrawable(drawableC);
                this.f1499d.setVisibility(0);
            } else {
                ImageView imageView2 = this.f1499d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f1499d.setImageDrawable(null);
                }
            }
            boolean z11 = !TextUtils.isEmpty(charSequenceD);
            if (z11) {
                if (this.f1498c == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, R$attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f1498c = appCompatTextView;
                }
                this.f1498c.setText(charSequenceD);
                this.f1498c.setVisibility(0);
            } else {
                TextView textView2 = this.f1498c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f1498c.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f1499d;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.a());
            }
            s0.a(this, z11 ? null : cVar.a());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i11, int i12) {
            super.onMeasure(i11, i12);
            if (ScrollingTabContainerView.this.f1488g > 0) {
                int measuredWidth = getMeasuredWidth();
                int i13 = ScrollingTabContainerView.this.f1488g;
                if (measuredWidth > i13) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i13, 1073741824), i12);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z11) {
            boolean z12 = isSelected() != z11;
            super.setSelected(z11);
            if (z12 && z11) {
                sendAccessibilityEvent(4);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1502a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1503b;

        public d() {
        }

        public d a(ViewPropertyAnimator viewPropertyAnimator, int i11) {
            this.f1503b = i11;
            ScrollingTabContainerView.this.f1492k = viewPropertyAnimator;
            return this;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1502a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f1502a) {
                return;
            }
            ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
            scrollingTabContainerView.f1492k = null;
            scrollingTabContainerView.setVisibility(this.f1503b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.f1502a = false;
        }
    }

    public ScrollingTabContainerView(@NonNull Context context) {
        super(context);
        this.f1493l = new d();
        setHorizontalScrollBarEnabled(false);
        g1.a aVarB = g1.a.b(context);
        setContentHeight(aVarB.f());
        this.f1489h = aVarB.e();
        LinearLayoutCompat linearLayoutCompatB = b();
        this.f1485c = linearLayoutCompatB;
        addView(linearLayoutCompatB, new ViewGroup.LayoutParams(-2, -1));
    }

    public final Spinner a() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R$attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.a(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    public void addTab(androidx.appcompat.app.a.c cVar, int i11, boolean z11) {
        c cVarC = c(cVar, false);
        this.f1485c.addView(cVarC, i11, new LinearLayoutCompat.a(0, -1, 1.0f));
        Spinner spinner = this.f1486d;
        if (spinner != null) {
            ((a) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z11) {
            cVarC.setSelected(true);
        }
        if (this.f1487f) {
            requestLayout();
        }
    }

    public void addTab(androidx.appcompat.app.a.c cVar, boolean z11) {
        c cVarC = c(cVar, false);
        this.f1485c.addView(cVarC, new LinearLayoutCompat.a(0, -1, 1.0f));
        Spinner spinner = this.f1486d;
        if (spinner != null) {
            ((a) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z11) {
            cVarC.setSelected(true);
        }
        if (this.f1487f) {
            requestLayout();
        }
    }

    public void animateToTab(int i11) {
        final View childAt = this.f1485c.getChildAt(i11);
        Runnable runnable = this.f1483a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: androidx.appcompat.widget.ScrollingTabContainerView.1
            @Override // java.lang.Runnable
            public void run() {
                ScrollingTabContainerView.this.smoothScrollTo(childAt.getLeft() - ((ScrollingTabContainerView.this.getWidth() - childAt.getWidth()) / 2), 0);
                ScrollingTabContainerView.this.f1483a = null;
            }
        };
        this.f1483a = runnable2;
        post(runnable2);
    }

    public void animateToVisibility(int i11) {
        ViewPropertyAnimator viewPropertyAnimator = this.f1492k;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        if (i11 != 0) {
            ViewPropertyAnimator viewPropertyAnimatorAlpha = animate().alpha(0.0f);
            viewPropertyAnimatorAlpha.setDuration(200L);
            viewPropertyAnimatorAlpha.setInterpolator(f1482m);
            viewPropertyAnimatorAlpha.setListener(this.f1493l.a(viewPropertyAnimatorAlpha, i11));
            viewPropertyAnimatorAlpha.start();
            return;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAlpha2 = animate().alpha(1.0f);
        viewPropertyAnimatorAlpha2.setDuration(200L);
        viewPropertyAnimatorAlpha2.setInterpolator(f1482m);
        viewPropertyAnimatorAlpha2.setListener(this.f1493l.a(viewPropertyAnimatorAlpha2, i11));
        viewPropertyAnimatorAlpha2.start();
    }

    public final LinearLayoutCompat b() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, R$attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.a(-2, -1));
        return linearLayoutCompat;
    }

    public c c(androidx.appcompat.app.a.c cVar, boolean z11) {
        c cVar2 = new c(getContext(), cVar, z11);
        if (z11) {
            cVar2.setBackgroundDrawable(null);
            cVar2.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1490i));
        } else {
            cVar2.setFocusable(true);
            if (this.f1484b == null) {
                this.f1484b = new b();
            }
            cVar2.setOnClickListener(this.f1484b);
        }
        return cVar2;
    }

    public final boolean d() {
        Spinner spinner = this.f1486d;
        return spinner != null && spinner.getParent() == this;
    }

    public final void e() {
        if (d()) {
            return;
        }
        if (this.f1486d == null) {
            this.f1486d = a();
        }
        removeView(this.f1485c);
        addView(this.f1486d, new ViewGroup.LayoutParams(-2, -1));
        if (this.f1486d.getAdapter() == null) {
            this.f1486d.setAdapter((SpinnerAdapter) new a());
        }
        Runnable runnable = this.f1483a;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f1483a = null;
        }
        this.f1486d.setSelection(this.f1491j);
    }

    public final boolean f() {
        if (!d()) {
            return false;
        }
        removeView(this.f1486d);
        addView(this.f1485c, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f1486d.getSelectedItemPosition());
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f1483a;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        g1.a aVarB = g1.a.b(getContext());
        setContentHeight(aVarB.f());
        this.f1489h = aVarB.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f1483a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i11, long j11) {
        ((c) view).b().e();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        boolean z11 = mode == 1073741824;
        setFillViewport(z11);
        int childCount = this.f1485c.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f1488g = -1;
        } else {
            if (childCount > 2) {
                this.f1488g = (int) (View.MeasureSpec.getSize(i11) * 0.4f);
            } else {
                this.f1488g = View.MeasureSpec.getSize(i11) / 2;
            }
            this.f1488g = Math.min(this.f1488g, this.f1489h);
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1490i, 1073741824);
        if (z11 || !this.f1487f) {
            f();
        } else {
            this.f1485c.measure(0, iMakeMeasureSpec);
            if (this.f1485c.getMeasuredWidth() > View.MeasureSpec.getSize(i11)) {
                e();
            } else {
                f();
            }
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i11, iMakeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z11 || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.f1491j);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void removeAllTabs() {
        this.f1485c.removeAllViews();
        Spinner spinner = this.f1486d;
        if (spinner != null) {
            ((a) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f1487f) {
            requestLayout();
        }
    }

    public void removeTabAt(int i11) {
        this.f1485c.removeViewAt(i11);
        Spinner spinner = this.f1486d;
        if (spinner != null) {
            ((a) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f1487f) {
            requestLayout();
        }
    }

    public void setAllowCollapse(boolean z11) {
        this.f1487f = z11;
    }

    public void setContentHeight(int i11) {
        this.f1490i = i11;
        requestLayout();
    }

    public void setTabSelected(int i11) {
        this.f1491j = i11;
        int childCount = this.f1485c.getChildCount();
        int i12 = 0;
        while (i12 < childCount) {
            View childAt = this.f1485c.getChildAt(i12);
            boolean z11 = i12 == i11;
            childAt.setSelected(z11);
            if (z11) {
                animateToTab(i11);
            }
            i12++;
        }
        Spinner spinner = this.f1486d;
        if (spinner == null || i11 < 0) {
            return;
        }
        spinner.setSelection(i11);
    }

    public void updateTab(int i11) {
        ((c) this.f1485c.getChildAt(i11)).c();
        Spinner spinner = this.f1486d;
        if (spinner != null) {
            ((a) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f1487f) {
            requestLayout();
        }
    }
}
