package cr;

import androidx.annotation.NonNull;
import com.transsion.athena.data.TrackData;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f62779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f62780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f62781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f62782d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f62783e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f62784f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f62785g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f62786h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TrackData f62787i;

    public String a() {
        return this.f62786h;
    }

    public String b() {
        return this.f62779a;
    }

    public JSONObject c() {
        return this.f62780b;
    }

    public JSONObject d() {
        return this.f62781c;
    }

    public long e() {
        return this.f62782d;
    }

    public TrackData f() {
        return this.f62787i;
    }

    public long g() {
        return this.f62785g;
    }

    public int h() {
        return this.f62783e;
    }

    public long i() {
        return this.f62784f;
    }

    public void j(String str) {
        this.f62786h = str;
    }

    public void k(String str) {
        this.f62779a = str;
    }

    public void l(JSONObject jSONObject) {
        this.f62780b = jSONObject;
    }

    public void m(JSONObject jSONObject) {
        this.f62781c = jSONObject;
    }

    public void n(long j11) {
        this.f62782d = j11;
    }

    public void o(TrackData trackData) {
        this.f62787i = trackData;
    }

    public void p(long j11) {
        this.f62785g = j11;
    }

    public void q(int i11) {
        this.f62783e = i11;
    }

    public void r(long j11) {
        this.f62784f = j11;
    }

    @NonNull
    public String toString() {
        return "tid = " + this.f62782d + ",event = " + this.f62780b.toString();
    }
}
