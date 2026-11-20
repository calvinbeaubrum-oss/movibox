package bs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f14386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f14387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f14388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @StringRes
    public int f14389d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @StringRes
    public int f14390f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<? extends CharSequence> f14391g;

    public c(TextView textView) {
        Intrinsics.g(textView, "textView");
        this.f14386a = textView;
        this.f14387b = "http://schemas.android.com/apk/res/android";
    }

    public final void a(Context context, AttributeSet attributeSet, int i11) {
        Intrinsics.g(context, "context");
        if (attributeSet != null) {
            String attributeValue = attributeSet.getAttributeValue(this.f14387b, MimeTypes.BASE_TYPE_TEXT);
            if (attributeValue != null && attributeValue.length() >= 2) {
                String strSubstring = attributeValue.substring(1, attributeValue.length());
                Intrinsics.f(strSubstring, "substring(...)");
                this.f14389d = b.a(strSubstring);
            }
            String attributeValue2 = attributeSet.getAttributeValue(this.f14387b, "hint");
            if (attributeValue2 == null || attributeValue2.length() < 2) {
                return;
            }
            String strSubstring2 = attributeValue2.substring(1, attributeValue2.length());
            Intrinsics.f(strSubstring2, "substring(...)");
            this.f14390f = b.a(strSubstring2);
        }
    }

    public void b(@StringRes int i11) {
        this.f14390f = i11;
        if (i11 != 0) {
            this.f14386a.setHint(i11);
        }
    }

    public void c(CharSequence charSequence) {
        this.f14390f = 0;
        this.f14386a.setHint(charSequence);
    }

    @Override // bs.a
    public void changeLocal() {
        try {
            int i11 = this.f14389d;
            if (i11 != 0) {
                this.f14386a.setText(i11);
            }
            int i12 = this.f14390f;
            if (i12 != 0) {
                this.f14386a.setHint(i12);
            }
            Function0<? extends CharSequence> function0 = this.f14391g;
            if (function0 != null) {
                this.f14386a.setText(function0 != null ? function0.invoke() : null);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        Function0<Unit> function1 = this.f14388c;
        if (function1 != null) {
            function1.invoke();
        }
    }

    public void d(Function0<Unit> listener) {
        Intrinsics.g(listener, "listener");
        this.f14388c = listener;
    }

    public void e(Function0<? extends CharSequence> function0) {
        this.f14391g = function0;
        this.f14389d = 0;
        this.f14386a.setText(function0 != null ? function0.invoke() : null);
    }

    public void f(@StringRes int i11) {
        this.f14389d = i11;
        if (i11 != 0) {
            this.f14386a.setText(i11);
        }
    }

    public void g(CharSequence charSequence) {
        this.f14391g = null;
        this.f14389d = 0;
        this.f14386a.setText(charSequence);
    }
}
