package com.transsion.baselib.db.video;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

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
public interface VideoDetailPlayDao {

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class DefaultImpls {
        /* JADX WARN: Code duplicated, block: B:32:0x0097  */
        /* JADX WARN: Code duplicated, block: B:33:0x00ff  */
        /* JADX WARN: Code duplicated, block: B:7:0x0019  */
        public static Object a(VideoDetailPlayDao videoDetailPlayDao, String str, Continuation<? super VideoDetailPlayBean> continuation) throws Throwable {
            VideoDetailPlayDao$getHistory$1 videoDetailPlayDao$getHistory$1;
            Object obj;
            VideoDetailPlayBean videoDetailPlayBean;
            String str2;
            VideoDetailPlayBean videoDetailPlayBean2;
            VideoDetailPlayDao videoDetailPlayDao2 = videoDetailPlayDao;
            String str3 = str;
            if (continuation instanceof VideoDetailPlayDao$getHistory$1) {
                videoDetailPlayDao$getHistory$1 = (VideoDetailPlayDao$getHistory$1) continuation;
                int i11 = videoDetailPlayDao$getHistory$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    videoDetailPlayDao$getHistory$1.label = i11 - Integer.MIN_VALUE;
                } else {
                    videoDetailPlayDao$getHistory$1 = new VideoDetailPlayDao$getHistory$1(continuation);
                }
            } else {
                videoDetailPlayDao$getHistory$1 = new VideoDetailPlayDao$getHistory$1(continuation);
            }
            Object objO = videoDetailPlayDao$getHistory$1.result;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i12 = videoDetailPlayDao$getHistory$1.label;
            if (i12 == 0) {
                ResultKt.b(objO);
                videoDetailPlayDao$getHistory$1.L$0 = videoDetailPlayDao2;
                videoDetailPlayDao$getHistory$1.L$1 = str3;
                videoDetailPlayDao$getHistory$1.label = 1;
                objO = videoDetailPlayDao2.o(str3, videoDetailPlayDao$getHistory$1);
                if (objO == objE) {
                    return objE;
                }
            } else {
                if (i12 != 1) {
                    if (i12 != 2) {
                        if (i12 == 3) {
                            ResultKt.b(objO);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    videoDetailPlayBean = (VideoDetailPlayBean) videoDetailPlayDao$getHistory$1.L$1;
                    String str4 = (String) videoDetailPlayDao$getHistory$1.L$0;
                    ResultKt.b(objO);
                    str2 = str4;
                    obj = objO;
                    videoDetailPlayBean2 = (VideoDetailPlayBean) obj;
                    if (videoDetailPlayBean2 == null) {
                        return new VideoDetailPlayBean(str2, videoDetailPlayBean.getId(), videoDetailPlayBean.getEp(), videoDetailPlayBean.getSe(), videoDetailPlayBean.getProgress(), videoDetailPlayBean.getTitle(), videoDetailPlayBean.getCoverUrl(), videoDetailPlayBean.getThumbnail(), videoDetailPlayBean.getVideoUrl(), videoDetailPlayBean.getTimeStamp(), videoDetailPlayBean.getSubtitleSelectId(), videoDetailPlayBean.getTotalDuration(), videoDetailPlayBean.getSubjectDurationSeconds(), videoDetailPlayBean.getAverageHueLight(), videoDetailPlayBean.getSubjectType(), videoDetailPlayBean.getHasDelete(), videoDetailPlayBean.getPlayMode(), videoDetailPlayBean.getDownloadUrl(), videoDetailPlayBean.getDownloadFilePath(), videoDetailPlayBean.getDownloadSize(), videoDetailPlayBean.getDubs(), null, null, false, false, false, 65011712, null);
                    }
                    videoDetailPlayBean2.setProgress(videoDetailPlayBean.getProgress());
                    return videoDetailPlayBean2;
                }
                String str5 = (String) videoDetailPlayDao$getHistory$1.L$1;
                VideoDetailPlayDao videoDetailPlayDao3 = (VideoDetailPlayDao) videoDetailPlayDao$getHistory$1.L$0;
                ResultKt.b(objO);
                str3 = str5;
                videoDetailPlayDao2 = videoDetailPlayDao3;
            }
            VideoDetailPlayBean videoDetailPlayBean3 = (VideoDetailPlayBean) objO;
            if (videoDetailPlayBean3 == null) {
                videoDetailPlayDao$getHistory$1.L$0 = null;
                videoDetailPlayDao$getHistory$1.L$1 = null;
                videoDetailPlayDao$getHistory$1.label = 3;
                objO = videoDetailPlayDao2.b(str3, videoDetailPlayDao$getHistory$1);
                return objO == objE ? objE : objO;
            }
            if (Intrinsics.b(videoDetailPlayBean3.getSubjectId(), str3)) {
                return videoDetailPlayBean3;
            }
            videoDetailPlayDao$getHistory$1.L$0 = str3;
            videoDetailPlayDao$getHistory$1.L$1 = videoDetailPlayBean3;
            videoDetailPlayDao$getHistory$1.label = 2;
            Object objB = videoDetailPlayDao2.b(str3, videoDetailPlayDao$getHistory$1);
            if (objB == objE) {
                return objE;
            }
            String str6 = str3;
            obj = objB;
            videoDetailPlayBean = videoDetailPlayBean3;
            str2 = str6;
            videoDetailPlayBean2 = (VideoDetailPlayBean) obj;
            if (videoDetailPlayBean2 == null) {
                return new VideoDetailPlayBean(str2, videoDetailPlayBean.getId(), videoDetailPlayBean.getEp(), videoDetailPlayBean.getSe(), videoDetailPlayBean.getProgress(), videoDetailPlayBean.getTitle(), videoDetailPlayBean.getCoverUrl(), videoDetailPlayBean.getThumbnail(), videoDetailPlayBean.getVideoUrl(), videoDetailPlayBean.getTimeStamp(), videoDetailPlayBean.getSubtitleSelectId(), videoDetailPlayBean.getTotalDuration(), videoDetailPlayBean.getSubjectDurationSeconds(), videoDetailPlayBean.getAverageHueLight(), videoDetailPlayBean.getSubjectType(), videoDetailPlayBean.getHasDelete(), videoDetailPlayBean.getPlayMode(), videoDetailPlayBean.getDownloadUrl(), videoDetailPlayBean.getDownloadFilePath(), videoDetailPlayBean.getDownloadSize(), videoDetailPlayBean.getDubs(), null, null, false, false, false, 65011712, null);
            }
            videoDetailPlayBean2.setProgress(videoDetailPlayBean.getProgress());
            return videoDetailPlayBean2;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public static Object b(VideoDetailPlayDao videoDetailPlayDao, VideoDetailPlayBean videoDetailPlayBean, Continuation<? super Unit> continuation) throws Throwable {
            VideoDetailPlayDao$insertOrUpdate$1 videoDetailPlayDao$insertOrUpdate$1;
            if (continuation instanceof VideoDetailPlayDao$insertOrUpdate$1) {
                videoDetailPlayDao$insertOrUpdate$1 = (VideoDetailPlayDao$insertOrUpdate$1) continuation;
                int i11 = videoDetailPlayDao$insertOrUpdate$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    videoDetailPlayDao$insertOrUpdate$1.label = i11 - Integer.MIN_VALUE;
                } else {
                    videoDetailPlayDao$insertOrUpdate$1 = new VideoDetailPlayDao$insertOrUpdate$1(continuation);
                }
            } else {
                videoDetailPlayDao$insertOrUpdate$1 = new VideoDetailPlayDao$insertOrUpdate$1(continuation);
            }
            Object objL = videoDetailPlayDao$insertOrUpdate$1.result;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i12 = videoDetailPlayDao$insertOrUpdate$1.label;
            if (i12 == 0) {
                ResultKt.b(objL);
                String subjectId = videoDetailPlayBean.getSubjectId();
                int se2 = videoDetailPlayBean.getSe();
                int ep2 = videoDetailPlayBean.getEp();
                videoDetailPlayDao$insertOrUpdate$1.L$0 = videoDetailPlayDao;
                videoDetailPlayDao$insertOrUpdate$1.L$1 = videoDetailPlayBean;
                videoDetailPlayDao$insertOrUpdate$1.label = 1;
                objL = videoDetailPlayDao.l(subjectId, se2, ep2, videoDetailPlayDao$insertOrUpdate$1);
                if (objL == objE) {
                    return objE;
                }
            } else {
                if (i12 != 1) {
                    if (i12 == 2) {
                        ResultKt.b(objL);
                        return Unit.f68710a;
                    }
                    if (i12 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(objL);
                    return Unit.f68710a;
                }
                videoDetailPlayBean = (VideoDetailPlayBean) videoDetailPlayDao$insertOrUpdate$1.L$1;
                videoDetailPlayDao = (VideoDetailPlayDao) videoDetailPlayDao$insertOrUpdate$1.L$0;
                ResultKt.b(objL);
            }
            if (objL == null) {
                videoDetailPlayDao$insertOrUpdate$1.L$0 = null;
                videoDetailPlayDao$insertOrUpdate$1.L$1 = null;
                videoDetailPlayDao$insertOrUpdate$1.label = 2;
                if (videoDetailPlayDao.p(videoDetailPlayBean, videoDetailPlayDao$insertOrUpdate$1) == objE) {
                    return objE;
                }
                return Unit.f68710a;
            }
            videoDetailPlayDao$insertOrUpdate$1.L$0 = null;
            videoDetailPlayDao$insertOrUpdate$1.L$1 = null;
            videoDetailPlayDao$insertOrUpdate$1.label = 3;
            if (videoDetailPlayDao.j(videoDetailPlayBean, videoDetailPlayDao$insertOrUpdate$1) == objE) {
                return objE;
            }
            return Unit.f68710a;
        }

        /* JADX WARN: Code duplicated, block: B:33:0x00d9  */
        /* JADX WARN: Code duplicated, block: B:34:0x0116  */
        /* JADX WARN: Code duplicated, block: B:37:0x0158 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:46:0x0173  */
        /* JADX WARN: Code duplicated, block: B:48:0x0181 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:7:0x001d  */
        public static Object c(VideoDetailPlayDao videoDetailPlayDao, String str, int i11, int i12, long j11, long j12, Continuation<? super Unit> continuation) throws Throwable {
            VideoDetailPlayDao$insertOrUpdateProgress$1 videoDetailPlayDao$insertOrUpdateProgress$1;
            long j13;
            int i13;
            VideoDetailPlayDao videoDetailPlayDao2;
            String str2;
            Object obj;
            int i14;
            long j14;
            Object obj2;
            long j15;
            VideoDetailPlayDao videoDetailPlayDao3;
            long j16;
            int i15;
            long j17;
            int i16;
            String str3;
            VideoDetailPlayDao videoDetailPlayDao4;
            VideoDetailPlayBean videoDetailPlayBean;
            VideoDetailPlayBean videoDetailPlayBean2;
            VideoDetailPlayBean videoDetailPlayBean3;
            if (continuation instanceof VideoDetailPlayDao$insertOrUpdateProgress$1) {
                videoDetailPlayDao$insertOrUpdateProgress$1 = (VideoDetailPlayDao$insertOrUpdateProgress$1) continuation;
                int i17 = videoDetailPlayDao$insertOrUpdateProgress$1.label;
                if ((i17 & Integer.MIN_VALUE) != 0) {
                    videoDetailPlayDao$insertOrUpdateProgress$1.label = i17 - Integer.MIN_VALUE;
                } else {
                    videoDetailPlayDao$insertOrUpdateProgress$1 = new VideoDetailPlayDao$insertOrUpdateProgress$1(continuation);
                }
            } else {
                videoDetailPlayDao$insertOrUpdateProgress$1 = new VideoDetailPlayDao$insertOrUpdateProgress$1(continuation);
            }
            Object objD = videoDetailPlayDao$insertOrUpdateProgress$1.result;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i18 = videoDetailPlayDao$insertOrUpdateProgress$1.label;
            if (i18 == 0) {
                ResultKt.b(objD);
                videoDetailPlayDao$insertOrUpdateProgress$1.L$0 = videoDetailPlayDao;
                videoDetailPlayDao$insertOrUpdateProgress$1.L$1 = str;
                videoDetailPlayDao$insertOrUpdateProgress$1.I$0 = i11;
                videoDetailPlayDao$insertOrUpdateProgress$1.I$1 = i12;
                videoDetailPlayDao$insertOrUpdateProgress$1.J$0 = j11;
                j13 = j12;
                videoDetailPlayDao$insertOrUpdateProgress$1.J$1 = j13;
                videoDetailPlayDao$insertOrUpdateProgress$1.label = 1;
                Object objL = videoDetailPlayDao.l(str, i11, i12, videoDetailPlayDao$insertOrUpdateProgress$1);
                if (objL == objE) {
                    return objE;
                }
                i13 = i11;
                videoDetailPlayDao2 = videoDetailPlayDao;
                str2 = str;
                obj = objL;
                i14 = i12;
                j14 = j11;
            } else {
                if (i18 != 1) {
                    if (i18 == 2) {
                        long j18 = videoDetailPlayDao$insertOrUpdateProgress$1.J$1;
                        long j19 = videoDetailPlayDao$insertOrUpdateProgress$1.J$0;
                        int i19 = videoDetailPlayDao$insertOrUpdateProgress$1.I$1;
                        int i21 = videoDetailPlayDao$insertOrUpdateProgress$1.I$0;
                        String str4 = (String) videoDetailPlayDao$insertOrUpdateProgress$1.L$1;
                        videoDetailPlayDao4 = (VideoDetailPlayDao) videoDetailPlayDao$insertOrUpdateProgress$1.L$0;
                        ResultKt.b(objD);
                        j17 = j18;
                        j16 = j19;
                        i15 = i19;
                        i16 = i21;
                        str3 = str4;
                        videoDetailPlayBean = (VideoDetailPlayBean) objD;
                        if (videoDetailPlayBean != null) {
                            videoDetailPlayBean2 = new VideoDetailPlayBean(videoDetailPlayBean.getSubjectId(), videoDetailPlayBean.getId(), i15, i16, j17, null, null, null, null, j16, null, null, null, null, null, false, null, null, null, 0L, null, null, null, false, false, false, 67108320, null);
                        } else {
                            videoDetailPlayBean2 = new VideoDetailPlayBean(str3, "", i15, i16, j17, null, null, null, null, j16, null, null, null, null, null, false, null, null, null, 0L, null, null, null, false, false, false, 67108320, null);
                        }
                        videoDetailPlayDao$insertOrUpdateProgress$1.L$0 = null;
                        videoDetailPlayDao$insertOrUpdateProgress$1.L$1 = null;
                        videoDetailPlayDao$insertOrUpdateProgress$1.label = 3;
                        if (videoDetailPlayDao4.p(videoDetailPlayBean2, videoDetailPlayDao$insertOrUpdateProgress$1) == objE) {
                            return objE;
                        }
                    } else {
                        if (i18 != 3) {
                            if (i18 == 4) {
                                j15 = videoDetailPlayDao$insertOrUpdateProgress$1.J$0;
                                videoDetailPlayDao3 = (VideoDetailPlayDao) videoDetailPlayDao$insertOrUpdateProgress$1.L$0;
                                ResultKt.b(objD);
                                obj2 = objD;
                                videoDetailPlayBean3 = (VideoDetailPlayBean) obj2;
                                if (videoDetailPlayBean3 != null) {
                                    videoDetailPlayBean3.setProgress(j15);
                                    videoDetailPlayDao$insertOrUpdateProgress$1.L$0 = null;
                                    videoDetailPlayDao$insertOrUpdateProgress$1.label = 5;
                                    if (videoDetailPlayDao3.j(videoDetailPlayBean3, videoDetailPlayDao$insertOrUpdateProgress$1) == objE) {
                                        return objE;
                                    }
                                }
                            } else {
                                if (i18 != 5) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.b(objD);
                            }
                            return Unit.f68710a;
                        }
                        ResultKt.b(objD);
                    }
                    return Unit.f68710a;
                }
                long j21 = videoDetailPlayDao$insertOrUpdateProgress$1.J$1;
                j14 = videoDetailPlayDao$insertOrUpdateProgress$1.J$0;
                i14 = videoDetailPlayDao$insertOrUpdateProgress$1.I$1;
                i13 = videoDetailPlayDao$insertOrUpdateProgress$1.I$0;
                str2 = (String) videoDetailPlayDao$insertOrUpdateProgress$1.L$1;
                videoDetailPlayDao2 = (VideoDetailPlayDao) videoDetailPlayDao$insertOrUpdateProgress$1.L$0;
                ResultKt.b(objD);
                j13 = j21;
                obj = objD;
            }
            if (obj != null) {
                videoDetailPlayDao$insertOrUpdateProgress$1.L$0 = videoDetailPlayDao2;
                videoDetailPlayDao$insertOrUpdateProgress$1.L$1 = null;
                videoDetailPlayDao$insertOrUpdateProgress$1.J$0 = j13;
                videoDetailPlayDao$insertOrUpdateProgress$1.label = 4;
                Object objK = videoDetailPlayDao2.k(str2, i13, i14, videoDetailPlayDao$insertOrUpdateProgress$1);
                if (objK == objE) {
                    return objE;
                }
                obj2 = objK;
                j15 = j13;
                videoDetailPlayDao3 = videoDetailPlayDao2;
                videoDetailPlayBean3 = (VideoDetailPlayBean) obj2;
                if (videoDetailPlayBean3 != null) {
                    videoDetailPlayBean3.setProgress(j15);
                    videoDetailPlayDao$insertOrUpdateProgress$1.L$0 = null;
                    videoDetailPlayDao$insertOrUpdateProgress$1.label = 5;
                    if (videoDetailPlayDao3.j(videoDetailPlayBean3, videoDetailPlayDao$insertOrUpdateProgress$1) == objE) {
                        return objE;
                    }
                }
                return Unit.f68710a;
            }
            videoDetailPlayDao$insertOrUpdateProgress$1.L$0 = videoDetailPlayDao2;
            videoDetailPlayDao$insertOrUpdateProgress$1.L$1 = str2;
            videoDetailPlayDao$insertOrUpdateProgress$1.I$0 = i13;
            videoDetailPlayDao$insertOrUpdateProgress$1.I$1 = i14;
            videoDetailPlayDao$insertOrUpdateProgress$1.J$0 = j14;
            videoDetailPlayDao$insertOrUpdateProgress$1.J$1 = j13;
            videoDetailPlayDao$insertOrUpdateProgress$1.label = 2;
            objD = videoDetailPlayDao2.d(str2, videoDetailPlayDao$insertOrUpdateProgress$1);
            if (objD == objE) {
                return objE;
            }
            j16 = j14;
            i15 = i14;
            j17 = j13;
            i16 = i13;
            str3 = str2;
            videoDetailPlayDao4 = videoDetailPlayDao2;
            videoDetailPlayBean = (VideoDetailPlayBean) objD;
            if (videoDetailPlayBean != null) {
                videoDetailPlayBean2 = new VideoDetailPlayBean(videoDetailPlayBean.getSubjectId(), videoDetailPlayBean.getId(), i15, i16, j17, null, null, null, null, j16, null, null, null, null, null, false, null, null, null, 0L, null, null, null, false, false, false, 67108320, null);
            } else {
                videoDetailPlayBean2 = new VideoDetailPlayBean(str3, "", i15, i16, j17, null, null, null, null, j16, null, null, null, null, null, false, null, null, null, 0L, null, null, null, false, false, false, 67108320, null);
            }
            videoDetailPlayDao$insertOrUpdateProgress$1.L$0 = null;
            videoDetailPlayDao$insertOrUpdateProgress$1.L$1 = null;
            videoDetailPlayDao$insertOrUpdateProgress$1.label = 3;
            if (videoDetailPlayDao4.p(videoDetailPlayBean2, videoDetailPlayDao$insertOrUpdateProgress$1) == objE) {
                return objE;
            }
            return Unit.f68710a;
        }
    }

    Object a(Continuation<? super Unit> continuation);

    Object b(String str, Continuation<? super VideoDetailPlayBean> continuation);

    Object c(String str, String str2, Continuation<? super Unit> continuation);

    Object d(String str, Continuation<? super VideoDetailPlayBean> continuation);

    Object e(String str, int i11, int i12, long j11, long j12, Continuation<? super Unit> continuation);

    Object f(String str, Continuation<? super Long> continuation);

    Object g(VideoDetailPlayBean videoDetailPlayBean, Continuation<? super Unit> continuation);

    Object h(int i11, int i12, int i13, Continuation<? super List<VideoDetailPlayBean>> continuation);

    Object i(String str, Continuation<? super List<VideoDetailPlayBean>> continuation);

    Object j(VideoDetailPlayBean videoDetailPlayBean, Continuation<? super Unit> continuation);

    Object k(String str, int i11, int i12, Continuation<? super VideoDetailPlayBean> continuation);

    Object l(String str, int i11, int i12, Continuation<? super VideoDetailPlayBean> continuation);

    Object m(long j11, Continuation<? super List<VideoDetailPlayBean>> continuation);

    Object n(int i11, int i12, Continuation<? super List<VideoDetailPlayBean>> continuation);

    Object o(String str, Continuation<? super VideoDetailPlayBean> continuation);

    Object p(VideoDetailPlayBean videoDetailPlayBean, Continuation<? super Unit> continuation);

    Object q(VideoDetailPlayBean videoDetailPlayBean, Continuation<? super Unit> continuation);

    List<VideoDetailPlayBean> r(long j11);
}
