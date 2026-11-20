package com.transsion.moviedetail.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$string;
import com.transsion.moviedetail.dialog.SubjectInfoMoreDetailDialog;
import com.transsion.moviedetail.view.CustomTextViewGroup;
import com.transsion.moviedetail.view.HeaderExtensionFragment;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.web.api.WebConstants;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Deprecated;
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
@Deprecated
@Metadata
@SourceDebugExtension
public final class SubjectMovieHeaderFragment extends BaseFragment<tu.r> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Subject f53590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f53591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f53592d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f53595h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HeaderExtensionFragment f53596i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f53589a = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.moviedetail.fragment.SubjectMovieHeaderFragment$special$$inlined$activityViewModels$default$1
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
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsion.moviedetail.fragment.SubjectMovieHeaderFragment$special$$inlined$activityViewModels$default$2
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

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f53593f = "subjectdetail";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f53594g = 1;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f53597a;

        public a(Function1 function) {
            Intrinsics.g(function, "function");
            this.f53597a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f53597a;
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
            this.f53597a.invoke(obj);
        }
    }

    private final String k0(String str) {
        if (str.length() < 4) {
            return str;
        }
        String strSubstring = str.substring(0, 4);
        Intrinsics.f(strSubstring, "substring(...)");
        return strSubstring;
    }

    private final MovieDetailViewModel l0() {
        return (MovieDetailViewModel) this.f53589a.getValue();
    }

    public static final void n0(SubjectMovieHeaderFragment this$0, View it) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.f(it, "it");
        this$0.p0(it);
    }

    public static final void o0(SubjectMovieHeaderFragment this$0, View it) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.f(it, "it");
        this$0.p0(it);
    }

    private final void p0(View view) {
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 1000L)) {
            return;
        }
        uo.b.a.g(uo.b.f78622a, "Open the right to view more detail", false, 2, null);
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            SubjectInfoMoreDetailDialog subjectInfoMoreDetailDialog = new SubjectInfoMoreDetailDialog();
            subjectInfoMoreDetailDialog.setArguments(androidx.core.os.c.b(TuplesKt.a("data_key_resource_detectors", this.f53590b), TuplesKt.a("page_name", this.f53593f)));
            subjectInfoMoreDetailDialog.T0(parentFragment, R$id.fl_bottom_dialog_container);
        }
    }

    private final void q0(Integer num) {
    }

    private final void r0(Integer num) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0(Subject subject) {
        Subject subject2;
        CustomTextViewGroup customTextViewGroup;
        CustomTextViewGroup customTextViewGroup2;
        tu.r mViewBinding;
        CustomTextViewGroup customTextViewGroup3;
        tu.r mViewBinding2;
        CustomTextViewGroup customTextViewGroup4;
        tu.r mViewBinding3;
        CustomTextViewGroup customTextViewGroup5;
        tu.r mViewBinding4;
        CustomTextViewGroup customTextViewGroup6;
        CustomTextViewGroup customTextViewGroup7;
        tu.r mViewBinding5;
        CustomTextViewGroup customTextViewGroup8;
        AppCompatTextView appCompatTextView;
        AppCompatImageView appCompatImageView;
        CustomTextViewGroup customTextViewGroup9;
        CustomTextViewGroup customTextViewGroup10;
        AppCompatImageView appCompatImageView2;
        this.f53590b = subject;
        String ops = subject != null ? subject.getOps() : null;
        if ((ops == null || ops.length() == 0) && (subject2 = this.f53590b) != null) {
            subject2.setOps(this.f53591c);
        }
        int iA = com.transsion.moviedetailapi.a.a(subject.getSubjectType());
        tu.r mViewBinding6 = getMViewBinding();
        if (mViewBinding6 != null && (appCompatImageView2 = mViewBinding6.f77589c) != null) {
            appCompatImageView2.setImageResource(iA);
        }
        tu.r mViewBinding7 = getMViewBinding();
        AppCompatTextView appCompatTextView2 = mViewBinding7 != null ? mViewBinding7.f77593h : null;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(subject.getTitle());
        }
        if (subject.isTvType()) {
            tu.r mViewBinding8 = getMViewBinding();
            if (mViewBinding8 != null && (customTextViewGroup10 = mViewBinding8.f77598m) != null) {
                so.c.k(customTextViewGroup10);
            }
            Integer seNum = subject.getSeNum();
            if (seNum != null) {
                int iIntValue = seNum.intValue();
                Context context = getContext();
                String string = context != null ? context.getString(R$string.movie_detail_seasons, Integer.valueOf(iIntValue)) : null;
                tu.r mViewBinding9 = getMViewBinding();
                if (mViewBinding9 != null && (customTextViewGroup9 = mViewBinding9.f77598m) != null) {
                    if (string == null) {
                        string = "";
                    }
                    customTextViewGroup9.setText(string);
                }
            }
        } else {
            tu.r mViewBinding10 = getMViewBinding();
            if (mViewBinding10 != null && (customTextViewGroup = mViewBinding10.f77598m) != null) {
                so.c.g(customTextViewGroup);
            }
        }
        if (subject.isMusicType()) {
            tu.r mViewBinding11 = getMViewBinding();
            if (mViewBinding11 != null && (appCompatImageView = mViewBinding11.f77590d) != null) {
                so.c.g(appCompatImageView);
            }
            tu.r mViewBinding12 = getMViewBinding();
            if (mViewBinding12 != null && (appCompatTextView = mViewBinding12.f77597l) != null) {
                so.c.g(appCompatTextView);
            }
            String countryName = subject.getCountryName();
            if (countryName != null && (mViewBinding5 = getMViewBinding()) != null && (customTextViewGroup8 = mViewBinding5.f77592g) != null) {
                customTextViewGroup8.setText(countryName);
            }
            String genre = subject.getGenre();
            if (genre != null) {
                String string2 = StringsKt__StringsKt.Z0((String) StringsKt__StringsKt.E0(genre, new String[]{","}, false, 0, 6, null).get(0)).toString();
                tu.r mViewBinding13 = getMViewBinding();
                if (mViewBinding13 != null && (customTextViewGroup7 = mViewBinding13.f77600o) != null) {
                    customTextViewGroup7.setText(string2);
                }
            }
            String releaseDate = subject.getReleaseDate();
            if (releaseDate != null && (mViewBinding4 = getMViewBinding()) != null && (customTextViewGroup6 = mViewBinding4.f77599n) != null) {
                customTextViewGroup6.setText(k0(releaseDate));
            }
        } else {
            String restrictLevel = subject.getRestrictLevel();
            if (restrictLevel != null && (mViewBinding3 = getMViewBinding()) != null && (customTextViewGroup5 = mViewBinding3.f77595j) != null) {
                customTextViewGroup5.setText(restrictLevel);
            }
            String releaseDate2 = subject.getReleaseDate();
            if (releaseDate2 != null && (mViewBinding2 = getMViewBinding()) != null && (customTextViewGroup4 = mViewBinding2.f77599n) != null) {
                customTextViewGroup4.setText(k0(releaseDate2));
            }
            String countryName2 = subject.getCountryName();
            if (countryName2 != null && (mViewBinding = getMViewBinding()) != null && (customTextViewGroup3 = mViewBinding.f77592g) != null) {
                customTextViewGroup3.setText(countryName2);
            }
            String genre2 = subject.getGenre();
            if (genre2 != null) {
                String string3 = StringsKt__StringsKt.Z0((String) StringsKt__StringsKt.E0(genre2, new String[]{","}, false, 0, 6, null).get(0)).toString();
                tu.r mViewBinding14 = getMViewBinding();
                if (mViewBinding14 != null && (customTextViewGroup2 = mViewBinding14.f77600o) != null) {
                    customTextViewGroup2.setText(string3);
                }
            }
            tu.r mViewBinding15 = getMViewBinding();
            AppCompatTextView appCompatTextView3 = mViewBinding15 != null ? mViewBinding15.f77597l : null;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setText(subject.getImdbRate());
            }
        }
        Subject subject3 = this.f53590b;
        r0(subject3 != null ? subject3.getSeenStatus() : null);
        Subject subject4 = this.f53590b;
        q0(subject4 != null ? subject4.getSeenStatus() : null);
        if (this.f53596i == null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.f(childFragmentManager, "childFragmentManager");
            FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
            Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
            HeaderExtensionFragment headerExtensionFragment = new HeaderExtensionFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("data_key_resource_detectors", this.f53590b);
            bundle.putString("module_name", this.f53595h);
            bundle.putInt("season", this.f53594g);
            bundle.putString("ops", this.f53591c);
            bundle.putString(WebConstants.PAGE_FROM, this.f53593f);
            headerExtensionFragment.setArguments(bundle);
            fragmentTransactionBeginTransaction.replace(R$id.extension_container, headerExtensionFragment);
            this.f53596i = headerExtensionFragment;
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.initData(view, bundle);
        Bundle arguments = getArguments();
        this.f53591c = arguments != null ? arguments.getString("ops") : null;
        Bundle arguments2 = getArguments();
        this.f53592d = arguments2 != null ? arguments2.getString("id") : null;
        MovieDetailViewModel movieDetailViewModelL0 = l0();
        movieDetailViewModelL0.r().j(this, new a(new Function1<Pair<? extends String, ? extends Subject>, Unit>() { // from class: com.transsion.moviedetail.fragment.SubjectMovieHeaderFragment$initData$1$1
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
                uo.b.f78622a.c("movie_detail_fragment -->", "get movie detail data==" + pair, true);
                if (second != null) {
                    this.this$0.s0(second);
                    com.transsion.baselib.report.h logViewConfig = this.this$0.getLogViewConfig();
                    if (logViewConfig != null) {
                        logViewConfig.j(true);
                    }
                    com.transsion.baselib.report.h logViewConfig2 = this.this$0.getLogViewConfig();
                    if (logViewConfig2 != null && (mapG2 = logViewConfig2.g()) != null) {
                        String subjectId = second.getSubjectId();
                        if (subjectId == null) {
                            subjectId = "";
                        }
                        mapG2.put("subject_id", subjectId);
                    }
                    com.transsion.baselib.report.h logViewConfig3 = this.this$0.getLogViewConfig();
                    if (logViewConfig3 == null || (mapG = logViewConfig3.g()) == null) {
                        return;
                    }
                    mapG.put("has_resource", String.valueOf(second.getHasResource()));
                }
            }
        }));
        movieDetailViewModelL0.u().j(this, new a(new Function1<Integer, Unit>() { // from class: com.transsion.moviedetail.fragment.SubjectMovieHeaderFragment$initData$1$2
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
                SubjectMovieHeaderFragment subjectMovieHeaderFragment = this.this$0;
                Intrinsics.f(season, "season");
                subjectMovieHeaderFragment.f53594g = season.intValue();
            }
        }));
        l0().u().j(this, new a(new Function1<Integer, Unit>() { // from class: com.transsion.moviedetail.fragment.SubjectMovieHeaderFragment.initData.2
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
                SubjectMovieHeaderFragment subjectMovieHeaderFragment = SubjectMovieHeaderFragment.this;
                Intrinsics.f(it, "it");
                subjectMovieHeaderFragment.f53594g = it.intValue();
                SubjectMovieHeaderFragment.this.hideLoading();
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        tu.r mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            mViewBinding.f77593h.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.u0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SubjectMovieHeaderFragment.n0(this.f53680a, view2);
                }
            });
            mViewBinding.f77596k.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.v0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SubjectMovieHeaderFragment.o0(this.f53685a, view2);
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public tu.r getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        tu.r rVarC = tu.r.c(inflater);
        Intrinsics.f(rVarC, "inflate(inflater)");
        return rVarC;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("data_key_resource_detectors") : null;
        this.f53590b = serializable instanceof Subject ? (Subject) serializable : null;
        Bundle arguments2 = getArguments();
        this.f53595h = arguments2 != null ? arguments2.getString("module_name") : null;
        Bundle arguments3 = getArguments();
        this.f53594g = arguments3 != null ? arguments3.getInt("season") : 1;
        Bundle arguments4 = getArguments();
        this.f53591c = arguments4 != null ? arguments4.getString("ops") : null;
        Bundle arguments5 = getArguments();
        String string = arguments5 != null ? arguments5.getString(WebConstants.PAGE_FROM) : null;
        if (string == null) {
            string = "subjectdetail";
        }
        this.f53593f = string;
    }
}
