package org.apache.tools.ant;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class r extends t.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Class f72707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Method f72708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ t f72709d;

    public r(t tVar, Method method, Class cls, Method method2) {
        super(method);
        this.f72709d = tVar;
        this.f72707b = cls;
        this.f72708c = method2;
    }

    @Override // org.apache.tools.ant.t.b
    public void a(Project project, Object obj, String str) throws IllegalAccessException, BuildException, InvocationTargetException {
        try {
            org.apache.tools.ant.types.f fVar = (org.apache.tools.ant.types.f) this.f72707b.newInstance();
            fVar.e(str);
            this.f72708c.invoke(obj, fVar);
        } catch (InstantiationException e11) {
            throw new BuildException(e11);
        }
    }
}
