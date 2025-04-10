package com.user.platonapi.inscription;

import com.google.gson.Gson;
import com.user.platonapi.common.config.GsonProvider;
import com.user.platonapi.common.config.ServiceConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "InscriptionServlet", urlPatterns = "/inscription")
public class InscriptionServlet extends HttpServlet {
    private InscriptionService inscriptionService;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        inscriptionService = ServiceConfig.getInscriptionService();
        gson = GsonProvider.createGson();
    }
}
