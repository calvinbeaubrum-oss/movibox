package com.cloud.tmc.integration.audio;

import android.text.TextUtils;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.EngineUtils;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final App f30411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f30412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, PlayerInstance> f30413c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PlayerInstance f30414d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f30415e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AtomicBoolean f30416f = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.cloud.tmc.integration.audio.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class C0335a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30417a;

        static {
            int[] iArr = new int[PlayerInstance.PlayType.values().length];
            f30417a = iArr;
            try {
                iArr[PlayerInstance.PlayType.ON_CAN_PLAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30417a[PlayerInstance.PlayType.ON_PLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30417a[PlayerInstance.PlayType.ON_STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30417a[PlayerInstance.PlayType.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f30417a[PlayerInstance.PlayType.ON_SEEKED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f30417a[PlayerInstance.PlayType.ON_SEEKING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f30417a[PlayerInstance.PlayType.ON_WAITING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f30417a[PlayerInstance.PlayType.ON_ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f30417a[PlayerInstance.PlayType.ON_ENDED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements PlayerInstance.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f30418a;

        public b(String str) {
            this.f30418a = str;
        }

        @Override // com.cloud.tmc.integration.audio.PlayerInstance.a
        public void a(PlayerInstance.PlayType playType, String str, String str2) {
            String str3;
            try {
                TmcLogger.c("ForegroundPlayerClient", "onDispatchEvent:### id=" + str2 + ",event = " + playType);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("audioPlayerID", str2);
                switch (C0335a.f30417a[playType.ordinal()]) {
                    case 1:
                        str3 = "onForegroundAudioCanPlay";
                        break;
                    case 2:
                        a aVar = a.this;
                        aVar.f30414d = (PlayerInstance) aVar.f30413c.get(str2);
                        str3 = "onForegroundAudioPlay";
                        break;
                    case 3:
                        str3 = "onForegroundAudioStop";
                        break;
                    case 4:
                        str3 = "onForegroundAudioPause";
                        break;
                    case 5:
                        str3 = "onForegroundAudioSeeked";
                        break;
                    case 6:
                        str3 = "onForegroundAudioSeeking";
                        break;
                    case 7:
                        str3 = "onForegroundAudioWaiting";
                        break;
                    case 8:
                        str3 = "onForegroundAudioError";
                        jsonObject.addProperty("errMsg", str);
                        break;
                    case 9:
                        str3 = "onForegroundAudioEnded";
                        break;
                    default:
                        return;
                }
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.add("data", jsonObject);
                if (a.this.f30411a == null || a.this.f30411a.getActivePage() == null) {
                    return;
                }
                EngineUtils.g(a.this.f30411a.getActivePage().getRender(), str3, jsonObject2, null);
            } catch (Exception e11) {
                TmcLogger.h("ForegroundPlayerClient", e11);
            }
        }
    }

    public a(App app) {
        this.f30411a = app;
        this.f30412b = app.getAppId();
    }

    public synchronized void d(String str, bc.a aVar) {
        if (this.f30416f.get()) {
            aVar.b();
            return;
        }
        PlayerInstance playerInstance = this.f30413c.get(str);
        if (playerInstance == null) {
            playerInstance = new PlayerInstance(this.f30411a, str, new b(str));
            this.f30413c.put(str, playerInstance);
        }
        playerInstance.a();
        aVar.g();
    }

    public synchronized void e(String str, bc.a aVar) {
        PlayerInstance playerInstanceRemove = this.f30413c.remove(str);
        if (playerInstanceRemove == null) {
            aVar.b();
        } else {
            playerInstanceRemove.q();
            aVar.g();
        }
    }

    public synchronized void f(String str, String str2, bc.a aVar) {
        try {
            PlayerInstance playerInstance = this.f30413c.get(str);
            if (playerInstance == null) {
                playerInstance = new PlayerInstance(this.f30411a, str, new b(str));
                this.f30413c.put(str, playerInstance);
            }
            h(aVar, str2, playerInstance);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void g(bc.a aVar, JsonObject jsonObject, String str) {
        jsonObject.addProperty("success", Boolean.TRUE);
        jsonObject.addProperty("audioPlayerID", str);
        if (aVar != null) {
            aVar.a(jsonObject);
        }
    }

    public final synchronized void h(bc.a aVar, String str, PlayerInstance playerInstance) {
        try {
            TmcLogger.c("ForegroundPlayerClient", "onGetOption:### " + str);
            if (aVar == null) {
                return;
            }
            JsonObject jsonObject = new JsonObject();
            if (TextUtils.isEmpty(str)) {
                TmcLogger.c("ForegroundPlayerClient", "InvalidParam : " + str);
                PlayerInstance.n(aVar, "error option = " + str);
            } else if ("src".equalsIgnoreCase(str)) {
                jsonObject.addProperty("src", playerInstance.j());
                g(aVar, jsonObject, playerInstance.i());
            } else if ("autoPlay".equalsIgnoreCase(str)) {
                jsonObject.addProperty("autoPlay", Boolean.valueOf(playerInstance.c()));
                g(aVar, jsonObject, playerInstance.i());
            } else if ("loop".equalsIgnoreCase(str)) {
                jsonObject.addProperty("loop", Boolean.valueOf(playerInstance.h()));
                g(aVar, jsonObject, playerInstance.i());
            } else if ("startTime".equalsIgnoreCase(str)) {
                jsonObject.addProperty("startTime", Float.valueOf(playerInstance.k()));
                g(aVar, jsonObject, playerInstance.i());
            } else if ("volume".equalsIgnoreCase(str)) {
                jsonObject.addProperty("volume", Float.valueOf(playerInstance.l()));
                g(aVar, jsonObject, playerInstance.i());
            } else if ("duration".equalsIgnoreCase(str)) {
                jsonObject.addProperty("duration", Float.valueOf(playerInstance.f() / 1000.0f));
                g(aVar, jsonObject, playerInstance.i());
            } else if ("currentTime".equalsIgnoreCase(str)) {
                jsonObject.addProperty("currentTime", Float.valueOf(playerInstance.e() / 1000.0f));
                g(aVar, jsonObject, playerInstance.i());
            } else if ("buffered".equalsIgnoreCase(str)) {
                jsonObject.addProperty("buffered", Integer.valueOf(playerInstance.d()));
                g(aVar, jsonObject, playerInstance.i());
            } else if ("paused".equalsIgnoreCase(str)) {
                jsonObject.addProperty("paused", Boolean.valueOf(!playerInstance.m()));
                g(aVar, jsonObject, playerInstance.i());
            } else {
                TmcLogger.c("ForegroundPlayerClient", "InvalidParam : " + str);
                PlayerInstance.n(aVar, "error option = " + str);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void i(bc.a aVar, JsonObject jsonObject, PlayerInstance playerInstance) {
        boolean z11;
        try {
            TmcLogger.c("ForegroundPlayerClient", "onSetOption:### " + jsonObject);
            if (jsonObject == null) {
                if (aVar != null) {
                    aVar.b();
                }
                TmcLogger.c("ForegroundPlayerClient", "InvalidParam : " + jsonObject);
                return;
            }
            boolean z12 = false;
            try {
                if (this.f30416f.get() && jsonObject.get("autoPlay").getAsBoolean()) {
                    jsonObject.addProperty("autoPlay", Boolean.FALSE);
                    this.f30414d = playerInstance;
                    playerInstance.f30398c = true;
                }
                Iterator<String> it = jsonObject.keySet().iterator();
                loop0: while (true) {
                    z11 = true;
                    while (true) {
                        if (!it.hasNext()) {
                            break loop0;
                        }
                        String next = it.next();
                        if (!TextUtils.isEmpty(next)) {
                            if ("src".equals(next)) {
                                if (z11 && playerInstance.v(jsonObject.get("src").getAsString())) {
                                }
                                z11 = false;
                            } else if ("loop".equals(next)) {
                                if (z11 && playerInstance.u(jsonObject.get("loop").getAsBoolean())) {
                                }
                                z11 = false;
                            } else if ("startTime".equals(next)) {
                                if (z11 && playerInstance.w(jsonObject.get("startTime").getAsInt())) {
                                }
                                z11 = false;
                            } else if ("volume".equals(next)) {
                                if (z11 && playerInstance.x(jsonObject.get("volume").getAsFloat())) {
                                }
                                z11 = false;
                            } else {
                                if (!"autoPlay".equals(next)) {
                                    TmcLogger.c("PlayerInstance", "InvalidParam : " + jsonObject);
                                } else if (z11 && playerInstance.t(jsonObject.get("autoPlay").getAsBoolean())) {
                                }
                                z11 = false;
                            }
                        }
                    }
                }
                z12 = z11;
            } catch (Exception e11) {
                TmcLogger.h("ForegroundPlayerClient", e11);
            }
            q(z12, aVar);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void j(String str, bc.a aVar) {
        try {
            PlayerInstance playerInstance = this.f30413c.get(str);
            if (playerInstance == null) {
                playerInstance = new PlayerInstance(this.f30411a, str, new b(str));
                this.f30413c.put(str, playerInstance);
            }
            playerInstance.a();
            q(playerInstance.o(), aVar);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void k() {
        TmcLogger.c("ForegroundPlayerClient", "pauseAppAudio - appId=" + this.f30412b);
        r(true);
        PlayerInstance playerInstance = this.f30414d;
        if (playerInstance != null && playerInstance.m()) {
            this.f30414d.o();
            this.f30414d.f30398c = true;
        }
    }

    public synchronized void l(String str, bc.a aVar) {
        if (this.f30416f.get()) {
            aVar.b();
            return;
        }
        PlayerInstance playerInstance = this.f30413c.get(str);
        if (playerInstance == null) {
            playerInstance = new PlayerInstance(this.f30411a, str, new b(str));
            this.f30413c.put(str, playerInstance);
        }
        if (!this.f30415e) {
            for (Map.Entry<String, PlayerInstance> entry : this.f30413c.entrySet()) {
                if (!str.equals(entry.getKey())) {
                    entry.getValue().o();
                }
            }
        }
        playerInstance.a();
        q(playerInstance.p(), aVar);
    }

    public synchronized void m() {
        try {
            try {
                TmcLogger.f("ForegroundPlayerClient", "App releaseAppAudio appId = " + this.f30412b);
                for (Map.Entry<String, PlayerInstance> entry : this.f30413c.entrySet()) {
                    if (entry.getValue() != null) {
                        entry.getValue().q();
                    }
                }
                this.f30413c.clear();
                r(false);
            } catch (Exception e11) {
                TmcLogger.h("ForegroundPlayerClient", e11);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void n(String str, bc.a aVar) {
        if (this.f30416f.get()) {
            aVar.b();
            return;
        }
        PlayerInstance playerInstance = this.f30413c.get(str);
        if (playerInstance == null) {
            playerInstance = new PlayerInstance(this.f30411a, str, new b(str));
            this.f30413c.put(str, playerInstance);
        }
        playerInstance.r();
        aVar.g();
    }

    public synchronized void o() {
        TmcLogger.c("ForegroundPlayerClient", "restoreAppAudio - appId=" + this.f30412b);
        r(false);
        PlayerInstance playerInstance = this.f30414d;
        if (playerInstance != null && playerInstance.f30398c) {
            playerInstance.f30398c = false;
            playerInstance.p();
        }
    }

    public synchronized void p(String str, float f11, bc.a aVar) {
        if (this.f30416f.get()) {
            aVar.b();
            return;
        }
        PlayerInstance playerInstance = this.f30413c.get(str);
        if (playerInstance == null) {
            playerInstance = new PlayerInstance(this.f30411a, str, new b(str));
            this.f30413c.put(str, playerInstance);
        }
        playerInstance.a();
        q(playerInstance.s(f11), aVar);
    }

    public final void q(boolean z11, bc.a aVar) {
        if (aVar == null) {
            return;
        }
        if (z11) {
            aVar.g();
        } else {
            aVar.b();
        }
    }

    public synchronized void r(boolean z11) {
        this.f30416f.set(z11);
        for (Map.Entry<String, PlayerInstance> entry : this.f30413c.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().f30409o = true;
            }
        }
    }

    public synchronized void s(String str, JsonObject jsonObject, bc.a aVar) {
        try {
            PlayerInstance playerInstance = this.f30413c.get(str);
            if (playerInstance == null) {
                playerInstance = new PlayerInstance(this.f30411a, str, new b(str));
                this.f30413c.put(str, playerInstance);
            }
            playerInstance.a();
            i(aVar, jsonObject, playerInstance);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void t(String str, bc.a aVar) {
        try {
            PlayerInstance playerInstance = this.f30413c.get(str);
            if (playerInstance == null) {
                playerInstance = new PlayerInstance(this.f30411a, str, new b(str));
                this.f30413c.put(str, playerInstance);
            }
            playerInstance.a();
            q(playerInstance.y(), aVar);
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
