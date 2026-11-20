package f7;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f64655a = JsonReader.a.a("a", TtmlNode.TAG_P, "s", "rz", CampaignEx.JSON_KEY_AD_R, "o", "so", "eo", "sk", "sa");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f64656b = JsonReader.a.a(CampaignEx.JSON_KEY_AD_K);

    public static boolean a(b7.e eVar) {
        return eVar == null || (eVar.c() && eVar.b().get(0).f66350b.equals(0.0f, 0.0f));
    }

    public static boolean b(b7.o<PointF, PointF> oVar) {
        return oVar == null || (!(oVar instanceof b7.i) && oVar.c() && oVar.b().get(0).f66350b.equals(0.0f, 0.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean c(b7.b bVar) {
        return bVar == null || (bVar.c() && ((Float) ((h7.a) bVar.b().get(0)).f66350b).floatValue() == 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean d(b7.g gVar) {
        return gVar == null || (gVar.c() && ((h7.d) ((h7.a) gVar.b().get(0)).f66350b).a(1.0f, 1.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean e(b7.b bVar) {
        return bVar == null || (bVar.c() && ((Float) ((h7.a) bVar.b().get(0)).f66350b).floatValue() == 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean f(b7.b bVar) {
        return bVar == null || (bVar.c() && ((Float) ((h7.a) bVar.b().get(0)).f66350b).floatValue() == 0.0f);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0066  */
    /* JADX WARN: Code duplicated, block: B:24:0x0090  */
    /* JADX WARN: Code duplicated, block: B:26:0x009f  */
    public static b7.n g(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        b7.b bVarF;
        boolean z11 = false;
        boolean z12 = jsonReader.n() == JsonReader.Token.BEGIN_OBJECT;
        if (z12) {
            jsonReader.c();
        }
        b7.b bVar = null;
        b7.e eVarA = null;
        b7.o<PointF, PointF> oVarB = null;
        b7.g gVarJ = null;
        b7.b bVarF2 = null;
        b7.b bVarF3 = null;
        b7.d dVarH = null;
        b7.b bVarF4 = null;
        b7.b bVarF5 = null;
        while (jsonReader.g()) {
            switch (jsonReader.p(f64655a)) {
                case 0:
                    jsonReader.c();
                    while (jsonReader.g()) {
                        if (jsonReader.p(f64656b) != 0) {
                            jsonReader.q();
                            jsonReader.r();
                        } else {
                            eVarA = a.a(jsonReader, hVar);
                        }
                    }
                    jsonReader.e();
                    z11 = false;
                    break;
                case 1:
                    oVarB = a.b(jsonReader, hVar);
                    z11 = false;
                    break;
                case 2:
                    gVarJ = d.j(jsonReader, hVar);
                    z11 = false;
                    break;
                case 3:
                    hVar.a("Lottie doesn't support 3D layers.");
                    bVarF = d.f(jsonReader, hVar, z11);
                    if (bVarF.b().isEmpty()) {
                        if (((h7.a) bVarF.b().get(0)).f66350b == 0) {
                            bVarF.b().set(0, new h7.a(hVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(hVar.f())));
                        }
                        bVar = bVarF;
                        z11 = false;
                    } else {
                        bVarF.b().add(new h7.a(hVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(hVar.f())));
                    }
                    bVar = bVarF;
                    z11 = false;
                    break;
                case 4:
                    bVarF = d.f(jsonReader, hVar, z11);
                    if (bVarF.b().isEmpty()) {
                        if (((h7.a) bVarF.b().get(0)).f66350b == 0) {
                            bVarF.b().set(0, new h7.a(hVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(hVar.f())));
                        }
                        bVar = bVarF;
                        z11 = false;
                    } else {
                        bVarF.b().add(new h7.a(hVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(hVar.f())));
                    }
                    bVar = bVarF;
                    z11 = false;
                    break;
                case 5:
                    dVarH = d.h(jsonReader, hVar);
                    break;
                case 6:
                    bVarF4 = d.f(jsonReader, hVar, z11);
                    break;
                case 7:
                    bVarF5 = d.f(jsonReader, hVar, z11);
                    break;
                case 8:
                    bVarF2 = d.f(jsonReader, hVar, z11);
                    break;
                case 9:
                    bVarF3 = d.f(jsonReader, hVar, z11);
                    break;
                default:
                    jsonReader.q();
                    jsonReader.r();
                    break;
            }
        }
        if (z12) {
            jsonReader.e();
        }
        b7.e eVar = a(eVarA) ? null : eVarA;
        b7.o<PointF, PointF> oVar = b(oVarB) ? null : oVarB;
        b7.b bVar2 = c(bVar) ? null : bVar;
        if (d(gVarJ)) {
            gVarJ = null;
        }
        return new b7.n(eVar, oVar, gVarJ, bVar2, dVarH, bVarF4, bVarF5, f(bVarF2) ? null : bVarF2, e(bVarF3) ? null : bVarF3);
    }
}
