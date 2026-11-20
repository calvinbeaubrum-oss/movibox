package com.transsion.subroom.app;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import androidx.appcompat.app.f;
import androidx.work.a;
import com.tn.lib.net.dns.or.CacheIpPool;
import com.tn.lib.util.bean.ProcessType;
import com.transsion.baselib.net.AppLifeStatusInterceptor;
import com.transsion.baselib.net.LoginInterceptor;
import com.transsion.baselib.net.c;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baselib.utils.g;
import com.transsion.baseui.activity.d;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.player.orplayer.global.TnPlayerManager;
import com.transsion.startup.StartupManager;
import com.transsion.startup.pref.al.UpdateUtils;
import com.transsion.startup.pref.consume.AppStartDotState;
import com.transsion.startup.pref.consume.AppStartReport;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.k;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public class SubRoomApp extends Application implements ComponentCallbacks2, a.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f58043b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f58044a = LazyKt__LazyJVMKt.b(new Function0<Boolean>() { // from class: com.transsion.subroom.app.SubRoomApp$isMainProcess$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(this.this$0.c());
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Function0<Boolean> d() {
            return new Function0<Boolean>() { // from class: com.transsion.subroom.app.SubRoomApp$Companion$isAsyncPlayerRequest$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    ConfigBean configBeanB = ConfigManager.f53111c.a().b("player_async", true);
                    return Boolean.valueOf(Intrinsics.b(configBeanB != null ? configBeanB.getValue() : null, "false"));
                }
            };
        }

        public final Function0<Boolean> e() {
            return new Function0<Boolean>() { // from class: com.transsion.subroom.app.SubRoomApp$Companion$isMultiplePlayerRequest$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(!g.f51315a.b());
                }
            };
        }

        public final Function0<Integer> f() {
            return new Function0<Integer>() { // from class: com.transsion.subroom.app.SubRoomApp$Companion$isUsePlayerTypeRequest$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Integer invoke() {
                    Integer numL;
                    ConfigBean configBeanB = ConfigManager.f53111c.a().b("sb_player_type", true);
                    String value = configBeanB != null ? configBeanB.getValue() : null;
                    int iIntValue = 0;
                    if (value != null && value.length() != 0 && (numL = k.l(value)) != null) {
                        iIntValue = numL.intValue();
                    }
                    return Integer.valueOf(iIntValue);
                }
            };
        }
    }

    @Override // androidx.work.a.c
    public a a() {
        a aVarA = new a.b().b(4).a();
        Intrinsics.f(aVarA, "Builder()\n            .s…NFO)\n            .build()");
        return aVarA;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        StartupManager.f57960d.a().p(context);
        c.f51224a.c();
    }

    public final boolean c() {
        return sp.a.f76444a.a(this) == ProcessType.MAIN_PROCESS;
    }

    public final boolean d() {
        return ((Boolean) this.f58044a.getValue()).booleanValue();
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        if (d()) {
            TnPlayerManager tnPlayerManager = TnPlayerManager.f54684a;
            Companion companion = f58043b;
            tnPlayerManager.t(companion.e());
            tnPlayerManager.s(companion.d());
            tnPlayerManager.u(companion.f());
            ep.c cVar = ep.c.f64339a;
            cVar.a(new LoginInterceptor());
            cVar.a(new AppLifeStatusInterceptor());
            CacheIpPool.f49384a.j("api3.aoneroom.com");
            StartupManager.f57960d.a().N(this);
            if (!RoomAppMMKV.f51271a.a().getBoolean("dark_mode_follow_sys", false)) {
                f.O(2);
            }
            registerActivityLifecycleCallbacks(RoomActivityLifecycleCallbacks.f51239a);
            UpdateUtils.f57967a.b();
        } else {
            StartupManager.f57960d.a().H(this);
        }
        AppStartReport.f57974a.d(new AppStartDotState(AppStartDotState.APP_END, 0L, 2, null));
        d.b(null, 1, null);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i11) {
        super.onTrimMemory(i11);
        StartupManager.f57960d.a().R(i11, d());
    }
}
