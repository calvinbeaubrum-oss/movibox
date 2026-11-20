package x1;

import android.util.Log;
import android.util.SparseArray;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.autofill.AutofillType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class h {
    @RequiresApi(26)
    public static final void a(e eVar, SparseArray<AutofillValue> sparseArray) {
        int size = sparseArray.size();
        for (int i11 = 0; i11 < size; i11++) {
            int iKeyAt = sparseArray.keyAt(i11);
            AutofillValue autofillValueA = g.a(sparseArray.get(iKeyAt));
            x xVar = x.f79832a;
            if (xVar.d(autofillValueA)) {
                eVar.b().b(iKeyAt, xVar.i(autofillValueA).toString());
            } else {
                if (xVar.b(autofillValueA)) {
                    throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for date");
                }
                if (xVar.c(autofillValueA)) {
                    throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for list");
                }
                if (xVar.e(autofillValueA)) {
                    throw new NotImplementedError("An operation is not implemented: b/138604541:  Add onFill() callback for toggle");
                }
            }
        }
    }

    @RequiresApi(26)
    public static final void b(e eVar, ViewStructure viewStructure) {
        int iA = n.f79831a.a(viewStructure, eVar.b().a().size());
        for (Map.Entry<Integer, c0> entry : eVar.b().a().entrySet()) {
            int iIntValue = entry.getKey().intValue();
            c0 value = entry.getValue();
            n nVar = n.f79831a;
            ViewStructure viewStructureB = nVar.b(viewStructure, iA);
            if (viewStructureB != null) {
                x xVar = x.f79832a;
                AutofillId autofillIdA = xVar.a(viewStructure);
                Intrinsics.d(autofillIdA);
                xVar.g(viewStructureB, autofillIdA, iIntValue);
                nVar.d(viewStructureB, iIntValue, eVar.c().getContext().getPackageName(), null, null);
                xVar.h(viewStructureB, e0.f79797b.a());
                List<AutofillType> listA = value.a();
                ArrayList arrayList = new ArrayList(listA.size());
                int size = listA.size();
                for (int i11 = 0; i11 < size; i11++) {
                    arrayList.add(f.a(listA.get(i11)));
                }
                xVar.f(viewStructureB, (String[]) arrayList.toArray(new String[0]));
                y1.i iVarB = value.b();
                if (iVarB == null) {
                    Log.w("Autofill Warning", "Bounding box not set.\n                        Did you call perform autofillTree before the component was positioned? ");
                } else {
                    int iRound = Math.round(iVarB.f());
                    int iRound2 = Math.round(iVarB.i());
                    int iRound3 = Math.round(iVarB.g());
                    int iRound4 = Math.round(iVarB.c()) - iRound2;
                    n.f79831a.c(viewStructureB, iRound, iRound2, 0, 0, iRound3 - iRound, iRound4);
                }
            }
            iA++;
        }
    }
}
