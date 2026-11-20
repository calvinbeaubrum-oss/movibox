package kotlin.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;

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
public class FilesKt__FileReadWriteKt extends b {
    public static final void c(File file, Charset charset, Function1<? super String, Unit> action) {
        Intrinsics.g(file, "<this>");
        Intrinsics.g(charset, "charset");
        Intrinsics.g(action, "action");
        TextStreamsKt.c(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)), action);
    }

    public static byte[] d(File file) {
        Intrinsics.g(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i11 = (int) length;
            byte[] bArrH = new byte[i11];
            int i12 = i11;
            int i13 = 0;
            while (i12 > 0) {
                int i14 = fileInputStream.read(bArrH, i13, i12);
                if (i14 < 0) {
                    break;
                }
                i12 -= i14;
                i13 += i14;
            }
            if (i12 > 0) {
                bArrH = Arrays.copyOf(bArrH, i13);
                Intrinsics.f(bArrH, "copyOf(...)");
            } else {
                int i15 = fileInputStream.read();
                if (i15 != -1) {
                    a aVar = new a(8193);
                    aVar.write(i15);
                    ByteStreamsKt.b(fileInputStream, aVar, 0, 2, null);
                    int size = aVar.size() + i11;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] bArrA = aVar.a();
                    byte[] bArrCopyOf = Arrays.copyOf(bArrH, size);
                    Intrinsics.f(bArrCopyOf, "copyOf(...)");
                    bArrH = ArraysKt___ArraysJvmKt.h(bArrA, bArrCopyOf, i11, 0, aVar.size());
                }
            }
            CloseableKt.a(fileInputStream, null);
            return bArrH;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.a(fileInputStream, th2);
                throw th3;
            }
        }
    }

    public static final List<String> e(File file, Charset charset) {
        Intrinsics.g(file, "<this>");
        Intrinsics.g(charset, "charset");
        final ArrayList arrayList = new ArrayList();
        c(file, charset, new Function1<String, Unit>() { // from class: kotlin.io.FilesKt__FileReadWriteKt$readLines$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.g(it, "it");
                arrayList.add(it);
            }
        });
        return arrayList;
    }

    public static /* synthetic */ List f(File file, Charset charset, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charset = Charsets.f69091b;
        }
        return e(file, charset);
    }

    public static final String g(File file, Charset charset) {
        Intrinsics.g(file, "<this>");
        Intrinsics.g(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String strE = TextStreamsKt.e(inputStreamReader);
            CloseableKt.a(inputStreamReader, null);
            return strE;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.a(inputStreamReader, th2);
                throw th3;
            }
        }
    }

    public static /* synthetic */ String h(File file, Charset charset, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charset = Charsets.f69091b;
        }
        return g(file, charset);
    }

    public static final void i(File file, byte[] array) {
        Intrinsics.g(file, "<this>");
        Intrinsics.g(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(array);
            Unit unit = Unit.f68710a;
            CloseableKt.a(fileOutputStream, null);
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.a(fileOutputStream, th2);
                throw th3;
            }
        }
    }

    public static final void j(File file, String text, Charset charset) {
        Intrinsics.g(file, "<this>");
        Intrinsics.g(text, "text");
        Intrinsics.g(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        Intrinsics.f(bytes, "getBytes(...)");
        i(file, bytes);
    }

    public static /* synthetic */ void k(File file, String str, Charset charset, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            charset = Charsets.f69091b;
        }
        j(file, str, charset);
    }
}
