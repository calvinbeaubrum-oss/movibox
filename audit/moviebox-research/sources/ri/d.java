package ri;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.material.R$color;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import yi.i;
import yi.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(21)
public class d extends com.google.android.material.floatingactionbutton.a {

    @Nullable
    public StateListAnimator O;

    /* JADX INFO: compiled from: source.java */
    public static class a extends i {
        public a(n nVar) {
            super(nVar);
        }

        @Override // yi.i, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    public d(FloatingActionButton floatingActionButton, xi.b bVar) {
        super(floatingActionButton, bVar);
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void A() {
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void C() {
        i0();
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void E(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            if (!this.f36867w.isEnabled()) {
                this.f36867w.setElevation(0.0f);
                this.f36867w.setTranslationZ(0.0f);
                return;
            }
            this.f36867w.setElevation(this.f36852h);
            if (this.f36867w.isPressed()) {
                this.f36867w.setTranslationZ(this.f36854j);
            } else if (this.f36867w.isFocused() || this.f36867w.isHovered()) {
                this.f36867w.setTranslationZ(this.f36853i);
            } else {
                this.f36867w.setTranslationZ(0.0f);
            }
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void F(float f11, float f12, float f13) {
        if (Build.VERSION.SDK_INT == 21) {
            this.f36867w.refreshDrawableState();
        } else if (this.f36867w.getStateListAnimator() == this.O) {
            StateListAnimator stateListAnimatorM0 = m0(f11, f12, f13);
            this.O = stateListAnimatorM0;
            this.f36867w.setStateListAnimator(stateListAnimatorM0);
        }
        if (c0()) {
            i0();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public boolean N() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void Y(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.f36847c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(wi.b.e(colorStateList));
        } else {
            super.Y(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public boolean c0() {
        return this.f36868x.c() || !e0();
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void g0() {
    }

    @NonNull
    public c l0(int i11, ColorStateList colorStateList) {
        Context context = this.f36867w.getContext();
        c cVar = new c((n) androidx.core.util.i.g(this.f36845a));
        cVar.e(z2.a.getColor(context, R$color.design_fab_stroke_top_outer_color), z2.a.getColor(context, R$color.design_fab_stroke_top_inner_color), z2.a.getColor(context, R$color.design_fab_stroke_end_inner_color), z2.a.getColor(context, R$color.design_fab_stroke_end_outer_color));
        cVar.d(i11);
        cVar.c(colorStateList);
        return cVar;
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public float m() {
        return this.f36867w.getElevation();
    }

    @NonNull
    public final StateListAnimator m0(float f11, float f12, float f13) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.I, n0(f11, f13));
        stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.J, n0(f11, f12));
        stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.K, n0(f11, f12));
        stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.L, n0(f11, f12));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.f36867w, "elevation", f11).setDuration(0L));
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 22 && i11 <= 24) {
            FloatingActionButton floatingActionButton = this.f36867w;
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
        }
        arrayList.add(ObjectAnimator.ofFloat(this.f36867w, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(com.google.android.material.floatingactionbutton.a.D);
        stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.M, animatorSet);
        stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.N, n0(0.0f, 0.0f));
        return stateListAnimator;
    }

    @NonNull
    public final Animator n0(float f11, float f12) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f36867w, "elevation", f11).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f36867w, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f12).setDuration(100L));
        animatorSet.setInterpolator(com.google.android.material.floatingactionbutton.a.D);
        return animatorSet;
    }

    @NonNull
    public i o0() {
        return new a((n) androidx.core.util.i.g(this.f36845a));
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void r(@NonNull Rect rect) {
        if (this.f36868x.c()) {
            super.r(rect);
        } else if (e0()) {
            rect.set(0, 0, 0, 0);
        } else {
            int sizeDimension = (this.f36855k - this.f36867w.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void x(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i11) {
        Drawable layerDrawable;
        i iVarO0 = o0();
        this.f36846b = iVarO0;
        iVarO0.setTintList(colorStateList);
        if (mode != null) {
            this.f36846b.setTintMode(mode);
        }
        this.f36846b.S(this.f36867w.getContext());
        if (i11 > 0) {
            this.f36848d = l0(i11, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{(Drawable) androidx.core.util.i.g(this.f36848d), (Drawable) androidx.core.util.i.g(this.f36846b)});
        } else {
            this.f36848d = null;
            layerDrawable = this.f36846b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(wi.b.e(colorStateList2), layerDrawable, null);
        this.f36847c = rippleDrawable;
        this.f36849e = rippleDrawable;
    }
}
