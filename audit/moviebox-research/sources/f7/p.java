package f7;

import android.graphics.Path;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f64694a = JsonReader.a.a("nm", "g", "o", "t", "s", "e", CampaignEx.JSON_KEY_AD_R, "hd");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f64695b = JsonReader.a.a(TtmlNode.TAG_P, CampaignEx.JSON_KEY_AD_K);

    public static c7.e a(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        b7.d dVarH = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String strL = null;
        GradientType gradientType = null;
        b7.c cVarG = null;
        b7.f fVarI = null;
        b7.f fVarI2 = null;
        boolean zH = false;
        while (jsonReader.g()) {
            switch (jsonReader.p(f64694a)) {
                case 0:
                    strL = jsonReader.l();
                    break;
                case 1:
                    jsonReader.c();
                    int iJ = -1;
                    while (jsonReader.g()) {
                        int iP = jsonReader.p(f64695b);
                        if (iP == 0) {
                            iJ = jsonReader.j();
                        } else if (iP != 1) {
                            jsonReader.q();
                            jsonReader.r();
                        } else {
                            cVarG = d.g(jsonReader, hVar, iJ);
                        }
                    }
                    jsonReader.e();
                    break;
                case 2:
                    dVarH = d.h(jsonReader, hVar);
                    break;
                case 3:
                    gradientType = jsonReader.j() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case 4:
                    fVarI = d.i(jsonReader, hVar);
                    break;
                case 5:
                    fVarI2 = d.i(jsonReader, hVar);
                    break;
                case 6:
                    fillType = jsonReader.j() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    zH = jsonReader.h();
                    break;
                default:
                    jsonReader.q();
                    jsonReader.r();
                    break;
            }
        }
        return new c7.e(strL, gradientType, fillType, cVarG, dVarH == null ? new b7.d(Collections.singletonList(new h7.a(100))) : dVarH, fVarI, fVarI2, null, null, zH);
    }
}
