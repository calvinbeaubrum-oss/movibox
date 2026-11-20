package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a extends AccessibleObject implements Member {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccessibleObject f39906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Member f39907b;

    public <M extends AccessibleObject & Member> a(M m11) {
        l.n(m11);
        this.f39906a = m11;
        this.f39907b = m11;
    }

    public TypeToken<?> a() {
        return TypeToken.of((Class) getDeclaringClass());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return a().equals(aVar.a()) && this.f39907b.equals(aVar.f39907b);
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return (A) this.f39906a.getAnnotation(cls);
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final Annotation[] getAnnotations() {
        return this.f39906a.getAnnotations();
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final Annotation[] getDeclaredAnnotations() {
        return this.f39906a.getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.Member
    public Class<?> getDeclaringClass() {
        return this.f39907b.getDeclaringClass();
    }

    @Override // java.lang.reflect.Member
    public final int getModifiers() {
        return this.f39907b.getModifiers();
    }

    @Override // java.lang.reflect.Member
    public final String getName() {
        return this.f39907b.getName();
    }

    public int hashCode() {
        return this.f39907b.hashCode();
    }

    @Override // java.lang.reflect.AccessibleObject
    public final boolean isAccessible() {
        return this.f39906a.isAccessible();
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.f39906a.isAnnotationPresent(cls);
    }

    @Override // java.lang.reflect.Member
    public final boolean isSynthetic() {
        return this.f39907b.isSynthetic();
    }

    @Override // java.lang.reflect.AccessibleObject
    public final void setAccessible(boolean z11) throws SecurityException {
        this.f39906a.setAccessible(z11);
    }

    public String toString() {
        return this.f39907b.toString();
    }
}
