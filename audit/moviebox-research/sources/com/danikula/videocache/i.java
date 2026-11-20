package com.danikula.videocache;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class i extends ProxySelector {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<Proxy> f32362d = Arrays.asList(Proxy.NO_PROXY);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProxySelector f32363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f32364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f32365c;

    public i(ProxySelector proxySelector, String str, int i11) {
        this.f32363a = (ProxySelector) l.c(proxySelector);
        this.f32364b = (String) l.c(str);
        this.f32365c = i11;
    }

    public static void a(String str, int i11) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i11));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f32363a.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return (this.f32364b.equals(uri.getHost()) && this.f32365c == uri.getPort()) ? f32362d : this.f32363a.select(uri);
    }
}
