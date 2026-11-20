package com.transsion.subtitle_download.task;

import android.app.Application;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.subtitle_download.SubtitleDownloadManager;
import com.transsion.subtitle_download.bean.SubtitleItem;
import com.transsion.subtitle_download.db.SubtitleDownloadDatabase;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import com.transsion.subtitle_download.utils.c;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.g;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
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
public final class GetInStationSubtitleListTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GetInStationSubtitleListTask f58367a = new GetInStationSubtitleListTask();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f58368b = LazyKt__LazyJVMKt.b(new Function0<ay.a>() { // from class: com.transsion.subtitle_download.task.GetInStationSubtitleListTask$api$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ay.a invoke() {
            return (ay.a) NetServiceGenerator.f49399d.a().i(ay.a.class);
        }
    });

    /* JADX WARN: Code duplicated, block: B:111:0x0407  */
    /* JADX WARN: Code duplicated, block: B:51:0x0228  */
    /* JADX WARN: Code duplicated, block: B:53:0x0236  */
    /* JADX WARN: Code duplicated, block: B:54:0x0240  */
    /* JADX WARN: Code duplicated, block: B:57:0x0258  */
    /* JADX WARN: Code duplicated, block: B:60:0x0290 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:63:0x0299  */
    /* JADX WARN: Code duplicated, block: B:64:0x029d  */
    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:102:0x03e5 -> B:103:0x03e7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x028e -> B:61:0x0291). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object e(com.tn.lib.net.bean.BaseDto<com.transsion.subtitle_download.bean.SubtitleListBean> r28, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, int r33, int r34, int r35, kotlin.coroutines.Continuation<? super kotlin.Unit> r36) {
        /*
            Method dump skipped, instruction units count: 1180
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subtitle_download.task.GetInStationSubtitleListTask.e(com.tn.lib.net.bean.BaseDto, kotlin.jvm.functions.Function1, java.lang.String, java.lang.String, java.lang.String, int, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void f(SubtitleDownloadTable dbBean) {
        Intrinsics.g(dbBean, "dbBean");
        j.d(l0.a(w0.b()), null, null, new GetInStationSubtitleListTask$download$2(dbBean, null), 3, null);
    }

    public final void g(String str, String str2, boolean z11, int i11, int i12, int i13, String str3, String str4, int i14, Function1<? super Boolean, Unit> function1) {
        j.d(l0.a(w0.b()), null, null, new GetInStationSubtitleListTask$download$1(z11, str, str3, i11, str2, function1, str4, i14, i12, i13, null), 3, null);
    }

    public final ay.a h() {
        return (ay.a) f58368b.getValue();
    }

    public final String i() {
        String simpleName = GetInStationSubtitleListTask.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final boolean j(String str, int i11, List<SubtitleDownloadTable> list) {
        boolean z11 = false;
        if (list != null) {
            for (SubtitleDownloadTable subtitleDownloadTable : list) {
                if (TextUtils.equals(str, subtitleDownloadTable.getId()) && i11 == subtitleDownloadTable.getResourceStreamType()) {
                    z11 = true;
                }
            }
        }
        return z11;
    }

    public final boolean k(String str, List<SubtitleItem> list) {
        Iterator<T> it = list.iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            if (TextUtils.equals(str, ((SubtitleItem) it.next()).getId())) {
                z11 = true;
            }
        }
        return z11;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:28:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:31:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:32:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:34:0x00da  */
    /* JADX WARN: Code duplicated, block: B:35:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:40:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object l(String str, String str2, String str3, int i11, int i12, int i13, SubtitleItem subtitleItem, boolean z11, Continuation<? super Boolean> continuation) throws Throwable {
        GetInStationSubtitleListTask$saveAdnDownload$1 getInStationSubtitleListTask$saveAdnDownload$1;
        SubtitleDownloadTable subtitleDownloadTableC;
        boolean z12;
        SubtitleDownloadTable subtitleDownloadTable;
        String lanAbbr;
        String upperCase;
        c cVar;
        Locale locale;
        String upperCase2;
        String lanAbbr2;
        String upperCase3;
        String upperCase4;
        if (continuation instanceof GetInStationSubtitleListTask$saveAdnDownload$1) {
            getInStationSubtitleListTask$saveAdnDownload$1 = (GetInStationSubtitleListTask$saveAdnDownload$1) continuation;
            int i14 = getInStationSubtitleListTask$saveAdnDownload$1.label;
            if ((i14 & Integer.MIN_VALUE) != 0) {
                getInStationSubtitleListTask$saveAdnDownload$1.label = i14 - Integer.MIN_VALUE;
            } else {
                getInStationSubtitleListTask$saveAdnDownload$1 = new GetInStationSubtitleListTask$saveAdnDownload$1(this, continuation);
            }
        } else {
            getInStationSubtitleListTask$saveAdnDownload$1 = new GetInStationSubtitleListTask$saveAdnDownload$1(this, continuation);
        }
        Object obj = getInStationSubtitleListTask$saveAdnDownload$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i15 = getInStationSubtitleListTask$saveAdnDownload$1.label;
        boolean z13 = true;
        if (i15 == 0) {
            ResultKt.b(obj);
            SubtitleDownloadDatabase.b bVar = SubtitleDownloadDatabase.f58352p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            dy.a aVarJ = bVar.b(applicationA).J();
            String id2 = subtitleItem.getId();
            if (id2 == null) {
                id2 = "";
            }
            subtitleDownloadTableC = aVarJ.c(id2, i11);
            if (subtitleDownloadTableC == null) {
                SubtitleDownloadTable subtitleDownloadTableB = cy.a.f62834a.b(str, str2, str3, i11, i12, i13, subtitleItem);
                subtitleDownloadTableB.setType(1);
                Application applicationA2 = Utils.a();
                Intrinsics.f(applicationA2, "getApp()");
                dy.a aVarJ2 = bVar.b(applicationA2).J();
                getInStationSubtitleListTask$saveAdnDownload$1.L$0 = subtitleDownloadTableB;
                z12 = z11;
                getInStationSubtitleListTask$saveAdnDownload$1.Z$0 = z12;
                getInStationSubtitleListTask$saveAdnDownload$1.label = 1;
                if (aVarJ2.e(subtitleDownloadTableB, getInStationSubtitleListTask$saveAdnDownload$1) == objE) {
                    return objE;
                }
                subtitleDownloadTable = subtitleDownloadTableB;
            } else {
                z12 = z11;
            }
            lanAbbr = subtitleDownloadTableC.getLanAbbr();
            if (lanAbbr != null) {
                upperCase = lanAbbr.toUpperCase(Locale.ROOT);
                Intrinsics.f(upperCase, "toUpperCase(...)");
            } else {
                upperCase = null;
            }
            cVar = c.f58376a;
            String strF = cVar.f();
            locale = Locale.ROOT;
            upperCase2 = strF.toUpperCase(locale);
            Intrinsics.f(upperCase2, "toUpperCase(...)");
            if (TextUtils.equals(upperCase, upperCase2)) {
                SubtitleDownloadTaskManager.c(SubtitleDownloadTaskManager.f58369a, subtitleDownloadTableC, false, 2, null);
            } else {
                lanAbbr2 = subtitleDownloadTableC.getLanAbbr();
                if (lanAbbr2 != null) {
                    upperCase3 = lanAbbr2.toUpperCase(locale);
                    Intrinsics.f(upperCase3, "toUpperCase(...)");
                } else {
                    upperCase3 = null;
                }
                upperCase4 = cVar.e().toUpperCase(locale);
                Intrinsics.f(upperCase4, "toUpperCase(...)");
                if (TextUtils.equals(upperCase3, upperCase4) || !z12) {
                    z13 = false;
                } else {
                    SubtitleDownloadTaskManager.c(SubtitleDownloadTaskManager.f58369a, subtitleDownloadTableC, false, 2, null);
                }
            }
            return Boxing.a(z13);
        }
        if (i15 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean z14 = getInStationSubtitleListTask$saveAdnDownload$1.Z$0;
        subtitleDownloadTable = (SubtitleDownloadTable) getInStationSubtitleListTask$saveAdnDownload$1.L$0;
        ResultKt.b(obj);
        z12 = z14;
        SubtitleDownloadManager.f58349a.m(subtitleDownloadTable);
        subtitleDownloadTableC = subtitleDownloadTable;
        lanAbbr = subtitleDownloadTableC.getLanAbbr();
        if (lanAbbr != null) {
            upperCase = lanAbbr.toUpperCase(Locale.ROOT);
            Intrinsics.f(upperCase, "toUpperCase(...)");
        } else {
            upperCase = null;
        }
        cVar = c.f58376a;
        String strF2 = cVar.f();
        locale = Locale.ROOT;
        upperCase2 = strF2.toUpperCase(locale);
        Intrinsics.f(upperCase2, "toUpperCase(...)");
        if (TextUtils.equals(upperCase, upperCase2)) {
            SubtitleDownloadTaskManager.c(SubtitleDownloadTaskManager.f58369a, subtitleDownloadTableC, false, 2, null);
        } else {
            lanAbbr2 = subtitleDownloadTableC.getLanAbbr();
            if (lanAbbr2 != null) {
                upperCase3 = lanAbbr2.toUpperCase(locale);
                Intrinsics.f(upperCase3, "toUpperCase(...)");
            } else {
                upperCase3 = null;
            }
            upperCase4 = cVar.e().toUpperCase(locale);
            Intrinsics.f(upperCase4, "toUpperCase(...)");
            if (TextUtils.equals(upperCase3, upperCase4)) {
                z13 = false;
            } else {
                z13 = false;
            }
        }
        return Boxing.a(z13);
    }

    public final void m(List<SubtitleItem> list) {
        SubtitleItem subtitleItemRemove;
        String upperCase;
        try {
            Result.Companion companion = Result.Companion;
            int i11 = -1;
            if (list != null) {
                int i12 = 0;
                for (Object obj : list) {
                    int i13 = i12 + 1;
                    if (i12 < 0) {
                        g.u();
                    }
                    String lanAbbr = ((SubtitleItem) obj).getLanAbbr();
                    if (lanAbbr != null) {
                        upperCase = lanAbbr.toUpperCase(Locale.ROOT);
                        Intrinsics.f(upperCase, "toUpperCase(...)");
                    } else {
                        upperCase = null;
                    }
                    String upperCase2 = c.f58376a.f().toUpperCase(Locale.ROOT);
                    Intrinsics.f(upperCase2, "toUpperCase(...)");
                    if (TextUtils.equals(upperCase, upperCase2)) {
                        i11 = i12;
                    }
                    i12 = i13;
                }
            }
            if (i11 > 0 && list != null && (subtitleItemRemove = list.remove(i11)) != null) {
                list.add(0, subtitleItemRemove);
            }
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }
}
