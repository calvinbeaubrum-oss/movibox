package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import fk.a;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class HttpInetSocketAddress extends InetSocketAddress {
    private static final long serialVersionUID = -6650701828361907957L;
    private final HttpHost httphost;

    public HttpInetSocketAddress(HttpHost httpHost, InetAddress inetAddress, int i11) {
        super(inetAddress, i11);
        a.g(httpHost, "HTTP host");
        this.httphost = httpHost;
    }

    public HttpHost getHttpHost() {
        return this.httphost;
    }

    @Override // java.net.InetSocketAddress
    public String toString() {
        return this.httphost.getHostName() + ":" + getPort();
    }
}
