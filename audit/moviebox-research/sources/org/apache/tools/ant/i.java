package org.apache.tools.ant;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class i extends t.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f72685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Constructor f72686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Method f72687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ t f72688e;

    public i(t tVar, Method method, boolean z11, Constructor constructor, Method method2) {
        super(method);
        this.f72688e = tVar;
        this.f72685b = z11;
        this.f72686c = constructor;
        this.f72687d = method2;
    }

    @Override // org.apache.tools.ant.t.b
    public void a(Project project, Object obj, String str) throws IllegalAccessException, BuildException, InvocationTargetException {
        try {
            Object objNewInstance = this.f72686c.newInstance(this.f72685b ? new Object[]{project, str} : new Object[]{str});
            if (project != null) {
                project.K(objNewInstance);
            }
            this.f72687d.invoke(obj, objNewInstance);
        } catch (InstantiationException e11) {
            throw new BuildException(e11);
        }
    }
}
