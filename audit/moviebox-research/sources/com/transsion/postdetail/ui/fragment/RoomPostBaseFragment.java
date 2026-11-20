package com.transsion.postdetail.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.android.arouter.facade.Postcard;
import com.applovin.sdk.AppLovinEventTypes;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.fragment.LazyFragment;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.ui.adapter.PostAdapterFrom;
import com.transsion.postdetail.ui.view.PostListLoadMoreView;
import com.transsion.postdetail.viewmodel.PostDetailViewModel;
import com.transsion.postdetail.viewmodel.RoomPostViewModel;
import com.transsion.postdetailapi.IPostDetailApi;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.user.action.sync.event.CommentEvent;
import com.transsion.usercenterapi.ReportType;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.LikeEvent;
import com.transsnet.flow.event.sync.event.PublishEvent;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
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
public abstract class RoomPostBaseFragment extends LazyFragment<tv.p> implements aw.a {
    public Function0<Unit> A;
    public com.transsion.postdetail.video.b B;
    public View C;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.transsion.postdetail.ui.adapter.d f55787q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public zr.b f55788r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public RoomPostViewModel f55789s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public PostDetailViewModel f55790t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f55791u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f55792v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Subject f55794x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Group f55795y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f55796z;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f55785o = "sa_post_exposure_percent";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f55786p = "Post_" + getClass().getSimpleName();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f55793w = 8;
    public final Lazy D = LazyKt__LazyJVMKt.b(new Function0<Handler>() { // from class: com.transsion.postdetail.ui.fragment.RoomPostBaseFragment$mHandler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });
    public final Lazy E = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.postdetail.ui.fragment.RoomPostBaseFragment$mLoginApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ILoginApi invoke() {
            return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements zr.a {
        public a() {
        }

        @Override // zr.a
        public void a(int i11, long j11, View view) {
            PostSubjectItem item;
            RoomPostBaseFragment roomPostBaseFragment = RoomPostBaseFragment.this;
            try {
                Result.Companion companion = Result.Companion;
                com.transsion.postdetail.ui.adapter.d dVarB1 = roomPostBaseFragment.b1();
                if (dVarB1 != null && (item = dVarB1.getItem(i11)) != null) {
                    com.transsion.postdetail.helper.a.f55063a.u(roomPostBaseFragment.h1(), roomPostBaseFragment.M1(), roomPostBaseFragment.R1(), i11, j11, item, roomPostBaseFragment.d1());
                }
                Result.m163constructorimpl(Unit.f68710a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends DiffUtil.e<PostSubjectItem> {
        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(PostSubjectItem oldItem, PostSubjectItem newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(oldItem.getPostId(), newItem.getPostId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(PostSubjectItem oldItem, PostSubjectItem newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(oldItem.getPostId(), newItem.getPostId());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements com.transsion.share.share.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareDialogFragment f55798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PostSubjectItem f55799b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RoomPostBaseFragment f55800c;

        public c(ShareDialogFragment shareDialogFragment, PostSubjectItem postSubjectItem, RoomPostBaseFragment roomPostBaseFragment) {
            this.f55798a = shareDialogFragment;
            this.f55799b = postSubjectItem;
            this.f55800c = roomPostBaseFragment;
        }

        @Override // com.transsion.share.share.e
        public void a(String id2, PostType postType) {
            Intrinsics.g(id2, "id");
            RoomPostViewModel roomPostViewModelJ1 = this.f55800c.j1();
            if (roomPostViewModelJ1 != null) {
                roomPostViewModelJ1.k(id2);
            }
        }

        @Override // com.transsion.share.share.e
        public void b(String str) {
            uo.b.a.f(uo.b.f78622a, this.f55800c.l1(), "id" + str, false, 4, null);
            this.f55800c.O1(str);
        }

        @Override // com.transsion.share.share.e
        public void c(String url, String fileName, String fileSize, String fileImage) {
            Subject subject;
            ResourceDetectors resourceDetector;
            String resourceLink;
            Media media;
            Cover cover;
            Integer size;
            Media media2;
            Cover cover2;
            String url2;
            String url3;
            String url4;
            Media media3;
            Intrinsics.g(url, "url");
            Intrinsics.g(fileName, "fileName");
            Intrinsics.g(fileSize, "fileSize");
            Intrinsics.g(fileImage, "fileImage");
            if (com.transsion.baseui.util.c.f51452a.a(this.f55798a.getId(), 500L)) {
                return;
            }
            PostSubjectItem postSubjectItem = this.f55799b;
            Video videoA = com.transsion.postdetail.util.l.a((postSubjectItem == null || (media3 = postSubjectItem.getMedia()) == null) ? null : media3.getVideo());
            PostSubjectItem postSubjectItem2 = this.f55799b;
            String title = postSubjectItem2 != null ? postSubjectItem2.getTitle() : null;
            if (TextUtils.isEmpty(title)) {
                PostSubjectItem postSubjectItem3 = this.f55799b;
                title = postSubjectItem3 != null ? postSubjectItem3.getContent() : null;
            }
            String str = title;
            String str2 = (videoA == null || (url4 = videoA.getUrl()) == null) ? "" : url4;
            String str3 = (videoA == null || (url3 = videoA.getUrl()) == null) ? "" : url3;
            PostSubjectItem postSubjectItem4 = this.f55799b;
            String str4 = (postSubjectItem4 == null || (media2 = postSubjectItem4.getMedia()) == null || (cover2 = media2.getCover()) == null || (url2 = cover2.getUrl()) == null) ? "" : url2;
            Long lValueOf = (videoA == null || (size = videoA.getSize()) == null) ? null : Long.valueOf(size.intValue());
            PostSubjectItem postSubjectItem5 = this.f55799b;
            String postId = postSubjectItem5 != null ? postSubjectItem5.getPostId() : null;
            PostSubjectItem postSubjectItem6 = this.f55799b;
            DownloadBean downloadBean = new DownloadBean(str2, str3, str, str4, lValueOf, postSubjectItem6 != null ? postSubjectItem6.getPostId() : null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, postId, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -134217792, 1073741823, null);
            PostSubjectItem postSubjectItem7 = this.f55799b;
            downloadBean.setThumbnail((postSubjectItem7 == null || (media = postSubjectItem7.getMedia()) == null || (cover = media.getCover()) == null) ? null : cover.getThumbnail());
            PostSubjectItem postSubjectItem8 = this.f55799b;
            if (postSubjectItem8 == null || !postSubjectItem8.getBuiltIn()) {
                DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
                Context context = this.f55798a.getContext();
                Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                PostSubjectItem postSubjectItem9 = this.f55799b;
                String ops = postSubjectItem9 != null ? postSubjectItem9.getOps() : null;
                PostSubjectItem postSubjectItem10 = this.f55799b;
                DownloadManagerApi.U1(downloadManagerApiA, fragmentActivity, downloadBean, "postdetail_video", ops, (postSubjectItem10 == null || (subject = postSubjectItem10.getSubject()) == null || (resourceDetector = subject.getResourceDetector()) == null || (resourceLink = resourceDetector.getResourceLink()) == null) ? "" : resourceLink, null, null, 96, null);
            } else {
                this.f55800c.P1(downloadBean);
            }
            com.transsion.postdetail.helper.a.i(com.transsion.postdetail.helper.a.f55063a, this.f55799b, this.f55800c.R1(), null, 4, null);
        }

        @Override // com.transsion.share.share.e
        public void d(String id2) {
            Intrinsics.g(id2, "id");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f55801a;

        public d(Function1 function) {
            Intrinsics.g(function, "function");
            this.f55801a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f55801a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f55801a.invoke(obj);
        }
    }

    private final void A1() {
        Function1<LikeEvent, Unit> function1 = new Function1<LikeEvent, Unit>() { // from class: com.transsion.postdetail.ui.fragment.RoomPostBaseFragment$observeLike$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LikeEvent likeEvent) {
                invoke2(likeEvent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LikeEvent value) {
                int i11;
                Stat stat;
                Object objM163constructorimpl;
                List<PostSubjectItem> listD;
                List<PostSubjectItem> listD2;
                Intrinsics.g(value, "value");
                try {
                    com.transsion.postdetail.ui.adapter.d dVarB1 = this.this$0.b1();
                    if (dVarB1 != null && (listD2 = dVarB1.D()) != null) {
                        Iterator<PostSubjectItem> it = listD2.iterator();
                        i11 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i11 = -1;
                                break;
                            } else if (Intrinsics.b(it.next().getPostId(), value.getSubjectId())) {
                                break;
                            } else {
                                i11++;
                            }
                        }
                    } else {
                        i11 = -1;
                        break;
                    }
                    if (i11 >= 0) {
                        com.transsion.postdetail.ui.adapter.d dVarB2 = this.this$0.b1();
                        PostSubjectItem postSubjectItem = (dVarB2 == null || (listD = dVarB2.D()) == null) ? null : listD.get(i11);
                        if (postSubjectItem != null) {
                            postSubjectItem.setHasLike(Boolean.valueOf(value.getLike()));
                        }
                        if (postSubjectItem != null && (stat = postSubjectItem.getStat()) != null) {
                            try {
                                Result.Companion companion = Result.Companion;
                                Long likeCount = stat.getLikeCount();
                                stat.setLikeCount(Long.valueOf((likeCount != null ? likeCount.longValue() : 0L) + ((long) (value.getLike() ? 1 : -1))));
                                objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                            } catch (Throwable th2) {
                                Result.Companion companion2 = Result.Companion;
                                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
                            }
                            Result.m162boximpl(objM163constructorimpl);
                        }
                        com.transsion.postdetail.ui.adapter.d dVarB3 = this.this$0.b1();
                        if (dVarB3 != null) {
                            dVarB3.notifyItemChanged(i11, Boolean.valueOf(value.getLike()));
                        }
                    }
                } catch (Exception unused) {
                    uo.b.a.g(uo.b.f78622a, " callback change data fail", false, 2, null);
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = LikeEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.w0.c().q(), false, function1);
    }

    public static /* synthetic */ void I1(RoomPostBaseFragment roomPostBaseFragment, PostSubjectItem postSubjectItem, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openPostDetail");
        }
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        roomPostBaseFragment.H1(postSubjectItem, z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P1(DownloadBean downloadBean) {
        kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(kotlinx.coroutines.w0.b()), null, null, new RoomPostBaseFragment$saveBuiltInVideo$1(downloadBean, null), 3, null);
    }

    public static final void U1(RoomPostBaseFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        com.transsion.postdetail.video.b bVar = this$0.B;
        if (bVar != null) {
            bVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler e1() {
        return (Handler) this.D.getValue();
    }

    private final ILoginApi f1() {
        return (ILoginApi) this.E.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n1() {
        RecyclerView recyclerView;
        float fK1 = k1();
        uo.b.a.f(uo.b.f78622a, "PostList", "initExposureHelper, postExposurePercent:" + fK1, false, 4, null);
        zr.b bVar = new zr.b(fK1, new a(), false, 4, null);
        bVar.n(2);
        tv.p pVar = (tv.p) getMViewBinding();
        if (pVar != null && (recyclerView = pVar.f77888b) != null) {
            recyclerView.addOnScrollListener(bVar);
        }
        this.f55788r = bVar;
    }

    public static final void p1(RoomPostBaseFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        aw.a.C0136a.a(this$0, null, 1, null);
    }

    public static final void q1(RoomPostBaseFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.v1(false);
    }

    public static final void r1(RoomPostBaseFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 500L)) {
            return;
        }
        Object item = adapter.getItem(i11);
        PostSubjectItem postSubjectItem = item instanceof PostSubjectItem ? (PostSubjectItem) item : null;
        if (postSubjectItem == null) {
            return;
        }
        com.transsion.postdetail.helper.a.f55063a.w(this$0.f55791u, this$0.M1(), this$0.R1(), i11, WebConstants.FIELD_ITEM, postSubjectItem, this$0.f55796z);
        I1(this$0, postSubjectItem, false, 2, null);
    }

    public static final void s1(RoomPostBaseFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 500L)) {
            return;
        }
        Object item = adapter.getItem(i11);
        String strE1 = null;
        PostSubjectItem postSubjectItem = item instanceof PostSubjectItem ? (PostSubjectItem) item : null;
        int id2 = view.getId();
        if (id2 == R$id.fl_cover || id2 == R$id.tv_room_name || id2 == R$id.tv_post_date) {
            this$0.D1(postSubjectItem);
            strE1 = this$0.E1();
        } else if (id2 == R$id.v_post_like) {
            strE1 = (postSubjectItem == null || !Intrinsics.b(postSubjectItem.getHasLike(), Boolean.TRUE)) ? "like" : "dislike";
            this$0.F1(postSubjectItem);
        } else if (id2 == R$id.v_post_comment) {
            this$0.C1(postSubjectItem);
            strE1 = "comment";
        } else if (id2 == R$id.v_post_share) {
            this$0.G1(postSubjectItem);
            strE1 = AppLovinEventTypes.USER_SHARED_LINK;
        } else if (id2 == R$id.cl_subject_content) {
            this$0.K1(postSubjectItem);
            strE1 = "subject";
        } else if (id2 == R$id.tv_room_tag) {
            this$0.J1(postSubjectItem);
            strE1 = "group";
        }
        if (postSubjectItem != null) {
            com.transsion.postdetail.helper.a.f55063a.w(this$0.f55791u, this$0.M1(), this$0.R1(), i11, strE1 == null ? "" : strE1, postSubjectItem, this$0.f55796z);
        }
    }

    public static /* synthetic */ void w1(RoomPostBaseFragment roomPostBaseFragment, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadData");
        }
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        roomPostBaseFragment.v1(z11);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean A0() {
        return false;
    }

    public final void B1() {
        if (t1()) {
            uo.b.a.f(uo.b.f78622a, this.f55786p, getClass().getSimpleName() + "--observePublish", false, 4, null);
            Function1<PublishEvent, Unit> function1 = new Function1<PublishEvent, Unit>() { // from class: com.transsion.postdetail.ui.fragment.RoomPostBaseFragment$observePublish$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PublishEvent publishEvent) {
                    invoke2(publishEvent);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PublishEvent value) {
                    PostDetailViewModel postDetailViewModelC1;
                    Intrinsics.g(value, "value");
                    androidx.lifecycle.u parentFragment = this.this$0.getParentFragment();
                    if (parentFragment instanceof rw.c) {
                        int iK = ((rw.c) parentFragment).K();
                        uo.b.a.f(uo.b.f78622a, this.this$0.l1(), this.this$0.getClass().getSimpleName() + "--publishevent curTab:" + iK + ", fTab:" + this.this$0.S1(), false, 4, null);
                        if (this.this$0.S1() != iK || (postDetailViewModelC1 = this.this$0.c1()) == null) {
                            return;
                        }
                        postDetailViewModelC1.n(value.getPostId());
                    }
                }
            };
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = PublishEvent.class.getName();
            Intrinsics.f(name, "T::class.java.name");
            flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.w0.c().q(), false, function1);
        }
    }

    public final void C1(PostSubjectItem postSubjectItem) {
        H1(postSubjectItem, true);
    }

    public abstract void D1(PostSubjectItem postSubjectItem);

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        K0();
        w1(this, false, 1, null);
    }

    public abstract String E1();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.transsion.postdetail.viewmodel.RoomPostViewModel] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void F1(PostSubjectItem postSubjectItem) {
        ?? B = postSubjectItem != null ? Intrinsics.b(postSubjectItem.getHasLike(), Boolean.TRUE) : 0;
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.no_network_tips);
            return;
        }
        ?? r11 = this.f55789s;
        if (r11 != 0) {
            r11.z(postSubjectItem != null ? postSubjectItem.getPostId() : null, B);
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0030  */
    public final void G1(PostSubjectItem postSubjectItem) {
        boolean z11;
        User user;
        Media media;
        User user2;
        UserInfo userInfoP = f1().P();
        if ((userInfoP != null ? userInfoP.getUserId() : null) != null) {
            if (Intrinsics.b(userInfoP.getUserId(), (postSubjectItem == null || (user2 = postSubjectItem.getUser()) == null) ? null : user2.getUserId())) {
                z11 = true;
            } else {
                z11 = false;
            }
        } else {
            z11 = false;
        }
        boolean zB = Intrinsics.b((postSubjectItem == null || (media = postSubjectItem.getMedia()) == null) ? null : media.getMediaType(), MediaType.VIDEO.getValue());
        ShareDialogFragment.a aVar = ShareDialogFragment.f57724t;
        PostType postType = PostType.POST_TYPE;
        String postId = postSubjectItem != null ? postSubjectItem.getPostId() : null;
        String userId = (postSubjectItem == null || (user = postSubjectItem.getUser()) == null) ? null : user.getUserId();
        String value = ReportType.POST.getValue();
        String title = postSubjectItem != null ? postSubjectItem.getTitle() : null;
        Context context = getContext();
        ShareDialogFragment shareDialogFragmentA = aVar.a(postType, postId, userId, value, (3072 & 16) != 0 ? "" : title, (3072 & 32) != 0 ? "" : "", (3072 & 64) != 0 ? false : zB, (3072 & 128) != 0 ? false : z11, (3072 & 256) != 0 ? false : false, "postdetail", (3072 & 1024) != 0 ? "" : null, (3072 & 2048) != 0 ? "" : context != null ? context.getString(com.transsion.postdetail.R$string.save_video) : null);
        shareDialogFragmentA.E0(new c(shareDialogFragmentA, postSubjectItem, this));
        shareDialogFragmentA.show(getChildFragmentManager(), AppLovinEventTypes.USER_SHARED_LINK);
    }

    public final void H1(PostSubjectItem postSubjectItem, boolean z11) {
        if (postSubjectItem != null) {
            ((IPostDetailApi) com.alibaba.android.arouter.launcher.a.d().h(IPostDetailApi.class)).f0(postSubjectItem);
            com.alibaba.android.arouter.launcher.a aVarD = com.alibaba.android.arouter.launcher.a.d();
            Media media = postSubjectItem.getMedia();
            Postcard postcardWithString = aVarD.b(Intrinsics.b(media != null ? media.getMediaType() : null, MediaType.VIDEO.getValue()) ? "/post/detailVideo" : "/post/detail").withString(WebConstants.PAGE_FROM, M1()).withBoolean("from_comment", z11).withSerializable("item_object", postSubjectItem).withString("id", postSubjectItem.getPostId()).withString("rec_ops", postSubjectItem.getOps()).withString("item_type", postSubjectItem.getItemType());
            Media media2 = postSubjectItem.getMedia();
            postcardWithString.withString("media_type", media2 != null ? media2.getMediaType() : null).withBoolean("is_build_in", postSubjectItem.getBuiltIn()).navigation();
        }
    }

    public void J1(PostSubjectItem postSubjectItem) {
        Group group;
        String groupId;
        if (postSubjectItem == null || (group = postSubjectItem.getGroup()) == null || (groupId = group.getGroupId()) == null) {
            return;
        }
        com.alibaba.android.arouter.launcher.a.d().b("/room/detail").withString("id", groupId).navigation();
    }

    public void K1(PostSubjectItem postSubjectItem) {
        Subject subject;
        if (postSubjectItem == null || (subject = postSubjectItem.getSubject()) == null) {
            return;
        }
        Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail");
        Integer subjectType = subject.getSubjectType();
        postcardB.withInt("subject_type", subjectType != null ? subjectType.intValue() : SubjectType.MOVIE.getValue()).withString("id", subject.getSubjectId()).withString("ops", subject.getOps()).navigation();
    }

    public void L1(PostSubjectItem postSubjectItem) {
        User user;
        if (postSubjectItem == null || (user = postSubjectItem.getUser()) == null) {
            return;
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(user.getUserId());
        userInfo.setAvatar(user.getAvatar());
        userInfo.setUsername(user.getUsername());
        userInfo.setNickname(user.getNickname());
        com.alibaba.android.arouter.launcher.a.d().b("/profile/user_center").withSerializable("userInfo", userInfo).navigation();
    }

    public abstract String M1();

    public abstract PostAdapterFrom N1();

    public final void O1(String str) {
        List<PostSubjectItem> listD;
        com.transsion.postdetail.ui.adapter.d dVar;
        com.transsion.postdetail.ui.adapter.d dVar2 = this.f55787q;
        if (dVar2 == null || (listD = dVar2.D()) == null) {
            return;
        }
        Iterator<PostSubjectItem> it = listD.iterator();
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                i11 = -1;
                break;
            } else if (Intrinsics.b(it.next().getPostId(), str)) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 >= 0 && (dVar = this.f55787q) != null) {
            dVar.k0(i11);
        }
    }

    public final void Q1(String str) {
        this.f55796z = str;
    }

    public abstract String R1();

    public abstract int S1();

    /* JADX WARN: Multi-variable type inference failed */
    public void T1(PostSubjectBean postSubjectBean) {
        List arrayList;
        h9.f fVarQ;
        h9.f fVarQ2;
        Pager pager;
        h9.f fVarQ3;
        List<PostSubjectItem> items;
        h9.f fVarQ4;
        com.transsion.postdetail.ui.adapter.d dVar;
        h9.f fVarQ5;
        h9.f fVarQ6;
        com.transsion.postdetail.ui.adapter.d dVar2;
        h9.f fVarQ7;
        FrameLayout frameLayoutB;
        SwipeRefreshLayout swipeRefreshLayout;
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(true);
        }
        Function0<Unit> function0 = this.A;
        if (function0 != null) {
            function0.invoke();
        }
        F0();
        tv.p pVar = (tv.p) getMViewBinding();
        if (pVar != null && (swipeRefreshLayout = pVar.f77889c) != null && swipeRefreshLayout.isRefreshing()) {
            tv.p pVar2 = (tv.p) getMViewBinding();
            SwipeRefreshLayout swipeRefreshLayout2 = pVar2 != null ? pVar2.f77889c : null;
            if (swipeRefreshLayout2 != null) {
                swipeRefreshLayout2.setRefreshing(false);
            }
        }
        com.transsion.postdetail.ui.adapter.d dVar3 = this.f55787q;
        if (dVar3 == null || (arrayList = dVar3.D()) == null) {
            arrayList = new ArrayList();
        }
        if (postSubjectBean == null || (items = postSubjectBean.getItems()) == null || items.isEmpty()) {
            if (arrayList.isEmpty()) {
                a1();
                return;
            }
            com.transsion.postdetail.ui.adapter.d dVar4 = this.f55787q;
            if (dVar4 == null || (fVarQ = dVar4.Q()) == null || !fVarQ.q()) {
                return;
            }
            if (postSubjectBean == null || (pager = postSubjectBean.getPager()) == null || !Intrinsics.b(pager.getHasMore(), Boolean.TRUE)) {
                com.transsion.postdetail.ui.adapter.d dVar5 = this.f55787q;
                if (dVar5 == null || (fVarQ2 = dVar5.Q()) == null) {
                    return;
                }
                h9.f.t(fVarQ2, false, 1, null);
                return;
            }
            com.transsion.postdetail.ui.adapter.d dVar6 = this.f55787q;
            if (dVar6 == null || (fVarQ3 = dVar6.Q()) == null) {
                return;
            }
            fVarQ3.u();
            return;
        }
        Pager pager2 = postSubjectBean.getPager();
        this.f55792v = pager2 != null ? pager2.getNextPage() : null;
        if (postSubjectBean.getSubject() != null) {
            this.f55794x = postSubjectBean.getSubject();
        }
        if (postSubjectBean.getGroup() != null) {
            this.f55795y = postSubjectBean.getGroup();
        }
        if (postSubjectBean.isRefresh()) {
            com.transsion.postdetail.ui.adapter.d dVar7 = this.f55787q;
            if (dVar7 != null) {
                dVar7.w0(postSubjectBean.getItems());
            }
            tv.p pVar3 = (tv.p) getMViewBinding();
            if (pVar3 != null && (frameLayoutB = pVar3.getRoot()) != null) {
                frameLayoutB.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.l0
                    @Override // java.lang.Runnable
                    public final void run() {
                        RoomPostBaseFragment.U1(this.f55899a);
                    }
                });
            }
        } else {
            List<PostSubjectItem> items2 = postSubjectBean.getItems();
            if (items2 != null) {
                if (this instanceof RoomPostExploreFragment) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : items2) {
                        if (((PostSubjectItem) obj).getGroup() != null) {
                            arrayList2.add(obj);
                        }
                    }
                    items2 = arrayList2;
                }
                ArrayList arrayList3 = new ArrayList();
                if (!arrayList.isEmpty()) {
                    for (PostSubjectItem postSubjectItem : items2) {
                        if (!arrayList.contains(postSubjectItem)) {
                            Subject subject = this.f55794x;
                            if (subject != null) {
                                postSubjectItem.setSubject(subject);
                            }
                            Group group = this.f55795y;
                            if (group != null) {
                                postSubjectItem.setGroup(group);
                            }
                            arrayList3.add(postSubjectItem);
                        }
                    }
                } else {
                    for (PostSubjectItem postSubjectItem2 : items2) {
                        Subject subject2 = this.f55794x;
                        if (subject2 != null) {
                            postSubjectItem2.setSubject(subject2);
                        }
                        Group group2 = this.f55795y;
                        if (group2 != null) {
                            postSubjectItem2.setGroup(group2);
                        }
                    }
                    arrayList3.addAll(items2);
                }
                if (arrayList3.isEmpty()) {
                    com.transsion.postdetail.ui.adapter.d dVar8 = this.f55787q;
                    if (dVar8 != null && (fVarQ4 = dVar8.Q()) != null) {
                        h9.f.t(fVarQ4, false, 1, null);
                    }
                    if (arrayList.isEmpty()) {
                        a1();
                    }
                } else {
                    com.transsion.postdetail.ui.adapter.d dVar9 = this.f55787q;
                    if (dVar9 != null) {
                        dVar9.m(arrayList3);
                    }
                }
            }
        }
        com.transsion.postdetail.ui.adapter.d dVar10 = this.f55787q;
        if (dVar10 != null && (fVarQ6 = dVar10.Q()) != null && fVarQ6.q() && (dVar2 = this.f55787q) != null && (fVarQ7 = dVar2.Q()) != null) {
            fVarQ7.r();
        }
        Pager pager3 = postSubjectBean.getPager();
        if ((pager3 != null && Intrinsics.b(pager3.getHasMore(), Boolean.TRUE)) || (dVar = this.f55787q) == null || (fVarQ5 = dVar.Q()) == null) {
            return;
        }
        h9.f.t(fVarQ5, false, 1, null);
    }

    public final void V1(BaseDto<String> baseDto) {
        List<PostSubjectItem> listD;
        com.transsion.postdetail.ui.adapter.d dVar;
        Unit unit = null;
        if (!Intrinsics.b(baseDto != null ? baseDto.getCode() : null, "0")) {
            zp.b.f82110a.e(getString(com.transsion.postdetail.R$string.delete_post_failed));
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            com.transsion.postdetail.ui.adapter.d dVar2 = this.f55787q;
            if (dVar2 != null && (listD = dVar2.D()) != null) {
                Iterator<PostSubjectItem> it = listD.iterator();
                int i11 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i11 = -1;
                        break;
                    } else if (Intrinsics.b(it.next().getPostId(), baseDto.getData())) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 >= 0 && (dVar = this.f55787q) != null) {
                    dVar.k0(i11);
                }
                unit = Unit.f68710a;
            }
            Result.m163constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public void a1() {
        if (getContext() == null) {
            return;
        }
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            com.transsion.postdetail.ui.adapter.d dVar = this.f55787q;
            if (dVar != null) {
                dVar.r0(l0(false));
                return;
            }
            return;
        }
        com.transsion.postdetail.ui.adapter.d dVar2 = this.f55787q;
        if (dVar2 != null) {
            dVar2.r0(r0(false));
        }
    }

    public final com.transsion.postdetail.ui.adapter.d b1() {
        return this.f55787q;
    }

    public final PostDetailViewModel c1() {
        return this.f55790t;
    }

    public final String d1() {
        return this.f55796z;
    }

    @Override // aw.a
    public void g(Function0<Unit> function0) {
        this.A = function0;
        this.f55792v = null;
        w1(this, false, 1, null);
    }

    public final String g1() {
        return this.f55792v;
    }

    public final String h1() {
        return this.f55791u;
    }

    public final int i1() {
        return this.f55793w;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        y1();
        z1();
        A1();
        B1();
    }

    public final RoomPostViewModel j1() {
        return this.f55789s;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String k0() {
        String string = getString(com.transsion.usercenter.R$string.profile_not_content);
        Intrinsics.f(string, "getString(com.transsion.…ring.profile_not_content)");
        return string;
    }

    public final float k1() {
        Float fK;
        ConfigBean configBeanC = ConfigManager.c(ConfigManager.f53111c.a(), this.f55785o, false, 2, null);
        String value = configBeanC != null ? configBeanC.getValue() : null;
        if (value == null || value.length() == 0 || (fK = kotlin.text.j.k(value)) == null) {
            return 0.6f;
        }
        return fK.floatValue();
    }

    public final String l1() {
        return this.f55786p;
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        K0();
        w1(this, false, 1, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: m1, reason: merged with bridge method [inline-methods] */
    public tv.p getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        tv.p pVarC = tv.p.c(inflater);
        Intrinsics.f(pVarC, "inflate(inflater)");
        return pVarC;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(M1(), false, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o1() {
        com.transsion.postdetail.video.b.a aVar = com.transsion.postdetail.video.b.f56244e8;
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        tv.p pVar = (tv.p) getMViewBinding();
        this.B = aVar.a(contextRequireContext, pVar != null ? pVar.f77888b : null, this.f55787q, M1(), R1(), getActivity() instanceof ut.a);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        HashMap<String, String> mapG;
        super.onCreate(bundle);
        this.f55789s = (RoomPostViewModel) new androidx.lifecycle.v0(this).a(RoomPostViewModel.class);
        this.f55790t = (PostDetailViewModel) new androidx.lifecycle.v0(this).a(PostDetailViewModel.class);
        this.f55791u = com.transsion.baselib.report.m.f51277a.f();
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (mapG = logViewConfig.g()) == null) {
            return;
        }
        mapG.put("subpage_name", R1());
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        e1().removeCallbacksAndMessages(null);
        com.transsion.postdetail.video.b bVar = this.B;
        if (bVar != null) {
            bVar.onPageDestroy();
        }
    }

    @Override // com.transsion.baseui.fragment.LazyFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (isResumed()) {
            if (z11) {
                logPause();
                x1();
                com.transsion.postdetail.video.b bVar = this.B;
                if (bVar != null) {
                    bVar.b();
                }
            } else {
                logResume();
                com.transsion.postdetail.video.b bVar2 = this.B;
                if (bVar2 != null) {
                    bVar2.c();
                }
            }
        }
        com.transsion.baseui.activity.d.h(null, this, z11, null, 9, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        x1();
        com.transsion.postdetail.video.b bVar = this.B;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // com.transsion.baseui.fragment.LazyFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com.transsion.postdetail.video.b bVar;
        super.onResume();
        if (!isVisible() || (bVar = this.B) == null) {
            return;
        }
        bVar.c();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View p0() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return new View(Utils.a());
        }
        if (this.C == null) {
            this.C = LayoutInflater.from(activity).inflate(R$layout.layout_room_post_loading, (ViewGroup) o0(), false);
        }
        return this.C;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    public abstract boolean t1();

    public abstract boolean u1();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        com.transsion.postdetail.ui.adapter.d dVar;
        LiveData<PostSubjectItem> liveDataQ;
        androidx.lifecycle.c0<BaseDto<String>> c0VarN;
        RecyclerView recyclerView;
        SwipeRefreshLayout swipeRefreshLayout;
        n1();
        if (u1()) {
            tv.p pVar = (tv.p) getMViewBinding();
            if (pVar != null && (swipeRefreshLayout = pVar.f77889c) != null) {
                swipeRefreshLayout.setProgressBackgroundColorSchemeColor(z2.a.getColor(swipeRefreshLayout.getContext(), R$color.bg_01));
                swipeRefreshLayout.setColorSchemeColors(z2.a.getColor(swipeRefreshLayout.getContext(), R$color.main_gradient_center), z2.a.getColor(swipeRefreshLayout.getContext(), R$color.main_gradient_start));
                swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.postdetail.ui.fragment.m0
                    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
                    public final void a() {
                        RoomPostBaseFragment.p1(this.f55902a);
                    }
                });
            }
        } else {
            tv.p pVar2 = (tv.p) getMViewBinding();
            SwipeRefreshLayout swipeRefreshLayout2 = pVar2 != null ? pVar2.f77889c : null;
            if (swipeRefreshLayout2 != null) {
                swipeRefreshLayout2.setEnabled(false);
            }
        }
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        com.transsion.postdetail.ui.adapter.d dVar2 = new com.transsion.postdetail.ui.adapter.d(contextRequireContext, N1(), this.f55788r, M1(), this.f55791u);
        dVar2.Q().y(true);
        dVar2.Q().x(true);
        dVar2.Q().D(3);
        dVar2.Q().B(new PostListLoadMoreView());
        dVar2.Q().C(new f9.f() { // from class: com.transsion.postdetail.ui.fragment.n0
            @Override // f9.f
            public final void a() {
                RoomPostBaseFragment.q1(this.f55904a);
            }
        });
        dVar2.o0(new b());
        dVar2.B0(new f9.d() { // from class: com.transsion.postdetail.ui.fragment.o0
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                RoomPostBaseFragment.r1(this.f55906a, baseQuickAdapter, view, i11);
            }
        });
        dVar2.i(R$id.fl_cover, R$id.tv_room_name, R$id.tv_post_date, R$id.v_post_like, R$id.v_post_comment, R$id.v_post_share, R$id.cl_subject_content, R$id.tv_room_tag);
        dVar2.z0(new f9.b() { // from class: com.transsion.postdetail.ui.fragment.p0
            @Override // f9.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                RoomPostBaseFragment.s1(this.f55909a, baseQuickAdapter, view, i11);
            }
        });
        this.f55787q = dVar2;
        tv.p pVar3 = (tv.p) getMViewBinding();
        if (pVar3 != null && (recyclerView = pVar3.f77888b) != null) {
            recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(this.f55787q);
        }
        RoomPostViewModel roomPostViewModel = this.f55789s;
        if (roomPostViewModel != null && (c0VarN = roomPostViewModel.n()) != null) {
            c0VarN.j(this, new d(new Function1<BaseDto<String>, Unit>() { // from class: com.transsion.postdetail.ui.fragment.RoomPostBaseFragment$initViewData$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BaseDto<String> baseDto) {
                    invoke2(baseDto);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(BaseDto<String> baseDto) {
                    this.this$0.V1(baseDto);
                }
            }));
        }
        PostDetailViewModel postDetailViewModel = this.f55790t;
        if (postDetailViewModel != null && (liveDataQ = postDetailViewModel.q()) != null) {
            liveDataQ.j(this, new d(new RoomPostBaseFragment$initViewData$5(this)));
        }
        if (!com.tn.lib.util.networkinfo.f.f49475a.e() && (dVar = this.f55787q) != null) {
            dVar.r0(r0(false));
        }
        o1();
    }

    public abstract void v1(boolean z11);

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }

    public final void x1() {
        zr.b bVar = this.f55788r;
        if (bVar != null) {
            bVar.f();
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        com.transsion.postdetail.helper.a.f55063a.p(M1(), R1(), jElapsedRealtime - (logViewConfig != null ? logViewConfig.h() : 0L), getLogViewConfig());
    }

    public final void y1() {
        Function1<CommentEvent, Unit> function1 = new Function1<CommentEvent, Unit>() { // from class: com.transsion.postdetail.ui.fragment.RoomPostBaseFragment$observeComment$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CommentEvent commentEvent) {
                invoke2(commentEvent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CommentEvent value) {
                Stat stat;
                Object objM163constructorimpl;
                Long lValueOf;
                List<PostSubjectItem> listD;
                List<PostSubjectItem> listD2;
                Intrinsics.g(value, "value");
                try {
                    com.transsion.postdetail.ui.adapter.d dVarB1 = this.this$0.b1();
                    int i11 = -1;
                    if (dVarB1 != null && (listD2 = dVarB1.D()) != null) {
                        Iterator<PostSubjectItem> it = listD2.iterator();
                        int i12 = 0;
                        while (it.hasNext()) {
                            if (Intrinsics.b(it.next().getPostId(), value.getSubjectId())) {
                                i11 = i12;
                                break;
                            }
                            i12++;
                        }
                    }
                    if (i11 >= 0) {
                        com.transsion.postdetail.ui.adapter.d dVarB2 = this.this$0.b1();
                        PostSubjectItem postSubjectItem = (dVarB2 == null || (listD = dVarB2.D()) == null) ? null : listD.get(i11);
                        if (postSubjectItem != null && (stat = postSubjectItem.getStat()) != null) {
                            try {
                                Result.Companion companion = Result.Companion;
                                if (value.getStatus()) {
                                    Long commentCount = stat.getCommentCount();
                                    lValueOf = Long.valueOf((commentCount != null ? commentCount.longValue() : 0L) + 1);
                                } else {
                                    Long commentCount2 = stat.getCommentCount();
                                    lValueOf = Long.valueOf((commentCount2 != null ? commentCount2.longValue() : 1L) - 1);
                                }
                                stat.setCommentCount(lValueOf);
                                objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                            } catch (Throwable th2) {
                                Result.Companion companion2 = Result.Companion;
                                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
                            }
                            Result.m162boximpl(objM163constructorimpl);
                        }
                        com.transsion.postdetail.ui.adapter.d dVarB3 = this.this$0.b1();
                        if (dVarB3 != null) {
                            dVarB3.notifyItemChanged(i11);
                        }
                    }
                } catch (Exception e11) {
                    uo.b.a.g(uo.b.f78622a, " callback change data fail " + e11.getMessage(), false, 2, null);
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = CommentEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.w0.c().q(), false, function1);
    }

    public final void z1() {
        Function1<j00.b, Unit> function1 = new Function1<j00.b, Unit>() { // from class: com.transsion.postdetail.ui.fragment.RoomPostBaseFragment$observeDelete$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(j00.b bVar) {
                invoke2(bVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(j00.b value) {
                com.transsion.postdetail.ui.adapter.d dVarB1;
                List<PostSubjectItem> listD;
                Intrinsics.g(value, "value");
                try {
                    com.transsion.postdetail.ui.adapter.d dVarB2 = this.this$0.b1();
                    int i11 = -1;
                    if (dVarB2 != null && (listD = dVarB2.D()) != null) {
                        Iterator<PostSubjectItem> it = listD.iterator();
                        int i12 = 0;
                        while (it.hasNext()) {
                            if (Intrinsics.b(it.next().getPostId(), value.a())) {
                                i11 = i12;
                                break;
                            }
                            i12++;
                        }
                    }
                    if (i11 >= 0 && (dVarB1 = this.this$0.b1()) != null) {
                        dVarB1.k0(i11);
                    }
                    this.this$0.a1();
                } catch (Exception unused) {
                    uo.b.a.g(uo.b.f78622a, " callback change data fail", false, 2, null);
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = j00.b.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.w0.c().q(), false, function1);
    }
}
