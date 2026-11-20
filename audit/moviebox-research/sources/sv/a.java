package sv;

import android.text.Editable;
import com.google.logging.type.LogSeverity;
import com.transsion.postdetail.bean.CommentBean;
import com.transsion.postdetail.comment.a0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f76469a = LogSeverity.NOTICE_VALUE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a0 f76470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Editable f76471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CommentBean f76472d;

    public final a0 a() {
        return this.f76470b;
    }

    public final Editable b() {
        return this.f76471c;
    }

    public final int c() {
        return this.f76469a;
    }

    public final CommentBean d() {
        return this.f76472d;
    }

    public final void e() {
        this.f76472d = null;
        this.f76471c = null;
    }

    public final void f(a0 a0Var) {
        this.f76470b = a0Var;
    }

    public final void g(Editable editable) {
        this.f76471c = editable;
    }

    public final void h(int i11) {
        this.f76469a = i11;
    }

    public final void i(CommentBean commentBean) {
        this.f76472d = commentBean;
    }
}
