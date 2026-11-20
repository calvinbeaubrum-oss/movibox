package com.transsion.postdetail.shorttv.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.m;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.HorizontalRecyclerview2;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.TnTextView;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.ShortTVRespData;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.R$string;
import com.transsion.postdetail.shorttv.ShortTvListActivity;
import com.transsion.postdetail.shorttv.adapter.ShortTVHeaderViewAdapter;
import com.transsion.postdetail.shorttv.n;
import com.transsion.postdetail.shorttv.viewmodel.ShortTVContentViewModel;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.loginapi.ILoginApi;
import java.util.List;
import java.util.Locale;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import tv.f0;

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
public final class ShortTVCollectionView extends LinearLayout {
    public static final a Companion = new a(null);
    public static final String TYPE_COLLECTION = "collection";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f55460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f55461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f55462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f55463d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f55464f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f0 f55465g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f55466h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ShortTVHeaderViewAdapter f55467i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public zr.b f55468j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f55469k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f55470l;

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
    public static final class b implements zr.a {
        public b() {
        }

        @Override // zr.a
        public void a(int i11, long j11, View view) {
            List<Subject> listD;
            List<Subject> listD2;
            ShortTVHeaderViewAdapter shortTVHeaderViewAdapter = ShortTVCollectionView.this.f55467i;
            if (((shortTVHeaderViewAdapter == null || (listD2 = shortTVHeaderViewAdapter.D()) == null) ? 0 : listD2.size()) <= i11) {
                return;
            }
            ShortTVHeaderViewAdapter shortTVHeaderViewAdapter2 = ShortTVCollectionView.this.f55467i;
            Subject subject = (shortTVHeaderViewAdapter2 == null || (listD = shortTVHeaderViewAdapter2.D()) == null) ? null : listD.get(i11);
            if (subject != null) {
                ShortTVCollectionView.this.f55462c.a("minitv_explore", subject, i11, j11, ShortTVCollectionView.this.getItemOptType());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends RecyclerView.l {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
            Intrinsics.g(outRect, "outRect");
            Intrinsics.g(view, "view");
            Intrinsics.g(parent, "parent");
            Intrinsics.g(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (adapter != null) {
                if (childAdapterPosition == 0) {
                    if (ShortTVCollectionView.this.f55463d) {
                        outRect.right = ShortTVCollectionView.this.f55464f * 2;
                        return;
                    } else {
                        outRect.left = ShortTVCollectionView.this.f55464f * 2;
                        return;
                    }
                }
                if (childAdapterPosition == adapter.getItemCount() - 1) {
                    outRect.right = ShortTVCollectionView.this.f55464f;
                    outRect.left = ShortTVCollectionView.this.f55464f;
                } else if (ShortTVCollectionView.this.f55463d) {
                    outRect.right = ShortTVCollectionView.this.f55464f;
                } else {
                    outRect.left = ShortTVCollectionView.this.f55464f;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f55473a;

        public d(Function1 function) {
            Intrinsics.g(function, "function");
            this.f55473a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f55473a;
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
            this.f55473a.invoke(obj);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTVCollectionView(Fragment fragment, String type, n recReport, Context context) {
        this(fragment, type, recReport, context, null);
        Intrinsics.g(fragment, "fragment");
        Intrinsics.g(type, "type");
        Intrinsics.g(recReport, "recReport");
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTVCollectionView(Fragment fragment, String type, n recReport, Context context, AttributeSet attributeSet) {
        this(fragment, type, recReport, context, attributeSet, 0);
        Intrinsics.g(fragment, "fragment");
        Intrinsics.g(type, "type");
        Intrinsics.g(recReport, "recReport");
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTVCollectionView(final Fragment fragment, String type, n recReport, Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(fragment, "fragment");
        Intrinsics.g(type, "type");
        Intrinsics.g(recReport, "recReport");
        Intrinsics.g(context, "context");
        this.f55460a = fragment;
        this.f55461b = type;
        this.f55462c = recReport;
        this.f55463d = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        this.f55464f = com.blankj.utilcode.util.f0.a(8.0f);
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.postdetail.shorttv.widget.ShortTVCollectionView$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return fragment;
            }
        };
        this.f55466h = FragmentViewModelLazyKt.a(fragment, Reflection.b(ShortTVContentViewModel.class), new Function0<x0>() { // from class: com.transsion.postdetail.shorttv.widget.ShortTVCollectionView$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.f(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.shorttv.widget.ShortTVCollectionView$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object objInvoke = function0.invoke();
                m mVar = objInvoke instanceof m ? (m) objInvoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.f(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.f55469k = "0";
        this.f55470l = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.postdetail.shorttv.widget.ShortTVCollectionView$loginApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ILoginApi invoke() {
                return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
            }
        });
        View.inflate(context, R$layout.layout_short_tv_collection, this);
        f0 f0VarA = f0.a(this);
        Intrinsics.f(f0VarA, "bind(this)");
        this.f55465g = f0VarA;
        setOrientation(1);
        c();
        f();
    }

    public static final void d(ShortTVCollectionView this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "<anonymous parameter 1>");
        Object item = adapter.getItem(i11);
        if (item instanceof Subject) {
            Subject subject = (Subject) item;
            this$0.f55462c.b("minitv_explore", subject, i11, this$0.getItemOptType());
            this$0.g(subject);
        }
    }

    public static final void e(View view) {
        uo.b.a.g(uo.b.f78622a, "Click view all", false, 2, null);
        com.alibaba.android.arouter.launcher.a.d().b("/shorts/favorite").navigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getItemOptType() {
        return Intrinsics.b(this.f55461b, TYPE_COLLECTION) ? TYPE_COLLECTION : "continue_watching";
    }

    private final ILoginApi getLoginApi() {
        return (ILoginApi) this.f55470l.getValue();
    }

    private final ShortTVContentViewModel getViewModel() {
        return (ShortTVContentViewModel) this.f55466h.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        this.f55468j = new zr.b(0.6f, new b(), false, 4, null);
        ShortTVHeaderViewAdapter shortTVHeaderViewAdapter = new ShortTVHeaderViewAdapter(null, 1, 0 == true ? 1 : 0);
        shortTVHeaderViewAdapter.B0(new f9.d() { // from class: com.transsion.postdetail.shorttv.widget.a
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                ShortTVCollectionView.d(this.f55504a, baseQuickAdapter, view, i11);
            }
        });
        this.f55467i = shortTVHeaderViewAdapter;
        HorizontalRecyclerview2 horizontalRecyclerview2 = this.f55465g.f77738b;
        horizontalRecyclerview2.setLayoutManager(new NpaLinearLayoutManager(horizontalRecyclerview2.getContext(), 0, false));
        horizontalRecyclerview2.addItemDecoration(new c());
        horizontalRecyclerview2.setAdapter(this.f55467i);
        zr.b bVar = this.f55468j;
        Intrinsics.d(bVar);
        horizontalRecyclerview2.addOnScrollListener(bVar);
        this.f55465g.f77741f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.shorttv.widget.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTVCollectionView.e(view);
            }
        });
    }

    public final void clearExposureCache() {
        zr.b bVar = this.f55468j;
        if (bVar != null) {
            bVar.f();
        }
    }

    public final void f() {
        if (Intrinsics.b(this.f55461b, TYPE_COLLECTION)) {
            TnTextView tnTextView = this.f55465g.f77740d;
            Intrinsics.f(tnTextView, "viewBinding.tvTitleTrending");
            tnTextView.setVisibility(8);
            AppCompatTextView appCompatTextView = this.f55465g.f77739c;
            Context context = getContext();
            appCompatTextView.setText(context != null ? context.getString(R$string.short_tv_my_list) : null);
            getViewModel().d().j(this.f55460a, new d(new Function1<ShortTVRespData, Unit>() { // from class: com.transsion.postdetail.shorttv.widget.ShortTVCollectionView$initViewModel$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ShortTVRespData shortTVRespData) {
                    invoke2(shortTVRespData);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ShortTVRespData shortTVRespData) {
                    String nextPage;
                    if (shortTVRespData == null) {
                        return;
                    }
                    ShortTVCollectionView shortTVCollectionView = this.this$0;
                    Pager pager = shortTVRespData.getPager();
                    if (pager == null || (nextPage = pager.getNextPage()) == null) {
                        nextPage = "0";
                    }
                    shortTVCollectionView.f55469k = nextPage;
                    this.this$0.h(shortTVRespData.getItems());
                }
            }));
        }
    }

    public final void g(Subject subject) {
        Context context = getContext();
        if (context != null) {
            if (Intrinsics.b(getItemOptType(), TYPE_COLLECTION)) {
                DownloadManagerApi.f60274j.a().a2((FragmentActivity) context, "minitv_explore", (384 & 4) != 0 ? "" : "", subject.getOps(), (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : false, (384 & 64) != 0 ? null : subject, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
            } else {
                ShortTvListActivity.a.b(ShortTvListActivity.f55358h, context, subject, null, 0L, false, 28, null);
            }
        }
    }

    public final void h(List<? extends Subject> list) {
        ShortTVHeaderViewAdapter shortTVHeaderViewAdapter;
        uo.b.a.f(uo.b.f78622a, "ShortTVCollectionView", "updateList, type:" + this.f55461b + "，size:" + (list != null ? Integer.valueOf(list.size()) : null), false, 4, null);
        List<? extends Subject> list2 = list;
        if (list2 == null || list2.isEmpty() || (shortTVHeaderViewAdapter = this.f55467i) == null) {
            return;
        }
        shortTVHeaderViewAdapter.w0(list2);
    }
}
