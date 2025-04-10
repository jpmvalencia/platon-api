package com.user.platonapi.inscription;

import com.user.platonapi.inscription.dao.InscriptionDAO;

public class InscriptionService {
    private final InscriptionDAO inscriptionDAO;

    public InscriptionService(InscriptionDAO inscriptionDAO) {
        this.inscriptionDAO = inscriptionDAO;
    }
}
