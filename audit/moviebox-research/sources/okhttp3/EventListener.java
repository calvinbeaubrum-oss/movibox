package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class EventListener {
    public static final Companion Companion = new Companion(null);

    @JvmField
    public static final EventListener NONE = new EventListener() { // from class: okhttp3.EventListener$Companion$NONE$1
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface Factory {
        EventListener create(Call call);
    }

    public void cacheConditionalHit(Call call, Response cachedResponse) {
        Intrinsics.g(call, "call");
        Intrinsics.g(cachedResponse, "cachedResponse");
    }

    public void cacheHit(Call call, Response response) {
        Intrinsics.g(call, "call");
        Intrinsics.g(response, "response");
    }

    public void cacheMiss(Call call) {
        Intrinsics.g(call, "call");
    }

    public void callEnd(Call call) {
        Intrinsics.g(call, "call");
    }

    public void callFailed(Call call, IOException ioe) {
        Intrinsics.g(call, "call");
        Intrinsics.g(ioe, "ioe");
    }

    public void callStart(Call call) {
        Intrinsics.g(call, "call");
    }

    public void canceled(Call call) {
        Intrinsics.g(call, "call");
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Intrinsics.g(call, "call");
        Intrinsics.g(inetSocketAddress, "inetSocketAddress");
        Intrinsics.g(proxy, "proxy");
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException ioe) {
        Intrinsics.g(call, "call");
        Intrinsics.g(inetSocketAddress, "inetSocketAddress");
        Intrinsics.g(proxy, "proxy");
        Intrinsics.g(ioe, "ioe");
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Intrinsics.g(call, "call");
        Intrinsics.g(inetSocketAddress, "inetSocketAddress");
        Intrinsics.g(proxy, "proxy");
    }

    public void connectionAcquired(Call call, Connection connection) {
        Intrinsics.g(call, "call");
        Intrinsics.g(connection, "connection");
    }

    public void connectionReleased(Call call, Connection connection) {
        Intrinsics.g(call, "call");
        Intrinsics.g(connection, "connection");
    }

    public void dnsEnd(Call call, String domainName, List<InetAddress> inetAddressList) {
        Intrinsics.g(call, "call");
        Intrinsics.g(domainName, "domainName");
        Intrinsics.g(inetAddressList, "inetAddressList");
    }

    public void dnsStart(Call call, String domainName) {
        Intrinsics.g(call, "call");
        Intrinsics.g(domainName, "domainName");
    }

    public void proxySelectEnd(Call call, HttpUrl url, List<Proxy> proxies) {
        Intrinsics.g(call, "call");
        Intrinsics.g(url, "url");
        Intrinsics.g(proxies, "proxies");
    }

    public void proxySelectStart(Call call, HttpUrl url) {
        Intrinsics.g(call, "call");
        Intrinsics.g(url, "url");
    }

    public void requestBodyEnd(Call call, long j11) {
        Intrinsics.g(call, "call");
    }

    public void requestBodyStart(Call call) {
        Intrinsics.g(call, "call");
    }

    public void requestFailed(Call call, IOException ioe) {
        Intrinsics.g(call, "call");
        Intrinsics.g(ioe, "ioe");
    }

    public void requestHeadersEnd(Call call, Request request) {
        Intrinsics.g(call, "call");
        Intrinsics.g(request, "request");
    }

    public void requestHeadersStart(Call call) {
        Intrinsics.g(call, "call");
    }

    public void responseBodyEnd(Call call, long j11) {
        Intrinsics.g(call, "call");
    }

    public void responseBodyStart(Call call) {
        Intrinsics.g(call, "call");
    }

    public void responseFailed(Call call, IOException ioe) {
        Intrinsics.g(call, "call");
        Intrinsics.g(ioe, "ioe");
    }

    public void responseHeadersEnd(Call call, Response response) {
        Intrinsics.g(call, "call");
        Intrinsics.g(response, "response");
    }

    public void responseHeadersStart(Call call) {
        Intrinsics.g(call, "call");
    }

    public void satisfactionFailure(Call call, Response response) {
        Intrinsics.g(call, "call");
        Intrinsics.g(response, "response");
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        Intrinsics.g(call, "call");
    }

    public void secureConnectStart(Call call) {
        Intrinsics.g(call, "call");
    }
}
