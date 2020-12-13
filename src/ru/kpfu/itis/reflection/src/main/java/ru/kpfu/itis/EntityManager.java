package ru.kpfu.itis;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

public class EntityManager {
    private DataSource dataSource;
    private SimpleJdbcInsert simpleJdbcInsert;
    private JdbcTemplate jdbcTemplate;


    public EntityManager(DataSource dataSource) {
        this.dataSource = dataSource;
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // createTable("account", User.class);
    public <T> void createTable(String tableName, Class<T> entityClass) {
        // сгенерировать CREATE TABLE на основе класса
        // create table account ( id integer, firstName varchar(255), ...))
        HashMap<String, String> headers = getHeaders(entityClass);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE ")
                .append(tableName)
                .append("(")
                .append(fillData(headers))
                .append(");");
        jdbcTemplate.execute(stringBuilder.toString());
    }

    public <T> HashMap<String, String> getHeaders(Class<T> entityClass) {
        HashMap<String, String> headers = new HashMap<>();
        Class<?> aClass = entityClass;
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            String type = field.getType().getSimpleName();
            headers.put(name, type);
        }
        return headers;
    }

    public StringBuilder fillData(Map<String, String> data) {
        StringBuilder sqlData = new StringBuilder();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            sqlData.append(entry.getKey()).append(" ");
            String value = entry.getValue();
//            String key = entry.getKey();
            if (value.equals("boolean") || value.equals("Boolean")) {
                sqlData.append("BOOLEAN,");
            } else if (value.equals("short")) {
                sqlData.append("SMALLINT,");
            } else if (value.equals("int") || value.equals("Integer")) {
                sqlData.append("INTEGER,");
            } else if (value.equals("long") || value.equals("Long")) {
                sqlData.append("BIGINT,");
            } else if (value.equals("double") || value.equals("Double")) {
                sqlData.append("DOUBLE PRECISION,");
            } else if (value.equals("float")) {
                sqlData.append("REAL,");
            } else if (value.equals("char") || value.equals("Character")) {
                sqlData.append("VARCHAR(255),");
            } else if (value.equals("String")) {
                sqlData.append("VARCHAR(255),");
            }
        }
        sqlData.deleteCharAt(sqlData.length() - 1);
        return sqlData;
    }

    public void save(String tableName, Object entity) throws IllegalAccessException {
        Class<?> classOfEntity = entity.getClass();
        // сканируем его поля
        // сканируем значения этих полей
        // генерируем insert into
        HashMap<String, Object> map = getEntity(entity);
        Collection<Object> data = map.values();
        StringBuilder sqlSData = new StringBuilder();
        sqlSData.append("INSERT INTO ")
                .append(tableName + " (")
                .append(getColumns(map.keySet()) + ")")
                .append("VALUES (" + getValues(data))
                .append(")");
        jdbcTemplate.execute(sqlSData.toString());
    }

    public String getValues(Collection<Object> data) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object str : data) {
            stringBuilder.append(str).append(",");
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }

    public String getColumns(Set<String> columns) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : columns) {
            stringBuilder.append(str).append(",");
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }

    public HashMap<String, Object> getEntity(Object entity) throws IllegalAccessException {
        HashMap<String, Object> map = new HashMap<>();
        Class<?> entityClass = entity.getClass();
        Field[] fields = entityClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = field.get(entity);
            if (value instanceof String) {
                value = "'" + value + "'";
            }
            map.put(name, value);
        }
        return map;
    }

    // User user = entityManager.findById("account", User.class, Long.class, 10L);
    public <T, ID> T findById(String tableName, Class<T> resultType, Class<ID> idType, ID idValue) {
        // сгенеририровать select
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM ")
                .append(tableName)
                .append(" WHERE id=")
                .append(idValue);
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ResultSet metaDataSet = null;

        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql.toString());
            resultSet = statement.executeQuery();
            DatabaseMetaData metaData = connection.getMetaData();
            metaDataSet = metaData.getColumns(null, null, tableName, "%");
            Map<String, String> map = getHeaders(resultType);
            T object = resultType.newInstance();

            while (metaDataSet.next()) {
                String column = metaDataSet.getString("COLUMN_NAME");
                String type = metaDataSet.getString("TYPE_NAME");
                if (map.containsKey(column)) {
                    Field field = resultType.getDeclaredField(column);
                    if (type.toLowerCase().equals("smallint") || type.toLowerCase().equals("bigint")
                            || type.toLowerCase().equals("numeric")) {
                        field.setInt(object, resultSet.getInt(column));
                    } else if (type.toLowerCase().equals("text") || type.toLowerCase().equals("char")
                            || type.toLowerCase().equals("varchar")) {
                        field.set(object, resultSet.getString(column));
                    } else if (type.toLowerCase().equals("boolean")) {
                        field.setBoolean(object, resultSet.getBoolean(column));
                    }
                }
            }
            return object;
        } catch (SQLException | NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            throw new IllegalStateException(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ignore) {
                }
            }
            if (statement != null) {
                try {
                    connection.close();
                } catch (SQLException ignore) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignore) {
                }
            }

        }

    }


}
