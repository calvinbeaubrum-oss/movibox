package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ImmutableBiMap extends ImmutableMap implements BiMap {

    /* JADX INFO: compiled from: source.java */
    public static final class Builder<K, V> extends ImmutableMap.Builder<K, V> {
        public ImmutableBiMap build() {
            int i11 = this.size;
            if (i11 == 0) {
                return ImmutableBiMap.of();
            }
            if (i11 == 1) {
                return ImmutableBiMap.of((Object) this.entries[0].getKey(), (Object) this.entries[0].getValue());
            }
            if (this.valueComparator != null) {
                if (this.entriesUsed) {
                    this.entries = (ImmutableMapEntry[]) ObjectArrays.arraysCopyOf(this.entries, i11);
                }
                Arrays.sort(this.entries, 0, this.size, Ordering.from(this.valueComparator).onResultOf(Maps.valueFunction()));
            }
            int i12 = this.size;
            ImmutableMapEntry<K, V>[] immutableMapEntryArr = this.entries;
            this.entriesUsed = i12 == immutableMapEntryArr.length;
            return RegularImmutableBiMap.fromEntryArray(i12, immutableMapEntryArr);
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap.Builder
        public Builder<K, V> put(K k11, V v11) {
            super.put((Object) k11, (Object) v11);
            return this;
        }
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static ImmutableBiMap of() {
        return RegularImmutableBiMap.EMPTY;
    }

    public static ImmutableBiMap of(Object obj, Object obj2) {
        return new SingletonImmutableBiMap(obj, obj2);
    }

    public abstract ImmutableBiMap inverse();

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<Object> values() {
        return inverse().keySet();
    }
}
