package kotlin.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;

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
@JvmName
@SourceDebugExtension
public final class TextStreamsKt {
    public static final long a(Reader reader, Writer out, int i11) throws IOException {
        Intrinsics.g(reader, "<this>");
        Intrinsics.g(out, "out");
        char[] cArr = new char[i11];
        int i12 = reader.read(cArr);
        long j11 = 0;
        while (i12 >= 0) {
            out.write(cArr, 0, i12);
            j11 += (long) i12;
            i12 = reader.read(cArr);
        }
        return j11;
    }

    public static /* synthetic */ long b(Reader reader, Writer writer, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 8192;
        }
        return a(reader, writer, i11);
    }

    public static final void c(Reader reader, Function1<? super String, Unit> action) {
        Intrinsics.g(reader, "<this>");
        Intrinsics.g(action, "action");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            Iterator<String> it = d(bufferedReader).iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            Unit unit = Unit.f68710a;
            CloseableKt.a(bufferedReader, null);
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.a(bufferedReader, th2);
                throw th3;
            }
        }
    }

    public static final Sequence<String> d(BufferedReader bufferedReader) {
        Intrinsics.g(bufferedReader, "<this>");
        return SequencesKt__SequencesKt.d(new LinesSequence(bufferedReader));
    }

    public static final String e(Reader reader) {
        Intrinsics.g(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        b(reader, stringWriter, 0, 2, null);
        String string = stringWriter.toString();
        Intrinsics.f(string, "toString(...)");
        return string;
    }
}
