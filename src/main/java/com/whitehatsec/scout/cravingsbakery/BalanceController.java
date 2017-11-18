package com.whitehatsec.scout.cravingsbakery;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.sql.*;
import java.util.logging.*;

@Controller
public class BalanceController {

    private final static Logger LOGGER = Logger.getLogger(BalanceController.class.getName());

    private Connection con;

    public BalanceController() {
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/initech", "initech", "pass123");
        } catch (Exception e) {
            throw new RuntimeException("failed to connect to database", e);
        }
    }

    @RequestMapping(value = "/")
    String check(Model model) {
     return "index";
    }
    
    @RequestMapping(value = "/balance")
    String check(Model model, @RequestParam(value = "account", required = false) String account) {
        if (account != null && !"".equals(account)) {
            String results = checkBalance(account);
            model.addAttribute("results", results);
        }

        return "index";
    }

    private String checkBalance(String account) {
        StringBuilder body = new StringBuilder();
        Statement statement = null;

        try {
            statement = con.createStatement();
            
            String selectStatement = "SELECT * FROM account where accountnum = '" + account + "';";
            ResultSet rs = statement.executeQuery(selectStatement);

//            String selectStatement = "SELECT * FROM account WHERE accountnum = ? ";                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
//            PreparedStatement prepStmt = con.prepareStatement(selectStatement);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
//            prepStmt.setString(1, account);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
//            ResultSet rs = prepStmt.executeQuery();
            
            LOGGER.info("Query executed: " + selectStatement);
            if (!rs.isBeforeFirst()) {
				body.append("No such account");
			} //end if
			else {
				// Extract data from result set
				while (rs.next()) {
	                String accountNumber = rs.getString("accountnum");
	                String accountName = rs.getString("accountname");
	                int balance = rs.getInt("balance");
	                body.append("<b> Account Number: </b>" + accountNumber + " <b> Name: </b>" + accountName + "   <b> Balance Rewards: </b>" + balance + "<br>\n");
				}
			}
		} catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getClass().getName(), e);
            body.append("Exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (Exception e) {
                // give up
            }
        }

        return body.toString();
    }
}