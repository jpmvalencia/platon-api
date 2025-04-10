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

    public SuccessResponse<Inscription> getInscriptions() {
        List<Inscription> inscriptions = inscriptionDAO.getInscriptions();

        return new SuccessResponse(
                "inscriptions retrieved successfully",
                200,
                inscriptions
        );
    }

    public SuccessResponse<Inscription> getInscriptionsByCareer(String career) {
        List<Inscription> inscriptions = inscriptionDAO.getInscriptionsByCareer(career);

        return new SuccessResponse<>(
                "inscriptions retrieved successfully",
                200,
                inscriptions
        );
    }

    public SuccessResponse<Inscription> addInscription(InscriptionDTO inscriptionDTO) throws Exception {
        if (!inscriptionDTO.getStatus().equals("Active") && !inscriptionDTO.getStatus().equals("Cancelled")) {
            throw new Exception("inscription status is not Active or Cancelled");
        }

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
