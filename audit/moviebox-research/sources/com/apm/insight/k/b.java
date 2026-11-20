package com.apm.insight.k;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.apm.insight.CrashType;
import com.apm.insight.Npth;
import com.apm.insight.entity.Header;
import com.apm.insight.l.n;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.o;
import com.apm.insight.runtime.q;
import com.applovin.sdk.AppLovinMediationProvider;
import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile b f16850b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f16851a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private C0166b f16855f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private HashMap<String, C0166b> f16856g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<File> f16852c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<File> f16853d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f16854e = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f16857h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Runnable f16858i = new Runnable() { // from class: com.apm.insight.k.b.1
        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            b.this.f();
        }
    };

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Runnable f16859j = new Runnable() { // from class: com.apm.insight.k.b.2
        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            b.this.d();
        }
    };

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        File f16869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f16870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f16871c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        CrashType f16872d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f16873e;

        public a(File file, long j11, @Nullable CrashType crashType) {
            this.f16871c = -1L;
            this.f16869a = file;
            this.f16870b = j11;
            this.f16872d = crashType;
            this.f16873e = file.getName();
        }

        public a(File file, @Nullable CrashType crashType) {
            this.f16870b = -1L;
            this.f16871c = -1L;
            this.f16869a = file;
            this.f16872d = crashType;
            this.f16873e = file.getName();
        }
    }

    /* JADX INFO: renamed from: com.apm.insight.k.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0166b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f16874a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        a f16877d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        a f16878e;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<a> f16875b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        List<a> f16876c = new ArrayList();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f16879f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f16880g = 0;

        public C0166b(String str) {
            this.f16874a = str;
        }
    }

    private b(Context context) {
        this.f16851a = context;
    }

    @Nullable
    private com.apm.insight.f.b a(File file, CrashType crashType, String str, long j11, long j12) {
        com.apm.insight.f.b bVar;
        try {
            try {
                if (file.isFile()) {
                    com.apm.insight.l.f.a(file);
                    return null;
                }
                boolean z11 = crashType == CrashType.LAUNCH;
                if (crashType == null) {
                    try {
                        return com.apm.insight.l.f.b(new File(file, file.getName()).getAbsolutePath());
                    } catch (Throwable th2) {
                        th = th2;
                        bVar = null;
                        com.apm.insight.l.f.a(file);
                        com.apm.insight.c.a();
                        com.apm.insight.runtime.k.a(th, "NPTH_CATCH");
                        return bVar;
                    }
                }
                com.apm.insight.f.b bVarA = com.apm.insight.l.f.a(file, crashType);
                try {
                    JSONObject jSONObjectB = bVarA.b();
                    if (bVarA.b() == null) {
                        com.apm.insight.l.f.a(file);
                    } else {
                        if (crashType == CrashType.ANR) {
                            return bVarA;
                        }
                        jSONObjectB.put("crash_time", j11);
                        jSONObjectB.put("app_start_time", j12);
                        JSONObject jSONObjectOptJSONObject = jSONObjectB.optJSONObject("header");
                        if (jSONObjectOptJSONObject == null) {
                            jSONObjectOptJSONObject = Header.a(j11).f();
                        } else if (z11) {
                            jSONObjectB.remove("header");
                        }
                        String strOptString = jSONObjectOptJSONObject.optString("sdk_version_name", null);
                        if (strOptString == null) {
                            strOptString = "1.3.8.nourl-rc.1";
                        }
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "sdk_version", strOptString);
                        JSONArray jSONArrayOptJSONArray = jSONObjectB.optJSONArray("logcat");
                        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                            jSONObjectB.put("logcat", com.apm.insight.runtime.i.a(str));
                        }
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "has_dump", "true");
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "has_logcat", String.valueOf(!com.apm.insight.a.a(jSONObjectB, "logcat")));
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "memory_leak", String.valueOf(com.apm.insight.entity.a.a(str)));
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "fd_leak", String.valueOf(com.apm.insight.entity.a.b(str)));
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "threads_leak", String.valueOf(com.apm.insight.entity.a.c(str)));
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "is_64_devices", String.valueOf(Header.a()));
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "is_64_runtime", String.valueOf(NativeImpl.f()));
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "is_x86_devices", String.valueOf(Header.b()));
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "has_meminfo_file", String.valueOf(com.apm.insight.l.j.d(str).exists()));
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "is_root", String.valueOf(com.apm.insight.nativecrash.a.k()));
                        jSONObjectB.put("launch_did", com.apm.insight.i.a.a(this.f16851a));
                        jSONObjectB.put("crash_uuid", file.getName());
                        jSONObjectB.put("jiffy", o.a.a());
                        try {
                            long j13 = Long.parseLong(com.apm.insight.runtime.b.a(j11, str));
                            com.apm.insight.entity.a.a(jSONObjectB, "filters", "lastAliveTime", Math.abs(j13 - j11) < ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS ? "< 60s" : "> 60s");
                            jSONObjectB.put("lastAliveTime", String.valueOf(j13));
                        } catch (Throwable unused) {
                            jSONObjectB.put("lastAliveTime", AppLovinMediationProvider.UNKNOWN);
                            com.apm.insight.entity.a.a(jSONObjectB, "filters", "lastAliveTime", AppLovinMediationProvider.UNKNOWN);
                        }
                        jSONObjectB.put("has_dump", "true");
                        if (jSONObjectB.opt(PlaceTypes.STORAGE) == null) {
                            com.apm.insight.e.g();
                            com.apm.insight.entity.a.a(jSONObjectB, n.a());
                        }
                        if (Header.b(jSONObjectOptJSONObject)) {
                            com.apm.insight.entity.a.a(jSONObjectB, "filters", "unauthentic_version", "unauthentic_version");
                        }
                        com.apm.insight.entity.d.b(jSONObjectB);
                        bVarA.b().put("upload_scene", "launch_scan");
                        if (z11) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObjectB.put("event_type", "start_crash");
                            jSONObjectB.put("stack", jSONObjectB.remove("data"));
                            jSONObject.put("data", new JSONArray().put(jSONObjectB));
                            jSONObject.put("header", jSONObjectOptJSONObject);
                            bVarA.a(jSONObject);
                        } else {
                            jSONObjectB.put("isJava", 1);
                        }
                    }
                    return bVarA;
                } catch (Throwable th3) {
                    th = th3;
                    bVar = bVarA;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            bVar = null;
        }
        com.apm.insight.l.f.a(file);
        com.apm.insight.c.a();
        com.apm.insight.runtime.k.a(th, "NPTH_CATCH");
        return bVar;
    }

    public static b a() {
        if (f16850b == null) {
            synchronized (b.class) {
                try {
                    if (f16850b == null) {
                        f16850b = new b(com.apm.insight.e.g());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f16850b;
    }

    private static JSONObject a(com.apm.insight.nativecrash.a aVar) {
        JSONObject jSONObjectB = aVar.b();
        if (jSONObjectB != null && jSONObjectB.length() != 0) {
            return jSONObjectB;
        }
        if (com.apm.insight.e.d()) {
            aVar.j();
        }
        if (!aVar.a()) {
            aVar.i();
            return null;
        }
        if (!aVar.d()) {
            aVar.i();
            return null;
        }
        if (aVar.e()) {
            aVar.i();
            return null;
        }
        aVar.c();
        return aVar.h();
    }

    private void a(final C0166b c0166b, boolean z11, @Nullable com.apm.insight.runtime.g gVar) {
        Iterator<a> it;
        final File file;
        CrashType crashType;
        if (c0166b.f16875b.isEmpty()) {
            return;
        }
        if (c0166b.f16878e == null) {
            c0166b.f16878e = c0166b.f16877d;
        }
        for (Iterator<a> it2 = c0166b.f16875b.iterator(); it2.hasNext(); it2 = it) {
            a next = it2.next();
            try {
                File file2 = next.f16869a;
                CrashType crashType2 = next.f16872d;
                it = it2;
                try {
                    final com.apm.insight.f.b bVarA = a(file2, crashType2, c0166b.f16874a, next.f16870b, next.f16871c);
                    if (bVarA == null) {
                        com.apm.insight.l.f.a(file2);
                    } else {
                        JSONObject jSONObjectB = bVarA.b();
                        if (jSONObjectB == null) {
                            com.apm.insight.l.f.a(file2);
                        } else {
                            JSONObject jSONObjectOptJSONObject = jSONObjectB.optJSONObject("header");
                            if (jSONObjectOptJSONObject == null) {
                                com.apm.insight.l.f.a(file2);
                            } else {
                                if (crashType2 == null) {
                                    file = file2;
                                    if (new File(file, file2.getName()).exists() || file.getName().split("_").length < 5) {
                                        if (e.b(bVarA.a(), jSONObjectB.toString()).a()) {
                                            com.apm.insight.l.f.a(file);
                                        }
                                    }
                                } else {
                                    file = file2;
                                }
                                File fileA = com.apm.insight.entity.b.a(file);
                                if (fileA.exists()) {
                                    try {
                                        JSONArray jSONArray = new JSONArray(com.apm.insight.l.f.a(fileA, "\n"));
                                        JSONObject jSONObjectOptJSONObject2 = crashType2 == CrashType.LAUNCH ? ((JSONArray) jSONObjectB.opt("data")).optJSONObject(0) : jSONObjectB;
                                        if ((z11 || c0166b.f16878e == next) && !next.f16873e.contains("ignore")) {
                                            crashType = crashType2;
                                            if (gVar != null && !gVar.a(jSONObjectOptJSONObject2.optString("crash_md5", TmcEngineFactory.ENGINE_TYPE_DEFAULT))) {
                                                com.apm.insight.l.f.a(next.f16869a);
                                            }
                                        } else {
                                            try {
                                                com.apm.insight.entity.a.a(jSONObjectOptJSONObject2, "filters", "aid", String.valueOf(jSONObjectOptJSONObject.opt("aid")));
                                                crashType = crashType2;
                                                try {
                                                    com.apm.insight.entity.a.a(jSONObjectOptJSONObject2, "filters", "has_ignore", String.valueOf(next.f16873e.contains("ignore")));
                                                    jSONObjectOptJSONObject.put("aid", 2010);
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    com.apm.insight.c.a();
                                                    com.apm.insight.runtime.k.a(th, "NPTH_CATCH");
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                crashType = crashType2;
                                            }
                                        }
                                        com.apm.insight.entity.a.a(jSONObjectOptJSONObject2, "filters", "start_uuid", c0166b.f16874a);
                                        com.apm.insight.entity.a.a(jSONObjectOptJSONObject2, "filters", "leak_threads_count", String.valueOf(c0166b.f16880g));
                                        com.apm.insight.entity.a.a(jSONObjectOptJSONObject2, "filters", "crash_thread_name", jSONObjectOptJSONObject2.optString("crash_thread_name", AppLovinMediationProvider.UNKNOWN));
                                        try {
                                            com.apm.insight.entity.b.a(jSONObjectB, jSONArray, new com.apm.insight.entity.b.a() { // from class: com.apm.insight.k.b.3
                                                @Override // com.apm.insight.entity.b.a
                                                public final void a(JSONObject jSONObject) {
                                                    e.a(bVarA.a(), jSONObject.toString(), new File(file, "logZip"), com.apm.insight.l.j.a(b.this.f16851a, c0166b.f16874a));
                                                }
                                            });
                                            if (!com.apm.insight.l.f.a(file)) {
                                                com.apm.insight.e.a.a().a(com.apm.insight.d.a.b(file.getAbsolutePath()));
                                            }
                                            c.a(crashType, jSONObjectB);
                                        } catch (Throwable th4) {
                                            th = th4;
                                            com.apm.insight.c.a();
                                            com.apm.insight.runtime.k.a(th, "NPTH_CATCH");
                                            com.apm.insight.l.f.a(next.f16869a);
                                        }
                                    } catch (Throwable unused) {
                                    }
                                } else {
                                    com.apm.insight.l.f.a(file);
                                }
                            }
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    com.apm.insight.c.a();
                    com.apm.insight.runtime.k.a(th, "NPTH_CATCH");
                    com.apm.insight.l.f.a(next.f16869a);
                }
            } catch (Throwable th6) {
                th = th6;
                it = it2;
            }
        }
    }

    private void a(HashMap<String, C0166b> map) {
        File[] fileArrListFiles = com.apm.insight.l.j.f(this.f16851a).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return;
        }
        for (int i11 = 0; i11 < fileArrListFiles.length && i11 < 5; i11++) {
            File file = fileArrListFiles[i11];
            try {
                if (!file.isDirectory()) {
                    com.apm.insight.l.f.a(file);
                } else if (file.getName().endsWith(RequestConfiguration.MAX_AD_CONTENT_RATING_G)) {
                    String name = file.getName();
                    C0166b c0166b = map.get(name);
                    if (c0166b == null) {
                        c0166b = new C0166b(name);
                        map.put(name, c0166b);
                    }
                    JSONArray jSONArrayA = com.apm.insight.nativecrash.b.a(com.apm.insight.l.j.l(file), com.apm.insight.l.j.m(file));
                    int length = jSONArrayA.length();
                    c0166b.f16880g = length;
                    if (length > 0) {
                        try {
                            com.apm.insight.l.f.a(com.apm.insight.l.j.n(file), jSONArrayA);
                        } catch (Throwable unused) {
                        }
                    }
                } else {
                    com.apm.insight.l.f.a(file);
                }
            } catch (Throwable th2) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.k.a(th2, "NPTH_CATCH");
                com.apm.insight.l.f.a(file);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00c4  */
    private void a(HashMap<String, C0166b> map, C0166b c0166b) {
        byte b11;
        CrashType crashType;
        File[] fileArrListFiles = com.apm.insight.l.j.a(this.f16851a).listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        Arrays.sort(fileArrListFiles, Collections.reverseOrder());
        char c11 = 0;
        int i11 = 0;
        while (i11 < fileArrListFiles.length) {
            File file = fileArrListFiles[i11];
            try {
                if (com.apm.insight.e.a.a().a(file.getAbsolutePath())) {
                    com.apm.insight.l.f.a(file);
                } else if (!com.apm.insight.l.f.e(file) && !com.apm.insight.g.a.a().b(file.getName())) {
                    if (file.isFile()) {
                        com.apm.insight.l.f.a(file);
                    } else {
                        String name = file.getName();
                        if (name.endsWith(RequestConfiguration.MAX_AD_CONTENT_RATING_G)) {
                            String[] strArrSplit = name.split("_");
                            if (strArrSplit.length < 5) {
                                c0166b.f16875b.add(new a(file, null));
                            } else {
                                try {
                                    long j11 = Long.parseLong(strArrSplit[c11]);
                                    long j12 = Long.parseLong(strArrSplit[4]);
                                    String str = strArrSplit[2];
                                    String str2 = strArrSplit[1];
                                    int iHashCode = str2.hashCode();
                                    if (iHashCode != -1109843021) {
                                        if (iHashCode != 96741) {
                                            if (iHashCode == 3254818 && str2.equals("java")) {
                                                b11 = 1;
                                            } else {
                                                b11 = -1;
                                            }
                                        } else if (str2.equals("anr")) {
                                            b11 = 2;
                                        } else {
                                            b11 = -1;
                                        }
                                    } else if (str2.equals("launch")) {
                                        b11 = 0;
                                    } else {
                                        b11 = -1;
                                    }
                                    if (b11 == 0) {
                                        crashType = CrashType.LAUNCH;
                                    } else if (b11 != 1) {
                                        crashType = b11 != 2 ? null : CrashType.ANR;
                                    } else {
                                        crashType = CrashType.JAVA;
                                    }
                                    C0166b c0166b2 = map.get(str);
                                    if (c0166b2 == null) {
                                        c0166b2 = new C0166b(str);
                                        map.put(str, c0166b2);
                                    }
                                    a aVar = new a(file, j11, crashType);
                                    aVar.f16871c = j12;
                                    a aVar2 = c0166b2.f16877d;
                                    if ((aVar2 == null || aVar2.f16870b > aVar.f16870b) && crashType != null && crashType != CrashType.ANR && !name.contains("ignore")) {
                                        c0166b2.f16877d = aVar;
                                    }
                                    c0166b2.f16875b.add(aVar);
                                } catch (Throwable unused) {
                                    c0166b.f16875b.add(new a(file, null));
                                    com.apm.insight.c.a();
                                    com.apm.insight.runtime.k.a(new RuntimeException("err format crashTime:".concat(name)), "NPTH_CATCH");
                                }
                            }
                        } else {
                            com.apm.insight.l.f.a(file);
                        }
                    }
                }
            } catch (Throwable th2) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.k.a(th2, "NPTH_CATCH");
            }
            i11++;
            c11 = 0;
        }
    }

    private static boolean a(File file) {
        String[] list = file.list();
        if (list == null) {
            return false;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && str.endsWith("")) {
                return true;
            }
        }
        return false;
    }

    private void b(final C0166b c0166b, boolean z11, @Nullable com.apm.insight.runtime.g gVar) {
        boolean z12;
        if (c0166b.f16876c.size() <= 1 && c0166b.f16876c.isEmpty()) {
            c0166b.f16878e = c0166b.f16877d;
            return;
        }
        boolean zB = com.apm.insight.l.k.b(this.f16851a);
        c0166b.f16878e = c0166b.f16877d;
        com.apm.insight.nativecrash.a aVar = new com.apm.insight.nativecrash.a(this.f16851a);
        Iterator<a> it = c0166b.f16876c.iterator();
        while (it.hasNext()) {
            a next = it.next();
            final File file = next.f16869a;
            try {
                aVar.a(file);
                JSONObject jSONObjectA = a(aVar);
                if (jSONObjectA == null || jSONObjectA.length() == 0) {
                    it = it;
                    z12 = zB;
                    aVar.i();
                    zB = z12;
                    it = it;
                } else {
                    if (jSONObjectA.length() != 0) {
                        if (z11) {
                            it = it;
                            z12 = zB;
                            if (gVar != null && !gVar.a(TmcEngineFactory.ENGINE_TYPE_DEFAULT)) {
                                aVar.i();
                            }
                        } else {
                            long jOptLong = jSONObjectA.optLong("crash_time");
                            try {
                                a aVar2 = c0166b.f16878e;
                                if (aVar2 == null) {
                                    c0166b.f16878e = next;
                                    c0166b.f16879f = true;
                                    if (gVar == null || gVar.a(TmcEngineFactory.ENGINE_TYPE_DEFAULT)) {
                                        it = it;
                                        z12 = zB;
                                    } else {
                                        aVar.i();
                                    }
                                    com.apm.insight.c.a();
                                    com.apm.insight.runtime.k.a(th, "NPTH_CATCH");
                                    com.apm.insight.l.f.a(file);
                                } else {
                                    it = it;
                                    try {
                                        if (c0166b.f16879f) {
                                            z12 = zB;
                                        } else {
                                            z12 = zB;
                                            try {
                                                if (jOptLong < aVar2.f16870b) {
                                                    c0166b.f16878e = next;
                                                    if (gVar == null || gVar.a(TmcEngineFactory.ENGINE_TYPE_DEFAULT)) {
                                                        a(file);
                                                        c0166b.f16879f = true;
                                                    } else {
                                                        aVar.i();
                                                        zB = z12;
                                                        it = it;
                                                    }
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                            }
                                        }
                                        com.apm.insight.entity.a.a(jSONObjectA, "filters", "aid", String.valueOf(jSONObjectA.optJSONObject("header").opt("aid")));
                                        jSONObjectA.optJSONObject("header").put("aid", 2010);
                                    } catch (Throwable th3) {
                                        th = th3;
                                        z12 = zB;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                z12 = zB;
                            }
                        }
                        try {
                            com.apm.insight.entity.a.a(jSONObjectA, "filters", "start_uuid", c0166b.f16874a);
                            com.apm.insight.entity.a.a(jSONObjectA, "filters", "crash_thread_name", jSONObjectA.optString("crash_thread_name", AppLovinMediationProvider.UNKNOWN));
                            if (z12) {
                                c.a aVar3 = new c.a(jSONObjectA, CrashType.NATIVE);
                                com.apm.insight.entity.b.a(jSONObjectA, com.apm.insight.entity.b.a(aVar3.c(), aVar3.a(), q.a().b(aVar3.b() == -1 ? System.currentTimeMillis() : aVar3.b())), new com.apm.insight.entity.b.a() { // from class: com.apm.insight.k.b.4
                                    @Override // com.apm.insight.entity.b.a
                                    public final void a(JSONObject jSONObject) {
                                        d.a();
                                        d.a(jSONObject, file, com.apm.insight.l.j.a(b.this.f16851a, c0166b.f16874a));
                                    }
                                });
                                if (!aVar.i()) {
                                    aVar.f();
                                }
                            }
                            c.a(CrashType.NATIVE, jSONObjectA);
                        } catch (Throwable th5) {
                            th = th5;
                            com.apm.insight.c.a();
                            com.apm.insight.runtime.k.a(th, "NPTH_CATCH");
                            com.apm.insight.l.f.a(file);
                        }
                    } else {
                        it = it;
                        z12 = zB;
                    }
                    zB = z12;
                    it = it;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    private void b(HashMap<String, C0166b> map) {
        File[] fileArrListFiles = com.apm.insight.l.j.d(this.f16851a).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return;
        }
        for (int i11 = 0; i11 < fileArrListFiles.length && i11 < 5; i11++) {
            File file = fileArrListFiles[i11];
            try {
                if (!file.isDirectory()) {
                    com.apm.insight.l.f.a(file);
                } else if (file.getName().endsWith(RequestConfiguration.MAX_AD_CONTENT_RATING_G)) {
                    String name = file.getName();
                    C0166b c0166b = map.get(name);
                    if (c0166b == null) {
                        c0166b = new C0166b(name);
                        map.put(name, c0166b);
                    }
                    c0166b.f16876c.add(new a(file, CrashType.NATIVE));
                } else {
                    com.apm.insight.l.f.a(file);
                }
            } catch (Throwable th2) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.k.a(th2, "NPTH_CATCH");
                com.apm.insight.l.f.a(file);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() throws Throwable {
        if (this.f16857h || this.f16856g == null) {
            return;
        }
        if (!com.apm.insight.l.k.b(this.f16851a)) {
            e();
        }
        if (this.f16854e == -1) {
            if (com.apm.insight.runtime.a.a() && com.apm.insight.runtime.a.f()) {
                this.f16854e = 1;
            } else {
                this.f16854e = 0;
            }
        }
        boolean z11 = this.f16854e == 1;
        com.apm.insight.runtime.g gVar = new com.apm.insight.runtime.g(this.f16851a);
        Iterator<C0166b> it = this.f16856g.values().iterator();
        while (it.hasNext()) {
            b(it.next(), z11, gVar);
        }
        Iterator<C0166b> it2 = this.f16856g.values().iterator();
        while (it2.hasNext()) {
            a(it2.next(), z11, gVar);
        }
        Iterator<C0166b> it3 = this.f16856g.values().iterator();
        while (it3.hasNext()) {
            com.apm.insight.l.f.a(com.apm.insight.l.j.a(this.f16851a, it3.next().f16874a));
        }
        gVar.a();
        com.apm.insight.runtime.b.a();
        e();
    }

    private void e() {
        this.f16857h = true;
        this.f16856g = null;
        NativeImpl.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() throws Throwable {
        if (this.f16857h) {
            return;
        }
        if (!com.apm.insight.l.k.b(this.f16851a) || (System.currentTimeMillis() - com.apm.insight.e.j() <= 5000 && com.apm.insight.e.i().isApmExists() && !Npth.hasCrash())) {
            com.apm.insight.runtime.n.a().a(this.f16858i, 5000L);
        } else {
            d();
        }
    }

    private void g() {
        File[] fileArrListFiles = com.apm.insight.l.j.i(this.f16851a).listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (int i11 = 0; i11 < fileArrListFiles.length && i11 < 5; i11++) {
            File file = fileArrListFiles[i11];
            if (file.getName().endsWith(".atmp")) {
                com.apm.insight.a.a.a();
                file.getAbsolutePath();
            } else {
                try {
                    com.apm.insight.f.b bVarC = com.apm.insight.l.f.c(file.getAbsolutePath());
                    if (bVarC != null) {
                        if (bVarC.b() != null) {
                            bVarC.b().put("upload_scene", "launch_scan");
                        }
                        if (e.a(e.d(), bVarC.e(), bVarC.d(), bVarC.f(), bVarC.g())) {
                            com.apm.insight.l.f.a(file);
                            String strC = bVarC.c();
                            if (!TextUtils.isEmpty(strC)) {
                                com.apm.insight.l.f.a(new File(strC));
                            }
                        }
                    } else {
                        com.apm.insight.l.f.a(file);
                    }
                } catch (Throwable th2) {
                    com.apm.insight.c.a();
                    com.apm.insight.runtime.k.a(th2, "NPTH_CATCH");
                }
            }
        }
    }

    public final void a(boolean z11) throws Throwable {
        if (!Npth.isStopUpload() && z11) {
            if (this.f16855f == null) {
                this.f16855f = new C0166b("old_uuid");
                HashMap<String, C0166b> map = new HashMap<>();
                this.f16856g = map;
                a(map);
                a(this.f16856g, this.f16855f);
                com.apm.insight.l.f.a(com.apm.insight.l.j.b(this.f16851a));
                b(this.f16856g);
                b(this.f16855f, true, null);
                a(this.f16855f, true, null);
                this.f16855f = null;
                if (this.f16856g.isEmpty()) {
                    e();
                } else {
                    f();
                }
            }
            g();
            com.apm.insight.a.c();
        }
    }

    public final void b() {
        try {
            if (!this.f16857h && com.apm.insight.l.a.c(com.apm.insight.e.g())) {
                com.apm.insight.runtime.n.a().a(this.f16859j);
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean c() {
        return this.f16857h;
    }
}
