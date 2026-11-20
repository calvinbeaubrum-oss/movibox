package f7;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class h0 implements n0<c7.i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f64667a = new h0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f64668b = JsonReader.a.a("c", "v", "i", "o");

    @Override // f7.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c7.i a(JsonReader jsonReader, float f11) throws IOException {
        if (jsonReader.n() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.b();
        }
        jsonReader.c();
        List<PointF> listF = null;
        List<PointF> listF2 = null;
        List<PointF> listF3 = null;
        boolean zH = false;
        while (jsonReader.g()) {
            int iP = jsonReader.p(f64668b);
            if (iP == 0) {
                zH = jsonReader.h();
            } else if (iP == 1) {
                listF = s.f(jsonReader, f11);
            } else if (iP == 2) {
                listF2 = s.f(jsonReader, f11);
            } else if (iP != 3) {
                jsonReader.q();
                jsonReader.r();
            } else {
                listF3 = s.f(jsonReader, f11);
            }
        }
        jsonReader.e();
        if (jsonReader.n() == JsonReader.Token.END_ARRAY) {
            jsonReader.d();
        }
        if (listF == null || listF2 == null || listF3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (listF.isEmpty()) {
            return new c7.i(new PointF(), false, Collections.emptyList());
        }
        int size = listF.size();
        PointF pointF = listF.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i11 = 1; i11 < size; i11++) {
            PointF pointF2 = listF.get(i11);
            int i12 = i11 - 1;
            arrayList.add(new a7.a(g7.k.a(listF.get(i12), listF3.get(i12)), g7.k.a(pointF2, listF2.get(i11)), pointF2));
        }
        if (zH) {
            PointF pointF3 = listF.get(0);
            int i13 = size - 1;
            arrayList.add(new a7.a(g7.k.a(listF.get(i13), listF3.get(i13)), g7.k.a(pointF3, listF2.get(0)), pointF3));
        }
        return new c7.i(pointF, zH, arrayList);
    }
}
