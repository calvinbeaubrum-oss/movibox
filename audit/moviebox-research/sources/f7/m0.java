package f7;

import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f64691a = JsonReader.a.a("s", "e", "o", "nm", "m", "hd");

    public static ShapeTrimPath a(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        String strL = null;
        ShapeTrimPath.Type typeForId = null;
        b7.b bVarF = null;
        b7.b bVarF2 = null;
        b7.b bVarF3 = null;
        boolean zH = false;
        while (jsonReader.g()) {
            int iP = jsonReader.p(f64691a);
            if (iP == 0) {
                bVarF = d.f(jsonReader, hVar, false);
            } else if (iP == 1) {
                bVarF2 = d.f(jsonReader, hVar, false);
            } else if (iP == 2) {
                bVarF3 = d.f(jsonReader, hVar, false);
            } else if (iP == 3) {
                strL = jsonReader.l();
            } else if (iP == 4) {
                typeForId = ShapeTrimPath.Type.forId(jsonReader.j());
            } else if (iP != 5) {
                jsonReader.r();
            } else {
                zH = jsonReader.h();
            }
        }
        return new ShapeTrimPath(strL, typeForId, bVarF, bVarF2, bVarF3, zH);
    }
}
