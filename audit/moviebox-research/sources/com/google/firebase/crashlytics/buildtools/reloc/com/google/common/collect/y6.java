package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class y6 {

    /* JADX INFO: compiled from: source.java */
    public static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Field f39814a;

        public b(Field field) {
            this.f39814a = field;
            field.setAccessible(true);
        }

        public void a(T t11, int i11) {
            try {
                this.f39814a.set(t11, Integer.valueOf(i11));
            } catch (IllegalAccessException e11) {
                throw new AssertionError(e11);
            }
        }

        public void b(T t11, Object obj) {
            try {
                this.f39814a.set(t11, obj);
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

    public static <K, V> void d(z5<K, V> z5Var, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        e(z5Var, objectInputStream, objectInputStream.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void e(z5<K, V> z5Var, ObjectInputStream objectInputStream, int i11) throws IOException, ClassNotFoundException {
        for (int i12 = 0; i12 < i11; i12++) {
            Collection collection = z5Var.get(objectInputStream.readObject());
            int i13 = objectInputStream.readInt();
            for (int i14 = 0; i14 < i13; i14++) {
                collection.add(objectInputStream.readObject());
            }
        }
    }

    public static <E> void f(l6<E> l6Var, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        g(l6Var, objectInputStream, objectInputStream.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> void g(l6<E> l6Var, ObjectInputStream objectInputStream, int i11) throws IOException, ClassNotFoundException {
        for (int i12 = 0; i12 < i11; i12++) {
            l6Var.add(objectInputStream.readObject(), objectInputStream.readInt());
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

    public static <K, V> void j(z5<K, V> z5Var, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(z5Var.asMap().size());
        for (Map.Entry<K, Collection<V>> entry : z5Var.asMap().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().size());
            Iterator<V> it = entry.getValue().iterator();
            while (it.hasNext()) {
                objectOutputStream.writeObject(it.next());
            }
        }
    }

    public static <E> void k(l6<E> l6Var, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(l6Var.entrySet().size());
        for (l6.a<E> aVar : l6Var.entrySet()) {
            objectOutputStream.writeObject(aVar.getElement());
            objectOutputStream.writeInt(aVar.getCount());
        }
    }
}
