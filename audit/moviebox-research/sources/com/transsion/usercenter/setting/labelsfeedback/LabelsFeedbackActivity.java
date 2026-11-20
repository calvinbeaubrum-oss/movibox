package com.transsion.usercenter.setting.labelsfeedback;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.PointerIconCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.KeyboardUtils;
import com.bumptech.glide.Glide;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.ui.SelectImageActivity;
import com.transsion.usercenter.R$color;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.setting.labelsfeedback.model.FBContact;
import com.transsion.usercenter.setting.labelsfeedback.model.FbDataModel;
import com.transsion.usercenter.setting.labelsfeedback.model.FbOption;
import com.transsion.usercenter.setting.labelsfeedback.model.FbOptionList;
import com.transsion.usercenter.setting.labelsfeedback.model.FbTvData;
import com.transsion.usercenter.setting.labelsfeedback.sender.FBSender;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.loginapi.bean.Country;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k0;
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
@Route(path = "/profile/user_center_labels_feedback")
@Metadata
@SourceDebugExtension
public final class LabelsFeedbackActivity extends BaseActivity<xy.d> implements d, i, mz.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f59708f = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FbDataModel f59710b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f59709a = LazyKt__LazyJVMKt.b(new Function0<xy.d>() { // from class: com.transsion.usercenter.setting.labelsfeedback.LabelsFeedbackActivity$d$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final xy.d invoke() {
            return xy.d.c(this.this$0.getLayoutInflater());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f59711c = LazyKt__LazyJVMKt.b(new Function0<h>() { // from class: com.transsion.usercenter.setting.labelsfeedback.LabelsFeedbackActivity$footerAdaptor$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final h invoke() {
            FbDataModel fbDataModel = this.this$0.f59710b;
            if (fbDataModel == null) {
                Intrinsics.y("model");
                fbDataModel = null;
            }
            return new h(fbDataModel, this.this$0);
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f59712d = LazyKt__LazyJVMKt.b(new Function0<c>() { // from class: com.transsion.usercenter.setting.labelsfeedback.LabelsFeedbackActivity$listAdaptor$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c invoke() {
            FbDataModel fbDataModel = this.this$0.f59710b;
            if (fbDataModel == null) {
                Intrinsics.y("model");
                fbDataModel = null;
            }
            c cVar = new c(fbDataModel);
            cVar.i(this.this$0);
            cVar.h(this.this$0);
            return cVar;
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.transsion.usercenter.setting.labelsfeedback.LabelsFeedbackActivity$onCreate$5, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.usercenter.setting.labelsfeedback.LabelsFeedbackActivity$onCreate$5", f = "LabelsFeedbackActivity.kt", l = {111}, m = "invokeSuspend")
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass5(Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LabelsFeedbackActivity.this.new AnonymousClass5(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            try {
                if (i11 == 0) {
                    ResultKt.b(obj);
                    lz.a aVar = (lz.a) NetServiceGenerator.f49399d.a().i(lz.a.class);
                    String strA = cp.a.f62775a.a();
                    this.label = 1;
                    obj = aVar.a(strA, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                FbOptionList fbOptionList = (FbOptionList) ((BaseDto) obj).getData();
                if (fbOptionList != null) {
                    LabelsFeedbackActivity labelsFeedbackActivity = LabelsFeedbackActivity.this;
                    FbDataModel fbDataModel = labelsFeedbackActivity.f59710b;
                    if (fbDataModel == null) {
                        Intrinsics.y("model");
                        fbDataModel = null;
                    }
                    fbDataModel.setOptions(fbOptionList.getLabelList());
                    labelsFeedbackActivity.X().notifyDataSetChanged();
                    FbOption.Companion.d(fbOptionList);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            return Unit.f68710a;
        }
    }

    public static final boolean a0(LabelsFeedbackActivity this$0, View view, MotionEvent motionEvent) {
        Intrinsics.g(this$0, "this$0");
        this$0.Z();
        return false;
    }

    public static final void b0(LabelsFeedbackActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.Z();
        this$0.c0();
    }

    @Override // com.transsion.usercenter.setting.labelsfeedback.d
    public void C(c adaptor) {
        Intrinsics.g(adaptor, "adaptor");
        Z();
        AppCompatButton appCompatButton = V().f80759c;
        FbDataModel fbDataModel = this.f59710b;
        if (fbDataModel == null) {
            Intrinsics.y("model");
            fbDataModel = null;
        }
        appCompatButton.setEnabled(fbDataModel.getCanSubmit());
    }

    public final void T(cw.a aVar) {
        List<PhotoEntity> listH = aVar.h();
        if (listH == null || listH.isEmpty()) {
            return;
        }
        W().h(listH.get(0).getLocalPath());
    }

    public final FbDataModel U(Bundle bundle) {
        FbDataModel fbDataModel;
        if (bundle != null && (fbDataModel = (FbDataModel) bundle.getParcelable("feedback_save_model")) != null) {
            fbDataModel.fillOption(FbOption.Companion.a(this));
            return fbDataModel;
        }
        FbDataModel fbDataModelD = FBSender.f59746a.d();
        if (fbDataModelD != null) {
            fbDataModelD.fillOption(FbOption.Companion.a(this));
            return fbDataModelD;
        }
        String stringExtra = getIntent().getStringExtra("feedback_from_page");
        if (stringExtra == null) {
            stringExtra = "SETTINGS";
        }
        String str = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("subject_id");
        Parcelable parcelableExtra = getIntent().getParcelableExtra("TV_DATA");
        FbDataModel fbDataModel2 = new FbDataModel(parcelableExtra instanceof FbTvData ? (FbTvData) parcelableExtra : null, str, stringExtra2, new FBContact(null, null, 2, null), null, null, null, null, null, null, PointerIconCompat.TYPE_TEXT, null);
        fbDataModel2.fillOption(FbOption.Companion.a(this));
        return fbDataModel2;
    }

    public final xy.d V() {
        return (xy.d) this.f59709a.getValue();
    }

    public final h W() {
        return (h) this.f59711c.getValue();
    }

    public final c X() {
        return (c) this.f59712d.getValue();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public xy.d getViewBinding() {
        xy.d d11 = V();
        Intrinsics.f(d11, "d");
        return d11;
    }

    public final void Z() {
        KeyboardUtils.d(this);
    }

    public final void c0() {
        if (d0() || com.transsion.baseui.util.c.f51452a.a(V().f80759c.getId(), 1000L)) {
            return;
        }
        FbDataModel fbDataModel = this.f59710b;
        FbDataModel fbDataModel2 = null;
        if (fbDataModel == null) {
            Intrinsics.y("model");
            fbDataModel = null;
        }
        Integer tips = fbDataModel.getTips();
        if (tips != null) {
            zp.b.f82110a.d(tips.intValue());
            return;
        }
        zp.b.f82110a.d(R$string.feedback_tips_send);
        FBSender fBSender = FBSender.f59746a;
        FbDataModel fbDataModel3 = this.f59710b;
        if (fbDataModel3 == null) {
            Intrinsics.y("model");
        } else {
            fbDataModel2 = fbDataModel3;
        }
        Application application = getApplication();
        Intrinsics.f(application, "application");
        fBSender.g(fbDataModel2, application);
        finish();
    }

    public final boolean d0() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isChangeStatusBar() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.usercenter.setting.labelsfeedback.i
    public void j(h adaptor) {
        Intrinsics.g(adaptor, "adaptor");
        if (d0()) {
            return;
        }
        SelectImageActivity.f56514r.a(this, 0, 1, null);
    }

    @Override // com.transsion.usercenter.setting.labelsfeedback.i
    public void k(h adaptor) {
        Intrinsics.g(adaptor, "adaptor");
        AppCompatButton appCompatButton = V().f80759c;
        FbDataModel fbDataModel = this.f59710b;
        if (fbDataModel == null) {
            Intrinsics.y("model");
            fbDataModel = null;
        }
        appCompatButton.setEnabled(fbDataModel.getCanSubmit());
    }

    @Override // com.transsion.usercenter.setting.labelsfeedback.i
    public void n(h adaptor, AppCompatImageView imageVIew) {
        Intrinsics.g(adaptor, "adaptor");
        Intrinsics.g(imageVIew, "imageVIew");
        FbDataModel fbDataModel = this.f59710b;
        if (fbDataModel == null) {
            Intrinsics.y("model");
            fbDataModel = null;
        }
        String imagePath = fbDataModel.getImagePath();
        if (imagePath != null) {
            Glide.with((FragmentActivity) this).load2(new File(imagePath)).into(imageVIew);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i11, int i12, Intent intent) {
        Serializable serializableExtra;
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1 && i11 == 100 && intent != null && (serializableExtra = intent.getSerializableExtra("countryCode")) != null && (serializableExtra instanceof Country)) {
            W().g((Country) serializableExtra);
        }
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"ClickableViewAccessibility"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f59710b = U(bundle);
        V().f80760d.setTitleText(R$string.user_setting_feedback);
        RecyclerView recyclerView = V().f80758b;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.setAdapter(new ConcatAdapter(new j(), X(), W()));
        V().f80758b.setOnTouchListener(new View.OnTouchListener() { // from class: com.transsion.usercenter.setting.labelsfeedback.k
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return LabelsFeedbackActivity.a0(this.f59741a, view, motionEvent);
            }
        });
        Function1<cw.a, Unit> function1 = new Function1<cw.a, Unit>() { // from class: com.transsion.usercenter.setting.labelsfeedback.LabelsFeedbackActivity.onCreate.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(cw.a aVar) {
                invoke2(aVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(cw.a it) {
                Intrinsics.g(it, "it");
                Integer numE = it.e();
                if (numE != null && numE.intValue() == 0) {
                    LabelsFeedbackActivity.this.T(it);
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = cw.a.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
        AppCompatButton appCompatButton = V().f80759c;
        FbDataModel fbDataModel = this.f59710b;
        if (fbDataModel == null) {
            Intrinsics.y("model");
            fbDataModel = null;
        }
        appCompatButton.setEnabled(fbDataModel.getCanSubmit());
        V().f80759c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.labelsfeedback.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LabelsFeedbackActivity.b0(this.f59742a, view);
            }
        });
        kotlinx.coroutines.j.d(v.a(this), w0.c(), null, new AnonymousClass5(null), 2, null);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.g(outState, "outState");
        FbDataModel fbDataModel = this.f59710b;
        if (fbDataModel == null) {
            Intrinsics.y("model");
            fbDataModel = null;
        }
        outState.putParcelable("feedback_save_model", fbDataModel);
        super.onSaveInstanceState(outState);
    }

    @Override // com.transsion.usercenter.setting.labelsfeedback.i
    public void s(h adaptor) {
        Intrinsics.g(adaptor, "adaptor");
        Z();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public int statusColor() {
        return R$color.pair_FFFFFF2;
    }

    @Override // com.transsion.usercenter.setting.labelsfeedback.i
    public void w(h adaptor) {
        Intrinsics.g(adaptor, "adaptor");
        com.alibaba.android.arouter.launcher.a.d().b("/loginapi/select_country").navigation(this, 100);
    }
}
