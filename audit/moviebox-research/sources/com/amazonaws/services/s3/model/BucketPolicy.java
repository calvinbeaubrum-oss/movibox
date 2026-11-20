package com.amazonaws.services.s3.model;

import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class BucketPolicy implements Serializable {
    private String policyText;

    public String getPolicyText() {
        return this.policyText;
    }

    public void setPolicyText(String str) {
        this.policyText = str;
    }
}
