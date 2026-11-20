package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbsActionBarView extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f1201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ActionMenuView f1203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ActionMenuPresenter f1204d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewPropertyAnimatorCompat f1206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1207h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1208i;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class a implements ViewPropertyAnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1209a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1210b;

        public a() {
        }

        public a a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i11) {
            AbsActionBarView.this.f1206g = viewPropertyAnimatorCompat;
            this.f1210b = i11;
            return this;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View view) {
            this.f1209a = true;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            if (this.f1209a) {
                return;
            }
            AbsActionBarView absActionBarView = AbsActionBarView.this;
            absActionBarView.f1206g = null;
            AbsActionBarView.super.setVisibility(this.f1210b);
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            AbsActionBarView.super.setVisibility(0);
            this.f1209a = false;
        }
    }

    public AbsActionBarView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbsActionBarView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f1201a = new a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1202b = context;
        } else {
            this.f1202b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    public static int d(int i11, int i12, boolean z11) {
        return z11 ? i11 - i12 : i11 + i12;
    }

    public void animateToVisibility(int i11) {
        setupAnimatorToVisibility(i11, 200L).start();
    }

    public int c(View view, int i11, int i12, int i13) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i11, Integer.MIN_VALUE), i12);
        return Math.max(0, (i11 - view.getMeasuredWidth()) - i13);
    }

    public boolean canShowOverflowMenu() {
        return isOverflowReserved() && getVisibility() == 0;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter actionMenuPresenter = this.f1204d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.A();
        }
    }

    public int e(View view, int i11, int i12, int i13, boolean z11) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i14 = i12 + ((i13 - measuredHeight) / 2);
        if (z11) {
            view.layout(i11 - measuredWidth, i14, i11, measuredHeight + i14);
        } else {
            view.layout(i11, i14, i11 + measuredWidth, measuredHeight + i14);
        }
        return z11 ? -measuredWidth : measuredWidth;
    }

    public int getAnimatedVisibility() {
        return this.f1206g != null ? this.f1201a.f1210b : getVisibility();
    }

    public int getContentHeight() {
        return this.f1205f;
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.f1204d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.D();
        }
        return false;
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter actionMenuPresenter = this.f1204d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.F();
        }
        return false;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.f1204d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.G();
        }
        return false;
    }

    public boolean isOverflowReserved() {
        ActionMenuPresenter actionMenuPresenter = this.f1204d;
        return actionMenuPresenter != null && actionMenuPresenter.H();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f1204d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.I(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1208i = false;
        }
        if (!this.f1208i) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f1208i = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1208i = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1207h = false;
        }
        if (!this.f1207h) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f1207h = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1207h = false;
        }
        return true;
    }

    public void postShowOverflowMenu() {
        post(new Runnable() { // from class: androidx.appcompat.widget.AbsActionBarView.1
            @Override // java.lang.Runnable
            public void run() {
                AbsActionBarView.this.showOverflowMenu();
            }
        });
    }

    public void setContentHeight(int i11) {
        this.f1205f = i11;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
        if (i11 != getVisibility()) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f1206g;
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.cancel();
            }
            super.setVisibility(i11);
        }
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i11, long j11) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f1206g;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
        if (i11 != 0) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAlpha = ViewCompat.animate(this).alpha(0.0f);
            viewPropertyAnimatorCompatAlpha.setDuration(j11);
            viewPropertyAnimatorCompatAlpha.setListener(this.f1201a.a(viewPropertyAnimatorCompatAlpha, i11));
            return viewPropertyAnimatorCompatAlpha;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAlpha2 = ViewCompat.animate(this).alpha(1.0f);
        viewPropertyAnimatorCompatAlpha2.setDuration(j11);
        viewPropertyAnimatorCompatAlpha2.setListener(this.f1201a.a(viewPropertyAnimatorCompatAlpha2, i11));
        return viewPropertyAnimatorCompatAlpha2;
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.f1204d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.N();
        }
        return false;
    }
}
