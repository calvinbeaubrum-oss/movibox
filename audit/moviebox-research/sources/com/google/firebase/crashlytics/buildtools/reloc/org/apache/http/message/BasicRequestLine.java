package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message;

import ck.d;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ProtocolVersion;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.p;
import fk.a;
import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class BasicRequestLine implements p, Cloneable, Serializable {
    private static final long serialVersionUID = 2810581718468737193L;
    private final String method;
    private final ProtocolVersion protoversion;
    private final String uri;

    public BasicRequestLine(String str, String str2, ProtocolVersion protocolVersion) {
        this.method = (String) a.g(str, "Method");
        this.uri = (String) a.g(str2, "URI");
        this.protoversion = (ProtocolVersion) a.g(protocolVersion, "Version");
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.p
    public String getMethod() {
        return this.method;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.p
    public ProtocolVersion getProtocolVersion() {
        return this.protoversion;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.p
    public String getUri() {
        return this.uri;
    }

    public String toString() {
        return d.f14942b.g(null, this).toString();
    }
}
