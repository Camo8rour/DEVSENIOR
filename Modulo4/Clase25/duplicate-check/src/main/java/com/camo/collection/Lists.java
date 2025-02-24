package com.camo.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.camo.exception.DuplicateMailException;

public class Lists {

    private Set<String> mails;
    private List<String> duplicateMails;

    public Lists(){
        mails = new HashSet<>();
        duplicateMails = new ArrayList<>();
    }

    public void addMails(String mail){
        if (!mails.add(mail)) {
            duplicateMails.add(mail);
        } else {
            System.out.printf("El correo electrónico %s fue agregado con éxito.%n", mail);
        }
    }

    public void verifyMail() throws DuplicateMailException {
        if (!duplicateMails.isEmpty()) {
            StringBuilder duplicate = new StringBuilder("\nSe encontraron los siguientes correos duplicados:\n");
            for (String mail : duplicateMails) {
                duplicate.append(mail).append("\n");
            }
            throw new DuplicateMailException(duplicate.toString());
        } else {
            System.out.println("No se encontraron correos duplicados.");
        }
    }
}
