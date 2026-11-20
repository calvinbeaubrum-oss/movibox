package com.tn.lib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.widget.R$id;
import com.tn.lib.widget.R$layout;
import com.tn.lib.widget.R$styleable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class AdvRecyclerView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f49476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f49477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f49478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f49479d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView.r f49480f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView f49481g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f49482h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f49483i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f49484j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f49485k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f49486l;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        void a();

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.g(context, "context");
        Intrinsics.g(attrs, "attrs");
        this.f49482h = -1;
        this.f49483i = -1;
        this.f49484j = -1;
        c(attrs);
        d();
    }

    public static final void f(AdvRecyclerView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        a aVar = this$0.f49486l;
        if (aVar != null) {
            aVar.b();
        }
    }

    public static final void g(AdvRecyclerView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        a aVar = this$0.f49486l;
        if (aVar != null) {
            aVar.a();
        }
    }

    private final void getEmptyView() {
        if (this.f49479d == null) {
            this.f49479d = (FrameLayout) ((ViewStub) findViewById(R$id.vs_state)).inflate();
        }
        if (this.f49477b == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f49483i, (ViewGroup) null);
            this.f49477b = viewInflate;
            FrameLayout frameLayout = this.f49479d;
            if (frameLayout != null) {
                frameLayout.addView(viewInflate, layoutParams);
            }
        }
    }

    private final void getErrorView() {
        if (this.f49479d == null) {
            this.f49479d = (FrameLayout) ((ViewStub) findViewById(R$id.vs_state)).inflate();
        }
        if (this.f49478c == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f49482h, (ViewGroup) null);
            if (viewInflate instanceof NoNetworkBigView) {
                NoNetworkBigView noNetworkBigView = (NoNetworkBigView) viewInflate;
                NoNetworkBigView.showTitle$default(noNetworkBigView, false, null, 2, null);
                noNetworkBigView.retry(new Function0<Unit>() { // from class: com.tn.lib.view.AdvRecyclerView$getErrorView$1$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        AdvRecyclerView.a onClickListener = this.this$0.getOnClickListener();
                        if (onClickListener != null) {
                            onClickListener.b();
                        }
                        String str = this.this$0.f49485k;
                        if (str != null) {
                            l.b(str);
                        }
                    }
                });
                noNetworkBigView.goToSetting(new Function0<Unit>() { // from class: com.tn.lib.view.AdvRecyclerView$getErrorView$1$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        String str = this.this$0.f49485k;
                        if (str != null) {
                            l.c(str);
                        }
                    }
                });
                String str = this.f49485k;
                if (str != null) {
                    l.a(str);
                }
            }
            this.f49478c = viewInflate;
            FrameLayout frameLayout = this.f49479d;
            if (frameLayout != null) {
                frameLayout.addView(viewInflate, layoutParams);
            }
        }
    }

    private final void getProgressView() {
        if (this.f49479d == null) {
            this.f49479d = (FrameLayout) ((ViewStub) findViewById(R$id.vs_state)).inflate();
        }
        if (this.f49476a == null) {
            this.f49476a = LayoutInflater.from(getContext()).inflate(this.f49484j, (ViewGroup) null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            FrameLayout frameLayout = this.f49479d;
            if (frameLayout != null) {
                frameLayout.addView(this.f49476a, layoutParams);
            }
        }
    }

    private final void setAdapter(RecyclerView.Adapter<RecyclerView.a0> adapter) {
        RecyclerView recyclerView = this.f49481g;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.y("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setAdapter(adapter);
        RecyclerView recyclerView3 = this.f49481g;
        if (recyclerView3 == null) {
            Intrinsics.y("mRecyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.setVisibility(0);
        FrameLayout frameLayout = this.f49479d;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    public final void addOnScrollListener(RecyclerView.r onScrollListener) {
        Intrinsics.g(onScrollListener, "onScrollListener");
        this.f49480f = onScrollListener;
        if (this.f49481g == null) {
            Intrinsics.y("mRecyclerView");
        }
        RecyclerView recyclerView = this.f49481g;
        if (recyclerView == null) {
            Intrinsics.y("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.addOnScrollListener(onScrollListener);
    }

    public final void c(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.advrecyclerview);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…tyleable.advrecyclerview)");
        try {
            try {
                this.f49484j = typedArrayObtainStyledAttributes.getResourceId(R$styleable.advrecyclerview_adv_layout_progress, R$layout.adv_layout_progress);
                this.f49483i = typedArrayObtainStyledAttributes.getResourceId(R$styleable.advrecyclerview_adv_layout_empty, R$layout.adv_layout_empty);
                this.f49482h = typedArrayObtainStyledAttributes.getResourceId(R$styleable.advrecyclerview_adv_layout_error, R$layout.adv_layout_error);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final void d() {
        LayoutInflater.from(getContext()).inflate(R$layout.adv_layout_advanced_recyclerview, this);
        View viewFindViewById = findViewById(R$id.recycler_view);
        Intrinsics.f(viewFindViewById, "findViewById(R.id.recycler_view)");
        this.f49481g = (RecyclerView) viewFindViewById;
    }

    public final void e(boolean z11) {
        RecyclerView recyclerView = this.f49481g;
        if (recyclerView == null) {
            Intrinsics.y("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(z11 ? 0 : 4);
        FrameLayout frameLayout = this.f49479d;
        if (frameLayout == null || frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(z11 ? 8 : 0);
    }

    public final a getOnClickListener() {
        return this.f49486l;
    }

    public final RecyclerView getRecyclerView() {
        RecyclerView recyclerView = this.f49481g;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.y("mRecyclerView");
        return null;
    }

    public final boolean isShowEmpty() {
        View view = this.f49477b;
        if (view != null) {
            return so.c.i(view);
        }
        return false;
    }

    public final View obtainEmptyView() {
        return this.f49477b;
    }

    public final void resetEmptyView(int i11) {
        this.f49483i = i11;
    }

    public final void setLayoutManager(RecyclerView.m mVar) {
        RecyclerView recyclerView = this.f49481g;
        if (recyclerView == null) {
            Intrinsics.y("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(mVar);
    }

    public final void setOnClickListener(a aVar) {
        this.f49486l = aVar;
    }

    public final void setOnStateClickListener(a listenr) {
        Intrinsics.g(listenr, "listenr");
        this.f49486l = listenr;
    }

    public final void setPageName(String pageName) {
        Intrinsics.g(pageName, "pageName");
        this.f49485k = pageName;
    }

    public final void showData() {
        e(true);
    }

    public final void showEmpty() {
        getEmptyView();
        e(false);
        View view = this.f49478c;
        if (view != null) {
            view.setVisibility(4);
        }
        View view2 = this.f49477b;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = this.f49476a;
        if (view3 != null) {
            view3.setVisibility(4);
        }
        FrameLayout frameLayout = this.f49479d;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    AdvRecyclerView.f(this.f49679a, view4);
                }
            });
        }
    }

    public final void showError() {
        getErrorView();
        e(false);
        View view = this.f49478c;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.f49477b;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        View view3 = this.f49476a;
        if (view3 != null) {
            view3.setVisibility(4);
        }
        FrameLayout frameLayout = this.f49479d;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tn.lib.view.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    AdvRecyclerView.g(this.f49677a, view4);
                }
            });
        }
    }

    public final void showProgress() {
        getProgressView();
        e(false);
        View view = this.f49478c;
        if (view != null) {
            view.setVisibility(4);
        }
        View view2 = this.f49477b;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        View view3 = this.f49476a;
        if (view3 == null) {
            return;
        }
        view3.setVisibility(0);
    }
}
