package com.mbridge.msdk.foundation.same.net.stack;

import android.text.TextUtils;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.foundation.same.net.dns.MBDns;
import com.mbridge.msdk.foundation.same.net.i;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.thrid.okhttp.Call;
import com.mbridge.msdk.thrid.okhttp.Connection;
import com.mbridge.msdk.thrid.okhttp.EventListener;
import com.mbridge.msdk.thrid.okhttp.Headers;
import com.mbridge.msdk.thrid.okhttp.MediaType;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import com.mbridge.msdk.thrid.okhttp.Protocol;
import com.mbridge.msdk.thrid.okhttp.Request;
import com.mbridge.msdk.thrid.okhttp.RequestBody;
import com.mbridge.msdk.thrid.okhttp.Response;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class OkHttpStack implements b {
    private final OkHttpClient mClient = c.a.f44720a.b();

    /* JADX INFO: compiled from: source.java */
    public static class DefaultEventListener extends EventListener {
        private long callDuring;
        private long callStart;
        private long connectDuring;
        private String connectErrorMessage;
        private long connectStart;
        private long connectionDuring;
        private long connectionStart;
        private long dnsDuring;
        private String dnsResult;
        private long dnsStart;
        private String hostName;
        private c.b httpStatus;
        private boolean isReportHttpStatus;
        private String method;

        public DefaultEventListener(String str) {
            try {
                boolean zA = c.a().a(str);
                this.isReportHttpStatus = zA;
                if (zA) {
                    this.httpStatus = c.a().c();
                }
            } catch (Exception unused) {
                this.isReportHttpStatus = false;
                this.httpStatus = null;
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.EventListener
        public void callEnd(Call call) {
            super.callEnd(call);
            try {
                com.mbridge.msdk.foundation.same.net.a.a().b();
            } catch (Exception unused) {
            }
            if (!this.isReportHttpStatus || this.httpStatus == null) {
                return;
            }
            try {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.callStart;
                this.callDuring = jCurrentTimeMillis;
                c.b bVar = this.httpStatus;
                bVar.f44731k = 0;
                bVar.f44730j = this.method;
                bVar.f44721a = jCurrentTimeMillis;
                bVar.f44729i = this.hostName;
                bVar.f44726f = this.dnsDuring;
                bVar.f44727g = this.dnsResult;
                bVar.f44723c = this.connectDuring;
                bVar.f44725e = this.connectionDuring;
                c.a().a(this.httpStatus);
            } catch (Exception e11) {
                ad.b("OkHttpStack", e11.getMessage());
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.EventListener
        public void callFailed(Call call, IOException iOException) {
            super.callFailed(call, iOException);
            try {
                com.mbridge.msdk.foundation.same.net.a.a().c();
            } catch (Exception unused) {
            }
            if (!this.isReportHttpStatus || this.httpStatus == null) {
                return;
            }
            try {
                this.callDuring = System.currentTimeMillis() - this.callStart;
                if (TextUtils.isEmpty(this.connectErrorMessage)) {
                    this.httpStatus.f44731k = 2;
                } else {
                    c.b bVar = this.httpStatus;
                    bVar.f44731k = 1;
                    bVar.f44724d = this.connectErrorMessage;
                }
                this.httpStatus.f44722b = iOException != null ? iOException.getMessage() : "IO Exception";
                c.b bVar2 = this.httpStatus;
                bVar2.f44721a = this.callDuring;
                bVar2.f44729i = this.hostName;
                bVar2.f44730j = this.method;
                bVar2.f44726f = this.dnsDuring;
                bVar2.f44727g = this.dnsResult;
                bVar2.f44723c = this.connectDuring;
                bVar2.f44725e = this.connectionDuring;
                c.a().a(this.httpStatus);
            } catch (Exception e11) {
                ad.b("OkHttpStack", e11.getMessage());
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.EventListener
        public void callStart(Call call) {
            super.callStart(call);
            try {
                com.mbridge.msdk.foundation.same.net.a.a().e();
            } catch (Exception unused) {
            }
            if (!this.isReportHttpStatus || this.httpStatus == null) {
                return;
            }
            this.callStart = System.currentTimeMillis();
            if (call != null) {
                try {
                    this.method = call.request().method();
                } catch (Exception unused2) {
                    this.method = "";
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.EventListener
        public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
            super.connectEnd(call, inetSocketAddress, proxy, protocol);
            if (this.isReportHttpStatus && this.httpStatus != null) {
                this.connectDuring = System.currentTimeMillis() - this.connectStart;
                this.connectErrorMessage = "";
            }
            try {
                e.a().e(call.request().url().host());
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.EventListener
        public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
            super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
            if (this.isReportHttpStatus && this.httpStatus != null) {
                this.connectDuring = System.currentTimeMillis() - this.connectStart;
                this.connectErrorMessage = iOException != null ? iOException.getMessage() : "IO Exception";
            }
            try {
                e.a().d(call.request().url().host());
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.EventListener
        public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
            super.connectStart(call, inetSocketAddress, proxy);
            if (!this.isReportHttpStatus || this.httpStatus == null) {
                return;
            }
            this.connectStart = System.currentTimeMillis();
        }

        @Override // com.mbridge.msdk.thrid.okhttp.EventListener
        public void connectionAcquired(Call call, Connection connection) {
            super.connectionAcquired(call, connection);
            if (!this.isReportHttpStatus || this.httpStatus == null) {
                return;
            }
            this.connectionStart = System.currentTimeMillis();
        }

        @Override // com.mbridge.msdk.thrid.okhttp.EventListener
        public void connectionReleased(Call call, Connection connection) {
            super.connectionReleased(call, connection);
            if (!this.isReportHttpStatus || this.httpStatus == null) {
                return;
            }
            this.connectionDuring = System.currentTimeMillis() - this.connectionStart;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.EventListener
        public void dnsEnd(Call call, String str, List<InetAddress> list) {
            super.dnsEnd(call, str, list);
            if (!this.isReportHttpStatus || this.httpStatus == null) {
                return;
            }
            try {
                this.dnsDuring = System.currentTimeMillis() - this.dnsStart;
                if (TextUtils.isEmpty(str)) {
                    this.hostName = "unKnown";
                } else {
                    this.hostName = str;
                }
                if (list != null && list.size() != 0) {
                    InetAddress inetAddress = list.get(0);
                    if (inetAddress != null && !TextUtils.isEmpty(inetAddress.getHostAddress())) {
                        this.dnsResult = inetAddress.getHostAddress();
                        return;
                    }
                    this.dnsResult = "unKnown";
                    return;
                }
                this.dnsResult = "unKnown";
            } catch (Exception e11) {
                ad.b("OkHttpStack", e11.getMessage());
                this.hostName = "";
                this.dnsResult = "";
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.EventListener
        public void dnsStart(Call call, String str) {
            super.dnsStart(call, str);
            if (!this.isReportHttpStatus || this.httpStatus == null) {
                return;
            }
            this.dnsStart = System.currentTimeMillis();
        }
    }

    private static RequestBody createRequestBody(i iVar) {
        byte[] bArrH = iVar.h();
        if (bArrH == null) {
            return null;
        }
        return RequestBody.create((MediaType) null, bArrH);
    }

    private static void setConnectionParametersForRequest(Request.Builder builder, i<?> iVar) throws IOException {
        switch (iVar.l()) {
            case 0:
                builder.get();
                return;
            case 1:
                builder.post(createRequestBody(iVar));
                return;
            case 2:
                builder.put(createRequestBody(iVar));
                return;
            case 3:
                builder.delete();
                return;
            case 4:
                builder.head();
                return;
            case 5:
                builder.method("OPTIONS", null);
                return;
            case 6:
                builder.method("TRACE", null);
                return;
            case 7:
                builder.patch(createRequestBody(iVar));
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.stack.b
    public com.mbridge.msdk.foundation.same.net.f.b performRequest(i<?> iVar) throws IOException {
        int iO = iVar.o();
        int iJ = iVar.j();
        int iM = iVar.m();
        int iP = iVar.p();
        int i11 = iVar.i();
        if (iJ == 0) {
            iJ = iO;
        }
        if (iM == 0) {
            iM = iO;
        }
        if (iP != 0) {
            iO = iP;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Protocol.HTTP_1_1);
        arrayList.add(Protocol.HTTP_2);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient.Builder builderEventListener = this.mClient.newBuilder().protocols(arrayList).readTimeout(iM, timeUnit).connectTimeout(iJ, timeUnit).writeTimeout(iO, timeUnit).eventListener(new DefaultEventListener(iVar.s()));
        if (i11 > 0) {
            builderEventListener.callTimeout(i11, timeUnit);
        }
        builderEventListener.dns(new MBDns());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("connectTimeout: ");
        sb2.append(iJ);
        sb2.append(" readTimeout: ");
        sb2.append(iM);
        sb2.append(" writeTimeout: ");
        sb2.append(iO);
        sb2.append(" callTimeout: ");
        sb2.append(i11 == 0 ? "not set" : Integer.valueOf(i11));
        ad.a("OkHttpStack", sb2.toString());
        Request.Builder builder = new Request.Builder();
        for (Map.Entry<String, String> entry : iVar.k().entrySet()) {
            builder.addHeader(entry.getKey(), entry.getValue());
        }
        setConnectionParametersForRequest(builder, iVar);
        Response responseExecute = builderEventListener.build().newCall(builder.url(iVar.s()).build()).execute();
        Headers headers = responseExecute.headers();
        ArrayList arrayList2 = new ArrayList();
        int size = headers.size();
        for (int i12 = 0; i12 < size; i12++) {
            String strName = headers.name(i12);
            String strValue = headers.value(i12);
            if (strName != null) {
                arrayList2.add(new com.mbridge.msdk.foundation.same.net.d.b(strName, strValue));
            }
        }
        return new com.mbridge.msdk.foundation.same.net.f.b(responseExecute.code(), arrayList2, responseExecute.body().byteStream());
    }
}
