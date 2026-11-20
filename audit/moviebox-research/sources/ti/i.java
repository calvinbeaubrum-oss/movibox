package ti;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$dimen;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class i extends ti.a<View> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f77220g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f77221h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f77222i;

    /* JADX INFO: compiled from: source.java */
    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f77223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f77224b;

        public a(boolean z11, int i11) {
            this.f77223a = z11;
            this.f77224b = i11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i.this.f77196b.setTranslationX(0.0f);
            i.this.k(0.0f, this.f77223a, this.f77224b);
        }
    }

    public i(@NonNull View view) {
        super(view);
        Resources resources = view.getResources();
        this.f77220g = resources.getDimension(R$dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
        this.f77221h = resources.getDimension(R$dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
        this.f77222i = resources.getDimension(R$dimen.m3_back_progress_side_container_max_scale_y_distance);
    }

    public void f() {
        if (super.b() == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f77196b, (Property<V, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.f77196b, (Property<V, Float>) View.SCALE_Y, 1.0f));
        V v11 = this.f77196b;
        if (v11 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v11;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i11), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setDuration(this.f77199e);
        animatorSet.start();
    }

    public final boolean g(int i11, int i12) {
        return (GravityCompat.getAbsoluteGravity(i11, ViewCompat.getLayoutDirection(this.f77196b)) & i12) == i12;
    }

    public void h(@NonNull androidx.activity.b bVar, int i11, @Nullable Animator.AnimatorListener animatorListener, @Nullable ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        boolean z11 = bVar.b() == 0;
        boolean zG = g(i11, 3);
        float width = (this.f77196b.getWidth() * this.f77196b.getScaleX()) + i(zG);
        V v11 = this.f77196b;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (zG) {
            width = -width;
        }
        fArr[0] = width;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(v11, (Property<V, Float>) property, fArr);
        if (animatorUpdateListener != null) {
            objectAnimatorOfFloat.addUpdateListener(animatorUpdateListener);
        }
        objectAnimatorOfFloat.setInterpolator(new q3.b());
        objectAnimatorOfFloat.setDuration(ii.b.c(this.f77197c, this.f77198d, bVar.a()));
        objectAnimatorOfFloat.addListener(new a(z11, i11));
        if (animatorListener != null) {
            objectAnimatorOfFloat.addListener(animatorListener);
        }
        objectAnimatorOfFloat.start();
    }

    public final int i(boolean z11) {
        ViewGroup.LayoutParams layoutParams = this.f77196b.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return z11 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
    }

    public void j(@NonNull androidx.activity.b bVar) {
        super.d(bVar);
    }

    public void k(float f11, boolean z11, int i11) {
        float fA = a(f11);
        boolean zG = g(i11, 3);
        boolean z12 = z11 == zG;
        int width = this.f77196b.getWidth();
        int height = this.f77196b.getHeight();
        float f12 = width;
        if (f12 > 0.0f) {
            float f13 = height;
            if (f13 <= 0.0f) {
                return;
            }
            float f14 = this.f77220g / f12;
            float f15 = this.f77221h / f12;
            float f16 = this.f77222i / f13;
            V v11 = this.f77196b;
            if (zG) {
                f12 = 0.0f;
            }
            v11.setPivotX(f12);
            if (!z12) {
                f15 = -f14;
            }
            float fA2 = ii.b.a(0.0f, f15, fA);
            float f17 = fA2 + 1.0f;
            this.f77196b.setScaleX(f17);
            float fA3 = 1.0f - ii.b.a(0.0f, f16, fA);
            this.f77196b.setScaleY(fA3);
            V v12 = this.f77196b;
            if (v12 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) v12;
                for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
                    View childAt = viewGroup.getChildAt(i12);
                    childAt.setPivotX(zG ? (width - childAt.getRight()) + childAt.getWidth() : -childAt.getLeft());
                    childAt.setPivotY(-childAt.getTop());
                    float f18 = z12 ? 1.0f - fA2 : 1.0f;
                    float f19 = fA3 != 0.0f ? (f17 / fA3) * f18 : 1.0f;
                    childAt.setScaleX(f18);
                    childAt.setScaleY(f19);
                }
            }
        }
    }

    public void l(@NonNull androidx.activity.b bVar, int i11) {
        if (super.e(bVar) == null) {
            return;
        }
        k(bVar.a(), bVar.b() == 0, i11);
    }
}
