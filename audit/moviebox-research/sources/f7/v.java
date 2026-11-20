package f7;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.model.content.LBlendMode;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f64707a = JsonReader.a.a("nm", "ind", "refId", "ty", "parent", "sw", com.mbridge.msdk.foundation.entity.b.JSON_KEY_SH, "sc", "ks", TtmlNode.TAG_TT, "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd", "ao", "bm");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f64708b = JsonReader.a.a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "a");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final JsonReader.a f64709c = JsonReader.a.a("ty", "nm");

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f64710a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f64710a = iArr;
            try {
                iArr[Layer.MatteType.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f64710a[Layer.MatteType.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static Layer a(com.airbnb.lottie.h hVar) {
        Rect rectB = hVar.b();
        return new Layer(Collections.emptyList(), hVar, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, Collections.emptyList(), new b7.n(), 0, 0, 0, 0.0f, 0.0f, rectB.width(), rectB.height(), null, null, Collections.emptyList(), Layer.MatteType.NONE, null, false, null, null, LBlendMode.NORMAL);
    }

    public static Layer b(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        Layer.MatteType matteType = Layer.MatteType.NONE;
        LBlendMode lBlendMode = LBlendMode.NORMAL;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        jsonReader.c();
        Float fValueOf = Float.valueOf(0.0f);
        Float fValueOf2 = Float.valueOf(1.0f);
        Layer.MatteType matteType2 = matteType;
        LBlendMode lBlendMode2 = lBlendMode;
        b7.n nVar = null;
        Layer.LayerType layerType = null;
        String strL = null;
        b7.j jVarD = null;
        b7.k kVarA = null;
        b7.b bVarF = null;
        c7.a aVarB = null;
        j jVarB = null;
        long j11 = 0;
        long j12 = -1;
        boolean z11 = false;
        float fI = 0.0f;
        int iJ = 0;
        int iJ2 = 0;
        int color = 0;
        float fI2 = 1.0f;
        float fI3 = 0.0f;
        float fI4 = 0.0f;
        float fI5 = 0.0f;
        boolean zH = false;
        float f11 = 0.0f;
        String strL2 = "UNSET";
        String strL3 = null;
        while (jsonReader.g()) {
            switch (jsonReader.p(f64707a)) {
                case 0:
                    strL2 = jsonReader.l();
                    break;
                case 1:
                    j11 = jsonReader.j();
                    break;
                case 2:
                    strL = jsonReader.l();
                    break;
                case 3:
                    int iJ3 = jsonReader.j();
                    layerType = Layer.LayerType.UNKNOWN;
                    if (iJ3 < layerType.ordinal()) {
                        layerType = Layer.LayerType.values()[iJ3];
                    }
                    break;
                case 4:
                    j12 = jsonReader.j();
                    break;
                case 5:
                    iJ = (int) (jsonReader.j() * g7.l.e());
                    break;
                case 6:
                    iJ2 = (int) (jsonReader.j() * g7.l.e());
                    break;
                case 7:
                    color = Color.parseColor(jsonReader.l());
                    break;
                case 8:
                    nVar = c.g(jsonReader, hVar);
                    break;
                case 9:
                    int iJ4 = jsonReader.j();
                    if (iJ4 < Layer.MatteType.values().length) {
                        matteType2 = Layer.MatteType.values()[iJ4];
                        int i11 = a.f64710a[matteType2.ordinal()];
                        if (i11 == 1) {
                            hVar.a("Unsupported matte type: Luma");
                        } else if (i11 == 2) {
                            hVar.a("Unsupported matte type: Luma Inverted");
                        }
                        hVar.r(1);
                    } else {
                        hVar.a("Unsupported matte type: " + iJ4);
                    }
                    break;
                case 10:
                    jsonReader.b();
                    while (jsonReader.g()) {
                        arrayList.add(x.a(jsonReader, hVar));
                    }
                    hVar.r(arrayList.size());
                    jsonReader.d();
                    break;
                case 11:
                    jsonReader.b();
                    while (jsonReader.g()) {
                        c7.c cVarA = h.a(jsonReader, hVar);
                        if (cVarA != null) {
                            arrayList2.add(cVarA);
                        }
                    }
                    jsonReader.d();
                    break;
                case 12:
                    jsonReader.c();
                    while (jsonReader.g()) {
                        int iP = jsonReader.p(f64708b);
                        if (iP == 0) {
                            jVarD = d.d(jsonReader, hVar);
                        } else if (iP != 1) {
                            jsonReader.q();
                            jsonReader.r();
                        } else {
                            jsonReader.b();
                            if (jsonReader.g()) {
                                kVarA = b.a(jsonReader, hVar);
                            }
                            while (jsonReader.g()) {
                                jsonReader.r();
                            }
                            jsonReader.d();
                        }
                    }
                    jsonReader.e();
                    break;
                case 13:
                    jsonReader.b();
                    ArrayList arrayList3 = new ArrayList();
                    while (jsonReader.g()) {
                        jsonReader.c();
                        while (jsonReader.g()) {
                            int iP2 = jsonReader.p(f64709c);
                            if (iP2 == 0) {
                                int iJ5 = jsonReader.j();
                                if (iJ5 == 29) {
                                    aVarB = e.b(jsonReader, hVar);
                                } else if (iJ5 == 25) {
                                    jVarB = new k().b(jsonReader, hVar);
                                }
                            } else if (iP2 != 1) {
                                jsonReader.q();
                                jsonReader.r();
                            } else {
                                arrayList3.add(jsonReader.l());
                            }
                        }
                        jsonReader.e();
                    }
                    jsonReader.d();
                    hVar.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList3);
                    break;
                case 14:
                    fI2 = (float) jsonReader.i();
                    break;
                case 15:
                    fI3 = (float) jsonReader.i();
                    break;
                case 16:
                    fI4 = (float) (jsonReader.i() * ((double) g7.l.e()));
                    break;
                case 17:
                    fI5 = (float) (jsonReader.i() * ((double) g7.l.e()));
                    break;
                case 18:
                    fI = (float) jsonReader.i();
                    break;
                case 19:
                    f11 = (float) jsonReader.i();
                    break;
                case 20:
                    bVarF = d.f(jsonReader, hVar, false);
                    break;
                case 21:
                    strL3 = jsonReader.l();
                    break;
                case 22:
                    zH = jsonReader.h();
                    break;
                case 23:
                    z11 = jsonReader.j() == 1;
                    break;
                case 24:
                    int iJ6 = jsonReader.j();
                    if (iJ6 < LBlendMode.values().length) {
                        lBlendMode2 = LBlendMode.values()[iJ6];
                    } else {
                        hVar.a("Unsupported Blend Mode: " + iJ6);
                        lBlendMode2 = LBlendMode.NORMAL;
                    }
                    break;
                default:
                    jsonReader.q();
                    jsonReader.r();
                    break;
            }
        }
        jsonReader.e();
        ArrayList arrayList4 = new ArrayList();
        if (fI > 0.0f) {
            arrayList4.add(new h7.a(hVar, fValueOf, fValueOf, null, 0.0f, Float.valueOf(fI)));
        }
        if (f11 <= 0.0f) {
            f11 = hVar.f();
        }
        arrayList4.add(new h7.a(hVar, fValueOf2, fValueOf2, null, fI, Float.valueOf(f11)));
        arrayList4.add(new h7.a(hVar, fValueOf, fValueOf, null, f11, Float.valueOf(Float.MAX_VALUE)));
        if (strL2.endsWith(".ai") || "ai".equals(strL3)) {
            hVar.a("Convert your Illustrator layers to shape layers.");
        }
        if (z11 != 0) {
            if (nVar == null) {
                nVar = new b7.n();
            }
            nVar.m(z11);
        }
        return new Layer(arrayList2, hVar, strL2, j11, layerType, j12, strL, arrayList, nVar, iJ, iJ2, color, fI2, fI3, fI4, fI5, jVarD, kVarA, arrayList4, matteType2, bVarF, zH, aVarB, jVarB, lBlendMode2);
    }
}
