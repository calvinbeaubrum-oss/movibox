package xb;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class d {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<View, Unit> f80472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Integer f80473b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f80474c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super View, Unit> function1, Integer num, boolean z11) {
            this.f80472a = function1;
            this.f80473b = num;
            this.f80474c = z11;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Intrinsics.g(widget, "widget");
            this.f80472a.invoke(widget);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds2) {
            Intrinsics.g(ds2, "ds");
            Integer num = this.f80473b;
            ds2.setColor(num != null ? num.intValue() : ds2.linkColor);
            ds2.setUnderlineText(this.f80474c);
        }
    }

    public static final ClickableSpan a(Integer num, boolean z11, Function1<? super View, Unit> onClick) {
        Intrinsics.g(onClick, "onClick");
        return new a(onClick, num, z11);
    }

    public static final SpannableStringBuilder b(SpannableStringBuilder spannableStringBuilder, CharSequence charSequence, Integer num, boolean z11, Function1<? super View, Unit> onClick) {
        Intrinsics.g(spannableStringBuilder, "<this>");
        Intrinsics.g(onClick, "onClick");
        ClickableSpan clickableSpanA = a(num, z11, onClick);
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append(charSequence);
        spannableStringBuilder.setSpan(clickableSpanA, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }
}
