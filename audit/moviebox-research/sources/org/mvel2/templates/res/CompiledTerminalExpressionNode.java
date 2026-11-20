package org.mvel2.templates.res;

import java.io.Serializable;
import org.mvel2.ParserContext;
import org.mvel2.d;
import org.mvel2.integration.VariableResolverFactory;
import r30.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class CompiledTerminalExpressionNode extends TerminalExpressionNode {

    /* JADX INFO: renamed from: ce, reason: collision with root package name */
    private Serializable f73355ce;

    public CompiledTerminalExpressionNode(Node node, ParserContext parserContext) {
        this.begin = node.begin;
        this.name = node.name;
        char[] cArr = node.contents;
        int i11 = node.cStart;
        this.f73355ce = d.e(cArr, i11, node.cEnd - i11, parserContext);
    }

    @Override // org.mvel2.templates.res.TerminalExpressionNode, org.mvel2.templates.res.Node
    public boolean demarcate(Node node, char[] cArr) {
        return false;
    }

    @Override // org.mvel2.templates.res.TerminalExpressionNode, org.mvel2.templates.res.Node
    public Object eval(q30.d dVar, c cVar, Object obj, VariableResolverFactory variableResolverFactory) {
        return d.r(this.f73355ce, obj, variableResolverFactory);
    }
}
