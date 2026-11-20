package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth;

import fk.a;
import fk.e;
import java.io.Serializable;
import java.security.Principal;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class NTUserPrincipal implements Principal, Serializable {
    private static final long serialVersionUID = -6870169797924406894L;
    private final String domain;
    private final String ntname;
    private final String username;

    public NTUserPrincipal(String str, String str2) {
        a.g(str2, "User name");
        this.username = str2;
        if (str != null) {
            this.domain = str.toUpperCase(Locale.ROOT);
        } else {
            this.domain = null;
        }
        String str3 = this.domain;
        if (str3 == null || str3.isEmpty()) {
            this.ntname = str2;
            return;
        }
        this.ntname = this.domain + '\\' + str2;
    }

    @Override // java.security.Principal
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NTUserPrincipal)) {
            return false;
        }
        NTUserPrincipal nTUserPrincipal = (NTUserPrincipal) obj;
        return e.a(this.username, nTUserPrincipal.username) && e.a(this.domain, nTUserPrincipal.domain);
    }

    public String getDomain() {
        return this.domain;
    }

    @Override // java.security.Principal
    public String getName() {
        return this.ntname;
    }

    public String getUsername() {
        return this.username;
    }

    @Override // java.security.Principal
    public int hashCode() {
        return e.d(e.d(17, this.username), this.domain);
    }

    @Override // java.security.Principal
    public String toString() {
        return this.ntname;
    }
}
