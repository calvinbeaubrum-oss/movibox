package f7;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g0 implements n0<h7.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g0 f64665a = new g0();

    @Override // f7.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public h7.d a(JsonReader jsonReader, float f11) throws IOException {
        boolean z11 = jsonReader.n() == JsonReader.Token.BEGIN_ARRAY;
        if (z11) {
            jsonReader.b();
        }
        float fI = (float) jsonReader.i();
        float fI2 = (float) jsonReader.i();
        while (jsonReader.g()) {
            jsonReader.r();
        }
        if (z11) {
            jsonReader.d();
        }
        return new h7.d((fI / 100.0f) * f11, (fI2 / 100.0f) * f11);
    }
}
