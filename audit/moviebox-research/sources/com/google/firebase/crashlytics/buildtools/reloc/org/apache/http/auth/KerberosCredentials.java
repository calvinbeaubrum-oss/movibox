package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth;

import java.io.Serializable;
import java.security.Principal;
import org.ietf.jgss.GSSCredential;
import xj.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class KerberosCredentials implements b, Serializable {
    private static final long serialVersionUID = 487421613855550713L;
    private final GSSCredential gssCredential;

    public KerberosCredentials(GSSCredential gSSCredential) {
        this.gssCredential = gSSCredential;
    }

    public GSSCredential getGSSCredential() {
        return this.gssCredential;
    }

    @Override // xj.b
    public String getPassword() {
        return null;
    }

    @Override // xj.b
    public Principal getUserPrincipal() {
        return null;
    }
}
