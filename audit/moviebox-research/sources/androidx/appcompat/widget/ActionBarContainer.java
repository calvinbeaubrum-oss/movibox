package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f1213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f1214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f1215d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f1216f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f1217g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f1218h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1219i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1220j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1221k;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(21)
    public static class a {
        public static void a(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(new androidx.appcompat.widget.a(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBar);
        this.f1216f = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ActionBar_background);
        this.f1217g = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundStacked);
        this.f1221k = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_height, -1);
        boolean z11 = true;
        if (getId() == R$id.split_action_bar) {
            this.f1219i = true;
            this.f1218h = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundSplit);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f1219i ? this.f1216f != null || this.f1217g != null : this.f1218h != null) {
            z11 = false;
        }
        setWillNotDraw(z11);
    }

    public final int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1216f;
        if (drawable != null && drawable.isStateful()) {
            this.f1216f.setState(getDrawableState());
        }
        Drawable drawable2 = this.f1217g;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f1217g.setState(getDrawableState());
        }
        Drawable drawable3 = this.f1218h;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f1218h.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f1213b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1216f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1217g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f1218h;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1214c = findViewById(R$id.action_bar);
        this.f1215d = findViewById(R$id.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1212a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        Drawable drawable;
        super.onLayout(z11, i11, i12, i13, i14);
        View view = this.f1213b;
        boolean z12 = true;
        boolean z13 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            int measuredHeight2 = measuredHeight - view.getMeasuredHeight();
            int i15 = layoutParams.bottomMargin;
            view.layout(i11, measuredHeight2 - i15, i13, measuredHeight - i15);
        }
        if (this.f1219i) {
            Drawable drawable2 = this.f1218h;
            if (drawable2 == null) {
                return;
            } else {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        } else {
            if (this.f1216f == null) {
                z12 = false;
            } else if (this.f1214c.getVisibility() == 0) {
                this.f1216f.setBounds(this.f1214c.getLeft(), this.f1214c.getTop(), this.f1214c.getRight(), this.f1214c.getBottom());
            } else {
                View view2 = this.f1215d;
                if (view2 == null || view2.getVisibility() != 0) {
                    this.f1216f.setBounds(0, 0, 0, 0);
                } else {
                    this.f1216f.setBounds(this.f1215d.getLeft(), this.f1215d.getTop(), this.f1215d.getRight(), this.f1215d.getBottom());
                }
            }
            this.f1220j = z13;
            if (z13 && (drawable = this.f1217g) != null) {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else if (!z12) {
                return;
            }
        }
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        int iA;
        int i13;
        if (this.f1214c == null && View.MeasureSpec.getMode(i12) == Integer.MIN_VALUE && (i13 = this.f1221k) >= 0) {
            i12 = View.MeasureSpec.makeMeasureSpec(Math.min(i13, View.MeasureSpec.getSize(i12)), Integer.MIN_VALUE);
        }
        super.onMeasure(i11, i12);
        if (this.f1214c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i12);
        View view = this.f1213b;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        if (b(this.f1214c)) {
            iA = !b(this.f1215d) ? a(this.f1215d) : 0;
        } else {
            iA = a(this.f1214c);
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(iA + a(this.f1213b), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i12) : Api.BaseClientBuilder.API_PRIORITY_OTHER));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f1216f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f1216f);
        }
        this.f1216f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f1214c;
            if (view != null) {
                this.f1216f.setBounds(view.getLeft(), this.f1214c.getTop(), this.f1214c.getRight(), this.f1214c.getBottom());
            }
        }
        boolean z11 = false;
        if (!this.f1219i ? !(this.f1216f != null || this.f1217g != null) : this.f1218h == null) {
            z11 = true;
        }
        setWillNotDraw(z11);
        invalidate();
        a.a(this);
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1218h;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1218h);
        }
        this.f1218h = drawable;
        boolean z11 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1219i && (drawable2 = this.f1218h) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f1219i ? !(this.f1216f != null || this.f1217g != null) : this.f1218h == null) {
            z11 = true;
        }
        setWillNotDraw(z11);
        invalidate();
        a.a(this);
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1217g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1217g);
        }
        this.f1217g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1220j && (drawable2 = this.f1217g) != null) {
                drawable2.setBounds(this.f1213b.getLeft(), this.f1213b.getTop(), this.f1213b.getRight(), this.f1213b.getBottom());
            }
        }
        boolean z11 = false;
        if (!this.f1219i ? !(this.f1216f != null || this.f1217g != null) : this.f1218h == null) {
            z11 = true;
        }
        setWillNotDraw(z11);
        invalidate();
        a.a(this);
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f1213b;
        if (view != null) {
            removeView(view);
        }
        this.f1213b = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z11) {
        this.f1212a = z11;
        setDescendantFocusability(z11 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
        super.setVisibility(i11);
        boolean z11 = i11 == 0;
        Drawable drawable = this.f1216f;
        if (drawable != null) {
            drawable.setVisible(z11, false);
        }
        Drawable drawable2 = this.f1217g;
        if (drawable2 != null) {
            drawable2.setVisible(z11, false);
        }
        Drawable drawable3 = this.f1218h;
        if (drawable3 != null) {
            drawable3.setVisible(z11, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i11) {
        if (i11 != 0) {
            return super.startActionModeForChild(view, callback, i11);
        }
        return null;
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return (drawable == this.f1216f && !this.f1219i) || (drawable == this.f1217g && this.f1220j) || ((drawable == this.f1218h && this.f1219i) || super.verifyDrawable(drawable));
    }
}
