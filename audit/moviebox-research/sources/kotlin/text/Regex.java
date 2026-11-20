package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import kotlin.sequences.SequencesKt__SequencesKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class Regex implements Serializable {
    public static final Companion Companion = new Companion(null);
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int b(int i11) {
            return (i11 & 2) != 0 ? i11 | 64 : i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class Serialized implements Serializable {
        public static final Companion Companion = new Companion(null);
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Serialized(String pattern, int i11) {
            Intrinsics.g(pattern, "pattern");
            this.pattern = pattern;
            this.flags = i11;
        }

        private final Object readResolve() {
            Pattern patternCompile = Pattern.compile(this.pattern, this.flags);
            Intrinsics.f(patternCompile, "compile(...)");
            return new Regex(patternCompile);
        }

        public final int getFlags() {
            return this.flags;
        }

        public final String getPattern() {
            return this.pattern;
        }
    }

    /* JADX INFO: renamed from: kotlin.text.Regex$findAll$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<MatchResult, MatchResult> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1, MatchResult.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final MatchResult invoke(MatchResult p11) {
            Intrinsics.g(p11, "p0");
            return p11.next();
        }
    }

    /* JADX INFO: renamed from: kotlin.text.Regex$splitToSequence$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    @DebugMetadata(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", l = {275, 283, 287}, m = "invokeSuspend")
    public static final class C20301 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super String>, Continuation<? super Unit>, Object> {
        final /* synthetic */ CharSequence $input;
        final /* synthetic */ int $limit;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C20301(CharSequence charSequence, int i11, Continuation<? super C20301> continuation) {
            super(2, continuation);
            this.$input = charSequence;
            this.$limit = i11;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C20301 c20301 = Regex.this.new C20301(this.$input, this.$limit, continuation);
            c20301.L$0 = obj;
            return c20301;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super String> sequenceScope, Continuation<? super Unit> continuation) {
            return ((C20301) create(sequenceScope, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0072 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:23:0x007d  */
        /* JADX WARN: Code duplicated, block: B:27:0x009e A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0070 -> B:21:0x0073). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C20301 c20301;
            SequenceScope sequenceScope;
            Matcher matcher;
            int i11;
            String string;
            String string2;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i12 = this.label;
            if (i12 == 0) {
                ResultKt.b(obj);
                SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
                Matcher matcher2 = Regex.this.nativePattern.matcher(this.$input);
                if (this.$limit != 1 && matcher2.find()) {
                    int iEnd = 0;
                    c20301 = this;
                    sequenceScope = sequenceScope2;
                    matcher = matcher2;
                    i11 = 0;
                    string = c20301.$input.subSequence(iEnd, matcher.start()).toString();
                    c20301.L$0 = sequenceScope;
                    c20301.L$1 = matcher;
                    c20301.I$0 = i11;
                    c20301.label = 2;
                    if (sequenceScope.a(string, c20301) == objE) {
                        return objE;
                    }
                    iEnd = matcher.end();
                    i11++;
                    if (i11 != c20301.$limit - 1) {
                    }
                    CharSequence charSequence = c20301.$input;
                    string2 = charSequence.subSequence(iEnd, charSequence.length()).toString();
                    c20301.L$0 = null;
                    c20301.L$1 = null;
                    c20301.label = 3;
                    if (sequenceScope.a(string2, c20301) == objE) {
                        return objE;
                    }
                    return Unit.f68710a;
                }
                String string3 = this.$input.toString();
                this.label = 1;
                if (sequenceScope2.a(string3, this) == objE) {
                    return objE;
                }
            } else {
                if (i12 != 1) {
                    if (i12 == 2) {
                        i11 = this.I$0;
                        Matcher matcher3 = (Matcher) this.L$1;
                        sequenceScope = (SequenceScope) this.L$0;
                        ResultKt.b(obj);
                        c20301 = this;
                        matcher = matcher3;
                        iEnd = matcher.end();
                        i11++;
                        if (i11 != c20301.$limit - 1 || !matcher.find()) {
                            CharSequence charSequence2 = c20301.$input;
                            string2 = charSequence2.subSequence(iEnd, charSequence2.length()).toString();
                            c20301.L$0 = null;
                            c20301.L$1 = null;
                            c20301.label = 3;
                            if (sequenceScope.a(string2, c20301) == objE) {
                                return objE;
                            }
                        }
                        string = c20301.$input.subSequence(iEnd, matcher.start()).toString();
                        c20301.L$0 = sequenceScope;
                        c20301.L$1 = matcher;
                        c20301.I$0 = i11;
                        c20301.label = 2;
                        if (sequenceScope.a(string, c20301) == objE) {
                            return objE;
                        }
                        iEnd = matcher.end();
                        i11++;
                        if (i11 != c20301.$limit - 1) {
                        }
                        CharSequence charSequence3 = c20301.$input;
                        string2 = charSequence3.subSequence(iEnd, charSequence3.length()).toString();
                        c20301.L$0 = null;
                        c20301.L$1 = null;
                        c20301.label = 3;
                        if (sequenceScope.a(string2, c20301) == objE) {
                            return objE;
                        }
                    } else {
                        if (i12 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    return Unit.f68710a;
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String pattern) {
        Intrinsics.g(pattern, "pattern");
        Pattern patternCompile = Pattern.compile(pattern);
        Intrinsics.f(patternCompile, "compile(...)");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String pattern, Set<? extends RegexOption> options) {
        Intrinsics.g(pattern, "pattern");
        Intrinsics.g(options, "options");
        Pattern patternCompile = Pattern.compile(pattern, Companion.b(RegexKt.j(options)));
        Intrinsics.f(patternCompile, "compile(...)");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String pattern, RegexOption option) {
        Intrinsics.g(pattern, "pattern");
        Intrinsics.g(option, "option");
        Pattern patternCompile = Pattern.compile(pattern, Companion.b(option.getValue()));
        Intrinsics.f(patternCompile, "compile(...)");
        this(patternCompile);
    }

    @PublishedApi
    public Regex(Pattern nativePattern) {
        Intrinsics.g(nativePattern, "nativePattern");
        this.nativePattern = nativePattern;
    }

    public static /* synthetic */ MatchResult find$default(Regex regex, CharSequence charSequence, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        return regex.find(charSequence, i11);
    }

    public static /* synthetic */ Sequence findAll$default(Regex regex, CharSequence charSequence, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        return regex.findAll(charSequence, i11);
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        return regex.split(charSequence, i11);
    }

    public static /* synthetic */ Sequence splitToSequence$default(Regex regex, CharSequence charSequence, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        return regex.splitToSequence(charSequence, i11);
    }

    private final Object writeReplace() {
        String strPattern = this.nativePattern.pattern();
        Intrinsics.f(strPattern, "pattern(...)");
        return new Serialized(strPattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(CharSequence input) {
        Intrinsics.g(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    public final MatchResult find(CharSequence input, int i11) {
        Intrinsics.g(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        Intrinsics.f(matcher, "matcher(...)");
        return RegexKt.f(matcher, i11, input);
    }

    public final Sequence<MatchResult> findAll(final CharSequence input, final int i11) {
        Intrinsics.g(input, "input");
        if (i11 >= 0 && i11 <= input.length()) {
            return SequencesKt__SequencesKt.g(new Function0<MatchResult>() { // from class: kotlin.text.Regex.findAll.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final MatchResult invoke() {
                    return Regex.this.find(input, i11);
                }
            }, AnonymousClass2.INSTANCE);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i11 + ", input length: " + input.length());
    }

    public final Set<RegexOption> getOptions() {
        Set set = this._options;
        if (set != null) {
            return set;
        }
        final int iFlags = this.nativePattern.flags();
        EnumSet enumSetAllOf = EnumSet.allOf(RegexOption.class);
        Intrinsics.d(enumSetAllOf);
        kotlin.collections.k.K(enumSetAllOf, new Function1<RegexOption, Boolean>() { // from class: kotlin.text.Regex$special$$inlined$fromInt$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(RegexOption regexOption) {
                RegexOption regexOption2 = regexOption;
                return Boolean.valueOf((iFlags & regexOption2.getMask()) == regexOption2.getValue());
            }
        });
        Set<RegexOption> setUnmodifiableSet = Collections.unmodifiableSet(enumSetAllOf);
        Intrinsics.f(setUnmodifiableSet, "unmodifiableSet(...)");
        this._options = setUnmodifiableSet;
        return setUnmodifiableSet;
    }

    public final String getPattern() {
        String strPattern = this.nativePattern.pattern();
        Intrinsics.f(strPattern, "pattern(...)");
        return strPattern;
    }

    @SinceKotlin
    @WasExperimental
    public final MatchResult matchAt(CharSequence input, int i11) {
        Intrinsics.g(input, "input");
        Matcher matcherRegion = this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i11, input.length());
        if (!matcherRegion.lookingAt()) {
            return null;
        }
        Intrinsics.d(matcherRegion);
        return new MatcherMatchResult(matcherRegion, input);
    }

    public final MatchResult matchEntire(CharSequence input) {
        Intrinsics.g(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        Intrinsics.f(matcher, "matcher(...)");
        return RegexKt.g(matcher, input);
    }

    public final boolean matches(CharSequence input) {
        Intrinsics.g(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    @SinceKotlin
    @WasExperimental
    public final boolean matchesAt(CharSequence input, int i11) {
        Intrinsics.g(input, "input");
        return this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i11, input.length()).lookingAt();
    }

    public final String replace(CharSequence input, String replacement) {
        Intrinsics.g(input, "input");
        Intrinsics.g(replacement, "replacement");
        String strReplaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        Intrinsics.f(strReplaceAll, "replaceAll(...)");
        return strReplaceAll;
    }

    public final String replace(CharSequence input, Function1<? super MatchResult, ? extends CharSequence> transform) {
        Intrinsics.g(input, "input");
        Intrinsics.g(transform, "transform");
        int iIntValue = 0;
        MatchResult matchResultFind$default = find$default(this, input, 0, 2, null);
        if (matchResultFind$default == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb2 = new StringBuilder(length);
        do {
            sb2.append(input, iIntValue, matchResultFind$default.b().x().intValue());
            sb2.append(transform.invoke(matchResultFind$default));
            iIntValue = matchResultFind$default.b().w().intValue() + 1;
            matchResultFind$default = matchResultFind$default.next();
            if (iIntValue >= length) {
                break;
            }
        } while (matchResultFind$default != null);
        if (iIntValue < length) {
            sb2.append(input, iIntValue, length);
        }
        String string = sb2.toString();
        Intrinsics.f(string, "toString(...)");
        return string;
    }

    public final String replaceFirst(CharSequence input, String replacement) {
        Intrinsics.g(input, "input");
        Intrinsics.g(replacement, "replacement");
        String strReplaceFirst = this.nativePattern.matcher(input).replaceFirst(replacement);
        Intrinsics.f(strReplaceFirst, "replaceFirst(...)");
        return strReplaceFirst;
    }

    public final List<String> split(CharSequence input, int i11) {
        Intrinsics.g(input, "input");
        StringsKt__StringsKt.z0(i11);
        Matcher matcher = this.nativePattern.matcher(input);
        if (i11 == 1 || !matcher.find()) {
            return kotlin.collections.f.e(input.toString());
        }
        ArrayList arrayList = new ArrayList(i11 > 0 ? kotlin.ranges.a.g(i11, 10) : 10);
        int i12 = i11 - 1;
        int iEnd = 0;
        do {
            arrayList.add(input.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
            if (i12 >= 0 && arrayList.size() == i12) {
                break;
            }
        } while (matcher.find());
        arrayList.add(input.subSequence(iEnd, input.length()).toString());
        return arrayList;
    }

    @SinceKotlin
    @WasExperimental
    public final Sequence<String> splitToSequence(CharSequence input, int i11) {
        Intrinsics.g(input, "input");
        StringsKt__StringsKt.z0(i11);
        return SequencesKt__SequenceBuilderKt.b(new C20301(input, i11, null));
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    public String toString() {
        String string = this.nativePattern.toString();
        Intrinsics.f(string, "toString(...)");
        return string;
    }
}
