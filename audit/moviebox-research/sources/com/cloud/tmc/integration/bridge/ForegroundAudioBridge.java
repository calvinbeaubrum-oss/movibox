package com.cloud.tmc.integration.bridge;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.google.gson.JsonObject;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
public final class ForegroundAudioBridge implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, com.cloud.tmc.integration.audio.a> f30466a = new ConcurrentHashMap();

    /* JADX WARN: Multi-variable type inference failed */
    public static final void d(Ref.ObjectRef client) {
        Intrinsics.g(client, "$client");
        com.cloud.tmc.integration.audio.a aVar = (com.cloud.tmc.integration.audio.a) client.element;
        if (aVar != null) {
            aVar.k();
        }
    }

    public static final void e(com.cloud.tmc.integration.audio.a client) {
        Intrinsics.g(client, "$client");
        client.m();
    }

    public static final void f(com.cloud.tmc.integration.audio.a client) {
        Intrinsics.g(client, "$client");
        client.o();
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void destroyForegroundAudio(@cc.f(App.class) App app, @cc.f(Page.class) Page page, @cc.g({"audioPlayerID"}) String str, @cc.c bc.a aVar) {
        String appId;
        if (page == null || app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
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
            com.cloud.tmc.integration.audio.a aVar2 = this.f30466a.get(app.getAppId());
            if (aVar2 != null) {
                aVar2.e(str, aVar);
            } else if (aVar != null) {
                aVar.b();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void getForegroundAudioOption(@cc.f(App.class) App app, @cc.f(Page.class) Page page, @cc.g({"audioPlayerID"}) String str, @cc.g({"optionName"}) String str2, @cc.c bc.a aVar) {
        String appId;
        if (page == null || app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
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
            com.cloud.tmc.integration.audio.a aVar2 = this.f30466a.get(app.getAppId());
            if (aVar2 != null) {
                aVar2.f(str, str2, aVar);
            } else if (aVar != null) {
                aVar.b();
            }
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, com.cloud.tmc.integration.audio.a, java.lang.Object] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @zb.a
    public final void pauseAppAudio(@cc.f(App.class) App app) {
        String appId;
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            return;
        }
        String appId2 = app.getAppId();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this.f30466a) {
            ?? r11 = this.f30466a.get(appId2);
            objectRef.element = r11;
            if (((com.cloud.tmc.integration.audio.a) r11) == null) {
                ?? aVar = new com.cloud.tmc.integration.audio.a(app);
                Map<String, com.cloud.tmc.integration.audio.a> map = this.f30466a;
                Intrinsics.f(appId2, "appId");
                map.put(appId2, (com.cloud.tmc.integration.audio.a) aVar);
                objectRef.element = aVar;
            }
        }
        com.cloud.tmc.integration.audio.a aVar2 = (com.cloud.tmc.integration.audio.a) objectRef.element;
        if (aVar2 != null) {
            aVar2.r(true);
        }
        com.cloud.tmc.kernel.utils.e.a(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.integration.bridge.e
            @Override // java.lang.Runnable
            public final void run() {
                ForegroundAudioBridge.d(objectRef);
            }
        });
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void pauseForegroundAudio(@cc.f(App.class) App app, @cc.f(Page.class) Page page, @cc.g({"audioPlayerID"}) String str, @cc.c bc.a aVar) {
        String appId;
        if (page == null || app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
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
            com.cloud.tmc.integration.audio.a aVar2 = this.f30466a.get(app.getAppId());
            if (aVar2 != null) {
                aVar2.j(str, aVar);
            } else if (aVar != null) {
                aVar.b();
            }
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void playForegroundAudio(@cc.f(App.class) App app, @cc.f(Page.class) Page page, @cc.g({"audioPlayerID"}) String str, @cc.c bc.a aVar) {
        String appId;
        if (page == null || app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
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
            com.cloud.tmc.integration.audio.a aVar2 = this.f30466a.get(app.getAppId());
            if (aVar2 != null) {
                aVar2.l(str, aVar);
            } else if (aVar != null) {
                aVar.b();
            }
        }
    }

    @zb.a
    public final void releaseAppAudio(@cc.f(App.class) App app) {
        String appId;
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            return;
        }
        final com.cloud.tmc.integration.audio.a aVarRemove = this.f30466a.remove(app.getAppId());
        if (aVarRemove == null) {
            return;
        }
        com.cloud.tmc.kernel.utils.e.a(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.integration.bridge.c
            @Override // java.lang.Runnable
            public final void run() {
                ForegroundAudioBridge.e(aVarRemove);
            }
        });
    }

    @zb.a
    public final void restoreAppAudio(@cc.f(App.class) App app) {
        String appId;
        if (app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
            return;
        }
        final com.cloud.tmc.integration.audio.a aVar = this.f30466a.get(app.getAppId());
        if (aVar == null) {
            return;
        }
        com.cloud.tmc.kernel.utils.e.a(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.integration.bridge.d
            @Override // java.lang.Runnable
            public final void run() {
                ForegroundAudioBridge.f(aVar);
            }
        });
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void seekForegroundAudio(@cc.f(App.class) App app, @cc.f(Page.class) Page page, @cc.g({"audioPlayerID"}) String str, @cc.g({RequestParameters.POSITION}) float f11, @cc.c bc.a aVar) {
        String appId;
        if (page == null || app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
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
            com.cloud.tmc.integration.audio.a aVar2 = this.f30466a.get(app.getAppId());
            if (aVar2 != null) {
                aVar2.p(str, f11, aVar);
            } else if (aVar != null) {
                aVar.b();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void setForegroundAudioOption(@cc.f(App.class) App app, @cc.f(Page.class) Page page, @cc.g({"audioPlayerID"}) String str, @cc.g({"option"}) JsonObject jsonObject, @cc.c bc.a aVar) {
        String appId;
        com.cloud.tmc.integration.audio.a aVar2;
        if (page == null || app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
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
        String appId2 = app.getAppId();
        synchronized (this.f30466a) {
            aVar2 = this.f30466a.get(appId2);
            if (aVar2 == null) {
                aVar2 = new com.cloud.tmc.integration.audio.a(app);
                Map<String, com.cloud.tmc.integration.audio.a> map = this.f30466a;
                Intrinsics.f(appId2, "appId");
                map.put(appId2, aVar2);
            }
        }
        com.cloud.tmc.integration.audio.a aVar3 = aVar2;
        if (aVar3 != null) {
            aVar3.s(str, jsonObject, aVar);
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void startMonitorForegroundAudio(@cc.f(App.class) App app, @cc.f(Page.class) Page page, @cc.g({"audioPlayerID"}) String str, @cc.c bc.a aVar) {
        String appId;
        if (page == null || app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
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
            com.cloud.tmc.integration.audio.a aVar2 = this.f30466a.get(app.getAppId());
            if (aVar2 != null) {
                aVar2.d(str, aVar);
            } else if (aVar != null) {
                aVar.b();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void stopForegroundAudio(@cc.f(App.class) App app, @cc.f(Page.class) Page page, @cc.g({"audioPlayerID"}) String str, @cc.c bc.a aVar) {
        String appId;
        if (page == null || app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
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
            com.cloud.tmc.integration.audio.a aVar2 = this.f30466a.get(app.getAppId());
            if (aVar2 != null) {
                aVar2.t(str, aVar);
            } else if (aVar != null) {
                aVar.b();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void stopMonitorForegroundAudio(@cc.f(App.class) App app, @cc.f(Page.class) Page page, @cc.g({"audioPlayerID"}) String str, @cc.c bc.a aVar) {
        String appId;
        if (page == null || app == null || (appId = app.getAppId()) == null || appId.length() == 0) {
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
            com.cloud.tmc.integration.audio.a aVar2 = this.f30466a.get(app.getAppId());
            if (aVar2 != null) {
                aVar2.n(str, aVar);
            } else if (aVar != null) {
                aVar.b();
            }
        }
    }
}
