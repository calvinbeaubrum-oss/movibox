package com.transsion.home.adapter.suboperate;

import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.home.adapter.suboperate.provider.SubBannerProvider;
import com.transsion.home.adapter.suboperate.provider.SubCustomProvider;
import com.transsion.home.adapter.suboperate.provider.SubFeedsEducationProvider;
import com.transsion.home.adapter.suboperate.provider.SubFeedsSingleImageProvider;
import com.transsion.home.adapter.suboperate.provider.SubFilterProvider;
import com.transsion.home.adapter.suboperate.provider.SubHorizontalBannerProvider;
import com.transsion.home.adapter.suboperate.provider.SubMusicRankProvider;
import com.transsion.home.adapter.suboperate.provider.SubMyCourseProvider;
import com.transsion.home.adapter.suboperate.provider.SubRankListProvider;
import com.transsion.home.adapter.suboperate.provider.SubRankingProvider;
import com.transsion.home.adapter.suboperate.provider.c;
import com.transsion.home.adapter.suboperate.provider.v;
import com.transsion.home.adapter.suboperate.provider.z;
import com.transsion.home.adapter.trending.provider.OpMovieRankProvider;
import com.transsion.home.adapter.trending.provider.OpNumberRankProvider;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.p003enum.HomeTabId;
import com.transsion.home.preload.b;
import com.transsion.moviedetailapi.bean.AppointSubject;
import com.transsion.moviedetailapi.bean.BannerBean;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.RankingData;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Trailer;
import h9.f;
import h9.i;
import h9.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.q1;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class SubTabAdapter extends BaseProviderMultiAdapter<OperateItem> implements j {
    public final int I;
    public final Function1<Integer, Unit> J;
    public final boolean K;
    public final List<String> L;
    public q1 M;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f52006a;

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
            f52006a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SubTabAdapter(List<OperateItem> typeList, Function1<? super Function1<? super Boolean, Unit>, Unit> onAppointmentCLick, SubTabFragment fragment, int i11, b bVar, Function1<? super Integer, Unit> onPositionScroll, boolean z11) {
        super(CollectionsKt___CollectionsKt.M0(typeList));
        Intrinsics.g(typeList, "typeList");
        Intrinsics.g(onAppointmentCLick, "onAppointmentCLick");
        Intrinsics.g(fragment, "fragment");
        Intrinsics.g(onPositionScroll, "onPositionScroll");
        this.I = i11;
        this.J = onPositionScroll;
        this.K = z11;
        this.L = new ArrayList();
        Function2<String, BaseItemProvider<OperateItem>, Unit> function2 = new Function2<String, BaseItemProvider<OperateItem>, Unit>() { // from class: com.transsion.home.adapter.suboperate.SubTabAdapter$addProvider$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, BaseItemProvider<OperateItem> baseItemProvider) {
                invoke2(str, baseItemProvider);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String key, BaseItemProvider<OperateItem> provider) {
                Intrinsics.g(key, "key");
                Intrinsics.g(provider, "provider");
                this.this$0.L.add(key);
                this.this$0.K0(provider);
            }
        };
        SubBannerProvider subBannerProvider = new SubBannerProvider(i11, fragment);
        fragment.getLifecycle().a(subBannerProvider);
        SubHorizontalBannerProvider subHorizontalBannerProvider = new SubHorizontalBannerProvider(i11, fragment);
        fragment.getLifecycle().a(subHorizontalBannerProvider);
        SubMyCourseProvider subMyCourseProvider = new SubMyCourseProvider(i11);
        fragment.getLifecycle().a(subMyCourseProvider);
        OpMovieRankProvider opMovieRankProvider = new OpMovieRankProvider(i11, bVar, true, z11);
        function2.invoke(PostItemType.HORIZONTAL_BANNER.getValue(), subHorizontalBannerProvider);
        function2.invoke(PostItemType.BANNER.getValue(), subBannerProvider);
        function2.invoke(PostItemType.FILTER.getValue(), new SubFilterProvider(Integer.valueOf(i11), z11));
        function2.invoke(PostItemType.APPOINTMENT_LIST.getValue(), new c(onAppointmentCLick, i11));
        function2.invoke(PostItemType.CUSTOM_DATA.getValue(), new SubCustomProvider(i11, z11));
        function2.invoke(PostItemType.PLAY_LIST.getValue(), new v(i11, fragment));
        function2.invoke(PostItemType.SUBJECT.getValue(), new com.transsion.home.adapter.suboperate.provider.j(i11, z11));
        function2.invoke(PostItemType.SINGLE_SUBJECT.getValue(), new SubFeedsSingleImageProvider(i11, z11));
        function2.invoke(PostItemType.EDUCATION_SUBJECT.getValue(), new SubFeedsEducationProvider(i11));
        function2.invoke(PostItemType.TRENDING_NATIVE_AD.getValue(), new com.transsion.home.adapter.suboperate.provider.a());
        function2.invoke(PostItemType.OP_SUBJECTS_MOVIE.getValue(), opMovieRankProvider);
        function2.invoke(PostItemType.RANKING_MOVIE_HORIZONTAL.getValue(), opMovieRankProvider);
        function2.invoke(PostItemType.MY_COURSE.getValue(), subMyCourseProvider);
        function2.invoke(PostItemType.FEEDS_TITLE.getValue(), new z());
        function2.invoke(PostItemType.OP_RANKING.getValue(), new SubRankingProvider(i11));
        function2.invoke(PostItemType.RANKING_LIST.getValue(), new SubRankListProvider(i11));
        function2.invoke(PostItemType.RANKING_LIST_NUMBER.getValue(), new OpNumberRankProvider(i11));
        function2.invoke(PostItemType.RANKING_LIST_MUSIC.getValue(), new SubMusicRankProvider(i11, z11));
    }

    private final void W0() {
        if (this.I != HomeTabId.Education.getValue()) {
            return;
        }
        this.M = kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new SubTabAdapter$registerCourse$1(this, null), 3, null);
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
        int i12 = postItemTypeA == null ? -1 : a.f52006a[postItemTypeA.ordinal()];
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
        if (this.I == HomeTabId.Education.getValue()) {
            return PostItemType.EDUCATION_SUBJECT.ordinal();
        }
        return (stills == null || (cover2 != null && Intrinsics.b(stills.getSize(), cover2.getSize()) && Intrinsics.b(stills.getHeight(), cover2.getHeight()) && Intrinsics.b(stills.getWidth(), cover2.getWidth()))) ? PostItemType.SINGLE_SUBJECT.ordinal() : PostItemType.SUBJECT.ordinal();
    }

    @Override // h9.j
    public /* synthetic */ f a(BaseQuickAdapter baseQuickAdapter) {
        return i.a(this, baseQuickAdapter);
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter, com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: i0 */
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.onViewAttachedToWindow(holder);
        this.J.invoke(Integer.valueOf(holder.getBindingAdapterPosition()));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics.g(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        q1 q1Var = this.M;
        if (q1Var != null) {
            q1.a.b(q1Var, null, 1, null);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void w0(Collection<OperateItem> collection) {
        List<AppointSubject> subjects;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(collection == null ? new ArrayList<>() : collection);
        if (collection != null) {
            for (OperateItem operateItem : collection) {
                if (!CollectionsKt___CollectionsKt.X(this.L, operateItem.getType())) {
                    arrayList.remove(operateItem);
                    uo.b.a.f(uo.b.f78622a, "SubTabViewModel", "remove unSupport operate " + operateItem.getType(), false, 4, null);
                }
                if (Intrinsics.b(operateItem.getType(), PostItemType.PLAY_LIST.getValue()) && operateItem.getPlayListData() != null && ((subjects = operateItem.getSubjects()) == null || subjects.size() < 3)) {
                    arrayList.remove(operateItem);
                    uo.b.a.f(uo.b.f78622a, "SubTabViewModel", "remove unSupport playList " + operateItem.getType(), false, 4, null);
                }
            }
        }
        W0();
        super.w0(arrayList);
    }
}
