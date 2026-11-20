package f7;

import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f64715a = JsonReader.a.a("nm", "mm", "hd");

    public static MergePaths a(JsonReader jsonReader) throws IOException {
        String strL = null;
        MergePaths.MergePathsMode mergePathsModeForId = null;
        boolean zH = false;
        while (jsonReader.g()) {
            int iP = jsonReader.p(f64715a);
            if (iP == 0) {
                strL = jsonReader.l();
            } else if (iP == 1) {
                mergePathsModeForId = MergePaths.MergePathsMode.forId(jsonReader.j());
            } else if (iP != 2) {
                jsonReader.q();
                jsonReader.r();
            } else {
                zH = jsonReader.h();
            }
        }
        return new MergePaths(strL, mergePathsModeForId, zH);
    }
}
