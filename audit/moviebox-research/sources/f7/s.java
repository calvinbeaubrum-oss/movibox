package f7;

import android.graphics.Color;
import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f64700a = JsonReader.a.a("x", "y");

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f64701a;

        static {
            int[] iArr = new int[JsonReader.Token.values().length];
            f64701a = iArr;
            try {
                iArr[JsonReader.Token.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f64701a[JsonReader.Token.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f64701a[JsonReader.Token.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static PointF a(JsonReader jsonReader, float f11) throws IOException {
        jsonReader.b();
        float fI = (float) jsonReader.i();
        float fI2 = (float) jsonReader.i();
        while (jsonReader.n() != JsonReader.Token.END_ARRAY) {
            jsonReader.r();
        }
        jsonReader.d();
        return new PointF(fI * f11, fI2 * f11);
    }

    public static PointF b(JsonReader jsonReader, float f11) throws IOException {
        float fI = (float) jsonReader.i();
        float fI2 = (float) jsonReader.i();
        while (jsonReader.g()) {
            jsonReader.r();
        }
        return new PointF(fI * f11, fI2 * f11);
    }

    public static PointF c(JsonReader jsonReader, float f11) throws IOException {
        jsonReader.c();
        float fG = 0.0f;
        float fG2 = 0.0f;
        while (jsonReader.g()) {
            int iP = jsonReader.p(f64700a);
            if (iP == 0) {
                fG = g(jsonReader);
            } else if (iP != 1) {
                jsonReader.q();
                jsonReader.r();
            } else {
                fG2 = g(jsonReader);
            }
        }
        jsonReader.e();
        return new PointF(fG * f11, fG2 * f11);
    }

    public static int d(JsonReader jsonReader) throws IOException {
        jsonReader.b();
        int i11 = (int) (jsonReader.i() * 255.0d);
        int i12 = (int) (jsonReader.i() * 255.0d);
        int i13 = (int) (jsonReader.i() * 255.0d);
        while (jsonReader.g()) {
            jsonReader.r();
        }
        jsonReader.d();
        return Color.argb(255, i11, i12, i13);
    }

    public static PointF e(JsonReader jsonReader, float f11) throws IOException {
        int i11 = a.f64701a[jsonReader.n().ordinal()];
        if (i11 == 1) {
            return b(jsonReader, f11);
        }
        if (i11 == 2) {
            return a(jsonReader, f11);
        }
        if (i11 == 3) {
            return c(jsonReader, f11);
        }
        throw new IllegalArgumentException("Unknown point starts with " + jsonReader.n());
    }

    public static List<PointF> f(JsonReader jsonReader, float f11) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.b();
        while (jsonReader.n() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.b();
            arrayList.add(e(jsonReader, f11));
            jsonReader.d();
        }
        jsonReader.d();
        return arrayList;
    }

    public static float g(JsonReader jsonReader) throws IOException {
        JsonReader.Token tokenN = jsonReader.n();
        int i11 = a.f64701a[tokenN.ordinal()];
        if (i11 == 1) {
            return (float) jsonReader.i();
        }
        if (i11 != 2) {
            throw new IllegalArgumentException("Unknown value for token of type " + tokenN);
        }
        jsonReader.b();
        float fI = (float) jsonReader.i();
        while (jsonReader.g()) {
            jsonReader.r();
        }
        jsonReader.d();
        return fI;
    }
}
