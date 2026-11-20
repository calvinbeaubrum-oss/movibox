package com.transsion.push.utils;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.n;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.push.R$mipmap;
import com.transsion.push.api.IPushProvider;
import com.transsion.sunflower.FSNConfig;
import com.transsion.sunflower.FSNManager;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class FSNControl {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static FSNConfig f57028b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FSNControl f57027a = new FSNControl();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f57029c = LazyKt__LazyJVMKt.b(new Function0<FSNManager>() { // from class: com.transsion.push.utils.FSNControl$mFSNManager$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FSNManager invoke() {
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            com.transsion.sunflower.f fVar = new com.transsion.sunflower.f(applicationA);
            fVar.n(R$mipmap.ic_notification_logo);
            fVar.m(com.blankj.utilcode.util.c.h());
            fVar.k(new Function0<Boolean>() { // from class: com.transsion.push.utils.FSNControl$mFSNManager$2$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(RoomActivityLifecycleCallbacks.f51239a.i());
                }
            });
            fVar.q(new Function0<Boolean>() { // from class: com.transsion.push.utils.FSNControl$mFSNManager$2$1$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(RoomActivityLifecycleCallbacks.f51239a.l());
                }
            });
            FSNControl fSNControl = FSNControl.f57027a;
            fVar.l(fSNControl.e());
            FSNConfig fSNConfigB = fVar.b();
            fVar.r(fSNControl.c(fSNConfigB != null ? fSNConfigB.getDeepLink() : null));
            fVar.o(new Function1<String, Unit>() { // from class: com.transsion.push.utils.FSNControl$mFSNManager$2$1$3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String msg) {
                    Intrinsics.g(msg, "msg");
                    uo.b.a.f(uo.b.f78622a, "qqqq", "sendFSI failed- msg:" + msg, false, 4, null);
                }
            });
            fVar.p(new Function1<String, Unit>() { // from class: com.transsion.push.utils.FSNControl$mFSNManager$2$1$4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String msg) {
                    Intrinsics.g(msg, "msg");
                    uo.b.a.f(uo.b.f78622a, "qqqq", "sendFSI show- msg:" + msg, false, 4, null);
                    com.transsion.push.helper.a.f56923a.c(msg);
                }
            });
            return fVar.a();
        }
    });

    public final Intent c(String str) {
        Object objM163constructorimpl;
        if (str == null) {
            return null;
        }
        IPushProvider iPushProvider = (IPushProvider) com.alibaba.android.arouter.launcher.a.d().h(IPushProvider.class);
        if (iPushProvider != null) {
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            Intent intentD1 = iPushProvider.d1(applicationA);
            intentD1.addFlags(603979776);
            intentD1.setAction("android.intent.action.VIEW");
            intentD1.setData(Uri.parse(str).buildUpon().appendQueryParameter("channel", "alive").build());
            return intentD1;
        }
        try {
            Result.Companion companion = Result.Companion;
            Postcard postcardA = com.alibaba.android.arouter.launcher.a.d().a(Uri.parse(str));
            com.alibaba.android.arouter.core.a.c(postcardA);
            Intent intent = new Intent(Utils.a(), postcardA.getDestination());
            intent.putExtras(postcardA.getExtras());
            objM163constructorimpl = Result.m163constructorimpl(intent);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        return (Intent) (Result.m169isFailureimpl(objM163constructorimpl) ? null : objM163constructorimpl);
    }

    public final void d() {
        if (f57028b == null) {
            g().r(e());
        }
    }

    public final FSNConfig e() {
        String value;
        Object objM163constructorimpl;
        ConfigBean configBeanB = ConfigManager.f53111c.a().b("sa_dauupupup_config", true);
        if (configBeanB == null || (value = configBeanB.getValue()) == null) {
            value = "";
        }
        uo.b.a.f(uo.b.f78622a, "qqqq", "getAppConfig: json:" + value, false, 4, null);
        try {
            Result.Companion companion = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl((FSNConfig) n.e(value, n.h(FSNConfig.class, new Type[0])));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        FSNConfig fSNConfig = null;
        if (Result.m169isFailureimpl(objM163constructorimpl)) {
            objM163constructorimpl = null;
        }
        FSNConfig fSNConfig2 = (FSNConfig) objM163constructorimpl;
        FSNConfig fSNConfigF = f();
        if (fSNConfig2 != null && fSNConfigF != null) {
            fSNConfig2.setEnable(fSNConfigF.getEnable() && fSNConfig2.getEnable());
            fSNConfig = fSNConfig2;
        }
        f57028b = fSNConfig;
        return fSNConfig;
    }

    public final FSNConfig f() {
        String value;
        ConfigBean configBeanB = ConfigManager.f53111c.a().b("dauupupup_config", true);
        if (configBeanB == null || (value = configBeanB.getValue()) == null) {
            value = "";
        }
        uo.b.a.f(uo.b.f78622a, "qqqq", "getAppConfigB: json:" + value, false, 4, null);
        try {
            Result.Companion companion = Result.Companion;
            return (FSNConfig) n.e(value, n.h(FSNConfig.class, new Type[0]));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Object objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
            if (Result.m169isFailureimpl(objM163constructorimpl)) {
                objM163constructorimpl = null;
            }
            return (FSNConfig) objM163constructorimpl;
        }
    }

    public final FSNManager g() {
        return (FSNManager) f57029c.getValue();
    }

    public final void h(String str) {
        d();
        g().m(str);
    }

    public final void i() {
        d();
        g().n();
    }
}
