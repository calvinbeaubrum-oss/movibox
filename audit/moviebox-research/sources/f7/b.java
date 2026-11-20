package f7;

import com.airbnb.lottie.model.content.TextRangeUnits;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f64651a = JsonReader.a.a("s", "a");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f64652b = JsonReader.a.a("s", "e", "o", CampaignEx.JSON_KEY_AD_R);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final JsonReader.a f64653c = JsonReader.a.a("fc", "sc", "sw", "t", "o");

    public static b7.k a(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        jsonReader.c();
        b7.m mVarC = null;
        b7.l lVarB = null;
        while (jsonReader.g()) {
            int iP = jsonReader.p(f64651a);
            if (iP == 0) {
                lVarB = b(jsonReader, hVar);
            } else if (iP != 1) {
                jsonReader.q();
                jsonReader.r();
            } else {
                mVarC = c(jsonReader, hVar);
            }
        }
        jsonReader.e();
        return new b7.k(mVarC, lVarB);
    }

    public static b7.l b(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        jsonReader.c();
        b7.d dVar = null;
        b7.d dVarH = null;
        b7.d dVarH2 = null;
        TextRangeUnits textRangeUnits = null;
        while (jsonReader.g()) {
            int iP = jsonReader.p(f64652b);
            if (iP == 0) {
                dVar = d.h(jsonReader, hVar);
            } else if (iP == 1) {
                dVarH = d.h(jsonReader, hVar);
            } else if (iP == 2) {
                dVarH2 = d.h(jsonReader, hVar);
            } else if (iP != 3) {
                jsonReader.q();
                jsonReader.r();
            } else {
                int iJ = jsonReader.j();
                if (iJ == 1 || iJ == 2) {
                    textRangeUnits = iJ == 1 ? TextRangeUnits.PERCENT : TextRangeUnits.INDEX;
                } else {
                    hVar.a("Unsupported text range units: " + iJ);
                    textRangeUnits = TextRangeUnits.INDEX;
                }
            }
        }
        jsonReader.e();
        if (dVar == null && dVarH != null) {
            dVar = new b7.d(Collections.singletonList(new h7.a(0)));
        }
        return new b7.l(dVar, dVarH, dVarH2, textRangeUnits);
    }

    public static b7.m c(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        jsonReader.c();
        b7.a aVarC = null;
        b7.a aVarC2 = null;
        b7.b bVarE = null;
        b7.b bVarE2 = null;
        b7.d dVarH = null;
        while (jsonReader.g()) {
            int iP = jsonReader.p(f64653c);
            if (iP == 0) {
                aVarC = d.c(jsonReader, hVar);
            } else if (iP == 1) {
                aVarC2 = d.c(jsonReader, hVar);
            } else if (iP == 2) {
                bVarE = d.e(jsonReader, hVar);
            } else if (iP == 3) {
                bVarE2 = d.e(jsonReader, hVar);
            } else if (iP != 4) {
                jsonReader.q();
                jsonReader.r();
            } else {
                dVarH = d.h(jsonReader, hVar);
            }
        }
        jsonReader.e();
        return new b7.m(aVarC, aVarC2, bVarE, bVarE2, dVarH);
    }
}
