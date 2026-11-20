package mr;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f71175a;

    public c(float f11) {
        this.f71175a = f11;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f11) {
        int width = view.getWidth();
        view.setPivotY(view.getHeight() / 2);
        view.setPivotX(width / 2);
        if (f11 < -1.0f) {
            view.setScaleX(this.f71175a);
            view.setScaleY(this.f71175a);
            view.setPivotX(width);
            return;
        }
        if (f11 > 1.0f) {
            view.setPivotX(0.0f);
            view.setScaleX(this.f71175a);
            view.setScaleY(this.f71175a);
        } else {
            if (f11 < 0.0f) {
                float f12 = this.f71175a;
                float f13 = ((f11 + 1.0f) * (1.0f - f12)) + f12;
                view.setScaleX(f13);
                view.setScaleY(f13);
                view.setPivotX(width * (((-f11) * 0.5f) + 0.5f));
                return;
            }
            float f14 = 1.0f - f11;
            float f15 = this.f71175a;
            float f16 = ((1.0f - f15) * f14) + f15;
            view.setScaleX(f16);
            view.setScaleY(f16);
            view.setPivotX(width * f14 * 0.5f);
        }
    }
}
