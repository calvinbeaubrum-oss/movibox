package com.transsion.transfer.wifi.create;

import android.os.Build;
import android.provider.Settings;
import com.blankj.utilcode.util.Utils;
import com.transsion.transfer.wifi.create.adapter.P2PWifiAdapter;
import com.transsion.transfer.wifi.create.adapter.b;
import com.transsion.transfer.wifi.create.adapter.c;
import com.transsion.transfer.wifi.util.WifiUtils;
import com.transsion.transfer.wifi.util.f;
import com.transsion.transfer.wifi.util.g;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;

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
public final class WifiCreateManager implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WifiCreateManager f59169a = new WifiCreateManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f59170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f59171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f59172d;

    @Override // com.transsion.transfer.wifi.create.a
    public void a(qy.a aVar, long j11) {
        a aVar2 = f59170b;
        if (aVar2 != null) {
            aVar2.a(aVar, System.currentTimeMillis() - f59172d);
        }
    }

    @Override // com.transsion.transfer.wifi.create.a
    public void b(int i11, long j11) {
        a aVar = f59170b;
        if (aVar != null) {
            aVar.b(i11, System.currentTimeMillis() - f59172d);
        }
        j();
    }

    public final void g(qy.a wifiInfoModel, k0 scope, a listener) {
        Intrinsics.g(wifiInfoModel, "wifiInfoModel");
        Intrinsics.g(scope, "scope");
        Intrinsics.g(listener, "listener");
        j.d(scope, null, null, new WifiCreateManager$createWifi$1(listener, wifiInfoModel, this, scope, null), 3, null);
    }

    public final String h() {
        String simpleName = WifiCreateManager.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final b i() {
        if (WifiUtils.f59242a.p()) {
            g.b(g.f59252a, h() + " --> initWifiAdapterWithAndroidVersion() --> wifiManager.isP2pSupported -> P2pWifiAdapter()", false, 2, null);
            return new P2PWifiAdapter();
        }
        if (Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(Utils.a().getApplicationContext())) {
            g.b(g.f59252a, h() + " --> initWifiAdapterWithAndroidVersion() --> checkCanWriteSetting(TransBaseApplication.CONTEXT) -> ApWifiAdapter()", false, 2, null);
            return new com.transsion.transfer.wifi.create.adapter.a();
        }
        g.b(g.f59252a, h() + " --> initWifiAdapterWithAndroidVersion() --> else -> LocalHostWifiAdapter()", false, 2, null);
        return new c();
    }

    public final void j() {
        Object objM163constructorimpl;
        Unit unit;
        try {
            Result.Companion companion = Result.Companion;
            f59170b = null;
            g gVar = g.f59252a;
            WifiCreateManager wifiCreateManager = f59169a;
            g.h(gVar, wifiCreateManager.h() + " --> releaseWifi() --> 发送端开始释放资源", false, 2, null);
            WifiUtils.f59242a.v();
            py.a.f74064a.b();
            f.f59249a.c();
            b bVar = f59171c;
            if (bVar != null) {
                bVar.f();
                unit = Unit.f68710a;
            } else {
                unit = null;
            }
            if (unit == null) {
                g.b(gVar, wifiCreateManager.h() + " --> releaseWifi() --> wifiAdapter == null", false, 2, null);
            }
            f59171c = null;
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl == null) {
            return;
        }
        g.d(g.f59252a, f59169a.h() + " --> releaseWifi() --> exception = " + thM166exceptionOrNullimpl, false, 2, null);
    }

    @Override // com.transsion.transfer.wifi.create.a
    public void onStart() {
        f59172d = System.currentTimeMillis();
        py.c.f74067a.k();
        a aVar = f59170b;
        if (aVar != null) {
            aVar.onStart();
        }
    }
}
