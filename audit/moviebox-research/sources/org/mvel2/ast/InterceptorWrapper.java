package org.mvel2.ast;

import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolverFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class InterceptorWrapper extends ASTNode {
    private l30.b interceptor;
    private ASTNode node;

    public InterceptorWrapper(l30.b bVar, ASTNode aSTNode, ParserContext parserContext) {
        super(parserContext);
        this.interceptor = bVar;
        this.node = aSTNode;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        this.interceptor.b(this.node, variableResolverFactory);
        l30.b bVar = this.interceptor;
        Object reducedValue = this.node.getReducedValue(obj, obj2, variableResolverFactory);
        bVar.a(reducedValue, this.node, variableResolverFactory);
        return reducedValue;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        this.interceptor.b(this.node, variableResolverFactory);
        l30.b bVar = this.interceptor;
        Object reducedValueAccelerated = this.node.getReducedValueAccelerated(obj, obj2, variableResolverFactory);
        bVar.a(reducedValueAccelerated, this.node, variableResolverFactory);
        return reducedValueAccelerated;
    }
}
