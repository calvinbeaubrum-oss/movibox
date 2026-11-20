package com.transsion.publish.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.PermissionUtils;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.publish.R$id;
import com.transsion.publish.R$string;
import com.transsion.publish.TempTransitData;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.bean.BigImageBean;
import com.transsion.publish.bean.PreviewMediaConfirmEvent;
import com.transsion.publish.view.CustomHeader;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.w0;
import org.mvel2.ast.ASTNode;

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
public final class SelectImageActivity extends BaseActivity<ew.d> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f56514r = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f56516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.transsion.publish.adapter.e0 f56517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gw.b f56518d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f56519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f56520g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ProgressBar f56521h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<PhotoEntity> f56522i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h10.b f56523j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f56524k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f56525l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b1.b<b1.e> f56527n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public b1.b<String> f56528o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b1.b<Intent> f56529p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f56530q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f56515a = "ImageSelect";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f56526m = 1;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, int i11, int i12, List<PhotoEntity> list) {
            Intrinsics.g(context, "context");
            Intent intent = new Intent(context, (Class<?>) SelectImageActivity.class);
            intent.setFlags(ASTNode.DEOP);
            intent.putExtra("key_type", i11);
            if (list != null) {
                intent.putExtra("key_list", (Serializable) list);
            }
            intent.putExtra("key_limited", i12);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements io.reactivex.rxjava3.core.o<List<PhotoEntity>> {
        public b() {
        }

        @Override // io.reactivex.rxjava3.core.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<PhotoEntity> t11) {
            Intrinsics.g(t11, "t");
            if (t11.isEmpty() || (t11.size() == 1 && TextUtils.isEmpty(t11.get(0).getLocalPath()))) {
                LinearLayout linearLayout = SelectImageActivity.this.f56519f;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
            } else {
                SelectImageActivity selectImageActivity = SelectImageActivity.this;
                List list = selectImageActivity.f56522i;
                selectImageActivity.g0(t11, list != null ? CollectionsKt___CollectionsKt.M0(list) : null);
                com.transsion.publish.adapter.e0 e0Var = SelectImageActivity.this.f56517c;
                if (e0Var != null) {
                    e0Var.j(t11);
                }
            }
            SelectImageActivity.this.k0();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            h10.b bVar = SelectImageActivity.this.f56523j;
            if (bVar != null) {
                bVar.dispose();
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
            SelectImageActivity.this.f56523j = d11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements PermissionUtils.b {
        public c() {
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void a() {
            LinearLayout linearLayout = SelectImageActivity.this.f56520g;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            ProgressBar progressBar = SelectImageActivity.this.f56521h;
            if (progressBar != null) {
                so.c.g(progressBar);
            }
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onGranted() {
            LinearLayout linearLayout = SelectImageActivity.this.f56520g;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            SelectImageActivity.this.p0();
        }
    }

    /* JADX INFO: renamed from: com.transsion.publish.ui.SelectImageActivity$initView$5, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
        public AnonymousClass5(Object obj) {
            super(1, obj, SelectImageActivity.class, "checkSelectNum", "checkSelectNum(I)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f68710a;
        }

        public final void invoke(int i11) {
            ((SelectImageActivity) this.receiver).h0(i11);
        }
    }

    public SelectImageActivity() {
        this.f56530q = Build.VERSION.SDK_INT < 33;
    }

    private final void initData() {
        Function1<PreviewMediaConfirmEvent, Unit> function1 = new Function1<PreviewMediaConfirmEvent, Unit>() { // from class: com.transsion.publish.ui.SelectImageActivity.initData.1
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
                SelectImageActivity.this.r0();
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = PreviewMediaConfirmEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        List<PhotoEntity> list;
        List<PhotoEntity> list2 = this.f56522i;
        PhotoEntity photoEntity = null;
        if (list2 != null) {
            for (PhotoEntity photoEntity2 : list2) {
                if (photoEntity2.isAdd()) {
                    photoEntity = photoEntity2;
                }
            }
        }
        if (photoEntity != null && (list = this.f56522i) != null) {
            TypeIntrinsics.a(list).remove(photoEntity);
        }
        ((CustomHeader) findViewById(R$id.sv_title_bar)).setOnBackClick(new View.OnClickListener() { // from class: com.transsion.publish.ui.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectImageActivity.n0(this.f56584a, view);
            }
        });
        List<PhotoEntity> list3 = this.f56522i;
        h0(list3 != null ? list3.size() : 0);
        TextView textView = ((ew.d) getMViewBinding()).f64384b;
        Intrinsics.f(textView, "mViewBinding.confirmTV");
        so.c.c(textView, 0L, new Function1<View, Unit>() { // from class: com.transsion.publish.ui.SelectImageActivity.initView.3
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
                SelectImageActivity.this.r0();
            }
        }, 1, null);
        this.f56521h = (ProgressBar) findViewById(R$id.select_video_loading);
        this.f56519f = (LinearLayout) findViewById(R$id.sv_no_content_view);
        this.f56520g = (LinearLayout) findViewById(R$id.sv_lock_view);
        TextView textView2 = (TextView) findViewById(R$id.sv_tv_grant);
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.e0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectImageActivity.o0(view);
                }
            });
        }
        this.f56516b = (RecyclerView) findViewById(R$id.select_video_recycler);
        com.transsion.publish.adapter.e0 e0Var = new com.transsion.publish.adapter.e0(new AnonymousClass5(this));
        this.f56517c = e0Var;
        e0Var.w(this.f56525l, this);
        com.transsion.publish.adapter.e0 e0Var2 = this.f56517c;
        if (e0Var2 != null) {
            e0Var2.x(this.f56526m);
        }
        RecyclerView recyclerView = this.f56516b;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new NpaGridLayoutManager((Context) this, 4, 1, false));
        }
        RecyclerView recyclerView2 = this.f56516b;
        if (recyclerView2 != null) {
            recyclerView2.addItemDecoration(new iw.e(com.blankj.utilcode.util.f0.a(2.0f)));
        }
        RecyclerView recyclerView3 = this.f56516b;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(this.f56517c);
        }
        Function1<BigImageBean, Unit> function1 = new Function1<BigImageBean, Unit>() { // from class: com.transsion.publish.ui.SelectImageActivity.initView.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BigImageBean bigImageBean) {
                invoke2(bigImageBean);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BigImageBean it) {
                Integer operator;
                Intrinsics.g(it, "it");
                Integer from = it.getFrom();
                if (from == null || from.intValue() != 3) {
                    Integer from2 = it.getFrom();
                    if (from2 != null && from2.intValue() == 1 && (operator = it.getOperator()) != null && operator.intValue() == 1) {
                        com.transsion.publish.adapter.e0 e0Var3 = SelectImageActivity.this.f56517c;
                        if (e0Var3 != null) {
                            e0Var3.l();
                        }
                        com.transsion.publish.adapter.e0 e0Var4 = SelectImageActivity.this.f56517c;
                        if (e0Var4 != null) {
                            e0Var4.v();
                        }
                        SelectImageActivity selectImageActivity = SelectImageActivity.this;
                        com.transsion.publish.adapter.e0 e0Var5 = selectImageActivity.f56517c;
                        selectImageActivity.g0(e0Var5 != null ? e0Var5.o() : null, it.getSelect());
                        com.transsion.publish.adapter.e0 e0Var6 = SelectImageActivity.this.f56517c;
                        if (e0Var6 != null) {
                            e0Var6.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    return;
                }
                Integer operator2 = it.getOperator();
                if (operator2 != null && operator2.intValue() == 2) {
                    com.transsion.publish.adapter.e0 e0Var7 = SelectImageActivity.this.f56517c;
                    if (e0Var7 != null) {
                        e0Var7.l();
                    }
                    com.transsion.publish.adapter.e0 e0Var8 = SelectImageActivity.this.f56517c;
                    if (e0Var8 != null) {
                        e0Var8.v();
                    }
                    com.transsion.publish.adapter.e0 e0Var9 = SelectImageActivity.this.f56517c;
                    if (e0Var9 != null) {
                        e0Var9.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                com.transsion.publish.adapter.e0 e0Var10 = SelectImageActivity.this.f56517c;
                if (e0Var10 != null) {
                    e0Var10.l();
                }
                com.transsion.publish.adapter.e0 e0Var11 = SelectImageActivity.this.f56517c;
                if (e0Var11 != null) {
                    e0Var11.v();
                }
                SelectImageActivity selectImageActivity2 = SelectImageActivity.this;
                com.transsion.publish.adapter.e0 e0Var12 = selectImageActivity2.f56517c;
                selectImageActivity2.g0(e0Var12 != null ? e0Var12.o() : null, it.getSelect());
                com.transsion.publish.adapter.e0 e0Var13 = SelectImageActivity.this.f56517c;
                if (e0Var13 != null) {
                    e0Var13.notifyDataSetChanged();
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = BigImageBean.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0() {
        ProgressBar progressBar = this.f56521h;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        ProgressBar progressBar2 = this.f56521h;
        if (progressBar2 != null) {
            so.c.g(progressBar2);
        }
    }

    public static final void m0(SelectImageActivity this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        this$0.i0(activityResult.getData());
    }

    public static final void n0(SelectImageActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.finish();
    }

    public static final void o0(View view) {
        PermissionUtils.v();
    }

    public static final void q0(SelectImageActivity this$0, io.reactivex.rxjava3.core.k emitter) throws Throwable {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(emitter, "emitter");
        uo.b.a.f(uo.b.f78622a, "SelectVideoManager", "loadLocalVideo success", false, 4, null);
        gw.b bVar = this$0.f56518d;
        if (bVar != null) {
            bVar.a(emitter);
        }
        if (emitter.isDisposed()) {
            return;
        }
        emitter.onComplete();
    }

    private final void showLoading() {
        ProgressBar progressBar = this.f56521h;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        ProgressBar progressBar2 = this.f56521h;
        if (progressBar2 != null) {
            so.c.k(progressBar2);
        }
    }

    public static final void w0(SelectImageActivity this$0, List list) {
        Intrinsics.g(this$0, "this$0");
        uo.b.a.f(uo.b.f78622a, this$0.f56515a, "imageSelect keyType:" + this$0.f56525l + ", data：" + list, false, 4, null);
        if (list != null) {
            this$0.s0(list);
        } else {
            this$0.finish();
        }
    }

    public static final void x0(SelectImageActivity this$0, Uri uri) {
        String strC;
        Intrinsics.g(this$0, "this$0");
        uo.b.a.f(uo.b.f78622a, this$0.f56515a, "singleSelect keyType:" + this$0.f56525l + ", uri：" + uri, false, 4, null);
        if (uri == null) {
            this$0.finish();
            return;
        }
        if (this$0.f56525l == 0) {
            this$0.s0(kotlin.collections.f.e(uri));
            return;
        }
        dw.a aVarB = iw.f.f67743a.b(this$0, uri);
        if (aVarB == null || (strC = aVarB.c()) == null) {
            return;
        }
        this$0.u0(strC, this$0.f56525l);
    }

    public final void g0(List<PhotoEntity> list, List<PhotoEntity> list2) {
        List<PhotoEntity> list3;
        if ((list2 != null && list2.isEmpty()) || (list3 = list) == null || list3.isEmpty() || list2 == null) {
            return;
        }
        int i11 = 0;
        for (Object obj : list2) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            PhotoEntity photoEntity = (PhotoEntity) obj;
            if (list != null) {
                for (PhotoEntity photoEntity2 : list) {
                    if (Intrinsics.b(photoEntity2 != null ? photoEntity2.getLocalPath() : null, photoEntity.getLocalPath())) {
                        photoEntity2.setEnableSelect(true);
                        com.transsion.publish.adapter.e0 e0Var = this.f56517c;
                        if (e0Var != null) {
                            e0Var.y(photoEntity);
                        }
                    }
                }
            }
            i11 = i12;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h0(int i11) {
        TextView textView = ((ew.d) getMViewBinding()).f64385c;
        Intrinsics.f(textView, "mViewBinding.selectNumTV");
        textView.setVisibility(i11 > 0 ? 0 : 8);
        ((ew.d) getMViewBinding()).f64385c.setText(getString(R$string.image_select_num_tips, Integer.valueOf(i11), Integer.valueOf(this.f56526m)));
    }

    public final void i0(Intent intent) {
        Bundle extras;
        Bundle extras2;
        if (intent != null && (extras2 = intent.getExtras()) != null && !extras2.containsKey("clip_result")) {
            finish();
            return;
        }
        Serializable serializable = (intent == null || (extras = intent.getExtras()) == null) ? null : extras.getSerializable("clip_result");
        if (serializable == null) {
            uo.b.a.f(uo.b.f78622a, "clip_result", "null...", false, 4, null);
            finish();
            return;
        }
        if (serializable instanceof PhotoEntity) {
            uo.b.a.f(uo.b.f78622a, "clip_result", "result:" + serializable, false, 4, null);
            int i11 = this.f56525l;
            if (i11 == 0 || i11 == 5) {
                cw.a aVar = new cw.a();
                aVar.o(5);
                aVar.n(1);
                aVar.l((PhotoEntity) serializable);
                FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name = cw.a.class.getName();
                Intrinsics.f(name, "T::class.java.name");
                flowEventBus.postEvent(name, aVar, 0L);
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("clip_result", ((PhotoEntity) serializable).getLocalPath());
                setResult(-1, intent2);
            }
        }
        finish();
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

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public ew.d getViewBinding() {
        ew.d dVarC = ew.d.c(getLayoutInflater());
        Intrinsics.f(dVarC, "inflate(layoutInflater)");
        return dVarC;
    }

    public final void l0() {
        if (this.f56529p != null) {
            return;
        }
        this.f56529p = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.transsion.publish.ui.f0
            @Override // b1.a
            public final void a(Object obj) {
                SelectImageActivity.m0(this.f56586a, (ActivityResult) obj);
            }
        });
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("select_image", false, 2, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        uo.b.a.f(uo.b.f78622a, this.f56515a, "onActivityResult keyType:" + this.f56525l + ", requestCodeP:" + i11 + ", data:" + (intent != null ? intent.getData() : null), false, 4, null);
        if (i11 != 10002) {
            return;
        }
        i0(intent);
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f56524k = System.currentTimeMillis();
        this.f56526m = getIntent().getIntExtra("key_limited", 1);
        this.f56525l = getIntent().getIntExtra("key_type", 0);
        if (getIntent().hasExtra("key_list")) {
            Serializable serializableExtra = getIntent().getSerializableExtra("key_list");
            Intrinsics.e(serializableExtra, "null cannot be cast to non-null type kotlin.collections.MutableList<com.transsion.publish.api.PhotoEntity>");
            this.f56522i = TypeIntrinsics.c(serializableExtra);
        }
        if (this.f56530q) {
            initView();
            initData();
            t0();
        } else {
            v0();
            View viewFindViewById = findViewById(com.transsion.baseui.R$id.llRootView);
            Intrinsics.f(viewFindViewById, "findViewById<FrameLayout…n.baseui.R.id.llRootView)");
            so.c.h(viewFindViewById);
        }
        l0();
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        h10.b bVar = this.f56523j;
        if (bVar != null) {
            bVar.dispose();
        }
        TempTransitData.f56359b.a().b();
    }

    public final void p0() {
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(true);
        }
        showLoading();
        this.f56518d = new gw.b(this);
        io.reactivex.rxjava3.core.j.f(new io.reactivex.rxjava3.core.l() { // from class: com.transsion.publish.ui.a0
            @Override // io.reactivex.rxjava3.core.l
            public final void a(io.reactivex.rxjava3.core.k kVar) throws Throwable {
                SelectImageActivity.q0(this.f56578a, kVar);
            }
        }).a(12).r(io.reactivex.rxjava3.android.schedulers.b.c()).A(q10.a.b()).subscribe(new b());
    }

    public final void r0() {
        com.transsion.publish.adapter.e0 e0Var = this.f56517c;
        List<PhotoEntity> listP = e0Var != null ? e0Var.p() : null;
        List<PhotoEntity> list = listP;
        if (list == null || list.isEmpty()) {
            finish();
            return;
        }
        if (this.f56525l != 0) {
            String localPath = listP.get(0).getLocalPath();
            if (localPath != null) {
                u0(localPath, this.f56525l);
                return;
            }
            return;
        }
        cw.a aVar = new cw.a();
        aVar.o(0);
        aVar.n(1);
        aVar.r(CollectionsKt___CollectionsKt.M0(list));
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = cw.a.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, aVar, 0L);
        finish();
    }

    public final void s0(List<? extends Uri> list) {
        cw.a aVar = new cw.a();
        aVar.o(Integer.valueOf(this.f56525l));
        aVar.n(1);
        aVar.r(new ArrayList());
        for (Uri uri : list) {
            PhotoEntity photoEntity = new PhotoEntity();
            dw.a aVarB = iw.f.f67743a.b(this, uri);
            if (aVarB != null) {
                photoEntity.setLocalPath(aVarB.c());
                photoEntity.setImageTitle(aVarB.e());
                photoEntity.setWidth(aVarB.f());
                photoEntity.setHeight(aVarB.b());
                photoEntity.setImageSize(aVarB.d());
            }
            List<PhotoEntity> listH = aVar.h();
            if (listH != null) {
                listH.add(photoEntity);
            }
            try {
                Result.Companion companion = Result.Companion;
                getContentResolver().takePersistableUriPermission(uri, 1);
                Result.m163constructorimpl(Unit.f68710a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
        }
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = cw.a.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, aVar, 0L);
        finish();
    }

    public final void t0() {
        String str;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 34) {
            str = "android.permission.READ_MEDIA_VISUAL_USER_SELECTED";
        } else {
            str = i11 >= 33 ? "android.permission.READ_MEDIA_IMAGES" : "android.permission.READ_EXTERNAL_STORAGE";
        }
        if (PermissionUtils.s(str)) {
            p0();
        } else {
            PermissionUtils.x(str).m(new c()).y();
        }
    }

    public final void u0(String str, int i11) {
        ClippingImageActivity.f56481k.a(this, str, i11, this.f56529p);
    }

    public final void v0() {
        int i11 = this.f56526m;
        if (i11 > 1) {
            b1.b<b1.e> bVarRegisterForActivityResult = registerForActivityResult(new c1.e(i11), new b1.a() { // from class: com.transsion.publish.ui.b0
                @Override // b1.a
                public final void a(Object obj) {
                    SelectImageActivity.w0(this.f56580a, (List) obj);
                }
            });
            this.f56527n = bVarRegisterForActivityResult;
            if (bVarRegisterForActivityResult != null) {
                bVarRegisterForActivityResult.a(b1.f.a(c1.g.c.f14544a));
                return;
            }
            return;
        }
        b1.b<String> bVarRegisterForActivityResult2 = registerForActivityResult(new c1.b(), new b1.a() { // from class: com.transsion.publish.ui.c0
            @Override // b1.a
            public final void a(Object obj) {
                SelectImageActivity.x0(this.f56583a, (Uri) obj);
            }
        });
        this.f56528o = bVarRegisterForActivityResult2;
        if (bVarRegisterForActivityResult2 != null) {
            bVarRegisterForActivityResult2.a("image/*");
        }
    }
}
