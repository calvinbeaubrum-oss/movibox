package lk;

import android.util.Base64;
import android.util.JsonReader;
import androidx.annotation.NonNull;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final uk.a f70304a = new wk.d().j(com.google.firebase.crashlytics.internal.model.a.f40241a).k(true).i();

    /* JADX INFO: compiled from: source.java */
    public interface a<T> {
        T a(@NonNull JsonReader jsonReader) throws IOException;
    }

    @NonNull
    public static CrashlyticsReport A(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.b bVarB = CrashlyticsReport.b();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "ndkPayload":
                    bVarB.f(y(jsonReader));
                    break;
                case "sdkVersion":
                    bVarB.h(jsonReader.nextString());
                    break;
                case "buildVersion":
                    bVarB.b(jsonReader.nextString());
                    break;
                case "gmpAppId":
                    bVarB.d(jsonReader.nextString());
                    break;
                case "installationUuid":
                    bVarB.e(jsonReader.nextString());
                    break;
                case "platform":
                    bVarB.g(jsonReader.nextInt());
                    break;
                case "displayVersion":
                    bVarB.c(jsonReader.nextString());
                    break;
                case "session":
                    bVarB.i(B(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return bVarB.a();
    }

    @NonNull
    public static CrashlyticsReport.e B(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.e.b bVarA = CrashlyticsReport.e.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "startedAt":
                    bVarA.l(jsonReader.nextLong());
                    break;
                case "identifier":
                    bVarA.j(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case "endedAt":
                    bVarA.e(Long.valueOf(jsonReader.nextLong()));
                    break;
                case "device":
                    bVarA.d(m(jsonReader));
                    break;
                case "events":
                    bVarA.f(k(jsonReader, new a() { // from class: lk.a
                        @Override // lk.g.a
                        public final Object a(JsonReader jsonReader2) {
                            return g.n(jsonReader2);
                        }
                    }));
                    break;
                case "os":
                    bVarA.k(z(jsonReader));
                    break;
                case "app":
                    bVarA.b(i(jsonReader));
                    break;
                case "user":
                    bVarA.m(C(jsonReader));
                    break;
                case "generator":
                    bVarA.g(jsonReader.nextString());
                    break;
                case "crashed":
                    bVarA.c(jsonReader.nextBoolean());
                    break;
                case "generatorType":
                    bVarA.h(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return bVarA.a();
    }

    @NonNull
    public static CrashlyticsReport.e.f C(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.e.f.a aVarA = CrashlyticsReport.e.f.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("identifier")) {
                aVarA.b(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    @NonNull
    public static CrashlyticsReport.e.a i(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.e.a.AbstractC0426a abstractC0426aA = CrashlyticsReport.e.a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "identifier":
                    abstractC0426aA.e(jsonReader.nextString());
                    break;
                case "developmentPlatform":
                    abstractC0426aA.b(jsonReader.nextString());
                    break;
                case "developmentPlatformVersion":
                    abstractC0426aA.c(jsonReader.nextString());
                    break;
                case "version":
                    abstractC0426aA.g(jsonReader.nextString());
                    break;
                case "installationUuid":
                    abstractC0426aA.f(jsonReader.nextString());
                    break;
                case "displayVersion":
                    abstractC0426aA.d(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0426aA.a();
    }

    @NonNull
    public static CrashlyticsReport.a j(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.a.AbstractC0425a abstractC0425aA = CrashlyticsReport.a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "pid":
                    abstractC0425aA.c(jsonReader.nextInt());
                    break;
                case "pss":
                    abstractC0425aA.e(jsonReader.nextLong());
                    break;
                case "rss":
                    abstractC0425aA.g(jsonReader.nextLong());
                    break;
                case "timestamp":
                    abstractC0425aA.h(jsonReader.nextLong());
                    break;
                case "processName":
                    abstractC0425aA.d(jsonReader.nextString());
                    break;
                case "reasonCode":
                    abstractC0425aA.f(jsonReader.nextInt());
                    break;
                case "traceFile":
                    abstractC0425aA.i(jsonReader.nextString());
                    break;
                case "importance":
                    abstractC0425aA.b(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0425aA.a();
    }

    @NonNull
    public static <T> kk.e<T> k(@NonNull JsonReader jsonReader, @NonNull a<T> aVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(aVar.a(jsonReader));
        }
        jsonReader.endArray();
        return kk.e.a(arrayList);
    }

    @NonNull
    public static CrashlyticsReport.c l(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.c.a aVarA = CrashlyticsReport.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("key")) {
                aVarA.b(jsonReader.nextString());
            } else if (strNextName.equals(AppMeasurementSdk.ConditionalUserProperty.VALUE)) {
                aVarA.c(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    @NonNull
    public static CrashlyticsReport.e.c m(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.e.c.a aVarA = CrashlyticsReport.e.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "simulator":
                    aVarA.i(jsonReader.nextBoolean());
                    break;
                case "manufacturer":
                    aVarA.e(jsonReader.nextString());
                    break;
                case "ram":
                    aVarA.h(jsonReader.nextLong());
                    break;
                case "arch":
                    aVarA.b(jsonReader.nextInt());
                    break;
                case "diskSpace":
                    aVarA.d(jsonReader.nextLong());
                    break;
                case "cores":
                    aVarA.c(jsonReader.nextInt());
                    break;
                case "model":
                    aVarA.f(jsonReader.nextString());
                    break;
                case "state":
                    aVarA.j(jsonReader.nextInt());
                    break;
                case "modelClass":
                    aVarA.g(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    @NonNull
    public static CrashlyticsReport.e.d n(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.e.d.b bVarA = CrashlyticsReport.e.d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "device":
                    bVarA.c(q(jsonReader));
                    break;
                case "app":
                    bVarA.b(o(jsonReader));
                    break;
                case "log":
                    bVarA.d(u(jsonReader));
                    break;
                case "type":
                    bVarA.f(jsonReader.nextString());
                    break;
                case "timestamp":
                    bVarA.e(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return bVarA.a();
    }

    @NonNull
    public static CrashlyticsReport.e.d.a o(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.e.d.a.AbstractC0427a abstractC0427aA = CrashlyticsReport.e.d.a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "background":
                    abstractC0427aA.b(Boolean.valueOf(jsonReader.nextBoolean()));
                    break;
                case "execution":
                    abstractC0427aA.d(r(jsonReader));
                    break;
                case "internalKeys":
                    abstractC0427aA.e(k(jsonReader, new a() { // from class: lk.c
                        @Override // lk.g.a
                        public final Object a(JsonReader jsonReader2) {
                            return g.l(jsonReader2);
                        }
                    }));
                    break;
                case "customAttributes":
                    abstractC0427aA.c(k(jsonReader, new a() { // from class: lk.c
                        @Override // lk.g.a
                        public final Object a(JsonReader jsonReader2) {
                            return g.l(jsonReader2);
                        }
                    }));
                    break;
                case "uiOrientation":
                    abstractC0427aA.f(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0427aA.a();
    }

    @NonNull
    public static CrashlyticsReport.e.d.a.b.AbstractC0428a p(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.e.d.a.b.AbstractC0428a.AbstractC0429a abstractC0429aA = CrashlyticsReport.e.d.a.b.AbstractC0428a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "name":
                    abstractC0429aA.c(jsonReader.nextString());
                    break;
                case "size":
                    abstractC0429aA.d(jsonReader.nextLong());
                    break;
                case "uuid":
                    abstractC0429aA.f(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case "baseAddress":
                    abstractC0429aA.b(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0429aA.a();
    }

    @NonNull
    public static CrashlyticsReport.e.d.c q(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.e.d.c.a aVarA = CrashlyticsReport.e.d.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "batteryLevel":
                    aVarA.b(Double.valueOf(jsonReader.nextDouble()));
                    break;
                case "batteryVelocity":
                    aVarA.c(jsonReader.nextInt());
                    break;
                case "orientation":
                    aVarA.e(jsonReader.nextInt());
                    break;
                case "diskUsed":
                    aVarA.d(jsonReader.nextLong());
                    break;
                case "ramUsed":
                    aVarA.g(jsonReader.nextLong());
                    break;
                case "proximityOn":
                    aVarA.f(jsonReader.nextBoolean());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    @NonNull
    public static CrashlyticsReport.e.d.a.b r(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.e.d.a.b.AbstractC0430b abstractC0430bA = CrashlyticsReport.e.d.a.b.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "appExitInfo":
                    abstractC0430bA.b(j(jsonReader));
                    break;
                case "threads":
                    abstractC0430bA.f(k(jsonReader, new a() { // from class: lk.d
                        @Override // lk.g.a
                        public final Object a(JsonReader jsonReader2) {
                            return g.w(jsonReader2);
                        }
                    }));
                    break;
                case "signal":
                    abstractC0430bA.e(v(jsonReader));
                    break;
                case "binaries":
                    abstractC0430bA.c(k(jsonReader, new a() { // from class: lk.e
                        @Override // lk.g.a
                        public final Object a(JsonReader jsonReader2) {
                            return g.p(jsonReader2);
                        }
                    }));
                    break;
                case "exception":
                    abstractC0430bA.d(s(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0430bA.a();
    }

    @NonNull
    public static CrashlyticsReport.e.d.a.b.c s(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.e.d.a.b.c.AbstractC0431a abstractC0431aA = CrashlyticsReport.e.d.a.b.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "frames":
                    abstractC0431aA.c(k(jsonReader, new f()));
                    break;
                case "reason":
                    abstractC0431aA.e(jsonReader.nextString());
                    break;
                case "type":
                    abstractC0431aA.f(jsonReader.nextString());
                    break;
                case "causedBy":
                    abstractC0431aA.b(s(jsonReader));
                    break;
                case "overflowCount":
                    abstractC0431aA.d(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0431aA.a();
    }

    @NonNull
    public static CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b t(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b.AbstractC0437a abstractC0437aA = CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0436b.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "offset":
                    abstractC0437aA.d(jsonReader.nextLong());
                    break;
                case "symbol":
                    abstractC0437aA.f(jsonReader.nextString());
                    break;
                case "pc":
                    abstractC0437aA.e(jsonReader.nextLong());
                    break;
                case "file":
                    abstractC0437aA.b(jsonReader.nextString());
                    break;
                case "importance":
                    abstractC0437aA.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0437aA.a();
    }

    @NonNull
    public static CrashlyticsReport.e.d.AbstractC0438d u(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.e.d.AbstractC0438d.a aVarA = CrashlyticsReport.e.d.AbstractC0438d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals(AppLovinEventTypes.USER_VIEWED_CONTENT)) {
                aVarA.b(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    @NonNull
    public static CrashlyticsReport.e.d.a.b.AbstractC0432d v(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.e.d.a.b.AbstractC0432d.AbstractC0433a abstractC0433aA = CrashlyticsReport.e.d.a.b.AbstractC0432d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "address":
                    abstractC0433aA.b(jsonReader.nextLong());
                    break;
                case "code":
                    abstractC0433aA.c(jsonReader.nextString());
                    break;
                case "name":
                    abstractC0433aA.d(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0433aA.a();
    }

    @NonNull
    public static CrashlyticsReport.e.d.a.b.AbstractC0434e w(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.e.d.a.b.AbstractC0434e.AbstractC0435a abstractC0435aA = CrashlyticsReport.e.d.a.b.AbstractC0434e.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "frames":
                    abstractC0435aA.b(k(jsonReader, new f()));
                    break;
                case "name":
                    abstractC0435aA.d(jsonReader.nextString());
                    break;
                case "importance":
                    abstractC0435aA.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0435aA.a();
    }

    @NonNull
    public static CrashlyticsReport.d.b x(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.d.b.a aVarA = CrashlyticsReport.d.b.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("filename")) {
                aVarA.c(jsonReader.nextString());
            } else if (strNextName.equals("contents")) {
                aVarA.b(Base64.decode(jsonReader.nextString(), 2));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    @NonNull
    public static CrashlyticsReport.d y(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.d.a aVarA = CrashlyticsReport.d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("files")) {
                aVarA.b(k(jsonReader, new a() { // from class: lk.b
                    @Override // lk.g.a
                    public final Object a(JsonReader jsonReader2) {
                        return g.x(jsonReader2);
                    }
                }));
            } else if (strNextName.equals("orgId")) {
                aVarA.c(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    @NonNull
    public static CrashlyticsReport.e.AbstractC0439e z(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.e.AbstractC0439e.a aVarA = CrashlyticsReport.e.AbstractC0439e.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "buildVersion":
                    aVarA.b(jsonReader.nextString());
                    break;
                case "jailbroken":
                    aVarA.c(jsonReader.nextBoolean());
                    break;
                case "version":
                    aVarA.e(jsonReader.nextString());
                    break;
                case "platform":
                    aVarA.d(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    @NonNull
    public CrashlyticsReport D(@NonNull String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                CrashlyticsReport crashlyticsReportA = A(jsonReader);
                jsonReader.close();
                return crashlyticsReportA;
            } catch (Throwable th2) {
                try {
                    jsonReader.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (IllegalStateException e11) {
            throw new IOException(e11);
        }
    }

    @NonNull
    public String E(@NonNull CrashlyticsReport crashlyticsReport) {
        return f70304a.b(crashlyticsReport);
    }

    @NonNull
    public CrashlyticsReport.e.d g(@NonNull String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                CrashlyticsReport.e.d dVarN = n(jsonReader);
                jsonReader.close();
                return dVarN;
            } catch (Throwable th2) {
                try {
                    jsonReader.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (IllegalStateException e11) {
            throw new IOException(e11);
        }
    }

    @NonNull
    public String h(@NonNull CrashlyticsReport.e.d dVar) {
        return f70304a.b(dVar);
    }
}
