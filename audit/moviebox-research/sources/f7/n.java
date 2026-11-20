package f7;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f64692a = JsonReader.a.a("fFamily", "fName", "fStyle", "ascent");

    public static a7.b a(JsonReader jsonReader) throws IOException {
        jsonReader.c();
        String strL = null;
        String strL2 = null;
        String strL3 = null;
        float fI = 0.0f;
        while (jsonReader.g()) {
            int iP = jsonReader.p(f64692a);
            if (iP == 0) {
                strL = jsonReader.l();
            } else if (iP == 1) {
                strL2 = jsonReader.l();
            } else if (iP == 2) {
                strL3 = jsonReader.l();
            } else if (iP != 3) {
                jsonReader.q();
                jsonReader.r();
            } else {
                fI = (float) jsonReader.i();
            }
        }
        jsonReader.e();
        return new a7.b(strL, strL2, strL3, fI);
    }
}
