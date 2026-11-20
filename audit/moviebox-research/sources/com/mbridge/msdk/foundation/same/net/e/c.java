package com.mbridge.msdk.foundation.same.net.e;

import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.ad;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class c extends e<JSONArray> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f44593c = "c";

    public c(int i11, String str, String str2, com.mbridge.msdk.foundation.same.net.e<JSONArray> eVar) {
        super(i11, str, str2, eVar);
    }

    @Override // com.mbridge.msdk.foundation.same.net.i
    public final k<JSONArray> a(com.mbridge.msdk.foundation.same.net.f.c cVar) {
        try {
            return k.a(new JSONArray(new String(cVar.f44605a, com.mbridge.msdk.foundation.same.net.g.b.a(cVar.f44606b))), cVar);
        } catch (UnsupportedEncodingException e11) {
            ad.b(f44593c, e11.getMessage());
            return k.a(new com.mbridge.msdk.foundation.same.net.b.a(8, cVar));
        } catch (JSONException e12) {
            ad.b(f44593c, e12.getMessage());
            return k.a(new com.mbridge.msdk.foundation.same.net.b.a(8, cVar));
        }
    }
}
