package com.bumptech.glide.repackaged.com.google.common.base;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Joiner {
    private final String separator;

    /* JADX INFO: compiled from: source.java */
    public static final class MapJoiner {
        private final Joiner joiner;
        private final String keyValueSeparator;

        private MapJoiner(Joiner joiner, String str) {
            this.joiner = joiner;
            this.keyValueSeparator = (String) Preconditions.checkNotNull(str);
        }

        public <A extends Appendable> A appendTo(A a11, Iterator<? extends Map.Entry<?, ?>> it) throws IOException {
            Preconditions.checkNotNull(a11);
            if (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                a11.append(this.joiner.toString(next.getKey()));
                a11.append(this.keyValueSeparator);
                a11.append(this.joiner.toString(next.getValue()));
                while (it.hasNext()) {
                    a11.append(this.joiner.separator);
                    Map.Entry<?, ?> next2 = it.next();
                    a11.append(this.joiner.toString(next2.getKey()));
                    a11.append(this.keyValueSeparator);
                    a11.append(this.joiner.toString(next2.getValue()));
                }
            }
            return a11;
        }

        public StringBuilder appendTo(StringBuilder sb2, Iterable<? extends Map.Entry<?, ?>> iterable) {
            return appendTo(sb2, iterable.iterator());
        }

        public StringBuilder appendTo(StringBuilder sb2, Iterator<? extends Map.Entry<?, ?>> it) {
            try {
                appendTo(sb2, it);
                return sb2;
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }

        public StringBuilder appendTo(StringBuilder sb2, Map<?, ?> map) {
            return appendTo(sb2, map.entrySet());
        }
    }

    private Joiner(Joiner joiner) {
        this.separator = joiner.separator;
    }

    private Joiner(String str) {
        this.separator = (String) Preconditions.checkNotNull(str);
    }

    public static Joiner on(char c11) {
        return new Joiner(String.valueOf(c11));
    }

    public static Joiner on(String str) {
        return new Joiner(str);
    }

    public <A extends Appendable> A appendTo(A a11, Iterator<?> it) throws IOException {
        Preconditions.checkNotNull(a11);
        if (it.hasNext()) {
            a11.append(toString(it.next()));
            while (it.hasNext()) {
                a11.append(this.separator);
                a11.append(toString(it.next()));
            }
        }
        return a11;
    }

    public final StringBuilder appendTo(StringBuilder sb2, Iterator<?> it) {
        try {
            appendTo(sb2, it);
            return sb2;
        } catch (IOException e11) {
            throw new AssertionError(e11);
        }
    }

    public final String join(Iterable<?> iterable) {
        return join(iterable.iterator());
    }

    public final String join(Iterator<?> it) {
        return appendTo(new StringBuilder(), it).toString();
    }

    public CharSequence toString(Object obj) {
        Preconditions.checkNotNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public Joiner useForNull(final String str) {
        Preconditions.checkNotNull(str);
        return new Joiner(this) { // from class: com.bumptech.glide.repackaged.com.google.common.base.Joiner.1
            @Override // com.bumptech.glide.repackaged.com.google.common.base.Joiner
            public CharSequence toString(Object obj) {
                return obj == null ? str : Joiner.this.toString(obj);
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.base.Joiner
            public Joiner useForNull(String str2) {
                throw new UnsupportedOperationException("already specified useForNull");
            }
        };
    }

    public MapJoiner withKeyValueSeparator(String str) {
        return new MapJoiner(str);
    }
}
