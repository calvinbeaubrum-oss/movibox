package f7;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f64661a = JsonReader.a.a("nm", "c", "o", "tr", "hd");

    public static c7.g a(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        String strL = null;
        b7.b bVarF = null;
        b7.b bVarF2 = null;
        b7.n nVarG = null;
        boolean zH = false;
        while (jsonReader.g()) {
            int iP = jsonReader.p(f64661a);
            if (iP == 0) {
                strL = jsonReader.l();
            } else if (iP == 1) {
                bVarF = d.f(jsonReader, hVar, false);
            } else if (iP == 2) {
                bVarF2 = d.f(jsonReader, hVar, false);
            } else if (iP == 3) {
                nVarG = c.g(jsonReader, hVar);
            } else if (iP != 4) {
                jsonReader.r();
            } else {
                zH = jsonReader.h();
            }
        }
        return new c7.g(strL, bVarF, bVarF2, nVarG, zH);
    }
}
