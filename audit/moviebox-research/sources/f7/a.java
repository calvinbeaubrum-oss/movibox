package f7;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f64649a = JsonReader.a.a(CampaignEx.JSON_KEY_AD_K, "x", "y");

    public static b7.e a(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.n() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.b();
            while (jsonReader.g()) {
                arrayList.add(z.a(jsonReader, hVar));
            }
            jsonReader.d();
            u.b(arrayList);
        } else {
            arrayList.add(new h7.a(s.e(jsonReader, g7.l.e())));
        }
        return new b7.e(arrayList);
    }

    public static b7.o<PointF, PointF> b(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        jsonReader.c();
        b7.e eVarA = null;
        b7.b bVarE = null;
        b7.b bVarE2 = null;
        boolean z11 = false;
        while (jsonReader.n() != JsonReader.Token.END_OBJECT) {
            int iP = jsonReader.p(f64649a);
            if (iP == 0) {
                eVarA = a(jsonReader, hVar);
            } else if (iP != 1) {
                if (iP != 2) {
                    jsonReader.q();
                    jsonReader.r();
                } else if (jsonReader.n() == JsonReader.Token.STRING) {
                    jsonReader.r();
                    z11 = true;
                } else {
                    bVarE2 = d.e(jsonReader, hVar);
                }
            } else if (jsonReader.n() == JsonReader.Token.STRING) {
                jsonReader.r();
                z11 = true;
            } else {
                bVarE = d.e(jsonReader, hVar);
            }
        }
        jsonReader.e();
        if (z11) {
            hVar.a("Lottie doesn't support expressions.");
        }
        return eVarA != null ? eVarA : new b7.i(bVarE, bVarE2);
    }
}
