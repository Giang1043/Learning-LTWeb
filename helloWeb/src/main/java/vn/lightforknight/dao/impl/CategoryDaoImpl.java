package vn.lightforknight.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.lightforknight.dao.ICategoryDao;
import vn.lightforknight.models.CategoryModel;
import vn.lightforknight.configs.DBConnectionMySQL;
//import vn.lightforknight.configs.DBconnectSQL; // Assuming this is your DB connection class

public class CategoryDaoImpl implements ICategoryDao {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public List<CategoryModel> findAll() {
        String sql = "SELECT * FROM categories";
        List<CategoryModel> list = new ArrayList<>();

        try {
            conn = new DBConnectionMySQL().getDataConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new CategoryModel(
                    rs.getInt("categoryid"),
                    rs.getString("categoryname"),
                    rs.getString("images"),
                    rs.getInt("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    @Override
    public CategoryModel findById(int id) {
        String sql = "SELECT * FROM categories WHERE categoryid = ?";
        CategoryModel category = null;

        try {
            conn = new DBConnectionMySQL().getDataConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                category = new CategoryModel(
                    rs.getInt("categoryid"),
                    rs.getString("categoryname"),
                    rs.getString("images"),
                    rs.getInt("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return category;
    }

    @Override
    public void insert(CategoryModel category) {
        String sql = "INSERT INTO categories (categoryname, images, status) VALUES (?, ?, ?)";

        try {
            conn = new DBConnectionMySQL().getDataConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, category.getCategoryname());
            ps.setString(2, category.getImages());
            ps.setInt(3, category.getStatus());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(CategoryModel category) {
        String sql = "UPDATE categories SET categoryname = ?, images = ?, status = ? WHERE categoryid = ?";

        try {
            conn = new DBConnectionMySQL().getDataConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, category.getCategoryname());
            ps.setString(2, category.getImages());
            ps.setInt(3, category.getStatus());
            ps.setInt(4, category.getCategoryid());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM categories WHERE categoryid = ?";

        try {
            conn = new DBConnectionMySQL().getDataConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<CategoryModel> findName(String keyword) {
        String sql = "SELECT * FROM categories WHERE categoryname LIKE ?";
        List<CategoryModel> list = new ArrayList<>();

        try {
            conn = new DBConnectionMySQL().getDataConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new CategoryModel(
                    rs.getInt("categoryid"),
                    rs.getString("categoryname"),
                    rs.getString("images"),
                    rs.getInt("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}



/*package vn.lightforknight.dao.impl;

import java.sql.Connection;
import java.util.ArrayList;

import vn.lightforknight.dao.ICategoryDao;

public class CategoryDapImpl implements ICategoryDao{
	public Connection conn = null;
	public PrepareStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public List<CategoryModel> findAll() {
		String sql = "Select * from categories";
		List<CategoryModel> list = new ArrayList<>();
		try
		{
			conn = new BDConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
		}
		
		//--find by id
		/*insert*/
		//--udpate
		//delete
	