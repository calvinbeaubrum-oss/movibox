package co;

import android.content.Context;
import com.transsion.baseui.dialog.BaseDialog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f15010a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<BaseDialog> f15011b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, BaseDialog> f15012c = new LinkedHashMap();

    public final void a() {
        f15011b.clear();
        f15012c.clear();
    }

    public final boolean b(BaseDialog dialog, String tag) {
        Intrinsics.g(dialog, "dialog");
        Intrinsics.g(tag, "tag");
        List<BaseDialog> list = f15011b;
        if (list.isEmpty()) {
            list.add(dialog);
            return true;
        }
        f15012c.put(tag, dialog);
        return false;
    }

    public final void c(Context context) {
        String str;
        BaseDialog baseDialogRemove;
        Intrinsics.g(context, "context");
        f15011b.clear();
        Map<String, BaseDialog> map = f15012c;
        if ((!map.isEmpty()) && (baseDialogRemove = map.remove((str = (String) CollectionsKt___CollectionsKt.d0(map.keySet())))) != null && f15010a.b(baseDialogRemove, str)) {
            baseDialogRemove.j0(context, str);
        }
    }
}
