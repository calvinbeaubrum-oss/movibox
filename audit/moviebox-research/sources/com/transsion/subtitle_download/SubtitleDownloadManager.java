package com.transsion.subtitle_download;

import android.text.TextUtils;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import com.transsion.subtitle_download.task.GetInStationSubtitleListTask;
import com.transsion.subtitle_download.utils.ObserveNetworkState;
import com.transsion.subtitle_download.utils.b;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.h;
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
public final class SubtitleDownloadManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SubtitleDownloadManager f58349a = new SubtitleDownloadManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<a> f58350b = new CopyOnWriteArrayList<>();

    public final void b(a listener) {
        Intrinsics.g(listener, "listener");
        f58350b.add(listener);
    }

    public final Object c(String str, Continuation<? super Unit> continuation) {
        Object objG = h.g(w0.b(), new SubtitleDownloadManager$deleteSubtitle$2(str, null), continuation);
        return objG == kotlin.coroutines.intrinsics.a.e() ? objG : Unit.f68710a;
    }

    public final void d(SubtitleDownloadTable dbBean) {
        Intrinsics.g(dbBean, "dbBean");
        GetInStationSubtitleListTask.f58367a.f(dbBean);
    }

    public final void e(String str, String str2, String str3, String str4, int i11, boolean z11, int i12, int i13, int i14, Function1<? super Boolean, Unit> function1) {
        GetInStationSubtitleListTask.f58367a.g(str, str2, z11, i12, i13, i14, str3, str4, i11, function1);
    }

    public final String f() {
        String simpleName = SubtitleDownloadManager.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final Object g(String str, Continuation<? super List<SubtitleDownloadTable>> continuation) {
        return h.g(w0.b(), new SubtitleDownloadManager$getSubtitleList$2(str, null), continuation);
    }

    public final void h() {
        b.f58375a.b(f() + " --> init() --> 字幕下载工具初始化");
        ObserveNetworkState.f58373a.d();
    }

    public final Object i(SubtitleDownloadTable subtitleDownloadTable, Continuation<? super Unit> continuation) {
        if (!TextUtils.isEmpty(subtitleDownloadTable.getPath()) && !TextUtils.isEmpty(subtitleDownloadTable.getResourceId()) && !TextUtils.isEmpty(subtitleDownloadTable.getId())) {
            Object objG = h.g(w0.b(), new SubtitleDownloadManager$migration$2(subtitleDownloadTable, null), continuation);
            return objG == kotlin.coroutines.intrinsics.a.e() ? objG : Unit.f68710a;
        }
        b.f58375a.b(f() + " --> migration() --> 缺少必要字段 --> path = " + subtitleDownloadTable.getPath() + " -- resourceId = " + subtitleDownloadTable.getResourceId() + " -- id = " + subtitleDownloadTable.getId());
        return Unit.f68710a;
    }

    public final void j(SubtitleDownloadTable stDownloadTable) {
        Intrinsics.g(stDownloadTable, "stDownloadTable");
        com.transsion.subtitle_download.task.a.f58372a.c(stDownloadTable);
        Iterator<T> it = f58350b.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b0(stDownloadTable);
        }
    }

    public final void k(Exception e11, SubtitleDownloadTable dbBean) {
        Intrinsics.g(e11, "e");
        Intrinsics.g(dbBean, "dbBean");
        Iterator<T> it = f58350b.iterator();
        while (it.hasNext()) {
            ((a) it.next()).m(e11, dbBean);
        }
    }

    public final void l(int i11, SubtitleDownloadTable stDownloadTable) {
        Intrinsics.g(stDownloadTable, "stDownloadTable");
        Iterator<T> it = f58350b.iterator();
        while (it.hasNext()) {
            ((a) it.next()).B(i11, stDownloadTable);
        }
    }

    public final void m(SubtitleDownloadTable bean) {
        Intrinsics.g(bean, "bean");
        Iterator<T> it = f58350b.iterator();
        while (it.hasNext()) {
            ((a) it.next()).J(bean);
        }
    }

    public final void n(SubtitleDownloadTable stDownloadTable) {
        Intrinsics.g(stDownloadTable, "stDownloadTable");
        Iterator<T> it = f58350b.iterator();
        while (it.hasNext()) {
            ((a) it.next()).E(stDownloadTable);
        }
    }

    public final void o(a listener) {
        Intrinsics.g(listener, "listener");
        f58350b.remove(listener);
    }
}
