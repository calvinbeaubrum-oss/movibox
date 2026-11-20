package org.apache.tools.ant;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class s extends t.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f72710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Class f72711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ t f72712d;

    public s(t tVar, Method method, Method method2, Class cls) {
        super(method);
        this.f72712d = tVar;
        this.f72710b = method2;
        this.f72711c = cls;
    }

    @Override // org.apache.tools.ant.t.b
    public void a(Project project, Object obj, String str) throws IllegalAccessException, BuildException, InvocationTargetException {
        try {
            Method method = this.f72710b;
            Object[] objArr = new Object[1];
            Class cls = this.f72711c;
            Class<?>[] clsArr = new Class[1];
            Class<?> clsC = t.f72725t;
            if (clsC == null) {
                clsC = t.c("java.lang.String");
                t.f72725t = clsC;
            }
            clsArr[0] = clsC;
            objArr[0] = cls.getMethod("valueOf", clsArr).invoke(null, str);
            method.invoke(obj, objArr);
        } catch (InvocationTargetException e11) {
            if (!(e11.getTargetException() instanceof IllegalArgumentException)) {
                throw t.g(e11);
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("'");
            stringBuffer.append(str);
            stringBuffer.append("' is not a permitted value for ");
            stringBuffer.append(this.f72711c.getName());
            throw new BuildException(stringBuffer.toString());
        } catch (Exception e12) {
            throw new BuildException(e12);
        }
    }
}
