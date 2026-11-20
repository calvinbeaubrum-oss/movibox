package org.apache.tools.ant;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class h extends t.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f72683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t f72684c;

    public h(t tVar, Method method, Method method2) {
        super(method);
        this.f72684c = tVar;
        this.f72683b = method2;
    }

    @Override // org.apache.tools.ant.t.b
    public void a(Project project, Object obj, String str) throws IllegalAccessException, BuildException, InvocationTargetException {
        try {
            this.f72683b.invoke(obj, new Long(org.apache.tools.ant.util.p.a(str)));
        } catch (IllegalAccessException e11) {
            throw e11;
        } catch (InvocationTargetException e12) {
            throw e12;
        } catch (Exception e13) {
            throw new BuildException(e13);
        }
    }
}
