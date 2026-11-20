package f7;

import androidx.annotation.Nullable;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f64666a = JsonReader.a.a("ty", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D);

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    @Nullable
    public static c7.c a(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        c7.c cVarA;
        String strL;
        jsonReader.c();
        byte b11 = 2;
        int iJ = 2;
        while (true) {
            cVarA = null;
            if (!jsonReader.g()) {
                strL = null;
                break;
            }
            int iP = jsonReader.p(f64666a);
            if (iP == 0) {
                strL = jsonReader.l();
                break;
            }
            if (iP != 1) {
                jsonReader.q();
                jsonReader.r();
            } else {
                iJ = jsonReader.j();
            }
        }
        if (strL == null) {
            return null;
        }
        switch (strL.hashCode()) {
            case 3239:
                if (!strL.equals("el")) {
                    b11 = -1;
                } else {
                    b11 = 0;
                }
                break;
            case 3270:
                if (!strL.equals("fl")) {
                    b11 = -1;
                } else {
                    b11 = 1;
                }
                break;
            case 3295:
                if (!strL.equals("gf")) {
                    b11 = -1;
                }
                break;
            case 3307:
                if (!strL.equals("gr")) {
                    b11 = -1;
                } else {
                    b11 = 3;
                }
                break;
            case 3308:
                if (!strL.equals("gs")) {
                    b11 = -1;
                } else {
                    b11 = 4;
                }
                break;
            case 3488:
                if (!strL.equals("mm")) {
                    b11 = -1;
                } else {
                    b11 = 5;
                }
                break;
            case 3633:
                if (!strL.equals(DownloadCommon.DOWNLOAD_REPORT_RETRY_COUNT)) {
                    b11 = -1;
                } else {
                    b11 = 6;
                }
                break;
            case 3634:
                if (!strL.equals("rd")) {
                    b11 = -1;
                } else {
                    b11 = 7;
                }
                break;
            case 3646:
                if (!strL.equals("rp")) {
                    b11 = -1;
                } else {
                    b11 = 8;
                }
                break;
            case 3669:
                if (!strL.equals(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SH)) {
                    b11 = -1;
                } else {
                    b11 = 9;
                }
                break;
            case 3679:
                if (!strL.equals("sr")) {
                    b11 = -1;
                } else {
                    b11 = 10;
                }
                break;
            case 3681:
                if (!strL.equals("st")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.VT;
                }
                break;
            case 3705:
                if (!strL.equals("tm")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.FF;
                }
                break;
            case 3710:
                if (!strL.equals("tr")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.CR;
                }
                break;
            default:
                b11 = -1;
                break;
        }
        switch (b11) {
            case 0:
                cVarA = f.a(jsonReader, hVar, iJ);
                break;
            case 1:
                cVarA = i0.a(jsonReader, hVar);
                break;
            case 2:
                cVarA = p.a(jsonReader, hVar);
                break;
            case 3:
                cVarA = j0.a(jsonReader, hVar);
                break;
            case 4:
                cVarA = q.a(jsonReader, hVar);
                break;
            case 5:
                cVarA = y.a(jsonReader);
                hVar.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                cVarA = d0.a(jsonReader, hVar);
                break;
            case 7:
                cVarA = f0.a(jsonReader, hVar);
                break;
            case 8:
                cVarA = e0.a(jsonReader, hVar);
                break;
            case 9:
                cVarA = k0.a(jsonReader, hVar);
                break;
            case 10:
                cVarA = c0.a(jsonReader, hVar, iJ);
                break;
            case 11:
                cVarA = l0.a(jsonReader, hVar);
                break;
            case 12:
                cVarA = m0.a(jsonReader, hVar);
                break;
            case 13:
                cVarA = c.g(jsonReader, hVar);
                break;
            default:
                g7.f.c("Unknown shape type " + strL);
                break;
        }
        while (jsonReader.g()) {
            jsonReader.r();
        }
        jsonReader.e();
        return cVarA;
    }
}
