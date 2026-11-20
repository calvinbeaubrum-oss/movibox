package org.mvel2.ast;

import org.mvel2.ParserContext;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class BooleanNode extends ASTNode {
    protected ASTNode left;
    protected ASTNode right;

    public BooleanNode(ParserContext parserContext) {
        super(parserContext);
    }

    public ASTNode getLeft() {
        return this.left;
    }

    public ASTNode getRight() {
        return this.right;
    }

    public abstract ASTNode getRightMost();

    public void setLeft(ASTNode aSTNode) {
        this.left = aSTNode;
    }

    public void setRight(ASTNode aSTNode) {
        this.right = aSTNode;
    }

    public abstract void setRightMost(ASTNode aSTNode);
}
