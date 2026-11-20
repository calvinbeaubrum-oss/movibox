package com.amazonaws.services.s3.model;

import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class CanonicalGrantee implements Grantee, Serializable {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f16003id = null;
    private String displayName = null;

    public CanonicalGrantee(String str) {
        setIdentifier(str);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CanonicalGrantee) {
            return this.f16003id.equals(((CanonicalGrantee) obj).f16003id);
        }
        return false;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    @Override // com.amazonaws.services.s3.model.Grantee
    public String getIdentifier() {
        return this.f16003id;
    }

    @Override // com.amazonaws.services.s3.model.Grantee
    public String getTypeIdentifier() {
        return "id";
    }

    public int hashCode() {
        return this.f16003id.hashCode();
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    @Override // com.amazonaws.services.s3.model.Grantee
    public void setIdentifier(String str) {
        this.f16003id = str;
    }
}
