package k6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class l0 extends j {
    public static final String[] O = {"android:visibility:visibility", "android:visibility:parent"};
    public int N = 3;

    /* JADX INFO: compiled from: source.java */
    public static class a extends AnimatorListenerAdapter implements j.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f68388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f68389b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ViewGroup f68390c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f68391d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f68392f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f68393g = false;

        public a(View view, int i11, boolean z11) {
            this.f68388a = view;
            this.f68389b = i11;
            this.f68390c = (ViewGroup) view.getParent();
            this.f68391d = z11;
            i(true);
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
            i(false);
            if (this.f68393g) {
                return;
            }
            z.f(this.f68388a, this.f68389b);
        }

        @Override // k6.j.f
        public void d(@NonNull j jVar) {
        }

        @Override // k6.j.f
        public void e(@NonNull j jVar) {
            jVar.V(this);
        }

        @Override // k6.j.f
        public void f(@NonNull j jVar) {
            i(true);
            if (this.f68393g) {
                return;
            }
            z.f(this.f68388a, 0);
        }

        @Override // k6.j.f
        public /* synthetic */ void g(j jVar, boolean z11) {
            k.a(this, jVar, z11);
        }

        public final void h() {
            if (!this.f68393g) {
                z.f(this.f68388a, this.f68389b);
                ViewGroup viewGroup = this.f68390c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            i(false);
        }

        public final void i(boolean z11) {
            ViewGroup viewGroup;
            if (!this.f68391d || this.f68392f == z11 || (viewGroup = this.f68390c) == null) {
                return;
            }
            this.f68392f = z11;
            y.b(viewGroup, z11);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f68393g = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NonNull Animator animator, boolean z11) {
            if (z11) {
                return;
            }
            h();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NonNull Animator animator, boolean z11) {
            if (z11) {
                z.f(this.f68388a, 0);
                ViewGroup viewGroup = this.f68390c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AnimatorListenerAdapter implements j.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f68394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f68395b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f68396c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f68397d = true;

        public b(ViewGroup viewGroup, View view, View view2) {
            this.f68394a = viewGroup;
            this.f68395b = view;
            this.f68396c = view2;
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
        }

        @Override // k6.j.f
        public void d(@NonNull j jVar) {
            if (this.f68397d) {
                h();
            }
        }

        @Override // k6.j.f
        public void e(@NonNull j jVar) {
            jVar.V(this);
        }

        @Override // k6.j.f
        public void f(@NonNull j jVar) {
        }

        @Override // k6.j.f
        public /* synthetic */ void g(j jVar, boolean z11) {
            k.a(this, jVar, z11);
        }

        public final void h() {
            this.f68396c.setTag(R$id.save_overlay_view, null);
            this.f68394a.getOverlay().remove(this.f68395b);
            this.f68397d = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NonNull Animator animator, boolean z11) {
            if (z11) {
                return;
            }
            h();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.f68394a.getOverlay().remove(this.f68395b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            if (this.f68395b.getParent() == null) {
                this.f68394a.getOverlay().add(this.f68395b);
            } else {
                l0.this.cancel();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NonNull Animator animator, boolean z11) {
            if (z11) {
                this.f68396c.setTag(R$id.save_overlay_view, this.f68395b);
                this.f68394a.getOverlay().add(this.f68395b);
                this.f68397d = true;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f68399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f68400b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f68401c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f68402d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ViewGroup f68403e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ViewGroup f68404f;
    }

    private void i0(w wVar) {
        wVar.f68416a.put("android:visibility:visibility", Integer.valueOf(wVar.f68417b.getVisibility()));
        wVar.f68416a.put("android:visibility:parent", wVar.f68417b.getParent());
        int[] iArr = new int[2];
        wVar.f68417b.getLocationOnScreen(iArr);
        wVar.f68416a.put("android:visibility:screenLocation", iArr);
    }

    @Override // k6.j
    @Nullable
    public String[] H() {
        return O;
    }

    @Override // k6.j
    public boolean J(@Nullable w wVar, @Nullable w wVar2) {
        if (wVar == null && wVar2 == null) {
            return false;
        }
        if (wVar != null && wVar2 != null && wVar2.f68416a.containsKey("android:visibility:visibility") != wVar.f68416a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c cVarJ0 = j0(wVar, wVar2);
        if (cVarJ0.f68399a) {
            return cVarJ0.f68401c == 0 || cVarJ0.f68402d == 0;
        }
        return false;
    }

    @Override // k6.j
    public void g(@NonNull w wVar) {
        i0(wVar);
    }

    public final c j0(w wVar, w wVar2) {
        c cVar = new c();
        cVar.f68399a = false;
        cVar.f68400b = false;
        if (wVar == null || !wVar.f68416a.containsKey("android:visibility:visibility")) {
            cVar.f68401c = -1;
            cVar.f68403e = null;
        } else {
            cVar.f68401c = ((Integer) wVar.f68416a.get("android:visibility:visibility")).intValue();
            cVar.f68403e = (ViewGroup) wVar.f68416a.get("android:visibility:parent");
        }
        if (wVar2 == null || !wVar2.f68416a.containsKey("android:visibility:visibility")) {
            cVar.f68402d = -1;
            cVar.f68404f = null;
        } else {
            cVar.f68402d = ((Integer) wVar2.f68416a.get("android:visibility:visibility")).intValue();
            cVar.f68404f = (ViewGroup) wVar2.f68416a.get("android:visibility:parent");
        }
        if (wVar != null && wVar2 != null) {
            int i11 = cVar.f68401c;
            int i12 = cVar.f68402d;
            if (i11 == i12 && cVar.f68403e == cVar.f68404f) {
                return cVar;
            }
            if (i11 != i12) {
                if (i11 == 0) {
                    cVar.f68400b = false;
                    cVar.f68399a = true;
                } else if (i12 == 0) {
                    cVar.f68400b = true;
                    cVar.f68399a = true;
                }
            } else if (cVar.f68404f == null) {
                cVar.f68400b = false;
                cVar.f68399a = true;
            } else if (cVar.f68403e == null) {
                cVar.f68400b = true;
                cVar.f68399a = true;
            }
        } else if (wVar == null && cVar.f68402d == 0) {
            cVar.f68400b = true;
            cVar.f68399a = true;
        } else if (wVar2 == null && cVar.f68401c == 0) {
            cVar.f68400b = false;
            cVar.f68399a = true;
        }
        return cVar;
    }

    @Override // k6.j
    public void k(@NonNull w wVar) {
        i0(wVar);
    }

    @Nullable
    public abstract Animator k0(@NonNull ViewGroup viewGroup, @NonNull View view, @Nullable w wVar, @Nullable w wVar2);

    @Nullable
    public Animator l0(@NonNull ViewGroup viewGroup, @Nullable w wVar, int i11, @Nullable w wVar2, int i12) {
        if ((this.N & 1) != 1 || wVar2 == null) {
            return null;
        }
        if (wVar == null) {
            View view = (View) wVar2.f68417b.getParent();
            if (j0(v(view, false), I(view, false)).f68399a) {
                return null;
            }
        }
        return k0(viewGroup, wVar2.f68417b, wVar, wVar2);
    }

    @Nullable
    public abstract Animator m0(@NonNull ViewGroup viewGroup, @NonNull View view, @Nullable w wVar, @Nullable w wVar2);

    /* JADX WARN: Code duplicated, block: B:23:0x0036  */
    @Nullable
    public Animator n0(@NonNull ViewGroup viewGroup, @Nullable w wVar, int i11, @Nullable w wVar2, int i12) {
        View view;
        boolean z11;
        boolean z12;
        View view2;
        if ((this.N & 2) != 2 || wVar == null) {
            return null;
        }
        View view3 = wVar.f68417b;
        View viewA = wVar2 != null ? wVar2.f68417b : null;
        View view4 = (View) view3.getTag(R$id.save_overlay_view);
        if (view4 != null) {
            view2 = null;
            z12 = true;
        } else {
            if (viewA == null || viewA.getParent() == null) {
                if (viewA != null) {
                    view = null;
                    z11 = false;
                } else {
                    viewA = null;
                    view = null;
                    z11 = true;
                }
            } else if (i12 == 4 || view3 == viewA) {
                view = viewA;
                z11 = false;
                viewA = null;
            } else {
                viewA = null;
                view = null;
                z11 = true;
            }
            if (z11) {
                if (view3.getParent() != null) {
                    if (view3.getParent() instanceof View) {
                        View view5 = (View) view3.getParent();
                        if (j0(I(view5, true), v(view5, true)).f68399a) {
                            int id2 = view5.getId();
                            if (view5.getParent() != null || id2 == -1 || viewGroup.findViewById(id2) == null || !this.f68370x) {
                            }
                        } else {
                            viewA = v.a(viewGroup, view3, view5);
                        }
                    }
                    z12 = false;
                    View view6 = view;
                    view4 = viewA;
                    view2 = view6;
                }
                view2 = view;
                z12 = false;
                view4 = view3;
            } else {
                z12 = false;
                View view7 = view;
                view4 = viewA;
                view2 = view7;
            }
        }
        if (view4 == null) {
            if (view2 == null) {
                return null;
            }
            int visibility = view2.getVisibility();
            z.f(view2, 0);
            Animator animatorM0 = m0(viewGroup, view2, wVar, wVar2);
            if (animatorM0 != null) {
                a aVar = new a(view2, i12, true);
                animatorM0.addListener(aVar);
                A().a(aVar);
            } else {
                z.f(view2, visibility);
            }
            return animatorM0;
        }
        if (!z12) {
            int[] iArr = (int[]) wVar.f68416a.get("android:visibility:screenLocation");
            int i13 = iArr[0];
            int i14 = iArr[1];
            int[] iArr2 = new int[2];
            viewGroup.getLocationOnScreen(iArr2);
            view4.offsetLeftAndRight((i13 - iArr2[0]) - view4.getLeft());
            view4.offsetTopAndBottom((i14 - iArr2[1]) - view4.getTop());
            viewGroup.getOverlay().add(view4);
        }
        Animator animatorM1 = m0(viewGroup, view4, wVar, wVar2);
        if (!z12) {
            if (animatorM1 == null) {
                viewGroup.getOverlay().remove(view4);
            } else {
                view3.setTag(R$id.save_overlay_view, view4);
                b bVar = new b(viewGroup, view4, view3);
                animatorM1.addListener(bVar);
                animatorM1.addPauseListener(bVar);
                A().a(bVar);
            }
        }
        return animatorM1;
    }

    @Override // k6.j
    @Nullable
    public Animator o(@NonNull ViewGroup viewGroup, @Nullable w wVar, @Nullable w wVar2) {
        c cVarJ0 = j0(wVar, wVar2);
        if (!cVarJ0.f68399a) {
            return null;
        }
        if (cVarJ0.f68403e == null && cVarJ0.f68404f == null) {
            return null;
        }
        return cVarJ0.f68400b ? l0(viewGroup, wVar, cVarJ0.f68401c, wVar2, cVarJ0.f68402d) : n0(viewGroup, wVar, cVarJ0.f68401c, wVar2, cVarJ0.f68402d);
    }

    public void o0(int i11) {
        if ((i11 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.N = i11;
    }
}
