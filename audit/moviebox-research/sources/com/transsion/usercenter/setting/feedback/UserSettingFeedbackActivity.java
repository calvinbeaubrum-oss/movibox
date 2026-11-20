package com.transsion.usercenter.setting.feedback;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.KeyboardUtils;
import com.bumptech.glide.Glide;
import com.tn.lib.view.TitleLayout;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.ui.SelectImageActivity;
import com.transsion.usercenter.R$color;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.setting.labelsfeedback.model.FbTvData;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.loginapi.bean.Country;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.w0;
import xy.o0;

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
@Route(path = "/profile/user_center_feedback")
@Metadata
@SourceDebugExtension
public final class UserSettingFeedbackActivity extends BaseActivity<o0> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f59693i = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o0 f59694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UserFeedbackViewModel f59695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PhotoEntity f59696c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f59698f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Country f59699g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f59697d = "SETTINGS";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final InputFilter.LengthFilter f59700h = new c();

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
    @SourceDebugExtension
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int length = editable != null ? editable.length() : 0;
            String string = UserSettingFeedbackActivity.this.getString(R$string.user_setting_feedback_max_len, Integer.valueOf(length));
            Intrinsics.f(string, "getString(R.string.user_…ng_feedback_max_len, len)");
            if (length < 500) {
                o0 o0Var = UserSettingFeedbackActivity.this.f59694a;
                AppCompatTextView appCompatTextView = o0Var != null ? o0Var.f80896j : null;
                if (appCompatTextView != null) {
                    appCompatTextView.setText(string);
                }
            } else {
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(z2.a.getColor(UserSettingFeedbackActivity.this, R$color.base_color_FA5546));
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
                spannableStringBuilder.setSpan(foregroundColorSpan, 0, 3, 33);
                o0 o0Var2 = UserSettingFeedbackActivity.this.f59694a;
                AppCompatTextView appCompatTextView2 = o0Var2 != null ? o0Var2.f80896j : null;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setText(spannableStringBuilder);
                }
            }
            o0 o0Var3 = UserSettingFeedbackActivity.this.f59694a;
            AppCompatButton appCompatButton = o0Var3 != null ? o0Var3.f80889b : null;
            if (appCompatButton == null) {
                return;
            }
            appCompatButton.setEnabled(length >= 1);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends InputFilter.LengthFilter {
        public c() {
            super(500);
        }

        @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i11, int i12, Spanned spanned, int i13, int i14) {
            int length;
            if (charSequence != null) {
                try {
                    length = charSequence.length();
                } catch (Exception unused) {
                }
            } else {
                length = 0;
            }
            if (length + (spanned != null ? spanned.length() : 0) > getMax()) {
                zp.b.f82110a.d(R$string.user_setting_feedback_max_len_tips);
            }
            return charSequence;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f59702a;

        public d(Function1 function) {
            Intrinsics.g(function, "function");
            this.f59702a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f59702a;
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
            this.f59702a.invoke(obj);
        }
    }

    public static final /* synthetic */ com.transsion.usercenter.setting.dialog.a U(UserSettingFeedbackActivity userSettingFeedbackActivity) {
        userSettingFeedbackActivity.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X() {
    }

    private final void Z() {
        Function1<cw.a, Unit> function1 = new Function1<cw.a, Unit>() { // from class: com.transsion.usercenter.setting.feedback.UserSettingFeedbackActivity$initListener$1
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
                    this.this$0.f0(it);
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = cw.a.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
    }

    public static final void a0(View view) {
        com.alibaba.android.arouter.launcher.a.d().b("/profile/user_center_labels_feedback").withString("feedback_from_page", "SETTINGS").withParcelable("TV_DATA", new FbTvData("1", 1, 1)).navigation();
    }

    public static final void b0(UserSettingFeedbackActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        KeyboardUtils.d(this$0);
    }

    public static final void c0(UserSettingFeedbackActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        SelectImageActivity.f56514r.a(this$0, 0, 1, null);
    }

    public static final void d0(UserSettingFeedbackActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        com.alibaba.android.arouter.launcher.a.d().b("/loginapi/select_country").navigation(this$0, 100);
    }

    private final void e0() {
        UserFeedbackViewModel userFeedbackViewModel = (UserFeedbackViewModel) new v0(this).a(UserFeedbackViewModel.class);
        userFeedbackViewModel.c().j(this, new d(new Function1<String, Unit>() { // from class: com.transsion.usercenter.setting.feedback.UserSettingFeedbackActivity$initViewModel$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                if (TextUtils.isEmpty(str)) {
                    this.this$0.g0();
                    return;
                }
                UserSettingFeedbackActivity.U(this.this$0);
                zp.b.f82110a.d(R$string.upload_success);
                this.this$0.X();
                this.this$0.finish();
            }
        }));
        this.f59695b = userFeedbackViewModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        o0 o0Var = (o0) getMViewBinding();
        this.f59694a = o0Var;
        if (o0Var != null) {
            AppCompatEditText etDesc = o0Var.f80890c;
            Intrinsics.f(etDesc, "etDesc");
            etDesc.addTextChangedListener(new b());
            InputFilter[] filters = o0Var.f80890c.getFilters();
            Intrinsics.f(filters, "etDesc.filters");
            List listD0 = kotlin.collections.d.D0(filters);
            listD0.add(0, this.f59700h);
            o0Var.f80890c.setFilters((InputFilter[]) listD0.toArray(new InputFilter[0]));
            TitleLayout titleLayout = o0Var.f80895i;
            String string = getString(R$string.user_setting_feedback);
            Intrinsics.f(string, "getString(R.string.user_setting_feedback)");
            titleLayout.setTitleText(string);
            o0Var.f80889b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.feedback.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserSettingFeedbackActivity.a0(view);
                }
            });
            o0Var.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.feedback.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserSettingFeedbackActivity.b0(this.f59705a, view);
                }
            });
            o0Var.f80892f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.feedback.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserSettingFeedbackActivity.c0(this.f59706a, view);
                }
            });
            o0Var.f80897k.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.feedback.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserSettingFeedbackActivity.d0(this.f59707a, view);
                }
            });
        }
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public o0 getViewBinding() {
        o0 o0VarC = o0.c(getLayoutInflater());
        Intrinsics.f(o0VarC, "inflate(layoutInflater)");
        return o0VarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f0(cw.a aVar) {
        String localPath;
        List<PhotoEntity> listH = aVar.h();
        if (listH == null || !(!listH.isEmpty())) {
            return;
        }
        this.f59696c = listH.get(0);
        o0 o0Var = (o0) getMViewBinding();
        AppCompatImageView ivAddImage = o0Var.f80893g;
        Intrinsics.f(ivAddImage, "ivAddImage");
        so.c.g(ivAddImage);
        PhotoEntity photoEntity = this.f59696c;
        if (photoEntity == null || (localPath = photoEntity.getLocalPath()) == null) {
            return;
        }
        Glide.with((FragmentActivity) this).load2(new File(localPath)).into(o0Var.f80892f);
    }

    public final void g0() {
        X();
        zp.b.f82110a.d(R$string.upload_failed);
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i11, int i12, Intent intent) {
        Serializable serializableExtra;
        super.onActivityResult(i11, i12, intent);
        if (i11 == 100 && i12 == -1 && intent != null && (serializableExtra = intent.getSerializableExtra("countryCode")) != null && (serializableExtra instanceof Country)) {
            Country country = (Country) serializableExtra;
            this.f59699g = country;
            ((o0) getMViewBinding()).f80897k.setText(country.getCountry_s() + " + " + country.getCode());
        }
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("feedback_from_page");
        if (stringExtra == null) {
            stringExtra = "SETTINGS";
        }
        this.f59697d = stringExtra;
        this.f59698f = getIntent().getStringExtra("subject_id");
        initView();
        e0();
        Z();
    }
}
