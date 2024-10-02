package vn.lightforknight.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.lightforknight.dao.IUserDAO;
import vn.lightforknight.models.UserModel;
//import vn.lightforknight.utils.DBconnectSQL; // Assuming this is your DB connection class
import vn.lightforknight.configs.DBConnectionMySQL; // Correct import

public class UserDaoImpl implements IUserDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public List<UserModel> findAll() {
        String sql = "SELECT * FROM users";
        List<UserModel> list = new ArrayList<>();
        
        try {
            // Establishing the connection
            conn = new DBConnectionMySQL().getDataConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            // Processing the result set
            while (rs.next()) {
                list.add(new UserModel(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("images"),
                        rs.getString("fullname"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("roleid"),
                        rs.getDate("createDate")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Closing resources
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
    public UserModel findById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        UserModel user = null;

        try {
            conn = new DBConnectionMySQL().getDataConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                user = new UserModel(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("images"),
                    rs.getString("fullname"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("roleid"),
                    rs.getDate("createDate")
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

        return user;
    }

    @Override
    public void insert(UserModel user) {
        String sql = "INSERT INTO users (username, password, images, fullname, email, phone, roleid, createDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = new DBConnectionMySQL().getDataConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getImages());
            ps.setString(4, user.getFullname());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPhone());
            ps.setString(7, user.getRoleid());
            ps.setDate(8, new java.sql.Date(user.getCreateDate().getTime()));

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

    public static void main(String[] args) {
        UserDaoImpl userDAO = new UserDaoImpl();
        List<UserModel> list = userDAO.findAll();
        for (UserModel user : list) {
            System.out.println(user);
        }
    }
}



/*
package vn.lightforknight.dao.impl;

import java.util.List;

import vn.lightforknight.dao.IUserDAO;
import vn.lightforknight.models.UserModel;

public class UserDaoImpl implements IUserDAO {
	

	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM users";
		try {
			conn = new DBconnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				List<UserModel> list = new ArrayList<UserModel> ();
				list.add(new UserModel(
						rs,getInt("id"),
						rs.getString("password"),
						rs.getString("images"),
						rs.getString("fullname"),
						rs.getString("email"),
						rs.getString("phone"),
						rs.
						)
						)
			}
		}
		
		
		return null;
	}
	
	@Override
	public UserModel findById(int id) {
		
		return null;
	}
	
	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO";
	}
	
	public static void main(String[] args) {
		UserDaoImpl userDAO = new UserDaoImpl();
		List<UserModel> list = userDAO.findAll();
		for (UserModel user : list) {
			System.out.print(user);
		} 
	}
}
*/