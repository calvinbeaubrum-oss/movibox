package f7;

import android.graphics.Color;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g implements n0<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f64664a = new g();

    @Override // f7.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(JsonReader jsonReader, float f11) throws IOException {
        boolean z11 = jsonReader.n() == JsonReader.Token.BEGIN_ARRAY;
        if (z11) {
            jsonReader.b();
        }
        double dI = jsonReader.i();
        double dI2 = jsonReader.i();
        double dI3 = jsonReader.i();
        double dI4 = jsonReader.n() == JsonReader.Token.NUMBER ? jsonReader.i() : 1.0d;
        if (z11) {
            jsonReader.d();
        }
        if (dI <= 1.0d && dI2 <= 1.0d && dI3 <= 1.0d) {
            dI *= 255.0d;
            dI2 *= 255.0d;
            dI3 *= 255.0d;
            if (dI4 <= 1.0d) {
                dI4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) dI4, (int) dI, (int) dI2, (int) dI3));
    }
}
