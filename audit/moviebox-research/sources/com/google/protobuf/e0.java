package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e0 f41231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e0 f41232b;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends e0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Class<?> f41233c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        public b() {
            super();
        }

        public static <E> List<E> f(Object obj, long j11) {
            return (List) l1.G(obj, j11);
        }

        public static <L> List<L> g(Object obj, long j11, int i11) {
            Object obj2;
            List<L> listC2;
            List<L> listF = f(obj, j11);
            if (listF.isEmpty()) {
                if (listF instanceof d0) {
                    listC2 = new c0(i11);
                } else {
                    listC2 = ((listF instanceof w0) && (listF instanceof y.j)) ? ((y.j) listF).c2(i11) : new ArrayList<>(i11);
                }
                l1.W(obj, j11, listC2);
                return listC2;
            }
            if (f41233c.isAssignableFrom(listF.getClass())) {
                ArrayList arrayList = new ArrayList(listF.size() + i11);
                arrayList.addAll(listF);
                l1.W(obj, j11, arrayList);
                obj2 = arrayList;
            } else {
                if (!(listF instanceof k1)) {
                    if (!(listF instanceof w0) || !(listF instanceof y.j)) {
                        return listF;
                    }
                    y.j jVar = (y.j) listF;
                    if (jVar.m()) {
                        return listF;
                    }
                    y.j jVarC2 = jVar.c2(listF.size() + i11);
                    l1.W(obj, j11, jVarC2);
                    return jVarC2;
                }
                c0 c0Var = new c0(listF.size() + i11);
                c0Var.addAll((k1) listF);
                l1.W(obj, j11, c0Var);
                obj2 = c0Var;
            }
            return (List<L>) obj2;
        }

        @Override // com.google.protobuf.e0
        public void c(Object obj, long j11) {
            Object objUnmodifiableList;
            List list = (List) l1.G(obj, j11);
            if (list instanceof d0) {
                objUnmodifiableList = ((d0) list).q();
            } else {
                if (f41233c.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof w0) && (list instanceof y.j)) {
                    y.j jVar = (y.j) list;
                    if (jVar.m()) {
                        jVar.k();
                        return;
                    }
                    return;
                }
                objUnmodifiableList = Collections.unmodifiableList(list);
            }
            l1.W(obj, j11, objUnmodifiableList);
        }

        @Override // com.google.protobuf.e0
        public <E> void d(Object obj, Object obj2, long j11) {
            List listF = f(obj2, j11);
            List listG = g(obj, j11, listF.size());
            int size = listG.size();
            int size2 = listF.size();
            if (size > 0 && size2 > 0) {
                listG.addAll(listF);
            }
            if (size > 0) {
                listF = listG;
            }
            l1.W(obj, j11, listF);
        }

        @Override // com.google.protobuf.e0
        public <L> List<L> e(Object obj, long j11) {
            return g(obj, j11, 10);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends e0 {
        public c() {
            super();
        }

        public static <E> y.j<E> f(Object obj, long j11) {
            return (y.j) l1.G(obj, j11);
        }

        @Override // com.google.protobuf.e0
        public void c(Object obj, long j11) {
            f(obj, j11).k();
        }

        @Override // com.google.protobuf.e0
        public <E> void d(Object obj, Object obj2, long j11) {
            y.j jVarF = f(obj, j11);
            y.j jVarF2 = f(obj2, j11);
            int size = jVarF.size();
            int size2 = jVarF2.size();
            if (size > 0 && size2 > 0) {
                if (!jVarF.m()) {
                    jVarF = jVarF.c2(size2 + size);
                }
                jVarF.addAll(jVarF2);
            }
            if (size > 0) {
                jVarF2 = jVarF;
            }
            l1.W(obj, j11, jVarF2);
        }

        @Override // com.google.protobuf.e0
        public <L> List<L> e(Object obj, long j11) {
            y.j jVarF = f(obj, j11);
            if (jVarF.m()) {
                return jVarF;
            }
            int size = jVarF.size();
            y.j jVarC2 = jVarF.c2(size == 0 ? 10 : size * 2);
            l1.W(obj, j11, jVarC2);
            return jVarC2;
        }
    }

    static {
        f41231a = new b();
        f41232b = new c();
    }

    public e0() {
    }

    public static e0 a() {
        return f41231a;
    }

    public static e0 b() {
        return f41232b;
    }

    public abstract void c(Object obj, long j11);

    public abstract <L> void d(Object obj, Object obj2, long j11);

    public abstract <L> List<L> e(Object obj, long j11);
}
