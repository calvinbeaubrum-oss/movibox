package com.cloud.tmc.integration.bridge;

import android.content.Context;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.google.gson.JsonObject;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AudioEffectBridge implements BridgeExtension {
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, sa.a> f30442a = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final void c(sa.a it) {
        Intrinsics.g(it, "$it");
        it.i();
    }

    public static final void d(sa.a it) {
        Intrinsics.g(it, "$it");
        it.j(true);
        it.m();
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void createAppAudioEffect(@cc.f(App.class) App app, @cc.g({"size"}) Integer num, @cc.c bc.a aVar) {
        String appId;
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0 || num == null || num.intValue() <= 0) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        try {
            synchronized (this.f30442a) {
                try {
                    sa.a aVar2 = this.f30442a.get(app.getAppId());
                    sa.a aVar3 = aVar2;
                    if (aVar3 != null) {
                        aVar3.i();
                    }
                    if (aVar2 == null) {
                        String appId2 = app.getAppId();
                        Intrinsics.f(appId2, "app.appId");
                        sa.a aVar4 = new sa.a(appId2, num.intValue());
                        ConcurrentHashMap<String, sa.a> concurrentHashMap = this.f30442a;
                        String appId3 = app.getAppId();
                        Intrinsics.f(appId3, "app.appId");
                        concurrentHashMap.put(appId3, aVar4);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (aVar != null) {
                aVar.g();
            }
        } catch (Throwable th3) {
            TmcLogger.h("AudioEffectBridge", th3);
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void destroyAudioEffect(@cc.f(App.class) App app, @cc.g({"id"}) String str, @cc.c bc.a aVar) {
        String appId;
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            if (str == null || str.length() == 0) {
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            sa.a aVar2 = this.f30442a.get(app.getAppId());
            if (aVar2 != null) {
                aVar2.b(str, aVar);
            } else if (aVar != null) {
                aVar.b();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void getAudioEffectOption(@cc.f(App.class) App app, @cc.g({"id"}) String str, @cc.g({"optionName"}) String str2, @cc.c bc.a aVar) {
        String appId;
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        sa.a aVar2 = this.f30442a.get(app.getAppId());
        if (aVar2 != null) {
            aVar2.f(str, str2, aVar);
        } else if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void playAudioEffect(@cc.f(App.class) App app, @cc.g({"id"}) String str, @cc.c bc.a aVar) {
        String appId;
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            if (str == null || str.length() == 0) {
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            sa.a aVar2 = this.f30442a.get(app.getAppId());
            if (aVar2 != null) {
                aVar2.h(str, aVar);
            } else if (aVar != null) {
                aVar.b();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void releaseAppAudioEffect(@cc.f(App.class) App app) {
        final sa.a aVarRemove;
        if (app != null) {
            try {
                String appId = app.getAppId();
                if (appId == null || appId.length() == 0 || (aVarRemove = this.f30442a.remove(app.getAppId())) == null) {
                    return;
                }
                com.cloud.tmc.kernel.utils.e.a(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.integration.bridge.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioEffectBridge.c(aVarRemove);
                    }
                });
            } catch (Throwable th2) {
                TmcLogger.h("AudioEffectBridge", th2);
            }
        }
    }

    @zb.a
    public final void restoreAppAudioEffect(@cc.f(App.class) App app) {
        String appId;
        sa.a aVar;
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0 || (aVar = this.f30442a.get(app.getAppId())) == null) {
            return;
        }
        aVar.j(false);
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void setAudioEffectOption(@cc.f(App.class) App app, @cc.g({"id"}) String str, @cc.g({"option"}) JsonObject jsonObject, @cc.c bc.a aVar) {
        String appId;
        sa.a aVar2;
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        tb.b appContext = app.getAppContext();
        if (appContext == null || appContext.getContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (str == null || str.length() == 0) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        sa.a aVar3 = this.f30442a.get(app.getAppId());
        if (aVar3 == null) {
            synchronized (this.f30442a) {
                aVar2 = this.f30442a.get(app.getAppId());
                if (aVar2 == null) {
                    String appId2 = app.getAppId();
                    Intrinsics.f(appId2, "app.appId");
                    aVar2 = new sa.a(appId2, 0, 2, null);
                    ConcurrentHashMap<String, sa.a> concurrentHashMap = this.f30442a;
                    String appId3 = app.getAppId();
                    Intrinsics.f(appId3, "app.appId");
                    concurrentHashMap.put(appId3, aVar2);
                }
            }
            aVar3 = aVar2;
        }
        sa.a aVar4 = aVar3;
        if (aVar4 != null) {
            Context context = appContext.getContext();
            Intrinsics.f(context, "appContext.context");
            aVar4.k(context, str, jsonObject, aVar);
        }
    }

    @zb.a
    public final void stopAppAudioEffect(@cc.f(App.class) App app) {
        if (app != null) {
            try {
                String appId = app.getAppId();
                if (appId != null && appId.length() != 0) {
                    sa.a aVar = this.f30442a.get(app.getAppId());
                    if (aVar != null) {
                        final sa.a aVar2 = aVar;
                        if (aVar2 != null) {
                            com.cloud.tmc.kernel.utils.e.a(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.integration.bridge.a
                                @Override // java.lang.Runnable
                                public final void run() {
                                    AudioEffectBridge.d(aVar2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    synchronized (this.f30442a) {
                        if (this.f30442a.get(app.getAppId()) == null) {
                            String appId2 = app.getAppId();
                            Intrinsics.f(appId2, "app.appId");
                            sa.a aVar3 = new sa.a(appId2, 0, 2, null);
                            aVar3.j(true);
                            ConcurrentHashMap<String, sa.a> concurrentHashMap = this.f30442a;
                            String appId3 = app.getAppId();
                            Intrinsics.f(appId3, "app.appId");
                            concurrentHashMap.put(appId3, aVar3);
                        }
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.h("AudioEffectBridge", th2);
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void stopAudioEffect(@cc.f(App.class) App app, @cc.g({"id"}) String str, @cc.c bc.a aVar) {
        String appId;
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            if (str == null || str.length() == 0) {
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            sa.a aVar2 = this.f30442a.get(app.getAppId());
            if (aVar2 != null) {
                aVar2.l(str, aVar);
            } else if (aVar != null) {
                aVar.b();
            }
        }
    }
}
