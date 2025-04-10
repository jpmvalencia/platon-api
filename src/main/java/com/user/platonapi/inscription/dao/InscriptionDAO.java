package com.user.platonapi.inscription.dao;

import com.user.platonapi.inscription.model.Inscription;

import java.util.ArrayList;
import java.util.List;

public class InscriptionDAO {
    private List<Inscription> inscriptions = new ArrayList<>();
    private static int idCounter = 1;

    public List<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void addInscription(Inscription inscription) {
        inscription.setId(idCounter++);
        inscriptions.add(inscription);
    }

    public boolean existsStudentInSubject(String student, String subject) {
        for (Inscription inscription : inscriptions) {
            if (inscription.getStudent().equals(student) && inscription.getSubject().equals(subject)) {
                return true;
            }
        }
        return false;
    }

    public List<Inscription> getInscriptionsByStudent(String student) {
        List<Inscription> studentInscriptions = new ArrayList<>();
        for (Inscription inscription : this.inscriptions) {
            if (inscription.getStudent().equals(student)) {
                studentInscriptions.add(inscription);
            }
        }
        return studentInscriptions;
    }
}
