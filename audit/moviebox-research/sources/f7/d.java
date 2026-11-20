package f7;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static <T> List<h7.a<T>> a(JsonReader jsonReader, float f11, com.airbnb.lottie.h hVar, n0<T> n0Var) throws IOException {
        return u.a(jsonReader, hVar, f11, n0Var, false);
    }

    public static <T> List<h7.a<T>> b(JsonReader jsonReader, com.airbnb.lottie.h hVar, n0<T> n0Var) throws IOException {
        return u.a(jsonReader, hVar, 1.0f, n0Var, false);
    }

    public static b7.a c(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        return new b7.a(b(jsonReader, hVar, g.f64664a));
    }

    public static b7.j d(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        return new b7.j(a(jsonReader, g7.l.e(), hVar, i.f64669a));
    }

    public static b7.b e(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        return f(jsonReader, hVar, true);
    }

    public static b7.b f(JsonReader jsonReader, com.airbnb.lottie.h hVar, boolean z11) throws IOException {
        return new b7.b(a(jsonReader, z11 ? g7.l.e() : 1.0f, hVar, l.f64686a));
    }

    public static b7.c g(JsonReader jsonReader, com.airbnb.lottie.h hVar, int i11) throws IOException {
        return new b7.c(b(jsonReader, hVar, new o(i11)));
    }

    public static b7.d h(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        return new b7.d(b(jsonReader, hVar, r.f64699a));
    }

    public static b7.f i(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        return new b7.f(u.a(jsonReader, hVar, g7.l.e(), b0.f64654a, true));
    }

    public static b7.g j(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        return new b7.g(b(jsonReader, hVar, g0.f64665a));
    }

    public static b7.h k(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        return new b7.h(a(jsonReader, g7.l.e(), hVar, h0.f64667a));
    }
}
