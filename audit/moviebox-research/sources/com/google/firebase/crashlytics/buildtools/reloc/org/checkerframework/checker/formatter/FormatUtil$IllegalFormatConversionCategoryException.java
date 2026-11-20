package com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.formatter;

import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.formatter.qual.ConversionCategory;
import java.util.IllegalFormatConversionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class FormatUtil$IllegalFormatConversionCategoryException extends IllegalFormatConversionException {
    private static final long serialVersionUID = 17000126;
    private final ConversionCategory expected;
    private final ConversionCategory found;

    public FormatUtil$IllegalFormatConversionCategoryException(ConversionCategory conversionCategory, ConversionCategory conversionCategory2) {
        super(conversionCategory.chars.length() == 0 ? '-' : conversionCategory.chars.charAt(0), conversionCategory2.types == null ? Object.class : conversionCategory2.types[0]);
        this.expected = conversionCategory;
        this.found = conversionCategory2;
    }

    public ConversionCategory getExpected() {
        return this.expected;
    }

    public ConversionCategory getFound() {
        return this.found;
    }

    @Override // java.util.IllegalFormatConversionException, java.lang.Throwable
    public String getMessage() {
        return String.format("Expected category %s but found %s.", this.expected, this.found);
    }
}
