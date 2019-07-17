package cn.aura.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.aura.domain.User;
import cn.aura.utils.JdbcUtils;

public class UserDao {

	/*
	 * 根据用户提供的账号与密码进行查询
	 */
	public User login(String username, String password){
		//第一步：创建数据库操作对象
		QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
		//第二步：查询
		try {
			User user = queryRunner.query("select * from user where username = ? and password = ?", new BeanHandler<User>(User.class),
					username,password);
			//如果当前没有出错，将查询到的数据返回出去
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			//如果在查询过程中，出现了意外，返回空对象。
			return null;
		}
	}
}
