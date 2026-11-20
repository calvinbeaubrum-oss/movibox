package org.mvel2.optimizers.impl.refl.nodes;

import l30.d;
import org.mvel2.compiler.AccessorNode;
import org.mvel2.integration.VariableResolverFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class PropertyHandlerAccessor extends BaseAccessor {
    private Class conversionType;
    private d propertyHandler;
    private String propertyName;

    public PropertyHandlerAccessor(String str, Class cls, d dVar) {
        this.propertyName = str;
        this.conversionType = cls;
        this.propertyHandler = dVar;
    }

    @Override // org.mvel2.optimizers.impl.refl.nodes.BaseAccessor, org.mvel2.compiler.AccessorNode, org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return Object.class;
    }

    @Override // org.mvel2.optimizers.impl.refl.nodes.BaseAccessor, org.mvel2.compiler.AccessorNode, org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (!this.conversionType.isAssignableFrom(obj.getClass())) {
            AccessorNode accessorNode = this.nextNode;
            return accessorNode != null ? accessorNode.getValue(org.mvel2.d.v(this.propertyName, obj), obj2, variableResolverFactory) : org.mvel2.d.v(this.propertyName, obj);
        }
        try {
            AccessorNode accessorNode2 = this.nextNode;
            return accessorNode2 != null ? accessorNode2.getValue(this.propertyHandler.b(this.propertyName, obj, variableResolverFactory), obj2, variableResolverFactory) : this.propertyHandler.b(this.propertyName, obj, variableResolverFactory);
        } catch (Exception e11) {
            throw new RuntimeException("unable to access field", e11);
        }
    }

    @Override // org.mvel2.optimizers.impl.refl.nodes.BaseAccessor, org.mvel2.compiler.AccessorNode, org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        AccessorNode accessorNode = this.nextNode;
        return accessorNode != null ? accessorNode.setValue(this.propertyHandler.b(this.propertyName, obj, variableResolverFactory), obj, variableResolverFactory, obj3) : this.propertyHandler.a(this.propertyName, obj, variableResolverFactory, obj3);
    }
}
