package athena;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.transsion.api.gateway.utils.SafeStringUtils;
import com.transsion.athena.data.AppIdData;
import com.transsion.athena.data.TrackData;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.gslb.GslbSdk;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends l implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13647d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f13648f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13649g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public z f13650h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ar.a f13651i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList<cr.a> f13652j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f13653k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public u0 f13654l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final SparseArray<String> f13655m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f13656n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f13657o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f13658p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f13659q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public x0 f13660r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ar.c f13661s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f13662t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Runnable f13663u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final LocationListener f13664v;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class a extends ar.c {
        public a() {
        }

        @Override // ar.c
        public void a(int i11, boolean z11) {
            try {
                if (i11 > 0) {
                    h.this.p(i11, z11);
                } else {
                    h.F(h.this);
                }
            } catch (Exception e11) {
                a0.d("onConfigChanged exception : %s", e11.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.f13657o = j0.r(ws.a.a());
            h.this.f13648f.postDelayed(this, 3600000L);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class c implements GslbSdk.InitListener {
        public c() {
        }

        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitFail() {
        }

        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitSuccess(Map<String, String> map) {
            h.this.f13656n = map == null ? "" : map.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class d implements GslbSdk.InitListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f13669b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ br.b f13670c;

        public d(String str, int i11, br.b bVar) {
            this.f13668a = str;
            this.f13669b = i11;
            this.f13670c = bVar;
        }

        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitFail() {
        }

        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitSuccess(Map<String, String> map) {
            h.this.z(this.f13668a, this.f13669b, this.f13670c, map == null ? "" : map.toString());
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class e implements GslbSdk.ResultListener {
        public e(h hVar) {
        }

        @Override // com.transsion.gslb.GslbSdk.ResultListener
        public void onGslbFail() {
        }

        @Override // com.transsion.gslb.GslbSdk.ResultListener
        public void onGslbSuccess(String str) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"MissingPermission"})
        public void run() {
            try {
                h.this.q(null);
                LocationManager locationManager = (LocationManager) ws.a.a().getApplicationContext().getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
                if (locationManager != null) {
                    locationManager.removeUpdates(h.this.f13664v);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public class g implements LocationListener {
        public g() {
        }

        @Override // android.location.LocationListener
        @SuppressLint({"MissingPermission"})
        public void onLocationChanged(Location location) {
            if (h.this.f13648f != null) {
                h.this.f13648f.removeCallbacks(h.this.f13663u);
            }
            try {
                h.this.q(location);
                LocationManager locationManager = (LocationManager) ws.a.a().getApplicationContext().getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
                if (locationManager != null) {
                    locationManager.removeUpdates(h.this.f13664v);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i11, Bundle bundle) {
        }
    }

    /* JADX INFO: renamed from: athena.h$h, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class C0133h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f13674a = new h(null);
    }

    public h() {
        this.f13644a = false;
        this.f13645b = false;
        this.f13655m = new SparseArray<>();
        this.f13659q = 0L;
        this.f13661s = new a();
        this.f13662t = 0L;
        this.f13663u = new f();
        this.f13664v = new g();
        HandlerThread handlerThread = new HandlerThread("Athena-Worker");
        handlerThread.setPriority(10);
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.f13648f = handler;
        handler.sendEmptyMessage(303);
    }

    public /* synthetic */ h(a aVar) {
        this();
    }

    public static void F(h hVar) {
        if (!hVar.f13647d) {
            hVar.f13646c = ar.b.a().r() * 1000;
        }
        hVar.M();
    }

    public static void H(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("v", str);
        com.transsion.ga.l.a().c(new com.transsion.ga.e("cleanupEvents_off", bundle));
        a0.f("handleTidChange cleanupList : %s", str);
    }

    public static void J(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("v", str);
        com.transsion.ga.l.a().c(new com.transsion.ga.e("cleanupEvents_oom", bundle));
    }

    private void L() {
        Context contextA = ws.a.a();
        Cursor cursorQuery = null;
        try {
            cursorQuery = contextA.getContentResolver().query(Uri.parse("content://com.transsion.dataservice.provider/authorize"), null, "pkg = ?", new String[]{contextA.getPackageName()}, null);
            if (cursorQuery != null) {
                this.f13658p = cursorQuery.getCount() == 1;
                Object[] objArr = new Object[2];
                objArr[0] = contextA.getPackageName();
                objArr[1] = this.f13658p ? "enable" : "disable";
                a0.f("Pkg [%s] DCS authorize [%s]", objArr);
            } else {
                a0.f("Cursor is null, Pkg [%s] may not on the DCS white list", contextA.getPackageName());
            }
        } catch (Exception e11) {
            a0.d("Dcs applyForAccess exception : %s", e11.getMessage());
        } finally {
            if (0 != 0) {
                cursorQuery.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void y(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("v", str);
        com.transsion.ga.l.a().c(new com.transsion.ga.e("cleanupEvents_oom", bundle));
    }

    public final void A(String str, Throwable th2) {
        com.transsion.ga.l.a().c(new com.transsion.ga.e(str, th2));
    }

    public final void B(JSONObject jSONObject, String str, Object obj) throws JSONException {
        try {
            jSONObject.getString(str);
        } catch (JSONException unused) {
            jSONObject.put(str, obj);
        }
    }

    @SuppressLint({"MissingPermission"})
    public final void C(boolean z11) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if ((z11 && TextUtils.isEmpty(br.g.z())) || Math.abs(jCurrentTimeMillis - this.f13662t) < 3600000) {
            if (this.f13648f.hasMessages(502)) {
                return;
            }
            this.f13648f.sendMessageDelayed(this.f13648f.obtainMessage(502), 3600000L);
            return;
        }
        if (this.f13651i.a(9999, RequestParameters.SUBRESOURCE_LOCATION) == 0) {
            if (j0.g(ws.a.a(), "android.permission.ACCESS_COARSE_LOCATION") || j0.g(ws.a.a(), "android.permission.ACCESS_FINE_LOCATION")) {
                LocationManager locationManager = (LocationManager) ws.a.a().getApplicationContext().getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
                if (locationManager == null) {
                    q(null);
                    return;
                }
                String str = "network";
                if (!locationManager.isProviderEnabled("network")) {
                    str = "passive";
                    if (!locationManager.isProviderEnabled("passive")) {
                        str = "gps";
                        if (!locationManager.isProviderEnabled("gps")) {
                            str = null;
                        }
                    }
                }
                if (str != null) {
                    this.f13648f.removeCallbacks(this.f13663u);
                    this.f13648f.postDelayed(this.f13663u, 30000L);
                    locationManager.requestSingleUpdate(str, this.f13664v, (Looper) null);
                    this.f13662t = jCurrentTimeMillis;
                }
                if (this.f13648f.hasMessages(502)) {
                    return;
                }
                this.f13648f.sendMessageDelayed(this.f13648f.obtainMessage(502), 3600000L);
            }
        }
    }

    public final void D(boolean z11, long j11) {
        if (this.f13648f.hasMessages(298)) {
            return;
        }
        Message messageObtainMessage = this.f13648f.obtainMessage(298);
        if (z11) {
            messageObtainMessage.arg1 = 1;
            this.f13648f.sendMessage(messageObtainMessage);
        } else {
            messageObtainMessage.arg1 = 0;
            this.f13648f.sendMessageDelayed(messageObtainMessage, j11);
        }
    }

    public final void G(cr.a aVar) {
        String str;
        int i11;
        if ("app_launch".equals(aVar.b())) {
            m0 m0VarA = m0.a(ws.a.a());
            String str2 = "app_launch_" + j0.a(aVar.e());
            int iE = m0VarA.e(str2);
            if (iE != 0 && Math.abs((aVar.i() / 1000) - ((long) iE)) <= 7200000) {
                return;
            } else {
                m0VarA.b(str2, Long.valueOf(aVar.i() / 1000).intValue());
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, aVar.b());
            jSONObject.put("tid", aVar.e());
            jSONObject.put("type", aVar.h());
            JSONObject jSONObjectD = aVar.d();
            String str3 = j0.f13693a;
            B(jSONObjectD, "_apkg", ws.a.a().getPackageName());
            try {
                str = ws.a.a().getApplicationContext().getPackageManager().getPackageInfo(ws.a.a().getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e11) {
                a0.c(Log.getStackTraceString(e11));
                str = "";
            }
            B(jSONObjectD, "_avn", str);
            try {
                i11 = ws.a.a().getApplicationContext().getPackageManager().getPackageInfo(ws.a.a().getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e12) {
                a0.c(Log.getStackTraceString(e12));
                i11 = 0;
            }
            B(jSONObjectD, "_avc", Integer.valueOf(i11));
            B(jSONObjectD, "_atutp", Short.valueOf(br.g.j()));
            String strH = br.g.h();
            if (strH == null) {
                strH = "";
            }
            B(jSONObjectD, "_atuid", strH);
            jSONObject.put("_eparam", jSONObjectD);
        } catch (JSONException e13) {
            a0.d("Track by DCS exception : ", e13.getMessage());
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("trackObject", jSONObject.toString());
        ws.a.a().getContentResolver().insert(Uri.parse("content://com.transsion.dataservice.provider/track"), contentValues);
        a0.f("track by DCS:%s", jSONObject.toString().replace("\\", ""));
    }

    public final void M() {
        if (!j0.r(ws.a.a())) {
            a0.f("%s", "CheckConfig cancel, network is not available");
            return;
        }
        if (!GslbSdk.isInitSuccess(br.g.c(false))) {
            a0.f("%s", "CheckConfig cancel, GslbSdk is not inited");
            return;
        }
        ar.a aVar = this.f13651i;
        if (aVar != null) {
            aVar.f(this.f13660r, this.f13661s);
        }
    }

    public final void N() {
        x0 x0Var;
        if (!j0.r(ws.a.a())) {
            a0.b("%s", "checkUpload network unavailable");
            return;
        }
        if (this.f13654l.j()) {
            if (this.f13654l.i()) {
                return;
            }
            a0.b("%s", "checkUpload sync baseTime");
            this.f13654l.e(true);
            this.f13660r.f(new g0());
            return;
        }
        if (!br.g.E()) {
            a0.b("%s", "checkUpload sdk disable or gaid invalid");
            String strI = m0.a(ws.a.a()).i("gdpr_close");
            if (TextUtils.isEmpty(strI) || (x0Var = this.f13660r) == null) {
                return;
            }
            x0Var.f(new x(strI));
            return;
        }
        if (!GslbSdk.isInitSuccess(br.g.B())) {
            a0.b("%s", "checkUpload GSLB is not ready");
            return;
        }
        if (br.d.k(this.f13651i.o())) {
            a0.b("%s", "checkUpload global config is not ready");
            return;
        }
        List<AppIdData> listQ = this.f13650h.q();
        if (br.d.k(listQ)) {
            List<br.b> listD = this.f13651i.d();
            if (br.d.k(listD)) {
                a0.b("%s", "checkUpload appid config list is null");
                return;
            }
            Iterator<br.b> it = listD.iterator();
            while (it.hasNext()) {
                AppIdData appIdDataA = AppIdData.a(ws.a.a(), it.next().a());
                if (listQ == null) {
                    listQ = new ArrayList<>();
                }
                listQ.add(appIdDataA);
                this.f13650h.i(appIdDataA);
            }
        }
        HashSet<String> hashSet = new HashSet();
        for (AppIdData appIdData : listQ) {
            br.b bVarL = this.f13651i.l(appIdData.f50747a);
            if (bVarL != null) {
                String domain = TextUtils.isEmpty(bVarL.u()) ? GslbSdk.getDomain(br.g.B(), true) : GslbSdk.getDomain(br.g.b(bVarL.u()), true);
                appIdData.f50752f = domain;
                hashSet.add(domain);
            }
        }
        this.f13660r.e(hashSet.size());
        for (String str : hashSet) {
            x0 x0Var2 = this.f13660r;
            x0Var2.f(new c0(str, x0Var2, this.f13650h, listQ, this.f13651i, this.f13654l, this.f13645b, this.f13655m));
        }
    }

    public final void O() {
        ArrayList<cr.a> arrayList = new ArrayList<>();
        for (cr.a aVar : this.f13652j) {
            if (this.f13651i.b(aVar.e()) == 0) {
                this.f13654l.d(aVar);
                arrayList.add(aVar);
            }
        }
        if (arrayList.size() > 0) {
            int iC = this.f13650h.c(arrayList, new l0() { // from class: athena.p
                @Override // athena.l0
                public final void a(Object obj) {
                    this.f13734a.r((LongSparseArray) obj);
                }
            });
            a0.f("saveMemCacheToDb tidCount [%d]", Integer.valueOf(iC));
            if (iC == -2) {
                a0.d("saveToDB out of memory cleanCount [%d]", Integer.valueOf(this.f13650h.a(1000, new l0() { // from class: athena.q
                    @Override // athena.l0
                    public final void a(Object obj) {
                        h.y((String) obj);
                    }
                })));
            }
            D(false, this.f13646c);
        }
    }

    public final void P() throws Throwable {
        this.f13657o = j0.r(ws.a.a());
        this.f13648f.postDelayed(new b(), 3600000L);
        j0.j(ws.a.a());
        this.f13660r = new x0(this.f13648f, 1);
        u0 u0VarB = u0.b(ws.a.a());
        this.f13654l = u0VarB;
        u0VarB.h();
        ar.a aVarA = ar.b.a();
        this.f13651i = aVarA;
        aVarA.s();
        z zVar = new z();
        this.f13650h = zVar;
        zVar.g(new l0() { // from class: athena.o
            @Override // athena.l0
            public final void a(Object obj) {
                this.f13731a.s((SparseArray) obj);
            }
        });
        AthenaAnalytics.y();
        if (j0.t(ws.a.a())) {
            a0.f("%s", "Current device support DCS");
            L();
        } else {
            a0.f("%s", "Current device doesn't support DCS");
        }
        GslbSdk.init(ws.a.a(), j.f13692a, new c());
        Handler handler = this.f13648f;
        handler.postDelayed(new athena.g(handler), 7200000L);
        try {
            m0 m0VarA = m0.a(ws.a.a());
            for (Integer num : cr.b.a()) {
                String str = "first_page_enter_" + num;
                if (m0VarA.d(str)) {
                    this.f13655m.put(num.intValue(), m0VarA.i(str));
                }
            }
            File filesDir = ws.a.a().getFilesDir();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(filesDir);
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append(br.g.f14358k);
            File file = new File(sb2.toString());
            File file2 = new File(filesDir + str2 + br.g.f14359l);
            if (AthenaAnalytics.H()) {
                this.f13645b = true;
            } else if (file.exists()) {
                String[] list = file.list();
                if (list != null && list.length != 0) {
                    this.f13645b = true;
                } else if (file.delete()) {
                    a0.b("%s", "dataFile deleted");
                }
            }
            if (file2.exists()) {
                v.h(file2.getPath());
            }
        } catch (Exception e11) {
            a0.b("%s", e11.getMessage());
            A("handleInit", e11);
        }
        Message messageObtainMessage = this.f13648f.obtainMessage(502);
        messageObtainMessage.arg1 = 1;
        this.f13648f.sendMessageDelayed(messageObtainMessage, 3000L);
        if (this.f13647d) {
            return;
        }
        this.f13646c = ar.b.a().r() * 1000;
    }

    @Override // athena.l
    public void b() {
        Handler handler = this.f13648f;
        if (handler != null) {
            this.f13648f.sendMessageAtFrontOfQueue(handler.obtainMessage(308));
        }
    }

    @Override // athena.l
    public void c(int i11) {
        this.f13646c = Math.max(i11, 2000);
        this.f13647d = true;
    }

    @Override // athena.l
    public void d(Message message, long j11) {
        Handler handler = this.f13648f;
        if (handler != null) {
            if (j11 > 0) {
                handler.removeMessages(message.what);
            }
            this.f13648f.sendMessageDelayed(message, j11);
        }
    }

    @Override // athena.l
    public void e(Runnable runnable) {
        Handler handler = this.f13648f;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    @Override // athena.l
    public void f(String str, TrackData trackData, long j11) {
        cr.a aVar = new cr.a();
        aVar.k(str);
        aVar.n(j11);
        aVar.r(System.currentTimeMillis());
        aVar.p(SystemClock.elapsedRealtime());
        aVar.o(trackData);
        int i11 = this.f13649g;
        if (i11 < 5000) {
            this.f13649g = i11 + 1;
            Message messageObtainMessage = this.f13648f.obtainMessage(302);
            messageObtainMessage.obj = aVar;
            this.f13648f.sendMessage(messageObtainMessage);
        }
    }

    @Override // athena.l
    public void g() {
        x0 x0Var = this.f13660r;
        if (x0Var != null) {
            x0Var.h();
        }
    }

    @Override // athena.l
    public void h() {
        D(true, this.f13646c);
    }

    /* JADX WARN: Code duplicated, block: B:112:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:115:0x0200 A[Catch: Exception -> 0x005e, TryCatch #0 {Exception -> 0x005e, blocks: (B:3:0x0008, B:21:0x0032, B:23:0x0042, B:25:0x0052, B:27:0x0058, B:30:0x0061, B:31:0x0069, B:35:0x0070, B:36:0x0075, B:38:0x007f, B:39:0x0082, B:42:0x0088, B:43:0x0095, B:54:0x00b6, B:55:0x00bd, B:57:0x00d8, B:58:0x00e9, B:67:0x0119, B:69:0x011f, B:71:0x0128, B:73:0x0137, B:75:0x013f, B:77:0x0145, B:82:0x0156, B:84:0x015a, B:86:0x0160, B:87:0x0165, B:89:0x016b, B:90:0x017f, B:92:0x018d, B:94:0x019e, B:98:0x01c0, B:100:0x01c9, B:102:0x01cd, B:104:0x01d1, B:106:0x01d7, B:108:0x01e9, B:110:0x01f0, B:117:0x0206, B:119:0x020a, B:121:0x020e, B:123:0x0212, B:125:0x0222, B:127:0x0229, B:129:0x0233, B:113:0x01f6, B:115:0x0200, B:116:0x0203, B:80:0x014d, B:81:0x0151, B:97:0x01b5, B:66:0x0112, B:130:0x0238, B:131:0x023c, B:133:0x0240, B:134:0x0243, B:136:0x024b, B:138:0x025f, B:141:0x0265, B:142:0x028c, B:45:0x00a3, B:47:0x00a7, B:50:0x00ad, B:52:0x00b1, B:59:0x00f1, B:61:0x00fd, B:63:0x0103), top: B:150:0x0008, inners: #1, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x023c A[Catch: Exception -> 0x005e, TryCatch #0 {Exception -> 0x005e, blocks: (B:3:0x0008, B:21:0x0032, B:23:0x0042, B:25:0x0052, B:27:0x0058, B:30:0x0061, B:31:0x0069, B:35:0x0070, B:36:0x0075, B:38:0x007f, B:39:0x0082, B:42:0x0088, B:43:0x0095, B:54:0x00b6, B:55:0x00bd, B:57:0x00d8, B:58:0x00e9, B:67:0x0119, B:69:0x011f, B:71:0x0128, B:73:0x0137, B:75:0x013f, B:77:0x0145, B:82:0x0156, B:84:0x015a, B:86:0x0160, B:87:0x0165, B:89:0x016b, B:90:0x017f, B:92:0x018d, B:94:0x019e, B:98:0x01c0, B:100:0x01c9, B:102:0x01cd, B:104:0x01d1, B:106:0x01d7, B:108:0x01e9, B:110:0x01f0, B:117:0x0206, B:119:0x020a, B:121:0x020e, B:123:0x0212, B:125:0x0222, B:127:0x0229, B:129:0x0233, B:113:0x01f6, B:115:0x0200, B:116:0x0203, B:80:0x014d, B:81:0x0151, B:97:0x01b5, B:66:0x0112, B:130:0x0238, B:131:0x023c, B:133:0x0240, B:134:0x0243, B:136:0x024b, B:138:0x025f, B:141:0x0265, B:142:0x028c, B:45:0x00a3, B:47:0x00a7, B:50:0x00ad, B:52:0x00b1, B:59:0x00f1, B:61:0x00fd, B:63:0x0103), top: B:150:0x0008, inners: #1, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x0240 A[Catch: Exception -> 0x005e, TryCatch #0 {Exception -> 0x005e, blocks: (B:3:0x0008, B:21:0x0032, B:23:0x0042, B:25:0x0052, B:27:0x0058, B:30:0x0061, B:31:0x0069, B:35:0x0070, B:36:0x0075, B:38:0x007f, B:39:0x0082, B:42:0x0088, B:43:0x0095, B:54:0x00b6, B:55:0x00bd, B:57:0x00d8, B:58:0x00e9, B:67:0x0119, B:69:0x011f, B:71:0x0128, B:73:0x0137, B:75:0x013f, B:77:0x0145, B:82:0x0156, B:84:0x015a, B:86:0x0160, B:87:0x0165, B:89:0x016b, B:90:0x017f, B:92:0x018d, B:94:0x019e, B:98:0x01c0, B:100:0x01c9, B:102:0x01cd, B:104:0x01d1, B:106:0x01d7, B:108:0x01e9, B:110:0x01f0, B:117:0x0206, B:119:0x020a, B:121:0x020e, B:123:0x0212, B:125:0x0222, B:127:0x0229, B:129:0x0233, B:113:0x01f6, B:115:0x0200, B:116:0x0203, B:80:0x014d, B:81:0x0151, B:97:0x01b5, B:66:0x0112, B:130:0x0238, B:131:0x023c, B:133:0x0240, B:134:0x0243, B:136:0x024b, B:138:0x025f, B:141:0x0265, B:142:0x028c, B:45:0x00a3, B:47:0x00a7, B:50:0x00ad, B:52:0x00b1, B:59:0x00f1, B:61:0x00fd, B:63:0x0103), top: B:150:0x0008, inners: #1, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:136:0x024b A[Catch: Exception -> 0x005e, TryCatch #0 {Exception -> 0x005e, blocks: (B:3:0x0008, B:21:0x0032, B:23:0x0042, B:25:0x0052, B:27:0x0058, B:30:0x0061, B:31:0x0069, B:35:0x0070, B:36:0x0075, B:38:0x007f, B:39:0x0082, B:42:0x0088, B:43:0x0095, B:54:0x00b6, B:55:0x00bd, B:57:0x00d8, B:58:0x00e9, B:67:0x0119, B:69:0x011f, B:71:0x0128, B:73:0x0137, B:75:0x013f, B:77:0x0145, B:82:0x0156, B:84:0x015a, B:86:0x0160, B:87:0x0165, B:89:0x016b, B:90:0x017f, B:92:0x018d, B:94:0x019e, B:98:0x01c0, B:100:0x01c9, B:102:0x01cd, B:104:0x01d1, B:106:0x01d7, B:108:0x01e9, B:110:0x01f0, B:117:0x0206, B:119:0x020a, B:121:0x020e, B:123:0x0212, B:125:0x0222, B:127:0x0229, B:129:0x0233, B:113:0x01f6, B:115:0x0200, B:116:0x0203, B:80:0x014d, B:81:0x0151, B:97:0x01b5, B:66:0x0112, B:130:0x0238, B:131:0x023c, B:133:0x0240, B:134:0x0243, B:136:0x024b, B:138:0x025f, B:141:0x0265, B:142:0x028c, B:45:0x00a3, B:47:0x00a7, B:50:0x00ad, B:52:0x00b1, B:59:0x00f1, B:61:0x00fd, B:63:0x0103), top: B:150:0x0008, inners: #1, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:142:0x028c A[Catch: Exception -> 0x005e, TRY_LEAVE, TryCatch #0 {Exception -> 0x005e, blocks: (B:3:0x0008, B:21:0x0032, B:23:0x0042, B:25:0x0052, B:27:0x0058, B:30:0x0061, B:31:0x0069, B:35:0x0070, B:36:0x0075, B:38:0x007f, B:39:0x0082, B:42:0x0088, B:43:0x0095, B:54:0x00b6, B:55:0x00bd, B:57:0x00d8, B:58:0x00e9, B:67:0x0119, B:69:0x011f, B:71:0x0128, B:73:0x0137, B:75:0x013f, B:77:0x0145, B:82:0x0156, B:84:0x015a, B:86:0x0160, B:87:0x0165, B:89:0x016b, B:90:0x017f, B:92:0x018d, B:94:0x019e, B:98:0x01c0, B:100:0x01c9, B:102:0x01cd, B:104:0x01d1, B:106:0x01d7, B:108:0x01e9, B:110:0x01f0, B:117:0x0206, B:119:0x020a, B:121:0x020e, B:123:0x0212, B:125:0x0222, B:127:0x0229, B:129:0x0233, B:113:0x01f6, B:115:0x0200, B:116:0x0203, B:80:0x014d, B:81:0x0151, B:97:0x01b5, B:66:0x0112, B:130:0x0238, B:131:0x023c, B:133:0x0240, B:134:0x0243, B:136:0x024b, B:138:0x025f, B:141:0x0265, B:142:0x028c, B:45:0x00a3, B:47:0x00a7, B:50:0x00ad, B:52:0x00b1, B:59:0x00f1, B:61:0x00fd, B:63:0x0103), top: B:150:0x0008, inners: #1, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0137 A[Catch: Exception -> 0x005e, JSONException -> 0x014b, TryCatch #2 {JSONException -> 0x014b, blocks: (B:67:0x0119, B:69:0x011f, B:71:0x0128, B:73:0x0137, B:75:0x013f, B:77:0x0145, B:82:0x0156, B:84:0x015a, B:86:0x0160, B:87:0x0165, B:89:0x016b, B:90:0x017f, B:92:0x018d, B:94:0x019e, B:80:0x014d, B:81:0x0151), top: B:153:0x0119, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x014d A[Catch: Exception -> 0x005e, JSONException -> 0x014b, TryCatch #2 {JSONException -> 0x014b, blocks: (B:67:0x0119, B:69:0x011f, B:71:0x0128, B:73:0x0137, B:75:0x013f, B:77:0x0145, B:82:0x0156, B:84:0x015a, B:86:0x0160, B:87:0x0165, B:89:0x016b, B:90:0x017f, B:92:0x018d, B:94:0x019e, B:80:0x014d, B:81:0x0151), top: B:153:0x0119, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0151 A[Catch: Exception -> 0x005e, JSONException -> 0x014b, TryCatch #2 {JSONException -> 0x014b, blocks: (B:67:0x0119, B:69:0x011f, B:71:0x0128, B:73:0x0137, B:75:0x013f, B:77:0x0145, B:82:0x0156, B:84:0x015a, B:86:0x0160, B:87:0x0165, B:89:0x016b, B:90:0x017f, B:92:0x018d, B:94:0x019e, B:80:0x014d, B:81:0x0151), top: B:153:0x0119, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x016b A[Catch: Exception -> 0x005e, JSONException -> 0x014b, LOOP:0: B:87:0x0165->B:89:0x016b, LOOP_END, TryCatch #2 {JSONException -> 0x014b, blocks: (B:67:0x0119, B:69:0x011f, B:71:0x0128, B:73:0x0137, B:75:0x013f, B:77:0x0145, B:82:0x0156, B:84:0x015a, B:86:0x0160, B:87:0x0165, B:89:0x016b, B:90:0x017f, B:92:0x018d, B:94:0x019e, B:80:0x014d, B:81:0x0151), top: B:153:0x0119, outer: #0 }] */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        Context contextA;
        long j11;
        long j12;
        br.b bVarL;
        JSONObject jSONObjectA;
        Object jSONObject;
        JSONArray jSONArrayNames;
        int i11;
        this.f13644a = true;
        try {
            int i12 = message.what;
            if (i12 == 298) {
                if (message.arg1 == 1) {
                    M();
                }
                if (!this.f13648f.hasMessages(299)) {
                    contextA = ws.a.a();
                    String str = j0.f13693a;
                    if (TextUtils.isEmpty(m0.a(contextA).i("first_init")) || !br.g.H) {
                        Handler handler = this.f13648f;
                        handler.sendMessageAtFrontOfQueue(Message.obtain(handler, 299));
                    } else {
                        a0.b("First init delay %d s upload!", Integer.valueOf(AthenaAnalytics.f51932o));
                        this.f13648f.sendEmptyMessageDelayed(299, ((long) AthenaAnalytics.f51932o) * 1000);
                        m0.a(ws.a.a()).g("first_init", "false");
                    }
                }
            } else if (i12 == 299) {
                N();
            } else if (i12 == 302) {
                cr.a aVar = (cr.a) message.obj;
                TrackData trackDataF = aVar.f();
                try {
                    if (!aVar.b().equals("page_enter") || w.e() == null) {
                        try {
                            jSONObjectA = trackDataF.a();
                            B(jSONObjectA, "_scr_type", j0.v());
                            B(jSONObjectA, "_fold_state", j0.p());
                            String str2 = br.g.f14348a;
                            if (jSONObjectA.has("_eparam")) {
                                jSONObject = jSONObjectA.get("_eparam");
                                if ((jSONObject instanceof JSONArray) || jSONObjectA.length() <= 1) {
                                    jSONObjectA.remove("_eparam");
                                } else {
                                    jSONObject = new JSONObject();
                                }
                            } else {
                                jSONObject = new JSONObject();
                            }
                            if ((jSONObject instanceof JSONObject) && jSONObjectA.length() > 0) {
                                jSONArrayNames = jSONObjectA.names();
                                for (i11 = 0; i11 < jSONArrayNames.length(); i11++) {
                                    String string = jSONArrayNames.getString(i11);
                                    ((JSONObject) jSONObject).put(string, jSONObjectA.get(string));
                                    jSONObjectA.remove(string);
                                }
                            }
                            JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                            jSONObjectA.put("_eparam", jSONObject);
                            jSONObjectA.put("net", j0.b(ws.a.a()).ordinal());
                            jSONObjectA.put(NotificationCompat.CATEGORY_EVENT, aVar.b());
                            aVar.l(jSONObjectA);
                            aVar.m(jSONObject2);
                            aVar.q(trackDataF.c());
                        } catch (JSONException e11) {
                            a0.d("Record track exception : %s", e11.getMessage());
                        }
                        this.f13649g--;
                        if (this.f13657o && this.f13658p && br.g.O && !AthenaAnalytics.H() && ((bVarL = ar.b.a().l(j0.a(aVar.e()))) == null || bVarL.o() == 2)) {
                            G(aVar);
                        } else {
                            if (!"ev_athena".equals(aVar.b())) {
                                M();
                            }
                            w(aVar);
                        }
                        if (!this.f13657o && !this.f13658p && br.g.O) {
                            j11 = this.f13659q + 1;
                            this.f13659q = j11;
                            j12 = 20;
                            if (j11 % j12 == 0 && j11 / j12 <= 5 && j0.t(ws.a.a())) {
                                L();
                            }
                        }
                    } else {
                        trackDataF.add("fromsite", w.a(w.e()));
                        jSONObjectA = trackDataF.a();
                        B(jSONObjectA, "_scr_type", j0.v());
                        B(jSONObjectA, "_fold_state", j0.p());
                        String str3 = br.g.f14348a;
                        if (jSONObjectA.has("_eparam")) {
                            jSONObject = jSONObjectA.get("_eparam");
                            if (jSONObject instanceof JSONArray) {
                                jSONObjectA.remove("_eparam");
                            } else {
                                jSONObjectA.remove("_eparam");
                            }
                        } else {
                            jSONObject = new JSONObject();
                        }
                        if (jSONObject instanceof JSONObject) {
                            jSONArrayNames = jSONObjectA.names();
                            while (i11 < jSONArrayNames.length()) {
                                String string2 = jSONArrayNames.getString(i11);
                                ((JSONObject) jSONObject).put(string2, jSONObjectA.get(string2));
                                jSONObjectA.remove(string2);
                            }
                        }
                        JSONObject jSONObject3 = new JSONObject(jSONObject.toString());
                        jSONObjectA.put("_eparam", jSONObject);
                        jSONObjectA.put("net", j0.b(ws.a.a()).ordinal());
                        jSONObjectA.put(NotificationCompat.CATEGORY_EVENT, aVar.b());
                        aVar.l(jSONObjectA);
                        aVar.m(jSONObject3);
                        aVar.q(trackDataF.c());
                        this.f13649g--;
                        if (this.f13657o) {
                            if (!"ev_athena".equals(aVar.b())) {
                                M();
                            }
                            w(aVar);
                        } else {
                            if (!"ev_athena".equals(aVar.b())) {
                                M();
                            }
                            w(aVar);
                        }
                        if (!this.f13657o) {
                            j11 = this.f13659q + 1;
                            this.f13659q = j11;
                            j12 = 20;
                            if (j11 % j12 == 0) {
                                L();
                            }
                        }
                    }
                } catch (Exception e12) {
                    a0.c(Log.getStackTraceString(e12));
                }
            } else if (i12 == 303) {
                ws.a.b(AthenaAnalytics.f51929l);
                ws.a.e(br.g.D());
                a0.f13598a.m().r(br.g.D());
                a0.f("Athena init, SDK Version is [%s]", "3.0.0.5");
                P();
                M();
            } else if (i12 == 308) {
                try {
                    ar.a aVar2 = this.f13651i;
                    if (aVar2 != null) {
                        aVar2.u();
                    }
                    z zVar = this.f13650h;
                    if (zVar != null) {
                        zVar.e();
                    }
                } catch (Exception e13) {
                    A("handleCleanupData", e13);
                }
            } else if (i12 == 400) {
                int i13 = message.arg1;
                String str4 = (String) message.obj;
                ar.a aVar3 = this.f13651i;
                if (aVar3 != null) {
                    aVar3.e(i13);
                }
                z zVar2 = this.f13650h;
                if (zVar2 != null) {
                    if (str4 == null) {
                        zVar2.i(AppIdData.a(ws.a.a(), i13));
                    } else {
                        AppIdData appIdData = new AppIdData();
                        appIdData.f50747a = i13;
                        appIdData.f50748b = str4;
                        zVar2.i(appIdData);
                    }
                }
            } else if (i12 == 600) {
                if (message.arg1 == 1) {
                    M();
                }
                if (!this.f13648f.hasMessages(299)) {
                    contextA = ws.a.a();
                    String str5 = j0.f13693a;
                    if (TextUtils.isEmpty(m0.a(contextA).i("first_init"))) {
                        Handler handler2 = this.f13648f;
                        handler2.sendMessageAtFrontOfQueue(Message.obtain(handler2, 299));
                    } else {
                        Handler handler3 = this.f13648f;
                        handler3.sendMessageAtFrontOfQueue(Message.obtain(handler3, 299));
                    }
                }
            } else if (i12 == 502) {
                C(message.arg1 == 1);
            } else if (i12 == 503) {
                if (this.f13654l.f(((Long) message.obj).longValue())) {
                    String strC = this.f13654l.c();
                    long jG = this.f13654l.g();
                    if (jG > 0 && !TextUtils.isEmpty(strC)) {
                        this.f13650h.j(strC, jG);
                    }
                }
                D(false, this.f13646c);
            }
        } catch (Exception e14) {
            if (j0.w()) {
                a0.d("Worker handle message exception : %s", e14.getMessage());
            }
            A("handleMessage", e14);
        }
        this.f13644a = false;
        return false;
    }

    public final void p(int i11, boolean z11) {
        br.b bVarL = this.f13651i.l(i11);
        a0.b("handleTidChange appconf : %s", bVarL.z());
        this.f13650h.h(bVarL, z11);
        String strU = bVarL.u();
        if (!TextUtils.isEmpty(strU)) {
            if (GslbSdk.isInitSuccess(strU)) {
                z(strU, i11, bVarL, this.f13656n);
            } else {
                GslbSdk.init(ws.a.a(), new String[]{strU}, new d(strU, i11, bVarL));
            }
            GslbSdk.getDomain(strU, new e(this));
        }
        if (z11) {
            List<br.a> listW = bVarL.w();
            if (br.d.k(listW)) {
                a0.f("%s", "handleTidChange tid config is null");
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (br.a aVar : listW) {
                if (aVar.e().t() == -1) {
                    arrayList.add(Long.valueOf(aVar.d()));
                }
            }
            if (!arrayList.isEmpty()) {
                try {
                    this.f13650h.o(arrayList, this.f13645b, new l0() { // from class: athena.r
                        @Override // athena.l0
                        public final void a(Object obj) {
                            h.H((String) obj);
                        }
                    });
                } catch (Exception e11) {
                    a0.d("Handle tid change exception : %s", e11.getMessage());
                    A("handleTidChange", e11);
                }
            }
            AthenaAnalytics.y();
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:? A[RETURN, SYNTHETIC] */
    @SuppressLint({"MissingPermission"})
    public final void q(Location location) {
        boolean z11;
        TrackData trackData = new TrackData();
        if (location != null) {
            BigDecimal bigDecimalValueOf = BigDecimal.valueOf(location.getLongitude());
            RoundingMode roundingMode = RoundingMode.HALF_UP;
            double dDoubleValue = bigDecimalValueOf.setScale(2, roundingMode).doubleValue();
            double dDoubleValue2 = BigDecimal.valueOf(location.getLatitude()).setScale(2, roundingMode).doubleValue();
            trackData.add("lng", dDoubleValue).add("lat", dDoubleValue2);
            try {
                trackData.add("geono", s0.a(dDoubleValue2, dDoubleValue, this.f13651i.j()).b());
            } catch (Exception e11) {
                a0.c(Log.getStackTraceString(e11));
            }
            z11 = true;
        } else {
            trackData.add("lng", 0).add("lat", 0);
            z11 = false;
        }
        if (j0.g(ws.a.a(), "android.permission.ACCESS_FINE_LOCATION")) {
            List<r0> listC = com.transsion.ga.g.c(ws.a.a());
            JSONArray jSONArray = new JSONArray();
            for (r0 r0Var : (ArrayList) listC) {
                try {
                    jSONArray.put(new JSONObject().put("cellid", r0Var.a()).put("level", r0Var.f13741e));
                } catch (JSONException e12) {
                    a0.d("%s", Log.getStackTraceString(e12));
                }
            }
            if (jSONArray.length() > 0) {
                trackData.add("cellidlist", jSONArray.toString());
            } else {
                trackData.add("cellidlist", "");
                if (!z11) {
                    return;
                }
            }
        } else if (!z11) {
            return;
        }
        AthenaAnalytics.z(9999).Q(RequestParameters.SUBRESOURCE_LOCATION, trackData, 9999);
    }

    public final /* synthetic */ void r(LongSparseArray longSparseArray) {
        a0.f("saveMemCacheToDb tidCountArray : %s", longSparseArray);
        this.f13652j.clear();
        for (int i11 = 0; i11 < longSparseArray.size(); i11++) {
            long jKeyAt = longSparseArray.keyAt(i11);
            br.a aVarN = this.f13651i.n(jKeyAt);
            if (aVarN != null) {
                aVarN.e().b(((Integer) longSparseArray.valueAt(i11)).intValue());
                if ("device".equals(aVarN.c()) && 9999 == j0.a(jKeyAt)) {
                    this.f13651i.v();
                }
            }
        }
    }

    public final /* synthetic */ void s(SparseArray sparseArray) {
        ArrayList arrayList = new ArrayList(sparseArray.size());
        for (int i11 = 0; i11 < sparseArray.size(); i11++) {
            arrayList.add((br.b) sparseArray.valueAt(i11));
        }
        this.f13651i.i(arrayList);
    }

    public final void w(cr.a aVar) {
        br.a aVarK;
        int iA = j0.a(aVar.e());
        if (!"".equals(this.f13655m.get(iA, null)) && "page_enter".equals(aVar.b())) {
            try {
                String string = new JSONObject().put(NotificationCompat.CATEGORY_EVENT, aVar.b()).put("ts", aVar.i()).put("tid", aVar.e()).put("net", aVar.c().getInt("net")).put("eparam", aVar.c().getJSONObject("_eparam").toString()).toString();
                this.f13655m.put(iA, string);
                m0.a(ws.a.a()).g("first_page_enter_" + iA, string);
                a0.b("save [%d] fpe to sp : %s", Integer.valueOf(iA), string);
                return;
            } catch (Exception e11) {
                a0.d("saveFpeForAppId exception : %s", e11.getMessage());
            }
        }
        if (!br.g.E()) {
            a0.f("%s", "Athena SDK Enable : [false]");
            return;
        }
        String string2 = aVar.c().toString();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SafeStringUtils.SP_APPID, j0.a(aVar.e()));
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, aVar.b());
            jSONObject.put("ts", aVar.i());
            jSONObject.put("params", aVar.c());
            a0.f("track event:%s", jSONObject.toString().replace("\\", ""));
        } catch (Exception e12) {
            a0.d("handleSaveData exception:%s", e12.getMessage());
        }
        if (string2.length() >= 716800) {
            a0.d("track [%d]-[%s], save2DB failed due to eparam out of limit [%d]", Long.valueOf(aVar.e()), aVar.b(), 716800);
            return;
        }
        if ("app_launch".equals(aVar.b())) {
            m0 m0VarA = m0.a(ws.a.a());
            String str = "app_launch_" + j0.a(aVar.e());
            int iE = m0VarA.e(str);
            if (iE == 0 || Math.abs((aVar.i() / 1000) - ((long) iE)) > 7200000) {
                m0VarA.b(str, Long.valueOf(aVar.i() / 1000).intValue());
            }
        }
        if (aVar.e() > 9999) {
            aVarK = this.f13651i.n(aVar.e());
        } else {
            aVarK = this.f13651i.k((int) aVar.e(), aVar.b());
            if (aVarK != null) {
                aVar.n(aVarK.d());
            }
        }
        br.a aVar2 = aVarK;
        boolean z11 = aVar.h() == 0 && aVar2 != null && aVar2.g();
        int iW = br.g.w();
        if (iW <= 0 || !z11) {
            x(aVar, aVar2);
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("tid", aVar.e());
            jSONObject2.put(NotificationCompat.CATEGORY_EVENT, aVar.b());
            a0.f("save event to memory:%s", jSONObject2.toString().replace("\\", ""));
        } catch (Exception e13) {
            a0.d("print saveTrack2Mem exception:%s", e13.getMessage());
        }
        if (this.f13652j == null) {
            this.f13652j = new ArrayList<>();
        }
        if (this.f13652j.size() >= iW - 1) {
            this.f13652j.add(aVar);
            O();
            this.f13653k = 0L;
            return;
        }
        long jI = aVar.i();
        if (!aVar2.a(jI)) {
            a0.f("save [%d]-[%s] to DB failed due to limit in one-life-cycle", Long.valueOf(aVar.e()), aVar.b());
            return;
        }
        aVar2.j(jI);
        this.f13652j.add(aVar);
        long j11 = this.f13653k;
        if (j11 == 0) {
            this.f13653k = jI;
        } else if (jI - j11 >= TTAdConstant.AD_MAX_EVENT_TIME) {
            O();
            this.f13653k = 0L;
        }
    }

    public final void x(cr.a aVar, br.a aVar2) {
        int iB;
        if ((aVar.e() > 9999 ? this.f13651i.b(aVar.e()) : this.f13651i.a((int) aVar.e(), aVar.b())) != 0) {
            AthenaAnalytics.B();
            return;
        }
        if (aVar2 == null || aVar2.a(aVar.i())) {
            this.f13654l.d(aVar);
            iB = this.f13650h.b(aVar);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tid", aVar.e());
                jSONObject.put(NotificationCompat.CATEGORY_EVENT, aVar.b());
                jSONObject.put("ts", aVar.i());
                jSONObject.put("db_count", iB);
                a0.f("save event to DB:%s", jSONObject.toString().replace("\\", ""));
            } catch (Exception e11) {
                a0.d("saveTrack2DB exception:%s", e11.getMessage());
            }
        } else {
            a0.d("save [%d]-[%s] to DB failed due to limit in one-life-cycle", Long.valueOf(aVar.e()), aVar.b());
            iB = 0;
        }
        if (iB == -1) {
            AthenaAnalytics.B();
        } else if (iB == -2) {
            a0.f("%s", "save [%d]-[%s] to DB failed due to DB_OUT_OF_MEMORY_ERROR");
            a0.f("Clean up DB due to DB_OUT_OF_MEMORY_ERROR, Count [%d]", Integer.valueOf(this.f13650h.a(1000, new l0() { // from class: athena.s
                @Override // athena.l0
                public final void a(Object obj) {
                    h.J((String) obj);
                }
            })));
        }
        if ("ev_athena".equals(aVar.b())) {
            return;
        }
        if (iB > 0) {
            if (aVar2 != null) {
                aVar2.j(aVar.i());
                aVar2.e().b(iB);
            }
            AthenaAnalytics.B();
            if ("device".equals(aVar.b()) && 9999 == j0.a(aVar.e())) {
                this.f13651i.v();
            }
        }
        D(false, this.f13646c);
    }

    public final void z(String str, int i11, br.b bVar, String str2) {
        String domain = TextUtils.isEmpty(str) ? GslbSdk.getDomain(br.g.B(), true) : GslbSdk.getDomain(br.g.b(str), true);
        Bundle bundle = new Bundle();
        bundle.putInt("app_id", i11);
        bundle.putString("url", domain);
        bundle.putLong("ver", bVar.x());
        bundle.putString("gslb_data", str2);
        new dr.a("app_cfg_log", 9999).c(bundle, null).b();
    }
}
