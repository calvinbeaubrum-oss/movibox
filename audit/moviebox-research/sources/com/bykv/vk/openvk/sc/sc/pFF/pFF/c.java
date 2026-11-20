package com.bykv.vk.openvk.sc.sc.pFF.pFF;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends ProxySelector {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<Proxy> f25990d = Collections.singletonList(Proxy.NO_PROXY);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProxySelector f25991a = ProxySelector.getDefault();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f25992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f25993c;

    public c(String str, int i11) {
        this.f25992b = str;
        this.f25993c = i11;
    }

    public static void a(String str, int i11) {
        ProxySelector.setDefault(new c(str, i11));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f25991a.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        if (uri != null) {
            return (this.f25992b.equalsIgnoreCase(uri.getHost()) && this.f25993c == uri.getPort()) ? f25990d : this.f25991a.select(uri);
        }
        throw new IllegalArgumentException("URI can't be null");
    }
}
