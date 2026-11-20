package f7;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b0 implements n0<PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f64654a = new b0();

    @Override // f7.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointF a(JsonReader jsonReader, float f11) throws IOException {
        JsonReader.Token tokenN = jsonReader.n();
        if (tokenN != JsonReader.Token.BEGIN_ARRAY && tokenN != JsonReader.Token.BEGIN_OBJECT) {
            if (tokenN == JsonReader.Token.NUMBER) {
                PointF pointF = new PointF(((float) jsonReader.i()) * f11, ((float) jsonReader.i()) * f11);
                while (jsonReader.g()) {
                    jsonReader.r();
                }
                return pointF;
            }
            throw new IllegalArgumentException("Cannot convert json to point. Next token is " + tokenN);
        }
        return s.e(jsonReader, f11);
    }
}
