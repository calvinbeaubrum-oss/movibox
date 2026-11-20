package com.transsion.moviedetail.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$string;
import com.transsion.moviedetail.dialog.SubjectEduInfoMoreDetailDialog;
import com.transsion.moviedetail.view.CustomTextViewGroup;
import com.transsion.moviedetail.view.HeaderExtensionFragment;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.web.api.WebConstants;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
@SourceDebugExtension
public final class SubjectEduHeaderFragment extends BaseFragment<tu.p> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Subject f53551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f53552d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f53553f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f53556i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f53557j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HeaderExtensionFragment f53558k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f53549a = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.moviedetail.fragment.SubjectEduHeaderFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final androidx.lifecycle.x0 invoke() {
            androidx.lifecycle.x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.f(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsion.moviedetail.fragment.SubjectEduHeaderFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final androidx.lifecycle.v0.c invoke() {
            androidx.lifecycle.v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.f(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f53550b = "SubjectEduHeaderFragment";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f53554g = "subjectdetail";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f53555h = 1;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f53559a;

        public a(Function1 function) {
            Intrinsics.g(function, "function");
            this.f53559a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f53559a;
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
            this.f53559a.invoke(obj);
        }
    }

    private final MovieDetailViewModel l0() {
        return (MovieDetailViewModel) this.f53549a.getValue();
    }

    public static final void n0(SubjectEduHeaderFragment this$0, View it) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.f(it, "it");
        this$0.o0(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(Subject subject) {
        Subject subject2;
        AppCompatTextView appCompatTextView;
        FrameLayout frameLayout;
        tu.p mViewBinding;
        CustomTextViewGroup customTextViewGroup;
        tu.p mViewBinding2;
        CustomTextViewGroup customTextViewGroup2;
        tu.p mViewBinding3;
        CustomTextViewGroup customTextViewGroup3;
        tu.p mViewBinding4;
        CustomTextViewGroup customTextViewGroup4;
        AppCompatImageView appCompatImageView;
        AppCompatTextView appCompatTextView2;
        HashMap<String, String> mapG;
        HashMap<String, String> mapG2;
        this.f53551c = subject;
        String ops = subject != null ? subject.getOps() : null;
        if ((ops == null || ops.length() == 0) && (subject2 = this.f53551c) != null) {
            subject2.setOps(this.f53552d);
        }
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(true);
        }
        com.transsion.baselib.report.h logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null) {
            logViewConfig2.m(this.f53552d);
        }
        com.transsion.baselib.report.h logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null && (mapG2 = logViewConfig3.g()) != null) {
            String subjectId = subject.getSubjectId();
            if (subjectId == null) {
                subjectId = "";
            }
            mapG2.put("subject_id", subjectId);
        }
        com.transsion.baselib.report.h logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null && (mapG = logViewConfig4.g()) != null) {
            mapG.put("has_resource", String.valueOf(subject.getHasResource()));
        }
        tu.p mViewBinding5 = getMViewBinding();
        AppCompatTextView appCompatTextView3 = mViewBinding5 != null ? mViewBinding5.f77576k : null;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(subject.getTitle());
        }
        String description = subject.getDescription();
        if (description == null || description.length() <= 0) {
            tu.p mViewBinding6 = getMViewBinding();
            if (mViewBinding6 != null && (appCompatTextView = mViewBinding6.f77572g) != null) {
                so.c.g(appCompatTextView);
            }
        } else {
            tu.p mViewBinding7 = getMViewBinding();
            AppCompatTextView appCompatTextView4 = mViewBinding7 != null ? mViewBinding7.f77572g : null;
            if (appCompatTextView4 != null) {
                appCompatTextView4.setText(subject.getDescription());
            }
            tu.p mViewBinding8 = getMViewBinding();
            if (mViewBinding8 != null && (appCompatTextView2 = mViewBinding8.f77572g) != null) {
                so.c.k(appCompatTextView2);
            }
        }
        int iA = com.transsion.moviedetailapi.a.a(subject.getSubjectType());
        tu.p mViewBinding9 = getMViewBinding();
        if (mViewBinding9 != null && (appCompatImageView = mViewBinding9.f77569c) != null) {
            appCompatImageView.setImageResource(iA);
        }
        String category = subject.getCategory();
        if (category != null && (mViewBinding4 = getMViewBinding()) != null && (customTextViewGroup4 = mViewBinding4.f77571f) != null) {
            customTextViewGroup4.setText(category);
        }
        String genre = subject.getGenre();
        if (genre != null && (mViewBinding3 = getMViewBinding()) != null && (customTextViewGroup3 = mViewBinding3.f77574i) != null) {
            customTextViewGroup3.setText(genre);
        }
        String strA = defpackage.a.a(this.f53551c);
        if (strA != null && (mViewBinding2 = getMViewBinding()) != null && (customTextViewGroup2 = mViewBinding2.f77573h) != null) {
            customTextViewGroup2.setText(strA);
        }
        Context context = getContext();
        if (context != null) {
            int i11 = R$string.movie_detail_students;
            Object[] objArr = new Object[1];
            Long viewers = subject.getViewers();
            objArr[0] = Long.valueOf(viewers != null ? viewers.longValue() : 0L);
            String string = context.getString(i11, objArr);
            if (string != null && (mViewBinding = getMViewBinding()) != null && (customTextViewGroup = mViewBinding.f77577l) != null) {
                customTextViewGroup.setText(string);
            }
        }
        if (this.f53557j) {
            tu.p mViewBinding10 = getMViewBinding();
            if (mViewBinding10 == null || (frameLayout = mViewBinding10.f77568b) == null) {
                return;
            }
            so.c.g(frameLayout);
            return;
        }
        if (this.f53558k == null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.f(childFragmentManager, "childFragmentManager");
            FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
            Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
            HeaderExtensionFragment headerExtensionFragment = new HeaderExtensionFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("data_key_resource_detectors", this.f53551c);
            bundle.putString("module_name", this.f53556i);
            bundle.putInt("season", this.f53555h);
            bundle.putString("ops", this.f53552d);
            bundle.putString(WebConstants.PAGE_FROM, this.f53554g);
            headerExtensionFragment.setArguments(bundle);
            fragmentTransactionBeginTransaction.replace(R$id.extension_container, headerExtensionFragment);
            this.f53558k = headerExtensionFragment;
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle bundle) {
        View view2;
        tu.p mViewBinding;
        AppCompatTextView appCompatTextView;
        Intrinsics.g(view, "view");
        super.initData(view, bundle);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("data_key_resource_detectors") : null;
        this.f53551c = serializable instanceof Subject ? (Subject) serializable : null;
        Bundle arguments2 = getArguments();
        this.f53552d = arguments2 != null ? arguments2.getString("ops") : null;
        Bundle arguments3 = getArguments();
        this.f53557j = arguments3 != null ? arguments3.getBoolean("is_Intercept_detail") : false;
        Bundle arguments4 = getArguments();
        this.f53553f = arguments4 != null ? arguments4.getString("id") : null;
        Bundle arguments5 = getArguments();
        this.f53556i = arguments5 != null ? arguments5.getString("module_name") : null;
        Bundle arguments6 = getArguments();
        this.f53555h = arguments6 != null ? arguments6.getInt("season") : 1;
        Bundle arguments7 = getArguments();
        this.f53552d = arguments7 != null ? arguments7.getString("ops") : null;
        Bundle arguments8 = getArguments();
        String string = arguments8 != null ? arguments8.getString(WebConstants.PAGE_FROM) : null;
        if (string == null) {
            string = "subjectdetail";
        }
        this.f53554g = string;
        Subject subject = this.f53551c;
        if (subject != null) {
            Intrinsics.d(subject);
            p0(subject);
        }
        if (this.f53557j && (mViewBinding = getMViewBinding()) != null && (appCompatTextView = mViewBinding.f77576k) != null) {
            appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        MovieDetailViewModel movieDetailViewModelL0 = l0();
        movieDetailViewModelL0.r().j(this, new a(new Function1<Pair<? extends String, ? extends Subject>, Unit>() { // from class: com.transsion.moviedetail.fragment.SubjectEduHeaderFragment$initData$1$1
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
                Subject second = pair.getSecond();
                uo.b.f78622a.c(this.this$0.f53550b, "get movie detail data==" + pair, true);
                if (second == null || this.this$0.f53551c != null) {
                    return;
                }
                this.this$0.p0(second);
            }
        }));
        movieDetailViewModelL0.u().j(this, new a(new Function1<Integer, Unit>() { // from class: com.transsion.moviedetail.fragment.SubjectEduHeaderFragment$initData$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer season) {
                SubjectEduHeaderFragment subjectEduHeaderFragment = this.this$0;
                Intrinsics.f(season, "season");
                subjectEduHeaderFragment.f53555h = season.intValue();
            }
        }));
        tu.p mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (view2 = mViewBinding2.f77578m) == null) {
            return;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                SubjectEduHeaderFragment.n0(this.f53655a, view3);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public tu.p getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        tu.p pVarC = tu.p.c(inflater);
        Intrinsics.f(pVarC, "inflate(inflater)");
        return pVarC;
    }

    public final void o0(View view) {
        if (this.f53557j || com.transsion.baseui.util.c.f51452a.a(view.getId(), 1000L)) {
            return;
        }
        uo.b.a.g(uo.b.f78622a, "Open the right to view more detail", false, 2, null);
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            SubjectEduInfoMoreDetailDialog subjectEduInfoMoreDetailDialog = new SubjectEduInfoMoreDetailDialog();
            subjectEduInfoMoreDetailDialog.setArguments(androidx.core.os.c.b(TuplesKt.a("data_key_resource_detectors", this.f53551c)));
            subjectEduInfoMoreDetailDialog.T0(parentFragment, R$id.fl_bottom_dialog_container);
        }
    }
}
