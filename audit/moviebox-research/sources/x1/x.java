package x1;

import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import androidx.annotation.RequiresApi;
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
@RequiresApi(26)
@Metadata
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f79832a = new x();

    @RequiresApi(26)
    public final AutofillId a(ViewStructure viewStructure) {
        return viewStructure.getAutofillId();
    }

    @RequiresApi(26)
    public final boolean b(AutofillValue autofillValue) {
        return autofillValue.isDate();
    }

    @RequiresApi(26)
    public final boolean c(AutofillValue autofillValue) {
        return autofillValue.isList();
    }

    @RequiresApi(26)
    public final boolean d(AutofillValue autofillValue) {
        return autofillValue.isText();
    }

    @RequiresApi(26)
    public final boolean e(AutofillValue autofillValue) {
        return autofillValue.isToggle();
    }

    @RequiresApi(26)
    public final void f(ViewStructure viewStructure, String[] strArr) {
        viewStructure.setAutofillHints(strArr);
    }

    @RequiresApi(26)
    public final void g(ViewStructure viewStructure, AutofillId autofillId, int i11) {
        viewStructure.setAutofillId(autofillId, i11);
    }

    @RequiresApi(26)
    public final void h(ViewStructure viewStructure, int i11) {
        viewStructure.setAutofillType(i11);
    }

    @RequiresApi(26)
    public final CharSequence i(AutofillValue autofillValue) {
        return autofillValue.getTextValue();
    }
}
