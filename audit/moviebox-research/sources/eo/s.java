package eo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.google.common.util.concurrent.Futures;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class s extends p007do.n {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f64304n = TimeUnit.MINUTES.toMillis(5);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f64305o = TimeUnit.SECONDS.toMillis(35);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f64306p = TimeUnit.DAYS.toMillis(2);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f64307q = io.d.a(0);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f64308r = io.d.a(1);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f64309s = io.d.a(2);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f64310t = io.d.a(3);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f64311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fo.f f64312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final go.i f64313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ho.d f64314f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ho.j f64315g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final z f64316h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ConcurrentHashMap f64317i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f64318j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.google.common.util.concurrent.s f64319k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.google.common.util.concurrent.t f64320l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f64321m;

    public s(p007do.m mVar, int i11) {
        super("anti-fraud", mVar);
        this.f64311c = i11;
        this.f64312d = (fo.f) mVar.A(fo.f.class);
        this.f64313e = (go.i) mVar.A(go.i.class);
        this.f64314f = (ho.d) mVar.A(ho.d.class);
        this.f64315g = (ho.j) mVar.A(ho.j.class);
        this.f64316h = new z(this);
        this.f64317i = new ConcurrentHashMap();
        this.f64318j = new a("", 0, 1.0f);
    }

    public static do.n.a<s> E(int i11) {
        return new t(i11);
    }

    public static /* synthetic */ String n(TelephonyManager telephonyManager) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 34) {
            return telephonyManager.getPrimaryImei();
        }
        return i11 >= 26 ? telephonyManager.getImei() : telephonyManager.getDeviceId();
    }

    public static String o(androidx.core.util.l lVar) {
        try {
            return (String) lVar.get();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static do.n.a<s> ofProvider() {
        return E(0);
    }

    public static /* synthetic */ void v(p007do.u uVar, io.r rVar, String str, io.l lVar) {
        uVar.a(str);
        lVar.a(rVar);
        rVar.m(536870911, 1640531527);
        uVar.b(rVar.f());
    }

    public static /* synthetic */ void x(ByteArrayOutputStream byteArrayOutputStream, ByteBuffer byteBuffer) {
        byteArrayOutputStream.write(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() + byteBuffer.arrayOffset());
    }

    public final byte[] A(boolean z11, byte[] bArr) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final p007do.u uVar = new p007do.u(new androidx.core.util.a() { // from class: eo.g
            @Override // androidx.core.util.a
            public final void accept(Object obj) {
                s.x(byteArrayOutputStream, (ByteBuffer) obj);
            }
        });
        final io.r rVar = new io.r();
        try {
            Context contextQ = d().q();
            t(uVar);
            D(uVar, contextQ);
            C(uVar, contextQ);
            u(uVar, contextQ);
        } catch (Throwable unused) {
        }
        if (z11) {
            uVar.a("high");
            if (Build.VERSION.SDK_INT >= 24) {
                this.f64317i.forEach(new BiConsumer() { // from class: eo.h
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) {
                        s.v(uVar, rVar, (String) obj, (io.l) obj2);
                    }
                });
            } else {
                for (Map.Entry entry : this.f64317i.entrySet()) {
                    uVar.a((String) entry.getKey());
                    ((io.l) entry.getValue()).a(rVar);
                    rVar.m(536870911, 1640531527);
                    uVar.b(rVar.f());
                }
            }
        }
        if (bArr != null) {
            uVar.a("extra");
            rVar.h(1, bArr);
            uVar.b(rVar.f());
        }
        ByteBuffer byteBuffer = uVar.f63508b;
        if (uVar.f63509c != 0) {
            byteBuffer.flip();
            uVar.f63507a.accept(byteBuffer);
            byteBuffer.clear();
            for (int i11 = 0; i11 < 2; i11++) {
                byteBuffer.putInt(byteBuffer.getInt(i11 * 4) * 1640531527);
            }
            uVar.f63509c = 0L;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public final void B() {
        synchronized (this) {
            try {
                if (this.f64321m) {
                    return;
                }
                com.google.common.util.concurrent.s sVar = this.f64319k;
                this.f64319k = null;
                long jP = f64304n;
                a aVar = this.f64318j;
                String strQ = "";
                int iO = 0;
                try {
                    io.o oVar = new io.o((ByteBuffer) Futures.d(sVar));
                    while (oVar.b()) {
                        int iN = oVar.n();
                        if (iN == 1) {
                            aVar = (a) oVar.l(aVar);
                        } else if (iN == 2) {
                            jP = oVar.p();
                        } else if (iN == 3) {
                            strQ = oVar.q();
                        } else if (iN != 4) {
                            oVar.c();
                        } else {
                            iO = oVar.o();
                        }
                    }
                } catch (Throwable unused) {
                    jP = f64305o;
                }
                if (aVar != this.f64318j) {
                    this.f64318j = aVar;
                    c(aVar);
                    d().D("ogm_antifraud_prev_desc", aVar.c());
                }
                if (!strQ.isEmpty()) {
                    synchronized (this) {
                        try {
                            if (!this.f64321m) {
                                final com.google.common.util.concurrent.s sVarA = this.f64316h.a(iO, strQ);
                                sVarA.addListener(new Runnable() { // from class: eo.r
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f64302a.r(sVarA);
                                    }
                                }, d().n());
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                if (jP <= 0) {
                    jP = f64304n;
                }
                q(jP);
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final void C(p007do.u uVar, Context context) {
        int i11 = this.f64311c;
        int i12 = f64309s;
        if ((i11 & i12) != 0) {
            return;
        }
        uVar.a(i12 + "\u0001" + io.b.i(context.getContentResolver(), "android_id").trim() + "\u0001" + io.b.k("prop.sim1.imei").trim() + "\u0001" + io.b.k("ro.tranos.version").trim() + "\u0001" + io.b.k("ro.serialno").trim() + "\u0000");
    }

    public final void D(p007do.u uVar, Context context) {
        final TelephonyManager telephonyManager;
        int i11 = this.f64311c;
        int i12 = f64308r;
        if ((i11 & i12) == 0 && (telephonyManager = (TelephonyManager) io.a.e(context, TelephonyManager.class, "phone")) != null) {
            String strO = o(new androidx.core.util.l() { // from class: eo.i
                @Override // androidx.core.util.l
                public final Object get() {
                    return s.n(telephonyManager);
                }
            });
            int i13 = Build.VERSION.SDK_INT;
            String strO2 = "";
            String strO3 = i13 < 26 ? "" : o(new androidx.core.util.l() { // from class: eo.j
                @Override // androidx.core.util.l
                public final Object get() {
                    return telephonyManager.getSubscriberId();
                }
            });
            String strO4 = i13 < 26 ? "" : o(new androidx.core.util.l() { // from class: eo.k
                @Override // androidx.core.util.l
                public final Object get() {
                    return telephonyManager.getMeid();
                }
            });
            if (i13 < 26 ? io.a.c(context, "android.permission.READ_PHONE_STATE") : io.a.b(context, "android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS")) {
                strO2 = o(new androidx.core.util.l() { // from class: eo.l
                    @Override // androidx.core.util.l
                    public final Object get() {
                        return telephonyManager.getLine1Number();
                    }
                });
            }
            uVar.a(i12 + "\u0001" + strO + "\u0001" + strO3 + "\u0001" + strO4 + "\u0001" + strO2 + "\u0000");
        }
    }

    @Override // p007do.n
    public void a() {
        ArrayList arrayList = new ArrayList(2);
        synchronized (this) {
            try {
                if (this.f64321m) {
                    return;
                }
                this.f64321m = true;
                arrayList.add(this.f64320l);
                this.f64320l = null;
                arrayList.add(this.f64319k);
                this.f64319k = null;
                io.g.d(arrayList);
                this.f64316h.b();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // p007do.n
    public void e(Context context) {
        d().G(new androidx.core.util.a() { // from class: eo.n
            @Override // androidx.core.util.a
            public final void accept(Object obj) {
                this.f64298a.y((Map) obj);
            }
        });
        JSONObject jSONObjectY = d().y("ogm_antifraud_prev_desc", new JSONObject());
        if (jSONObjectY.length() > 0) {
            this.f64318j = new a(jSONObjectY.optString("_0", ""), jSONObjectY.optInt("_1", 0), (float) jSONObjectY.optDouble("_2", 1.0d));
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jMax = Math.max(d().z("ogm_antifraud_next_send", jCurrentTimeMillis) - jCurrentTimeMillis, 10L);
        q(jMax <= f64306p ? jMax : 10L);
    }

    public final /* synthetic */ void p() {
        z(null);
    }

    public final void q(long j11) {
        long jMin = Math.min(j11, f64306p);
        d().E("ogm_antifraud_next_send", System.currentTimeMillis() + jMin);
        synchronized (this) {
            try {
                if (!this.f64321m && this.f64320l == null) {
                    this.f64320l = d().n().schedule(new Runnable() { // from class: eo.p
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f64300a.p();
                        }
                    }, jMin, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void r(com.google.common.util.concurrent.s sVar) {
        byte[] bytes;
        try {
            bytes = (byte[]) sVar.get();
        } catch (InterruptedException | ExecutionException unused) {
            bytes = "X".getBytes(StandardCharsets.UTF_8);
        }
        if (bytes != null) {
            synchronized (this) {
                try {
                    com.google.common.util.concurrent.t tVar = this.f64320l;
                    if (tVar != null) {
                        tVar.cancel(false);
                        this.f64320l = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            z(bytes);
        }
    }

    public final /* synthetic */ void s(p007do.n nVar, io.l lVar) {
        this.f64317i.put(nVar.b(), lVar);
    }

    public final void t(p007do.u uVar) {
        int i11 = this.f64311c;
        int i12 = f64307q;
        if ((i11 & i12) != 0) {
            return;
        }
        uVar.a(i12 + "\u0001" + (Build.VERSION.SDK_INT < 26 ? Build.SERIAL : o(new androidx.core.util.l() { // from class: eo.m
            @Override // androidx.core.util.l
            public final Object get() {
                return Build.getSerial();
            }
        })) + "\u0000");
    }

    public final void u(p007do.u uVar, Context context) {
        int i11 = this.f64311c;
        int i12 = f64310t;
        if ((i11 & i12) != 0) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i12);
        sb2.append((char) 1);
        if (io.a.c(context, "android.permission.QUERY_ALL_PACKAGES")) {
            try {
                for (ApplicationInfo applicationInfo : context.getPackageManager().getInstalledApplications(0)) {
                    sb2.append((char) 1);
                    sb2.append(com.google.common.base.p.e(applicationInfo.packageName));
                }
            } catch (Throwable unused) {
            }
        }
        sb2.append((char) 0);
        uVar.a(sb2.toString());
    }

    public final void w(io.r rVar) throws PackageManager.NameNotFoundException {
        Context contextQ = d().q();
        PackageInfo packageInfo = contextQ.getPackageManager().getPackageInfo(d().i().c(), 4096);
        HashSet<String> hashSet = new HashSet();
        hashSet.add("android.permission.READ_CONTACTS");
        hashSet.add("android.permission.ACCESS_FINE_LOCATION");
        hashSet.add("android.permission.ACCESS_COARSE_LOCATION");
        hashSet.add("android.permission.INSTALL_LOCATION_PROVIDER");
        String[] strArr = packageInfo.requestedPermissions;
        if (strArr != null) {
            for (String str : strArr) {
                if (!com.google.common.base.p.b(str)) {
                    hashSet.add(str);
                }
            }
        }
        for (String str2 : hashSet) {
            if (io.a.c(contextQ, str2)) {
                rVar.u(102, str2);
            }
        }
    }

    public final /* synthetic */ void y(Map map) {
        if (Build.VERSION.SDK_INT >= 24) {
            map.forEach(new BiConsumer() { // from class: eo.o
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f64299a.s((p007do.n) obj, (io.l) obj2);
                }
            });
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            this.f64317i.put(((p007do.n) entry.getKey()).b(), (io.l) entry.getValue());
        }
    }

    public final void z(byte[] bArr) {
        io.r rVar = new io.r();
        rVar.q(1, d().i()).q(2, this.f64312d.j()).q(3, this.f64313e.j()).q(4, this.f64314f.o());
        try {
            w(rVar);
        } catch (Throwable unused) {
        }
        a aVar = this.f64318j;
        if (aVar != null) {
            if (!com.google.common.base.p.b(aVar.f())) {
                rVar.u(100, this.f64318j.f());
            }
            if (this.f64318j.g() == 2 && this.f64318j.d() < 0.5d) {
                rVar.h(101, A(false, bArr));
                bArr = null;
            }
        }
        if (bArr != null) {
            rVar.h(101, A(false, bArr));
        }
        synchronized (this) {
            this.f64320l = null;
            if (!this.f64321m && this.f64319k == null) {
                com.google.common.util.concurrent.s<ByteBuffer> sVarX = this.f64315g.x(32781292443756643L, rVar.f());
                this.f64319k = sVarX;
                sVarX.addListener(new Runnable() { // from class: eo.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f64301a.B();
                    }
                }, d().n());
            }
        }
    }
}
