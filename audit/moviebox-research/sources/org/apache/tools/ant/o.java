package org.apache.tools.ant;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class o extends t.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f72701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t f72702c;

    public o(t tVar, Method method, Method method2) {
        super(method);
        this.f72702c = tVar;
        this.f72701b = method2;
    }

    @Override // org.apache.tools.ant.t.b
    public void a(Project project, Object obj, String str) throws IllegalAccessException, InvocationTargetException {
        Method method = this.f72701b;
        Boolean[] boolArr = new Boolean[1];
        boolArr[0] = Project.N(str) ? Boolean.TRUE : Boolean.FALSE;
        method.invoke(obj, boolArr);
    }
}
