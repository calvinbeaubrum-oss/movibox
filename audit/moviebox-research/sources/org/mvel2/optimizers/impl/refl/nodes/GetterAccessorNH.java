package org.mvel2.optimizers.impl.refl.nodes;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.reflect.Method;
import l30.d;
import org.mvel2.CompileException;
import org.mvel2.compiler.AccessorNode;
import org.mvel2.integration.VariableResolverFactory;
import t30.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class GetterAccessorNH implements AccessorNode {
    public static final Object[] EMPTY = new Object[0];
    private final Method method;
    private AccessorNode nextNode;
    private d nullHandler;

    public GetterAccessorNH(Method method, d dVar) {
        this.method = method;
        this.nullHandler = dVar;
    }

    private Object executeOverrideTarget(Method method, Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        try {
            return nullHandle(method.getName(), method.invoke(obj, EMPTY), obj, obj2, variableResolverFactory);
        } catch (Exception e11) {
            throw new RuntimeException("unable to invoke method", e11);
        }
    }

    private Object nullHandle(String str, Object obj, Object obj2, Object obj3, VariableResolverFactory variableResolverFactory) {
        if (obj != null) {
            AccessorNode accessorNode = this.nextNode;
            return accessorNode != null ? accessorNode.getValue(obj, obj3, variableResolverFactory) : obj;
        }
        AccessorNode accessorNode2 = this.nextNode;
        return accessorNode2 != null ? accessorNode2.getValue(this.nullHandler.b(str, obj2, variableResolverFactory), obj3, variableResolverFactory) : this.nullHandler.b(str, obj2, variableResolverFactory);
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
        Method methodL;
        try {
            return nullHandle(this.method.getName(), this.method.invoke(obj, EMPTY), obj, obj2, variableResolverFactory);
        } catch (IllegalArgumentException unused) {
            if (obj != null && this.method.getDeclaringClass() != obj.getClass() && (methodL = m.L(EMPTY, this.method.getName(), obj.getClass(), obj.getClass().getMethods(), true)) != null) {
                return executeOverrideTarget(methodL, obj, obj2, variableResolverFactory);
            }
            return nullHandle(this.method.getName(), org.mvel2.d.v(this.method.getName() + "()", obj), obj, obj2, variableResolverFactory);
        } catch (Exception e11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("cannot invoke getter: ");
            sb2.append(this.method.getName());
            sb2.append(" [declr.class: ");
            sb2.append(this.method.getDeclaringClass().getName());
            sb2.append("; act.class: ");
            sb2.append(obj != null ? obj.getClass().getName() : "null");
            sb2.append("]");
            throw new RuntimeException(sb2.toString(), e11);
        }
    }

    @Override // org.mvel2.compiler.AccessorNode
    public AccessorNode setNextNode(AccessorNode accessorNode) {
        this.nextNode = accessorNode;
        return accessorNode;
    }

    @Override // org.mvel2.compiler.AccessorNode, org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        try {
            Object objInvoke = this.method.invoke(obj, EMPTY);
            if (objInvoke == null) {
                objInvoke = this.nullHandler.b(this.method.getName(), obj, variableResolverFactory);
            }
            return this.nextNode.setValue(objInvoke, obj2, variableResolverFactory, obj3);
        } catch (IllegalArgumentException unused) {
            Object objV = org.mvel2.d.v(this.method.getName() + "()", obj);
            if (objV == null) {
                objV = this.nullHandler.b(this.method.getName(), obj, variableResolverFactory);
            }
            return this.nextNode.setValue(objV, obj2, variableResolverFactory, obj3);
        } catch (CompileException e11) {
            throw e11;
        } catch (Exception e12) {
            throw new RuntimeException("error " + this.method.getName() + ": " + e12.getClass().getName() + ":" + e12.getMessage(), e12);
        }
    }

    public String toString() {
        return this.method.getDeclaringClass().getName() + InstructionFileId.DOT + this.method.getName();
    }
}
