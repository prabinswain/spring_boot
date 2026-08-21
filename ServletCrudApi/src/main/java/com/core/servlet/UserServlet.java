package com.core.servlet;

import com.core.model.User;
import com.core.service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");
        String name = request.getParameter("name");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");

        // Validate required fields
        if (idParam == null || name == null || mobile == null || email == null) {
            sendJson(response,
                    HttpServletResponse.SC_BAD_REQUEST,
                    "{\"message\":\"Required field is missing\"}");
            return;
        }

        Integer id;

        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            sendJson(response,
                    HttpServletResponse.SC_BAD_REQUEST,
                    "{\"message\":\"id must be a valid number\"}");
            return;
        }

        User user = new User(id, name, mobile, email);

        userService.createUser(user);

        sendJson(response,
                HttpServletResponse.SC_CREATED,
                "{\"message\":\"One User record created\"}");
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");

        // GET /users
        // Fetch all users
        if (idParam == null) {

            List<User> userList = userService.fetchAllUsers();

            sendJson(response,
                    HttpServletResponse.SC_OK,
                    usersToJson(userList));

            return;
        }

        // GET /users?id=101
        Integer id;

        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            sendJson(response,
                    HttpServletResponse.SC_BAD_REQUEST,
                    "{\"message\":\"id must be a valid number\"}");
            return;
        }

        User user = userService.fetchUserById(id);

        if (user == null) {
            sendJson(response,
                    HttpServletResponse.SC_NOT_FOUND,
                    "{\"message\":\"User not found\"}");
            return;
        }

        sendJson(response,
                HttpServletResponse.SC_OK,
                userToJson(user));
    }

    @Override
    protected void doDelete(HttpServletRequest request,
                            HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");

        if (idParam == null) {
            sendJson(response,
                    HttpServletResponse.SC_BAD_REQUEST,
                    "{\"message\":\"id is required\"}");
            return;
        }

        Integer id;

        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            sendJson(response,
                    HttpServletResponse.SC_BAD_REQUEST,
                    "{\"message\":\"id must be a valid number\"}");
            return;
        }

        boolean deleted = userService.deleteUser(id);

        if (!deleted) {
            sendJson(response,
                    HttpServletResponse.SC_NOT_FOUND,
                    "{\"message\":\"User not found\"}");
            return;
        }

        sendJson(response,
                HttpServletResponse.SC_OK,
                "{\"message\":\"User deleted successfully\"}");
    }

    @Override
    protected void doPut(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");
        String name = request.getParameter("name");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");

        if (idParam == null || name == null || mobile == null || email == null) {
            sendJson(response,
                    HttpServletResponse.SC_BAD_REQUEST,
                    "{\"message\":\"Required field is missing\"}");
            return;
        }

        Integer id;

        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            sendJson(response,
                    HttpServletResponse.SC_BAD_REQUEST,
                    "{\"message\":\"id must be a valid number\"}");
            return;
        }

        // Check whether user exists
        User existingUser = userService.fetchUserById(id);

        if (existingUser == null) {
            sendJson(response,
                    HttpServletResponse.SC_NOT_FOUND,
                    "{\"message\":\"User not found\"}");
            return;
        }

        User updatedUser = new User(id, name, mobile, email);

        userService.updateUser(updatedUser);

        sendJson(response,
                HttpServletResponse.SC_OK,
                "{\"message\":\"User updated successfully\"}");
    }

    private String usersToJson(List<User> userList) {

        StringBuilder json = new StringBuilder();

        json.append("[");

        for (int i = 0; i < userList.size(); i++) {

            json.append(userToJson(userList.get(i)));

            if (i < userList.size() - 1) {
                json.append(",");
            }
        }

        json.append("]");

        return json.toString();
    }

    private String userToJson(User user) {

        return "{\n" +
                "    \"id\" : " + user.getId() + ",\n" +
                "    \"name\" : \"" + user.getName() + "\",\n" +
                "    \"email\" : \"" + user.getEmail() + "\",\n" +
                "    \"mobile\" : \"" + user.getMobile() + "\"\n" +
                "}";
    }

    private void sendJson(HttpServletResponse response,
                          int status,
                          String json) throws IOException {

        response.setStatus(status);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}