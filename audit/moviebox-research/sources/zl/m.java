package zl;

import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bl.b<nj.a> f82100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f82101b = Collections.synchronizedMap(new HashMap());

    public m(bl.b<nj.a> bVar) {
        this.f82100a = bVar;
    }

    public void a(@NonNull String str, @NonNull com.google.firebase.remoteconfig.internal.a aVar) {
        JSONObject jSONObjectOptJSONObject;
        nj.a aVar2 = this.f82100a.get();
        if (aVar2 == null) {
            return;
        }
        JSONObject jSONObjectF = aVar.f();
        if (jSONObjectF.length() < 1) {
            return;
        }
        JSONObject jSONObjectD = aVar.d();
        if (jSONObjectD.length() >= 1 && (jSONObjectOptJSONObject = jSONObjectF.optJSONObject(str)) != null) {
            String strOptString = jSONObjectOptJSONObject.optString("choiceId");
            if (strOptString.isEmpty()) {
                return;
            }
            synchronized (this.f82101b) {
                try {
                    if (strOptString.equals(this.f82101b.get(str))) {
                        return;
                    }
                    this.f82101b.put(str, strOptString);
                    Bundle bundle = new Bundle();
                    bundle.putString("arm_key", str);
                    bundle.putString("arm_value", jSONObjectD.optString(str));
                    bundle.putString("personalization_id", jSONObjectOptJSONObject.optString("personalizationId"));
                    bundle.putInt("arm_index", jSONObjectOptJSONObject.optInt("armIndex", -1));
                    bundle.putString("group", jSONObjectOptJSONObject.optString("group"));
                    aVar2.b("fp", "personalization_assignment", bundle);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("_fpid", strOptString);
                    aVar2.b("fp", "_fpc", bundle2);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }
}
