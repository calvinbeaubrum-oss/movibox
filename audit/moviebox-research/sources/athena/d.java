package athena;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile d f13624c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f13625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public br.f f13626b = new br.f();

    public d(i iVar) {
        this.f13625a = iVar;
    }

    public static d a(i iVar) {
        if (f13624c == null) {
            synchronized (d.class) {
                try {
                    if (f13624c == null) {
                        f13624c = new d(iVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f13624c;
    }

    public br.c b(long j11) {
        br.c cVar = new br.c();
        String strC = this.f13626b.c(j11);
        if (TextUtils.isEmpty(strC)) {
            strC = br.g.c(true);
        }
        cVar.f14327a = strC + br.g.f14355h;
        cVar.f14328b = l();
        cVar.f14329c = this.f13626b.f().x();
        return cVar;
    }

    public List<br.b> c() {
        return this.f13626b.d();
    }

    public void d(int i11) {
        List<br.b> listD = this.f13626b.d();
        Iterator<br.b> it = listD.iterator();
        while (it.hasNext()) {
            if (it.next().a() == i11) {
                return;
            }
        }
        br.b bVar = new br.b();
        bVar.d(i11);
        listD.add(bVar);
    }

    public void e(@NonNull x0 x0Var, ar.c cVar) {
        long j11;
        if (br.g.E()) {
            br.e eVarF = this.f13626b.f();
            if (eVarF.h(32)) {
                x0Var.f(new f0(br.g.v(), eVarF, cVar));
            }
            for (br.b bVar : this.f13626b.d()) {
                int iK = bVar.k();
                long jO = iK > 0 ? ((long) iK) * 3600000 : eVarF.o();
                if (bVar.f(jO, 32)) {
                    StringBuilder sb2 = new StringBuilder();
                    try {
                        String strD = com.transsion.ga.g.d();
                        sb2.append(Build.MODEL);
                        sb2.append(Build.BRAND);
                        sb2.append(com.transsion.core.utils.a.b());
                        sb2.append(Build.VERSION.RELEASE);
                        sb2.append(com.transsion.core.utils.a.a());
                        sb2.append(com.transsion.ga.g.g());
                        sb2.append(Locale.getDefault().getLanguage());
                        if (strD == null) {
                            strD = "";
                        }
                        sb2.append(strD);
                    } catch (Exception e11) {
                        a0.c(Log.getStackTraceString(e11));
                    }
                    int iHashCode = sb2.toString().hashCode();
                    long jX = bVar.x();
                    if (jX <= 0 || iHashCode == bVar.g()) {
                        j11 = jX;
                    } else {
                        a0.e("dimensionChanged, so set appConfig version to 0");
                        bVar.m(0L);
                        j11 = 0;
                    }
                    x0Var.f(new e0(bVar.a(), bVar, br.g.p(), j11, iHashCode, jO, cVar));
                }
            }
        }
    }

    public void f(@NonNull br.b bVar, @NonNull String str) {
        br.b bVar2 = bVar;
        String str2 = "cfg";
        String str3 = "ur";
        String str4 = "gmin";
        String str5 = "pr";
        String str6 = "stats";
        try {
            String str7 = "frq";
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("ver")) {
                bVar2.m(jSONObject.getLong("ver"));
            }
            if (jSONObject.has("url")) {
                bVar2.q(jSONObject.getString("url"));
            }
            if (jSONObject.has("interval")) {
                bVar2.l(jSONObject.getInt("interval"));
            }
            if (jSONObject.has("offline")) {
                bVar2.p(jSONObject.getInt("offline"));
            }
            if (jSONObject.has("data")) {
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                if (jSONArray.length() > 0) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(0).getJSONObject("cfg");
                    int i11 = 0;
                    while (i11 < jSONArray.length()) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i11).getJSONObject(str2);
                        JSONArray jSONArray2 = jSONArray.getJSONObject(i11).getJSONArray("tids");
                        int i12 = 0;
                        while (i12 < jSONArray2.length()) {
                            String str8 = str2;
                            JSONArray jSONArray3 = jSONArray;
                            long j11 = jSONArray2.getLong(i12);
                            br.a aVarB = bVar2.b(j11);
                            if (aVarB == null) {
                                br.a aVar = new br.a();
                                aVar.k(j11);
                                bVar2.e(aVar);
                                aVarB = aVar;
                            }
                            int iOptInt = jSONObject2.optInt("cv", 0);
                            if (jSONObject3.has("cv")) {
                                iOptInt = jSONObject3.getInt("cv");
                            }
                            aVarB.e().g(iOptInt > 0 ? ((long) iOptInt) * ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS : iOptInt);
                            int iOptInt2 = jSONObject2.optInt(str4, 0);
                            if (jSONObject3.has(str4)) {
                                iOptInt2 = jSONObject3.getInt(str4);
                            }
                            aVarB.e().i(iOptInt2);
                            int iOptInt3 = jSONObject2.optInt("gmax", 100);
                            if (jSONObject3.has("gmax")) {
                                iOptInt3 = jSONObject3.getInt("gmax");
                            }
                            aVarB.e().f(iOptInt3);
                            int iOptInt4 = jSONObject2.optInt("num", 0);
                            if (jSONObject3.has("num")) {
                                iOptInt4 = jSONObject3.getInt("num");
                            }
                            aVarB.e().l(iOptInt4);
                            int iOptInt5 = jSONObject2.optInt("s", 10);
                            if (jSONObject3.has("s")) {
                                iOptInt5 = jSONObject3.getInt("s");
                            }
                            aVarB.e().m(((long) iOptInt5) * ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
                            int iOptInt6 = jSONObject2.optInt("iw", 0);
                            if (jSONObject3.has("iw")) {
                                iOptInt6 = jSONObject3.getInt("iw");
                            }
                            aVarB.e().o(iOptInt6);
                            String str9 = str3;
                            int iOptInt7 = jSONObject2.optInt(str9, 100);
                            if (jSONObject3.has(str9)) {
                                iOptInt7 = jSONObject3.getInt(str9);
                            }
                            aVarB.e().u(iOptInt7);
                            String str10 = str7;
                            int iOptInt8 = jSONObject2.optInt(str10, 0);
                            if (jSONObject3.has(str10)) {
                                iOptInt8 = jSONObject3.getInt(str10);
                            }
                            int i13 = iOptInt8 * 60;
                            String str11 = str4;
                            aVarB.e().c(((long) i13) * 1000);
                            String str12 = str6;
                            int iOptInt9 = jSONObject2.optInt(str12, 0);
                            if (jSONObject3.has(str12)) {
                                iOptInt9 = jSONObject3.getInt(str12);
                            }
                            aVarB.e().s(iOptInt9);
                            String str13 = str5;
                            int iOptInt10 = jSONObject2.optInt(str13, 0);
                            if (jSONObject3.has(str13)) {
                                iOptInt10 = jSONObject3.getInt(str13);
                            }
                            str6 = str12;
                            aVarB.e().q(iOptInt10);
                            i12++;
                            bVar2 = bVar;
                            str5 = str13;
                            str3 = str9;
                            str4 = str11;
                            str2 = str8;
                            str7 = str10;
                            jSONArray = jSONArray3;
                        }
                        i11++;
                        bVar2 = bVar;
                        str4 = str4;
                        str2 = str2;
                        str7 = str7;
                        jSONArray = jSONArray;
                    }
                }
            }
            if (jSONObject.has("table")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("table");
                for (br.a aVar2 : bVar.w()) {
                    String strOptString = jSONObject4.optString(String.valueOf(aVar2.d()), "");
                    if (strOptString.length() > 0) {
                        aVar2.i(strOptString);
                    }
                }
            }
            try {
                br.b bVarA = this.f13626b.a(cr.b.d());
                if (bVarA == null) {
                    return;
                }
                br.g.d(bVarA.v());
            } catch (Exception e11) {
                e = e11;
                a0.c(Log.getStackTraceString(e));
                com.transsion.ga.e.a("updateAppConfig", e);
            }
        } catch (Exception e12) {
            e = e12;
        }
    }

    public void g(@NonNull String str) {
        try {
            br.e eVarF = this.f13626b.f();
            JSONObject jSONObject = new JSONObject(str);
            eVarF.u(jSONObject.getLong("cv") * 3600000);
            eVarF.w(jSONObject.getLong("threshold"));
            eVarF.n(jSONObject.getInt("once") == 1);
            if (jSONObject.has("networks")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("networks");
                eVarF.r(jSONObject2.getString("url"));
                eVarF.m(jSONObject2.getJSONObject("tids"));
            }
            if (jSONObject.has(TtmlNode.TAG_P)) {
                eVarF.f(jSONObject.getJSONArray(TtmlNode.TAG_P));
            }
            if (jSONObject.has("ver")) {
                eVarF.y(jSONObject.getLong("ver"));
            }
            if (jSONObject.has("delays")) {
                String[] strArrSplit = jSONObject.getString("delays").split(",");
                eVarF.d(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]));
            }
            if (jSONObject.has("tz")) {
                eVarF.l(jSONObject.getString("tz"));
            }
            if (jSONObject.has("dlt")) {
                eVarF.t(jSONObject.getInt("dlt"));
            }
            eVarF.j(jSONObject.optInt("geo", 6));
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
            com.transsion.ga.e.a("updateGlobalConfig", e11);
        }
    }

    public void h(List<br.b> list) {
        this.f13626b.e(list);
    }

    public br.f i() {
        return this.f13626b;
    }

    public final void j() {
        String str;
        try {
            this.f13625a.getClass();
            byte[] bArrJ = br.d.j("63D4BEBEBC7ABCA4BC6A796B6AB06B766A6C7D706B6B756F70B07B6F71A4A5AEBCB2D4BEBEBC6A69BCA4BC7A6B69B16A796B6AB06B767D72726A6C65B07B6F71BCB2D4BEBEBC6A7BBCA4BC7A6B7BB16A796B6AB06B767D72726A6C65B07B6F71BCB2D4BEBEBC6F69BCA4BC7A6B69B06B767D72726A6C65B07B6F71BCB2D4BEBEBC6F7BBCA4BC7A6B7BB06B767D72726A6C65B07B6F71BCB2D4BEBEBC7BBCA4BCAF726F777B6F7078AF68A8AF696E726F7D7A7B6F7078BCB2D4BEBEBC77BCA4BCAF726F777B6F7078AF68ADAF6B797B6C796ABCB2D4BEBEBC69BCA4BCAF7D6A7679707DAF7B76797B736E6F75706AAF68ACAF696E726F7D7ABCB2D4BEBEBC787BBCA4BC68AEAC7BBCB2D4BEBEBC787ABCA4BC68AEAC7ABCB2D4BEBEBC7879BCA4BC68AEAC79BCB2D4BEBEBC7568BCA4BC7D7C7B7A79787776757473AD71706F6EBCB2D4BEBEBC67BCA4BCABA7ADA899A99B9CAD9CA5A6AC9BAEABA9AEADAB99A9ACADA8A79D9D98A9AA9DBCD461D4D4");
            if (bArrJ == null) {
                str = "";
            } else {
                for (int i11 = 0; i11 < bArrJ.length; i11++) {
                    bArrJ[i11] = (byte) (222 - ((char) bArrJ[i11]));
                }
                str = new String(bArrJ);
            }
            br.g.i(str);
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
            com.transsion.ga.e.a("initSDKConfig", e11);
        } finally {
            this.f13625a.a(br.g.f14357j);
            this.f13625a.b(br.g.f14360m);
        }
    }

    public void k() {
        try {
            j();
            br.f fVarB = br.f.b(this.f13625a.f());
            if (fVarB == null) {
                this.f13625a.e(this.f13626b.h());
            } else {
                this.f13626b = fVarB;
            }
            br.b bVarA = this.f13626b.a(cr.b.d());
            if (bVarA == null) {
                return;
            }
            br.g.d(bVarA.v());
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
        }
    }

    @NonNull
    public Pair<Integer, byte[]> l() {
        List<byte[]> listI = this.f13626b.f().i();
        if (!br.d.i(listI)) {
            return new Pair<>(0, br.g.f14361n);
        }
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() % ((long) listI.size()));
        return new Pair<>(Integer.valueOf(iCurrentTimeMillis), listI.get(iCurrentTimeMillis));
    }

    public void m() {
        this.f13626b.g();
        this.f13625a.e(this.f13626b.h());
    }

    public void n() {
        br.e eVarF = this.f13626b.f();
        eVarF.e(com.transsion.core.utils.a.c());
        eVarF.g(true);
        this.f13625a.e(this.f13626b.h());
    }

    public void o() {
        i iVar = this.f13625a;
        if (iVar != null) {
            iVar.e(this.f13626b.h());
        }
    }
}
