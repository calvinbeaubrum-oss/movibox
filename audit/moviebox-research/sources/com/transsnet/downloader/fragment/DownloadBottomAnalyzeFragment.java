package com.transsnet.downloader.fragment;

import android.animation.Animator;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.airbnb.lottie.LottieAnimationView;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.FirebaseAnalyticsManager;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.web.api.WebConstants;
import com.transsion.web.api.WebPageIdentity;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.bean.DownloadUrlBean;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.manager.StartDownloadHelper;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
@Metadata
public class DownloadBottomAnalyzeFragment extends BaseDialog {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f60613w = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h00.z f60614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f60615d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f60616f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Subject f60617g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f60618h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f60619i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f60620j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f60621k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f60622l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f60623m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f60624n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public DownloadBean f60625o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f60626p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f60627q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f60628r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f60629s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Function4<? super Integer, ? super String, ? super DownloadBean, ? super Boolean, Unit> f60630t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f60631u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final DownloadBottomAnalyzeFragment$runnable$1 f60632v;

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
    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f60634b;

        public b(Function0<Unit> function0) {
            this.f60634b = function0;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.g(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.g(animation, "animation");
            if (DownloadBottomAnalyzeFragment.this.isAdded() && !DownloadBottomAnalyzeFragment.this.isStateSaved()) {
                Function0<Unit> function0 = this.f60634b;
                if (function0 != null) {
                    function0.invoke();
                }
                DownloadBottomAnalyzeFragment.this.dismiss();
            }
            Function1 function1 = DownloadBottomAnalyzeFragment.this.f60631u;
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Intrinsics.g(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.g(animation, "animation");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f60635a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60635a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60635a;
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
            this.f60635a.invoke(obj);
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.transsnet.downloader.fragment.DownloadBottomAnalyzeFragment$runnable$1] */
    public DownloadBottomAnalyzeFragment() {
        super(R$layout.fragment_download_res_ana);
        this.f60615d = "";
        this.f60616f = "";
        this.f60628r = LazyKt__LazyJVMKt.b(new Function0<com.transsnet.downloader.manager.a>() { // from class: com.transsnet.downloader.fragment.DownloadBottomAnalyzeFragment$downloadManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.transsnet.downloader.manager.a invoke() {
                return com.transsnet.downloader.manager.b.f61062a.a(Utils.a());
            }
        });
        this.f60629s = LazyKt__LazyJVMKt.b(new Function0<StartDownloadHelper>() { // from class: com.transsnet.downloader.fragment.DownloadBottomAnalyzeFragment$startDownloadHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final StartDownloadHelper invoke() {
                return new StartDownloadHelper();
            }
        });
        this.f60632v = new Runnable() { // from class: com.transsnet.downloader.fragment.DownloadBottomAnalyzeFragment$runnable$1
            @Override // java.lang.Runnable
            public void run() {
                AppCompatTextView appCompatTextView;
                AppCompatTextView appCompatTextView2;
                this.this$0.f60626p++;
                h00.z zVar = this.this$0.f60614c;
                ProgressBar progressBar = zVar != null ? zVar.f66105c : null;
                if (progressBar != null) {
                    progressBar.setProgress(this.this$0.f60626p);
                }
                if (this.this$0.f60626p < 100) {
                    h00.z zVar2 = this.this$0.f60614c;
                    if (zVar2 == null || (appCompatTextView = zVar2.f66107f) == null) {
                        return;
                    }
                    appCompatTextView.postDelayed(this, 20L);
                    return;
                }
                h00.z zVar3 = this.this$0.f60614c;
                if (zVar3 != null && (appCompatTextView2 = zVar3.f66107f) != null) {
                    appCompatTextView2.removeCallbacks(this);
                }
                if (this.this$0.f60621k) {
                    return;
                }
                DownloadBottomAnalyzeFragment.L0(this.this$0, null, 1, null);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F0(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap map = new HashMap();
        map.put(WebConstants.PAGE_FROM, str2);
        map.put("subject_id", str3);
        map.put("post_id", str4);
        map.put("ops", str5);
        map.put("resource_id", str6);
        map.put("task_id", str7);
        map.put("module_name", this.f60624n);
        com.transsion.baselib.report.m mVar = com.transsion.baselib.report.m.f51277a;
        if (str == null) {
            str = "download_click";
        }
        mVar.m(str, "download_click", map);
        Bundle bundle = new Bundle();
        bundle.putString("resource_id", str6);
        bundle.putString("subject_id", str3);
        FirebaseAnalyticsManager.f51235a.n("download_click", bundle, getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsnet.downloader.manager.a G0() {
        return (com.transsnet.downloader.manager.a) this.f60628r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StartDownloadHelper H0() {
        return (StartDownloadHelper) this.f60629s.getValue();
    }

    private final void I0() {
        HashMap<String, String> mapG;
        h00.z zVar = this.f60614c;
        AppCompatTextView appCompatTextView = zVar != null ? zVar.f66106d : null;
        if (appCompatTextView != null) {
            appCompatTextView.setText(getString(R$string.download_analyzing) + " from " + this.f60623m);
        }
        if (this.f60619i) {
            com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (mapG = logViewConfig.g()) != null) {
                mapG.put("anima_only", "true");
            }
            uo.b.a.f(uo.b.f78622a, "downloadAna", "anima only~}", false, 4, null);
            return;
        }
        uo.b.a.f(uo.b.f78622a, "downloadAna", "single， initData subject is null = " + (this.f60617g == null) + ", ", false, 4, null);
        String str = this.f60620j;
        if (str == null || str.length() <= 0) {
            Subject subject = this.f60617g;
            if (subject != null) {
                if (subject != null) {
                    kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this), null, null, new DownloadBottomAnalyzeFragment$initData$3$1(subject, this, null), 3, null);
                    return;
                }
                return;
            } else {
                androidx.lifecycle.c0<List<DownloadBean>> c0VarO = DownloadListManager.f61186m.a().o();
                if (c0VarO != null) {
                    c0VarO.j(this, new c(new Function1<List<? extends DownloadBean>, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadBottomAnalyzeFragment$initData$2

                        /* JADX INFO: renamed from: com.transsnet.downloader.fragment.DownloadBottomAnalyzeFragment$initData$2$1, reason: invalid class name */
                        /* JADX INFO: compiled from: source.java */
                        @Metadata
                        @DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadBottomAnalyzeFragment$initData$2$1", f = "DownloadBottomAnalyzeFragment.kt", l = {195}, m = "invokeSuspend")
                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
                            final /* synthetic */ List<DownloadBean> $it;
                            int label;
                            final /* synthetic */ DownloadBottomAnalyzeFragment this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            public AnonymousClass1(List<? extends DownloadBean> list, DownloadBottomAnalyzeFragment downloadBottomAnalyzeFragment, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$it = list;
                                this.this$0 = downloadBottomAnalyzeFragment;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$it, this.this$0, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) throws Throwable {
                                Object objE = kotlin.coroutines.intrinsics.a.e();
                                int i11 = this.label;
                                if (i11 == 0) {
                                    ResultKt.b(obj);
                                    List<DownloadBean> list = this.$it;
                                    if (list == null || list.isEmpty()) {
                                        return Unit.f68710a;
                                    }
                                    DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
                                    String resourceId = this.$it.get(0).getResourceId();
                                    if (resourceId == null) {
                                        resourceId = this.$it.get(0).getUrl();
                                    }
                                    this.label = 1;
                                    obj = downloadEsHelperA.k(resourceId, this);
                                    if (obj == objE) {
                                        return objE;
                                    }
                                } else {
                                    if (i11 != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.b(obj);
                                }
                                DownloadBean downloadBean = (DownloadBean) obj;
                                if (downloadBean != null) {
                                    uo.b.a.f(uo.b.f78622a, "downloadAna", "single， get download bean from database", false, 4, null);
                                    this.this$0.f60625o = downloadBean;
                                } else {
                                    uo.b.a.f(uo.b.f78622a, "downloadAna", "single， create download bean from subject", false, 4, null);
                                    List<DownloadBean> it = this.$it;
                                    Intrinsics.f(it, "it");
                                    if (!it.isEmpty()) {
                                        this.this$0.f60625o = this.$it.get(0);
                                    }
                                }
                                DownloadBean downloadBean2 = this.this$0.f60625o;
                                if (downloadBean2 != null) {
                                    DownloadBottomAnalyzeFragment downloadBottomAnalyzeFragment = this.this$0;
                                    uo.b.a.f(uo.b.f78622a, "downloadAna", "single， add download task， " + downloadBean2, false, 4, null);
                                    downloadBottomAnalyzeFragment.N0(downloadBean2);
                                    downloadBean2.setCreateAt(System.currentTimeMillis());
                                    downloadBean2.setUpdateTimeStamp(Boxing.e(System.currentTimeMillis()));
                                    downloadBean2.setPageFrom(downloadBottomAnalyzeFragment.f60615d);
                                    downloadBean2.setLastPageFrom(downloadBottomAnalyzeFragment.f60616f);
                                    downloadBean2.setOps(downloadBottomAnalyzeFragment.f60622l);
                                    String string = UUID.randomUUID().toString();
                                    Intrinsics.f(string, "randomUUID().toString()");
                                    downloadBean2.setTaskId(string);
                                    downloadBottomAnalyzeFragment.F0(downloadBottomAnalyzeFragment.f60615d, downloadBottomAnalyzeFragment.f60616f, downloadBean2.getSubjectId(), downloadBean2.getPostId(), downloadBottomAnalyzeFragment.f60622l, downloadBean2.getResourceId(), string);
                                    downloadBottomAnalyzeFragment.G0().p(downloadBean2);
                                    downloadBottomAnalyzeFragment.H0().d(kotlin.collections.g.h(downloadBean2));
                                }
                                return Unit.f68710a;
                            }
                        }

                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(List<? extends DownloadBean> list) {
                            invoke2(list);
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(List<? extends DownloadBean> list) {
                            List<? extends DownloadBean> list2 = list;
                            if (list2 == null || list2.isEmpty()) {
                                return;
                            }
                            kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this.this$0), null, null, new AnonymousClass1(list, this.this$0, null), 3, null);
                        }
                    }));
                    return;
                }
                return;
            }
        }
        this.f60621k = true;
        DownloadListManager.a aVar = DownloadListManager.f61186m;
        DownloadListManager downloadListManagerA = aVar.a();
        Subject subject2 = this.f60617g;
        String subjectId = subject2 != null ? subject2.getSubjectId() : null;
        String str2 = this.f60620j;
        Intrinsics.d(str2);
        downloadListManagerA.E(subjectId, str2);
        androidx.lifecycle.c0<DownloadUrlBean> c0VarF = aVar.a().F();
        if (c0VarF != null) {
            c0VarF.j(this, new c(new Function1<DownloadUrlBean, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadBottomAnalyzeFragment$initData$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DownloadUrlBean downloadUrlBean) {
                    invoke2(downloadUrlBean);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DownloadUrlBean downloadUrlBean) {
                    this.this$0.f60621k = false;
                    this.this$0.M0(downloadUrlBean);
                }
            }));
        }
    }

    private final void J0(View view) {
        LottieAnimationView lottieAnimationView;
        h00.z zVarA = h00.z.a(view);
        this.f60614c = zVarA;
        ProgressBar progressBar = zVarA != null ? zVarA.f66105c : null;
        if (progressBar != null) {
            progressBar.setMax(100);
        }
        h00.z zVar = this.f60614c;
        if (zVar != null && (lottieAnimationView = zVar.f66104b) != null) {
            lottieAnimationView.playAnimation();
            lottieAnimationView.setRepeatCount(-1);
        }
        O0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void L0(DownloadBottomAnalyzeFragment downloadBottomAnalyzeFragment, Function0 function0, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onAnalyzeSuccess");
        }
        if ((i11 & 1) != 0) {
            function0 = null;
        }
        downloadBottomAnalyzeFragment.K0(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M0(DownloadUrlBean downloadUrlBean) {
        if ((downloadUrlBean != null ? downloadUrlBean.getResource() : null) != null) {
            DownloadItem resource = downloadUrlBean.getResource();
            String url = resource != null ? resource.getUrl() : null;
            if (url != null && url.length() != 0) {
                DownloadItem resource2 = downloadUrlBean.getResource();
                Ref.IntRef intRef = new Ref.IntRef();
                intRef.element = downloadUrlBean.getTotalEpisode();
                kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this), null, null, new DownloadBottomAnalyzeFragment$onGetUrlDownloadConfig$2(resource2, this, intRef, downloadUrlBean, null), 3, null);
                return;
            }
        }
        uo.b.a.f(uo.b.f78622a, "downloadAna", "url has no resource, open url", false, 4, null);
        K0(new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.DownloadBottomAnalyzeFragment$onGetUrlDownloadConfig$1
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
                com.alibaba.android.arouter.launcher.a.d().b(WebPageIdentity.WEB_VIEW).withString("url", this.this$0.f60620j).navigation();
            }
        });
    }

    private final void O0() {
        AppCompatTextView appCompatTextView;
        LottieAnimationView lottieAnimationView;
        h00.z zVar = this.f60614c;
        if (zVar != null && (lottieAnimationView = zVar.f66104b) != null) {
            lottieAnimationView.setRepeatCount(-1);
            lottieAnimationView.setAnimation(com.transsion.baselib.utils.o.f51321a.a() ? "download_analyzing_anima_night.json" : "download_analyzing_anima.json");
            lottieAnimationView.playAnimation();
        }
        h00.z zVar2 = this.f60614c;
        if (zVar2 == null || (appCompatTextView = zVar2.f66107f) == null) {
            return;
        }
        appCompatTextView.post(this.f60632v);
    }

    public final void K0(Function0<Unit> function0) {
        LottieAnimationView lottieAnimationView;
        AppCompatTextView appCompatTextView;
        h00.z zVar = this.f60614c;
        if (zVar != null && (appCompatTextView = zVar.f66107f) != null) {
            appCompatTextView.removeCallbacks(this.f60632v);
        }
        h00.z zVar2 = this.f60614c;
        ProgressBar progressBar = zVar2 != null ? zVar2.f66105c : null;
        if (progressBar != null) {
            progressBar.setProgress(100);
        }
        h00.z zVar3 = this.f60614c;
        if (zVar3 == null || (lottieAnimationView = zVar3.f66104b) == null) {
            return;
        }
        lottieAnimationView.setAnimation(com.transsion.baselib.utils.o.f51321a.a() ? "download_analyzing_success_anima_night.json" : "download_analyzing_success_anima.json");
        lottieAnimationView.setRepeatCount(0);
        lottieAnimationView.addAnimatorListener(new b(function0));
        lottieAnimationView.playAnimation();
    }

    public final void N0(DownloadBean downloadBean) {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String string;
        String string2;
        String string3;
        String string4;
        HashMap<String, String> mapG;
        HashMap<String, String> mapG2;
        HashMap<String, String> mapG3;
        HashMap<String, String> mapG4;
        String string5;
        super.onCreate(bundle);
        setCancelable(false);
        setStyle(0, R$style.BottomDialogTheme);
        Bundle arguments = getArguments();
        String string6 = arguments != null ? arguments.getString("extra_page_from") : null;
        String str = "";
        if (string6 == null) {
            string6 = "";
        }
        this.f60615d = string6;
        Bundle arguments2 = getArguments();
        String string7 = arguments2 != null ? arguments2.getString("extra_last_page_from") : null;
        if (string7 == null) {
            string7 = "";
        }
        this.f60616f = string7;
        Bundle arguments3 = getArguments();
        this.f60617g = (Subject) (arguments3 != null ? arguments3.getSerializable("extra_subject") : null);
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (string = arguments4.getString("extra_group_id")) == null) {
            string = "";
        }
        this.f60618h = string;
        Bundle arguments5 = getArguments();
        this.f60619i = arguments5 != null ? arguments5.getBoolean("extra_anima_only") : false;
        Bundle arguments6 = getArguments();
        if (arguments6 == null || (string2 = arguments6.getString("extra_link_url")) == null) {
            string2 = "";
        }
        this.f60620j = string2;
        Bundle arguments7 = getArguments();
        if (arguments7 == null || (string3 = arguments7.getString("extra_ops")) == null) {
            string3 = "";
        }
        this.f60622l = string3;
        Bundle arguments8 = getArguments();
        if (arguments8 == null || (string4 = arguments8.getString("extra_resource")) == null) {
            string4 = "";
        }
        this.f60623m = string4;
        Bundle arguments9 = getArguments();
        if (arguments9 != null && (string5 = arguments9.getString("extra_module_name")) != null) {
            str = string5;
        }
        this.f60624n = str;
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (mapG4 = logViewConfig.g()) != null) {
            mapG4.put(WebConstants.PAGE_FROM, this.f60615d);
        }
        com.transsion.baselib.report.h logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (mapG3 = logViewConfig2.g()) != null) {
            mapG3.put("last_page_from", this.f60616f);
        }
        com.transsion.baselib.report.h logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null && (mapG2 = logViewConfig3.g()) != null) {
            mapG2.put("ops", this.f60622l);
        }
        com.transsion.baselib.report.h logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 == null || (mapG = logViewConfig4.g()) == null) {
            return;
        }
        mapG.put("type", "1");
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        uo.b.a.f(uo.b.f78622a, "TAG", "onCreateDialog: ", false, 4, null);
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        com.google.android.material.bottomsheet.b bVar = new com.google.android.material.bottomsheet.b(contextRequireContext, getTheme());
        Window window = bVar.getWindow();
        if (window != null) {
            window.setWindowAnimations(R$style.BaseBottomDialogAnimation);
        }
        Window window2 = bVar.getWindow();
        if (window2 != null) {
            window2.setGravity(80);
            window2.setDimAmount(0.5f);
            WindowManager.LayoutParams attributes = window2.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            } else {
                Intrinsics.f(attributes, "it.attributes ?: WindowManager.LayoutParams()");
            }
            attributes.width = com.transsion.baseui.util.a.f51450a.b(contextRequireContext);
            attributes.height = com.blankj.utilcode.util.f0.a(168.0f);
            window2.setBackgroundDrawable(null);
            window2.setAttributes(attributes);
        }
        return bVar;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onDestroy() {
        String strA;
        DownloadListManager.a aVar = DownloadListManager.f61186m;
        aVar.a().K(null);
        aVar.a().N(null);
        super.onDestroy();
        DownloadBean downloadBean = this.f60625o;
        if (downloadBean != null) {
            Long size = downloadBean.getSize();
            if (size == null || (strA = tp.a.a(size.longValue(), 1)) == null) {
                strA = "";
            }
            Function4<? super Integer, ? super String, ? super DownloadBean, ? super Boolean, Unit> function4 = this.f60630t;
            if (function4 != null) {
                function4.invoke(1, strA, downloadBean, Boolean.valueOf(this.f60627q));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        J0(view);
        I0();
    }
}
