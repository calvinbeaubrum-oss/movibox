package com.mbridge.msdk.mbbid.common.b;

import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.same.net.f;
import com.mbridge.msdk.foundation.same.net.f.c;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b extends f<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f45435a = "b";

    public b(String str, String str2) {
        this.unitId = str2;
        this.placementId = str;
    }

    public abstract void a(int i11, String str);

    public abstract void a(BidResponsedEx bidResponsedEx);

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public void onError(com.mbridge.msdk.foundation.same.net.b.a aVar) {
        ad.b(f45435a, "errorCode = " + aVar.f44551a);
        a(aVar.f44551a, com.mbridge.msdk.foundation.same.net.g.a.a(aVar));
    }

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public void onSuccess(k<JSONObject> kVar) {
        c cVar;
        super.onSuccess(kVar);
        if (kVar == null || (cVar = kVar.f44690b) == null) {
            return;
        }
        List<com.mbridge.msdk.foundation.same.net.d.b> list = cVar.f44606b;
        JSONObject jSONObject = kVar.f44691c;
        int iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        if (200 != iOptInt) {
            a(iOptInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
            return;
        }
        BidResponsedEx bidResponsedEx = BidResponsedEx.parseBidResponsedEx(jSONObject.optJSONObject("data"), this.unitId);
        if (bidResponsedEx != null) {
            a(bidResponsedEx);
        } else {
            a(iOptInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
        }
    }
}
