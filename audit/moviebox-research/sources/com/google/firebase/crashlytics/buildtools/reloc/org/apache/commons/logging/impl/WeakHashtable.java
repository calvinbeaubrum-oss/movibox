package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.impl;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class WeakHashtable extends Hashtable {
    private static final int MAX_CHANGES_BEFORE_PURGE = 100;
    private static final int PARTIAL_PURGE_COUNT = 10;
    private static final long serialVersionUID = -1546036869799732453L;
    private final ReferenceQueue queue = new ReferenceQueue();
    private int changeCount = 0;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements Map.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f40083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f40084b;

        public a(Object obj, Object obj2) {
            this.f40083a = obj;
            this.f40084b = obj2;
        }

        public /* synthetic */ a(Object obj, Object obj2, com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.impl.b bVar) {
            this(obj, obj2);
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (getKey() == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!getKey().equals(entry.getKey())) {
                return false;
            }
            if (getValue() == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!getValue().equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f40083a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f40084b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("Entry.setValue is not supported.");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference f40085a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f40086b;

        public b(Object obj) {
            this.f40085a = new WeakReference(obj);
            this.f40086b = obj.hashCode();
        }

        public /* synthetic */ b(Object obj, com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.impl.b bVar) {
            this(obj);
        }

        public b(Object obj, ReferenceQueue referenceQueue) {
            this.f40085a = new c(obj, referenceQueue, this, null);
            this.f40086b = obj.hashCode();
        }

        public /* synthetic */ b(Object obj, ReferenceQueue referenceQueue, com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.impl.b bVar) {
            this(obj, referenceQueue);
        }

        public final Object b() {
            return this.f40085a.get();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            Object objB = b();
            Object objB2 = bVar.b();
            if (objB == null) {
                return objB2 == null && hashCode() == bVar.hashCode();
            }
            return objB.equals(objB2);
        }

        public int hashCode() {
            return this.f40086b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends WeakReference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f40087a;

        public c(Object obj, ReferenceQueue referenceQueue, b bVar) {
            super(obj, referenceQueue);
            this.f40087a = bVar;
        }

        public /* synthetic */ c(Object obj, ReferenceQueue referenceQueue, b bVar, com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.impl.b bVar2) {
            this(obj, referenceQueue, bVar);
        }

        public final b b() {
            return this.f40087a;
        }
    }

    private void purge() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.queue) {
            while (true) {
                try {
                    c cVar = (c) this.queue.poll();
                    if (cVar == null) {
                        break;
                    } else {
                        arrayList.add(cVar.b());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            super.remove(arrayList.get(i11));
        }
    }

    private void purgeOne() {
        synchronized (this.queue) {
            try {
                c cVar = (c) this.queue.poll();
                if (cVar != null) {
                    super.remove(cVar.b());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // java.util.Hashtable, java.util.Map
    public boolean containsKey(Object obj) {
        return super.containsKey(new b(obj, (com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.impl.b) null));
    }

    @Override // java.util.Hashtable, java.util.Dictionary
    public Enumeration elements() {
        purge();
        return super.elements();
    }

    @Override // java.util.Hashtable, java.util.Map
    public Set entrySet() {
        purge();
        Set<Map.Entry> setEntrySet = super.entrySet();
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : setEntrySet) {
            Object objB = ((b) entry.getKey()).b();
            Object value = entry.getValue();
            if (objB != null) {
                hashSet.add(new a(objB, value, null));
            }
        }
        return hashSet;
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public Object get(Object obj) {
        return super.get(new b(obj, (com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.impl.b) null));
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public boolean isEmpty() {
        purge();
        return super.isEmpty();
    }

    @Override // java.util.Hashtable, java.util.Map
    public Set keySet() {
        purge();
        Set setKeySet = super.keySet();
        HashSet hashSet = new HashSet();
        Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            Object objB = ((b) it.next()).b();
            if (objB != null) {
                hashSet.add(objB);
            }
        }
        return hashSet;
    }

    @Override // java.util.Hashtable, java.util.Dictionary
    public Enumeration keys() {
        purge();
        return new com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.impl.b(this, super.keys());
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public synchronized Object put(Object obj, Object obj2) {
        try {
            if (obj == null) {
                throw new NullPointerException("Null keys are not allowed");
            }
            if (obj2 == null) {
                throw new NullPointerException("Null values are not allowed");
            }
            int i11 = this.changeCount;
            int i12 = i11 + 1;
            this.changeCount = i12;
            if (i11 > 100) {
                purge();
                this.changeCount = 0;
            } else if (i12 % 10 == 0) {
                purgeOne();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return super.put(new b(obj, this.queue, null), obj2);
    }

    @Override // java.util.Hashtable, java.util.Map
    public void putAll(Map map) {
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // java.util.Hashtable
    public void rehash() {
        purge();
        super.rehash();
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public synchronized Object remove(Object obj) {
        try {
            int i11 = this.changeCount;
            int i12 = i11 + 1;
            this.changeCount = i12;
            if (i11 > 100) {
                purge();
                this.changeCount = 0;
            } else if (i12 % 10 == 0) {
                purgeOne();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return super.remove(new b(obj, (com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.impl.b) null));
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public int size() {
        purge();
        return super.size();
    }

    @Override // java.util.Hashtable
    public String toString() {
        purge();
        return super.toString();
    }

    @Override // java.util.Hashtable, java.util.Map
    public Collection values() {
        purge();
        return super.values();
    }
}
