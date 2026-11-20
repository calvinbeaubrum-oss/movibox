package com.bumptech.glide.repackaged.com.google.common.collect;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class ImmutableMapEntry<K, V> extends ImmutableEntry<K, V> {

    /* JADX INFO: compiled from: source.java */
    public static final class NonTerminalImmutableBiMapEntry<K, V> extends NonTerminalImmutableMapEntry<K, V> {
        private final transient ImmutableMapEntry<K, V> nextInValueBucket;

        public NonTerminalImmutableBiMapEntry(K k11, V v11, ImmutableMapEntry<K, V> immutableMapEntry, ImmutableMapEntry<K, V> immutableMapEntry2) {
            super(k11, v11, immutableMapEntry);
            this.nextInValueBucket = immutableMapEntry2;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMapEntry
        public ImmutableMapEntry<K, V> getNextInValueBucket() {
            return this.nextInValueBucket;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class NonTerminalImmutableMapEntry<K, V> extends ImmutableMapEntry<K, V> {
        private final transient ImmutableMapEntry<K, V> nextInKeyBucket;

        public NonTerminalImmutableMapEntry(K k11, V v11, ImmutableMapEntry<K, V> immutableMapEntry) {
            super(k11, v11);
            this.nextInKeyBucket = immutableMapEntry;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMapEntry
        public final ImmutableMapEntry<K, V> getNextInKeyBucket() {
            return this.nextInKeyBucket;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMapEntry
        public final boolean isReusable() {
            return false;
        }
    }

    public ImmutableMapEntry(K k11, V v11) {
        super(k11, v11);
        CollectPreconditions.checkEntryNotNull(k11, v11);
    }

    public static <K, V> ImmutableMapEntry<K, V>[] createEntryArray(int i11) {
        return new ImmutableMapEntry[i11];
    }

    public ImmutableMapEntry<K, V> getNextInKeyBucket() {
        return null;
    }

    public ImmutableMapEntry<K, V> getNextInValueBucket() {
        return null;
    }

    public boolean isReusable() {
        return true;
    }
}
