package f7;

import android.graphics.Rect;
import androidx.collection.w0;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f64711a = JsonReader.a.a("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static JsonReader.a f64712b = JsonReader.a.a("id", "layers", "w", "h", TtmlNode.TAG_P, "u");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final JsonReader.a f64713c = JsonReader.a.a("list");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final JsonReader.a f64714d = JsonReader.a.a("cm", "tm", DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_RATE);

    public static com.airbnb.lottie.h a(JsonReader jsonReader) throws IOException {
        float fE = g7.l.e();
        androidx.collection.v<Layer> vVar = new androidx.collection.v<>();
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        w0<a7.c> w0Var = new w0<>();
        com.airbnb.lottie.h hVar = new com.airbnb.lottie.h();
        jsonReader.c();
        int iJ = 0;
        float fI = 0.0f;
        float fI2 = 0.0f;
        float fI3 = 0.0f;
        int iJ2 = 0;
        while (jsonReader.g()) {
            switch (jsonReader.p(f64711a)) {
                case 0:
                    iJ2 = jsonReader.j();
                    continue;
                case 1:
                    iJ = jsonReader.j();
                    continue;
                case 2:
                    fI = (float) jsonReader.i();
                    continue;
                case 3:
                    fI2 = ((float) jsonReader.i()) - 0.01f;
                    break;
                case 4:
                    fI3 = (float) jsonReader.i();
                    break;
                case 5:
                    String[] strArrSplit = jsonReader.l().split("\\.");
                    if (!g7.l.j(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        hVar.a("Lottie only supports bodymovin >= 4.4.0");
                        continue;
                    }
                    break;
                case 6:
                    e(jsonReader, hVar, arrayList, vVar);
                    continue;
                case 7:
                    b(jsonReader, hVar, map, map2);
                    continue;
                case 8:
                    d(jsonReader, map3);
                    continue;
                case 9:
                    c(jsonReader, hVar, w0Var);
                    continue;
                case 10:
                    f(jsonReader, arrayList2);
                    continue;
                default:
                    jsonReader.q();
                    jsonReader.r();
                    continue;
            }
            map3 = map3;
            arrayList2 = arrayList2;
        }
        hVar.s(new Rect(0, 0, (int) (iJ2 * fE), (int) (iJ * fE)), fI, fI2, fI3, arrayList, vVar, map, map2, g7.l.e(), w0Var, map3, arrayList2, iJ2, iJ);
        return hVar;
    }

    public static void b(JsonReader jsonReader, com.airbnb.lottie.h hVar, Map<String, List<Layer>> map, Map<String, com.airbnb.lottie.l0> map2) throws IOException {
        jsonReader.b();
        while (jsonReader.g()) {
            ArrayList arrayList = new ArrayList();
            androidx.collection.v vVar = new androidx.collection.v();
            jsonReader.c();
            String strL = null;
            String strL2 = null;
            String strL3 = null;
            int iJ = 0;
            int iJ2 = 0;
            while (jsonReader.g()) {
                int iP = jsonReader.p(f64712b);
                if (iP == 0) {
                    strL = jsonReader.l();
                } else if (iP == 1) {
                    jsonReader.b();
                    while (jsonReader.g()) {
                        Layer layerB = v.b(jsonReader, hVar);
                        vVar.l(layerB.e(), layerB);
                        arrayList.add(layerB);
                    }
                    jsonReader.d();
                } else if (iP == 2) {
                    iJ = jsonReader.j();
                } else if (iP == 3) {
                    iJ2 = jsonReader.j();
                } else if (iP == 4) {
                    strL2 = jsonReader.l();
                } else if (iP != 5) {
                    jsonReader.q();
                    jsonReader.r();
                } else {
                    strL3 = jsonReader.l();
                }
            }
            jsonReader.e();
            if (strL2 != null) {
                com.airbnb.lottie.l0 l0Var = new com.airbnb.lottie.l0(iJ, iJ2, strL, strL2, strL3);
                map2.put(l0Var.e(), l0Var);
            } else {
                map.put(strL, arrayList);
            }
        }
        jsonReader.d();
    }

    public static void c(JsonReader jsonReader, com.airbnb.lottie.h hVar, w0<a7.c> w0Var) throws IOException {
        jsonReader.b();
        while (jsonReader.g()) {
            a7.c cVarA = m.a(jsonReader, hVar);
            w0Var.m(cVarA.hashCode(), cVarA);
        }
        jsonReader.d();
    }

    public static void d(JsonReader jsonReader, Map<String, a7.b> map) throws IOException {
        jsonReader.c();
        while (jsonReader.g()) {
            if (jsonReader.p(f64713c) != 0) {
                jsonReader.q();
                jsonReader.r();
            } else {
                jsonReader.b();
                while (jsonReader.g()) {
                    a7.b bVarA = n.a(jsonReader);
                    map.put(bVarA.b(), bVarA);
                }
                jsonReader.d();
            }
        }
        jsonReader.e();
    }

    public static void e(JsonReader jsonReader, com.airbnb.lottie.h hVar, List<Layer> list, androidx.collection.v<Layer> vVar) throws IOException {
        jsonReader.b();
        int i11 = 0;
        while (jsonReader.g()) {
            Layer layerB = v.b(jsonReader, hVar);
            if (layerB.g() == Layer.LayerType.IMAGE) {
                i11++;
            }
            list.add(layerB);
            vVar.l(layerB.e(), layerB);
            if (i11 > 4) {
                g7.f.c("You have " + i11 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.d();
    }

    public static void f(JsonReader jsonReader, List<a7.g> list) throws IOException {
        jsonReader.b();
        while (jsonReader.g()) {
            jsonReader.c();
            float fI = 0.0f;
            String strL = null;
            float fI2 = 0.0f;
            while (jsonReader.g()) {
                int iP = jsonReader.p(f64714d);
                if (iP == 0) {
                    strL = jsonReader.l();
                } else if (iP == 1) {
                    fI = (float) jsonReader.i();
                } else if (iP != 2) {
                    jsonReader.q();
                    jsonReader.r();
                } else {
                    fI2 = (float) jsonReader.i();
                }
            }
            jsonReader.e();
            list.add(new a7.g(strL, fI, fI2));
        }
        jsonReader.d();
    }
}
