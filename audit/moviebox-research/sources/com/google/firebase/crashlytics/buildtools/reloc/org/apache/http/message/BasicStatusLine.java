package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message;

import ck.d;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ProtocolVersion;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.q;
import fk.a;
import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class BasicStatusLine implements q, Cloneable, Serializable {
    private static final long serialVersionUID = -2443303766890459269L;
    private final ProtocolVersion protoVersion;
    private final String reasonPhrase;
    private final int statusCode;

    public BasicStatusLine(ProtocolVersion protocolVersion, int i11, String str) {
        this.protoVersion = (ProtocolVersion) a.g(protocolVersion, "Version");
        this.statusCode = a.f(i11, "Status code");
        this.reasonPhrase = str;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.q
    public ProtocolVersion getProtocolVersion() {
        return this.protoVersion;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.q
    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.q
    public int getStatusCode() {
        return this.statusCode;
    }

    public String toString() {
        return d.f14942b.h(null, this).toString();
    }
}
