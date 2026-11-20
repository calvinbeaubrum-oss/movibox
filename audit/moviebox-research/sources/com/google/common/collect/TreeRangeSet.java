package com.google.common.collect;

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
/* JADX INFO: loaded from: classes4.dex */
public class TreeRangeSet<C extends Comparable<?>> extends f<C> implements Serializable {
    private transient Set<Range<C>> asDescendingSetOfRanges;
    private transient Set<Range<C>> asRanges;
    private transient s0<C> complement;
    final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;

    /* JADX INFO: compiled from: source.java */
    public final class Complement extends TreeRangeSet<C> {
        public Complement() {
            super(new c(TreeRangeSet.this.rangesByLowerBound));
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public void add(Range<C> range) {
            TreeRangeSet.this.remove(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.s0
        public s0<C> complement() {
            return TreeRangeSet.this;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public boolean contains(C c11) {
            return !TreeRangeSet.this.contains(c11);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public void remove(Range<C> range) {
            TreeRangeSet.this.add(range);
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

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public void add(Range<C> range) {
            com.google.common.base.m.l(this.restriction.encloses(range), "Cannot add range %s to subRangeSet(%s)", range, this.restriction);
            TreeRangeSet.this.add(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public void clear() {
            TreeRangeSet.this.remove(this.restriction);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public boolean contains(C c11) {
            return this.restriction.contains(c11) && TreeRangeSet.this.contains(c11);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f, com.google.common.collect.s0
        public boolean encloses(Range<C> range) {
            Range rangeRangeEnclosing;
            return (this.restriction.isEmpty() || !this.restriction.encloses(range) || (rangeRangeEnclosing = TreeRangeSet.this.rangeEnclosing(range)) == null || rangeRangeEnclosing.intersection(this.restriction).isEmpty()) ? false : true;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public Range<C> rangeContaining(C c11) {
            Range<C> rangeRangeContaining;
            if (this.restriction.contains(c11) && (rangeRangeContaining = TreeRangeSet.this.rangeContaining(c11)) != null) {
                return rangeRangeContaining.intersection(this.restriction);
            }
            return null;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public void remove(Range<C> range) {
            if (range.isConnected(this.restriction)) {
                TreeRangeSet.this.remove(range.intersection(this.restriction));
            }
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.s0
        public s0<C> subRangeSet(Range<C> range) {
            if (range.encloses(this.restriction)) {
                return this;
            }
            return range.isConnected(this.restriction) ? new SubRangeSet(this.restriction.intersection(range)) : ImmutableRangeSet.of();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class b extends r<Range<C>> implements Set<Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Collection<Range<C>> f38646a;

        public b(TreeRangeSet treeRangeSet, Collection<Range<C>> collection) {
            this.f38646a = collection;
        }

        @Override // com.google.common.collect.r, com.google.common.collect.x
        /* JADX INFO: renamed from: delegate */
        public Collection<Range<C>> u() {
            return this.f38646a;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return Sets.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.d(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c<C extends Comparable<?>> extends com.google.common.collect.e<Cut<C>, Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f38647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f38648b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Range<Cut<C>> f38649c;

        /* JADX INFO: compiled from: source.java */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Cut<C> f38650c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Cut f38651d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ o0 f38652f;

            public a(Cut cut, o0 o0Var) {
                this.f38651d = cut;
                this.f38652f = o0Var;
                this.f38650c = cut;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<Cut<C>, Range<C>> a() {
                Range rangeCreate;
                if (c.this.f38649c.upperBound.isLessThan(this.f38650c) || this.f38650c == Cut.aboveAll()) {
                    return (Map.Entry) b();
                }
                if (this.f38652f.hasNext()) {
                    Range range = (Range) this.f38652f.next();
                    rangeCreate = Range.create(this.f38650c, range.lowerBound);
                    this.f38650c = range.upperBound;
                } else {
                    rangeCreate = Range.create(this.f38650c, Cut.aboveAll());
                    this.f38650c = Cut.aboveAll();
                }
                return Maps.i(rangeCreate.lowerBound, rangeCreate);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Cut<C> f38654c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Cut f38655d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ o0 f38656f;

            public b(Cut cut, o0 o0Var) {
                this.f38655d = cut;
                this.f38656f = o0Var;
                this.f38654c = cut;
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
            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (this.f38654c == Cut.belowAll()) {
                    return (Map.Entry) b();
                }
                if (this.f38656f.hasNext()) {
                    Range range = (Range) this.f38656f.next();
                    Range rangeCreate = Range.create(range.upperBound, this.f38654c);
                    this.f38654c = range.lowerBound;
                    if (c.this.f38649c.lowerBound.isLessThan(rangeCreate.lowerBound)) {
                        return Maps.i(rangeCreate.lowerBound, rangeCreate);
                    }
                } else if (c.this.f38649c.lowerBound.isLessThan(Cut.belowAll())) {
                    Range rangeCreate2 = Range.create(Cut.belowAll(), this.f38654c);
                    this.f38654c = Cut.belowAll();
                    return Maps.i(Cut.belowAll(), rangeCreate2);
                }
                return (Map.Entry) b();
            }
        }

        public c(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this(navigableMap, Range.all());
        }

        public c(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.f38647a = navigableMap;
            this.f38648b = new d(navigableMap);
            this.f38649c = range;
        }

        @Override // com.google.common.collect.Maps.k
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            Collection<Range<C>> collectionValues;
            Cut cutBelowAll;
            if (this.f38649c.hasLowerBound()) {
                collectionValues = this.f38648b.tailMap((Cut) this.f38649c.lowerEndpoint(), this.f38649c.lowerBoundType() == BoundType.CLOSED).values();
            } else {
                collectionValues = this.f38648b.values();
            }
            o0 o0VarT = Iterators.t(collectionValues.iterator());
            if (this.f38649c.contains(Cut.belowAll()) && (!o0VarT.hasNext() || ((Range) o0VarT.peek()).lowerBound != Cut.belowAll())) {
                cutBelowAll = Cut.belowAll();
            } else {
                if (!o0VarT.hasNext()) {
                    return Iterators.i();
                }
                cutBelowAll = ((Range) o0VarT.next()).upperBound;
            }
            return new a(cutBelowAll, o0VarT);
        }

        @Override // com.google.common.collect.e
        public Iterator<Map.Entry<Cut<C>, Range<C>>> c() {
            Cut<C> cutHigherKey;
            o0 o0VarT = Iterators.t(this.f38648b.headMap(this.f38649c.hasUpperBound() ? (Cut) this.f38649c.upperEndpoint() : Cut.aboveAll(), this.f38649c.hasUpperBound() && this.f38649c.upperBoundType() == BoundType.CLOSED).descendingMap().values().iterator());
            if (o0VarT.hasNext()) {
                cutHigherKey = ((Range) o0VarT.peek()).upperBound == Cut.aboveAll() ? ((Range) o0VarT.next()).lowerBound : this.f38647a.higherKey(((Range) o0VarT.peek()).upperBound);
            } else {
                if (!this.f38649c.contains(Cut.belowAll()) || this.f38647a.containsKey(Cut.belowAll())) {
                    return Iterators.i();
                }
                cutHigherKey = this.f38647a.higherKey(Cut.belowAll());
            }
            return new b((Cut) com.google.common.base.h.a(cutHigherKey, Cut.aboveAll()), o0VarT);
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
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
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
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z11) {
            return h(Range.upTo(cut, BoundType.forBoolean(z11)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z11, Cut<C> cut2, boolean z12) {
            return h(Range.range(cut, BoundType.forBoolean(z11), cut2, BoundType.forBoolean(z12)));
        }

        public final NavigableMap<Cut<C>, Range<C>> h(Range<Cut<C>> range) {
            if (!this.f38649c.isConnected(range)) {
                return ImmutableSortedMap.of();
            }
            return new c(this.f38647a, range.intersection(this.f38649c));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z11) {
            return h(Range.downTo(cut, BoundType.forBoolean(z11)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.z(a());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d<C extends Comparable<?>> extends com.google.common.collect.e<Cut<C>, Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f38658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Range<Cut<C>> f38659b;

        /* JADX INFO: compiled from: source.java */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Iterator f38660c;

            public a(Iterator it) {
                this.f38660c = it;
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
            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.f38660c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f38660c.next();
                return d.this.f38659b.upperBound.isLessThan(range.upperBound) ? (Map.Entry) b() : Maps.i(range.upperBound, range);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ o0 f38662c;

            public b(o0 o0Var) {
                this.f38662c = o0Var;
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
            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.f38662c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f38662c.next();
                return d.this.f38659b.lowerBound.isLessThan(range.upperBound) ? Maps.i(range.upperBound, range) : (Map.Entry) b();
            }
        }

        public d(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this.f38658a = navigableMap;
            this.f38659b = Range.all();
        }

        public d(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.f38658a = navigableMap;
            this.f38659b = range;
        }

        private NavigableMap<Cut<C>, Range<C>> h(Range<Cut<C>> range) {
            return range.isConnected(this.f38659b) ? new d(this.f38658a, range.intersection(this.f38659b)) : ImmutableSortedMap.of();
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
        @Override // com.google.common.collect.Maps.k
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            Map.Entry<Cut<C>, Range<C>> entryLowerEntry;
            Iterator<Range<C>> it;
            if (this.f38659b.hasLowerBound() && (entryLowerEntry = this.f38658a.lowerEntry((Cut) this.f38659b.lowerEndpoint())) != null) {
                it = this.f38659b.lowerBound.isLessThan(entryLowerEntry.getValue().upperBound) ? this.f38658a.tailMap(entryLowerEntry.getKey(), true).values().iterator() : this.f38658a.tailMap((Cut) this.f38659b.lowerEndpoint(), true).values().iterator();
            } else {
                it = this.f38658a.values().iterator();
            }
            return new a(it);
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
        @Override // com.google.common.collect.e
        public Iterator<Map.Entry<Cut<C>, Range<C>>> c() {
            o0 o0VarT = Iterators.t((this.f38659b.hasUpperBound() ? this.f38658a.headMap((Cut) this.f38659b.upperEndpoint(), false).descendingMap().values() : this.f38658a.descendingMap().values()).iterator());
            if (o0VarT.hasNext() && this.f38659b.upperBound.isLessThan(((Range) o0VarT.peek()).upperBound)) {
                o0VarT.next();
            }
            return new b(o0VarT);
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
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Range<C> get(Object obj) {
            Map.Entry<Cut<C>, Range<C>> entryLowerEntry;
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    if (this.f38659b.contains(cut) && (entryLowerEntry = this.f38658a.lowerEntry(cut)) != null && entryLowerEntry.getValue().upperBound.equals(cut)) {
                        return entryLowerEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
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

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            if (this.f38659b.equals(Range.all())) {
                return this.f38658a.isEmpty();
            }
            return !a().hasNext();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f38659b.equals(Range.all()) ? this.f38658a.size() : Iterators.z(a());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e<C extends Comparable<?>> extends com.google.common.collect.e<Cut<C>, Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Range<Cut<C>> f38664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Range<C> f38665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f38666c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final NavigableMap<Cut<C>, Range<C>> f38667d;

        /* JADX INFO: compiled from: source.java */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Iterator f38668c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Cut f38669d;

            public a(Iterator it, Cut cut) {
                this.f38668c = it;
                this.f38669d = cut;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.f38668c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f38668c.next();
                if (this.f38669d.isLessThan(range.lowerBound)) {
                    return (Map.Entry) b();
                }
                Range rangeIntersection = range.intersection(e.this.f38665b);
                return Maps.i(rangeIntersection.lowerBound, rangeIntersection);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Iterator f38671c;

            public b(Iterator it) {
                this.f38671c = it;
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
            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.f38671c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f38671c.next();
                if (e.this.f38665b.lowerBound.compareTo((Cut) range.upperBound) >= 0) {
                    return (Map.Entry) b();
                }
                Range rangeIntersection = range.intersection(e.this.f38665b);
                return e.this.f38664a.contains(rangeIntersection.lowerBound) ? Maps.i(rangeIntersection.lowerBound, rangeIntersection) : (Map.Entry) b();
            }
        }

        public e(Range<Cut<C>> range, Range<C> range2, NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this.f38664a = (Range) com.google.common.base.m.p(range);
            this.f38665b = (Range) com.google.common.base.m.p(range2);
            this.f38666c = (NavigableMap) com.google.common.base.m.p(navigableMap);
            this.f38667d = new d(navigableMap);
        }

        private NavigableMap<Cut<C>, Range<C>> i(Range<Cut<C>> range) {
            return !range.isConnected(this.f38664a) ? ImmutableSortedMap.of() : new e(this.f38664a.intersection(range), this.f38665b, this.f38666c);
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
        @Override // com.google.common.collect.Maps.k
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            Iterator<Range<C>> it;
            if (!this.f38665b.isEmpty() && !this.f38664a.upperBound.isLessThan(this.f38665b.lowerBound)) {
                if (this.f38664a.lowerBound.isLessThan(this.f38665b.lowerBound)) {
                    it = this.f38667d.tailMap(this.f38665b.lowerBound, false).values().iterator();
                } else {
                    it = this.f38666c.tailMap((Cut) this.f38664a.lowerBound.endpoint(), this.f38664a.lowerBoundType() == BoundType.CLOSED).values().iterator();
                }
                return new a(it, (Cut) Ordering.natural().min(this.f38664a.upperBound, Cut.belowValue(this.f38665b.upperBound)));
            }
            return Iterators.i();
        }

        @Override // com.google.common.collect.e
        public Iterator<Map.Entry<Cut<C>, Range<C>>> c() {
            if (this.f38665b.isEmpty()) {
                return Iterators.i();
            }
            Cut cut = (Cut) Ordering.natural().min(this.f38664a.upperBound, Cut.belowValue(this.f38665b.upperBound));
            return new b(this.f38666c.headMap((Cut) cut.endpoint(), cut.typeAsUpperBound() == BoundType.CLOSED).descendingMap().values().iterator());
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
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Range<C> get(Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    if (this.f38664a.contains(cut) && cut.compareTo((Cut) this.f38665b.lowerBound) >= 0 && cut.compareTo((Cut) this.f38665b.upperBound) < 0) {
                        if (cut.equals(this.f38665b.lowerBound)) {
                            Range range = (Range) Maps.E(this.f38666c.floorEntry(cut));
                            if (range != null && range.upperBound.compareTo((Cut) this.f38665b.lowerBound) > 0) {
                                return range.intersection(this.f38665b);
                            }
                        } else {
                            Range<C> range2 = this.f38666c.get(cut);
                            if (range2 != null) {
                                return range2.intersection(this.f38665b);
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z11) {
            return i(Range.upTo(cut, BoundType.forBoolean(z11)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z11, Cut<C> cut2, boolean z12) {
            return i(Range.range(cut, BoundType.forBoolean(z11), cut2, BoundType.forBoolean(z12)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z11) {
            return i(Range.downTo(cut, BoundType.forBoolean(z11)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.z(a());
        }
    }

    private TreeRangeSet(NavigableMap<Cut<C>, Range<C>> navigableMap) {
        this.rangesByLowerBound = navigableMap;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create() {
        return new TreeRangeSet<>(new TreeMap());
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(s0<C> s0Var) {
        TreeRangeSet<C> treeRangeSetCreate = create();
        treeRangeSetCreate.addAll(s0Var);
        return treeRangeSetCreate;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(Iterable<Range<C>> iterable) {
        TreeRangeSet<C> treeRangeSetCreate = create();
        treeRangeSetCreate.addAll(iterable);
        return treeRangeSetCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Range<C> rangeEnclosing(Range<C> range) {
        com.google.common.base.m.p(range);
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
    @Override // com.google.common.collect.f
    public void add(Range<C> range) {
        com.google.common.base.m.p(range);
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

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ void addAll(s0 s0Var) {
        super.addAll(s0Var);
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ void addAll(Iterable iterable) {
        super.addAll(iterable);
    }

    public Set<Range<C>> asDescendingSetOfRanges() {
        Set<Range<C>> set = this.asDescendingSetOfRanges;
        if (set != null) {
            return set;
        }
        b bVar = new b(this, this.rangesByLowerBound.descendingMap().values());
        this.asDescendingSetOfRanges = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.s0
    public Set<Range<C>> asRanges() {
        Set<Range<C>> set = this.asRanges;
        if (set != null) {
            return set;
        }
        b bVar = new b(this, this.rangesByLowerBound.values());
        this.asRanges = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.s0
    public s0<C> complement() {
        s0<C> s0Var = this.complement;
        if (s0Var != null) {
            return s0Var;
        }
        Complement complement = new Complement();
        this.complement = complement;
        return complement;
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    @Override // com.google.common.collect.f, com.google.common.collect.s0
    public boolean encloses(Range<C> range) {
        com.google.common.base.m.p(range);
        Map.Entry<Cut<C>, Range<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        return entryFloorEntry != null && entryFloorEntry.getValue().encloses(range);
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean enclosesAll(s0 s0Var) {
        return super.enclosesAll(s0Var);
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.f
    public boolean intersects(Range<C> range) {
        com.google.common.base.m.p(range);
        Map.Entry<Cut<C>, Range<C>> entryCeilingEntry = this.rangesByLowerBound.ceilingEntry(range.lowerBound);
        if (entryCeilingEntry != null && entryCeilingEntry.getValue().isConnected(range) && !entryCeilingEntry.getValue().intersection(range).isEmpty()) {
            return true;
        }
        Map.Entry<Cut<C>, Range<C>> entryLowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        return (entryLowerEntry == null || !entryLowerEntry.getValue().isConnected(range) || entryLowerEntry.getValue().intersection(range).isEmpty()) ? false : true;
    }

    @Override // com.google.common.collect.f, com.google.common.collect.s0
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.f
    public Range<C> rangeContaining(C c11) {
        com.google.common.base.m.p(c11);
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
    @Override // com.google.common.collect.f
    public void remove(Range<C> range) {
        com.google.common.base.m.p(range);
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

    @Override // com.google.common.collect.f, com.google.common.collect.s0
    public /* bridge */ /* synthetic */ void removeAll(s0 s0Var) {
        super.removeAll(s0Var);
    }

    @Override // com.google.common.collect.f
    public /* bridge */ /* synthetic */ void removeAll(Iterable iterable) {
        super.removeAll(iterable);
    }

    public Range<C> span() {
        Map.Entry<Cut<C>, Range<C>> entryFirstEntry = this.rangesByLowerBound.firstEntry();
        Map.Entry<Cut<C>, Range<C>> entryLastEntry = this.rangesByLowerBound.lastEntry();
        if (entryFirstEntry == null || entryLastEntry == null) {
            throw new NoSuchElementException();
        }
        return Range.create(entryFirstEntry.getValue().lowerBound, entryLastEntry.getValue().upperBound);
    }

    @Override // com.google.common.collect.s0
    public s0<C> subRangeSet(Range<C> range) {
        return range.equals(Range.all()) ? this : new SubRangeSet(range);
    }
}
