package sg;

import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static byte[] a(byte[] bArr) {
        return o0.f35608a >= 27 ? bArr : o0.n0(c(o0.D(bArr)));
    }

    public static byte[] b(byte[] bArr) {
        if (o0.f35608a >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(o0.D(bArr));
            StringBuilder sb2 = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                if (i11 != 0) {
                    sb2.append(",");
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
                sb2.append("{\"k\":\"");
                sb2.append(d(jSONObject2.getString(CampaignEx.JSON_KEY_AD_K)));
                sb2.append("\",\"kid\":\"");
                sb2.append(d(jSONObject2.getString("kid")));
                sb2.append("\",\"kty\":\"");
                sb2.append(jSONObject2.getString("kty"));
                sb2.append("\"}");
            }
            sb2.append("]}");
            return o0.n0(sb2.toString());
        } catch (JSONException e11) {
            com.google.android.exoplayer2.util.s.d("ClearKeyUtil", "Failed to adjust response data: " + o0.D(bArr), e11);
            return bArr;
        }
    }

    public static String c(String str) {
        return str.replace('+', '-').replace('/', '_');
    }

    public static String d(String str) {
        return str.replace('-', '+').replace('_', '/');
    }
}
