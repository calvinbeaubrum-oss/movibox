package za;

import android.os.Bundle;
import bb.c;
import bb.d;
import bb.e;
import bb.f;
import bb.h;
import bb.i;
import bb.j;
import bb.k;
import bb.l;
import bb.m;
import com.cloud.tmc.integration.chain.page.PageChainContext;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.collections.g;
import kotlin.jvm.internal.Intrinsics;
import xa.q;
import ya.b;

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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f81892a = new a();

    public final void a(wa.a appChainContext, Bundle dataBundle) {
        Intrinsics.g(appChainContext, "appChainContext");
        Intrinsics.g(dataBundle, "dataBundle");
        try {
            if (appChainContext.h() instanceof q) {
                d(appChainContext, dataBundle);
            } else {
                bb.a aVar = new bb.a();
                aVar.e(appChainContext, dataBundle);
                aVar.h(appChainContext, dataBundle);
                aVar.a(appChainContext, dataBundle);
            }
        } catch (Throwable unused) {
        }
    }

    public final void b(wa.a appChainContext, Bundle dataBundle, String hotOpenType) {
        Intrinsics.g(appChainContext, "appChainContext");
        Intrinsics.g(dataBundle, "dataBundle");
        Intrinsics.g(hotOpenType, "hotOpenType");
        try {
            if (appChainContext.h() instanceof q) {
                e(appChainContext, dataBundle, hotOpenType);
            } else {
                bb.a aVar = new bb.a();
                aVar.e(appChainContext, dataBundle);
                aVar.h(appChainContext, dataBundle);
                aVar.a(appChainContext, dataBundle);
            }
        } catch (Throwable unused) {
        }
    }

    public final void c(wa.a appChainContext, Bundle dataBundle) {
        Intrinsics.g(appChainContext, "appChainContext");
        Intrinsics.g(dataBundle, "dataBundle");
        try {
            appChainContext.e(dataBundle);
            if (dataBundle.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.S)) {
                String string = dataBundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.S, "0");
                Intrinsics.f(string, "dataBundle.getString(ChainPoint.CHAIN_SCENE, \"0\")");
                appChainContext.Z(string);
                String string2 = dataBundle.getString("hot_open_type", "-2");
                Intrinsics.f(string2, "dataBundle.getString(HOT_OPEN_TYPE, \"-2\")");
                appChainContext.S(string2);
            }
            if (dataBundle.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.T)) {
                String string3 = dataBundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.T, "-1");
                Intrinsics.f(string3, "dataBundle.getString(Cha…CHAIN_OPEN_CHANNEL, \"-1\")");
                appChainContext.U(string3);
            }
            appChainContext.r().set(0);
            appChainContext.p().set(1);
            appChainContext.Y(false);
            appChainContext.X(false);
            appChainContext.W(false);
            appChainContext.V(false);
            appChainContext.P(new LinkedHashMap());
            appChainContext.Q(new LinkedHashMap());
            appChainContext.O(0);
            appChainContext.a0(0);
            appChainContext.b0(new LinkedHashMap());
            appChainContext.R("");
            appChainContext.t().clear();
            appChainContext.u().clear();
            for (int i11 = 1; i11 < 12; i11++) {
                appChainContext.u().put(String.valueOf(i11), g.h(Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis())));
                appChainContext.t().put(String.valueOf(i11), 0L);
            }
        } catch (Throwable unused) {
        }
    }

    public final void d(wa.a aVar, Bundle bundle) {
        if (aVar.q().isEmpty()) {
            return;
        }
        PageChainContext pageChainContextPeek = aVar.q().peek();
        if ((pageChainContextPeek.g() instanceof xa.a) || ((pageChainContextPeek.h() instanceof db.g) && ((pageChainContextPeek.g() instanceof b) || pageChainContextPeek.g() == null))) {
            m mVar = new m();
            mVar.g(aVar, bundle);
            mVar.j(aVar, bundle);
            mVar.f(aVar, bundle);
            return;
        }
        if (pageChainContextPeek.g() instanceof xa.g) {
            d dVar = new d();
            dVar.h(aVar, bundle);
            dVar.e(aVar, bundle);
            return;
        }
        if (aVar.C() && aVar.B()) {
            h hVar = new h();
            hVar.c(aVar, bundle);
            hVar.f(aVar, bundle);
        } else if (aVar.C() && !aVar.B()) {
            j jVar = new j();
            jVar.d(aVar, bundle);
            jVar.g(aVar, bundle);
        } else {
            if (aVar.C() || aVar.B()) {
                return;
            }
            f fVar = new f();
            fVar.e(aVar, bundle);
            fVar.h(aVar, bundle);
        }
    }

    public final void e(wa.a aVar, Bundle bundle, String str) {
        if (aVar.q().isEmpty()) {
            return;
        }
        PageChainContext pageChainContextPeek = aVar.q().peek();
        TmcLogger.c("HotOpenState", "currentChainEndState:" + pageChainContextPeek.h() + ", currentChainEndState:" + pageChainContextPeek.g());
        if ((pageChainContextPeek.g() instanceof xa.a) || ((pageChainContextPeek.h() instanceof db.g) && ((pageChainContextPeek.g() instanceof b) || pageChainContextPeek.g() == null))) {
            if (Intrinsics.b(str, "shell_0")) {
                k kVar = new k();
                kVar.e(aVar, bundle);
                kVar.g(aVar, bundle);
                kVar.b(aVar, bundle);
                return;
            }
            if (Intrinsics.b(str, "shell_1")) {
                l lVar = new l();
                lVar.h(aVar, bundle);
                lVar.k(aVar, bundle);
                lVar.g(aVar, bundle);
                lVar.c(aVar, bundle);
                return;
            }
            return;
        }
        if (pageChainContextPeek.g() instanceof xa.g) {
            if (Intrinsics.b(str, "shell_0")) {
                bb.b bVar = new bb.b();
                bVar.c(aVar, bundle);
                bVar.a(aVar, bundle);
                return;
            } else {
                if (Intrinsics.b(str, "shell_1")) {
                    c cVar = new c();
                    cVar.i(aVar, bundle);
                    cVar.f(aVar, bundle);
                    cVar.b(aVar, bundle);
                    return;
                }
                return;
            }
        }
        if (aVar.C() && aVar.B()) {
            bb.g gVar = new bb.g();
            gVar.d(aVar, bundle);
            gVar.g(aVar, bundle);
            gVar.b(aVar, bundle);
            return;
        }
        if (aVar.C() && !aVar.B()) {
            i iVar = new i();
            iVar.e(aVar, bundle);
            iVar.h(aVar, bundle);
            iVar.b(aVar, bundle);
            return;
        }
        if (aVar.C() || aVar.B()) {
            return;
        }
        e eVar = new e();
        eVar.f(aVar, bundle);
        eVar.i(aVar, bundle);
        eVar.b(aVar, bundle);
    }
}
