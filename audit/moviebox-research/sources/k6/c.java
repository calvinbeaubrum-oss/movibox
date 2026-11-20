package k6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends l0 {

    /* JADX INFO: compiled from: source.java */
    public static class a extends AnimatorListenerAdapter implements j.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f68316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f68317b = false;

        public a(View view) {
            this.f68316a = view;
        }

        @Override // k6.j.f
        public void a(@NonNull j jVar, boolean z11) {
        }

        @Override // k6.j.f
        public void b(@NonNull j jVar) {
        }

        @Override // k6.j.f
        public void c(@NonNull j jVar) {
            this.f68316a.setTag(R$id.transition_pause_alpha, Float.valueOf(this.f68316a.getVisibility() == 0 ? z.b(this.f68316a) : 0.0f));
        }

        @Override // k6.j.f
        public void d(@NonNull j jVar) {
        }

        @Override // k6.j.f
        public void e(@NonNull j jVar) {
        }

        @Override // k6.j.f
        public void f(@NonNull j jVar) {
            this.f68316a.setTag(R$id.transition_pause_alpha, null);
        }

        @Override // k6.j.f
        public /* synthetic */ void g(j jVar, boolean z11) {
            k.a(this, jVar, z11);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            z.e(this.f68316a, 1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NonNull Animator animator, boolean z11) {
            if (this.f68317b) {
                this.f68316a.setLayerType(0, null);
            }
            if (z11) {
                return;
            }
            z.e(this.f68316a, 1.0f);
            z.a(this.f68316a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f68316a.hasOverlappingRendering() && this.f68316a.getLayerType() == 0) {
                this.f68317b = true;
                this.f68316a.setLayerType(2, null);
            }
        }
    }

    public c() {
    }

    public c(int i11) {
        o0(i11);
    }

    public static float q0(w wVar, float f11) {
        Float f12;
        return (wVar == null || (f12 = (Float) wVar.f68416a.get("android:fade:transitionAlpha")) == null) ? f11 : f12.floatValue();
    }

    @Override // k6.l0, k6.j
    public void k(@NonNull w wVar) {
        super.k(wVar);
        Float fValueOf = (Float) wVar.f68417b.getTag(R$id.transition_pause_alpha);
        if (fValueOf == null) {
            fValueOf = wVar.f68417b.getVisibility() == 0 ? Float.valueOf(z.b(wVar.f68417b)) : Float.valueOf(0.0f);
        }
        wVar.f68416a.put("android:fade:transitionAlpha", fValueOf);
    }

    @Override // k6.l0
    @Nullable
    public Animator k0(@NonNull ViewGroup viewGroup, @NonNull View view, @Nullable w wVar, @Nullable w wVar2) {
        z.c(view);
        return p0(view, q0(wVar, 0.0f), 1.0f);
    }

    @Override // k6.l0
    @Nullable
    public Animator m0(@NonNull ViewGroup viewGroup, @NonNull View view, @Nullable w wVar, @Nullable w wVar2) {
        z.c(view);
        Animator animatorP0 = p0(view, q0(wVar, 1.0f), 0.0f);
        if (animatorP0 == null) {
            z.e(view, q0(wVar2, 1.0f));
        }
        return animatorP0;
    }

    public final Animator p0(View view, float f11, float f12) {
        if (f11 == f12) {
            return null;
        }
        z.e(view, f11);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, z.f68425b, f12);
        a aVar = new a(view);
        objectAnimatorOfFloat.addListener(aVar);
        A().a(aVar);
        return objectAnimatorOfFloat;
    }
}
