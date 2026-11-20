package com.applovin.exoplayer2.common.base;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Splitter {
    private final int limit;
    private final boolean omitEmptyStrings;
    private final e strategy;
    private final CharMatcher trimmer;

    /* JADX INFO: compiled from: source.java */
    public class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharMatcher f17221a;

        /* JADX INFO: renamed from: com.applovin.exoplayer2.common.base.Splitter$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0171a extends d {
            public C0171a(Splitter splitter, CharSequence charSequence) {
                super(splitter, charSequence);
            }

            @Override // com.applovin.exoplayer2.common.base.Splitter.d
            public int a(int i11) {
                return i11 + 1;
            }

            @Override // com.applovin.exoplayer2.common.base.Splitter.d
            public int b(int i11) {
                return a.this.f17221a.indexIn(this.f17227c, i11);
            }
        }

        public a(CharMatcher charMatcher) {
            this.f17221a = charMatcher;
        }

        @Override // com.applovin.exoplayer2.common.base.Splitter.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public d a(Splitter splitter, CharSequence charSequence) {
            return new C0171a(splitter, charSequence);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17223a;

        /* JADX INFO: compiled from: source.java */
        public class a extends d {
            public a(Splitter splitter, CharSequence charSequence) {
                super(splitter, charSequence);
            }

            @Override // com.applovin.exoplayer2.common.base.Splitter.d
            public int a(int i11) {
                return i11 + b.this.f17223a.length();
            }

            @Override // com.applovin.exoplayer2.common.base.Splitter.d
            public int b(int i11) {
                int length = b.this.f17223a.length();
                int length2 = this.f17227c.length() - length;
                while (i11 <= length2) {
                    for (int i12 = 0; i12 < length; i12++) {
                        if (this.f17227c.charAt(i12 + i11) != b.this.f17223a.charAt(i12)) {
                            i11++;
                        }
                    }
                    return i11;
                }
                return -1;
            }
        }

        public b(String str) {
            this.f17223a = str;
        }

        @Override // com.applovin.exoplayer2.common.base.Splitter.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public d a(Splitter splitter, CharSequence charSequence) {
            return new a(splitter, charSequence);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f17225a;

        /* JADX INFO: compiled from: source.java */
        public class a extends d {
            public a(Splitter splitter, CharSequence charSequence) {
                super(splitter, charSequence);
            }

            @Override // com.applovin.exoplayer2.common.base.Splitter.d
            public int a(int i11) {
                return i11;
            }

            @Override // com.applovin.exoplayer2.common.base.Splitter.d
            public int b(int i11) {
                int i12 = i11 + c.this.f17225a;
                if (i12 < this.f17227c.length()) {
                    return i12;
                }
                return -1;
            }
        }

        public c(int i11) {
            this.f17225a = i11;
        }

        @Override // com.applovin.exoplayer2.common.base.Splitter.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public d a(Splitter splitter, CharSequence charSequence) {
            return new a(splitter, charSequence);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class d extends com.applovin.exoplayer2.common.base.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final CharSequence f17227c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final CharMatcher f17228d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final boolean f17229f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f17230g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f17231h;

        public d(Splitter splitter, CharSequence charSequence) {
            this.f17228d = splitter.trimmer;
            this.f17229f = splitter.omitEmptyStrings;
            this.f17231h = splitter.limit;
            this.f17227c = charSequence;
        }

        public abstract int a(int i11);

        public abstract int b(int i11);

        @Override // com.applovin.exoplayer2.common.base.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a() {
            int i11 = this.f17230g;
            while (true) {
                int i12 = this.f17230g;
                if (i12 == -1) {
                    return (String) b();
                }
                int iB = b(i12);
                if (iB == -1) {
                    iB = this.f17227c.length();
                    this.f17230g = -1;
                } else {
                    this.f17230g = a(iB);
                }
                int i13 = this.f17230g;
                if (i13 == i11) {
                    int i14 = i13 + 1;
                    this.f17230g = i14;
                    if (i14 > this.f17227c.length()) {
                        this.f17230g = -1;
                    }
                } else {
                    while (i11 < iB && this.f17228d.matches(this.f17227c.charAt(i11))) {
                        i11++;
                    }
                    while (iB > i11 && this.f17228d.matches(this.f17227c.charAt(iB - 1))) {
                        iB--;
                    }
                    if (!this.f17229f || i11 != iB) {
                        int i15 = this.f17231h;
                        if (i15 == 1) {
                            iB = this.f17227c.length();
                            this.f17230g = -1;
                            while (iB > i11 && this.f17228d.matches(this.f17227c.charAt(iB - 1))) {
                                iB--;
                            }
                        } else {
                            this.f17231h = i15 - 1;
                        }
                        return this.f17227c.subSequence(i11, iB).toString();
                    }
                    i11 = this.f17230g;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface e {
        Iterator a(Splitter splitter, CharSequence charSequence);
    }

    private Splitter(e eVar) {
        this(eVar, false, CharMatcher.none(), Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    private Splitter(e eVar, boolean z11, CharMatcher charMatcher, int i11) {
        this.strategy = eVar;
        this.omitEmptyStrings = z11;
        this.trimmer = charMatcher;
        this.limit = i11;
    }

    public static Splitter fixedLength(int i11) {
        Preconditions.checkArgument(i11 > 0, "The length may not be less than 1");
        return new Splitter(new c(i11));
    }

    public static Splitter on(char c11) {
        return on(CharMatcher.is(c11));
    }

    public static Splitter on(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(new a(charMatcher));
    }

    public static Splitter on(String str) {
        Preconditions.checkArgument(str.length() != 0, "The separator may not be the empty string.");
        return str.length() == 1 ? on(str.charAt(0)) : new Splitter(new b(str));
    }

    private Iterator<String> splittingIterator(CharSequence charSequence) {
        return this.strategy.a(this, charSequence);
    }

    public Splitter limit(int i11) {
        Preconditions.checkArgument(i11 > 0, "must be greater than zero: %s", i11);
        return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, i11);
    }

    public Splitter omitEmptyStrings() {
        return new Splitter(this.strategy, true, this.trimmer, this.limit);
    }

    public List<String> splitToList(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        Iterator<String> itSplittingIterator = splittingIterator(charSequence);
        ArrayList arrayList = new ArrayList();
        while (itSplittingIterator.hasNext()) {
            arrayList.add(itSplittingIterator.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Splitter trimResults() {
        return trimResults(CharMatcher.whitespace());
    }

    public Splitter trimResults(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(this.strategy, this.omitEmptyStrings, charMatcher, this.limit);
    }
}
