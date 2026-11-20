package androidx.compose.ui.text.platform;

import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.h0;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHashMap<h0, URLSpan> f6035a = new WeakHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakHashMap<AnnotatedString.b<androidx.compose.ui.text.f.b>, URLSpan> f6036b = new WeakHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakHashMap<AnnotatedString.b<androidx.compose.ui.text.f>, i> f6037c = new WeakHashMap<>();

    public final ClickableSpan a(AnnotatedString.b<androidx.compose.ui.text.f> bVar) {
        WeakHashMap<AnnotatedString.b<androidx.compose.ui.text.f>, i> weakHashMap = this.f6037c;
        i iVar = weakHashMap.get(bVar);
        if (iVar == null) {
            iVar = new i(bVar.e());
            weakHashMap.put(bVar, iVar);
        }
        return iVar;
    }

    public final URLSpan b(AnnotatedString.b<androidx.compose.ui.text.f.b> bVar) {
        WeakHashMap<AnnotatedString.b<androidx.compose.ui.text.f.b>, URLSpan> weakHashMap = this.f6036b;
        URLSpan uRLSpan = weakHashMap.get(bVar);
        if (uRLSpan == null) {
            uRLSpan = new URLSpan(bVar.e().c());
            weakHashMap.put(bVar, uRLSpan);
        }
        return uRLSpan;
    }

    public final URLSpan c(h0 h0Var) {
        WeakHashMap<h0, URLSpan> weakHashMap = this.f6035a;
        URLSpan uRLSpan = weakHashMap.get(h0Var);
        if (uRLSpan == null) {
            uRLSpan = new URLSpan(h0Var.a());
            weakHashMap.put(h0Var, uRLSpan);
        }
        return uRLSpan;
    }
}
