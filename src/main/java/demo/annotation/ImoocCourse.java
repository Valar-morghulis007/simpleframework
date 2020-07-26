package demo.annotation;


@CourseInfoAnnotation(courseName = "剑指java面试", courseTag = "面试",
        courseProfile = "不仅涉及Java相关的核心知识，还涉及网络、数据库、缓存框架等核心知识")
public class ImoocCourse {

    @PersonInfoAnnotation(name = "翔仔", language = {"Java", "C++", "Go", "Python"})
    private String author;

    @CourseInfoAnnotation(courseName = "校园商铺",
            courseTag = "实战", courseProfile = "手把手教会从前端到后端开发商铺管理系统",
            courseIndex = 144)
    public void getCourseInfo() {

    }
}
