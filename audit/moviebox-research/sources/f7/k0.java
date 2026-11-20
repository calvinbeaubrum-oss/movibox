package f7;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JsonReader.a f64685a = JsonReader.a.a("nm", "ind", "ks", "hd");

    public static c7.l a(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        String strL = null;
        b7.h hVarK = null;
        int iJ = 0;
        boolean zH = false;
        while (jsonReader.g()) {
            int iP = jsonReader.p(f64685a);
            if (iP == 0) {
                strL = jsonReader.l();
            } else if (iP == 1) {
                iJ = jsonReader.j();
            } else if (iP == 2) {
                hVarK = d.k(jsonReader, hVar);
            } else if (iP != 3) {
                jsonReader.r();
            } else {
                zH = jsonReader.h();
            }
        }
        return new c7.l(strL, iJ, hVarK, zH);
    }
}
