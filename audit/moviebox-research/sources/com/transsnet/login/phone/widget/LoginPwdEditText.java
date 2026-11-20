package com.transsnet.login.phone.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import com.transsnet.login.R$string;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class LoginPwdEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function2<? super Boolean, ? super String, Unit> f61669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Pattern f61670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Pattern f61671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Pattern f61672d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            LoginPwdEditText.this.a(editable != null ? editable.toString() : null);
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
    public static final class b extends InputFilter.LengthFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoginPwdEditText f61674a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Ref.IntRef intRef, LoginPwdEditText loginPwdEditText) {
            super(intRef.element);
            this.f61674a = loginPwdEditText;
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
                this.f61674a.e();
            }
            return charSequence;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginPwdEditText(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f61670b = Pattern.compile("^[0-9a-zA-Z]*$");
        this.f61671c = Pattern.compile("^[0-9a-zA-Z]{6,18}$");
        this.f61672d = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,18}$");
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginPwdEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        this.f61670b = Pattern.compile("^[0-9a-zA-Z]*$");
        this.f61671c = Pattern.compile("^[0-9a-zA-Z]{6,18}$");
        this.f61672d = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,18}$");
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginPwdEditText(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f61670b = Pattern.compile("^[0-9a-zA-Z]*$");
        this.f61671c = Pattern.compile("^[0-9a-zA-Z]{6,18}$");
        this.f61672d = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,18}$");
        c();
    }

    private final boolean b() {
        Editable text = getText();
        if (text != null) {
            return this.f61670b.matcher(text).matches();
        }
        return false;
    }

    private final void c() {
        g();
        addTextChangedListener(new a());
        setTransformationMethod(new p00.a());
    }

    public final void a(String str) {
        if (str == null) {
            return;
        }
        if (!b()) {
            f();
        } else if (str.length() > 18) {
            e();
        } else {
            d();
        }
    }

    public final void d() {
        enableStatusChange(true, null);
    }

    public final void e() {
        enableStatusChange(false, getContext().getString(R$string.login_pwd_max_len_tips));
    }

    public final void enableStatusChange(boolean z11, String str) {
        Function2<? super Boolean, ? super String, Unit> function2 = this.f61669a;
        if (function2 != null) {
            function2.invoke(Boolean.valueOf(z11), str);
        }
    }

    public final void f() {
        enableStatusChange(false, getContext().getString(R$string.login_pwd_rule));
    }

    public final void g() {
        InputFilter[] filters = getFilters();
        Intrinsics.f(filters, "filters");
        List<InputFilter> listD0 = d.D0(filters);
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 18;
        for (InputFilter inputFilter : listD0) {
            if (inputFilter instanceof InputFilter.LengthFilter) {
                intRef.element = ((InputFilter.LengthFilter) inputFilter).getMax();
                break;
            }
        }
        listD0.add(0, new b(intRef, this));
        setFilters((InputFilter[]) listD0.toArray(new InputFilter[0]));
    }

    public final Function2<Boolean, String, Unit> getMListener() {
        return this.f61669a;
    }

    public final boolean isCanClickNext() {
        Editable text = getText();
        if (text != null) {
            return this.f61671c.matcher(text).matches();
        }
        return false;
    }

    public final boolean isCharNumRuleLength() {
        Editable text = getText();
        if (text != null) {
            return this.f61672d.matcher(text).matches();
        }
        return false;
    }

    public final void setEnableStatusChangeListener(Function2<? super Boolean, ? super String, Unit> listener) {
        Intrinsics.g(listener, "listener");
        this.f61669a = listener;
    }

    public final void setMListener(Function2<? super Boolean, ? super String, Unit> function2) {
        this.f61669a = function2;
    }
}
