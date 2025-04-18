package com.user.platonapi.inscription;

import com.google.gson.Gson;
import com.user.platonapi.common.config.GsonProvider;
import com.user.platonapi.common.config.ServiceConfig;
import com.user.platonapi.common.response.ErrorResponse;
import com.user.platonapi.common.response.SuccessResponse;
import com.user.platonapi.inscription.dto.InscriptionDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "InscriptionServlet", urlPatterns = "/inscriptions/*")
public class InscriptionServlet extends HttpServlet {
    private InscriptionService inscriptionService;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        inscriptionService = ServiceConfig.getInscriptionService();
        gson = GsonProvider.createGson();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            try {
                SuccessResponse successResponse = inscriptionService.getInscriptions();

                String jsonSuccessResponse = gson.toJson(successResponse);
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(jsonSuccessResponse);
            } catch (Exception e) {
                ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), 500);
                String jsonErrorResponse = gson.toJson(errorResponse);

                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                resp.setContentType("application/json");
                resp.getWriter().write(jsonErrorResponse);
            }
        } else if (pathInfo.matches("/career")) {
            String career = req.getParameter("name");

            try {
                SuccessResponse successResponse = inscriptionService.getInscriptionsByCareer(career);

                String jsonSuccessResponse = gson.toJson(successResponse);
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(jsonSuccessResponse);
            } catch (Exception e) {
                ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), 500);
                String jsonErrorResponse = gson.toJson(errorResponse);

                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                resp.setContentType("application/json");
                resp.getWriter().write(jsonErrorResponse);
            }
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InscriptionDTO inscriptionDTO = gson.fromJson(req.getReader(), InscriptionDTO.class);

        try {
            SuccessResponse successResponse = inscriptionService.addInscription(inscriptionDTO);
            String jsonSuccessResponse = gson.toJson(successResponse);

            resp.setStatus(HttpServletResponse.SC_CREATED);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(jsonSuccessResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), 500);
            String jsonErrorResponse = gson.toJson(errorResponse);

            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(jsonErrorResponse);
        }
    }
}
