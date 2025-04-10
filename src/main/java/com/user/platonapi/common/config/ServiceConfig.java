package com.user.platonapi.common.config;

import com.user.platonapi.inscription.InscriptionService;
import com.user.platonapi.inscription.dao.InscriptionDAO;

public class ServiceConfig {
    private static InscriptionDAO inscriptionDAO;
    private static InscriptionService inscriptionService;

    static {
        inscriptionDAO = new InscriptionDAO();
        inscriptionService = new InscriptionService(inscriptionDAO);
    }

    public static InscriptionDAO getInscriptionDAO() {
        return inscriptionDAO;
    }

    public static InscriptionService getInscriptionService() {
        return inscriptionService;
    }
}
