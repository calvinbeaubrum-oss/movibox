package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$integer;
import com.google.android.material.internal.w;
import java.util.ArrayList;
import java.util.Iterator;
import yi.n;
import yi.q;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {
    public static final TimeInterpolator D = ii.b.f67203c;
    public static final int E = R$attr.motionDurationLong2;
    public static final int F = R$attr.motionEasingEmphasizedInterpolator;
    public static final int G = R$attr.motionDurationMedium1;
    public static final int H = R$attr.motionEasingEmphasizedAccelerateInterpolator;
    public static final int[] I = {R.attr.state_pressed, R.attr.state_enabled};
    public static final int[] J = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    public static final int[] K = {R.attr.state_focused, R.attr.state_enabled};
    public static final int[] L = {R.attr.state_hovered, R.attr.state_enabled};
    public static final int[] M = {R.attr.state_enabled};
    public static final int[] N = new int[0];

    @Nullable
    public ViewTreeObserver.OnPreDrawListener C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public n f36845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public yi.i f36846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public Drawable f36847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public ri.c f36848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public Drawable f36849e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f36850f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f36852h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f36853i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f36854j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f36855k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final w f36856l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public Animator f36857m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public ii.i f36858n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public ii.i f36859o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f36860p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f36862r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ArrayList<Animator.AnimatorListener> f36864t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ArrayList<Animator.AnimatorListener> f36865u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ArrayList<j> f36866v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final FloatingActionButton f36867w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final xi.b f36868x;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f36851g = true;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f36861q = 1.0f;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f36863s = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Rect f36869y = new Rect();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final RectF f36870z = new RectF();
    public final RectF A = new RectF();
    public final Matrix B = new Matrix();

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0383a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f36871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f36872b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k f36873c;

        public C0383a(boolean z11, k kVar) {
            this.f36872b = z11;
            this.f36873c = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f36871a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f36863s = 0;
            a.this.f36857m = null;
            if (this.f36871a) {
                return;
            }
            FloatingActionButton floatingActionButton = a.this.f36867w;
            boolean z11 = this.f36872b;
            floatingActionButton.internalSetVisibility(z11 ? 8 : 4, z11);
            k kVar = this.f36873c;
            if (kVar != null) {
                kVar.b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f36867w.internalSetVisibility(0, this.f36872b);
            a.this.f36863s = 1;
            a.this.f36857m = animator;
            this.f36871a = false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f36875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f36876b;

        public b(boolean z11, k kVar) {
            this.f36875a = z11;
            this.f36876b = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f36863s = 0;
            a.this.f36857m = null;
            k kVar = this.f36876b;
            if (kVar != null) {
                kVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f36867w.internalSetVisibility(0, this.f36875a);
            a.this.f36863s = 2;
            a.this.f36857m = animator;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends ii.h {
        public c() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f11, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
            a.this.f36861q = f11;
            return super.evaluate(f11, matrix, matrix2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f36879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f36880b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f36881c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f36882d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ float f36883f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ float f36884g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ float f36885h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Matrix f36886i;

        public d(float f11, float f12, float f13, float f14, float f15, float f16, float f17, Matrix matrix) {
            this.f36879a = f11;
            this.f36880b = f12;
            this.f36881c = f13;
            this.f36882d = f14;
            this.f36883f = f15;
            this.f36884g = f16;
            this.f36885h = f17;
            this.f36886i = matrix;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.f36867w.setAlpha(ii.b.b(this.f36879a, this.f36880b, 0.0f, 0.2f, fFloatValue));
            a.this.f36867w.setScaleX(ii.b.a(this.f36881c, this.f36882d, fFloatValue));
            a.this.f36867w.setScaleY(ii.b.a(this.f36883f, this.f36882d, fFloatValue));
            a.this.f36861q = ii.b.a(this.f36884g, this.f36885h, fFloatValue);
            a.this.h(ii.b.a(this.f36884g, this.f36885h, fFloatValue), this.f36886i);
            a.this.f36867w.setImageMatrix(this.f36886i);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements TypeEvaluator<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FloatEvaluator f36888a = new FloatEvaluator();

        public e() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float evaluate(float f11, Float f12, Float f13) {
            float fFloatValue = this.f36888a.evaluate(f11, (Number) f12, (Number) f13).floatValue();
            if (fFloatValue < 0.1f) {
                fFloatValue = 0.0f;
            }
            return Float.valueOf(fFloatValue);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements ViewTreeObserver.OnPreDrawListener {
        public f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a.this.H();
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g extends m {
        public g() {
            super(a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.a.m
        public float a() {
            return 0.0f;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h extends m {
        public h() {
            super(a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.a.m
        public float a() {
            a aVar = a.this;
            return aVar.f36852h + aVar.f36853i;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i extends m {
        public i() {
            super(a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.a.m
        public float a() {
            a aVar = a.this;
            return aVar.f36852h + aVar.f36854j;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface j {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: source.java */
    public interface k {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: source.java */
    public class l extends m {
        public l() {
            super(a.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.a.m
        public float a() {
            return a.this.f36852h;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public abstract class m extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f36895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f36896b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f36897c;

        public m() {
        }

        public /* synthetic */ m(a aVar, C0383a c0383a) {
            this();
        }

        public abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.j0((int) this.f36897c);
            this.f36895a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            if (!this.f36895a) {
                yi.i iVar = a.this.f36846b;
                this.f36896b = iVar == null ? 0.0f : iVar.y();
                this.f36897c = a();
                this.f36895a = true;
            }
            a aVar = a.this;
            float f11 = this.f36896b;
            aVar.j0((int) (f11 + ((this.f36897c - f11) * valueAnimator.getAnimatedFraction())));
        }
    }

    public a(FloatingActionButton floatingActionButton, xi.b bVar) {
        this.f36867w = floatingActionButton;
        this.f36868x = bVar;
        w wVar = new w();
        this.f36856l = wVar;
        wVar.a(I, k(new i()));
        wVar.a(J, k(new h()));
        wVar.a(K, k(new h()));
        wVar.a(L, k(new h()));
        wVar.a(M, k(new l()));
        wVar.a(N, k(new g()));
        this.f36860p = floatingActionButton.getRotation();
    }

    public void A() {
        throw null;
    }

    public void B() {
        yi.i iVar = this.f36846b;
        if (iVar != null) {
            yi.j.f(this.f36867w, iVar);
        }
        if (N()) {
            this.f36867w.getViewTreeObserver().addOnPreDrawListener(q());
        }
    }

    public void C() {
        throw null;
    }

    public void D() {
        ViewTreeObserver viewTreeObserver = this.f36867w.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.C;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.C = null;
        }
    }

    public void E(int[] iArr) {
        throw null;
    }

    public void F(float f11, float f12, float f13) {
        throw null;
    }

    public void G(@NonNull Rect rect) {
        androidx.core.util.i.h(this.f36849e, "Didn't initialize content background");
        if (!c0()) {
            this.f36868x.b(this.f36849e);
        } else {
            this.f36868x.b(new InsetDrawable(this.f36849e, rect.left, rect.top, rect.right, rect.bottom));
        }
    }

    public void H() {
        float rotation = this.f36867w.getRotation();
        if (this.f36860p != rotation) {
            this.f36860p = rotation;
            g0();
        }
    }

    public void I() {
        ArrayList<j> arrayList = this.f36866v;
        if (arrayList != null) {
            Iterator<j> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    public void J() {
        ArrayList<j> arrayList = this.f36866v;
        if (arrayList != null) {
            Iterator<j> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public void K(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.f36865u;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public void L(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.f36864t;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public void M(@NonNull j jVar) {
        ArrayList<j> arrayList = this.f36866v;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(jVar);
    }

    public boolean N() {
        throw null;
    }

    public void O(@Nullable ColorStateList colorStateList) {
        yi.i iVar = this.f36846b;
        if (iVar != null) {
            iVar.setTintList(colorStateList);
        }
        ri.c cVar = this.f36848d;
        if (cVar != null) {
            cVar.c(colorStateList);
        }
    }

    public void P(@Nullable PorterDuff.Mode mode) {
        yi.i iVar = this.f36846b;
        if (iVar != null) {
            iVar.setTintMode(mode);
        }
    }

    public final void Q(float f11) {
        if (this.f36852h != f11) {
            this.f36852h = f11;
            F(f11, this.f36853i, this.f36854j);
        }
    }

    public void R(boolean z11) {
        this.f36850f = z11;
    }

    public final void S(@Nullable ii.i iVar) {
        this.f36859o = iVar;
    }

    public final void T(float f11) {
        if (this.f36853i != f11) {
            this.f36853i = f11;
            F(this.f36852h, f11, this.f36854j);
        }
    }

    public final void U(float f11) {
        this.f36861q = f11;
        Matrix matrix = this.B;
        h(f11, matrix);
        this.f36867w.setImageMatrix(matrix);
    }

    public final void V(int i11) {
        if (this.f36862r != i11) {
            this.f36862r = i11;
            h0();
        }
    }

    public void W(int i11) {
        this.f36855k = i11;
    }

    public final void X(float f11) {
        if (this.f36854j != f11) {
            this.f36854j = f11;
            F(this.f36852h, this.f36853i, f11);
        }
    }

    public void Y(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.f36847c;
        if (drawable != null) {
            d3.a.o(drawable, wi.b.e(colorStateList));
        }
    }

    public void Z(boolean z11) {
        this.f36851g = z11;
        i0();
    }

    public final void a0(@NonNull n nVar) {
        this.f36845a = nVar;
        yi.i iVar = this.f36846b;
        if (iVar != null) {
            iVar.setShapeAppearanceModel(nVar);
        }
        Object obj = this.f36847c;
        if (obj instanceof q) {
            ((q) obj).setShapeAppearanceModel(nVar);
        }
        ri.c cVar = this.f36848d;
        if (cVar != null) {
            cVar.f(nVar);
        }
    }

    public final void b0(@Nullable ii.i iVar) {
        this.f36858n = iVar;
    }

    public boolean c0() {
        throw null;
    }

    public final boolean d0() {
        return ViewCompat.isLaidOut(this.f36867w) && !this.f36867w.isInEditMode();
    }

    public void e(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.f36865u == null) {
            this.f36865u = new ArrayList<>();
        }
        this.f36865u.add(animatorListener);
    }

    public final boolean e0() {
        return !this.f36850f || this.f36867w.getSizeDimension() >= this.f36855k;
    }

    public void f(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.f36864t == null) {
            this.f36864t = new ArrayList<>();
        }
        this.f36864t.add(animatorListener);
    }

    public void f0(@Nullable k kVar, boolean z11) {
        if (z()) {
            return;
        }
        Animator animator = this.f36857m;
        if (animator != null) {
            animator.cancel();
        }
        boolean z12 = this.f36858n == null;
        if (!d0()) {
            this.f36867w.internalSetVisibility(0, z11);
            this.f36867w.setAlpha(1.0f);
            this.f36867w.setScaleY(1.0f);
            this.f36867w.setScaleX(1.0f);
            U(1.0f);
            if (kVar != null) {
                kVar.a();
                return;
            }
            return;
        }
        if (this.f36867w.getVisibility() != 0) {
            this.f36867w.setAlpha(0.0f);
            this.f36867w.setScaleY(z12 ? 0.4f : 0.0f);
            this.f36867w.setScaleX(z12 ? 0.4f : 0.0f);
            U(z12 ? 0.4f : 0.0f);
        }
        ii.i iVar = this.f36858n;
        AnimatorSet animatorSetI = iVar != null ? i(iVar, 1.0f, 1.0f, 1.0f) : j(1.0f, 1.0f, 1.0f, E, F);
        animatorSetI.addListener(new b(z11, kVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.f36864t;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetI.addListener(it.next());
            }
        }
        animatorSetI.start();
    }

    public void g(@NonNull j jVar) {
        if (this.f36866v == null) {
            this.f36866v = new ArrayList<>();
        }
        this.f36866v.add(jVar);
    }

    public void g0() {
        throw null;
    }

    public final void h(float f11, @NonNull Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.f36867w.getDrawable();
        if (drawable == null || this.f36862r == 0) {
            return;
        }
        RectF rectF = this.f36870z;
        RectF rectF2 = this.A;
        rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        int i11 = this.f36862r;
        rectF2.set(0.0f, 0.0f, i11, i11);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i12 = this.f36862r;
        matrix.postScale(f11, f11, i12 / 2.0f, i12 / 2.0f);
    }

    public final void h0() {
        U(this.f36861q);
    }

    @NonNull
    public final AnimatorSet i(@NonNull ii.i iVar, float f11, float f12, float f13) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f36867w, (Property<FloatingActionButton, Float>) View.ALPHA, f11);
        iVar.h("opacity").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f36867w, (Property<FloatingActionButton, Float>) View.SCALE_X, f12);
        iVar.h("scale").a(objectAnimatorOfFloat2);
        k0(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f36867w, (Property<FloatingActionButton, Float>) View.SCALE_Y, f12);
        iVar.h("scale").a(objectAnimatorOfFloat3);
        k0(objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat3);
        h(f13, this.B);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.f36867w, new ii.g(), new c(), new Matrix(this.B));
        iVar.h("iconScale").a(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        ii.c.a(animatorSet, arrayList);
        return animatorSet;
    }

    public final void i0() {
        Rect rect = this.f36869y;
        r(rect);
        G(rect);
        this.f36868x.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final AnimatorSet j(float f11, float f12, float f13, int i11, int i12) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new d(this.f36867w.getAlpha(), f11, this.f36867w.getScaleX(), f12, this.f36867w.getScaleY(), this.f36861q, f13, new Matrix(this.B)));
        arrayList.add(valueAnimatorOfFloat);
        ii.c.a(animatorSet, arrayList);
        animatorSet.setDuration(ti.j.f(this.f36867w.getContext(), i11, this.f36867w.getContext().getResources().getInteger(R$integer.material_motion_duration_long_1)));
        animatorSet.setInterpolator(ti.j.g(this.f36867w.getContext(), i12, ii.b.f67202b));
        return animatorSet;
    }

    public void j0(float f11) {
        yi.i iVar = this.f36846b;
        if (iVar != null) {
            iVar.c0(f11);
        }
    }

    @NonNull
    public final ValueAnimator k(@NonNull m mVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(D);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(mVar);
        valueAnimator.addUpdateListener(mVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public final void k0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new e());
    }

    @Nullable
    public final Drawable l() {
        return this.f36849e;
    }

    public float m() {
        throw null;
    }

    public boolean n() {
        return this.f36850f;
    }

    @Nullable
    public final ii.i o() {
        return this.f36859o;
    }

    public float p() {
        return this.f36853i;
    }

    @NonNull
    public final ViewTreeObserver.OnPreDrawListener q() {
        if (this.C == null) {
            this.C = new f();
        }
        return this.C;
    }

    public void r(@NonNull Rect rect) {
        int iV = v();
        float fM = this.f36851g ? m() + this.f36854j : 0.0f;
        int iMax = Math.max(iV, (int) Math.ceil(fM));
        int iMax2 = Math.max(iV, (int) Math.ceil(fM * 1.5f));
        rect.set(iMax, iMax2, iMax, iMax2);
    }

    public float s() {
        return this.f36854j;
    }

    @Nullable
    public final n t() {
        return this.f36845a;
    }

    @Nullable
    public final ii.i u() {
        return this.f36858n;
    }

    public int v() {
        if (this.f36850f) {
            return Math.max((this.f36855k - this.f36867w.getSizeDimension()) / 2, 0);
        }
        return 0;
    }

    public void w(@Nullable k kVar, boolean z11) {
        if (y()) {
            return;
        }
        Animator animator = this.f36857m;
        if (animator != null) {
            animator.cancel();
        }
        if (!d0()) {
            this.f36867w.internalSetVisibility(z11 ? 8 : 4, z11);
            if (kVar != null) {
                kVar.b();
                return;
            }
            return;
        }
        ii.i iVar = this.f36859o;
        AnimatorSet animatorSetI = iVar != null ? i(iVar, 0.0f, 0.0f, 0.0f) : j(0.0f, 0.4f, 0.4f, G, H);
        animatorSetI.addListener(new C0383a(z11, kVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.f36865u;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetI.addListener(it.next());
            }
        }
        animatorSetI.start();
    }

    public void x(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i11) {
        throw null;
    }

    public boolean y() {
        if (this.f36867w.getVisibility() == 0) {
            return this.f36863s == 1;
        }
        return this.f36863s != 2;
    }

    public boolean z() {
        if (this.f36867w.getVisibility() != 0) {
            return this.f36863s == 2;
        }
        return this.f36863s != 1;
    }
}
