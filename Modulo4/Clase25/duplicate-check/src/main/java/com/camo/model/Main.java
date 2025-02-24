package com.camo.model;

import com.camo.collection.Lists;
import com.camo.exception.DuplicateMailException;

public class Main {
    public static void main(String[] args) {
        var mails = new Lists();

        // Agrega los correos electrónicos
            mails.addMails("posi121@gmail.com");
            mails.addMails("jas32hj12dhu@gmail.com");
            mails.addMails("ksdaj46a2swj@gmail.com");
            mails.addMails("p222d3h4@gmail.com");
            mails.addMails("34ui3u4@gmail.com");
            mails.addMails("posi121@gmail.com");
            mails.addMails("34ui3u4@gmail.com");

        // Identifica y reporta los correos electrónicos generados
        try {
            mails.verifyMail();
        } catch (DuplicateMailException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Saliendo del programa.");
    }
}