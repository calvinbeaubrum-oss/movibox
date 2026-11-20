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
public final class PostDetailSubjectView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f56048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f56049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ConstraintLayout f56050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DownloadView f56051d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AppCompatTextView f56052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AppCompatTextView f56053g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AppCompatImageView f56054h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AppCompatImageView f56055i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PostSubjectItem f56056j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostDetailSubjectView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostDetailSubjectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostDetailSubjectView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        View.inflate(context, R$layout.view_post_detail_subject_layout, this);
        g();
        c();
    }

    private final void c() {
        DownloadView downloadView = this.f56051d;
        if (downloadView != null) {
            downloadView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws InterruptedException {
                    PostDetailSubjectView.e(this.f56131a, view);
                }
            });
        }
        ConstraintLayout constraintLayout = this.f56050c;
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.e0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PostDetailSubjectView.f(this.f56134a, view);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.transsion.moviedetailapi.bean.Subject] */
    /* JADX WARN: Type inference failed for: r31v0, types: [java.lang.String] */
    public static final void e(PostDetailSubjectView this$0, View view) throws InterruptedException {
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
            PostSubjectItem postSubjectItem = this$0.f56056j;
            Object nickname = null;
            String subjectId2 = (postSubjectItem == null || (subject6 = postSubjectItem.getSubject()) == null) ? null : subject6.getSubjectId();
            PostSubjectItem postSubjectItem2 = this$0.f56056j;
            String resourceId = (postSubjectItem2 == null || (subject5 = postSubjectItem2.getSubject()) == null || (resourceDetector2 = subject5.getResourceDetector()) == null) ? null : resourceDetector2.getResourceId();
            PostSubjectItem postSubjectItem3 = this$0.f56056j;
            if (DownloadManagerApi.n2(downloadManagerApiA, subjectId2, resourceId, (postSubjectItem3 == null || (subject4 = postSubjectItem3.getSubject()) == null) ? false : subject4.isSeries(), false, 8, null)) {
                PostSubjectItem postSubjectItem4 = this$0.f56056j;
                if (postSubjectItem4 == null || (subject3 = postSubjectItem4.getSubject()) == null || (subjectId = subject3.getSubjectId()) == null) {
                    return;
                }
                DownloadManagerApi downloadManagerApiA2 = aVar.a();
                Context context = this$0.getContext();
                Intrinsics.d(context);
                DownloadManagerApi.p2(downloadManagerApiA2, subjectId, context, this$0.f56049b, null, 8, null);
                return;
            }
            PostSubjectItem postSubjectItem5 = this$0.f56056j;
            if (postSubjectItem5 != null && (subject2 = postSubjectItem5.getSubject()) != null) {
                Integer subjectType = subject2.getSubjectType();
                int value = SubjectType.SHORT_TV.getValue();
                if (subjectType != null && subjectType.intValue() == value) {
                    DownloadManagerApi downloadManagerApiA3 = aVar.a();
                    Context context2 = this$0.getContext();
                    Intrinsics.e(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                    FragmentActivity fragmentActivity = (FragmentActivity) context2;
                    String str = this$0.f56049b;
                    PostSubjectItem postSubjectItem6 = this$0.f56056j;
                    String groupId = (postSubjectItem6 == null || (group2 = postSubjectItem6.getGroup()) == null) ? null : group2.getGroupId();
                    PostSubjectItem postSubjectItem7 = this$0.f56056j;
                    String ops = postSubjectItem7 != null ? postSubjectItem7.getOps() : null;
                    PostSubjectItem postSubjectItem8 = this$0.f56056j;
                    downloadManagerApiA3.a2(fragmentActivity, str, (384 & 4) != 0 ? "" : groupId, ops, (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : true, (384 & 64) != 0 ? null : postSubjectItem8 != null ? postSubjectItem8.getSubject() : null, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
                    return;
                }
            }
            DownloadManagerApi downloadManagerApiA4 = aVar.a();
            Context context3 = this$0.getContext();
            Intrinsics.e(context3, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            FragmentActivity fragmentActivity2 = (FragmentActivity) context3;
            PostSubjectItem postSubjectItem9 = this$0.f56056j;
            Subject subject7 = postSubjectItem9 != null ? postSubjectItem9.getSubject() : null;
            String str2 = this$0.f56049b;
            PostSubjectItem postSubjectItem10 = this$0.f56056j;
            String groupId2 = (postSubjectItem10 == null || (group = postSubjectItem10.getGroup()) == null) ? null : group.getGroupId();
            PostSubjectItem postSubjectItem11 = this$0.f56056j;
            String ops2 = postSubjectItem11 != null ? postSubjectItem11.getOps() : null;
            PostSubjectItem postSubjectItem12 = this$0.f56056j;
            if (postSubjectItem12 == null || (subject = postSubjectItem12.getSubject()) == null || (resourceDetector = subject.getResourceDetector()) == null || (resourceLink = resourceDetector.getResourceLink()) == null) {
                resourceLink = "";
            }
            String str3 = resourceLink;
            PostSubjectItem postSubjectItem13 = this$0.f56056j;
            if (postSubjectItem13 != null && (user = postSubjectItem13.getUser()) != null) {
                nickname = user.getNickname();
            }
            downloadManagerApiA4.P1(fragmentActivity2, subject7, str2, (960 & 8) != 0 ? "" : groupId2, ops2, str3, (960 & 64) != 0 ? "" : null, (960 & 128) != 0 ? null : null, (960 & 256) != 0 ? null : nickname, (960 & 512) != 0 ? false : false);
        }
    }

    public static final void f(PostDetailSubjectView this$0, View view) {
        Function0<Unit> function0;
        Intrinsics.g(this$0, "this$0");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) || (function0 = this$0.f56048a) == null) {
            return;
        }
        function0.invoke();
    }

    private final void g() {
        this.f56055i = (AppCompatImageView) findViewById(R$id.ivGaussianBlur);
        this.f56054h = (AppCompatImageView) findViewById(R$id.ivCover);
        this.f56053g = (AppCompatTextView) findViewById(R$id.tvSubjectTitle);
        this.f56052f = (AppCompatTextView) findViewById(R$id.tvSubjectYear);
        this.f56051d = (DownloadView) findViewById(R$id.llDownload);
        this.f56050c = (ConstraintLayout) findViewById(R$id.clSubjectRoot);
    }

    private final void h() {
        Context context = getContext();
        Intrinsics.e(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1<AddToDownloadEvent, Unit> function1 = new Function1<AddToDownloadEvent, Unit>() { // from class: com.transsion.postdetail.ui.view.PostDetailSubjectView$observeAddToDownload$1
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
                    PostSubjectItem postSubjectItem = this.this$0.f56056j;
                    if (TextUtils.equals(subjectId, (postSubjectItem == null || (subject4 = postSubjectItem.getSubject()) == null) ? null : subject4.getSubjectId()) && (downloadView = this.this$0.f56051d) != null) {
                        PostSubjectItem postSubjectItem2 = this.this$0.f56056j;
                        String subjectId2 = (postSubjectItem2 == null || (subject3 = postSubjectItem2.getSubject()) == null) ? null : subject3.getSubjectId();
                        PostSubjectItem postSubjectItem3 = this.this$0.f56056j;
                        String resourceId = (postSubjectItem3 == null || (subject2 = postSubjectItem3.getSubject()) == null || (resourceDetector = subject2.getResourceDetector()) == null) ? null : resourceDetector.getResourceId();
                        PostSubjectItem postSubjectItem4 = this.this$0.f56056j;
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

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showData$default(PostDetailSubjectView postDetailSubjectView, PostSubjectItem postSubjectItem, String str, Function0 function0, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            function0 = null;
        }
        postDetailSubjectView.showData(postSubjectItem, str, function0);
    }

    public final void showData(PostSubjectItem postSubjectItem, String pageName, Function0<Unit> function0) {
        Subject subject;
        Subject subject2;
        ResourceDetectors resourceDetector;
        Subject subject3;
        Subject subject4;
        Object objM163constructorimpl;
        String strSubstring;
        String url;
        String url2;
        Subject subject5;
        DownloadView downloadView;
        Subject subject6;
        Intrinsics.g(postSubjectItem, "postSubjectItem");
        Intrinsics.g(pageName, "pageName");
        this.f56049b = pageName;
        this.f56056j = postSubjectItem;
        this.f56048a = function0;
        Boolean boolValueOf = null;
        if (TextUtils.isEmpty((postSubjectItem == null || (subject6 = postSubjectItem.getSubject()) == null) ? null : subject6.getSubjectId())) {
            ConstraintLayout constraintLayout = this.f56050c;
            if (constraintLayout == null) {
                return;
            }
            constraintLayout.setVisibility(8);
            return;
        }
        PostSubjectItem postSubjectItem2 = this.f56056j;
        if (postSubjectItem2 != null && (subject5 = postSubjectItem2.getSubject()) != null && Intrinsics.b(subject5.getHasResource(), Boolean.FALSE) && (downloadView = this.f56051d) != null) {
            downloadView.setVisibility(8);
        }
        DownloadView downloadView2 = this.f56051d;
        if (downloadView2 != null) {
            downloadView2.setPageFrom(pageName);
        }
        PostSubjectItem postSubjectItem3 = this.f56056j;
        if (postSubjectItem3 != null && (subject4 = postSubjectItem3.getSubject()) != null) {
            AppCompatImageView appCompatImageView = this.f56055i;
            String str = "";
            if (appCompatImageView != null) {
                com.transsion.baseui.image.e eVar = com.transsion.baseui.image.e.f51399a;
                Cover cover = subject4.getCover();
                if (cover == null || (url2 = cover.getUrl()) == null) {
                    url2 = "";
                }
                Glide.with(appCompatImageView.getContext()).load2(eVar.d(url2, com.blankj.utilcode.util.f0.a(42.0f), (56 & 4) != 0 ? true : true, (56 & 8) != 0 ? true : true, (56 & 16) != 0 ? 0 : 0, (56 & 32) != 0 ? false : false, (56 & 64) != 0 ? false : false, (56 & 128) != 0 ? false : false, (56 & 256) != 0 ? 25 : 0)).transform(new qo.a(50, 1, true)).into(appCompatImageView);
            }
            AppCompatImageView appCompatImageView2 = this.f56054h;
            if (appCompatImageView2 != null) {
                int iA = com.blankj.utilcode.util.f0.a(42.0f);
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = appCompatImageView2.getContext();
                Intrinsics.f(context, "context");
                Cover cover2 = subject4.getCover();
                companion.o(context, appCompatImageView2, (cover2 == null || (url = cover2.getUrl()) == null) ? "" : url, (32704 & 8) != 0 ? R$color.skeleton : R$mipmap.home_ic_default_res, (32704 & 16) != 0 ? companion.d() : iA, (32704 & 32) != 0 ? companion.c() : iA, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
            }
            AppCompatTextView appCompatTextView = this.f56053g;
            if (appCompatTextView != null) {
                appCompatTextView.setText(subject4.getTitle());
            }
            try {
                Result.Companion companion2 = Result.Companion;
                AppCompatTextView appCompatTextView2 = this.f56052f;
                if (appCompatTextView2 != null) {
                    String releaseDate = subject4.getReleaseDate();
                    if (releaseDate != null) {
                        strSubstring = releaseDate.substring(0, 4);
                        Intrinsics.f(strSubstring, "substring(...)");
                    } else {
                        strSubstring = null;
                    }
                    if (!TextUtils.isEmpty(subject4.getCountryName())) {
                        str = " · " + subject4.getCountryName();
                    }
                    appCompatTextView2.setText(strSubstring + str);
                    Subject subject7 = postSubjectItem.getSubject();
                    appCompatTextView2.setCompoundDrawablesRelativeWithIntrinsicBounds(com.transsion.moviedetailapi.a.a(subject7 != null ? subject7.getSubjectType() : null), 0, 0, 0);
                } else {
                    appCompatTextView2 = null;
                }
                objM163constructorimpl = Result.m163constructorimpl(appCompatTextView2);
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
            }
            Result.m162boximpl(objM163constructorimpl);
        }
        DownloadView downloadView3 = this.f56051d;
        if (downloadView3 != null) {
            PostSubjectItem postSubjectItem4 = this.f56056j;
            String subjectId = (postSubjectItem4 == null || (subject3 = postSubjectItem4.getSubject()) == null) ? null : subject3.getSubjectId();
            PostSubjectItem postSubjectItem5 = this.f56056j;
            String resourceId = (postSubjectItem5 == null || (subject2 = postSubjectItem5.getSubject()) == null || (resourceDetector = subject2.getResourceDetector()) == null) ? null : resourceDetector.getResourceId();
            PostSubjectItem postSubjectItem6 = this.f56056j;
            if (postSubjectItem6 != null && (subject = postSubjectItem6.getSubject()) != null) {
                boolValueOf = Boolean.valueOf(subject.isSeries());
            }
            DownloadView.setShowType$default(downloadView3, subjectId, resourceId, boolValueOf, false, 0, 24, null);
        }
        h();
    }
}
