package com.LiYangyang.controller;

import com.LiYangyang.dao.ProductDao;
import com.LiYangyang.model.Category;
import com.LiYangyang.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductDetailsServlet", value = "/productDetails")
public class ProductDetailsServlet extends HttpServlet {
    private Connection con=null;

    @Override
    public void init() throws ServletException {
        con=(Connection)getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id=request.getParameter("id")!=null?Integer.parseInt(request.getParameter("id")):0;
        ProductDao productDao=new ProductDao();
        if (id==0){
            return;//error
        }
        try {
            List<Category> categoryList=Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);

            Product product=productDao.findById(id,con);
            request.setAttribute("p",product);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String path="/WEB-INF/views/productDetails.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
