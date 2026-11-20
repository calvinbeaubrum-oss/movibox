package kotlin.sequences;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.g;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public class SequencesKt___SequencesKt extends e {
    public static <T> Iterable<T> h(Sequence<? extends T> sequence) {
        Intrinsics.g(sequence, "<this>");
        return new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(sequence);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Sequence<T> i(Sequence<? extends T> sequence, int i11) {
        Intrinsics.g(sequence, "<this>");
        if (i11 >= 0) {
            if (i11 == 0) {
                return sequence;
            }
            return sequence instanceof DropTakeSequence ? ((DropTakeSequence) sequence).a(i11) : new DropSequence(sequence, i11);
        }
        throw new IllegalArgumentException(("Requested element count " + i11 + " is less than zero.").toString());
    }

    public static final <T> Sequence<T> j(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.g(sequence, "<this>");
        Intrinsics.g(predicate, "predicate");
        return new FilteringSequence(sequence, true, predicate);
    }

    public static final <T> Sequence<T> k(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.g(sequence, "<this>");
        Intrinsics.g(predicate, "predicate");
        return new FilteringSequence(sequence, false, predicate);
    }

    public static <T> Sequence<T> l(Sequence<? extends T> sequence) {
        Intrinsics.g(sequence, "<this>");
        Sequence<T> sequenceK = k(sequence, new Function1<T, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$filterNotNull$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(T t11) {
                return Boolean.valueOf(t11 == null);
            }
        });
        Intrinsics.e(sequenceK, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return sequenceK;
    }

    public static <T> T m(Sequence<? extends T> sequence) {
        Intrinsics.g(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static final <T, A extends Appendable> A n(Sequence<? extends T> sequence, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i11, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) throws IOException {
        Intrinsics.g(sequence, "<this>");
        Intrinsics.g(buffer, "buffer");
        Intrinsics.g(separator, "separator");
        Intrinsics.g(prefix, "prefix");
        Intrinsics.g(postfix, "postfix");
        Intrinsics.g(truncated, "truncated");
        buffer.append(prefix);
        int i12 = 0;
        for (T t11 : sequence) {
            i12++;
            if (i12 > 1) {
                buffer.append(separator);
            }
            if (i11 >= 0 && i12 > i11) {
                break;
            }
            kotlin.text.e.a(buffer, t11, function1);
        }
        if (i11 >= 0 && i12 > i11) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T> String o(Sequence<? extends T> sequence, CharSequence separator, CharSequence prefix, CharSequence postfix, int i11, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.g(sequence, "<this>");
        Intrinsics.g(separator, "separator");
        Intrinsics.g(prefix, "prefix");
        Intrinsics.g(postfix, "postfix");
        Intrinsics.g(truncated, "truncated");
        String string = ((StringBuilder) n(sequence, new StringBuilder(), separator, prefix, postfix, i11, truncated, function1)).toString();
        Intrinsics.f(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String p(Sequence sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, Function1 function1, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i12 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i12 & 4) == 0 ? charSequence3 : "";
        int i13 = (i12 & 8) != 0 ? -1 : i11;
        if ((i12 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i12 & 32) != 0) {
            function1 = null;
        }
        return o(sequence, charSequence, charSequence5, charSequence6, i13, charSequence7, function1);
    }

    public static <T> T q(Sequence<? extends T> sequence) {
        Intrinsics.g(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static <T, R> Sequence<R> r(Sequence<? extends T> sequence, Function1<? super T, ? extends R> transform) {
        Intrinsics.g(sequence, "<this>");
        Intrinsics.g(transform, "transform");
        return new TransformingSequence(sequence, transform);
    }

    public static <T, R> Sequence<R> s(Sequence<? extends T> sequence, Function1<? super T, ? extends R> transform) {
        Intrinsics.g(sequence, "<this>");
        Intrinsics.g(transform, "transform");
        return l(new TransformingSequence(sequence, transform));
    }

    public static <T> Sequence<T> t(Sequence<? extends T> sequence, Function1<? super T, Boolean> predicate) {
        Intrinsics.g(sequence, "<this>");
        Intrinsics.g(predicate, "predicate");
        return new TakeWhileSequence(sequence, predicate);
    }

    public static final <T, C extends Collection<? super T>> C u(Sequence<? extends T> sequence, C destination) {
        Intrinsics.g(sequence, "<this>");
        Intrinsics.g(destination, "destination");
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static <T> List<T> v(Sequence<? extends T> sequence) {
        Intrinsics.g(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            return g.l();
        }
        T next = it.next();
        if (!it.hasNext()) {
            return kotlin.collections.f.e(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static <T> List<T> w(Sequence<? extends T> sequence) {
        Intrinsics.g(sequence, "<this>");
        return (List) u(sequence, new ArrayList());
    }
}
