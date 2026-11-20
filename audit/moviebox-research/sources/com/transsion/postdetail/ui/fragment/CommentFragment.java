package com.transsion.postdetail.ui.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.logging.type.LogSeverity;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.view.DefaultView;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.postdetail.R$drawable;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.R$string;
import com.transsion.postdetail.bean.CommentBean;
import com.transsion.postdetail.bean.CommentBody;
import com.transsion.postdetail.bean.CommentLikeBean;
import com.transsion.postdetail.bean.CommentLikeBody;
import com.transsion.postdetail.bean.CommentListBean;
import com.transsion.postdetail.bean.Pager;
import com.transsion.postdetail.comment.CommentDeleteDialogFragment;
import com.transsion.postdetail.comment.SocialStatus;
import com.transsion.postdetail.viewmodel.CommentViewModel;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.ui.SelectImageActivity;
import com.transsion.upload.bean.UploadFileType;
import com.transsion.upload.bean.UploadTstTokenStorageType;
import com.transsion.web.api.WebConstants;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.SyncManager;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;

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
public final class CommentFragment extends BaseFragment<tv.i> implements com.transsion.postdetail.comment.a0, com.transsion.postdetail.comment.y {
    public static final a F = new a(null);
    public boolean A;
    public Editable B;
    public long C;
    public Function2<? super String, ? super Boolean, Unit> D;
    public CommentDeleteDialogFragment E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f55633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f55634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.transsion.postdetail.comment.l f55635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.transsion.postdetail.comment.k f55636d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.transsion.postdetail.util.h f55637f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.transsion.postdetail.comment.e f55638g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CommentListBean f55639h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CommentViewModel f55640i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f55641j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f55644m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f55646o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f55647p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CommentBean f55648q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f55649r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f55650s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f55651t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f55653v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public b f55654w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f55655x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f55656y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public b1.b<Intent> f55657z;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f55642k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f55643l = 10;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f55645n = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f55652u = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.postdetail.ui.fragment.CommentFragment$loginApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ILoginApi invoke() {
            return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final CommentFragment a(String str, long j11, boolean z11, boolean z12, String commentId, String str2) {
            Intrinsics.g(commentId, "commentId");
            CommentFragment commentFragment = new CommentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("POST_ID", str);
            bundle.putLong("comment_count", j11);
            bundle.putBoolean("show_download", z11);
            bundle.putBoolean("from_detail", z12);
            bundle.putString(WebConstants.PAGE_FROM, str2);
            if (commentId.length() > 0) {
                bundle.putString("comment_id", commentId);
            }
            commentFragment.setArguments(bundle);
            return commentFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface b {
        void a(long j11);
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements com.tn.lib.util.networkinfo.g {
        public c() {
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected() {
            com.tn.lib.util.networkinfo.g.a.a(this);
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.g(network, "network");
            Intrinsics.g(networkCapabilities, "networkCapabilities");
            com.transsion.postdetail.comment.l lVar = CommentFragment.this.f55635c;
            if (lVar == null || !lVar.Z()) {
                return;
            }
            CommentFragment.this.P0();
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onDisconnected() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements com.transsion.postdetail.util.h.a {
        public d() {
        }

        @Override // com.transsion.postdetail.util.h.a
        public void a(int i11) {
            com.transsion.postdetail.comment.e eVar = CommentFragment.this.f55638g;
            if (eVar != null) {
                CommentFragment commentFragment = CommentFragment.this;
                if (eVar.isShowing() && commentFragment.f55647p) {
                    eVar.dismiss();
                }
            }
        }

        @Override // com.transsion.postdetail.util.h.a
        public void b(int i11) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements CommentDeleteDialogFragment.b {
        public e() {
        }

        @Override // com.transsion.postdetail.comment.CommentDeleteDialogFragment.b
        public void a(String str) {
            CommentFragment.this.H0(str);
            CommentFragment.this.T0("delete_comment", str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f implements ty.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2<String, String, Unit> f55661a;

        /* JADX WARN: Multi-variable type inference failed */
        public f(Function2<? super String, ? super String, Unit> function2) {
            this.f55661a = function2;
        }

        @Override // ty.a
        public void a(String localFilePath, long j11, long j12) {
            Intrinsics.g(localFilePath, "localFilePath");
        }

        @Override // ty.a
        public void b(String localFilePath, String url, String bucket) {
            Intrinsics.g(localFilePath, "localFilePath");
            Intrinsics.g(url, "url");
            Intrinsics.g(bucket, "bucket");
            this.f55661a.invoke(url, bucket);
        }

        @Override // ty.a
        public void c(String localFilePath, String str, String str2, UploadTstTokenStorageType uploadTstTokenStorageType) {
            Intrinsics.g(localFilePath, "localFilePath");
            uo.b.a.g(uo.b.f78622a, "uploadKey: " + localFilePath + "; clientMessage:" + str + "; serviceMessage: " + str2, false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F0(cw.a aVar) {
        com.transsion.postdetail.comment.k kVarL;
        List<PhotoEntity> listH = aVar.h();
        if (listH == null || listH.isEmpty()) {
            return;
        }
        this.f55653v = listH.get(0).getLocalPath();
        PhotoEntity photoEntity = listH.get(0);
        com.transsion.postdetail.comment.e eVar = this.f55638g;
        if (eVar == null || (kVarL = eVar.l()) == null) {
            return;
        }
        kVarL.w(photoEntity);
    }

    private final void K0() {
        Context context;
        if (this.f55635c != null || (context = getContext()) == null) {
            return;
        }
        com.transsion.postdetail.comment.l lVar = new com.transsion.postdetail.comment.l(this);
        h9.f fVarQ = lVar.Q();
        fVarQ.y(true);
        fVarQ.x(true);
        fVarQ.C(new f9.f() { // from class: com.transsion.postdetail.ui.fragment.d
            @Override // f9.f
            public final void a() {
                CommentFragment.L0(this.f55868a);
            }
        });
        this.f55635c = lVar;
        RecyclerView recyclerView = this.f55633a;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        }
        RecyclerView recyclerView2 = this.f55633a;
        if (recyclerView2 == null) {
            return;
        }
        recyclerView2.setAdapter(this.f55635c);
    }

    public static final void L0(CommentFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.Q0();
    }

    private final void N0() {
        setNetListener(new c());
    }

    public static final void O0(CommentFragment this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        if (activityResult.getResultCode() != -1) {
            uo.b.a.f(uo.b.f78622a, "loginStatus", "登录失败或者取消", false, 4, null);
            return;
        }
        uo.b.a.f(uo.b.f78622a, "loginStatus", "登录成功", false, 4, null);
        com.tn.lib.widget.toast.core.h hVar = com.tn.lib.widget.toast.core.h.f50034a;
        ILoginApi loginApi = this$0.getLoginApi();
        hVar.l(loginApi != null ? loginApi.b() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P0() {
        com.transsion.postdetail.comment.l lVar;
        if (this.f55639h == null && (((lVar = this.f55635c) == null || (lVar != null && lVar.getItemCount() == 0)) && !com.tn.lib.util.networkinfo.f.f49475a.e())) {
            c1();
            return;
        }
        startLoading();
        CommentViewModel commentViewModel = this.f55640i;
        if (commentViewModel != null) {
            String str = this.f55641j;
            if (str == null) {
                str = "";
            }
            String strValueOf = String.valueOf(this.f55642k);
            int i11 = this.f55643l;
            String str2 = this.f55655x;
            if (str2 == null) {
                str2 = "";
            }
            commentViewModel.f(str, "0", strValueOf, i11, str2);
        }
    }

    private final void Q0() {
        CommentViewModel commentViewModel = this.f55640i;
        if (commentViewModel != null) {
            String str = this.f55641j;
            if (str == null) {
                str = "";
            }
            int i11 = this.f55642k + 1;
            this.f55642k = i11;
            commentViewModel.f(str, "0", String.valueOf(i11), this.f55643l, "");
        }
    }

    public static /* synthetic */ void U0(CommentFragment commentFragment, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "";
        }
        commentFragment.T0(str, str2);
    }

    private final void Z0() {
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        DefaultView defaultView = new DefaultView(contextRequireContext);
        defaultView.setStyle(DefaultView.DefaultViewStyle.STYLE_IMAGE_DES);
        String string = getString(R$string.comment_empty);
        Intrinsics.f(string, "getString(R.string.comment_empty)");
        defaultView.setDescText(string);
        defaultView.setDefaultImage(R$drawable.icon_comment_empty);
        defaultView.setMinimumHeight(com.blankj.utilcode.util.f0.a(250.0f));
        com.transsion.postdetail.comment.l lVar = this.f55635c;
        if (lVar != null) {
            lVar.r0(defaultView);
        }
    }

    public static final void b1(CommentFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.g(this$0, "this$0");
        if (dialogInterface instanceof com.transsion.postdetail.comment.e) {
            com.transsion.postdetail.comment.k kVarL = ((com.transsion.postdetail.comment.e) dialogInterface).l();
            Editable editableH = kVarL != null ? kVarL.h() : null;
            this$0.B = editableH;
            uo.b.a.f(uo.b.f78622a, "CommentFragment", "text=" + ((Object) editableH), false, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c1() {
        TextView textView;
        TextView textView2;
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        View view = LayoutInflater.from(requireContext()).inflate(R$layout.post_detail_no_comment, (ViewGroup) null);
        if (view != null && (textView2 = (TextView) view.findViewById(R$id.tv_status)) != null) {
            textView2.setText(R$string.base_net_err);
            textView2.setTextSize(12.0f);
            textView2.setVisibility(0);
        }
        if (view != null && (textView = (TextView) view.findViewById(R$id.tv_retry)) != null) {
            textView.setText(R$string.comment_retry);
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CommentFragment.d1(this.f55861a, view2);
                }
            });
        }
        com.transsion.postdetail.comment.l lVar = this.f55635c;
        if (lVar != null) {
            Intrinsics.f(view, "view");
            lVar.r0(view);
        }
    }

    private final boolean checkLogin() {
        ILoginApi loginApi = getLoginApi();
        if (loginApi != null && !loginApi.N()) {
            if (this.f55657z == null) {
                this.A = true;
            }
            if (isAdded() && !isDetached() && !isRemoving()) {
                b1.b<Intent> bVar = this.f55657z;
                if (bVar == null) {
                    return false;
                }
                Context contextRequireContext = requireContext();
                Intrinsics.f(contextRequireContext, "requireContext()");
                Intent intentO1 = loginApi.o1(contextRequireContext);
                intentO1.putExtra("title_name", getString(R$string.comment_login_title));
                bVar.a(intentO1);
                return false;
            }
        }
        return true;
    }

    public static final void d1(CommentFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.base_net_err);
        } else {
            this$0.P0();
            U0(this$0, "retry", null, 2, null);
        }
    }

    private final ILoginApi getLoginApi() {
        return (ILoginApi) this.f55652u.getValue();
    }

    private final void initViewModel() {
        CommentViewModel commentViewModel = (CommentViewModel) new androidx.lifecycle.v0(this).a(CommentViewModel.class);
        commentViewModel.i().j(getViewLifecycleOwner(), new g(new Function1<CommentListBean, Unit>() { // from class: com.transsion.postdetail.ui.fragment.CommentFragment$initViewModel$1$1
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
                h9.f fVarQ;
                com.transsion.postdetail.comment.l lVar;
                this.this$0.hideLoading();
                if (commentListBean != null || ((this.this$0.f55635c != null && ((lVar = this.this$0.f55635c) == null || lVar.getItemCount() != 0)) || com.tn.lib.util.networkinfo.f.f49475a.e())) {
                    CommentFragment commentFragment = this.this$0;
                    commentFragment.W0(commentFragment.f55641j, commentListBean);
                    this.this$0.E0(commentListBean);
                } else {
                    this.this$0.c1();
                    com.transsion.postdetail.comment.l lVar2 = this.this$0.f55635c;
                    if (lVar2 == null || (fVarQ = lVar2.Q()) == null) {
                        return;
                    }
                    fVarQ.r();
                }
            }
        }));
        commentViewModel.j().j(getViewLifecycleOwner(), new g(new Function1<rv.c, Unit>() { // from class: com.transsion.postdetail.ui.fragment.CommentFragment$initViewModel$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(rv.c cVar) {
                invoke2(cVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(rv.c cVar) {
                List<CommentBean> commentList;
                List<CommentBean> commentList2;
                this.this$0.hideLoading();
                if (cVar == null) {
                    CommentFragment commentFragment = this.this$0;
                    commentFragment.i1(commentFragment.f55639h);
                    return;
                }
                if (this.this$0.f55639h == null) {
                    CommentFragment commentFragment2 = this.this$0;
                    commentFragment2.i1(commentFragment2.f55639h);
                    return;
                }
                CommentListBean commentListBean = this.this$0.f55639h;
                if (commentListBean != null) {
                    CommentListBean commentListBeanB = cVar.b();
                    commentListBean.setPager(commentListBeanB != null ? commentListBeanB.getPager() : null);
                }
                CommentListBean commentListBean2 = this.this$0.f55639h;
                if (commentListBean2 != null && (commentList = commentListBean2.getCommentList()) != null) {
                    for (CommentBean commentBean : commentList) {
                        if (Intrinsics.b(commentBean.getCommentId(), cVar.a().a())) {
                            CommentListBean commentListBeanB2 = cVar.b();
                            if (commentListBeanB2 != null && (commentList2 = commentListBeanB2.getCommentList()) != null) {
                                List<CommentBean> subComments = commentBean.getSubComments();
                                List<CommentBean> listM0 = subComments != null ? CollectionsKt___CollectionsKt.M0(subComments) : null;
                                if (listM0 != null) {
                                    listM0.addAll(commentList2);
                                }
                                commentBean.setSubComments(listM0);
                                break;
                            }
                            break;
                            break;
                        }
                    }
                }
                CommentFragment commentFragment3 = this.this$0;
                commentFragment3.i1(commentFragment3.f55639h);
            }
        }));
        commentViewModel.l().j(getViewLifecycleOwner(), new g(new CommentFragment$initViewModel$1$3(this)));
        commentViewModel.k().j(getViewLifecycleOwner(), new g(new Function1<CommentLikeBean, Unit>() { // from class: com.transsion.postdetail.ui.fragment.CommentFragment$initViewModel$1$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CommentLikeBean commentLikeBean) {
                invoke2(commentLikeBean);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CommentLikeBean commentLikeBean) {
            }
        }));
        commentViewModel.h().j(getViewLifecycleOwner(), new g(new Function1<BaseDto<String>, Unit>() { // from class: com.transsion.postdetail.ui.fragment.CommentFragment$initViewModel$1$5
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
                this.this$0.H0(baseDto != null ? baseDto.getData() : null);
            }
        }));
        this.f55640i = commentViewModel;
    }

    public final void E0(CommentListBean commentListBean) {
        List<CommentBean> commentList;
        Pager pager;
        Pager pager2;
        Integer perPage;
        i1(this.f55639h);
        this.f55643l = (commentListBean == null || (pager2 = commentListBean.getPager()) == null || (perPage = pager2.getPerPage()) == null) ? 10 : perPage.intValue();
        com.transsion.postdetail.comment.l lVar = this.f55635c;
        if (lVar != null) {
            if (lVar.Q().q()) {
                lVar.Q().r();
            }
            if (commentListBean != null && (pager = commentListBean.getPager()) != null && Intrinsics.b(pager.getHasMore(), Boolean.FALSE)) {
                lVar.Q().s(false);
            }
        }
        if (commentListBean != null && (commentList = commentListBean.getCommentList()) != null) {
            for (CommentBean commentBean : commentList) {
                this.f55650s += commentBean.getSubCommentCnt() + 1;
                Long createdAt = commentBean.getCreatedAt();
                this.f55651t = createdAt != null ? createdAt.longValue() : 0L;
            }
        }
        com.transsion.postdetail.comment.l lVar2 = this.f55635c;
        if (lVar2 == null || lVar2.getItemCount() != 0) {
            I0();
        } else {
            Z0();
        }
    }

    @Override // com.transsion.postdetail.comment.y
    public void G(CommentBean commentBean) {
        com.transsion.postdetail.comment.k kVar = this.f55636d;
        CommentBean commentBeanI = kVar != null ? kVar.i() : null;
        if (!Intrinsics.b(commentBeanI != null ? commentBeanI.getCommentId() : null, commentBean != null ? commentBean.getCommentId() : null)) {
            com.transsion.postdetail.comment.k kVar2 = this.f55636d;
            if (kVar2 != null) {
                kVar2.t();
            }
            com.transsion.postdetail.comment.k kVar3 = this.f55636d;
            if (kVar3 != null) {
                kVar3.v(commentBean);
            }
        }
        a1(commentBean);
        U0(this, "reply", null, 2, null);
    }

    public final void G0(ArrayList<CommentBean> arrayList) {
        int i11;
        int i12;
        List<CommentBean> subComments;
        List<CommentBean> commentList;
        List<CommentBean> commentList2;
        List<CommentBean> commentList3;
        List<CommentBean> commentList4;
        List<CommentBean> commentList5;
        List<CommentBean> commentList6;
        CommentListBean commentListBean = this.f55639h;
        if (commentListBean != null) {
            if ((commentListBean != null && (commentList6 = commentListBean.getCommentList()) != null && commentList6.isEmpty()) || arrayList == null || arrayList.isEmpty()) {
                return;
            }
            int i13 = 0;
            for (Object obj : arrayList) {
                int i14 = i13 + 1;
                if (i13 < 0) {
                    kotlin.collections.g.u();
                }
                CommentBean commentBean = (CommentBean) obj;
                CommentListBean commentListBean2 = this.f55639h;
                if (commentListBean2 == null || (commentList5 = commentListBean2.getCommentList()) == null) {
                    i11 = -1;
                    i12 = -1;
                } else {
                    i11 = -1;
                    i12 = -1;
                    int i15 = 0;
                    for (Object obj2 : commentList5) {
                        int i16 = i15 + 1;
                        if (i15 < 0) {
                            kotlin.collections.g.u();
                        }
                        CommentBean commentBean2 = (CommentBean) obj2;
                        String commentId = commentBean.getCommentId();
                        if (TextUtils.equals(commentBean2.getCommentId(), commentId)) {
                            i11 = i15;
                        } else {
                            List<CommentBean> subComments2 = commentBean2.getSubComments();
                            if (subComments2 != null) {
                                int i17 = 0;
                                for (Object obj3 : subComments2) {
                                    int i18 = i17 + 1;
                                    if (i17 < 0) {
                                        kotlin.collections.g.u();
                                    }
                                    CommentBean commentBean3 = (CommentBean) obj3;
                                    if (TextUtils.equals(commentId, commentBean3 != null ? commentBean3.getCommentId() : null)) {
                                        i11 = i15;
                                        i12 = i17;
                                    }
                                    i17 = i18;
                                }
                            }
                        }
                        i15 = i16;
                    }
                }
                if (i11 != -1 || i12 != -1) {
                    if (i11 == -1 || i12 != -1) {
                        CommentListBean commentListBean3 = this.f55639h;
                        Integer numValueOf = (commentListBean3 == null || (commentList2 = commentListBean3.getCommentList()) == null) ? null : Integer.valueOf(commentList2.size());
                        Intrinsics.d(numValueOf);
                        if (numValueOf.intValue() >= i11) {
                            CommentListBean commentListBean4 = this.f55639h;
                            CommentBean commentBean4 = (commentListBean4 == null || (commentList = commentListBean4.getCommentList()) == null) ? null : commentList.get(i11);
                            CommentBean commentBeanRemove = (commentBean4 == null || (subComments = commentBean4.getSubComments()) == null) ? null : subComments.remove(i12);
                            uo.b.a.f(uo.b.f78622a, "deleteComment list:", "remove childMsg:" + (commentBeanRemove != null ? commentBeanRemove.getContent() : null), false, 4, null);
                        } else {
                            uo.b.a.f(uo.b.f78622a, "deleteComment list:", "remove childMsg: index ", false, 4, null);
                        }
                    } else {
                        CommentListBean commentListBean5 = this.f55639h;
                        Integer numValueOf2 = (commentListBean5 == null || (commentList4 = commentListBean5.getCommentList()) == null) ? null : Integer.valueOf(commentList4.size());
                        Intrinsics.d(numValueOf2);
                        if (numValueOf2.intValue() >= i11) {
                            CommentListBean commentListBean6 = this.f55639h;
                            CommentBean commentBeanRemove2 = (commentListBean6 == null || (commentList3 = commentListBean6.getCommentList()) == null) ? null : commentList3.remove(i11);
                            uo.b.a.f(uo.b.f78622a, "deleteComment list:", "remove parentsMsg:" + (commentBeanRemove2 != null ? commentBeanRemove2.getContent() : null), false, 4, null);
                        } else {
                            uo.b.a.f(uo.b.f78622a, "deleteComment list:", "remove parentsMsg: index ", false, 4, null);
                        }
                    }
                }
                i13 = i14;
            }
        }
    }

    public final void H0(String str) {
        try {
            f1(str);
        } catch (Exception e11) {
            String message = e11.getMessage();
            if (message != null) {
                uo.b.a.f(uo.b.f78622a, "deleteComment", message, false, 4, null);
            }
        }
    }

    public final void I0() {
        LinearLayout linearLayout;
        tv.i mViewBinding = getMViewBinding();
        if (mViewBinding == null || (linearLayout = mViewBinding.f77764d) == null) {
            return;
        }
        so.c.g(linearLayout);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public tv.i getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        tv.i iVarC = tv.i.c(inflater);
        Intrinsics.f(iVarC, "inflate(inflater)");
        return iVarC;
    }

    public final void M0(View view) {
        if (view == null || this.f55636d != null) {
            return;
        }
        this.f55636d = new com.transsion.postdetail.comment.k(view, null, new SocialStatus(false, false, false, this.f55645n, 7, null), false, 10, null);
        sv.a aVar = new sv.a();
        aVar.h(LogSeverity.NOTICE_VALUE);
        aVar.f(this);
        aVar.g(null);
        com.transsion.postdetail.comment.k kVar = this.f55636d;
        if (kVar != null) {
            kVar.k(aVar);
        }
    }

    @Override // com.transsion.postdetail.comment.a0
    public void N() {
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        SelectImageActivity.a aVar = SelectImageActivity.f56514r;
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        aVar.a(contextRequireContext, 0, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0081  */
    @Override // com.transsion.postdetail.comment.a0
    public void P(Editable editable, CommentBean commentBean) {
        String rootCommentId;
        String str;
        String commentId;
        String uid;
        com.transsion.postdetail.comment.k kVarL;
        if (this.f55649r) {
            zp.b.f82110a.d(R$string.loding);
            return;
        }
        com.transsion.postdetail.helper.a aVar = com.transsion.postdetail.helper.a.f55063a;
        String str2 = this.f55641j;
        if (str2 == null) {
            str2 = "";
        }
        aVar.g(str2, "post", this.f55646o ? "post_detail" : "postdetail_video", this.f55656y);
        this.f55648q = commentBean;
        this.C = SystemClock.elapsedRealtime();
        R0("发表评论");
        com.transsion.postdetail.comment.e eVar = this.f55638g;
        List<PhotoEntity> listJ = (eVar == null || (kVarL = eVar.l()) == null) ? null : kVarL.j();
        CharSequence charSequenceZ0 = editable != null ? StringsKt__StringsKt.Z0(editable) : null;
        if ((charSequenceZ0 == null || charSequenceZ0.length() == 0) && listJ != null && listJ.isEmpty()) {
            zp.b.f82110a.d(R$string.comment_empty_tips);
            return;
        }
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.check_error);
            return;
        }
        if (checkLogin()) {
            if (commentBean != null) {
                if (Intrinsics.b(commentBean.getRootCommentId(), "0")) {
                    rootCommentId = commentBean.getCommentId();
                    if (rootCommentId == null) {
                        str = "0";
                    }
                } else {
                    rootCommentId = commentBean.getRootCommentId();
                }
                str = rootCommentId;
            } else {
                str = "0";
            }
            final CommentBody commentBody = new CommentBody(String.valueOf(charSequenceZ0), str, (commentBean == null || Intrinsics.b(commentBean.getRootCommentId(), "0") || (commentId = commentBean.getCommentId()) == null) ? "0" : commentId, (commentBean == null || (uid = commentBean.getUid()) == null) ? "0" : uid, this.f55641j, new ArrayList(), "", "POST");
            this.f55649r = true;
            com.transsion.postdetail.comment.e eVar2 = this.f55638g;
            if (eVar2 != null) {
                eVar2.p();
            }
            List<PhotoEntity> list = listJ;
            if (list != null && !list.isEmpty()) {
                String localPath = listJ.get(0).getLocalPath();
                j1(localPath != null ? localPath : "", new Function2<String, String, Unit>() { // from class: com.transsion.postdetail.ui.fragment.CommentFragment$onPost$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(String str3, String str4) {
                        invoke2(str3, str4);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String data, String bucket) {
                        Intrinsics.g(data, "data");
                        Intrinsics.g(bucket, "bucket");
                        if (data.length() > 0) {
                            List<String> imageList = commentBody.getImageList();
                            if (imageList != null) {
                                imageList.clear();
                            }
                            List<String> imageList2 = commentBody.getImageList();
                            if (imageList2 != null) {
                                imageList2.add(data);
                            }
                            commentBody.setBucket(bucket);
                            CommentViewModel commentViewModel = this.f55640i;
                            if (commentViewModel != null) {
                                commentViewModel.q(commentBody);
                            }
                        }
                    }
                });
            } else {
                CommentViewModel commentViewModel = this.f55640i;
                if (commentViewModel != null) {
                    commentViewModel.q(commentBody);
                }
            }
        }
    }

    public final void R0(String str) {
    }

    public final void S0() {
        if (this.f55637f == null) {
            this.f55637f = new com.transsion.postdetail.util.h();
        }
        com.transsion.postdetail.util.h hVar = this.f55637f;
        if (hVar != null) {
            hVar.d(getActivity(), new d());
        }
    }

    public final void T0(String str, String str2) {
        HashMap map = new HashMap();
        map.put("module_name", str);
        String str3 = this.f55641j;
        if (str3 == null) {
            str3 = "";
        }
        map.put("post_id", str3);
        if (str2 == null) {
            str2 = "";
        }
        map.put("comment_id", str2);
        String str4 = this.f55656y;
        if (str4 != null && str4.length() != 0) {
            String str5 = this.f55656y;
            Intrinsics.d(str5);
            map.put(WebConstants.PAGE_FROM, str5);
        }
        com.transsion.baselib.helper.a.f51183a.h(this.f55646o ? "post_detail" : "postdetail_video", map);
    }

    public final void V0(Function2<? super String, ? super Boolean, Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.D = callback;
    }

    public final void W0(String str, CommentListBean commentListBean) {
        List<CommentBean> commentList;
        List<CommentBean> commentList2;
        HashMap<String, CommentBean> mapL0;
        if (this.f55639h == null) {
            this.f55641j = str;
            this.f55639h = commentListBean;
            return;
        }
        if (commentListBean == null || (commentList = commentListBean.getCommentList()) == null) {
            return;
        }
        for (CommentBean commentBean : commentList) {
            com.transsion.postdetail.comment.l lVar = this.f55635c;
            if (lVar != null && (mapL0 = lVar.L0()) != null) {
                if (mapL0.containsKey(commentBean != null ? commentBean.getCommentId() : null)) {
                }
            }
            CommentListBean commentListBean2 = this.f55639h;
            if (commentListBean2 != null && (commentList2 = commentListBean2.getCommentList()) != null) {
                commentList2.add(commentBean);
            }
        }
    }

    public final void X0(b bVar) {
        this.f55654w = bVar;
    }

    public final void Y0(CommentBean commentBean) {
        FragmentManager childFragmentManager;
        UserInfo userInfoP;
        if (commentBean == null) {
            return;
        }
        String content = commentBean.getContent();
        String userId = null;
        this.E = content != null ? CommentDeleteDialogFragment.f54880o.a(commentBean.getCommentId(), content) : null;
        try {
            if (isAdded() && (childFragmentManager = getChildFragmentManager()) != null) {
                childFragmentManager.executePendingTransactions();
                CommentDeleteDialogFragment commentDeleteDialogFragment = this.E;
                if ((commentDeleteDialogFragment != null && commentDeleteDialogFragment.isAdded()) || childFragmentManager.findFragmentByTag("commentDelete") != null) {
                    return;
                }
                String uid = commentBean.getUid();
                ILoginApi loginApi = getLoginApi();
                if (loginApi != null && (userInfoP = loginApi.P()) != null) {
                    userId = userInfoP.getUserId();
                }
                boolean zEquals = TextUtils.equals(uid, userId);
                CommentDeleteDialogFragment commentDeleteDialogFragment2 = this.E;
                if (commentDeleteDialogFragment2 != null) {
                    commentDeleteDialogFragment2.u0(new e());
                }
                CommentDeleteDialogFragment commentDeleteDialogFragment3 = this.E;
                if (commentDeleteDialogFragment3 != null) {
                    commentDeleteDialogFragment3.w0(childFragmentManager, "commentDelete", zEquals);
                }
            }
            e1();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final boolean a1(CommentBean commentBean) {
        if (!isAdded() || isDetached() || isRemoving()) {
            return false;
        }
        if (this.f55638g == null) {
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            com.transsion.postdetail.comment.e.a aVarC = new com.transsion.postdetail.comment.e.a(contextRequireContext).d(LogSeverity.NOTICE_VALUE).c(this);
            com.transsion.postdetail.comment.k kVar = this.f55636d;
            com.transsion.postdetail.comment.e eVarA = aVarC.b(kVar != null ? kVar.h() : null).e(commentBean).a();
            this.f55638g = eVarA;
            if (eVarA != null) {
                eVarA.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.transsion.postdetail.ui.fragment.c
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        CommentFragment.b1(this.f55864a, dialogInterface);
                    }
                });
            }
        }
        com.transsion.postdetail.comment.e eVar = this.f55638g;
        if (eVar == null || eVar.isShowing()) {
            return true;
        }
        com.transsion.postdetail.comment.e eVar2 = this.f55638g;
        if (eVar2 != null) {
            eVar2.n(this.B);
        }
        com.transsion.postdetail.comment.e eVar3 = this.f55638g;
        sv.a aVarK = eVar3 != null ? eVar3.k() : null;
        if (aVarK != null) {
            aVarK.i(commentBean);
        }
        com.transsion.postdetail.comment.e eVar4 = this.f55638g;
        if (eVar4 == null) {
            return true;
        }
        eVar4.show();
        return true;
    }

    @Override // com.transsion.postdetail.comment.a0, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        com.transsion.postdetail.comment.a0.a.a(this, editable);
    }

    @Override // com.transsion.postdetail.comment.a0, android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        com.transsion.postdetail.comment.a0.a.b(this, charSequence, i11, i12, i13);
    }

    @Override // com.transsion.postdetail.comment.y
    public void c0(rv.a info, int i11) {
        Intrinsics.g(info, "info");
        R0("加载更多");
        CommentViewModel commentViewModel = this.f55640i;
        if (commentViewModel != null) {
            commentViewModel.n(info, String.valueOf(info.c()), this.f55643l);
        }
    }

    @Override // com.transsion.postdetail.comment.y
    public void e(CommentBean commentBean) {
        Y0(commentBean);
    }

    public final void e1() {
        com.blankj.utilcode.util.k0.b(300L);
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00f0  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void f1(String str) {
        Iterable<e9.a> iterableD;
        List<T> listD;
        Iterable<e9.a> iterableD2;
        String str2 = str;
        ArrayList<CommentBean> arrayList = new ArrayList();
        com.transsion.postdetail.comment.l lVar = this.f55635c;
        if (lVar != null && (iterableD2 = lVar.D()) != null) {
            for (e9.a aVar : iterableD2) {
                if (aVar instanceof CommentBean) {
                    CommentBean commentBean = (CommentBean) aVar;
                    if (TextUtils.equals(commentBean.getCommentId(), str2)) {
                        arrayList.add(aVar);
                    }
                    if (TextUtils.equals(commentBean.getRootCommentId(), str2)) {
                        arrayList.add(aVar);
                    }
                }
            }
        }
        uo.b.a aVar2 = uo.b.f78622a;
        String string = arrayList.toString();
        Intrinsics.f(string, "deleteList.toString()");
        uo.b.a.f(aVar2, "deleteComment list:", string, false, 4, null);
        if (!arrayList.isEmpty()) {
            this.f55634b = true;
            for (CommentBean commentBean2 : arrayList) {
                com.transsion.postdetail.comment.l lVar2 = this.f55635c;
                if (lVar2 != null && (listD = lVar2.D()) != 0) {
                    listD.remove(commentBean2);
                }
            }
            com.transsion.postdetail.comment.l lVar3 = this.f55635c;
            if ((lVar3 != null ? lVar3.D() : null) == null) {
                this.f55651t = 0L;
                uo.b.a.f(uo.b.f78622a, "deleteComment list:", "mCommentExpandAdapter null", false, 4, null);
            } else {
                com.transsion.postdetail.comment.l lVar4 = this.f55635c;
                List listD2 = lVar4 != null ? lVar4.D() : null;
                if (listD2 == null || listD2.isEmpty()) {
                    this.f55651t = 0L;
                    uo.b.a.f(uo.b.f78622a, "deleteComment list:", "mCommentExpandAdapter null", false, 4, null);
                } else {
                    com.transsion.postdetail.comment.l lVar5 = this.f55635c;
                    if (lVar5 != null && (iterableD = lVar5.D()) != null) {
                        for (e9.a aVar3 : iterableD) {
                            if (aVar3 instanceof CommentBean) {
                                Long createdAt = ((CommentBean) aVar3).getCreatedAt();
                                long jLongValue = createdAt != null ? createdAt.longValue() : 0L;
                                this.f55651t = jLongValue;
                                uo.b.a.f(uo.b.f78622a, "deleteComment list:", "mCommentExpandAdapter createdTime:" + jLongValue, false, 4, null);
                            }
                        }
                    }
                }
            }
            com.transsion.postdetail.comment.l lVar6 = this.f55635c;
            if (lVar6 != null) {
                lVar6.notifyDataSetChanged();
            }
            this.f55644m -= (long) arrayList.size();
            g1();
            G0(arrayList);
        }
        SyncManager syncManagerA = SyncManager.f61414a.a();
        if (str2 == null) {
            str2 = "";
        }
        syncManagerA.b(2, str2, String.valueOf(this.f55644m), this.f55641j);
    }

    public final void g1() {
        tv.i mViewBinding = getMViewBinding();
        AppCompatTextView appCompatTextView = mViewBinding != null ? mViewBinding.f77765f : null;
        if (appCompatTextView != null) {
            appCompatTextView.setVisibility(this.f55646o ? 8 : 0);
        }
        tv.i mViewBinding2 = getMViewBinding();
        AppCompatTextView appCompatTextView2 = mViewBinding2 != null ? mViewBinding2.f77765f : null;
        if (appCompatTextView2 != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
            String string = getString(R$string.comments);
            Intrinsics.f(string, "getString(R.string.comments)");
            String str = String.format(string, Arrays.copyOf(new Object[]{com.transsion.baseui.util.j.a(this.f55644m)}, 1));
            Intrinsics.f(str, "format(...)");
            appCompatTextView2.setText(str);
        }
        b bVar = this.f55654w;
        if (bVar != null) {
            bVar.a(this.f55644m);
        }
    }

    public final void h1(long j11) {
        this.f55644m = j11;
        g1();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void hideLoading() {
        LinearLayout linearLayout;
        RecyclerView recyclerView;
        tv.i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f77763c) != null) {
            so.c.k(recyclerView);
        }
        tv.i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (linearLayout = mViewBinding2.f77764d) == null) {
            return;
        }
        so.c.g(linearLayout);
    }

    public final void i1(CommentListBean commentListBean) {
        K0();
        com.transsion.postdetail.comment.l lVar = this.f55635c;
        if (lVar != null) {
            lVar.O0(commentListBean);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        this.f55633a = (RecyclerView) view.findViewById(R$id.comment_list);
        K0();
        S0();
        R0("onViewCreated");
        initViewModel();
        g1();
        N0();
        this.f55657z = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.transsion.postdetail.ui.fragment.a
            @Override // b1.a
            public final void a(Object obj) {
                CommentFragment.O0(this.f55858a, (ActivityResult) obj);
            }
        });
    }

    public final void j1(String str, Function2<? super String, ? super String, Unit> function2) {
        ty.b.f78077a.d(str, UploadFileType.OBJECT_NAME_IMAGE, true, new f(function2));
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        CommentListBean commentListBean = this.f55639h;
        if (commentListBean == null) {
            P0();
        } else {
            E0(commentListBean);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f55641j = arguments.getString("POST_ID");
            this.f55644m = arguments.getLong("comment_count");
            this.f55645n = arguments.getBoolean("show_download", true);
            this.f55646o = arguments.getBoolean("from_detail", false);
            this.f55655x = arguments.getString("comment_id", "");
            this.f55656y = arguments.getString(WebConstants.PAGE_FROM);
        }
        Function1<cw.a, Unit> function1 = new Function1<cw.a, Unit>() { // from class: com.transsion.postdetail.ui.fragment.CommentFragment.onCreate.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(cw.a aVar) {
                invoke2(aVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(cw.a it) {
                Intrinsics.g(it, "it");
                Integer numE = it.e();
                if (numE != null && numE.intValue() == 0) {
                    CommentFragment.this.F0(it);
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = cw.a.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.w0.c().q(), false, function1);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        R0("onTextChanged");
    }

    @Override // com.transsion.postdetail.comment.y
    public void s(CommentBean commentBean) {
        String uid;
        R0("跳转个人页面");
        if (commentBean != null && (uid = commentBean.getUid()) != null) {
            com.alibaba.android.arouter.launcher.a.d().b("/profile/user_center").withString("userId", uid).navigation();
        }
        U0(this, "avatar_comment", null, 2, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void startLoading() {
        LinearLayout linearLayout;
        RecyclerView recyclerView;
        tv.i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f77763c) != null) {
            so.c.g(recyclerView);
        }
        tv.i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (linearLayout = mViewBinding2.f77764d) == null) {
            return;
        }
        so.c.k(linearLayout);
    }

    @Override // com.transsion.postdetail.comment.y
    public void t(CommentBean commentBean) {
        R0("点赞");
        if (commentBean == null || commentBean.getCommentId() == null) {
            return;
        }
        String commentId = commentBean.getCommentId();
        Boolean likeStatu = commentBean.getLikeStatu();
        Boolean bool = Boolean.TRUE;
        CommentLikeBody commentLikeBody = new CommentLikeBody(commentId, Integer.valueOf(!Intrinsics.b(likeStatu, bool) ? 1 : 0));
        CommentViewModel commentViewModel = this.f55640i;
        if (commentViewModel != null) {
            commentViewModel.o(commentLikeBody);
        }
        U0(this, Intrinsics.b(commentBean.getLikeStatu(), bool) ? "dislike_comment" : "like_comment", null, 2, null);
        Function2<? super String, ? super Boolean, Unit> function2 = this.D;
        if (function2 != null) {
            function2.invoke(commentBean.getCommentId(), commentBean.getLikeStatu());
        }
    }
}
