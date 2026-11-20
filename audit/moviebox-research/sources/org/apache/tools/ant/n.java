package org.apache.tools.ant;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class n extends t.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f72698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Method f72699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ t f72700d;

    public n(t tVar, Method method, String str, Method method2) {
        super(method);
        this.f72700d = tVar;
        this.f72698b = str;
        this.f72699c = method2;
    }

    @Override // org.apache.tools.ant.t.b
    public void a(Project project, Object obj, String str) throws IllegalAccessException, InvocationTargetException {
        if (str.length() != 0) {
            this.f72699c.invoke(obj, new Character(str.charAt(0)));
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("The value \"\" is not a legal value for attribute \"");
        stringBuffer.append(this.f72698b);
        stringBuffer.append("\"");
        throw new BuildException(stringBuffer.toString());
    }
}
