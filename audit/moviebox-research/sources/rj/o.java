package rj;

import android.util.Log;
import androidx.compose.animation.core.j0;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.InvalidRegistrarException;
import com.google.firebase.components.MissingDependencyException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class o implements e, tk.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final bl.b<Set<Object>> f75549i = new bl.b() { // from class: rj.l
        @Override // bl.b
        public final Object get() {
            return Collections.emptySet();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<c<?>, bl.b<?>> f75550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<b0<?>, bl.b<?>> f75551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<b0<?>, v<?>> f75552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<bl.b<ComponentRegistrar>> f75553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Set<String> f75554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final t f75555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference<Boolean> f75556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j f75557h;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Executor f75558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<bl.b<ComponentRegistrar>> f75559b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<c<?>> f75560c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public j f75561d = j.f75542a;

        public b(Executor executor) {
            this.f75558a = executor;
        }

        public static /* synthetic */ ComponentRegistrar f(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }

        public b b(c<?> cVar) {
            this.f75560c.add(cVar);
            return this;
        }

        public b c(final ComponentRegistrar componentRegistrar) {
            this.f75559b.add(new bl.b() { // from class: rj.p
                @Override // bl.b
                public final Object get() {
                    return o.b.f(componentRegistrar);
                }
            });
            return this;
        }

        public b d(Collection<bl.b<ComponentRegistrar>> collection) {
            this.f75559b.addAll(collection);
            return this;
        }

        public o e() {
            return new o(this.f75558a, this.f75559b, this.f75560c, this.f75561d);
        }

        public b g(j jVar) {
            this.f75561d = jVar;
            return this;
        }
    }

    public o(Executor executor, Iterable<bl.b<ComponentRegistrar>> iterable, Collection<c<?>> collection, j jVar) {
        this.f75550a = new HashMap();
        this.f75551b = new HashMap();
        this.f75552c = new HashMap();
        this.f75554e = new HashSet();
        this.f75556g = new AtomicReference<>();
        t tVar = new t(executor);
        this.f75555f = tVar;
        this.f75557h = jVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(c.s(tVar, t.class, yk.d.class, yk.c.class));
        arrayList.add(c.s(this, tk.a.class, new Class[0]));
        for (c<?> cVar : collection) {
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        this.f75553d = q(iterable);
        n(arrayList);
    }

    public static b m(Executor executor) {
        return new b(executor);
    }

    public static <T> List<T> q(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @Override // rj.e
    public <T> bl.a<T> a(b0<T> b0Var) {
        bl.b<T> bVarD = d(b0Var);
        if (bVarD == null) {
            return z.e();
        }
        return bVarD instanceof z ? (z) bVarD : z.i(bVarD);
    }

    @Override // rj.e
    public /* synthetic */ Object b(Class cls) {
        return d.a(this, cls);
    }

    @Override // rj.e
    public /* synthetic */ Set c(Class cls) {
        return d.e(this, cls);
    }

    @Override // rj.e
    public synchronized <T> bl.b<T> d(b0<T> b0Var) {
        a0.c(b0Var, "Null interface requested.");
        return (bl.b) this.f75551b.get(b0Var);
    }

    @Override // rj.e
    public /* synthetic */ Object e(b0 b0Var) {
        return d.b(this, b0Var);
    }

    @Override // rj.e
    public /* synthetic */ bl.b f(Class cls) {
        return d.d(this, cls);
    }

    @Override // rj.e
    public /* synthetic */ Set g(b0 b0Var) {
        return d.f(this, b0Var);
    }

    @Override // rj.e
    public synchronized <T> bl.b<Set<T>> h(b0<T> b0Var) {
        v<?> vVar = this.f75552c.get(b0Var);
        if (vVar != null) {
            return vVar;
        }
        return (bl.b<Set<T>>) f75549i;
    }

    @Override // rj.e
    public /* synthetic */ bl.a i(Class cls) {
        return d.c(this, cls);
    }

    public final void n(List<c<?>> list) {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<bl.b<ComponentRegistrar>> it = this.f75553d.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = it.next().get();
                    if (componentRegistrar != null) {
                        list.addAll(this.f75557h.a(componentRegistrar));
                        it.remove();
                    }
                } catch (InvalidRegistrarException e11) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e11);
                }
            }
            Iterator<c<?>> it2 = list.iterator();
            while (it2.hasNext()) {
                for (Object obj : it2.next().j().toArray()) {
                    if (obj.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                        if (this.f75554e.contains(obj.toString())) {
                            it2.remove();
                            break;
                        }
                        this.f75554e.add(obj.toString());
                    }
                }
            }
            if (this.f75550a.isEmpty()) {
                q.a(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.f75550a.keySet());
                arrayList2.addAll(list);
                q.a(arrayList2);
            }
            for (final c<?> cVar : list) {
                this.f75550a.put(cVar, new u(new bl.b() { // from class: rj.k
                    @Override // bl.b
                    public final Object get() {
                        return this.f75543a.r(cVar);
                    }
                }));
            }
            arrayList.addAll(w(list));
            arrayList.addAll(x());
            v();
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            ((Runnable) it3.next()).run();
        }
        u();
    }

    public final void o(Map<c<?>, bl.b<?>> map, boolean z11) {
        for (Map.Entry<c<?>, bl.b<?>> entry : map.entrySet()) {
            c<?> key = entry.getKey();
            bl.b<?> value = entry.getValue();
            if (key.n() || (key.o() && z11)) {
                value.get();
            }
        }
        this.f75555f.d();
    }

    public void p(boolean z11) {
        HashMap map;
        if (j0.a(this.f75556g, null, Boolean.valueOf(z11))) {
            synchronized (this) {
                map = new HashMap(this.f75550a);
            }
            o(map, z11);
        }
    }

    public final /* synthetic */ Object r(c cVar) {
        return cVar.h().a(new c0(cVar, this));
    }

    public final void u() {
        Boolean bool = this.f75556g.get();
        if (bool != null) {
            o(this.f75550a, bool.booleanValue());
        }
    }

    public final void v() {
        for (c<?> cVar : this.f75550a.keySet()) {
            for (r rVar : cVar.g()) {
                if (rVar.g() && !this.f75552c.containsKey(rVar.c())) {
                    this.f75552c.put(rVar.c(), v.b(Collections.emptySet()));
                } else if (this.f75551b.containsKey(rVar.c())) {
                    continue;
                } else {
                    if (rVar.f()) {
                        throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", cVar, rVar.c()));
                    }
                    if (!rVar.g()) {
                        this.f75551b.put(rVar.c(), z.e());
                    }
                }
            }
        }
    }

    public final List<Runnable> w(List<c<?>> list) {
        ArrayList arrayList = new ArrayList();
        for (c<?> cVar : list) {
            if (cVar.p()) {
                final bl.b<?> bVar = this.f75550a.get(cVar);
                for (b0<? super Object> b0Var : cVar.j()) {
                    if (this.f75551b.containsKey(b0Var)) {
                        final z zVar = (z) this.f75551b.get(b0Var);
                        arrayList.add(new Runnable() { // from class: rj.m
                            @Override // java.lang.Runnable
                            public final void run() {
                                zVar.j(bVar);
                            }
                        });
                    } else {
                        this.f75551b.put(b0Var, bVar);
                    }
                }
            }
        }
        return arrayList;
    }

    public final List<Runnable> x() {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (Map.Entry<c<?>, bl.b<?>> entry : this.f75550a.entrySet()) {
            c<?> key = entry.getKey();
            if (!key.p()) {
                bl.b<?> value = entry.getValue();
                for (b0<? super Object> b0Var : key.j()) {
                    if (!map.containsKey(b0Var)) {
                        map.put(b0Var, new HashSet());
                    }
                    ((Set) map.get(b0Var)).add(value);
                }
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            if (this.f75552c.containsKey(entry2.getKey())) {
                final v<?> vVar = this.f75552c.get(entry2.getKey());
                for (final bl.b bVar : (Set) entry2.getValue()) {
                    arrayList.add(new Runnable() { // from class: rj.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            vVar.a(bVar);
                        }
                    });
                }
            } else {
                this.f75552c.put((b0) entry2.getKey(), v.b((Collection) entry2.getValue()));
            }
        }
        return arrayList;
    }
}
