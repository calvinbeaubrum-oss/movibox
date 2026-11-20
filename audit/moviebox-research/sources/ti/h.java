package ti;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.RoundedCorner;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.material.R$dimen;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.f0;
import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class h extends ti.a<View> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f77212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f77213h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f77214i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public Rect f77215j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public Rect f77216k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public Integer f77217l;

    /* JADX INFO: compiled from: source.java */
    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f77218a;

        public a(View view) {
            this.f77218a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view = this.f77218a;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public h(@NonNull View view) {
        super(view);
        Resources resources = view.getResources();
        this.f77212g = resources.getDimension(R$dimen.m3_back_progress_main_container_min_edge_gap);
        this.f77213h = resources.getDimension(R$dimen.m3_back_progress_main_container_max_translation_y);
    }

    public static /* synthetic */ void q(ClippableRoundedCornerLayout clippableRoundedCornerLayout, ValueAnimator valueAnimator) {
        clippableRoundedCornerLayout.updateCornerRadius(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public void g(@Nullable View view) {
        if (super.b() == null) {
            return;
        }
        AnimatorSet animatorSetI = i(view);
        V v11 = this.f77196b;
        if (v11 instanceof ClippableRoundedCornerLayout) {
            animatorSetI.playTogether(h((ClippableRoundedCornerLayout) v11));
        }
        animatorSetI.setDuration(this.f77199e);
        animatorSetI.start();
        r();
    }

    @NonNull
    public final ValueAnimator h(final ClippableRoundedCornerLayout clippableRoundedCornerLayout) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(clippableRoundedCornerLayout.getCornerRadius(), k());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ti.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                h.q(clippableRoundedCornerLayout, valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    @NonNull
    public final AnimatorSet i(@Nullable View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f77196b, (Property<V, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.f77196b, (Property<V, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.f77196b, (Property<V, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(this.f77196b, (Property<V, Float>) View.TRANSLATION_Y, 0.0f));
        animatorSet.addListener(new a(view));
        return animatorSet;
    }

    public void j(long j11, @Nullable View view) {
        AnimatorSet animatorSetI = i(view);
        animatorSetI.setDuration(j11);
        animatorSetI.start();
        r();
    }

    public int k() {
        if (this.f77217l == null) {
            this.f77217l = Integer.valueOf(p() ? n() : 0);
        }
        return this.f77217l.intValue();
    }

    @Nullable
    public Rect l() {
        return this.f77216k;
    }

    @Nullable
    public Rect m() {
        return this.f77215j;
    }

    public final int n() {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 31 || (rootWindowInsets = this.f77196b.getRootWindowInsets()) == null) {
            return 0;
        }
        return Math.max(Math.max(o(rootWindowInsets, 0), o(rootWindowInsets, 1)), Math.max(o(rootWindowInsets, 3), o(rootWindowInsets, 2)));
    }

    @RequiresApi(VungleException.WEB_CRASH)
    public final int o(WindowInsets windowInsets, int i11) {
        RoundedCorner roundedCorner = windowInsets.getRoundedCorner(i11);
        if (roundedCorner != null) {
            return roundedCorner.getRadius();
        }
        return 0;
    }

    public final boolean p() {
        int[] iArr = new int[2];
        this.f77196b.getLocationOnScreen(iArr);
        return iArr[1] == 0;
    }

    public final void r() {
        this.f77214i = 0.0f;
        this.f77215j = null;
        this.f77216k = null;
    }

    public void s(float f11, @Nullable View view) {
        this.f77215j = f0.c(this.f77196b);
        if (view != null) {
            this.f77216k = f0.b(this.f77196b, view);
        }
        this.f77214i = f11;
    }

    public void t(@NonNull androidx.activity.b bVar, @Nullable View view) {
        super.d(bVar);
        s(bVar.c(), view);
    }

    public void u(float f11, boolean z11, float f12, float f13) {
        float fA = a(f11);
        float width = this.f77196b.getWidth();
        float height = this.f77196b.getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return;
        }
        float fA2 = ii.b.a(1.0f, 0.9f, fA);
        float fA3 = ii.b.a(0.0f, Math.max(0.0f, ((width - (0.9f * width)) / 2.0f) - this.f77212g), fA) * (z11 ? 1 : -1);
        float fMin = Math.min(Math.max(0.0f, ((height - (fA2 * height)) / 2.0f) - this.f77212g), this.f77213h);
        float f14 = f12 - this.f77214i;
        float fA4 = ii.b.a(0.0f, fMin, Math.abs(f14) / height) * Math.signum(f14);
        this.f77196b.setScaleX(fA2);
        this.f77196b.setScaleY(fA2);
        this.f77196b.setTranslationX(fA3);
        this.f77196b.setTranslationY(fA4);
        V v11 = this.f77196b;
        if (v11 instanceof ClippableRoundedCornerLayout) {
            ((ClippableRoundedCornerLayout) v11).updateCornerRadius(ii.b.a(k(), f13, fA));
        }
    }

    public void v(@NonNull androidx.activity.b bVar, @Nullable View view, float f11) {
        if (super.e(bVar) == null) {
            return;
        }
        if (view != null && view.getVisibility() != 4) {
            view.setVisibility(4);
        }
        u(bVar.a(), bVar.b() == 0, bVar.c(), f11);
    }
}
