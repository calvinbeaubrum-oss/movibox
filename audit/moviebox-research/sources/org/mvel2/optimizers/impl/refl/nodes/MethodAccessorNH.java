package org.mvel2.optimizers.impl.refl.nodes;

import java.lang.reflect.Method;
import l30.d;
import org.mvel2.b;
import org.mvel2.compiler.AccessorNode;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.integration.VariableResolverFactory;
import t30.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class MethodAccessorNH implements AccessorNode {
    private boolean coercionNeeded = false;
    private int length;
    private Method method;
    private AccessorNode nextNode;
    private d nullHandler;
    private Class[] parameterTypes;
    private ExecutableStatement[] parms;

    public MethodAccessorNH() {
    }

    public MethodAccessorNH(Method method, ExecutableStatement[] executableStatementArr, d dVar) {
        this.method = method;
        Class<?>[] parameterTypes = method.getParameterTypes();
        this.parameterTypes = parameterTypes;
        this.length = parameterTypes.length;
        this.parms = executableStatementArr;
        this.nullHandler = dVar;
    }

    private Object[] executeAll(Object obj, VariableResolverFactory variableResolverFactory) {
        int i11 = this.length;
        if (i11 == 0) {
            return GetterAccessor.EMPTY;
        }
        Object[] objArr = new Object[i11];
        for (int i12 = 0; i12 < this.length; i12++) {
            objArr[i12] = this.parms[i12].getValue(obj, variableResolverFactory);
        }
        return objArr;
    }

    private Object[] executeAndCoerce(Class[] clsArr, Object obj, VariableResolverFactory variableResolverFactory) {
        Object[] objArr = new Object[this.length];
        for (int i11 = 0; i11 < this.length; i11++) {
            objArr[i11] = b.b(this.parms[i11].getValue(obj, variableResolverFactory), clsArr[i11]);
        }
        return objArr;
    }

    private Object executeOverrideTarget(Method method, Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        try {
            Object objInvoke = method.invoke(obj, executeAll(obj2, variableResolverFactory));
            if (objInvoke == null) {
                objInvoke = this.nullHandler.b(method.getName(), obj, variableResolverFactory);
            }
            AccessorNode accessorNode = this.nextNode;
            return accessorNode != null ? accessorNode.getValue(objInvoke, obj2, variableResolverFactory) : objInvoke;
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

    public ExecutableStatement[] getParms() {
        return this.parms;
    }

    @Override // org.mvel2.compiler.AccessorNode, org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        Method methodJ;
        if (this.coercionNeeded) {
            try {
                AccessorNode accessorNode = this.nextNode;
                return accessorNode != null ? accessorNode.getValue(this.method.invoke(obj, executeAndCoerce(this.parameterTypes, obj2, variableResolverFactory)), obj2, variableResolverFactory) : this.method.invoke(obj, executeAndCoerce(this.parameterTypes, obj2, variableResolverFactory));
            } catch (Exception e11) {
                throw new RuntimeException("cannot invoke method", e11);
            }
        }
        try {
            Object objInvoke = this.method.invoke(obj, executeAll(obj2, variableResolverFactory));
            if (objInvoke == null) {
                this.nullHandler.b(this.method.getName(), obj, variableResolverFactory);
            }
            AccessorNode accessorNode2 = this.nextNode;
            return accessorNode2 != null ? accessorNode2.getValue(objInvoke, obj2, variableResolverFactory) : objInvoke;
        } catch (IllegalArgumentException unused) {
            if (obj != null && this.method.getDeclaringClass() != obj.getClass() && (methodJ = m.J(this.parameterTypes, this.method.getName(), obj.getClass(), obj.getClass().getMethods(), true)) != null) {
                return executeOverrideTarget(methodJ, obj, obj2, variableResolverFactory);
            }
            this.coercionNeeded = true;
            return getValue(obj, obj2, variableResolverFactory);
        } catch (Exception e12) {
            throw new RuntimeException("cannot invoke method", e12);
        }
    }

    public void setMethod(Method method) {
        this.method = method;
        Class<?>[] parameterTypes = method.getParameterTypes();
        this.parameterTypes = parameterTypes;
        this.length = parameterTypes.length;
    }

    @Override // org.mvel2.compiler.AccessorNode
    public AccessorNode setNextNode(AccessorNode accessorNode) {
        this.nextNode = accessorNode;
        return accessorNode;
    }

    public void setParms(ExecutableStatement[] executableStatementArr) {
        this.parms = executableStatementArr;
    }

    @Override // org.mvel2.compiler.AccessorNode, org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        return this.nextNode.setValue(obj, obj2, variableResolverFactory, obj3);
    }
}
