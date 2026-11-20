package androidx.compose.ui.node;

import androidx.compose.ui.graphics.e4;
import androidx.compose.ui.graphics.g5;
import kotlin.Metadata;

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
public final class u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f5144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f5145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f5146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f5147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f5148g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f5142a = 1.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f5143b = 1.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f5149h = 8.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f5150i = g5.f4145a.a();

    public final void a(e4 e4Var) {
        this.f5142a = e4Var.v();
        this.f5143b = e4Var.E();
        this.f5144c = e4Var.z();
        this.f5145d = e4Var.y();
        this.f5146e = e4Var.B();
        this.f5147f = e4Var.o();
        this.f5148g = e4Var.q();
        this.f5149h = e4Var.s();
        this.f5150i = e4Var.i0();
    }

    public final void b(u uVar) {
        this.f5142a = uVar.f5142a;
        this.f5143b = uVar.f5143b;
        this.f5144c = uVar.f5144c;
        this.f5145d = uVar.f5145d;
        this.f5146e = uVar.f5146e;
        this.f5147f = uVar.f5147f;
        this.f5148g = uVar.f5148g;
        this.f5149h = uVar.f5149h;
        this.f5150i = uVar.f5150i;
    }

    public final boolean c(u uVar) {
        return this.f5142a == uVar.f5142a && this.f5143b == uVar.f5143b && this.f5144c == uVar.f5144c && this.f5145d == uVar.f5145d && this.f5146e == uVar.f5146e && this.f5147f == uVar.f5147f && this.f5148g == uVar.f5148g && this.f5149h == uVar.f5149h && g5.c(this.f5150i, uVar.f5150i);
    }
}
