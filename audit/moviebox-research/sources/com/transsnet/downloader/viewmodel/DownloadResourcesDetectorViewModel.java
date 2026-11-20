package com.transsnet.downloader.viewmodel;

import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.b0;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.moviedetailapi.bean.DubsInfoData;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.bean.DownloadListBean;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.util.DownloadSDCardUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class DownloadResourcesDetectorViewModel extends t0 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a f61205y = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f61206a = LazyKt__LazyJVMKt.b(new Function0<i00.a>() { // from class: com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel$serviceDownload$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final i00.a invoke() {
            return (i00.a) NetServiceGenerator.f49399d.a().i(i00.a.class);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k0 f61207b = l0.a(w0.b());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0<Integer> f61208c = new c0<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0<Boolean> f61209d = new c0<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c0<b> f61210f = new c0<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0<f00.b> f61211g = new c0<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c0<List<f00.b>> f61212h = new c0<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c0<List<f00.b>> f61213i = new c0<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c0<List<String>> f61214j = new c0<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c0<ResourcesSeasonList> f61215k = new c0<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c0<Integer> f61216l = new c0<>();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c0<Integer> f61217m = new c0<>();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c0<DubsInfoData> f61218n = new c0<>();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c0<String> f61219o = new c0<>();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c0<DubsInfo> f61220p = new c0<>();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final c0<DownloadListBean> f61221q = new c0<>();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final c0<Map<Integer, f00.c>> f61222r = new c0<>();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final c0<Long> f61223s = new c0<>();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final c0<String> f61224t = new c0<>();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final c0<String> f61225u = new c0<>();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c0<String> f61226v = new c0<>();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final c0<Integer> f61227w = new c0<>();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final c0<Subject> f61228x = new c0<>();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final i00.a B() {
        return (i00.a) this.f61206a.getValue();
    }

    public final c0<f00.b> A() {
        return this.f61211g;
    }

    public final c0<String> C() {
        return this.f61225u;
    }

    public final c0<Integer> D() {
        return this.f61227w;
    }

    public final c0<Map<Integer, f00.c>> E() {
        return this.f61222r;
    }

    public final c0<Long> F() {
        return this.f61223s;
    }

    public final c0<String> G() {
        return this.f61226v;
    }

    public final c0<String> H() {
        return this.f61224t;
    }

    public final void I(String type) {
        Intrinsics.g(type, "type");
        this.f61224t.q(type);
    }

    public final void J(f00.c item) {
        Intrinsics.g(item, "item");
        Map<Integer, f00.c> mapF = this.f61222r.f();
        if (mapF == null) {
            mapF = new LinkedHashMap<>();
        }
        if (item.d()) {
            mapF.remove(Integer.valueOf(item.a()));
        } else {
            mapF.put(Integer.valueOf(item.a()), item);
        }
        this.f61222r.q(mapF);
    }

    public final void e(Subject subject) {
        ShortTVFavInfo shortTVFavInfo;
        if (subject == null || (shortTVFavInfo = subject.getShortTVFavInfo()) == null) {
            return;
        }
        j.d(u0.a(this), null, null, new DownloadResourcesDetectorViewModel$favorite$1(subject, shortTVFavInfo.getHasFavorite(), this, shortTVFavInfo, null), 3, null);
    }

    public final c0<String> f() {
        return this.f61219o;
    }

    public final c0<Integer> g() {
        return this.f61216l;
    }

    public final c0<b> h() {
        return this.f61210f;
    }

    public final void i(String str, String str2, int i11, String nextPage, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        Intrinsics.g(nextPage, "nextPage");
        j.d(l0.a(w0.b()), null, null, new DownloadResourcesDetectorViewModel$getDownloadList$1(i18, str, i13, i14, i11, this, nextPage, i12, i15, i16, i17, str2, null), 3, null);
    }

    public final void k(String savedRootPath) {
        Intrinsics.g(savedRootPath, "savedRootPath");
        j.d(this.f61207b, null, null, new DownloadResourcesDetectorViewModel$getDownloadSavePathInfo$1(this, savedRootPath, null), 3, null);
    }

    public final c0<Boolean> l() {
        return this.f61209d;
    }

    public final c0<DubsInfoData> m() {
        return this.f61218n;
    }

    public final c0<DubsInfo> n() {
        return this.f61220p;
    }

    public final c0<Integer> o() {
        return this.f61208c;
    }

    public final void p() {
        boolean z11;
        char c11;
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, "DownloadReDetector", "--- getPathInfo", false, 4, null);
        ArrayList arrayList = new ArrayList();
        List<f00.b> listA = DownloadSDCardUtil.f61130a.a();
        DownloadEsHelper.a aVar2 = DownloadEsHelper.f60994m;
        aVar2.a().e();
        String strD = tr.b.f77264a.d();
        String strO = aVar2.a().o();
        uo.b.a.s(aVar, "DownloadReDetector", "--- savedPath = " + strO, false, 4, null);
        Iterator<f00.b> it = listA.iterator();
        while (true) {
            if (!it.hasNext()) {
                z11 = false;
                break;
            }
            f00.b next = it.next();
            if (Intrinsics.b(next.b(), strO)) {
                next.g(true);
                z11 = true;
                break;
            }
        }
        long jA = b0.a();
        tr.b.a aVar3 = tr.b.f77264a;
        String strA = aVar3.a();
        if (Intrinsics.b(strO, strD) || (listA.isEmpty() && !Intrinsics.b(strO, strA))) {
            c11 = 1;
        } else {
            c11 = z11 ? (char) 2 : (char) 3;
        }
        String string = Utils.a().getString(R$string.str_download_dialog_path_moviebox_folder);
        Intrinsics.f(string, "getApp().getString(R.str…log_path_moviebox_folder)");
        f00.b bVar = new f00.b(strD, "", string, 1, jA, 1);
        bVar.g(c11 == 1);
        String strB = aVar3.b();
        String string2 = Utils.a().getString(R$string.str_download_dialog_path_albums);
        Intrinsics.f(string2, "getApp().getString(R.str…nload_dialog_path_albums)");
        f00.b bVar2 = new f00.b(strA, strB, string2, 3, jA, 2);
        bVar2.g(c11 == 3);
        arrayList.add(bVar);
        arrayList.add(bVar2);
        arrayList.addAll(listA);
        this.f61212h.n(arrayList);
    }

    public final c0<List<f00.b>> q() {
        return this.f61212h;
    }

    public final c0<DownloadListBean> r() {
        return this.f61221q;
    }

    public final void s(String subjectId) {
        Intrinsics.g(subjectId, "subjectId");
        j.d(u0.a(this), null, null, new DownloadResourcesDetectorViewModel$getResourceAllLangInfo$1(this, subjectId, null), 3, null);
    }

    public final void t(String subjectId) {
        Intrinsics.g(subjectId, "subjectId");
        j.d(u0.a(this), null, null, new DownloadResourcesDetectorViewModel$getResourcesSeasonInfo$1(this, subjectId, null), 3, null);
    }

    public final void u() {
        j.d(this.f61207b, null, null, new DownloadResourcesDetectorViewModel$getSDCardPathInfo$1(this, null), 3, null);
    }

    public final void v(String str) {
        uo.b.a.f(uo.b.f78622a, "DownloadReDetector", "--- getDownloadSavePathInfo, savedRootPath = " + str, false, 4, null);
        ArrayList arrayList = new ArrayList();
        long jA = b0.a();
        tr.b.a aVar = tr.b.f77264a;
        aVar.d();
        String strA = aVar.a();
        String strB = aVar.b();
        String string = Utils.a().getString(R$string.str_download_dialog_path_albums);
        Intrinsics.f(string, "getApp().getString(R.str…nload_dialog_path_albums)");
        f00.b bVar = new f00.b(strA, strB, string, 3, jA, 2);
        bVar.g(Intrinsics.b(strA, str));
        List<f00.b> listA = DownloadSDCardUtil.f61130a.a();
        DownloadEsHelper.f60994m.a().e();
        for (f00.b bVar2 : listA) {
            if (Intrinsics.b(bVar2.b(), str)) {
                bVar2.g(true);
                break;
            }
        }
        arrayList.add(bVar);
        arrayList.addAll(listA);
        this.f61213i.n(arrayList);
    }

    public final c0<List<f00.b>> w() {
        return this.f61213i;
    }

    public final c0<ResourcesSeasonList> x() {
        return this.f61215k;
    }

    public final c0<Integer> y() {
        return this.f61217m;
    }

    public final c0<List<String>> z() {
        return this.f61214j;
    }
}
