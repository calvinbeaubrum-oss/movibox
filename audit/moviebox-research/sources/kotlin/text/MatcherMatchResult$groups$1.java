package kotlin.text;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt___SequencesKt;

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
public final class MatcherMatchResult$groups$1 extends AbstractCollection<MatchGroup> implements MatchNamedGroupCollection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MatcherMatchResult f69146a;

    public MatcherMatchResult$groups$1(MatcherMatchResult matcherMatchResult) {
        this.f69146a = matcherMatchResult;
    }

    public /* bridge */ boolean a(MatchGroup matchGroup) {
        return super.contains(matchGroup);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null || (obj instanceof MatchGroup)) {
            return a((MatchGroup) obj);
        }
        return false;
    }

    @Override // kotlin.text.MatchGroupCollection
    public MatchGroup get(int i11) {
        IntRange intRangeI = RegexKt.i(this.f69146a.e(), i11);
        if (intRangeI.x().intValue() < 0) {
            return null;
        }
        String strGroup = this.f69146a.e().group(i11);
        Intrinsics.f(strGroup, "group(...)");
        return new MatchGroup(strGroup, intRangeI);
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f69146a.e().groupCount() + 1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return false;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<MatchGroup> iterator() {
        return SequencesKt___SequencesKt.r(CollectionsKt___CollectionsKt.V(kotlin.collections.g.m(this)), new Function1<Integer, MatchGroup>() { // from class: kotlin.text.MatcherMatchResult$groups$1$iterator$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MatchGroup invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final MatchGroup invoke(int i11) {
                return this.this$0.get(i11);
            }
        }).iterator();
    }
}
