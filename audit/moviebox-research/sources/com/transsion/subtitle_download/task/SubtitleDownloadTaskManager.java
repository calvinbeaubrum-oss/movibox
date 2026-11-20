package com.transsion.subtitle_download.task;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.blankj.utilcode.util.Utils;
import com.transsion.subtitle_download.SubtitleDownloadManager;
import com.transsion.subtitle_download.db.SubtitleDownloadDatabase;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import com.transsion.subtitle_download.utils.b;
import com.transsion.subtitle_download.utils.c;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class SubtitleDownloadTaskManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SubtitleDownloadTaskManager f58369a = new SubtitleDownloadTaskManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedBlockingDeque<SubtitleDownloadTable> f58370b = new LinkedBlockingDeque<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f58371c;

    public static /* synthetic */ void c(SubtitleDownloadTaskManager subtitleDownloadTaskManager, SubtitleDownloadTable subtitleDownloadTable, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        subtitleDownloadTaskManager.b(subtitleDownloadTable, z11);
    }

    public final void b(SubtitleDownloadTable dbBean, boolean z11) {
        Intrinsics.g(dbBean, "dbBean");
        if (c.f58376a.h(dbBean.getPath())) {
            b.f58375a.c(f() + " --> addTaskAndExecute() --> 开始下载字幕 --> 如果字幕资源已经下载完成了，那就直接跳过 --> next() -- getSubtitleInfo = " + dbBean.getSubtitleInfo());
            dbBean.setStatus(5);
            SubtitleDownloadDatabase.b bVar = SubtitleDownloadDatabase.f58352p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            bVar.b(applicationA).J().f(dbBean);
            SubtitleDownloadManager.f58349a.j(dbBean);
            return;
        }
        Iterator<T> it = f58370b.iterator();
        boolean z12 = false;
        while (it.hasNext()) {
            if (TextUtils.equals(((SubtitleDownloadTable) it.next()).getId(), dbBean.getId())) {
                z12 = true;
            }
        }
        if (z12) {
            return;
        }
        a.f58372a.d(dbBean);
        if (z11) {
            f58370b.addFirst(dbBean);
        } else {
            f58370b.add(dbBean);
        }
        b.f58375a.a(f() + " --> addTaskAndExecute() --> 剩余任务数量 -- taskList.size = " + f58370b.size() + " --> isDownloading = " + f58371c + " --> dbBean.failCount = " + dbBean.getFailCount());
        e();
    }

    public final void d() {
        f58371c = false;
        e();
    }

    public final void e() {
        Object objM163constructorimpl;
        Unit unit;
        if (!f58371c) {
            LinkedBlockingDeque<SubtitleDownloadTable> linkedBlockingDeque = f58370b;
            if (!linkedBlockingDeque.isEmpty()) {
                f58371c = true;
                try {
                    Result.Companion companion = Result.Companion;
                    SubtitleDownloadTable subtitleDownloadTableRemoveFirst = linkedBlockingDeque.removeFirst();
                    if (subtitleDownloadTableRemoveFirst != null) {
                        Intrinsics.f(subtitleDownloadTableRemoveFirst, "removeFirst()");
                        int type = subtitleDownloadTableRemoveFirst.getType();
                        if (type == 4) {
                            new SearchOpenSubtitleDownloadTask().i(subtitleDownloadTableRemoveFirst, new Function0<Unit>() { // from class: com.transsion.subtitle_download.task.SubtitleDownloadTaskManager$downloadNext$1$1$1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    this.$this_runCatching.d();
                                }
                            });
                        } else if (type != 5) {
                            new InStationSubtitleDownloadTask().i(subtitleDownloadTableRemoveFirst, new Function0<Unit>() { // from class: com.transsion.subtitle_download.task.SubtitleDownloadTaskManager$downloadNext$1$1$3
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    this.$this_runCatching.d();
                                }
                            });
                        } else {
                            new SearchOenSubtitleNewApiDownloadTask().i(subtitleDownloadTableRemoveFirst, new Function0<Unit>() { // from class: com.transsion.subtitle_download.task.SubtitleDownloadTaskManager$downloadNext$1$1$2
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    this.$this_runCatching.d();
                                }
                            });
                        }
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
                b bVar = b.f58375a;
                SubtitleDownloadTaskManager subtitleDownloadTaskManager = f58369a;
                bVar.b(subtitleDownloadTaskManager.f() + " --> downloadNext() --> 执行下载任务发生异常 -- it = " + Log.getStackTraceString(thM166exceptionOrNullimpl));
                subtitleDownloadTaskManager.d();
                return;
            }
        }
        LinkedBlockingDeque<SubtitleDownloadTable> linkedBlockingDeque2 = f58370b;
        if (linkedBlockingDeque2.isEmpty()) {
            b.f58375a.c(f() + " --> downloadNext() --> taskList = " + linkedBlockingDeque2.size() + " -- 当前没有可执行任务了");
        }
    }

    public final String f() {
        String simpleName = SubtitleDownloadTaskManager.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
