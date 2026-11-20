package x0;

import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ScrollingView;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements Interpolator {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static float f79782b = Resources.getSystem().getDisplayMetrics().density;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f79783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float f79784d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f79785a;

    static {
        float fG = 1.0f / g(1.0f);
        f79783c = fG;
        f79784d = 1.0f - (g(1.0f) * fG);
    }

    public b(int i11) {
        this.f79785a = i11;
    }

    public static int a(float f11) {
        return (int) ((f11 * f79782b) + 0.5f);
    }

    public static boolean b(View view) {
        return h(view) || (view instanceof ViewPager) || (view instanceof NestedScrollingParent);
    }

    public static boolean c(@NonNull View view, int i11) {
        return view.canScrollVertically(i11);
    }

    public static boolean d(@NonNull View view, PointF pointF) {
        if (c(view, -1) && view.getVisibility() == 0) {
            return false;
        }
        if (!(view instanceof ViewGroup) || pointF == null) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        PointF pointF2 = new PointF();
        for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount - 1);
            if (f(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                if ("fixed".equals(childAt.getTag()) || "fixed-bottom".equals(childAt.getTag())) {
                    return false;
                }
                pointF.offset(pointF2.x, pointF2.y);
                boolean zD = d(childAt, pointF);
                pointF.offset(-pointF2.x, -pointF2.y);
                return zD;
            }
        }
        return true;
    }

    public static boolean e(@NonNull View view, PointF pointF, boolean z11) {
        if (c(view, 1) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && pointF != null && !h(view)) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (f(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if ("fixed".equals(childAt.getTag()) || "fixed-top".equals(childAt.getTag())) {
                        return false;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    boolean zE = e(childAt, pointF, z11);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return zE;
                }
            }
        }
        return z11 || c(view, -1);
    }

    public static boolean f(@NonNull View view, @NonNull View view2, float f11, float f12, PointF pointF) {
        if (view2.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f11, f12};
        fArr[0] = (view.getScrollX() - view2.getLeft()) + f11;
        float scrollY = fArr[1] + (view.getScrollY() - view2.getTop());
        fArr[1] = scrollY;
        float f13 = fArr[0];
        boolean z11 = f13 >= 0.0f && scrollY >= 0.0f && f13 < ((float) view2.getWidth()) && fArr[1] < ((float) view2.getHeight());
        if (z11) {
            pointF.set(fArr[0] - f11, fArr[1] - f12);
        }
        return z11;
    }

    public static float g(float f11) {
        float f12 = f11 * 8.0f;
        return f12 < 1.0f ? f12 - (1.0f - ((float) Math.exp(-f12))) : 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - f12))) * 0.63212055f);
    }

    public static boolean h(View view) {
        return (view instanceof AbsListView) || (view instanceof ScrollView) || (view instanceof ScrollingView) || (view instanceof WebView) || (view instanceof NestedScrollingChild);
    }

    public static int i(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i11 = layoutParams.height;
        view.measure(childMeasureSpec, i11 > 0 ? View.MeasureSpec.makeMeasureSpec(i11, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredHeight();
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f11) {
        if (this.f79785a == 1) {
            float f12 = 1.0f - f11;
            return 1.0f - (f12 * f12);
        }
        float fG = g(f11) * f79783c;
        return fG > 0.0f ? fG + f79784d : fG;
    }
}
