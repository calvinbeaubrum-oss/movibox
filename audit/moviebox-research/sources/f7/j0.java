package f7;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f64677a = JsonReader.a.a("nm", "hd", "it");

    public static c7.k a(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strL = null;
        boolean zH = false;
        while (jsonReader.g()) {
            int iP = jsonReader.p(f64677a);
            if (iP == 0) {
                strL = jsonReader.l();
            } else if (iP == 1) {
                zH = jsonReader.h();
            } else if (iP != 2) {
                jsonReader.r();
            } else {
                jsonReader.b();
                while (jsonReader.g()) {
                    c7.c cVarA = h.a(jsonReader, hVar);
                    if (cVarA != null) {
                        arrayList.add(cVarA);
                    }
                }
                jsonReader.d();
            }
        }
        return new c7.k(strL, arrayList, zH);
    }
}
