package org.apache.tools.ant;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class p extends t.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f72703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t f72704c;

    public p(t tVar, Method method, Method method2) {
        super(method);
        this.f72704c = tVar;
        this.f72703b = method2;
    }

    @Override // org.apache.tools.ant.t.b
    public void a(Project project, Object obj, String str) throws IllegalAccessException, BuildException, InvocationTargetException {
        try {
            this.f72703b.invoke(obj, Class.forName(str));
        } catch (ClassNotFoundException e11) {
            throw new BuildException(e11);
        }
    }
}
