package okhttp3;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.android.gms.common.api.Api;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import okhttp3.internal.Util;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class CacheControl {
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;
    public static final Companion Companion = new Companion(null);

    @JvmField
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();

    @JvmField
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Api.BaseClientBuilder.API_PRIORITY_OTHER, TimeUnit.SECONDS).build();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds = -1;
        private int maxStaleSeconds = -1;
        private int minFreshSeconds = -1;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        private final int clampToInt(long j11) {
            return j11 > ((long) Api.BaseClientBuilder.API_PRIORITY_OTHER) ? Api.BaseClientBuilder.API_PRIORITY_OTHER : (int) j11;
        }

        public final CacheControl build() {
            return new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, null, null);
        }

        public final Builder immutable() {
            this.immutable = true;
            return this;
        }

        public final Builder maxAge(int i11, TimeUnit timeUnit) {
            Intrinsics.g(timeUnit, "timeUnit");
            if (i11 >= 0) {
                this.maxAgeSeconds = clampToInt(timeUnit.toSeconds(i11));
                return this;
            }
            throw new IllegalArgumentException(("maxAge < 0: " + i11).toString());
        }

        public final Builder maxStale(int i11, TimeUnit timeUnit) {
            Intrinsics.g(timeUnit, "timeUnit");
            if (i11 >= 0) {
                this.maxStaleSeconds = clampToInt(timeUnit.toSeconds(i11));
                return this;
            }
            throw new IllegalArgumentException(("maxStale < 0: " + i11).toString());
        }

        public final Builder minFresh(int i11, TimeUnit timeUnit) {
            Intrinsics.g(timeUnit, "timeUnit");
            if (i11 >= 0) {
                this.minFreshSeconds = clampToInt(timeUnit.toSeconds(i11));
                return this;
            }
            throw new IllegalArgumentException(("minFresh < 0: " + i11).toString());
        }

        public final Builder noCache() {
            this.noCache = true;
            return this;
        }

        public final Builder noStore() {
            this.noStore = true;
            return this;
        }

        public final Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public final Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int indexOfElement(String str, String str2, int i11) {
            int length = str.length();
            while (i11 < length) {
                if (StringsKt__StringsKt.P(str2, str.charAt(i11), false, 2, null)) {
                    return i11;
                }
                i11++;
            }
            return str.length();
        }

        public static /* synthetic */ int indexOfElement$default(Companion companion, String str, String str2, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                i11 = 0;
            }
            return companion.indexOfElement(str, str2, i11);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x004b  */
        /* JADX WARN: Code duplicated, block: B:17:0x005e  */
        /* JADX WARN: Code duplicated, block: B:19:0x006e  */
        /* JADX WARN: Code duplicated, block: B:34:0x00d0  */
        /* JADX WARN: Code duplicated, block: B:38:0x00de  */
        /* JADX WARN: Code duplicated, block: B:39:0x00e2  */
        /* JADX WARN: Code duplicated, block: B:41:0x00ea  */
        /* JADX WARN: Code duplicated, block: B:42:0x00ee  */
        /* JADX WARN: Code duplicated, block: B:44:0x00f6  */
        /* JADX WARN: Code duplicated, block: B:46:0x00ff  */
        /* JADX WARN: Code duplicated, block: B:48:0x0108  */
        /* JADX WARN: Code duplicated, block: B:49:0x010e  */
        /* JADX WARN: Code duplicated, block: B:51:0x0116  */
        /* JADX WARN: Code duplicated, block: B:52:0x0119  */
        /* JADX WARN: Code duplicated, block: B:54:0x0121  */
        /* JADX WARN: Code duplicated, block: B:55:0x0124  */
        /* JADX WARN: Code duplicated, block: B:57:0x012c  */
        /* JADX WARN: Code duplicated, block: B:58:0x0130  */
        /* JADX WARN: Code duplicated, block: B:60:0x0138  */
        /* JADX WARN: Code duplicated, block: B:61:0x0142  */
        /* JADX WARN: Code duplicated, block: B:63:0x014a  */
        /* JADX WARN: Code duplicated, block: B:64:0x0152  */
        /* JADX WARN: Code duplicated, block: B:66:0x015b  */
        /* JADX WARN: Code duplicated, block: B:67:0x015e  */
        /* JADX WARN: Code duplicated, block: B:69:0x0166  */
        /* JADX WARN: Code duplicated, block: B:70:0x0169  */
        /* JADX WARN: Code duplicated, block: B:72:0x0171  */
        /* JADX WARN: Code duplicated, block: B:86:0x017c A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:99:0x0173 A[SYNTHETIC] */
        @JvmStatic
        public final CacheControl parse(Headers headers) {
            int i11;
            int i12;
            int iIndexOfElement;
            String strSubstring;
            String string;
            boolean z11;
            int iIndexOfElement2;
            String string2;
            Headers headers2 = headers;
            Intrinsics.g(headers2, "headers");
            int size = headers.size();
            boolean z12 = true;
            int i13 = 0;
            boolean z13 = true;
            String str = null;
            boolean z14 = false;
            boolean z15 = false;
            int nonNegativeInt = -1;
            int nonNegativeInt2 = -1;
            boolean z16 = false;
            boolean z17 = false;
            boolean z18 = false;
            int nonNegativeInt3 = -1;
            int nonNegativeInt4 = -1;
            boolean z19 = false;
            boolean z21 = false;
            boolean z22 = false;
            while (i13 < size) {
                String strName = headers2.name(i13);
                String strValue = headers2.value(i13);
                if (l.v(strName, HttpHeaders.CACHE_CONTROL, z12)) {
                    if (str == null) {
                        str = strValue;
                    }
                    i12 = 0;
                    while (i12 < strValue.length()) {
                        iIndexOfElement = indexOfElement(strValue, "=,;", i12);
                        strSubstring = strValue.substring(i12, iIndexOfElement);
                        Intrinsics.f(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        if (strSubstring != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        string = StringsKt__StringsKt.Z0(strSubstring).toString();
                        int i14 = size;
                        if (iIndexOfElement != strValue.length()) {
                            z11 = z13;
                            if (strValue.charAt(iIndexOfElement) == ',' && strValue.charAt(iIndexOfElement) != ';') {
                                int iIndexOfNonWhitespace = Util.indexOfNonWhitespace(strValue, iIndexOfElement + 1);
                                if (iIndexOfNonWhitespace >= strValue.length() || strValue.charAt(iIndexOfNonWhitespace) != '\"') {
                                    iIndexOfElement2 = indexOfElement(strValue, ",;", iIndexOfNonWhitespace);
                                    String strSubstring2 = strValue.substring(iIndexOfNonWhitespace, iIndexOfElement2);
                                    Intrinsics.f(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    if (strSubstring2 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                                    }
                                    string2 = StringsKt__StringsKt.Z0(strSubstring2).toString();
                                } else {
                                    int i15 = iIndexOfNonWhitespace + 1;
                                    int iC0 = StringsKt__StringsKt.c0(strValue, '\"', i15, false, 4, null);
                                    string2 = strValue.substring(i15, iC0);
                                    Intrinsics.f(string2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    iIndexOfElement2 = iC0 + 1;
                                }
                            }
                            z12 = true;
                            if (l.v("no-cache", string, true)) {
                                z14 = true;
                            } else if (l.v("no-store", string, true)) {
                                z15 = true;
                            } else if (l.v("max-age", string, true)) {
                                nonNegativeInt = Util.toNonNegativeInt(string2, -1);
                            } else if (l.v("s-maxage", string, true)) {
                                nonNegativeInt2 = Util.toNonNegativeInt(string2, -1);
                            } else if (l.v("private", string, true)) {
                                z16 = true;
                            } else if (l.v("public", string, true)) {
                                z17 = true;
                            } else if (l.v("must-revalidate", string, true)) {
                                z18 = true;
                            } else if (l.v("max-stale", string, true)) {
                                nonNegativeInt3 = Util.toNonNegativeInt(string2, Api.BaseClientBuilder.API_PRIORITY_OTHER);
                            } else if (l.v("min-fresh", string, true)) {
                                nonNegativeInt4 = Util.toNonNegativeInt(string2, -1);
                            } else if (l.v("only-if-cached", string, true)) {
                                z19 = true;
                            } else if (l.v("no-transform", string, true)) {
                                z21 = true;
                            } else if (l.v("immutable", string, true)) {
                                z22 = true;
                            }
                            i12 = iIndexOfElement2;
                            size = i14;
                            z13 = z11;
                        } else {
                            z11 = z13;
                        }
                        iIndexOfElement2 = iIndexOfElement + 1;
                        string2 = null;
                        z12 = true;
                        if (l.v("no-cache", string, true)) {
                            z14 = true;
                        } else if (l.v("no-store", string, true)) {
                            z15 = true;
                        } else if (l.v("max-age", string, true)) {
                            nonNegativeInt = Util.toNonNegativeInt(string2, -1);
                        } else if (l.v("s-maxage", string, true)) {
                            nonNegativeInt2 = Util.toNonNegativeInt(string2, -1);
                        } else if (l.v("private", string, true)) {
                            z16 = true;
                        } else if (l.v("public", string, true)) {
                            z17 = true;
                        } else if (l.v("must-revalidate", string, true)) {
                            z18 = true;
                        } else if (l.v("max-stale", string, true)) {
                            nonNegativeInt3 = Util.toNonNegativeInt(string2, Api.BaseClientBuilder.API_PRIORITY_OTHER);
                        } else if (l.v("min-fresh", string, true)) {
                            nonNegativeInt4 = Util.toNonNegativeInt(string2, -1);
                        } else if (l.v("only-if-cached", string, true)) {
                            z19 = true;
                        } else if (l.v("no-transform", string, true)) {
                            z21 = true;
                        } else if (l.v("immutable", string, true)) {
                            z22 = true;
                        }
                        i12 = iIndexOfElement2;
                        size = i14;
                        z13 = z11;
                    }
                    i11 = size;
                    i13++;
                    headers2 = headers;
                    size = i11;
                } else {
                    if (!l.v(strName, "Pragma", z12)) {
                        i11 = size;
                    }
                    i13++;
                    headers2 = headers;
                    size = i11;
                }
                z13 = false;
                i12 = 0;
                while (i12 < strValue.length()) {
                    iIndexOfElement = indexOfElement(strValue, "=,;", i12);
                    strSubstring = strValue.substring(i12, iIndexOfElement);
                    Intrinsics.f(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (strSubstring != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    string = StringsKt__StringsKt.Z0(strSubstring).toString();
                    int i16 = size;
                    if (iIndexOfElement != strValue.length()) {
                        z11 = z13;
                        if (strValue.charAt(iIndexOfElement) == ',') {
                        }
                        z12 = true;
                        if (l.v("no-cache", string, true)) {
                            z14 = true;
                        } else if (l.v("no-store", string, true)) {
                            z15 = true;
                        } else if (l.v("max-age", string, true)) {
                            nonNegativeInt = Util.toNonNegativeInt(string2, -1);
                        } else if (l.v("s-maxage", string, true)) {
                            nonNegativeInt2 = Util.toNonNegativeInt(string2, -1);
                        } else if (l.v("private", string, true)) {
                            z16 = true;
                        } else if (l.v("public", string, true)) {
                            z17 = true;
                        } else if (l.v("must-revalidate", string, true)) {
                            z18 = true;
                        } else if (l.v("max-stale", string, true)) {
                            nonNegativeInt3 = Util.toNonNegativeInt(string2, Api.BaseClientBuilder.API_PRIORITY_OTHER);
                        } else if (l.v("min-fresh", string, true)) {
                            nonNegativeInt4 = Util.toNonNegativeInt(string2, -1);
                        } else if (l.v("only-if-cached", string, true)) {
                            z19 = true;
                        } else if (l.v("no-transform", string, true)) {
                            z21 = true;
                        } else if (l.v("immutable", string, true)) {
                            z22 = true;
                        }
                        i12 = iIndexOfElement2;
                        size = i16;
                        z13 = z11;
                    } else {
                        z11 = z13;
                    }
                    iIndexOfElement2 = iIndexOfElement + 1;
                    string2 = null;
                    z12 = true;
                    if (l.v("no-cache", string, true)) {
                        z14 = true;
                    } else if (l.v("no-store", string, true)) {
                        z15 = true;
                    } else if (l.v("max-age", string, true)) {
                        nonNegativeInt = Util.toNonNegativeInt(string2, -1);
                    } else if (l.v("s-maxage", string, true)) {
                        nonNegativeInt2 = Util.toNonNegativeInt(string2, -1);
                    } else if (l.v("private", string, true)) {
                        z16 = true;
                    } else if (l.v("public", string, true)) {
                        z17 = true;
                    } else if (l.v("must-revalidate", string, true)) {
                        z18 = true;
                    } else if (l.v("max-stale", string, true)) {
                        nonNegativeInt3 = Util.toNonNegativeInt(string2, Api.BaseClientBuilder.API_PRIORITY_OTHER);
                    } else if (l.v("min-fresh", string, true)) {
                        nonNegativeInt4 = Util.toNonNegativeInt(string2, -1);
                    } else if (l.v("only-if-cached", string, true)) {
                        z19 = true;
                    } else if (l.v("no-transform", string, true)) {
                        z21 = true;
                    } else if (l.v("immutable", string, true)) {
                        z22 = true;
                    }
                    i12 = iIndexOfElement2;
                    size = i16;
                    z13 = z11;
                }
                i11 = size;
                i13++;
                headers2 = headers;
                size = i11;
            }
            return new CacheControl(z14, z15, nonNegativeInt, nonNegativeInt2, z16, z17, z18, nonNegativeInt3, nonNegativeInt4, z19, z21, z22, !z13 ? null : str, null);
        }
    }

    private CacheControl(boolean z11, boolean z12, int i11, int i12, boolean z13, boolean z14, boolean z15, int i13, int i14, boolean z16, boolean z17, boolean z18, String str) {
        this.noCache = z11;
        this.noStore = z12;
        this.maxAgeSeconds = i11;
        this.sMaxAgeSeconds = i12;
        this.isPrivate = z13;
        this.isPublic = z14;
        this.mustRevalidate = z15;
        this.maxStaleSeconds = i13;
        this.minFreshSeconds = i14;
        this.onlyIfCached = z16;
        this.noTransform = z17;
        this.immutable = z18;
        this.headerValue = str;
    }

    public /* synthetic */ CacheControl(boolean z11, boolean z12, int i11, int i12, boolean z13, boolean z14, boolean z15, int i13, int i14, boolean z16, boolean z17, boolean z18, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11, z12, i11, i12, z13, z14, z15, i13, i14, z16, z17, z18, str);
    }

    @JvmStatic
    public static final CacheControl parse(Headers headers) {
        return Companion.parse(headers);
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_immutable, reason: not valid java name */
    public final boolean m188deprecated_immutable() {
        return this.immutable;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_maxAgeSeconds, reason: not valid java name */
    public final int m189deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_maxStaleSeconds, reason: not valid java name */
    public final int m190deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_minFreshSeconds, reason: not valid java name */
    public final int m191deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_mustRevalidate, reason: not valid java name */
    public final boolean m192deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_noCache, reason: not valid java name */
    public final boolean m193deprecated_noCache() {
        return this.noCache;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_noStore, reason: not valid java name */
    public final boolean m194deprecated_noStore() {
        return this.noStore;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_noTransform, reason: not valid java name */
    public final boolean m195deprecated_noTransform() {
        return this.noTransform;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_onlyIfCached, reason: not valid java name */
    public final boolean m196deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_sMaxAgeSeconds, reason: not valid java name */
    public final int m197deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    @JvmName
    public final boolean immutable() {
        return this.immutable;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    @JvmName
    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @JvmName
    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @JvmName
    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @JvmName
    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    @JvmName
    public final boolean noCache() {
        return this.noCache;
    }

    @JvmName
    public final boolean noStore() {
        return this.noStore;
    }

    @JvmName
    public final boolean noTransform() {
        return this.noTransform;
    }

    @JvmName
    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    @JvmName
    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public String toString() {
        String str = this.headerValue;
        if (str != null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.noCache) {
            sb2.append("no-cache, ");
        }
        if (this.noStore) {
            sb2.append("no-store, ");
        }
        if (this.maxAgeSeconds != -1) {
            sb2.append("max-age=");
            sb2.append(this.maxAgeSeconds);
            sb2.append(", ");
        }
        if (this.sMaxAgeSeconds != -1) {
            sb2.append("s-maxage=");
            sb2.append(this.sMaxAgeSeconds);
            sb2.append(", ");
        }
        if (this.isPrivate) {
            sb2.append("private, ");
        }
        if (this.isPublic) {
            sb2.append("public, ");
        }
        if (this.mustRevalidate) {
            sb2.append("must-revalidate, ");
        }
        if (this.maxStaleSeconds != -1) {
            sb2.append("max-stale=");
            sb2.append(this.maxStaleSeconds);
            sb2.append(", ");
        }
        if (this.minFreshSeconds != -1) {
            sb2.append("min-fresh=");
            sb2.append(this.minFreshSeconds);
            sb2.append(", ");
        }
        if (this.onlyIfCached) {
            sb2.append("only-if-cached, ");
        }
        if (this.noTransform) {
            sb2.append("no-transform, ");
        }
        if (this.immutable) {
            sb2.append("immutable, ");
        }
        if (sb2.length() == 0) {
            return "";
        }
        sb2.delete(sb2.length() - 2, sb2.length());
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        this.headerValue = string;
        return string;
    }
}
