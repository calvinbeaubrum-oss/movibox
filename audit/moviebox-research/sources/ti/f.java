package ti;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$dimen;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class f extends ti.a<View> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f77208g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f77209h;

    /* JADX INFO: compiled from: source.java */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.f77196b.setTranslationY(0.0f);
            f.this.k(0.0f);
        }
    }

    public f(@NonNull View view) {
        super(view);
        Resources resources = view.getResources();
        this.f77208g = resources.getDimension(R$dimen.m3_back_progress_bottom_container_max_scale_x_distance);
        this.f77209h = resources.getDimension(R$dimen.m3_back_progress_bottom_container_max_scale_y_distance);
    }

    public void f() {
        if (super.b() == null) {
            return;
        }
        Animator animatorG = g();
        animatorG.setDuration(this.f77199e);
        animatorG.start();
    }

    public final Animator g() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f77196b, (Property<V, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.f77196b, (Property<V, Float>) View.SCALE_Y, 1.0f));
        V v11 = this.f77196b;
        if (v11 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v11;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i11), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setInterpolator(new q3.b());
        return animatorSet;
    }

    public void h(@NonNull androidx.activity.b bVar, @Nullable Animator.AnimatorListener animatorListener) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f77196b, (Property<V, Float>) View.TRANSLATION_Y, this.f77196b.getHeight() * this.f77196b.getScaleY());
        objectAnimatorOfFloat.setInterpolator(new q3.b());
        objectAnimatorOfFloat.setDuration(ii.b.c(this.f77197c, this.f77198d, bVar.a()));
        objectAnimatorOfFloat.addListener(new a());
        if (animatorListener != null) {
            objectAnimatorOfFloat.addListener(animatorListener);
        }
        objectAnimatorOfFloat.start();
    }

    public void i(@NonNull androidx.activity.b bVar, @Nullable Animator.AnimatorListener animatorListener) {
        Animator animatorG = g();
        animatorG.setDuration(ii.b.c(this.f77197c, this.f77198d, bVar.a()));
        if (animatorListener != null) {
            animatorG.addListener(animatorListener);
        }
        animatorG.start();
    }

    public void j(@NonNull androidx.activity.b bVar) {
        super.d(bVar);
    }

    public void k(float f11) {
        float fA = a(f11);
        float width = this.f77196b.getWidth();
        float height = this.f77196b.getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return;
        }
        float f12 = this.f77208g / width;
        float f13 = this.f77209h / height;
        float fA2 = 1.0f - ii.b.a(0.0f, f12, fA);
        float fA3 = 1.0f - ii.b.a(0.0f, f13, fA);
        this.f77196b.setScaleX(fA2);
        this.f77196b.setPivotY(height);
        this.f77196b.setScaleY(fA3);
        V v11 = this.f77196b;
        if (v11 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v11;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                View childAt = viewGroup.getChildAt(i11);
                childAt.setPivotY(-childAt.getTop());
                childAt.setScaleY(fA3 != 0.0f ? fA2 / fA3 : 1.0f);
            }
        }
    }

    public void l(@NonNull androidx.activity.b bVar) {
        if (super.e(bVar) == null) {
            return;
        }
        k(bVar.a());
    }
}
