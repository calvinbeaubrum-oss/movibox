package com.transsion.home.adapter.trending.provider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLConstraintLayout;
import com.tn.lib.widget.TnTextView;
import com.transsion.baselib.exposure.ExposureType;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.bean.RoomEntranceResponse;
import com.transsion.home.fragment.tab.BaseHomeSubFragment;
import com.transsion.home.p003enum.HomeTabType;
import com.transsion.home.viewmodel.TrendingViewModel;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.FirstFrame;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.web.api.WebConstants;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class RoomProvider extends BaseItemProvider<OperateItem> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f52242p = new a(null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f52243q = 8;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f52244r = "TrendingRoom";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f52245s = HomeTabType.TAB_CODE_TRENDING;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f52246t = "room_home_recommend";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BaseHomeSubFragment<?> f52247f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TrendingViewModel f52248g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f52249h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public zr.b f52250i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public zr.b f52251j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f52252k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final e f52253l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d f52254m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f52255n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f52256o;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class PostAdapter extends BaseProviderMultiAdapter<PostSubjectItem> {

        /* JADX INFO: compiled from: source.java */
        @Metadata
        @SourceDebugExtension
        public static final class PostItemProvider extends BaseItemProvider<PostSubjectItem> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final String f52257f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final rw.f f52258g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final int f52259h;

            /* JADX INFO: compiled from: source.java */
            @Metadata
            public static final class PostItemVH extends BaseViewHolder {

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final lt.x f52260b;

                /* JADX WARN: Illegal instructions before constructor call */
                public PostItemVH(lt.x viewBinding) {
                    Intrinsics.g(viewBinding, "viewBinding");
                    BLConstraintLayout root = viewBinding.getRoot();
                    Intrinsics.f(root, "viewBinding.root");
                    super(root);
                    this.f52260b = viewBinding;
                }

                public final lt.x e() {
                    return this.f52260b;
                }
            }

            public PostItemProvider(String str, rw.f trendingRoomsViewModel) {
                Intrinsics.g(trendingRoomsViewModel, "trendingRoomsViewModel");
                this.f52257f = str;
                this.f52258g = trendingRoomsViewModel;
                this.f52259h = gs.a.a(112);
            }

            public static final void w(PostItemProvider this$0, PostSubjectItem item, PostItemVH holder, View view) {
                Intrinsics.g(this$0, "this$0");
                Intrinsics.g(item, "$item");
                Intrinsics.g(holder, "$holder");
                this$0.y(item, holder.getAdapterPosition());
            }

            @Override // com.chad.library.adapter.base.provider.BaseItemProvider
            public int h() {
                return 1;
            }

            @Override // com.chad.library.adapter.base.provider.BaseItemProvider
            public int i() {
                return R$layout.item_adapter_room_entrance_post;
            }

            @Override // com.chad.library.adapter.base.provider.BaseItemProvider
            /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
            public void a(BaseViewHolder helper, final PostSubjectItem item) {
                String title;
                Pair pair;
                FirstFrame firstFrame;
                String thumbnail;
                Cover cover;
                Cover cover2;
                String url;
                CharSequence charSequence;
                List<Image> image;
                Image image2;
                List<Image> image3;
                Image image4;
                Intrinsics.g(helper, "helper");
                Intrinsics.g(item, "item");
                final PostItemVH postItemVH = (PostItemVH) helper;
                postItemVH.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.u
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RoomProvider.PostAdapter.PostItemProvider.w(this.f52320a, item, postItemVH, view);
                    }
                });
                String content = item.getContent();
                if (content == null || content.length() == 0) {
                    title = item.getTitle();
                    if (title == null) {
                        title = "";
                    }
                } else {
                    title = item.getContent();
                }
                TnTextView tnTextView = postItemVH.e().f70532d;
                Intrinsics.f(tnTextView, "holder.viewBinding.tvTitle");
                tnTextView.setVisibility(title != null && title.length() > 0 ? 0 : 8);
                postItemVH.e().f70532d.setText(title);
                AppCompatImageView appCompatImageView = postItemVH.e().f70531c;
                Intrinsics.f(appCompatImageView, "holder.viewBinding.ivVideoPlay");
                Media media = item.getMedia();
                Pair pair2 = null;
                thumbnail = null;
                thumbnail = null;
                String thumbnail2 = null;
                url = null;
                String url2 = null;
                String mediaType = media != null ? media.getMediaType() : null;
                MediaType mediaType2 = MediaType.VIDEO;
                appCompatImageView.setVisibility(Intrinsics.b(mediaType, mediaType2.getValue()) ? 0 : 8);
                Media media2 = item.getMedia();
                String mediaType3 = media2 != null ? media2.getMediaType() : null;
                if (!Intrinsics.b(mediaType3, MediaType.IMAGE.getValue())) {
                    if (Intrinsics.b(mediaType3, mediaType2.getValue())) {
                        Media media3 = item.getMedia();
                        if (media3 == null || (cover2 = media3.getCover()) == null || (url = cover2.getUrl()) == null) {
                            Media media4 = item.getMedia();
                            if (media4 != null && (firstFrame = media4.getFirstFrame()) != null) {
                                url2 = firstFrame.getUrl();
                            }
                        } else {
                            url2 = url;
                        }
                        Media media5 = item.getMedia();
                        if (media5 == null || (cover = media5.getCover()) == null || (thumbnail = cover.getThumbnail()) == null) {
                            thumbnail = "";
                        }
                        pair = new Pair(url2, thumbnail);
                    }
                    if (pair2 != null || (charSequence = (CharSequence) pair2.getFirst()) == null || charSequence.length() == 0) {
                        ShapeableImageView shapeableImageView = postItemVH.e().f70530b;
                        Intrinsics.f(shapeableImageView, "holder.viewBinding.ivCover");
                        so.c.g(shapeableImageView);
                    }
                    ShapeableImageView shapeableImageView2 = postItemVH.e().f70530b;
                    Intrinsics.f(shapeableImageView2, "holder.viewBinding.ivCover");
                    so.c.k(shapeableImageView2);
                    ImageHelper.Companion companion = ImageHelper.f51371a;
                    Context contextG = g();
                    ShapeableImageView shapeableImageView3 = postItemVH.e().f70530b;
                    Intrinsics.f(shapeableImageView3, "holder.viewBinding.ivCover");
                    Object first = pair2.getFirst();
                    Intrinsics.d(first);
                    String str = (String) first;
                    int i11 = this.f52259h;
                    String str2 = (String) pair2.getSecond();
                    companion.q(contextG, shapeableImageView3, str, (8120 & 8) != 0 ? companion.d() : i11, (8120 & 16) != 0 ? companion.c() : i11, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : str2 == null ? "" : str2, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
                    return;
                }
                Media media6 = item.getMedia();
                String url3 = (media6 == null || (image3 = media6.getImage()) == null || (image4 = (Image) CollectionsKt___CollectionsKt.g0(image3)) == null) ? null : image4.getUrl();
                Media media7 = item.getMedia();
                if (media7 != null && (image = media7.getImage()) != null && (image2 = (Image) CollectionsKt___CollectionsKt.g0(image)) != null) {
                    thumbnail2 = image2.getThumbnail();
                }
                pair = new Pair(url3, thumbnail2);
                pair2 = pair;
                if (pair2 != null) {
                }
                ShapeableImageView shapeableImageView4 = postItemVH.e().f70530b;
                Intrinsics.f(shapeableImageView4, "holder.viewBinding.ivCover");
                so.c.g(shapeableImageView4);
            }

            @Override // com.chad.library.adapter.base.provider.BaseItemProvider
            /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
            public PostItemVH n(ViewGroup parent, int i11) {
                Intrinsics.g(parent, "parent");
                lt.x xVarC = lt.x.c(LayoutInflater.from(g()), parent, false);
                Intrinsics.f(xVarC, "inflate(LayoutInflater.f…(context), parent, false)");
                return new PostItemVH(xVarC);
            }

            public final void y(PostSubjectItem postSubjectItem, int i11) {
                String postId = postSubjectItem.getPostId();
                if (postId == null) {
                    return;
                }
                com.transsion.postdetail.helper.a.f55063a.w(this.f52257f, RoomProvider.f52245s, "", i11, WebConstants.FIELD_ITEM, postSubjectItem, (64 & 64) != 0 ? null : null);
                this.f52258g.b().q(new Pair<>(postId, postSubjectItem.getOps()));
                rw.e.f75743a.a(postId, postSubjectItem.getOps());
            }
        }

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a extends BaseItemProvider<PostSubjectItem> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final String f52261f;

            public a(String str) {
                this.f52261f = str;
            }

            public static final void w(a this$0, BaseViewHolder helper, PostSubjectItem item, View view) {
                Intrinsics.g(this$0, "this$0");
                Intrinsics.g(helper, "$helper");
                Intrinsics.g(item, "$item");
                com.transsion.postdetail.helper.a.f55063a.w(this$0.f52261f, RoomProvider.f52245s, "", helper.getBindingAdapterPosition(), WebConstants.FIELD_ITEM, item, (64 & 64) != 0 ? null : null);
                com.transsion.baselib.report.m.f51277a.t(RoomProvider.f52245s, "click", kotlin.collections.s.l(TuplesKt.a(WebConstants.PAGE_FROM, this$0.f52261f), TuplesKt.a("module_name", "item_post_more")));
                rw.e.b(rw.e.f75743a, null, null, 3, null);
            }

            @Override // com.chad.library.adapter.base.provider.BaseItemProvider
            public int h() {
                return 2;
            }

            @Override // com.chad.library.adapter.base.provider.BaseItemProvider
            public int i() {
                return R$layout.item_adapter_room_entrance_post_more;
            }

            @Override // com.chad.library.adapter.base.provider.BaseItemProvider
            /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
            public void a(final BaseViewHolder helper, final PostSubjectItem item) {
                Intrinsics.g(helper, "helper");
                Intrinsics.g(item, "item");
                helper.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.t
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RoomProvider.PostAdapter.a.w(this.f52317a, helper, item, view);
                    }
                });
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostAdapter(String str, rw.f trendingRoomsViewModel) {
            super(null, 1, null);
            Intrinsics.g(trendingRoomsViewModel, "trendingRoomsViewModel");
            K0(new PostItemProvider(str, trendingRoomsViewModel));
            K0(new a(str));
        }

        @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
        public int S0(List<? extends PostSubjectItem> data, int i11) {
            Intrinsics.g(data, "data");
            return data.get(i11).isMore() ? 2 : 1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class RoomAdapter extends BaseQuickAdapter<RoomItem, RoomItemVH> {
        public final int H;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class RoomItemVH extends BaseViewHolder {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final lt.w f52262b;

            /* JADX WARN: Illegal instructions before constructor call */
            public RoomItemVH(lt.w viewBinding) {
                Intrinsics.g(viewBinding, "viewBinding");
                ConstraintLayout root = viewBinding.getRoot();
                Intrinsics.f(root, "viewBinding.root");
                super(root);
                this.f52262b = viewBinding;
            }

            public final lt.w e() {
                return this.f52262b;
            }
        }

        public RoomAdapter() {
            super(R$layout.item_adapter_room_entrance_group, null, 2, null);
            this.H = gs.a.a(52);
        }

        public static final void I0(RoomAdapter this$0, RoomItem item, View view) {
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(item, "$item");
            this$0.K0(item);
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
        public void x(RoomItemVH holder, final RoomItem item) {
            String strA;
            Intrinsics.g(holder, "holder");
            Intrinsics.g(item, "item");
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomProvider.RoomAdapter.I0(this.f52323a, item, view);
                }
            });
            holder.e().f70527f.setText(item.getName());
            if (item.getUserCount() != null) {
                Long userCount = item.getUserCount();
                Intrinsics.d(userCount);
                strA = com.transsion.baselib.utils.i.a(userCount.longValue());
            } else {
                strA = "0";
            }
            holder.e().f70526d.setText(strA);
            String avatar = item.getAvatar();
            if (avatar != null) {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = getContext();
                ShapeableImageView shapeableImageView = holder.e().f70525c;
                Intrinsics.f(shapeableImageView, "holder.viewBinding.ivCover");
                int i11 = this.H;
                companion.r(context, shapeableImageView, avatar, (4088 & 8) != 0 ? companion.d() : i11, (4088 & 16) != 0 ? companion.c() : i11, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
            }
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
        public RoomItemVH f0(ViewGroup parent, int i11) {
            Intrinsics.g(parent, "parent");
            lt.w wVarC = lt.w.c(LayoutInflater.from(getContext()), parent, false);
            Intrinsics.f(wVarC, "inflate(LayoutInflater.f…(context), parent, false)");
            return new RoomItemVH(wVarC);
        }

        public final void K0(RoomItem roomItem) {
            roomItem.setNewPostCount(0L);
            com.transsion.room.helper.k.f57301a.f(RoomProvider.f52245s, RoomProvider.f52246t, roomItem);
            com.alibaba.android.arouter.launcher.a.d().b("/room/detail").withString("id", roomItem.getGroupId()).withBoolean("need_start_room_home", false).navigation();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements zr.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomAdapter f52263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RoomProvider f52264b;

        public b(RoomAdapter roomAdapter, RoomProvider roomProvider) {
            this.f52263a = roomAdapter;
            this.f52264b = roomProvider;
        }

        @Override // zr.a
        public void a(int i11, long j11, View view) {
            RoomAdapter roomAdapter = this.f52263a;
            RoomProvider roomProvider = this.f52264b;
            try {
                Result.Companion companion = Result.Companion;
                uo.b.a.o(uo.b.f78622a, RoomProvider.f52244r, new String[]{"1----------room report, position:" + i11 + ", duration:" + j11}, false, 4, null);
                com.transsion.room.helper.k.f57301a.g(roomProvider.f52252k, RoomProvider.f52245s, i11, j11, roomAdapter.getItem(i11));
                Result.m163constructorimpl(Unit.f68710a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements zr.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PostAdapter f52265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RoomProvider f52266b;

        public c(PostAdapter postAdapter, RoomProvider roomProvider) {
            this.f52265a = postAdapter;
            this.f52266b = roomProvider;
        }

        @Override // zr.a
        public void a(int i11, long j11, View view) {
            PostAdapter postAdapter = this.f52265a;
            RoomProvider roomProvider = this.f52266b;
            try {
                Result.Companion companion = Result.Companion;
                uo.b.a.f(uo.b.f78622a, RoomProvider.f52244r, "2-------post report, position:" + i11 + ", duration:" + j11, false, 4, null);
                com.transsion.postdetail.helper.a.f55063a.u(roomProvider.f52252k, RoomProvider.f52245s, "", i11, j11, postAdapter.getItem(i11), (64 & 64) != 0 ? null : null);
                Result.m163constructorimpl(Unit.f68710a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements r00.a {
        public d() {
        }

        @Override // r00.a
        public void onLogin(UserInfo user) {
            Intrinsics.g(user, "user");
            TrendingViewModel trendingViewModel = RoomProvider.this.f52248g;
            if (trendingViewModel != null) {
                trendingViewModel.H(false);
            }
        }

        @Override // r00.a
        public void onLogout() {
            TrendingViewModel trendingViewModel = RoomProvider.this.f52248g;
            if (trendingViewModel != null) {
                trendingViewModel.H(false);
            }
        }

        @Override // r00.a
        public void onUpdateUserInfo(UserInfo userInfo) {
            r00.a.C0822a.c(this, userInfo);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e extends RecyclerView.r {
        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            Intrinsics.g(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i11, i12);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f52268a;

        public f(Function1 function) {
            Intrinsics.g(function, "function");
            this.f52268a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f52268a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f52268a.invoke(obj);
        }
    }

    public RoomProvider(final BaseHomeSubFragment<?> fragment, TrendingViewModel trendingViewModel) {
        Intrinsics.g(fragment, "fragment");
        this.f52247f = fragment;
        this.f52248g = trendingViewModel;
        this.f52249h = FragmentViewModelLazyKt.a(fragment, Reflection.b(rw.f.class), new Function0<x0>() { // from class: com.transsion.home.adapter.trending.provider.RoomProvider$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = fragment.requireActivity().getViewModelStore();
                Intrinsics.f(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.home.adapter.trending.provider.RoomProvider$special$$inlined$activityViewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                v0.c defaultViewModelProviderFactory = fragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.f(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.f52252k = com.transsion.baselib.report.m.f51277a.f();
        this.f52253l = new e();
        this.f52254m = new d();
        this.f52255n = LazyKt__LazyJVMKt.b(new Function0<RoomProvider$roomRecycledViewPool$2.a>() { // from class: com.transsion.home.adapter.trending.provider.RoomProvider$roomRecycledViewPool$2

            /* JADX INFO: compiled from: source.java */
            @Metadata
            public static final class a extends RecyclerView.s {
                public a() {
                    m(0, 10);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a();
            }
        });
        this.f52256o = LazyKt__LazyJVMKt.b(new Function0<RoomProvider$postRecycledViewPool$2.a>() { // from class: com.transsion.home.adapter.trending.provider.RoomProvider$postRecycledViewPool$2

            /* JADX INFO: compiled from: source.java */
            @Metadata
            public static final class a extends RecyclerView.s {
                public a() {
                    m(0, 10);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a();
            }
        });
    }

    public static final void B(View view) {
        com.transsion.room.helper.k.f57301a.e(f52245s, f52246t);
        rw.e.b(rw.e.f75743a, null, null, 3, null);
    }

    private final rw.f E() {
        return (rw.f) this.f52249h.getValue();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public void a(final BaseViewHolder helper, OperateItem item) {
        androidx.lifecycle.c0<RoomEntranceResponse> c0VarQ;
        androidx.lifecycle.c0<RoomEntranceResponse> c0VarQ2;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        final RecyclerView recyclerView = (RecyclerView) helper.getView(R$id.main_operation_room_group_recycler);
        final RecyclerView recyclerView2 = (RecyclerView) helper.getView(R$id.main_operation_room_post_recycler);
        ((TextView) helper.getView(R$id.main_operation_room_more_text)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RoomProvider.B(view);
            }
        });
        String title = item.getTitle();
        if (title != null && title.length() != 0) {
            ((TextView) helper.getView(R$id.main_operation_room_title)).setText(item.getTitle());
        }
        if (!Intrinsics.b(recyclerView.getRecycledViewPool(), D())) {
            recyclerView.setRecycledViewPool(D());
        }
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new ro.e(8.0f, 0.0f, 12.0f, 2, null));
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f52247f.getContext(), 0, false));
        final RoomAdapter roomAdapter = new RoomAdapter();
        recyclerView.setAdapter(roomAdapter);
        if (!Intrinsics.b(recyclerView2.getRecycledViewPool(), C())) {
            recyclerView2.setRecycledViewPool(C());
        }
        if (recyclerView2.getItemDecorationCount() == 0) {
            recyclerView2.addItemDecoration(new ro.e(8.0f, 0.0f, 12.0f, 2, null));
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(this.f52247f.getContext(), 0, false));
        final PostAdapter postAdapter = new PostAdapter(this.f52252k, E());
        recyclerView2.setAdapter(postAdapter);
        F(recyclerView, recyclerView2, roomAdapter, postAdapter);
        TrendingViewModel trendingViewModel = this.f52248g;
        if (trendingViewModel != null && (c0VarQ2 = trendingViewModel.Q()) != null) {
            c0VarQ2.p(this.f52247f);
        }
        TrendingViewModel trendingViewModel2 = this.f52248g;
        if (trendingViewModel2 == null || (c0VarQ = trendingViewModel2.Q()) == null) {
            return;
        }
        c0VarQ.j(this.f52247f, new f(new Function1<RoomEntranceResponse, Unit>() { // from class: com.transsion.home.adapter.trending.provider.RoomProvider$convert$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RoomEntranceResponse roomEntranceResponse) {
                invoke2(roomEntranceResponse);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RoomEntranceResponse roomEntranceResponse) {
                helper.setText(R$id.main_operation_room_title, roomEntranceResponse.getTitle());
                List<RoomItem> groups = roomEntranceResponse.getGroups();
                if (groups == null || groups.isEmpty()) {
                    recyclerView.setVisibility(8);
                } else {
                    recyclerView.setVisibility(0);
                    roomAdapter.w0(roomEntranceResponse.getGroups());
                }
                List<PostSubjectItem> posts = roomEntranceResponse.getPosts();
                if (posts == null || posts.isEmpty()) {
                    recyclerView2.setVisibility(8);
                    return;
                }
                recyclerView2.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                List<PostSubjectItem> posts2 = roomEntranceResponse.getPosts();
                Intrinsics.d(posts2);
                arrayList.addAll(posts2);
                PostSubjectItem postSubjectItem = new PostSubjectItem(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, null, false, null, false, 1073741823, null);
                postSubjectItem.setMore(true);
                arrayList.add(postSubjectItem);
                postAdapter.w0(arrayList);
            }
        }));
    }

    public final RoomProvider$postRecycledViewPool$2.a C() {
        return (RoomProvider$postRecycledViewPool$2.a) this.f52256o.getValue();
    }

    public final RoomProvider$roomRecycledViewPool$2.a D() {
        return (RoomProvider$roomRecycledViewPool$2.a) this.f52255n.getValue();
    }

    public final void F(RecyclerView recyclerView, RecyclerView recyclerView2, RoomAdapter roomAdapter, PostAdapter postAdapter) {
        recyclerView.clearOnScrollListeners();
        recyclerView2.clearOnScrollListeners();
        zr.b bVar = new zr.b(0.6f, new b(roomAdapter, this), false, 4, null);
        bVar.n(1);
        ExposureType exposureType = ExposureType.NEST_HORIZONTAL;
        bVar.o(exposureType);
        recyclerView.addOnScrollListener(bVar);
        this.f52250i = bVar;
        zr.b bVar2 = new zr.b(0.6f, new c(postAdapter, this), false, 4, null);
        bVar2.n(1);
        bVar2.o(exposureType);
        recyclerView2.addOnScrollListener(bVar2);
        this.f52251j = bVar2;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return PostItemType.ROOM.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.post_list_item_room;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public BaseViewHolder n(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        return super.n(parent, i11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void p(BaseViewHolder holder) {
        Unit unit;
        RecyclerView recyclerViewW;
        Intrinsics.g(holder, "holder");
        super.p(holder);
        try {
            Result.Companion companion = Result.Companion;
            BaseProviderMultiAdapter<OperateItem> baseProviderMultiAdapterC = c();
            if (baseProviderMultiAdapterC == null || (recyclerViewW = baseProviderMultiAdapterC.W()) == null) {
                unit = null;
            } else {
                recyclerViewW.addOnScrollListener(this.f52253l);
                unit = Unit.f68710a;
            }
            Result.m163constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void q(BaseViewHolder holder) {
        Unit unit;
        RecyclerView recyclerViewW;
        Intrinsics.g(holder, "holder");
        super.q(holder);
        uo.b.a.s(uo.b.f78622a, f52244r, "room onViewDetachedFromWindow", false, 4, null);
        zr.b bVar = this.f52250i;
        if (bVar != null) {
            bVar.f();
        }
        zr.b bVar2 = this.f52251j;
        if (bVar2 != null) {
            bVar2.f();
        }
        try {
            Result.Companion companion = Result.Companion;
            BaseProviderMultiAdapter<OperateItem> baseProviderMultiAdapterC = c();
            if (baseProviderMultiAdapterC == null || (recyclerViewW = baseProviderMultiAdapterC.W()) == null) {
                unit = null;
            } else {
                recyclerViewW.removeOnScrollListener(this.f52253l);
                unit = Unit.f68710a;
            }
            Result.m163constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }
}
