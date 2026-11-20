package com.transsion.moviedetail.fragment;

import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.moviedetail.activity.MovieDetailActivity;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

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
public final class StarringFragment$lazyLoadData$1$1$1 extends Lambda implements Function1<Pair<? extends String, ? extends Subject>, Unit> {
    final /* synthetic */ Fragment $it;
    final /* synthetic */ StarringFragment this$0;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StarringFragment f53547a;

        public a(StarringFragment starringFragment) {
            this.f53547a = starringFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            RecyclerView recyclerView;
            ViewParent parent;
            RecyclerView recyclerView2;
            ViewTreeObserver viewTreeObserver;
            tu.m mViewBinding = this.f53547a.getMViewBinding();
            if (mViewBinding != null && (recyclerView2 = mViewBinding.f77541b) != null && (viewTreeObserver = recyclerView2.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            tu.m mViewBinding2 = this.f53547a.getMViewBinding();
            if (mViewBinding2 == null || (recyclerView = mViewBinding2.f77541b) == null || (parent = recyclerView.getParent()) == null) {
                return;
            }
            parent.requestLayout();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StarringFragment$lazyLoadData$1$1$1(Fragment fragment, StarringFragment starringFragment) {
        super(1);
        this.$it = fragment;
        this.this$0 = starringFragment;
    }

    public static final void b(BaseQuickAdapter adapter, View v11, int i11) {
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(v11, "v");
        Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/movie/staff");
        Object item = adapter.getItem(i11);
        Intrinsics.e(item, "null cannot be cast to non-null type com.transsion.moviedetailapi.bean.Staff");
        postcardB.withSerializable("staff", (Staff) item).navigation();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends Subject> pair) {
        invoke2((Pair<String, ? extends Subject>) pair);
        return Unit.f68710a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Pair<String, ? extends Subject> pair) {
        RecyclerView recyclerView;
        ViewTreeObserver viewTreeObserver;
        RecyclerView recyclerView2;
        Subject second;
        MovieDetailActivity.f53423s.a("movie_detail_fragment --> get movie detail data --> it = " + this.$it);
        List<Staff> staffList = (pair == null || (second = pair.getSecond()) == null) ? null : second.getStaffList();
        List<Staff> list = staffList;
        if (list == null || list.isEmpty()) {
            return;
        }
        tu.m mViewBinding = this.this$0.getMViewBinding();
        AppCompatTextView appCompatTextView = mViewBinding != null ? mViewBinding.f77542c : null;
        if (appCompatTextView != null) {
            appCompatTextView.setText("(" + staffList.size() + ")");
        }
        tu.m mViewBinding2 = this.this$0.getMViewBinding();
        RecyclerView recyclerView3 = mViewBinding2 != null ? mViewBinding2.f77541b : null;
        if (recyclerView3 != null) {
            recyclerView3.setLayoutManager(new NpaGridLayoutManager(this.this$0.getContext(), 4));
        }
        tu.m mViewBinding3 = this.this$0.getMViewBinding();
        if (mViewBinding3 != null && (recyclerView2 = mViewBinding3.f77541b) != null) {
            recyclerView2.addItemDecoration(new ro.b(com.blankj.utilcode.util.f0.a(4.0f), com.blankj.utilcode.util.f0.a(4.0f), com.blankj.utilcode.util.f0.a(12.0f), com.blankj.utilcode.util.f0.a(12.0f)));
        }
        com.transsion.moviedetail.adapter.a aVar = new com.transsion.moviedetail.adapter.a(staffList);
        aVar.B0(new f9.d() { // from class: com.transsion.moviedetail.fragment.h0
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                StarringFragment$lazyLoadData$1$1$1.b(baseQuickAdapter, view, i11);
            }
        });
        tu.m mViewBinding4 = this.this$0.getMViewBinding();
        RecyclerView recyclerView4 = mViewBinding4 != null ? mViewBinding4.f77541b : null;
        if (recyclerView4 != null) {
            recyclerView4.setAdapter(aVar);
        }
        tu.m mViewBinding5 = this.this$0.getMViewBinding();
        if (mViewBinding5 == null || (recyclerView = mViewBinding5.f77541b) == null || (viewTreeObserver = recyclerView.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new a(this.this$0));
    }
}
