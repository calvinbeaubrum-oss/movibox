package com.transsion.json;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f52933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f52934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f52935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Class f52936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Field f52937e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Method f52938f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Method f52939g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<Class<?>, Method> f52940h = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h<? extends com.transsion.json.b.n> f52941i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h<? extends p> f52942j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Boolean f52943k = null;

    public d(String str, c cVar) {
        this.f52934b = str;
        this.f52933a = str;
        this.f52935c = cVar;
        Field fieldB = cVar.b(str);
        this.f52937e = fieldB;
        if (fieldB == null || !fieldB.isAnnotationPresent(eu.a.class)) {
            return;
        }
        c((eu.a) fieldB.getAnnotation(eu.a.class));
    }

    public d(Field field, c cVar) {
        String name = field.getName();
        this.f52934b = name;
        this.f52933a = name;
        this.f52935c = cVar;
        this.f52937e = field;
        this.f52936d = field.getType();
        if (field.isAnnotationPresent(eu.a.class)) {
            c((eu.a) field.getAnnotation(eu.a.class));
        }
    }

    public Object a(Object obj) {
        try {
            Method methodI = i();
            if (methodI != null) {
                return methodI.invoke(obj, null);
            }
            Field field = this.f52937e;
            if (field != null) {
                return field.get(obj);
            }
            return null;
        } catch (IllegalAccessException e11) {
            e = e11;
            throw new k("Error while reading property " + this.f52936d.getName() + InstructionFileId.DOT + this.f52933a, e);
        } catch (InvocationTargetException e12) {
            e = e12;
            throw new k("Error while reading property " + this.f52936d.getName() + InstructionFileId.DOT + this.f52933a, e);
        }
    }

    public String b() {
        return this.f52934b;
    }

    public final void c(eu.a aVar) {
        this.f52934b = aVar.name().length() > 0 ? aVar.name() : this.f52933a;
        this.f52941i = aVar.transformer() == com.transsion.json.b.n.class ? null : new h<>(aVar.transformer());
        this.f52942j = aVar.objectFactory() != p.class ? new h<>(aVar.objectFactory()) : null;
        this.f52943k = Boolean.valueOf(aVar.include());
    }

    public void d(Method method) {
        Class<?> cls = method.getParameterTypes()[0];
        if (this.f52936d == null) {
            this.f52936d = cls;
        }
        this.f52940h.put(cls, method);
        method.setAccessible(true);
    }

    public String e() {
        return this.f52933a;
    }

    public void f(Method method) {
        if (this.f52936d == null) {
            this.f52936d = method.getReturnType();
            this.f52938f = method;
            method.setAccessible(true);
        } else if (method.getReturnType().isAssignableFrom(this.f52936d)) {
            this.f52938f = method;
            method.setAccessible(true);
        }
        Method method2 = this.f52938f;
        if (method2 == null || !method2.isAnnotationPresent(eu.a.class)) {
            return;
        }
        c((eu.a) this.f52938f.getAnnotation(eu.a.class));
    }

    public Field g() {
        return this.f52937e;
    }

    public Class h() {
        return this.f52936d;
    }

    public Method i() {
        return (this.f52938f == null && this.f52935c.e() != null && this.f52935c.e().h(this.f52933a)) ? this.f52935c.e().f(this.f52933a).i() : this.f52938f;
    }

    public com.transsion.json.b.n j() throws IllegalAccessException, InstantiationException {
        h<? extends com.transsion.json.b.n> hVar = this.f52941i;
        if (hVar != null) {
            return hVar.a();
        }
        return null;
    }

    public Method k() {
        if (this.f52939g == null) {
            Method method = this.f52940h.get(this.f52936d);
            this.f52939g = method;
            if (method == null && this.f52935c.e() != null && this.f52935c.e().h(this.f52933a)) {
                return this.f52935c.e().f(this.f52933a).k();
            }
        }
        return this.f52939g;
    }

    public Boolean l() {
        return this.f52943k;
    }

    public boolean m() {
        return i() == null && k() == null && !Modifier.isPublic(this.f52937e.getModifiers());
    }

    public Boolean n() {
        Field field;
        Method methodI = i();
        return Boolean.valueOf(((methodI == null || Modifier.isStatic(methodI.getModifiers())) && ((field = this.f52937e) == null || Modifier.isStatic(field.getModifiers()) || Modifier.isTransient(this.f52937e.getModifiers()))) ? false : true);
    }

    public Boolean o() {
        Field field = this.f52937e;
        return Boolean.valueOf(field != null && Modifier.isTransient(field.getModifiers()));
    }

    public Boolean p() {
        Field field;
        return Boolean.valueOf((k() == null && ((field = this.f52937e) == null || !Modifier.isPublic(field.getModifiers()) || Modifier.isTransient(this.f52937e.getModifiers()))) ? false : true);
    }
}
