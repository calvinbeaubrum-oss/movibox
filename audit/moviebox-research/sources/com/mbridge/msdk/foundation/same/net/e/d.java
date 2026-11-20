package com.mbridge.msdk.foundation.same.net.e;

import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.ad;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class d extends e<JSONObject> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f44594c = "d";

    public d(int i11, String str, String str2, com.mbridge.msdk.foundation.same.net.e<JSONObject> eVar) {
        super(i11, str, str2, eVar);
    }

    public d(int i11, String str, String str2, com.mbridge.msdk.foundation.same.net.e<JSONObject> eVar, boolean z11) {
        super(i11, str, str2, eVar, z11);
    }

    @Override // com.mbridge.msdk.foundation.same.net.i
    public final k<JSONObject> a(com.mbridge.msdk.foundation.same.net.f.c cVar) {
        try {
            return cVar.f44608d == 204 ? k.a(new JSONObject(), cVar) : k.a(new JSONObject(new String(cVar.f44605a, com.mbridge.msdk.foundation.same.net.g.b.a(cVar.f44606b))), cVar);
        } catch (UnsupportedEncodingException e11) {
            ad.b(f44594c, e11.getMessage());
            return k.a(new com.mbridge.msdk.foundation.same.net.b.a(8, cVar));
        } catch (JSONException e12) {
            ad.b(f44594c, e12.getMessage());
            return k.a(new com.mbridge.msdk.foundation.same.net.b.a(8, cVar));
        }
    }
}
