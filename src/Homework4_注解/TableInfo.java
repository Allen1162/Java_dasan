package Homework4_注解;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class TableInfo {

    private String tableName;
    private Class<?> clazz;
    private boolean needPersist = false;
    private Map<String, ColumnInfo> colums = new HashMap<>();

    public TableInfo parse(Class<?> clazz){
        this.clazz = clazz;
        this.tableName = this.clazz.getSimpleName();
        Annotation[] annotations = this.clazz.getAnnotations();
        for(Annotation annotation : annotations){
            if(annotation.annotationType().equals(Entity.class)){
                this.needPersist = true;
                Entity entity = (Entity)annotation;
                if(!entity.value().equals("")){
                    this.tableName = entity.value();
                }
                break;
            }
        }
        if(needPersist){
            Field[] fields = this.clazz.getDeclaredFields();
            for(Field field : fields){
                ColumnInfo columnInfo = new ColumnInfo();
                columnInfo = columnInfo.parse(field);
                if(columnInfo != null){
                    this.colums.put(field.getName(), columnInfo);
                }
            }
            return this;
        }else{
            return null;
        }
    }

    @Override
    public String toString(){
        StringBuilder sql = new StringBuilder();
        sql.append(Symbol.LINE);
        sql.append("CREATE TABLE ");
        sql.append(this.tableName + Symbol.BLANK);
        sql.append("(");
        for(ColumnInfo columnInfo : this.colums.values()){
            sql.append(Symbol.LINE);
            sql.append(Symbol.TAB);
            sql.append(columnInfo.toString());
        }
        sql.append(Symbol.LINE);
        sql.append(");");
        return sql.toString();
    }

    public String add(){
        StringBuilder addSql = new StringBuilder();
        addSql.append("insert into");
        addSql.append(Symbol.BLANK + tableName);
        addSql.append(Symbol.BLANK + "(");
        for(String string : this.colums.keySet()){
            addSql.append(string + ",");
        }
        addSql.deleteCharAt(addSql.length()-1);
        addSql.append(")");
        addSql.append(Symbol.BLANK + "values('阿伦', 408)");
        return addSql.toString();
    }

    public String update(){
        StringBuilder updateSql = new StringBuilder();
        updateSql.append("update");
        updateSql.append(Symbol.BLANK + tableName);
        updateSql.append(Symbol.BLANK + "set ");
        for(String string : this.colums.keySet()){
            if(string.equals("name"))
            updateSql.append(string + "='黄俊霖', ");
            else if(string.equals("id")){
                updateSql.append(string + "=408, ");
            }
        }
        updateSql.deleteCharAt(updateSql.length()-1);
        updateSql.append("where id = '408'");
        return updateSql.toString();
    }

    public String delete(){
        StringBuilder deleteSql = new StringBuilder();
        deleteSql.append("delete");
        deleteSql.append(Symbol.BLANK + "from");
        deleteSql.append(Symbol.BLANK + tableName);
        deleteSql.append(Symbol.BLANK + "where id = '408'");
        return deleteSql.toString();
    }
}
