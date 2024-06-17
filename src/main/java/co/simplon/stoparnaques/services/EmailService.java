package co.simplon.stoparnaques.services;

import co.simplon.stoparnaques.dtos.SendMailDto;

public interface EmailService {

    void sendSimpleMail(SendMailDto inputs);

}
