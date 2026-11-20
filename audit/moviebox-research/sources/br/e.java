package br;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import athena.a0;
import athena.j0;
import com.hisavana.common.constant.ComConstants;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f14334e;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f14339j;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f14343n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f14330a = ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f14331b = 150000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14332c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f14333d = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f14335f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f14336g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14337h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f14338i = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<String> f14340k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<byte[]> f14341l = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Pair<Integer, Integer> f14342m = new Pair<>(3, 6);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f14344o = 6;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f14345p = 10;

    @Nullable
    public static e b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                e eVar = new e();
                eVar.f14330a = jSONObject.getLong("pd");
                eVar.f14331b = jSONObject.getLong("th");
                eVar.f14332c = jSONObject.getBoolean("once");
                if (jSONObject.has("url")) {
                    eVar.f14333d = jSONObject.getString("url");
                }
                if (jSONObject.has("tidUrls")) {
                    eVar.f14334e = jSONObject.getJSONObject("tidUrls");
                }
                eVar.f14335f = jSONObject.getLong("version");
                eVar.f14336g = jSONObject.getLong("npt");
                eVar.f14337h = jSONObject.getInt("rt");
                eVar.f14338i = jSONObject.getBoolean("dd");
                eVar.f14339j = jSONObject.optString("ddv", null);
                if (jSONObject.has(TtmlNode.TAG_P)) {
                    eVar.f(jSONObject.getJSONArray(TtmlNode.TAG_P));
                }
                if (jSONObject.has("delays")) {
                    String[] strArrSplit = jSONObject.getString("delays").split(",");
                    eVar.f14342m = new Pair<>(Integer.valueOf(Integer.parseInt(strArrSplit[0])), Integer.valueOf(Integer.parseInt(strArrSplit[1])));
                }
                if (jSONObject.has("tz")) {
                    eVar.f14343n = jSONObject.getString("tz");
                }
                int i11 = 6;
                int iOptInt = jSONObject.optInt("geo", 6);
                if (iOptInt > 0 && iOptInt < 12) {
                    i11 = iOptInt;
                }
                eVar.f14344o = i11;
                if (jSONObject.has("dlt")) {
                    eVar.f14345p = jSONObject.getInt("dlt");
                }
                return eVar;
            } catch (Exception e11) {
                a0.c(Log.getStackTraceString(e11));
            }
        }
        return null;
    }

    public int A() {
        return this.f14345p;
    }

    public long B() {
        return this.f14335f;
    }

    public JSONObject C() {
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.f14340k.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            return new JSONObject().put("pd", this.f14330a).put("dlt", this.f14345p).put("th", this.f14331b).put("once", this.f14332c).put("url", this.f14333d).put("tidUrls", this.f14334e).put("version", this.f14335f).put("npt", this.f14336g).put("rt", this.f14337h).put("dd", this.f14338i).put("ddv", this.f14339j).put(TtmlNode.TAG_P, jSONArray).put("tz", this.f14343n).put("geo", this.f14344o).put("delays", this.f14342m.first + "," + this.f14342m.second);
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
            return null;
        }
    }

    public int a() {
        return this.f14344o;
    }

    public String c(long j11) {
        String string;
        String strValueOf = String.valueOf(j11);
        JSONObject jSONObject = this.f14334e;
        if (jSONObject == null || !jSONObject.has(strValueOf)) {
            string = null;
        } else {
            try {
                string = this.f14334e.getString(strValueOf);
            } catch (Exception e11) {
                a0.c(Log.getStackTraceString(e11));
                string = null;
            }
        }
        return TextUtils.isEmpty(string) ? this.f14333d : string;
    }

    public void d(int i11, int i12) {
        this.f14342m = new Pair<>(Integer.valueOf(i11), Integer.valueOf(i12));
    }

    public void e(String str) {
        this.f14339j = str;
    }

    public void f(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        this.f14340k.clear();
        this.f14341l.clear();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            this.f14340k.add(jSONArray.getString(i11));
            this.f14341l.add(jSONArray.getString(i11).getBytes());
        }
    }

    public void g(boolean z11) {
        this.f14338i = z11;
    }

    public boolean h(int i11) {
        if (this.f14336g == -1 || this.f14330a == -1) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j11 = jCurrentTimeMillis - this.f14336g;
        if (Math.abs(j11) < this.f14330a) {
            return j11 >= 0 && this.f14337h < i11;
        }
        k(jCurrentTimeMillis);
        return true;
    }

    public List<byte[]> i() {
        return this.f14341l;
    }

    public void j(int i11) {
        if (i11 <= 0 || i11 >= 12) {
            i11 = 6;
        }
        this.f14344o = i11;
    }

    public void k(long j11) {
        this.f14336g = j11;
        this.f14337h = 0;
    }

    public void l(String str) {
        this.f14343n = str;
    }

    public void m(JSONObject jSONObject) {
        this.f14334e = jSONObject;
    }

    public void n(boolean z11) {
        this.f14332c = z11;
    }

    public long o() {
        return this.f14330a;
    }

    public void p(int i11) {
        this.f14337h = i11;
    }

    public void q(long j11) {
        this.f14336g = j11;
    }

    public void r(String str) {
        this.f14333d = str;
    }

    public int s() {
        return this.f14337h;
    }

    public void t(int i11) {
        this.f14345p = i11;
    }

    public void u(long j11) {
        this.f14330a = j11;
    }

    public int v() {
        try {
            int iIntValue = ((Integer) this.f14342m.first).intValue();
            int iIntValue2 = ((Integer) this.f14342m.second).intValue();
            String str = j0.f13693a;
            return new Random().nextInt((iIntValue2 - iIntValue) + 1) + iIntValue;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 6;
        }
    }

    public void w(long j11) {
        if (j11 <= 0) {
            return;
        }
        this.f14331b = j11;
    }

    public long x() {
        return this.f14331b;
    }

    public void y(long j11) {
        this.f14335f = j11;
    }

    public String z() {
        return TextUtils.isEmpty(this.f14343n) ? "Asia/Shanghai" : this.f14343n;
    }
}
