package ce;

import android.os.SystemClock;
import com.cloud.tmc.offline.download.utils.OfflineUtils;
import com.google.gson.JsonObject;
import com.hisavana.common.tracking.TrackingKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public abstract class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f14776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2<? super b, ? super yd.a<?>, Unit> f14777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14778d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f14779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f14780g;

    public a(String name, long j11) {
        Intrinsics.g(name, "name");
        this.f14775a = name;
        this.f14776b = j11;
        this.f14778d = 5;
        this.f14780g = OfflineUtils.f32081a.s();
    }

    public /* synthetic */ a(String str, long j11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? SystemClock.elapsedRealtime() : j11);
    }

    @Override // ce.b
    public Function2<b, yd.a<?>, Unit> J() {
        return this.f14777c;
    }

    @Override // ce.b
    public void K(int i11) {
        this.f14779f = i11;
    }

    @Override // ce.b
    public long L() {
        return this.f14776b;
    }

    @Override // ce.b
    public boolean M() {
        return false;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(b other) {
        int priority;
        int priority2;
        Intrinsics.g(other, "other");
        if (getPriority() == other.getPriority()) {
            priority = getSequence();
            priority2 = other.getSequence();
        } else {
            priority = getPriority();
            priority2 = other.getPriority();
        }
        return priority - priority2;
    }

    public String b() {
        return this.f14780g;
    }

    public String c() {
        return this.f14775a;
    }

    @Override // ce.b
    public int getPriority() {
        return this.f14778d;
    }

    @Override // ce.b
    public int getSequence() {
        return this.f14779f;
    }

    public String toString() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", c());
        jsonObject.addProperty("id", b());
        jsonObject.addProperty("sequence", Integer.valueOf(getSequence()));
        jsonObject.addProperty(TrackingKey.PRIORITY, Integer.valueOf(getPriority()));
        jsonObject.addProperty("isIdleRunTask", Boolean.valueOf(M()));
        String string = jsonObject.toString();
        Intrinsics.f(string, "JsonObject().apply {\n   …ask)\n        }.toString()");
        return string;
    }
}
