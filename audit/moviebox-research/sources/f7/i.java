package f7;

import android.graphics.PointF;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class i implements n0<DocumentData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f64669a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f64670b = JsonReader.a.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of", "ps", "sz");

    @Override // f7.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public DocumentData a(JsonReader jsonReader, float f11) throws IOException {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.c();
        DocumentData.Justification justification2 = justification;
        String strL = null;
        String strL2 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        float fI = 0.0f;
        int iJ = 0;
        float fI2 = 0.0f;
        float fI3 = 0.0f;
        int iD = 0;
        int iD2 = 0;
        float fI4 = 0.0f;
        boolean zH = true;
        while (jsonReader.g()) {
            switch (jsonReader.p(f64670b)) {
                case 0:
                    strL = jsonReader.l();
                    break;
                case 1:
                    strL2 = jsonReader.l();
                    break;
                case 2:
                    fI = (float) jsonReader.i();
                    break;
                case 3:
                    int iJ2 = jsonReader.j();
                    justification2 = DocumentData.Justification.CENTER;
                    if (iJ2 <= justification2.ordinal() && iJ2 >= 0) {
                        justification2 = DocumentData.Justification.values()[iJ2];
                    }
                    break;
                case 4:
                    iJ = jsonReader.j();
                    break;
                case 5:
                    fI2 = (float) jsonReader.i();
                    break;
                case 6:
                    fI3 = (float) jsonReader.i();
                    break;
                case 7:
                    iD = s.d(jsonReader);
                    break;
                case 8:
                    iD2 = s.d(jsonReader);
                    break;
                case 9:
                    fI4 = (float) jsonReader.i();
                    break;
                case 10:
                    zH = jsonReader.h();
                    break;
                case 11:
                    jsonReader.b();
                    PointF pointF3 = new PointF(((float) jsonReader.i()) * f11, ((float) jsonReader.i()) * f11);
                    jsonReader.d();
                    pointF = pointF3;
                    break;
                case 12:
                    jsonReader.b();
                    PointF pointF4 = new PointF(((float) jsonReader.i()) * f11, ((float) jsonReader.i()) * f11);
                    jsonReader.d();
                    pointF2 = pointF4;
                    break;
                default:
                    jsonReader.q();
                    jsonReader.r();
                    break;
            }
        }
        jsonReader.e();
        return new DocumentData(strL, strL2, fI, justification2, iJ, fI2, fI3, iD, iD2, fI4, zH, pointF, pointF2);
    }
}
