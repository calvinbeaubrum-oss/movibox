package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import ii.f;
import ii.i;
import ii.j;
import ii.k;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f37993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f37994d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f37995f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f37996g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f37997h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f37998i;

    /* JADX INFO: compiled from: source.java */
    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f37999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f38000b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f38001c;

        public a(boolean z11, View view, View view2) {
            this.f37999a = z11;
            this.f38000b = view;
            this.f38001c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f37999a) {
                return;
            }
            this.f38000b.setVisibility(4);
            this.f38001c.setAlpha(1.0f);
            this.f38001c.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f37999a) {
                this.f38000b.setVisibility(0);
                this.f38001c.setAlpha(0.0f);
                this.f38001c.setVisibility(4);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f38003a;

        public b(View view) {
            this.f38003a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f38003a.invalidate();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.google.android.material.circularreveal.c f38005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Drawable f38006b;

        public c(com.google.android.material.circularreveal.c cVar, Drawable drawable) {
            this.f38005a = cVar;
            this.f38006b = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f38005a.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f38005a.setCircularRevealOverlayDrawable(this.f38006b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.google.android.material.circularreveal.c f38008a;

        public d(com.google.android.material.circularreveal.c cVar) {
            this.f38008a = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            com.google.android.material.circularreveal.c.e revealInfo = this.f38008a.getRevealInfo();
            revealInfo.f36627c = Float.MAX_VALUE;
            this.f38008a.setRevealInfo(revealInfo);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public i f38010a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public k f38011b;
    }

    public FabTransformationBehavior() {
        this.f37993c = new Rect();
        this.f37994d = new RectF();
        this.f37995f = new RectF();
        this.f37996g = new int[2];
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37993c = new Rect();
        this.f37994d = new RectF();
        this.f37995f = new RectF();
        this.f37996g = new int[2];
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    public AnimatorSet J(@NonNull View view, @NonNull View view2, boolean z11, boolean z12) {
        e eVarE0 = e0(view2.getContext(), z11);
        if (z11) {
            this.f37997h = view.getTranslationX();
            this.f37998i = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        X(view, view2, z11, z12, eVarE0, arrayList, arrayList2);
        RectF rectF = this.f37994d;
        c0(view, view2, z11, z12, eVarE0, arrayList, arrayList2, rectF);
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        W(view, view2, z11, eVarE0, arrayList);
        Z(view, view2, z11, z12, eVarE0, arrayList, arrayList2);
        Y(view, view2, z11, z12, eVarE0, fWidth, fHeight, arrayList, arrayList2);
        V(view, view2, z11, z12, eVarE0, arrayList, arrayList2);
        U(view, view2, z11, z12, eVarE0, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        ii.c.a(animatorSet, arrayList);
        animatorSet.addListener(new a(z11, view2, view));
        int size = arrayList2.size();
        for (int i11 = 0; i11 < size; i11++) {
            animatorSet.addListener(arrayList2.get(i11));
        }
        return animatorSet;
    }

    @Nullable
    public final ViewGroup K(@NonNull View view) {
        View viewFindViewById = view.findViewById(R$id.mtrl_child_content_container);
        if (viewFindViewById != null) {
            return f0(viewFindViewById);
        }
        return ((view instanceof TransformationChildLayout) || (view instanceof TransformationChildCard)) ? f0(((ViewGroup) view).getChildAt(0)) : f0(view);
    }

    public final void L(@NonNull View view, @NonNull e eVar, @NonNull j jVar, @NonNull j jVar2, float f11, float f12, float f13, float f14, @NonNull RectF rectF) {
        float fS = S(eVar, jVar, f11, f13);
        float fS2 = S(eVar, jVar2, f12, f14);
        Rect rect = this.f37993c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f37994d;
        rectF2.set(rect);
        RectF rectF3 = this.f37995f;
        T(view, rectF3);
        rectF3.offset(fS, fS2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    public final void M(@NonNull View view, @NonNull RectF rectF) {
        T(view, rectF);
        rectF.offset(this.f37997h, this.f37998i);
    }

    @NonNull
    public final Pair<j, j> N(float f11, float f12, boolean z11, @NonNull e eVar) {
        j jVarH;
        j jVarH2;
        if (f11 == 0.0f || f12 == 0.0f) {
            jVarH = eVar.f38010a.h("translationXLinear");
            jVarH2 = eVar.f38010a.h("translationYLinear");
        } else if ((!z11 || f12 >= 0.0f) && (z11 || f12 <= 0.0f)) {
            jVarH = eVar.f38010a.h("translationXCurveDownwards");
            jVarH2 = eVar.f38010a.h("translationYCurveDownwards");
        } else {
            jVarH = eVar.f38010a.h("translationXCurveUpwards");
            jVarH2 = eVar.f38010a.h("translationYCurveUpwards");
        }
        return new Pair<>(jVarH, jVarH2);
    }

    public final float O(@NonNull View view, @NonNull View view2, @NonNull k kVar) {
        RectF rectF = this.f37994d;
        RectF rectF2 = this.f37995f;
        M(view, rectF);
        T(view2, rectF2);
        rectF2.offset(-Q(view, view2, kVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    public final float P(@NonNull View view, @NonNull View view2, @NonNull k kVar) {
        RectF rectF = this.f37994d;
        RectF rectF2 = this.f37995f;
        M(view, rectF);
        T(view2, rectF2);
        rectF2.offset(0.0f, -R(view, view2, kVar));
        return rectF.centerY() - rectF2.top;
    }

    public final float Q(@NonNull View view, @NonNull View view2, @NonNull k kVar) {
        float fCenterX;
        float fCenterX2;
        float f11;
        RectF rectF = this.f37994d;
        RectF rectF2 = this.f37995f;
        M(view, rectF);
        T(view2, rectF2);
        int i11 = kVar.f67221a & 7;
        if (i11 == 1) {
            fCenterX = rectF2.centerX();
            fCenterX2 = rectF.centerX();
        } else {
            if (i11 != 3) {
                if (i11 != 5) {
                    f11 = 0.0f;
                } else {
                    fCenterX = rectF2.right;
                    fCenterX2 = rectF.right;
                }
                return f11 + kVar.f67222b;
            }
            fCenterX = rectF2.left;
            fCenterX2 = rectF.left;
        }
        f11 = fCenterX - fCenterX2;
        return f11 + kVar.f67222b;
    }

    public final float R(@NonNull View view, @NonNull View view2, @NonNull k kVar) {
        float fCenterY;
        float fCenterY2;
        float f11;
        RectF rectF = this.f37994d;
        RectF rectF2 = this.f37995f;
        M(view, rectF);
        T(view2, rectF2);
        int i11 = kVar.f67221a & 112;
        if (i11 == 16) {
            fCenterY = rectF2.centerY();
            fCenterY2 = rectF.centerY();
        } else {
            if (i11 != 48) {
                if (i11 != 80) {
                    f11 = 0.0f;
                } else {
                    fCenterY = rectF2.bottom;
                    fCenterY2 = rectF.bottom;
                }
                return f11 + kVar.f67223c;
            }
            fCenterY = rectF2.top;
            fCenterY2 = rectF.top;
        }
        f11 = fCenterY - fCenterY2;
        return f11 + kVar.f67223c;
    }

    public final float S(@NonNull e eVar, @NonNull j jVar, float f11, float f12) {
        long jC = jVar.c();
        long jD = jVar.d();
        j jVarH = eVar.f38010a.h("expansion");
        return ii.b.a(f11, f12, jVar.e().getInterpolation((((jVarH.c() + jVarH.d()) + 17) - jC) / jD));
    }

    public final void T(@NonNull View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        int[] iArr = this.f37996g;
        view.getLocationInWindow(iArr);
        rectF.offsetTo(iArr[0], iArr[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    public final void U(View view, View view2, boolean z11, boolean z12, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup viewGroupK;
        ObjectAnimator objectAnimatorOfFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof com.google.android.material.circularreveal.c) && com.google.android.material.circularreveal.b.f36611j == 0) || (viewGroupK = K(view2)) == null) {
                return;
            }
            if (z11) {
                if (!z12) {
                    ii.e.f67207a.set(viewGroupK, Float.valueOf(0.0f));
                }
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupK, ii.e.f67207a, 1.0f);
            } else {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupK, ii.e.f67207a, 0.0f);
            }
            eVar.f38010a.h("contentFade").a(objectAnimatorOfFloat);
            list.add(objectAnimatorOfFloat);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V(@NonNull View view, View view2, boolean z11, boolean z12, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfInt;
        if (view2 instanceof com.google.android.material.circularreveal.c) {
            com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
            int iD0 = d0(view);
            int i11 = 16777215 & iD0;
            if (z11) {
                if (!z12) {
                    cVar.setCircularRevealScrimColor(iD0);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(cVar, com.google.android.material.circularreveal.c.d.f36624a, i11);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(cVar, com.google.android.material.circularreveal.c.d.f36624a, iD0);
            }
            objectAnimatorOfInt.setEvaluator(ii.d.b());
            eVar.f38010a.h(TtmlNode.ATTR_TTS_COLOR).a(objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
        }
    }

    public final void W(@NonNull View view, @NonNull View view2, boolean z11, @NonNull e eVar, @NonNull List<Animator> list) {
        float fQ = Q(view, view2, eVar.f38011b);
        float fR = R(view, view2, eVar.f38011b);
        Pair<j, j> pairN = N(fQ, fR, z11, eVar);
        j jVar = (j) pairN.first;
        j jVar2 = (j) pairN.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z11) {
            fQ = this.f37997h;
        }
        fArr[0] = fQ;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z11) {
            fR = this.f37998i;
        }
        fArr2[0] = fR;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
        jVar.a(objectAnimatorOfFloat);
        jVar2.a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    @TargetApi(21)
    public final void X(View view, @NonNull View view2, boolean z11, boolean z12, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfFloat;
        float elevation = ViewCompat.getElevation(view2) - ViewCompat.getElevation(view);
        if (z11) {
            if (!z12) {
                view2.setTranslationZ(-elevation);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -elevation);
        }
        eVar.f38010a.h("elevation").a(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y(@NonNull View view, View view2, boolean z11, boolean z12, @NonNull e eVar, float f11, float f12, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        Animator animatorA;
        if (view2 instanceof com.google.android.material.circularreveal.c) {
            com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
            float fO = O(view, view2, eVar.f38011b);
            float fP = P(view, view2, eVar.f38011b);
            ((FloatingActionButton) view).getContentRect(this.f37993c);
            float fWidth = this.f37993c.width() / 2.0f;
            j jVarH = eVar.f38010a.h("expansion");
            if (z11) {
                if (!z12) {
                    cVar.setRevealInfo(new com.google.android.material.circularreveal.c.e(fO, fP, fWidth));
                }
                if (z12) {
                    fWidth = cVar.getRevealInfo().f36627c;
                }
                animatorA = com.google.android.material.circularreveal.a.a(cVar, fO, fP, si.a.b(fO, fP, 0.0f, 0.0f, f11, f12));
                animatorA.addListener(new d(cVar));
                b0(view2, jVarH.c(), (int) fO, (int) fP, fWidth, list);
            } else {
                float f13 = cVar.getRevealInfo().f36627c;
                Animator animatorA2 = com.google.android.material.circularreveal.a.a(cVar, fO, fP, fWidth);
                int i11 = (int) fO;
                int i12 = (int) fP;
                b0(view2, jVarH.c(), i11, i12, f13, list);
                a0(view2, jVarH.c(), jVarH.d(), eVar.f38010a.i(), i11, i12, fWidth, list);
                animatorA = animatorA2;
            }
            jVarH.a(animatorA);
            list.add(animatorA);
            list2.add(com.google.android.material.circularreveal.a.b(cVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z(View view, View view2, boolean z11, boolean z12, @NonNull e eVar, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfInt;
        if ((view2 instanceof com.google.android.material.circularreveal.c) && (view instanceof ImageView)) {
            com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z11) {
                if (!z12) {
                    drawable.setAlpha(255);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, f.f67208b, 0);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, f.f67208b, 255);
            }
            objectAnimatorOfInt.addUpdateListener(new b(view2));
            eVar.f38010a.h("iconFade").a(objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
            list2.add(new c(cVar, drawable));
        }
    }

    public final void a0(View view, long j11, long j12, long j13, int i11, int i12, float f11, @NonNull List<Animator> list) {
        long j14 = j11 + j12;
        if (j14 < j13) {
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i11, i12, f11, f11);
            animatorCreateCircularReveal.setStartDelay(j14);
            animatorCreateCircularReveal.setDuration(j13 - j14);
            list.add(animatorCreateCircularReveal);
        }
    }

    public final void b0(View view, long j11, int i11, int i12, float f11, @NonNull List<Animator> list) {
        if (j11 > 0) {
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i11, i12, f11, f11);
            animatorCreateCircularReveal.setStartDelay(0L);
            animatorCreateCircularReveal.setDuration(j11);
            list.add(animatorCreateCircularReveal);
        }
    }

    public final void c0(@NonNull View view, @NonNull View view2, boolean z11, boolean z12, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2, @NonNull RectF rectF) {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        float fQ = Q(view, view2, eVar.f38011b);
        float fR = R(view, view2, eVar.f38011b);
        Pair<j, j> pairN = N(fQ, fR, z11, eVar);
        j jVar = (j) pairN.first;
        j jVar2 = (j) pairN.second;
        if (z11) {
            if (!z12) {
                view2.setTranslationX(-fQ);
                view2.setTranslationY(-fR);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            L(view2, eVar, jVar, jVar2, -fQ, -fR, 0.0f, 0.0f, rectF);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -fQ);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -fR);
        }
        jVar.a(objectAnimatorOfFloat);
        jVar2.a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    public final int d0(@NonNull View view) {
        ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(view);
        if (backgroundTintList != null) {
            return backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor());
        }
        return 0;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    @CallSuper
    public boolean e(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    public abstract e e0(Context context, boolean z11);

    @Nullable
    public final ViewGroup f0(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    @CallSuper
    public void g(@NonNull CoordinatorLayout.f fVar) {
        if (fVar.f7527h == 0) {
            fVar.f7527h = 80;
        }
    }
}
