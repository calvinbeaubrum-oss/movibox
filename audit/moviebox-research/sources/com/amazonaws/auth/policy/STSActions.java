package com.amazonaws.auth.policy;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public enum STSActions {
    AssumeRole("sts:AssumeRole"),
    AssumeRoleWithWebIdentity("sts:AssumeRoleWithWebIdentity");

    private final String action;

    STSActions(String str) {
        this.action = str;
    }

    public String getActionName() {
        return this.action;
    }
}
