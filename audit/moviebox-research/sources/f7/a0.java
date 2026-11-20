package f7;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a0 implements n0<PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a0 f64650a = new a0();

    @Override // f7.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointF a(JsonReader jsonReader, float f11) throws IOException {
        return s.e(jsonReader, f11);
    }
}
