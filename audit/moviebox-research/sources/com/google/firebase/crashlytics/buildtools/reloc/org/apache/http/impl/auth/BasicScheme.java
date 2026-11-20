package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthenticationException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.ChallengeState;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.MalformedChallengeException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.d;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.l;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.BufferedHeader;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.CharArrayBuffer;
import ek.c;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class BasicScheme extends RFC2617Scheme {
    private static final long serialVersionUID = -1931571557597830536L;
    private boolean complete;

    public BasicScheme() {
        this(com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.a.f40092b);
    }

    @Deprecated
    public BasicScheme(ChallengeState challengeState) {
        super(challengeState);
    }

    public BasicScheme(Charset charset) {
        super(charset);
        this.complete = false;
    }

    @Deprecated
    public static d authenticate(xj.b bVar, String str, boolean z11) {
        fk.a.g(bVar, "Credentials");
        fk.a.g(str, "charset");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(bVar.getUserPrincipal().getName());
        sb2.append(":");
        sb2.append(bVar.getPassword() == null ? "null" : bVar.getPassword());
        byte[] bArrK = vj.a.k(fk.d.b(sb2.toString(), str), false);
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(32);
        if (z11) {
            charArrayBuffer.append("Proxy-Authorization");
        } else {
            charArrayBuffer.append(HttpHeaders.AUTHORIZATION);
        }
        charArrayBuffer.append(": Basic ");
        charArrayBuffer.append(bArrK, 0, bArrK.length);
        return new BufferedHeader(charArrayBuffer);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth.RFC2617Scheme, xj.a
    @Deprecated
    public d authenticate(xj.b bVar, l lVar) throws AuthenticationException {
        return authenticate(bVar, lVar, new ek.a());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth.a
    public d authenticate(xj.b bVar, l lVar, c cVar) throws AuthenticationException {
        fk.a.g(bVar, "Credentials");
        fk.a.g(lVar, "HTTP request");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(bVar.getUserPrincipal().getName());
        sb2.append(":");
        sb2.append(bVar.getPassword() == null ? "null" : bVar.getPassword());
        byte[] bArrD = new vj.a(0).d(fk.d.b(sb2.toString(), getCredentialsCharset(lVar)));
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(32);
        if (isProxy()) {
            charArrayBuffer.append("Proxy-Authorization");
        } else {
            charArrayBuffer.append(HttpHeaders.AUTHORIZATION);
        }
        charArrayBuffer.append(": Basic ");
        charArrayBuffer.append(bArrD, 0, bArrD.length);
        return new BufferedHeader(charArrayBuffer);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth.RFC2617Scheme, xj.a
    public String getSchemeName() {
        return "basic";
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth.RFC2617Scheme
    public boolean isComplete() {
        return this.complete;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth.RFC2617Scheme
    public boolean isConnectionBased() {
        return false;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth.a
    public void processChallenge(d dVar) throws MalformedChallengeException {
        super.processChallenge(dVar);
        this.complete = true;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth.a
    public String toString() {
        return "BASIC [complete=" + this.complete + "]";
    }
}
