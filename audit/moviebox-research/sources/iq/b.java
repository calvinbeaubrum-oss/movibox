package iq;

import android.os.SystemClock;
import androidx.core.view.PointerIconCompat;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.android.gms.ads.RequestConfiguration;
import java.net.URL;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Headers;
import org.chromium.net.CronetException;
import org.chromium.net.NetworkException;
import org.chromium.net.RequestFinishedInfo;
import org.chromium.net.UrlResponseInfo;

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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f67593a = new b();

    public final boolean a() {
        k kVar = k.f67654a;
        return kVar.f() || SystemClock.uptimeMillis() - kVar.b() > 3000;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00c6  */
    public final void b(RequestFinishedInfo requestInfo, int i11, String channel, String tag, boolean z11, boolean z12, boolean z13) {
        int i12;
        int iB;
        List<String> list;
        List<String> list2;
        Object next;
        String strSubstring;
        int i13;
        Intrinsics.g(requestInfo, "requestInfo");
        Intrinsics.g(channel, "channel");
        Intrinsics.g(tag, "tag");
        if (z12 && requestInfo.getFinishedReason() == 2) {
            return;
        }
        UrlResponseInfo responseInfo = requestInfo.getResponseInfo();
        String negotiatedProtocol = responseInfo != null ? responseInfo.getNegotiatedProtocol() : null;
        if (negotiatedProtocol == null) {
            negotiatedProtocol = "";
        }
        e eVarA = e.J.a(i11, channel);
        eVarA.V(2);
        eVarA.Z(negotiatedProtocol);
        UrlResponseInfo responseInfo2 = requestInfo.getResponseInfo();
        int httpStatusCode = responseInfo2 != null ? responseInfo2.getHttpStatusCode() : 480;
        RequestFinishedInfo.Metrics metrics = requestInfo.getMetrics();
        int iO = kotlin.ranges.a.o(new IntRange(1, 10), Random.Default);
        String string = requestInfo.getUrl().toString();
        eVarA.P(iO <= 2 ? string : "");
        try {
            Collection<Object> annotations = requestInfo.getAnnotations();
            Intrinsics.f(annotations, "requestInfo.annotations");
            Iterator<T> it = annotations.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(next instanceof Headers));
            Headers headers = next instanceof Headers ? (Headers) next : null;
            if (headers != null) {
                String str = headers.get("isDownload");
                if (str != null) {
                    int iHashCode = str.hashCode();
                    if (iHashCode != 84) {
                        if (iHashCode == 3569038 && str.equals("true")) {
                            i13 = 1;
                        } else {
                            i13 = 0;
                        }
                    } else if (str.equals(RequestConfiguration.MAX_AD_CONTENT_RATING_T)) {
                        i13 = 1;
                    } else {
                        i13 = 0;
                    }
                    eVarA.l0(i13);
                }
                eVarA.X(Intrinsics.b(headers.get("offlineAd"), "1") ? 1 : 0);
            } else {
                headers = null;
            }
            String str2 = headers != null ? headers.get("infoeyes-tag") : null;
            if (str2 == null) {
                str2 = tag;
            }
            eVarA.O(str2);
            if (eVarA.G() == 0 && StringsKt__StringsKt.Q(string, "?", false, 2, null)) {
                i12 = 0;
                try {
                    strSubstring = string.substring(0, StringsKt__StringsKt.d0(string, "?", 0, false, 6, null));
                    Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                } catch (Exception e11) {
                    e = e11;
                    String message = e.getMessage();
                    if (message != null) {
                        c.c(message);
                    }
                }
            } else {
                i12 = 0;
                strSubstring = string;
            }
            eVarA.g0(strSubstring);
            String host = new URL(string).getHost();
            String path = new URL(string).getPath();
            Intrinsics.f(host, "host");
            eVarA.U(host);
            Intrinsics.f(path, "path");
            eVarA.Y(path);
        } catch (Exception e12) {
            e = e12;
            i12 = 0;
        }
        if (requestInfo.getFinishedReason() == 0) {
            eVarA.I(1);
            Date dnsStart = metrics.getDnsStart();
            long time = dnsStart != null ? dnsStart.getTime() : 0L;
            Date dnsEnd = metrics.getDnsEnd();
            eVarA.R((dnsEnd != null ? dnsEnd.getTime() : 0L) - time);
            Date sslStart = metrics.getSslStart();
            long time2 = sslStart != null ? sslStart.getTime() : 0L;
            Date sslEnd = metrics.getSslEnd();
            eVarA.i0((sslEnd != null ? sslEnd.getTime() : 0L) - time2);
            Date connectStart = metrics.getConnectStart();
            long time3 = connectStart != null ? connectStart.getTime() : 0L;
            Date connectEnd = metrics.getConnectEnd();
            eVarA.j0((connectEnd != null ? connectEnd.getTime() : 0L) - time3);
            Date sendingStart = metrics.getSendingStart();
            long time4 = sendingStart != null ? sendingStart.getTime() : 0L;
            Date sendingEnd = metrics.getSendingEnd();
            long time5 = sendingEnd != null ? sendingEnd.getTime() : 0L;
            eVarA.f0(time5 - time4);
            Date responseStart = metrics.getResponseStart();
            long time6 = responseStart != null ? responseStart.getTime() : 0L;
            Date requestEnd = metrics.getRequestEnd();
            eVarA.a0((requestEnd != null ? requestEnd.getTime() : 0L) - time6);
            eVarA.m0(time6 - time5);
            Long receivedByteCount = metrics.getReceivedByteCount();
            eVarA.e0(receivedByteCount == null ? 0L : receivedByteCount.longValue());
            Long sentByteCount = metrics.getSentByteCount();
            eVarA.b0(sentByteCount == null ? 0L : sentByteCount.longValue());
            UrlResponseInfo responseInfo3 = requestInfo.getResponseInfo();
            Map<String, List<String>> allHeaders = responseInfo3 != null ? responseInfo3.getAllHeaders() : null;
            List<String> list3 = allHeaders != null ? allHeaders.get(HttpHeaders.CONTENT_ENCODING) : null;
            if (list3 != null) {
                Iterator<String> it2 = list3.iterator();
                if (it2.hasNext()) {
                    String contentEncoding = it2.next();
                    Intrinsics.f(contentEncoding, "contentEncoding");
                    eVarA.Q(contentEncoding);
                }
            }
            String str3 = (allHeaders == null || (list2 = allHeaders.get("server-time")) == null) ? null : list2.get(i12);
            if (str3 == null) {
                str3 = "0";
            }
            eVarA.h0(Long.parseLong(str3));
            Long totalTimeMs = metrics.getTotalTimeMs();
            eVarA.c0(totalTimeMs == null ? 0L : totalTimeMs.longValue());
            if (eVarA.G() == 1) {
                String str4 = (allHeaders == null || (list = allHeaders.get("x-response-cdn")) == null) ? null : list.get(i12);
                eVarA.K(str4 == null ? "" : str4);
                Date requestStart = metrics.getRequestStart();
                eVarA.L(time6 - (requestStart != null ? requestStart.getTime() : 0L));
                eVarA.J(eVarA.u());
                eVarA.M(String.valueOf((eVarA.y() / 1024.0f) / (eVarA.u() / 1000.0f)));
            }
        } else {
            eVarA.I(2);
            boolean z14 = requestInfo.getFinishedReason() == 2;
            CronetException exception = requestInfo.getException();
            String message2 = exception != null ? exception.getMessage() : null;
            String str5 = message2 == null ? "" : message2;
            if (requestInfo.getException() instanceof NetworkException) {
                CronetException exception2 = requestInfo.getException();
                Intrinsics.e(exception2, "null cannot be cast to non-null type org.chromium.net.NetworkException");
                NetworkException networkException = (NetworkException) exception2;
                if (a()) {
                    k kVar = k.f67654a;
                    if (!kVar.g()) {
                        str5 = "Network disconnect";
                        httpStatusCode = PointerIconCompat.TYPE_GRAB;
                    } else if (kVar.e()) {
                        str5 = "Fake Network";
                        httpStatusCode = PointerIconCompat.TYPE_GRABBING;
                    } else {
                        iB = a.f67592a.b(httpStatusCode, networkException, z14);
                    }
                } else {
                    iB = a.f67592a.b(httpStatusCode, networkException, z14);
                }
                httpStatusCode = iB;
            } else {
                httpStatusCode = z14 ? 1050 : 480;
            }
            eVarA.T(str5);
        }
        eVarA.S(httpStatusCode);
        if (z11 || httpStatusCode == 304) {
            return;
        }
        if (z13 && httpStatusCode == 1020) {
            return;
        }
        c.g(eVarA);
    }
}
