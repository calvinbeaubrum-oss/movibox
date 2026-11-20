package org.apache.tools.ant;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class j extends t.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f72689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f72690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ t f72691d;

    public j(t tVar, Method method, Object obj, Object obj2) {
        super(method);
        this.f72691d = tVar;
        this.f72689b = obj;
        this.f72690c = obj2;
    }

    @Override // org.apache.tools.ant.t.e
    public Object a(Project project, Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        if (!b().getName().endsWith("Configured")) {
            b().invoke(obj, this.f72689b);
        }
        return this.f72690c;
    }

    @Override // org.apache.tools.ant.t.e
    public Object c() {
        return this.f72689b;
    }

    @Override // org.apache.tools.ant.t.e
    public void e(Object obj, Object obj2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        if (b().getName().endsWith("Configured")) {
            b().invoke(obj, this.f72689b);
        }
    }
}
