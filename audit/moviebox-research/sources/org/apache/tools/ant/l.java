package org.apache.tools.ant;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class l extends t.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f72694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t f72695c;

    public l(t tVar, Method method, Object obj) {
        super(method);
        this.f72695c = tVar;
        this.f72694b = obj;
    }

    @Override // org.apache.tools.ant.t.e
    public Object a(Project project, Object obj, Object obj2) {
        return this.f72694b;
    }
}
