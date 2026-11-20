package com.transsion.postdetail.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import com.alibaba.android.arouter.facade.Postcard;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.material.imageview.ShapeableImageView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.util.ActivityStackManager;
import com.tn.lib.view.expand.ExpandView;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.R$drawable;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.IMovieDetailService;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Audio;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Link;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.ninegridview.video.NineGridVideoView;
import com.transsion.ninegridview.video.NineGridVideoViewAdapter;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.ui.dialog.ImmVideoCommentDialog;
import com.transsion.postdetail.ui.view.PostDetailOperationView;
import com.transsion.postdetail.viewmodel.PostDetailViewModel;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.usercenterapi.ReportType;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.widget.DownloadView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.SyncManager;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import com.transsnet.flow.event.sync.event.LikeEvent;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
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
import kotlin.jvm.functions.Function2;
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
public abstract class PostDetailCommonFragment extends PageStatusFragment<tv.m> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f55745t = new a(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f55746k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f55747l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f55748m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public PostSubjectItem f55749n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PostRecommendFragment f55750o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f55751p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public DownloadView f55752q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f55753r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.transsion.ninegridview.a f55754s;

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
            PostDetailCommonFragment.this.o1().h(id2);
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
        public final /* synthetic */ Function1 f55756a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f55756a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f55756a;
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
            this.f55756a.invoke(obj);
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
            PostSubjectItem postSubjectItemL1 = PostDetailCommonFragment.this.l1();
            if (postSubjectItemL1 == null || (stat = postSubjectItemL1.getStat()) == null || (commentCount = stat.getCommentCount()) == null || commentCount.longValue() != j11) {
                PostSubjectItem postSubjectItemL2 = PostDetailCommonFragment.this.l1();
                Stat stat2 = postSubjectItemL2 != null ? postSubjectItemL2.getStat() : null;
                if (stat2 != null) {
                    stat2.setCommentCount(Long.valueOf(j11));
                }
                PostDetailCommonFragment.this.z1();
            }
        }
    }

    public PostDetailCommonFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommonFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        this.f55751p = FragmentViewModelLazyKt.a(this, Reflection.b(PostDetailViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommonFragment$special$$inlined$viewModels$default$2
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
        }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommonFragment$special$$inlined$viewModels$default$3
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
        this.f55753r = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommonFragment$mLoginApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ILoginApi invoke() {
                return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
            }
        });
    }

    public static final void C1(PostDetailCommonFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.initPlayer();
    }

    public static final void E1(String str, tv.j0 this_apply, String str2, final PostDetailCommonFragment this$0) {
        Subject subject;
        String subjectId;
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(this$0, "this$0");
        if (TextUtils.isEmpty(str)) {
            ExpandView tvPostDesc = this_apply.f77809b;
            Intrinsics.f(tvPostDesc, "tvPostDesc");
            so.c.g(tvPostDesc);
            return;
        }
        ExpandView showPostInfo$lambda$21$lambda$20$lambda$19 = this_apply.f77809b;
        Intrinsics.f(showPostInfo$lambda$21$lambda$20$lambda$19, "showPostInfo$lambda$21$lambda$20$lambda$19");
        so.c.k(showPostInfo$lambda$21$lambda$20$lambda$19);
        if (!TextUtils.isEmpty(str2)) {
            str = str + "\n" + (str2 != null ? kotlin.text.l.F(str2, " ", "%20", false, 4, null) : null);
        }
        PostSubjectItem postSubjectItem = this$0.f55749n;
        final boolean z11 = false;
        if (postSubjectItem != null && (subject = postSubjectItem.getSubject()) != null && (subjectId = subject.getSubjectId()) != null && subjectId.length() > 0) {
            z11 = true;
        }
        com.transsion.baseui.util.k.f(showPostInfo$lambda$21$lambda$20$lambda$19, str, !z11, new Function2<View, String, Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommonFragment$showPostInfo$2$1$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, String str3) {
                invoke2(view, str3);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view, String str3) {
                String resourceLink;
                User user;
                Subject subject2;
                ResourceDetectors resourceDetector;
                if (z11) {
                    DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
                    FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
                    Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
                    PostSubjectItem postSubjectItemL1 = this$0.l1();
                    String nickname = null;
                    Subject subject3 = postSubjectItemL1 != null ? postSubjectItemL1.getSubject() : null;
                    Intrinsics.d(str3);
                    String str4 = this$0.f55746k;
                    PostSubjectItem postSubjectItemL2 = this$0.l1();
                    if (postSubjectItemL2 == null || (subject2 = postSubjectItemL2.getSubject()) == null || (resourceDetector = subject2.getResourceDetector()) == null || (resourceLink = resourceDetector.getResourceLink()) == null) {
                        resourceLink = "";
                    }
                    String str5 = resourceLink;
                    PostSubjectItem postSubjectItemL3 = this$0.l1();
                    if (postSubjectItemL3 != null && (user = postSubjectItemL3.getUser()) != null) {
                        nickname = user.getNickname();
                    }
                    downloadManagerApiA.W1(fragmentActivityRequireActivity, subject3, str3, "postdetail", str4, str5, nickname);
                }
            }
        });
    }

    public static final void J1(PostDetailCommonFragment this$0, View view) {
        Group group;
        Intrinsics.g(this$0, "this$0");
        Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/room/detail");
        PostSubjectItem postSubjectItem = this$0.f55749n;
        postcardB.withString("id", (postSubjectItem == null || (group = postSubjectItem.getGroup()) == null) ? null : group.getGroupId()).navigation();
        com.transsion.postdetail.helper.a.k(com.transsion.postdetail.helper.a.f55063a, this$0.f55749n, null, null, 6, null);
    }

    private final void f1() {
        Subject subject;
        ConstraintLayout root;
        Context context = getContext();
        Boolean hasResource = null;
        DownloadView downloadView = context != null ? new DownloadView(context) : null;
        this.f55752q = downloadView;
        if (downloadView != null) {
            downloadView.setPageFrom(getPageName());
        }
        DownloadView downloadView2 = this.f55752q;
        if (downloadView2 != null) {
            DownloadView.setAttrs$default(downloadView2, null, Float.valueOf(com.transsion.core.utils.e.g(16.0f)), null, 5, null);
        }
        DownloadView downloadView3 = this.f55752q;
        if (downloadView3 != null) {
            Context context2 = getContext();
            downloadView3.setBackground(context2 != null ? z2.a.getDrawable(context2, R$drawable.bg_btn_radius_20) : null);
        }
        ConstraintLayout.b bVar = new ConstraintLayout.b(com.transsion.core.utils.e.a(140.0f), com.transsion.core.utils.e.a(40.0f));
        int i11 = R$id.cl_container;
        bVar.f7299l = i11;
        bVar.f7315t = i11;
        bVar.f7319v = i11;
        bVar.setMargins(0, 0, 0, com.transsion.core.utils.e.a(48.0f));
        tv.m mViewBinding = getMViewBinding();
        if (mViewBinding != null && (root = mViewBinding.getRoot()) != null) {
            root.addView(this.f55752q, -1, bVar);
        }
        DownloadView downloadView4 = this.f55752q;
        if (downloadView4 != null) {
            downloadView4.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws InterruptedException {
                    PostDetailCommonFragment.g1(this.f55859a, view);
                }
            });
        }
        PostSubjectItem postSubjectItem = this.f55749n;
        if (postSubjectItem != null && (subject = postSubjectItem.getSubject()) != null) {
            hasResource = subject.getHasResource();
        }
        H1(hasResource);
    }

    public static final void g1(PostDetailCommonFragment this$0, View view) throws InterruptedException {
        String resourceLink;
        User user;
        Subject subject;
        ResourceDetectors resourceDetector;
        Group group;
        Subject subject2;
        String subjectId;
        Subject subject3;
        Subject subject4;
        ResourceDetectors resourceDetector2;
        Subject subject5;
        Intrinsics.g(this$0, "this$0");
        DownloadManagerApi.a aVar = DownloadManagerApi.f60274j;
        DownloadManagerApi downloadManagerApiA = aVar.a();
        PostSubjectItem postSubjectItem = this$0.f55749n;
        String nickname = null;
        String subjectId2 = (postSubjectItem == null || (subject5 = postSubjectItem.getSubject()) == null) ? null : subject5.getSubjectId();
        PostSubjectItem postSubjectItem2 = this$0.f55749n;
        String resourceId = (postSubjectItem2 == null || (subject4 = postSubjectItem2.getSubject()) == null || (resourceDetector2 = subject4.getResourceDetector()) == null) ? null : resourceDetector2.getResourceId();
        PostSubjectItem postSubjectItem3 = this$0.f55749n;
        if (DownloadManagerApi.n2(downloadManagerApiA, subjectId2, resourceId, (postSubjectItem3 == null || (subject3 = postSubjectItem3.getSubject()) == null) ? false : subject3.isSeries(), false, 8, null)) {
            PostSubjectItem postSubjectItem4 = this$0.f55749n;
            if (postSubjectItem4 == null || (subject2 = postSubjectItem4.getSubject()) == null || (subjectId = subject2.getSubjectId()) == null) {
                return;
            }
            DownloadManagerApi downloadManagerApiA2 = aVar.a();
            Context context = this$0.getContext();
            Intrinsics.d(context);
            DownloadManagerApi.p2(downloadManagerApiA2, subjectId, context, this$0.getPageName(), null, 8, null);
            return;
        }
        DownloadManagerApi downloadManagerApiA3 = aVar.a();
        Context context2 = this$0.getContext();
        Intrinsics.e(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentActivity fragmentActivity = (FragmentActivity) context2;
        PostSubjectItem postSubjectItem5 = this$0.f55749n;
        Subject subject6 = postSubjectItem5 != null ? postSubjectItem5.getSubject() : null;
        String pageName = this$0.getPageName();
        PostSubjectItem postSubjectItem6 = this$0.f55749n;
        String groupId = (postSubjectItem6 == null || (group = postSubjectItem6.getGroup()) == null) ? null : group.getGroupId();
        PostSubjectItem postSubjectItem7 = this$0.f55749n;
        String ops = postSubjectItem7 != null ? postSubjectItem7.getOps() : null;
        PostSubjectItem postSubjectItem8 = this$0.f55749n;
        if (postSubjectItem8 == null || (subject = postSubjectItem8.getSubject()) == null || (resourceDetector = subject.getResourceDetector()) == null || (resourceLink = resourceDetector.getResourceLink()) == null) {
            resourceLink = "";
        }
        String str = resourceLink;
        PostSubjectItem postSubjectItem9 = this$0.f55749n;
        if (postSubjectItem9 != null && (user = postSubjectItem9.getUser()) != null) {
            nickname = user.getNickname();
        }
        downloadManagerApiA3.P1(fragmentActivity, subject6, pageName, (960 & 8) != 0 ? "" : groupId, ops, str, (960 & 64) != 0 ? "" : null, (960 & 128) != 0 ? null : null, (960 & 256) != 0 ? null : nickname, (960 & 512) != 0 ? false : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    public final void h1() {
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
        PostSubjectItem postSubjectItem2 = this.f55749n;
        Audio audio2 = (postSubjectItem2 == null || (media2 = postSubjectItem2.getMedia()) == null || (audio = media2.getAudio()) == null) ? null : audio.get(0);
        PostSubjectItem postSubjectItem3 = this.f55749n;
        String title = postSubjectItem3 != null ? postSubjectItem3.getTitle() : null;
        if (TextUtils.isEmpty(title)) {
            PostSubjectItem postSubjectItem4 = this.f55749n;
            title = postSubjectItem4 != null ? postSubjectItem4.getContent() : null;
        }
        String str2 = title;
        PostSubjectItem postSubjectItem5 = this.f55749n;
        String coverUrl$default = postSubjectItem5 != null ? PostSubjectItem.getCoverUrl$default(postSubjectItem5, false, 1, null) : null;
        if (TextUtils.isEmpty(coverUrl$default) && ((postSubjectItem = this.f55749n) == null || (media = postSubjectItem.getMedia()) == null || (cover = media.getCover()) == null || (coverUrl$default = cover.getUrl()) == null)) {
            coverUrl$default = "";
        }
        String str3 = coverUrl$default;
        PostSubjectItem postSubjectItem6 = this.f55749n;
        if ((postSubjectItem6 != null ? postSubjectItem6.getSubject() : null) != null) {
            PostSubjectItem postSubjectItem7 = this.f55749n;
            if (postSubjectItem7 == null || (subject4 = postSubjectItem7.getSubject()) == null || (resourceDetector2 = subject4.getResourceDetector()) == null) {
                str = null;
            } else {
                url = resourceDetector2.getResourceId();
                str = url;
            }
        } else if (audio2 != null) {
            url = audio2.getUrl();
            str = url;
        } else {
            str = null;
        }
        DownloadBean downloadBean = new DownloadBean((audio2 == null || (url2 = audio2.getUrl()) == null) ? "" : url2, str, str2, str3, (audio2 == null || (size = audio2.getSize()) == null) ? null : Long.valueOf(size.intValue()), "", null, null, null, null, 0L, 0, 0, 1, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -8256, 1073741823, null);
        PostSubjectItem postSubjectItem8 = this.f55749n;
        downloadBean.setPostId(postSubjectItem8 != null ? postSubjectItem8.getPostId() : null);
        PostSubjectItem postSubjectItem9 = this.f55749n;
        downloadBean.setSubjectId((postSubjectItem9 == null || (subject3 = postSubjectItem9.getSubject()) == null) ? null : subject3.getSubjectId());
        PostSubjectItem postSubjectItem10 = this.f55749n;
        downloadBean.setSubjectName((postSubjectItem10 == null || (subject2 = postSubjectItem10.getSubject()) == null) ? null : subject2.getTitle());
        DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
        Context context = getContext();
        Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentActivity fragmentActivity = (FragmentActivity) context;
        PostSubjectItem postSubjectItem11 = this.f55749n;
        String ops = postSubjectItem11 != null ? postSubjectItem11.getOps() : null;
        PostSubjectItem postSubjectItem12 = this.f55749n;
        String str4 = (postSubjectItem12 == null || (subject = postSubjectItem12.getSubject()) == null || (resourceDetector = subject.getResourceDetector()) == null || (resourceLink = resourceDetector.getResourceLink()) == null) ? "" : resourceLink;
        PostSubjectItem postSubjectItem13 = this.f55749n;
        DownloadManagerApi.U1(downloadManagerApiA, fragmentActivity, downloadBean, "post_audio_detail", ops, str4, postSubjectItem13 != null ? postSubjectItem13.getSubject() : null, null, 64, null);
        com.transsion.postdetail.helper.a.i(com.transsion.postdetail.helper.a.f55063a, this.f55749n, getPageName(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.transsion.postdetail.viewmodel.PostDetailViewModel] */
    public final void i1() {
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.no_network_tips);
            return;
        }
        PostSubjectItem postSubjectItem = this.f55749n;
        ?? B = postSubjectItem != null ? Intrinsics.b(postSubjectItem.getHasLike(), Boolean.TRUE) : 0;
        ?? O1 = o1();
        PostSubjectItem postSubjectItem2 = this.f55749n;
        O1.v(postSubjectItem2 != null ? postSubjectItem2.getPostId() : null, B);
        com.transsion.postdetail.helper.a aVar = com.transsion.postdetail.helper.a.f55063a;
        PostSubjectItem postSubjectItem3 = this.f55749n;
        com.transsion.postdetail.helper.a.n(aVar, postSubjectItem3, postSubjectItem3 != null ? Intrinsics.b(postSubjectItem3.getHasLike(), Boolean.TRUE) : false, getPageName(), null, 8, null);
    }

    private final void initPlayer() {
        com.transsion.ninegridview.a aVar = new com.transsion.ninegridview.a();
        aVar.h();
        aVar.i();
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        aVar.j(contextRequireContext);
        bv.a aVarG = aVar.g();
        if (aVarG != null) {
            aVarG.a();
        }
        bv.a aVarG2 = aVar.g();
        if (aVarG2 != null) {
            PostSubjectItem postSubjectItem = this.f55749n;
            tv.m mViewBinding = getMViewBinding();
            aVarG2.s(postSubjectItem, mViewBinding != null ? mViewBinding.f77849s : null, 0);
        }
        bv.a aVarG3 = aVar.g();
        if (aVarG3 != null) {
            aVarG3.y(true);
        }
        this.f55754s = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:16:0x0032  */
    public final void j1() {
        boolean z11;
        User user;
        User user2;
        UserInfo userInfoP = k1().P();
        if ((userInfoP != null ? userInfoP.getUserId() : null) != null) {
            String userId = userInfoP.getUserId();
            PostSubjectItem postSubjectItem = this.f55749n;
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
        PostSubjectItem postSubjectItem2 = this.f55749n;
        String postId = postSubjectItem2 != null ? postSubjectItem2.getPostId() : null;
        PostSubjectItem postSubjectItem3 = this.f55749n;
        String userId2 = (postSubjectItem3 == null || (user = postSubjectItem3.getUser()) == null) ? null : user.getUserId();
        String value = ReportType.POST.getValue();
        PostSubjectItem postSubjectItem4 = this.f55749n;
        ShareDialogFragment shareDialogFragmentA = aVar.a(postType, postId, userId2, value, (3072 & 16) != 0 ? "" : postSubjectItem4 != null ? postSubjectItem4.getTitle() : null, (3072 & 32) != 0 ? "" : "", (3072 & 64) != 0 ? false : false, (3072 & 128) != 0 ? false : z11, (3072 & 256) != 0 ? false : false, "postdetail", (3072 & 1024) != 0 ? "" : this.f55746k, (3072 & 2048) != 0 ? "" : null);
        shareDialogFragmentA.E0(new b());
        shareDialogFragmentA.show(getChildFragmentManager(), AppLovinEventTypes.USER_SHARED_LINK);
        com.transsion.postdetail.helper.a.z(com.transsion.postdetail.helper.a.f55063a, this.f55749n, getPageName(), null, 4, null);
    }

    private final ILoginApi k1() {
        return (ILoginApi) this.f55753r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PostDetailViewModel o1() {
        return (PostDetailViewModel) this.f55751p.getValue();
    }

    public static final void s1(PostDetailCommonFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void t1(PostDetailCommonFragment this$0, View view) {
        User user;
        Intrinsics.g(this$0, "this$0");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/profile/user_center");
        PostSubjectItem postSubjectItem = this$0.f55749n;
        postcardB.withString("userId", (postSubjectItem == null || (user = postSubjectItem.getUser()) == null) ? null : user.getUserId()).navigation();
        com.transsion.postdetail.helper.a.d(com.transsion.postdetail.helper.a.f55063a, this$0.f55749n, null, null, 6, null);
    }

    private final void u1() {
        Unit unit;
        String subjectId;
        PostSubjectItem postSubjectItem = this.f55749n;
        if (postSubjectItem != null) {
            if (postSubjectItem != null) {
                postSubjectItem.setTran_ops(this.f55746k);
            }
            I1();
            Subject subject = postSubjectItem.getSubject();
            if (subject != null && (subjectId = subject.getSubjectId()) != null && subjectId.length() == 0) {
                PostDetailViewModel postDetailViewModelO1 = o1();
                String str = this.f55747l;
                if (str == null) {
                    str = "";
                }
                postDetailViewModelO1.n(str);
            }
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        if (unit == null) {
            K0();
            PostDetailViewModel postDetailViewModelO2 = o1();
            String str2 = this.f55747l;
            postDetailViewModelO2.n(str2 != null ? str2 : "");
        }
    }

    private final void v1() {
        Context context = getContext();
        Intrinsics.e(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1<AddToDownloadEvent, Unit> function1 = new Function1<AddToDownloadEvent, Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommonFragment$observeAddToDownload$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AddToDownloadEvent addToDownloadEvent) {
                invoke2(addToDownloadEvent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AddToDownloadEvent value) {
                Subject subject;
                Subject subject2;
                Intrinsics.g(value, "value");
                try {
                    String subjectId = value.getSubjectId();
                    PostSubjectItem postSubjectItemL1 = this.this$0.l1();
                    if (TextUtils.equals(subjectId, (postSubjectItemL1 == null || (subject2 = postSubjectItemL1.getSubject()) == null) ? null : subject2.getSubjectId())) {
                        PostDetailCommonFragment postDetailCommonFragment = this.this$0;
                        PostSubjectItem postSubjectItemL2 = postDetailCommonFragment.l1();
                        postDetailCommonFragment.H1((postSubjectItemL2 == null || (subject = postSubjectItemL2.getSubject()) == null) ? null : subject.getHasResource());
                    }
                } catch (Exception unused) {
                    uo.b.a.g(uo.b.f78622a, " callback change data fail", false, 2, null);
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = AddToDownloadEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent((AppCompatActivity) context, name, Lifecycle.State.CREATED, kotlinx.coroutines.w0.c().q(), false, function1);
    }

    private final void w1() {
        Function1<LikeEvent, Unit> function1 = new Function1<LikeEvent, Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommonFragment$observeLike$1
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
                PostDetailCommonFragment postDetailCommonFragment = this.this$0;
                try {
                    Result.Companion companion = Result.Companion;
                    PostSubjectItem postSubjectItemL1 = postDetailCommonFragment.l1();
                    Long lValueOf = null;
                    if (TextUtils.equals(postSubjectItemL1 != null ? postSubjectItemL1.getPostId() : null, value.getSubjectId())) {
                        PostSubjectItem postSubjectItemL2 = postDetailCommonFragment.l1();
                        if (postSubjectItemL2 != null) {
                            postSubjectItemL2.setHasLike(Boolean.valueOf(value.getLike()));
                        }
                        if (value.getLike()) {
                            PostSubjectItem postSubjectItemL3 = postDetailCommonFragment.l1();
                            Stat stat3 = postSubjectItemL3 != null ? postSubjectItemL3.getStat() : null;
                            if (stat3 != null) {
                                PostSubjectItem postSubjectItemL4 = postDetailCommonFragment.l1();
                                if (postSubjectItemL4 != null && (stat2 = postSubjectItemL4.getStat()) != null && (likeCount2 = stat2.getLikeCount()) != null) {
                                    lValueOf = Long.valueOf(likeCount2.longValue() + 1);
                                }
                                stat3.setLikeCount(lValueOf);
                            }
                        } else {
                            PostSubjectItem postSubjectItemL5 = postDetailCommonFragment.l1();
                            Stat stat4 = postSubjectItemL5 != null ? postSubjectItemL5.getStat() : null;
                            if (stat4 != null) {
                                PostSubjectItem postSubjectItemL6 = postDetailCommonFragment.l1();
                                if (postSubjectItemL6 != null && (stat = postSubjectItemL6.getStat()) != null && (likeCount = stat.getLikeCount()) != null) {
                                    lValueOf = Long.valueOf(likeCount.longValue() - 1);
                                }
                                stat4.setLikeCount(lValueOf);
                            }
                        }
                        postDetailCommonFragment.z1();
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

    public final void A1() {
        ImmVideoCommentDialog immVideoCommentDialogB = ImmVideoCommentDialog.a.b(ImmVideoCommentDialog.f55600n, this.f55749n, null, null, null, 14, null);
        immVideoCommentDialogB.y0(new d());
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.f(childFragmentManager, "childFragmentManager");
        immVideoCommentDialogB.show(childFragmentManager, "PostDetailCommentsFragment.TAG_POST_DETAIL_COMMENTS_FRAGMENT");
    }

    public final void B1(Media media) {
        NineGridVideoView nineGridVideoView;
        tv.m mViewBinding = getMViewBinding();
        if (mViewBinding == null || (nineGridVideoView = mViewBinding.f77849s) == null) {
            return;
        }
        if ((media != null ? media.getImage() : null) == null) {
            so.c.g(nineGridVideoView);
        } else {
            List<Image> image = media.getImage();
            if (image != null) {
                nineGridVideoView.setAdapter(new NineGridVideoViewAdapter(image));
                nineGridVideoView.loadImage();
            }
            so.c.k(nineGridVideoView);
        }
        if (bv.b.a(media)) {
            nineGridVideoView.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.f0
                @Override // java.lang.Runnable
                public final void run() {
                    PostDetailCommonFragment.C1(this.f55880a);
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void D0() {
        Serializable serializable;
        super.D0();
        Bundle arguments = getArguments();
        PostSubjectItem postSubjectItem = null;
        this.f55747l = arguments != null ? arguments.getString("id") : null;
        Bundle arguments2 = getArguments();
        this.f55748m = arguments2 != null ? arguments2.getBoolean("from_comment") : false;
        Bundle arguments3 = getArguments();
        this.f55746k = arguments3 != null ? arguments3.getString("rec_ops") : null;
        Bundle arguments4 = getArguments();
        if (arguments4 != null && (serializable = arguments4.getSerializable("item_object")) != null) {
            postSubjectItem = (PostSubjectItem) serializable;
        }
        this.f55749n = postSubjectItem;
    }

    public final void D1(String str, final String str2, final String str3) {
        final tv.j0 j0Var;
        tv.l0 l0Var;
        tv.m mViewBinding = getMViewBinding();
        if (mViewBinding != null && (l0Var = mViewBinding.f77856z) != null) {
            if (TextUtils.isEmpty(str)) {
                AppCompatTextView tvPostTitle = l0Var.f77831b;
                Intrinsics.f(tvPostTitle, "tvPostTitle");
                so.c.g(tvPostTitle);
            } else {
                AppCompatTextView tvPostTitle2 = l0Var.f77831b;
                Intrinsics.f(tvPostTitle2, "tvPostTitle");
                so.c.k(tvPostTitle2);
                l0Var.f77831b.setText(str);
            }
        }
        tv.m mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (j0Var = mViewBinding2.f77854x) == null) {
            return;
        }
        j0Var.f77809b.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.e0
            @Override // java.lang.Runnable
            public final void run() {
                PostDetailCommonFragment.E1(str2, j0Var, str3, this);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    public final void F1(Integer num) {
        tv.k0 k0Var;
        tv.m mViewBinding = getMViewBinding();
        if (mViewBinding == null || (k0Var = mViewBinding.f77840j) == null) {
            return;
        }
        if (num == null || num.intValue() <= 0) {
            ConstraintLayout clRating = k0Var.f77814b;
            Intrinsics.f(clRating, "clRating");
            so.c.g(clRating);
            return;
        }
        ConstraintLayout clRating2 = k0Var.f77814b;
        Intrinsics.f(clRating2, "clRating");
        so.c.k(clRating2);
        StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
        String string = getString(com.transsion.postdetail.R$string.score);
        Intrinsics.f(string, "getString(R.string.score)");
        String str = String.format(string, Arrays.copyOf(new Object[]{num}, 1));
        Intrinsics.f(str, "format(...)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int length = String.valueOf(num).length();
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(16, true), 0, length, 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(z2.a.getColor(requireActivity(), R$color.color_ffaa33)), 0, length, 17);
        k0Var.f77816d.setText(spannableStringBuilder);
    }

    public final void G1() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.f(childFragmentManager, "childFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
        PostRecommendFragment postRecommendFragmentA = PostRecommendFragment.f55774x.a(this.f55747l);
        fragmentTransactionBeginTransaction.replace(R$id.flContainer, postRecommendFragmentA);
        this.f55750o = postRecommendFragmentA;
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    public final void H1(Boolean bool) {
        HashMap<String, String> mapG;
        Subject subject;
        Subject subject2;
        ResourceDetectors resourceDetector;
        Subject subject3;
        if (Intrinsics.b(bool, Boolean.TRUE)) {
            DownloadView downloadView = this.f55752q;
            if (downloadView != null) {
                downloadView.setVisibility(0);
            }
        } else {
            DownloadView downloadView2 = this.f55752q;
            if (downloadView2 != null) {
                downloadView2.setVisibility(8);
            }
        }
        DownloadView downloadView3 = this.f55752q;
        if (downloadView3 != null) {
            PostSubjectItem postSubjectItem = this.f55749n;
            String subjectId = (postSubjectItem == null || (subject3 = postSubjectItem.getSubject()) == null) ? null : subject3.getSubjectId();
            PostSubjectItem postSubjectItem2 = this.f55749n;
            String resourceId = (postSubjectItem2 == null || (subject2 = postSubjectItem2.getSubject()) == null || (resourceDetector = subject2.getResourceDetector()) == null) ? null : resourceDetector.getResourceId();
            PostSubjectItem postSubjectItem3 = this.f55749n;
            DownloadView.setShowType$default(downloadView3, subjectId, resourceId, (postSubjectItem3 == null || (subject = postSubjectItem3.getSubject()) == null) ? null : Boolean.valueOf(subject.isSeries()), false, 0, 24, null);
        }
        DownloadView downloadView4 = this.f55752q;
        String str = (downloadView4 == null || downloadView4.getShowType() != 1) ? "download_subject" : "play_subject";
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (mapG = logViewConfig.g()) == null) {
            return;
        }
        mapG.put(CampaignEx.KEY_SHOW_TYPE, str);
    }

    public final void I1() {
        Subject subject;
        String avatar;
        PostSubjectItem postSubjectItem = this.f55749n;
        if (postSubjectItem != null) {
            tv.m mViewBinding = getMViewBinding();
            Boolean hasResource = null;
            if (mViewBinding != null) {
                AppCompatTextView appCompatTextView = mViewBinding.B;
                User user = postSubjectItem.getUser();
                appCompatTextView.setText(user != null ? user.getNickname() : null);
                ShapeableImageView shapeableImageView = mViewBinding.f77845o;
                int iA = com.blankj.utilcode.util.f0.a(28.0f);
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context contextRequireContext = requireContext();
                Intrinsics.f(contextRequireContext, "requireContext()");
                Intrinsics.f(shapeableImageView, "this");
                User user2 = postSubjectItem.getUser();
                if (user2 == null || (avatar = user2.getAvatar()) == null) {
                    avatar = "";
                }
                companion.r(contextRequireContext, shapeableImageView, avatar, (4088 & 8) != 0 ? companion.d() : iA, (4088 & 16) != 0 ? companion.c() : iA, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
                if (postSubjectItem.getGroup() != null) {
                    AppCompatTextView appCompatTextView2 = mViewBinding.A;
                    Group group = postSubjectItem.getGroup();
                    appCompatTextView2.setText(group != null ? group.getName() : null);
                    AppCompatTextView tvSubject = mViewBinding.A;
                    Intrinsics.f(tvSubject, "tvSubject");
                    so.c.k(tvSubject);
                    mViewBinding.A.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.b0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            PostDetailCommonFragment.J1(this.f55862a, view);
                        }
                    });
                } else {
                    AppCompatTextView tvSubject2 = mViewBinding.A;
                    Intrinsics.f(tvSubject2, "tvSubject");
                    so.c.g(tvSubject2);
                }
                AppCompatTextView appCompatTextView3 = mViewBinding.f77855y;
                if (postSubjectItem.getCreatedAt() == null) {
                    Intrinsics.f(appCompatTextView3, "this");
                    so.c.g(appCompatTextView3);
                } else {
                    Intrinsics.f(appCompatTextView3, "this");
                    so.c.k(appCompatTextView3);
                    String createdAt = postSubjectItem.getCreatedAt();
                    appCompatTextView3.setText(com.transsion.postdetail.util.i.a(createdAt != null ? Long.parseLong(createdAt) : 0L));
                }
                mViewBinding.f77851u.showData(postSubjectItem, getPageName(), new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommonFragment$updatePostDetail$1$1$4
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
                        Subject subject2;
                        String subjectId;
                        Subject subject3;
                        Integer subjectType;
                        if (TextUtils.equals(ActivityStackManager.f49449b.a().b(), ((IMovieDetailService) com.alibaba.android.arouter.launcher.a.d().h(IMovieDetailService.class)).Q0())) {
                            this.this$0.requireActivity().finish();
                            return;
                        }
                        PostSubjectItem postSubjectItemL1 = this.this$0.l1();
                        if (postSubjectItemL1 != null && (subject2 = postSubjectItemL1.getSubject()) != null && (subjectId = subject2.getSubjectId()) != null) {
                            PostDetailCommonFragment postDetailCommonFragment = this.this$0;
                            Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail");
                            PostSubjectItem postSubjectItemL2 = postDetailCommonFragment.l1();
                            Postcard postcardWithString = postcardB.withInt("subject_type", (postSubjectItemL2 == null || (subject3 = postSubjectItemL2.getSubject()) == null || (subjectType = subject3.getSubjectType()) == null) ? SubjectType.MOVIE.getValue() : subjectType.intValue()).withString("id", subjectId);
                            PostSubjectItem postSubjectItemL3 = postDetailCommonFragment.l1();
                            postcardWithString.withString("ops", postSubjectItemL3 != null ? postSubjectItemL3.getOps() : null).navigation();
                        }
                        com.transsion.postdetail.helper.a.B(com.transsion.postdetail.helper.a.f55063a, this.this$0.l1(), null, null, 6, null);
                    }
                });
            }
            F1(postSubjectItem.getSubjectRate());
            B1(postSubjectItem.getMedia());
            y1(postSubjectItem);
            String title = postSubjectItem.getTitle();
            String content = postSubjectItem.getContent();
            Link link = postSubjectItem.getLink();
            D1(title, content, link != null ? link.getUrl() : null);
            p1();
            PostSubjectItem postSubjectItem2 = this.f55749n;
            if (postSubjectItem2 != null && (subject = postSubjectItem2.getSubject()) != null) {
                hasResource = subject.getHasResource();
            }
            H1(hasResource);
            z1();
        }
    }

    public abstract String getPageName();

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        AppCompatImageView appCompatImageView;
        tv.m mViewBinding = getMViewBinding();
        if (mViewBinding != null && (appCompatImageView = mViewBinding.f77846p) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.c0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PostDetailCommonFragment.s1(this.f55865a, view);
                }
            });
        }
        com.transsion.baseui.util.m mVar = com.transsion.baseui.util.m.f51477a;
        View[] viewArr = new View[2];
        tv.m mViewBinding2 = getMViewBinding();
        viewArr[0] = mViewBinding2 != null ? mViewBinding2.f77845o : null;
        tv.m mViewBinding3 = getMViewBinding();
        viewArr[1] = mViewBinding3 != null ? mViewBinding3.B : null;
        mVar.a(viewArr, new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostDetailCommonFragment.t1(this.f55869a, view);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        PostDetailViewModel postDetailViewModelO1 = o1();
        postDetailViewModelO1.q().j(this, new c(new Function1<PostSubjectItem, Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommonFragment$initViewModel$1$1
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
                this.this$0.x1(postSubjectItem);
                PostSubjectItem postSubjectItemL1 = this.this$0.l1();
                if (postSubjectItemL1 != null) {
                    postSubjectItemL1.setTran_ops(this.this$0.f55746k);
                }
                this.this$0.I1();
            }
        }));
        postDetailViewModelO1.j().j(this, new c(new Function1<String, Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommonFragment$initViewModel$1$2
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
                String strM1 = this.this$0.m1();
                if (strM1 != null) {
                    SyncManager.f61414a.a().c(strM1);
                }
                FragmentActivity activity2 = this.this$0.getActivity();
                if (activity2 != null) {
                    activity2.finish();
                }
            }
        }));
        w1();
    }

    public final PostSubjectItem l1() {
        return this.f55749n;
    }

    public final String m1() {
        return this.f55747l;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: n1, reason: merged with bridge method [inline-methods] */
    public tv.m getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        tv.m mVarC = tv.m.c(inflater);
        Intrinsics.f(mVarC, "inflate(inflater)");
        return mVarC;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(getPageName(), false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.transsion.ninegridview.a aVar = this.f55754s;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.transsion.ninegridview.a aVar = this.f55754s;
        if (aVar != null) {
            aVar.k();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.transsion.ninegridview.a aVar = this.f55754s;
        if (aVar != null) {
            aVar.l();
        }
    }

    public abstract void p1();

    public abstract void q1();

    public abstract void r1();

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        G1();
        q1();
        r1();
        u1();
        f1();
        v1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }

    public final void x1(PostSubjectItem postSubjectItem) {
        this.f55749n = postSubjectItem;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean y0() {
        return false;
    }

    public final void y1(PostSubjectItem postSubjectItem) {
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

    public final void z1() {
        PostDetailOperationView postDetailOperationView;
        tv.m mViewBinding = getMViewBinding();
        if (mViewBinding == null || (postDetailOperationView = mViewBinding.f77850t) == null) {
            return;
        }
        postDetailOperationView.showData(this.f55749n, new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommonFragment$showBottomLayout$1
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
                this.this$0.i1();
            }
        }, new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommonFragment$showBottomLayout$2
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
                this.this$0.A1();
            }
        }, new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommonFragment$showBottomLayout$3
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
                this.this$0.j1();
            }
        }, new Function0<Unit>() { // from class: com.transsion.postdetail.ui.fragment.PostDetailCommonFragment$showBottomLayout$4
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
                this.this$0.h1();
            }
        });
    }
}
