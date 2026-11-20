package yt;

import au.e;
import com.transsion.http.request.HttpMethod;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b extends c<b> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f81634l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map<String, Object> f81635m;

    public vt.b g() {
        Map<String, Object> map = this.f81635m;
        if (map != null) {
            this.f81634l = new JSONObject(map).toString();
        }
        return new e(this.f81636a, this.f81637b, HttpMethod.POST, this.f81638c, this.f81634l, this.f81639d, this.f81640e, this.f81641f, this.f81642g, com.transsion.http.request.a.f52881b, this.f81643h, this.f81644i, this.f81646k).a();
    }

    public b h(String str) {
        this.f81634l = str;
        return this;
    }
}
