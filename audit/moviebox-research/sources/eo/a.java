package eo;

import androidx.annotation.Nullable;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements io.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f64288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f64289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f64290c;

    public a(String str, int i11, float f11) {
        this.f64288a = str;
        this.f64289b = i11;
        this.f64290c = f11;
    }

    @Override // io.l
    public void a(io.r rVar) {
        rVar.u(1, this.f64288a).s(2, this.f64289b).l(3, this.f64290c);
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_0", this.f64288a).put("_1", this.f64289b).put("_2", this.f64290c);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public float d() {
        return this.f64290c;
    }

    @Override // io.l
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public a b(io.o oVar) {
        String strQ = this.f64288a;
        int iO = this.f64289b;
        float fH = this.f64290c;
        while (oVar.b()) {
            int iN = oVar.n();
            if (iN == 1) {
                strQ = oVar.q();
            } else if (iN == 2) {
                iO = oVar.o();
            } else if (iN != 3) {
                oVar.c();
            } else {
                fH = oVar.h();
            }
        }
        return new a(strQ, iO, fH);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Objects.equals(this.f64288a, aVar.f64288a) && this.f64289b == aVar.f64289b && this.f64290c == aVar.f64290c;
    }

    public String f() {
        return this.f64288a;
    }

    public int g() {
        return this.f64289b;
    }

    public int hashCode() {
        return Objects.hash(this.f64288a, Integer.valueOf(this.f64289b), Float.valueOf(this.f64290c));
    }

    public String toString() {
        return super.toString();
    }
}
