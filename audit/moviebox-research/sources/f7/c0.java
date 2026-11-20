package f7;

import android.graphics.PointF;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f64657a = JsonReader.a.a("nm", "sy", "pt", TtmlNode.TAG_P, CampaignEx.JSON_KEY_AD_R, "or", "os", "ir", "is", "hd", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D);

    public static PolystarShape a(JsonReader jsonReader, com.airbnb.lottie.h hVar, int i11) throws IOException {
        boolean z11 = i11 == 3;
        String strL = null;
        PolystarShape.Type typeForValue = null;
        b7.b bVarF = null;
        b7.o<PointF, PointF> oVarB = null;
        b7.b bVarF2 = null;
        b7.b bVarE = null;
        b7.b bVarE2 = null;
        b7.b bVarF3 = null;
        b7.b bVarF4 = null;
        boolean zH = false;
        while (jsonReader.g()) {
            switch (jsonReader.p(f64657a)) {
                case 0:
                    strL = jsonReader.l();
                    break;
                case 1:
                    typeForValue = PolystarShape.Type.forValue(jsonReader.j());
                    break;
                case 2:
                    bVarF = d.f(jsonReader, hVar, false);
                    break;
                case 3:
                    oVarB = a.b(jsonReader, hVar);
                    break;
                case 4:
                    bVarF2 = d.f(jsonReader, hVar, false);
                    break;
                case 5:
                    bVarE2 = d.e(jsonReader, hVar);
                    break;
                case 6:
                    bVarF4 = d.f(jsonReader, hVar, false);
                    break;
                case 7:
                    bVarE = d.e(jsonReader, hVar);
                    break;
                case 8:
                    bVarF3 = d.f(jsonReader, hVar, false);
                    break;
                case 9:
                    zH = jsonReader.h();
                    break;
                case 10:
                    z11 = jsonReader.j() == 3;
                    break;
                default:
                    jsonReader.q();
                    jsonReader.r();
                    break;
            }
        }
        return new PolystarShape(strL, typeForValue, bVarF, oVarB, bVarF2, bVarE, bVarE2, bVarF3, bVarF4, zH, z11);
    }
}
