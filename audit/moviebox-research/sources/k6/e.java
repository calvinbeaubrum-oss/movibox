package k6;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransitionImpl;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends FragmentTransitionImpl {

    /* JADX INFO: compiled from: source.java */
    public class a extends j.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f68326a;

        public a(Rect rect) {
            this.f68326a = rect;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements j.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f68328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f68329b;

        public b(View view, ArrayList arrayList) {
            this.f68328a = view;
            this.f68329b = arrayList;
        }

        @Override // k6.j.f
        public /* synthetic */ void a(j jVar, boolean z11) {
            k.b(this, jVar, z11);
        }

        @Override // k6.j.f
        public void b(@NonNull j jVar) {
            jVar.V(this);
            jVar.a(this);
        }

        @Override // k6.j.f
        public void c(@NonNull j jVar) {
        }

        @Override // k6.j.f
        public void d(@NonNull j jVar) {
        }

        @Override // k6.j.f
        public void e(@NonNull j jVar) {
            jVar.V(this);
            this.f68328a.setVisibility(8);
            int size = this.f68329b.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((View) this.f68329b.get(i11)).setVisibility(0);
            }
        }

        @Override // k6.j.f
        public void f(@NonNull j jVar) {
        }

        @Override // k6.j.f
        public /* synthetic */ void g(j jVar, boolean z11) {
            k.a(this, jVar, z11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f68331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f68332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f68333c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ArrayList f68334d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Object f68335f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ ArrayList f68336g;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f68331a = obj;
            this.f68332b = arrayList;
            this.f68333c = obj2;
            this.f68334d = arrayList2;
            this.f68335f = obj3;
            this.f68336g = arrayList3;
        }

        @Override // k6.r, k6.j.f
        public void b(@NonNull j jVar) {
            Object obj = this.f68331a;
            if (obj != null) {
                e.this.y(obj, this.f68332b, null);
            }
            Object obj2 = this.f68333c;
            if (obj2 != null) {
                e.this.y(obj2, this.f68334d, null);
            }
            Object obj3 = this.f68335f;
            if (obj3 != null) {
                e.this.y(obj3, this.f68336g, null);
            }
        }

        @Override // k6.j.f
        public void e(@NonNull j jVar) {
            jVar.V(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements j.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f68338a;

        public d(Runnable runnable) {
            this.f68338a = runnable;
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
        }

        @Override // k6.j.f
        public void e(@NonNull j jVar) {
            this.f68338a.run();
        }

        @Override // k6.j.f
        public void f(@NonNull j jVar) {
        }

        @Override // k6.j.f
        public /* synthetic */ void g(j jVar, boolean z11) {
            k.a(this, jVar, z11);
        }
    }

    /* JADX INFO: renamed from: k6.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0735e extends j.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f68340a;

        public C0735e(Rect rect) {
            this.f68340a = rect;
        }
    }

    public static boolean w(j jVar) {
        return (FragmentTransitionImpl.i(jVar.D()) && FragmentTransitionImpl.i(jVar.E()) && FragmentTransitionImpl.i(jVar.F())) ? false : true;
    }

    public static /* synthetic */ void x(Runnable runnable, j jVar, Runnable runnable2) {
        if (runnable != null) {
            runnable.run();
        } else {
            jVar.cancel();
            runnable2.run();
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void a(@NonNull Object obj, @NonNull View view) {
        if (obj != null) {
            ((j) obj).b(view);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void b(@NonNull Object obj, @NonNull ArrayList<View> arrayList) {
        j jVar = (j) obj;
        if (jVar == null) {
            return;
        }
        int i11 = 0;
        if (jVar instanceof u) {
            u uVar = (u) jVar;
            int iN0 = uVar.n0();
            while (i11 < iN0) {
                b(uVar.m0(i11), arrayList);
                i11++;
            }
            return;
        }
        if (w(jVar) || !FragmentTransitionImpl.i(jVar.G())) {
            return;
        }
        int size = arrayList.size();
        while (i11 < size) {
            jVar.b(arrayList.get(i11));
            i11++;
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void c(@NonNull ViewGroup viewGroup, @Nullable Object obj) {
        s.a(viewGroup, (j) obj);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public boolean e(@NonNull Object obj) {
        return obj instanceof j;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    @Nullable
    public Object f(@Nullable Object obj) {
        if (obj != null) {
            return ((j) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    @Nullable
    public Object j(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3) {
        j jVarS0 = (j) obj;
        j jVar = (j) obj2;
        j jVar2 = (j) obj3;
        if (jVarS0 != null && jVar != null) {
            jVarS0 = new u().k0(jVarS0).k0(jVar).s0(1);
        } else if (jVarS0 == null) {
            jVarS0 = jVar != null ? jVar : null;
        }
        if (jVar2 == null) {
            return jVarS0;
        }
        u uVar = new u();
        if (jVarS0 != null) {
            uVar.k0(jVarS0);
        }
        uVar.k0(jVar2);
        return uVar;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    @NonNull
    public Object k(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3) {
        u uVar = new u();
        if (obj != null) {
            uVar.k0((j) obj);
        }
        if (obj2 != null) {
            uVar.k0((j) obj2);
        }
        if (obj3 != null) {
            uVar.k0((j) obj3);
        }
        return uVar;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void m(@NonNull Object obj, @NonNull View view, @NonNull ArrayList<View> arrayList) {
        ((j) obj).a(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void n(@NonNull Object obj, @Nullable Object obj2, @Nullable ArrayList<View> arrayList, @Nullable Object obj3, @Nullable ArrayList<View> arrayList2, @Nullable Object obj4, @Nullable ArrayList<View> arrayList3) {
        ((j) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void o(@NonNull Object obj, @NonNull Rect rect) {
        if (obj != null) {
            ((j) obj).b0(new C0735e(rect));
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void p(@NonNull Object obj, @Nullable View view) {
        if (view != null) {
            Rect rect = new Rect();
            h(view, rect);
            ((j) obj).b0(new a(rect));
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void q(@NonNull Fragment fragment, @NonNull Object obj, @NonNull androidx.core.os.d dVar, @NonNull Runnable runnable) {
        z(fragment, obj, dVar, null, runnable);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void s(@NonNull Object obj, @NonNull View view, @NonNull ArrayList<View> arrayList) {
        u uVar = (u) obj;
        List<View> listG = uVar.G();
        listG.clear();
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            FragmentTransitionImpl.d(listG, arrayList.get(i11));
        }
        listG.add(view);
        arrayList.add(view);
        b(uVar, arrayList);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void t(@Nullable Object obj, @Nullable ArrayList<View> arrayList, @Nullable ArrayList<View> arrayList2) {
        u uVar = (u) obj;
        if (uVar != null) {
            uVar.G().clear();
            uVar.G().addAll(arrayList2);
            y(uVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    @Nullable
    public Object u(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        u uVar = new u();
        uVar.k0((j) obj);
        return uVar;
    }

    public void y(@NonNull Object obj, @SuppressLint({"UnknownNullness"}) ArrayList<View> arrayList, @SuppressLint({"UnknownNullness"}) ArrayList<View> arrayList2) {
        j jVar = (j) obj;
        int i11 = 0;
        if (jVar instanceof u) {
            u uVar = (u) jVar;
            int iN0 = uVar.n0();
            while (i11 < iN0) {
                y(uVar.m0(i11), arrayList, arrayList2);
                i11++;
            }
            return;
        }
        if (w(jVar)) {
            return;
        }
        List<View> listG = jVar.G();
        if (listG.size() == arrayList.size() && listG.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i11 < size) {
                jVar.b(arrayList2.get(i11));
                i11++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                jVar.W(arrayList.get(size2));
            }
        }
    }

    public void z(@NonNull Fragment fragment, @NonNull Object obj, @NonNull androidx.core.os.d dVar, @Nullable final Runnable runnable, @NonNull final Runnable runnable2) {
        final j jVar = (j) obj;
        dVar.b(new androidx.core.os.d.a() { // from class: k6.d
            @Override // androidx.core.os.d.a
            public final void onCancel() {
                e.x(runnable, jVar, runnable2);
            }
        });
        jVar.a(new d(runnable2));
    }
}
