package f7;

import androidx.annotation.Nullable;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f64659a = JsonReader.a.a("ef");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f64660b = JsonReader.a.a("ty", "v");

    @Nullable
    public static c7.a a(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        jsonReader.c();
        c7.a aVar = null;
        while (true) {
            boolean z11 = false;
            while (true) {
                if (!jsonReader.g()) {
                    jsonReader.e();
                    return aVar;
                }
                int iP = jsonReader.p(f64660b);
                if (iP != 0) {
                    if (iP != 1) {
                        jsonReader.q();
                        jsonReader.r();
                    } else if (z11) {
                        aVar = new c7.a(d.e(jsonReader, hVar));
                    } else {
                        jsonReader.r();
                    }
                } else if (jsonReader.j() == 0) {
                    z11 = true;
                }
            }
        }
    }

    @Nullable
    public static c7.a b(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        c7.a aVar = null;
        while (jsonReader.g()) {
            if (jsonReader.p(f64659a) != 0) {
                jsonReader.q();
                jsonReader.r();
            } else {
                jsonReader.b();
                while (jsonReader.g()) {
                    c7.a aVarA = a(jsonReader, hVar);
                    if (aVarA != null) {
                        aVar = aVarA;
                    }
                }
                jsonReader.d();
            }
        }
        return aVar;
    }
}
