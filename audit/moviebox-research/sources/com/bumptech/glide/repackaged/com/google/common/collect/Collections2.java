package com.bumptech.glide.repackaged.com.google.common.collect;

import com.bumptech.glide.repackaged.com.google.common.base.Joiner;
import java.util.Collection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Collections2 {
    static final Joiner STANDARD_JOINER = Joiner.on(", ").useForNull("null");

    public static <T> Collection<T> cast(Iterable<T> iterable) {
        return (Collection) iterable;
    }

    public static StringBuilder newStringBuilderForCollection(int i11) {
        CollectPreconditions.checkNonnegative(i11, "size");
        return new StringBuilder((int) Math.min(((long) i11) * 8, 1073741824L));
    }
}
