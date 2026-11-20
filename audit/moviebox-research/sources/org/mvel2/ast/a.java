package org.mvel2.ast;

import org.mvel2.compiler.ExecutableStatement;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface a {
    String getAssignmentVar();

    boolean isNewDeclaration();

    void setValueStatement(ExecutableStatement executableStatement);
}
