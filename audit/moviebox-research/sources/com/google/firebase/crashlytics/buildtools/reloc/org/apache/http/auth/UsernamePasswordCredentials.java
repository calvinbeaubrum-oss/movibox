package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth;

import fk.a;
import fk.e;
import java.io.Serializable;
import java.security.Principal;
import xj.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class UsernamePasswordCredentials implements b, Serializable {
    private static final long serialVersionUID = 243343858802739403L;
    private final String password;
    private final BasicUserPrincipal principal;

    @Deprecated
    public UsernamePasswordCredentials(String str) {
        a.g(str, "Username:password string");
        int iIndexOf = str.indexOf(58);
        if (iIndexOf >= 0) {
            this.principal = new BasicUserPrincipal(str.substring(0, iIndexOf));
            this.password = str.substring(iIndexOf + 1);
        } else {
            this.principal = new BasicUserPrincipal(str);
            this.password = null;
        }
    }

    public UsernamePasswordCredentials(String str, String str2) {
        a.g(str, "Username");
        this.principal = new BasicUserPrincipal(str);
        this.password = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UsernamePasswordCredentials) && e.a(this.principal, ((UsernamePasswordCredentials) obj).principal);
    }

    @Override // xj.b
    public String getPassword() {
        return this.password;
    }

    public String getUserName() {
        return this.principal.getName();
    }

    @Override // xj.b
    public Principal getUserPrincipal() {
        return this.principal;
    }

    public int hashCode() {
        return this.principal.hashCode();
    }

    public String toString() {
        return this.principal.toString();
    }
}
