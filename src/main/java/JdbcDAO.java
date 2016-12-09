import java.util.Map;
import spark.Spark.*;

/**
 * Created by Aqib on 12/8/2016.
 */


import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;

import java.util.Map;

import java.util.stream.Collectors;

import org.apache.commons.dbutils.QueryRunner;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class JdbcDAO implements DAO {

    private static MysqlDataSource dataSource;

    static {

        try {

            dataSource = new MysqlDataSource();

            dataSource.setUser("root");

            dataSource.setPassword("root");

            dataSource.setServerName("localhost");

            dataSource.setDatabaseName("blog");

        } catch (Exception e) {

            throw new ExceptionInInitializerError(e);

        }

    }

    public boolean addPerson(Map<String, Object> data) {

        QueryRunner run = new QueryRunner( dataSource );

        try	{

            int inserts = run.update( "INSERT INTO Person (first_name, last_name) VALUES (?,?)", data.get("first_name"), data.get("last_name"));

        } catch(SQLException sqle) {

            throw new RuntimeException("Problem updating", sqle);

        }

        return true;

    }

}
