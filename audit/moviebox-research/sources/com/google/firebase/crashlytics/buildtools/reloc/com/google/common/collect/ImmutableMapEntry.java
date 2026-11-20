package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
class ImmutableMapEntry<K, V> extends ImmutableEntry<K, V> {

    /* JADX INFO: compiled from: source.java */
    public static final class NonTerminalImmutableBiMapEntry<K, V> extends NonTerminalImmutableMapEntry<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final transient ImmutableMapEntry<K, V> f39343b;

        public NonTerminalImmutableBiMapEntry(K k11, V v11, ImmutableMapEntry<K, V> immutableMapEntry, ImmutableMapEntry<K, V> immutableMapEntry2) {
            super(k11, v11, immutableMapEntry);
            this.f39343b = immutableMapEntry2;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMapEntry
        public ImmutableMapEntry<K, V> getNextInValueBucket() {
            return this.f39343b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class NonTerminalImmutableMapEntry<K, V> extends ImmutableMapEntry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final transient ImmutableMapEntry<K, V> f39344a;

        public NonTerminalImmutableMapEntry(K k11, V v11, ImmutableMapEntry<K, V> immutableMapEntry) {
            super(k11, v11);
            this.f39344a = immutableMapEntry;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMapEntry
        public final ImmutableMapEntry<K, V> getNextInKeyBucket() {
            return this.f39344a;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMapEntry
        public final boolean isReusable() {
            return false;
        }
    }

    public ImmutableMapEntry(ImmutableMapEntry<K, V> immutableMapEntry) {
        super(immutableMapEntry.getKey(), immutableMapEntry.getValue());
    }

    public ImmutableMapEntry(K k11, V v11) {
        super(k11, v11);
        n1.a(k11, v11);
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
