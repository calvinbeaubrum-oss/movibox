package com.cloud.tmc.miniapp.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.fragment.app.Fragment;
import com.cloud.tmc.integration.model.AlertBeforeUnloadCache;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.R$drawable;
import com.cloud.tmc.miniapp.base.MiniAppBaseFragment;
import java.lang.reflect.Field;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class SwipeBackLayout extends FrameLayout {

    /* JADX INFO: renamed from: OooO, reason: collision with root package name */
    public Drawable f31870OooO;
    public float OooO00o;
    public ViewDragHelper OooO0O0;
    public float OooO0OO;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public float f31871OooO0Oo;

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public TmcFragment f31872OooO0o;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public View f31873OooO0o0;
    public Fragment OooO0oO;

    /* JADX INFO: renamed from: OooO0oo, reason: collision with root package name */
    public Drawable f31874OooO0oo;

    /* JADX INFO: renamed from: OooOO0, reason: collision with root package name */
    public final Rect f31875OooOO0;
    public int OooOO0O;

    /* JADX INFO: renamed from: OooOO0o, reason: collision with root package name */
    public boolean f31876OooOO0o;
    public float OooOOO;
    public int OooOOO0;
    public boolean OooOOOO;
    public boolean OooOOOo;
    public int OooOOo;
    public int OooOOo0;
    public float OooOOoo;
    public int OooOo0;
    public int OooOo00;
    public int OooOo0O;
    public final Context OooOo0o;

    /* JADX INFO: compiled from: source.java */
    public enum EdgeLevel {
        MAX,
        MIN,
        MED
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends ViewDragHelper.b {
        public a() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int a(@NonNull View view, int i11, int i12) {
            int i13 = SwipeBackLayout.this.OooOOO0;
            if ((i13 & 1) != 0) {
                return Math.min(view.getWidth(), Math.max(i11, 0));
            }
            if ((i13 & 2) != 0) {
                return Math.min(0, Math.max(i11, -view.getWidth()));
            }
            return 0;
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int d(@NonNull View view) {
            SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
            swipeBackLayout.f31872OooO0o.getClass();
            Fragment fragment = swipeBackLayout.OooO0oO;
            return (((fragment instanceof TmcFragment) && ((TmcFragment) fragment).h0() != null && ((TmcFragment) SwipeBackLayout.this.OooO0oO).h0().isTabPage() && SwipeBackLayout.this.f31872OooO0o.h0() != null && SwipeBackLayout.this.f31872OooO0o.h0().isTabPage()) || SwipeBackLayout.this.OooO0oO == null) ? 0 : 1;
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void h(int i11, int i12) {
            super.h(i11, i12);
            SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
            if ((swipeBackLayout.OooOO0O & i11) != 0) {
                swipeBackLayout.OooOOO0 = i11;
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void j(int i11) {
            super.j(i11);
            SwipeBackLayout.this.getClass();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void k(@NonNull View view, int i11, int i12, int i13, int i14) {
            View view2;
            View view3;
            AlertBeforeUnloadCache alertBeforeUnloadCache;
            super.k(view, i11, i12, i13, i14);
            SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
            int i15 = swipeBackLayout.OooOOO0;
            if ((i15 & 1) != 0) {
                swipeBackLayout.OooO0OO = Math.abs(i11 / (SwipeBackLayout.this.f31874OooO0oo.getIntrinsicWidth() + swipeBackLayout.f31873OooO0o0.getWidth()));
            } else if ((i15 & 2) != 0) {
                swipeBackLayout.OooO0OO = Math.abs(i11 / (SwipeBackLayout.this.f31870OooO.getIntrinsicWidth() + swipeBackLayout.f31873OooO0o0.getWidth()));
            }
            SwipeBackLayout swipeBackLayout2 = SwipeBackLayout.this;
            swipeBackLayout2.OooOOo0 = i11;
            swipeBackLayout2.OooOOo = i12;
            swipeBackLayout2.invalidate();
            SwipeBackLayout.this.getClass();
            SwipeBackLayout swipeBackLayout3 = SwipeBackLayout.this;
            float f11 = swipeBackLayout3.OooO0OO;
            if (f11 > 1.0f) {
                TmcFragment tmcFragment = swipeBackLayout3.f31872OooO0o;
                tmcFragment.getClass();
                if (swipeBackLayout3.OooOOOO || tmcFragment.isDetached()) {
                    return;
                }
                SwipeBackLayout.this.getClass();
                TmcFragment tmcFragment2 = SwipeBackLayout.this.f31872OooO0o;
                if ((tmcFragment2 instanceof MiniAppBaseFragment) && (tmcFragment2.getActivity() instanceof com.cloud.tmc.miniapp.ui.OooO0OO)) {
                    TmcLogger.b("[SwipeBackLayout]：MiniAppActivity.onKeyDown()");
                    com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = (com.cloud.tmc.miniapp.ui.OooO0OO) SwipeBackLayout.this.f31872OooO0o.getActivity();
                    TmcFragment mFragment = SwipeBackLayout.this.f31872OooO0o;
                    oooO0OO.getClass();
                    Intrinsics.g(mFragment, "mFragment");
                    Page pageH0 = mFragment.h0();
                    if (pageH0 == null || (alertBeforeUnloadCache = (AlertBeforeUnloadCache) pageH0.getData(AlertBeforeUnloadCache.class)) == null) {
                        return;
                    }
                    alertBeforeUnloadCache.setEnabled(false);
                    oooO0OO.G0();
                    return;
                }
                return;
            }
            if (f11 > 0.0f) {
                if (f11 < 1.0f) {
                    swipeBackLayout3.OooO00o();
                    Fragment fragment = SwipeBackLayout.this.OooO0oO;
                    if (fragment == null || (view2 = fragment.getView()) == null || view2.getVisibility() == 0) {
                        return;
                    }
                    view2.setVisibility(0);
                    TmcLogger.c("SwipeBackLayout", "preView set visible, mScrollPercent:" + SwipeBackLayout.this.OooO0OO);
                    return;
                }
                return;
            }
            Page pageH1 = swipeBackLayout3.f31872OooO0o.h0();
            if (pageH1 != null && pageH1.isHide()) {
                StringBuilder sbA = hd.j.a("page is hidden, mScrollPercent: ");
                sbA.append(SwipeBackLayout.this.OooO0OO);
                TmcLogger.c("SwipeBackLayout", sbA.toString());
                return;
            }
            SwipeBackLayout.this.OooO00o();
            Fragment fragment2 = SwipeBackLayout.this.OooO0oO;
            if (fragment2 == null || (view3 = fragment2.getView()) == null || view3.getVisibility() != 0) {
                return;
            }
            view3.setVisibility(8);
            TmcLogger.c("SwipeBackLayout", "preView set gone, mScrollPercent: " + SwipeBackLayout.this.OooO0OO);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x003b  */
        @Override // androidx.customview.widget.ViewDragHelper.b
        public void l(View view, float f11, float f12) {
            int intrinsicWidth;
            int width = view.getWidth();
            SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
            int i11 = swipeBackLayout.OooOOO0;
            if ((i11 & 1) != 0) {
                if (f11 > 0.0f || (f11 == 0.0f && swipeBackLayout.OooO0OO > swipeBackLayout.OooO00o)) {
                    intrinsicWidth = swipeBackLayout.f31874OooO0oo.getIntrinsicWidth() + width + 10;
                } else {
                    intrinsicWidth = 0;
                }
            } else if ((i11 & 2) == 0 || (f11 >= 0.0f && (f11 != 0.0f || swipeBackLayout.OooO0OO <= swipeBackLayout.OooO00o))) {
                intrinsicWidth = 0;
            } else {
                intrinsicWidth = -(swipeBackLayout.f31870OooO.getIntrinsicWidth() + width + 10);
            }
            SwipeBackLayout.this.OooO0O0.Q(intrinsicWidth, 0);
            SwipeBackLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public boolean m(@NonNull View view, int i11) {
            SwipeBackLayout swipeBackLayout = SwipeBackLayout.this;
            boolean zD = swipeBackLayout.OooO0O0.D(swipeBackLayout.OooOO0O, i11);
            if (zD) {
                if (SwipeBackLayout.this.OooO0O0.D(1, i11)) {
                    SwipeBackLayout.this.OooOOO0 = 1;
                } else if (SwipeBackLayout.this.OooO0O0.D(2, i11)) {
                    SwipeBackLayout.this.OooOOO0 = 2;
                }
                SwipeBackLayout.this.getClass();
            }
            return zD;
        }
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.OooO00o = 0.4f;
        this.f31875OooOO0 = new Rect();
        this.f31876OooOO0o = true;
        this.OooOOO = 0.33f;
        this.OooOOoo = 0.5f;
        this.OooOo00 = 0;
        this.OooOo0 = 0;
        this.OooOo0O = 0;
        this.OooOo0o = context;
        OooO0O0();
    }

    private void setContentView(View view) {
        this.f31873OooO0o0 = view;
    }

    public void OooO00o() {
        TmcFragment tmcFragment;
        Page pageH0;
        App app;
        TmcFragment tmcFragmentD;
        if (this.OooO0oO != null || (tmcFragment = this.f31872OooO0o) == null || (pageH0 = tmcFragment.h0()) == null || (app = pageH0.getApp()) == null) {
            return;
        }
        tb.b appContext = app.getAppContext();
        if (!(appContext instanceof com.cloud.tmc.integration.structure.app.b) || (tmcFragmentD = ((com.cloud.tmc.integration.structure.app.b) appContext).k().d(this.f31872OooO0o.h0())) == null || tmcFragmentD.getView() == null) {
            return;
        }
        this.OooO0oO = tmcFragmentD;
    }

    public void OooO00o(int i11, int i12) {
        Drawable drawable = z2.a.getDrawable(this.OooOo0o, i11);
        if ((i12 & 1) != 0) {
            this.f31874OooO0oo = drawable;
        } else if ((i12 & 2) != 0) {
            this.f31870OooO = drawable;
        }
        invalidate();
    }

    public final void OooO00o(int i11, EdgeLevel edgeLevel) {
        try {
            DisplayMetrics displayMetrics = this.OooOo0o.getResources().getDisplayMetrics();
            if (i11 >= 0) {
                this.OooOo00 = i11 + this.OooOo0;
            } else if (edgeLevel == EdgeLevel.MAX) {
                this.OooOo00 = displayMetrics.widthPixels;
            } else if (edgeLevel == EdgeLevel.MED) {
                this.OooOo00 = displayMetrics.widthPixels / 2;
            } else {
                this.OooOo00 = (int) ((displayMetrics.density * 20.0f) + 0.5f);
            }
            Field declaredField = this.OooO0O0.getClass().getDeclaredField("mEdgeSize");
            declaredField.setAccessible(true);
            declaredField.setInt(this.OooO0O0, this.OooOo00);
        } catch (IllegalAccessException e11) {
            e = e11;
            e.printStackTrace();
        } catch (NoSuchFieldException e12) {
            e = e12;
            e.printStackTrace();
        }
    }

    public final void OooO0O0() {
        this.OooO0O0 = ViewDragHelper.p(this, new a());
        OooO00o(R$drawable.shape_swipe_back_shadow, 1);
        setEdgeOrientation(1);
        DisplayMetrics displayMetrics = this.OooOo0o.getResources().getDisplayMetrics();
        float f11 = displayMetrics.density;
        this.OooOo00 = (int) ((20.0f * f11) + 0.5f);
        this.OooOo0 = (int) ((f11 * 25.0f) + 0.5f);
        this.OooOo0O = (int) (displayMetrics.heightPixels * 0.33f);
    }

    @Override // android.view.View
    public void computeScroll() {
        float f11 = 1.0f - this.OooO0OO;
        this.f31871OooO0Oo = f11;
        if (f11 >= 0.0f) {
            if (this.OooO0O0.n(true)) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
            Fragment fragment = this.OooO0oO;
            if (fragment == null || fragment.getView() == null) {
                return;
            }
            if (this.OooOOOO) {
                this.OooO0oO.getView().setX(0.0f);
            } else if (this.OooO0O0.w() != null) {
                int left = (int) ((this.OooO0O0.w().getLeft() - getWidth()) * this.OooOOO * this.f31871OooO0Oo);
                if (this.OooO0O0.w().getLeft() == 0) {
                    left = 0;
                }
                this.OooO0oO.getView().setX(Math.min(left, 0));
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j11) {
        boolean z11 = view == this.f31873OooO0o0;
        boolean zDrawChild = super.drawChild(canvas, view, j11);
        if (z11 && this.f31871OooO0Oo > 0.0f && this.OooO0O0.B() != 0) {
            Rect rect = this.f31875OooOO0;
            view.getHitRect(rect);
            int i11 = this.OooOOO0;
            if ((i11 & 1) != 0) {
                Drawable drawable = this.f31874OooO0oo;
                drawable.setBounds(rect.left - drawable.getIntrinsicWidth(), rect.top, rect.left, rect.bottom);
                this.f31874OooO0oo.draw(canvas);
            } else if ((i11 & 2) != 0) {
                Drawable drawable2 = this.f31870OooO;
                int i12 = rect.right;
                drawable2.setBounds(i12, rect.top, drawable2.getIntrinsicWidth() + i12, rect.bottom);
                this.f31870OooO.draw(canvas);
            }
            int i13 = ((int) ((this.f31871OooO0Oo * 153.0f) * this.OooOOoo)) << 24;
            int i14 = this.OooOOO0;
            if ((i14 & 1) != 0) {
                canvas.clipRect(0, 0, view.getLeft(), getHeight());
            } else if ((i14 & 2) != 0) {
                canvas.clipRect(view.getRight(), 0, getRight(), getHeight());
            }
            canvas.drawColor(i13);
        }
        return zDrawChild;
    }

    public ViewDragHelper getViewDragHelper() {
        return this.OooO0O0;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f31876OooOO0o) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        try {
            if (motionEvent.getActionMasked() == 0) {
                float x11 = motionEvent.getX();
                float y11 = motionEvent.getY();
                if (x11 >= this.OooOo0) {
                    if (x11 <= this.OooOo00) {
                        if (y11 > this.OooOo0O) {
                        }
                    }
                }
                return super.onInterceptTouchEvent(motionEvent);
            }
            return this.OooO0O0.R(motionEvent);
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        this.OooOOOo = true;
        View view = this.f31873OooO0o0;
        if (view != null) {
            int i15 = this.OooOOo0;
            view.layout(i15, this.OooOOo, view.getMeasuredWidth() + i15, this.f31873OooO0o0.getMeasuredHeight() + this.OooOOo);
        }
        this.OooOOOo = false;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f31876OooOO0o) {
            return super.onTouchEvent(motionEvent);
        }
        try {
            if (motionEvent.getActionMasked() == 0) {
                float x11 = motionEvent.getX();
                float y11 = motionEvent.getY();
                if (x11 >= this.OooOo0) {
                    if (x11 <= this.OooOo00) {
                        if (y11 > this.OooOo0O) {
                        }
                    }
                }
                return super.onTouchEvent(motionEvent);
            }
            this.OooO0O0.H(motionEvent);
            return true;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.OooOOOo) {
            return;
        }
        super.requestLayout();
    }

    public void setEdgeLevel(int i11) {
        OooO00o(i11, (EdgeLevel) null);
    }

    public void setEdgeLevel(EdgeLevel edgeLevel) {
        OooO00o(-1, edgeLevel);
    }

    public void setEdgeOrientation(int i11) {
        this.OooOO0O = i11;
        this.OooO0O0.O(i11);
        if (i11 == 2 || i11 == 3) {
            OooO00o(R$drawable.shape_swipe_back_shadow, 2);
        }
    }

    public void setEnableGesture(boolean z11) {
        this.f31876OooOO0o = z11;
    }

    public void setParallaxOffset(float f11) {
        this.OooOOO = f11;
    }

    public void setScrollThresHold(float f11) {
        if (f11 >= 1.0f || f11 <= 0.0f) {
            throw new IllegalArgumentException("Threshold value should be between 0 and 1.0");
        }
        this.OooO00o = f11;
    }

    public void setSwipeAlpha(float f11) {
        this.OooOOoo = f11;
    }
}
