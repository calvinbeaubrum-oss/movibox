package k6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class j implements Cloneable {
    public static final Animator[] J = new Animator[0];
    public static final int[] K = {2, 1, 3, 4};
    public static final k6.g L = new a();
    public static ThreadLocal<androidx.collection.a<Animator, d>> M = new ThreadLocal<>();
    public e G;
    public androidx.collection.a<String, String> H;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ArrayList<w> f68367u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ArrayList<w> f68368v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public f[] f68369w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f68348a = getClass().getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f68349b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f68350c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TimeInterpolator f68351d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<Integer> f68352f = new ArrayList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList<View> f68353g = new ArrayList<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList<String> f68354h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList<Class<?>> f68355i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList<Integer> f68356j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList<View> f68357k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList<Class<?>> f68358l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList<String> f68359m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList<Integer> f68360n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList<View> f68361o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList<Class<?>> f68362p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public x f68363q = new x();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public x f68364r = new x();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public u f68365s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int[] f68366t = K;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f68370x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ArrayList<Animator> f68371y = new ArrayList<>();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Animator[] f68372z = J;
    public int A = 0;
    public boolean B = false;
    public boolean C = false;
    public j D = null;
    public ArrayList<f> E = null;
    public ArrayList<Animator> F = new ArrayList<>();
    public k6.g I = L;

    /* JADX INFO: compiled from: source.java */
    public class a extends k6.g {
        @Override // k6.g
        @NonNull
        public Path a(float f11, float f12, float f13, float f14) {
            Path path = new Path();
            path.moveTo(f11, f12);
            path.lineTo(f13, f14);
            return path;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.collection.a f68373a;

        public b(androidx.collection.a aVar) {
            this.f68373a = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f68373a.remove(animator);
            j.this.f68371y.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            j.this.f68371y.add(animator);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            j.this.q();
            animator.removeListener(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f68376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f68377b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public w f68378c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public WindowId f68379d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public j f68380e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Animator f68381f;

        public d(View view, String str, j jVar, WindowId windowId, w wVar, Animator animator) {
            this.f68376a = view;
            this.f68377b = str;
            this.f68378c = wVar;
            this.f68379d = windowId;
            this.f68380e = jVar;
            this.f68381f = animator;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class e {
    }

    /* JADX INFO: compiled from: source.java */
    public interface f {
        void a(@NonNull j jVar, boolean z11);

        void b(@NonNull j jVar);

        void c(@NonNull j jVar);

        void d(@NonNull j jVar);

        void e(@NonNull j jVar);

        void f(@NonNull j jVar);

        void g(@NonNull j jVar, boolean z11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f68382a = new g() { // from class: k6.l
            @Override // k6.j.g
            public final void a(j.f fVar, j jVar, boolean z11) {
                fVar.a(jVar, z11);
            }
        };

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g f68383b = new g() { // from class: k6.m
            @Override // k6.j.g
            public final void a(j.f fVar, j jVar, boolean z11) {
                fVar.g(jVar, z11);
            }
        };

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g f68384c = new g() { // from class: k6.n
            @Override // k6.j.g
            public final void a(j.f fVar, j jVar, boolean z11) {
                fVar.d(jVar);
            }
        };

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final g f68385d = new g() { // from class: k6.o
            @Override // k6.j.g
            public final void a(j.f fVar, j jVar, boolean z11) {
                fVar.c(jVar);
            }
        };

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final g f68386e = new g() { // from class: k6.p
            @Override // k6.j.g
            public final void a(j.f fVar, j jVar, boolean z11) {
                fVar.f(jVar);
            }
        };

        void a(@NonNull f fVar, @NonNull j jVar, boolean z11);
    }

    public static androidx.collection.a<Animator, d> B() {
        androidx.collection.a<Animator, d> aVar = M.get();
        if (aVar != null) {
            return aVar;
        }
        androidx.collection.a<Animator, d> aVar2 = new androidx.collection.a<>();
        M.set(aVar2);
        return aVar2;
    }

    public static boolean L(w wVar, w wVar2, String str) {
        Object obj = wVar.f68416a.get(str);
        Object obj2 = wVar2.f68416a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public static void d(x xVar, View view, w wVar) {
        xVar.f68419a.put(view, wVar);
        int id2 = view.getId();
        if (id2 >= 0) {
            if (xVar.f68420b.indexOfKey(id2) >= 0) {
                xVar.f68420b.put(id2, null);
            } else {
                xVar.f68420b.put(id2, view);
            }
        }
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            if (xVar.f68422d.containsKey(transitionName)) {
                xVar.f68422d.put(transitionName, null);
            } else {
                xVar.f68422d.put(transitionName, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (xVar.f68421c.h(itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    xVar.f68421c.l(itemIdAtPosition, view);
                    return;
                }
                View viewF = xVar.f68421c.f(itemIdAtPosition);
                if (viewF != null) {
                    viewF.setHasTransientState(false);
                    xVar.f68421c.l(itemIdAtPosition, null);
                }
            }
        }
    }

    @NonNull
    public final j A() {
        u uVar = this.f68365s;
        return uVar != null ? uVar.A() : this;
    }

    public long C() {
        return this.f68349b;
    }

    @NonNull
    public List<Integer> D() {
        return this.f68352f;
    }

    @Nullable
    public List<String> E() {
        return this.f68354h;
    }

    @Nullable
    public List<Class<?>> F() {
        return this.f68355i;
    }

    @NonNull
    public List<View> G() {
        return this.f68353g;
    }

    @Nullable
    public String[] H() {
        return null;
    }

    @Nullable
    public w I(@NonNull View view, boolean z11) {
        u uVar = this.f68365s;
        if (uVar != null) {
            return uVar.I(view, z11);
        }
        return (z11 ? this.f68363q : this.f68364r).f68419a.get(view);
    }

    public boolean J(@Nullable w wVar, @Nullable w wVar2) {
        if (wVar == null || wVar2 == null) {
            return false;
        }
        String[] strArrH = H();
        if (strArrH == null) {
            Iterator<String> it = wVar.f68416a.keySet().iterator();
            while (it.hasNext()) {
                if (L(wVar, wVar2, it.next())) {
                }
            }
            return false;
        }
        for (String str : strArrH) {
            if (!L(wVar, wVar2, str)) {
            }
        }
        return false;
        return true;
    }

    public boolean K(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id2 = view.getId();
        ArrayList<Integer> arrayList3 = this.f68356j;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id2))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.f68357k;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.f68358l;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i11 = 0; i11 < size; i11++) {
                if (this.f68358l.get(i11).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f68359m != null && ViewCompat.getTransitionName(view) != null && this.f68359m.contains(ViewCompat.getTransitionName(view))) {
            return false;
        }
        if ((this.f68352f.size() == 0 && this.f68353g.size() == 0 && (((arrayList = this.f68355i) == null || arrayList.isEmpty()) && ((arrayList2 = this.f68354h) == null || arrayList2.isEmpty()))) || this.f68352f.contains(Integer.valueOf(id2)) || this.f68353g.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.f68354h;
        if (arrayList6 != null && arrayList6.contains(ViewCompat.getTransitionName(view))) {
            return true;
        }
        if (this.f68355i != null) {
            for (int i12 = 0; i12 < this.f68355i.size(); i12++) {
                if (this.f68355i.get(i12).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void M(androidx.collection.a<View, w> aVar, androidx.collection.a<View, w> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i11 = 0; i11 < size; i11++) {
            View viewValueAt = sparseArray.valueAt(i11);
            if (viewValueAt != null && K(viewValueAt) && (view = sparseArray2.get(sparseArray.keyAt(i11))) != null && K(view)) {
                w wVar = aVar.get(viewValueAt);
                w wVar2 = aVar2.get(view);
                if (wVar != null && wVar2 != null) {
                    this.f68367u.add(wVar);
                    this.f68368v.add(wVar2);
                    aVar.remove(viewValueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    public final void N(androidx.collection.a<View, w> aVar, androidx.collection.a<View, w> aVar2) {
        w wVarRemove;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View viewKeyAt = aVar.keyAt(size);
            if (viewKeyAt != null && K(viewKeyAt) && (wVarRemove = aVar2.remove(viewKeyAt)) != null && K(wVarRemove.f68417b)) {
                this.f68367u.add(aVar.removeAt(size));
                this.f68368v.add(wVarRemove);
            }
        }
    }

    public final void O(androidx.collection.a<View, w> aVar, androidx.collection.a<View, w> aVar2, androidx.collection.v<View> vVar, androidx.collection.v<View> vVar2) {
        View viewF;
        int iO = vVar.o();
        for (int i11 = 0; i11 < iO; i11++) {
            View viewP = vVar.p(i11);
            if (viewP != null && K(viewP) && (viewF = vVar2.f(vVar.k(i11))) != null && K(viewF)) {
                w wVar = aVar.get(viewP);
                w wVar2 = aVar2.get(viewF);
                if (wVar != null && wVar2 != null) {
                    this.f68367u.add(wVar);
                    this.f68368v.add(wVar2);
                    aVar.remove(viewP);
                    aVar2.remove(viewF);
                }
            }
        }
    }

    public final void P(androidx.collection.a<View, w> aVar, androidx.collection.a<View, w> aVar2, androidx.collection.a<String, View> aVar3, androidx.collection.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i11 = 0; i11 < size; i11++) {
            View viewValueAt = aVar3.valueAt(i11);
            if (viewValueAt != null && K(viewValueAt) && (view = aVar4.get(aVar3.keyAt(i11))) != null && K(view)) {
                w wVar = aVar.get(viewValueAt);
                w wVar2 = aVar2.get(view);
                if (wVar != null && wVar2 != null) {
                    this.f68367u.add(wVar);
                    this.f68368v.add(wVar2);
                    aVar.remove(viewValueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    public final void Q(x xVar, x xVar2) {
        androidx.collection.a<View, w> aVar = new androidx.collection.a<>(xVar.f68419a);
        androidx.collection.a<View, w> aVar2 = new androidx.collection.a<>(xVar2.f68419a);
        int i11 = 0;
        while (true) {
            int[] iArr = this.f68366t;
            if (i11 >= iArr.length) {
                c(aVar, aVar2);
                return;
            }
            int i12 = iArr[i11];
            if (i12 == 1) {
                N(aVar, aVar2);
            } else if (i12 == 2) {
                P(aVar, aVar2, xVar.f68422d, xVar2.f68422d);
            } else if (i12 == 3) {
                M(aVar, aVar2, xVar.f68420b, xVar2.f68420b);
            } else if (i12 == 4) {
                O(aVar, aVar2, xVar.f68421c, xVar2.f68421c);
            }
            i11++;
        }
    }

    public final void R(j jVar, g gVar, boolean z11) {
        j jVar2 = this.D;
        if (jVar2 != null) {
            jVar2.R(jVar, gVar, z11);
        }
        ArrayList<f> arrayList = this.E;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = this.E.size();
        f[] fVarArr = this.f68369w;
        if (fVarArr == null) {
            fVarArr = new f[size];
        }
        this.f68369w = null;
        f[] fVarArr2 = (f[]) this.E.toArray(fVarArr);
        for (int i11 = 0; i11 < size; i11++) {
            gVar.a(fVarArr2[i11], jVar, z11);
            fVarArr2[i11] = null;
        }
        this.f68369w = fVarArr2;
    }

    public void S(g gVar, boolean z11) {
        R(this, gVar, z11);
    }

    public void T(@Nullable View view) {
        if (this.C) {
            return;
        }
        int size = this.f68371y.size();
        Animator[] animatorArr = (Animator[]) this.f68371y.toArray(this.f68372z);
        this.f68372z = J;
        for (int i11 = size - 1; i11 >= 0; i11--) {
            Animator animator = animatorArr[i11];
            animatorArr[i11] = null;
            animator.pause();
        }
        this.f68372z = animatorArr;
        S(g.f68385d, false);
        this.B = true;
    }

    public void U(@NonNull ViewGroup viewGroup) {
        d dVar;
        this.f68367u = new ArrayList<>();
        this.f68368v = new ArrayList<>();
        Q(this.f68363q, this.f68364r);
        androidx.collection.a<Animator, d> aVarB = B();
        int size = aVarB.size();
        WindowId windowId = viewGroup.getWindowId();
        for (int i11 = size - 1; i11 >= 0; i11--) {
            Animator animatorKeyAt = aVarB.keyAt(i11);
            if (animatorKeyAt != null && (dVar = aVarB.get(animatorKeyAt)) != null && dVar.f68376a != null && windowId.equals(dVar.f68379d)) {
                w wVar = dVar.f68378c;
                View view = dVar.f68376a;
                w wVarI = I(view, true);
                w wVarV = v(view, true);
                if (wVarI == null && wVarV == null) {
                    wVarV = this.f68364r.f68419a.get(view);
                }
                if ((wVarI != null || wVarV != null) && dVar.f68380e.J(wVar, wVarV)) {
                    dVar.f68380e.A().getClass();
                    if (animatorKeyAt.isRunning() || animatorKeyAt.isStarted()) {
                        animatorKeyAt.cancel();
                    } else {
                        aVarB.remove(animatorKeyAt);
                    }
                }
            }
        }
        p(viewGroup, this.f68363q, this.f68364r, this.f68367u, this.f68368v);
        Z();
    }

    @NonNull
    public j V(@NonNull f fVar) {
        j jVar;
        ArrayList<f> arrayList = this.E;
        if (arrayList == null) {
            return this;
        }
        if (!arrayList.remove(fVar) && (jVar = this.D) != null) {
            jVar.V(fVar);
        }
        if (this.E.size() == 0) {
            this.E = null;
        }
        return this;
    }

    @NonNull
    public j W(@NonNull View view) {
        this.f68353g.remove(view);
        return this;
    }

    public void X(@Nullable View view) {
        if (this.B) {
            if (!this.C) {
                int size = this.f68371y.size();
                Animator[] animatorArr = (Animator[]) this.f68371y.toArray(this.f68372z);
                this.f68372z = J;
                for (int i11 = size - 1; i11 >= 0; i11--) {
                    Animator animator = animatorArr[i11];
                    animatorArr[i11] = null;
                    animator.resume();
                }
                this.f68372z = animatorArr;
                S(g.f68386e, false);
            }
            this.B = false;
        }
    }

    public final void Y(Animator animator, androidx.collection.a<Animator, d> aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            f(animator);
        }
    }

    public void Z() {
        g0();
        androidx.collection.a<Animator, d> aVarB = B();
        for (Animator animator : this.F) {
            if (aVarB.containsKey(animator)) {
                g0();
                Y(animator, aVarB);
            }
        }
        this.F.clear();
        q();
    }

    @NonNull
    public j a(@NonNull f fVar) {
        if (this.E == null) {
            this.E = new ArrayList<>();
        }
        this.E.add(fVar);
        return this;
    }

    @NonNull
    public j a0(long j11) {
        this.f68350c = j11;
        return this;
    }

    @NonNull
    public j b(@NonNull View view) {
        this.f68353g.add(view);
        return this;
    }

    public void b0(@Nullable e eVar) {
        this.G = eVar;
    }

    public final void c(androidx.collection.a<View, w> aVar, androidx.collection.a<View, w> aVar2) {
        for (int i11 = 0; i11 < aVar.size(); i11++) {
            w wVarValueAt = aVar.valueAt(i11);
            if (K(wVarValueAt.f68417b)) {
                this.f68367u.add(wVarValueAt);
                this.f68368v.add(null);
            }
        }
        for (int i12 = 0; i12 < aVar2.size(); i12++) {
            w wVarValueAt2 = aVar2.valueAt(i12);
            if (K(wVarValueAt2.f68417b)) {
                this.f68368v.add(wVarValueAt2);
                this.f68367u.add(null);
            }
        }
    }

    @NonNull
    public j c0(@Nullable TimeInterpolator timeInterpolator) {
        this.f68351d = timeInterpolator;
        return this;
    }

    public void cancel() {
        int size = this.f68371y.size();
        Animator[] animatorArr = (Animator[]) this.f68371y.toArray(this.f68372z);
        this.f68372z = J;
        for (int i11 = size - 1; i11 >= 0; i11--) {
            Animator animator = animatorArr[i11];
            animatorArr[i11] = null;
            animator.cancel();
        }
        this.f68372z = animatorArr;
        S(g.f68384c, false);
    }

    public void d0(@Nullable k6.g gVar) {
        if (gVar == null) {
            this.I = L;
        } else {
            this.I = gVar;
        }
    }

    public void e0(@Nullable t tVar) {
    }

    public void f(@Nullable Animator animator) {
        if (animator == null) {
            q();
            return;
        }
        if (r() >= 0) {
            animator.setDuration(r());
        }
        if (C() >= 0) {
            animator.setStartDelay(C() + animator.getStartDelay());
        }
        if (t() != null) {
            animator.setInterpolator(t());
        }
        animator.addListener(new c());
        animator.start();
    }

    @NonNull
    public j f0(long j11) {
        this.f68349b = j11;
        return this;
    }

    public abstract void g(@NonNull w wVar);

    public void g0() {
        if (this.A == 0) {
            S(g.f68382a, false);
            this.C = false;
        }
        this.A++;
    }

    public final void h(View view, boolean z11) {
        if (view == null) {
            return;
        }
        int id2 = view.getId();
        ArrayList<Integer> arrayList = this.f68356j;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id2))) {
            ArrayList<View> arrayList2 = this.f68357k;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class<?>> arrayList3 = this.f68358l;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        if (this.f68358l.get(i11).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    w wVar = new w(view);
                    if (z11) {
                        k(wVar);
                    } else {
                        g(wVar);
                    }
                    wVar.f68418c.add(this);
                    j(wVar);
                    if (z11) {
                        d(this.f68363q, view, wVar);
                    } else {
                        d(this.f68364r, view, wVar);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.f68360n;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id2))) {
                        ArrayList<View> arrayList5 = this.f68361o;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class<?>> arrayList6 = this.f68362p;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i12 = 0; i12 < size2; i12++) {
                                    if (this.f68362p.get(i12).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i13 = 0; i13 < viewGroup.getChildCount(); i13++) {
                                h(viewGroup.getChildAt(i13), z11);
                            }
                        }
                    }
                }
            }
        }
    }

    public String h0(String str) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(getClass().getSimpleName());
        sb2.append("@");
        sb2.append(Integer.toHexString(hashCode()));
        sb2.append(": ");
        if (this.f68350c != -1) {
            sb2.append("dur(");
            sb2.append(this.f68350c);
            sb2.append(") ");
        }
        if (this.f68349b != -1) {
            sb2.append("dly(");
            sb2.append(this.f68349b);
            sb2.append(") ");
        }
        if (this.f68351d != null) {
            sb2.append("interp(");
            sb2.append(this.f68351d);
            sb2.append(") ");
        }
        if (this.f68352f.size() > 0 || this.f68353g.size() > 0) {
            sb2.append("tgts(");
            if (this.f68352f.size() > 0) {
                for (int i11 = 0; i11 < this.f68352f.size(); i11++) {
                    if (i11 > 0) {
                        sb2.append(", ");
                    }
                    sb2.append(this.f68352f.get(i11));
                }
            }
            if (this.f68353g.size() > 0) {
                for (int i12 = 0; i12 < this.f68353g.size(); i12++) {
                    if (i12 > 0) {
                        sb2.append(", ");
                    }
                    sb2.append(this.f68353g.get(i12));
                }
            }
            sb2.append(")");
        }
        return sb2.toString();
    }

    public void j(w wVar) {
    }

    public abstract void k(@NonNull w wVar);

    public void l(@NonNull ViewGroup viewGroup, boolean z11) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        androidx.collection.a<String, String> aVar;
        m(z11);
        if ((this.f68352f.size() > 0 || this.f68353g.size() > 0) && (((arrayList = this.f68354h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f68355i) == null || arrayList2.isEmpty()))) {
            for (int i11 = 0; i11 < this.f68352f.size(); i11++) {
                View viewFindViewById = viewGroup.findViewById(this.f68352f.get(i11).intValue());
                if (viewFindViewById != null) {
                    w wVar = new w(viewFindViewById);
                    if (z11) {
                        k(wVar);
                    } else {
                        g(wVar);
                    }
                    wVar.f68418c.add(this);
                    j(wVar);
                    if (z11) {
                        d(this.f68363q, viewFindViewById, wVar);
                    } else {
                        d(this.f68364r, viewFindViewById, wVar);
                    }
                }
            }
            for (int i12 = 0; i12 < this.f68353g.size(); i12++) {
                View view = this.f68353g.get(i12);
                w wVar2 = new w(view);
                if (z11) {
                    k(wVar2);
                } else {
                    g(wVar2);
                }
                wVar2.f68418c.add(this);
                j(wVar2);
                if (z11) {
                    d(this.f68363q, view, wVar2);
                } else {
                    d(this.f68364r, view, wVar2);
                }
            }
        } else {
            h(viewGroup, z11);
        }
        if (z11 || (aVar = this.H) == null) {
            return;
        }
        int size = aVar.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i13 = 0; i13 < size; i13++) {
            arrayList3.add(this.f68363q.f68422d.remove(this.H.keyAt(i13)));
        }
        for (int i14 = 0; i14 < size; i14++) {
            View view2 = (View) arrayList3.get(i14);
            if (view2 != null) {
                this.f68363q.f68422d.put(this.H.valueAt(i14), view2);
            }
        }
    }

    public void m(boolean z11) {
        if (z11) {
            this.f68363q.f68419a.clear();
            this.f68363q.f68420b.clear();
            this.f68363q.f68421c.b();
        } else {
            this.f68364r.f68419a.clear();
            this.f68364r.f68420b.clear();
            this.f68364r.f68421c.b();
        }
    }

    @Override // 
    @NonNull
    /* JADX INFO: renamed from: n */
    public j clone() {
        try {
            j jVar = (j) super.clone();
            jVar.F = new ArrayList<>();
            jVar.f68363q = new x();
            jVar.f68364r = new x();
            jVar.f68367u = null;
            jVar.f68368v = null;
            jVar.D = this;
            jVar.E = null;
            return jVar;
        } catch (CloneNotSupportedException e11) {
            throw new RuntimeException(e11);
        }
    }

    @Nullable
    public Animator o(@NonNull ViewGroup viewGroup, @Nullable w wVar, @Nullable w wVar2) {
        return null;
    }

    public void p(@NonNull ViewGroup viewGroup, @NonNull x xVar, @NonNull x xVar2, @NonNull ArrayList<w> arrayList, @NonNull ArrayList<w> arrayList2) {
        View view;
        Animator animator;
        w wVar;
        Animator animator2;
        w wVar2;
        androidx.collection.a<Animator, d> aVarB = B();
        SparseIntArray sparseIntArray = new SparseIntArray();
        A().getClass();
        int i11 = 0;
        for (int size = arrayList.size(); i11 < size; size = size) {
            w wVar3 = arrayList.get(i11);
            w wVar4 = arrayList2.get(i11);
            if (wVar3 != null && !wVar3.f68418c.contains(this)) {
                wVar3 = null;
            }
            if (wVar4 != null && !wVar4.f68418c.contains(this)) {
                wVar4 = null;
            }
            if ((wVar3 != null || wVar4 != null) && (wVar3 == null || wVar4 == null || J(wVar3, wVar4))) {
                Animator animatorO = o(viewGroup, wVar3, wVar4);
                if (animatorO != null) {
                    if (wVar4 != null) {
                        View view2 = wVar4.f68417b;
                        String[] strArrH = H();
                        if (strArrH != null && strArrH.length > 0) {
                            wVar2 = new w(view2);
                            w wVar5 = xVar2.f68419a.get(view2);
                            if (wVar5 != null) {
                                int i12 = 0;
                                while (i12 < strArrH.length) {
                                    Map<String, Object> map = wVar2.f68416a;
                                    Animator animator3 = animatorO;
                                    String str = strArrH[i12];
                                    map.put(str, wVar5.f68416a.get(str));
                                    i12++;
                                    animatorO = animator3;
                                    strArrH = strArrH;
                                }
                            }
                            Animator animator4 = animatorO;
                            int size2 = aVarB.size();
                            int i13 = 0;
                            while (true) {
                                if (i13 >= size2) {
                                    animator2 = animator4;
                                    break;
                                }
                                d dVar = aVarB.get(aVarB.keyAt(i13));
                                if (dVar.f68378c != null && dVar.f68376a == view2 && dVar.f68377b.equals(x()) && dVar.f68378c.equals(wVar2)) {
                                    animator2 = null;
                                    break;
                                }
                                i13++;
                            }
                        } else {
                            animator2 = animatorO;
                            wVar2 = null;
                        }
                        view = view2;
                        animator = animator2;
                        wVar = wVar2;
                    } else {
                        view = wVar3.f68417b;
                        animator = animatorO;
                        wVar = null;
                    }
                    if (animator != null) {
                        aVarB.put(animator, new d(view, x(), this, viewGroup.getWindowId(), wVar, animator));
                        this.F.add(animator);
                    }
                }
                i11++;
            }
            i11++;
        }
        if (sparseIntArray.size() != 0) {
            for (int i14 = 0; i14 < sparseIntArray.size(); i14++) {
                d dVar2 = aVarB.get(this.F.get(sparseIntArray.keyAt(i14)));
                dVar2.f68381f.setStartDelay((((long) sparseIntArray.valueAt(i14)) - Long.MAX_VALUE) + dVar2.f68381f.getStartDelay());
            }
        }
    }

    public void q() {
        int i11 = this.A - 1;
        this.A = i11;
        if (i11 == 0) {
            S(g.f68383b, false);
            for (int i12 = 0; i12 < this.f68363q.f68421c.o(); i12++) {
                View viewP = this.f68363q.f68421c.p(i12);
                if (viewP != null) {
                    viewP.setHasTransientState(false);
                }
            }
            for (int i13 = 0; i13 < this.f68364r.f68421c.o(); i13++) {
                View viewP2 = this.f68364r.f68421c.p(i13);
                if (viewP2 != null) {
                    viewP2.setHasTransientState(false);
                }
            }
            this.C = true;
        }
    }

    public long r() {
        return this.f68350c;
    }

    @Nullable
    public e s() {
        return this.G;
    }

    @Nullable
    public TimeInterpolator t() {
        return this.f68351d;
    }

    @NonNull
    public String toString() {
        return h0("");
    }

    public w v(View view, boolean z11) {
        u uVar = this.f68365s;
        if (uVar != null) {
            return uVar.v(view, z11);
        }
        ArrayList<w> arrayList = z11 ? this.f68367u : this.f68368v;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                i11 = -1;
                break;
            }
            w wVar = arrayList.get(i11);
            if (wVar == null) {
                return null;
            }
            if (wVar.f68417b == view) {
                break;
            }
            i11++;
        }
        if (i11 >= 0) {
            return (z11 ? this.f68368v : this.f68367u).get(i11);
        }
        return null;
    }

    @NonNull
    public String x() {
        return this.f68348a;
    }

    @NonNull
    public k6.g y() {
        return this.I;
    }

    @Nullable
    public t z() {
        return null;
    }
}
