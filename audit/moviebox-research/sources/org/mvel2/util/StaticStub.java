package org.mvel2.util;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import org.mvel2.integration.VariableResolverFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface StaticStub extends Serializable {
    Object call(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object[] objArr) throws IllegalAccessException, InvocationTargetException;
}
