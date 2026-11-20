package com.android.volley.toolbox;

import androidx.annotation.Nullable;
import com.android.volley.ParseError;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class j extends k<JSONObject> {
    public j(int i11, String str, @Nullable JSONObject jSONObject, com.android.volley.i.b<JSONObject> bVar, @Nullable com.android.volley.i.a aVar) {
        super(i11, str, jSONObject != null ? jSONObject.toString() : null, bVar, aVar);
    }

    public j(String str, com.android.volley.i.b<JSONObject> bVar, @Nullable com.android.volley.i.a aVar) {
        super(0, str, null, bVar, aVar);
    }

    @Deprecated
    public j(String str, @Nullable JSONObject jSONObject, com.android.volley.i.b<JSONObject> bVar, @Nullable com.android.volley.i.a aVar) {
        super(jSONObject == null ? 0 : 1, str, jSONObject != null ? jSONObject.toString() : null, bVar, aVar);
    }

    @Override // com.android.volley.toolbox.k, com.android.volley.Request
    public com.android.volley.i<JSONObject> parseNetworkResponse(com.android.volley.g gVar) {
        try {
            return com.android.volley.i.c(new JSONObject(new String(gVar.f16505b, d.f(gVar.f16506c, "utf-8"))), d.e(gVar));
        } catch (UnsupportedEncodingException e11) {
            return com.android.volley.i.a(new ParseError(e11));
        } catch (JSONException e12) {
            return com.android.volley.i.a(new ParseError(e12));
        }
    }
}
