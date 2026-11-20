package com.transsion.postdetail.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import com.alibaba.android.arouter.facade.Postcard;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Audio;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.postdetail.R$drawable;
import com.transsion.postdetail.R$mipmap;
import com.transsion.postdetail.bean.CommentBean;
import com.transsion.postdetail.bean.CommentLikeBean;
import com.transsion.postdetail.bean.CommentListBean;
import com.transsion.postdetail.ui.dialog.ImmVideoCommentDialog;
import com.transsion.postdetail.viewmodel.CommentViewModel;
import com.transsion.postdetail.viewmodel.PostDetailCommentsFragmentViewModel;
import com.transsion.postdetail.viewmodel.PostDetailViewModel;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.usercenterapi.ReportType;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.SyncManager;
import com.transsnet.flow.event.sync.event.LikeEvent;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
@Deprecated
@SourceDebugExtension
public final class PostDetailCommentsFragment extends PageStatusFragment<tv.l> {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f55729w = new a(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CommentBean f55730k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PostSubjectItem f55731l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f55732m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f55733n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f55734o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f55735p = LazyKt__LazyJVMKt.b(new Function0<PostDetailCommentsFragmentViewModel>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommentsFragment$mViewModel$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PostDetailCommentsFragmentViewModel invoke() {
            return new PostDetailCommentsFragmentViewModel();
        }
    });

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f55736q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f55737r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Function1<? super Integer, Unit> f55738s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public CommentViewModel f55739t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f55740u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f55741v;

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
    public static final class b implements com.transsion.share.share.e {
        public b() {
        }

        @Override // com.transsion.share.share.e
        public void a(String id2, PostType postType) {
            Intrinsics.g(id2, "id");
            PostDetailCommentsFragment.this.g1().h(id2);
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
    public static final class c implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f55743a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f55743a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f55743a;
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
            this.f55743a.invoke(obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements CommentFragment.b {
        public d() {
        }

        @Override // com.transsion.postdetail.ui.fragment.CommentFragment.b
        public void a(long j11) {
            Stat stat;
            Long commentCount;
            PostSubjectItem postSubjectItem = PostDetailCommentsFragment.this.f55731l;
            if (postSubjectItem == null || (stat = postSubjectItem.getStat()) == null || (commentCount = stat.getCommentCount()) == null || commentCount.longValue() != j11) {
                PostSubjectItem postSubjectItem2 = PostDetailCommentsFragment.this.f55731l;
                Stat stat2 = postSubjectItem2 != null ? postSubjectItem2.getStat() : null;
                if (stat2 != null) {
                    stat2.setCommentCount(Long.valueOf(j11));
                }
                if (j11 != 0) {
                    PostDetailCommentsFragment.this.B0();
                } else {
                    PostDetailCommentsFragment.this.p1();
                    PostDetailCommentsFragment.this.r1();
                }
            }
        }
    }

    public PostDetailCommentsFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommentsFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        this.f55736q = FragmentViewModelLazyKt.a(this, Reflection.b(PostDetailViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommentsFragment$special$$inlined$viewModels$default$2
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
        }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommentsFragment$special$$inlined$viewModels$default$3
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
        this.f55737r = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommentsFragment$mLoginApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ILoginApi invoke() {
                return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
            }
        });
        this.f55738s = new Function1<Integer, Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommentsFragment$operationViewVisibilityCallback$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(int i11) {
            }
        };
        this.f55740u = true;
    }

    private final ILoginApi e1() {
        return (ILoginApi) this.f55737r.getValue();
    }

    public static final void i1(PostDetailCommentsFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.m1(true);
    }

    public static final void j1(PostDetailCommentsFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/profile/user_center");
        CommentBean commentBean = this$0.f55730k;
        postcardB.withSerializable("userId", commentBean != null ? commentBean.getUid() : null).navigation();
    }

    public static final void k1(View view) {
    }

    private final void l1() {
        Function1<LikeEvent, Unit> function1 = new Function1<LikeEvent, Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommentsFragment$observeLike$1
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
                PostDetailCommentsFragment postDetailCommentsFragment = this.this$0;
                try {
                    Result.Companion companion = Result.Companion;
                    PostSubjectItem postSubjectItem = postDetailCommentsFragment.f55731l;
                    Long lValueOf = null;
                    if (TextUtils.equals(postSubjectItem != null ? postSubjectItem.getPostId() : null, value.getSubjectId())) {
                        PostSubjectItem postSubjectItem2 = postDetailCommentsFragment.f55731l;
                        if (postSubjectItem2 != null) {
                            postSubjectItem2.setHasLike(Boolean.valueOf(value.getLike()));
                        }
                        if (value.getLike()) {
                            PostSubjectItem postSubjectItem3 = postDetailCommentsFragment.f55731l;
                            Stat stat3 = postSubjectItem3 != null ? postSubjectItem3.getStat() : null;
                            if (stat3 != null) {
                                PostSubjectItem postSubjectItem4 = postDetailCommentsFragment.f55731l;
                                if (postSubjectItem4 != null && (stat2 = postSubjectItem4.getStat()) != null && (likeCount2 = stat2.getLikeCount()) != null) {
                                    lValueOf = Long.valueOf(likeCount2.longValue() + 1);
                                }
                                stat3.setLikeCount(lValueOf);
                            }
                        } else {
                            PostSubjectItem postSubjectItem5 = postDetailCommentsFragment.f55731l;
                            Stat stat4 = postSubjectItem5 != null ? postSubjectItem5.getStat() : null;
                            if (stat4 != null) {
                                PostSubjectItem postSubjectItem6 = postDetailCommentsFragment.f55731l;
                                if (postSubjectItem6 != null && (stat = postSubjectItem6.getStat()) != null && (likeCount = stat.getLikeCount()) != null) {
                                    lValueOf = Long.valueOf(likeCount.longValue() - 1);
                                }
                                stat4.setLikeCount(lValueOf);
                            }
                        }
                        postDetailCommentsFragment.r1();
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

    public static /* synthetic */ void n1(PostDetailCommentsFragment postDetailCommentsFragment, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        postDetailCommentsFragment.m1(z11);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void B0() {
        String postId;
        PostDetailCommentsFragmentViewModel postDetailCommentsFragmentViewModelF1 = f1();
        PostSubjectItem postSubjectItem = this.f55731l;
        if (postSubjectItem == null || (postId = postSubjectItem.getPostId()) == null) {
            postId = "";
        }
        postDetailCommentsFragmentViewModelF1.c(postId, "0", String.valueOf(this.f55733n), this.f55734o);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    /* JADX WARN: Code duplicated, block: B:50:0x008c  */
    public final void b1() {
        String url;
        String str;
        Subject subject;
        ResourceDetectors resourceDetector;
        String resourceLink;
        Subject subject2;
        Subject subject3;
        Integer size;
        String url2;
        Subject subject4;
        ResourceDetectors resourceDetector2;
        PostSubjectItem postSubjectItem;
        Media media;
        Cover cover;
        Media media2;
        List<Audio> audio;
        PostSubjectItem postSubjectItem2 = this.f55731l;
        Audio audio2 = (postSubjectItem2 == null || (media2 = postSubjectItem2.getMedia()) == null || (audio = media2.getAudio()) == null || !(audio.isEmpty() ^ true)) ? null : audio.get(0);
        PostSubjectItem postSubjectItem3 = this.f55731l;
        String title = postSubjectItem3 != null ? postSubjectItem3.getTitle() : null;
        if (TextUtils.isEmpty(title)) {
            PostSubjectItem postSubjectItem4 = this.f55731l;
            title = postSubjectItem4 != null ? postSubjectItem4.getContent() : null;
        }
        String str2 = title;
        PostSubjectItem postSubjectItem5 = this.f55731l;
        String coverUrl$default = postSubjectItem5 != null ? PostSubjectItem.getCoverUrl$default(postSubjectItem5, false, 1, null) : null;
        if (TextUtils.isEmpty(coverUrl$default) && ((postSubjectItem = this.f55731l) == null || (media = postSubjectItem.getMedia()) == null || (cover = media.getCover()) == null || (coverUrl$default = cover.getUrl()) == null)) {
            coverUrl$default = "";
        }
        String str3 = coverUrl$default;
        PostSubjectItem postSubjectItem6 = this.f55731l;
        if ((postSubjectItem6 != null ? postSubjectItem6.getSubject() : null) != null) {
            PostSubjectItem postSubjectItem7 = this.f55731l;
            if (postSubjectItem7 == null || (subject4 = postSubjectItem7.getSubject()) == null || (resourceDetector2 = subject4.getResourceDetector()) == null) {
                str = null;
            } else {
                url = resourceDetector2.getResourceId();
                str = url;
            }
        } else {
            Audio audio3 = audio2;
            if (audio3 != null) {
                url = audio3.getUrl();
                str = url;
            } else {
                str = null;
            }
        }
        Audio audio4 = audio2;
        DownloadBean downloadBean = new DownloadBean((audio4 == null || (url2 = audio4.getUrl()) == null) ? "" : url2, str, str2, str3, (audio4 == null || (size = audio4.getSize()) == null) ? null : Long.valueOf(size.intValue()), "", null, null, null, null, 0L, 0, 0, 1, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -8256, 1073741823, null);
        PostSubjectItem postSubjectItem8 = this.f55731l;
        downloadBean.setPostId(postSubjectItem8 != null ? postSubjectItem8.getPostId() : null);
        PostSubjectItem postSubjectItem9 = this.f55731l;
        downloadBean.setSubjectId((postSubjectItem9 == null || (subject3 = postSubjectItem9.getSubject()) == null) ? null : subject3.getSubjectId());
        PostSubjectItem postSubjectItem10 = this.f55731l;
        downloadBean.setSubjectName((postSubjectItem10 == null || (subject2 = postSubjectItem10.getSubject()) == null) ? null : subject2.getTitle());
        DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
        Context context = getContext();
        Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentActivity fragmentActivity = (FragmentActivity) context;
        PostSubjectItem postSubjectItem11 = this.f55731l;
        String ops = postSubjectItem11 != null ? postSubjectItem11.getOps() : null;
        PostSubjectItem postSubjectItem12 = this.f55731l;
        String str4 = (postSubjectItem12 == null || (subject = postSubjectItem12.getSubject()) == null || (resourceDetector = subject.getResourceDetector()) == null || (resourceLink = resourceDetector.getResourceLink()) == null) ? "" : resourceLink;
        PostSubjectItem postSubjectItem13 = this.f55731l;
        DownloadManagerApi.U1(downloadManagerApiA, fragmentActivity, downloadBean, "post_audio_detail", ops, str4, postSubjectItem13 != null ? postSubjectItem13.getSubject() : null, null, 64, null);
        com.transsion.postdetail.helper.a aVar = com.transsion.postdetail.helper.a.f55063a;
        PostSubjectItem postSubjectItem14 = this.f55731l;
        String str5 = this.f55741v;
        com.transsion.postdetail.helper.a.i(aVar, postSubjectItem14, str5 == null ? "" : str5, null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.transsion.postdetail.viewmodel.PostDetailViewModel] */
    public final void c1() {
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.no_network_tips);
            return;
        }
        PostSubjectItem postSubjectItem = this.f55731l;
        ?? B = postSubjectItem != null ? Intrinsics.b(postSubjectItem.getHasLike(), Boolean.TRUE) : 0;
        ?? G1 = g1();
        PostSubjectItem postSubjectItem2 = this.f55731l;
        G1.v(postSubjectItem2 != null ? postSubjectItem2.getPostId() : null, B);
        com.transsion.postdetail.helper.a aVar = com.transsion.postdetail.helper.a.f55063a;
        PostSubjectItem postSubjectItem3 = this.f55731l;
        boolean zB = postSubjectItem3 != null ? Intrinsics.b(postSubjectItem3.getHasLike(), Boolean.TRUE) : false;
        String str = this.f55741v;
        if (str == null) {
            str = "";
        }
        com.transsion.postdetail.helper.a.n(aVar, postSubjectItem3, zB, str, null, 8, null);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0032  */
    public final void d1() {
        boolean z11;
        User user;
        User user2;
        UserInfo userInfoP = e1().P();
        if ((userInfoP != null ? userInfoP.getUserId() : null) != null) {
            String userId = userInfoP.getUserId();
            PostSubjectItem postSubjectItem = this.f55731l;
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
        PostSubjectItem postSubjectItem2 = this.f55731l;
        String postId = postSubjectItem2 != null ? postSubjectItem2.getPostId() : null;
        PostSubjectItem postSubjectItem3 = this.f55731l;
        String userId2 = (postSubjectItem3 == null || (user = postSubjectItem3.getUser()) == null) ? null : user.getUserId();
        String value = ReportType.POST.getValue();
        PostSubjectItem postSubjectItem4 = this.f55731l;
        ShareDialogFragment shareDialogFragmentA = aVar.a(postType, postId, userId2, value, (3072 & 16) != 0 ? "" : postSubjectItem4 != null ? postSubjectItem4.getTitle() : null, (3072 & 32) != 0 ? "" : "", (3072 & 64) != 0 ? false : false, (3072 & 128) != 0 ? false : z11, (3072 & 256) != 0 ? false : false, "postdetail", (3072 & 1024) != 0 ? "" : this.f55732m, (3072 & 2048) != 0 ? "" : null);
        shareDialogFragmentA.E0(new b());
        shareDialogFragmentA.show(getChildFragmentManager(), AppLovinEventTypes.USER_SHARED_LINK);
        com.transsion.postdetail.helper.a aVar2 = com.transsion.postdetail.helper.a.f55063a;
        PostSubjectItem postSubjectItem5 = this.f55731l;
        String str = this.f55741v;
        if (str == null) {
            str = "";
        }
        com.transsion.postdetail.helper.a.z(aVar2, postSubjectItem5, str, null, 4, null);
    }

    public final PostDetailCommentsFragmentViewModel f1() {
        return (PostDetailCommentsFragmentViewModel) this.f55735p.getValue();
    }

    public final PostDetailViewModel g1() {
        return (PostDetailViewModel) this.f55736q.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: h1, reason: merged with bridge method [inline-methods] */
    public tv.l getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        tv.l lVarC = tv.l.c(inflater);
        Intrinsics.f(lVarC, "inflate(inflater)");
        return lVarC;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        l1();
        tv.l mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            mViewBinding.f77823h.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PostDetailCommentsFragment.i1(this.f55943a, view);
                }
            });
            com.transsion.postdetail.util.f fVar = com.transsion.postdetail.util.f.f56211a;
            AppCompatTextView tvComments = mViewBinding.f77828m;
            Intrinsics.f(tvComments, "tvComments");
            AppCompatImageView ivRight = mViewBinding.f77826k;
            Intrinsics.f(ivRight, "ivRight");
            AppCompatTextView tvNoCommentYet = mViewBinding.f77829n;
            Intrinsics.f(tvNoCommentYet, "tvNoCommentYet");
            AppCompatTextView itemCommentData = mViewBinding.f77821f;
            Intrinsics.f(itemCommentData, "itemCommentData");
            AppCompatTextView itemCommentContent = mViewBinding.f77820d;
            Intrinsics.f(itemCommentContent, "itemCommentContent");
            AppCompatTextView itemCommentUserName = mViewBinding.f77825j;
            Intrinsics.f(itemCommentUserName, "itemCommentUserName");
            fVar.b(new View[]{tvComments, ivRight, tvNoCommentYet, itemCommentData, itemCommentContent, itemCommentUserName}, new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommentsFragment$initListener$1$2
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
                    PostDetailCommentsFragment.n1(this.this$0, false, 1, null);
                }
            });
            mViewBinding.f77824i.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PostDetailCommentsFragment.j1(this.f55946a, view);
                }
            });
            mViewBinding.f77829n.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PostDetailCommentsFragment.k1(view);
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        CommentViewModel commentViewModel = (CommentViewModel) new androidx.lifecycle.v0(this).a(CommentViewModel.class);
        commentViewModel.k().j(getViewLifecycleOwner(), new c(new Function1<CommentLikeBean, Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommentsFragment$initViewModel$1$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CommentLikeBean commentLikeBean) {
                invoke2(commentLikeBean);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CommentLikeBean commentLikeBean) {
            }
        }));
        this.f55739t = commentViewModel;
        f1().e().j(getViewLifecycleOwner(), new c(new Function1<CommentListBean, Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommentsFragment.initViewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CommentListBean commentListBean) {
                invoke2(commentListBean);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CommentListBean commentListBean) {
                List<CommentBean> commentList;
                if (commentListBean == null || (commentList = commentListBean.getCommentList()) == null || commentList.isEmpty()) {
                    PostDetailCommentsFragment.this.p1();
                    PostDetailCommentsFragment.this.r1();
                    return;
                }
                tv.l mViewBinding = PostDetailCommentsFragment.this.getMViewBinding();
                Group group = mViewBinding != null ? mViewBinding.f77819c : null;
                if (group != null) {
                    group.setVisibility(0);
                }
                tv.l mViewBinding2 = PostDetailCommentsFragment.this.getMViewBinding();
                AppCompatTextView appCompatTextView = mViewBinding2 != null ? mViewBinding2.f77829n : null;
                if (appCompatTextView != null) {
                    appCompatTextView.setVisibility(8);
                }
                PostDetailCommentsFragment.this.s1(commentListBean != null ? commentListBean.getCommentList() : null);
            }
        }));
        g1().j().j(this, new c(new Function1<String, Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommentsFragment$initViewModel$3$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                PostDetailCommentsFragment postDetailCommentsFragment = this.this$0;
                Intrinsics.f(it, "it");
                postDetailCommentsFragment.q1(it);
            }
        }));
    }

    public final void m1(boolean z11) {
        ImmVideoCommentDialog immVideoCommentDialogB = ImmVideoCommentDialog.a.b(ImmVideoCommentDialog.f55600n, this.f55731l, null, null, null, 14, null);
        immVideoCommentDialogB.x0(new Function2<String, Boolean, Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommentsFragment$showCommentsDialog$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, Boolean bool) {
                invoke2(str, bool);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str, Boolean bool) {
                CommentBean commentBean = this.this$0.f55730k;
                if (TextUtils.equals(str, commentBean != null ? commentBean.getCommentId() : null)) {
                    CommentBean commentBean2 = this.this$0.f55730k;
                    if (commentBean2 != null) {
                        commentBean2.setLikeStatu(bool);
                    }
                    this.this$0.o1(bool != null ? bool.booleanValue() : false);
                }
            }
        });
        immVideoCommentDialogB.y0(new d());
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.f(childFragmentManager, "childFragmentManager");
        immVideoCommentDialogB.show(childFragmentManager, "tag_post_detail_comments_fragment");
        if (z11) {
            immVideoCommentDialogB.z0();
            immVideoCommentDialogB.w0(this.f55730k);
        }
    }

    public final void o1(boolean z11) {
        AppCompatImageView appCompatImageView;
        int i11 = z11 ? R$mipmap.ic_comment_item_liked : R$drawable.ic_like_comment_normal;
        tv.l mViewBinding = getMViewBinding();
        if (mViewBinding == null || (appCompatImageView = mViewBinding.f77822g) == null) {
            return;
        }
        appCompatImageView.setImageResource(i11);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Object objM163constructorimpl;
        HashMap<String, String> mapG;
        Subject subject;
        HashMap<String, String> mapG2;
        Subject subject2;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            try {
                Result.Companion companion = Result.Companion;
                Serializable serializable = arguments.getSerializable("post_subject_item");
                Intrinsics.e(serializable, "null cannot be cast to non-null type com.transsion.moviedetailapi.bean.PostSubjectItem");
                this.f55731l = (PostSubjectItem) serializable;
                this.f55732m = arguments.getString("rec_ops");
                this.f55741v = arguments.getString("page_name");
                com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
                Object hasResource = null;
                if (logViewConfig != null && (mapG2 = logViewConfig.g()) != null) {
                    PostSubjectItem postSubjectItem = this.f55731l;
                    mapG2.put("subject_id", (postSubjectItem == null || (subject2 = postSubjectItem.getSubject()) == null) ? null : subject2.getSubjectId());
                }
                com.transsion.baselib.report.h logViewConfig2 = getLogViewConfig();
                if (logViewConfig2 != null && (mapG = logViewConfig2.g()) != null) {
                    PostSubjectItem postSubjectItem2 = this.f55731l;
                    if (postSubjectItem2 != null && (subject = postSubjectItem2.getSubject()) != null) {
                        hasResource = subject.getHasResource();
                    }
                    mapG.put("has_resource", String.valueOf(hasResource));
                    hasResource = Unit.f68710a;
                }
                objM163constructorimpl = Result.m163constructorimpl(hasResource);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
            }
            Result.m162boximpl(objM163constructorimpl);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f55740u = false;
        super.onDestroyView();
    }

    public final void p1() {
        tv.l mViewBinding = getMViewBinding();
        Group group = mViewBinding != null ? mViewBinding.f77819c : null;
        if (group != null) {
            group.setVisibility(8);
        }
        tv.l mViewBinding2 = getMViewBinding();
        AppCompatTextView appCompatTextView = mViewBinding2 != null ? mViewBinding2.f77829n : null;
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setVisibility(0);
    }

    public final void q1(String str) {
        String postId;
        if (!TextUtils.equals("0", str)) {
            com.tn.lib.widget.toast.core.h hVar = com.tn.lib.widget.toast.core.h.f50034a;
            FragmentActivity activity = getActivity();
            hVar.l(activity != null ? activity.getString(com.transsion.postdetail.R$string.delete_post_failed) : null);
            return;
        }
        PostSubjectItem postSubjectItem = this.f55731l;
        if (postSubjectItem != null && (postId = postSubjectItem.getPostId()) != null) {
            SyncManager.f61414a.a().c(postId);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    public final void r1() {
        Stat stat;
        Long commentCount;
        tv.l mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            tv.l mViewBinding2 = getMViewBinding();
            AppCompatTextView appCompatTextView = mViewBinding2 != null ? mViewBinding2.f77828m : null;
            if (appCompatTextView != null) {
                PostSubjectItem postSubjectItem = this.f55731l;
                appCompatTextView.setText(((postSubjectItem == null || (stat = postSubjectItem.getStat()) == null || (commentCount = stat.getCommentCount()) == null) ? 0L : commentCount.longValue()) + " Comments");
            }
            mViewBinding.f77827l.showData(this.f55731l, new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommentsFragment$updateOperationViewState$1$1
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
                    this.this$0.c1();
                }
            }, new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommentsFragment$updateOperationViewState$1$2
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
                    PostDetailCommentsFragment.n1(this.this$0, false, 1, null);
                }
            }, new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommentsFragment$updateOperationViewState$1$3
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
                    this.this$0.d1();
                }
            }, new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommentsFragment$updateOperationViewState$1$4
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
            });
        }
    }

    public final void s1(List<CommentBean> list) {
        String avatarUrl;
        Boolean likeStatu;
        Long createdAt;
        Subject subject;
        String subjectId;
        if (list == null || list.isEmpty()) {
            return;
        }
        final boolean z11 = false;
        this.f55730k = list.get(0);
        tv.l mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            ShapeableImageView shapeableImageView = mViewBinding.f77824i;
            int iA = com.blankj.utilcode.util.f0.a(32.0f);
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = shapeableImageView.getContext();
            Intrinsics.f(context, "context");
            Intrinsics.f(shapeableImageView, "this");
            CommentBean commentBean = this.f55730k;
            if (commentBean == null || (avatarUrl = commentBean.getAvatarUrl()) == null) {
                avatarUrl = "";
            }
            companion.r(context, shapeableImageView, avatarUrl, (4088 & 8) != 0 ? companion.d() : iA, (4088 & 16) != 0 ? companion.c() : iA, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
            AppCompatTextView appCompatTextView = mViewBinding.f77825j;
            CommentBean commentBean2 = this.f55730k;
            appCompatTextView.setText(commentBean2 != null ? commentBean2.getNickName() : null);
            AppCompatTextView uploadCommentsView$lambda$14$lambda$13 = mViewBinding.f77820d;
            PostSubjectItem postSubjectItem = this.f55731l;
            boolean zBooleanValue = true;
            if (postSubjectItem != null && (subject = postSubjectItem.getSubject()) != null && (subjectId = subject.getSubjectId()) != null && subjectId.length() > 0) {
                z11 = true;
            }
            Intrinsics.f(uploadCommentsView$lambda$14$lambda$13, "uploadCommentsView$lambda$14$lambda$13");
            CommentBean commentBean3 = this.f55730k;
            com.transsion.baseui.util.k.f(uploadCommentsView$lambda$14$lambda$13, commentBean3 != null ? commentBean3.getContent() : null, !z11, new Function2<View, String, Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommentsFragment$uploadCommentsView$1$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view, String str) {
                    invoke2(view, str);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view, String str) {
                    String resourceLink;
                    User user;
                    Subject subject2;
                    ResourceDetectors resourceDetector;
                    if (z11) {
                        DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
                        FragmentActivity fragmentActivityRequireActivity = this.requireActivity();
                        Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
                        PostSubjectItem postSubjectItem2 = this.f55731l;
                        String nickname = null;
                        Subject subject3 = postSubjectItem2 != null ? postSubjectItem2.getSubject() : null;
                        Intrinsics.d(str);
                        PostSubjectItem postSubjectItem3 = this.f55731l;
                        String ops = postSubjectItem3 != null ? postSubjectItem3.getOps() : null;
                        PostSubjectItem postSubjectItem4 = this.f55731l;
                        if (postSubjectItem4 == null || (subject2 = postSubjectItem4.getSubject()) == null || (resourceDetector = subject2.getResourceDetector()) == null || (resourceLink = resourceDetector.getResourceLink()) == null) {
                            resourceLink = "";
                        }
                        String str2 = resourceLink;
                        PostSubjectItem postSubjectItem5 = this.f55731l;
                        if (postSubjectItem5 != null && (user = postSubjectItem5.getUser()) != null) {
                            nickname = user.getNickname();
                        }
                        downloadManagerApiA.W1(fragmentActivityRequireActivity, subject3, str, "postdetail", ops, str2, nickname);
                    }
                }
            });
            AppCompatTextView appCompatTextView2 = mViewBinding.f77821f;
            com.transsion.postdetail.comment.r rVar = com.transsion.postdetail.comment.r.f54963a;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
            CommentBean commentBean4 = this.f55730k;
            appCompatTextView2.setText(rVar.c(fragmentActivityRequireActivity, (commentBean4 == null || (createdAt = commentBean4.getCreatedAt()) == null) ? 0L : createdAt.longValue()));
            CommentBean commentBean5 = this.f55730k;
            if (commentBean5 != null && (likeStatu = commentBean5.getLikeStatu()) != null) {
                zBooleanValue = likeStatu.booleanValue();
            }
            o1(zBooleanValue);
            r1();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        Stat stat;
        Long commentCount;
        tv.l mViewBinding = getMViewBinding();
        AppCompatTextView appCompatTextView = mViewBinding != null ? mViewBinding.f77828m : null;
        if (appCompatTextView == null) {
            return;
        }
        PostSubjectItem postSubjectItem = this.f55731l;
        appCompatTextView.setText(((postSubjectItem == null || (stat = postSubjectItem.getStat()) == null || (commentCount = stat.getCommentCount()) == null) ? 0L : commentCount.longValue()) + " Comments");
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
