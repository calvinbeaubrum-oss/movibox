package com.facebook.biddingkit.facebook.bidder;

import android.text.TextUtils;
import com.facebook.biddingkit.http.util.HttpStatusCode;
import java.util.List;
import java.util.Map;
import uf.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {
    public static a a(e eVar, long j11) {
        if (eVar == null) {
            com.facebook.biddingkit.logging.b.a("FacebookBidBuilder", "Got empty http response");
            return null;
        }
        com.facebook.biddingkit.logging.b.a("FacebookBidBuilder", c(eVar.c(), eVar.b(), j11));
        String strA = eVar.a();
        if (strA == null || strA.isEmpty()) {
            com.facebook.biddingkit.logging.b.c("FacebookBidBuilder", b(eVar.c(), eVar.b()));
            return null;
        }
        com.facebook.biddingkit.logging.b.a("FacebookBidBuilder", "Bid response from Facebook: " + strA);
        return new a(eVar);
    }

    public static String b(int i11, Map<String, List<String>> map) {
        String errorMessage = HttpStatusCode.getValue(i11).getErrorMessage();
        if (map == null || !map.containsKey("x-fb-an-errors")) {
            return errorMessage;
        }
        String string = map.get("x-fb-an-errors").toString();
        return !TextUtils.isEmpty(string) ? string : errorMessage;
    }

    public static String c(int i11, Map<String, List<String>> map, long j11) {
        StringBuilder sb2 = new StringBuilder("Bid request for facebook finished. HTTP status: " + i11 + ". ");
        if (map != null && map.containsKey("x-fb-an-request-id")) {
            sb2.append("Request ID: " + map.get("x-fb-an-request-id"));
        }
        sb2.append("Time taken: " + (System.currentTimeMillis() - j11) + "ms");
        return sb2.toString();
    }
}
