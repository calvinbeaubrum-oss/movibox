package org.mvel2.ast;

import org.mvel2.integration.VariableResolverFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VariableResolverFactory f73292b;

    public d(Function function, VariableResolverFactory variableResolverFactory) {
        super(function);
        this.f73292b = variableResolverFactory;
    }

    @Override // org.mvel2.ast.b
    public Object a(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object[] objArr) {
        return this.f73291a.call(obj, obj2, new InvokationContextFactory(variableResolverFactory, this.f73292b), objArr);
    }

    public VariableResolverFactory c() {
        return this.f73292b;
    }

    public String toString() {
        return "function_prototype:" + this.f73291a.getName();
    }
}
