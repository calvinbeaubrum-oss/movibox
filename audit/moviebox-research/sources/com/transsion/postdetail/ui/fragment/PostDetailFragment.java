package com.transsion.postdetail.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import com.alibaba.android.arouter.facade.Postcard;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.material.appbar.AppBarLayout;
import com.tn.lib.util.ActivityStackManager;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R$string;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.moviedetailapi.IMovieDetailService;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.ui.activity.PostDetailActivity;
import com.transsion.postdetail.ui.view.PostDetailItemView;
import com.transsion.postdetail.viewmodel.PostDetailViewModel;
import com.transsion.room.api.IRoomApi;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.usercenterapi.ReportType;
import com.transsion.web.api.WebConstants;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.SyncManager;
import com.transsnet.flow.event.sync.event.LikeEvent;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;

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
public final class PostDetailFragment extends PageStatusFragment<tv.n> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f55758v = new a(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f55759k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f55760l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f55761m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f55762n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f55763o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public PostSubjectItem f55764p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CommentFragment f55765q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f55766r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f55767s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public CommentFragment.b f55768t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public com.transsion.ninegridview.a f55769u;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final PostDetailFragment a(String str, boolean z11, String str2, PostSubjectItem postSubjectItem, String str3, String str4) {
            PostDetailFragment postDetailFragment = new PostDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", str);
            bundle.putString("comment_id", str3);
            bundle.putBoolean("from_comment", z11);
            bundle.putString("rec_ops", str2);
            bundle.putString(WebConstants.PAGE_FROM, str4);
            bundle.putSerializable("item_object", postSubjectItem);
            postDetailFragment.setArguments(bundle);
            return postDetailFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements com.transsion.share.share.e {
        public b() {
        }

        @Override // com.transsion.share.share.e
        public void a(String id2, PostType postType) {
            Intrinsics.g(id2, "id");
            PostDetailFragment.this.g1().h(id2);
        }

        @Override // com.transsion.share.share.e
        public void b(String str) {
            new Intent().putExtra("id", str);
            Activity activityB = com.blankj.utilcode.util.a.b();
            if (activityB != null) {
                activityB.finish();
            }
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

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements CommentFragment.b {
        public c() {
        }

        @Override // com.transsion.postdetail.ui.fragment.CommentFragment.b
        public void a(long j11) {
            PostDetailFragment.this.s1(j11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f55772a;

        public d(Function1 function) {
            Intrinsics.g(function, "function");
            this.f55772a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f55772a;
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
            this.f55772a.invoke(obj);
        }
    }

    public PostDetailFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        this.f55766r = FragmentViewModelLazyKt.a(this, Reflection.b(PostDetailViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final androidx.lifecycle.x0 invoke() {
                androidx.lifecycle.x0 viewModelStore = ((androidx.lifecycle.y0) function0.invoke()).getViewModelStore();
                Intrinsics.f(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final androidx.lifecycle.v0.c invoke() {
                Object objInvoke = function0.invoke();
                androidx.lifecycle.m mVar = objInvoke instanceof androidx.lifecycle.m ? (androidx.lifecycle.m) objInvoke : null;
                androidx.lifecycle.v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.f(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.f55767s = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailFragment$mLoginApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ILoginApi invoke() {
                return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.transsion.postdetail.viewmodel.PostDetailViewModel] */
    public final void a1() {
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.no_network_tips);
            return;
        }
        PostSubjectItem postSubjectItem = this.f55764p;
        ?? B = postSubjectItem != null ? Intrinsics.b(postSubjectItem.getHasLike(), Boolean.TRUE) : 0;
        ?? G1 = g1();
        PostSubjectItem postSubjectItem2 = this.f55764p;
        G1.v(postSubjectItem2 != null ? postSubjectItem2.getPostId() : null, B);
        com.transsion.postdetail.helper.a aVar = com.transsion.postdetail.helper.a.f55063a;
        PostSubjectItem postSubjectItem3 = this.f55764p;
        aVar.m(postSubjectItem3, postSubjectItem3 != null ? Intrinsics.b(postSubjectItem3.getHasLike(), Boolean.TRUE) : false, getPageName(), this.f55763o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:16:0x0032  */
    public final void b1() {
        boolean z11;
        User user;
        User user2;
        UserInfo userInfoP = c1().P();
        if ((userInfoP != null ? userInfoP.getUserId() : null) != null) {
            String userId = userInfoP.getUserId();
            PostSubjectItem postSubjectItem = this.f55764p;
            if (Intrinsics.b(userId, (postSubjectItem == null || (user2 = postSubjectItem.getUser()) == null) ? null : user2.getUserId())) {
                z11 = true;
            } else {
                z11 = false;
            }
        } else {
            z11 = false;
        }
        ShareDialogFragment.a aVar = ShareDialogFragment.f57724t;
        PostType postType = PostType.POST_TYPE;
        PostSubjectItem postSubjectItem2 = this.f55764p;
        String postId = postSubjectItem2 != null ? postSubjectItem2.getPostId() : null;
        PostSubjectItem postSubjectItem3 = this.f55764p;
        String userId2 = (postSubjectItem3 == null || (user = postSubjectItem3.getUser()) == null) ? null : user.getUserId();
        String value = ReportType.POST.getValue();
        PostSubjectItem postSubjectItem4 = this.f55764p;
        ShareDialogFragment shareDialogFragmentA = aVar.a(postType, postId, userId2, value, (3072 & 16) != 0 ? "" : postSubjectItem4 != null ? postSubjectItem4.getTitle() : null, (3072 & 32) != 0 ? "" : "", (3072 & 64) != 0 ? false : false, (3072 & 128) != 0 ? false : z11, (3072 & 256) != 0 ? false : false, "postdetail", (3072 & 1024) != 0 ? "" : this.f55759k, (3072 & 2048) != 0 ? "" : null);
        shareDialogFragmentA.E0(new b());
        shareDialogFragmentA.show(getChildFragmentManager(), AppLovinEventTypes.USER_SHARED_LINK);
        com.transsion.postdetail.helper.a.f55063a.y(this.f55764p, getPageName(), this.f55763o);
    }

    private final ILoginApi c1() {
        return (ILoginApi) this.f55767s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PostDetailViewModel g1() {
        return (PostDetailViewModel) this.f55766r.getValue();
    }

    private final String getPageName() {
        return "post_detail";
    }

    public static final void h1(PostDetailFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        CommentFragment commentFragment = this$0.f55765q;
        if (commentFragment != null) {
            commentFragment.a1(null);
        }
    }

    private final void i1() {
        Unit unit;
        PostDetailItemView postDetailItemView;
        PostSubjectItem postSubjectItem = this.f55764p;
        if (postSubjectItem != null) {
            if (postSubjectItem != null) {
                postSubjectItem.setTran_ops(this.f55759k);
            }
            u1();
            FragmentActivity activity = getActivity();
            Intrinsics.e(activity, "null cannot be cast to non-null type com.transsion.postdetail.ui.activity.PostDetailActivity");
            ((PostDetailActivity) activity).g0();
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        if (unit == null) {
            PostDetailViewModel postDetailViewModelG1 = g1();
            String str = this.f55760l;
            if (str == null) {
                str = "";
            }
            postDetailViewModelG1.n(str);
        }
        tv.n mViewBinding = getMViewBinding();
        if (mViewBinding == null || (postDetailItemView = mViewBinding.f77865f) == null) {
            return;
        }
        postDetailItemView.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.h0
            @Override // java.lang.Runnable
            public final void run() {
                PostDetailFragment.j1(this.f55887a);
            }
        }, 500L);
    }

    private final void initView() {
        AppCompatTextView appCompatTextView;
        Stat stat;
        Long commentCount;
        TitleLayout titleLayout;
        this.f55768t = new c();
        tv.n mViewBinding = getMViewBinding();
        if (mViewBinding != null && (titleLayout = mViewBinding.f77866g) != null) {
            titleLayout.setTitleText("");
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.f(childFragmentManager, "childFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
        CommentFragment.a aVar = CommentFragment.F;
        String str = this.f55760l;
        PostSubjectItem postSubjectItem = this.f55764p;
        long jLongValue = (postSubjectItem == null || (stat = postSubjectItem.getStat()) == null || (commentCount = stat.getCommentCount()) == null) ? 0L : commentCount.longValue();
        String str2 = this.f55762n;
        CommentFragment commentFragmentA = aVar.a(str, jLongValue, (4 & 4) != 0, (4 & 8) != 0 ? false : true, (4 & 16) != 0 ? "" : str2 == null ? "" : str2, this.f55763o);
        fragmentTransactionBeginTransaction.replace(R$id.fl_comment_container, commentFragmentA);
        this.f55765q = commentFragmentA;
        fragmentTransactionBeginTransaction.commit();
        CommentFragment commentFragment = this.f55765q;
        if (commentFragment != null) {
            commentFragment.X0(this.f55768t);
        }
        tv.n mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (appCompatTextView = mViewBinding2.f77867h) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostDetailFragment.h1(this.f55883a, view);
            }
        });
    }

    public static final void j1(PostDetailFragment this$0) {
        tv.n mViewBinding;
        AppBarLayout appBarLayout;
        Intrinsics.g(this$0, "this$0");
        String str = this$0.f55762n;
        if (str == null || str.length() == 0 || (mViewBinding = this$0.getMViewBinding()) == null || (appBarLayout = mViewBinding.f77862b) == null) {
            return;
        }
        appBarLayout.setExpanded(false, true);
    }

    private final void k1() {
        HashMap<String, String> mapG;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        long jH = jElapsedRealtime - (logViewConfig != null ? logViewConfig.h() : 0L);
        com.transsion.baselib.report.h logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 == null || (mapG = logViewConfig2.g()) == null) {
            return;
        }
        mapG.put("post_duration", String.valueOf(jH));
    }

    private final void l1() {
        Function1<LikeEvent, Unit> function1 = new Function1<LikeEvent, Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailFragment$observeLike$1
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
                Stat stat;
                Long likeCount;
                Stat stat2;
                Long likeCount2;
                Intrinsics.g(value, "value");
                PostDetailFragment postDetailFragment = this.this$0;
                try {
                    Result.Companion companion = Result.Companion;
                    PostSubjectItem postSubjectItemD1 = postDetailFragment.d1();
                    Long lValueOf = null;
                    if (TextUtils.equals(postSubjectItemD1 != null ? postSubjectItemD1.getPostId() : null, value.getSubjectId())) {
                        PostSubjectItem postSubjectItemD2 = postDetailFragment.d1();
                        if (postSubjectItemD2 != null) {
                            postSubjectItemD2.setHasLike(Boolean.valueOf(value.getLike()));
                        }
                        if (value.getLike()) {
                            PostSubjectItem postSubjectItemD3 = postDetailFragment.d1();
                            Stat stat3 = postSubjectItemD3 != null ? postSubjectItemD3.getStat() : null;
                            if (stat3 != null) {
                                PostSubjectItem postSubjectItemD4 = postDetailFragment.d1();
                                if (postSubjectItemD4 != null && (stat2 = postSubjectItemD4.getStat()) != null && (likeCount2 = stat2.getLikeCount()) != null) {
                                    lValueOf = Long.valueOf(likeCount2.longValue() + 1);
                                }
                                stat3.setLikeCount(lValueOf);
                            }
                        } else {
                            PostSubjectItem postSubjectItemD5 = postDetailFragment.d1();
                            Stat stat4 = postSubjectItemD5 != null ? postSubjectItemD5.getStat() : null;
                            if (stat4 != null) {
                                PostSubjectItem postSubjectItemD6 = postDetailFragment.d1();
                                if (postSubjectItemD6 != null && (stat = postSubjectItemD6.getStat()) != null && (likeCount = stat.getLikeCount()) != null) {
                                    lValueOf = Long.valueOf(likeCount.longValue() - 1);
                                }
                                stat4.setLikeCount(lValueOf);
                            }
                        }
                        postDetailFragment.t1();
                        Result.m163constructorimpl(Unit.f68710a);
                    }
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    Result.m163constructorimpl(ResultKt.a(th2));
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = LikeEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.w0.c().q(), false, function1);
    }

    private final void q1(PostSubjectItem postSubjectItem) {
        HashMap<String, String> mapG;
        HashMap<String, String> mapG2;
        com.transsion.baselib.report.h logViewConfig;
        HashMap<String, String> mapG3;
        String mediaType;
        com.transsion.baselib.report.h logViewConfig2;
        HashMap<String, String> mapG4;
        com.transsion.baselib.report.h logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null) {
            logViewConfig3.j(true);
        }
        com.transsion.baselib.report.h logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null) {
            logViewConfig4.m(postSubjectItem.getRec_ops());
        }
        String str = "";
        if (!TextUtils.isEmpty(postSubjectItem.getPostId()) && (logViewConfig2 = getLogViewConfig()) != null && (mapG4 = logViewConfig2.g()) != null) {
            String postId = postSubjectItem.getPostId();
            if (postId == null) {
                postId = "";
            }
            mapG4.put("post_id", postId);
        }
        Media media = postSubjectItem.getMedia();
        if (!TextUtils.isEmpty(media != null ? media.getMediaType() : null) && (logViewConfig = getLogViewConfig()) != null && (mapG3 = logViewConfig.g()) != null) {
            Media media2 = postSubjectItem.getMedia();
            if (media2 != null && (mediaType = media2.getMediaType()) != null) {
                str = mediaType;
            }
            mapG3.put("post_media_type", str);
        }
        com.transsion.baselib.report.h logViewConfig5 = getLogViewConfig();
        if (logViewConfig5 != null && (mapG2 = logViewConfig5.g()) != null) {
            Subject subject = postSubjectItem.getSubject();
            mapG2.put("subject_id", subject != null ? subject.getSubjectId() : null);
        }
        com.transsion.baselib.report.h logViewConfig6 = getLogViewConfig();
        if (logViewConfig6 == null || (mapG = logViewConfig6.g()) == null) {
            return;
        }
        Subject subject2 = postSubjectItem.getSubject();
        mapG.put("has_resource", String.valueOf(subject2 != null ? subject2.getHasResource() : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r1() {
        CommentFragment commentFragment = this.f55765q;
        if (commentFragment != null) {
            commentFragment.a1(null);
        }
        com.transsion.postdetail.helper.a.f55063a.e(this.f55764p, getPageName(), this.f55763o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s1(long j11) {
        PostDetailItemView postDetailItemView;
        tv.n mViewBinding = getMViewBinding();
        AppCompatTextView appCompatTextView = mViewBinding != null ? mViewBinding.f77868i : null;
        if (appCompatTextView != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
            String string = getString(com.transsion.postdetail.R$string.comments);
            Intrinsics.f(string, "getString(R.string.comments)");
            String str = String.format(string, Arrays.copyOf(new Object[]{com.transsion.baseui.util.j.a(j11)}, 1));
            Intrinsics.f(str, "format(...)");
            appCompatTextView.setText(str);
        }
        tv.n mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (postDetailItemView = mViewBinding2.f77865f) == null) {
            return;
        }
        postDetailItemView.setCommentCount(j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t1() {
        tv.n mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            mViewBinding.f77865f.setBottomBarClick(this.f55764p, new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailFragment$updateOperationViewState$1$1
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
                    this.this$0.a1();
                }
            }, new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailFragment$updateOperationViewState$1$2
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
                    this.this$0.r1();
                }
            }, new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailFragment$updateOperationViewState$1$3
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
                    this.this$0.b1();
                }
            }, new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailFragment$updateOperationViewState$1$4
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
                    PostDetailFragment postDetailFragment = this.this$0;
                    postDetailFragment.n1(postDetailFragment.d1());
                }
            }, new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailFragment$updateOperationViewState$1$5
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
                    PostDetailFragment postDetailFragment = this.this$0;
                    postDetailFragment.m1(postDetailFragment.d1());
                }
            }, new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailFragment$updateOperationViewState$1$6
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
                    PostDetailFragment postDetailFragment = this.this$0;
                    postDetailFragment.o1(postDetailFragment.d1());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u1() {
        PostDetailItemView postDetailItemView;
        Long commentCount;
        PostSubjectItem postSubjectItem = this.f55764p;
        if (postSubjectItem != null) {
            tv.n mViewBinding = getMViewBinding();
            if (mViewBinding != null) {
                CommentFragment commentFragment = this.f55765q;
                if (commentFragment != null) {
                    Stat stat = postSubjectItem.getStat();
                    commentFragment.h1((stat == null || (commentCount = stat.getCommentCount()) == null) ? 0L : commentCount.longValue());
                }
                mViewBinding.f77865f.setIsDetail(true);
                mViewBinding.f77865f.setPage("post_detail", this.f55763o);
                mViewBinding.f77865f.setData(postSubjectItem);
                tv.n mViewBinding2 = getMViewBinding();
                if (mViewBinding2 != null && (postDetailItemView = mViewBinding2.f77865f) != null) {
                    postDetailItemView.setBottomBarClick(this.f55764p, new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailFragment$updatePostDetail$1$1$1
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
                            this.this$0.a1();
                        }
                    }, new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailFragment$updatePostDetail$1$1$2
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
                            this.this$0.r1();
                        }
                    }, new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailFragment$updatePostDetail$1$1$3
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
                            this.this$0.b1();
                        }
                    }, new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailFragment$updatePostDetail$1$1$4
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
                            PostDetailFragment postDetailFragment = this.this$0;
                            postDetailFragment.n1(postDetailFragment.d1());
                        }
                    }, new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailFragment$updatePostDetail$1$1$5
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
                            PostDetailFragment postDetailFragment = this.this$0;
                            postDetailFragment.m1(postDetailFragment.d1());
                        }
                    }, new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailFragment$updatePostDetail$1$1$6
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
                            PostDetailFragment postDetailFragment = this.this$0;
                            postDetailFragment.o1(postDetailFragment.d1());
                        }
                    });
                }
            }
            q1(postSubjectItem);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void D0() {
        Serializable serializable;
        super.D0();
        Bundle arguments = getArguments();
        PostSubjectItem postSubjectItem = null;
        this.f55760l = arguments != null ? arguments.getString("id") : null;
        Bundle arguments2 = getArguments();
        this.f55761m = arguments2 != null ? arguments2.getBoolean("from_comment") : false;
        Bundle arguments3 = getArguments();
        this.f55759k = arguments3 != null ? arguments3.getString("rec_ops") : null;
        Bundle arguments4 = getArguments();
        this.f55763o = arguments4 != null ? arguments4.getString(WebConstants.PAGE_FROM) : null;
        Bundle arguments5 = getArguments();
        this.f55762n = arguments5 != null ? arguments5.getString("comment_id") : null;
        Bundle arguments6 = getArguments();
        if (arguments6 != null && (serializable = arguments6.getSerializable("item_object")) != null) {
            postSubjectItem = (PostSubjectItem) serializable;
        }
        this.f55764p = postSubjectItem;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    public final PostSubjectItem d1() {
        return this.f55764p;
    }

    public final String e1() {
        return this.f55760l;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: f1, reason: merged with bridge method [inline-methods] */
    public tv.n getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        tv.n nVarC = tv.n.c(inflater);
        Intrinsics.f(nVarC, "inflate(inflater)");
        return nVarC;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        PostDetailViewModel postDetailViewModelG1 = g1();
        postDetailViewModelG1.q().j(this, new d(new Function1<PostSubjectItem, Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailFragment$initViewModel$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PostSubjectItem postSubjectItem) {
                invoke2(postSubjectItem);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PostSubjectItem postSubjectItem) {
                if (postSubjectItem == null) {
                    PageStatusFragment.H0(this.this$0, false, 1, null);
                    return;
                }
                this.this$0.F0();
                this.this$0.p1(postSubjectItem);
                PostSubjectItem postSubjectItemD1 = this.this$0.d1();
                if (postSubjectItemD1 != null) {
                    postSubjectItemD1.setTran_ops(this.this$0.f55759k);
                }
                this.this$0.u1();
            }
        }));
        postDetailViewModelG1.j().j(this, new d(new Function1<String, Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailFragment$initViewModel$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                if (!TextUtils.equals("0", str)) {
                    zp.b.a aVar = zp.b.f82110a;
                    FragmentActivity activity = this.this$0.getActivity();
                    aVar.e(activity != null ? activity.getString(com.transsion.postdetail.R$string.delete_post_failed) : null);
                    return;
                }
                String strE1 = this.this$0.e1();
                if (strE1 != null) {
                    SyncManager.f61414a.a().c(strE1);
                }
                FragmentActivity activity2 = this.this$0.getActivity();
                if (activity2 != null) {
                    activity2.finish();
                }
            }
        }));
        l1();
    }

    public final void m1(PostSubjectItem postSubjectItem) {
        Group group;
        String groupId;
        if (TextUtils.equals(ActivityStackManager.f49449b.a().b(), ((IRoomApi) com.alibaba.android.arouter.launcher.a.d().h(IRoomApi.class)).R0())) {
            requireActivity().finish();
        } else if (postSubjectItem != null && (group = postSubjectItem.getGroup()) != null && (groupId = group.getGroupId()) != null) {
            com.alibaba.android.arouter.launcher.a.d().b("/room/detail").withString("id", groupId).navigation();
        }
        com.transsion.postdetail.helper.a.f55063a.j(this.f55764p, getPageName(), this.f55763o);
    }

    public final void n1(PostSubjectItem postSubjectItem) {
        Subject subject;
        String strB = ActivityStackManager.f49449b.a().b();
        if (TextUtils.equals(strB, ((IMovieDetailService) com.alibaba.android.arouter.launcher.a.d().h(IMovieDetailService.class)).Q0()) || TextUtils.equals(strB, "StreamDetailActivity") || TextUtils.equals(strB, "MusicDetailActivity")) {
            requireActivity().finish();
        } else if (postSubjectItem != null && (subject = postSubjectItem.getSubject()) != null) {
            Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail");
            Integer subjectType = subject.getSubjectType();
            postcardB.withInt("subject_type", subjectType != null ? subjectType.intValue() : SubjectType.MOVIE.getValue()).withString("id", subject.getSubjectId()).withString("ops", subject.getOps()).navigation();
        }
        com.transsion.postdetail.helper.a.f55063a.A(this.f55764p, getPageName(), this.f55763o);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("post_detail", false, 2, null);
    }

    public final void o1(PostSubjectItem postSubjectItem) {
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

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.transsion.ninegridview.a aVar = this.f55769u;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        k1();
        super.onPause();
        com.transsion.ninegridview.a aVar = this.f55769u;
        if (aVar != null) {
            aVar.k();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.transsion.ninegridview.a aVar = this.f55769u;
        if (aVar != null) {
            aVar.l();
        }
    }

    public final void p1(PostSubjectItem postSubjectItem) {
        this.f55764p = postSubjectItem;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        HashMap<String, String> mapG;
        initView();
        i1();
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (mapG = logViewConfig.g()) == null) {
            return;
        }
        mapG.put(WebConstants.PAGE_FROM, this.f55763o);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean y0() {
        return false;
    }
}
