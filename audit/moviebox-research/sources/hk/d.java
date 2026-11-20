package hk;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class d implements b, ik.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public ik.a f66489a;

    @NonNull
    public static String b(@NonNull String str, @NonNull Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put("name", str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    @Override // ik.b
    public void a(@Nullable ik.a aVar) {
        this.f66489a = aVar;
        gk.f.f().b("Registered Firebase Analytics event receiver for breadcrumbs");
    }

    @Override // hk.b
    public void onEvent(@NonNull String str, @NonNull Bundle bundle) {
        ik.a aVar = this.f66489a;
        if (aVar != null) {
            try {
                aVar.a("$A$:" + b(str, bundle));
            } catch (JSONException unused) {
                gk.f.f().k("Unable to serialize Firebase Analytics event to breadcrumb.");
            }
        }
    }
}
