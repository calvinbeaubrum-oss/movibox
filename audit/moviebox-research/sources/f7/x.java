package f7;

import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class x {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:28:0x0062  */
    /* JADX WARN: Code duplicated, block: B:7:0x0020  */
    public static Mask a(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        jsonReader.c();
        Mask.MaskMode maskMode = null;
        b7.h hVarK = null;
        b7.d dVarH = null;
        boolean zH = false;
        while (jsonReader.g()) {
            String strK = jsonReader.k();
            strK.hashCode();
            switch (strK) {
                case "o":
                    dVarH = d.h(jsonReader, hVar);
                    break;
                case "pt":
                    hVarK = d.k(jsonReader, hVar);
                    break;
                case "inv":
                    zH = jsonReader.h();
                    break;
                case "mode":
                    String strL = jsonReader.l();
                    strL.hashCode();
                    switch (strL) {
                        case "a":
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            break;
                        case "i":
                            hVar.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            maskMode = Mask.MaskMode.MASK_MODE_INTERSECT;
                            break;
                        case "n":
                            maskMode = Mask.MaskMode.MASK_MODE_NONE;
                            break;
                        case "s":
                            maskMode = Mask.MaskMode.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            g7.f.c("Unknown mask mode " + strK + ". Defaulting to Add.");
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            break;
                    }
                    break;
                default:
                    jsonReader.r();
                    break;
            }
        }
        jsonReader.e();
        return new Mask(maskMode, hVarK, dVarH, zH);
    }
}
