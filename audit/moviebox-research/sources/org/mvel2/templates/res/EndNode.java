package org.mvel2.templates.res;

import org.mvel2.integration.VariableResolverFactory;
import q30.d;
import r30.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class EndNode extends Node {
    @Override // org.mvel2.templates.res.Node
    public boolean demarcate(Node node, char[] cArr) {
        return false;
    }

    @Override // org.mvel2.templates.res.Node
    public Object eval(d dVar, c cVar, Object obj, VariableResolverFactory variableResolverFactory) {
        return cVar.toString();
    }

    public String toString() {
        return "EndNode";
    }
}
