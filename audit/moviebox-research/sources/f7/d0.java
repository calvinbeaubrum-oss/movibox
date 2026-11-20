package f7;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f64658a = JsonReader.a.a("nm", TtmlNode.TAG_P, "s", CampaignEx.JSON_KEY_AD_R, "hd");

    public static c7.f a(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        String strL = null;
        b7.o<PointF, PointF> oVarB = null;
        b7.f fVarI = null;
        b7.b bVarE = null;
        boolean zH = false;
        while (jsonReader.g()) {
            int iP = jsonReader.p(f64658a);
            if (iP == 0) {
                strL = jsonReader.l();
            } else if (iP == 1) {
                oVarB = a.b(jsonReader, hVar);
            } else if (iP == 2) {
                fVarI = d.i(jsonReader, hVar);
            } else if (iP == 3) {
                bVarE = d.e(jsonReader, hVar);
            } else if (iP != 4) {
                jsonReader.r();
            } else {
                zH = jsonReader.h();
            }
        }
        return new c7.f(strL, oVarB, fVarI, bVarE, zH);
    }
}
