package com.transsion.moviedetail.staff;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.R$mipmap;
import com.transsion.moviedetail.R$string;
import com.transsion.moviedetail.staff.bean.MovieStaffList;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class j extends BaseProviderMultiAdapter<Object> {
    public static final a J = new a(null);
    public final Integer I;

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
    public static final class b extends BaseItemProvider<Object> {
        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public void a(BaseViewHolder helper, Object item) {
            Intrinsics.g(helper, "helper");
            Intrinsics.g(item, "item");
            if (item instanceof wu.a) {
                wu.a aVar = (wu.a) item;
                if (aVar.a() >= aVar.c()) {
                    helper.setText(R$id.tv_load, R$string.movie_staff_show_less);
                    helper.setImageResource(R$id.iv_arrow, R$mipmap.movie_arrow_up);
                } else {
                    helper.setText(R$id.tv_load, R$string.movie_staff_show_more);
                    helper.setImageResource(R$id.iv_arrow, R$mipmap.movie_arrow_down);
                }
            }
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int h() {
            return 2;
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int i() {
            return R$layout.movie_staff_item_more;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends BaseItemProvider<Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f53771f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Function2<Integer, Integer, Unit> f53772g;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a extends RecyclerView.r {
            public a() {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.r
            public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
                Intrinsics.g(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, i11, i12);
                RecyclerView.m layoutManager = recyclerView.getLayoutManager();
                Intrinsics.e(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                View viewFindViewByPosition = linearLayoutManager.findViewByPosition(iFindFirstVisibleItemPosition);
                if (viewFindViewByPosition != null) {
                    Rect rect = new Rect();
                    viewFindViewByPosition.getLocalVisibleRect(rect);
                    if ((rect.width() * 100) / viewFindViewByPosition.getWidth() < 70) {
                        iFindFirstVisibleItemPosition++;
                    }
                }
                View viewFindViewByPosition2 = linearLayoutManager.findViewByPosition(iFindLastVisibleItemPosition);
                if (viewFindViewByPosition2 != null) {
                    Rect rect2 = new Rect();
                    viewFindViewByPosition2.getLocalVisibleRect(rect2);
                    if ((rect2.width() * 100) / viewFindViewByPosition2.getWidth() < 70) {
                        iFindLastVisibleItemPosition--;
                    }
                }
                c.this.w().invoke(Integer.valueOf(iFindFirstVisibleItemPosition), Integer.valueOf(iFindLastVisibleItemPosition));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(String str, Function2<? super Integer, ? super Integer, Unit> callback) {
            Intrinsics.g(callback, "callback");
            this.f53771f = str;
            this.f53772g = callback;
        }

        public static final void v(c this$0, BaseQuickAdapter adapter, View v11, int i11) {
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(adapter, "adapter");
            Intrinsics.g(v11, "v");
            Object item = adapter.getItem(i11);
            Intrinsics.e(item, "null cannot be cast to non-null type com.transsion.moviedetailapi.bean.Staff");
            Staff staff = (Staff) item;
            com.alibaba.android.arouter.launcher.a.d().b("/movie/staff").withSerializable("staff", staff).navigation();
            HashMap map = new HashMap();
            map.put("module_name", "staff");
            String str = this$0.f53771f;
            if (str == null) {
                str = "";
            }
            map.put("staff_id", str);
            String staffId = staff.getStaffId();
            map.put("related_staff_id", staffId != null ? staffId : "");
            com.transsion.baselib.helper.a.f51183a.h("staff_info", map);
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public void a(BaseViewHolder helper, Object item) {
            Intrinsics.g(helper, "helper");
            Intrinsics.g(item, "item");
            RecyclerView recyclerView = (RecyclerView) helper.getView(R$id.f53421rv);
            if (item instanceof MovieStaffList) {
                if (recyclerView.getLayoutManager() == null) {
                    recyclerView.setLayoutManager(new LinearLayoutManager(g(), 0, false));
                }
                if (recyclerView.getItemDecorationCount() <= 0) {
                    recyclerView.addItemDecoration(new ro.e(8.0f, 0.0f, 12.0f, 2, null));
                }
                if (recyclerView.getAdapter() == null) {
                    List<Staff> items = ((MovieStaffList) item).getItems();
                    if (items == null) {
                        items = Collections.emptyList();
                        Intrinsics.f(items, "emptyList()");
                    }
                    com.transsion.moviedetail.adapter.b bVar = new com.transsion.moviedetail.adapter.b(items);
                    bVar.B0(new f9.d() { // from class: com.transsion.moviedetail.staff.k
                        @Override // f9.d
                        public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                            j.c.v(this.f53775a, baseQuickAdapter, view, i11);
                        }
                    });
                    recyclerView.setAdapter(bVar);
                    recyclerView.addOnScrollListener(new a());
                }
            }
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int h() {
            return 3;
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int i() {
            return R$layout.movie_staff_item_related;
        }

        public final Function2<Integer, Integer, Unit> w() {
            return this.f53772g;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends BaseItemProvider<Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Integer f53774f;

        public d(Integer num) {
            this.f53774f = num;
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public void a(BaseViewHolder helper, Object item) {
            String url;
            String thumbnail;
            Intrinsics.g(helper, "helper");
            Intrinsics.g(item, "item");
            if (item instanceof Subject) {
                ShapeableImageView shapeableImageView = (ShapeableImageView) helper.getViewOrNull(R$id.iv_cover);
                if (shapeableImageView != null) {
                    Integer num = this.f53774f;
                    if (num != null && num.intValue() == 6) {
                        ViewGroup.LayoutParams layoutParams = shapeableImageView.getLayoutParams();
                        ConstraintLayout.b bVar = null;
                        ConstraintLayout.b bVar2 = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
                        if (bVar2 != null) {
                            bVar2.I = "h,160:90";
                            bVar = bVar2;
                        }
                        shapeableImageView.setLayoutParams(bVar);
                    }
                    ImageHelper.Companion companion = ImageHelper.f51371a;
                    Context context = shapeableImageView.getContext();
                    Intrinsics.f(context, "context");
                    Subject subject = (Subject) item;
                    Cover cover = subject.getCover();
                    if (cover == null || (url = cover.getUrl()) == null) {
                        url = "";
                    }
                    Cover cover2 = subject.getCover();
                    companion.q(context, shapeableImageView, url, (8120 & 8) != 0 ? companion.d() : 0, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
                }
                AppCompatTextView appCompatTextView = (AppCompatTextView) helper.getViewOrNull(R$id.tv_title);
                if (appCompatTextView != null) {
                    appCompatTextView.setText(((Subject) item).getTitle());
                }
            }
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int h() {
            return 1;
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int i() {
            return R$layout.movie_staff_item_subject;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(String str, Integer num, Function2<? super Integer, ? super Integer, Unit> staffScrollCallback) {
        super(null, 1, null);
        Intrinsics.g(staffScrollCallback, "staffScrollCallback");
        this.I = num;
        K0(new b());
        K0(new c(str, staffScrollCallback));
        K0(new d(num));
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int S0(List<? extends Object> data, int i11) {
        Intrinsics.g(data, "data");
        if (data.get(i11) instanceof Subject) {
            return 1;
        }
        return data.get(i11) instanceof wu.a ? 2 : 3;
    }
}
