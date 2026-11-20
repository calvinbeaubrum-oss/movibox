package com.transsnet.downloader.util;

import androidx.lifecycle.c0;
import com.tencent.mmkv.MMKV;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.json.JSONObject;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class ShortTvMmkv {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f61144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f61145d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ShortTvMmkv f61142a = new ShortTvMmkv();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f61143b = LazyKt__LazyJVMKt.b(new Function0<MMKV>() { // from class: com.transsnet.downloader.util.ShortTvMmkv$mmkv$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MMKV invoke() {
            return MMKV.z("short_tv");
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f61146e = 20;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f61147f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static CopyOnWriteArrayList<a> f61148g = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c0<Boolean> f61149h = new c0<>();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        void a(String str, int i11);
    }

    public final void a(a listener) {
        Intrinsics.g(listener, "listener");
        if (f61148g.contains(listener)) {
            return;
        }
        f61148g.add(listener);
    }

    public final int b() {
        int iOptInt;
        String value;
        if (f61144c <= 0) {
            try {
                ConfigBean configBeanB = ConfigManager.f53111c.a().b("shorts_unlock_config", true);
                iOptInt = (configBeanB == null || (value = configBeanB.getValue()) == null) ? f61146e : new JSONObject(value).optInt("maxUnlockCount");
            } catch (Exception unused) {
                iOptInt = f61146e;
            }
            f61144c = iOptInt;
        }
        return f61144c;
    }

    public final int c(String subjectId) {
        Intrinsics.g(subjectId, "subjectId");
        return d().getInt(subjectId, b());
    }

    public final MMKV d() {
        Object value = f61143b.getValue();
        Intrinsics.f(value, "<get-mmkv>(...)");
        return (MMKV) value;
    }

    public final int e() {
        int iOptInt;
        String value;
        if (f61145d <= 0) {
            try {
                ConfigBean configBeanB = ConfigManager.f53111c.a().b("shorts_unlock_config", true);
                iOptInt = (configBeanB == null || (value = configBeanB.getValue()) == null) ? f61147f : new JSONObject(value).optInt("perUnlockCount");
            } catch (Exception unused) {
                iOptInt = f61147f;
            }
            f61145d = iOptInt;
        }
        return f61145d;
    }

    public final boolean f() {
        return Boolean.parseBoolean(d().getString("KEY_AUTO_UNLOCK_STATE", "false"));
    }

    public final void g(a listener) {
        Intrinsics.g(listener, "listener");
        f61148g.remove(listener);
    }

    public final void h(String subjectId, int i11) {
        Intrinsics.g(subjectId, "subjectId");
        d().putInt(subjectId, i11);
        for (a aVar : f61148g) {
            if (aVar != null) {
                aVar.a(subjectId, i11);
            }
        }
    }

    public final void i(boolean z11) {
        d().putString("KEY_AUTO_UNLOCK_STATE", String.valueOf(z11));
        f61149h.q(Boolean.valueOf(z11));
    }
}
