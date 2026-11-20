package com.transsion.commercialization.pslink;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.n;
import com.google.gson.reflect.TypeToken;
import com.transsnet.launcherlib.PalmStoreDownLoadTaskInfo;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PsLinkServiceHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static e00.b f51718b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f51720d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PsLinkServiceHelper f51717a = new PsLinkServiceHelper();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static CopyOnWriteArrayList<b> f51719c = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ServiceConnection f51721e = new a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Intrinsics.g(componentName, "componentName");
            Intrinsics.g(iBinder, "iBinder");
            com.transsion.commercialization.pslink.a aVar = com.transsion.commercialization.pslink.a.f51724a;
            PsLinkServiceHelper psLinkServiceHelper = PsLinkServiceHelper.f51717a;
            aVar.a(psLinkServiceHelper.j() + " --> onServiceConnected() --> 连接成功 --> componentName = " + componentName);
            psLinkServiceHelper.l(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Intrinsics.g(componentName, "componentName");
            com.transsion.commercialization.pslink.a.f51724a.b(PsLinkServiceHelper.f51717a.j() + " --> onServiceDisconnected() --> 断开连接 --> componentName = " + componentName);
            PsLinkServiceHelper.f51718b = null;
            PsLinkInstallReceiver.f51714a.b();
        }
    }

    public final void g(b psLinkCallBackCommon) {
        Intrinsics.g(psLinkCallBackCommon, "psLinkCallBackCommon");
        if (f51719c.contains(psLinkCallBackCommon)) {
            return;
        }
        f51719c.add(psLinkCallBackCommon);
    }

    public final void h() {
        Object objM163constructorimpl;
        if (f51718b != null) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            com.transsion.commercialization.pslink.a aVar = com.transsion.commercialization.pslink.a.f51724a;
            PsLinkServiceHelper psLinkServiceHelper = f51717a;
            aVar.a(psLinkServiceHelper.j() + " --> bindService() --> 开始bindService .... ");
            Intent intent = new Intent();
            intent.setClassName("com.transsnet.store", "com.transsnet.launcherlib.services.DispenseCommonService");
            boolean zBindService = Utils.a().bindService(intent, f51721e, 1);
            aVar.a(psLinkServiceHelper.j() + " --> bindService() --> 开始bindService .... --> isConnect = " + zBindService);
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            com.transsion.commercialization.pslink.a.f51724a.b(f51717a.j() + " --> bindService() --> " + Log.getStackTraceString(thM166exceptionOrNullimpl));
        }
        PsLinkInstallReceiver.f51714a.a();
    }

    public final CopyOnWriteArrayList<b> i() {
        return f51719c;
    }

    public final String j() {
        String simpleName = PsLinkServiceHelper.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final boolean k() {
        return f51718b == null;
    }

    public final void l(IBinder iBinder) {
        Object objM163constructorimpl;
        Unit unit;
        try {
            Result.Companion companion = Result.Companion;
            e00.b bVarE0 = e00.b.a.e0(iBinder);
            f51718b = bVarE0;
            if (bVarE0 != null) {
                bVarE0.g(new e00.a.AbstractBinderC0654a() { // from class: com.transsion.commercialization.pslink.PsLinkServiceHelper$register$1$1
                    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                    /* JADX WARN: Code duplicated, block: B:17:0x004a  */
                    /* JADX WARN: Code duplicated, block: B:19:0x005c  */
                    /* JADX WARN: Code duplicated, block: B:21:0x0064  */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // e00.a
                    public void W(String callBackName, String param) {
                        String pkgName;
                        Intrinsics.g(callBackName, "callBackName");
                        Intrinsics.g(param, "param");
                        Object obj = null;
                        switch (callBackName) {
                            case "addTask":
                            case "onAction":
                                Object objE = n.e(param, new TypeToken<PalmStoreDownLoadTaskInfo>() { // from class: com.transsion.commercialization.pslink.PsLinkServiceHelper$register$1$1$callBackCommon$1
                                }.getType());
                                PalmStoreDownLoadTaskInfo palmStoreDownLoadTaskInfo = (PalmStoreDownLoadTaskInfo) objE;
                                obj = objE;
                                pkgName = palmStoreDownLoadTaskInfo != null ? palmStoreDownLoadTaskInfo.getPkgName() : null;
                                break;
                            case "removeTask":
                                pkgName = ((PalmStoreDownLoadTaskInfo) n.e(param, new TypeToken<PalmStoreDownLoadTaskInfo>() { // from class: com.transsion.commercialization.pslink.PsLinkServiceHelper$register$1$1$callBackCommon$info$1
                                }.getType())).getPkgName();
                                break;
                            case "onProgress":
                                Object objE2 = n.e(param, new TypeToken<PalmStoreDownLoadTaskInfo>() { // from class: com.transsion.commercialization.pslink.PsLinkServiceHelper$register$1$1$callBackCommon$1
                                }.getType());
                                PalmStoreDownLoadTaskInfo palmStoreDownLoadTaskInfo2 = (PalmStoreDownLoadTaskInfo) objE2;
                                obj = objE2;
                                pkgName = palmStoreDownLoadTaskInfo2 != null ? palmStoreDownLoadTaskInfo2.getPkgName() : null;
                                break;
                            default:
                                pkgName = "";
                                break;
                        }
                        if (!Intrinsics.b(callBackName, "onProgress") || System.currentTimeMillis() - PsLinkServiceHelper.f51720d >= 1000) {
                            PsLinkServiceHelper psLinkServiceHelper = PsLinkServiceHelper.f51717a;
                            PsLinkServiceHelper.f51720d = System.currentTimeMillis();
                            Iterator it = PsLinkServiceHelper.f51719c.iterator();
                            while (it.hasNext()) {
                                ((b) it.next()).a(callBackName, param, (PalmStoreDownLoadTaskInfo) obj, pkgName);
                            }
                        }
                    }
                }, "Moviebox");
                unit = Unit.f68710a;
            } else {
                unit = null;
            }
            objM163constructorimpl = Result.m163constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl == null) {
            return;
        }
        com.transsion.commercialization.pslink.a.f51724a.b(f51717a.j() + " --> register() --> it = " + Log.getStackTraceString(thM166exceptionOrNullimpl));
    }

    public final void m(b psLinkCallBackCommon) {
        Intrinsics.g(psLinkCallBackCommon, "psLinkCallBackCommon");
        f51719c.remove(psLinkCallBackCommon);
    }
}
