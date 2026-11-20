package com.avery.subtitle;

import a8.d;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class DefaultSubtitleEngine implements com.avery.subtitle.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f25075p = new a(null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f25076q = DefaultSubtitleEngine.class.getSimpleName();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f25077r = TimeUnit.MINUTES.toMillis(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HandlerThread f25078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f25079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f25080c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public y7.a f25082f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.avery.subtitle.b.InterfaceC0209b f25083g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.avery.subtitle.b.a f25084h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f25085i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f25086j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f25087k;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f25091o;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Long> f25081d = new HashMap();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public k0 f25088l = l0.a(w0.c());

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public k0 f25089m = l0.a(w0.b());

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f25090n = LazyKt__LazyJVMKt.b(new Function0<b8.a>() { // from class: com.avery.subtitle.DefaultSubtitleEngine$subtitleCacheManager$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final b8.a invoke() {
            return new b8.a();
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements SubtitleLoader.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f25093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f25094c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f25095d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f25096e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ y7.b f25097f;

        public b(String str, String str2, String str3, boolean z11, y7.b bVar) {
            this.f25093b = str;
            this.f25094c = str2;
            this.f25095d = str3;
            this.f25096e = z11;
            this.f25097f = bVar;
        }

        @Override // com.avery.subtitle.SubtitleLoader.a
        public void a(Exception exc) {
            DefaultSubtitleEngine.this.i().k(this.f25093b, null);
            String str = DefaultSubtitleEngine.f25076q;
            Intrinsics.d(exc);
            Log.e(str, "onError: " + exc.getMessage());
            y7.b bVar = this.f25097f;
            if (bVar != null) {
                bVar.a(false);
            }
        }

        @Override // com.avery.subtitle.SubtitleLoader.a
        public void b(d dVar) {
            b8.a aVarI = DefaultSubtitleEngine.this.i();
            String str = this.f25093b;
            Intrinsics.d(dVar);
            aVarI.k(str, dVar);
            DefaultSubtitleEngine.this.i().i(this.f25093b);
            DefaultSubtitleEngine.this.j(this.f25094c, this.f25095d, this.f25096e, this.f25097f, dVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0065  */
    public static final boolean g(DefaultSubtitleEngine this$0, Message msg) {
        long j11;
        y7.a aVar;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(msg, "msg");
        if (this$0.f25087k) {
            return true;
        }
        try {
            y7.a aVar2 = this$0.f25082f;
            Float speed = aVar2 != null ? aVar2.getSpeed() : null;
            float fFloatValue = speed == null ? 1.0f : speed.floatValue();
            boolean z11 = msg.what == 2185;
            y7.a aVar3 = this$0.f25082f;
            long currentPosition = (aVar3 != null ? aVar3.getCurrentPosition() : 0L) + this$0.f25086j;
            if (z11 || ((aVar = this$0.f25082f) != null && aVar.isPlaying())) {
                b8.a aVarI = this$0.i();
                String str = this$0.f25085i;
                Intrinsics.d(str);
                a8.b bVarA = c.a(currentPosition, aVarI.d(str));
                this$0.m(bVarA);
                if (bVarA != null) {
                    j11 = ((long) bVarA.f452c.f454a) - currentPosition;
                } else {
                    j11 = 1000;
                }
            } else {
                j11 = 1000;
            }
            this$0.e();
            long j12 = (long) (j11 / fFloatValue);
            Handler handler = this$0.f25079b;
            if (handler != null) {
                Intrinsics.d(handler);
                handler.removeMessages(2184);
                Handler handler2 = this$0.f25079b;
                Intrinsics.d(handler2);
                handler2.sendEmptyMessageDelayed(2184, j12);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return true;
    }

    @Override // com.avery.subtitle.b
    public void destroy() {
        reset();
        n();
        this.f25087k = false;
    }

    public final void e() {
        if (this.f25081d.isEmpty()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f25091o < AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
            return;
        }
        this.f25091o = jCurrentTimeMillis;
        this.f25081d.put(this.f25085i, Long.valueOf(jCurrentTimeMillis));
        Iterator<Map.Entry<String, Long>> it = this.f25081d.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Long> next = it.next();
            String key = next.getKey();
            long jLongValue = next.getValue().longValue();
            if (!TextUtils.equals(key, this.f25085i) && jCurrentTimeMillis - jLongValue > f25077r) {
                Log.v(f25076q, "-----------------------timeout remove~ md5 = " + key + ", setTime = " + jLongValue + ", cur = " + jCurrentTimeMillis);
                it.remove();
                b8.a aVarI = i();
                Intrinsics.d(key);
                aVarI.j(key);
            }
        }
    }

    public final void f() {
        HandlerThread handlerThread = new HandlerThread("SubtitleFindThread");
        this.f25078a = handlerThread;
        Intrinsics.d(handlerThread);
        handlerThread.start();
        HandlerThread handlerThread2 = this.f25078a;
        Intrinsics.d(handlerThread2);
        this.f25079b = new Handler(handlerThread2.getLooper(), new Handler.Callback() { // from class: com.avery.subtitle.a
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return DefaultSubtitleEngine.g(this.f25101a, message);
            }
        });
    }

    public final void h() {
        if (this.f25078a != null) {
            return;
        }
        f();
    }

    public final b8.a i() {
        return (b8.a) this.f25090n.getValue();
    }

    @Override // com.avery.subtitle.b
    public void initSubtitle(y7.a playerControl, boolean z11) {
        Intrinsics.g(playerControl, "playerControl");
        this.f25082f = playerControl;
        this.f25080c = z11;
    }

    public final void j(String str, String str2, boolean z11, y7.b bVar, d dVar) {
        if (dVar == null) {
            if (bVar != null) {
                bVar.a(false);
            }
            Log.e(f25076q, "onSuccess: timedTextObject is null.");
            return;
        }
        TreeMap<Integer, a8.b> treeMap = dVar.f463i;
        if (treeMap == null) {
            if (bVar != null) {
                bVar.a(false);
            }
            Log.e(f25076q, "onSuccess: captions is null.");
            return;
        }
        String md5 = b8.b.a(str);
        String str3 = dVar.f464j;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onSuccess: md5 = ");
        sb2.append(md5);
        sb2.append(".,path = ");
        sb2.append(str);
        sb2.append(" warnings = ");
        sb2.append(str3);
        ArrayList arrayList = new ArrayList(treeMap.values());
        b8.a aVarI = i();
        Intrinsics.f(md5, "md5");
        aVarI.f(md5, arrayList);
        if (!this.f25080c) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("add timeout map : md5 = ");
            sb3.append(md5);
            sb3.append("， path = ");
            sb3.append(str);
            this.f25081d.put(md5, Long.valueOf(System.currentTimeMillis()));
        }
        if (!this.f25080c || TextUtils.equals(md5, this.f25085i)) {
            l(z11);
        }
        if (bVar != null) {
            bVar.a(true);
        }
    }

    public final void k(String str, final String str2, final String str3, final boolean z11, final y7.b bVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("loadSubtitle: path = ");
        sb2.append(str2);
        if (!i().h(str)) {
            i().a(str);
            SubtitleLoader.f25098a.h(str2, str3, new b(str, str2, str3, z11, bVar));
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("loadSubtitle, 当前有加载，无需处理: path = ");
            sb3.append(str2);
            i().b(new Function2<String, d, Unit>() { // from class: com.avery.subtitle.DefaultSubtitleEngine$loadSubtitle$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str4, d dVar) {
                    invoke2(str4, dVar);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str4, d dVar) {
                    String unused = DefaultSubtitleEngine.f25076q;
                    String str5 = str2;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("其他的加载成功: path = ");
                    sb4.append(str5);
                    this.j(str2, str3, z11, bVar, dVar);
                }
            });
        }
    }

    public final void l(boolean z11) {
        com.avery.subtitle.b.InterfaceC0209b interfaceC0209b;
        if (i().g() || this.f25087k || (interfaceC0209b = this.f25083g) == null) {
            return;
        }
        if (z11) {
            Intrinsics.d(interfaceC0209b);
            interfaceC0209b.onRefreshSubtitle();
        } else {
            Intrinsics.d(interfaceC0209b);
            interfaceC0209b.onSubtitlePrepared();
        }
    }

    public final void m(a8.b bVar) {
        com.avery.subtitle.b.a aVar = this.f25084h;
        if (aVar != null) {
            j.d(this.f25088l, null, null, new DefaultSubtitleEngine$notifyRefreshUI$1$1(aVar, bVar, null), 3, null);
        }
    }

    public final void n() {
        HandlerThread handlerThread = this.f25078a;
        if (handlerThread != null) {
            Intrinsics.d(handlerThread);
            handlerThread.quit();
            this.f25078a = null;
        }
        Handler handler = this.f25079b;
        if (handler != null) {
            Intrinsics.d(handler);
            handler.removeCallbacksAndMessages(null);
            this.f25079b = null;
        }
    }

    @Override // com.avery.subtitle.b
    public void pause() {
        this.f25087k = true;
        Handler handler = this.f25079b;
        if (handler != null) {
            Intrinsics.d(handler);
            handler.removeMessages(2184);
        }
    }

    @Override // com.avery.subtitle.b
    public void refreshImmediately() {
        if (i().g()) {
            return;
        }
        this.f25087k = false;
        Handler handler = this.f25079b;
        if (handler != null) {
            Intrinsics.d(handler);
            handler.removeMessages(2184);
            Handler handler2 = this.f25079b;
            Intrinsics.d(handler2);
            handler2.sendEmptyMessage(2185);
        }
    }

    @Override // com.avery.subtitle.b
    public void reset() {
        this.f25087k = false;
        n();
        i().c();
    }

    @Override // com.avery.subtitle.b
    public void resume() {
        start();
    }

    @Override // com.avery.subtitle.b
    public void selectSubtitle(String path, String unicode, y7.b bVar) {
        Intrinsics.g(path, "path");
        Intrinsics.g(unicode, "unicode");
        if (path.length() == 0) {
            if (bVar != null) {
                bVar.a(false);
                return;
            }
            return;
        }
        String md5 = b8.b.a(path);
        if (TextUtils.equals(md5, this.f25085i)) {
            if (bVar != null) {
                bVar.a(true);
                return;
            }
            return;
        }
        this.f25085i = md5;
        b8.a aVarI = i();
        Intrinsics.f(md5, "md5");
        if (!aVarI.e(md5)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("selectSubtitle: load md5 = ");
            sb2.append(md5);
            sb2.append(", path = ");
            sb2.append(path);
            k(md5, path, unicode, true, bVar);
            return;
        }
        this.f25081d.put(this.f25085i, Long.valueOf(System.currentTimeMillis()));
        StringBuilder sb3 = new StringBuilder();
        sb3.append("selectSubtitle: immediately, md5 = ");
        sb3.append(md5);
        sb3.append(", path = ");
        sb3.append(path);
        l(true);
        if (bVar != null) {
            bVar.a(true);
        }
    }

    @Override // com.avery.subtitle.b
    public void setDefaultSubtitle(String path) {
        Intrinsics.g(path, "path");
        String strA = b8.b.a(path);
        if (TextUtils.equals(strA, this.f25085i)) {
            return;
        }
        this.f25085i = strA;
    }

    @Override // com.avery.subtitle.b
    public void setOnSubtitleChangeListener(com.avery.subtitle.b.a listener) {
        Intrinsics.g(listener, "listener");
        this.f25084h = listener;
    }

    @Override // com.avery.subtitle.b
    public void setOnSubtitlePreparedListener(com.avery.subtitle.b.InterfaceC0209b listener) {
        Intrinsics.g(listener, "listener");
        this.f25083g = listener;
    }

    @Override // com.avery.subtitle.b
    public void setSubtitlePath(String path, String unicode) {
        Intrinsics.g(path, "path");
        Intrinsics.g(unicode, "unicode");
        h();
        if (TextUtils.isEmpty(path)) {
            Log.w(f25076q, "loadSubtitleFromRemote: path is null.");
            return;
        }
        String md5 = b8.b.a(path);
        if (!TextUtils.isEmpty(md5)) {
            b8.a aVarI = i();
            Intrinsics.f(md5, "md5");
            if (aVarI.e(md5)) {
                return;
            }
        }
        if (this.f25080c || TextUtils.isEmpty(this.f25085i) || TextUtils.equals(this.f25085i, md5)) {
            Intrinsics.f(md5, "md5");
            k(md5, path, unicode, false, null);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setSubtitlePath: skip~ md5 = ");
        sb2.append(md5);
        sb2.append(", path = ");
        sb2.append(path);
    }

    @Override // com.avery.subtitle.b
    public void start() {
        if (i().g()) {
            return;
        }
        if (this.f25082f == null) {
            Log.w(f25076q, "PlayerControl is not bind, You must bind PlayerControl to " + com.avery.subtitle.b.class.getSimpleName() + " before start() method be called, you can do this by call bindPlayerControl(PlayerControl playerControl) method.");
            return;
        }
        this.f25087k = false;
        Handler handler = this.f25079b;
        if (handler != null) {
            Intrinsics.d(handler);
            handler.removeMessages(2184);
            Handler handler2 = this.f25079b;
            Intrinsics.d(handler2);
            handler2.sendEmptyMessageDelayed(2184, 1000L);
        }
    }

    @Override // com.avery.subtitle.b
    public void stop() {
        this.f25087k = true;
        Handler handler = this.f25079b;
        if (handler != null) {
            Intrinsics.d(handler);
            handler.removeMessages(2184);
        }
    }

    @Override // com.avery.subtitle.b
    public void subtitleDelay(long j11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("subtitleDelay = ");
        sb2.append(j11);
        this.f25086j = j11;
        l(true);
    }
}
