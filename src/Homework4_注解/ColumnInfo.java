package Homework4_注解;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ColumnInfo {

    private String columnName;
    private Class<?> type;
    private boolean isID =  false;
    private boolean nullable = true;
    private int length = 32;
    private boolean needPersist = false;

    public ColumnInfo parse(Field field){

        this.columnName = field.getName();
        this.type = field.getType();
        Annotation[] annotations = field.getAnnotations();
//        System.out.println(annotations.length);
//        Annotation[] annotations = field.getDeclaredAnnotations();
        for(Annotation annotation : annotations){
            if(annotation.annotationType().equals(Column.class)) {
                this.needPersist = true;
                Column column = (Column) annotation;
//                System.out.println(column.value()+"111");
                if (!(column.value().equals(""))) {
                    this.columnName = column.value();
                }
//                    System.out.println(column.nullable()
//                    this.nullable = column.nullable();); 没进来
                if (column.length() != -1) {
                    this.length = column.length();
                }
                if (column.nullable()) {
                    nullable = true;
                }else{
                    nullable = false;
                }
            }else if(annotation.annotationType().equals(ID.class)){
                    this.needPersist = true;
//                    System.out.println(444); 没进来
                    ID id = (ID) annotation;
                    this.isID = true;
                    if(!id.value().equals("")){
                        this.columnName = id.value();
                    }
            }
        }
        if(this.needPersist){
            return this;
        }else{
            return null;
        }
    }

    @Override
    public String toString(){
        StringBuilder sql = new StringBuilder(columnName);
        if(this.type.equals(String.class)){
            sql.append(Symbol.BLANK + "VARCHAR(" + this.length + ")");
        }else if(this.type.equals(Integer.class)){
            sql.append(Symbol.BLANK + "INT");
        }
//        System.out.println(this.isID);
//        System.out.println(this.nullable);
        if(this.isID){
            sql.append(Symbol.BLANK + "PRIMARY KEY");
//            System.out.println(111);
        }
        if(!this.nullable){
            sql.append(Symbol.BLANK + "NOT NULL");
//            System.out.println(222);
        }
        sql.append(";");
        return sql.toString();
    }
}
