package com.transsion.ad.hi;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.util.device.TNDeviceHelper;
import com.transsion.ad.a;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.h;
import kotlinx.coroutines.w0;
import wq.b;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class HiSavanaAdManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HiSavanaAdManager f50400a = new HiSavanaAdManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static AtomicBoolean f50401b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static AtomicBoolean f50402c = new AtomicBoolean(false);

    public final String c() {
        String simpleName = HiSavanaAdManager.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final Object d(String str, boolean z11, boolean z12, Continuation<? super Unit> continuation) {
        if (e()) {
            a.d(a.f50276a, c() + " --> initHiAdSdk() --> 2g & 开关不打开直接关闭sdk初始化", false, 2, null);
            return Unit.f68710a;
        }
        if (!f50401b.get()) {
            f50401b.set(true);
            Object objG = h.g(w0.b(), new HiSavanaAdManager$initHiAdSdk$2(str, z12, z11, null), continuation);
            return objG == kotlin.coroutines.intrinsics.a.e() ? objG : Unit.f68710a;
        }
        a.d(a.f50276a, c() + " --> initHiAdSdk() --> isInitializing == true", false, 2, null);
        return Unit.f68710a;
    }

    public final boolean e() {
        TNDeviceHelper tNDeviceHelper = TNDeviceHelper.f49455a;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        return ((double) tNDeviceHelper.j(applicationA).totalMem) <= ((double) 1073741824) * ((double) b.f79582a.c());
    }

    public final boolean f() {
        return f50402c.get();
    }
}
