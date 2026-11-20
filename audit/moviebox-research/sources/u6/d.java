package u6;

import android.os.Build;
import androidx.work.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import s6.i;
import s6.o;
import s6.u;
import s6.x;
import s6.z;

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
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f78488a;

    static {
        String strI = j.i("DiagnosticsWrkr");
        Intrinsics.f(strI, "tagWithPrefix(\"DiagnosticsWrkr\")");
        f78488a = strI;
    }

    public static final String c(u uVar, String str, Integer num, String str2) {
        return '\n' + uVar.f76199a + "\t " + uVar.f76201c + "\t " + num + "\t " + uVar.f76200b.name() + "\t " + str + "\t " + str2 + '\t';
    }

    public static final String d(o oVar, z zVar, s6.j jVar, List<u> list) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\n Id \t Class Name\t " + (Build.VERSION.SDK_INT >= 23 ? "Job Id" : "Alarm Id") + "\t State\t Unique Name\t Tags\t");
        for (u uVar : list) {
            i iVarE = jVar.e(x.a(uVar));
            sb2.append(c(uVar, CollectionsKt___CollectionsKt.o0(oVar.a(uVar.f76199a), ",", null, null, 0, null, null, 62, null), iVarE != null ? Integer.valueOf(iVarE.f76172c) : null, CollectionsKt___CollectionsKt.o0(zVar.b(uVar.f76199a), ",", null, null, 0, null, null, 62, null)));
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
