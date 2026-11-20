package org.mvel2.optimizers.impl.refl.nodes;

import java.lang.reflect.Field;
import l30.d;
import org.mvel2.b;
import org.mvel2.compiler.AccessorNode;
import org.mvel2.integration.VariableResolverFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class FieldAccessorNH implements AccessorNode {
    private boolean coercionRequired = false;
    private Field field;
    private AccessorNode nextNode;
    private d nullHandler;

    public FieldAccessorNH(Field field, d dVar) {
        this.field = field;
        this.nullHandler = dVar;
    }

    public Field getField() {
        return this.field;
    }

    @Override // org.mvel2.compiler.AccessorNode, org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return this.field.getClass();
    }

    @Override // org.mvel2.compiler.AccessorNode
    public AccessorNode getNextNode() {
        return this.nextNode;
    }

    @Override // org.mvel2.compiler.AccessorNode, org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        try {
            Object objB = this.field.get(obj);
            if (objB == null) {
                objB = this.nullHandler.b(this.field.getName(), obj2, variableResolverFactory);
            }
            AccessorNode accessorNode = this.nextNode;
            return accessorNode != null ? accessorNode.getValue(objB, obj2, variableResolverFactory) : objB;
        } catch (Exception e11) {
            throw new RuntimeException("unable to access field", e11);
        }
    }

    public void setField(Field field) {
        this.field = field;
    }

    @Override // org.mvel2.compiler.AccessorNode
    public AccessorNode setNextNode(AccessorNode accessorNode) {
        this.nextNode = accessorNode;
        return accessorNode;
    }

    @Override // org.mvel2.compiler.AccessorNode, org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        boolean z11 = this.coercionRequired;
        try {
            AccessorNode accessorNode = this.nextNode;
            if (accessorNode != null) {
                return accessorNode.setValue(obj, obj2, variableResolverFactory, obj3);
            }
            if (!z11) {
                this.field.set(obj, obj3);
                return obj3;
            }
            Field field = this.field;
            Object objB = b.b(obj, field.getClass());
            field.set(obj, objB);
            return objB;
        } catch (IllegalArgumentException e11) {
            if (z11) {
                throw new RuntimeException("unable to bind property", e11);
            }
            this.coercionRequired = true;
            return setValue(obj, obj2, variableResolverFactory, obj3);
        } catch (Exception e12) {
            throw new RuntimeException("unable to access field", e12);
        }
    }
}
