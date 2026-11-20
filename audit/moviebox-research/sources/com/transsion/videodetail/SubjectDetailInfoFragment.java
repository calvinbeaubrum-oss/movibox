package com.transsion.videodetail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetail.activity.MoviePosterActivity;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Deprecated;
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
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
@Metadata
@SourceDebugExtension
public final class SubjectDetailInfoFragment extends BaseFragment<rz.g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f59831a = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.videodetail.SubjectDetailInfoFragment$special$$inlined$activityViewModels$default$1
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
    }, new Function0<v0.c>() { // from class: com.transsion.videodetail.SubjectDetailInfoFragment$special$$inlined$activityViewModels$default$2
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

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Subject f59832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f59833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f59834d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f59835a;

        public a(Function1 function) {
            Intrinsics.g(function, "function");
            this.f59835a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f59835a;
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
            this.f59835a.invoke(obj);
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
        return (MovieDetailViewModel) this.f59831a.getValue();
    }

    public static final void m0(SubjectDetailInfoFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        com.transsion.moviedetail.activity.g gVar = new com.transsion.moviedetail.activity.g(this$0.f59832b);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = com.transsion.moviedetail.activity.g.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, gVar, 0L);
        com.transsion.baselib.helper.a.f51183a.g("subjectdetail", "movie_poster", (28 & 4) != 0 ? "" : "", (28 & 8) != 0 ? "" : this$0.f59834d, (28 & 16) != 0 ? "" : null);
        this$0.startActivity(new Intent(this$0.requireContext(), (Class<?>) MoviePosterActivity.class));
    }

    private final void n0(String str) {
        AppCompatTextView appCompatTextView;
        AppCompatImageView appCompatImageView;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        AppCompatTextView tvSubtitleMore;
        AppCompatTextView appCompatTextView4;
        AppCompatTextView tvSubtitleMore2;
        AppCompatTextView appCompatTextView5;
        AppCompatImageView appCompatImageView2;
        CharSequence charSequenceJ = k0().j(str);
        if (charSequenceJ == null || charSequenceJ.length() == 0) {
            rz.g mViewBinding = getMViewBinding();
            if (mViewBinding != null && (appCompatTextView2 = mViewBinding.f75841o) != null) {
                so.c.g(appCompatTextView2);
            }
            rz.g mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (appCompatImageView = mViewBinding2.f75834h) != null) {
                so.c.g(appCompatImageView);
            }
            rz.g mViewBinding3 = getMViewBinding();
            if (mViewBinding3 == null || (appCompatTextView = mViewBinding3.f75840n) == null) {
                return;
            }
            so.c.g(appCompatTextView);
            return;
        }
        rz.g mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (appCompatImageView2 = mViewBinding4.f75834h) != null) {
            so.c.k(appCompatImageView2);
        }
        rz.g mViewBinding5 = getMViewBinding();
        if (mViewBinding5 != null && (appCompatTextView5 = mViewBinding5.f75841o) != null) {
            so.c.k(appCompatTextView5);
        }
        rz.g mViewBinding6 = getMViewBinding();
        if (mViewBinding6 == null || (appCompatTextView3 = mViewBinding6.f75841o) == null) {
            return;
        }
        appCompatTextView3.setText(charSequenceJ);
        TextPaint paint = appCompatTextView3.getPaint();
        Intrinsics.f(paint, "paint");
        int iF = com.transsion.core.utils.e.f() - com.blankj.utilcode.util.i.e(130.0f);
        StaticLayout staticLayoutBuild = Build.VERSION.SDK_INT > 23 ? StaticLayout.Builder.obtain(charSequenceJ, 0, charSequenceJ.length(), paint, iF).build() : new StaticLayout(charSequenceJ, paint, iF, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        Intrinsics.f(staticLayoutBuild, "if (Build.VERSION.SDK_IN…          )\n            }");
        if (staticLayoutBuild.getLineCount() <= 1) {
            rz.g mViewBinding7 = getMViewBinding();
            if (mViewBinding7 == null || (tvSubtitleMore = mViewBinding7.f75840n) == null) {
                return;
            }
            Intrinsics.f(tvSubtitleMore, "tvSubtitleMore");
            so.c.g(tvSubtitleMore);
            return;
        }
        rz.g mViewBinding8 = getMViewBinding();
        if (mViewBinding8 != null && (tvSubtitleMore2 = mViewBinding8.f75840n) != null) {
            Intrinsics.f(tvSubtitleMore2, "tvSubtitleMore");
            so.c.k(tvSubtitleMore2);
        }
        rz.g mViewBinding9 = getMViewBinding();
        if (mViewBinding9 == null || (appCompatTextView4 = mViewBinding9.f75840n) == null) {
            return;
        }
        appCompatTextView4.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubjectDetailInfoFragment.o0(this.f59997a, view);
            }
        });
    }

    public static final void o0(SubjectDetailInfoFragment this$0, View view) {
        AppCompatTextView appCompatTextView;
        Intrinsics.g(this$0, "this$0");
        rz.g mViewBinding = this$0.getMViewBinding();
        if (mViewBinding != null && (appCompatTextView = mViewBinding.f75840n) != null) {
            so.c.g(appCompatTextView);
        }
        rz.g mViewBinding2 = this$0.getMViewBinding();
        AppCompatTextView appCompatTextView2 = mViewBinding2 != null ? mViewBinding2.f75841o : null;
        if (appCompatTextView2 == null) {
            return;
        }
        appCompatTextView2.setMaxLines(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(Subject subject) {
        Subject subject2;
        AppCompatTextView appCompatTextView;
        ShapeableImageView shapeableImageView;
        String url;
        String thumbnail;
        AppCompatTextView appCompatTextView2;
        AppCompatImageView appCompatImageView;
        AppCompatTextView appCompatTextView3;
        AppCompatImageView appCompatImageView2;
        ShapeableImageView shapeableImageView2;
        AppCompatImageView appCompatImageView3;
        this.f59832b = subject;
        String ops = subject != null ? subject.getOps() : null;
        if ((ops == null || ops.length() == 0) && (subject2 = this.f59832b) != null) {
            subject2.setOps(this.f59833c);
        }
        int iA = com.transsion.moviedetailapi.a.a(subject.getSubjectType());
        rz.g mViewBinding = getMViewBinding();
        if (mViewBinding != null && (appCompatImageView3 = mViewBinding.f75830c) != null) {
            appCompatImageView3.setImageResource(iA);
        }
        rz.g mViewBinding2 = getMViewBinding();
        AppCompatTextView appCompatTextView4 = mViewBinding2 != null ? mViewBinding2.f75838l : null;
        if (appCompatTextView4 != null) {
            appCompatTextView4.setText(subject.getTitle());
        }
        Subject subject3 = this.f59832b;
        n0(subject3 != null ? subject3.getSubtitles() : null);
        if (subject.isMusicType()) {
            rz.g mViewBinding3 = getMViewBinding();
            if (mViewBinding3 != null && (shapeableImageView2 = mViewBinding3.f75831d) != null) {
                so.c.g(shapeableImageView2);
            }
            rz.g mViewBinding4 = getMViewBinding();
            if (mViewBinding4 != null && (appCompatImageView2 = mViewBinding4.f75833g) != null) {
                so.c.g(appCompatImageView2);
            }
            rz.g mViewBinding5 = getMViewBinding();
            if (mViewBinding5 != null && (appCompatTextView3 = mViewBinding5.f75839m) != null) {
                so.c.g(appCompatTextView3);
            }
            rz.g mViewBinding6 = getMViewBinding();
            if (mViewBinding6 != null && (appCompatImageView = mViewBinding6.f75834h) != null) {
                so.c.g(appCompatImageView);
            }
            rz.g mViewBinding7 = getMViewBinding();
            if (mViewBinding7 != null && (appCompatTextView2 = mViewBinding7.f75841o) != null) {
                so.c.g(appCompatTextView2);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (TextUtils.isEmpty(subject.getCountryName())) {
                spannableStringBuilder.append((CharSequence) subject.getLanguage());
            } else {
                spannableStringBuilder.append((CharSequence) subject.getCountryName());
            }
            if (!TextUtils.isEmpty(subject.getGenre())) {
                if (spannableStringBuilder.length() > 2) {
                    spannableStringBuilder.append((CharSequence) " / ");
                }
                spannableStringBuilder.append((CharSequence) subject.getGenre());
            }
            String releaseDate = subject.getReleaseDate();
            if (releaseDate != null && releaseDate.length() > 0) {
                spannableStringBuilder.append((CharSequence) " / ");
                spannableStringBuilder.append((CharSequence) releaseDate);
            }
            String duration = subject.getDuration();
            if (duration != null) {
                if (duration.length() > 0) {
                    if (spannableStringBuilder.length() > 0) {
                        spannableStringBuilder.append((CharSequence) " / ");
                    }
                    spannableStringBuilder.append((CharSequence) duration);
                } else {
                    Integer durationSeconds = subject.getDurationSeconds();
                    if (durationSeconds != null && durationSeconds.intValue() > 0) {
                        spannableStringBuilder.append((CharSequence) " / ");
                        Integer durationSeconds2 = subject.getDurationSeconds();
                        spannableStringBuilder.append((CharSequence) j0(durationSeconds2 != null ? durationSeconds2.intValue() : 0));
                    }
                }
            }
            rz.g mViewBinding8 = getMViewBinding();
            appCompatTextView = mViewBinding8 != null ? mViewBinding8.f75837k : null;
            if (appCompatTextView == null) {
                return;
            }
            appCompatTextView.setText(spannableStringBuilder);
            return;
        }
        rz.g mViewBinding9 = getMViewBinding();
        if (mViewBinding9 != null && (shapeableImageView = mViewBinding9.f75831d) != null) {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            Cover cover = subject.getCover();
            if (cover == null || (url = cover.getUrl()) == null) {
                url = "";
            }
            Cover cover2 = subject.getCover();
            if (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) {
                thumbnail = "";
            }
            companion.q(contextRequireContext, shapeableImageView, url, (8120 & 8) != 0 ? companion.d() : 0, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        String restrictLevel = subject.getRestrictLevel();
        if (restrictLevel != null && restrictLevel.length() > 0) {
            spannableStringBuilder2.append((CharSequence) " / ");
            spannableStringBuilder2.append((CharSequence) restrictLevel);
        }
        String releaseDate2 = subject.getReleaseDate();
        if (releaseDate2 != null && releaseDate2.length() > 0) {
            spannableStringBuilder2.append((CharSequence) " / ");
            spannableStringBuilder2.append((CharSequence) releaseDate2);
        }
        String duration2 = subject.getDuration();
        if (duration2 != null) {
            if (duration2.length() > 0) {
                if (spannableStringBuilder2.length() > 0) {
                    spannableStringBuilder2.append((CharSequence) " / ");
                }
                spannableStringBuilder2.append((CharSequence) duration2);
            } else {
                Integer durationSeconds3 = subject.getDurationSeconds();
                if (durationSeconds3 != null && durationSeconds3.intValue() > 0) {
                    spannableStringBuilder2.append((CharSequence) " / ");
                    Integer durationSeconds4 = subject.getDurationSeconds();
                    spannableStringBuilder2.append((CharSequence) j0(durationSeconds4 != null ? durationSeconds4.intValue() : 0));
                }
            }
        }
        rz.g mViewBinding10 = getMViewBinding();
        AppCompatTextView appCompatTextView5 = mViewBinding10 != null ? mViewBinding10.f75842p : null;
        if (appCompatTextView5 != null) {
            appCompatTextView5.setText(spannableStringBuilder2);
        }
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(subject.getCountryName())) {
            spannableStringBuilder3.append((CharSequence) subject.getCountryName());
        }
        if (!TextUtils.isEmpty(subject.getGenre())) {
            if (spannableStringBuilder3.length() > 2) {
                spannableStringBuilder3.append((CharSequence) " / ");
            }
            spannableStringBuilder3.append((CharSequence) subject.getGenre());
        }
        rz.g mViewBinding11 = getMViewBinding();
        AppCompatTextView appCompatTextView6 = mViewBinding11 != null ? mViewBinding11.f75837k : null;
        if (appCompatTextView6 != null) {
            appCompatTextView6.setText(spannableStringBuilder3);
        }
        rz.g mViewBinding12 = getMViewBinding();
        appCompatTextView = mViewBinding12 != null ? mViewBinding12.f75839m : null;
        if (appCompatTextView == null) {
            return;
        }
        appCompatTextView.setText(subject.getImdbRate());
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.initData(view, bundle);
        Bundle arguments = getArguments();
        this.f59833c = arguments != null ? arguments.getString("ops") : null;
        Bundle arguments2 = getArguments();
        this.f59834d = arguments2 != null ? arguments2.getString("id") : null;
        k0().r().j(this, new a(new Function1<Pair<? extends String, ? extends Subject>, Unit>() { // from class: com.transsion.videodetail.SubjectDetailInfoFragment$initData$1$1
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
                uo.b.f78622a.c("videoDetail", "get movie detail data==" + pair, true);
                if (second != null) {
                    this.this$0.p0(second);
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
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        ShapeableImageView shapeableImageView;
        Intrinsics.g(view, "view");
        rz.g mViewBinding = getMViewBinding();
        if (mViewBinding == null || (shapeableImageView = mViewBinding.f75831d) == null) {
            return;
        }
        shapeableImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videodetail.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SubjectDetailInfoFragment.m0(this.f59996a, view2);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public rz.g getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        rz.g gVarC = rz.g.c(inflater);
        Intrinsics.f(gVarC, "inflate(inflater)");
        return gVarC;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }
}
