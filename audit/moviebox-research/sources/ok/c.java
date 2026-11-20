package ok;

import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f72453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mk.b f72454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gk.f f72455c;

    public c(String str, mk.b bVar) {
        this(str, bVar, gk.f.f());
    }

    public c(String str, mk.b bVar, gk.f fVar) {
        if (str == null) {
            throw new IllegalArgumentException("url must not be null.");
        }
        this.f72455c = fVar;
        this.f72454b = bVar;
        this.f72453a = str;
    }

    @Override // ok.i
    public JSONObject a(h hVar, boolean z11) {
        if (!z11) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        try {
            Map<String, String> mapF = f(hVar);
            mk.a aVarB = b(d(mapF), hVar);
            this.f72455c.b("Requesting settings from " + this.f72453a);
            this.f72455c.i("Settings query params were: " + mapF);
            return g(aVarB.c());
        } catch (IOException e11) {
            this.f72455c.e("Settings request failed.", e11);
            return null;
        }
    }

    public final mk.a b(mk.a aVar, h hVar) {
        c(aVar, "X-CRASHLYTICS-GOOGLE-APP-ID", hVar.f72469a);
        c(aVar, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        c(aVar, "X-CRASHLYTICS-API-CLIENT-VERSION", CrashlyticsCore.l());
        c(aVar, "Accept", "application/json");
        c(aVar, "X-CRASHLYTICS-DEVICE-MODEL", hVar.f72470b);
        c(aVar, "X-CRASHLYTICS-OS-BUILD-VERSION", hVar.f72471c);
        c(aVar, "X-CRASHLYTICS-OS-DISPLAY-VERSION", hVar.f72472d);
        c(aVar, "X-CRASHLYTICS-INSTALLATION-ID", hVar.f72473e.a());
        return aVar;
    }

    public final void c(mk.a aVar, String str, String str2) {
        if (str2 != null) {
            aVar.d(str, str2);
        }
    }

    public mk.a d(Map<String, String> map) {
        return this.f72454b.a(this.f72453a, map).d("User-Agent", "Crashlytics Android SDK/" + CrashlyticsCore.l()).d("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    public final JSONObject e(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e11) {
            this.f72455c.l("Failed to parse settings JSON from " + this.f72453a, e11);
            this.f72455c.k("Settings response " + str);
            return null;
        }
    }

    public final Map<String, String> f(h hVar) {
        HashMap map = new HashMap();
        map.put("build_version", hVar.f72476h);
        map.put("display_version", hVar.f72475g);
        map.put("source", Integer.toString(hVar.f72477i));
        String str = hVar.f72474f;
        if (!TextUtils.isEmpty(str)) {
            map.put("instance", str);
        }
        return map;
    }

    public JSONObject g(mk.c cVar) {
        int iB = cVar.b();
        this.f72455c.i("Settings response code was: " + iB);
        if (h(iB)) {
            return e(cVar.a());
        }
        this.f72455c.d("Settings request failed; (status: " + iB + ") from " + this.f72453a);
        return null;
    }

    public boolean h(int i11) {
        return i11 == 200 || i11 == 201 || i11 == 202 || i11 == 203;
    }
}
