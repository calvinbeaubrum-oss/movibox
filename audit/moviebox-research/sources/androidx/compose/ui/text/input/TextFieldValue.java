package androidx.compose.ui.text.input;

import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SaversKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class TextFieldValue {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f5909d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final androidx.compose.runtime.saveable.d<TextFieldValue, Object> f5910e = SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, TextFieldValue, Object>() { // from class: androidx.compose.ui.text.input.TextFieldValue$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(androidx.compose.runtime.saveable.e eVar, TextFieldValue textFieldValue) {
            return kotlin.collections.g.h(SaversKt.y(textFieldValue.a(), SaversKt.h(), eVar), SaversKt.y(androidx.compose.ui.text.c0.b(textFieldValue.c()), SaversKt.l(androidx.compose.ui.text.c0.f5765b), eVar));
        }
    }, new Function1<Object, TextFieldValue>() { // from class: androidx.compose.ui.text.input.TextFieldValue$Companion$Saver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final TextFieldValue invoke(Object obj) {
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            androidx.compose.runtime.saveable.d<AnnotatedString, Object> dVarH = SaversKt.h();
            Boolean bool = Boolean.FALSE;
            androidx.compose.ui.text.c0 c0VarB = null;
            AnnotatedString annotatedStringB = ((!Intrinsics.b(obj2, bool) || (dVarH instanceof androidx.compose.ui.text.j)) && obj2 != null) ? dVarH.b(obj2) : null;
            Intrinsics.d(annotatedStringB);
            Object obj3 = list.get(1);
            androidx.compose.runtime.saveable.d<androidx.compose.ui.text.c0, Object> dVarL = SaversKt.l(androidx.compose.ui.text.c0.f5765b);
            if ((!Intrinsics.b(obj3, bool) || (dVarL instanceof androidx.compose.ui.text.j)) && obj3 != null) {
                c0VarB = dVarL.b(obj3);
            }
            Intrinsics.d(c0VarB);
            return new TextFieldValue(annotatedStringB, c0VarB.n(), (androidx.compose.ui.text.c0) null, 4, (DefaultConstructorMarker) null);
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnnotatedString f5911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f5912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.compose.ui.text.c0 f5913c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TextFieldValue(AnnotatedString annotatedString, long j11, androidx.compose.ui.text.c0 c0Var) {
        this.f5911a = annotatedString;
        this.f5912b = androidx.compose.ui.text.d0.c(j11, 0, d().length());
        this.f5913c = c0Var != null ? androidx.compose.ui.text.c0.b(androidx.compose.ui.text.d0.c(c0Var.n(), 0, d().length())) : null;
    }

    public /* synthetic */ TextFieldValue(AnnotatedString annotatedString, long j11, androidx.compose.ui.text.c0 c0Var, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, (i11 & 2) != 0 ? androidx.compose.ui.text.c0.f5765b.a() : j11, (i11 & 4) != 0 ? null : c0Var, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ TextFieldValue(AnnotatedString annotatedString, long j11, androidx.compose.ui.text.c0 c0Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, j11, c0Var);
    }

    public TextFieldValue(String str, long j11, androidx.compose.ui.text.c0 c0Var) {
        this(new AnnotatedString(str, null, null, 6, null), j11, c0Var, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ TextFieldValue(String str, long j11, androidx.compose.ui.text.c0 c0Var, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? androidx.compose.ui.text.c0.f5765b.a() : j11, (i11 & 4) != 0 ? null : c0Var, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ TextFieldValue(String str, long j11, androidx.compose.ui.text.c0 c0Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j11, c0Var);
    }

    public final AnnotatedString a() {
        return this.f5911a;
    }

    public final androidx.compose.ui.text.c0 b() {
        return this.f5913c;
    }

    public final long c() {
        return this.f5912b;
    }

    public final String d() {
        return this.f5911a.i();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldValue)) {
            return false;
        }
        TextFieldValue textFieldValue = (TextFieldValue) obj;
        return androidx.compose.ui.text.c0.e(this.f5912b, textFieldValue.f5912b) && Intrinsics.b(this.f5913c, textFieldValue.f5913c) && Intrinsics.b(this.f5911a, textFieldValue.f5911a);
    }

    public int hashCode() {
        int iHashCode = ((this.f5911a.hashCode() * 31) + androidx.compose.ui.text.c0.l(this.f5912b)) * 31;
        androidx.compose.ui.text.c0 c0Var = this.f5913c;
        return iHashCode + (c0Var != null ? androidx.compose.ui.text.c0.l(c0Var.n()) : 0);
    }

    public String toString() {
        return "TextFieldValue(text='" + ((Object) this.f5911a) + "', selection=" + ((Object) androidx.compose.ui.text.c0.m(this.f5912b)) + ", composition=" + this.f5913c + ')';
    }
}
