package com.transsion.home.viewmodel;

import android.app.Application;
import android.net.Uri;
import android.os.Bundle;
import androidx.lifecycle.c0;
import androidx.lifecycle.u0;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.n;
import com.google.gson.JsonObject;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baselib.report.o;
import com.transsion.home.bean.HonorInfoBean;
import com.transsion.home.bean.HotItemsBean;
import com.transsion.home.bean.RoomEntranceResponse;
import com.transsion.home.bean.TrendingRespData;
import com.transsion.home.p003enum.HomeTabId;
import com.transsion.home.p003enum.HomeTabType;
import com.transsion.home.utils.DBOperatePlugin;
import com.transsion.home.utils.HomeMMKV;
import com.transsion.moviedetailapi.AbsSubjectListViewModel;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.p005enum.PostListSource;
import com.transsion.quickjs.QuickJSHelper;
import com.transsion.web.api.WebConstants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jt.a;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.w0;
import okhttp3.RequestBody;
import rt.d;
import uo.b;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class TrendingViewModel extends AbsSubjectListViewModel {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f52760v = new a(null);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f52761w = 8;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f52762l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f52763m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f52764n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f52765o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f52766p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f52767q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f52768r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List<Subject> f52769s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f52770t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final d f52771u;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class b implements com.transsion.quickjs.a {
        public b() {
        }

        @Override // com.transsion.quickjs.a
        public void a(String str, int i11) {
            TrendingViewModel.this.M().n(null);
        }

        @Override // com.transsion.quickjs.a
        public void onSuccess(Object obj) {
            try {
                Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.String");
                TrendingViewModel.this.M().n((HonorInfoBean) n.d((String) obj, HonorInfoBean.class));
            } catch (Exception unused) {
                TrendingViewModel.this.M().n(null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendingViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f52762l = LazyKt__LazyJVMKt.b(new Function0<c0<HonorInfoBean>>() { // from class: com.transsion.home.viewmodel.TrendingViewModel$honorViewLiveData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c0<HonorInfoBean> invoke() {
                return new c0<>();
            }
        });
        this.f52763m = LazyKt__LazyJVMKt.b(new Function0<c0<List<? extends jt.a>>>() { // from class: com.transsion.home.viewmodel.TrendingViewModel$playHistoryLiveData$2
            @Override // kotlin.jvm.functions.Function0
            public final c0<List<? extends a>> invoke() {
                return new c0<>();
            }
        });
        this.f52764n = LazyKt__LazyJVMKt.b(new Function0<c0<BaseDto<TrendingRespData>>>() { // from class: com.transsion.home.viewmodel.TrendingViewModel$trendListLiveData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c0<BaseDto<TrendingRespData>> invoke() {
                return new c0<>();
            }
        });
        this.f52765o = LazyKt__LazyJVMKt.b(new Function0<c0<String>>() { // from class: com.transsion.home.viewmodel.TrendingViewModel$bgColorLiveData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c0<String> invoke() {
                return new c0<>();
            }
        });
        this.f52766p = LazyKt__LazyJVMKt.b(new Function0<c0<Boolean>>() { // from class: com.transsion.home.viewmodel.TrendingViewModel$memberShipLiveData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c0<Boolean> invoke() {
                return new c0<>();
            }
        });
        this.f52767q = LazyKt__LazyJVMKt.b(new Function0<c0<RoomEntranceResponse>>() { // from class: com.transsion.home.viewmodel.TrendingViewModel$roomLivedata$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c0<RoomEntranceResponse> invoke() {
                return new c0<>();
            }
        });
        this.f52768r = LazyKt__LazyJVMKt.b(new Function0<VideoDetailPlayDao>() { // from class: com.transsion.home.viewmodel.TrendingViewModel$videoDetailPlayDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VideoDetailPlayDao invoke() {
                AppDatabase.v0 v0Var = AppDatabase.f51036p;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                return v0Var.b(applicationA).O0();
            }
        });
        this.f52769s = new ArrayList();
        this.f52770t = 12;
        this.f52771u = (d) NetServiceGenerator.f49399d.a().i(d.class);
    }

    public final void H(boolean z11) {
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.transsion.home.viewmodel.TrendingViewModel$fetchGroupInfo$useCache$1
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
                String string = HomeMMKV.f52664a.a().getString("trending_room_entrance_cache_v2", "");
                if (string == null || string.length() == 0) {
                    b.f78622a.c("TrendingViewModel", "fetchGroupInfo failed without cache", true);
                    return;
                }
                this.this$0.Q().n((RoomEntranceResponse) n.d(string, RoomEntranceResponse.class));
                b.f78622a.c("TrendingViewModel", "fetchGroupInfo use cache", true);
            }
        };
        if (z11) {
            function0.invoke();
        } else {
            j.d(u0.a(this), w0.b(), null, new TrendingViewModel$fetchGroupInfo$1(this, function0, null), 2, null);
        }
    }

    public final void I() {
        j.d(u0.a(this), null, null, new TrendingViewModel$fetchHistoryList$1(this, null), 3, null);
    }

    public final void J() {
        QuickJSHelper.ExecuteBuilder executeBuilderM = new QuickJSHelper.ExecuteBuilder().l("watch_info").m("displayRank");
        String string = RoomAppMMKV.f51271a.a().getString("k_language_short_name", null);
        if (string == null) {
            string = "";
        }
        executeBuilderM.i(string).h(new DBOperatePlugin()).j(new b()).n();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object K(int i11, Continuation<? super List<? extends Subject>> continuation) throws Throwable {
        TrendingViewModel$fetchHotList$1 trendingViewModel$fetchHotList$1;
        List<Subject> items;
        if (continuation instanceof TrendingViewModel$fetchHotList$1) {
            trendingViewModel$fetchHotList$1 = (TrendingViewModel$fetchHotList$1) continuation;
            int i12 = trendingViewModel$fetchHotList$1.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                trendingViewModel$fetchHotList$1.label = i12 - Integer.MIN_VALUE;
            } else {
                trendingViewModel$fetchHotList$1 = new TrendingViewModel$fetchHotList$1(this, continuation);
            }
        } else {
            trendingViewModel$fetchHotList$1 = new TrendingViewModel$fetchHotList$1(this, continuation);
        }
        Object objE = trendingViewModel$fetchHotList$1.result;
        Object objE2 = kotlin.coroutines.intrinsics.a.e();
        int i13 = trendingViewModel$fetchHotList$1.label;
        try {
            if (i13 == 0) {
                ResultKt.b(objE);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("perPage", Boxing.d(i11));
                ip.b.a aVar = ip.b.f67591a;
                String string = jsonObject.toString();
                Intrinsics.f(string, "json.toString()");
                RequestBody requestBodyA = aVar.a(string);
                if (requestBodyA != null) {
                    d dVar = this.f52771u;
                    String strA = cp.a.f62775a.a();
                    trendingViewModel$fetchHotList$1.label = 1;
                    objE = dVar.e(strA, requestBodyA, trendingViewModel$fetchHotList$1);
                    if (objE == objE2) {
                        return objE2;
                    }
                }
                return new ArrayList();
            }
            if (i13 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(objE);
            HotItemsBean hotItemsBean = (HotItemsBean) ((BaseDto) objE).getData();
            return (hotItemsBean == null || (items = hotItemsBean.getItems()) == null) ? new ArrayList() : items;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new ArrayList();
    }

    public final c0<String> L() {
        return (c0) this.f52765o.getValue();
    }

    public final c0<HonorInfoBean> M() {
        return (c0) this.f52762l.getValue();
    }

    public final c0<Boolean> N() {
        return (c0) this.f52766p.getValue();
    }

    public final long O() {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(2);
        calendar.add(7, 2 - calendar.get(7));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public final c0<List<jt.a>> P() {
        return (c0) this.f52763m.getValue();
    }

    public final c0<RoomEntranceResponse> Q() {
        return (c0) this.f52767q.getValue();
    }

    public final c0<BaseDto<TrendingRespData>> R() {
        return (c0) this.f52764n.getValue();
    }

    public final void S(String nextPage, int i11, List<String> optPlaylistIds, boolean z11) {
        String string;
        Intrinsics.g(nextPage, "nextPage");
        Intrinsics.g(optPlaylistIds, "optPlaylistIds");
        TrendingRequestEntity trendingRequestEntity = new TrendingRequestEntity();
        trendingRequestEntity.setPage(nextPage);
        trendingRequestEntity.setPerPage(i11);
        trendingRequestEntity.setSessionId(fp.b.f65208a.h());
        Uri uriA = o.f51281a.a();
        if (uriA == null || (string = uriA.toString()) == null) {
            string = "";
        }
        trendingRequestEntity.setDeepLink(string);
        trendingRequestEntity.setLatest_events(new ds.a(ds.b.f63534a.e()));
        trendingRequestEntity.setOptPlaylistIds(optPlaylistIds);
        trendingRequestEntity.setTabId(HomeTabId.Trending.getValue());
        trendingRequestEntity.setDisablePlaylist(Boolean.valueOf(z11));
        j.d(u0.a(this), w0.b(), null, new TrendingViewModel$getTrendingList$1(trendingRequestEntity, this, nextPage, null), 2, null);
    }

    public final VideoDetailPlayDao T() {
        return (VideoDetailPlayDao) this.f52768r.getValue();
    }

    public final void U(Subject subject, int i11, String moduleName) {
        Intrinsics.g(subject, "subject");
        Intrinsics.g(moduleName, "moduleName");
        HashMap map = new HashMap();
        map.put("module_name", moduleName);
        String subjectId = subject.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        map.put("subject_id", subjectId);
        map.put("has_resource", String.valueOf(subject.getHasResource()));
        map.put("item_type", "rec");
        String title = subject.getTitle();
        if (title == null) {
            title = "";
        }
        map.put(CampaignEx.JSON_KEY_TITLE, title);
        String ops = subject.getOps();
        if (ops == null) {
            ops = "";
        }
        map.put("ops", ops);
        map.put(WebConstants.PAGE_FROM, m());
        map.put("sequence", String.valueOf(i11));
        Map<String, String> mapL = l(k().ordinal());
        if (mapL != null) {
            for (Map.Entry<String, String> entry : mapL.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                map.put(key, value);
            }
        }
        com.transsion.baselib.helper.a.f51183a.f(n(k().ordinal()), map);
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public String n(int i11) {
        return HomeTabType.TAB_CODE_TRENDING;
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public PostListSource r() {
        return PostListSource.POSTLIST;
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public void u(boolean z11) {
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public void v(Bundle bundle) {
    }
}
