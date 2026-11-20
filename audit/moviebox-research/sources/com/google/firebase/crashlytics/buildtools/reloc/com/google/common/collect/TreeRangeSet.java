package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class TreeRangeSet<C extends Comparable<?>> extends v<C> implements Serializable {
    private transient Set<Range<C>> asDescendingSetOfRanges;
    private transient Set<Range<C>> asRanges;
    private transient v6<C> complement;
    final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;

    /* JADX INFO: compiled from: source.java */
    public final class Complement extends TreeRangeSet<C> {
        public Complement() {
            super(new c(TreeRangeSet.this.rangesByLowerBound));
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TreeRangeSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
        public void add(Range<C> range) {
            TreeRangeSet.this.remove(range);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TreeRangeSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
        public /* bridge */ /* synthetic */ void addAll(Iterable iterable) {
            u6.a(this, iterable);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TreeRangeSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
        public v6<C> complement() {
            return TreeRangeSet.this;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TreeRangeSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
        public boolean contains(C c11) {
            return !TreeRangeSet.this.contains(c11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TreeRangeSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
        public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
            return u6.b(this, iterable);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TreeRangeSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
        public void remove(Range<C> range) {
            TreeRangeSet.this.add(range);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TreeRangeSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
        public /* bridge */ /* synthetic */ void removeAll(Iterable iterable) {
            u6.c(this, iterable);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class SubRangeSet extends TreeRangeSet<C> {
        private final Range<C> restriction;

        /* JADX WARN: Illegal instructions before constructor call */
        public SubRangeSet(Range<C> range) {
            super(new e(Range.all(), range, TreeRangeSet.this.rangesByLowerBound));
            this.restriction = range;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TreeRangeSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
        public void add(Range<C> range) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.k(this.restriction.encloses(range), "Cannot add range %s to subRangeSet(%s)", range, this.restriction);
            super.add(range);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TreeRangeSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
        public /* bridge */ /* synthetic */ void addAll(Iterable iterable) {
            u6.a(this, iterable);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TreeRangeSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
        public void clear() {
            TreeRangeSet.this.remove(this.restriction);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TreeRangeSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
        public boolean contains(C c11) {
            return this.restriction.contains(c11) && TreeRangeSet.this.contains(c11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TreeRangeSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
        public boolean encloses(Range<C> range) {
            Range rangeRangeEnclosing;
            return (this.restriction.isEmpty() || !this.restriction.encloses(range) || (rangeRangeEnclosing = TreeRangeSet.this.rangeEnclosing(range)) == null || rangeRangeEnclosing.intersection(this.restriction).isEmpty()) ? false : true;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TreeRangeSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
        public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
            return u6.b(this, iterable);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TreeRangeSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
        public Range<C> rangeContaining(C c11) {
            Range<C> rangeRangeContaining;
            if (this.restriction.contains(c11) && (rangeRangeContaining = TreeRangeSet.this.rangeContaining(c11)) != null) {
                return rangeRangeContaining.intersection(this.restriction);
            }
            return null;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TreeRangeSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
        public void remove(Range<C> range) {
            if (range.isConnected(this.restriction)) {
                TreeRangeSet.this.remove(range.intersection(this.restriction));
            }
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TreeRangeSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
        public /* bridge */ /* synthetic */ void removeAll(Iterable iterable) {
            u6.c(this, iterable);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.TreeRangeSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
        public v6<C> subRangeSet(Range<C> range) {
            if (range.encloses(this.restriction)) {
                return this;
            }
            return range.isConnected(this.restriction) ? new SubRangeSet(this.restriction.intersection(range)) : ImmutableRangeSet.of();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class b extends n2<Range<C>> implements Set<Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Collection<Range<C>> f39638a;

        public b(Collection<Range<C>> collection) {
            this.f39638a = collection;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
        public Collection<Range<C>> delegate() {
            return this.f39638a;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return Sets.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.b(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c<C extends Comparable<?>> extends u<Cut<C>, Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f39640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f39641b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Range<Cut<C>> f39642c;

        /* JADX INFO: compiled from: source.java */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Cut<C> f39643c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Cut f39644d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ q6 f39645f;

            public a(Cut cut, q6 q6Var) {
                this.f39644d = cut;
                this.f39645f = q6Var;
                this.f39643c = cut;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<Cut<C>, Range<C>> a() {
                Range rangeCreate;
                if (c.this.f39642c.upperBound.isLessThan(this.f39643c) || this.f39643c == Cut.aboveAll()) {
                    return (Map.Entry) b();
                }
                if (this.f39645f.hasNext()) {
                    Range range = (Range) this.f39645f.next();
                    rangeCreate = Range.create(this.f39643c, range.lowerBound);
                    this.f39643c = range.upperBound;
                } else {
                    rangeCreate = Range.create(this.f39643c, Cut.aboveAll());
                    this.f39643c = Cut.aboveAll();
                }
                return Maps.g(rangeCreate.lowerBound, rangeCreate);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Cut<C> f39647c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Cut f39648d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ q6 f39649f;

            public b(Cut cut, q6 q6Var) {
                this.f39648d = cut;
                this.f39649f = q6Var;
                this.f39647c = cut;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (this.f39647c == Cut.belowAll()) {
                    return (Map.Entry) b();
                }
                if (this.f39649f.hasNext()) {
                    Range range = (Range) this.f39649f.next();
                    Range rangeCreate = Range.create(range.upperBound, this.f39647c);
                    this.f39647c = range.lowerBound;
                    if (c.this.f39642c.lowerBound.isLessThan(rangeCreate.lowerBound)) {
                        return Maps.g(rangeCreate.lowerBound, rangeCreate);
                    }
                } else if (c.this.f39642c.lowerBound.isLessThan(Cut.belowAll())) {
                    Range rangeCreate2 = Range.create(Cut.belowAll(), this.f39647c);
                    this.f39647c = Cut.belowAll();
                    return Maps.g(Cut.belowAll(), rangeCreate2);
                }
                return (Map.Entry) b();
            }
        }

        public c(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this(navigableMap, Range.all());
        }

        public c(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.f39640a = navigableMap;
            this.f39641b = new d(navigableMap);
            this.f39642c = range;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.u
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            Cut<C> cutHigherKey;
            q6 q6VarR = Iterators.r(this.f39641b.headMap(this.f39642c.hasUpperBound() ? (Cut) this.f39642c.upperEndpoint() : Cut.aboveAll(), this.f39642c.hasUpperBound() && this.f39642c.upperBoundType() == BoundType.CLOSED).descendingMap().values().iterator());
            if (q6VarR.hasNext()) {
                cutHigherKey = ((Range) q6VarR.peek()).upperBound == Cut.aboveAll() ? ((Range) q6VarR.next()).lowerBound : this.f39640a.higherKey(((Range) q6VarR.peek()).upperBound);
            } else {
                if (!this.f39642c.contains(Cut.belowAll()) || this.f39640a.containsKey(Cut.belowAll())) {
                    return Iterators.h();
                }
                cutHigherKey = this.f39640a.higherKey(Cut.belowAll());
            }
            return new b((Cut) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.f.a(cutHigherKey, Cut.aboveAll()), q6VarR);
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Range<C> get(Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    Map.Entry<Cut<C>, Range<C>> entryFirstEntry = tailMap(cut, true).firstEntry();
                    if (entryFirstEntry != null && entryFirstEntry.getKey().equals(cut)) {
                        return entryFirstEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z11) {
            return g(Range.upTo(cut, BoundType.forBoolean(z11)));
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.h
        public Iterator<Map.Entry<Cut<C>, Range<C>>> entryIterator() {
            Collection<Range<C>> collectionValues;
            Cut cutBelowAll;
            if (this.f39642c.hasLowerBound()) {
                collectionValues = this.f39641b.tailMap((Cut<C>) this.f39642c.lowerEndpoint(), this.f39642c.lowerBoundType() == BoundType.CLOSED).values();
            } else {
                collectionValues = this.f39641b.values();
            }
            q6 q6VarR = Iterators.r(collectionValues.iterator());
            if (this.f39642c.contains(Cut.belowAll()) && (!q6VarR.hasNext() || ((Range) q6VarR.peek()).lowerBound != Cut.belowAll())) {
                cutBelowAll = Cut.belowAll();
            } else {
                if (!q6VarR.hasNext()) {
                    return Iterators.h();
                }
                cutBelowAll = ((Range) q6VarR.next()).upperBound;
            }
            return new a(cutBelowAll, q6VarR);
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z11, Cut<C> cut2, boolean z12) {
            return g(Range.range(cut, BoundType.forBoolean(z11), cut2, BoundType.forBoolean(z12)));
        }

        public final NavigableMap<Cut<C>, Range<C>> g(Range<Cut<C>> range) {
            if (!this.f39642c.isConnected(range)) {
                return ImmutableSortedMap.of();
            }
            return new c(this.f39640a, range.intersection(this.f39642c));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z11) {
            return g(Range.downTo(cut, BoundType.forBoolean(z11)));
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.h, java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.w(entryIterator());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d<C extends Comparable<?>> extends u<Cut<C>, Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f39651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Range<Cut<C>> f39652b;

        /* JADX INFO: compiled from: source.java */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Iterator f39653c;

            public a(Iterator it) {
                this.f39653c = it;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.f39653c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f39653c.next();
                return d.this.f39652b.upperBound.isLessThan(range.upperBound) ? (Map.Entry) b() : Maps.g(range.upperBound, range);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ q6 f39655c;

            public b(q6 q6Var) {
                this.f39655c = q6Var;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.f39655c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f39655c.next();
                return d.this.f39652b.lowerBound.isLessThan(range.upperBound) ? Maps.g(range.upperBound, range) : (Map.Entry) b();
            }
        }

        public d(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this.f39651a = navigableMap;
            this.f39652b = Range.all();
        }

        public d(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.f39651a = navigableMap;
            this.f39652b = range;
        }

        private NavigableMap<Cut<C>, Range<C>> g(Range<Cut<C>> range) {
            return range.isConnected(this.f39652b) ? new d(this.f39651a, range.intersection(this.f39652b)) : ImmutableSortedMap.of();
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.u
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            q6 q6VarR = Iterators.r((this.f39652b.hasUpperBound() ? this.f39651a.headMap(this.f39652b.upperEndpoint(), false).descendingMap().values() : this.f39651a.descendingMap().values()).iterator());
            if (q6VarR.hasNext() && this.f39652b.upperBound.isLessThan(((Range) q6VarR.peek()).upperBound)) {
                q6VarR.next();
            }
            return new b(q6VarR);
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Range<C> get(Object obj) {
            Map.Entry<Cut<C>, Range<C>> entryLowerEntry;
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    if (this.f39652b.contains(cut) && (entryLowerEntry = this.f39651a.lowerEntry(cut)) != null && entryLowerEntry.getValue().upperBound.equals(cut)) {
                        return entryLowerEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z11) {
            return g(Range.upTo(cut, BoundType.forBoolean(z11)));
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.h
        public Iterator<Map.Entry<Cut<C>, Range<C>>> entryIterator() {
            Map.Entry entryLowerEntry;
            Iterator<Range<C>> it;
            if (this.f39652b.hasLowerBound() && (entryLowerEntry = this.f39651a.lowerEntry((Cut<C>) this.f39652b.lowerEndpoint())) != null) {
                it = this.f39652b.lowerBound.isLessThan(((Range) entryLowerEntry.getValue()).upperBound) ? this.f39651a.tailMap(entryLowerEntry.getKey(), true).values().iterator() : this.f39651a.tailMap(this.f39652b.lowerEndpoint(), true).values().iterator();
            } else {
                it = this.f39651a.values().iterator();
            }
            return new a(it);
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z11, Cut<C> cut2, boolean z12) {
            return g(Range.range(cut, BoundType.forBoolean(z11), cut2, BoundType.forBoolean(z12)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z11) {
            return g(Range.downTo(cut, BoundType.forBoolean(z11)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            if (this.f39652b.equals(Range.all())) {
                return this.f39651a.isEmpty();
            }
            return !entryIterator().hasNext();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.h, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f39652b.equals(Range.all()) ? this.f39651a.size() : Iterators.w(entryIterator());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e<C extends Comparable<?>> extends u<Cut<C>, Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Range<Cut<C>> f39657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Range<C> f39658b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f39659c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f39660d;

        /* JADX INFO: compiled from: source.java */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Iterator f39661c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Cut f39662d;

            public a(Iterator it, Cut cut) {
                this.f39661c = it;
                this.f39662d = cut;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.f39661c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f39661c.next();
                if (this.f39662d.isLessThan(range.lowerBound)) {
                    return (Map.Entry) b();
                }
                Range rangeIntersection = range.intersection(e.this.f39658b);
                return Maps.g(rangeIntersection.lowerBound, rangeIntersection);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Iterator f39664c;

            public b(Iterator it) {
                this.f39664c = it;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.f39664c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f39664c.next();
                if (e.this.f39658b.lowerBound.compareTo((Cut) range.upperBound) >= 0) {
                    return (Map.Entry) b();
                }
                Range rangeIntersection = range.intersection(e.this.f39658b);
                return e.this.f39657a.contains(rangeIntersection.lowerBound) ? Maps.g(rangeIntersection.lowerBound, rangeIntersection) : (Map.Entry) b();
            }
        }

        public e(Range<Cut<C>> range, Range<C> range2, NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this.f39657a = (Range) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(range);
            this.f39658b = (Range) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(range2);
            this.f39659c = (NavigableMap) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(navigableMap);
            this.f39660d = new d(navigableMap);
        }

        private NavigableMap<Cut<C>, Range<C>> h(Range<Cut<C>> range) {
            return !range.isConnected(this.f39657a) ? ImmutableSortedMap.of() : new e(this.f39657a.intersection(range), this.f39658b, this.f39659c);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.u
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            if (this.f39658b.isEmpty()) {
                return Iterators.h();
            }
            Cut cut = (Cut) Ordering.natural().min(this.f39657a.upperBound, Cut.belowValue(this.f39658b.upperBound));
            return new b(this.f39659c.headMap((Cut<C>) cut.endpoint(), cut.typeAsUpperBound() == BoundType.CLOSED).descendingMap().values().iterator());
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Range<C> get(Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    if (this.f39657a.contains(cut) && cut.compareTo((Cut) this.f39658b.lowerBound) >= 0 && cut.compareTo((Cut) this.f39658b.upperBound) < 0) {
                        if (cut.equals(this.f39658b.lowerBound)) {
                            Range range = (Range) Maps.z(this.f39659c.floorEntry(cut));
                            if (range != null && range.upperBound.compareTo((Cut) this.f39658b.lowerBound) > 0) {
                                return range.intersection(this.f39658b);
                            }
                        } else {
                            Range<C> range2 = this.f39659c.get(cut);
                            if (range2 != null) {
                                return range2.intersection(this.f39658b);
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.h
        public Iterator<Map.Entry<Cut<C>, Range<C>>> entryIterator() {
            Iterator<Range<C>> it;
            if (!this.f39658b.isEmpty() && !this.f39657a.upperBound.isLessThan(this.f39658b.lowerBound)) {
                if (this.f39657a.lowerBound.isLessThan(this.f39658b.lowerBound)) {
                    it = this.f39660d.tailMap(this.f39658b.lowerBound, false).values().iterator();
                } else {
                    it = this.f39659c.tailMap(this.f39657a.lowerBound.endpoint(), this.f39657a.lowerBoundType() == BoundType.CLOSED).values().iterator();
                }
                return new a(it, (Cut) Ordering.natural().min(this.f39657a.upperBound, Cut.belowValue(this.f39658b.upperBound)));
            }
            return Iterators.h();
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z11) {
            return h(Range.upTo(cut, BoundType.forBoolean(z11)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z11, Cut<C> cut2, boolean z12) {
            return h(Range.range(cut, BoundType.forBoolean(z11), cut2, BoundType.forBoolean(z12)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z11) {
            return h(Range.downTo(cut, BoundType.forBoolean(z11)));
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.h, java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.w(entryIterator());
        }
    }

    private TreeRangeSet(NavigableMap<Cut<C>, Range<C>> navigableMap) {
        this.rangesByLowerBound = navigableMap;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create() {
        return new TreeRangeSet<>(new TreeMap());
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(v6<C> v6Var) {
        TreeRangeSet<C> treeRangeSetCreate = create();
        treeRangeSetCreate.addAll(v6Var);
        return treeRangeSetCreate;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(Iterable<Range<C>> iterable) {
        TreeRangeSet<C> treeRangeSetCreate = create();
        treeRangeSetCreate.addAll(iterable);
        return treeRangeSetCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Range<C> rangeEnclosing(Range<C> range) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(range);
        Map.Entry<Cut<C>, Range<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        if (entryFloorEntry == null || !entryFloorEntry.getValue().encloses(range)) {
            return null;
        }
        return entryFloorEntry.getValue();
    }

    private void replaceRangeWithSameLowerBound(Range<C> range) {
        if (range.isEmpty()) {
            this.rangesByLowerBound.remove(range.lowerBound);
        } else {
            this.rangesByLowerBound.put(range.lowerBound, range);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
    public void add(Range<C> range) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(range);
        if (range.isEmpty()) {
            return;
        }
        Cut<C> cut = range.lowerBound;
        Cut<C> cut2 = range.upperBound;
        Map.Entry<Cut<C>, Range<C>> entryLowerEntry = this.rangesByLowerBound.lowerEntry(cut);
        if (entryLowerEntry != null) {
            Range<C> value = entryLowerEntry.getValue();
            if (value.upperBound.compareTo((Cut) cut) >= 0) {
                if (value.upperBound.compareTo((Cut) cut2) >= 0) {
                    cut2 = value.upperBound;
                }
                cut = value.lowerBound;
            }
        }
        Map.Entry<Cut<C>, Range<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(cut2);
        if (entryFloorEntry != null) {
            Range<C> value2 = entryFloorEntry.getValue();
            if (value2.upperBound.compareTo((Cut) cut2) >= 0) {
                cut2 = value2.upperBound;
            }
        }
        this.rangesByLowerBound.subMap(cut, cut2).clear();
        replaceRangeWithSameLowerBound(Range.create(cut, cut2));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
    public /* bridge */ /* synthetic */ void addAll(v6 v6Var) {
        super.addAll(v6Var);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
    public /* bridge */ /* synthetic */ void addAll(Iterable iterable) {
        u6.a(this, iterable);
    }

    public Set<Range<C>> asDescendingSetOfRanges() {
        Set<Range<C>> set = this.asDescendingSetOfRanges;
        if (set != null) {
            return set;
        }
        b bVar = new b(this.rangesByLowerBound.descendingMap().values());
        this.asDescendingSetOfRanges = bVar;
        return bVar;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
    public Set<Range<C>> asRanges() {
        Set<Range<C>> set = this.asRanges;
        if (set != null) {
            return set;
        }
        b bVar = new b(this.rangesByLowerBound.values());
        this.asRanges = bVar;
        return bVar;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
    public v6<C> complement() {
        v6<C> v6Var = this.complement;
        if (v6Var != null) {
            return v6Var;
        }
        Complement complement = new Complement();
        this.complement = complement;
        return complement;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
    public boolean encloses(Range<C> range) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(range);
        Map.Entry<Cut<C>, Range<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        return entryFloorEntry != null && entryFloorEntry.getValue().encloses(range);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
    public /* bridge */ /* synthetic */ boolean enclosesAll(v6 v6Var) {
        return super.enclosesAll(v6Var);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return u6.b(this, iterable);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
    public boolean intersects(Range<C> range) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(range);
        Map.Entry<Cut<C>, Range<C>> entryCeilingEntry = this.rangesByLowerBound.ceilingEntry(range.lowerBound);
        if (entryCeilingEntry != null && entryCeilingEntry.getValue().isConnected(range) && !entryCeilingEntry.getValue().intersection(range).isEmpty()) {
            return true;
        }
        Map.Entry<Cut<C>, Range<C>> entryLowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        return (entryLowerEntry == null || !entryLowerEntry.getValue().isConnected(range) || entryLowerEntry.getValue().intersection(range).isEmpty()) ? false : true;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
    public Range<C> rangeContaining(C c11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(c11);
        Map.Entry<Cut<C>, Range<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(Cut.belowValue(c11));
        if (entryFloorEntry == null || !entryFloorEntry.getValue().contains(c11)) {
            return null;
        }
        return entryFloorEntry.getValue();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
    public void remove(Range<C> range) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(range);
        if (range.isEmpty()) {
            return;
        }
        Map.Entry<Cut<C>, Range<C>> entryLowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        if (entryLowerEntry != null) {
            Range<C> value = entryLowerEntry.getValue();
            if (value.upperBound.compareTo((Cut) range.lowerBound) >= 0) {
                if (range.hasUpperBound() && value.upperBound.compareTo((Cut) range.upperBound) >= 0) {
                    replaceRangeWithSameLowerBound(Range.create(range.upperBound, value.upperBound));
                }
                replaceRangeWithSameLowerBound(Range.create(value.lowerBound, range.lowerBound));
            }
        }
        Map.Entry<Cut<C>, Range<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(range.upperBound);
        if (entryFloorEntry != null) {
            Range<C> value2 = entryFloorEntry.getValue();
            if (range.hasUpperBound() && value2.upperBound.compareTo((Cut) range.upperBound) >= 0) {
                replaceRangeWithSameLowerBound(Range.create(range.upperBound, value2.upperBound));
            }
        }
        this.rangesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
    public /* bridge */ /* synthetic */ void removeAll(v6 v6Var) {
        super.removeAll(v6Var);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v
    public /* bridge */ /* synthetic */ void removeAll(Iterable iterable) {
        u6.c(this, iterable);
    }

    public Range<C> span() {
        Map.Entry<Cut<C>, Range<C>> entryFirstEntry = this.rangesByLowerBound.firstEntry();
        Map.Entry<Cut<C>, Range<C>> entryLastEntry = this.rangesByLowerBound.lastEntry();
        if (entryFirstEntry != null) {
            return Range.create(entryFirstEntry.getValue().lowerBound, entryLastEntry.getValue().upperBound);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
    public v6<C> subRangeSet(Range<C> range) {
        return range.equals(Range.all()) ? this : new SubRangeSet(range);
    }
}
