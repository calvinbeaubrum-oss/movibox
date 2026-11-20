package org.apache.tools.ant;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class k extends t.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f72692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t f72693c;

    public k(t tVar, Method method, Object obj) {
        super(method);
        this.f72693c = tVar;
        this.f72692b = obj;
    }

    @Override // org.apache.tools.ant.t.e
    public Object a(Project project, Object obj, Object obj2) {
        return this.f72692b;
    }
}
