package com.whitehatsec.sourcex.tasteofindia;

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

    private Connection connection;

    public BalanceController() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/initech", "initech", "pass123");
        } catch (Exception e) {
            throw new RuntimeException("failed to connect to database", e);
        }
    }

    @RequestMapping(value = "/balance")
    String check(Model model, @RequestParam(value = "account", required = false) String account) {
        if (account != null && !"".equals(account)) {
            String results = checkBalance(account);
            model.addAttribute("results", results);
        }

        return "balance";
    }

    private String checkBalance(String account) {
        StringBuilder body = new StringBuilder();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM account where accountnum = '" + account + "';";
            LOGGER.info("issuing query: " + query);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String accountNumber = resultSet.getString("accountnum");
                String accountName = resultSet.getString("accountname");
                int balance = resultSet.getInt("balance");
                body.append("<b> Account Number: </b>" + accountNumber + " <b> Name: </b>" + accountName + "   <b> Balance Rewards: </b>" + balance + "<br>\n");
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getClass().getName(), e);
            body.append("Exception: " + e.getMessage());
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