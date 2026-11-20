package com.transsion.home.adapter.trending;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.home.adapter.suboperate.provider.SubBannerProvider;
import com.transsion.home.adapter.suboperate.provider.SubCustomProvider;
import com.transsion.home.adapter.suboperate.provider.SubFilterProvider;
import com.transsion.home.adapter.suboperate.provider.SubHorizontalBannerProvider;
import com.transsion.home.adapter.suboperate.provider.c;
import com.transsion.home.adapter.suboperate.provider.z;
import com.transsion.home.adapter.trending.provider.NoNetWorkItemProvider;
import com.transsion.home.adapter.trending.provider.OpHonorProvider;
import com.transsion.home.adapter.trending.provider.OpMovieRankProvider;
import com.transsion.home.adapter.trending.provider.OpNumberRankProvider;
import com.transsion.home.adapter.trending.provider.RoomProvider;
import com.transsion.home.adapter.trending.provider.SportLiveProvider;
import com.transsion.home.adapter.trending.provider.SubjectItemProvider;
import com.transsion.home.adapter.trending.provider.SubjectSingleImgItemProvider;
import com.transsion.home.adapter.trending.provider.c0;
import com.transsion.home.adapter.trending.provider.e;
import com.transsion.home.adapter.trending.provider.f;
import com.transsion.home.adapter.trending.provider.q;
import com.transsion.home.adapter.trending.provider.r;
import com.transsion.home.adapter.trending.provider.x;
import com.transsion.home.fragment.tab.TrendingFragment;
import com.transsion.home.manager.NewcomerGuideManager;
import com.transsion.home.p003enum.HomeTabId;
import com.transsion.home.utils.HomeMMKV;
import com.transsion.home.viewmodel.TrendingViewModel;
import com.transsion.moviedetailapi.bean.BannerBean;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.RankingData;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Trailer;
import h9.i;
import h9.j;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nt.b;

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
public final class TrendingAdapter extends BaseProviderMultiAdapter<OperateItem> implements j {
    public final b I;
    public final boolean J;
    public final int K;
    public Function0<Unit> L;
    public final boolean M;
    public final Lazy N;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f52224a;

        static {
            int[] iArr = new int[PostItemType.values().length];
            try {
                iArr[PostItemType.SUBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PostItemType.RANKING_MOVIE_HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PostItemType.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f52224a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendingAdapter(b bVar, final com.transsion.home.preload.b bVar2, final TrendingFragment fragment, final TrendingViewModel trendingViewModel, final Function1<? super Function1<? super Boolean, Unit>, Unit> onAppointmentCLick, boolean z11, int i11) {
        super(null, 1, null);
        Intrinsics.g(fragment, "fragment");
        Intrinsics.g(onAppointmentCLick, "onAppointmentCLick");
        this.I = bVar;
        this.J = z11;
        this.K = i11;
        this.M = HomeMMKV.f52664a.a().getBoolean("trending_operation_grid_feeds", true);
        this.N = LazyKt__LazyJVMKt.b(new Function0<HashMap<String, BaseItemProvider<OperateItem>>>() { // from class: com.transsion.home.adapter.trending.TrendingAdapter$supportProviders$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final HashMap<String, BaseItemProvider<OperateItem>> invoke() {
                HomeTabId homeTabId = HomeTabId.Trending;
                SubBannerProvider subBannerProvider = new SubBannerProvider(homeTabId.getValue(), fragment);
                fragment.getLifecycle().a(subBannerProvider);
                SubHorizontalBannerProvider subHorizontalBannerProvider = new SubHorizontalBannerProvider(homeTabId.getValue(), fragment);
                fragment.getLifecycle().a(subHorizontalBannerProvider);
                OpMovieRankProvider opMovieRankProvider = new OpMovieRankProvider(1, bVar2, false, this.J);
                return s.j(TuplesKt.a(PostItemType.GRID_SUBJECT.getValue(), new f(this.K)), TuplesKt.a(PostItemType.OP_SUBJECTS_MOVIE.getValue(), opMovieRankProvider), TuplesKt.a(PostItemType.RANKING_MOVIE_HORIZONTAL.getValue(), opMovieRankProvider), TuplesKt.a(PostItemType.BANNER.getValue(), subBannerProvider), TuplesKt.a(PostItemType.OP_RANKING.getValue(), new r(bVar2)), TuplesKt.a(PostItemType.TRENDING_NATIVE_AD.getValue(), new c0()), TuplesKt.a(PostItemType.NO_NETWORK.getValue(), new NoNetWorkItemProvider()), TuplesKt.a(PostItemType.FILTER.getValue(), new SubFilterProvider(Integer.valueOf(homeTabId.getValue()), this.J)), TuplesKt.a(PostItemType.CUSTOM_DATA.getValue(), new SubCustomProvider(homeTabId.getValue(), this.J)), TuplesKt.a(PostItemType.APPOINTMENT_LIST.getValue(), new c(onAppointmentCLick, homeTabId.getValue())), TuplesKt.a(PostItemType.FEEDS_TITLE.getValue(), new z()), TuplesKt.a(PostItemType.SPORT_LIVE.getValue(), new SportLiveProvider(homeTabId.getValue(), this.J)), TuplesKt.a(PostItemType.ROOM.getValue(), new RoomProvider(fragment, trendingViewModel)), TuplesKt.a(PostItemType.SINGLE_IMAGE.getValue(), new x()), TuplesKt.a(PostItemType.HORIZONTAL_BANNER.getValue(), subHorizontalBannerProvider), TuplesKt.a(PostItemType.SINGLE_SUBJECT.getValue(), new SubjectSingleImgItemProvider(this.J)), TuplesKt.a(PostItemType.SUBJECT.getValue(), new SubjectItemProvider(this.J)), TuplesKt.a(PostItemType.GAME_LIST.getValue(), new e()), TuplesKt.a(PostItemType.RANKING_LIST_NUMBER.getValue(), new OpNumberRankProvider(homeTabId.getValue())), TuplesKt.a(PostItemType.PLAY_LIST.getValue(), new q(bVar2)), TuplesKt.a(PostItemType.HONOR.getValue(), new OpHonorProvider(fragment, trendingViewModel)));
            }
        });
        Collection<BaseItemProvider<OperateItem>> collectionValues = Y0().values();
        Intrinsics.f(collectionValues, "supportProviders.values");
        for (BaseItemProvider<OperateItem> provider : collectionValues) {
            Intrinsics.f(provider, "provider");
            K0(provider);
        }
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int S0(List<? extends OperateItem> data, int i11) {
        Trailer trailer;
        Cover cover;
        Intrinsics.g(data, "data");
        OperateItem operateItem = data.get(i11);
        PostItemType.a aVar = PostItemType.Companion;
        String type = operateItem.getType();
        if (type == null) {
            type = "";
        }
        PostItemType postItemTypeA = aVar.a(type);
        int i12 = postItemTypeA == null ? -1 : a.f52224a[postItemTypeA.ordinal()];
        if (i12 == -1) {
            return PostItemType.SUBJECT.ordinal();
        }
        Cover stills = null;
        if (i12 != 1) {
            if (i12 == 2) {
                operateItem.setRankingData(new RankingData(null, true, 1, null));
                return PostItemType.OP_SUBJECTS_MOVIE.ordinal();
            }
            if (i12 != 3) {
                return postItemTypeA.ordinal();
            }
            BannerBean banner = operateItem.getBanner();
            return Intrinsics.b(banner != null ? banner.getStyle() : null, BannerBean.BANNER_STYLE_HORIZONTAL) ? PostItemType.HORIZONTAL_BANNER.ordinal() : PostItemType.BANNER.ordinal();
        }
        if (this.M) {
            return PostItemType.GRID_SUBJECT.ordinal();
        }
        Subject feedsSubject = operateItem.getFeedsSubject();
        Cover cover2 = feedsSubject != null ? feedsSubject.getCover() : null;
        Subject feedsSubject2 = operateItem.getFeedsSubject();
        if (feedsSubject2 == null || (trailer = feedsSubject2.getTrailer()) == null || (cover = trailer.getCover()) == null) {
            Subject feedsSubject3 = operateItem.getFeedsSubject();
            if (feedsSubject3 != null) {
                stills = feedsSubject3.getStills();
            }
        } else {
            stills = cover;
        }
        return (stills == null || (cover2 != null && Intrinsics.b(stills.getSize(), cover2.getSize()) && Intrinsics.b(stills.getHeight(), cover2.getHeight()) && Intrinsics.b(stills.getWidth(), cover2.getWidth()))) ? PostItemType.SINGLE_SUBJECT.ordinal() : PostItemType.SUBJECT.ordinal();
    }

    public final Function0<Unit> X0() {
        return this.L;
    }

    public final HashMap<String, BaseItemProvider<OperateItem>> Y0() {
        return (HashMap) this.N.getValue();
    }

    public final boolean Z0() {
        return this.M;
    }

    @Override // h9.j
    public /* synthetic */ h9.f a(BaseQuickAdapter baseQuickAdapter) {
        return i.a(this, baseQuickAdapter);
    }

    public final void a1(Function0<Unit> function0) {
        this.L = function0;
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter, com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: i0 */
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.onViewAttachedToWindow(holder);
        int bindingAdapterPosition = holder.getBindingAdapterPosition();
        b bVar = this.I;
        if (bVar != null) {
            RecyclerView.m layoutManager = W().getLayoutManager();
            Intrinsics.e(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            bVar.h((LinearLayoutManager) layoutManager, bindingAdapterPosition, true);
        }
        NewcomerGuideManager.f52637h.a().i(holder, bindingAdapterPosition);
    }
}
