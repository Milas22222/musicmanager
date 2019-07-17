package cn.aura.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.aura.domain.Music;
import cn.aura.utils.JdbcUtils;

public class MusicDao {
	
	/*
	 * 查询所有
	 */
	public List<Music> selectAll(){
		//创建数据库操作对象
		QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
		try {
			//没问题，返回集合
			return queryRunner.query("select * from music", new BeanListHandler<Music>(Music.class));
		} catch (SQLException e) {
			e.printStackTrace();
			//有问题，返回空
			return null;
		}
	}

	/*
	 * 添加
	 */
	public void add(Music music){
		QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
		try {
			queryRunner.update("insert into music values(null,?,?,?)",
					music.getMname(),music.getMurl(),music.getAuthor());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 删除
	 */
	public void del(int id) {
		QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
		try {
			//删除数据库对象
			queryRunner.update("delete from music where id = ?",id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 根据id查询音乐文件
	 */
	public Music selectOne(int id) {
		QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
		//寻找到对象
		try {
			return queryRunner.query("select * from music where id = ?", new BeanHandler<Music>(Music.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	//根据音乐名称搜索
	public List<Music> selectByName(String value) {
		QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
		try {
			return queryRunner.query("select * from music where mname = ?", new BeanListHandler<Music>(Music.class),value);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
