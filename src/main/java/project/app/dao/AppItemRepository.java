package project.app.dao;

import project.app.model.Item;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AppItemRepository {
	

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private RowMapper<Item> rowMapper = new RowMapper<Item>() {
		
		@Override
		public Item mapRow(ResultSet rs,int rowNum) throws SQLException{
				Item item = new Item();
				item.setId(rs.getLong("id"));
				item.setItemBrand(rs.getString("itembrand"));
				item.setItemType(rs.getString("itemtype"));
				item.setItemQuantity(rs.getInt("itemquantity"));
				item.setItemDate(rs.getObject("itemdate",LocalDate.class));
				item.setItemLocation(rs.getString("itemlocation"));
				item.setItemPerson(rs.getString("itemperson"));
				return item;
			}
		};
	
	public List<Item> findAll(){
		String sql="SELECT * FROM item";
		return jdbcTemplate.query(sql, rowMapper);
	}
	public void create(Item item) {
		String sql ="insert into Item(id,itembrand,itemtype,itemquantity,itemdate,itemlocation,itemperson) values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,item.getId(),item.getItemBrand(),item.getItemType(),item.getItemQuantity(),item.getItemDate(),item.getItemLocation(),item.getItemPerson());
		
	}
	public void delete(long id) {
		String sql = "delete from item where id=?";
		jdbcTemplate.update(sql,id);
	}
	
	public Item findById(long id) {
		String sql = "select * from item where id=?";
		return DataAccessUtils.singleResult(jdbcTemplate.query(sql, rowMapper,id));
	}
	
}
