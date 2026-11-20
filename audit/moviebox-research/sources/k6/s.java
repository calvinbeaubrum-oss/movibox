package k6;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static j f68405a = new k6.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ThreadLocal<WeakReference<androidx.collection.a<ViewGroup, ArrayList<j>>>> f68406b = new ThreadLocal<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ArrayList<ViewGroup> f68407c = new ArrayList<>();

    /* JADX INFO: compiled from: source.java */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public j f68408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ViewGroup f68409b;

        /* JADX INFO: renamed from: k6.s$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0736a extends r {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ androidx.collection.a f68410a;

            public C0736a(androidx.collection.a aVar) {
                this.f68410a = aVar;
            }

            @Override // k6.j.f
            public void e(@NonNull j jVar) {
                ((ArrayList) this.f68410a.get(a.this.f68409b)).remove(jVar);
                jVar.V(this);
            }
        }

        public a(j jVar, ViewGroup viewGroup) {
            this.f68408a = jVar;
            this.f68409b = viewGroup;
        }

        public final void a() {
            this.f68409b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f68409b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!s.f68407c.remove(this.f68409b)) {
                return true;
            }
            androidx.collection.a<ViewGroup, ArrayList<j>> aVarB = s.b();
            ArrayList<j> arrayList = aVarB.get(this.f68409b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                aVarB.put(this.f68409b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f68408a);
            this.f68408a.a(new C0736a(aVarB));
            this.f68408a.l(this.f68409b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((j) it.next()).X(this.f68409b);
                }
            }
            this.f68408a.U(this.f68409b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            s.f68407c.remove(this.f68409b);
            ArrayList<j> arrayList = s.b().get(this.f68409b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<j> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().X(this.f68409b);
                }
            }
            this.f68408a.m(true);
        }
    }

    public static void a(@NonNull ViewGroup viewGroup, @Nullable j jVar) {
        if (f68407c.contains(viewGroup) || !viewGroup.isLaidOut()) {
            return;
        }
        f68407c.add(viewGroup);
        if (jVar == null) {
            jVar = f68405a;
        }
        j jVarClone = jVar.clone();
        d(viewGroup, jVarClone);
        i.c(viewGroup, null);
        c(viewGroup, jVarClone);
    }

    public static androidx.collection.a<ViewGroup, ArrayList<j>> b() {
        androidx.collection.a<ViewGroup, ArrayList<j>> aVar;
        WeakReference<androidx.collection.a<ViewGroup, ArrayList<j>>> weakReference = f68406b.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        androidx.collection.a<ViewGroup, ArrayList<j>> aVar2 = new androidx.collection.a<>();
        f68406b.set(new WeakReference<>(aVar2));
        return aVar2;
    }

    public static void c(ViewGroup viewGroup, j jVar) {
        if (jVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(jVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    public static void d(ViewGroup viewGroup, j jVar) {
        ArrayList<j> arrayList = b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<j> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().T(viewGroup);
            }
        }
        if (jVar != null) {
            jVar.l(viewGroup, true);
        }
        i iVarB = i.b(viewGroup);
        if (iVarB != null) {
            iVarB.a();
        }
    }
}
