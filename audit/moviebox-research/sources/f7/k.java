package f7;

import androidx.annotation.Nullable;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final JsonReader.a f64678f = JsonReader.a.a("ef");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final JsonReader.a f64679g = JsonReader.a.a("nm", "v");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b7.a f64680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b7.b f64681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b7.b f64682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b7.b f64683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b7.b f64684e;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:12:0x0029  */
    public final void a(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        jsonReader.c();
        String strL = "";
        while (jsonReader.g()) {
            int iP = jsonReader.p(f64679g);
            if (iP != 0) {
                if (iP == 1) {
                    strL.hashCode();
                    switch (strL) {
                        case "Distance":
                            this.f64683d = d.e(jsonReader, hVar);
                            break;
                        case "Opacity":
                            this.f64681b = d.f(jsonReader, hVar, false);
                            break;
                        case "Direction":
                            this.f64682c = d.f(jsonReader, hVar, false);
                            break;
                        case "Shadow Color":
                            this.f64680a = d.c(jsonReader, hVar);
                            break;
                        case "Softness":
                            this.f64684e = d.e(jsonReader, hVar);
                            break;
                        default:
                            jsonReader.r();
                            break;
                    }
                } else {
                    jsonReader.q();
                    jsonReader.r();
                }
            } else {
                strL = jsonReader.l();
            }
        }
        jsonReader.e();
    }

    @Nullable
    public j b(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        b7.b bVar;
        b7.b bVar2;
        b7.b bVar3;
        b7.b bVar4;
        while (jsonReader.g()) {
            if (jsonReader.p(f64678f) != 0) {
                jsonReader.q();
                jsonReader.r();
            } else {
                jsonReader.b();
                while (jsonReader.g()) {
                    a(jsonReader, hVar);
                }
                jsonReader.d();
            }
        }
        b7.a aVar = this.f64680a;
        if (aVar == null || (bVar = this.f64681b) == null || (bVar2 = this.f64682c) == null || (bVar3 = this.f64683d) == null || (bVar4 = this.f64684e) == null) {
            return null;
        }
        return new j(aVar, bVar, bVar2, bVar3, bVar4);
    }
}
