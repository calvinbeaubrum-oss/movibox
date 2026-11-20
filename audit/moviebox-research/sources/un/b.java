package un;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WindowManager f78617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String[] f78618b = {"x", "y", "width", "height"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static float f78619c = Resources.getSystem().getDisplayMetrics().density;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f78620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f78621b;

        public a(float f11, float f12) {
            this.f78620a = f11;
            this.f78621b = f12;
        }
    }

    public static float a(int i11) {
        return i11 / f78619c;
    }

    public static JSONObject b(int i11, int i12, int i13, int i14) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", a(i11));
            jSONObject.put("y", a(i12));
            jSONObject.put("width", a(i13));
            jSONObject.put("height", a(i14));
        } catch (JSONException e11) {
            c.b("Error with creating viewStateObject", e11);
        }
        return jSONObject;
    }

    public static void c(Context context) {
        if (context != null) {
            f78619c = context.getResources().getDisplayMetrics().density;
            f78617a = (WindowManager) context.getSystemService("window");
        }
    }

    public static void d(JSONObject jSONObject) {
        a aVarJ = j(jSONObject);
        try {
            jSONObject.put("width", aVarJ.f78620a);
            jSONObject.put("height", aVarJ.f78621b);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    public static void e(JSONObject jSONObject, com.iab.omid.library.vungle.walking.a.C0472a c0472a) {
        com.iab.omid.library.vungle.b.c cVarA = c0472a.a();
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = c0472a.c().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
            jSONObject.put("friendlyObstructionClass", cVarA.b());
            jSONObject.put("friendlyObstructionPurpose", cVarA.c());
            jSONObject.put("friendlyObstructionReason", cVarA.d());
        } catch (JSONException e11) {
            c.b("Error with setting friendly obstruction", e11);
        }
    }

    public static void f(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e11) {
            c.b("Error with setting ad session id", e11);
        }
    }

    public static void g(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e11) {
            c.b("JSONException during JSONObject.put for name [" + str + "]", e11);
        }
    }

    public static void h(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childViews");
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
                jSONObject.put("childViews", jSONArrayOptJSONArray);
            }
            jSONArrayOptJSONArray.put(jSONObject2);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    public static boolean i(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }

    public static a j(JSONObject jSONObject) {
        float fA;
        float fA2;
        if (f78617a != null) {
            Point point = new Point(0, 0);
            f78617a.getDefaultDisplay().getRealSize(point);
            fA = a(point.x);
            fA2 = a(point.y);
        } else {
            fA = 0.0f;
            fA2 = 0.0f;
        }
        return new a(fA, fA2);
    }

    public static void k(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e11) {
            c.b("Error with setting not visible reason", e11);
        }
    }

    public static boolean l(@NonNull JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        return jSONObject != null && jSONObject2 != null && m(jSONObject, jSONObject2) && n(jSONObject, jSONObject2) && o(jSONObject, jSONObject2) && p(jSONObject, jSONObject2);
    }

    public static boolean m(JSONObject jSONObject, JSONObject jSONObject2) {
        for (String str : f78618b) {
            if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean n(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", ""));
    }

    public static boolean o(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
        JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
        if (jSONArrayOptJSONArray == null && jSONArrayOptJSONArray2 == null) {
            return true;
        }
        if (!i(jSONArrayOptJSONArray, jSONArrayOptJSONArray2)) {
            return false;
        }
        for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
            if (!jSONArrayOptJSONArray.optString(i11, "").equals(jSONArrayOptJSONArray2.optString(i11, ""))) {
                return false;
            }
        }
        return true;
    }

    public static boolean p(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childViews");
        JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("childViews");
        if (jSONArrayOptJSONArray == null && jSONArrayOptJSONArray2 == null) {
            return true;
        }
        if (!i(jSONArrayOptJSONArray, jSONArrayOptJSONArray2)) {
            return false;
        }
        for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
            if (!l(jSONArrayOptJSONArray.optJSONObject(i11), jSONArrayOptJSONArray2.optJSONObject(i11))) {
                return false;
            }
        }
        return true;
    }
}
