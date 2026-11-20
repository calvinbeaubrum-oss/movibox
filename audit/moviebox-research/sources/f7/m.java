package f7;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f64689a = JsonReader.a.a("ch", "size", "w", TtmlNode.TAG_STYLE, "fFamily", "data");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f64690b = JsonReader.a.a("shapes");

    public static a7.c a(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.c();
        double dI = 0.0d;
        String strL = null;
        String strL2 = null;
        double dI2 = 0.0d;
        char cCharAt = 0;
        while (jsonReader.g()) {
            int iP = jsonReader.p(f64689a);
            if (iP == 0) {
                cCharAt = jsonReader.l().charAt(0);
            } else if (iP == 1) {
                dI2 = jsonReader.i();
            } else if (iP == 2) {
                dI = jsonReader.i();
            } else if (iP == 3) {
                strL = jsonReader.l();
            } else if (iP == 4) {
                strL2 = jsonReader.l();
            } else if (iP != 5) {
                jsonReader.q();
                jsonReader.r();
            } else {
                jsonReader.c();
                while (jsonReader.g()) {
                    if (jsonReader.p(f64690b) != 0) {
                        jsonReader.q();
                        jsonReader.r();
                    } else {
                        jsonReader.b();
                        while (jsonReader.g()) {
                            arrayList.add((c7.k) h.a(jsonReader, hVar));
                        }
                        jsonReader.d();
                    }
                }
                jsonReader.e();
            }
        }
        jsonReader.e();
        return new a7.c(arrayList, cCharAt, dI2, dI, strL, strL2);
    }
}
