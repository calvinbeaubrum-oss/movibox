package org.apache.commons.compress.archivers.zip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class ZipArchiveEntry extends ZipEntry implements l20.a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final byte[] f72530r = new byte[0];

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final w[] f72531s = new w[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f72532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f72533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f72534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f72535d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f72536f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f72537g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public w[] f72538h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public l f72539i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f72540j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte[] f72541k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public e f72542l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f72543m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f72544n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f72545o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public NameSource f72546p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CommentSource f72547q;

    /* JADX INFO: compiled from: source.java */
    public enum CommentSource {
        COMMENT,
        UNICODE_EXTRA_FIELD
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'BEST_EFFORT' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: source.java */
    public static class ExtraFieldParsingMode implements c {
        private static final /* synthetic */ ExtraFieldParsingMode[] $VALUES;
        public static final ExtraFieldParsingMode BEST_EFFORT;
        public static final ExtraFieldParsingMode DRACONIC;
        public static final ExtraFieldParsingMode ONLY_PARSEABLE_LENIENT;
        public static final ExtraFieldParsingMode ONLY_PARSEABLE_STRICT;
        public static final ExtraFieldParsingMode STRICT_FOR_KNOW_EXTRA_FIELDS;
        private final d.a onUnparseableData;

        static {
            d.a aVar = d.a.f72561d;
            ExtraFieldParsingMode extraFieldParsingMode = new ExtraFieldParsingMode("BEST_EFFORT", 0, aVar) { // from class: org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.1
                @Override // org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode, org.apache.commons.compress.archivers.zip.c
                public w fill(w wVar, byte[] bArr, int i11, int i12, boolean z11) {
                    return ExtraFieldParsingMode.fillAndMakeUnrecognizedOnError(wVar, bArr, i11, i12, z11);
                }
            };
            BEST_EFFORT = extraFieldParsingMode;
            ExtraFieldParsingMode extraFieldParsingMode2 = new ExtraFieldParsingMode("STRICT_FOR_KNOW_EXTRA_FIELDS", 1, aVar);
            STRICT_FOR_KNOW_EXTRA_FIELDS = extraFieldParsingMode2;
            d.a aVar2 = d.a.f72560c;
            ExtraFieldParsingMode extraFieldParsingMode3 = new ExtraFieldParsingMode("ONLY_PARSEABLE_LENIENT", 2, aVar2) { // from class: org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.2
                @Override // org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode, org.apache.commons.compress.archivers.zip.c
                public w fill(w wVar, byte[] bArr, int i11, int i12, boolean z11) {
                    return ExtraFieldParsingMode.fillAndMakeUnrecognizedOnError(wVar, bArr, i11, i12, z11);
                }
            };
            ONLY_PARSEABLE_LENIENT = extraFieldParsingMode3;
            ExtraFieldParsingMode extraFieldParsingMode4 = new ExtraFieldParsingMode("ONLY_PARSEABLE_STRICT", 3, aVar2);
            ONLY_PARSEABLE_STRICT = extraFieldParsingMode4;
            ExtraFieldParsingMode extraFieldParsingMode5 = new ExtraFieldParsingMode("DRACONIC", 4, d.a.f72559b);
            DRACONIC = extraFieldParsingMode5;
            $VALUES = new ExtraFieldParsingMode[]{extraFieldParsingMode, extraFieldParsingMode2, extraFieldParsingMode3, extraFieldParsingMode4, extraFieldParsingMode5};
        }

        private ExtraFieldParsingMode(String str, int i11, d.a aVar) {
            super(str, i11);
            this.onUnparseableData = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static w fillAndMakeUnrecognizedOnError(w wVar, byte[] bArr, int i11, int i12, boolean z11) {
            try {
                return d.c(wVar, bArr, i11, i12, z11);
            } catch (ZipException unused) {
                m mVar = new m();
                mVar.b(wVar.getHeaderId());
                if (z11) {
                    mVar.c(Arrays.copyOfRange(bArr, i11, i12 + i11));
                } else {
                    mVar.a(Arrays.copyOfRange(bArr, i11, i12 + i11));
                }
                return mVar;
            }
        }

        public static ExtraFieldParsingMode valueOf(String str) {
            return (ExtraFieldParsingMode) Enum.valueOf(ExtraFieldParsingMode.class, str);
        }

        public static ExtraFieldParsingMode[] values() {
            return (ExtraFieldParsingMode[]) $VALUES.clone();
        }

        @Override // org.apache.commons.compress.archivers.zip.c
        public w createExtraField(ZipShort zipShort) throws IllegalAccessException, ZipException, InstantiationException {
            return d.a(zipShort);
        }

        @Override // org.apache.commons.compress.archivers.zip.c
        public w fill(w wVar, byte[] bArr, int i11, int i12, boolean z11) throws ZipException {
            return d.c(wVar, bArr, i11, i12, z11);
        }

        @Override // org.apache.commons.compress.archivers.zip.k
        public w onUnparseableExtraField(byte[] bArr, int i11, int i12, boolean z11, int i13) throws ZipException {
            return this.onUnparseableData.onUnparseableExtraField(bArr, i11, i12, z11, i13);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum NameSource {
        NAME,
        NAME_WITH_EFS_FLAG,
        UNICODE_EXTRA_FIELD
    }

    public ZipArchiveEntry() {
        this("");
    }

    public ZipArchiveEntry(String str) {
        super(str);
        this.f72532a = -1;
        this.f72533b = -1L;
        this.f72534c = 0;
        this.f72535d = 0;
        this.f72536f = 0L;
        this.f72537g = 0;
        this.f72539i = null;
        this.f72540j = null;
        this.f72541k = null;
        this.f72542l = new e();
        this.f72543m = -1L;
        this.f72544n = -1L;
        this.f72545o = false;
        this.f72546p = NameSource.NAME;
        this.f72547q = CommentSource.COMMENT;
        v(str);
    }

    public void a(w wVar) {
        if (wVar instanceof l) {
            this.f72539i = (l) wVar;
        } else if (this.f72538h == null) {
            this.f72538h = new w[]{wVar};
        } else {
            if (g(wVar.getHeaderId()) != null) {
                p(wVar.getHeaderId());
            }
            w[] wVarArr = this.f72538h;
            w[] wVarArr2 = (w[]) Arrays.copyOf(wVarArr, wVarArr.length + 1);
            wVarArr2[wVarArr2.length - 1] = wVar;
            this.f72538h = wVarArr2;
        }
        r();
    }

    public final w[] b() {
        w[] wVarArr = this.f72538h;
        if (wVarArr == null) {
            return n();
        }
        return this.f72539i != null ? l() : wVarArr;
    }

    public byte[] c() {
        return d.d(b());
    }

    @Override // java.util.zip.ZipEntry
    public Object clone() {
        ZipArchiveEntry zipArchiveEntry = (ZipArchiveEntry) super.clone();
        zipArchiveEntry.t(h());
        zipArchiveEntry.q(f());
        zipArchiveEntry.s(b());
        return zipArchiveEntry;
    }

    public long d() {
        return this.f72544n;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ZipArchiveEntry zipArchiveEntry = (ZipArchiveEntry) obj;
        String name = getName();
        String name2 = zipArchiveEntry.getName();
        if (name == null) {
            if (name2 != null) {
                return false;
            }
        } else if (!name.equals(name2)) {
            return false;
        }
        String comment = getComment();
        String comment2 = zipArchiveEntry.getComment();
        if (comment == null) {
            comment = "";
        }
        if (comment2 == null) {
            comment2 = "";
        }
        return getTime() == zipArchiveEntry.getTime() && comment.equals(comment2) && h() == zipArchiveEntry.h() && m() == zipArchiveEntry.m() && f() == zipArchiveEntry.f() && getMethod() == zipArchiveEntry.getMethod() && getSize() == zipArchiveEntry.getSize() && getCrc() == zipArchiveEntry.getCrc() && getCompressedSize() == zipArchiveEntry.getCompressedSize() && Arrays.equals(c(), zipArchiveEntry.c()) && Arrays.equals(j(), zipArchiveEntry.j()) && this.f72543m == zipArchiveEntry.f72543m && this.f72544n == zipArchiveEntry.f72544n && this.f72542l.equals(zipArchiveEntry.f72542l);
    }

    public long f() {
        return this.f72536f;
    }

    public w g(ZipShort zipShort) {
        w[] wVarArr = this.f72538h;
        if (wVarArr == null) {
            return null;
        }
        for (w wVar : wVarArr) {
            if (zipShort.equals(wVar.getHeaderId())) {
                return wVar;
            }
        }
        return null;
    }

    @Override // java.util.zip.ZipEntry
    public int getMethod() {
        return this.f72532a;
    }

    @Override // java.util.zip.ZipEntry
    public String getName() {
        String str = this.f72540j;
        return str == null ? super.getName() : str;
    }

    @Override // java.util.zip.ZipEntry
    public long getSize() {
        return this.f72533b;
    }

    public int h() {
        return this.f72534c;
    }

    @Override // java.util.zip.ZipEntry
    public int hashCode() {
        String name = getName();
        if (name == null) {
            name = "";
        }
        return name.hashCode();
    }

    @Override // java.util.zip.ZipEntry
    public boolean isDirectory() {
        String name = getName();
        return name != null && name.endsWith("/");
    }

    public byte[] j() {
        byte[] extra = getExtra();
        return extra != null ? extra : f72530r;
    }

    public long k() {
        return this.f72543m;
    }

    public final w[] l() {
        w[] wVarArr = this.f72538h;
        w[] wVarArr2 = (w[]) Arrays.copyOf(wVarArr, wVarArr.length + 1);
        wVarArr2[this.f72538h.length] = this.f72539i;
        return wVarArr2;
    }

    public int m() {
        return this.f72535d;
    }

    public final w[] n() {
        l lVar = this.f72539i;
        return lVar == null ? f72531s : new w[]{lVar};
    }

    public final void o(w[] wVarArr, boolean z11) {
        if (this.f72538h == null) {
            s(wVarArr);
            return;
        }
        for (w wVar : wVarArr) {
            w wVarG = wVar instanceof l ? this.f72539i : g(wVar.getHeaderId());
            if (wVarG == null) {
                a(wVar);
            } else {
                byte[] localFileDataData = z11 ? wVar.getLocalFileDataData() : wVar.getCentralDirectoryData();
                if (z11) {
                    try {
                        wVarG.parseFromLocalFileData(localFileDataData, 0, localFileDataData.length);
                    } catch (ZipException unused) {
                        m mVar = new m();
                        mVar.b(wVarG.getHeaderId());
                        if (z11) {
                            mVar.c(localFileDataData);
                            mVar.a(wVarG.getCentralDirectoryData());
                        } else {
                            mVar.c(wVarG.getLocalFileDataData());
                            mVar.a(localFileDataData);
                        }
                        p(wVarG.getHeaderId());
                        a(mVar);
                    }
                } else {
                    wVarG.parseFromCentralDirectoryData(localFileDataData, 0, localFileDataData.length);
                }
            }
        }
        r();
    }

    public void p(ZipShort zipShort) {
        if (this.f72538h == null) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        for (w wVar : this.f72538h) {
            if (!zipShort.equals(wVar.getHeaderId())) {
                arrayList.add(wVar);
            }
        }
        if (this.f72538h.length == arrayList.size()) {
            throw new NoSuchElementException();
        }
        this.f72538h = (w[]) arrayList.toArray(f72531s);
        r();
    }

    public void q(long j11) {
        this.f72536f = j11;
    }

    public void r() {
        super.setExtra(d.e(b()));
    }

    public void s(w[] wVarArr) {
        this.f72539i = null;
        ArrayList arrayList = new ArrayList();
        if (wVarArr != null) {
            for (w wVar : wVarArr) {
                if (wVar instanceof l) {
                    this.f72539i = (l) wVar;
                } else {
                    arrayList.add(wVar);
                }
            }
        }
        this.f72538h = (w[]) arrayList.toArray(f72531s);
        r();
    }

    @Override // java.util.zip.ZipEntry
    public void setExtra(byte[] bArr) throws RuntimeException {
        try {
            o(d.f(bArr, true, ExtraFieldParsingMode.BEST_EFFORT), true);
        } catch (ZipException e11) {
            throw new RuntimeException("Error parsing extra fields for entry: " + getName() + " - " + e11.getMessage(), e11);
        }
    }

    @Override // java.util.zip.ZipEntry
    public void setMethod(int i11) {
        if (i11 >= 0) {
            this.f72532a = i11;
            return;
        }
        throw new IllegalArgumentException("ZIP compression method can not be negative: " + i11);
    }

    @Override // java.util.zip.ZipEntry
    public void setSize(long j11) {
        if (j11 < 0) {
            throw new IllegalArgumentException("Invalid entry size");
        }
        this.f72533b = j11;
    }

    public void t(int i11) {
        this.f72534c = i11;
    }

    public void v(String str) {
        if (str != null && m() == 0 && !str.contains("/")) {
            str = str.replace('\\', '/');
        }
        this.f72540j = str;
    }
}
