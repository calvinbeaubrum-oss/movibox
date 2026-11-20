package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth;

import ck.g;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthenticationException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.ChallengeState;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.MalformedChallengeException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.d;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.e;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.l;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.CharArrayBuffer;
import fk.c;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class RFC2617Scheme extends a implements Serializable {
    private static final long serialVersionUID = -2845454858205884623L;
    private transient Charset credentialsCharset;
    private final Map<String, String> params;

    public RFC2617Scheme() {
        this(com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.a.f40092b);
    }

    @Deprecated
    public RFC2617Scheme(ChallengeState challengeState) {
        super(challengeState);
        this.params = new HashMap();
        this.credentialsCharset = com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.a.f40092b;
    }

    public RFC2617Scheme(Charset charset) {
        this.params = new HashMap();
        this.credentialsCharset = charset == null ? com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.a.f40092b : charset;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Charset charsetA = c.a(objectInputStream.readUTF());
        this.credentialsCharset = charsetA;
        if (charsetA == null) {
            this.credentialsCharset = com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.a.f40092b;
        }
        this.challengeState = (ChallengeState) objectInputStream.readObject();
    }

    private void readObjectNoData() throws ObjectStreamException {
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeUTF(this.credentialsCharset.name());
        objectOutputStream.writeObject(this.challengeState);
    }

    @Override // xj.a
    @Deprecated
    public abstract /* synthetic */ d authenticate(xj.b bVar, l lVar) throws AuthenticationException;

    public String getCredentialsCharset(l lVar) {
        String str = (String) lVar.getParams().getParameter("http.auth.credential-charset");
        return str == null ? getCredentialsCharset().name() : str;
    }

    public Charset getCredentialsCharset() {
        Charset charset = this.credentialsCharset;
        return charset != null ? charset : com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.a.f40092b;
    }

    public String getParameter(String str) {
        if (str == null) {
            return null;
        }
        return this.params.get(str.toLowerCase(Locale.ROOT));
    }

    public Map<String, String> getParameters() {
        return this.params;
    }

    public String getRealm() {
        return getParameter("realm");
    }

    @Override // xj.a
    public abstract /* synthetic */ String getSchemeName();

    public abstract /* synthetic */ boolean isComplete();

    public abstract /* synthetic */ boolean isConnectionBased();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth.a
    public void parseChallenge(CharArrayBuffer charArrayBuffer, int i11, int i12) throws MalformedChallengeException {
        e[] eVarArrA = ck.c.f14937c.a(charArrayBuffer, new g(i11, charArrayBuffer.length()));
        this.params.clear();
        for (e eVar : eVarArrA) {
            this.params.put(eVar.getName().toLowerCase(Locale.ROOT), eVar.getValue());
        }
    }
}
