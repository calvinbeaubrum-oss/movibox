package mr;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f71174a;

    public b(float f11) {
        this.f71174a = f11;
    }

    public final ViewPager2 a(@NonNull View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            return (ViewPager2) parent2;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f11) {
        ViewPager2 viewPager2A = a(view);
        float paddingLeft = viewPager2A.getPaddingLeft();
        float measuredWidth = f11 - (paddingLeft / ((viewPager2A.getMeasuredWidth() - paddingLeft) - viewPager2A.getPaddingRight()));
        float width = view.getWidth();
        float f12 = this.f71174a;
        float f13 = ((1.0f - f12) * width) / 2.0f;
        if (measuredWidth <= -1.0f) {
            view.setTranslationX(f13);
            view.setScaleX(this.f71174a);
            view.setScaleY(this.f71174a);
            return;
        }
        double d11 = measuredWidth;
        if (d11 > 1.0d) {
            view.setScaleX(f12);
            view.setScaleY(this.f71174a);
            view.setTranslationX(-f13);
            return;
        }
        float fAbs = (1.0f - f12) * Math.abs(1.0f - Math.abs(measuredWidth));
        float f14 = (-f13) * measuredWidth;
        if (d11 <= -0.5d) {
            view.setTranslationX(f14 + (Math.abs(Math.abs(measuredWidth) - 0.5f) / 0.5f));
        } else if (measuredWidth > 0.0f && d11 >= 0.5d) {
            view.setTranslationX(f14 - (Math.abs(Math.abs(measuredWidth) - 0.5f) / 0.5f));
        } else {
            view.setTranslationX(f14);
        }
        view.setScaleX(this.f71174a + fAbs);
        view.setScaleY(fAbs + this.f71174a);
    }
}
