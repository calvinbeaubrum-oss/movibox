package u0;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import java.util.LinkedList;
import p0.d;
import p0.h;
import p014OoooO0O.OooOOO0;
import xb.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements d, w0.a, ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f78104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f78105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f78106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f78107d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f78108f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f78109g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f78110h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f78111i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f78112j = new b();

    public a(@NonNull View view) {
        this.f78106c = view;
        this.f78105b = view;
        this.f78104a = view;
    }

    public ValueAnimator.AnimatorUpdateListener a(int i11) {
        View view = this.f78106c;
        if (view == null || i11 == 0) {
            return null;
        }
        if ((i11 >= 0 || !x0.b.c(view, 1)) && (i11 <= 0 || !x0.b.c(this.f78106c, -1))) {
            return null;
        }
        this.f78109g = i11;
        return this;
    }

    public View b(View view, PointF pointF, View view2) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (x0.b.f(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if (!(childAt instanceof ViewPager) && x0.b.b(childAt)) {
                        return childAt;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    View viewB = b(childAt, pointF, view2);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return viewB;
                }
            }
        }
        return view2;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003f  */
    public void c(int i11, int i12, int i13) {
        boolean z11;
        View viewFindViewById;
        View viewFindViewById2;
        if (i12 == -1 || (viewFindViewById2 = this.f78105b.findViewById(i12)) == null) {
            z11 = false;
        } else if (i11 > 0) {
            viewFindViewById2.setTranslationY(i11);
            z11 = true;
        } else {
            if (viewFindViewById2.getTranslationY() > 0.0f) {
                viewFindViewById2.setTranslationY(0.0f);
            }
            z11 = false;
        }
        if (i13 != -1 && (viewFindViewById = this.f78105b.findViewById(i13)) != null) {
            if (i11 < 0) {
                viewFindViewById.setTranslationY(i11);
            } else {
                if (viewFindViewById.getTranslationY() < 0.0f) {
                    viewFindViewById.setTranslationY(0.0f);
                }
                if (z11) {
                    this.f78105b.setTranslationY(i11);
                }
            }
            this.f78105b.setTranslationY(0.0f);
        } else if (z11) {
            this.f78105b.setTranslationY(0.0f);
        } else {
            this.f78105b.setTranslationY(i11);
        }
        View view = this.f78107d;
        if (view != null) {
            view.setTranslationY(Math.max(0, i11));
        }
        View view2 = this.f78108f;
        if (view2 != null) {
            view2.setTranslationY(Math.min(0, i11));
        }
    }

    public void d(h hVar, View view, View view2) {
        View view3 = this.f78104a;
        boolean zIsInEditMode = view3.isInEditMode();
        View view4 = null;
        while (true) {
            if (view4 != null && (!(view4 instanceof NestedScrollingParent) || (view4 instanceof NestedScrollingChild))) {
                break;
            }
            boolean z11 = view4 == null;
            LinkedList linkedList = new LinkedList();
            linkedList.add(view3);
            View view5 = null;
            while (linkedList.size() > 0 && view5 == null) {
                View view6 = (View) linkedList.poll();
                if (view6 != null) {
                    if ((z11 || view6 != view3) && x0.b.b(view6)) {
                        view5 = view6;
                    } else if (view6 instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view6;
                        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                            linkedList.add(viewGroup.getChildAt(i11));
                        }
                    }
                }
            }
            if (view5 != null) {
                view3 = view5;
            }
            if (view3 == view4) {
                break;
            }
            if (!zIsInEditMode) {
                try {
                    if (view3 instanceof CoordinatorLayout) {
                        OooOOO0.this.setNestedScrollingEnabled(false);
                        ViewGroup viewGroup2 = (ViewGroup) view3;
                        for (int childCount = viewGroup2.getChildCount() - 1; childCount >= 0; childCount--) {
                            View childAt = viewGroup2.getChildAt(childCount);
                            if (childAt instanceof AppBarLayout) {
                                ((AppBarLayout) childAt).addOnOffsetChangedListener((AppBarLayout.g) new x0.a(this));
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            view4 = view3;
        }
        if (view4 != null) {
            this.f78106c = view4;
        }
        if (view == null && view2 == null) {
            return;
        }
        this.f78107d = view;
        this.f78108f = view2;
        FrameLayout frameLayout = new FrameLayout(this.f78104a.getContext());
        OooOOO0.g gVar = (OooOOO0.g) hVar;
        int iIndexOfChild = OooOOO0.this.getLayout().indexOfChild(this.f78104a);
        OooOOO0.this.getLayout().removeView(this.f78104a);
        i.b(this.f78104a);
        frameLayout.addView(this.f78104a, 0, new ViewGroup.LayoutParams(-1, -1));
        ViewGroup.LayoutParams layoutParams = this.f78104a.getLayoutParams();
        i.b(frameLayout);
        OooOOO0.this.getLayout().addView(frameLayout, iIndexOfChild, layoutParams);
        this.f78104a = frameLayout;
        if (view != null) {
            view.setTag("fixed-top");
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            ViewGroup viewGroup3 = (ViewGroup) view.getParent();
            int iIndexOfChild2 = viewGroup3.indexOfChild(view);
            viewGroup3.removeView(view);
            layoutParams2.height = x0.b.i(view);
            viewGroup3.addView(new Space(this.f78104a.getContext()), iIndexOfChild2, layoutParams2);
            frameLayout.addView(view, 1, layoutParams2);
        }
        if (view2 != null) {
            view2.setTag("fixed-bottom");
            ViewGroup.LayoutParams layoutParams3 = view2.getLayoutParams();
            ViewGroup viewGroup4 = (ViewGroup) view2.getParent();
            int iIndexOfChild3 = viewGroup4.indexOfChild(view2);
            viewGroup4.removeView(view2);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(layoutParams3);
            layoutParams3.height = x0.b.i(view2);
            viewGroup4.addView(new Space(this.f78104a.getContext()), iIndexOfChild3, layoutParams3);
            layoutParams4.gravity = 80;
            frameLayout.addView(view2, 1, layoutParams4);
        }
    }

    public boolean e() {
        return this.f78111i && this.f78112j.a(this.f78104a);
    }

    public boolean f() {
        return this.f78110h && this.f78112j.b(this.f78104a);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            float scaleY = (iIntValue - this.f78109g) * this.f78106c.getScaleY();
            View view = this.f78106c;
            if (view instanceof AbsListView) {
                float f11 = x0.b.f79782b;
                ((AbsListView) view).scrollListBy((int) scaleY);
            } else {
                view.scrollBy(0, (int) scaleY);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        this.f78109g = iIntValue;
    }
}
