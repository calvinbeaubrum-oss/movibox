package com.transsion.home.viewmodel;

import android.app.Application;
import android.net.Uri;
import androidx.lifecycle.b;
import androidx.lifecycle.c0;
import androidx.lifecycle.u0;
import com.blankj.utilcode.util.n;
import com.google.gson.Gson;
import com.tencent.mmkv.MMKV;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.baselib.report.o;
import com.transsion.edcation.CourseManager;
import com.transsion.home.bean.SubOperateData;
import com.transsion.home.bean.TrendingRespData;
import com.transsion.home.p003enum.HomeTabId;
import com.transsion.home.utils.HomeMMKV;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.j;
import kotlinx.coroutines.w0;
import rt.d;

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
public final class SubTabViewModel extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f52753h = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f52754i = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0<SubOperateData> f52755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0<SubOperateData> f52756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f52757d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f52758f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f52759g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubTabViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f52755b = new c0<>();
        this.f52756c = new c0<>();
        this.f52757d = LazyKt__LazyJVMKt.b(new Function0<c0<BaseDto<TrendingRespData>>>() { // from class: com.transsion.home.viewmodel.SubTabViewModel$trendListLiveData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c0<BaseDto<TrendingRespData>> invoke() {
                return new c0<>();
            }
        });
        this.f52758f = (d) NetServiceGenerator.f49399d.a().i(d.class);
        this.f52759g = 1;
    }

    public final void g(int i11, boolean z11) {
        j.d(u0.a(this), w0.b(), null, new SubTabViewModel$fetchOperateData$1(z11, this, new Ref.ObjectRef(), i11, null), 2, null);
    }

    public final String h(String str, int i11) {
        return str + "_" + i11;
    }

    public final c0<SubOperateData> i() {
        return this.f52755b;
    }

    public final c0<SubOperateData> j() {
        return this.f52756c;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object k(int i11, Continuation<? super SubOperateData> continuation) throws Throwable {
        SubTabViewModel$getSubOperation$1 subTabViewModel$getSubOperation$1;
        String str;
        SubTabViewModel subTabViewModel;
        List<OperateItem> items;
        SubOperateData subOperateData;
        List<OperateItem> items2;
        SubOperateData subOperateData2;
        String version;
        if (continuation instanceof SubTabViewModel$getSubOperation$1) {
            subTabViewModel$getSubOperation$1 = (SubTabViewModel$getSubOperation$1) continuation;
            int i12 = subTabViewModel$getSubOperation$1.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                subTabViewModel$getSubOperation$1.label = i12 - Integer.MIN_VALUE;
            } else {
                subTabViewModel$getSubOperation$1 = new SubTabViewModel$getSubOperation$1(this, continuation);
            }
        } else {
            subTabViewModel$getSubOperation$1 = new SubTabViewModel$getSubOperation$1(this, continuation);
        }
        SubTabViewModel$getSubOperation$1 subTabViewModel$getSubOperation$2 = subTabViewModel$getSubOperation$1;
        Object obj = subTabViewModel$getSubOperation$2.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i13 = subTabViewModel$getSubOperation$2.label;
        if (i13 == 0) {
            ResultKt.b(obj);
            String string = HomeMMKV.f52664a.a().getString(h("sub_operation_version_prefix", i11), "");
            d dVar = this.f52758f;
            subTabViewModel$getSubOperation$2.L$0 = this;
            subTabViewModel$getSubOperation$2.L$1 = string;
            subTabViewModel$getSubOperation$2.I$0 = i11;
            subTabViewModel$getSubOperation$2.label = 1;
            Object objD = d.a.d(dVar, null, i11, string, subTabViewModel$getSubOperation$2, 1, null);
            if (objD == objE) {
                return objE;
            }
            str = string;
            obj = objD;
            subTabViewModel = this;
        } else {
            if (i13 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i11 = subTabViewModel$getSubOperation$2.I$0;
            str = (String) subTabViewModel$getSubOperation$2.L$1;
            subTabViewModel = (SubTabViewModel) subTabViewModel$getSubOperation$2.L$0;
            ResultKt.b(obj);
        }
        BaseDto baseDto = (BaseDto) obj;
        if (str == null || str.length() == 0 || (subOperateData = (SubOperateData) baseDto.getData()) == null || (items2 = subOperateData.getItems()) == null || !items2.isEmpty() || (subOperateData2 = (SubOperateData) baseDto.getData()) == null || (version = subOperateData2.getVersion()) == null || version.length() <= 0) {
            SubOperateData subOperateData3 = (SubOperateData) baseDto.getData();
            if (subOperateData3 != null && (items = subOperateData3.getItems()) != null && (!items.isEmpty())) {
                String json = new Gson().toJson(baseDto.getData());
                HomeMMKV homeMMKV = HomeMMKV.f52664a;
                homeMMKV.a().putString(subTabViewModel.h("sub_operation_prefix", i11), json);
                MMKV mmkvA = homeMMKV.a();
                String strH = subTabViewModel.h("sub_operation_version_prefix", i11);
                SubOperateData subOperateData4 = (SubOperateData) baseDto.getData();
                mmkvA.putString(strH, subOperateData4 != null ? subOperateData4.getVersion() : null);
            }
        } else {
            baseDto.setData(n.d(HomeMMKV.f52664a.a().getString(subTabViewModel.h("sub_operation_prefix", i11), ""), SubOperateData.class));
        }
        return baseDto.getData();
    }

    public final c0<BaseDto<TrendingRespData>> l() {
        return (c0) this.f52757d.getValue();
    }

    public final void m(int i11, boolean z11, List<String> optPlaylistIds) {
        String string;
        Intrinsics.g(optPlaylistIds, "optPlaylistIds");
        if (z11) {
            this.f52759g = 1;
        }
        TrendingRequestEntity trendingRequestEntity = new TrendingRequestEntity();
        int i12 = this.f52759g;
        this.f52759g = i12 + 1;
        trendingRequestEntity.setPage(String.valueOf(i12));
        trendingRequestEntity.setPerPage(12);
        trendingRequestEntity.setSessionId(fp.b.f65208a.h());
        Uri uriA = o.f51281a.a();
        if (uriA == null || (string = uriA.toString()) == null) {
            string = "";
        }
        trendingRequestEntity.setDeepLink(string);
        trendingRequestEntity.setLatest_events(new ds.a(ds.b.f63534a.e()));
        trendingRequestEntity.setOptPlaylistIds(optPlaylistIds);
        j.d(u0.a(this), w0.b(), null, new SubTabViewModel$getTrendingList$1(trendingRequestEntity, i11, this, null), 2, null);
    }

    public final void n(int i11, SubOperateData subOperateData) {
        List<OperateItem> items;
        List<OperateItem> items2;
        if (i11 == HomeTabId.Education.getValue()) {
            CourseManager.n(CourseManager.f51853a, null, null, 3, null);
            if (subOperateData != null && (items2 = subOperateData.getItems()) != null) {
                items2.add(1, new OperateItem(null, PostItemType.MY_COURSE.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097149, null));
            }
        }
        String trendingTitle = subOperateData != null ? subOperateData.getTrendingTitle() : null;
        if (trendingTitle == null || trendingTitle.length() == 0 || subOperateData == null || (items = subOperateData.getItems()) == null) {
            return;
        }
        items.add(new OperateItem(subOperateData.getTrendingTitle(), PostItemType.FEEDS_TITLE.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097148, null));
    }
}
