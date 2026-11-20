package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base;

import java.io.Serializable;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'LOWER_UNDERSCORE' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class CaseFormat {
    private static final /* synthetic */ CaseFormat[] $VALUES;
    public static final CaseFormat LOWER_CAMEL;
    public static final CaseFormat LOWER_HYPHEN;
    public static final CaseFormat LOWER_UNDERSCORE;
    public static final CaseFormat UPPER_CAMEL;
    public static final CaseFormat UPPER_UNDERSCORE;
    private final b wordBoundary;
    private final String wordSeparator;

    /* JADX INFO: compiled from: source.java */
    public static final class StringConverter extends Converter<String, String> implements Serializable {
        private static final long serialVersionUID = 0;
        private final CaseFormat sourceFormat;
        private final CaseFormat targetFormat;

        public StringConverter(CaseFormat caseFormat, CaseFormat caseFormat2) {
            this.sourceFormat = (CaseFormat) l.n(caseFormat);
            this.targetFormat = (CaseFormat) l.n(caseFormat2);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter
        public String doBackward(String str) {
            return this.targetFormat.to(this.sourceFormat, str);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter
        public String doForward(String str) {
            return this.sourceFormat.to(this.targetFormat, str);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Converter, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d
        public boolean equals(Object obj) {
            if (!(obj instanceof StringConverter)) {
                return false;
            }
            StringConverter stringConverter = (StringConverter) obj;
            return this.sourceFormat.equals(stringConverter.sourceFormat) && this.targetFormat.equals(stringConverter.targetFormat);
        }

        public int hashCode() {
            return this.sourceFormat.hashCode() ^ this.targetFormat.hashCode();
        }

        public String toString() {
            return this.sourceFormat + ".converterTo(" + this.targetFormat + ")";
        }
    }

    static {
        CaseFormat caseFormat = new CaseFormat("LOWER_HYPHEN", 0, b.j('-'), "-") { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat.1
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat
            public String convert(CaseFormat caseFormat2, String str) {
                if (caseFormat2 == CaseFormat.LOWER_UNDERSCORE) {
                    return str.replace('-', '_');
                }
                return caseFormat2 == CaseFormat.UPPER_UNDERSCORE ? a.e(str.replace('-', '_')) : super.convert(caseFormat2, str);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat
            public String normalizeWord(String str) {
                return a.c(str);
            }
        };
        LOWER_HYPHEN = caseFormat;
        String str = "_";
        CaseFormat caseFormat2 = new CaseFormat("LOWER_UNDERSCORE", 1, b.j('_'), str) { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat.2
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat
            public String convert(CaseFormat caseFormat3, String str2) {
                if (caseFormat3 == CaseFormat.LOWER_HYPHEN) {
                    return str2.replace('_', '-');
                }
                return caseFormat3 == CaseFormat.UPPER_UNDERSCORE ? a.e(str2) : super.convert(caseFormat3, str2);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat
            public String normalizeWord(String str2) {
                return a.c(str2);
            }
        };
        LOWER_UNDERSCORE = caseFormat2;
        String str2 = "";
        CaseFormat caseFormat3 = new CaseFormat("LOWER_CAMEL", 2, b.g('A', 'Z'), str2) { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat.3
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat
            public String normalizeWord(String str3) {
                return CaseFormat.firstCharOnlyToUpper(str3);
            }
        };
        LOWER_CAMEL = caseFormat3;
        CaseFormat caseFormat4 = new CaseFormat("UPPER_CAMEL", 3, b.g('A', 'Z'), str2) { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat.4
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat
            public String normalizeWord(String str3) {
                return CaseFormat.firstCharOnlyToUpper(str3);
            }
        };
        UPPER_CAMEL = caseFormat4;
        CaseFormat caseFormat5 = new CaseFormat("UPPER_UNDERSCORE", 4, b.j('_'), str) { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat.5
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat
            public String convert(CaseFormat caseFormat6, String str3) {
                if (caseFormat6 == CaseFormat.LOWER_HYPHEN) {
                    return a.c(str3.replace('_', '-'));
                }
                return caseFormat6 == CaseFormat.LOWER_UNDERSCORE ? a.c(str3) : super.convert(caseFormat6, str3);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.CaseFormat
            public String normalizeWord(String str3) {
                return a.e(str3);
            }
        };
        UPPER_UNDERSCORE = caseFormat5;
        $VALUES = new CaseFormat[]{caseFormat, caseFormat2, caseFormat3, caseFormat4, caseFormat5};
    }

    private CaseFormat(String str, int i11, b bVar, String str2) {
        super(str, i11);
        this.wordBoundary = bVar;
        this.wordSeparator = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String firstCharOnlyToUpper(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return a.d(str.charAt(0)) + a.c(str.substring(1));
    }

    private String normalizeFirstWord(String str) {
        return this == LOWER_CAMEL ? a.c(str) : normalizeWord(str);
    }

    public static CaseFormat valueOf(String str) {
        return (CaseFormat) Enum.valueOf(CaseFormat.class, str);
    }

    public static CaseFormat[] values() {
        return (CaseFormat[]) $VALUES.clone();
    }

    public String convert(CaseFormat caseFormat, String str) {
        StringBuilder sb2 = null;
        int length = 0;
        int iH = -1;
        while (true) {
            iH = this.wordBoundary.h(str, iH + 1);
            if (iH == -1) {
                break;
            }
            if (length == 0) {
                sb2 = new StringBuilder(str.length() + (this.wordSeparator.length() * 4));
                sb2.append(caseFormat.normalizeFirstWord(str.substring(length, iH)));
            } else {
                sb2.append(caseFormat.normalizeWord(str.substring(length, iH)));
            }
            sb2.append(caseFormat.wordSeparator);
            length = this.wordSeparator.length() + iH;
        }
        if (length == 0) {
            return caseFormat.normalizeFirstWord(str);
        }
        sb2.append(caseFormat.normalizeWord(str.substring(length)));
        return sb2.toString();
    }

    public Converter<String, String> converterTo(CaseFormat caseFormat) {
        return new StringConverter(this, caseFormat);
    }

    public abstract String normalizeWord(String str);

    public final String to(CaseFormat caseFormat, String str) {
        l.n(caseFormat);
        l.n(str);
        return caseFormat == this ? str : convert(caseFormat, str);
    }
}
