package okhttp3;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class Address {
    private final CertificatePinner certificatePinner;
    private final List<ConnectionSpec> connectionSpecs;
    private final Dns dns;
    private final HostnameVerifier hostnameVerifier;
    private final List<Protocol> protocols;
    private final Proxy proxy;
    private final Authenticator proxyAuthenticator;
    private final ProxySelector proxySelector;
    private final SocketFactory socketFactory;
    private final SSLSocketFactory sslSocketFactory;
    private final HttpUrl url;

    public Address(String uriHost, int i11, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator proxyAuthenticator, Proxy proxy, List<? extends Protocol> protocols, List<ConnectionSpec> connectionSpecs, ProxySelector proxySelector) {
        Intrinsics.g(uriHost, "uriHost");
        Intrinsics.g(dns, "dns");
        Intrinsics.g(socketFactory, "socketFactory");
        Intrinsics.g(proxyAuthenticator, "proxyAuthenticator");
        Intrinsics.g(protocols, "protocols");
        Intrinsics.g(connectionSpecs, "connectionSpecs");
        Intrinsics.g(proxySelector, "proxySelector");
        this.dns = dns;
        this.socketFactory = socketFactory;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.certificatePinner = certificatePinner;
        this.proxyAuthenticator = proxyAuthenticator;
        this.proxy = proxy;
        this.proxySelector = proxySelector;
        this.url = new HttpUrl.Builder().scheme(sSLSocketFactory != null ? "https" : HttpHost.DEFAULT_SCHEME_NAME).host(uriHost).port(i11).build();
        this.protocols = Util.toImmutableList(protocols);
        this.connectionSpecs = Util.toImmutableList(connectionSpecs);
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_certificatePinner, reason: not valid java name */
    public final CertificatePinner m176deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_connectionSpecs, reason: not valid java name */
    public final List<ConnectionSpec> m177deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_dns, reason: not valid java name */
    public final Dns m178deprecated_dns() {
        return this.dns;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_hostnameVerifier, reason: not valid java name */
    public final HostnameVerifier m179deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_protocols, reason: not valid java name */
    public final List<Protocol> m180deprecated_protocols() {
        return this.protocols;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_proxy, reason: not valid java name */
    public final Proxy m181deprecated_proxy() {
        return this.proxy;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_proxyAuthenticator, reason: not valid java name */
    public final Authenticator m182deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_proxySelector, reason: not valid java name */
    public final ProxySelector m183deprecated_proxySelector() {
        return this.proxySelector;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_socketFactory, reason: not valid java name */
    public final SocketFactory m184deprecated_socketFactory() {
        return this.socketFactory;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_sslSocketFactory, reason: not valid java name */
    public final SSLSocketFactory m185deprecated_sslSocketFactory() {
        return this.sslSocketFactory;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_url, reason: not valid java name */
    public final HttpUrl m186deprecated_url() {
        return this.url;
    }

    @JvmName
    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    @JvmName
    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    @JvmName
    public final Dns dns() {
        return this.dns;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (Intrinsics.b(this.url, address.url) && equalsNonHost$okhttp(address)) {
                return true;
            }
        }
        return false;
    }

    public final boolean equalsNonHost$okhttp(Address that) {
        Intrinsics.g(that, "that");
        return Intrinsics.b(this.dns, that.dns) && Intrinsics.b(this.proxyAuthenticator, that.proxyAuthenticator) && Intrinsics.b(this.protocols, that.protocols) && Intrinsics.b(this.connectionSpecs, that.connectionSpecs) && Intrinsics.b(this.proxySelector, that.proxySelector) && Intrinsics.b(this.proxy, that.proxy) && Intrinsics.b(this.sslSocketFactory, that.sslSocketFactory) && Intrinsics.b(this.hostnameVerifier, that.hostnameVerifier) && Intrinsics.b(this.certificatePinner, that.certificatePinner) && this.url.port() == that.url.port();
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.url.hashCode()) * 31) + this.dns.hashCode()) * 31) + this.proxyAuthenticator.hashCode()) * 31) + this.protocols.hashCode()) * 31) + this.connectionSpecs.hashCode()) * 31) + this.proxySelector.hashCode()) * 31) + Objects.hashCode(this.proxy)) * 31) + Objects.hashCode(this.sslSocketFactory)) * 31) + Objects.hashCode(this.hostnameVerifier)) * 31) + Objects.hashCode(this.certificatePinner);
    }

    @JvmName
    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @JvmName
    public final List<Protocol> protocols() {
        return this.protocols;
    }

    @JvmName
    public final Proxy proxy() {
        return this.proxy;
    }

    @JvmName
    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @JvmName
    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    @JvmName
    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    @JvmName
    public final SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public String toString() {
        StringBuilder sb2;
        Object obj;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Address{");
        sb3.append(this.url.host());
        sb3.append(':');
        sb3.append(this.url.port());
        sb3.append(", ");
        if (this.proxy != null) {
            sb2 = new StringBuilder();
            sb2.append("proxy=");
            obj = this.proxy;
        } else {
            sb2 = new StringBuilder();
            sb2.append("proxySelector=");
            obj = this.proxySelector;
        }
        sb2.append(obj);
        sb3.append(sb2.toString());
        sb3.append("}");
        return sb3.toString();
    }

    @JvmName
    public final HttpUrl url() {
        return this.url;
    }
}
