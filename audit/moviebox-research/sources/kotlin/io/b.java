package kotlin.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.g;
import kotlin.collections.h;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public class b {
    public static final int a(String str) {
        int iC0;
        char c11 = File.separatorChar;
        int iC1 = StringsKt__StringsKt.c0(str, c11, 0, false, 4, null);
        if (iC1 == 0) {
            if (str.length() <= 1 || str.charAt(1) != c11 || (iC0 = StringsKt__StringsKt.c0(str, c11, 2, false, 4, null)) < 0) {
                return 1;
            }
            int iC2 = StringsKt__StringsKt.c0(str, c11, iC0 + 1, false, 4, null);
            return iC2 >= 0 ? iC2 + 1 : str.length();
        }
        if (iC1 > 0 && str.charAt(iC1 - 1) == ':') {
            return iC1 + 1;
        }
        if (iC1 == -1 && StringsKt__StringsKt.T(str, ':', false, 2, null)) {
            return str.length();
        }
        return 0;
    }

    public static final FilePathComponents b(File file) {
        List listL;
        Intrinsics.g(file, "<this>");
        String path = file.getPath();
        Intrinsics.d(path);
        int iA = a(path);
        String strSubstring = path.substring(0, iA);
        Intrinsics.f(strSubstring, "substring(...)");
        String strSubstring2 = path.substring(iA);
        Intrinsics.f(strSubstring2, "substring(...)");
        if (strSubstring2.length() == 0) {
            listL = g.l();
        } else {
            List listD0 = StringsKt__StringsKt.D0(strSubstring2, new char[]{File.separatorChar}, false, 0, 6, null);
            ArrayList arrayList = new ArrayList(h.v(listD0, 10));
            Iterator it = listD0.iterator();
            while (it.hasNext()) {
                arrayList.add(new File((String) it.next()));
            }
            listL = arrayList;
        }
        return new FilePathComponents(new File(strSubstring), listL);
    }
}
