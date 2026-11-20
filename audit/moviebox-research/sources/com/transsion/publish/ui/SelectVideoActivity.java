package com.transsion.publish.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.PermissionUtils;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.publish.R$id;
import com.transsion.publish.R$string;
import com.transsion.publish.adapter.SelectVideoAdapter;
import com.transsion.publish.api.VsMediaInfo;
import com.transsion.publish.bean.PreviewMediaConfirmEvent;
import com.transsion.publish.bean.PreviewVideoBean;
import com.transsion.publish.view.CustomHeader;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.w0;

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
@Metadata
@SourceDebugExtension
public final class SelectVideoActivity extends BaseActivity<ew.k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f56559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SelectVideoAdapter f56560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gw.c f56561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearLayout f56562d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f56563f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ProgressBar f56564g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f56565h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f56566i = com.blankj.utilcode.util.d0.e();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h10.b f56567j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f56568k;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements io.reactivex.rxjava3.core.o<List<VsMediaInfo>> {
        public a() {
        }

        @Override // io.reactivex.rxjava3.core.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<VsMediaInfo> t11) {
            Intrinsics.g(t11, "t");
            if (t11.isEmpty()) {
                LinearLayout linearLayout = SelectVideoActivity.this.f56562d;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
            } else {
                SelectVideoAdapter selectVideoAdapter = SelectVideoActivity.this.f56560b;
                if (selectVideoAdapter != null) {
                    selectVideoAdapter.g(t11);
                }
            }
            SelectVideoActivity.this.d0();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            LinearLayout linearLayout;
            SelectVideoAdapter selectVideoAdapter;
            h10.b bVar = SelectVideoActivity.this.f56567j;
            if (bVar != null) {
                bVar.dispose();
            }
            SelectVideoActivity.this.d0();
            if ((SelectVideoActivity.this.f56560b == null || ((selectVideoAdapter = SelectVideoActivity.this.f56560b) != null && selectVideoAdapter.getItemCount() == 0)) && (linearLayout = SelectVideoActivity.this.f56562d) != null) {
                linearLayout.setVisibility(0);
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable e11) {
            Intrinsics.g(e11, "e");
            uo.b.a.f(uo.b.f78622a, "SelectVideoManager", "onError e:" + e11, false, 4, null);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b d11) {
            Intrinsics.g(d11, "d");
            SelectVideoActivity.this.f56567j = d11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements PermissionUtils.b {
        public b() {
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void a() {
            LinearLayout linearLayout = SelectVideoActivity.this.f56563f;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onGranted() {
            LinearLayout linearLayout = SelectVideoActivity.this.f56563f;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            SelectVideoActivity.this.g0();
        }
    }

    /* JADX INFO: renamed from: com.transsion.publish.ui.SelectVideoActivity$initView$4, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
        public AnonymousClass4(Object obj) {
            super(1, obj, SelectVideoActivity.class, "checkSelect", "checkSelect(I)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f68710a;
        }

        public final void invoke(int i11) {
            ((SelectVideoActivity) this.receiver).a0(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0() {
        ProgressBar progressBar = this.f56564g;
        if (progressBar == null) {
            return;
        }
        progressBar.setVisibility(8);
    }

    public static final void e0(SelectVideoActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.finish();
    }

    public static final void f0(View view) {
        PermissionUtils.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0() {
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(true);
        }
        showLoading();
        this.f56561c = new gw.c(this);
        io.reactivex.rxjava3.core.j.f(new io.reactivex.rxjava3.core.l() { // from class: com.transsion.publish.ui.n0
            @Override // io.reactivex.rxjava3.core.l
            public final void a(io.reactivex.rxjava3.core.k kVar) throws Throwable {
                SelectVideoActivity.h0(this.f56601a, kVar);
            }
        }).a(12).r(io.reactivex.rxjava3.android.schedulers.b.c()).A(q10.a.b()).subscribe(new a());
    }

    public static final void h0(SelectVideoActivity this$0, io.reactivex.rxjava3.core.k emitter) throws Throwable {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(emitter, "emitter");
        uo.b.a.f(uo.b.f78622a, "SelectVideoManager", "loadLocalVideo success", false, 4, null);
        gw.c cVar = this$0.f56561c;
        if (cVar != null) {
            cVar.a(emitter);
        }
        if (emitter.isDisposed()) {
            return;
        }
        emitter.onComplete();
    }

    private final void i0() {
        if (PermissionUtils.s("android.permission.READ_EXTERNAL_STORAGE")) {
            g0();
        } else {
            PermissionUtils.x("android.permission.READ_EXTERNAL_STORAGE").m(new b()).y();
        }
    }

    private final void initData() {
        Function1<PreviewMediaConfirmEvent, Unit> function1 = new Function1<PreviewMediaConfirmEvent, Unit>() { // from class: com.transsion.publish.ui.SelectVideoActivity.initData.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PreviewMediaConfirmEvent previewMediaConfirmEvent) {
                invoke2(previewMediaConfirmEvent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PreviewMediaConfirmEvent it) {
                Intrinsics.g(it, "it");
                SelectVideoActivity.this.b0();
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = PreviewMediaConfirmEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        ((CustomHeader) findViewById(R$id.sv_title_bar)).setOnBackClick(new View.OnClickListener() { // from class: com.transsion.publish.ui.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectVideoActivity.e0(this.f56603a, view);
            }
        });
        a0(0);
        TextView textView = ((ew.k) getMViewBinding()).f64452b;
        Intrinsics.f(textView, "mViewBinding.confirmTV");
        so.c.c(textView, 0L, new Function1<View, Unit>() { // from class: com.transsion.publish.ui.SelectVideoActivity.initView.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.g(it, "it");
                SelectVideoActivity.this.b0();
            }
        }, 1, null);
        this.f56564g = (ProgressBar) findViewById(R$id.select_video_loading);
        this.f56562d = (LinearLayout) findViewById(R$id.sv_no_content_view);
        this.f56563f = (LinearLayout) findViewById(R$id.sv_lock_view);
        TextView textView2 = (TextView) findViewById(R$id.sv_tv_grant);
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.p0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectVideoActivity.f0(view);
                }
            });
        }
        this.f56559a = (RecyclerView) findViewById(R$id.select_video_recycler);
        this.f56560b = new SelectVideoAdapter(new AnonymousClass4(this));
        RecyclerView recyclerView = this.f56559a;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager((Context) this, 4, 1, false));
        }
        RecyclerView recyclerView2 = this.f56559a;
        if (recyclerView2 != null) {
            recyclerView2.addItemDecoration(new iw.e(com.blankj.utilcode.util.f0.a(2.0f)));
        }
        RecyclerView recyclerView3 = this.f56559a;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(this.f56560b);
        }
        Function1<PreviewVideoBean, Unit> function1 = new Function1<PreviewVideoBean, Unit>() { // from class: com.transsion.publish.ui.SelectVideoActivity.initView.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PreviewVideoBean previewVideoBean) {
                invoke2(previewVideoBean);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PreviewVideoBean it) {
                SelectVideoAdapter selectVideoAdapter;
                Intrinsics.g(it, "it");
                VsMediaInfo select = it.getSelect();
                if (select == null || (selectVideoAdapter = SelectVideoActivity.this.f56560b) == null) {
                    return;
                }
                selectVideoAdapter.q(select);
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = PreviewVideoBean.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
    }

    private final void showLoading() {
        ProgressBar progressBar = this.f56564g;
        if (progressBar == null) {
            return;
        }
        progressBar.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a0(int i11) {
        int iD = kotlin.ranges.a.d(i11, 0);
        TextView textView = ((ew.k) getMViewBinding()).f64453c;
        Intrinsics.f(textView, "mViewBinding.selectNumTV");
        textView.setVisibility(iD > 0 ? 0 : 8);
        ((ew.k) getMViewBinding()).f64453c.setText(getString(R$string.video_select_num_tips, Integer.valueOf(iD), Integer.valueOf(this.f56565h)));
    }

    public final void b0() {
        List<VsMediaInfo> listJ;
        SelectVideoAdapter selectVideoAdapter = this.f56560b;
        VsMediaInfo vsMediaInfo = (selectVideoAdapter == null || (listJ = selectVideoAdapter.j()) == null) ? null : (VsMediaInfo) CollectionsKt___CollectionsKt.g0(listJ);
        if (vsMediaInfo != null) {
            cw.a aVar = new cw.a();
            aVar.o(1);
            aVar.n(1);
            aVar.t(vsMediaInfo);
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = cw.a.class.getName();
            Intrinsics.f(name, "T::class.java.name");
            flowEventBus.postEvent(name, aVar, 0L);
        }
        finish();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public ew.k getViewBinding() {
        ew.k kVarC = ew.k.c(getLayoutInflater());
        Intrinsics.f(kVarC, "inflate(layoutInflater)");
        return kVarC;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isChangeStatusBar() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("select_video", false, 2, null);
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f56568k = System.currentTimeMillis();
        initView();
        initData();
        i0();
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        h10.b bVar = this.f56567j;
        if (bVar != null) {
            bVar.dispose();
        }
    }
}
