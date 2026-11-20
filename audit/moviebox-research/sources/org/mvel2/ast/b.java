package org.mvel2.ast;

import org.mvel2.integration.VariableResolverFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function f73291a;

    public b(Function function) {
        this.f73291a = function;
    }

    public Object a(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object[] objArr) {
        return this.f73291a.call(obj, obj2, variableResolverFactory, objArr);
    }

    public Function b() {
        return this.f73291a;
    }
}
