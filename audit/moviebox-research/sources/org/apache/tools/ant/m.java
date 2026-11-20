package org.apache.tools.ant;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class m extends t.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f72696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t f72697c;

    public m(t tVar, Method method, Method method2) {
        super(method);
        this.f72697c = tVar;
        this.f72696b = method2;
    }

    @Override // org.apache.tools.ant.t.b
    public void a(Project project, Object obj, String str) throws IllegalAccessException, InvocationTargetException {
        this.f72696b.invoke(obj, str);
    }
}
