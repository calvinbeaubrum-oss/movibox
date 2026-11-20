package com.transsion.moviedetail.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResult;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.applovin.sdk.AppLovinEventTypes;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.view.StateView;
import com.tn.lib.widget.R$string;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.view.SubjectCommentsLoadMoreView;
import com.transsion.moviedetail.viewmodel.HotViewModel;
import com.transsion.moviedetailapi.AbsSubjectListViewModel;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Audio;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.LikeBean;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.RoomBean;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.moviedetailapi.helper.ListVideoPreloadHelper;
import com.transsion.moviedetailapi.p005enum.PostListSource;
import com.transsion.moviedetailapi.p005enum.ProfileSubSource;
import com.transsion.postdetail.R$id;
import com.transsion.postdetailapi.IPostDetailApi;
import com.transsion.room.api.IAudioApi;
import com.transsion.room.api.IFloatingApi;
import com.transsion.room.api.IRoomApi;
import com.transsion.room.api.RoomsViewType;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.user.action.sync.event.CommentEvent;
import com.transsion.usercenterapi.ReportType;
import com.transsion.web.api.WebConstants;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.LikeEvent;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public class SubjectListFragment extends PageStatusFragment<tu.g> implements qz.a {
    public static final a C = new a(null);
    public String A;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public zr.b f53560k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public BiddingListManager f53561l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.transsion.ad.bidding.nativead.c f53562m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AbsSubjectListViewModel f53563n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.transsion.moviedetail.adapter.d f53564o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public PostSubjectBean f53565p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public b1.b<Intent> f53566q;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public rw.b f53570u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f53571v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public com.transsion.ninegridview.a f53573x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Subject f53574y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f53575z;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f53567r = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.moviedetail.fragment.SubjectListFragment$mLoginApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ILoginApi invoke() {
            return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
        }
    });

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f53568s = LazyKt__LazyJVMKt.b(new Function0<IAudioApi>() { // from class: com.transsion.moviedetail.fragment.SubjectListFragment$mAudioApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IAudioApi invoke() {
            return (IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class);
        }
    });

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f53569t = LazyKt__LazyJVMKt.b(new Function0<IFloatingApi>() { // from class: com.transsion.moviedetail.fragment.SubjectListFragment$mFloatApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IFloatingApi invoke() {
            return (IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class);
        }
    });

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f53572w = LazyKt__LazyJVMKt.b(new Function0<IRoomApi>() { // from class: com.transsion.moviedetail.fragment.SubjectListFragment$mRoomApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IRoomApi invoke() {
            return (IRoomApi) com.alibaba.android.arouter.launcher.a.d().h(IRoomApi.class);
        }
    });
    public boolean B = true;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final SubjectListFragment a(Bundle params, Class<? extends AbsSubjectListViewModel> type) {
            Intrinsics.g(params, "params");
            Intrinsics.g(type, "type");
            SubjectListFragment subjectListFragment = new SubjectListFragment();
            params.putSerializable("view_model_type", type);
            subjectListFragment.setArguments(params);
            return subjectListFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements zr.a {
        public b() {
        }

        @Override // zr.a
        public void a(int i11, long j11, View view) {
            PostSubjectItem item;
            AbsSubjectListViewModel absSubjectListViewModelW0;
            PostListSource postListSourceR;
            SubjectListFragment subjectListFragment = SubjectListFragment.this;
            try {
                Result.Companion companion = Result.Companion;
                com.transsion.moviedetail.adapter.d dVar = subjectListFragment.f53564o;
                if (dVar != null && (item = dVar.getItem(i11)) != null) {
                    String strName = "";
                    if (subjectListFragment.f53564o != null) {
                        com.transsion.moviedetail.adapter.d dVar2 = subjectListFragment.f53564o;
                        strName = (dVar2 == null || (absSubjectListViewModelW0 = dVar2.W0()) == null || (postListSourceR = absSubjectListViewModelW0.r()) == null) ? null : postListSourceR.name();
                    }
                    com.transsion.postdetail.helper.a.f55063a.u(strName, subjectListFragment.N1(), subjectListFragment.S1(), i11, j11, item, (64 & 64) != 0 ? null : null);
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
    public static final class c extends RecyclerView.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f53577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f53578b;

        public c() {
        }

        private final void d(RecyclerView recyclerView) {
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                throw new RuntimeException("Unsupported layoutManager.");
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            this.f53577a = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            this.f53578b = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            com.transsion.moviedetail.adapter.d dVar;
            h9.f fVarQ;
            h9.f fVarQ2;
            Intrinsics.g(recyclerView, "recyclerView");
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            int childCount = layoutManager != null ? layoutManager.getChildCount() : 0;
            int itemCount = layoutManager != null ? layoutManager.getItemCount() : 0;
            if (i11 != 0 || childCount <= 0 || this.f53577a < itemCount - 1) {
                return;
            }
            com.transsion.moviedetail.adapter.d dVar2 = SubjectListFragment.this.f53564o;
            if (((dVar2 == null || (fVarQ2 = dVar2.Q()) == null) ? null : fVarQ2.i()) != LoadMoreStatus.Fail || (dVar = SubjectListFragment.this.f53564o) == null || (fVarQ = dVar.Q()) == null) {
                return;
            }
            fVarQ.v();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            Intrinsics.g(recyclerView, "recyclerView");
            d(recyclerView);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends DiffUtil.e<PostSubjectItem> {
        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(PostSubjectItem oldItem, PostSubjectItem newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(String.valueOf(oldItem.getPostId()), String.valueOf(newItem.getPostId()));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(PostSubjectItem oldItem, PostSubjectItem newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            Subject subject = oldItem.getSubject();
            String subjectId = subject != null ? subject.getSubjectId() : null;
            Subject subject2 = newItem.getSubject();
            return Intrinsics.b(subjectId, subject2 != null ? subject2.getSubjectId() : null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements com.transsion.share.share.e {
        public e() {
        }

        @Override // com.transsion.share.share.e
        public void a(String id2, PostType postType) {
            Intrinsics.g(id2, "id");
            AbsSubjectListViewModel absSubjectListViewModel = SubjectListFragment.this.f53563n;
            if (absSubjectListViewModel != null) {
                absSubjectListViewModel.d(id2);
            }
        }

        @Override // com.transsion.share.share.e
        public void b(String str) {
            uo.b.a.f(uo.b.f78622a, "MoveListFragment", "id" + str, false, 4, null);
            SubjectListFragment.this.P1(str);
        }

        @Override // com.transsion.share.share.e
        public void c(String url, String fileName, String fileSize, String fileImage) {
            Intrinsics.g(url, "url");
            Intrinsics.g(fileName, "fileName");
            Intrinsics.g(fileSize, "fileSize");
            Intrinsics.g(fileImage, "fileImage");
        }

        @Override // com.transsion.share.share.e
        public void d(String id2) {
            Intrinsics.g(id2, "id");
        }
    }

    private final void A1() {
        RecyclerView recyclerView;
        tu.g mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f77481b) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new c());
    }

    public static final void B1(SubjectListFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.G1();
    }

    public static final void C1(SubjectListFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 500L)) {
            return;
        }
        Object item = adapter.getItem(i11);
        if (item instanceof PostSubjectItem) {
            PostSubjectItem postSubjectItem = (PostSubjectItem) item;
            this$0.M1(postSubjectItem, false);
            AbsSubjectListViewModel absSubjectListViewModel = this$0.f53563n;
            if (absSubjectListViewModel != null) {
                absSubjectListViewModel.x(postSubjectItem, i11, this$0.S1());
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void D1(SubjectListFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        User user;
        User user2;
        User user3;
        User user4;
        Media media;
        Subject subject;
        Subject subject2;
        Subject subject3;
        Integer subjectType;
        AbsSubjectListViewModel absSubjectListViewModelW0;
        PostListSource postListSourceR;
        Group group;
        AbsSubjectListViewModel absSubjectListViewModel;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 500L)) {
            return;
        }
        Object item = adapter.getItem(i11);
        String nickname = null;
        groupId = null;
        String groupId = null;
        ops = null;
        String ops = null;
        str = null;
        String str = null;
        nickname = null;
        PostSubjectItem postSubjectItem = item instanceof PostSubjectItem ? (PostSubjectItem) item : null;
        int id2 = view.getId();
        if (id2 == R$id.v_post_share) {
            this$0.Q1(postSubjectItem);
            str = AppLovinEventTypes.USER_SHARED_LINK;
        } else if (id2 == R$id.v_post_like) {
            String str2 = (postSubjectItem == null || !Intrinsics.b(postSubjectItem.getHasLike(), Boolean.TRUE)) ? "like" : "dislike";
            this$0.F1(postSubjectItem != null ? postSubjectItem.getPostId() : null, postSubjectItem != null ? postSubjectItem.getHasLike() : null);
            str = str2;
        } else if (id2 == R$id.v_post_comment) {
            this$0.M1(postSubjectItem, true);
            str = "comment";
        } else if (id2 == R$id.tv_room_tag) {
            Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/room/detail");
            if (postSubjectItem != null && (group = postSubjectItem.getGroup()) != null) {
                groupId = group.getGroupId();
            }
            postcardB.withString("id", groupId).navigation();
            str = "group";
        } else if (id2 == R$id.fl_cover || id2 == R$id.tv_room_name || id2 == R$id.tv_post_date) {
            AbsSubjectListViewModel absSubjectListViewModel2 = this$0.f53563n;
            if ((absSubjectListViewModel2 != null ? absSubjectListViewModel2.s() : null) == ProfileSubSource.POSTS) {
                com.alibaba.android.arouter.launcher.a.d().b("/post/detail").withString(WebConstants.PAGE_FROM, this$0.N1()).withSerializable("item_object", postSubjectItem).withString("rec_ops", postSubjectItem != null ? postSubjectItem.getOps() : null).withString("id", postSubjectItem != null ? postSubjectItem.getPostId() : null).withString("item_type", postSubjectItem != null ? postSubjectItem.getItemType() : null).withString("media_type", (postSubjectItem == null || (media = postSubjectItem.getMedia()) == null) ? null : media.getMediaType()).navigation();
            } else {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId((postSubjectItem == null || (user4 = postSubjectItem.getUser()) == null) ? null : user4.getUserId());
                userInfo.setAvatar((postSubjectItem == null || (user3 = postSubjectItem.getUser()) == null) ? null : user3.getAvatar());
                userInfo.setUsername((postSubjectItem == null || (user2 = postSubjectItem.getUser()) == null) ? null : user2.getUsername());
                if (postSubjectItem != null && (user = postSubjectItem.getUser()) != null) {
                    nickname = user.getNickname();
                }
                userInfo.setNickname(nickname);
                com.alibaba.android.arouter.launcher.a.d().b("/profile/user_center").withSerializable("userInfo", userInfo).navigation();
                str = "user_center";
            }
        } else if (id2 == com.transsion.moviedetail.R$id.cl_audio) {
            this$0.R1(postSubjectItem);
            str = "audio_play";
        } else if (id2 == R$id.cl_subject_content) {
            com.transsion.moviedetail.adapter.d dVar = this$0.f53564o;
            if (dVar != null && (absSubjectListViewModelW0 = dVar.W0()) != null && (postListSourceR = absSubjectListViewModelW0.r()) != null) {
                postListSourceR.name();
            }
            Postcard postcardWithString = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail").withInt("subject_type", (postSubjectItem == null || (subject3 = postSubjectItem.getSubject()) == null || (subjectType = subject3.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue()).withString("id", (postSubjectItem == null || (subject2 = postSubjectItem.getSubject()) == null) ? null : subject2.getSubjectId());
            if (postSubjectItem != null && (subject = postSubjectItem.getSubject()) != null) {
                ops = subject.getOps();
            }
            postcardWithString.withString("ops", ops).navigation();
            str = "subject";
        }
        if (postSubjectItem == null || (absSubjectListViewModel = this$0.f53563n) == null) {
            return;
        }
        if (str == null) {
            str = "";
        }
        absSubjectListViewModel.y(postSubjectItem, i11, str, this$0.S1());
    }

    private final void G1() {
        RecyclerView recyclerView;
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            AbsSubjectListViewModel absSubjectListViewModel = this.f53563n;
            if (absSubjectListViewModel != null) {
                absSubjectListViewModel.u(false);
                return;
            }
            return;
        }
        zp.b.f82110a.d(R$string.no_network_tips);
        tu.g mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f77481b) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.moviedetail.fragment.p0
            @Override // java.lang.Runnable
            public final void run() {
                SubjectListFragment.H1(this.f53668a);
            }
        }, 500L);
    }

    public static final void H1(SubjectListFragment this$0) {
        h9.f fVarQ;
        Intrinsics.g(this$0, "this$0");
        com.transsion.moviedetail.adapter.d dVar = this$0.f53564o;
        if (dVar == null || (fVarQ = dVar.Q()) == null) {
            return;
        }
        fVarQ.u();
    }

    private final void I1() {
        zr.b bVar = this.f53560k;
        if (bVar != null) {
            bVar.f();
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        com.transsion.postdetail.helper.a.f55063a.p(N1(), S1(), jElapsedRealtime - (logViewConfig != null ? logViewConfig.h() : 0L), getLogViewConfig());
    }

    private final void J1() {
        Function1<CommentEvent, Unit> function1 = new Function1<CommentEvent, Unit>() { // from class: com.transsion.moviedetail.fragment.SubjectListFragment$observeComment$1
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
                List<PostSubjectItem> listD;
                List<PostSubjectItem> listD2;
                Intrinsics.g(value, "value");
                try {
                    com.transsion.moviedetail.adapter.d dVar = this.this$0.f53564o;
                    int i11 = -1;
                    if (dVar != null && (listD2 = dVar.D()) != null) {
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
                        com.transsion.moviedetail.adapter.d dVar2 = this.this$0.f53564o;
                        PostSubjectItem postSubjectItem = (dVar2 == null || (listD = dVar2.D()) == null) ? null : listD.get(i11);
                        if (postSubjectItem != null && (stat = postSubjectItem.getStat()) != null) {
                            try {
                                if (value.getStatus()) {
                                    Long commentCount = stat.getCommentCount();
                                    stat.setCommentCount(Long.valueOf((commentCount != null ? commentCount.longValue() : 0L) + 1));
                                } else {
                                    Long commentCount2 = stat.getCommentCount();
                                    stat.setCommentCount(Long.valueOf((commentCount2 != null ? commentCount2.longValue() : 1L) - 1));
                                }
                            } catch (Exception e11) {
                                uo.b.a.g(uo.b.f78622a, " callback change data fail " + e11.getMessage(), false, 2, null);
                            }
                        }
                        com.transsion.moviedetail.adapter.d dVar3 = this.this$0.f53564o;
                        if (dVar3 != null) {
                            com.transsion.moviedetail.adapter.d dVar4 = this.this$0.f53564o;
                            dVar3.notifyItemChanged(i11 + (dVar4 != null ? dVar4.K() : 0));
                        }
                    }
                } catch (Exception e12) {
                    uo.b.a.g(uo.b.f78622a, " callback change data fail " + e12.getMessage(), false, 2, null);
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = CommentEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.w0.c().q(), false, function1);
    }

    private final void K1() {
        Function1<j00.b, Unit> function1 = new Function1<j00.b, Unit>() { // from class: com.transsion.moviedetail.fragment.SubjectListFragment$observeDelete$1
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
                com.transsion.moviedetail.adapter.d dVar;
                List<PostSubjectItem> listD;
                Intrinsics.g(value, "value");
                try {
                    com.transsion.moviedetail.adapter.d dVar2 = this.this$0.f53564o;
                    int i11 = -1;
                    if (dVar2 != null && (listD = dVar2.D()) != null) {
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
                    if (i11 >= 0 && (dVar = this.this$0.f53564o) != null) {
                        dVar.k0(i11);
                    }
                    this.this$0.l1();
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

    private final void L1() {
        Function1<LikeEvent, Unit> function1 = new Function1<LikeEvent, Unit>() { // from class: com.transsion.moviedetail.fragment.SubjectListFragment$observeLike$1
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
                    com.transsion.moviedetail.adapter.d dVar = this.this$0.f53564o;
                    if (dVar != null && (listD2 = dVar.D()) != null) {
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
                        com.transsion.moviedetail.adapter.d dVar2 = this.this$0.f53564o;
                        PostSubjectItem postSubjectItem = (dVar2 == null || (listD = dVar2.D()) == null) ? null : listD.get(i11);
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
                        com.transsion.moviedetail.adapter.d dVar3 = this.this$0.f53564o;
                        if (dVar3 != null) {
                            com.transsion.moviedetail.adapter.d dVar4 = this.this$0.f53564o;
                            dVar3.notifyItemChanged(i11 + (dVar4 != null ? dVar4.K() : 0), Boolean.valueOf(value.getLike()));
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

    /* JADX INFO: Access modifiers changed from: private */
    public final String N1() {
        String str = this.A;
        return str == null ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P1(String str) {
        com.transsion.moviedetail.adapter.d dVar = this.f53564o;
        if (dVar != null) {
            int i11 = 0;
            for (Object obj : dVar.D()) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.g.u();
                }
                if (Intrinsics.b(((PostSubjectItem) obj).getPostId(), str)) {
                    if (dVar.getItemCount() > 2) {
                        dVar.D().remove(i11);
                        dVar.notifyDataSetChanged();
                        return;
                    } else {
                        dVar.D().clear();
                        dVar.notifyDataSetChanged();
                        l1();
                        return;
                    }
                }
                i11 = i12;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String S1() {
        AbsSubjectListViewModel absSubjectListViewModel = this.f53563n;
        if (absSubjectListViewModel != null) {
            ProfileSubSource profileSubSourceS = absSubjectListViewModel.s();
            String value = profileSubSourceS != null ? profileSubSourceS.getValue() : null;
            if (value != null) {
                return value;
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T1(BaseDto<String> baseDto) {
        List<PostSubjectItem> listD;
        List<PostSubjectItem> listD2;
        List<PostSubjectItem> listD3;
        if (!Intrinsics.b(baseDto != null ? baseDto.getCode() : null, "0")) {
            zp.b.f82110a.e(getString(com.transsion.moviedetail.R$string.delete_post_failed));
            return;
        }
        com.transsion.moviedetail.adapter.d dVar = this.f53564o;
        List<PostSubjectItem> listD4 = dVar != null ? dVar.D() : null;
        if (listD4 != null) {
            int i11 = 0;
            for (Object obj : listD4) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.g.u();
                }
                PostSubjectItem postSubjectItem = (PostSubjectItem) obj;
                if (Intrinsics.b(postSubjectItem.getPostId(), baseDto.getData())) {
                    com.transsion.moviedetail.adapter.d dVar2 = this.f53564o;
                    if (dVar2 == null || (listD2 = dVar2.D()) == null || listD2.size() != 1) {
                        com.transsion.moviedetail.adapter.d dVar3 = this.f53564o;
                        if (dVar3 != null) {
                            dVar3.notifyItemRemoved(i11);
                        }
                        com.transsion.moviedetail.adapter.d dVar4 = this.f53564o;
                        if (dVar4 == null || (listD = dVar4.D()) == null) {
                            return;
                        }
                        listD.remove(postSubjectItem);
                        return;
                    }
                    com.transsion.moviedetail.adapter.d dVar5 = this.f53564o;
                    if (dVar5 != null && (listD3 = dVar5.D()) != null) {
                        listD3.remove(postSubjectItem);
                    }
                    com.transsion.moviedetail.adapter.d dVar6 = this.f53564o;
                    if (dVar6 != null) {
                        dVar6.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                i11 = i12;
            }
        }
    }

    private final IRoomApi getMRoomApi() {
        return (IRoomApi) this.f53572w.getValue();
    }

    private final void initPlayer() {
        RecyclerView recyclerView;
        com.transsion.ninegridview.a aVar = new com.transsion.ninegridview.a();
        tu.g mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f77481b) != null) {
            Intrinsics.f(recyclerView, "this");
            aVar.n(recyclerView, this.f53564o);
        }
        this.f53573x = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1() {
        PostSubjectItem postSubjectItemR1;
        rw.b bVar;
        View view;
        Unit unit;
        rw.b bVar2;
        View view2;
        String value;
        ProfileSubSource profileSubSourceS;
        RecyclerView recyclerView;
        tu.g mViewBinding;
        RecyclerView recyclerView2;
        com.transsion.moviedetail.adapter.d dVar = this.f53564o;
        if (dVar == null || dVar.getItemCount() != 0) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            tu.g mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (recyclerView = mViewBinding2.f77481b) != null && recyclerView.getItemDecorationCount() == 0 && (mViewBinding = getMViewBinding()) != null && (recyclerView2 = mViewBinding.f77481b) != null) {
                recyclerView2.addItemDecoration(new ro.g(com.blankj.utilcode.util.f0.a(16.0f), 0));
            }
            Context context = getContext();
            Unit unit2 = null;
            if (context != null) {
                if (this.f53570u == null) {
                    IRoomApi mRoomApi = getMRoomApi();
                    Intrinsics.f(context, "context");
                    this.f53570u = mRoomApi.O0(context, RoomsViewType.TYPE_SUBJECT_DETAIL);
                }
                AbsSubjectListViewModel absSubjectListViewModel = this.f53563n;
                if (absSubjectListViewModel instanceof HotViewModel) {
                    Intrinsics.e(absSubjectListViewModel, "null cannot be cast to non-null type com.transsion.moviedetail.viewmodel.HotViewModel");
                    RoomBean roomBeanF = ((HotViewModel) absSubjectListViewModel).O().f();
                    if (roomBeanF != null && (postSubjectItemR1 = r1(roomBeanF)) != null) {
                        List<RoomItem> roomList = postSubjectItemR1.getRoomList();
                        if (roomList != null) {
                            rw.b bVar3 = this.f53570u;
                            if (bVar3 != null) {
                                String strN1 = N1();
                                AbsSubjectListViewModel absSubjectListViewModel2 = this.f53563n;
                                if (absSubjectListViewModel2 == null || (profileSubSourceS = absSubjectListViewModel2.s()) == null || (value = profileSubSourceS.getValue()) == null) {
                                    value = ProfileSubSource.COMMENTS.getValue();
                                }
                                bVar3.setReportName(strN1, value);
                            }
                            rw.b bVar4 = this.f53570u;
                            if (bVar4 != null) {
                                bVar4.setList(roomList);
                                unit = Unit.f68710a;
                            } else {
                                unit = null;
                            }
                            if (unit != null && (bVar2 = this.f53570u) != null && (view2 = bVar2.getView()) != null) {
                                so.c.g(view2);
                                unit2 = Unit.f68710a;
                            }
                        }
                        if (unit2 != null && (bVar = this.f53570u) != null && (view = bVar.getView()) != null) {
                            so.c.g(view);
                        }
                    }
                }
                com.transsion.moviedetail.adapter.d dVar2 = this.f53564o;
                if (dVar2 != null) {
                    dVar2.r0(l0(false));
                }
                com.transsion.moviedetail.adapter.d dVar3 = this.f53564o;
                if (dVar3 != null) {
                    dVar3.E0(true);
                }
                unit2 = Unit.f68710a;
            }
            Result.m163constructorimpl(unit2);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    private final void lazyLoadData() {
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            com.transsion.moviedetail.adapter.d dVar = this.f53564o;
            if (dVar != null) {
                dVar.r0(r0(false));
                return;
            }
            return;
        }
        K0();
        AbsSubjectListViewModel absSubjectListViewModel = this.f53563n;
        if (absSubjectListViewModel instanceof HotViewModel) {
            Intrinsics.e(absSubjectListViewModel, "null cannot be cast to non-null type com.transsion.moviedetail.viewmodel.HotViewModel");
            HotViewModel.N((HotViewModel) absSubjectListViewModel, null, 0, 3, null);
        } else if (absSubjectListViewModel != null) {
            absSubjectListViewModel.u(true);
        }
    }

    public static final void m1(SubjectListFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.E0();
    }

    private final ILoginApi p1() {
        return (ILoginApi) this.f53567r.getValue();
    }

    private final float q1() {
        Float fK;
        ConfigBean configBeanC = ConfigManager.c(ConfigManager.f53111c.a(), "sa_post_exposure_percent", false, 2, null);
        String value = configBeanC != null ? configBeanC.getValue() : null;
        if (value == null || value.length() == 0 || (fK = kotlin.text.j.k(value)) == null) {
            return 0.6f;
        }
        return fK.floatValue();
    }

    private final void t1() {
        AbsSubjectListViewModel absSubjectListViewModel = this.f53563n;
        if ((absSubjectListViewModel != null ? absSubjectListViewModel.r() : null) != PostListSource.SUBJECT) {
            return;
        }
        BiddingListManager biddingListManager = new BiddingListManager();
        this.f53561l = biddingListManager;
        tu.g mViewBinding = getMViewBinding();
        biddingListManager.F(mViewBinding != null ? mViewBinding.f77481b : null);
        BiddingListManager biddingListManager2 = this.f53561l;
        if (biddingListManager2 != null) {
            biddingListManager2.A(androidx.lifecycle.v.a(this));
        }
        BiddingListManager biddingListManager3 = this.f53561l;
        if (biddingListManager3 != null) {
            biddingListManager3.G("SubjectDetailRecommendScene");
        }
        BiddingListManager biddingListManager4 = this.f53561l;
        if (biddingListManager4 != null) {
            biddingListManager4.z(new Function2<Integer, com.transsion.ad.bidding.nativead.c, Unit>() { // from class: com.transsion.moviedetail.fragment.SubjectListFragment$initAd$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, com.transsion.ad.bidding.nativead.c cVar) {
                    invoke(num.intValue(), cVar);
                    return Unit.f68710a;
                }

                public final void invoke(int i11, com.transsion.ad.bidding.nativead.c current) {
                    List<PostSubjectItem> listD;
                    Intrinsics.g(current, "current");
                    if (current != null) {
                        SubjectListFragment subjectListFragment = this.this$0;
                        PostSubjectItem postSubjectItem = new PostSubjectItem(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, null, false, null, false, 1073741823, null);
                        postSubjectItem.setNonAdDelegate(current);
                        com.transsion.moviedetail.adapter.d dVar = subjectListFragment.f53564o;
                        int size = (dVar == null || (listD = dVar.D()) == null) ? 0 : listD.size();
                        if (i11 <= size) {
                            com.transsion.moviedetail.adapter.d dVar2 = subjectListFragment.f53564o;
                            if (dVar2 != null) {
                                dVar2.j(i11, postSubjectItem);
                                return;
                            }
                            return;
                        }
                        com.transsion.moviedetail.adapter.d dVar3 = subjectListFragment.f53564o;
                        if (dVar3 != null) {
                            dVar3.j(size, postSubjectItem);
                        }
                    }
                }
            });
        }
    }

    private final void v1() {
        RecyclerView recyclerView;
        float fQ1 = q1();
        uo.b.a.f(uo.b.f78622a, "PostList", "initExposureHelper, postExposurePercent:" + fQ1, false, 4, null);
        zr.b bVar = new zr.b(fQ1, new b(), false, 4, null);
        bVar.n(2);
        tu.g mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f77481b) != null) {
            recyclerView.addOnScrollListener(bVar);
        }
        this.f53560k = bVar;
    }

    private final void w1() {
        this.f53566q = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.transsion.moviedetail.fragment.o0
            @Override // b1.a
            public final void a(Object obj) {
                SubjectListFragment.x1(this.f53666a, (ActivityResult) obj);
            }
        });
    }

    public static final void x1(SubjectListFragment this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            Serializable serializableExtra = data != null ? data.getSerializableExtra(MimeTypes.BASE_TYPE_AUDIO) : null;
            if (serializableExtra instanceof AudioBean) {
                uo.b.a.f(uo.b.f78622a, "MoveListFragment", "showFloating", false, 4, null);
                ((IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class)).y(new WeakReference<>(this$0.requireActivity()), (AudioBean) serializableExtra);
            }
            Intent data2 = activityResult.getData();
            this$0.P1(data2 != null ? data2.getStringExtra("id") : null);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        lazyLoadData();
    }

    public final void E1() {
        List arrayList;
        AbsSubjectListViewModel absSubjectListViewModel = this.f53563n;
        if ((absSubjectListViewModel != null ? absSubjectListViewModel.r() : null) == PostListSource.SUBJECT) {
            com.transsion.moviedetail.adapter.d dVar = this.f53564o;
            if (dVar == null || (arrayList = dVar.D()) == null) {
                arrayList = new ArrayList();
            }
            if (arrayList.size() <= wq.a.f(wq.a.f79581a, "SubjectDetailRecommendScene", 0, 2, null)) {
                kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this), null, null, new SubjectListFragment$insertLast$1(this, arrayList, null), 3, null);
            }
        }
    }

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
    public final void F1(String str, Boolean bool) {
        boolean zB = Intrinsics.b(bool, Boolean.TRUE);
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.no_network_tips);
            return;
        }
        AbsSubjectListViewModel absSubjectListViewModel = this.f53563n;
        if (absSubjectListViewModel != null) {
            absSubjectListViewModel.t(str, zB ? 1 : 0);
        }
    }

    public final void M1(PostSubjectItem postSubjectItem, boolean z11) {
        Media media;
        IPostDetailApi iPostDetailApi = (IPostDetailApi) com.alibaba.android.arouter.launcher.a.d().h(IPostDetailApi.class);
        AbsSubjectListViewModel absSubjectListViewModel = this.f53563n;
        PostListSource postListSourceR = absSubjectListViewModel != null ? absSubjectListViewModel.r() : null;
        PostListSource postListSource = PostListSource.PROFILE;
        if (postListSourceR != postListSource && postSubjectItem != null) {
            iPostDetailApi.f0(postSubjectItem);
        }
        Postcard postcardWithBoolean = com.alibaba.android.arouter.launcher.a.d().b("/post/detail").withString(WebConstants.PAGE_FROM, N1()).withSerializable("item_object", postSubjectItem).withString("rec_ops", postSubjectItem != null ? postSubjectItem.getOps() : null).withString("id", postSubjectItem != null ? postSubjectItem.getPostId() : null).withString("item_type", postSubjectItem != null ? postSubjectItem.getItemType() : null).withString("media_type", (postSubjectItem == null || (media = postSubjectItem.getMedia()) == null) ? null : media.getMediaType()).withBoolean("from_comment", z11);
        AbsSubjectListViewModel absSubjectListViewModel2 = this.f53563n;
        postcardWithBoolean.withBoolean("video_load_more", (absSubjectListViewModel2 != null ? absSubjectListViewModel2.r() : null) != postListSource).navigation();
    }

    public final void O1() {
        AbsSubjectListViewModel absSubjectListViewModel = this.f53563n;
        if (absSubjectListViewModel != null) {
            absSubjectListViewModel.v(getArguments());
        }
        com.transsion.moviedetail.adapter.d dVar = this.f53564o;
        if (dVar != null) {
            dVar.V0();
        }
        com.transsion.ninegridview.a aVar = this.f53573x;
        if (aVar != null) {
            aVar.m();
        }
        lazyLoadData();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002e  */
    public final void Q1(PostSubjectItem postSubjectItem) {
        boolean z11;
        User user;
        User user2;
        UserInfo userInfoP = p1().P();
        if ((userInfoP != null ? userInfoP.getUserId() : null) != null) {
            if (Intrinsics.b(userInfoP.getUserId(), (postSubjectItem == null || (user2 = postSubjectItem.getUser()) == null) ? null : user2.getUserId())) {
                z11 = true;
            } else {
                z11 = false;
            }
        } else {
            z11 = false;
        }
        ShareDialogFragment shareDialogFragmentA = ShareDialogFragment.f57724t.a(PostType.POST_TYPE, postSubjectItem != null ? postSubjectItem.getPostId() : null, (postSubjectItem == null || (user = postSubjectItem.getUser()) == null) ? null : user.getUserId(), ReportType.POST.getValue(), (3072 & 16) != 0 ? "" : postSubjectItem != null ? postSubjectItem.getTitle() : null, (3072 & 32) != 0 ? "" : "", (3072 & 64) != 0 ? false : false, (3072 & 128) != 0 ? false : z11, (3072 & 256) != 0 ? false : false, "postdetail", (3072 & 1024) != 0 ? "" : null, (3072 & 2048) != 0 ? "" : null);
        shareDialogFragmentA.E0(new e());
        shareDialogFragmentA.show(getChildFragmentManager(), AppLovinEventTypes.USER_SHARED_LINK);
    }

    public final void R1(PostSubjectItem postSubjectItem) {
        String url;
        Integer size;
        List<Audio> audio;
        if (postSubjectItem != null) {
            String coverUrl$default = PostSubjectItem.getCoverUrl$default(postSubjectItem, false, 1, null);
            Media media = postSubjectItem.getMedia();
            Audio audio2 = (media == null || (audio = media.getAudio()) == null || !(true ^ audio.isEmpty())) ? null : audio.get(0);
            if (audio2 == null || (url = audio2.getUrl()) == null) {
                url = "";
            }
            Long duration = audio2 != null ? audio2.getDuration() : null;
            Long lValueOf = (audio2 == null || (size = audio2.getSize()) == null) ? null : Long.valueOf(size.intValue());
            String url2 = audio2 != null ? audio2.getUrl() : null;
            String title = postSubjectItem.getTitle();
            String content = postSubjectItem.getContent();
            if (content == null) {
                content = "";
            }
            Integer bitrate = audio2 != null ? audio2.getBitrate() : null;
            String postId = postSubjectItem.getPostId();
            Subject subject = postSubjectItem.getSubject();
            String subjectId = subject != null ? subject.getSubjectId() : null;
            Subject subject2 = postSubjectItem.getSubject();
            String title2 = subject2 != null ? subject2.getTitle() : null;
            Group group = postSubjectItem.getGroup();
            AudioBean audioBean = new AudioBean(url, coverUrl$default, duration, lValueOf, url2, title, content, bitrate, null, null, null, null, null, postId, subjectId, group != null ? group.getGroupId() : null, 0, title2, 0, 0, 859904, null);
            IFloatingApi iFloatingApiO1 = o1();
            if (iFloatingApiO1 != null) {
                iFloatingApiO1.y(new WeakReference<>((Activity) getContext()), audioBean);
            }
            audioBean.setOps(postSubjectItem.getRec_ops());
            IAudioApi iAudioApiN1 = n1();
            if (iAudioApiN1 != null) {
                IAudioApi.a.a(iAudioApiN1, audioBean, false, 2, null);
            }
        }
    }

    public final void U1(LikeBean likeBean) {
        List<PostSubjectItem> listD;
        com.transsion.moviedetail.adapter.d dVar = this.f53564o;
        if (dVar == null || (listD = dVar.D()) == null) {
            return;
        }
        int i11 = 0;
        for (Object obj : listD) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            PostSubjectItem postSubjectItem = (PostSubjectItem) obj;
            if (Intrinsics.b(likeBean.isAffected(), Boolean.TRUE) && Intrinsics.b(postSubjectItem.getPostId(), likeBean.getPostId())) {
                Boolean hasLike = postSubjectItem.getHasLike();
                postSubjectItem.setHasLike(hasLike != null ? Boolean.valueOf(!hasLike.booleanValue()) : null);
                Stat stat = postSubjectItem.getStat();
                if (stat != null) {
                    Integer likes = likeBean.getLikes();
                    stat.setLikeCount(likes != null ? Long.valueOf(likes.intValue()) : null);
                }
                com.transsion.moviedetail.adapter.d dVar2 = this.f53564o;
                if (dVar2 != null) {
                    dVar2.notifyItemChanged(i11);
                    return;
                }
                return;
            }
            i11 = i12;
        }
    }

    public final void V1(PostSubjectBean postSubjectBean) {
        List arrayList;
        PostSubjectItem postSubjectItemR1;
        h9.f fVarQ;
        Pager pager;
        Object objM163constructorimpl;
        h9.f fVarQ2;
        h9.f fVarQ3;
        com.transsion.moviedetail.adapter.d dVar;
        h9.f fVarQ4;
        h9.f fVarQ5;
        com.transsion.moviedetail.adapter.d dVar2;
        h9.f fVarQ6;
        if (postSubjectBean == null) {
            com.transsion.moviedetail.adapter.d dVar3 = this.f53564o;
            if (dVar3 != null && (fVarQ5 = dVar3.Q()) != null && fVarQ5.q() && (dVar2 = this.f53564o) != null && (fVarQ6 = dVar2.Q()) != null) {
                fVarQ6.u();
            }
        } else {
            if (postSubjectBean.getSubject() != null) {
                this.f53574y = postSubjectBean.getSubject();
            }
            List<PostSubjectItem> items = postSubjectBean.getItems();
            if (items != null) {
                com.transsion.moviedetail.adapter.d dVar4 = this.f53564o;
                if (dVar4 == null || (arrayList = dVar4.D()) == null) {
                    arrayList = new ArrayList();
                }
                ArrayList arrayList2 = new ArrayList();
                if (!arrayList.isEmpty()) {
                    for (PostSubjectItem postSubjectItem : items) {
                        if (!arrayList.contains(postSubjectItem)) {
                            Subject subject = this.f53574y;
                            if (subject != null) {
                                postSubjectItem.setSubject(subject);
                            }
                            arrayList2.add(postSubjectItem);
                        }
                    }
                } else {
                    for (PostSubjectItem postSubjectItem2 : items) {
                        Subject subject2 = this.f53574y;
                        if (subject2 != null) {
                            postSubjectItem2.setSubject(subject2);
                        }
                    }
                    arrayList2.addAll(items);
                }
                if (arrayList2.isEmpty()) {
                    com.transsion.moviedetail.adapter.d dVar5 = this.f53564o;
                    if (dVar5 != null && (fVarQ = dVar5.Q()) != null) {
                        h9.f.t(fVarQ, false, 1, null);
                    }
                    l1();
                    return;
                }
                if (this.f53563n instanceof HotViewModel) {
                    com.transsion.moviedetail.adapter.d dVar6 = this.f53564o;
                    List<PostSubjectItem> listD = dVar6 != null ? dVar6.D() : null;
                    if (listD == null || listD.isEmpty()) {
                        AbsSubjectListViewModel absSubjectListViewModel = this.f53563n;
                        Intrinsics.e(absSubjectListViewModel, "null cannot be cast to non-null type com.transsion.moviedetail.viewmodel.HotViewModel");
                        RoomBean roomBeanF = ((HotViewModel) absSubjectListViewModel).O().f();
                        if (roomBeanF != null && (postSubjectItemR1 = r1(roomBeanF)) != null) {
                            arrayList2.add(0, postSubjectItemR1);
                        }
                    }
                }
                com.transsion.moviedetail.adapter.d dVar7 = this.f53564o;
                if (dVar7 != null) {
                    dVar7.m(arrayList2);
                }
            }
        }
        com.transsion.moviedetail.adapter.d dVar8 = this.f53564o;
        if (dVar8 != null && (fVarQ3 = dVar8.Q()) != null && fVarQ3.q() && (dVar = this.f53564o) != null && (fVarQ4 = dVar.Q()) != null) {
            fVarQ4.r();
        }
        if (postSubjectBean != null && (pager = postSubjectBean.getPager()) != null && Intrinsics.b(pager.getHasMore(), Boolean.FALSE)) {
            com.transsion.moviedetail.adapter.d dVar9 = this.f53564o;
            if (dVar9 != null && (fVarQ2 = dVar9.Q()) != null) {
                fVarQ2.s(false);
            }
            try {
                Result.Companion companion = Result.Companion;
                E1();
                objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
            }
            Result.m166exceptionOrNullimpl(objM163constructorimpl);
        }
        l1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        v1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View l0(boolean z11) {
        if (this.f53571v == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.layout_hot_empty_view, (ViewGroup) null);
            tu.w wVarA = tu.w.a(viewInflate);
            Intrinsics.f(wVarA, "bind(this)");
            if (this.f53563n instanceof HotViewModel) {
                if (this.f53570u == null) {
                    IRoomApi mRoomApi = getMRoomApi();
                    Context context = viewInflate.getContext();
                    Intrinsics.f(context, "this.context");
                    this.f53570u = mRoomApi.O0(context, RoomsViewType.TYPE_SUBJECT_DETAIL);
                }
                FrameLayout frameLayout = wVarA.f77648c;
                rw.b bVar = this.f53570u;
                Intrinsics.d(bVar);
                frameLayout.addView(bVar.getView());
            }
            FrameLayout frameLayout2 = wVarA.f77647b;
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            StateView stateView = new StateView(contextRequireContext);
            stateView.showData(2, 2, z11, t0(), k0());
            frameLayout2.addView(stateView);
            this.f53571v = viewInflate;
        }
        View view = this.f53571v;
        Intrinsics.d(view);
        return view;
    }

    public final IAudioApi n1() {
        return (IAudioApi) this.f53568s.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(N1(), false, 2, null);
    }

    @Override // qz.a
    public void o(boolean z11) {
        if (isAdded() && !isHidden() && isResumed()) {
            if (!z11) {
                logResume();
            } else {
                logPause();
                I1();
            }
        }
    }

    public final IFloatingApi o1() {
        return (IFloatingApi) this.f53569t.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, com.tn.lib.util.networkinfo.g
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        List<PostSubjectItem> listD;
        Intrinsics.g(network, "network");
        Intrinsics.g(networkCapabilities, "networkCapabilities");
        super.onConnected(network, networkCapabilities);
        com.transsion.moviedetail.adapter.d dVar = this.f53564o;
        if (dVar == null || (listD = dVar.D()) == null || !listD.isEmpty()) {
            G1();
        } else {
            lazyLoadData();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        HashMap<String, String> mapG;
        com.transsion.baselib.report.h logViewConfig;
        HashMap<String, String> mapG2;
        String strQ;
        super.onCreate(bundle);
        try {
            Bundle arguments = getArguments();
            Serializable serializable = arguments != null ? arguments.getSerializable("view_model_type") : null;
            Intrinsics.e(serializable, "null cannot be cast to non-null type java.lang.Class<com.transsion.moviedetailapi.AbsSubjectListViewModel>");
            AbsSubjectListViewModel absSubjectListViewModel = (AbsSubjectListViewModel) new androidx.lifecycle.v0(this).a((Class) serializable);
            this.f53563n = absSubjectListViewModel;
            if (absSubjectListViewModel != null) {
                absSubjectListViewModel.v(getArguments());
            }
            Bundle arguments2 = getArguments();
            this.A = arguments2 != null ? arguments2.getString("page_name") : null;
            AbsSubjectListViewModel absSubjectListViewModel2 = this.f53563n;
            if (absSubjectListViewModel2 != null) {
                absSubjectListViewModel2.B(com.transsion.baselib.report.m.f51277a.f());
            }
            if ((this.f53563n instanceof HotViewModel) && (logViewConfig = getLogViewConfig()) != null && (mapG2 = logViewConfig.g()) != null) {
                AbsSubjectListViewModel absSubjectListViewModel3 = this.f53563n;
                HotViewModel hotViewModel = absSubjectListViewModel3 instanceof HotViewModel ? (HotViewModel) absSubjectListViewModel3 : null;
                if (hotViewModel == null || (strQ = hotViewModel.Q()) == null) {
                    strQ = "";
                }
                mapG2.put("subject_id", strQ);
            }
        } catch (Exception unused) {
        }
        com.transsion.baselib.report.h logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 == null || (mapG = logViewConfig2.g()) == null) {
            return;
        }
        mapG.put("subpage_name", S1());
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        com.transsion.ninegridview.a aVar = this.f53573x;
        if (aVar != null) {
            aVar.f();
        }
        super.onDestroy();
        b1.b<Intent> bVar = this.f53566q;
        if (bVar != null) {
            bVar.c();
        }
        BiddingListManager biddingListManager = this.f53561l;
        if (biddingListManager != null) {
            biddingListManager.o();
        }
        com.transsion.ad.bidding.nativead.c cVar = this.f53562m;
        if (cVar != null) {
            cVar.F();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (isResumed()) {
            if (z11) {
                logPause();
                I1();
            } else {
                logResume();
            }
        }
        com.transsion.baseui.activity.d.h(null, this, z11, null, 9, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        I1();
        com.transsion.ninegridview.a aVar = this.f53573x;
        if (aVar != null) {
            aVar.k();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.transsion.ninegridview.a aVar = this.f53573x;
        if (aVar != null) {
            aVar.l();
        }
        if (this.B) {
            this.B = false;
            lazyLoadData();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View p0() {
        return LayoutInflater.from(requireContext()).inflate(R$layout.layout_commnets_loading_view, (ViewGroup) o0(), false);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View r0(boolean z11) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.layout_state_view, (ViewGroup) null);
        tu.x xVarA = tu.x.a(viewInflate);
        Intrinsics.f(xVarA, "bind(this)");
        xVarA.f77652d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubjectListFragment.m1(this.f53664a, view);
            }
        });
        Intrinsics.f(viewInflate, "from(context).inflate(R.…)\n            }\n        }");
        return viewInflate;
    }

    public final PostSubjectItem r1(RoomBean roomBean) {
        List<PostSubjectItem> listD;
        PostSubjectItem postSubjectItem;
        List<RoomItem> items = roomBean != null ? roomBean.getItems() : null;
        List<RoomItem> list = items;
        if (list == null || list.isEmpty()) {
            return null;
        }
        com.transsion.moviedetail.adapter.d dVar = this.f53564o;
        if (dVar != null && (listD = dVar.D()) != null && (postSubjectItem = (PostSubjectItem) CollectionsKt___CollectionsKt.g0(listD)) != null && postSubjectItem.isRoomList()) {
            return null;
        }
        if (items.size() > 3) {
            items = items.subList(0, 3);
        }
        PostSubjectItem postSubjectItem2 = new PostSubjectItem(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, null, false, null, false, 1073741823, null);
        postSubjectItem2.setRoomList(true);
        postSubjectItem2.setRoomList(items);
        return postSubjectItem2;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: s1, reason: merged with bridge method [inline-methods] */
    public tu.g getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        tu.g gVarC = tu.g.c(inflater);
        Intrinsics.f(gVarC, "inflate(inflater)");
        return gVarC;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    public final void u1() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        RecyclerView recyclerView;
        t1();
        tu.g mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f77481b) != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        }
        com.transsion.moviedetail.adapter.d dVar = new com.transsion.moviedetail.adapter.d(new ArrayList(), this.f53563n, N1(), com.transsion.baselib.report.m.f51277a.f());
        h9.f fVarQ = dVar.Q();
        fVarQ.B(new SubjectCommentsLoadMoreView());
        fVarQ.y(true);
        fVarQ.C(new f9.f() { // from class: com.transsion.moviedetail.fragment.k0
            @Override // f9.f
            public final void a() {
                SubjectListFragment.B1(this.f53657a);
            }
        });
        dVar.o0(new d());
        dVar.B0(new f9.d() { // from class: com.transsion.moviedetail.fragment.l0
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                SubjectListFragment.C1(this.f53660a, baseQuickAdapter, view, i11);
            }
        });
        A1();
        dVar.i(R$id.fl_cover, R$id.tv_room_name, R$id.tv_post_date, R$id.v_post_like, R$id.v_post_comment, R$id.v_post_share, R$id.cl_subject_content, R$id.tv_room_tag);
        dVar.z0(new f9.b() { // from class: com.transsion.moviedetail.fragment.m0
            @Override // f9.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                SubjectListFragment.D1(this.f53662a, baseQuickAdapter, view, i11);
            }
        });
        this.f53564o = dVar;
        tu.g mViewBinding2 = getMViewBinding();
        RecyclerView recyclerView2 = mViewBinding2 != null ? mViewBinding2.f77481b : null;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.f53564o);
        }
        z1();
        u1();
        K1();
        L1();
        J1();
        w1();
        initPlayer();
        y1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }

    public final void y1() {
        RecyclerView recyclerView;
        AbsSubjectListViewModel absSubjectListViewModel = this.f53563n;
        if (absSubjectListViewModel != null) {
            if ((absSubjectListViewModel != null ? absSubjectListViewModel.r() : null) != PostListSource.SUBJECT) {
                return;
            }
            ListVideoPreloadHelper listVideoPreloadHelper = new ListVideoPreloadHelper(0.75f, new Function1<Integer, PostSubjectItem>() { // from class: com.transsion.moviedetail.fragment.SubjectListFragment$initListVideoPreload$1
                {
                    super(1);
                }

                public final PostSubjectItem invoke(int i11) {
                    List<PostSubjectItem> listD;
                    try {
                        com.transsion.moviedetail.adapter.d dVar = this.this$0.f53564o;
                        if (dVar == null || (listD = dVar.D()) == null) {
                            return null;
                        }
                        return listD.get(i11);
                    } catch (Throwable unused) {
                        return null;
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ PostSubjectItem invoke(Integer num) {
                    return invoke(num.intValue());
                }
            });
            tu.g mViewBinding = getMViewBinding();
            if (mViewBinding == null || (recyclerView = mViewBinding.f77481b) == null) {
                return;
            }
            recyclerView.addOnScrollListener(listVideoPreloadHelper);
        }
    }

    public final void z1() {
        AbsSubjectListViewModel absSubjectListViewModel = this.f53563n;
        if (absSubjectListViewModel != null) {
            if (absSubjectListViewModel instanceof HotViewModel) {
                ((HotViewModel) absSubjectListViewModel).O().j(this, new r0(new Function1<RoomBean, Unit>() { // from class: com.transsion.moviedetail.fragment.SubjectListFragment$initLiveData$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(RoomBean roomBean) {
                        invoke2(roomBean);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(RoomBean roomBean) {
                        AbsSubjectListViewModel absSubjectListViewModel2;
                        com.transsion.moviedetail.adapter.d dVar = this.this$0.f53564o;
                        List<PostSubjectItem> listD = dVar != null ? dVar.D() : null;
                        if ((listD == null || listD.isEmpty()) && (absSubjectListViewModel2 = this.this$0.f53563n) != null) {
                            absSubjectListViewModel2.u(true);
                        }
                    }
                }));
            }
            absSubjectListViewModel.o().j(this, new r0(new SubjectListFragment$initLiveData$1$2(this)));
            absSubjectListViewModel.i().j(this, new r0(new Function1<LikeBean, Unit>() { // from class: com.transsion.moviedetail.fragment.SubjectListFragment$initLiveData$1$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LikeBean likeBean) {
                    invoke2(likeBean);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LikeBean likeBean) {
                    if (likeBean != null) {
                        this.this$0.U1(likeBean);
                    }
                }
            }));
            absSubjectListViewModel.e().j(getViewLifecycleOwner(), new r0(new Function1<List<? extends PostSubjectItem>, Unit>() { // from class: com.transsion.moviedetail.fragment.SubjectListFragment$initLiveData$1$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends PostSubjectItem> list) {
                    invoke2((List<PostSubjectItem>) list);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<PostSubjectItem> list) {
                    List arrayList;
                    com.transsion.moviedetail.adapter.d dVar;
                    h9.f fVarQ;
                    RecyclerView recyclerView;
                    RecyclerView.m layoutManager;
                    List<PostSubjectItem> listD;
                    PostSubjectItem postSubjectItem;
                    if (list != null) {
                        SubjectListFragment subjectListFragment = this.this$0;
                        com.transsion.moviedetail.adapter.d dVar2 = subjectListFragment.f53564o;
                        if (dVar2 == null || (arrayList = dVar2.D()) == null) {
                            arrayList = new ArrayList();
                        }
                        ArrayList arrayList2 = new ArrayList();
                        if (!arrayList.isEmpty()) {
                            for (PostSubjectItem postSubjectItem2 : list) {
                                if (!arrayList.contains(postSubjectItem2)) {
                                    arrayList2.add(postSubjectItem2);
                                }
                            }
                        } else {
                            arrayList2.addAll(list);
                        }
                        com.transsion.moviedetail.adapter.d dVar3 = subjectListFragment.f53564o;
                        int i11 = (dVar3 == null || (listD = dVar3.D()) == null || (postSubjectItem = (PostSubjectItem) CollectionsKt___CollectionsKt.g0(listD)) == null || !postSubjectItem.isRoomList()) ? 0 : 1;
                        com.transsion.moviedetail.adapter.d dVar4 = subjectListFragment.f53564o;
                        if (dVar4 != null) {
                            dVar4.k(i11, arrayList2);
                        }
                        tu.g mViewBinding = subjectListFragment.getMViewBinding();
                        if (mViewBinding != null && (recyclerView = mViewBinding.f77481b) != null && (layoutManager = recyclerView.getLayoutManager()) != null) {
                            try {
                                if ((layoutManager instanceof LinearLayoutManager) && ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() <= 1) {
                                    layoutManager.scrollToPosition(0);
                                }
                            } catch (Exception unused) {
                            }
                        }
                        com.transsion.moviedetail.adapter.d dVar5 = subjectListFragment.f53564o;
                        if ((dVar5 != null ? dVar5.getItemCount() : 0) != list.size() || (dVar = subjectListFragment.f53564o) == null || (fVarQ = dVar.Q()) == null) {
                            return;
                        }
                        fVarQ.s(false);
                    }
                }
            }));
            absSubjectListViewModel.g().j(getViewLifecycleOwner(), new r0(new Function1<BaseDto<String>, Unit>() { // from class: com.transsion.moviedetail.fragment.SubjectListFragment$initLiveData$1$5
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
                    this.this$0.T1(baseDto);
                }
            }));
        }
    }
}
