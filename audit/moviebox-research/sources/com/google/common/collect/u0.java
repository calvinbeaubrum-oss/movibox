package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class u0 {

    /* JADX INFO: compiled from: source.java */
    public static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Field f38732a;

        public b(Field field) {
            this.f38732a = field;
            field.setAccessible(true);
        }

        public void a(T t11, int i11) {
            try {
                this.f38732a.set(t11, Integer.valueOf(i11));
            } catch (IllegalAccessException e11) {
                throw new AssertionError(e11);
            }
        }

        public void b(T t11, Object obj) {
            try {
                this.f38732a.set(t11, obj);
            } catch (IllegalAccessException e11) {
                throw new AssertionError(e11);
            }
        }
    }

    public static <T> b<T> a(Class<T> cls, String str) {
        try {
            return new b<>(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e11) {
            throw new AssertionError(e11);
        }
    }

    public static <K, V> void b(Map<K, V> map, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        c(map, objectInputStream, objectInputStream.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void c(Map<K, V> map, ObjectInputStream objectInputStream, int i11) throws IOException, ClassNotFoundException {
        for (int i12 = 0; i12 < i11; i12++) {
            map.put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    public static <K, V> void d(h0<K, V> h0Var, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        e(h0Var, objectInputStream, objectInputStream.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void e(h0<K, V> h0Var, ObjectInputStream objectInputStream, int i11) throws IOException, ClassNotFoundException {
        for (int i12 = 0; i12 < i11; i12++) {
            Collection collection = h0Var.get(objectInputStream.readObject());
            int i13 = objectInputStream.readInt();
            for (int i14 = 0; i14 < i13; i14++) {
                collection.add(objectInputStream.readObject());
            }
        }
    }

    public static <E> void f(j0<E> j0Var, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        g(j0Var, objectInputStream, objectInputStream.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> void g(j0<E> j0Var, ObjectInputStream objectInputStream, int i11) throws IOException, ClassNotFoundException {
        for (int i12 = 0; i12 < i11; i12++) {
            j0Var.add(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    public static int h(ObjectInputStream objectInputStream) throws IOException {
        return objectInputStream.readInt();
    }

    public static <K, V> void i(Map<K, V> map, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    public static <K, V> void j(h0<K, V> h0Var, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(h0Var.asMap().size());
        for (Map.Entry<K, Collection<V>> entry : h0Var.asMap().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().size());
            Iterator<V> it = entry.getValue().iterator();
            while (it.hasNext()) {
                objectOutputStream.writeObject(it.next());
            }
        }
    }

    public static <E> void k(j0<E> j0Var, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(j0Var.entrySet().size());
        for (j0.a<E> aVar : j0Var.entrySet()) {
            objectOutputStream.writeObject(aVar.getElement());
            objectOutputStream.writeInt(aVar.getCount());
        }
    }
}
