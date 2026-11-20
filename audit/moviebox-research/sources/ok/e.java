package ok;

import com.google.firebase.crashlytics.internal.common.l;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f72468a;

    public e(l lVar) {
        this.f72468a = lVar;
    }

    public static f a(int i11) {
        if (i11 == 3) {
            return new j();
        }
        gk.f.f().d("Could not determine SettingsJsonTransform for settings version " + i11 + ". Using default settings values.");
        return new b();
    }

    public d b(JSONObject jSONObject) throws JSONException {
        return a(jSONObject.getInt("settings_version")).a(this.f72468a, jSONObject);
    }
}
