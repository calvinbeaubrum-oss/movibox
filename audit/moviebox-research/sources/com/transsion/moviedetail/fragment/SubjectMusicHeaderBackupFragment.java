package com.transsion.moviedetail.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.Arrays;
import java.util.HashMap;
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
public final class SubjectMusicHeaderBackupFragment extends BaseFragment<tu.p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f53598a = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.moviedetail.fragment.SubjectMusicHeaderBackupFragment$special$$inlined$activityViewModels$default$1
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
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsion.moviedetail.fragment.SubjectMusicHeaderBackupFragment$special$$inlined$activityViewModels$default$2
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
    public final String f53599b = "SubjectMusicHeaderFragment";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Subject f53600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f53601d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f53602f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f53603a;

        public a(Function1 function) {
            Intrinsics.g(function, "function");
            this.f53603a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f53603a;
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
            this.f53603a.invoke(obj);
        }
    }

    @SuppressLint({"DefaultLocale"})
    private final String j0(int i11) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
        String str = String.format("%02dh%02dm", Arrays.copyOf(new Object[]{Integer.valueOf(i11 / 3600), Integer.valueOf((i11 % 3600) / 60)}, 2));
        Intrinsics.f(str, "format(...)");
        return str;
    }

    private final MovieDetailViewModel k0() {
        return (MovieDetailViewModel) this.f53598a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(Subject subject) {
        Subject subject2;
        this.f53600c = subject;
        String ops = subject != null ? subject.getOps() : null;
        if ((ops == null || ops.length() == 0) && (subject2 = this.f53600c) != null) {
            subject2.setOps(this.f53601d);
        }
        tu.p mViewBinding = getMViewBinding();
        AppCompatTextView appCompatTextView = mViewBinding != null ? mViewBinding.f77576k : null;
        if (appCompatTextView != null) {
            appCompatTextView.setText(subject.getTitle());
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(subject.getCountryName())) {
            spannableStringBuilder.append((CharSequence) subject.getCountryName());
        }
        if (!TextUtils.isEmpty(subject.getGenre())) {
            if (spannableStringBuilder.length() > 2) {
                spannableStringBuilder.append((CharSequence) " / ");
            }
            spannableStringBuilder.append((CharSequence) subject.getGenre());
        }
        if (!TextUtils.isEmpty(subject.getReleaseDate())) {
            if (spannableStringBuilder.length() > 2) {
                spannableStringBuilder.append((CharSequence) " / ");
            }
            spannableStringBuilder.append((CharSequence) subject.getReleaseDate());
        }
        String duration = subject.getDuration();
        if (duration != null) {
            if (duration.length() > 0) {
                if (spannableStringBuilder.length() > 0) {
                    spannableStringBuilder.append((CharSequence) " / ");
                }
                spannableStringBuilder.append((CharSequence) duration);
                return;
            }
            Integer durationSeconds = subject.getDurationSeconds();
            if (durationSeconds == null || durationSeconds.intValue() <= 0) {
                return;
            }
            spannableStringBuilder.append((CharSequence) " / ");
            Integer durationSeconds2 = subject.getDurationSeconds();
            spannableStringBuilder.append((CharSequence) j0(durationSeconds2 != null ? durationSeconds2.intValue() : 0));
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.initData(view, bundle);
        Bundle arguments = getArguments();
        this.f53601d = arguments != null ? arguments.getString("ops") : null;
        Bundle arguments2 = getArguments();
        this.f53602f = arguments2 != null ? arguments2.getString("id") : null;
        k0().r().j(this, new a(new Function1<Pair<? extends String, ? extends Subject>, Unit>() { // from class: com.transsion.moviedetail.fragment.SubjectMusicHeaderBackupFragment$initData$1$1
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
                uo.b.f78622a.c(this.this$0.f53599b, "get movie detail data==" + pair, true);
                if (second != null) {
                    this.this$0.m0(second);
                    com.transsion.baselib.report.h logViewConfig = this.this$0.getLogViewConfig();
                    if (logViewConfig != null) {
                        logViewConfig.j(true);
                    }
                    com.transsion.baselib.report.h logViewConfig2 = this.this$0.getLogViewConfig();
                    if (logViewConfig2 != null) {
                        logViewConfig2.m(this.this$0.f53601d);
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
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void initView(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        tu.p mViewBinding = getMViewBinding();
        AppCompatTextView appCompatTextView = mViewBinding != null ? mViewBinding.f77572g : null;
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setVisibility(8);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public tu.p getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        tu.p pVarC = tu.p.c(inflater);
        Intrinsics.f(pVarC, "inflate(inflater)");
        return pVarC;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }
}
