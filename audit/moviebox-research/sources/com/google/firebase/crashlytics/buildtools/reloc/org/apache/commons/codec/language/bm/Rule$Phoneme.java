package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm;

import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class Rule$Phoneme {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Comparator<Rule$Phoneme> f40069b = new Comparator<Rule$Phoneme>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Rule$Phoneme.1
        @Override // java.util.Comparator
        public int compare(Rule$Phoneme rule$Phoneme, Rule$Phoneme rule$Phoneme2) {
            for (int i11 = 0; i11 < rule$Phoneme.f40070a.length(); i11++) {
                if (i11 >= rule$Phoneme2.f40070a.length()) {
                    return 1;
                }
                int iCharAt = rule$Phoneme.f40070a.charAt(i11) - rule$Phoneme2.f40070a.charAt(i11);
                if (iCharAt != 0) {
                    return iCharAt;
                }
            }
            return rule$Phoneme.f40070a.length() < rule$Phoneme2.f40070a.length() ? -1 : 0;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StringBuilder f40070a;

    public String toString() {
        return this.f40070a.toString() + "[" + ((Object) null) + "]";
    }
}
