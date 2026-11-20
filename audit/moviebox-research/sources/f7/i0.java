package f7;

import android.graphics.Path;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f64671a = JsonReader.a.a("nm", "c", "o", "fillEnabled", CampaignEx.JSON_KEY_AD_R, "hd");

    public static c7.j a(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        b7.d dVar = null;
        String strL = null;
        b7.a aVarC = null;
        int iJ = 1;
        boolean zH = false;
        boolean zH2 = false;
        while (jsonReader.g()) {
            int iP = jsonReader.p(f64671a);
            if (iP == 0) {
                strL = jsonReader.l();
            } else if (iP == 1) {
                aVarC = d.c(jsonReader, hVar);
            } else if (iP == 2) {
                dVar = d.h(jsonReader, hVar);
            } else if (iP == 3) {
                zH = jsonReader.h();
            } else if (iP == 4) {
                iJ = jsonReader.j();
            } else if (iP != 5) {
                jsonReader.q();
                jsonReader.r();
            } else {
                zH2 = jsonReader.h();
            }
        }
        if (dVar == null) {
            dVar = new b7.d(Collections.singletonList(new h7.a(100)));
        }
        return new c7.j(strL, zH, iJ == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVarC, dVar, zH2);
    }
}
