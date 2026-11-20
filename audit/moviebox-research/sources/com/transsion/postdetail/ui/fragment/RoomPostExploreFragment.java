package com.transsion.postdetail.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.postdetail.ui.adapter.PostAdapterFrom;
import com.transsion.postdetail.viewmodel.RoomPostViewModel;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
public final class RoomPostExploreFragment extends RoomPostBaseFragment {
    public static final a I = new a(null);
    public final Lazy F = FragmentViewModelLazyKt.a(this, Reflection.b(rw.f.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsion.postdetail.ui.fragment.RoomPostExploreFragment$special$$inlined$activityViewModels$default$1
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
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsion.postdetail.ui.fragment.RoomPostExploreFragment$special$$inlined$activityViewModels$default$2
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
    public String G;
    public String H;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoomPostExploreFragment a(String str, String str2) {
            RoomPostExploreFragment roomPostExploreFragment = new RoomPostExploreFragment();
            roomPostExploreFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("post_id", str), TuplesKt.a("ops", str2)));
            return roomPostExploreFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f55802a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f55802a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f55802a;
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
            this.f55802a.invoke(obj);
        }
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public void D1(PostSubjectItem postSubjectItem) {
        J1(postSubjectItem);
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public String E1() {
        return "group";
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public String M1() {
        return "room_home";
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public PostAdapterFrom N1() {
        return PostAdapterFrom.EXPLORE;
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public String R1() {
        return "room_home_explore";
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public int S1() {
        return 0;
    }

    public final rw.f a2() {
        return (rw.f) this.F.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        androidx.lifecycle.c0<PostSubjectBean> c0VarO;
        RoomPostViewModel roomPostViewModelJ1 = j1();
        if (roomPostViewModelJ1 != null && (c0VarO = roomPostViewModelJ1.o()) != null) {
            c0VarO.j(this, new b(new Function1<PostSubjectBean, Unit>() { // from class: com.transsion.postdetail.ui.fragment.RoomPostExploreFragment.initViewModel.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PostSubjectBean postSubjectBean) {
                    invoke2(postSubjectBean);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PostSubjectBean postSubjectBean) {
                    String str;
                    List<PostSubjectItem> items;
                    PostSubjectItem postSubjectItem;
                    String ops;
                    if (postSubjectBean != null && postSubjectBean.isRefresh() && (str = RoomPostExploreFragment.this.H) != null && str.length() != 0 && (items = postSubjectBean.getItems()) != null && (postSubjectItem = (PostSubjectItem) CollectionsKt___CollectionsKt.g0(items)) != null) {
                        RoomPostExploreFragment roomPostExploreFragment = RoomPostExploreFragment.this;
                        if (Intrinsics.b(postSubjectItem.getPostId(), roomPostExploreFragment.G) && ((ops = postSubjectItem.getOps()) == null || ops.length() == 0)) {
                            postSubjectItem.setOps(roomPostExploreFragment.H);
                        }
                    }
                    if (postSubjectBean == null) {
                        com.transsion.postdetail.ui.adapter.d dVarB1 = RoomPostExploreFragment.this.b1();
                        List<PostSubjectItem> listD = dVarB1 != null ? dVarB1.D() : null;
                        if (listD != null && !listD.isEmpty()) {
                            return;
                        }
                    }
                    RoomPostExploreFragment.this.T1(postSubjectBean);
                }
            }));
        }
        a2().b().j(this, new b(new Function1<Pair<? extends String, ? extends String>, Unit>() { // from class: com.transsion.postdetail.ui.fragment.RoomPostExploreFragment.initViewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends String> pair) {
                invoke2((Pair<String, String>) pair);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<String, String> pair) {
                String first = pair != null ? pair.getFirst() : null;
                if (first == null || first.length() == 0) {
                    return;
                }
                RoomPostExploreFragment.this.H = pair.getSecond();
                RoomPostExploreFragment.this.G = first;
                RoomPostExploreFragment.this.v1(true);
            }
        }));
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.G = arguments != null ? arguments.getString("post_id") : null;
        Bundle arguments2 = getArguments();
        this.H = arguments2 != null ? arguments2.getString("ops") : null;
        RoomPostBaseFragment.w1(this, false, 1, null);
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public boolean t1() {
        return true;
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public boolean u1() {
        return false;
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public void v1(boolean z11) {
        RoomPostViewModel roomPostViewModelJ1;
        Context context = getContext();
        if (context == null || (roomPostViewModelJ1 = j1()) == null) {
            return;
        }
        roomPostViewModelJ1.s(context, z11, g1(), 8, this.G);
    }
}
