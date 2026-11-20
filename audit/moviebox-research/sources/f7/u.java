package f7;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JsonReader.a f64706a = JsonReader.a.a(CampaignEx.JSON_KEY_AD_K);

    public static <T> List<h7.a<T>> a(JsonReader jsonReader, com.airbnb.lottie.h hVar, float f11, n0<T> n0Var, boolean z11) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.n() == JsonReader.Token.STRING) {
            hVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.c();
        while (jsonReader.g()) {
            if (jsonReader.p(f64706a) != 0) {
                jsonReader.r();
            } else if (jsonReader.n() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.b();
                if (jsonReader.n() == JsonReader.Token.NUMBER) {
                    arrayList.add(t.c(jsonReader, hVar, f11, n0Var, false, z11));
                } else {
                    while (jsonReader.g()) {
                        arrayList.add(t.c(jsonReader, hVar, f11, n0Var, true, z11));
                    }
                }
                jsonReader.d();
            } else {
                arrayList.add(t.c(jsonReader, hVar, f11, n0Var, false, z11));
            }
        }
        jsonReader.e();
        b(arrayList);
        return arrayList;
    }

    public static <T> void b(List<? extends h7.a<T>> list) {
        int i11;
        T t11;
        int size = list.size();
        int i12 = 0;
        while (true) {
            i11 = size - 1;
            if (i12 >= i11) {
                break;
            }
            h7.a<T> aVar = list.get(i12);
            i12++;
            h7.a<T> aVar2 = list.get(i12);
            aVar.f66356h = Float.valueOf(aVar2.f66355g);
            if (aVar.f66351c == null && (t11 = aVar2.f66350b) != null) {
                aVar.f66351c = t11;
                if (aVar instanceof y6.i) {
                    ((y6.i) aVar).j();
                }
            }
        }
        h7.a<T> aVar3 = list.get(i11);
        if ((aVar3.f66350b == null || aVar3.f66351c == null) && list.size() > 1) {
            list.remove(aVar3);
        }
    }
}
