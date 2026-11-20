package org.mvel2.optimizers.impl.refl.nodes;

import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.optimizers.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a implements org.mvel2.compiler.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.mvel2.compiler.a f73342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public char[] f73343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f73344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f73345d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public org.mvel2.compiler.a f73346f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ParserContext f73347g;

    public a(ParserContext parserContext, org.mvel2.compiler.a aVar, char[] cArr, int i11, int i12) {
        this.f73342a = aVar;
        this.f73344c = i11;
        this.f73345d = i12;
        this.f73343b = cArr;
        this.f73347g = parserContext;
    }

    public final Object b(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (this.f73346f != null) {
            return this.f73342a.getValue(obj, obj2, variableResolverFactory);
        }
        Object value = this.f73342a.getValue(obj, obj2, variableResolverFactory);
        org.mvel2.optimizers.a aVarC = b.c();
        this.f73346f = aVarC.optimizeAccessor(this.f73347g, this.f73343b, this.f73344c, this.f73345d, value, obj2, variableResolverFactory, false, this.f73342a.getKnownEgressType());
        return aVarC.getResultOptPass();
    }

    @Override // org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return this.f73346f.getKnownEgressType();
    }

    @Override // org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        org.mvel2.compiler.a aVar = this.f73346f;
        return aVar == null ? b(obj, obj2, variableResolverFactory) : aVar.getValue(b(obj, obj2, variableResolverFactory), obj2, variableResolverFactory);
    }

    @Override // org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        return this.f73346f.setValue(b(obj, obj2, variableResolverFactory), obj2, variableResolverFactory, obj3);
    }
}
