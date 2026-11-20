package rj;

import com.google.firebase.components.DependencyCycleException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class q {

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final rj.c<?> f75563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set<b> f75564b = new HashSet();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set<b> f75565c = new HashSet();

        public b(rj.c<?> cVar) {
            this.f75563a = cVar;
        }

        public void a(b bVar) {
            this.f75564b.add(bVar);
        }

        public void b(b bVar) {
            this.f75565c.add(bVar);
        }

        public rj.c<?> c() {
            return this.f75563a;
        }

        public Set<b> d() {
            return this.f75564b;
        }

        public boolean e() {
            return this.f75564b.isEmpty();
        }

        public boolean f() {
            return this.f75565c.isEmpty();
        }

        public void g(b bVar) {
            this.f75565c.remove(bVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b0<?> f75566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f75567b;

        public c(b0<?> b0Var, boolean z11) {
            this.f75566a = b0Var;
            this.f75567b = z11;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return cVar.f75566a.equals(this.f75566a) && cVar.f75567b == this.f75567b;
        }

        public int hashCode() {
            return ((this.f75566a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f75567b).hashCode();
        }
    }

    public static void a(List<rj.c<?>> list) {
        Set<b> setC = c(list);
        Set<b> setB = b(setC);
        int i11 = 0;
        while (!setB.isEmpty()) {
            b next = setB.iterator().next();
            setB.remove(next);
            i11++;
            for (b bVar : next.d()) {
                bVar.g(next);
                if (bVar.f()) {
                    setB.add(bVar);
                }
            }
        }
        if (i11 == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar2 : setC) {
            if (!bVar2.f() && !bVar2.e()) {
                arrayList.add(bVar2.c());
            }
        }
        throw new DependencyCycleException(arrayList);
    }

    public static Set<b> b(Set<b> set) {
        HashSet hashSet = new HashSet();
        for (b bVar : set) {
            if (bVar.f()) {
                hashSet.add(bVar);
            }
        }
        return hashSet;
    }

    public static Set<b> c(List<rj.c<?>> list) {
        Set<b> set;
        HashMap map = new HashMap(list.size());
        Iterator<rj.c<?>> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                Iterator it2 = map.values().iterator();
                while (it2.hasNext()) {
                    for (b bVar : (Set) it2.next()) {
                        for (r rVar : bVar.c().g()) {
                            if (rVar.e() && (set = (Set) map.get(new c(rVar.c(), rVar.g()))) != null) {
                                for (b bVar2 : set) {
                                    bVar.a(bVar2);
                                    bVar2.b(bVar);
                                }
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator it3 = map.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                return hashSet;
            }
            rj.c<?> next = it.next();
            b bVar3 = new b(next);
            for (b0<? super Object> b0Var : next.j()) {
                c cVar = new c(b0Var, !next.p());
                if (!map.containsKey(cVar)) {
                    map.put(cVar, new HashSet());
                }
                Set set2 = (Set) map.get(cVar);
                if (!set2.isEmpty() && !cVar.f75567b) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", b0Var));
                }
                set2.add(bVar3);
            }
        }
    }
}
