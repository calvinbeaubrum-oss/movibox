package br;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import athena.a0;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f14346a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<b> f14347b = new CopyOnWriteArrayList();

    @Nullable
    public static f b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f fVar = new f();
            e eVarB = e.b(jSONObject.getJSONObject("global_config"));
            if (eVarB != null) {
                fVar.f14346a = eVarB;
            }
            return fVar;
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
            com.transsion.ga.e.a("fromJSON", e11);
            return null;
        }
    }

    public b a(int i11) {
        if (!d.i(this.f14347b)) {
            return null;
        }
        for (b bVar : this.f14347b) {
            if (bVar.a() == i11) {
                return bVar;
            }
        }
        return null;
    }

    public String c(long j11) {
        return this.f14346a.c(j11);
    }

    public List<b> d() {
        return this.f14347b;
    }

    public void e(List<b> list) {
        this.f14347b.clear();
        this.f14347b.addAll(list);
    }

    public e f() {
        return this.f14346a;
    }

    public void g() {
        for (b bVar : this.f14347b) {
            bVar.m(0L);
            bVar.j(-1L);
        }
        this.f14346a.y(0L);
        this.f14346a.q(-1L);
    }

    public String h() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("global_config", this.f14346a.C());
            return jSONObject.toString();
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
            com.transsion.ga.e.a("toJSON", e11);
            return "";
        }
    }
}
