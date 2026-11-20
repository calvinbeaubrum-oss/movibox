package com.transsion.publish.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.viewpager.widget.ViewPager;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$string;
import com.transsion.publish.TempTransitData;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.bean.BigImageBean;
import com.transsion.publish.bean.PreviewMediaConfirmEvent;
import com.transsion.publish.view.FixedViewPager;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
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
public final class GalleryActivity extends BaseActivity<ew.c> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f56500g = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.transsion.publish.adapter.j0 f56503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f56504d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<PhotoEntity> f56501a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<PhotoEntity> f56502b = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f56505f = 1;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, List<PhotoEntity> select, int i11, int i12, int i13) {
            Intrinsics.g(context, "context");
            Intrinsics.g(select, "select");
            Intent intent = new Intent(context, (Class<?>) GalleryActivity.class);
            intent.setFlags(ASTNode.DEOP);
            intent.putExtra("select", (Serializable) select);
            intent.putExtra("index", i11);
            intent.putExtra("from", i12);
            intent.putExtra("key_list", i13);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements ViewPager.h {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.h
        public void onPageScrollStateChanged(int i11) {
        }

        @Override // androidx.viewpager.widget.ViewPager.h
        public void onPageScrolled(int i11, float f11, int i12) {
        }

        @Override // androidx.viewpager.widget.ViewPager.h
        public void onPageSelected(int i11) {
            GalleryActivity.this.T(i11);
        }
    }

    public static final void X(GalleryActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.h0();
        this$0.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void Y(GalleryActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        int currentItem = ((ew.c) this$0.getMViewBinding()).f64382o.getCurrentItem();
        if (!this$0.f56501a.isEmpty() && currentItem <= this$0.f56501a.size()) {
            PhotoEntity photoEntity = this$0.f56501a.get(currentItem);
            try {
                int i11 = this$0.f56504d;
                if (i11 == 1) {
                    this$0.d0(photoEntity);
                } else if (i11 == 2) {
                    this$0.e0(photoEntity);
                } else if (i11 == 3) {
                    this$0.g0(photoEntity);
                }
            } catch (Exception e11) {
                uo.b.a.g(uo.b.f78622a, "ext:" + e11.getMessage(), false, 2, null);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a0(GalleryActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        int currentItem = ((ew.c) this$0.getMViewBinding()).f64382o.getCurrentItem();
        if (!this$0.f56501a.isEmpty() && currentItem <= this$0.f56501a.size()) {
            try {
                this$0.e0(this$0.f56501a.get(currentItem));
            } catch (Exception e11) {
                uo.b.a.g(uo.b.f78622a, "ext:" + e11.getMessage(), false, 2, null);
            }
        }
    }

    private final void initData() {
        Z();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        ((ew.c) getMViewBinding()).f64372d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GalleryActivity.X(this.f56620a, view);
            }
        });
        ((ew.c) getMViewBinding()).f64377j.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GalleryActivity.Y(this.f56621a, view);
            }
        });
        TextView textView = ((ew.c) getMViewBinding()).f64375h;
        Intrinsics.f(textView, "mViewBinding.confirmTV");
        so.c.c(textView, 0L, new Function1<View, Unit>() { // from class: com.transsion.publish.ui.GalleryActivity.initView.3
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
                PreviewMediaConfirmEvent previewMediaConfirmEvent = new PreviewMediaConfirmEvent(0, 1, null);
                FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name = PreviewMediaConfirmEvent.class.getName();
                Intrinsics.f(name, "T::class.java.name");
                flowEventBus.postEvent(name, previewMediaConfirmEvent, 0L);
                GalleryActivity.this.finish();
            }
        }, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S() {
        TextView textView = ((ew.c) getMViewBinding()).f64378k;
        Intrinsics.f(textView, "mViewBinding.selectNumTV");
        textView.setVisibility(this.f56502b.size() > 0 ? 0 : 8);
        ((ew.c) getMViewBinding()).f64378k.setText(getString(R$string.image_select_num_tips, Integer.valueOf(this.f56502b.size()), Integer.valueOf(this.f56505f)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T(int i11) {
        try {
            int i12 = this.f56504d;
            if (2 != i12) {
                if (3 == i12) {
                    if (this.f56501a.get(i11).getEnableSelect()) {
                        ((ew.c) getMViewBinding()).f64380m.setText("1");
                        ((ew.c) getMViewBinding()).f64380m.setBackgroundResource(R$drawable.bg_linear_r16);
                        return;
                    } else {
                        ((ew.c) getMViewBinding()).f64380m.setText("");
                        ((ew.c) getMViewBinding()).f64380m.setBackgroundResource(R$drawable.ic_select_number_bro);
                        return;
                    }
                }
                PhotoEntity photoEntity = this.f56501a.get(i11);
                if (photoEntity.getEnableSelect()) {
                    ((ew.c) getMViewBinding()).f64380m.setText(V(photoEntity));
                    ((ew.c) getMViewBinding()).f64380m.setBackgroundResource(R$drawable.bg_linear_r16);
                    return;
                } else {
                    ((ew.c) getMViewBinding()).f64380m.setText("");
                    ((ew.c) getMViewBinding()).f64380m.setBackgroundResource(R$drawable.ic_select_number_bro);
                    return;
                }
            }
            int i13 = i11 + 1;
            if (i13 > this.f56501a.size()) {
                ((ew.c) getMViewBinding()).f64379l.setText(i11 + "/" + this.f56501a.size());
                return;
            }
            ((ew.c) getMViewBinding()).f64379l.setText(i13 + "/" + this.f56501a.size());
        } catch (Exception e11) {
            String message = e11.getMessage();
            if (message != null) {
                uo.b.a.f(uo.b.f78622a, "checkStatus", message, false, 4, null);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void U(PhotoEntity photoEntity) {
        if (!photoEntity.getEnableSelect()) {
            this.f56502b.add(photoEntity);
            photoEntity.setEnableSelect(true);
        }
        ((ew.c) getMViewBinding()).f64380m.setText(V(photoEntity));
        ((ew.c) getMViewBinding()).f64380m.setBackgroundResource(R$drawable.bg_linear_r16);
        h0();
        S();
    }

    public final String V(PhotoEntity photoEntity) {
        int i11 = 0;
        for (Object obj : this.f56502b) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            if (Intrinsics.b(photoEntity.getLocalPath(), ((PhotoEntity) obj).getLocalPath())) {
                return String.valueOf(i12);
            }
            i11 = i12;
        }
        return "-1";
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public ew.c getViewBinding() {
        ew.c cVarC = ew.c.c(getLayoutInflater());
        Intrinsics.f(cVarC, "inflate(layoutInflater)");
        return cVarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z() {
        List<PhotoEntity> listC;
        ProgressBar progressBar = ((ew.c) getMViewBinding()).f64374g;
        Intrinsics.f(progressBar, "mViewBinding.clipLoading");
        so.c.k(progressBar);
        if (getIntent().hasExtra("list")) {
            Serializable serializableExtra = getIntent().getSerializableExtra("list");
            Intrinsics.e(serializableExtra, "null cannot be cast to non-null type kotlin.collections.MutableList<com.transsion.publish.api.PhotoEntity>");
            listC = TypeIntrinsics.c(serializableExtra);
        } else {
            listC = TempTransitData.f56359b.a().c();
        }
        this.f56501a = listC;
        if (getIntent().hasExtra("select")) {
            Serializable serializableExtra2 = getIntent().getSerializableExtra("select");
            Intrinsics.e(serializableExtra2, "null cannot be cast to non-null type kotlin.collections.MutableList<com.transsion.publish.api.PhotoEntity>");
            this.f56502b = TypeIntrinsics.c(serializableExtra2);
        }
        this.f56504d = getIntent().getIntExtra("from", 1);
        this.f56505f = getIntent().getIntExtra("key_list", 1);
        int intExtra = getIntent().getIntExtra("index", 0);
        this.f56503c = new com.transsion.publish.adapter.j0(this.f56501a);
        ((ew.c) getMViewBinding()).f64382o.setAdapter(this.f56503c);
        ProgressBar progressBar2 = ((ew.c) getMViewBinding()).f64374g;
        Intrinsics.f(progressBar2, "mViewBinding.clipLoading");
        so.c.g(progressBar2);
        ((ew.c) getMViewBinding()).f64382o.addOnPageChangeListener(new b());
        ((ew.c) getMViewBinding()).f64382o.setCurrentItem(intExtra);
        int i11 = this.f56504d;
        if (2 == i11) {
            ((ew.c) getMViewBinding()).f64379l.getVisibility();
            ImageView imageView = ((ew.c) getMViewBinding()).f64376i;
            Intrinsics.f(imageView, "mViewBinding.ivDelete");
            so.c.k(imageView);
            LinearLayout linearLayout = ((ew.c) getMViewBinding()).f64377j;
            Intrinsics.f(linearLayout, "mViewBinding.llSelect");
            so.c.g(linearLayout);
            Group group = ((ew.c) getMViewBinding()).f64370b;
            Intrinsics.f(group, "mViewBinding.bottomGroup");
            so.c.g(group);
            ((ew.c) getMViewBinding()).f64376i.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GalleryActivity.a0(this.f56622a, view);
                }
            });
        } else if (4 == i11) {
            ((ew.c) getMViewBinding()).f64379l.getVisibility();
            ImageView imageView2 = ((ew.c) getMViewBinding()).f64376i;
            Intrinsics.f(imageView2, "mViewBinding.ivDelete");
            so.c.g(imageView2);
            LinearLayout linearLayout2 = ((ew.c) getMViewBinding()).f64377j;
            Intrinsics.f(linearLayout2, "mViewBinding.llSelect");
            so.c.g(linearLayout2);
            Group group2 = ((ew.c) getMViewBinding()).f64370b;
            Intrinsics.f(group2, "mViewBinding.bottomGroup");
            so.c.g(group2);
        } else {
            S();
            Group group3 = ((ew.c) getMViewBinding()).f64370b;
            Intrinsics.f(group3, "mViewBinding.bottomGroup");
            so.c.k(group3);
            TextView textView = ((ew.c) getMViewBinding()).f64379l;
            Intrinsics.f(textView, "mViewBinding.tvNum");
            so.c.g(textView);
            ImageView imageView3 = ((ew.c) getMViewBinding()).f64376i;
            Intrinsics.f(imageView3, "mViewBinding.ivDelete");
            so.c.g(imageView3);
        }
        T(intExtra);
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig == null) {
            return;
        }
        logViewConfig.j(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b0(PhotoEntity photoEntity, boolean z11) {
        if (photoEntity.getEnableSelect()) {
            f0(photoEntity);
            photoEntity.setEnableSelect(false);
            ((ew.c) getMViewBinding()).f64380m.setText("");
            ((ew.c) getMViewBinding()).f64380m.setBackgroundResource(R$drawable.ic_select_number_bro);
        }
    }

    public final boolean c0() {
        return this.f56502b.size() >= this.f56505f;
    }

    public final void d0(PhotoEntity photoEntity) {
        if (c0()) {
            if (photoEntity.getEnableSelect()) {
                b0(photoEntity, true);
                return;
            } else {
                com.tn.lib.widget.toast.core.h.f50034a.l(getString(R$string.add_img_max_tips, Integer.valueOf(this.f56505f)));
                return;
            }
        }
        if (photoEntity.getEnableSelect()) {
            b0(photoEntity, false);
        } else {
            U(photoEntity);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e0(PhotoEntity photoEntity) {
        if (photoEntity.getEnableSelect()) {
            PhotoEntity photoEntity2 = null;
            int i11 = 0;
            int i12 = 0;
            for (Object obj : this.f56501a) {
                int i13 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.g.u();
                }
                PhotoEntity photoEntity3 = (PhotoEntity) obj;
                if (TextUtils.equals(photoEntity3.getLocalPath(), photoEntity.getLocalPath())) {
                    i12 = i11;
                    photoEntity2 = photoEntity3;
                }
                i11 = i13;
            }
            if (photoEntity2 == null) {
                return;
            }
            TypeIntrinsics.a(this.f56501a).remove(photoEntity2);
            com.transsion.publish.adapter.j0 j0Var = this.f56503c;
            if (j0Var != null) {
                j0Var.c(this.f56501a);
            }
            f0(photoEntity);
            if (this.f56501a.isEmpty()) {
                h0();
                finish();
                return;
            }
            FixedViewPager fixedViewPager = ((ew.c) getMViewBinding()).f64382o;
            Intrinsics.f(fixedViewPager, "mViewBinding.vp");
            if (i12 > fixedViewPager.getChildCount()) {
                ((ew.c) getMViewBinding()).f64382o.setCurrentItem(0, false);
            } else {
                ((ew.c) getMViewBinding()).f64382o.setCurrentItem(i12, false);
            }
            T(i12);
        }
    }

    public final void f0(PhotoEntity photoEntity) {
        PhotoEntity photoEntity2 = null;
        for (PhotoEntity photoEntity3 : this.f56502b) {
            if (TextUtils.equals(photoEntity3.getLocalPath(), photoEntity.getLocalPath())) {
                photoEntity3.setEnableSelect(false);
                photoEntity2 = photoEntity3;
            }
        }
        if (photoEntity2 != null) {
            TypeIntrinsics.a(this.f56502b).remove(photoEntity2);
        }
        h0();
        S();
    }

    public final void g0(PhotoEntity photoEntity) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(photoEntity);
        BigImageBean bigImageBean = new BigImageBean();
        bigImageBean.setFrom(Integer.valueOf(this.f56504d));
        bigImageBean.setSelect(arrayList);
        if (photoEntity.getEnableSelect()) {
            photoEntity.setEnableSelect(false);
            bigImageBean.setOperator(2);
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = BigImageBean.class.getName();
            Intrinsics.f(name, "T::class.java.name");
            flowEventBus.postEvent(name, bigImageBean, 0L);
            return;
        }
        photoEntity.setEnableSelect(true);
        bigImageBean.setOperator(1);
        FlowEventBus flowEventBus2 = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = BigImageBean.class.getName();
        Intrinsics.f(name2, "T::class.java.name");
        flowEventBus2.postEvent(name2, bigImageBean, 0L);
        finish();
    }

    public final void h0() {
        BigImageBean bigImageBean = new BigImageBean();
        bigImageBean.setFrom(Integer.valueOf(this.f56504d));
        bigImageBean.setSelect(this.f56502b);
        bigImageBean.setOperator(1);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = BigImageBean.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, bigImageBean, 0L);
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
        return new com.transsion.baselib.report.h("gallery_page", false, 2, null);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        h0();
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ProgressBar progressBar = ((ew.c) getMViewBinding()).f64374g;
        Intrinsics.f(progressBar, "mViewBinding.clipLoading");
        so.c.g(progressBar);
    }
}
