package kj;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.firebase.abt.AbtException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bl.b<nj.a> f68609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f68610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public Integer f68611c = null;

    public b(Context context, bl.b<nj.a> bVar, String str) {
        this.f68609a = bVar;
        this.f68610b = str;
    }

    public static List<a> c(List<Map<String, String>> list) throws AbtException {
        ArrayList arrayList = new ArrayList();
        Iterator<Map<String, String>> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a.a(it.next()));
        }
        return arrayList;
    }

    public final void a(nj.a.c cVar) {
        this.f68609a.get().a(cVar);
    }

    public final void b(List<a> list) {
        ArrayDeque arrayDeque = new ArrayDeque(d());
        int iG = g();
        for (a aVar : list) {
            while (arrayDeque.size() >= iG) {
                i(((nj.a.c) arrayDeque.pollFirst()).f71998b);
            }
            nj.a.c cVarD = aVar.d(this.f68610b);
            a(cVarD);
            arrayDeque.offer(cVarD);
        }
    }

    public final List<nj.a.c> d() {
        return this.f68609a.get().g(this.f68610b, "");
    }

    public final ArrayList<a> e(List<a> list, Set<String> set) {
        ArrayList<a> arrayList = new ArrayList<>();
        for (a aVar : list) {
            if (!set.contains(aVar.b())) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public final ArrayList<nj.a.c> f(List<nj.a.c> list, Set<String> set) {
        ArrayList<nj.a.c> arrayList = new ArrayList<>();
        for (nj.a.c cVar : list) {
            if (!set.contains(cVar.f71998b)) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public final int g() {
        if (this.f68611c == null) {
            this.f68611c = Integer.valueOf(this.f68609a.get().f(this.f68610b));
        }
        return this.f68611c.intValue();
    }

    public void h() throws AbtException {
        m();
        j(d());
    }

    public final void i(String str) {
        this.f68609a.get().clearConditionalUserProperty(str, null, null);
    }

    public final void j(Collection<nj.a.c> collection) {
        Iterator<nj.a.c> it = collection.iterator();
        while (it.hasNext()) {
            i(it.next().f71998b);
        }
    }

    public void k(List<Map<String, String>> list) throws AbtException {
        m();
        if (list == null) {
            throw new IllegalArgumentException("The replacementExperiments list is null.");
        }
        l(c(list));
    }

    public final void l(List<a> list) throws AbtException {
        if (list.isEmpty()) {
            h();
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().b());
        }
        List<nj.a.c> listD = d();
        HashSet hashSet2 = new HashSet();
        Iterator<nj.a.c> it2 = listD.iterator();
        while (it2.hasNext()) {
            hashSet2.add(it2.next().f71998b);
        }
        j(f(listD, hashSet));
        b(e(list, hashSet2));
    }

    public final void m() throws AbtException {
        if (this.f68609a.get() == null) {
            throw new AbtException("The Analytics SDK is not available. Please check that the Analytics SDK is included in your app dependencies.");
        }
    }
}
