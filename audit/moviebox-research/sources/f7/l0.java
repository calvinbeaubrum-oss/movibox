package f7;

import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f64687a = JsonReader.a.a("nm", "c", "w", "o", "lc", "lj", "ml", "hd", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f64688b = JsonReader.a.a("n", "v");

    public static ShapeStroke a(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strL = null;
        b7.b bVar = null;
        b7.a aVarC = null;
        b7.b bVarE = null;
        b7.d dVar = null;
        float fI = 0.0f;
        boolean zH = false;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        while (jsonReader.g()) {
            switch (jsonReader.p(f64687a)) {
                case 0:
                    strL = jsonReader.l();
                    break;
                case 1:
                    aVarC = d.c(jsonReader, hVar);
                    break;
                case 2:
                    bVarE = d.e(jsonReader, hVar);
                    break;
                case 3:
                    dVar = d.h(jsonReader, hVar);
                    break;
                case 4:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.j() - 1];
                    break;
                case 5:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.j() - 1];
                    break;
                case 6:
                    fI = (float) jsonReader.i();
                    break;
                case 7:
                    zH = jsonReader.h();
                    break;
                case 8:
                    jsonReader.b();
                    while (jsonReader.g()) {
                        jsonReader.c();
                        String strL2 = null;
                        b7.b bVarE2 = null;
                        while (jsonReader.g()) {
                            int iP = jsonReader.p(f64688b);
                            if (iP == 0) {
                                strL2 = jsonReader.l();
                            } else if (iP != 1) {
                                jsonReader.q();
                                jsonReader.r();
                            } else {
                                bVarE2 = d.e(jsonReader, hVar);
                            }
                        }
                        jsonReader.e();
                        strL2.hashCode();
                        switch (strL2) {
                            case "d":
                            case "g":
                                hVar.u(true);
                                arrayList.add(bVarE2);
                                break;
                            case "o":
                                bVar = bVarE2;
                                break;
                        }
                    }
                    jsonReader.d();
                    if (arrayList.size() == 1) {
                        arrayList.add((b7.b) arrayList.get(0));
                    }
                    break;
                default:
                    jsonReader.r();
                    break;
            }
        }
        if (dVar == null) {
            dVar = new b7.d(Collections.singletonList(new h7.a(100)));
        }
        if (lineCapType == null) {
            lineCapType = ShapeStroke.LineCapType.BUTT;
        }
        if (lineJoinType == null) {
            lineJoinType = ShapeStroke.LineJoinType.MITER;
        }
        return new ShapeStroke(strL, bVar, arrayList, aVarC, dVar, bVarE, lineCapType, lineJoinType, fI, zH);
    }
}
