package iq;

import android.os.SystemClock;
import androidx.core.view.PointerIconCompat;
import com.google.android.gms.ads.RequestConfiguration;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Call;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class f extends EventListener implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventListener f67624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f67625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f67626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f67627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f67628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f67629f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f67630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f67631h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f67632i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f67633j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f67634k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f67635l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f67636m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f67637n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final e f67638o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f67639p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f67640q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f67641r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f67642s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f67643t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f67644u;

    public f(EventListener eventListener, int i11, boolean z11, String str, boolean z12, String str2, boolean z13, boolean z14) {
        this.f67624a = eventListener;
        this.f67625b = i11;
        this.f67626c = z11;
        this.f67627d = str2;
        this.f67628e = z13;
        this.f67629f = z14;
        this.f67638o = e.J.a(i11, str);
        this.f67639p = z11 || z12;
        this.f67641r = 480;
        this.f67642s = 480;
        this.f67643t = "Unknown";
        this.f67644u = kotlin.ranges.a.o(new IntRange(1, 10), Random.Default);
    }

    @Override // iq.i
    public void a(Request request) {
        Intrinsics.g(request, "request");
        c.c("[onRequestUpdate]");
        try {
            Result.Companion companion = Result.Companion;
            String strHost = request.url().host();
            String strEncodedPath = request.url().encodedPath();
            e eVar = this.f67638o;
            if (strEncodedPath == null) {
                strEncodedPath = "";
            } else {
                Intrinsics.f(strEncodedPath, "path ?: \"\"");
            }
            eVar.Y(strEncodedPath);
            e eVar2 = this.f67638o;
            if (strHost == null) {
                strHost = "";
            } else {
                Intrinsics.f(strHost, "host ?: \"\"");
            }
            eVar2.U(strHost);
            String string = request.url().toString();
            Intrinsics.f(string, "request.url().toString()");
            this.f67638o.P(this.f67644u <= 2 ? string : "");
            e eVar3 = this.f67638o;
            if (this.f67625b == 0 && StringsKt__StringsKt.Q(string, "?", false, 2, null)) {
                string = string.substring(0, StringsKt__StringsKt.d0(string, "?", 0, false, 6, null));
                Intrinsics.f(string, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            eVar3.g0(string);
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    @Override // iq.i
    public void b(Request request, int i11) {
        Intrinsics.g(request, "request");
        c.c("[onDowngrade]");
        if (!this.f67626c) {
            this.f67639p = false;
        }
        this.f67638o.d0(i11);
    }

    public final boolean c() {
        k kVar = k.f67654a;
        return kVar.f() || SystemClock.uptimeMillis() - kVar.b() > 3000;
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        Intrinsics.g(call, "call");
        super.callEnd(call);
        c.c("[callEnd]");
        e eVar = this.f67638o;
        eVar.I(1);
        eVar.c0(c.e(this.f67630g));
        eVar.S(this.f67641r);
        if (eVar.m() != 304 && !this.f67639p) {
            c.g(eVar);
        }
        EventListener eventListener = this.f67624a;
        if (eventListener != null) {
            eventListener.callEnd(call);
        }
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException ioe) {
        Intrinsics.g(call, "call");
        Intrinsics.g(ioe, "ioe");
        super.callFailed(call, ioe);
        c.b("[callFailed]  " + ioe.getClass().getSimpleName() + " : " + ioe.getMessage());
        this.f67638o.I(2);
        if (c()) {
            k kVar = k.f67654a;
            if (!kVar.g()) {
                this.f67642s = PointerIconCompat.TYPE_GRAB;
                this.f67643t = "Network disconnect";
            } else if (kVar.e()) {
                this.f67642s = PointerIconCompat.TYPE_GRABBING;
                this.f67643t = "Fake Network";
            } else {
                this.f67642s = a.f67592a.a(this.f67641r, ioe);
            }
        } else {
            this.f67642s = a.f67592a.a(this.f67641r, ioe);
        }
        this.f67638o.S(this.f67642s);
        this.f67638o.T(Intrinsics.b(this.f67643t, "Unknown") ? c.f(ioe) : this.f67643t);
        if (!this.f67639p) {
            boolean z11 = (this.f67628e && this.f67642s == 1050) ? false : true;
            if ((!this.f67629f || this.f67642s != 1020) && z11) {
                c.g(this.f67638o);
            }
        }
        EventListener eventListener = this.f67624a;
        if (eventListener != null) {
            eventListener.callFailed(call, ioe);
        }
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        Intrinsics.g(call, "call");
        super.callStart(call);
        c.c("[callStart]");
        try {
            String str = call.request().headers().get("isDownload");
            if (str != null) {
                this.f67638o.l0((Intrinsics.b(str, "true") || Intrinsics.b(str, RequestConfiguration.MAX_AD_CONTENT_RATING_T)) ? 1 : 0);
            }
            String str2 = call.request().headers().get("offlineAd");
            if (str2 != null) {
                this.f67638o.X(Integer.parseInt(str2));
            }
            String strHost = call.request().url().host();
            String strEncodedPath = call.request().url().encodedPath();
            e eVar = this.f67638o;
            String str3 = "";
            if (strEncodedPath == null) {
                strEncodedPath = "";
            }
            eVar.Y(strEncodedPath);
            e eVar2 = this.f67638o;
            if (strHost == null) {
                strHost = "";
            }
            eVar2.U(strHost);
            String string = call.request().url().toString();
            Intrinsics.f(string, "call.request().url().toString()");
            this.f67638o.P(this.f67644u <= 2 ? string : "");
            e eVar3 = this.f67638o;
            if (this.f67625b == 0 && StringsKt__StringsKt.Q(string, "?", false, 2, null)) {
                string = string.substring(0, StringsKt__StringsKt.d0(string, "?", 0, false, 6, null));
                Intrinsics.f(string, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            eVar3.g0(string);
            String str4 = call.request().headers().get("infoeyes-tag");
            e eVar4 = this.f67638o;
            if (str4 != null || (str4 = this.f67627d) != null) {
                str3 = str4;
            }
            eVar4.O(str3);
        } catch (Exception e11) {
            c.b("[get header exception] " + e11.getClass().getSimpleName() + " : " + e11.getMessage());
        }
        this.f67630g = c.d();
        EventListener eventListener = this.f67624a;
        if (eventListener != null) {
            eventListener.callStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        String strName;
        Intrinsics.g(call, "call");
        Intrinsics.g(inetSocketAddress, "inetSocketAddress");
        Intrinsics.g(proxy, "proxy");
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        c.c("[connectEnd] inetSocketAddress " + inetSocketAddress);
        this.f67638o.j0(c.e(this.f67633j));
        e eVar = this.f67638o;
        if (protocol == null || (strName = protocol.name()) == null) {
            strName = "";
        }
        eVar.Z(strName);
        EventListener eventListener = this.f67624a;
        if (eventListener != null) {
            eventListener.connectEnd(call, inetSocketAddress, proxy, protocol);
        }
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException ioe) {
        String strName;
        Intrinsics.g(call, "call");
        Intrinsics.g(inetSocketAddress, "inetSocketAddress");
        Intrinsics.g(proxy, "proxy");
        Intrinsics.g(ioe, "ioe");
        super.connectFailed(call, inetSocketAddress, proxy, protocol, ioe);
        c.b("[connectFailed] " + ioe.getClass().getSimpleName() + " : " + ioe.getMessage());
        e eVar = this.f67638o;
        if (protocol == null || (strName = protocol.name()) == null) {
            strName = "";
        }
        eVar.Z(strName);
        EventListener eventListener = this.f67624a;
        if (eventListener != null) {
            eventListener.connectFailed(call, inetSocketAddress, proxy, protocol, ioe);
        }
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Intrinsics.g(call, "call");
        Intrinsics.g(inetSocketAddress, "inetSocketAddress");
        Intrinsics.g(proxy, "proxy");
        super.connectStart(call, inetSocketAddress, proxy);
        this.f67633j = c.d();
        e eVar = this.f67638o;
        String hostAddress = inetSocketAddress.getAddress().getHostAddress();
        if (hostAddress == null) {
            hostAddress = "";
        }
        eVar.W(hostAddress);
        c.c("[connectStart] inetSocketAddress : " + inetSocketAddress + ", proxy : " + proxy);
        EventListener eventListener = this.f67624a;
        if (eventListener != null) {
            eventListener.connectStart(call, inetSocketAddress, proxy);
        }
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        String strName;
        TlsVersion tlsVersion;
        Intrinsics.g(call, "call");
        Intrinsics.g(connection, "connection");
        super.connectionAcquired(call, connection);
        c.c("[connectionAcquired] connection: " + connection);
        e eVar = this.f67638o;
        Handshake handshake = connection.handshake();
        if (handshake == null || (tlsVersion = handshake.tlsVersion()) == null || (strName = tlsVersion.name()) == null) {
            strName = "";
        }
        eVar.k0(strName);
        this.f67638o.Z(connection.protocol().name());
        EventListener eventListener = this.f67624a;
        if (eventListener != null) {
            eventListener.connectionAcquired(call, connection);
        }
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call call, Connection connection) {
        Intrinsics.g(call, "call");
        Intrinsics.g(connection, "connection");
        super.connectionReleased(call, connection);
        c.c("[connectionReleased]");
        EventListener eventListener = this.f67624a;
        if (eventListener != null) {
            eventListener.connectionReleased(call, connection);
        }
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String domainName, List<? extends InetAddress> inetAddressList) {
        Intrinsics.g(call, "call");
        Intrinsics.g(domainName, "domainName");
        Intrinsics.g(inetAddressList, "inetAddressList");
        super.dnsEnd(call, domainName, inetAddressList);
        c.c("[dnsEnd] inetAddressList " + CollectionsKt___CollectionsKt.o0(inetAddressList, ",", "[", "]", 0, null, null, 56, null));
        this.f67638o.R(c.e(this.f67631h));
        EventListener eventListener = this.f67624a;
        if (eventListener != null) {
            eventListener.dnsEnd(call, domainName, inetAddressList);
        }
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String domainName) {
        Intrinsics.g(call, "call");
        Intrinsics.g(domainName, "domainName");
        super.dnsStart(call, domainName);
        c.c("[dnsStart] domainName: " + domainName);
        this.f67631h = c.d();
        EventListener eventListener = this.f67624a;
        if (eventListener != null) {
            eventListener.dnsStart(call, domainName);
        }
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j11) {
        Intrinsics.g(call, "call");
        super.requestBodyEnd(call, j11);
        c.c("[requestBodyEnd] byteCount: " + j11);
        this.f67636m = c.d();
        e eVar = this.f67638o;
        eVar.b0(j11);
        eVar.f0(this.f67636m - this.f67634k);
        EventListener eventListener = this.f67624a;
        if (eventListener != null) {
            eventListener.requestBodyEnd(call, j11);
        }
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        Intrinsics.g(call, "call");
        super.requestBodyStart(call);
        c.c("[requestBodyStart]");
        EventListener eventListener = this.f67624a;
        if (eventListener != null) {
            eventListener.requestBodyStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void requestFailed(Call call, IOException ioe) {
        Intrinsics.g(call, "call");
        Intrinsics.g(ioe, "ioe");
        super.requestFailed(call, ioe);
        c.b("[requestFailed] " + ioe.getClass().getSimpleName() + " : " + ioe.getMessage());
        EventListener eventListener = this.f67624a;
        if (eventListener != null) {
            eventListener.requestFailed(call, ioe);
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        Intrinsics.g(call, "call");
        Intrinsics.g(request, "request");
        super.requestHeadersEnd(call, request);
        c.c("[requestHeadersEnd] request :" + request);
        long jD = c.d();
        this.f67635l = jD;
        this.f67638o.f0(jD - this.f67634k);
        EventListener eventListener = this.f67624a;
        if (eventListener != null) {
            eventListener.requestHeadersEnd(call, request);
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        Intrinsics.g(call, "call");
        super.requestHeadersStart(call);
        c.c("[requestHeadersStart]");
        this.f67634k = c.d();
        EventListener eventListener = this.f67624a;
        if (eventListener != null) {
            eventListener.requestHeadersStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j11) {
        Intrinsics.g(call, "call");
        super.responseBodyEnd(call, j11);
        c.c("[responseBodyEnd] byteCount: " + j11);
        e eVar = this.f67638o;
        eVar.e0(j11);
        eVar.a0(c.e(this.f67637n));
        eVar.J(c.e(this.f67640q));
        eVar.M(String.valueOf((j11 / 1024.0f) / (eVar.c() / 1000.0f)));
        EventListener eventListener = this.f67624a;
        if (eventListener != null) {
            eventListener.responseBodyEnd(call, j11);
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        Intrinsics.g(call, "call");
        super.responseBodyStart(call);
        c.c("[responseBodyStart]");
        EventListener eventListener = this.f67624a;
        if (eventListener != null) {
            eventListener.responseBodyStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void responseFailed(Call call, IOException ioe) {
        Intrinsics.g(call, "call");
        Intrinsics.g(ioe, "ioe");
        super.responseFailed(call, ioe);
        c.b("[responseFailed] " + ioe.getClass().getSimpleName() + " : " + ioe.getMessage());
        EventListener eventListener = this.f67624a;
        if (eventListener != null) {
            eventListener.responseFailed(call, ioe);
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        Intrinsics.g(call, "call");
        Intrinsics.g(response, "response");
        super.responseHeadersEnd(call, response);
        c.c("[responseHeadersEnd] code : " + response.code());
        String str = response.headers().get("x-response-cdn");
        if (str == null) {
            str = "";
        }
        String str2 = response.headers().get("server-time");
        if (str2 == null) {
            str2 = "0";
        }
        long j11 = Long.parseLong(str2);
        c.c(str);
        this.f67638o.K(str);
        this.f67640q = c.d();
        this.f67638o.a0(c.e(this.f67637n));
        this.f67638o.L(c.e(this.f67630g));
        this.f67638o.h0(j11);
        this.f67641r = response.code();
        EventListener eventListener = this.f67624a;
        if (eventListener != null) {
            eventListener.responseHeadersEnd(call, response);
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        Intrinsics.g(call, "call");
        super.responseHeadersStart(call);
        c.c("[responseHeadersStart]");
        long jD = c.d();
        this.f67637n = jD;
        this.f67638o.m0(jD - Math.max(this.f67636m, this.f67635l));
        EventListener eventListener = this.f67624a;
        if (eventListener != null) {
            eventListener.responseHeadersStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        String strName;
        TlsVersion tlsVersion;
        Intrinsics.g(call, "call");
        super.secureConnectEnd(call, handshake);
        c.c("[secureConnectEnd]");
        e eVar = this.f67638o;
        if (handshake == null || (tlsVersion = handshake.tlsVersion()) == null || (strName = tlsVersion.name()) == null) {
            strName = "";
        }
        eVar.k0(strName);
        this.f67638o.i0(c.e(this.f67632i));
        EventListener eventListener = this.f67624a;
        if (eventListener != null) {
            eventListener.secureConnectEnd(call, handshake);
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        Intrinsics.g(call, "call");
        super.secureConnectStart(call);
        c.c("[secureConnectStart]");
        this.f67632i = c.d();
        EventListener eventListener = this.f67624a;
        if (eventListener != null) {
            eventListener.secureConnectStart(call);
        }
    }
}
