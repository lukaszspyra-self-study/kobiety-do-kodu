package pl.kobietydokodu.learningjavapart1.cats;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CatDao {

	@Autowired
	private DataSource dataSource;

	public Cat getCatList() {
		String sql = "SELECT * FROM cats";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			Cat cat = null;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cat = new Cat();
				cat.setCatName(rs.getString(1));
				cat.setDateOfBirth(rs.getDate(2));
				cat.setWeight(rs.getFloat(3));
				cat.setOwnerName(rs.getString(4));
				cat.setCatId(rs.getInt(5));
			}
			rs.close();
			ps.close();
			return cat;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

				}
			}
		}
	}

	protected void addCatToTheList(Cat cat) {
		String sql = "INSERT INTO cats (catName, dateOfBirth, weight, ownerName, catId) VALUES(?, ?, ?, ?, ?)";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cat.getCatName());
			ps.setDate(2, new java.sql.Date(cat.getDateOfBirth().getTime()));
			ps.setFloat(3, cat.getWeight());
			ps.setString(4, cat.getOwnerName());
			ps.setInt(5, cat.getCatId());
			ResultSet rs = ps.executeQuery();
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Cat getCatById(int catId) {
		String sql = "SELECT * FROM cats WHERE catId = ?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, catId);
			Cat cat = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cat = new Cat();
				cat.setCatName(rs.getString(1));
				cat.setDateOfBirth(rs.getDate(2));
				cat.setWeight(rs.getFloat(3));
				cat.setOwnerName(rs.getString(4));
				cat.setCatId(rs.getInt(5));
			}
			rs.close();
			ps.close();
			return cat;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

				}
			}
		}
	}
}
