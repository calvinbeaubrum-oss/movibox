package com.transsion.moviedetail.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.alibaba.android.arouter.facade.Postcard;
import com.transsion.baseui.R$string;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.baseui.widget.DrawableCenterTextView;
import com.transsion.baseui.widget.ResourcesRequestView;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.viewmodel.MovieDetailViewModel;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.publish.model.PostEntity;
import com.transsion.push.notification.permission.NoticePermissionFrom;
import java.io.Serializable;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class ResourceDetectorEmptyFragment extends PageStatusFragment<tu.k> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f53512n = new a(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Subject f53513k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f53514l = FragmentViewModelLazyKt.a(this, Reflection.b(MovieDetailViewModel.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.moviedetail.fragment.ResourceDetectorEmptyFragment$special$$inlined$activityViewModels$default$1
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
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsion.moviedetail.fragment.ResourceDetectorEmptyFragment$special$$inlined$activityViewModels$default$2
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

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f53515m;

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
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f53516a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f53516a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f53516a;
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
            this.f53516a.invoke(obj);
        }
    }

    private final MovieDetailViewModel W0() {
        return (MovieDetailViewModel) this.f53514l.getValue();
    }

    public static final void Y0(ResourceDetectorEmptyFragment this$0, View view) {
        List<ResourceDetectors> resourceDetectors;
        String title;
        Intrinsics.g(this$0, "this$0");
        Subject subject = this$0.f53513k;
        if (subject == null || (resourceDetectors = subject.getResourceDetectors()) == null || !(!resourceDetectors.isEmpty())) {
            return;
        }
        ResourceDetectors resourceDetectors2 = resourceDetectors.get(0);
        ResourceDetectorDialogFragment.a aVar = ResourceDetectorDialogFragment.f53509f;
        Subject subject2 = this$0.f53513k;
        if (subject2 == null || (title = subject2.getTitle()) == null) {
            title = "";
        }
        ResourceDetectorDialogFragment resourceDetectorDialogFragmentA = aVar.a(title, resourceDetectors2);
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.f(childFragmentManager, "childFragmentManager");
        resourceDetectorDialogFragmentA.show(childFragmentManager, "ResourceDetectorEmptyFragment --> ");
    }

    public static final void Z0(ResourceDetectorEmptyFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Postcard postcardWithString = com.alibaba.android.arouter.launcher.a.d().b("/profile/user_center_labels_feedback").withString("feedback_from_page", "SUBJECT_DETAIL");
        Subject subject = this$0.f53513k;
        postcardWithString.withString("subject_id", subject != null ? subject.getSubjectId() : null).navigation();
    }

    public static final void a1(ResourceDetectorEmptyFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        lw.c.f70578a.c(this$0, NoticePermissionFrom.DETAIL_NO_RES);
        this$0.c1();
    }

    public static final void b1(ResourceDetectorEmptyFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Postcard postcardWithString = com.alibaba.android.arouter.launcher.a.d().b("/profile/user_center_labels_feedback").withString("feedback_from_page", "SUBJECT_DETAIL");
        Subject subject = this$0.f53513k;
        postcardWithString.withString("subject_id", subject != null ? subject.getSubjectId() : null).navigation();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void D0() {
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("data_key_resource_detectors") : null;
        this.f53513k = serializable instanceof Subject ? (Subject) serializable : null;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public tu.k getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        tu.k kVarC = tu.k.c(inflater);
        Intrinsics.f(kVarC, "inflate(inflater)");
        return kVarC;
    }

    public final void c1() {
        ResourcesRequestView resourcesRequestView;
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            com.tn.lib.widget.toast.core.h hVar = com.tn.lib.widget.toast.core.h.f50034a;
            hVar.f(16, 0, -com.transsion.core.utils.e.a(20.0f));
            hVar.l(getString(R$string.base_network_fail));
            return;
        }
        if (com.transsion.baseui.util.c.f51452a.a(R$id.id_request_request, 500L)) {
            return;
        }
        MovieDetailViewModel movieDetailViewModelW0 = W0();
        Subject subject = this.f53513k;
        MovieDetailViewModel.E(movieDetailViewModelW0, subject != null ? subject.getSubjectId() : null, false, 2, null);
        Integer num = this.f53515m;
        if (num != null) {
            Intrinsics.d(num);
            this.f53515m = Integer.valueOf(num.intValue() + 1);
            tu.k mViewBinding = getMViewBinding();
            if (mViewBinding == null || (resourcesRequestView = mViewBinding.f77526f) == null) {
                return;
            }
            Integer num2 = this.f53515m;
            Intrinsics.d(num2);
            ResourcesRequestView.setCount$default(resourcesRequestView, num2.intValue(), false, 2, null);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        AppCompatImageView appCompatImageView;
        ResourcesRequestView resourcesRequestView;
        DrawableCenterTextView ivCenterView;
        AppCompatImageView appCompatImageView2;
        AppCompatTextView appCompatTextView;
        tu.k mViewBinding = getMViewBinding();
        if (mViewBinding != null && (appCompatTextView = mViewBinding.f77524c) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResourceDetectorEmptyFragment.Y0(this.f53665a, view);
                }
            });
        }
        tu.k mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (appCompatImageView2 = mViewBinding2.f77523b) != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResourceDetectorEmptyFragment.Z0(this.f53667a, view);
                }
            });
        }
        tu.k mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (resourcesRequestView = mViewBinding3.f77526f) != null && (ivCenterView = resourcesRequestView.getIvCenterView()) != null) {
            ivCenterView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResourceDetectorEmptyFragment.a1(this.f53669a, view);
                }
            });
        }
        tu.k mViewBinding4 = getMViewBinding();
        if (mViewBinding4 == null || (appCompatImageView = mViewBinding4.f77523b) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ResourceDetectorEmptyFragment.b1(this.f53672a, view);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        W0().t().j(this, new b(new Function1<PostEntity, Unit>() { // from class: com.transsion.moviedetail.fragment.ResourceDetectorEmptyFragment$initViewModel$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PostEntity postEntity) {
                invoke2(postEntity);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PostEntity postEntity) {
                int count;
                ResourcesRequestView resourcesRequestView;
                if (postEntity == null || !postEntity.getSuccess()) {
                    uo.b.a.g(uo.b.f78622a, "Submission fail", false, 2, null);
                    return;
                }
                uo.b.a.g(uo.b.f78622a, "Post request succeed " + postEntity, false, 2, null);
                if (this.this$0.f53515m == null) {
                    ResourceDetectorEmptyFragment resourceDetectorEmptyFragment = this.this$0;
                    if (postEntity == null || (count = postEntity.getCount()) == null) {
                        count = 0;
                    }
                    resourceDetectorEmptyFragment.f53515m = count;
                    tu.k mViewBinding = this.this$0.getMViewBinding();
                    if (mViewBinding == null || (resourcesRequestView = mViewBinding.f77526f) == null) {
                        return;
                    }
                    Integer num = this.this$0.f53515m;
                    resourcesRequestView.setCount(num != null ? num.intValue() : 0, false);
                }
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        ResourcesRequestView resourcesRequestView;
        List<ResourceDetectors> resourceDetectors;
        Subject subject = this.f53513k;
        if (subject != null && (resourceDetectors = subject.getResourceDetectors()) != null && (!resourceDetectors.isEmpty())) {
            String string = getString(com.transsion.moviedetail.R$string.movie_detail_source, resourceDetectors.get(0).getSource());
            Intrinsics.f(string, "getString(R.string.movie…ail_source, it[0].source)");
            tu.k mViewBinding = getMViewBinding();
            AppCompatTextView appCompatTextView = mViewBinding != null ? mViewBinding.f77524c : null;
            if (appCompatTextView != null) {
                appCompatTextView.setText(string);
            }
        }
        tu.k mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (resourcesRequestView = mViewBinding2.f77526f) != null) {
            String string2 = getString(com.transsion.moviedetail.R$string.movie_detail_coming_soon);
            Intrinsics.f(string2, "getString(R.string.movie_detail_coming_soon)");
            resourcesRequestView.set(string2);
        }
        MovieDetailViewModel movieDetailViewModelW0 = W0();
        Subject subject2 = this.f53513k;
        movieDetailViewModelW0.D(subject2 != null ? subject2.getSubjectId() : null, true);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean y0() {
        return false;
    }
}
