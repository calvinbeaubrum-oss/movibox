package com.transsion.subtitle.viewmodel;

import android.app.Application;
import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.SubtitleLanguageMapBean;
import com.transsion.moviedetailapi.bean.SubtitleItem;
import com.transsion.subtitle.bean.OpenSubtitleData;
import com.transsion.subtitle.bean.SubtitleSearchListBean;
import com.transsion.subtitle.fragment.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import tr.o;
import uo.b;
import yx.a;

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
public final class SubtitleDownloadViewModel extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f58319a = LazyKt__LazyJVMKt.b(new Function0<a>() { // from class: com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$service$2
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f58320b = LazyKt__LazyJVMKt.b(new Function0<o>() { // from class: com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$subtitleLanguageMapDao$2
        @Override // kotlin.jvm.functions.Function0
        public final o invoke() {
            Application applicationA = com.tn.lib.util.a.f49452a.a();
            if (applicationA != null) {
                return AppDatabase.f51036p.b(applicationA).N0();
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0<Integer> f58321c = new c0<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0<String> f58322d = new c0<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c0<String> f58323f = new c0<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0<List<SubtitleLanguageMapBean>> f58324g = new c0<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c0<List<SubtitleLanguageMapBean>> f58325h = new c0<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c0<g> f58326i = new c0<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c0<SubtitleSearchListBean> f58327j = new c0<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c0<vx.a> f58328k = new c0<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c0<Map<String, vx.a>> f58329l = new c0<>();

    public static /* synthetic */ void s(SubtitleDownloadViewModel subtitleDownloadViewModel, g gVar, String str, List list, DownloadBean downloadBean, String str2, int i11, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            str2 = "1";
        }
        subtitleDownloadViewModel.r(gVar, str, list, downloadBean, str2, (i12 & 32) != 0 ? 20 : i11);
    }

    public final void e(String subtitleResId) {
        Intrinsics.g(subtitleResId, "subtitleResId");
        j.d(u0.a(this), null, null, new SubtitleDownloadViewModel$getDownloadedList$1(subtitleResId, this, null), 3, null);
    }

    public final c0<String> f() {
        return this.f58322d;
    }

    public final void g() {
        j.d(l0.a(w0.b()), null, null, new SubtitleDownloadViewModel$getLanguageAllList$1(this, null), 3, null);
    }

    public final c0<List<SubtitleLanguageMapBean>> h() {
        return this.f58324g;
    }

    public final void i(vx.a item) {
        Intrinsics.g(item, "item");
        j.d(u0.a(this), w0.b(), null, new SubtitleDownloadViewModel$getOpenSubNewApiDownloadInfo$1(item, this, null), 2, null);
    }

    public final c0<vx.a> j() {
        return this.f58328k;
    }

    public final c0<Map<String, vx.a>> k() {
        return this.f58329l;
    }

    public final c0<String> l() {
        return this.f58323f;
    }

    public final c0<SubtitleSearchListBean> m() {
        return this.f58327j;
    }

    public final a n() {
        return (a) this.f58319a.getValue();
    }

    public final o o() {
        return (o) this.f58320b.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    public final Object p(g gVar, String str, DownloadBean downloadBean, String str2, int i11, Continuation<? super SubtitleSearchListBean> continuation) throws Throwable {
        SubtitleDownloadViewModel$searchFromMovieBox$1 subtitleDownloadViewModel$searchFromMovieBox$1;
        String subjectId;
        int i12;
        String str3 = str2;
        if (continuation instanceof SubtitleDownloadViewModel$searchFromMovieBox$1) {
            subtitleDownloadViewModel$searchFromMovieBox$1 = (SubtitleDownloadViewModel$searchFromMovieBox$1) continuation;
            int i13 = subtitleDownloadViewModel$searchFromMovieBox$1.label;
            if ((i13 & Integer.MIN_VALUE) != 0) {
                subtitleDownloadViewModel$searchFromMovieBox$1.label = i13 - Integer.MIN_VALUE;
            } else {
                subtitleDownloadViewModel$searchFromMovieBox$1 = new SubtitleDownloadViewModel$searchFromMovieBox$1(this, continuation);
            }
        } else {
            subtitleDownloadViewModel$searchFromMovieBox$1 = new SubtitleDownloadViewModel$searchFromMovieBox$1(this, continuation);
        }
        SubtitleDownloadViewModel$searchFromMovieBox$1 subtitleDownloadViewModel$searchFromMovieBox$2 = subtitleDownloadViewModel$searchFromMovieBox$1;
        Object objA = subtitleDownloadViewModel$searchFromMovieBox$2.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i14 = subtitleDownloadViewModel$searchFromMovieBox$2.label;
        if (i14 == 0) {
            ResultKt.b(objA);
            if (gVar == null || gVar.b().length() == 0) {
                SubtitleSearchListBean subtitleSearchListBean = new SubtitleSearchListBean(null, null, 0, false, 12, null);
                subtitleSearchListBean.setSearchType(1);
                subtitleSearchListBean.setRefresh(Intrinsics.b(str3, "1"));
                return subtitleSearchListBean;
            }
            b.a.s(b.f78622a, "ORSubtitle_search", "222 searchFromMovieBox name:" + gVar.b() + ",ep:" + gVar.a() + ",se:" + gVar.c(), false, 4, null);
            a aVarN = n();
            String strB = gVar.b();
            if (downloadBean == null || (subjectId = downloadBean.getSubjectId()) == null) {
                subjectId = "";
            }
            String str4 = subjectId;
            int iC = gVar.c();
            int iA = gVar.a();
            subtitleDownloadViewModel$searchFromMovieBox$2.L$0 = str3;
            subtitleDownloadViewModel$searchFromMovieBox$2.label = 1;
            i12 = 1;
            objA = a.C0918a.a(aVarN, null, strB, str, str4, iC, iA, str2, i11, subtitleDownloadViewModel$searchFromMovieBox$2, 1, null);
            if (objA == objE) {
                return objE;
            }
        } else {
            if (i14 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str5 = (String) subtitleDownloadViewModel$searchFromMovieBox$2.L$0;
            ResultKt.b(objA);
            str3 = str5;
            i12 = 1;
        }
        BaseDto baseDto = (BaseDto) objA;
        if (!Intrinsics.b(baseDto.getCode(), "0")) {
            SubtitleSearchListBean subtitleSearchListBean2 = new SubtitleSearchListBean(null, null, 0, false, 12, null);
            subtitleSearchListBean2.setSearchType(i12);
            subtitleSearchListBean2.setRefresh(Intrinsics.b(str3, "1"));
            return subtitleSearchListBean2;
        }
        com.transsion.subtitle.helper.b.f58260a.f(i12, baseDto.getReason());
        SubtitleSearchListBean subtitleSearchListBean3 = (SubtitleSearchListBean) baseDto.getData();
        if (subtitleSearchListBean3 != null) {
            subtitleSearchListBean3.setSearchType(i12);
            subtitleSearchListBean3.setRefresh(Intrinsics.b(str3, "1"));
            List<SubtitleItem> items = subtitleSearchListBean3.getItems();
            if (items != null) {
                Iterator<T> it = items.iterator();
                while (it.hasNext()) {
                    ((SubtitleItem) it.next()).setType(Boxing.d(2));
                }
            }
        }
        return (SubtitleSearchListBean) baseDto.getData();
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object q(DownloadBean downloadBean, g gVar, List<SubtitleLanguageMapBean> list, Continuation<? super SubtitleSearchListBean> continuation) throws Throwable {
        SubtitleDownloadViewModel$searchFromOpenSubtitleNewApi$1 subtitleDownloadViewModel$searchFromOpenSubtitleNewApi$1;
        String name;
        String lan;
        String strB;
        String strB2;
        String lan2;
        List list2;
        if (continuation instanceof SubtitleDownloadViewModel$searchFromOpenSubtitleNewApi$1) {
            subtitleDownloadViewModel$searchFromOpenSubtitleNewApi$1 = (SubtitleDownloadViewModel$searchFromOpenSubtitleNewApi$1) continuation;
            int i11 = subtitleDownloadViewModel$searchFromOpenSubtitleNewApi$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                subtitleDownloadViewModel$searchFromOpenSubtitleNewApi$1.label = i11 - Integer.MIN_VALUE;
            } else {
                subtitleDownloadViewModel$searchFromOpenSubtitleNewApi$1 = new SubtitleDownloadViewModel$searchFromOpenSubtitleNewApi$1(this, continuation);
            }
        } else {
            subtitleDownloadViewModel$searchFromOpenSubtitleNewApi$1 = new SubtitleDownloadViewModel$searchFromOpenSubtitleNewApi$1(this, continuation);
        }
        SubtitleDownloadViewModel$searchFromOpenSubtitleNewApi$1 subtitleDownloadViewModel$searchFromOpenSubtitleNewApi$2 = subtitleDownloadViewModel$searchFromOpenSubtitleNewApi$1;
        Object objE = subtitleDownloadViewModel$searchFromOpenSubtitleNewApi$2.result;
        Object objE2 = kotlin.coroutines.intrinsics.a.e();
        int i12 = subtitleDownloadViewModel$searchFromOpenSubtitleNewApi$2.label;
        if (i12 == 0) {
            ResultKt.b(objE);
            b.f78622a.c(com.transsion.baselib.report.a.f51248a.a(), "searchFromOpenSubtitleNewApi -start", true);
            if (downloadBean == null || !downloadBean.isSeries()) {
                com.transsion.subtitle.helper.b bVar = com.transsion.subtitle.helper.b.f58260a;
                if (gVar == null || (strB = gVar.b()) == null) {
                    name = downloadBean != null ? downloadBean.getName() : null;
                    if (name == null) {
                        name = "";
                    }
                } else {
                    name = strB;
                }
                SubtitleLanguageMapBean subtitleLanguageMapBean = (SubtitleLanguageMapBean) CollectionsKt___CollectionsKt.g0(list);
                String str = (subtitleLanguageMapBean == null || (lan = subtitleLanguageMapBean.getLan()) == null) ? "" : lan;
                subtitleDownloadViewModel$searchFromOpenSubtitleNewApi$2.label = 2;
                objE = bVar.e(name, str, null, null, subtitleDownloadViewModel$searchFromOpenSubtitleNewApi$2);
                if (objE == objE2) {
                    return objE2;
                }
                list2 = (List) objE;
            } else {
                com.transsion.subtitle.helper.b bVar2 = com.transsion.subtitle.helper.b.f58260a;
                if (gVar == null || (strB2 = gVar.b()) == null) {
                    String name2 = downloadBean.getName();
                    strB2 = name2 == null ? "" : name2;
                }
                SubtitleLanguageMapBean subtitleLanguageMapBean2 = (SubtitleLanguageMapBean) CollectionsKt___CollectionsKt.g0(list);
                String str2 = (subtitleLanguageMapBean2 == null || (lan2 = subtitleLanguageMapBean2.getLan()) == null) ? "" : lan2;
                Integer numD = gVar != null ? Boxing.d(gVar.c()) : null;
                Integer numD2 = gVar != null ? Boxing.d(gVar.a()) : null;
                subtitleDownloadViewModel$searchFromOpenSubtitleNewApi$2.label = 1;
                objE = bVar2.e(strB2, str2, numD, numD2, subtitleDownloadViewModel$searchFromOpenSubtitleNewApi$2);
                if (objE == objE2) {
                    return objE2;
                }
                list2 = (List) objE;
            }
        } else if (i12 == 1) {
            ResultKt.b(objE);
            list2 = (List) objE;
        } else {
            if (i12 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(objE);
            list2 = (List) objE;
        }
        List list3 = list2;
        if (list3 == null || list3.isEmpty()) {
            b.f78622a.c(com.transsion.baselib.report.a.f51248a.a(), "searchFromOpenSubtitleNewApi -fail", true);
            return null;
        }
        b.f78622a.c(com.transsion.baselib.report.a.f51248a.a(), "searchFromOpenSubtitleNewApi -success", true);
        ArrayList arrayList = new ArrayList();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            SubtitleItem subtitleBean = ((OpenSubtitleData) it.next()).toSubtitleBean();
            if (subtitleBean != null) {
                arrayList.add(subtitleBean);
            }
        }
        SubtitleSearchListBean subtitleSearchListBean = new SubtitleSearchListBean(null, arrayList, 0, false, 12, null);
        subtitleSearchListBean.setSearchType(3);
        subtitleSearchListBean.setRefresh(true);
        return subtitleSearchListBean;
    }

    public final void r(g gVar, String languages, List<SubtitleLanguageMapBean> languageList, DownloadBean downloadBean, String nextPage, int i11) {
        Intrinsics.g(languages, "languages");
        Intrinsics.g(languageList, "languageList");
        Intrinsics.g(nextPage, "nextPage");
        j.d(u0.a(this), w0.b(), null, new SubtitleDownloadViewModel$searchSubtitleList$1(this, downloadBean, gVar, languageList, languages, nextPage, i11, null), 2, null);
    }
}
