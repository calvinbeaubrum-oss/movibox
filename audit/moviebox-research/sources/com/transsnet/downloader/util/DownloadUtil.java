package com.transsnet.downloader.util;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.fragment.app.Fragment;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.applovin.sdk.AppLovinEventTypes;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.Utils;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.baselib.db.download.DownloadRange;
import com.transsion.baseui.R$mipmap;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.ResolutionItem;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.ResourcesSeason;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Video;
import com.transsnet.downloader.bean.DownloadListBean;
import com.transsnet.downloader.bean.DownloadUrlBean;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import com.transsnet.downloader.manager.DownloadEsHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class DownloadUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DownloadUtil f61136a = new DownloadUtil();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f61137b = LazyKt__LazyJVMKt.b(new Function0<com.transsnet.downloader.manager.a>() { // from class: com.transsnet.downloader.util.DownloadUtil$downloadManager$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.transsnet.downloader.manager.a invoke() {
            return com.transsnet.downloader.manager.b.f61062a.a(Utils.a());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f61138c = LazyKt__LazyJVMKt.b(new Function0<tr.h>() { // from class: com.transsnet.downloader.util.DownloadUtil$downloadRangeDao$2
        @Override // kotlin.jvm.functions.Function0
        public final tr.h invoke() {
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return v0Var.b(applicationA).F0();
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f61139d = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};

    public final void A(boolean z11, DownloadBean data) {
        Intrinsics.g(data, "data");
        if (data.isSeriesCollection()) {
            data.setSeriesAllCheck(z11);
            Iterator<T> it = data.getSeriesList().iterator();
            while (it.hasNext()) {
                ((DownloadBean) it.next()).setCheck(z11);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x014a  */
    /* JADX WARN: Code duplicated, block: B:51:0x0174  */
    /* JADX WARN: Code duplicated, block: B:59:0x022a  */
    /* JADX WARN: Code duplicated, block: B:64:0x0253  */
    /* JADX WARN: Code duplicated, block: B:8:0x0028  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object B(Context context, boolean z11, DownloadBean downloadBean, String str, int i11, String str2, int i12, final Function2<? super Long, ? super Long, Unit> function2, Function1<? super Boolean, Unit> function1, boolean z12, Continuation<? super Unit> continuation) throws Throwable {
        DownloadUtil$transferFile$1 downloadUtil$transferFile$1;
        String str3;
        Function1<? super Boolean, Unit> function3;
        String str4;
        Function1<? super Boolean, Unit> function4;
        String str5;
        Function1<? super Boolean, Unit> function5;
        String str6;
        Function1<? super Boolean, Unit> function6;
        DownloadUtil downloadUtil = this;
        if (continuation instanceof DownloadUtil$transferFile$1) {
            downloadUtil$transferFile$1 = (DownloadUtil$transferFile$1) continuation;
            int i13 = downloadUtil$transferFile$1.label;
            if ((i13 & Integer.MIN_VALUE) != 0) {
                downloadUtil$transferFile$1.label = i13 - Integer.MIN_VALUE;
            } else {
                downloadUtil$transferFile$1 = new DownloadUtil$transferFile$1(downloadUtil, continuation);
            }
        } else {
            downloadUtil$transferFile$1 = new DownloadUtil$transferFile$1(downloadUtil, continuation);
        }
        DownloadUtil$transferFile$1 downloadUtil$transferFile$2 = downloadUtil$transferFile$1;
        Object obj = downloadUtil$transferFile$2.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i14 = downloadUtil$transferFile$2.label;
        if (i14 == 0) {
            ResultKt.b(obj);
            if (downloadBean.getPath() == null || downloadBean.getRootPath() == null) {
                return Unit.f68710a;
            }
            String path = downloadBean.getPath();
            Intrinsics.d(path);
            String str7 = z11 ? "下载完成" : "下载目录转存";
            if (i12 == 2) {
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = "";
                com.transsnet.downloader.e eVar = com.transsnet.downloader.e.f60605a;
                Function2<Long, Long, Unit> function7 = new Function2<Long, Long, Unit>() { // from class: com.transsnet.downloader.util.DownloadUtil$transferFile$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Long l11, Long l12) {
                        invoke(l11.longValue(), l12.longValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(long j11, long j12) {
                        Function2<Long, Long, Unit> function8 = function2;
                        if (function8 != null) {
                            function8.invoke(Long.valueOf(j11), Long.valueOf(j12));
                        }
                    }
                };
                Function1<String, Unit> function8 = new Function1<String, Unit>() { // from class: com.transsnet.downloader.util.DownloadUtil$transferFile$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str8) {
                        invoke2(str8);
                        return Unit.f68710a;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String newPath) {
                        Intrinsics.g(newPath, "newPath");
                        objectRef.element = newPath;
                        uo.b.f78622a.r("resource_save", "转存到sdcard newPath = " + newPath, true);
                    }
                };
                str3 = str7;
                if (eVar.m(context, path, str, str2, function7, function8)) {
                    uo.b.f78622a.n("resource_save", new String[]{str3 + " ，转存到相册 成功 beforeRootPathType:" + i11 + ", beforeRootPath = " + str + " targetRootPathType:" + i12 + ", targetRootPath = " + str2}, true);
                    String str8 = (String) objectRef.element;
                    function4 = function1;
                    downloadUtil$transferFile$2.L$0 = function4;
                    downloadUtil$transferFile$2.label = 3;
                    if (E(downloadBean, path, str, i11, str2, i12, str8, z12, downloadUtil$transferFile$2) == objE) {
                        return objE;
                    }
                    if (function4 != null) {
                        function4.invoke(Boxing.a(true));
                    }
                } else {
                    function3 = function1;
                    str4 = "resource_save";
                    downloadUtil$transferFile$2.L$0 = function3;
                    downloadUtil$transferFile$2.L$1 = str3;
                    downloadUtil$transferFile$2.label = 4;
                    if (D(downloadBean, z11, downloadUtil$transferFile$2) == objE) {
                        return objE;
                    }
                    if (function3 != null) {
                        function3.invoke(Boxing.a(false));
                    }
                    uo.b.f78622a.t(str4, str3 + " ，转存到sdcard，转存失败", true);
                }
            } else if (i12 == 3) {
                final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = "";
                str5 = "resource_save";
                if (com.transsnet.downloader.e.f60605a.i(context, path, str, new Function2<Long, Long, Unit>() { // from class: com.transsnet.downloader.util.DownloadUtil$transferFile$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Long l11, Long l12) {
                        invoke(l11.longValue(), l12.longValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(long j11, long j12) {
                        Function2<Long, Long, Unit> function9 = function2;
                        if (function9 != null) {
                            function9.invoke(Long.valueOf(j11), Long.valueOf(j12));
                        }
                    }
                }, new Function1<String, Unit>() { // from class: com.transsnet.downloader.util.DownloadUtil$transferFile$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str9) {
                        invoke2(str9);
                        return Unit.f68710a;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String newPath) {
                        Intrinsics.g(newPath, "newPath");
                        objectRef2.element = newPath;
                        uo.b.f78622a.r("resource_save", "转存到相册 newPath = " + newPath, true);
                    }
                })) {
                    uo.b.f78622a.n(str5, new String[]{str7 + " ，转存到相册 成功 beforeRootPathType:" + i11 + ", beforeRootPath = " + str + " targetRootPathType:" + i12 + ", targetRootPath = " + str2}, true);
                    String str9 = (String) objectRef2.element;
                    function6 = function1;
                    downloadUtil$transferFile$2.L$0 = function6;
                    downloadUtil$transferFile$2.label = 1;
                    if (E(downloadBean, path, str, i11, str2, i12, str9, z12, downloadUtil$transferFile$2) == objE) {
                        return objE;
                    }
                    if (function6 != null) {
                        function6.invoke(Boxing.a(true));
                    }
                } else {
                    function5 = function1;
                    downloadUtil$transferFile$2.L$0 = function5;
                    downloadUtil$transferFile$2.L$1 = str7;
                    downloadUtil$transferFile$2.label = 2;
                    downloadUtil = this;
                    if (downloadUtil.D(downloadBean, z11, downloadUtil$transferFile$2) == objE) {
                        return objE;
                    }
                    str6 = str7;
                    if (function5 != null) {
                        function5.invoke(Boxing.a(false));
                    }
                    uo.b.f78622a.t(str5, str6 + " ，转存到相册 失败", true);
                }
            }
        } else if (i14 == 1) {
            Function1<? super Boolean, Unit> function9 = (Function1) downloadUtil$transferFile$2.L$0;
            ResultKt.b(obj);
            function6 = function9;
            if (function6 != null) {
                function6.invoke(Boxing.a(true));
            }
        } else if (i14 == 2) {
            str6 = (String) downloadUtil$transferFile$2.L$1;
            Function1<? super Boolean, Unit> function10 = (Function1) downloadUtil$transferFile$2.L$0;
            ResultKt.b(obj);
            function5 = function10;
            str5 = "resource_save";
            if (function5 != null) {
                function5.invoke(Boxing.a(false));
            }
            uo.b.f78622a.t(str5, str6 + " ，转存到相册 失败", true);
        } else if (i14 == 3) {
            Function1<? super Boolean, Unit> function11 = (Function1) downloadUtil$transferFile$2.L$0;
            ResultKt.b(obj);
            function4 = function11;
            if (function4 != null) {
                function4.invoke(Boxing.a(true));
            }
        } else {
            if (i14 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str10 = (String) downloadUtil$transferFile$2.L$1;
            Function1<? super Boolean, Unit> function12 = (Function1) downloadUtil$transferFile$2.L$0;
            ResultKt.b(obj);
            str3 = str10;
            function3 = function12;
            str4 = "resource_save";
            if (function3 != null) {
                function3.invoke(Boxing.a(false));
            }
            uo.b.f78622a.t(str4, str3 + " ，转存到sdcard，转存失败", true);
        }
        return Unit.f68710a;
    }

    public final Object D(DownloadBean downloadBean, boolean z11, Continuation<? super Unit> continuation) throws Throwable {
        if (!z11) {
            return Unit.f68710a;
        }
        downloadBean.setTransferFailed(true);
        Object objP = DownloadEsHelper.f60994m.a().P(downloadBean, continuation);
        return objP == kotlin.coroutines.intrinsics.a.e() ? objP : Unit.f68710a;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    public final Object E(DownloadBean downloadBean, String str, String str2, int i11, String str3, int i12, String str4, boolean z11, Continuation<? super Unit> continuation) throws Throwable {
        DownloadUtil$transferFileSuccessNext$1 downloadUtil$transferFileSuccessNext$1;
        boolean z12;
        String strF;
        DownloadBean downloadBean2;
        DownloadUtil downloadUtil;
        if (continuation instanceof DownloadUtil$transferFileSuccessNext$1) {
            downloadUtil$transferFileSuccessNext$1 = (DownloadUtil$transferFileSuccessNext$1) continuation;
            int i13 = downloadUtil$transferFileSuccessNext$1.label;
            if ((i13 & Integer.MIN_VALUE) != 0) {
                downloadUtil$transferFileSuccessNext$1.label = i13 - Integer.MIN_VALUE;
            } else {
                downloadUtil$transferFileSuccessNext$1 = new DownloadUtil$transferFileSuccessNext$1(this, continuation);
            }
        } else {
            downloadUtil$transferFileSuccessNext$1 = new DownloadUtil$transferFileSuccessNext$1(this, continuation);
        }
        DownloadUtil$transferFileSuccessNext$1 downloadUtil$transferFileSuccessNext$2 = downloadUtil$transferFileSuccessNext$1;
        Object obj = downloadUtil$transferFileSuccessNext$2.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i14 = downloadUtil$transferFileSuccessNext$2.label;
        if (i14 == 0) {
            ResultKt.b(obj);
            if (z11) {
                if (kotlin.text.l.L(str, AppLovinEventTypes.USER_VIEWED_CONTENT, false, 2, null)) {
                    try {
                        l3.a aVarG = l3.a.g(Utils.a(), Uri.parse(str));
                        Boolean boolA = aVarG != null ? Boxing.a(aVarG.d()) : null;
                        uo.b.f78622a.r("resource_save", "DocumentFile ,删除结果 = " + boolA, true);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                } else {
                    File file = new File(str);
                    if (file.exists()) {
                        if (i11 != 2) {
                            if (i11 == 3 && Build.VERSION.SDK_INT >= 29) {
                                com.transsnet.downloader.e eVar = com.transsnet.downloader.e.f60605a;
                                Application applicationA = Utils.a();
                                Intrinsics.f(applicationA, "getApp()");
                                eVar.d(applicationA, str);
                            }
                        } else if (Build.VERSION.SDK_INT >= 29) {
                            com.transsnet.downloader.e eVar2 = com.transsnet.downloader.e.f60605a;
                            Application applicationA2 = Utils.a();
                            Intrinsics.f(applicationA2, "getApp()");
                            eVar2.e(applicationA2, str);
                        }
                        try {
                            boolean zDelete = file.delete();
                            uo.b.f78622a.r("resource_save", "转存到成功 ,删除结果 = " + zDelete + ", videoPath = " + str, true);
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    } else {
                        uo.b.f78622a.t("resource_save", "转存到成功 ,源文件不存在，无法删除", true);
                    }
                }
                if (str4.length() == 0) {
                    z12 = false;
                    strF = kotlin.text.l.F(str, str2, str3, false, 4, null);
                } else {
                    z12 = false;
                    strF = str4;
                }
                downloadBean.setPath(strF);
                downloadBean.setTransferFailed(z12);
                downloadBean.setRootPathType(i12);
                downloadBean.setRootPath(str3);
                uo.b.f78622a.r("resource_save", "转存到成功, resourceId:" + downloadBean.getResourceId() + " old path = " + str + "， new path = " + downloadBean.getPath(), true);
                DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
                downloadUtil$transferFileSuccessNext$2.L$0 = this;
                downloadUtil$transferFileSuccessNext$2.L$1 = downloadBean;
                downloadUtil$transferFileSuccessNext$2.label = 1;
                if (downloadEsHelperA.P(downloadBean, downloadUtil$transferFileSuccessNext$2) == objE) {
                    return objE;
                }
                downloadBean2 = downloadBean;
                downloadUtil = this;
            } else {
                uo.b.f78622a.r("resource_save", "save to成功, resourceId:" + downloadBean.getResourceId() + " old path = " + str + "， new path = " + downloadBean.getPath(), true);
            }
            return Unit.f68710a;
        }
        if (i14 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        downloadBean2 = (DownloadBean) downloadUtil$transferFileSuccessNext$2.L$1;
        downloadUtil = (DownloadUtil) downloadUtil$transferFileSuccessNext$2.L$0;
        ResultKt.b(obj);
        if (downloadBean2.isDownloadingPlay()) {
            downloadUtil.g().q();
        }
        return Unit.f68710a;
    }

    public final boolean c(DownloadBean bean) {
        String path;
        Intrinsics.g(bean, "bean");
        if (bean.getProgress() != 0) {
            Long size = bean.getSize();
            if ((size != null ? size.longValue() : 0L) > 31457280 && (path = bean.getPath()) != null) {
                File file = new File(path);
                long length = file.length();
                if (!file.exists() || length <= 0) {
                    uo.b.f78622a.h(DownloadBaseRunnable.TAG, "文件不存在，重新下载，fileLength = " + length + ",progress = " + bean.getProgress() + "，path = " + path, true);
                    return true;
                }
                long progress = bean.getProgress() - length;
                if (progress > 5120) {
                    uo.b.f78622a.t(DownloadBaseRunnable.TAG, "文件已经开始出现异常 name：" + bean.getTitleName(), true);
                }
                if (progress > 10485760) {
                    uo.b.f78622a.h(DownloadBaseRunnable.TAG, "重新下载，fileLength = " + length + ",progress = " + bean.getProgress() + ",extra = " + progress + "，path = " + path, true);
                    return true;
                }
            }
        }
        return false;
    }

    public final DownloadBean d(Subject subject, String str, String str2, String str3, String str4, String str5) {
        String downloadUrl;
        ResourceDetectors resourceDetector;
        String uploadBy;
        ResourceDetectors resourceDetector2;
        String resourceLink;
        ResourceDetectors resourceDetector3;
        Integer subjectType;
        ResourceDetectors resourceDetector4;
        Integer resolution;
        ResourceDetectors resourceDetector5;
        Cover cover;
        ResourceDetectors resourceDetector6;
        Cover cover2;
        String title;
        ResourceDetectors resourceDetector7;
        String resourceId;
        ResourceDetectors resourceDetector8;
        String downloadUrl2;
        ResourceDetectors resourceDetector9;
        DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
        String str6 = "";
        if (subject == null || (resourceDetector9 = subject.getResourceDetector()) == null || (downloadUrl = resourceDetector9.getResourceId()) == null) {
            downloadUrl = (subject == null || (resourceDetector = subject.getResourceDetector()) == null) ? null : resourceDetector.getDownloadUrl();
            if (downloadUrl == null) {
                downloadUrl = "";
            }
        }
        DownloadBean downloadBeanL = downloadEsHelperA.l(downloadUrl);
        if (downloadBeanL != null) {
            uo.b.a.f(uo.b.f78622a, "downloadAna", "single， get download bean from database", false, 4, null);
        } else {
            downloadBeanL = new DownloadBean((subject == null || (resourceDetector8 = subject.getResourceDetector()) == null || (downloadUrl2 = resourceDetector8.getDownloadUrl()) == null) ? "" : downloadUrl2, (subject == null || (resourceDetector7 = subject.getResourceDetector()) == null || (resourceId = resourceDetector7.getResourceId()) == null) ? "" : resourceId, (subject == null || (title = subject.getTitle()) == null) ? "" : title, (subject == null || (cover2 = subject.getCover()) == null) ? null : cover2.getUrl(), (subject == null || (resourceDetector6 = subject.getResourceDetector()) == null) ? null : resourceDetector6.getTotalSize(), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, subject != null ? subject.getGenre() : null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073610751, null);
            downloadBeanL.setGenre(subject != null ? subject.getGenre() : null);
            downloadBeanL.setRestrictLevel(subject != null ? subject.getRestrictLevel() : null);
            downloadBeanL.setReleaseDate(subject != null ? subject.getReleaseDate() : null);
            downloadBeanL.setImdbRate(subject != null ? subject.getImdbRate() : null);
            downloadBeanL.setCountryName(subject != null ? subject.getCountryName() : null);
            downloadBeanL.setSeNum(subject != null ? subject.getSeNum() : null);
            downloadBeanL.setSubtitles(subject != null ? subject.getSubtitles() : null);
            downloadBeanL.setThumbnail((subject == null || (cover = subject.getCover()) == null) ? null : cover.getThumbnail());
            downloadBeanL.setPostId((subject == null || (resourceDetector5 = subject.getResourceDetector()) == null) ? null : resourceDetector5.getPostId());
            downloadBeanL.setSubjectId(subject != null ? subject.getSubjectId() : null);
            downloadBeanL.setGroupId(str4);
            downloadBeanL.setSubjectName(subject != null ? subject.getTitle() : null);
            downloadBeanL.setResolution((subject == null || (resourceDetector4 = subject.getResourceDetector()) == null || (resolution = resourceDetector4.getResolution()) == null) ? 0 : resolution.intValue());
            downloadBeanL.setType(DownloadBean.Companion.c(subject != null ? subject.getSubjectType() : null));
            downloadBeanL.setSubjectType((subject == null || (subjectType = subject.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue());
            if (subject == null || (resourceDetector3 = subject.getResourceDetector()) == null || (uploadBy = resourceDetector3.getUploadBy()) == null) {
                uploadBy = str5 == null ? "" : str5;
            }
            downloadBeanL.setUploadBy(uploadBy);
            if (subject != null && (resourceDetector2 = subject.getResourceDetector()) != null && (resourceLink = resourceDetector2.getResourceLink()) != null) {
                str6 = resourceLink;
            }
            downloadBeanL.setSourceUrl(str6);
        }
        uo.b.a.f(uo.b.f78622a, "downloadAna", "single， add download task， " + downloadBeanL, false, 4, null);
        downloadBeanL.setCreateAt(System.currentTimeMillis());
        downloadBeanL.setUpdateTimeStamp(Long.valueOf(System.currentTimeMillis()));
        downloadBeanL.setPageFrom(str);
        downloadBeanL.setLastPageFrom(str2);
        downloadBeanL.setOps(str3);
        String string = UUID.randomUUID().toString();
        Intrinsics.f(string, "randomUUID().toString()");
        downloadBeanL.setTaskId(string);
        downloadBeanL.setDuration(subject != null ? Long.valueOf(subject.getResourceAboutDuration()) : null);
        return downloadBeanL;
    }

    public final DownloadBean e(DownloadUrlBean urlBean, Subject subject, String str, String str2, String str3) {
        String uploadBy;
        String sourceUrl;
        String name;
        Integer subjectType;
        Integer resolution;
        Integer epse;
        Cover cover;
        Cover cover2;
        Cover cover3;
        String name2;
        String resourceId;
        String url;
        Intrinsics.g(urlBean, "urlBean");
        DownloadItem resource = urlBean.getResource();
        int totalEpisode = urlBean.getTotalEpisode();
        DownloadBean downloadBean = new DownloadBean((resource == null || (url = resource.getUrl()) == null) ? "" : url, (resource == null || (resourceId = resource.getResourceId()) == null) ? "" : resourceId, (resource == null || (name2 = resource.getName()) == null) ? "" : name2, (subject == null || (cover3 = subject.getCover()) == null) ? null : cover3.getUrl(), resource != null ? resource.getSize() : null, null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, subject != null ? subject.getGenre() : null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073610751, null);
        downloadBean.setThumbnail((subject == null || (cover2 = subject.getCover()) == null) ? null : cover2.getThumbnail());
        downloadBean.setGenre(subject != null ? subject.getGenre() : null);
        downloadBean.setRestrictLevel(subject != null ? subject.getRestrictLevel() : null);
        downloadBean.setReleaseDate(subject != null ? subject.getReleaseDate() : null);
        downloadBean.setImdbRate(subject != null ? subject.getImdbRate() : null);
        downloadBean.setCountryName(subject != null ? subject.getCountryName() : null);
        downloadBean.setSeNum(subject != null ? subject.getSeNum() : null);
        downloadBean.setSubtitles(subject != null ? subject.getSubtitles() : null);
        downloadBean.setAverageHueLight((subject == null || (cover = subject.getCover()) == null) ? null : cover.getAverageHueLight());
        downloadBean.setSubjectDurationSeconds(subject != null ? subject.getDurationSeconds() : null);
        if (resource == null || (uploadBy = resource.getUploadBy()) == null) {
            uploadBy = "";
        }
        downloadBean.setUploadBy(uploadBy);
        if (resource == null || (sourceUrl = resource.getSourceUrl()) == null) {
            sourceUrl = "";
        }
        downloadBean.setSourceUrl(sourceUrl);
        downloadBean.setPostId(resource != null ? resource.getPostId() : null);
        int iIntValue = 0;
        downloadBean.setEpse((resource == null || (epse = resource.getEpse()) == null) ? 0 : epse.intValue());
        downloadBean.setEp(resource != null ? resource.getEp() : 0);
        downloadBean.setSe(resource != null ? resource.getSe() : 0);
        if (resource != null && (resolution = resource.getResolution()) != null) {
            iIntValue = resolution.intValue();
        }
        downloadBean.setResolution(iIntValue);
        downloadBean.setSubjectId(subject != null ? subject.getSubjectId() : null);
        downloadBean.setType(DownloadBean.Companion.c(subject != null ? subject.getSubjectType() : null));
        downloadBean.setSubjectType((subject == null || (subjectType = subject.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue());
        downloadBean.setTotalEpisode(totalEpisode);
        downloadBean.setCreateAt(System.currentTimeMillis());
        downloadBean.setUpdateTimeStamp(Long.valueOf(System.currentTimeMillis()));
        String title = subject != null ? subject.getTitle() : null;
        if (title == null || title.length() == 0) {
            name = urlBean.getName();
        } else {
            name = subject != null ? subject.getTitle() : null;
        }
        downloadBean.setSubjectName(name);
        downloadBean.setPageFrom(str);
        downloadBean.setLastPageFrom(str2);
        downloadBean.setOps(str3);
        String string = UUID.randomUUID().toString();
        Intrinsics.f(string, "randomUUID().toString()");
        downloadBean.setTaskId(string);
        downloadBean.setDuration(subject != null ? Long.valueOf(subject.getResourceAboutDuration()) : null);
        return downloadBean;
    }

    public final long f(DownloadBean bean) {
        Long duration;
        Intrinsics.g(bean, "bean");
        if (bean.getDuration() == null || ((duration = bean.getDuration()) != null && duration.longValue() == 0)) {
            return bean.getType() != 2 ? 5242880L : 7864320L;
        }
        Long duration2 = bean.getDuration();
        Intrinsics.d(duration2);
        long jLongValue = duration2.longValue() - 3600000;
        if (jLongValue > 0) {
            long j11 = ((((long) 46080) * jLongValue) / ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) + 5242880;
            if (j11 > 9437184) {
                return 9437184L;
            }
            return j11;
        }
        long jAbs = 5242880 - ((((long) 87040) * Math.abs(jLongValue)) / ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
        if (jAbs < 3145728) {
            return 3145728L;
        }
        return jAbs;
    }

    public final com.transsnet.downloader.manager.a g() {
        return (com.transsnet.downloader.manager.a) f61137b.getValue();
    }

    public final tr.h h() {
        return (tr.h) f61138c.getValue();
    }

    public final int i(DownloadBean downloadBean) {
        Integer numValueOf = downloadBean != null ? Integer.valueOf(downloadBean.getType()) : null;
        if (numValueOf != null && numValueOf.intValue() == 1) {
            return R$mipmap.home_ic_audio_white;
        }
        if (numValueOf != null && numValueOf.intValue() == 3) {
            return downloadBean.isShotTV() ? R$mipmap.home_ic_short_tv_white : R$mipmap.home_ic_tv_white;
        }
        return R$mipmap.home_ic_movie_white;
    }

    public final String j(DownloadBean bean) {
        File parentFile;
        Intrinsics.g(bean, "bean");
        String strReplace = new Regex("[\\\\/:#*?\"<>|&,]").replace(bean.getFileName(), "");
        String strR0 = StringsKt__StringsKt.R0(StringsKt__StringsKt.V0(bean.getUrl(), "?", null, 2, null), InstructionFileId.DOT, null, 2, null);
        if (strR0.length() == 0) {
            strR0 = "mp4";
        }
        DownloadEsHelper.a aVar = DownloadEsHelper.f60994m;
        String str = (aVar.a().d().getAbsolutePath() + File.separatorChar + strReplace) + InstructionFileId.DOT + strR0;
        Intrinsics.f(str, "toString(...)");
        String newPath = l(str).getAbsolutePath();
        bean.setRootPath(aVar.a().o());
        bean.setRootPathType(aVar.a().p());
        File file = new File(newPath);
        if (!file.exists()) {
            try {
                Result.Companion companion = Result.Companion;
                File parentFile2 = file.getParentFile();
                if (parentFile2 != null && (!parentFile2.exists()) && (parentFile = file.getParentFile()) != null) {
                    parentFile.mkdirs();
                }
                Result.m163constructorimpl(Boolean.valueOf(file.createNewFile()));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
        }
        Intrinsics.f(newPath, "newPath");
        return newPath;
    }

    public final int k(List<ResourcesSeason> seasons, int i11) {
        Object next;
        Object next2;
        List<ResolutionItem> resolutions;
        Intrinsics.g(seasons, "seasons");
        Iterator<T> it = seasons.iterator();
        do {
            next = null;
            if (!it.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it.next();
        } while (((ResourcesSeason) next2).getSe() != i11);
        ResourcesSeason resourcesSeason = (ResourcesSeason) next2;
        if (resourcesSeason == null || (resolutions = resourcesSeason.getResolutions()) == null) {
            return 0;
        }
        Iterator<T> it2 = resolutions.iterator();
        if (it2.hasNext()) {
            next = it2.next();
            if (it2.hasNext()) {
                int epNum = ((ResolutionItem) next).getEpNum();
                do {
                    Object next3 = it2.next();
                    int epNum2 = ((ResolutionItem) next3).getEpNum();
                    if (epNum < epNum2) {
                        next = next3;
                        epNum = epNum2;
                    }
                } while (it2.hasNext());
            }
        }
        ResolutionItem resolutionItem = (ResolutionItem) next;
        if (resolutionItem != null) {
            return resolutionItem.getResolution();
        }
        return 0;
    }

    public final File l(String str) {
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            int i11 = 1;
            if ((parentFile == null || !parentFile.exists()) && parentFile != null) {
                parentFile.mkdirs();
            }
            String strU = FilesKt__UtilsKt.u(file);
            String strT = FilesKt__UtilsKt.t(file);
            File file2 = new File(parentFile, file.getName());
            while (file2.exists()) {
                file2 = new File(parentFile, strU + "_" + i11 + InstructionFileId.DOT + strT);
                i11++;
            }
            return file2;
        } catch (Throwable unused) {
            return new File(str);
        }
    }

    public final String[] m() {
        return f61139d;
    }

    public final int n(List<DownloadBean> list) {
        int size;
        if (list == null) {
            return 0;
        }
        int i11 = 0;
        for (DownloadBean downloadBean : list) {
            if (downloadBean.getStatus() != 10) {
                size = 1;
            } else if (downloadBean.isSeriesAllCheck()) {
                size = downloadBean.getSeriesList().size();
            } else {
                Iterator<T> it = downloadBean.getSeriesList().iterator();
                int i12 = 0;
                while (it.hasNext()) {
                    if (((DownloadBean) it.next()).isCheck()) {
                        i12++;
                    }
                }
                size = i12;
            }
            i11 += size;
        }
        return i11;
    }

    public final ShortTVItem o(DownloadBean bean) {
        Intrinsics.g(bean, "bean");
        Integer numValueOf = Integer.valueOf(bean.getVideoHeight());
        Long size = bean.getSize();
        return new ShortTVItem(bean.getResourceId(), bean.getSubjectId(), bean.getSe(), bean.getEp(), null, new Media(null, null, null, null, null, null, new Video(null, null, null, null, numValueOf, size != null ? Integer.valueOf((int) size.longValue()) : null, bean.getPath(), Integer.valueOf(bean.getVideoWidth()))), null, 0, 0, null, bean.getReadProgress(), bean.getStatus(), 976, null);
    }

    public final Subject p(DownloadBean bean) {
        Intrinsics.g(bean, "bean");
        String subjectId = bean.getSubjectId();
        String subjectName = bean.getSubjectName();
        int subjectType = bean.getSubjectType();
        return new Subject(subjectId, Integer.valueOf(subjectType), subjectName, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, bean.getOps(), null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, bean.getTotalEpisode(), false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, null, null, -524296, 4194295, null);
    }

    public final List<DownloadBean> q(DownloadListBean downloadListBean, Subject subject, String str, String str2, String str3, String str4, String str5, List<? extends DownloadBean> list) {
        List<DownloadItem> items;
        DownloadBean downloadBeanS;
        Object next;
        ArrayList arrayList = new ArrayList();
        if (downloadListBean != null && (items = downloadListBean.getItems()) != null) {
            for (DownloadItem downloadItem : items) {
                if (list == null || !(!list.isEmpty())) {
                    downloadBeanS = f61136a.s(downloadListBean, subject, downloadItem, str, str2, str3, str4, str5);
                } else {
                    Iterator<T> it = list.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!Intrinsics.b(((DownloadBean) next).getResourceId(), downloadItem.getResourceId()));
                    downloadBeanS = (DownloadBean) next;
                    if (downloadBeanS == null) {
                        downloadBeanS = f61136a.s(downloadListBean, subject, downloadItem, str, str2, str3, str4, str5);
                    }
                }
                arrayList.add(downloadBeanS);
            }
        }
        return arrayList;
    }

    public final DownloadBean s(DownloadListBean downloadListBean, Subject subject, DownloadItem downloadItem, String str, String str2, String str3, String str4, String str5) {
        String genre;
        String thumbnail;
        String releaseDate;
        String countryName;
        Cover cover;
        String url;
        String url2 = downloadItem.getUrl();
        String str6 = url2 == null ? "" : url2;
        String resourceId = downloadItem.getResourceId();
        String str7 = resourceId == null ? "" : resourceId;
        String name = downloadItem.getName();
        String str8 = name == null ? "" : name;
        Cover cover2 = downloadListBean.getCover();
        DownloadBean downloadBean = new DownloadBean(str6, str7, str8, (cover2 == null || (url = cover2.getUrl()) == null) ? "" : url, downloadItem.getSize(), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -32, 1073741823, null);
        if (subject == null || (genre = subject.getGenre()) == null) {
            genre = downloadListBean.getGenre();
        }
        downloadBean.setGenre(genre);
        downloadBean.setCreateAt(System.currentTimeMillis());
        if (subject == null || (cover = subject.getCover()) == null || (thumbnail = cover.getThumbnail()) == null) {
            Cover cover3 = downloadListBean.getCover();
            thumbnail = cover3 != null ? cover3.getThumbnail() : null;
            if (thumbnail == null) {
                thumbnail = "";
            }
        }
        downloadBean.setThumbnail(thumbnail);
        if (subject == null || (releaseDate = subject.getGenre()) == null) {
            releaseDate = downloadListBean.getReleaseDate();
        }
        downloadBean.setReleaseDate(releaseDate);
        if (subject == null || (countryName = subject.getCountryName()) == null) {
            countryName = downloadListBean.getCountryName();
        }
        downloadBean.setCountryName(countryName);
        downloadBean.setRestrictLevel(subject != null ? subject.getRestrictLevel() : null);
        downloadBean.setImdbRate(subject != null ? subject.getImdbRate() : null);
        downloadBean.setSeNum(subject != null ? subject.getSeNum() : null);
        downloadBean.setSubtitles(subject != null ? subject.getSubtitles() : null);
        downloadBean.setDuration(downloadItem.getDuration());
        Cover cover4 = downloadListBean.getCover();
        downloadBean.setAverageHueLight(cover4 != null ? cover4.getAverageHueLight() : null);
        String uploadBy = downloadItem.getUploadBy();
        if (uploadBy == null) {
            uploadBy = "";
        }
        downloadBean.setUploadBy(uploadBy);
        downloadBean.setPostId(downloadItem.getPostId());
        Integer epse = downloadItem.getEpse();
        downloadBean.setEpse(epse != null ? epse.intValue() : 0);
        downloadBean.setEp(downloadItem.getEp());
        downloadBean.setSe(downloadItem.getSe());
        Integer resolution = downloadItem.getResolution();
        downloadBean.setResolution(resolution != null ? resolution.intValue() : 0);
        downloadBean.setSubjectId(downloadListBean.getSubjectId());
        downloadBean.setGroupId(str == null ? downloadListBean.getGroupId() : str);
        downloadBean.setSubjectName((str5 == null || str5.length() == 0) ? downloadListBean.getTitle() : str5);
        downloadBean.setPageFrom(str2);
        downloadBean.setLastPageFrom(str3);
        downloadBean.setOps(str4);
        String sourceUrl = downloadItem.getSourceUrl();
        if (sourceUrl == null) {
            sourceUrl = "";
        }
        downloadBean.setSourceUrl(sourceUrl);
        downloadBean.setRequireMemberType(downloadItem.getRequireMemberType());
        downloadBean.setType(DownloadBean.Companion.c(Integer.valueOf(downloadListBean.getSubjectType())));
        downloadBean.setSubjectType(downloadListBean.getSubjectType());
        downloadBean.setSubjectDurationSeconds(downloadListBean.getDurationSeconds());
        Integer totalEpisode = downloadListBean.getTotalEpisode();
        downloadBean.setTotalEpisode(totalEpisode != null ? totalEpisode.intValue() : 1);
        List<DownloadItem> items = downloadListBean.getItems();
        Integer numValueOf = items != null ? Integer.valueOf(items.size()) : null;
        Intrinsics.d(numValueOf);
        if (numValueOf.intValue() > downloadBean.getTotalEpisode()) {
            downloadBean.setMultiresolution(1);
        }
        return downloadBean;
    }

    public final Pair<Integer, Integer> t(List<ResourcesSeason> seasons, int i11, int i12) {
        int epNum;
        Intrinsics.g(seasons, "seasons");
        List<ResourcesSeason> list = seasons;
        CollectionsKt___CollectionsKt.E0(list, new Comparator() { // from class: com.transsnet.downloader.util.DownloadUtil$initGetPositions$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                return kotlin.comparisons.b.d(Integer.valueOf(((ResourcesSeason) t11).getSe()), Integer.valueOf(((ResourcesSeason) t12).getSe()));
            }
        });
        int epNum2 = 0;
        int i13 = 0;
        for (ResourcesSeason resourcesSeason : list) {
            Object next = null;
            if (i12 == 0) {
                List<ResolutionItem> resolutions = resourcesSeason.getResolutions();
                if (resolutions != null) {
                    Iterator<T> it = resolutions.iterator();
                    if (it.hasNext()) {
                        next = it.next();
                        if (it.hasNext()) {
                            int epNum3 = ((ResolutionItem) next).getEpNum();
                            do {
                                Object next2 = it.next();
                                int epNum4 = ((ResolutionItem) next2).getEpNum();
                                if (epNum3 < epNum4) {
                                    next = next2;
                                    epNum3 = epNum4;
                                }
                            } while (it.hasNext());
                        }
                    }
                    ResolutionItem resolutionItem = (ResolutionItem) next;
                    if (resolutionItem != null) {
                        uo.b.f78622a.c("DownloadRes", "initGetPositions,分辨率0  it.epNum:" + resolutionItem.getEpNum() + " ", true);
                        if (resourcesSeason.getSe() < i11) {
                            epNum2 += resolutionItem.getEpNum();
                        }
                        if (resourcesSeason.getSe() <= i11) {
                            epNum = resolutionItem.getEpNum();
                            i13 += epNum;
                        }
                    }
                }
            } else {
                List<ResolutionItem> resolutions2 = resourcesSeason.getResolutions();
                if (resolutions2 != null) {
                    for (Object obj : resolutions2) {
                        if (((ResolutionItem) obj).getResolution() == i12) {
                            next = obj;
                            break;
                        }
                    }
                    ResolutionItem resolutionItem2 = (ResolutionItem) next;
                    if (resolutionItem2 != null) {
                        uo.b.f78622a.c("DownloadRes", "initGetPositions,分辨率0  resolution:" + i12 + " ", true);
                        if (resourcesSeason.getSe() < i11) {
                            epNum2 += resolutionItem2.getEpNum();
                        }
                        if (resourcesSeason.getSe() <= i11) {
                            epNum = resolutionItem2.getEpNum();
                            i13 += epNum;
                        }
                    }
                }
            }
        }
        int i14 = epNum2 + 1;
        if (i13 < i14) {
            i13 = i14;
        }
        return new Pair<>(Integer.valueOf(i13), Integer.valueOf(i14));
    }

    public final void u(DownloadBean bean) {
        Intrinsics.g(bean, "bean");
        if (bean.getDownloadRanges().isEmpty()) {
            kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new DownloadUtil$initSetDownloadInfoAndRanges$1(bean, null), 3, null);
        }
    }

    public final boolean v(DownloadBean data) {
        Intrinsics.g(data, "data");
        boolean z11 = true;
        if (!data.isSeriesCollection()) {
            return true;
        }
        Iterator<T> it = data.getSeriesList().iterator();
        while (it.hasNext()) {
            if (!((DownloadBean) it.next()).isCheck()) {
                z11 = false;
            }
        }
        return z11;
    }

    public final boolean w() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 > 29 || i11 < 23) {
            return true;
        }
        return PermissionUtils.s("android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public final boolean x(DownloadBean bean) {
        String subjectId;
        String resourceId;
        Object value;
        Intrinsics.g(bean, "bean");
        if (bean.isVideo() && (subjectId = bean.getSubjectId()) != null && subjectId.length() != 0 && (resourceId = bean.getResourceId()) != null && resourceId.length() != 0) {
            ConfigBean configBeanB = ConfigManager.f53111c.a().b("download_error_opt_off", false);
            if (configBeanB == null || (value = configBeanB.getValue()) == null) {
                value = 0;
            }
            DownloadException exception = bean.getException();
            if (exception != null && exception.getCode() == bean.getPreErrorCode() && Intrinsics.b(value, 0)) {
                return false;
            }
            if ((bean.isCNDError() || bean.is4xxError()) && bean.getRequestNewSourceCount() < 5) {
                return true;
            }
        }
        return false;
    }

    public final boolean y(Fragment fragment) {
        Intrinsics.g(fragment, "fragment");
        boolean z11 = false;
        for (String str : f61139d) {
            if (!fragment.shouldShowRequestPermissionRationale(str)) {
                z11 = true;
            }
        }
        return z11;
    }

    public final void z(DownloadBean bean) {
        Intrinsics.g(bean, "bean");
        bean.setProgress(0L);
        Iterator<T> it = bean.getDownloadRanges().iterator();
        while (it.hasNext()) {
            ((DownloadRange) it.next()).setProgress(0L);
        }
    }
}
