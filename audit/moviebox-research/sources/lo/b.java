package lo;

import com.applovin.sdk.AppLovinErrorCodes;
import com.tmc.monitor.AppMonitor;
import com.tmc.network.NetworkConfig;
import com.tmc.network.NetworkMonitor;
import com.tmc.network.stat.ConnectStat;
import com.tmc.network.stat.RequestStat;
import com.tmc.network.strategy.LocalDnsStrategy;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.TlsVersion;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class b extends EventListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f70347c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EventListener.Factory f70348d = new EventListener.Factory() { // from class: lo.a
        @Override // okhttp3.EventListener.Factory
        public final EventListener create(Call call) {
            return b.d(call);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RequestStat f70349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConnectStat f70350b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EventListener.Factory a() {
            return b.f70348d;
        }
    }

    @JvmOverloads
    public b(RequestStat requestStat, ConnectStat connectStat) {
        Intrinsics.g(requestStat, "requestStat");
        Intrinsics.g(connectStat, "connectStat");
        this.f70349a = requestStat;
        this.f70350b = connectStat;
        NetworkMonitor networkMonitor = NetworkMonitor.INSTANCE;
        connectStat.setNetworkConnected(networkMonitor.isConnected());
        this.f70350b.setNetStatus(networkMonitor.getNetworkStatus());
        this.f70349a.setNetStatus(this.f70350b.getNetStatus());
        this.f70349a.setNetworkConnected(this.f70350b.isNetworkConnected());
        ConnectStat connectStat2 = this.f70350b;
        NetworkConfig networkConfig = NetworkConfig.INSTANCE;
        connectStat2.setAppName(networkConfig.getPackageName());
        this.f70349a.setAppName(networkConfig.getPackageName());
        this.f70349a.setNetworkType(networkMonitor.getNetworkType());
        this.f70350b.setNetworkType(networkMonitor.getNetworkType());
        this.f70349a.setNetworkImprove(networkConfig.isNetworkImproveEnable());
        this.f70350b.setNetworkImprove(networkConfig.isNetworkImproveEnable());
    }

    public /* synthetic */ b(RequestStat requestStat, ConnectStat connectStat, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new RequestStat() : requestStat, (i11 & 2) != 0 ? new ConnectStat() : connectStat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final EventListener d(Call it) {
        Intrinsics.g(it, "it");
        return new b(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        Intrinsics.g(call, "call");
        super.callEnd(call);
        this.f70349a.setOnewayTime(System.currentTimeMillis() - this.f70349a.getCallStart());
        this.f70350b.setStep(10);
        this.f70349a.setStep(10);
        if (this.f70349a.isPre()) {
            return;
        }
        AppMonitor.d().c(this.f70349a);
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException ioe) {
        Intrinsics.g(call, "call");
        Intrinsics.g(ioe, "ioe");
        super.callFailed(call, ioe);
        this.f70349a.setOnewayTime(System.currentTimeMillis() - this.f70349a.getCallStart());
        this.f70349a.setRet(0);
        this.f70349a.setConnRet(this.f70350b.getRet());
        this.f70349a.setErrMsg(ioe.getMessage());
        this.f70350b.setStep(this.f70349a.getStep());
        if (ioe instanceof UnknownHostException) {
            this.f70349a.setErrCode(-399);
            this.f70350b.setDnsTime(System.currentTimeMillis() - this.f70350b.getDnsStart());
            if (!this.f70350b.isPre()) {
                AppMonitor.d().c(this.f70350b);
            }
        } else if (ioe instanceof SSLException) {
            this.f70349a.setErrCode(-402);
        } else if (ioe instanceof ConnectException) {
            this.f70349a.setErrCode(AppLovinErrorCodes.INCENTIVIZED_UNKNOWN_SERVER_ERROR);
        } else {
            this.f70349a.setErrCode(-406);
            if (Intrinsics.b(this.f70349a.getErrMsg(), "Canceled")) {
                this.f70349a.setRet(2);
            }
        }
        if (this.f70349a.isPre()) {
            return;
        }
        AppMonitor.d().c(this.f70349a);
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        Intrinsics.g(call, "call");
        super.callStart(call);
        this.f70349a.setUrl(call.request().url().toString());
        this.f70350b.setHost(call.request().url().host());
        this.f70349a.setHost(this.f70350b.getHost());
        this.f70349a.setCallStart(System.currentTimeMillis());
        if (Intrinsics.b(call.request().header("isPre"), "true")) {
            this.f70349a.setPre(true);
            this.f70350b.setPre(true);
        }
        this.f70349a.setRequestChannel(call.request().header("requestChannel"));
        this.f70350b.setStep(0);
        this.f70349a.setStep(0);
    }

    @Override // okhttp3.EventListener
    public void canceled(Call call) {
        Intrinsics.g(call, "call");
        super.canceled(call);
        this.f70349a.setOnewayTime(System.currentTimeMillis() - this.f70349a.getCallStart());
        this.f70349a.setRet(2);
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Intrinsics.g(call, "call");
        Intrinsics.g(inetSocketAddress, "inetSocketAddress");
        Intrinsics.g(proxy, "proxy");
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        ConnectStat connectStat = this.f70350b;
        InetAddress address = inetSocketAddress.getAddress();
        connectStat.setIp(address == null ? null : address.getHostAddress());
        this.f70350b.setProtocol(protocol != null ? protocol.name() : null);
        this.f70350b.setRet(1);
        this.f70350b.setConnTime(System.currentTimeMillis() - this.f70350b.getConnectStart());
        this.f70349a.setConnWaitTime(this.f70350b.getConnTime());
        ConnectStat connectStat2 = this.f70350b;
        connectStat2.setTcpTime(connectStat2.getConnTime() - this.f70350b.getTlsTime());
        this.f70349a.setTcpTime(this.f70350b.getTcpTime());
        this.f70350b.setStep(this.f70349a.getStep());
        if (this.f70350b.isPre()) {
            return;
        }
        AppMonitor.d().c(this.f70350b);
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException ioe) {
        Intrinsics.g(call, "call");
        Intrinsics.g(inetSocketAddress, "inetSocketAddress");
        Intrinsics.g(proxy, "proxy");
        Intrinsics.g(ioe, "ioe");
        super.connectFailed(call, inetSocketAddress, proxy, protocol, ioe);
        this.f70350b.setConnTime(System.currentTimeMillis() - this.f70350b.getConnectStart());
        this.f70349a.setConnWaitTime(this.f70350b.getConnTime());
        this.f70350b.setRet(0);
        this.f70350b.setErrMsg(ioe.getMessage());
        if (ioe instanceof SSLPeerUnverifiedException) {
            this.f70350b.setErrCode(-402);
            String message = ioe.getMessage();
            if (message != null && StringsKt__StringsKt.O(message, "Certificate pinning failure!", true)) {
                this.f70350b.setPinning(true);
                this.f70349a.setPinning(true);
            }
        } else if (ioe instanceof SSLException) {
            this.f70350b.setErrCode(-402);
        } else if (ioe instanceof ConnectException) {
            this.f70350b.setErrCode(AppLovinErrorCodes.INCENTIVIZED_UNKNOWN_SERVER_ERROR);
        } else {
            this.f70350b.setErrCode(-406);
        }
        this.f70350b.setStep(this.f70349a.getStep());
        if (!this.f70350b.isPre()) {
            AppMonitor.d().c(this.f70350b);
        }
        LocalDnsStrategy localDnsStrategyA = LocalDnsStrategy.f49355c.a();
        String hostName = inetSocketAddress.getHostName();
        Intrinsics.f(hostName, "inetSocketAddress.hostName");
        InetAddress address = inetSocketAddress.getAddress();
        Intrinsics.f(address, "inetSocketAddress.address");
        localDnsStrategyA.i(hostName, address);
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Intrinsics.g(call, "call");
        Intrinsics.g(inetSocketAddress, "inetSocketAddress");
        Intrinsics.g(proxy, "proxy");
        super.connectStart(call, inetSocketAddress, proxy);
        this.f70350b.setConnectStart(System.currentTimeMillis());
        this.f70350b.setStep(2);
        this.f70349a.setStep(2);
        this.f70350b.setIp(inetSocketAddress.getAddress().getHostAddress());
        this.f70349a.setIp(this.f70350b.getIp());
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        TlsVersion tlsVersion;
        String strName;
        Intrinsics.g(call, "call");
        Intrinsics.g(connection, "connection");
        super.connectionAcquired(call, connection);
        this.f70349a.setConnRet(1);
        this.f70349a.setIp(connection.route().socketAddress().getAddress().getHostAddress());
        this.f70349a.setProtocol(connection.protocol().name());
        CertificatePinner certificatePinner = connection.route().address().certificatePinner();
        List<CertificatePinner.Pin> listFindMatchingPins = certificatePinner == null ? null : certificatePinner.findMatchingPins(connection.route().address().url().host());
        if (listFindMatchingPins != null && !listFindMatchingPins.isEmpty()) {
            this.f70350b.setPinning(true);
            this.f70349a.setPinning(true);
        }
        RequestStat requestStat = this.f70349a;
        Handshake handshake = connection.handshake();
        String str = "";
        if (handshake != null && (tlsVersion = handshake.tlsVersion()) != null && (strName = tlsVersion.name()) != null) {
            str = strName;
        }
        requestStat.setTlsVersion(str);
        this.f70350b.setTlsVersion(this.f70349a.getTlsVersion());
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String domainName, List<? extends InetAddress> inetAddressList) {
        Intrinsics.g(call, "call");
        Intrinsics.g(domainName, "domainName");
        Intrinsics.g(inetAddressList, "inetAddressList");
        super.dnsEnd(call, domainName, inetAddressList);
        this.f70350b.setDnsTime(System.currentTimeMillis() - this.f70350b.getDnsStart());
        this.f70349a.setDnsTime(this.f70350b.getDnsTime());
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String domainName) {
        Intrinsics.g(call, "call");
        Intrinsics.g(domainName, "domainName");
        super.dnsStart(call, domainName);
        this.f70350b.setDnsStart(System.currentTimeMillis());
        this.f70350b.setStep(1);
        this.f70349a.setStep(1);
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j11) {
        Intrinsics.g(call, "call");
        super.requestBodyEnd(call, j11);
        this.f70349a.setReqBodyTime(System.currentTimeMillis() - this.f70349a.getReqBodyStart());
        this.f70349a.setSendDataEnd(System.currentTimeMillis());
        this.f70349a.setSendDataTime(System.currentTimeMillis() - this.f70349a.getReqHeaderStart());
        this.f70350b.setStep(6);
        this.f70349a.setStep(6);
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        Intrinsics.g(call, "call");
        super.requestBodyStart(call);
        this.f70349a.setReqBodyStart(System.currentTimeMillis());
        this.f70350b.setStep(5);
        this.f70349a.setStep(5);
    }

    @Override // okhttp3.EventListener
    public void requestFailed(Call call, IOException ioe) {
        Intrinsics.g(call, "call");
        Intrinsics.g(ioe, "ioe");
        super.requestFailed(call, ioe);
        this.f70349a.setRet(0);
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        Intrinsics.g(call, "call");
        Intrinsics.g(request, "request");
        super.requestHeadersEnd(call, request);
        this.f70349a.setReqHeaderTime(System.currentTimeMillis() - this.f70349a.getReqHeaderStart());
        this.f70349a.setSendDataEnd(System.currentTimeMillis());
        RequestStat requestStat = this.f70349a;
        requestStat.setSendDataTime(requestStat.getReqHeaderTime());
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        Intrinsics.g(call, "call");
        super.requestHeadersStart(call);
        this.f70349a.setReqHeaderStart(System.currentTimeMillis());
        this.f70350b.setStep(4);
        this.f70349a.setStep(4);
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j11) {
        Intrinsics.g(call, "call");
        super.responseBodyEnd(call, j11);
        this.f70349a.setRecvBodySize(j11);
        this.f70349a.setRecvDataTime(System.currentTimeMillis() - this.f70349a.getSendDataEnd());
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        Intrinsics.g(call, "call");
        super.responseBodyStart(call);
        this.f70350b.setStep(8);
        this.f70349a.setStep(8);
    }

    @Override // okhttp3.EventListener
    public void responseFailed(Call call, IOException ioe) {
        Intrinsics.g(call, "call");
        Intrinsics.g(ioe, "ioe");
        super.responseFailed(call, ioe);
        this.f70349a.setRet(0);
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        Intrinsics.g(call, "call");
        Intrinsics.g(response, "response");
        super.responseHeadersEnd(call, response);
        this.f70349a.setResHeaderTime(System.currentTimeMillis() - this.f70349a.getResHeaderStart());
        String strHeader$default = Response.header$default(response, "X-Cache", null, 2, null);
        this.f70349a.setXCache("miss");
        if (strHeader$default != null && StringsKt__StringsKt.O(strHeader$default, "hit", true)) {
            this.f70349a.setXCache("hit");
        }
        this.f70349a.setRequestSrc(Response.header$default(response, "x-request-cdn", null, 2, null));
        this.f70349a.setRequestLLID(Response.header$default(response, "X-LLID", null, 2, null));
        this.f70349a.setEagleId(Response.header$default(response, "EagleId", null, 2, null));
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        Intrinsics.g(call, "call");
        super.responseHeadersStart(call);
        this.f70349a.setRet(1);
        this.f70349a.setFirstDataTime(System.currentTimeMillis() - this.f70349a.getSendDataEnd());
        this.f70349a.setResHeaderStart(System.currentTimeMillis());
        this.f70350b.setStep(7);
        this.f70349a.setStep(7);
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        Intrinsics.g(call, "call");
        super.secureConnectEnd(call, handshake);
        this.f70350b.setTlsTime(System.currentTimeMillis() - this.f70350b.getTlsStart());
        this.f70349a.setTlsTime(this.f70350b.getTlsTime());
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        Intrinsics.g(call, "call");
        super.secureConnectStart(call);
        this.f70350b.setTlsStart(System.currentTimeMillis());
        this.f70350b.setStep(3);
        this.f70349a.setStep(3);
    }
}
