package com.transsnet.downloader.util;

import android.content.Context;
import com.blankj.utilcode.util.f0;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.transfer.impl.entity.FileData;
import com.transsnet.downloader.widget.TransferBottomToolsView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.k0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class DownloadTransferUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DownloadTransferUtils f61135a = new DownloadTransferUtils();

    public final String c(Map<String, String> map, int i11, DownloadBean downloadBean) {
        String cover;
        String cover2 = downloadBean.getCover();
        if (cover2 == null || !kotlin.text.l.L(cover2, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null)) {
            cover = downloadBean.getCover();
            if (cover == null) {
                return "";
            }
        } else {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            String cover3 = downloadBean.getCover();
            Intrinsics.d(cover3);
            cover = map.get(companion.e(cover3, (124 & 2) != 0 ? 0 : i11, (124 & 4) != 0 ? 0 : i11, (124 & 8) != 0, (124 & 16) != 0 ? false : true, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0));
            if (cover == null && (cover = downloadBean.getCover()) == null) {
                return "";
            }
        }
        return cover;
    }

    public final void d(Context context, final List<DownloadBean> list, final Function1<? super List<FileData>, Unit> callback) {
        Iterator it;
        String cover;
        String cover2;
        Intrinsics.g(context, "context");
        Intrinsics.g(callback, "callback");
        List<DownloadBean> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            callback.invoke(new ArrayList());
            return;
        }
        final int iA = f0.a(120.0f);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            DownloadBean downloadBean = (DownloadBean) it2.next();
            boolean zIsSeriesCollection = downloadBean.isSeriesCollection();
            Object obj = null;
            int i11 = 2;
            boolean z11 = false;
            String str = HttpHost.DEFAULT_SCHEME_NAME;
            boolean z12 = true;
            if (zIsSeriesCollection) {
                for (DownloadBean downloadBean2 : downloadBean.getSeriesList()) {
                    String cover3 = downloadBean2.getCover();
                    if (cover3 != null && kotlin.text.l.L(cover3, str, z11, i11, obj) == z12 && (cover2 = downloadBean2.getCover()) != null) {
                        arrayList.add(ImageHelper.f51371a.e(cover2, (124 & 2) != 0 ? 0 : iA, (124 & 4) != 0 ? 0 : iA, (124 & 8) != 0, (124 & 16) != 0 ? false : true, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0));
                    }
                    obj = obj;
                    it2 = it2;
                    str = str;
                    z12 = true;
                    z11 = false;
                    i11 = 2;
                }
                it = it2;
            } else {
                it = it2;
                String cover4 = downloadBean.getCover();
                if (cover4 != null && kotlin.text.l.L(cover4, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null) && (cover = downloadBean.getCover()) != null) {
                    arrayList.add(ImageHelper.f51371a.e(cover, (124 & 2) != 0 ? 0 : iA, (124 & 4) != 0 ? 0 : iA, (124 & 8) != 0, (124 & 16) != 0 ? false : true, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0));
                }
            }
            it2 = it;
        }
        uo.b.a.f(uo.b.f78622a, TransferBottomToolsView.TAG, "getTransferDataList-----1", false, 4, null);
        e(l0.a(w0.c()), context, arrayList, new Function1<Map<String, String>, Unit>() { // from class: com.transsnet.downloader.util.DownloadTransferUtils$getTransferDataList$2

            /* JADX INFO: renamed from: com.transsnet.downloader.util.DownloadTransferUtils$getTransferDataList$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            @DebugMetadata(c = "com.transsnet.downloader.util.DownloadTransferUtils$getTransferDataList$2$1", f = "DownloadTransferUtils.kt", l = {83}, m = "invokeSuspend")
            @SourceDebugExtension
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function1<List<FileData>, Unit> $callback;
                final /* synthetic */ int $coverWidth;
                final /* synthetic */ Map<String, String> $pathMap;
                final /* synthetic */ List<DownloadBean> $selectedList;
                int label;

                /* JADX INFO: renamed from: com.transsnet.downloader.util.DownloadTransferUtils$getTransferDataList$2$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: source.java */
                @Metadata
                @DebugMetadata(c = "com.transsnet.downloader.util.DownloadTransferUtils$getTransferDataList$2$1$2", f = "DownloadTransferUtils.kt", l = {}, m = "invokeSuspend")
                public static final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Function1<List<FileData>, Unit> $callback;
                    final /* synthetic */ List<FileData> $fileDataList;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public AnonymousClass2(Function1<? super List<FileData>, Unit> function1, List<FileData> list, Continuation<? super AnonymousClass2> continuation) {
                        super(2, continuation);
                        this.$callback = function1;
                        this.$fileDataList = list;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass2(this.$callback, this.$fileDataList, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        kotlin.coroutines.intrinsics.a.e();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        uo.b.a.f(uo.b.f78622a, TransferBottomToolsView.TAG, "getTransferDataList-----3", false, 4, null);
                        this.$callback.invoke(this.$fileDataList);
                        return Unit.f68710a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public AnonymousClass1(List<DownloadBean> list, Map<String, String> map, int i11, Function1<? super List<FileData>, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$selectedList = list;
                    this.$pathMap = map;
                    this.$coverWidth = i11;
                    this.$callback = function1;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$selectedList, this.$pathMap, this.$coverWidth, this.$callback, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objE = kotlin.coroutines.intrinsics.a.e();
                    int i11 = this.label;
                    if (i11 == 0) {
                        ResultKt.b(obj);
                        ArrayList arrayList = new ArrayList();
                        List<DownloadBean> list = this.$selectedList;
                        Map<String, String> map = this.$pathMap;
                        int i12 = this.$coverWidth;
                        for (DownloadBean downloadBean : list) {
                            if (downloadBean.isSeriesCollection()) {
                                for (DownloadBean downloadBean2 : downloadBean.getSeriesList()) {
                                    if (downloadBean2.isCheck()) {
                                        DownloadTransferUtils downloadTransferUtils = DownloadTransferUtils.f61135a;
                                        arrayList.add(downloadTransferUtils.f(downloadTransferUtils.c(map, i12, downloadBean), downloadBean2));
                                    }
                                }
                            } else {
                                DownloadTransferUtils downloadTransferUtils2 = DownloadTransferUtils.f61135a;
                                arrayList.add(downloadTransferUtils2.f(downloadTransferUtils2.c(map, i12, downloadBean), downloadBean));
                            }
                        }
                        a2 a2VarC = w0.c();
                        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$callback, arrayList, null);
                        this.label = 1;
                        if (kotlinx.coroutines.h.g(a2VarC, anonymousClass2, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    return Unit.f68710a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, String> map) {
                invoke2(map);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Map<String, String> pathMap) {
                Intrinsics.g(pathMap, "pathMap");
                uo.b.a.f(uo.b.f78622a, TransferBottomToolsView.TAG, "getTransferDataList-----2", false, 4, null);
                kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new AnonymousClass1(list, pathMap, iA, callback, null), 3, null);
            }
        });
    }

    public final void e(k0 k0Var, Context context, List<String> list, Function1<? super Map<String, String>, Unit> function1) {
        kotlinx.coroutines.j.d(k0Var, w0.c(), null, new DownloadTransferUtils$loadPath$1(list, function1, context, null), 2, null);
    }

    public final FileData f(String str, DownloadBean downloadBean) {
        String name;
        if (!downloadBean.isInnerRes()) {
            name = downloadBean.getName();
            if (name == null) {
                name = "";
            }
        } else {
            String path = downloadBean.getPath();
            name = path != null ? new File(path).getName() : null;
            if (name == null) {
                String fileName = downloadBean.getFileName();
                if (fileName == null) {
                    fileName = "";
                }
                name = fileName + ".mp4";
            }
        }
        String cover = downloadBean.getCover();
        if (cover == null) {
            cover = "";
        }
        String path2 = downloadBean.getPath();
        if (name.length() == 0 && path2 != null && path2.length() > 0) {
            name = new File(path2).getName();
            Intrinsics.f(name, "File(path).name");
        }
        String str2 = name;
        uo.b.a.f(uo.b.f78622a, TransferBottomToolsView.TAG, "transLocalData2FileData: coverImagePath:" + cover + ", coverPath:" + str, false, 4, null);
        String str3 = path2 == null ? "" : path2;
        Long size = downloadBean.getSize();
        FileData fileData = new FileData(str3, str2, size != null ? size.longValue() : 0L, str, null, null, 0, 0L, 240, null);
        fileData.setDownloadBean(downloadBean);
        return fileData;
    }
}
