package f7;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class l implements n0<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f64686a = new l();

    @Override // f7.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Float a(JsonReader jsonReader, float f11) throws IOException {
        return Float.valueOf(s.g(jsonReader) * f11);
    }
}
