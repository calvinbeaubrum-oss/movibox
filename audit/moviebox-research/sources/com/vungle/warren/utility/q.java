package com.vungle.warren.utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class q extends ObjectInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Class<?>> f62639a;

    public q(InputStream inputStream, List<Class<?>> list) throws IOException {
        super(inputStream);
        this.f62639a = list;
    }

    @Override // java.io.ObjectInputStream
    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException, IOException {
        Class<?> clsResolveClass = super.resolveClass(objectStreamClass);
        if (this.f62639a == null || Number.class.isAssignableFrom(clsResolveClass) || String.class.equals(clsResolveClass) || Boolean.class.equals(clsResolveClass) || clsResolveClass.isArray() || this.f62639a.contains(clsResolveClass)) {
            return clsResolveClass;
        }
        throw new IOException("Deserialization is not allowed for " + objectStreamClass.getName());
    }
}
