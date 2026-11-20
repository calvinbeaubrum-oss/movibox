package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Route;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Address f49316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.squareup.okhttp.internal.f f49317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Proxy f49318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InetSocketAddress f49319d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f49321f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f49323h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<Proxy> f49320e = Collections.emptyList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<InetSocketAddress> f49322g = Collections.emptyList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<Route> f49324i = new ArrayList();

    public l(Address address, com.squareup.okhttp.internal.f fVar) {
        this.f49316a = address;
        this.f49317b = fVar;
        l(address.url(), address.getProxy());
    }

    public static String b(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    public void a(Route route, IOException iOException) {
        if (route.getProxy().type() != Proxy.Type.DIRECT && this.f49316a.getProxySelector() != null) {
            this.f49316a.getProxySelector().connectFailed(this.f49316a.url().uri(), route.getProxy().address(), iOException);
        }
        this.f49317b.b(route);
    }

    public boolean c() {
        return d() || f() || e();
    }

    public final boolean d() {
        return this.f49323h < this.f49322g.size();
    }

    public final boolean e() {
        return !this.f49324i.isEmpty();
    }

    public final boolean f() {
        return this.f49321f < this.f49320e.size();
    }

    public Route g() throws IOException {
        if (!d()) {
            if (!f()) {
                if (e()) {
                    return i();
                }
                throw new NoSuchElementException();
            }
            this.f49318c = j();
        }
        InetSocketAddress inetSocketAddressH = h();
        this.f49319d = inetSocketAddressH;
        Route route = new Route(this.f49316a, this.f49318c, inetSocketAddressH);
        if (!this.f49317b.c(route)) {
            return route;
        }
        this.f49324i.add(route);
        return g();
    }

    public final InetSocketAddress h() throws IOException {
        if (d()) {
            List<InetSocketAddress> list = this.f49322g;
            int i11 = this.f49323h;
            this.f49323h = i11 + 1;
            return list.get(i11);
        }
        throw new SocketException("No route to " + this.f49316a.getUriHost() + "; exhausted inet socket addresses: " + this.f49322g);
    }

    public final Route i() {
        return this.f49324i.remove(0);
    }

    public final Proxy j() throws IOException {
        if (f()) {
            List<Proxy> list = this.f49320e;
            int i11 = this.f49321f;
            this.f49321f = i11 + 1;
            Proxy proxy = list.get(i11);
            k(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f49316a.getUriHost() + "; exhausted proxy configurations: " + this.f49320e);
    }

    public final void k(Proxy proxy) throws IOException {
        String uriHost;
        int uriPort;
        this.f49322g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            uriHost = this.f49316a.getUriHost();
            uriPort = this.f49316a.getUriPort();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            uriHost = b(inetSocketAddress);
            uriPort = inetSocketAddress.getPort();
        }
        if (uriPort < 1 || uriPort > 65535) {
            throw new SocketException("No route to " + uriHost + ":" + uriPort + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.f49322g.add(InetSocketAddress.createUnresolved(uriHost, uriPort));
        } else {
            List<InetAddress> listLookup = this.f49316a.getDns().lookup(uriHost);
            int size = listLookup.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.f49322g.add(new InetSocketAddress(listLookup.get(i11), uriPort));
            }
        }
        this.f49323h = 0;
    }

    public final void l(HttpUrl httpUrl, Proxy proxy) {
        if (proxy != null) {
            this.f49320e = Collections.singletonList(proxy);
        } else {
            this.f49320e = new ArrayList();
            List<Proxy> listSelect = this.f49316a.getProxySelector().select(httpUrl.uri());
            if (listSelect != null) {
                this.f49320e.addAll(listSelect);
            }
            List<Proxy> list = this.f49320e;
            Proxy proxy2 = Proxy.NO_PROXY;
            list.removeAll(Collections.singleton(proxy2));
            this.f49320e.add(proxy2);
        }
        this.f49321f = 0;
    }
}
