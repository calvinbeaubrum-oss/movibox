package com.transsion.moviedetail.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import com.applovin.sdk.AppLovinEventTypes;
import com.blankj.utilcode.util.Utils;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.edcation.CourseManager;
import com.transsion.moviedetail.R$string;
import com.transsion.moviedetail.p004enum.SeenStatus;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.push.notification.permission.NoticePermissionFrom;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.usercenterapi.ReportType;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.flow.event.sync.SyncManager;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import tu.v;

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
public final class HeaderExtensionFragment extends PageStatusFragment<v> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Subject f53801k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f53802l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f53804n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ShareDialogFragment f53806p;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f53803m = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f53805o = "subjectdetail";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f53807q = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.moviedetail.view.HeaderExtensionFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final x0 invoke() {
            x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.f(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.moviedetail.view.HeaderExtensionFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final v0.c invoke() {
            v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.f(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f53808a;

        public a(Function1 function) {
            Intrinsics.g(function, "function");
            this.f53808a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f53808a;
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
            this.f53808a.invoke(obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements com.transsion.share.share.e {
        @Override // com.transsion.share.share.e
        public void a(String id2, PostType postType) {
            Intrinsics.g(id2, "id");
        }

        @Override // com.transsion.share.share.e
        public void b(String str) {
            com.transsion.share.share.e.a.b(this, str);
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

    public static final void h1(HeaderExtensionFragment this$0, View view) {
        String subjectId;
        Intrinsics.g(this$0, "this$0");
        uo.b.a.g(uo.b.f78622a, "HeaderExtensionFragment click -- share", false, 2, null);
        Subject subject = this$0.f53801k;
        if (subject == null || (subjectId = subject.getSubjectId()) == null) {
            return;
        }
        this$0.r1(subjectId);
    }

    public static final void i1(final HeaderExtensionFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        com.transsion.baseui.util.d.b(0L, new Function0<Unit>() { // from class: com.transsion.moviedetail.view.HeaderExtensionFragment$addListeners$2$1
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
                CourseManager.q(CourseManager.f51853a, this.this$0.f53801k, null, 2, null);
                ct.a.b(this.this$0.f53801k, this.this$0.f53805o, "opt_detail_addcourse");
            }
        }, 1, null);
    }

    public static final void j1(final HeaderExtensionFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        com.transsion.baseui.util.d.b(0L, new Function0<Unit>() { // from class: com.transsion.moviedetail.view.HeaderExtensionFragment$addListeners$3$1
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
                this.this$0.x1();
            }
        }, 1, null);
    }

    public static final void k1(HeaderExtensionFragment this$0, View view) {
        ResourceDetectors resourceDetector;
        List<DownloadItem> resolutionList;
        ResourceDetectors resourceDetector2;
        List<DownloadItem> resolutionList2;
        Intrinsics.g(this$0, "this$0");
        Subject subject = this$0.f53801k;
        if (subject != null && (resourceDetector = subject.getResourceDetector()) != null && (resolutionList = resourceDetector.getResolutionList()) != null && (!resolutionList.isEmpty())) {
            Subject subject2 = this$0.f53801k;
            Integer numValueOf = (subject2 == null || (resourceDetector2 = subject2.getResourceDetector()) == null || (resolutionList2 = resourceDetector2.getResolutionList()) == null) ? null : Integer.valueOf(resolutionList2.size());
            Intrinsics.d(numValueOf);
            if (numValueOf.intValue() > 1) {
                Subject subject3 = this$0.f53801k;
                ResourceDetectors resourceDetector3 = subject3 != null ? subject3.getResourceDetector() : null;
                if (resourceDetector3 != null) {
                    resourceDetector3.setType(1);
                }
            }
        }
        this$0.m1();
    }

    public static final void l1(HeaderExtensionFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        com.transsion.baselib.helper.a aVar = com.transsion.baselib.helper.a.f51183a;
        String str = this$0.f53805o;
        Subject subject = this$0.f53801k;
        aVar.g(str, "view_download", (28 & 4) != 0 ? "" : "", (28 & 8) != 0 ? "" : subject != null ? subject.getSubjectId() : null, (28 & 16) != 0 ? "" : null);
        com.alibaba.android.arouter.launcher.a.d().b("/download/panel_activity").withInt("extra_page_index", 0).navigation();
    }

    private final void m1() {
        String str;
        boolean z11;
        List<ResourceDetectors> resourceDetectors;
        String resourceLink;
        if (getContext() == null) {
            return;
        }
        Subject subject = this.f53801k;
        String str2 = "";
        if (subject == null || (resourceDetectors = subject.getResourceDetectors()) == null) {
            str = "";
            z11 = false;
        } else {
            if (!resourceDetectors.isEmpty()) {
                resourceLink = resourceDetectors.get(0).getResourceLink();
                if (resourceLink == null) {
                    resourceLink = "";
                }
                String resourceId = resourceDetectors.get(0).getResourceId();
                str2 = resourceId != null ? resourceId : "";
                z11 = resourceDetectors.get(0).isMultiResolution();
                str = resourceLink;
            } else {
                resourceLink = "";
            }
            str = resourceLink;
        }
        DownloadManagerApi.a aVar = DownloadManagerApi.f60274j;
        DownloadManagerApi downloadManagerApiA = aVar.a();
        Subject subject2 = this.f53801k;
        String subjectId = subject2 != null ? subject2.getSubjectId() : null;
        Subject subject3 = this.f53801k;
        downloadManagerApiA.m2(subjectId, str2, subject3 != null && subject3.isSeries(), z11);
        Subject subject4 = this.f53801k;
        if (subject4 != null) {
            Integer subjectType = subject4.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                DownloadManagerApi downloadManagerApiA2 = aVar.a();
                Context context = getContext();
                Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                String str3 = this.f53805o;
                Subject subject5 = this.f53801k;
                downloadManagerApiA2.a2(fragmentActivity, str3, (384 & 4) != 0 ? "" : "", subject5 != null ? subject5.getOps() : null, (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : true, (384 & 64) != 0 ? null : this.f53801k, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
                return;
            }
        }
        DownloadManagerApi downloadManagerApiA3 = aVar.a();
        Context context2 = getContext();
        Intrinsics.e(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        DownloadManagerApi.S1(downloadManagerApiA3, (FragmentActivity) context2, this.f53801k, this.f53805o, "", "", str, null, this.f53802l, null, false, this.f53803m, false, 832, null);
    }

    private final MovieDetailViewModel n1() {
        return (MovieDetailViewModel) this.f53807q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean p1() {
        Subject subject = this.f53801k;
        if (subject == null) {
            return false;
        }
        Integer seenStatus = subject.getSeenStatus();
        return seenStatus != null && seenStatus.intValue() == SeenStatus.WANT_TO_SEE.ordinal();
    }

    public static final void u1(HeaderExtensionFragment this$0, Staff staff, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(staff, "$staff");
        this$0.q1(staff);
    }

    public static final void v1(HeaderExtensionFragment this$0, Staff staff, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(staff, "$staff");
        this$0.q1(staff);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x1() {
        String subjectId;
        Subject subject = this.f53801k;
        if (subject == null || (subjectId = subject.getSubjectId()) == null) {
            return;
        }
        if (p1()) {
            n1().F(subjectId, 0);
            zp.b.f82110a.d(R$string.movie_detail_favorite_cancel_toast);
            com.transsion.baselib.helper.a.f51183a.g(this.f53805o, "want_to_see_cancel ", (28 & 4) != 0 ? "" : "", (28 & 8) != 0 ? "" : subjectId, (28 & 16) != 0 ? "" : null);
        } else {
            n1().F(subjectId, 1);
            zp.b.f82110a.d(R$string.movie_detail_favorite_open_toast);
            com.transsion.baselib.helper.a.f51183a.g(this.f53805o, "want_to_see", (28 & 4) != 0 ? "" : "", (28 & 8) != 0 ? "" : subjectId, (28 & 16) != 0 ? "" : null);
            lw.c.f70578a.c(this, NoticePermissionFrom.WANT_TO_SEE);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void D0() {
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("data_key_resource_detectors") : null;
        this.f53801k = serializable instanceof Subject ? (Subject) serializable : null;
        Bundle arguments2 = getArguments();
        this.f53802l = arguments2 != null ? arguments2.getString("module_name") : null;
        Bundle arguments3 = getArguments();
        this.f53803m = arguments3 != null ? arguments3.getInt("season") : 1;
        Bundle arguments4 = getArguments();
        String string = arguments4 != null ? arguments4.getString(WebConstants.PAGE_FROM) : null;
        if (string == null) {
            string = "subjectdetail";
        }
        this.f53805o = string;
        Bundle arguments5 = getArguments();
        this.f53804n = arguments5 != null ? arguments5.getString("ops") : null;
        if (this.f53803m <= 0) {
            this.f53803m = 1;
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    public final void g1() {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        AppCompatTextView appCompatTextView4;
        AppCompatTextView appCompatTextView5;
        AppCompatTextView appCompatTextView6;
        AppCompatTextView appCompatTextView7;
        AppCompatTextView appCompatTextView8;
        AppCompatTextView appCompatTextView9;
        v mViewBinding = getMViewBinding();
        if (mViewBinding != null && (appCompatTextView9 = mViewBinding.f77645j) != null) {
            appCompatTextView9.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.view.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HeaderExtensionFragment.h1(this.f53824a, view);
                }
            });
        }
        Subject subject = this.f53801k;
        if (subject == null || !subject.isEduType()) {
            Subject subject2 = this.f53801k;
            if (subject2 == null || !subject2.isMusicType()) {
                v mViewBinding2 = getMViewBinding();
                if (mViewBinding2 != null && (appCompatTextView = mViewBinding2.f77644i) != null) {
                    appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.view.d
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HeaderExtensionFragment.j1(this.f53826a, view);
                        }
                    });
                }
                Subject subject3 = this.f53801k;
                w1(subject3 != null ? subject3.getSeenStatus() : null);
            } else {
                v mViewBinding3 = getMViewBinding();
                if (mViewBinding3 != null && (appCompatTextView3 = mViewBinding3.f77639c) != null) {
                    so.c.g(appCompatTextView3);
                }
                v mViewBinding4 = getMViewBinding();
                if (mViewBinding4 != null && (appCompatTextView2 = mViewBinding4.f77644i) != null) {
                    so.c.g(appCompatTextView2);
                }
                t1();
            }
        } else {
            v mViewBinding5 = getMViewBinding();
            if (mViewBinding5 != null && (appCompatTextView8 = mViewBinding5.f77639c) != null) {
                appCompatTextView8.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.view.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HeaderExtensionFragment.i1(this.f53825a, view);
                    }
                });
            }
            ct.a.a(this.f53801k, this.f53805o, "opt_detail_addcourse");
            v mViewBinding6 = getMViewBinding();
            if (mViewBinding6 != null && (appCompatTextView7 = mViewBinding6.f77639c) != null) {
                so.c.k(appCompatTextView7);
            }
            v mViewBinding7 = getMViewBinding();
            if (mViewBinding7 != null && (appCompatTextView6 = mViewBinding7.f77644i) != null) {
                so.c.g(appCompatTextView6);
            }
            Subject subject4 = this.f53801k;
            s1(subject4 != null ? subject4.getSeenStatus() : null);
        }
        v mViewBinding8 = getMViewBinding();
        AppCompatTextView appCompatTextView10 = mViewBinding8 != null ? mViewBinding8.f77641f : null;
        if (appCompatTextView10 != null) {
            Subject subject5 = this.f53801k;
            appCompatTextView10.setVisibility(subject5 != null ? Intrinsics.b(subject5.getHasResource(), Boolean.TRUE) : false ? 0 : 8);
        }
        v mViewBinding9 = getMViewBinding();
        if (mViewBinding9 != null && (appCompatTextView5 = mViewBinding9.f77641f) != null) {
            appCompatTextView5.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.view.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HeaderExtensionFragment.k1(this.f53827a, view);
                }
            });
        }
        v mViewBinding10 = getMViewBinding();
        if (mViewBinding10 != null && (appCompatTextView4 = mViewBinding10.f77642g) != null) {
            appCompatTextView4.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.view.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HeaderExtensionFragment.l1(this.f53828a, view);
                }
            });
        }
        n1().u().j(this, new a(new Function1<Integer, Unit>() { // from class: com.transsion.moviedetail.view.HeaderExtensionFragment$addListeners$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer it) {
                HeaderExtensionFragment headerExtensionFragment = this.this$0;
                Intrinsics.f(it, "it");
                headerExtensionFragment.f53803m = it.intValue();
            }
        }));
        n1().r().j(this, new a(new Function1<Pair<? extends String, ? extends Subject>, Unit>() { // from class: com.transsion.moviedetail.view.HeaderExtensionFragment$addListeners$7$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends Subject> pair) {
                invoke2((Pair<String, ? extends Subject>) pair);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<String, ? extends Subject> pair) {
                HashMap<String, String> mapG;
                HashMap<String, String> mapG2;
                Subject second = pair.getSecond();
                uo.b.f78622a.c("zxb_fragment", "get movie detail data==" + pair, true);
                if (second != null) {
                    this.this$0.f53801k = second;
                    com.transsion.baselib.report.h logViewConfig = this.this$0.getLogViewConfig();
                    if (logViewConfig != null) {
                        logViewConfig.j(true);
                    }
                    com.transsion.baselib.report.h logViewConfig2 = this.this$0.getLogViewConfig();
                    if (logViewConfig2 != null) {
                        logViewConfig2.m(this.this$0.f53804n);
                    }
                    com.transsion.baselib.report.h logViewConfig3 = this.this$0.getLogViewConfig();
                    if (logViewConfig3 != null && (mapG2 = logViewConfig3.g()) != null) {
                        String subjectId = second.getSubjectId();
                        if (subjectId == null) {
                            subjectId = "";
                        }
                        mapG2.put("subject_id", subjectId);
                    }
                    com.transsion.baselib.report.h logViewConfig4 = this.this$0.getLogViewConfig();
                    if (logViewConfig4 == null || (mapG = logViewConfig4.g()) == null) {
                        return;
                    }
                    mapG.put("has_resource", String.valueOf(second.getHasResource()));
                }
            }
        }));
        n1().A().j(this, new a(new Function1<BaseDto<Object>, Unit>() { // from class: com.transsion.moviedetail.view.HeaderExtensionFragment$addListeners$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BaseDto<Object> baseDto) {
                invoke2(baseDto);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BaseDto<Object> baseDto) {
                String subjectId;
                String subjectId2;
                Long wantToSeeCount;
                if (baseDto != null) {
                    HeaderExtensionFragment headerExtensionFragment = this.this$0;
                    if (Intrinsics.b(baseDto.getCode(), "0")) {
                        Subject subject6 = headerExtensionFragment.f53801k;
                        long jLongValue = (subject6 == null || (wantToSeeCount = subject6.getWantToSeeCount()) == null) ? 0L : wantToSeeCount.longValue();
                        if (headerExtensionFragment.p1()) {
                            Subject subject7 = headerExtensionFragment.f53801k;
                            if (subject7 != null) {
                                subject7.setSeenStatus(Integer.valueOf(SeenStatus.NOT_SEEN.ordinal()));
                            }
                            headerExtensionFragment.w1(Integer.valueOf(SeenStatus.NOT_SEEN.ordinal()));
                            Subject subject8 = headerExtensionFragment.f53801k;
                            if (subject8 != null) {
                                subject8.setWantToSeeCount(Long.valueOf(jLongValue - 1));
                            }
                            Subject subject9 = headerExtensionFragment.f53801k;
                            if (subject9 == null || (subjectId2 = subject9.getSubjectId()) == null) {
                                return;
                            }
                            SyncManager.f61414a.a().g(0, subjectId2);
                            return;
                        }
                        Subject subject10 = headerExtensionFragment.f53801k;
                        if (subject10 != null) {
                            subject10.setSeenStatus(Integer.valueOf(SeenStatus.WANT_TO_SEE.ordinal()));
                        }
                        headerExtensionFragment.w1(Integer.valueOf(SeenStatus.WANT_TO_SEE.ordinal()));
                        Subject subject11 = headerExtensionFragment.f53801k;
                        if (subject11 != null) {
                            subject11.setWantToSeeCount(Long.valueOf(jLongValue + 1));
                        }
                        Subject subject12 = headerExtensionFragment.f53801k;
                        if (subject12 == null || (subjectId = subject12.getSubjectId()) == null) {
                            return;
                        }
                        SyncManager.f61414a.a().g(1, subjectId);
                    }
                }
            }
        }));
        Subject subject6 = this.f53801k;
        if (subject6 == null || !subject6.isEduType()) {
            return;
        }
        kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this), null, null, new HeaderExtensionFragment$addListeners$9(this, null), 3, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        g1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: o1, reason: merged with bridge method [inline-methods] */
    public v getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        v vVarC = v.c(inflater);
        Intrinsics.f(vVarC, "inflate(inflater)");
        return vVarC;
    }

    public final void q1(Staff staff) {
        com.alibaba.android.arouter.launcher.a.d().b("/movie/staff").withSerializable("staff", staff).navigation();
    }

    public final void r1(String str) {
        ShareDialogFragment shareDialogFragment;
        Subject subject = this.f53801k;
        if (subject == null) {
            return;
        }
        com.transsion.baselib.helper.a.f51183a.g(this.f53805o, AppLovinEventTypes.USER_SHARED_LINK, (28 & 4) != 0 ? "" : "", (28 & 8) != 0 ? "" : subject != null ? subject.getSubjectId() : null, (28 & 16) != 0 ? "" : null);
        if (this.f53806p == null) {
            ShareDialogFragment.a aVar = ShareDialogFragment.f57724t;
            PostType postType = PostType.SUBJECT_TYPE;
            String value = ReportType.SUBJECT.getValue();
            Subject subject2 = this.f53801k;
            String title = subject2 != null ? subject2.getTitle() : null;
            Subject subject3 = this.f53801k;
            ShareDialogFragment shareDialogFragmentA = aVar.a(postType, str, "", value, (3072 & 16) != 0 ? "" : title, (3072 & 32) != 0 ? "" : String.valueOf(subject3 != null ? subject3.getImdbRate() : null), (3072 & 64) != 0 ? false : false, (3072 & 128) != 0 ? false : false, (3072 & 256) != 0 ? false : false, this.f53805o, (3072 & 1024) != 0 ? "" : null, (3072 & 2048) != 0 ? "" : null);
            this.f53806p = shareDialogFragmentA;
            if (shareDialogFragmentA != null) {
                shareDialogFragmentA.E0(new b());
            }
        }
        try {
            if (isAdded()) {
                FragmentManager childFragmentManager = getChildFragmentManager();
                childFragmentManager.executePendingTransactions();
                ShareDialogFragment shareDialogFragment2 = this.f53806p;
                if ((shareDialogFragment2 == null || !shareDialogFragment2.isAdded()) && childFragmentManager.findFragmentByTag(AppLovinEventTypes.USER_SHARED_LINK) == null && (shareDialogFragment = this.f53806p) != null) {
                    shareDialogFragment.show(childFragmentManager, AppLovinEventTypes.USER_SHARED_LINK);
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void s1(Integer num) {
        v mViewBinding = getMViewBinding();
        AppCompatTextView appCompatTextView = mViewBinding != null ? mViewBinding.f77639c : null;
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setSelected(num != null && SeenStatus.WANT_TO_SEE.ordinal() == num.intValue());
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    public final void t1() {
        List<Staff> staffList;
        ConstraintLayout tvMusicAvatar;
        AppCompatTextView appCompatTextView;
        ShapeableImageView shapeableImageView;
        ShapeableImageView it1;
        ConstraintLayout tvMusicAvatar2;
        ConstraintLayout tvMusicAvatar3;
        Subject subject = this.f53801k;
        if (subject == null || (staffList = subject.getStaffList()) == null) {
            return;
        }
        if (!(!staffList.isEmpty())) {
            v mViewBinding = getMViewBinding();
            if (mViewBinding == null || (tvMusicAvatar = mViewBinding.f77643h) == null) {
                return;
            }
            Intrinsics.f(tvMusicAvatar, "tvMusicAvatar");
            so.c.g(tvMusicAvatar);
            return;
        }
        final Staff staff = staffList.get(0);
        if (TextUtils.isEmpty(staff.getAvatarUrl())) {
            v mViewBinding2 = getMViewBinding();
            if (mViewBinding2 == null || (tvMusicAvatar3 = mViewBinding2.f77643h) == null) {
                return;
            }
            Intrinsics.f(tvMusicAvatar3, "tvMusicAvatar");
            so.c.g(tvMusicAvatar3);
            return;
        }
        v mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (tvMusicAvatar2 = mViewBinding3.f77643h) != null) {
            Intrinsics.f(tvMusicAvatar2, "tvMusicAvatar");
            so.c.k(tvMusicAvatar2);
        }
        v mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (it1 = mViewBinding4.f77638b) != null) {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
            Intrinsics.f(it1, "it1");
            String avatarUrl = staff.getAvatarUrl();
            if (avatarUrl == null) {
                avatarUrl = "";
            }
            companion.r(fragmentActivityRequireActivity, it1, avatarUrl, (4088 & 8) != 0 ? companion.d() : 0, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        }
        v mViewBinding5 = getMViewBinding();
        if (mViewBinding5 != null && (shapeableImageView = mViewBinding5.f77638b) != null) {
            shapeableImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.view.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HeaderExtensionFragment.u1(this.f53829a, staff, view);
                }
            });
        }
        v mViewBinding6 = getMViewBinding();
        if (mViewBinding6 != null && (appCompatTextView = mViewBinding6.f77640d) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.view.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HeaderExtensionFragment.v1(this.f53831a, staff, view);
                }
            });
        }
        v mViewBinding7 = getMViewBinding();
        AppCompatTextView appCompatTextView2 = mViewBinding7 != null ? mViewBinding7.f77640d : null;
        if (appCompatTextView2 == null) {
            return;
        }
        appCompatTextView2.setText(staff.getName());
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        Subject subject = this.f53801k;
        w1(subject != null ? subject.getSeenStatus() : null);
        Subject subject2 = this.f53801k;
        s1(subject2 != null ? subject2.getSeenStatus() : null);
    }

    public final void w1(Integer num) {
        AppCompatTextView appCompatTextView;
        int iOrdinal = SeenStatus.WANT_TO_SEE.ordinal();
        if (num != null && num.intValue() == iOrdinal) {
            v mViewBinding = getMViewBinding();
            AppCompatTextView appCompatTextView2 = mViewBinding != null ? mViewBinding.f77644i : null;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setSelected(true);
            }
            v mViewBinding2 = getMViewBinding();
            appCompatTextView = mViewBinding2 != null ? mViewBinding2.f77644i : null;
            if (appCompatTextView == null) {
                return;
            }
            appCompatTextView.setText(Utils.a().getString(R$string.movie_detail_added));
            return;
        }
        v mViewBinding3 = getMViewBinding();
        AppCompatTextView appCompatTextView3 = mViewBinding3 != null ? mViewBinding3.f77644i : null;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setSelected(false);
        }
        v mViewBinding4 = getMViewBinding();
        appCompatTextView = mViewBinding4 != null ? mViewBinding4.f77644i : null;
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setText(Utils.a().getString(R$string.movie_detail_add_to_list));
    }
}
