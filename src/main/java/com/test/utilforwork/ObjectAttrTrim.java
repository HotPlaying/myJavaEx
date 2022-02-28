package com.test.utilforwork;

import com.test.experiment.ex.ex1.Student;

import java.lang.reflect.Field;

/**
 * @author tangrd
 * @date 2020/6/1 17:16
 * @destination
 */
public class ObjectAttrTrim {
    public static void main(String[] args) {
        Object object = new Student("   沃特   华生 ","  12  3 4  5 6",16);
        object = replaceBlankSpace(object);
        Student student = (Student)object;
        System.out.println(student);
    }
    /**
     * @Description : 为object中的所有String属性去除空格字符
     *
     * @param object 待处理的实体对象
     * @return : java.lang.Object
     */
    public static Object replaceBlankSpace(Object object){
        //获取该类中所有的域(属性)
        Field[] fields = object.getClass().getDeclaredFields();

        for(Field field : fields){
            //对所有的属性判断是否为String类型
            if(field.getType().equals(String.class)){
                //将私有属性设置为可访问状态
                field.setAccessible(true);
                try {
                    String string = (String)field.get(object);
                    //将所有的空格字符用""替换
                    string = string.replaceAll(" ","");
                    //相当于调用了set方法设置属性
                    field.set(object,string);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return object;
    }
}
