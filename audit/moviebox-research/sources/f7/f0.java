package f7;

import androidx.annotation.Nullable;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f64663a = JsonReader.a.a("nm", CampaignEx.JSON_KEY_AD_R, "hd");

    @Nullable
    public static c7.h a(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        boolean zH = false;
        String strL = null;
        b7.b bVarF = null;
        while (jsonReader.g()) {
            int iP = jsonReader.p(f64663a);
            if (iP == 0) {
                strL = jsonReader.l();
            } else if (iP == 1) {
                bVarF = d.f(jsonReader, hVar, true);
            } else if (iP != 2) {
                jsonReader.r();
            } else {
                zH = jsonReader.h();
            }
        }
        if (zH) {
            return null;
        }
        return new c7.h(strL, bVarF);
    }
}
