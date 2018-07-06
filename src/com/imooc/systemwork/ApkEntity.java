package com.imooc.systemwork;

import java.util.List;



import android.app.Application;

public class ApkEntity extends Application{
	private String des;
	private String info;
	private String department_t1;
	private String class_t1;
	private String student_t1;
	private String course_t1;
	private String teacher_t1;
	private String teacher_information_listview_t1;
	private String teacher_information_listview_t2;
	private String teacher_coursemanagementt1;
	private String teacher_studentstudy_listview_t1;
	private String teacher_studentstudy_listview_t2;
	private String teacher_knowledgelv;
	private String teacher_filelv_t1;
	private String teacher_filelv_t2;
	private String teacher_filelv_t3;
	private String teacher_combinedtraininglv;
	private String comprehensive_traininglvt1;
	private String teaching_information_listview_t1;
	private String teaching_information_listview_t2;
	private String teacher_task_managementlv_t1;
	private String teacher_task_managementlv_t2;
	private String teacher_task_managementlv_t3;
	private String teaching_words_setlv_t1;
	private String teaching_comment_supervision_t1;
	private String teaching_comment_supervision_t2;
    private String review_training_planlvt1;
    private int teaching_comment_supervision_pic;
    private String tongzhilvt1;
	private String tv1_item_xueyouquan;
	private String zixun_img2;
	private String zixun_title;
	private String tv_xiaoxi1;
	private String tv_xiaoxi3;
	public String tv1_wodekecheng;
	public String tv2_wodekecheng;
	public String tv3_wodekecheng;
	public String tv5_wodekecheng;
	public String tv_chengjiitem1;
	public String tv_chengjiitem3;
	public String tv_renwuitem2;
	public String tv_nengliitem1;
	public String tv_nengliitem3;
	public String tv1_zixunxiangqing;
	public String img_zixunxiangqing;
	public String tv3_zixunxiangqing;
	public String tv4_zixunxiangqing;
	public String tv1_item_tongzhi2;
	public String tv1_item_shixun1;
	public String tv1_item_yuanxiaoxuanze;
	public String tv_allkecheng1;

	
	private static String theme;	
	public static String gettheme() {
		return theme;
	}
	public void settheme(String theme) {
		ApkEntity.theme = theme;
	}
	
	private static String xueyouquan_theme;
	public static String getxueyouquan_theme() {
		return xueyouquan_theme;
	}
	public void setxueyouquan_theme(String xueyouquan_theme) {
		ApkEntity.xueyouquan_theme = xueyouquan_theme;
	}
	
	private static String tongzhi_theme;
	public static String gettongzhi_theme() {
		return tongzhi_theme;
	}
	public void settongzhi_theme(String tongzhi_theme) {
		ApkEntity.tongzhi_theme = tongzhi_theme;
	}
	
	private static String renwu_theme;
	public static String getrenwu_theme() {
		return renwu_theme;
	}
	public void setrenwu_theme(String renwu_theme) {
		ApkEntity.renwu_theme = renwu_theme;
	}
	
	public String gettongzhilvt1() {
		return tongzhilvt1;
	}
	public void settongzhilvt1(String teacher_combinedtraininglvt1) {
		this.tongzhilvt1 = teacher_combinedtraininglvt1;
	}
	
	public String gettv1_item_xueyouquan() {
		return tv1_item_xueyouquan;
	}
	public void settv1_item_xueyouquan(String tv1_item_xueyouquan) {
		this.tongzhilvt1 = tv1_item_xueyouquan;
	}
	
	public String getzixun_img2() {
		return zixun_img2;
	}
	public void setzixun_img2(String zixunpicture) {
		this.zixun_img2 = zixunpicture;
	}
	
	public String getzixun_title() {
		return zixun_title;
	}
	public void setzixun_title(String zixun_title) {
		this.zixun_title = zixun_title;
	}
	
	public String gettv_xiaoxi1() {
		return tv_xiaoxi1;
	}
	public void settv_xiaoxi1(String tv_xiaoxi1) {
		this.tv_xiaoxi1 = tv_xiaoxi1;
	}
	
	public String gettv_xiaoxi3() {
		return tv_xiaoxi3;
	}
	public void settv_xiaoxi3(String tv_xiaoxi3) {
		this.tv_xiaoxi3 = tv_xiaoxi3;
	}
	
	public String gettv1_wodekecheng() {
		return tv1_wodekecheng;
	}
	public void settv1_wodekecheng(String tv1_wodekecheng) {
		this.tv1_wodekecheng = tv1_wodekecheng;
	}
	
	public String gettv2_wodekecheng() {
		return tv2_wodekecheng;
	}
	public void settv2_wodekecheng(String tv2_wodekecheng) {
		this.tv2_wodekecheng = tv2_wodekecheng;
	}
	
	public String gettv3_wodekecheng() {
		return tv3_wodekecheng;
	}
	public void settv3_wodekecheng(String tv3_wodekecheng) {
		this.tv3_wodekecheng = tv3_wodekecheng;
	}
	
	public String gettv5_wodekecheng() {
		return tv5_wodekecheng;
	}
	public void settv5_wodekecheng(String tv5_wodekecheng) {
		this.tv5_wodekecheng = tv5_wodekecheng;
	}
	
	public String gettv_chengjiitem1() {
		return tv_chengjiitem1;
	}
	public void settv_chengjiitem1(String tv_chengjiitem1) {
		this.tv_chengjiitem1 = tv_chengjiitem1;
	}
	
	public String gettv_chengjiitem3() {
		return tv_chengjiitem3;
	}
	public void settv_chengjiitem3(String tv_chengjiitem3) {
		this.tv_chengjiitem3 = tv_chengjiitem3 ;
	}
	
	public String gettv_renwuitem2() {
		return tv_renwuitem2;
	}
	public void settv_renwuitem2(String tv_renwuitem2) {
		this.tv_renwuitem2 = tv_renwuitem2 ;
	}
	
	public String gettv_nengliitem1() {
		return tv_nengliitem1;
	}
	public void settv_nengliitem1(String tv_nengliitem1) {
		this.tv_nengliitem1 = tv_nengliitem1 ;
	}
	
	public String gettv_nengliitem3() {
		return tv_nengliitem3;
	}
	public void settv_nengliitem3(String tv_nengliitem3) {
		this.tv_nengliitem3 = tv_nengliitem3 ;
	}
	
	public String gettv1_zixunxiangqing() {
		return tv1_zixunxiangqing;
	}
	public void settv1_zixunxiangqing(String tv1_zixunxiangqing) {
		this.tv1_zixunxiangqing = tv1_zixunxiangqing ;
	}
	
	public String gettv3_zixunxiangqing() {
		return tv3_zixunxiangqing;
	}
	public void settv3_zixunxiangqing(String tv3_zixunxiangqing) {
		this.tv3_zixunxiangqing= tv3_zixunxiangqing ;
	}
	
	public String gettv4_zixunxiangqing() {
		return tv4_zixunxiangqing;
	}
	public void settv4_zixunxiangqing(String tv4_zixunxiangqing) {
		this.tv4_zixunxiangqing= tv4_zixunxiangqing ;
	}
	
	public String getimg_zixunxiangqing() {
		return img_zixunxiangqing;
	}
	public void setimg_zixunxiangqing(String img_zixunxiangqing) {
		this.img_zixunxiangqing= img_zixunxiangqing ;
	}
	
	public String gettv1_item_tongzhi2() {
		return tv1_item_tongzhi2;
	}	
	public void settv1_item_tongzhi2(String tv1_item_tongzhi2) {
		this.tongzhilvt1= tv1_item_tongzhi2;
	}
	
	public String gettv1_item_shixun1() {
		return tv1_item_shixun1;
	}	
	public void settv1_item_shixun1(String tv1_item_shixun1) {
		this.tv1_item_shixun1= tv1_item_shixun1;
	}
	
	public String gettv1_item_yuanxiaoxuanze() {
		return tv1_item_yuanxiaoxuanze;
	}	
	public void settv1_item_yuanxiaoxuanze(String tv1_item_yuanxiaoxuanze) {
		this.tv1_item_yuanxiaoxuanze= tv1_item_yuanxiaoxuanze;
	}
	
	public String gettv_allkecheng1() {
		return tv_allkecheng1;
	}	
	public void settv_allkecheng1(String tv_allkecheng1) {
		this.tv_allkecheng1= tv_allkecheng1;
	}
    
    private String review_training_planlvt2;
    public String getreview_training_planlvt2() {
		return review_training_planlvt2;
	}
	public void setreview_training_planlvt2(String review_training_planlvt2) {
		this.review_training_planlvt2 = review_training_planlvt2;
	}
    public String getreview_training_planlvt1() {
		return review_training_planlvt1;
	}
	public void setreview_training_planlvt1(String review_training_planlvt1) {
		this.review_training_planlvt1 = review_training_planlvt1;
	}
	public int getteaching_comment_supervision_pic() {
		return teaching_comment_supervision_pic;
	}
	public void setteaching_comment_supervision_pic(int teaching_comment_supervision_pic) {
		this.teaching_comment_supervision_pic = teaching_comment_supervision_pic;
	}
	
	public String getteaching_comment_supervision_t2() {
		return teaching_comment_supervision_t2;
	}
	public void setteaching_comment_supervision_t2(String teaching_comment_supervision_t2) {
		this.teaching_comment_supervision_t2 = teaching_comment_supervision_t2;
	}
	public String getteaching_comment_supervision_t1() {
		return teaching_comment_supervision_t1;
	}
	public void setteaching_comment_supervision_t1(String teaching_comment_supervision_t1) {
		this.teaching_comment_supervision_t1 = teaching_comment_supervision_t1;
	}
	public String getteaching_words_setlv_t1() {
		return teaching_words_setlv_t1;
	}
	public void setteaching_words_setlv_t1(String teaching_words_setlv_t1) {
		this.teaching_words_setlv_t1 = teaching_words_setlv_t1;
	}
	public String getteacher_task_managementlv_t3() {
		return teacher_task_managementlv_t3;
	}
	public void setteacher_task_managementlv_t3(String teacher_task_managementlv_t3) {
		this.teacher_task_managementlv_t3 = teacher_task_managementlv_t3;
	}
	public String getteacher_task_managementlv_t2() {
		return teacher_task_managementlv_t2;
	}
	public void setteacher_task_managementlv_t2(String teacher_task_managementlv_t2) {
		this.teacher_task_managementlv_t2 = teacher_task_managementlv_t2;
	}
	public String getteacher_task_managementlv_t1() {
		return teacher_task_managementlv_t1;
	}
	public void setteacher_task_managementlv_t1(String teacher_task_managementlv_t1) {
		this.teacher_task_managementlv_t1 = teacher_task_managementlv_t1;
	}
	public String getteaching_information_listview_t1() {
		return teaching_information_listview_t1;
	}
	public void setteaching_information_listview_t1(String teaching_information_listview_t1) {
		this.teaching_information_listview_t1 = teaching_information_listview_t1;
	}
	public String getteaching_information_listview_t2() {
		return teaching_information_listview_t2;
	}
	public void setteaching_information_listview_t2(String teaching_information_listview_t2) {
		this.teaching_information_listview_t2 = teaching_information_listview_t2;
	}
	public String getcomprehensive_traininglvt1() {
		return comprehensive_traininglvt1;
	}
	public void setcomprehensive_traininglvt1(String comprehensive_traininglvt1) {
		this.comprehensive_traininglvt1 = comprehensive_traininglvt1;
	}
	public String getteacher_combinedtraininglv() {
		return teacher_combinedtraininglv;
	}
	public void setteacher_combinedtraininglv(String teacher_combinedtraininglv) {
		this.teacher_combinedtraininglv = teacher_combinedtraininglv;
	}
	public String getteacher_filelv_t1() {
		return teacher_filelv_t1;
	}
	public void setteacher_filelv_t1(String teacher_filelv_t1) {
		this.teacher_filelv_t1 = teacher_filelv_t1;
	}
	public String getteacher_filelv_t2() {
		return teacher_filelv_t2;
	}
	public void setteacher_filelv_t2(String teacher_filelv_t2) {
		this.teacher_filelv_t2 = teacher_filelv_t2;
	}
	public String getteacher_filelv_t3() {
		return teacher_filelv_t3;
	}
	public void setteacher_filelv_t3(String teacher_filelv_t3) {
		this.teacher_filelv_t3 = teacher_filelv_t3;
	}
	public String getteacher_knowledgelv() {
		return teacher_knowledgelv;
	}
	public void setteacher_knowledgelv(String teacher_knowledgelv) {
		this.teacher_knowledgelv = teacher_knowledgelv;
	}
	public String getteacher_studentstudy_listview_t1() {
		return teacher_studentstudy_listview_t1;
	}
	public void setteacher_studentstudy_listview_t1(String teacher_studentstudy_listview_t1) {
		this.teacher_studentstudy_listview_t1 = teacher_studentstudy_listview_t1;
	}
	public String getteacher_coursemanagementt1() {
		return teacher_coursemanagementt1;
	}
	public void setteacher_studentstudy_listview_t2(String teacher_studentstudy_listview_t2) {
		this.teacher_studentstudy_listview_t2 = teacher_studentstudy_listview_t2;
	}
	public String getteacher_studentstudy_listview_t2() {
		return teacher_studentstudy_listview_t2;
	}
	public void setteacher_coursemanagementt1(String teacher_coursemanagementt1) {
		this.teacher_coursemanagementt1 = teacher_coursemanagementt1;
	}
	public String getteacher_information_listview_t1() {
		return teacher_information_listview_t1;
	}
	public void setteacher_information_listview_t1(String teacher_information_listview_t1) {
		this.teacher_information_listview_t1 = teacher_information_listview_t1;
	}
	public String getteacher_information_listview_t2() {
		return teacher_information_listview_t2;
	}
	public void setteacher_information_listview_t2(String teacher_information_listview_t2) {
		this.teacher_information_listview_t2 = teacher_information_listview_t2;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	public String getdepartment_t1() {
		return department_t1;
	}
	public void setdepartment_t1(String department_t1) {
		this.department_t1 = department_t1;
	}
	public String getclass_t1() {
		return class_t1;
	}
	public void setclass_t1(String class_t1) {
		this.class_t1 = class_t1;
	}
	public String getstudent_t1() {
		return student_t1;
	}
	public void setstudent_t1(String student_t1) {
		this.student_t1 = student_t1;
	}

	public String getcourse_t1() {
		return course_t1;
	}
	public void setcourse_t1(String course_t1) {
		this.course_t1 = course_t1;
	}
	public String getteacher_t1() {
		return teacher_t1;
	}
	public void setteacher_1(String teacher_t1) {
		this.teacher_t1 = teacher_t1;
	}
	
private static String file_student;
	
	public static String getfile_student() {
		return file_student;
	}
	public void setfile_student(String file_student) {
		ApkEntity.file_student = file_student;
	}
private static String student_account;
	
	public static String getstudent_account() {
		return student_account;
	}
	public void setstudent_account(String student_account) {
		ApkEntity.student_account = student_account;
	}
private static String coursename;
	
	public static String getcoursename() {
		return coursename;
	}
	public void setcoursename(String coursename) {
		ApkEntity.coursename = coursename;
	}
private static String teacher_account;
	
	public static String getteacher_account() {
		return teacher_account;
	}
	public void setteacher_account (String teacher_account) {
		ApkEntity.teacher_account = teacher_account;
	}
private static String vodiourl;
	
	public static String getvodiourl() {
		return vodiourl;
	}
	public void setvodiourl(String vodiourl) {
		ApkEntity.vodiourl = vodiourl;
	}
private static String vodioname;
	
	public static String getvodioname() {
		return vodioname;
	}
	public void setvodioname(String vodioname) {
		ApkEntity.vodioname = vodioname;
	}
private static String liveurl;
	
	public static String getliveurl() {
		return liveurl;
	}
	public void setliveurl(String liveurl) {
		ApkEntity.liveurl = liveurl;
	}
private static String teachername;
	
	public static String getteachername() {
		return teachername;
	}
	public void setteachername(String teachername) {
		ApkEntity.teachername = teachername;
	}
private static int aa;
	
	public static int getaa() {
		return aa;
	}
	public void setaa(int aa) {
		ApkEntity.aa = aa;
	}
private static int ab;
	
	public static int getab() {
		return ab;
	}
	public void setab(int ab) {
		ApkEntity.ab = ab;
	}
private static int ac;
	
	public static int getac() {
		return ac;
	}
	public void setac(int ac) {
		ApkEntity.ac = ac;
	}
private static int ad;
	
	public static int getad() {
		return ad;
	}
	public void setad(int ad) {
		ApkEntity.ad = ad;
	}
private static String account;
	
	public static String getaccount() {
		return account;
	}
	public void setaccount(String account) {
		ApkEntity.account = account;
	}
private static String account_name;
	
	public static String getaccount_name() {
		return account_name;
	}
	public void setaccount_name(String account_name) {
		ApkEntity.account_name = account_name;
	}
private static String renwucourse;
	
	public static String getrenwucourse() {
		return renwucourse;
	}
	public void setrenwucourse(String renwucourse) {
		ApkEntity.renwucourse = renwucourse;
	}
private static String renwutitle;
	
	public static String getrenwutitle() {
		return renwutitle;
	}
	public void setrenwutitle(String renwutitle) {
		ApkEntity.renwutitle = renwutitle;
	}
private static String taskType;
	
	public static String gettaskType() {
		return taskType;
	}
	public void settaskType(String taskType) {
		ApkEntity.taskType = taskType;
	}
private static String organization;
	
	public static String getorganization() {
		return organization;
	}
	public void setorganization(String organization) {
		ApkEntity.organization = organization;
	}
private static String sousuo;
	
	public static String getsousuo() {
		return sousuo;
	}
	public void setsousuo(String sousuo) {
		ApkEntity.sousuo = sousuo;
	}
	
	private String review_training_planlvt3;
    public String getreview_training_planlvt3() {
		return review_training_planlvt3;
	}
	public void setreview_training_planlvt3(String review_training_planlvt3) {
		this.review_training_planlvt3 = review_training_planlvt3;
	}
	
private static String shixuncourse;
	
	public static String getshixuncourse() {
		return shixuncourse;
	}
	public void setshixuncourse (String shixuncourse) {
		ApkEntity.shixuncourse = shixuncourse;
	}
private static String shixunteacher;
	
	public static String getshixunteacher() {
		return shixunteacher;
	}
	public void setshixunteacher (String shixunteacher) {
		ApkEntity.shixunteacher = shixunteacher;
	}
private static String shixuncontent;
	
	public static String getshixuncontent() {
		return shixuncontent;
	}
	public void setshixuncontent (String shixuncontent) {
		ApkEntity.shixuncontent = shixuncontent;
	}
	
	private String teacher_renwuxiangqingtv;
    public String getteacher_renwuxiangqingtv() {
		return teacher_renwuxiangqingtv;
	}
	public void setteacher_renwuxiangqingtv(String teacher_renwuxiangqingtv) {
		this.teacher_renwuxiangqingtv = teacher_renwuxiangqingtv;
	}
private static String data_coursename;
	
	public static String getdata_coursename() {
		return data_coursename;
	}
	public void setdata_coursename(String data_coursename) {
		ApkEntity.data_coursename = data_coursename;
	}
	private String student_marklv_t1;
    public String getstudent_marklv_t1() {
		return student_marklv_t1;
	}
	public void setstudent_marklv_t1(String student_marklv_t1) {
		this.student_marklv_t1 = student_marklv_t1;
	}
	private String teaching_student_mark_t2;
    public String getteaching_student_mark_t2() {
		return teaching_student_mark_t2;
	}
	public void setteaching_student_mark_t2(String teaching_student_mark_t2) {
		this.teaching_student_mark_t2 = teaching_student_mark_t2;
	}
	private String teaching_student_mark_t1;
    public String getteaching_student_mark_t1() {
		return teaching_student_mark_t1;
	}
	public void setteaching_student_mark_t1(String teaching_student_mark_t1) {
		this.teaching_student_mark_t1 = teaching_student_mark_t1;
	}
	private String student_participation_t1;
    public String getstudent_participation_t1() {
		return student_participation_t1;
	}
	public void setstudent_participation_t1(String student_participation_t1) {
		this.student_participation_t1 = student_participation_t1;
	}
	private String student_participation_t2;
    public String getstudent_participation_t2() {
		return student_participation_t2;
	}
	public void setstudent_participation_t2(String student_participation_t2) {
		this.student_participation_t2 = student_participation_t2;
	}
	private String student_participation_t3;
    public String getstudent_participation_t3() {
		return student_participation_t3;
	}
	public void setstudent_participation_t3(String student_participation_t3) {
		this.student_participation_t3 = student_participation_t3;
	}
	private String homepagelv_name;
    public String gethomepagelv_name() {
		return homepagelv_name;
	}
	public void sethomepagelv_name(String homepagelv_name) {
		this.homepagelv_name = homepagelv_name;
	}
	private String imageUrls;
	public String getImageUrls() {
		return imageUrls;
	}
	public void setImageUrls(String imageUrls) {
		this.imageUrls = imageUrls;
	}
	private String pictureUrls;
	public String getpictureUrls() {
		return pictureUrls;
	}
	public void setpictureUrls(String pictureUrls) {
		this.pictureUrls = pictureUrls;
	}
	private String teaching_class_t1;
	public String getteaching_class_t1() {
		return teaching_class_t1;
	}
	public void setteaching_class_t1(String teaching_class_t1) {
		this.teaching_class_t1 = teaching_class_t1;
	}
	private String teaching_class_t2;
	public String getteaching_class_t2() {
		return teaching_class_t2;
	}
	public void setteaching_class_t2(String teaching_class_t2) {
		this.teaching_class_t2 = teaching_class_t2;
	}
	private String teaching_class_t3;
	public String getteaching_class_t3() {
		return teaching_class_t3;
	}
	public void setteaching_class_t3(String teaching_class_t3) {
		this.teaching_class_t3 = teaching_class_t3;
	}
	private String teaching_class_t4;
	public String getteaching_class_t4() {
		return teaching_class_t4;
	}
	public void setteaching_class_t4(String teaching_class_t4) {
		this.teaching_class_t4 = teaching_class_t4;
	}
	private String teaching_class_t5;
	public String getteaching_class_t5() {
		return teaching_class_t5;
	}
	public void setteaching_class_t5(String teaching_class_t5) {
		this.teaching_class_t5 = teaching_class_t5;
	}
	private String teaching_class_t6;
	public String getteaching_class_t6() {
		return teaching_class_t6;
	}
	public void setteaching_class_t6(String teaching_class_t6) {
		this.teaching_class_t6 = teaching_class_t6;
	}
private static String zhuangtai;
	
	public static String getzhuangtai() {
		return zhuangtai;
	}
	public void setzhuangtai(String zhuangtai) {
		ApkEntity.zhuangtai = zhuangtai;
	}
private static int timucount;
	
	public static int gettimucount() {
		return timucount;
	}
	public void settimucount(int timucount) {
		ApkEntity.timucount = timucount;
	}

}
