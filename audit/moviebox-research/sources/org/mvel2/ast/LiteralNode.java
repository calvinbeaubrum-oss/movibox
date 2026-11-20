package org.mvel2.ast;

import org.mvel2.ParserContext;
import org.mvel2.compiler.BlankLiteral;
import org.mvel2.integration.VariableResolverFactory;
import t30.l;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class LiteralNode extends ASTNode {
    public LiteralNode(Object obj, Class cls, ParserContext parserContext) {
        this(obj, parserContext);
        this.egressType = cls;
    }

    public LiteralNode(Object obj, ParserContext parserContext) {
        super(parserContext);
        this.literal = obj;
        if (obj == null) {
            this.egressType = l.class;
            return;
        }
        Class<?> cls = obj.getClass();
        this.egressType = cls;
        if (cls == BlankLiteral.class) {
            this.egressType = Object.class;
        }
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getLiteralValue() {
        return this.literal;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        return this.literal;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        return this.literal;
    }

    @Override // org.mvel2.ast.ASTNode
    public boolean isLiteral() {
        return true;
    }

    @Override // org.mvel2.ast.ASTNode
    public void setLiteralValue(Object obj) {
        this.literal = obj;
    }

    @Override // org.mvel2.ast.ASTNode
    public String toString() {
        return "Literal<" + this.literal + ">";
    }
}
