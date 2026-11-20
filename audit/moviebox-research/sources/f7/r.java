package f7;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class r implements n0<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f64699a = new r();

    @Override // f7.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(JsonReader jsonReader, float f11) throws IOException {
        return Integer.valueOf(Math.round(s.g(jsonReader) * f11));
    }
}
