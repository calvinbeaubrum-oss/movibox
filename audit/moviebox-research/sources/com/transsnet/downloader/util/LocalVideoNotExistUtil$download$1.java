package com.transsnet.downloader.util;

import android.app.Application;
import android.os.Build;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.DownloadRefreshEvent;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.r0;

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
@DebugMetadata(c = "com.transsnet.downloader.util.LocalVideoNotExistUtil$download$1", f = "LocalVideoNotExistUtil.kt", l = {163, 182, 201}, m = "invokeSuspend")
@SourceDebugExtension
public final class LocalVideoNotExistUtil$download$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isSeries;
    final /* synthetic */ String $path;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ int $seriesPosition;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalVideoNotExistUtil$download$1(String str, String str2, boolean z11, int i11, Continuation<? super LocalVideoNotExistUtil$download$1> continuation) {
        super(2, continuation);
        this.$resourceId = str;
        this.$path = str2;
        this.$isSeries = z11;
        this.$seriesPosition = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalVideoNotExistUtil$download$1(this.$resourceId, this.$path, this.$isSeries, this.$seriesPosition, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LocalVideoNotExistUtil$download$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:41:0x00de  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:45:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:50:0x010e  */
    /* JADX WARN: Code duplicated, block: B:52:0x0119  */
    /* JADX WARN: Code duplicated, block: B:55:0x0128 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:58:0x0139  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        DownloadBean downloadBean;
        String str;
        File file;
        String path;
        String strF;
        String rootPath;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
                ResultKt.b(obj);
            } else if (i11 == 2) {
                downloadBean = (DownloadBean) this.L$0;
                ResultKt.b(obj);
                uo.b.a.f(uo.b.f78622a, "LocalVideoNotExistUtil", "2 download, 加入下载队列", false, 4, null);
                if (downloadBean.getRootPathType() != 1) {
                    if (Build.VERSION.SDK_INT <= 28 || downloadBean.getRootPathType() != 2) {
                        path = downloadBean.getPath();
                        if (path != null) {
                            rootPath = downloadBean.getRootPath();
                            if (rootPath == null) {
                                rootPath = tr.b.f77264a.d();
                            }
                            strF = kotlin.text.l.F(path, rootPath, tr.b.f77264a.d(), false, 4, null);
                        } else {
                            strF = null;
                        }
                        downloadBean.setPath(strF);
                    } else {
                        downloadBean.setPath(DownloadUtil.f61136a.j(downloadBean));
                    }
                }
                com.transsnet.downloader.manager.b.f61062a.a(Utils.a()).p(downloadBean);
                str = this.$path;
                if (str != null) {
                    file = new File(str);
                    if (file.exists()) {
                        file.delete();
                    }
                }
                this.L$0 = null;
                this.label = 3;
                if (r0.a(200L, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            uo.b.a.f(uo.b.f78622a, "LocalVideoNotExistUtil", "2 download, 刷新列表", false, 4, null);
            if (this.$isSeries) {
                LocalVideoNotExistUtil.f61140a.m(this.$seriesPosition);
            }
            DownloadRefreshEvent downloadRefreshEvent = new DownloadRefreshEvent("", "", false, false, 12, null);
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = DownloadRefreshEvent.class.getName();
            Intrinsics.f(name, "T::class.java.name");
            flowEventBus.postEvent(name, downloadRefreshEvent, 0L);
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        uo.b.a.f(uo.b.f78622a, "LocalVideoNotExistUtil", "2 download, resourceId = " + this.$resourceId, false, 4, null);
        DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
        String str2 = this.$resourceId;
        this.label = 1;
        obj = downloadEsHelperA.k(str2, this);
        if (obj == objE) {
            return objE;
        }
        downloadBean = (DownloadBean) obj;
        if (downloadBean != null) {
            String str3 = this.$path;
            String str4 = this.$resourceId;
            if (str3 != null) {
                int rootPathType = downloadBean.getRootPathType();
                if (rootPathType != 2) {
                    if (rootPathType == 3 && Build.VERSION.SDK_INT >= 29) {
                        com.transsnet.downloader.e eVar = com.transsnet.downloader.e.f60605a;
                        Application applicationA = Utils.a();
                        Intrinsics.f(applicationA, "getApp()");
                        eVar.d(applicationA, str3);
                    }
                } else if (Build.VERSION.SDK_INT >= 29) {
                    com.transsnet.downloader.e eVar2 = com.transsnet.downloader.e.f60605a;
                    Application applicationA2 = Utils.a();
                    Intrinsics.f(applicationA2, "getApp()");
                    eVar2.e(applicationA2, str3);
                }
            }
            downloadBean.setStatus(0);
            DownloadUtil.f61136a.z(downloadBean);
            tr.h hVarK = LocalVideoNotExistUtil.f61140a.k();
            this.L$0 = downloadBean;
            this.label = 2;
            if (hVarK.b(str4, this) == objE) {
                return objE;
            }
            uo.b.a.f(uo.b.f78622a, "LocalVideoNotExistUtil", "2 download, 加入下载队列", false, 4, null);
            if (downloadBean.getRootPathType() != 1) {
                if (Build.VERSION.SDK_INT <= 28) {
                    path = downloadBean.getPath();
                    if (path != null) {
                        rootPath = downloadBean.getRootPath();
                        if (rootPath == null) {
                            rootPath = tr.b.f77264a.d();
                        }
                        strF = kotlin.text.l.F(path, rootPath, tr.b.f77264a.d(), false, 4, null);
                    } else {
                        strF = null;
                    }
                    downloadBean.setPath(strF);
                } else {
                    path = downloadBean.getPath();
                    if (path != null) {
                        rootPath = downloadBean.getRootPath();
                        if (rootPath == null) {
                            rootPath = tr.b.f77264a.d();
                        }
                        strF = kotlin.text.l.F(path, rootPath, tr.b.f77264a.d(), false, 4, null);
                    } else {
                        strF = null;
                    }
                    downloadBean.setPath(strF);
                }
            }
            com.transsnet.downloader.manager.b.f61062a.a(Utils.a()).p(downloadBean);
        }
        str = this.$path;
        if (str != null) {
            file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
        this.L$0 = null;
        this.label = 3;
        if (r0.a(200L, this) == objE) {
            return objE;
        }
        uo.b.a.f(uo.b.f78622a, "LocalVideoNotExistUtil", "2 download, 刷新列表", false, 4, null);
        if (this.$isSeries) {
            LocalVideoNotExistUtil.f61140a.m(this.$seriesPosition);
        }
        DownloadRefreshEvent downloadRefreshEvent2 = new DownloadRefreshEvent("", "", false, false, 12, null);
        FlowEventBus flowEventBus2 = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = DownloadRefreshEvent.class.getName();
        Intrinsics.f(name2, "T::class.java.name");
        flowEventBus2.postEvent(name2, downloadRefreshEvent2, 0L);
        return Unit.f68710a;
    }
}
