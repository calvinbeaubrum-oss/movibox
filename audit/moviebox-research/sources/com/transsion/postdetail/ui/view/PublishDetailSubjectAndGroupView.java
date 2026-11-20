package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bumptech.glide.Glide;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.R$mipmap;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.widget.DownloadView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.w0;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class PublishDetailSubjectAndGroupView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f56057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f56058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f56059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConstraintLayout f56060d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DownloadView f56061f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AppCompatTextView f56062g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AppCompatTextView f56063h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AppCompatImageView f56064i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AppCompatImageView f56065j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ConstraintLayout f56066k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ConstraintLayout f56067l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f56068m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AppCompatTextView f56069n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PostSubjectItem f56070o;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PublishDetailSubjectAndGroupView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PublishDetailSubjectAndGroupView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishDetailSubjectAndGroupView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        View.inflate(context, R$layout.view_post_detail_subject_and_group_layout, this);
        i();
        e();
    }

    private final void e() {
        DownloadView downloadView = this.f56061f;
        if (downloadView != null) {
            downloadView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.f0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws InterruptedException {
                    PublishDetailSubjectAndGroupView.f(this.f56135a, view);
                }
            });
        }
        ConstraintLayout constraintLayout = this.f56066k;
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.g0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PublishDetailSubjectAndGroupView.g(this.f56137a, view);
                }
            });
        }
        ConstraintLayout constraintLayout2 = this.f56067l;
        if (constraintLayout2 != null) {
            constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.h0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PublishDetailSubjectAndGroupView.h(this.f56139a, view);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.transsion.moviedetailapi.bean.Subject] */
    /* JADX WARN: Type inference failed for: r31v0, types: [java.lang.String] */
    public static final void f(PublishDetailSubjectAndGroupView this$0, View view) throws InterruptedException {
        String resourceLink;
        User user;
        Subject subject;
        ResourceDetectors resourceDetector;
        Group group;
        Subject subject2;
        Group group2;
        Subject subject3;
        String subjectId;
        Subject subject4;
        Subject subject5;
        ResourceDetectors resourceDetector2;
        Subject subject6;
        Intrinsics.g(this$0, "this$0");
        if (this$0.getContext() instanceof FragmentActivity) {
            DownloadManagerApi.a aVar = DownloadManagerApi.f60274j;
            DownloadManagerApi downloadManagerApiA = aVar.a();
            PostSubjectItem postSubjectItem = this$0.f56070o;
            Object nickname = null;
            String subjectId2 = (postSubjectItem == null || (subject6 = postSubjectItem.getSubject()) == null) ? null : subject6.getSubjectId();
            PostSubjectItem postSubjectItem2 = this$0.f56070o;
            String resourceId = (postSubjectItem2 == null || (subject5 = postSubjectItem2.getSubject()) == null || (resourceDetector2 = subject5.getResourceDetector()) == null) ? null : resourceDetector2.getResourceId();
            PostSubjectItem postSubjectItem3 = this$0.f56070o;
            if (DownloadManagerApi.n2(downloadManagerApiA, subjectId2, resourceId, (postSubjectItem3 == null || (subject4 = postSubjectItem3.getSubject()) == null) ? false : subject4.isSeries(), false, 8, null)) {
                PostSubjectItem postSubjectItem4 = this$0.f56070o;
                if (postSubjectItem4 == null || (subject3 = postSubjectItem4.getSubject()) == null || (subjectId = subject3.getSubjectId()) == null) {
                    return;
                }
                DownloadManagerApi downloadManagerApiA2 = aVar.a();
                Context context = this$0.getContext();
                Intrinsics.d(context);
                DownloadManagerApi.p2(downloadManagerApiA2, subjectId, context, this$0.f56059c, null, 8, null);
                return;
            }
            PostSubjectItem postSubjectItem5 = this$0.f56070o;
            if (postSubjectItem5 != null && (subject2 = postSubjectItem5.getSubject()) != null) {
                Integer subjectType = subject2.getSubjectType();
                int value = SubjectType.SHORT_TV.getValue();
                if (subjectType != null && subjectType.intValue() == value) {
                    DownloadManagerApi downloadManagerApiA3 = aVar.a();
                    Context context2 = this$0.getContext();
                    Intrinsics.e(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                    FragmentActivity fragmentActivity = (FragmentActivity) context2;
                    String str = this$0.f56059c;
                    PostSubjectItem postSubjectItem6 = this$0.f56070o;
                    String groupId = (postSubjectItem6 == null || (group2 = postSubjectItem6.getGroup()) == null) ? null : group2.getGroupId();
                    PostSubjectItem postSubjectItem7 = this$0.f56070o;
                    String ops = postSubjectItem7 != null ? postSubjectItem7.getOps() : null;
                    PostSubjectItem postSubjectItem8 = this$0.f56070o;
                    downloadManagerApiA3.a2(fragmentActivity, str, (384 & 4) != 0 ? "" : groupId, ops, (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : true, (384 & 64) != 0 ? null : postSubjectItem8 != null ? postSubjectItem8.getSubject() : null, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
                    return;
                }
            }
            DownloadManagerApi downloadManagerApiA4 = aVar.a();
            Context context3 = this$0.getContext();
            Intrinsics.e(context3, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            FragmentActivity fragmentActivity2 = (FragmentActivity) context3;
            PostSubjectItem postSubjectItem9 = this$0.f56070o;
            Subject subject7 = postSubjectItem9 != null ? postSubjectItem9.getSubject() : null;
            String str2 = this$0.f56059c;
            PostSubjectItem postSubjectItem10 = this$0.f56070o;
            String groupId2 = (postSubjectItem10 == null || (group = postSubjectItem10.getGroup()) == null) ? null : group.getGroupId();
            PostSubjectItem postSubjectItem11 = this$0.f56070o;
            String ops2 = postSubjectItem11 != null ? postSubjectItem11.getOps() : null;
            PostSubjectItem postSubjectItem12 = this$0.f56070o;
            if (postSubjectItem12 == null || (subject = postSubjectItem12.getSubject()) == null || (resourceDetector = subject.getResourceDetector()) == null || (resourceLink = resourceDetector.getResourceLink()) == null) {
                resourceLink = "";
            }
            String str3 = resourceLink;
            PostSubjectItem postSubjectItem13 = this$0.f56070o;
            if (postSubjectItem13 != null && (user = postSubjectItem13.getUser()) != null) {
                nickname = user.getNickname();
            }
            downloadManagerApiA4.P1(fragmentActivity2, subject7, str2, (960 & 8) != 0 ? "" : groupId2, ops2, str3, (960 & 64) != 0 ? "" : null, (960 & 128) != 0 ? null : null, (960 & 256) != 0 ? null : nickname, (960 & 512) != 0 ? false : false);
        }
    }

    public static final void g(PublishDetailSubjectAndGroupView this$0, View view) {
        Function0<Unit> function0;
        Intrinsics.g(this$0, "this$0");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) || (function0 = this$0.f56057a) == null) {
            return;
        }
        function0.invoke();
    }

    public static final void h(PublishDetailSubjectAndGroupView this$0, View view) {
        Function0<Unit> function0;
        Intrinsics.g(this$0, "this$0");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) || (function0 = this$0.f56058b) == null) {
            return;
        }
        function0.invoke();
    }

    private final void i() {
        this.f56065j = (AppCompatImageView) findViewById(R$id.ivGaussianBlur);
        this.f56064i = (AppCompatImageView) findViewById(R$id.ivCover);
        this.f56063h = (AppCompatTextView) findViewById(R$id.tvSubjectTitle);
        this.f56062g = (AppCompatTextView) findViewById(R$id.tvSubjectYear);
        this.f56061f = (DownloadView) findViewById(R$id.llDownload);
        this.f56060d = (ConstraintLayout) findViewById(R$id.clSubjectRoot);
        this.f56066k = (ConstraintLayout) findViewById(R$id.clSubject);
        this.f56067l = (ConstraintLayout) findViewById(R$id.clGroup);
        this.f56068m = findViewById(R$id.view_line);
        this.f56069n = (AppCompatTextView) findViewById(R$id.tvGroupName);
    }

    private final void j() {
        Context context = getContext();
        Intrinsics.e(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1<AddToDownloadEvent, Unit> function1 = new Function1<AddToDownloadEvent, Unit>() { // from class: com.transsion.postdetail.ui.view.PublishDetailSubjectAndGroupView$observeAddToDownload$1
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
                DownloadView downloadView;
                Subject subject;
                Subject subject2;
                ResourceDetectors resourceDetector;
                Subject subject3;
                Subject subject4;
                Intrinsics.g(value, "value");
                try {
                    String subjectId = value.getSubjectId();
                    PostSubjectItem postSubjectItem = this.this$0.f56070o;
                    if (TextUtils.equals(subjectId, (postSubjectItem == null || (subject4 = postSubjectItem.getSubject()) == null) ? null : subject4.getSubjectId()) && (downloadView = this.this$0.f56061f) != null) {
                        PostSubjectItem postSubjectItem2 = this.this$0.f56070o;
                        String subjectId2 = (postSubjectItem2 == null || (subject3 = postSubjectItem2.getSubject()) == null) ? null : subject3.getSubjectId();
                        PostSubjectItem postSubjectItem3 = this.this$0.f56070o;
                        String resourceId = (postSubjectItem3 == null || (subject2 = postSubjectItem3.getSubject()) == null || (resourceDetector = subject2.getResourceDetector()) == null) ? null : resourceDetector.getResourceId();
                        PostSubjectItem postSubjectItem4 = this.this$0.f56070o;
                        DownloadView.setShowType$default(downloadView, subjectId2, resourceId, (postSubjectItem4 == null || (subject = postSubjectItem4.getSubject()) == null) ? null : Boolean.valueOf(subject.isSeries()), false, 0, 24, null);
                    }
                } catch (Exception unused) {
                    uo.b.a.g(uo.b.f78622a, " callback change data fail", false, 2, null);
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = AddToDownloadEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent((AppCompatActivity) context, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
    }

    public final void showData(PostSubjectItem postSubjectItem, String pageName, boolean z11, Function0<Unit> function0, Function0<Unit> function1) {
        ConstraintLayout constraintLayout;
        Group group;
        Subject subject;
        Group group2;
        Group group3;
        AppCompatTextView appCompatTextView;
        Subject subject2;
        Subject subject3;
        ResourceDetectors resourceDetector;
        Subject subject4;
        Subject subject5;
        Object objM163constructorimpl;
        String strSubstring;
        String url;
        String url2;
        DownloadView downloadView;
        Subject subject6;
        Subject subject7;
        Intrinsics.g(postSubjectItem, "postSubjectItem");
        Intrinsics.g(pageName, "pageName");
        this.f56059c = pageName;
        this.f56070o = postSubjectItem;
        this.f56057a = function0;
        this.f56058b = function1;
        Boolean boolValueOf = null;
        if (TextUtils.isEmpty((postSubjectItem == null || (subject7 = postSubjectItem.getSubject()) == null) ? null : subject7.getSubjectId())) {
            ConstraintLayout constraintLayout2 = this.f56066k;
            if (constraintLayout2 != null) {
                constraintLayout2.setVisibility(8);
            }
            View view = this.f56068m;
            if (view != null) {
                view.setVisibility(8);
            }
        } else {
            PostSubjectItem postSubjectItem2 = this.f56070o;
            String groupId = (postSubjectItem2 == null || (group2 = postSubjectItem2.getGroup()) == null) ? null : group2.getGroupId();
            if (groupId == null || groupId.length() == 0) {
                ConstraintLayout constraintLayout3 = this.f56067l;
                if (constraintLayout3 != null) {
                    constraintLayout3.setVisibility(8);
                }
                View view2 = this.f56068m;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                ConstraintLayout constraintLayout4 = this.f56066k;
                if (constraintLayout4 != null) {
                    constraintLayout4.setLayoutParams(new ConstraintLayout.b(-1, -2));
                }
            } else {
                PostSubjectItem postSubjectItem3 = this.f56070o;
                if (TextUtils.isEmpty((postSubjectItem3 == null || (subject = postSubjectItem3.getSubject()) == null) ? null : subject.getSubjectId())) {
                    PostSubjectItem postSubjectItem4 = this.f56070o;
                    String groupId2 = (postSubjectItem4 == null || (group = postSubjectItem4.getGroup()) == null) ? null : group.getGroupId();
                    if ((groupId2 == null || groupId2.length() == 0) && (constraintLayout = this.f56060d) != null) {
                        constraintLayout.setVisibility(8);
                    }
                }
            }
        }
        PostSubjectItem postSubjectItem5 = this.f56070o;
        if (((postSubjectItem5 != null && (subject6 = postSubjectItem5.getSubject()) != null && Intrinsics.b(subject6.getHasResource(), Boolean.FALSE)) || !z11) && (downloadView = this.f56061f) != null) {
            downloadView.setVisibility(8);
        }
        DownloadView downloadView2 = this.f56061f;
        if (downloadView2 != null) {
            downloadView2.setPageFrom(pageName);
        }
        PostSubjectItem postSubjectItem6 = this.f56070o;
        if (postSubjectItem6 != null && (subject5 = postSubjectItem6.getSubject()) != null) {
            AppCompatImageView appCompatImageView = this.f56065j;
            String str = "";
            if (appCompatImageView != null) {
                com.transsion.baseui.image.e eVar = com.transsion.baseui.image.e.f51399a;
                Cover cover = subject5.getCover();
                if (cover == null || (url2 = cover.getUrl()) == null) {
                    url2 = "";
                }
                Glide.with(appCompatImageView.getContext()).load2(eVar.d(url2, com.blankj.utilcode.util.f0.a(42.0f), (56 & 4) != 0 ? true : true, (56 & 8) != 0 ? true : true, (56 & 16) != 0 ? 0 : 0, (56 & 32) != 0 ? false : false, (56 & 64) != 0 ? false : false, (56 & 128) != 0 ? false : false, (56 & 256) != 0 ? 25 : 0)).transform(new qo.a(50, 1, true)).into(appCompatImageView);
            }
            AppCompatImageView appCompatImageView2 = this.f56064i;
            if (appCompatImageView2 != null) {
                int iA = com.blankj.utilcode.util.f0.a(42.0f);
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = appCompatImageView2.getContext();
                Intrinsics.f(context, "context");
                Cover cover2 = subject5.getCover();
                companion.o(context, appCompatImageView2, (cover2 == null || (url = cover2.getUrl()) == null) ? "" : url, (32704 & 8) != 0 ? R$color.skeleton : R$mipmap.home_ic_default_res, (32704 & 16) != 0 ? companion.d() : iA, (32704 & 32) != 0 ? companion.c() : iA, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
            }
            AppCompatTextView appCompatTextView2 = this.f56063h;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setText(subject5.getTitle());
            }
            try {
                Result.Companion companion2 = Result.Companion;
                AppCompatTextView appCompatTextView3 = this.f56062g;
                if (appCompatTextView3 != null) {
                    String releaseDate = subject5.getReleaseDate();
                    if (releaseDate != null) {
                        strSubstring = releaseDate.substring(0, 4);
                        Intrinsics.f(strSubstring, "substring(...)");
                    } else {
                        strSubstring = null;
                    }
                    if (!TextUtils.isEmpty(subject5.getCountryName())) {
                        str = " · " + subject5.getCountryName();
                    }
                    appCompatTextView3.setText(strSubstring + str);
                    Subject subject8 = postSubjectItem.getSubject();
                    appCompatTextView3.setCompoundDrawablesRelativeWithIntrinsicBounds(com.transsion.moviedetailapi.a.a(subject8 != null ? subject8.getSubjectType() : null), 0, 0, 0);
                } else {
                    appCompatTextView3 = null;
                }
                objM163constructorimpl = Result.m163constructorimpl(appCompatTextView3);
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
            }
            Result.m162boximpl(objM163constructorimpl);
        }
        DownloadView downloadView3 = this.f56061f;
        if (downloadView3 != null) {
            PostSubjectItem postSubjectItem7 = this.f56070o;
            String subjectId = (postSubjectItem7 == null || (subject4 = postSubjectItem7.getSubject()) == null) ? null : subject4.getSubjectId();
            PostSubjectItem postSubjectItem8 = this.f56070o;
            String resourceId = (postSubjectItem8 == null || (subject3 = postSubjectItem8.getSubject()) == null || (resourceDetector = subject3.getResourceDetector()) == null) ? null : resourceDetector.getResourceId();
            PostSubjectItem postSubjectItem9 = this.f56070o;
            if (postSubjectItem9 != null && (subject2 = postSubjectItem9.getSubject()) != null) {
                boolValueOf = Boolean.valueOf(subject2.isSeries());
            }
            DownloadView.setShowType$default(downloadView3, subjectId, resourceId, boolValueOf, false, 0, 24, null);
        }
        j();
        PostSubjectItem postSubjectItem10 = this.f56070o;
        if (postSubjectItem10 == null || (group3 = postSubjectItem10.getGroup()) == null || (appCompatTextView = this.f56069n) == null) {
            return;
        }
        appCompatTextView.setText(group3.getName());
    }
}
