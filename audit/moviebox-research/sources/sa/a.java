package sa;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.resource.IResourceProcessor;
import com.cloud.tmc.miniutils.util.j;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.google.gson.JsonObject;
import com.hisavana.common.tracking.TrackingKey;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import wc.e;
import wc.f;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0838a f76261f = new C0838a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f76262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f76263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SoundPool f76264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AtomicBoolean f76265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ConcurrentHashMap<String, b> f76266e;

    /* JADX INFO: renamed from: sa.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0838a {
        public C0838a() {
        }

        public /* synthetic */ C0838a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f76267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f76268b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f76269c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f76270d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f76271e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f76272f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f76273g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Integer f76274h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Integer f76275i;

        public b(String id2) {
            Intrinsics.g(id2, "id");
            this.f76267a = id2;
            this.f76269c = 1.0f;
            this.f76270d = 1.0f;
            this.f76272f = 1.0f;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final boolean a(JsonObject jsonObject) {
            String str;
            if (jsonObject != null) {
                for (String str2 : jsonObject.keySet()) {
                    if (str2 != null) {
                        switch (str2.hashCode()) {
                            case -1165461084:
                                if (!str2.equals(TrackingKey.PRIORITY)) {
                                    continue;
                                } else {
                                    int asInt = jsonObject.get(str2).getAsInt();
                                    if (asInt < 0) {
                                        return false;
                                    }
                                    this.f76273g = asInt;
                                }
                                break;
                            case -810883302:
                                if (!str2.equals("volume")) {
                                    continue;
                                } else {
                                    float asFloat = jsonObject.get(str2).getAsFloat();
                                    if (asFloat < 0.0f || asFloat > 1.0f) {
                                        return false;
                                    }
                                    this.f76269c = jsonObject.get(str2).getAsFloat();
                                    this.f76270d = jsonObject.get(str2).getAsFloat();
                                }
                                break;
                            case 114148:
                                if (str2.equals("src")) {
                                    this.f76271e = jsonObject.get(str2).getAsString();
                                }
                                break;
                            case 3493088:
                                if (!str2.equals("rate")) {
                                    continue;
                                } else {
                                    float asFloat2 = jsonObject.get(str2).getAsFloat();
                                    if (asFloat2 < 0.5f || asFloat2 > 2.0f) {
                                        return false;
                                    }
                                    this.f76272f = asFloat2;
                                }
                                break;
                        }
                    }
                }
            }
            String str3 = this.f76271e;
            return (str3 == null || str3.length() == 0 || (str = this.f76271e) == null || !l.L(str, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null)) ? false : true;
        }

        public final float b() {
            return this.f76269c;
        }

        public final int c() {
            return this.f76268b;
        }

        public final int d() {
            return this.f76273g;
        }

        public final float e() {
            return this.f76272f;
        }

        public final Integer f() {
            return this.f76274h;
        }

        public final float g() {
            return this.f76270d;
        }

        public final String h() {
            return this.f76271e;
        }

        public final Integer i() {
            return this.f76275i;
        }

        public final void j(Integer num) {
            this.f76274h = num;
        }

        public final void k(Integer num) {
            this.f76275i = num;
        }

        public String toString() {
            return "PlayConfig(id='" + this.f76267a + "', loop=" + this.f76268b + ", leftVolume=" + this.f76269c + ", rightVolume=" + this.f76270d + ", src=" + this.f76271e + ", rate=" + this.f76272f + ", priority=" + this.f76273g + ", resId=" + this.f76274h + ", streamId=" + this.f76275i + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bc.a f76276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f76277b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f76278c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f76279d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f76280e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ b f76281f;

        public c(bc.a aVar, Context context, a aVar2, String str, String str2, b bVar) {
            this.f76276a = aVar;
            this.f76277b = context;
            this.f76278c = aVar2;
            this.f76279d = str;
            this.f76280e = str2;
            this.f76281f = bVar;
        }

        @Override // wc.f
        public /* synthetic */ void a(String str, int i11, String str2, long j11, long j12) {
            e.a(this, str, i11, str2, j11, j12);
        }

        @Override // wc.f
        public void b(String str, String errorCode, String str2, IOException e11, String str3) {
            Intrinsics.g(errorCode, "errorCode");
            Intrinsics.g(e11, "e");
            TmcLogger.f("AudioEffectClient", str2);
            bc.a aVar = this.f76276a;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // wc.f
        public void c(String str, String str2) {
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(this.f76277b, this.f76278c.e(), this.f76279d, this.f76280e);
            b bVar = this.f76281f;
            SoundPool soundPool = this.f76278c.f76264c;
            bVar.j(soundPool != null ? Integer.valueOf(soundPool.load(this.f76280e, this.f76281f.d())) : null);
            bc.a aVar = this.f76276a;
            if (aVar != null) {
                aVar.g();
            }
        }

        @Override // wc.f
        public void f(String str, int i11, String str2) {
        }

        @Override // wc.f
        public void g(String str, String str2) {
            TmcLogger.f("AudioEffectClient", str + " cancel request.");
            bc.a aVar = this.f76276a;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public a(String mAppId, int i11) {
        Intrinsics.g(mAppId, "mAppId");
        this.f76262a = mAppId;
        this.f76263b = i11;
        this.f76265d = new AtomicBoolean(false);
        this.f76266e = new ConcurrentHashMap<>();
        this.f76264c = new SoundPool.Builder().setMaxStreams(kotlin.ranges.a.g(this.f76263b, 5)).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).build()).build();
    }

    public /* synthetic */ a(String str, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i12 & 2) != 0 ? 1 : i11);
    }

    public final synchronized void b(String id2, bc.a aVar) {
        Intrinsics.g(id2, "id");
        try {
            TmcLogger.f("AudioEffectClient", "destroy !" + id2);
            b bVarRemove = this.f76266e.remove(id2);
            if (bVarRemove == null) {
                if (aVar != null) {
                    aVar.b();
                }
                return;
            }
            Integer numF = bVarRemove.f();
            if (numF == null) {
                if (aVar != null) {
                    aVar.b();
                }
                return;
            }
            numF.intValue();
            SoundPool soundPool = this.f76264c;
            if (soundPool != null) {
                soundPool.unload(numF.intValue());
            }
            if (aVar != null) {
                aVar.g();
            }
        } catch (Throwable th2) {
            TmcLogger.h("AudioEffectClient", th2);
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public final void c(Context context, b bVar, bc.a aVar) {
        String str = "" + System.currentTimeMillis();
        String strH = bVar.h();
        if (strH == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        List listE0 = StringsKt__StringsKt.E0(strH, new String[]{"/"}, false, 0, 6, null);
        if (!listE0.isEmpty()) {
            str = (String) listE0.get(listE0.size() - 1);
        }
        String str2 = ((PathProxy) tc.a.a(PathProxy.class)).getBaseMiniAppPath(this.f76262a) + "/temp_data/" + str;
        j.l(str2);
        ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).downloadPackage(this.f76262a, bVar.h(), str2, new HashMap(), null, new c(aVar, context, this, strH, str2, bVar));
    }

    public final String d(String str) {
        IResourceProcessor iResourceProcessor;
        File file;
        if (str == null || str.length() == 0) {
            return null;
        }
        if ((l.L(str, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null) && !StringsKt__StringsKt.Q(str, ".miniapp.transsion.com", false, 2, null)) || (iResourceProcessor = (IResourceProcessor) tc.a.a(IResourceProcessor.class)) == null || (file = iResourceProcessor.get(str, this.f76262a)) == null) {
            return null;
        }
        return file.getAbsolutePath();
    }

    public final String e() {
        return this.f76262a;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final synchronized void f(String id2, String optionName, bc.a aVar) {
        Intrinsics.g(id2, "id");
        Intrinsics.g(optionName, "optionName");
        try {
            b bVar = this.f76266e.get(id2);
            if (bVar == null) {
                if (aVar != null) {
                    aVar.b();
                }
                return;
            }
            JsonObject jsonObject = new JsonObject();
            switch (optionName.hashCode()) {
                case -1165461084:
                    if (optionName.equals(TrackingKey.PRIORITY)) {
                        jsonObject.addProperty(TrackingKey.PRIORITY, Integer.valueOf(bVar.d()));
                    }
                    break;
                case -810883302:
                    if (optionName.equals("volume")) {
                        jsonObject.addProperty("volume", Float.valueOf(bVar.b()));
                    }
                    break;
                case 114148:
                    if (optionName.equals("src")) {
                        jsonObject.addProperty("src", bVar.h());
                    }
                    break;
                case 3493088:
                    if (optionName.equals("rate")) {
                        jsonObject.addProperty("rate", Float.valueOf(bVar.e()));
                    }
                    break;
            }
            jsonObject.addProperty("id", id2);
            jsonObject.addProperty("success", Boolean.TRUE);
            if (aVar != null) {
                aVar.a(jsonObject);
            }
        } catch (Throwable th2) {
            TmcLogger.h("AudioEffectClient", th2);
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public final String g(Context context, String str) {
        String string;
        if (str != null && str.length() != 0 && (string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, this.f76262a, str)) != null) {
            if (new File(string).exists()) {
                return string;
            }
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).remove(context, this.f76262a, str);
        }
        return null;
    }

    public final synchronized void h(String id2, bc.a aVar) {
        Intrinsics.g(id2, "id");
        try {
            if (this.f76265d.get()) {
                if (aVar != null) {
                    aVar.b();
                }
                TmcLogger.f("AudioEffectClient", "app is on background, must not play!");
                return;
            }
            b bVar = this.f76266e.get(id2);
            if (bVar == null) {
                if (aVar != null) {
                    aVar.b();
                }
                return;
            }
            Integer numF = bVar.f();
            if (numF == null) {
                if (aVar != null) {
                    aVar.b();
                }
                return;
            }
            numF.intValue();
            SoundPool soundPool = this.f76264c;
            bVar.k(soundPool != null ? Integer.valueOf(soundPool.play(numF.intValue(), bVar.b(), bVar.g(), bVar.d(), bVar.c(), bVar.e())) : null);
            if (aVar != null) {
                aVar.g();
            }
        } catch (Throwable th2) {
            TmcLogger.h("AudioEffectClient", th2);
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public final synchronized void i() {
        try {
            TmcLogger.f("AudioEffectClient", "releaseAll !");
            this.f76266e.clear();
            SoundPool soundPool = this.f76264c;
            if (soundPool != null) {
                soundPool.release();
            }
        } catch (Throwable th2) {
            TmcLogger.h("AudioEffectClient", th2);
        }
    }

    public final void j(boolean z11) {
        this.f76265d.set(z11);
    }

    public final synchronized void k(Context context, String id2, JsonObject jsonObject, bc.a aVar) {
        try {
            Intrinsics.g(context, "context");
            Intrinsics.g(id2, "id");
            try {
                b bVar = this.f76266e.get(id2);
                if (bVar != null) {
                    if (aVar != null) {
                        aVar.b();
                    }
                    TmcLogger.f("AudioEffectClient", id2 + " has existed!!!");
                    return;
                }
                if (bVar == null) {
                    bVar = new b(id2);
                    this.f76266e.put(id2, bVar);
                }
                if (!bVar.a(jsonObject)) {
                    if (aVar != null) {
                        aVar.b();
                    }
                    TmcLogger.f("AudioEffectClient", id2 + " convertParam error.");
                    return;
                }
                String strD = d(bVar.h());
                if ((strD != null && strD.length() != 0) || ((strD = g(context, bVar.h())) != null && strD.length() != 0)) {
                    SoundPool soundPool = this.f76264c;
                    bVar.j(soundPool != null ? Integer.valueOf(soundPool.load(strD, bVar.d())) : null);
                    if (aVar != null) {
                        aVar.g();
                    }
                    return;
                }
                c(context, bVar, aVar);
            } catch (Throwable th2) {
                TmcLogger.h("AudioEffectClient", th2);
                if (aVar != null) {
                    aVar.b();
                }
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    public final synchronized void l(String id2, bc.a aVar) {
        Intrinsics.g(id2, "id");
        try {
            b bVar = this.f76266e.get(id2);
            if (bVar == null) {
                if (aVar != null) {
                    aVar.b();
                }
                return;
            }
            Integer numI = bVar.i();
            if (numI == null) {
                if (aVar != null) {
                    aVar.b();
                }
                return;
            }
            SoundPool soundPool = this.f76264c;
            if (soundPool != null) {
                soundPool.stop(numI.intValue());
            }
            if (aVar != null) {
                aVar.g();
            }
        } catch (Throwable th2) {
            TmcLogger.h("AudioEffectClient", th2);
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public final synchronized void m() {
        try {
            SoundPool soundPool = this.f76264c;
            if (soundPool != null) {
                soundPool.autoPause();
            }
        } catch (Throwable th2) {
            TmcLogger.h("AudioEffectClient", th2);
        }
    }
}
