package kotlin.text;

import java.util.List;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

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
public final class MatcherMatchResult implements MatchResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matcher f69141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f69142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MatchGroupCollection f69143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<String> f69144d;

    public MatcherMatchResult(Matcher matcher, CharSequence input) {
        Intrinsics.g(matcher, "matcher");
        Intrinsics.g(input, "input");
        this.f69141a = matcher;
        this.f69142b = input;
        this.f69143c = new MatcherMatchResult$groups$1(this);
    }

    @Override // kotlin.text.MatchResult
    public List<String> a() {
        if (this.f69144d == null) {
            this.f69144d = new AbstractList<String>() { // from class: kotlin.text.MatcherMatchResult$groupValues$1
                public /* bridge */ boolean a(String str) {
                    return super.contains(str);
                }

                @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
                public final /* bridge */ boolean contains(Object obj) {
                    if (obj instanceof String) {
                        return a((String) obj);
                    }
                    return false;
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
                public String get(int i11) {
                    String strGroup = this.f69145a.e().group(i11);
                    return strGroup == null ? "" : strGroup;
                }

                public /* bridge */ int f(String str) {
                    return super.indexOf(str);
                }

                public /* bridge */ int g(String str) {
                    return super.lastIndexOf(str);
                }

                @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
                public int getSize() {
                    return this.f69145a.e().groupCount() + 1;
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                public final /* bridge */ int indexOf(Object obj) {
                    if (obj instanceof String) {
                        return f((String) obj);
                    }
                    return -1;
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                public final /* bridge */ int lastIndexOf(Object obj) {
                    if (obj instanceof String) {
                        return g((String) obj);
                    }
                    return -1;
                }
            };
        }
        List<String> list = this.f69144d;
        Intrinsics.d(list);
        return list;
    }

    @Override // kotlin.text.MatchResult
    public IntRange b() {
        return RegexKt.h(e());
    }

    @Override // kotlin.text.MatchResult
    public MatchGroupCollection c() {
        return this.f69143c;
    }

    public final java.util.regex.MatchResult e() {
        return this.f69141a;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult next() {
        int iEnd = e().end() + (e().end() == e().start() ? 1 : 0);
        if (iEnd > this.f69142b.length()) {
            return null;
        }
        Matcher matcher = this.f69141a.pattern().matcher(this.f69142b);
        Intrinsics.f(matcher, "matcher(...)");
        return RegexKt.f(matcher, iEnd, this.f69142b);
    }
}
