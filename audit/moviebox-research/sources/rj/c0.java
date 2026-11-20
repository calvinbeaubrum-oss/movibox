package rj;

import com.google.firebase.components.DependencyException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c0 implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<b0<?>> f75529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<b0<?>> f75530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<b0<?>> f75531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<b0<?>> f75532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<b0<?>> f75533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<Class<?>> f75534f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f75535g;

    /* JADX INFO: compiled from: source.java */
    public static class a implements yk.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<Class<?>> f75536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final yk.c f75537b;

        public a(Set<Class<?>> set, yk.c cVar) {
            this.f75536a = set;
            this.f75537b = cVar;
        }
    }

    public c0(c<?> cVar, e eVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (r rVar : cVar.g()) {
            if (rVar.e()) {
                if (rVar.g()) {
                    hashSet4.add(rVar.c());
                } else {
                    hashSet.add(rVar.c());
                }
            } else if (rVar.d()) {
                hashSet3.add(rVar.c());
            } else if (rVar.g()) {
                hashSet5.add(rVar.c());
            } else {
                hashSet2.add(rVar.c());
            }
        }
        if (!cVar.k().isEmpty()) {
            hashSet.add(b0.b(yk.c.class));
        }
        this.f75529a = Collections.unmodifiableSet(hashSet);
        this.f75530b = Collections.unmodifiableSet(hashSet2);
        this.f75531c = Collections.unmodifiableSet(hashSet3);
        this.f75532d = Collections.unmodifiableSet(hashSet4);
        this.f75533e = Collections.unmodifiableSet(hashSet5);
        this.f75534f = cVar.k();
        this.f75535g = eVar;
    }

    @Override // rj.e
    public <T> bl.a<T> a(b0<T> b0Var) {
        if (this.f75531c.contains(b0Var)) {
            return this.f75535g.a(b0Var);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Deferred<%s>.", b0Var));
    }

    @Override // rj.e
    public <T> T b(Class<T> cls) {
        if (!this.f75529a.contains(b0.b(cls))) {
            throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        T t11 = (T) this.f75535g.b(cls);
        return !cls.equals(yk.c.class) ? t11 : (T) new a(this.f75534f, (yk.c) t11);
    }

    @Override // rj.e
    public /* synthetic */ Set c(Class cls) {
        return d.e(this, cls);
    }

    @Override // rj.e
    public <T> bl.b<T> d(b0<T> b0Var) {
        if (this.f75530b.contains(b0Var)) {
            return this.f75535g.d(b0Var);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<%s>.", b0Var));
    }

    @Override // rj.e
    public <T> T e(b0<T> b0Var) {
        if (this.f75529a.contains(b0Var)) {
            return (T) this.f75535g.e(b0Var);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", b0Var));
    }

    @Override // rj.e
    public <T> bl.b<T> f(Class<T> cls) {
        return d(b0.b(cls));
    }

    @Override // rj.e
    public <T> Set<T> g(b0<T> b0Var) {
        if (this.f75532d.contains(b0Var)) {
            return this.f75535g.g(b0Var);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Set<%s>.", b0Var));
    }

    @Override // rj.e
    public <T> bl.b<Set<T>> h(b0<T> b0Var) {
        if (this.f75533e.contains(b0Var)) {
            return this.f75535g.h(b0Var);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", b0Var));
    }

    @Override // rj.e
    public <T> bl.a<T> i(Class<T> cls) {
        return a(b0.b(cls));
    }
}
