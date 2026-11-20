package k6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.R$id;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends j {
    public static final String[] O = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final Property<i, PointF> P = new a(PointF.class, "topLeft");
    public static final Property<i, PointF> Q = new C0734b(PointF.class, "bottomRight");
    public static final Property<View, PointF> R = new c(PointF.class, "bottomRight");
    public static final Property<View, PointF> S = new d(PointF.class, "topLeft");
    public static final Property<View, PointF> T = new e(PointF.class, RequestParameters.POSITION);
    public static final k6.h U = new k6.h();
    public boolean N = false;

    /* JADX INFO: compiled from: source.java */
    public class a extends Property<i, PointF> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(i iVar) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(i iVar, PointF pointF) {
            iVar.c(pointF);
        }
    }

    /* JADX INFO: renamed from: k6.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0734b extends Property<i, PointF> {
        public C0734b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(i iVar) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(i iVar, PointF pointF) {
            iVar.a(pointF);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends Property<View, PointF> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            z.d(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends Property<View, PointF> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            z.d(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends Property<View, PointF> {
        public e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int iRound = Math.round(pointF.x);
            int iRound2 = Math.round(pointF.y);
            z.d(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f68291a;
        private final i mViewBounds;

        public f(i iVar) {
            this.f68291a = iVar;
            this.mViewBounds = iVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class g extends AnimatorListenerAdapter implements j.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f68293a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f68294b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f68295c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Rect f68296d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f68297f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f68298g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f68299h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f68300i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f68301j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f68302k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f68303l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f68304m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f68305n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f68306o;

        public g(View view, Rect rect, boolean z11, Rect rect2, boolean z12, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            this.f68293a = view;
            this.f68294b = rect;
            this.f68295c = z11;
            this.f68296d = rect2;
            this.f68297f = z12;
            this.f68298g = i11;
            this.f68299h = i12;
            this.f68300i = i13;
            this.f68301j = i14;
            this.f68302k = i15;
            this.f68303l = i16;
            this.f68304m = i17;
            this.f68305n = i18;
        }

        @Override // k6.j.f
        public /* synthetic */ void a(j jVar, boolean z11) {
            k.b(this, jVar, z11);
        }

        @Override // k6.j.f
        public void b(@NonNull j jVar) {
        }

        @Override // k6.j.f
        public void c(@NonNull j jVar) {
            this.f68293a.setTag(R$id.transition_clip, this.f68293a.getClipBounds());
            this.f68293a.setClipBounds(this.f68297f ? null : this.f68296d);
        }

        @Override // k6.j.f
        public void d(@NonNull j jVar) {
            this.f68306o = true;
        }

        @Override // k6.j.f
        public void e(@NonNull j jVar) {
        }

        @Override // k6.j.f
        public void f(@NonNull j jVar) {
            Rect rect = (Rect) this.f68293a.getTag(R$id.transition_clip);
            this.f68293a.setTag(R$id.transition_clip, null);
            this.f68293a.setClipBounds(rect);
        }

        @Override // k6.j.f
        public /* synthetic */ void g(j jVar, boolean z11) {
            k.a(this, jVar, z11);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z11) {
            if (this.f68306o) {
                return;
            }
            Rect rect = null;
            if (z11) {
                if (!this.f68295c) {
                    rect = this.f68294b;
                }
            } else if (!this.f68297f) {
                rect = this.f68296d;
            }
            this.f68293a.setClipBounds(rect);
            if (z11) {
                z.d(this.f68293a, this.f68298g, this.f68299h, this.f68300i, this.f68301j);
            } else {
                z.d(this.f68293a, this.f68302k, this.f68303l, this.f68304m, this.f68305n);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            onAnimationStart(animator, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z11) {
            int iMax = Math.max(this.f68300i - this.f68298g, this.f68304m - this.f68302k);
            int iMax2 = Math.max(this.f68301j - this.f68299h, this.f68305n - this.f68303l);
            int i11 = z11 ? this.f68302k : this.f68298g;
            int i12 = z11 ? this.f68303l : this.f68299h;
            z.d(this.f68293a, i11, i12, iMax + i11, iMax2 + i12);
            this.f68293a.setClipBounds(z11 ? this.f68296d : this.f68294b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class h extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f68307a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewGroup f68308b;

        public h(@NonNull ViewGroup viewGroup) {
            this.f68308b = viewGroup;
        }

        @Override // k6.r, k6.j.f
        public void c(@NonNull j jVar) {
            y.b(this.f68308b, false);
        }

        @Override // k6.r, k6.j.f
        public void d(@NonNull j jVar) {
            y.b(this.f68308b, false);
            this.f68307a = true;
        }

        @Override // k6.j.f
        public void e(@NonNull j jVar) {
            if (!this.f68307a) {
                y.b(this.f68308b, false);
            }
            jVar.V(this);
        }

        @Override // k6.r, k6.j.f
        public void f(@NonNull j jVar) {
            y.b(this.f68308b, true);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f68309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f68310b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f68311c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f68312d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f68313e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f68314f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f68315g;

        public i(View view) {
            this.f68313e = view;
        }

        public void a(PointF pointF) {
            this.f68311c = Math.round(pointF.x);
            this.f68312d = Math.round(pointF.y);
            int i11 = this.f68315g + 1;
            this.f68315g = i11;
            if (this.f68314f == i11) {
                b();
            }
        }

        public final void b() {
            z.d(this.f68313e, this.f68309a, this.f68310b, this.f68311c, this.f68312d);
            this.f68314f = 0;
            this.f68315g = 0;
        }

        public void c(PointF pointF) {
            this.f68309a = Math.round(pointF.x);
            this.f68310b = Math.round(pointF.y);
            int i11 = this.f68314f + 1;
            this.f68314f = i11;
            if (i11 == this.f68315g) {
                b();
            }
        }
    }

    @Override // k6.j
    @NonNull
    public String[] H() {
        return O;
    }

    @Override // k6.j
    public void g(@NonNull w wVar) {
        i0(wVar);
    }

    public final void i0(w wVar) {
        View view = wVar.f68417b;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        wVar.f68416a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        wVar.f68416a.put("android:changeBounds:parent", wVar.f68417b.getParent());
        if (this.N) {
            wVar.f68416a.put("android:changeBounds:clip", view.getClipBounds());
        }
    }

    @Override // k6.j
    public void k(@NonNull w wVar) {
        Rect rect;
        i0(wVar);
        if (!this.N || (rect = (Rect) wVar.f68417b.getTag(R$id.transition_clip)) == null) {
            return;
        }
        wVar.f68416a.put("android:changeBounds:clip", rect);
    }

    @Override // k6.j
    @Nullable
    public Animator o(@NonNull ViewGroup viewGroup, @Nullable w wVar, @Nullable w wVar2) {
        int i11;
        View view;
        int i12;
        Rect rect;
        Animator animator;
        Animator animatorC;
        if (wVar == null || wVar2 == null) {
            return null;
        }
        Map<String, Object> map = wVar.f68416a;
        Map<String, Object> map2 = wVar2.f68416a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = wVar2.f68417b;
        Rect rect2 = (Rect) wVar.f68416a.get("android:changeBounds:bounds");
        Rect rect3 = (Rect) wVar2.f68416a.get("android:changeBounds:bounds");
        int i13 = rect2.left;
        int i14 = rect3.left;
        int i15 = rect2.top;
        int i16 = rect3.top;
        int i17 = rect2.right;
        int i18 = rect3.right;
        int i19 = rect2.bottom;
        int i21 = rect3.bottom;
        int i22 = i17 - i13;
        int i23 = i19 - i15;
        int i24 = i18 - i14;
        int i25 = i21 - i16;
        Rect rect4 = (Rect) wVar.f68416a.get("android:changeBounds:clip");
        Rect rect5 = (Rect) wVar2.f68416a.get("android:changeBounds:clip");
        if ((i22 == 0 || i23 == 0) && (i24 == 0 || i25 == 0)) {
            i11 = 0;
        } else {
            i11 = (i13 == i14 && i15 == i16) ? 0 : 1;
            if (i17 != i18 || i19 != i21) {
                i11++;
            }
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i11++;
        }
        int i26 = i11;
        if (i26 <= 0) {
            return null;
        }
        if (this.N) {
            view = view2;
            z.d(view, i13, i15, Math.max(i22, i24) + i13, i15 + Math.max(i23, i25));
            ObjectAnimator objectAnimatorA = (i13 == i14 && i15 == i16) ? null : k6.f.a(view, T, y().a(i13, i15, i14, i16));
            boolean z11 = rect4 == null;
            if (z11) {
                i12 = 0;
                rect = new Rect(0, 0, i22, i23);
            } else {
                i12 = 0;
                rect = rect4;
            }
            boolean z12 = rect5 == null;
            Rect rect6 = z12 ? new Rect(i12, i12, i24, i25) : rect5;
            if (rect.equals(rect6)) {
                animator = null;
            } else {
                view.setClipBounds(rect);
                k6.h hVar = U;
                Object[] objArr = new Object[2];
                objArr[i12] = rect;
                objArr[1] = rect6;
                Animator animatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", hVar, objArr);
                g gVar = new g(view, rect, z11, rect6, z12, i13, i15, i17, i19, i14, i16, i18, i21);
                animatorOfObject.addListener(gVar);
                a(gVar);
                animator = animatorOfObject;
                objectAnimatorA = objectAnimatorA;
            }
            animatorC = v.c(objectAnimatorA, animator);
        } else {
            z.d(view2, i13, i15, i17, i19);
            if (i26 != 2) {
                animatorC = (i13 == i14 && i15 == i16) ? k6.f.a(view2, R, y().a(i17, i19, i18, i21)) : k6.f.a(view2, S, y().a(i13, i15, i14, i16));
            } else if (i22 == i24 && i23 == i25) {
                animatorC = k6.f.a(view2, T, y().a(i13, i15, i14, i16));
            } else {
                i iVar = new i(view2);
                ObjectAnimator objectAnimatorA2 = k6.f.a(iVar, P, y().a(i13, i15, i14, i16));
                ObjectAnimator objectAnimatorA3 = k6.f.a(iVar, Q, y().a(i17, i19, i18, i21));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimatorA2, objectAnimatorA3);
                animatorSet.addListener(new f(iVar));
                view = view2;
                animatorC = animatorSet;
            }
            view = view2;
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            y.b(viewGroup4, true);
            A().a(new h(viewGroup4));
        }
        return animatorC;
    }
}
