package org.mvel2.integration;

import java.io.Serializable;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface VariableResolverFactory extends Serializable {
    VariableResolver createIndexedVariable(int i11, String str, Object obj);

    VariableResolver createIndexedVariable(int i11, String str, Object obj, Class<?> cls);

    VariableResolver createVariable(String str, Object obj);

    VariableResolver createVariable(String str, Object obj, Class<?> cls);

    VariableResolver getIndexedVariableResolver(int i11);

    Set<String> getKnownVariables();

    VariableResolverFactory getNextFactory();

    VariableResolver getVariableResolver(String str);

    boolean isIndexedFactory();

    boolean isResolveable(String str);

    boolean isTarget(String str);

    VariableResolver setIndexedVariableResolver(int i11, VariableResolver variableResolver);

    VariableResolverFactory setNextFactory(VariableResolverFactory variableResolverFactory);

    void setTiltFlag(boolean z11);

    boolean tiltFlag();

    int variableIndexOf(String str);
}
