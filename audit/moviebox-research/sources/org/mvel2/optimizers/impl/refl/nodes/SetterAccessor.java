package org.mvel2.optimizers.impl.refl.nodes;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.reflect.Method;
import org.mvel2.b;
import org.mvel2.compiler.AccessorNode;
import org.mvel2.integration.VariableResolverFactory;
import t30.m;
import t30.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class SetterAccessor implements AccessorNode {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Object[] EMPTY = new Object[0];
    private boolean coercionRequired = false;
    private final Method method;
    private AccessorNode nextNode;
    private boolean primitive;
    private Class<?> targetType;

    public SetterAccessor(Method method) {
        this.method = method;
        Class<?> cls = method.getParameterTypes()[0];
        this.targetType = cls;
        this.primitive = cls.isPrimitive();
    }

    private Object executeOverrideTarget(Method method, Object obj, Object obj2) {
        try {
            return method.invoke(obj, b.b(obj2, this.targetType));
        } catch (Exception e11) {
            throw new RuntimeException("unable to invoke method", e11);
        }
    }

    @Override // org.mvel2.compiler.AccessorNode, org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return this.method.getReturnType();
    }

    public Method getMethod() {
        return this.method;
    }

    @Override // org.mvel2.compiler.AccessorNode
    public AccessorNode getNextNode() {
        return this.nextNode;
    }

    @Override // org.mvel2.compiler.AccessorNode, org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        return null;
    }

    @Override // org.mvel2.compiler.AccessorNode
    public AccessorNode setNextNode(AccessorNode accessorNode) {
        this.nextNode = accessorNode;
        return accessorNode;
    }

    @Override // org.mvel2.compiler.AccessorNode, org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        Method methodL;
        boolean z11 = this.coercionRequired;
        try {
            if (z11) {
                return this.method.invoke(obj, b.b(obj3, this.targetType));
            }
            Method method = this.method;
            Object[] objArr = new Object[1];
            objArr[0] = (obj3 == null && this.primitive) ? n.f(this.targetType) : obj3;
            return method.invoke(obj, objArr);
        } catch (IllegalArgumentException e11) {
            if (obj != null && this.method.getDeclaringClass() != obj.getClass() && (methodL = m.L(EMPTY, this.method.getName(), obj.getClass(), obj.getClass().getMethods(), true)) != null) {
                return executeOverrideTarget(methodL, obj, obj3);
            }
            if (z11) {
                throw new RuntimeException("unable to bind property", e11);
            }
            this.coercionRequired = true;
            return setValue(obj, obj2, variableResolverFactory, obj3);
        } catch (Exception e12) {
            throw new RuntimeException("error calling method: " + this.method.getDeclaringClass().getName() + InstructionFileId.DOT + this.method.getName(), e12);
        }
    }

    public String toString() {
        return this.method.getDeclaringClass().getName() + InstructionFileId.DOT + this.method.getName();
    }
}
