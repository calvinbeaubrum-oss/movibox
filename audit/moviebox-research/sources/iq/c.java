package iq;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.hisavana.common.tracking.TrackingKey;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

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
public final class c {
    public static final Bundle a(e eVar) {
        Intrinsics.g(eVar, "<this>");
        return androidx.core.os.c.b(TuplesKt.a("usage", Integer.valueOf(eVar.G())), TuplesKt.a("call_id", eVar.a()), TuplesKt.a("call_result_code", Integer.valueOf(eVar.b())), TuplesKt.a(TrackingKey.ERROR_CODE, Integer.valueOf(eVar.m())), TuplesKt.a("error_msg", eVar.n()), TuplesKt.a("server_api", eVar.B()), TuplesKt.a("complete_api", eVar.i()), TuplesKt.a("ip_address", eVar.q()), TuplesKt.a("req_time", Long.valueOf(eVar.w())), TuplesKt.a("dns_time", Long.valueOf(eVar.l())), TuplesKt.a("tcp_time", Long.valueOf(eVar.E())), TuplesKt.a("ssl_time", Long.valueOf(eVar.D())), TuplesKt.a("send_time", Long.valueOf(eVar.A())), TuplesKt.a("wait_time", Long.valueOf(eVar.H())), TuplesKt.a("rec_time", Long.valueOf(eVar.u())), TuplesKt.a("req_body_size", Long.valueOf(eVar.v())), TuplesKt.a("res_body_size", Long.valueOf(eVar.y())), TuplesKt.a("cdn_req_time", Long.valueOf(eVar.e())), TuplesKt.a("cdn_down_time", Long.valueOf(eVar.c())), TuplesKt.a("cdn_speed", eVar.f()), TuplesKt.a("cdn_provider", eVar.d()), TuplesKt.a(PlaceTypes.COUNTRY, eVar.k()), TuplesKt.a("host", eVar.o()), TuplesKt.a(TrackingKey.IS_OFFLINE, Integer.valueOf(eVar.r())), TuplesKt.a("channel", eVar.g()), TuplesKt.a("sdk_version", eVar.z()), TuplesKt.a("server_time", Long.valueOf(eVar.C())), TuplesKt.a("protocol", eVar.t()), TuplesKt.a("compare_tag", eVar.h()), TuplesKt.a("http_type", Integer.valueOf(eVar.p())), TuplesKt.a("content_encoding", eVar.j()), TuplesKt.a("tls_version", eVar.F()), TuplesKt.a("request_downgrade", Integer.valueOf(eVar.x())));
    }

    public static final void b(String str) {
        Intrinsics.g(str, "<this>");
        o.f67667a.j("NetworkMonitor", "=======/ " + str + " /=======");
    }

    public static final void c(String str) {
        Intrinsics.g(str, "<this>");
        o.f67667a.h("NetworkMonitor", "=======/ " + str + " /=======");
    }

    public static final long d() {
        return SystemClock.elapsedRealtime();
    }

    public static final long e(long j11) {
        return d() - j11;
    }

    public static final String f(Exception exc) {
        Intrinsics.g(exc, "<this>");
        if (exc.getMessage() == null) {
            return "";
        }
        String message = exc.getMessage();
        Intrinsics.d(message);
        int iMin = Math.min(message.length(), 200);
        String message2 = exc.getMessage();
        Intrinsics.d(message2);
        String strSubstring = message2.substring(0, iMin);
        Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final void g(e eVar) {
        String str;
        Intrinsics.g(eVar, "<this>");
        o.f67667a.h("NetworkMonitor", eVar.toString());
        if (d.b(eVar.o()) || l.a(eVar.s()) || n.a(eVar.B())) {
            str = "process_black";
        } else {
            str = (d.c(eVar.o()) || l.b(eVar.s()) || n.b(eVar.B())) ? "process_white" : "process";
        }
        new dr.a(str, 1814).c(a(eVar), null).b();
    }
}
