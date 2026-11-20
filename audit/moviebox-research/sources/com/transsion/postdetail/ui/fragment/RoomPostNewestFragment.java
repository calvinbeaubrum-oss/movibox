package com.transsion.postdetail.ui.fragment;

import android.os.Bundle;
import com.transsion.moviedetailapi.PostRankType;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.postdetail.ui.adapter.PostAdapterFrom;
import com.transsion.postdetail.viewmodel.RoomPostViewModel;
import java.util.HashMap;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public class RoomPostNewestFragment extends RoomPostBaseFragment {
    public static final a F = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoomPostNewestFragment a(String str) {
            RoomPostNewestFragment roomPostNewestFragment = new RoomPostNewestFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", str);
            roomPostNewestFragment.setArguments(bundle);
            return roomPostNewestFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f55804a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f55804a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f55804a;
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
            this.f55804a.invoke(obj);
        }
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public void D1(PostSubjectItem postSubjectItem) {
        L1(postSubjectItem);
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public String E1() {
        return "user_center";
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public String M1() {
        return "room_detail";
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public PostAdapterFrom N1() {
        return PostAdapterFrom.DETAIL;
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public String R1() {
        return "room_detail_newest";
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public int S1() {
        return 1;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        androidx.lifecycle.c0<PostSubjectBean> c0VarQ;
        RoomPostViewModel roomPostViewModelJ1 = j1();
        if (roomPostViewModelJ1 == null || (c0VarQ = roomPostViewModelJ1.q()) == null) {
            return;
        }
        c0VarQ.j(this, new b(new Function1<PostSubjectBean, Unit>() { // from class: com.transsion.postdetail.ui.fragment.RoomPostNewestFragment.initViewModel.1
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
                RoomPostNewestFragment.this.T1(postSubjectBean);
            }
        }));
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public boolean t1() {
        return false;
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public boolean u1() {
        return true;
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        com.transsion.baselib.report.h logViewConfig;
        HashMap<String, String> mapG;
        super.v0();
        Bundle arguments = getArguments();
        Q1(arguments != null ? arguments.getString("id") : null);
        String strD1 = d1();
        if (strD1 == null || (logViewConfig = getLogViewConfig()) == null || (mapG = logViewConfig.g()) == null) {
            return;
        }
        mapG.put("group_id", strD1);
    }

    @Override // com.transsion.postdetail.ui.fragment.RoomPostBaseFragment
    public void v1(boolean z11) {
        RoomPostViewModel roomPostViewModelJ1;
        String strD1 = d1();
        if (strD1 == null || (roomPostViewModelJ1 = j1()) == null) {
            return;
        }
        roomPostViewModelJ1.u(z11, strD1, g1(), 8, PostRankType.POST_RANK_TYPE_NEW.getValue(), z11);
    }
}
