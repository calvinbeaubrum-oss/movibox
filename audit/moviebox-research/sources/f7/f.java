package f7;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f64662a = JsonReader.a.a("nm", TtmlNode.TAG_P, "s", "hd", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D);

    public static c7.b a(JsonReader jsonReader, com.airbnb.lottie.h hVar, int i11) throws IOException {
        boolean z11 = i11 == 3;
        String strL = null;
        b7.o<PointF, PointF> oVarB = null;
        b7.f fVarI = null;
        boolean zH = false;
        while (jsonReader.g()) {
            int iP = jsonReader.p(f64662a);
            if (iP == 0) {
                strL = jsonReader.l();
            } else if (iP == 1) {
                oVarB = a.b(jsonReader, hVar);
            } else if (iP == 2) {
                fVarI = d.i(jsonReader, hVar);
            } else if (iP == 3) {
                zH = jsonReader.h();
            } else if (iP != 4) {
                jsonReader.q();
                jsonReader.r();
            } else {
                z11 = jsonReader.j() == 3;
            }
        }
        return new c7.b(strL, oVarB, fVarI, z11, zH);
    }
}
