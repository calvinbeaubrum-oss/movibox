package x1;

import android.view.View;
import android.view.autofill.AutofillManager;
import androidx.annotation.RequiresApi;
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
@RequiresApi(26)
@Metadata
@SourceDebugExtension
public final class e implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f79794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f79795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AutofillManager f79796c;

    public e(View view, d0 d0Var) {
        this.f79794a = view;
        this.f79795b = d0Var;
        AutofillManager autofillManagerA = c.a(view.getContext().getSystemService(a.a()));
        if (autofillManagerA == null) {
            throw new IllegalStateException("Autofill service could not be located.".toString());
        }
        this.f79796c = autofillManagerA;
        view.setImportantForAutofill(1);
    }

    public final AutofillManager a() {
        return this.f79796c;
    }

    public final d0 b() {
        return this.f79795b;
    }

    public final View c() {
        return this.f79794a;
    }
}
