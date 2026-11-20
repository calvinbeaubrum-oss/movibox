package com.transsnet.downloader.core.task;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadRange;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsnet.downloader.core.DownloadTaskImpl2;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import com.transsnet.downloader.util.DownloadUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import l.p;
import tr.h;

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
public final class DownloadTaskUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DownloadTaskUtil f60483a = new DownloadTaskUtil();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f60484b = LazyKt__LazyJVMKt.b(new Function0<h>() { // from class: com.transsnet.downloader.core.task.DownloadTaskUtil$rangeDao$2
        @Override // kotlin.jvm.functions.Function0
        public final h invoke() {
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return v0Var.b(applicationA).F0();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f60485c = LazyKt__LazyJVMKt.b(new Function0<Boolean>() { // from class: com.transsnet.downloader.core.task.DownloadTaskUtil$downloadNewRanges$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            Boolean boolY0;
            ConfigBean configBeanB = ConfigManager.f53111c.a().b("downloadNewRange", false);
            String value = configBeanB != null ? configBeanB.getValue() : null;
            boolean zBooleanValue = true;
            if (value != null && value.length() != 0 && (boolY0 = StringsKt__StringsKt.Y0(value)) != null) {
                zBooleanValue = boolY0.booleanValue();
            }
            return Boolean.valueOf(zBooleanValue);
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f60486d = LazyKt__LazyJVMKt.b(new Function0<Boolean>() { // from class: com.transsnet.downloader.core.task.DownloadTaskUtil$downloadInCoroutine$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            Boolean boolY0;
            ConfigBean configBeanB = ConfigManager.f53111c.a().b("downloadInCoroutine", false);
            String value = configBeanB != null ? configBeanB.getValue() : null;
            boolean zBooleanValue = true;
            if (value != null && value.length() != 0 && (boolY0 = StringsKt__StringsKt.Y0(value)) != null) {
                zBooleanValue = boolY0.booleanValue();
            }
            return Boolean.valueOf(zBooleanValue);
        }
    });

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object a(long j11, DownloadBean downloadBean, List<DownloadRange> list, Continuation<? super List<DownloadRange>> continuation) {
        DownloadTaskUtil$checkOldRanges$1 downloadTaskUtil$checkOldRanges$1;
        String str;
        List<DownloadRange> list2;
        DownloadBean downloadBean2;
        long j12;
        if (continuation instanceof DownloadTaskUtil$checkOldRanges$1) {
            downloadTaskUtil$checkOldRanges$1 = (DownloadTaskUtil$checkOldRanges$1) continuation;
            int i11 = downloadTaskUtil$checkOldRanges$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                downloadTaskUtil$checkOldRanges$1.label = i11 - Integer.MIN_VALUE;
            } else {
                downloadTaskUtil$checkOldRanges$1 = new DownloadTaskUtil$checkOldRanges$1(this, continuation);
            }
        } else {
            downloadTaskUtil$checkOldRanges$1 = new DownloadTaskUtil$checkOldRanges$1(this, continuation);
        }
        Object obj = downloadTaskUtil$checkOldRanges$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = downloadTaskUtil$checkOldRanges$1.label;
        String str2 = DownloadBaseRunnable.TAG;
        if (i12 == 0) {
            ResultKt.b(obj);
            ArrayList arrayList = new ArrayList();
            Iterator<DownloadRange> it = list.iterator();
            while (it.hasNext()) {
                DownloadRange next = it.next();
                if (next.isRangeDownloadSuccess() || next.getRangeSize() < j11 + 3145728) {
                    objE = objE;
                    str2 = str2;
                    it = it;
                    downloadTaskUtil$checkOldRanges$1 = downloadTaskUtil$checkOldRanges$1;
                    arrayList = arrayList;
                } else {
                    Object obj2 = objE;
                    Iterator<DownloadRange> it2 = it;
                    uo.b.f78622a.c(str2, "checkOldRanges, rangeId:" + next.getRangeId() + ",start:" + next.getStart() + ",end:" + next.getEnd() + ",progress:" + next.getProgress(), true);
                    Ref.LongRef longRef = new Ref.LongRef();
                    longRef.element = -1L;
                    Ref.LongRef longRef2 = new Ref.LongRef();
                    longRef2.element = -1L;
                    long j13 = next.totalProgress();
                    long end = next.getEnd();
                    while (true) {
                        long j14 = longRef.element;
                        if (j14 >= end) {
                            break;
                        }
                        long start = longRef2.element < 0 ? next.getStart() : j14 + 1;
                        longRef2.element = start;
                        long j15 = (start + j11) - 1;
                        longRef.element = j15;
                        if (j15 >= end) {
                            longRef.element = end;
                        }
                        if (j13 > longRef.element) {
                            j12 = j11;
                        } else {
                            long j16 = longRef2.element;
                            j12 = j13 > j16 ? j13 - j16 : 0L;
                        }
                        end = end;
                        if (longRef2.element == next.getStart()) {
                            next.setEnd(longRef.element);
                            next.setProgress(j12);
                            ArrayList arrayList2 = arrayList;
                            Ref.LongRef longRef3 = longRef2;
                            String str3 = str2;
                            uo.b.f78622a.c(str3, "checkOldRanges,oldRange rangeId:" + next.getRangeId() + ", start:" + longRef2.element + ", end:" + longRef.element + ", progress:" + j12 + ", totalProgress:" + j13, true);
                            str2 = str3;
                            arrayList = arrayList2;
                            longRef2 = longRef3;
                            downloadTaskUtil$checkOldRanges$1 = downloadTaskUtil$checkOldRanges$1;
                            longRef = longRef;
                        } else {
                            ArrayList arrayList3 = arrayList;
                            DownloadTaskUtil$checkOldRanges$1 downloadTaskUtil$checkOldRanges$2 = downloadTaskUtil$checkOldRanges$1;
                            Ref.LongRef longRef4 = longRef;
                            Ref.LongRef longRef5 = longRef2;
                            String str4 = str2;
                            DownloadRange downloadRange = new DownloadRange();
                            downloadRange.setThreadId(next.getThreadId());
                            downloadRange.setRangeId(p.a(longRef5.element + longRef4.element));
                            downloadRange.setResourceId(next.getResourceId());
                            downloadRange.setStart(longRef5.element);
                            downloadRange.setEnd(longRef4.element);
                            downloadRange.setProgress(j12);
                            DownloadRange downloadRange2 = next;
                            uo.b.f78622a.c(str4, "checkOldRanges,newRange rangeId:" + downloadRange.getRangeId() + ", start:" + longRef5.element + ", end:" + longRef4.element + ", progress:" + j12, true);
                            arrayList3.add(downloadRange);
                            str2 = str4;
                            longRef = longRef4;
                            next = downloadRange2;
                            longRef2 = longRef5;
                            downloadTaskUtil$checkOldRanges$1 = downloadTaskUtil$checkOldRanges$2;
                            j13 = j13;
                            arrayList = arrayList3;
                        }
                    }
                    objE = obj2;
                    it = it2;
                }
            }
            Collection<? extends DownloadRange> collection = arrayList;
            DownloadTaskUtil$checkOldRanges$1 downloadTaskUtil$checkOldRanges$3 = downloadTaskUtil$checkOldRanges$1;
            Object obj3 = objE;
            str = str2;
            if (!(!collection.isEmpty())) {
                return list;
            }
            list2 = list;
            list2.addAll(collection);
            downloadBean2 = downloadBean;
            downloadTaskUtil$checkOldRanges$3.L$0 = downloadBean2;
            downloadTaskUtil$checkOldRanges$3.L$1 = list2;
            downloadTaskUtil$checkOldRanges$3.label = 1;
            if (h(list2, downloadTaskUtil$checkOldRanges$3) == obj3) {
                return obj3;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List<DownloadRange> list3 = (List) downloadTaskUtil$checkOldRanges$1.L$1;
            DownloadBean downloadBean3 = (DownloadBean) downloadTaskUtil$checkOldRanges$1.L$0;
            ResultKt.b(obj);
            str = DownloadBaseRunnable.TAG;
            downloadBean2 = downloadBean3;
            list2 = list3;
        }
        uo.b.f78622a.c(str, "checkOldRanges, set new range, size:" + downloadBean2.getDownloadRanges().size(), true);
        return list2;
    }

    public final void b(DownloadBean downloadBean) {
        Intrinsics.g(downloadBean, "downloadBean");
        String path = downloadBean.getPath();
        if (path == null || path.length() == 0) {
            downloadBean.setPath(DownloadUtil.f61136a.j(downloadBean));
            uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"DownloadTaskImpl 新任务, set download path, path = " + downloadBean.getPath()}, true);
        }
    }

    public final long c(DownloadBean downloadBean, DownloadTaskImpl2 downloadTask, b bVar) {
        Intrinsics.g(downloadBean, "downloadBean");
        Intrinsics.g(downloadTask, "downloadTask");
        ArrayList<DownloadRange> arrayList = new ArrayList();
        arrayList.addAll(downloadBean.getDownloadRanges());
        AtomicLong atomicLong = new AtomicLong(0L);
        for (DownloadRange downloadRange : arrayList) {
            if (!downloadRange.getReDownload() && downloadRange.getProgress() > 0) {
                atomicLong.getAndAdd(downloadRange.getProgress());
            }
        }
        long j11 = atomicLong.get();
        synchronized (downloadTask) {
            try {
                downloadBean.setProgress(j11);
                if (downloadBean.isPreDownload() && j11 >= 5242880 && bVar != null) {
                    bVar.H(downloadBean);
                }
                uo.b.a.f(uo.b.f78622a, "DownloadThread", "------------total size:" + downloadBean.getSize() + " progress:" + j11 + ", isPreDownload: " + downloadBean.isPreDownload(), false, 4, null);
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return j11;
    }

    public final boolean d() {
        return ((Boolean) f60486d.getValue()).booleanValue();
    }

    public final boolean e() {
        return ((Boolean) f60485c.getValue()).booleanValue();
    }

    public final List<DownloadRange> f(int i11, DownloadBean downloadBean) {
        Intrinsics.g(downloadBean, "downloadBean");
        long currentOffset = 0;
        if (downloadBean.getCurrentOffset() > 0) {
            long currentOffset2 = downloadBean.getCurrentOffset();
            Long size = downloadBean.getSize();
            if (currentOffset2 < (size != null ? size.longValue() : 0L)) {
                currentOffset = downloadBean.getCurrentOffset();
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<DownloadRange> arrayList2 = new ArrayList();
        arrayList2.addAll(downloadBean.getDownloadRanges());
        for (DownloadRange downloadRange : arrayList2) {
            if (!downloadRange.isRangeDownloadSuccess() && !downloadRange.isDownloading() && (!downloadBean.isDownloadingPlay() || downloadRange.getEnd() >= currentOffset)) {
                arrayList.add(downloadRange);
                if (arrayList.size() >= i11) {
                    break;
                }
            }
        }
        if (arrayList.size() < i11) {
            for (DownloadRange downloadRange2 : arrayList2) {
                if (!downloadRange2.isRangeDownloadSuccess() && !downloadRange2.isDownloading() && !arrayList.contains(downloadRange2)) {
                    arrayList.add(downloadRange2);
                    if (arrayList.size() >= i11) {
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    public final h g() {
        return (h) f60484b.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0082 A[Catch: all -> 0x0115, TryCatch #0 {all -> 0x0115, blocks: (B:12:0x0039, B:23:0x009e, B:18:0x007c, B:20:0x0082, B:24:0x00f0, B:17:0x0054), top: B:28:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x009d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x009b -> B:23:0x009e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object h(java.util.List<com.transsion.baselib.db.download.DownloadRange> r24, kotlin.coroutines.Continuation<? super kotlin.Unit> r25) {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.core.task.DownloadTaskUtil.h(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
