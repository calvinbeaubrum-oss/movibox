package com.cloud.tmc.integration;

import android.content.Context;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.network.IConfigStrategyProxy;
import com.tencent.mmkv.MMKV;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class MiniAppConfigHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static MMKV f30371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static WeakReference<MiniAppConfigStore> f30372c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f30374e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f30377h = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MiniAppConfigHelper f30370a = new MiniAppConfigHelper();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Byte[] f30373d = new Byte[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f30375f = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.cloud.tmc.integration.MiniAppConfigHelper$KEY_OFFLINE_CONFIG$2
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return ((IConfigStrategyProxy) tc.a.a(IConfigStrategyProxy.class)).getOfflineConfigKey();
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f30376g = ":mini";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f30378i = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.cloud.tmc.integration.MiniAppConfigHelper$DEFAULT_OFFLINE_DOWNLOAD$2
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return ((IConfigStrategyProxy) tc.a.a(IConfigStrategyProxy.class)).getOfflineConfigDefaultValue();
        }
    });

    @JvmStatic
    public static final MMKV j() {
        try {
            if (!f30374e) {
                synchronized (f30373d) {
                    try {
                        if (!f30374e) {
                            f30371b = MMKV.A("MiniAppConfigMMKV", 2);
                            f30374e = true;
                        }
                        Unit unit = Unit.f68710a;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            TmcLogger.h("getMultiMMKV", th3);
        }
        return f30371b;
    }

    public final MiniAppConfigStore a(Context context) {
        Intrinsics.g(context, "context");
        WeakReference<MiniAppConfigStore> weakReference = f30372c;
        MiniAppConfigStore miniAppConfigStore = weakReference != null ? weakReference.get() : null;
        if (miniAppConfigStore != null) {
            return miniAppConfigStore;
        }
        MiniAppConfigStore miniAppConfigStore2 = new MiniAppConfigStore(context);
        f30372c = new WeakReference<>(miniAppConfigStore2);
        return miniAppConfigStore2;
    }

    public final boolean b(String str, boolean z11) {
        try {
            MMKV mmkvJ = j();
            String string = mmkvJ != null ? mmkvJ.getString(str, String.valueOf(z11)) : null;
            if (string != null && string.length() != 0) {
                return Boolean.parseBoolean(string);
            }
            return z11;
        } catch (Exception unused) {
            return z11;
        }
    }

    public final int c(String str, int i11) {
        String string;
        try {
            MMKV mmkvJ = j();
            if (mmkvJ != null) {
                string = mmkvJ.getString(str, i11 + "");
            } else {
                string = null;
            }
            if (string != null && string.length() != 0) {
                return Integer.parseInt(string);
            }
            return i11;
        } catch (Exception unused) {
            return i11;
        }
    }

    public final long d(String str, long j11) {
        String string;
        try {
            MMKV mmkvJ = j();
            if (mmkvJ != null) {
                string = mmkvJ.getString(str, j11 + "");
            } else {
                string = null;
            }
            if (string != null && string.length() != 0) {
                return Long.parseLong(string);
            }
            return j11;
        } catch (Exception unused) {
            return j11;
        }
    }

    public final String e(String str, String defaultValue) {
        Intrinsics.g(defaultValue, "defaultValue");
        try {
            MMKV mmkvJ = j();
            String string = mmkvJ != null ? mmkvJ.getString(str, defaultValue) : null;
            return (string == null || string.length() == 0) ? defaultValue : string;
        } catch (Exception unused) {
            return defaultValue;
        }
    }

    public final boolean f() {
        return f30377h;
    }

    public final String g() {
        return (String) f30378i.getValue();
    }

    public final String h() {
        return f30376g;
    }

    public final String i() {
        return (String) f30375f.getValue();
    }

    public final void k() {
        try {
            j();
        } catch (Throwable th2) {
            TmcLogger.h("warmUpConfigMMKV", th2);
        }
    }
}
