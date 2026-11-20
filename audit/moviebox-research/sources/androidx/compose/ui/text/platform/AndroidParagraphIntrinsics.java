package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import androidx.compose.runtime.a3;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.e0;
import androidx.compose.ui.text.font.o0;
import androidx.compose.ui.text.font.u;
import androidx.compose.ui.text.t;
import androidx.compose.ui.text.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import m2.i0;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AndroidParagraphIntrinsics implements androidx.compose.ui.text.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e0 f6000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<AnnotatedString.b<y>> f6001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<AnnotatedString.b<t>> f6002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.compose.ui.text.font.i.b f6003e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q2.e f6004f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AndroidTextPaint f6005g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CharSequence f6006h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i0 f6007i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public r f6008j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f6009k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f6010l;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.util.List, java.util.List<androidx.compose.ui.text.AnnotatedString$b<androidx.compose.ui.text.y>>] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List] */
    public AndroidParagraphIntrinsics(String str, e0 e0Var, List<AnnotatedString.b<y>> list, List<AnnotatedString.b<t>> list2, androidx.compose.ui.text.font.i.b bVar, q2.e eVar) {
        this.f5999a = str;
        this.f6000b = e0Var;
        this.f6001c = list;
        this.f6002d = list2;
        this.f6003e = bVar;
        this.f6004f = eVar;
        AndroidTextPaint androidTextPaint = new AndroidTextPaint(1, eVar.getDensity());
        this.f6005g = androidTextPaint;
        this.f6009k = !d.c(e0Var) ? false : l.f6027a.a().getValue().booleanValue();
        this.f6010l = d.d(e0Var.B(), e0Var.u());
        Function4<androidx.compose.ui.text.font.i, u, androidx.compose.ui.text.font.q, androidx.compose.ui.text.font.r, Typeface> function4 = new Function4<androidx.compose.ui.text.font.i, u, androidx.compose.ui.text.font.q, androidx.compose.ui.text.font.r, Typeface>() { // from class: androidx.compose.ui.text.platform.AndroidParagraphIntrinsics$resolveTypeface$1
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Typeface invoke(androidx.compose.ui.text.font.i iVar, u uVar, androidx.compose.ui.text.font.q qVar, androidx.compose.ui.text.font.r rVar) {
                return m90invokeDPcqOEQ(iVar, uVar, qVar.i(), rVar.j());
            }

            /* JADX INFO: renamed from: invoke-DPcqOEQ, reason: not valid java name */
            public final Typeface m90invokeDPcqOEQ(androidx.compose.ui.text.font.i iVar, u uVar, int i11, int i12) {
                a3<Object> a3VarA = this.this$0.g().a(iVar, uVar, i11, i12);
                if (a3VarA instanceof o0.b) {
                    Object value = a3VarA.getValue();
                    Intrinsics.e(value, "null cannot be cast to non-null type android.graphics.Typeface");
                    return (Typeface) value;
                }
                r rVar = new r(a3VarA, this.this$0.f6008j);
                this.this$0.f6008j = rVar;
                return rVar.a();
            }
        };
        androidx.compose.ui.text.platform.extensions.f.e(androidTextPaint, e0Var.E());
        y yVarA = androidx.compose.ui.text.platform.extensions.f.a(androidTextPaint, e0Var.M(), function4, eVar, !((Collection) list).isEmpty());
        if (yVarA != null) {
            int size = list.size() + 1;
            list = new ArrayList<>(size);
            int i11 = 0;
            while (i11 < size) {
                list.add(i11 == 0 ? new AnnotatedString.b<>(yVarA, 0, this.f5999a.length()) : this.f6001c.get(i11 - 1));
                i11++;
            }
        }
        CharSequence charSequenceA = c.a(this.f5999a, this.f6005g.getTextSize(), this.f6000b, list, this.f6002d, this.f6004f, function4, this.f6009k);
        this.f6006h = charSequenceA;
        this.f6007i = new i0(charSequenceA, this.f6005g, this.f6010l);
    }

    @Override // androidx.compose.ui.text.o
    public float a() {
        return this.f6007i.b();
    }

    @Override // androidx.compose.ui.text.o
    public boolean b() {
        r rVar = this.f6008j;
        return (rVar != null && rVar.b()) || (!this.f6009k && d.c(this.f6000b) && l.f6027a.a().getValue().booleanValue());
    }

    @Override // androidx.compose.ui.text.o
    public float c() {
        return this.f6007i.c();
    }

    public final CharSequence f() {
        return this.f6006h;
    }

    public final androidx.compose.ui.text.font.i.b g() {
        return this.f6003e;
    }

    public final i0 h() {
        return this.f6007i;
    }

    public final e0 i() {
        return this.f6000b;
    }

    public final int j() {
        return this.f6010l;
    }

    public final AndroidTextPaint k() {
        return this.f6005g;
    }
}
