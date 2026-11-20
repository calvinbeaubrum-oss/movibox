package vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a implements qf.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ThreadLocal<SimpleDateFormat> f79027a = new C0877a();

    /* JADX INFO: renamed from: vo.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0877a extends ThreadLocal<SimpleDateFormat> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        }
    }

    @Override // qf.b
    public String a(int i11, long j11) {
        String string;
        StringBuilder sb2;
        SimpleDateFormat simpleDateFormat = this.f79027a.get();
        if (simpleDateFormat != null) {
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
        }
        if (simpleDateFormat == null) {
            string = UUID.randomUUID().toString();
            sb2 = new StringBuilder();
        } else {
            string = simpleDateFormat.format(new Date(j11));
            sb2 = new StringBuilder();
        }
        sb2.append(string);
        sb2.append(".log");
        return sb2.toString();
    }

    @Override // qf.b
    public boolean b() {
        return true;
    }
}
