package com.transsnet.downloader.fragment;

import android.animation.Animator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import com.airbnb.lottie.LottieAnimationView;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.web.api.WebPageIdentity;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.bean.DownloadUrlBean;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

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
@Metadata
public class DownloadReDetectorAnalysingFragment extends DownloadReDetectorSingleResBaseFragment<h00.z> {
    public static final a J = new a(null);
    public Subject A;
    public boolean B;
    public String E;
    public String F;
    public int G;
    public boolean H;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f60686z;
    public String C = "";
    public String D = "";
    public final DownloadReDetectorAnalysingFragment$runnable$1 I = new Runnable() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorAnalysingFragment$runnable$1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            AppCompatTextView appCompatTextView;
            AppCompatTextView appCompatTextView2;
            this.this$0.G++;
            h00.z zVar = (h00.z) this.this$0.getMViewBinding();
            ProgressBar progressBar = zVar != null ? zVar.f66105c : null;
            if (progressBar != null) {
                progressBar.setProgress(this.this$0.G);
            }
            if (this.this$0.G < 100) {
                h00.z zVar2 = (h00.z) this.this$0.getMViewBinding();
                if (zVar2 == null || (appCompatTextView = zVar2.f66107f) == null) {
                    return;
                }
                appCompatTextView.postDelayed(this, 20L);
                return;
            }
            h00.z zVar3 = (h00.z) this.this$0.getMViewBinding();
            if (zVar3 != null && (appCompatTextView2 = zVar3.f66107f) != null) {
                appCompatTextView2.removeCallbacks(this);
            }
            if (this.this$0.B) {
                return;
            }
            DownloadReDetectorAnalysingFragment.J1(this.this$0, null, null, 2, null);
        }
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadReDetectorAnalysingFragment a(String str, Subject subject, String str2, String str3, String str4, String str5, Boolean bool, String str6) {
            DownloadReDetectorAnalysingFragment downloadReDetectorAnalysingFragment = new DownloadReDetectorAnalysingFragment();
            downloadReDetectorAnalysingFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("extra_page_from", str2), TuplesKt.a("extra_last_page_from", str3), TuplesKt.a("extra_subject", subject), TuplesKt.a("extra_link_url", str), TuplesKt.a("extra_ops", str4), TuplesKt.a("extra_resource", str5), TuplesKt.a("extra_download_execute_download", bool), TuplesKt.a("extra_module_name", str6)));
            return downloadReDetectorAnalysingFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f60688b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DownloadUrlBean f60689c;

        public b(Function0<Unit> function0, DownloadUrlBean downloadUrlBean) {
            this.f60688b = function0;
            this.f60689c = downloadUrlBean;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.g(animation, "animation");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            LottieAnimationView lottieAnimationView;
            Intrinsics.g(animation, "animation");
            h00.z zVar = (h00.z) DownloadReDetectorAnalysingFragment.this.getMViewBinding();
            if (zVar != null && (lottieAnimationView = zVar.f66104b) != null) {
                lottieAnimationView.removeAnimatorListener(this);
            }
            if (!DownloadReDetectorAnalysingFragment.this.isAdded() || DownloadReDetectorAnalysingFragment.this.isStateSaved()) {
                return;
            }
            Function0<Unit> function0 = this.f60688b;
            if (function0 != null) {
                function0.invoke();
            }
            if (this.f60689c == null) {
                uo.b.a aVar = uo.b.f78622a;
                String TAG = DownloadReDetectorAnalysingFragment.this.X0();
                Intrinsics.f(TAG, "TAG");
                uo.b.a.f(aVar, TAG, "onAnalyzeSuccess ,  close 2", false, 4, null);
                DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = DownloadReDetectorAnalysingFragment.this.Y0();
                androidx.lifecycle.c0<Boolean> c0VarL = downloadResourcesDetectorViewModelY0 != null ? downloadResourcesDetectorViewModelY0.l() : null;
                if (c0VarL != null) {
                    c0VarL.q(Boolean.TRUE);
                }
                DownloadReDetectorAnalysingFragment.this.S0();
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
        public final /* synthetic */ Function1 f60690a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60690a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60690a;
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
            this.f60690a.invoke(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void H1() {
        if (this.F != null) {
            h00.z zVar = (h00.z) getMViewBinding();
            AppCompatTextView appCompatTextView = zVar != null ? zVar.f66106d : null;
            if (appCompatTextView != null) {
                String str = getString(R$string.download_analyzing) + " from " + this.F;
                Intrinsics.f(str, "toString(...)");
                appCompatTextView.setText(str);
            }
        }
        String str2 = this.f60686z;
        if (str2 == null || str2.length() <= 0) {
            return;
        }
        this.B = true;
        DownloadListManager.a aVar = DownloadListManager.f61186m;
        DownloadListManager downloadListManagerA = aVar.a();
        Subject subject = this.A;
        String subjectId = subject != null ? subject.getSubjectId() : null;
        String str3 = this.f60686z;
        Intrinsics.d(str3);
        downloadListManagerA.E(subjectId, str3);
        androidx.lifecycle.c0<DownloadUrlBean> c0VarF = aVar.a().F();
        if (c0VarF != null) {
            c0VarF.j(this, new c(new Function1<DownloadUrlBean, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorAnalysingFragment$initData$2
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
                    this.this$0.B = false;
                    this.this$0.K1(downloadUrlBean);
                }
            }));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void J1(DownloadReDetectorAnalysingFragment downloadReDetectorAnalysingFragment, DownloadUrlBean downloadUrlBean, Function0 function0, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onAnalyzeSuccess");
        }
        if ((i11 & 2) != 0) {
            function0 = null;
        }
        downloadReDetectorAnalysingFragment.I1(downloadUrlBean, function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        LottieAnimationView lottieAnimationView;
        h00.z zVar = (h00.z) getMViewBinding();
        ProgressBar progressBar = zVar != null ? zVar.f66105c : null;
        if (progressBar != null) {
            progressBar.setMax(100);
        }
        h00.z zVar2 = (h00.z) getMViewBinding();
        if (zVar2 != null && (lottieAnimationView = zVar2.f66104b) != null) {
            lottieAnimationView.playAnimation();
            lottieAnimationView.setRepeatCount(-1);
        }
        M1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: G1, reason: merged with bridge method [inline-methods] */
    public h00.z getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        h00.z zVarC = h00.z.c(inflater);
        Intrinsics.f(zVarC, "inflate(inflater)");
        return zVarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void I1(DownloadUrlBean downloadUrlBean, Function0<Unit> function0) {
        LottieAnimationView lottieAnimationView;
        AppCompatTextView appCompatTextView;
        h00.z zVar = (h00.z) getMViewBinding();
        if (zVar != null && (appCompatTextView = zVar.f66107f) != null) {
            appCompatTextView.removeCallbacks(this.I);
        }
        h00.z zVar2 = (h00.z) getMViewBinding();
        ProgressBar progressBar = zVar2 != null ? zVar2.f66105c : null;
        if (progressBar != null) {
            progressBar.setProgress(100);
        }
        h00.z zVar3 = (h00.z) getMViewBinding();
        if (zVar3 == null || (lottieAnimationView = zVar3.f66104b) == null) {
            return;
        }
        lottieAnimationView.setAnimation(com.transsion.baselib.utils.o.f51321a.a() ? "download_analyzing_success_anima_night.json" : "download_analyzing_success_anima.json");
        lottieAnimationView.setRepeatCount(0);
        lottieAnimationView.addAnimatorListener(new b(function0, downloadUrlBean));
        lottieAnimationView.playAnimation();
    }

    public final void K1(final DownloadUrlBean downloadUrlBean) {
        if ((downloadUrlBean != null ? downloadUrlBean.getResource() : null) != null) {
            DownloadItem resource = downloadUrlBean.getResource();
            String url = resource != null ? resource.getUrl() : null;
            if (url != null && url.length() != 0) {
                I1(downloadUrlBean, new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorAnalysingFragment$onGetUrlDownloadConfig$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        DownloadListManager.f61186m.a().i(DownloadUtil.f61136a.e(downloadUrlBean, this.A, this.C, this.D, this.E));
                        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = this.Y0();
                        androidx.lifecycle.c0<Integer> c0VarO = downloadResourcesDetectorViewModelY0 != null ? downloadResourcesDetectorViewModelY0.o() : null;
                        if (c0VarO != null) {
                            c0VarO.q(1);
                        }
                        this.L1();
                    }
                });
                return;
            }
        }
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "url has no resource, open url", false, 4, null);
        I1(null, new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorAnalysingFragment$onGetUrlDownloadConfig$1
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
                com.alibaba.android.arouter.launcher.a.d().b(WebPageIdentity.WEB_VIEW).withString("url", this.this$0.f60686z).navigation();
            }
        });
    }

    public final void L1() {
        this.H = true;
        this.f60686z = "";
        this.B = false;
        this.G = 0;
        DownloadListManager.f61186m.a().N(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void M1() {
        AppCompatTextView appCompatTextView;
        LottieAnimationView lottieAnimationView;
        h00.z zVar = (h00.z) getMViewBinding();
        if (zVar != null && (lottieAnimationView = zVar.f66104b) != null) {
            lottieAnimationView.setRepeatCount(-1);
            lottieAnimationView.setAnimation(com.transsion.baselib.utils.o.f51321a.a() ? "download_analyzing_anima_night.json" : "download_analyzing_anima.json");
            lottieAnimationView.playAnimation();
        }
        h00.z zVar2 = (h00.z) getMViewBinding();
        if (zVar2 == null || (appCompatTextView = zVar2.f66107f) == null) {
            return;
        }
        appCompatTextView.post(this.I);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorSingleResBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "onHiddenChanged, hidden = " + z11, false, 4, null);
        if (z11 || !this.H) {
            return;
        }
        this.H = false;
        M1();
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        initView();
        H1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        String string;
        String string2;
        String string3;
        String string4;
        Bundle arguments = getArguments();
        String string5 = arguments != null ? arguments.getString("extra_page_from") : null;
        String str = "";
        if (string5 == null) {
            string5 = "";
        }
        this.C = string5;
        Bundle arguments2 = getArguments();
        String string6 = arguments2 != null ? arguments2.getString("extra_last_page_from") : null;
        if (string6 == null) {
            string6 = "";
        }
        this.D = string6;
        Bundle arguments3 = getArguments();
        this.A = (Subject) (arguments3 != null ? arguments3.getSerializable("extra_subject") : null);
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (string = arguments4.getString("extra_link_url")) == null) {
            string = "";
        }
        this.f60686z = string;
        Bundle arguments5 = getArguments();
        if (arguments5 == null || (string2 = arguments5.getString("extra_ops")) == null) {
            string2 = "";
        }
        this.E = string2;
        Bundle arguments6 = getArguments();
        if (arguments6 == null || (string3 = arguments6.getString("extra_resource")) == null) {
            string3 = "";
        }
        this.F = string3;
        Bundle arguments7 = getArguments();
        r1(arguments7 != null ? arguments7.getBoolean("extra_download_execute_download") : false);
        Bundle arguments8 = getArguments();
        if (arguments8 != null && (string4 = arguments8.getString("extra_module_name")) != null) {
            str = string4;
        }
        s1(str);
    }
}
