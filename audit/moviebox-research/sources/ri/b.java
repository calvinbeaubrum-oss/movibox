package ri;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import ii.i;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b implements com.google.android.material.floatingactionbutton.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f75487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ExtendedFloatingActionButton f75488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<Animator.AnimatorListener> f75489c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ri.a f75490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public i f75491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public i f75492f;

    /* JADX INFO: compiled from: source.java */
    public class a extends Property<ExtendedFloatingActionButton, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(ExtendedFloatingActionButton extendedFloatingActionButton) {
            return Float.valueOf(ii.b.a(0.0f, 1.0f, (Color.alpha(extendedFloatingActionButton.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton.F.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.f75488b.F.getDefaultColor()))));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(ExtendedFloatingActionButton extendedFloatingActionButton, Float f11) {
            int colorForState = extendedFloatingActionButton.F.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.f75488b.F.getDefaultColor());
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(Color.argb((int) (ii.b.a(0.0f, Color.alpha(colorForState) / 255.0f, f11.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
            if (f11.floatValue() == 1.0f) {
                extendedFloatingActionButton.B(extendedFloatingActionButton.F);
            } else {
                extendedFloatingActionButton.B(colorStateListValueOf);
            }
        }
    }

    public b(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton, ri.a aVar) {
        this.f75488b = extendedFloatingActionButton;
        this.f75487a = extendedFloatingActionButton.getContext();
        this.f75490d = aVar;
    }

    @Override // com.google.android.material.floatingactionbutton.b
    @Nullable
    public i b() {
        return this.f75492f;
    }

    @Override // com.google.android.material.floatingactionbutton.b
    public final void d(@NonNull Animator.AnimatorListener animatorListener) {
        this.f75489c.remove(animatorListener);
    }

    @Override // com.google.android.material.floatingactionbutton.b
    @CallSuper
    public void e() {
        this.f75490d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.b
    public final void g(@NonNull Animator.AnimatorListener animatorListener) {
        this.f75489c.add(animatorListener);
    }

    @Override // com.google.android.material.floatingactionbutton.b
    @CallSuper
    public void h() {
        this.f75490d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.b
    public final void i(@Nullable i iVar) {
        this.f75492f = iVar;
    }

    @Override // com.google.android.material.floatingactionbutton.b
    public AnimatorSet j() {
        return n(o());
    }

    @Override // com.google.android.material.floatingactionbutton.b
    @NonNull
    public final List<Animator.AnimatorListener> k() {
        return this.f75489c;
    }

    @NonNull
    public AnimatorSet n(@NonNull i iVar) {
        ArrayList arrayList = new ArrayList();
        if (iVar.j("opacity")) {
            arrayList.add(iVar.f("opacity", this.f75488b, View.ALPHA));
        }
        if (iVar.j("scale")) {
            arrayList.add(iVar.f("scale", this.f75488b, View.SCALE_Y));
            arrayList.add(iVar.f("scale", this.f75488b, View.SCALE_X));
        }
        if (iVar.j("width")) {
            arrayList.add(iVar.f("width", this.f75488b, ExtendedFloatingActionButton.K));
        }
        if (iVar.j("height")) {
            arrayList.add(iVar.f("height", this.f75488b, ExtendedFloatingActionButton.L));
        }
        if (iVar.j("paddingStart")) {
            arrayList.add(iVar.f("paddingStart", this.f75488b, ExtendedFloatingActionButton.M));
        }
        if (iVar.j("paddingEnd")) {
            arrayList.add(iVar.f("paddingEnd", this.f75488b, ExtendedFloatingActionButton.N));
        }
        if (iVar.j("labelOpacity")) {
            arrayList.add(iVar.f("labelOpacity", this.f75488b, new a(Float.class, "LABEL_OPACITY_PROPERTY")));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ii.c.a(animatorSet, arrayList);
        return animatorSet;
    }

    public final i o() {
        i iVar = this.f75492f;
        if (iVar != null) {
            return iVar;
        }
        if (this.f75491e == null) {
            this.f75491e = i.d(this.f75487a, f());
        }
        return (i) androidx.core.util.i.g(this.f75491e);
    }

    @Override // com.google.android.material.floatingactionbutton.b
    @CallSuper
    public void onAnimationStart(Animator animator) {
        this.f75490d.c(animator);
    }
}
