package f7;

import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f64696a = JsonReader.a.a("nm", "g", "o", "t", "s", "e", "w", "lc", "lj", "ml", "hd", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f64697b = JsonReader.a.a(TtmlNode.TAG_P, CampaignEx.JSON_KEY_AD_K);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final JsonReader.a f64698c = JsonReader.a.a("n", "v");

    public static com.airbnb.lottie.model.content.a a(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strL = null;
        GradientType gradientType = null;
        b7.c cVarG = null;
        b7.f fVarI = null;
        b7.f fVarI2 = null;
        b7.b bVarE = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float fI = 0.0f;
        b7.b bVar = null;
        boolean zH = false;
        b7.d dVar = null;
        while (jsonReader.g()) {
            switch (jsonReader.p(f64696a)) {
                case 0:
                    strL = jsonReader.l();
                    continue;
                case 1:
                    jsonReader.c();
                    int iJ = -1;
                    while (jsonReader.g()) {
                        int iP = jsonReader.p(f64697b);
                        if (iP == 0) {
                            iJ = jsonReader.j();
                        } else if (iP != 1) {
                            jsonReader.q();
                            jsonReader.r();
                        } else {
                            cVarG = d.g(jsonReader, hVar, iJ);
                        }
                        cVarG = cVarG;
                    }
                    jsonReader.e();
                    break;
                case 2:
                    dVar = d.h(jsonReader, hVar);
                    continue;
                case 3:
                    gradientType = jsonReader.j() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case 4:
                    fVarI = d.i(jsonReader, hVar);
                    continue;
                case 5:
                    fVarI2 = d.i(jsonReader, hVar);
                    continue;
                case 6:
                    bVarE = d.e(jsonReader, hVar);
                    continue;
                case 7:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.j() - 1];
                    break;
                case 8:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.j() - 1];
                    break;
                case 9:
                    fI = (float) jsonReader.i();
                    break;
                case 10:
                    zH = jsonReader.h();
                    continue;
                case 11:
                    jsonReader.b();
                    while (jsonReader.g()) {
                        jsonReader.c();
                        String strL2 = null;
                        b7.b bVarE2 = null;
                        while (jsonReader.g()) {
                            int iP2 = jsonReader.p(f64698c);
                            if (iP2 != 0) {
                                b7.b bVar2 = bVar;
                                if (iP2 != 1) {
                                    jsonReader.q();
                                    jsonReader.r();
                                } else {
                                    bVarE2 = d.e(jsonReader, hVar);
                                }
                                bVar = bVar2;
                            } else {
                                strL2 = jsonReader.l();
                            }
                        }
                        b7.b bVar3 = bVar;
                        jsonReader.e();
                        if (strL2.equals("o")) {
                            bVar = bVarE2;
                        } else {
                            if (strL2.equals(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D) || strL2.equals("g")) {
                                hVar.u(true);
                                arrayList.add(bVarE2);
                            }
                            bVar = bVar3;
                        }
                    }
                    b7.b bVar4 = bVar;
                    jsonReader.d();
                    if (arrayList.size() == 1) {
                        arrayList.add((b7.b) arrayList.get(0));
                    }
                    bVar = bVar4;
                    continue;
                default:
                    jsonReader.q();
                    jsonReader.r();
                    continue;
            }
            strL = strL;
        }
        String str = strL;
        if (dVar == null) {
            dVar = new b7.d(Collections.singletonList(new h7.a(100)));
        }
        return new com.airbnb.lottie.model.content.a(str, gradientType, cVarG, dVar, fVarI, fVarI2, bVarE, lineCapType, lineJoinType, fI, arrayList, bVar, zH);
    }
}
