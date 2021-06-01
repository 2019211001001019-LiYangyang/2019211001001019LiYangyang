package com.LiYangyang.dao;

import com.LiYangyang.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,Price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {
        String sql="delete from Product where ProductId=?";
        PreparedStatement pt= con.prepareStatement(sql);
        pt.setInt(1,productId);
        return pt.executeUpdate();
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException{
        String sql="update Product set ProductName=?,ProductDescription=?,Picture=?,Price=?,CategoryId=? where ProductId=?";
        PreparedStatement pt= con.prepareStatement(sql);
        pt.setString(1,instance.getProductName());
        pt.setString(2,instance.getProductDescription());
        if(instance.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, instance.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, instance.getPrice());
        pt.setInt(5, instance.getCategoryId());
        pt.setInt(6,instance.getProductId());
        return pt.executeUpdate();
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        String queryString = "select * from Product where ProductId=?";
        PreparedStatement pt=con.prepareStatement(queryString);
        pt.setInt(1,productId);
        ResultSet rs = pt.executeQuery();
        Product product= new Product();
        while (rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            //product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryId"));
        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con)  throws SQLException{
        String sql="select * from Product where CategoryId=?";
        PreparedStatement pt= con.prepareStatement(sql);
        pt.setInt(1,categoryId);
        ResultSet rs= pt.executeQuery();
        Product product=null;
        List<Product> pro=new ArrayList<Product>();
        if(rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            pro.add(product);
        }
        return pro;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        String sql="select * from Product where Price between ? and ?";
        PreparedStatement pt= con.prepareStatement(sql);
        pt.setDouble(1,minPrice);
        pt.setDouble(2,maxPrice);
        ResultSet rs= pt.executeQuery();
        Product product=null;
        List<Product> pro=new ArrayList<Product>();
        if(rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("Picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            pro.add(product);
        }
        return pro;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        List<Product> list = new ArrayList<Product>();
        String queryString = "select * from Product";
        PreparedStatement pt = con.prepareStatement(queryString);
        ResultSet rs = pt.executeQuery();
        while (rs.next()){
            Product product = new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            list.add(product);
        }
        System.out.println("successful");
        return list;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        String sql="select * from Product where ProductName=?";
        PreparedStatement pt= con.prepareStatement(sql);
        pt.setString(1,productName);
        ResultSet rs= pt.executeQuery();
        Product product=null;
        List<Product> pro=new ArrayList<Product>();
        if(rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            pro.add(product);
        }
        return pro;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        String sql="select * from Product where ProductId=?";
        PreparedStatement pstmt= con.prepareStatement(sql);
        pstmt.setInt(1,productId);
        ResultSet rs= pstmt.executeQuery();
        Product product=null;
        List<Product> pro=new ArrayList<Product>();
        if(rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            pro.add(product);
        }
        return pro;
    }
    public byte[] getPictureById(Integer productId,Connection con)throws SQLException{
        byte[] imgByte=null;
        String sql="select picture from product where productId=?";
        PreparedStatement pt=con.prepareStatement(sql);
        pt.setInt(1,productId);
        ResultSet rs=pt.executeQuery();
        while (rs.next()){
            Blob blob=rs.getBlob("picture");
            imgByte=blob.getBytes(1,(int)blob.length());
        }
        return imgByte;
    }
}