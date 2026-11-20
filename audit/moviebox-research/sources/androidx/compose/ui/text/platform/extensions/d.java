package androidx.compose.ui.text.platform.extensions;

import androidx.annotation.RequiresApi;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.h;
import kotlin.jvm.internal.SourceDebugExtension;
import p2.i;

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
@RequiresApi(24)
@Metadata
@SourceDebugExtension
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f6020a = new d();

    @RequiresApi(24)
    public final Object a(i iVar) {
        ArrayList arrayList = new ArrayList(h.v(iVar, 10));
        Iterator<p2.h> it = iVar.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a());
        }
        Locale[] localeArr = (Locale[]) arrayList.toArray(new Locale[0]);
        return c.a(b.a((Locale[]) Arrays.copyOf(localeArr, localeArr.length)));
    }

    @RequiresApi(24)
    public final void b(AndroidTextPaint androidTextPaint, i iVar) {
        ArrayList arrayList = new ArrayList(h.v(iVar, 10));
        Iterator<p2.h> it = iVar.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a());
        }
        Locale[] localeArr = (Locale[]) arrayList.toArray(new Locale[0]);
        androidTextPaint.setTextLocales(b.a((Locale[]) Arrays.copyOf(localeArr, localeArr.length)));
    }
}
