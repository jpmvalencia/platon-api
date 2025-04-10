package com.user.platonapi.inscription;

import com.user.platonapi.common.response.SuccessResponse;
import com.user.platonapi.inscription.dao.InscriptionDAO;
import com.user.platonapi.inscription.dto.InscriptionDTO;
import com.user.platonapi.inscription.model.Inscription;

import java.io.IOException;
import java.util.List;

public class InscriptionService {
    private final InscriptionDAO inscriptionDAO;

    public InscriptionService(InscriptionDAO inscriptionDAO) {
        this.inscriptionDAO = inscriptionDAO;
    }

    public SuccessResponse<Inscription> addInscription(InscriptionDTO inscriptionDTO) throws Exception {
        Inscription inscription = new Inscription(
                inscriptionDTO.getStudent(),
                inscriptionDTO.getDocument(),
                inscriptionDTO.getCareer(),
                inscriptionDTO.getSubject(),
                inscriptionDTO.getSemester(),
                inscriptionDTO.getEnrollmentDate(),
                inscriptionDTO.getStatus()
        );

        if (inscriptionDAO.existsStudentInSubject(inscription.getStudent(), inscription.getSubject())) {
            throw new Exception("student already in subject");
        }
        if (inscriptionDAO.getInscriptionsByStudent(inscription.getStudent()).size() >= 7) {
            throw new Exception("student is already in 7 subjects");
        }

        inscriptionDAO.addInscription(inscription);

        return new SuccessResponse(
                "inscription created successfully",
                201,
                inscription
        );
    }
}
