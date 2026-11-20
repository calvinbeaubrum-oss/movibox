package mc;

import ac.c;
import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.utils.j;
import com.google.gson.JsonObject;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public c f70971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.cloud.tmc.kernel.extension.c f70972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f70973c;

    public a(@Nullable c cVar) {
        this.f70971a = cVar;
    }

    public void a(JsonObject jsonObject, boolean z11) {
        b(jsonObject, z11, false);
    }

    public void b(JsonObject jsonObject, boolean z11, boolean z12) {
        com.cloud.tmc.kernel.extension.c cVar;
        if (this.f70971a != null) {
            if (j.a() && (cVar = this.f70972b) != null) {
                jsonObject.addProperty("ext", cVar.getClass().getName());
            }
            this.f70971a.b(jsonObject, z11, z12);
        }
    }

    public void c(HashMap<String, Object> map, boolean z11) {
        d(map, z11, false);
    }

    public void d(HashMap<String, Object> map, boolean z11, boolean z12) {
        com.cloud.tmc.kernel.extension.c cVar;
        if (this.f70971a != null) {
            if (j.a() && (cVar = this.f70972b) != null) {
                map.put("ext", cVar.getClass().getName());
            }
            this.f70971a.a(map, z11, z12);
        }
    }

    public String e() {
        return this.f70973c;
    }

    public c f() {
        return this.f70971a;
    }

    public void g(HashMap<String, Object> map) {
        c(map, false);
    }

    public void h(HashMap<String, Object> map) {
        c(map, true);
    }

    public void i(JsonObject jsonObject) {
        a(jsonObject, false);
    }

    public void j(JsonObject jsonObject) {
        b(jsonObject, false, true);
    }

    public void k(JsonObject jsonObject) {
        a(jsonObject, true);
    }

    public void l(int i11, String str) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("message", str);
        jsonObject.addProperty("errMsg", str);
        jsonObject.addProperty("errCode", Integer.valueOf(i11));
        jsonObject.addProperty("success", "false");
        a(jsonObject, false);
    }

    public void m() {
        l(4, "无权调用");
    }

    public void n() {
        l(1, "not implemented");
    }

    public void o() {
        l(5, "获取授权失败");
    }

    public void p(String str) {
        this.f70973c = str;
    }

    public void q(com.cloud.tmc.kernel.extension.c cVar) {
        this.f70972b = cVar;
    }
}
